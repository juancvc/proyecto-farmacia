package proyect.web.controller.mantenimiento;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import proyect.core.bean.general.CatalogoBean;
import proyect.core.bean.stock.ArticuloBean;
import proyect.core.bean.stock.LaboratorioBean;
import proyect.core.bean.stock.StockBean;
import proyect.base.service.ServiceException;
import proyect.core.service.interfaces.catalogo.Catalogo1Service;
import proyect.core.service.interfaces.catalogo.Catalogo2Service;
import proyect.core.service.interfaces.stock.ArticuloService;
import proyect.core.service.interfaces.stock.LaboratorioService;
import proyect.core.service.interfaces.stock.StockService;
import proyect.web.controller.base.BaseController; 

@Controller
@RequestMapping(value = "articuloController")
public class ArticuloController extends BaseController{
	
	List<CatalogoBean> lstPresentacion;
	List<CatalogoBean> lstTipoArticulo;
	List<CatalogoBean> lstClaseArticulo;
	List<LaboratorioBean> lstLaboratorios;
	List<ArticuloBean> lstArticulos;
	private ArticuloBean articuloBean;
	
	@Autowired
	private Catalogo1Service catalogo1Service;
	
	@Autowired
	private Catalogo2Service catalogo2Service;
	
	@Autowired
	private ArticuloService articuloService;
	
	@Autowired
	private LaboratorioService laboratorioService;
	
	@Autowired
	private StockService stockService;
	
	@PostConstruct
	public void init() { 
	  this.setArticuloBean(new ArticuloBean());	
	  this.setLstPresentacion(new ArrayList<CatalogoBean>());
	  this.setLstTipoArticulo(new ArrayList<CatalogoBean>());
	  this.setLstClaseArticulo(new ArrayList<CatalogoBean>());
	  this.setLstLaboratorios(new ArrayList<LaboratorioBean>());
	}
	
