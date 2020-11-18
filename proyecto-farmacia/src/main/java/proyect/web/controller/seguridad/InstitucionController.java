package proyect.web.controller.seguridad;


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
import proyect.core.bean.general.PersonalBean;
import proyect.core.bean.inventario.PreciosVentaArticuloBean;
import proyect.core.bean.seguridad.UsuarioBean;
import proyect.base.service.ServiceException;
import proyect.core.service.interfaces.catalogo.Catalogo1Service;
import proyect.core.service.interfaces.catalogo.Catalogo2Service;
import proyect.core.service.interfaces.general.PersonalService;
import proyect.web.controller.base.BaseController; 

@Controller
@RequestMapping(value = "institucionController")
public class InstitucionController extends BaseController{
	
	List<CatalogoBean> lstMes;
	List<CatalogoBean> lstTipoPrecios;
	List<PersonalBean> lstPersonal;
	
	private PreciosVentaArticuloBean preciosVentaArticuloBean;
	
	@Autowired
	private Catalogo1Service catalogo1Service;
	
	@Autowired
	private Catalogo2Service catalogo2Service;
	
	@Autowired
	private PersonalService personalService;
	
	private void cargarCombos(ModelAndView mav) {
		try {
			lstMes = catalogo2Service.listarPorCodigoTabla("000010", 0);
			lstTipoPrecios = catalogo2Service.listarPorCodigoTabla("000011", 0);
			
			PersonalBean personal = new PersonalBean();
			personal.getPersona().setNombres("");
			personal.getPersona().setApellidoPaterno("");
			lstPersonal = personalService.getBuscarPorFiltros(personal);
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		mav.addObject("lstMes", lstMes);
		mav.addObject("lstTipoPrecios", lstTipoPrecios);
		mav.addObject("lstPersonal", lstPersonal);
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("catalogoBean") CatalogoBean catalogoBean,
			HttpServletRequest request)
			throws Exception { 
		List<CatalogoBean> lstcatalogosRegistros = new ArrayList<CatalogoBean>();
		
		ModelAndView mav = new ModelAndView("inventario/precio/listado-articulo", "command", catalogoBean); 
		try {
			lstMes = catalogo2Service.listarPorCodigoTabla("000010", 0);
			lstTipoPrecios = catalogo2Service.listarPorCodigoTabla("000011", 0);
			
			PersonalBean personal = new PersonalBean();
			personal.getPersona().setNombres("");
			personal.getPersona().setApellidoPaterno("");
			lstPersonal = personalService.getBuscarPorFiltros(personal);
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		mav.addObject("lstcatalogosRegistros", lstcatalogosRegistros); 
		//this.cargarCombos(mav);
		return mav;
		
	}
	
	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("catalogoBean") CatalogoBean catalogoBean, HttpServletRequest request) {
		
		return listado(catalogoBean, request);
	}

	
	@RequestMapping(value = "/listado", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView listado(@ModelAttribute("catalogoBean") CatalogoBean catalogoBean, HttpServletRequest request){
	 
		ModelAndView mav = new ModelAndView("inventario/precio/listado-precio", "command", catalogoBean); 
		try {
			lstTipoPrecios = catalogo2Service.listarPorCodigoTabla("000017", 0);
			 
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		mav.addObject("lstTipoPrecios", lstTipoPrecios);
		//this.cargarCombos(mav);
		return mav;
	}
 
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo(HttpServletRequest request) {
		// cargarComboLeccion();
		UsuarioBean usuario= (UsuarioBean) request.getSession().getAttribute("usuarioSesion");
		System.out.println("usuario.getAlmacen()" + usuario.getAlmacen().getCodigo());
		CatalogoBean catalogoBean = new CatalogoBean(); 
		ModelAndView mav = new ModelAndView("seguridad/configuracion/registro-institucion", "command", catalogoBean); 
	//	this.cargarCombos(mav);
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
		 
		System.out.println("sw " + sw);
		if (sw) {
			catalogoBean = new CatalogoBean() ;
			 return this.listado(catalogoBean, request);
			 
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
		 
		return valida;
	}
	
	@RequestMapping(value = "/refrescarLista", method = RequestMethod.GET)
	public @ResponseBody List<CatalogoBean> refrescarLista(@RequestParam("catalogo") String catalogo)throws Exception { 
		 CatalogoBean catalogoBean = new CatalogoBean();
		 catalogoBean.setIdCatalogo(catalogo);
		List<CatalogoBean> lstcatalogoBean =new ArrayList<CatalogoBean>(); 
		 
		 
			return lstcatalogoBean; 
	}
 
	
	
}