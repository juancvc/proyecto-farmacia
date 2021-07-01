package proyect.web.controller.general;


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
import proyect.core.bean.general.CatalogoBean;
import proyect.base.service.ServiceException;
import proyect.core.service.interfaces.catalogo.Catalogo1Service;
import proyect.core.service.interfaces.catalogo.Catalogo2Service;
import proyect.web.controller.base.BaseController; 

@Controller
@RequestMapping(value = "catalogoController")
public class CatalogoController extends BaseController{
	
	List<CatalogoBean> lstcatalogos = new ArrayList<CatalogoBean>();
	List<CatalogoBean> lstcatalogosRegistros = new ArrayList<CatalogoBean>();
	
	@Autowired
	private Catalogo1Service Catalogo1Service;
	
	@Autowired
	private Catalogo2Service Catalogo2Service;
	
	private void cargarCombos(ModelAndView mav) {
		try {
			lstcatalogos = Catalogo2Service.listarTodascatalogos();
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		} 
		mav.addObject("lstcatalogos", lstcatalogos);
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("catalogoBean") CatalogoBean catalogoBean,
			HttpServletRequest request)
			throws Exception { 
		 
		
		ModelAndView mav = new ModelAndView("mantenimiento/catalogo/listado-catalogo", "command", catalogoBean); 

		try {
			lstcatalogosRegistros = Catalogo2Service.listarCatalogoRegistros(catalogoBean);
		} catch (Exception e) { 
		}
		mav.addObject("lstcatalogosRegistros", lstcatalogosRegistros); 
		this.cargarCombos(mav);
		return mav;
		
	}
	
	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("catalogoBean") CatalogoBean catalogoBean, HttpServletRequest request) {
		return this.listado(catalogoBean, request);
	}

	
	@RequestMapping(value = "/listado", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView listado(@ModelAttribute("catalogoBean") CatalogoBean catalogoBean, HttpServletRequest request){
	 
		ModelAndView mav = new ModelAndView("mantenimiento/catalogo/listado-catalogo", "command", catalogoBean); 
		try {
			lstcatalogosRegistros = Catalogo2Service.listarCatalogoRegistros(catalogoBean);
		} catch (Exception e) { 
		}
		mav.addObject("lstcatalogosRegistros", lstcatalogosRegistros);
		this.cargarCombos(mav);
		return mav;
	}
 
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo(HttpServletRequest request) {
		// cargarComboLeccion();
		CatalogoBean catalogoBean = new CatalogoBean(); 
		ModelAndView mav = new ModelAndView("mantenimiento/catalogo/registro-catalogo", "command", catalogoBean); 
		this.cargarCombos(mav);
		return mav;
	}
	@RequestMapping(value = "/modificar", method = RequestMethod.POST)
	public ModelAndView modificar(@RequestParam("index") int index ){  
		CatalogoBean catalogoBean = new CatalogoBean();
		catalogoBean = lstcatalogosRegistros.get(index);
		ModelAndView mav = new ModelAndView("mantenimiento/catalogo/registro-catalogo", "command",catalogoBean); 
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
				this.setAuditoria(catalogoBean, request, false); 
				sw = (Catalogo2Service.actualizar(catalogoBean));
			} else { 
				this.setAuditoria(catalogoBean, request, false); 
				sw =  (Catalogo2Service.insertar(catalogoBean)); 
				
			} 
		} catch (Exception e) { 
			e.printStackTrace();
		}
		System.out.println("sw " + sw);
		if (sw) {
			catalogoBean = new CatalogoBean() ;
			 return this.listado(catalogoBean, request);
			 
		}else{
			ModelAndView mav = new ModelAndView("mantenimiento/catalogo/registro-catalogo", "command",catalogoBean); 
			return mav ;
		} 
		 
	} 
	
	@RequestMapping(value = "/eliminar", method = RequestMethod.GET)
	@ResponseBody
	public String doEliminar(@RequestParam("index") int index,
			 HttpServletRequest request) {
		String valida = "";
		System.out.println("codigo eliminar:: " + index); 
		CatalogoBean catalogoBean = new CatalogoBean();
		catalogoBean = lstcatalogosRegistros.get(index);
		try { 
			 if(Catalogo2Service.eliminar(catalogoBean)){
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
}