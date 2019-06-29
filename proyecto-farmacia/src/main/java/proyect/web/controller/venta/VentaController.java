package proyect.web.controller.venta;


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
import proyect.core.bean.general.PersonaBean;
import proyect.core.bean.general.UbigeoBean;
import proyect.core.bean.venta.VentaBean;
import proyect.base.service.ServiceException;
import proyect.core.service.interfaces.catalogo.Catalogo1Service;
import proyect.core.service.interfaces.catalogo.Catalogo2Service;
import proyect.core.service.interfaces.general.UbigeoService;
import proyect.web.controller.base.BaseController; 

@Controller
@RequestMapping(value = "ventaController")
public class VentaController extends BaseController{
	
	List<CatalogoBean> lstTipoDocumento;
	List<CatalogoBean> lstTipoFinanciador;
	List<UbigeoBean> lstUbigeoBean;
	
	private VentaBean ventaBean;
	private UbigeoBean ubigeobean;
	
	@Autowired
	private Catalogo1Service catalogo1Service;
	
	@Autowired
	private Catalogo2Service catalogo2Service;
	
	@Autowired
	private UbigeoService ubigeoService;
	
	
	private void cargarCombos(ModelAndView mav) {
		try {
			lstTipoDocumento = catalogo2Service.listarPorCodigoTabla("000003", 1);
			lstTipoFinanciador = catalogo2Service.listarPorCodigoTabla("000008", 1);
			
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		
		mav.addObject("lstTipoDocumento", lstTipoDocumento);
		mav.addObject("lstTipoFinanciador", lstTipoFinanciador);
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("catalogoBean") CatalogoBean catalogoBean,
			HttpServletRequest request)
			throws Exception { 
		List<CatalogoBean> lstcatalogosRegistros = new ArrayList<CatalogoBean>();
		
		ModelAndView mav = new ModelAndView("mantenimiento/articulo/listado-articulo", "command", catalogoBean); 
		
		lstcatalogosRegistros = catalogo2Service.getBuscarPorFiltros(catalogoBean);
		mav.addObject("lstcatalogosRegistros", lstcatalogosRegistros);
		System.out.println("lstcatalogosRegistros " + lstcatalogosRegistros.size());
		this.cargarCombos(mav);
		return mav;
		
	}
	
	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("VentaBean") VentaBean VentaBean, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("mantenimiento/articulo/listado-articulo", "command", VentaBean); 
	
		this.cargarCombos(mav);
		return mav;
	}

	
	@RequestMapping(value = "/listado", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView listado(@ModelAttribute("VentaBean") VentaBean VentaBean, HttpServletRequest request){
	 
		ModelAndView mav = new ModelAndView("mantenimiento/articulo/listado-articulo", "command", VentaBean); 
		this.cargarCombos(mav);
		return mav;
	}
 
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo(HttpServletRequest request) {
		// cargarComboLeccion();
		VentaBean ventaBean = new VentaBean(); 
		ModelAndView mav = new ModelAndView("ventas/generar-venta", "command", ventaBean); 
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
				catalogoBean = catalogo2Service.getBuscarPorObjecto(ocatalogoBean);  
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
				sw = (catalogo2Service.actualizar(catalogoBean));
			} else { 
				sw =  (catalogo2Service.insertar(catalogoBean)); 
				
			} 
		} catch (Exception e) { 
			e.printStackTrace();
		}
		System.out.println("sw " + sw);
		if (sw) {
			ventaBean = new VentaBean() ;
			 return this.listado(ventaBean, request);
			 
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
			 if(catalogo2Service.eliminar(catalogoBean)){
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
			lstcatalogoBean = catalogo2Service.getBuscarPorFiltros(catalogoBean); 
		
		} catch (ServiceException e) {
			
			e.printStackTrace();
		}
		 
			return lstcatalogoBean; 
	}
	
	@RequestMapping(value = "/personaModal", method = RequestMethod.POST)
	public ModelAndView personaModalPost() throws Exception {
		PersonaBean objPersona = new  PersonaBean(); 
		ModelAndView mav = new ModelAndView("ventas/persona-registro-modal", "command",  objPersona); 
		
		ubigeobean = new UbigeoBean();
		ubigeobean.setVariable("");
		ubigeobean.setInstitucion("000003");
		ubigeobean.setCategoria("000003");
		lstUbigeoBean = new ArrayList<UbigeoBean>();
		try {
			
			lstUbigeoBean = ubigeoService.getBuscarPorFiltros(ubigeobean);
		} catch (Exception e) { 
		}
		mav.addObject("ubigeoBean", new UbigeoBean());
		mav.addObject("lstUbigeoBean", lstUbigeoBean);
		this.cargarCombos(mav);
		return mav;
	} 

	public VentaBean getVentaBean() {
		return ventaBean;
	}

	public void setVentaBean(VentaBean VentaBean) {
		this.ventaBean = VentaBean;
	}
	
	
	
}