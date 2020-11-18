package proyect.web.controller.movimiento;


import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import proyect.core.bean.general.AlmacenBean;
import proyect.core.bean.general.CatalogoBean;
import proyect.core.bean.general.PersonaBean;
import proyect.core.bean.movimiento.MovimientoAlmacenBean;
import proyect.core.bean.stock.ArticuloBean;
import proyect.core.bean.stock.StockBean;
import proyect.core.bean.venta.VentaBean;
import proyect.base.service.ServiceException;
import proyect.core.service.interfaces.catalogo.Catalogo1Service;
import proyect.core.service.interfaces.catalogo.Catalogo2Service;
import proyect.core.service.interfaces.general.AlmacenService;
import proyect.core.service.interfaces.movimiento.MovimientoAlmacenService;
import proyect.core.service.interfaces.stock.ArticuloService;
import proyect.core.service.interfaces.stock.StockService;
import proyect.web.controller.base.BaseController; 

@Controller
@RequestMapping(value = "movimientoAlmacenController")
public class MovimientoAlmacenController extends BaseController{
	
	List<CatalogoBean> lstcatalogos = new ArrayList<CatalogoBean>();
	private MovimientoAlmacenBean movimientoAlmacenBean;
	
	List<CatalogoBean> lstMes;
	List<CatalogoBean> lstPeriodo;
	List<StockBean> lstStocks;
	List<ArticuloBean> lstArticulos;
	List<AlmacenBean> lstAlmacen;
	List<MovimientoAlmacenBean> lstMovimientoArticulo;
	
	@Autowired
	private ArticuloService articuloService;
	@Autowired
	private AlmacenService almacenService;
	@Autowired
	private Catalogo1Service Catalogo1Service;
	@Autowired
	private MovimientoAlmacenService movimientoAlmacenService;
	@Autowired
	private Catalogo2Service catalogo2Service;
	@Autowired
	private StockService StockService;
	
	private void cargarCombos(ModelAndView mav) {
		try {
		//	lstcatalogos = Catalogo1Service.listarTodascatalogos(new CatalogoBean());
			lstMes = catalogo2Service.listarPorCodigoTabla("000010", 0);
			lstPeriodo = catalogo2Service.listarPorCodigoTabla("000011", 0);
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		mav.addObject("lstMes", lstMes);
		mav.addObject("lstPeriodo", lstPeriodo);
		mav.addObject("lstcatalogos", lstcatalogos);
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("catalogoBean") CatalogoBean catalogoBean,
			HttpServletRequest request)
			throws Exception { 
		List<CatalogoBean> lstcatalogosRegistros = new ArrayList<CatalogoBean>();
		
		ModelAndView mav = new ModelAndView("mantenimiento/articulo/listado-articulo", "command", catalogoBean); 
		
		lstcatalogosRegistros = Catalogo1Service.getBuscarPorFiltros(catalogoBean);
		mav.addObject("lstcatalogosRegistros", lstcatalogosRegistros);
		System.out.println("lstcatalogosRegistros " + lstcatalogosRegistros.size());
		this.cargarCombos(mav);
		return mav;
		
	}
	
	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("movimientoAlmacenBean") MovimientoAlmacenBean movimientoAlmacenBean,
			HttpServletRequest request) {
		return this.listado(movimientoAlmacenBean, request) ;
	}
	