	private void cargarCombos(ModelAndView mav) {
		try {
			lstPresentacion = catalogo2Service.listarPorCodigoTabla("000015", 0);
			lstTipoArticulo = catalogo2Service.listarPorCodigoTabla("000001", 0);
			lstClaseArticulo = catalogo2Service.listarPorCodigoTabla("000016", 0);
			lstLaboratorios = laboratorioService.getBuscarPorFiltros(new LaboratorioBean());
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		
		mav.addObject("lstTipoArticulo", lstTipoArticulo);
		mav.addObject("lstPresentacion", lstPresentacion);
		mav.addObject("lstClaseArticulo", lstClaseArticulo);
		mav.addObject("lstLaboratorios", lstLaboratorios);
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("articuloBean") ArticuloBean articuloBean,
			HttpServletRequest request)
			throws Exception {  
		ModelAndView mav = new ModelAndView("mantenimiento/articulo/listado-articulo", "command", articuloBean);  
		lstArticulos = articuloService.getBuscarPorFiltros(articuloBean);
		mav.addObject("lstArticulos", lstArticulos);
		this.cargarCombos(mav);
		return mav;
		
	}
	
	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("articuloBean") ArticuloBean articuloBean, HttpServletRequest request) { 
		return listado(articuloBean, request);
	}

	
	@RequestMapping(value = "/listado", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView listado(@ModelAttribute("articuloBean") ArticuloBean articuloBean, HttpServletRequest request){ 
		ModelAndView mav = new ModelAndView("mantenimiento/articulo/listado-articulo", "command", articuloBean); 
		this.cargarCombos(mav);
		try {
			lstArticulos = articuloService.getBuscarPorFiltros(new ArticuloBean());
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		mav.addObject("lstArticulos", lstArticulos);
		return mav;
	}
 
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo(HttpServletRequest request) {
		// cargarComboLeccion();
		ArticuloBean articuloBean = new ArticuloBean(); 
		ModelAndView mav = new ModelAndView("mantenimiento/articulo/registro-articulo", "command", articuloBean); 
		this.cargarCombos(mav);
		return mav;
	}
	
	@RequestMapping(value = "/modificar", method = RequestMethod.POST)
	public ModelAndView modificar(@RequestParam("index") int index){  
		
		System.out.println("modificar index " + index);  
		int totalStock = 0;
		ArticuloBean articuloBean = new ArticuloBean();  
	    articuloBean = lstArticulos.get(index); 
		List<StockBean> lstStock = null ;
		try {
			lstStock = stockService.listarPorIdArticulo(articuloBean);
			if (lstStock !=null) {
				for (StockBean stockBean : lstStock) {
					totalStock = totalStock + stockBean.getStock();
				}
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("mantenimiento/articulo/registro-articulo", "command", articuloBean); 
		
		mav.addObject("totalStock", totalStock);
		mav.addObject("lstStock", lstStock);
		this.cargarCombos(mav);
		return mav;
	}
	
	@RequestMapping(value = "/grabar", method = RequestMethod.POST) 
	public ModelAndView grabar(@ModelAttribute("articuloBean") ArticuloBean articuloBean, HttpServletRequest request) {
		 
		System.out.println("doGrabar @articuloBean");
		boolean sw = true;
		try {
			if (articuloBean.getCodigo()!=null && !articuloBean.getCodigo().equals("")) { 
				this.setAuditoria(articuloBean, request, false); 
				sw = (articuloService.actualizar(articuloBean));
			} else { 
				this.setAuditoria(articuloBean, request, true); 
				sw =  (articuloService.insertar(articuloBean)); 
				
			} 
		} catch (Exception e) { 
			e.printStackTrace();
		}
		System.out.println("sw " + sw);
		if (sw) {
			articuloBean = new ArticuloBean() ;
			 return this.listado(articuloBean, request);
			 
		}else{
			ModelAndView mav = new ModelAndView("general/Catalogos/registro-Catalogo", "command",articuloBean); 
			return mav ;
		} 
		 
	} 
	
	@RequestMapping(value = "/eliminar", method = RequestMethod.GET)
	@ResponseBody
	public String doEliminar(@RequestParam("index") int index ,
			 HttpServletRequest request) {
		String valida = "";
		ArticuloBean articuloBean = new ArticuloBean();  
	    articuloBean = lstArticulos.get(index);
	    System.out.println("articuloBean.getCodigo " + articuloBean.getCodigo());
	    try { 
	    	this.setAuditoria(articuloBean, request, true); 
			 if(articuloService.eliminar(articuloBean)){
				 valida = "1";
			 }
		} catch (Exception e) { 
			e.printStackTrace();
		} 
		return valida;
	}
	
	@RequestMapping(value = "/refrescarLista", method = RequestMethod.GET)
	public @ResponseBody List<CatalogoBean> refrescarLista(@RequestParam("catalogo") String catalogo)throws Exception { 
		 CatalogoBean catalogoBean = new CatalogoBean();
		 catalogoBean.setIdCatalogo(catalogo);
		List<CatalogoBean> lstcatalogoBean =new ArrayList<CatalogoBean>(); 
		try {
			lstcatalogoBean = catalogo1Service.getBuscarPorFiltros(catalogoBean); 
		
		} catch (ServiceException e) {
			
			e.printStackTrace();
		}
		 
			return lstcatalogoBean; 
	}

	public ArticuloBean getArticuloBean() {
		return articuloBean;
	}

	public void setArticuloBean(ArticuloBean articuloBean) {
		this.articuloBean = articuloBean;
	}

	public List<CatalogoBean> getLstPresentacion() {
		return lstPresentacion;
	}

	public void setLstPresentacion(List<CatalogoBean> lstPresentacion) {
		this.lstPresentacion = lstPresentacion;
	}

	public List<CatalogoBean> getLstTipoArticulo() {
		return lstTipoArticulo;
	}

	public void setLstTipoArticulo(List<CatalogoBean> lstTipoArticulo) {
		this.lstTipoArticulo = lstTipoArticulo;
	}

	public List<CatalogoBean> getLstClaseArticulo() {
		return lstClaseArticulo;
	}

	public void setLstClaseArticulo(List<CatalogoBean> lstClaseArticulo) {
		this.lstClaseArticulo = lstClaseArticulo;
	}

	public List<LaboratorioBean> getLstLaboratorios() {
		return lstLaboratorios;
	}

	public void setLstLaboratorios(List<LaboratorioBean> lstLaboratorios) {
		this.lstLaboratorios = lstLaboratorios;
	}
	
}