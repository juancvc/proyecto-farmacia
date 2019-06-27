package proyect.web.controller.mantenimiento;


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
import proyect.base.service.ServiceException;
import proyect.core.service.interfaces.catalogo.Catalogo1Service;
import proyect.web.controller.base.BaseController; 

@Controller
@RequestMapping(value = "AlmacenController")
public class AlmacenController extends BaseController{
	
	List<CatalogoBean> lstcatalogos = new ArrayList<CatalogoBean>();
	private AlmacenBean almacenBean;
	
	@Autowired
	private Catalogo1Service Catalogo1Service;
	
	
	private void cargarCombos(ModelAndView mav) {
		/*try {
			lstcatalogos = Catalogo1Service.listarTodascatalogos(new CatalogoBean());
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		*/
		mav.addObject("lstcatalogos", lstcatalogos);
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("catalogoBean") CatalogoBean catalogoBean,
			HttpServletRequest request)
			throws Exception { 
		List<CatalogoBean> lstcatalogosRegistros = new ArrayList<CatalogoBean>();
		
		ModelAndView mav = new ModelAndView("mantenimiento/Almacen/listado-Almacen", "command", catalogoBean); 
		
		lstcatalogosRegistros = Catalogo1Service.getBuscarPorFiltros(catalogoBean);
		mav.addObject("lstcatalogosRegistros", lstcatalogosRegistros);
		System.out.println("lstcatalogosRegistros " + lstcatalogosRegistros.size());
		this.cargarCombos(mav);
		return mav;
		
	}
	
	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("AlmacenBean") AlmacenBean AlmacenBean, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("mantenimiento/Almacen/listado-Almacen", "command", AlmacenBean); 
	
		this.cargarCombos(mav);
		return mav;
	}

	
	@RequestMapping(value = "/listado", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView listado(@ModelAttribute("AlmacenBean") AlmacenBean AlmacenBean, HttpServletRequest request){
	 
		ModelAndView mav = new ModelAndView("mantenimiento/Almacen/listado-Almacen", "command", AlmacenBean); 
		this.cargarCombos(mav);
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
			almacenBean = new AlmacenBean() ;
			 return this.listado(almacenBean, request);
			 
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

	
	
}