	@RequestMapping(value = "/listadoICIMensual", method = RequestMethod.GET)
	public ModelAndView doListadoICIMensual(@ModelAttribute("movimientoAlmacenBean") MovimientoAlmacenBean movimientoAlmacenBean, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("movimiento/ICI-mensual", "command", movimientoAlmacenBean); 
	
		this.cargarCombos(mav);
		return mav;
	}

	
	@RequestMapping(value = "/listado", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView listado(@ModelAttribute("movimientoAlmacenBean") MovimientoAlmacenBean movimientoAlmacenBean, 
			HttpServletRequest request){
	 
		ModelAndView mav = new ModelAndView("mantenimiento/articulo/listado-articulo", "command", movimientoAlmacenBean); 
		this.cargarCombos(mav);
		return mav;
	}
	
	@RequestMapping(value = "/reporteKardex", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView reporteKardex(@ModelAttribute("movimientoAlmacenBean") MovimientoAlmacenBean movimientoAlmacenBean, 
			HttpServletRequest request){ 
		ArticuloBean articulo = new ArticuloBean(); 
		ModelAndView mav = new ModelAndView("movimiento/kardex-articulo", "command", movimientoAlmacenBean); 
		try {
			lstAlmacen = almacenService.getBuscarPorFiltros(new AlmacenBean());
			lstArticulos = articuloService.getBuscarPorFiltros(articulo); 
		} catch (Exception e) { 
		}
		mav.addObject("lstAlmacen", lstAlmacen);
		mav.addObject("lstArticulos", lstArticulos);
		this.cargarCombos(mav);
		return mav;
	}
	
	@RequestMapping(value = "/buscarArticuloKardex", method = RequestMethod.POST)
	public ModelAndView buscarArticuloKardex(@ModelAttribute("movimientoAlmacenBean") MovimientoAlmacenBean movimientoAlmacenBean,
			HttpServletRequest request)
			throws Exception { 
		ArticuloBean articulo = new ArticuloBean(); 
		System.out.println(movimientoAlmacenBean.getStockBean().getArticulo().getCodigo());
		ModelAndView mav = new ModelAndView("movimiento/kardex-articulo", "command", movimientoAlmacenBean); 
		
		try {
			lstAlmacen = almacenService.getBuscarPorFiltros(new AlmacenBean());
			lstArticulos = articuloService.getBuscarPorFiltros(articulo); 
			lstMovimientoArticulo = movimientoAlmacenService.buscarxArticuloAlmacen(movimientoAlmacenBean); 
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		mav.addObject("lstAlmacen", lstAlmacen);
		mav.addObject("lstArticulos", lstArticulos);
		mav.addObject("lstMovimientoArticulo", lstMovimientoArticulo);  
		mav.addObject("movimientoAlmacenBean", movimientoAlmacenBean); 
		//this.cargarCombosListado(mav);
		return mav;
		
	}
	
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo(HttpServletRequest request) {
		// cargarComboLeccion();
		CatalogoBean catalogoBean = new CatalogoBean(); 
		ModelAndView mav = new ModelAndView("general/Catalogos/registro-Catalogo", "command", catalogoBean); 
		this.cargarCombos(mav);
		return mav;
	}
	@RequestMapping(value = "/modificar", method = RequestMethod.POST)
	public ModelAndView modificar(@RequestParam("catalogo") String catalogo,
								  @RequestParam("codigo") String codigoRegistro){  
		
		System.out.println("modificar catalogo " + catalogo);
		System.out.println("modificar codigoRegistro " + codigoRegistro);
		CatalogoBean ocatalogoBean = new CatalogoBean(); 
		ocatalogoBean.setIdCatalogo(catalogo);
		ocatalogoBean.setIdRegistro(codigoRegistro);
		CatalogoBean catalogoBean = new CatalogoBean();  
	
			try { 
				catalogoBean = Catalogo1Service.getBuscarPorObjecto(ocatalogoBean);  
			 System.out.println("catalogoBean::" + catalogoBean);
			} catch (ServiceException e) {
				
				e.printStackTrace();
			}
			ModelAndView mav = new ModelAndView("general/Catalogos/registro-Catalogo", "command",catalogoBean); 
			this.cargarCombos(mav);
			mav.addObject("catalogoBean", catalogoBean);
			mav.addObject("swActivo", "1"); 
			return mav;
	}
	
	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
	//@ResponseBody
	public ModelAndView grabar(@ModelAttribute("catalogoBean") CatalogoBean catalogoBean, HttpServletRequest request) {
		 
		System.out.println("doGrabar @ModelAttribute");
		boolean sw = true;
		try {
			if (catalogoBean.getIdRegistro()!=null && !catalogoBean.getIdRegistro().equals("")) { 
				sw = (Catalogo1Service.actualizar(catalogoBean));
			} else { 
				sw =  (Catalogo1Service.insertar(catalogoBean)); 
				
			} 
		} catch (Exception e) { 
			e.printStackTrace();
		}
		System.out.println("sw " + sw);
		if (sw) {
			movimientoAlmacenBean = new MovimientoAlmacenBean() ;
			 return this.listado(movimientoAlmacenBean, request);
			 
		}else{
			ModelAndView mav = new ModelAndView("general/Catalogos/registro-Catalogo", "command",catalogoBean); 
			return mav ;
		} 
		 
	} 
	
	@RequestMapping(value = "/eliminar", method = RequestMethod.GET)
	@ResponseBody
	public String doEliminar(@RequestParam("catalogo") String catalogo,
							 @RequestParam("codReg") String codReg,
			 HttpServletRequest request) {
		String valida = "";
		System.out.println("codigo eliminar:: " + catalogo); 
		CatalogoBean catalogoBean = new CatalogoBean();
		catalogoBean.setIdRegistro(codReg);
		catalogoBean.setIdCatalogo(catalogo);
		try { 
			 if(Catalogo1Service.eliminar(catalogoBean)){
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
			lstcatalogoBean = Catalogo1Service.getBuscarPorFiltros(catalogoBean); 
		
		} catch (ServiceException e) {
			
			e.printStackTrace();
		}
		 
			return lstcatalogoBean; 
	}
 
	@RequestMapping(value = "/listarReporteICIMensual", method = RequestMethod.GET)
	public @ResponseBody List<CatalogoBean> listarReporteICIMensual(@RequestParam("catalogo") String catalogo)throws Exception { 
		 CatalogoBean catalogoBean = new CatalogoBean();
		 catalogoBean.setIdCatalogo(catalogo);
		List<CatalogoBean> lstcatalogoBean =new ArrayList<CatalogoBean>(); 
		try {
			lstcatalogoBean = Catalogo1Service.getBuscarPorFiltros(catalogoBean); 
		
		} catch (ServiceException e) {
			
			e.printStackTrace();
		}
		 
			return lstcatalogoBean; 
	}
	
}