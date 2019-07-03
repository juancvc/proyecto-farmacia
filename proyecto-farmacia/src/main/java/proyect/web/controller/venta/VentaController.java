package proyect.web.controller.venta;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import proyect.core.bean.general.CatalogoBean;
import proyect.core.bean.general.PersonaBean;
import proyect.core.bean.general.UbigeoBean;
import proyect.core.bean.seguridad.UsuarioBean;
import proyect.core.bean.stock.StockBean;
import proyect.core.bean.venta.VentaBean;
import proyect.core.bean.venta.VentaItemBean;
import proyect.base.service.ServiceException;
import proyect.core.service.interfaces.catalogo.Catalogo1Service;
import proyect.core.service.interfaces.catalogo.Catalogo2Service;
import proyect.core.service.interfaces.general.PersonaService;
import proyect.core.service.interfaces.general.UbigeoService;
import proyect.core.service.interfaces.stock.StockService;
import proyect.core.service.interfaces.venta.VentaService;
import proyect.web.controller.base.BaseController; 

@Controller
@RequestMapping(value = "ventaController")
public class VentaController extends BaseController{
	
	List<CatalogoBean> lstTipoDocumento;
	List<CatalogoBean> lstTipoFinanciador;
	List<CatalogoBean> lstSexo;
	List<CatalogoBean> lstEstadoCivil;
	List<CatalogoBean> lstNacionalidad;
	
	List<UbigeoBean> lstUbigeoBean;
	List<StockBean> lstStocks;
	
	private VentaBean ventaBean;
	private UbigeoBean ubigeobean;
	private PersonaBean personaBean;
	
	@Autowired
	private Catalogo1Service catalogo1Service;
	
	@Autowired
	private Catalogo2Service catalogo2Service;
	
	@Autowired
	private UbigeoService ubigeoService;
	
	@Autowired
	private StockService StockService;
	
	@Autowired
	private PersonaService personaService;

	@Autowired
	private VentaService ventaService;
	
	private void cargarCombos(ModelAndView mav) {
		try {
			lstTipoDocumento = catalogo2Service.listarPorCodigoTabla("000003", 1);
			lstTipoFinanciador = catalogo2Service.listarPorCodigoTabla("000008", 1);
			lstNacionalidad = catalogo1Service.listarPorCodigoTabla("000003", 1);
			lstSexo = catalogo1Service.listarPorCodigoTabla("000009", 1);
			lstEstadoCivil = catalogo1Service.listarPorCodigoTabla("000005", 1);
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		
		mav.addObject("lstTipoDocumento", lstTipoDocumento);
		mav.addObject("lstTipoFinanciador", lstTipoFinanciador);
		mav.addObject("lstNacionalidad", lstNacionalidad);
		mav.addObject("lstSexo", lstSexo);
		mav.addObject("lstEstadoCivil", lstEstadoCivil);
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("catalogoBean") CatalogoBean catalogoBean,
			HttpServletRequest request)
			throws Exception { 
		List<CatalogoBean> lstcatalogosRegistros = new ArrayList<CatalogoBean>();
		
		ModelAndView mav = new ModelAndView("mantenimiento/Stock/listado-Stock", "command", catalogoBean); 
		
		lstcatalogosRegistros = catalogo2Service.getBuscarPorFiltros(catalogoBean);
		mav.addObject("lstcatalogosRegistros", lstcatalogosRegistros);
		System.out.println("lstcatalogosRegistros " + lstcatalogosRegistros.size());
		this.cargarCombos(mav);
		return mav;
		
	}
	
	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("VentaBean") VentaBean VentaBean, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("mantenimiento/Stock/listado-Stock", "command", VentaBean); 
	
		this.cargarCombos(mav);
		return mav;
	}

	
	@RequestMapping(value = "/listado", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView listado(@ModelAttribute("VentaBean") VentaBean VentaBean, HttpServletRequest request){
	 
		ModelAndView mav = new ModelAndView("mantenimiento/Stock/listado-Stock", "command", VentaBean); 
		this.cargarCombos(mav);
		return mav;
	}
 
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo(HttpServletRequest request) {
		// cargarComboLeccion();
		VentaBean ventaBean = new VentaBean(); 
		StockBean Stock = new StockBean();
		Stock.setTipoLlamada("1");
		UsuarioBean usuario= (UsuarioBean) request.getSession().getAttribute("usuarioSesion");
		System.out.println("usuario.getAlmacen()" + usuario.getAlmacen().getCodigo());
		Stock.setAlmacen(usuario.getAlmacen());
		ModelAndView mav = new ModelAndView("ventas/generar-venta", "command", ventaBean); 
		this.cargarCombos(mav);
		try {
			
			lstStocks = StockService.getBuscarPorFiltros(Stock);
			System.out.println("lstStocks " + lstStocks.size());
		} catch (Exception e) { 
		}
		mav.addObject("lstStocks", lstStocks);
		
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
		objPersona.getNacionalidad().setIdRegistro("000114");
		objPersona.getEstadoCivil().setIdRegistro("000006");
		ModelAndView mav = new ModelAndView("ventas/persona-registro-modal", "command",  objPersona); 
		ubigeobean = new UbigeoBean();
		ubigeobean.setDescripcion("");
		ubigeobean.setInstitucion("000003");
		ubigeobean.setCategoria("000003");
		lstUbigeoBean = new ArrayList<UbigeoBean>();
		try {
			
			lstUbigeoBean = ubigeoService.getBuscarPorFiltros(ubigeobean);
		} catch (Exception e) { 
		}
		mav.addObject("personaBean", objPersona);
		mav.addObject("ubigeoBean", new UbigeoBean());
		mav.addObject("lstUbigeoBean", lstUbigeoBean);
		this.cargarCombos(mav);
		return mav;
	} 
	
	@RequestMapping(value = "/grabarPersona", method = RequestMethod.POST)
	public @ResponseBody PersonaBean grabarPersonaLaboratorio(@ModelAttribute("personaBean")PersonaBean obpersonaBean,
											 HttpServletRequest request) throws Exception {  
	
		if (personaBean==null) {
			personaBean = new PersonaBean();
		} 
		
		System.out.println("obpersonaBean.getCodigo() " + obpersonaBean.getCodigo());
		
		if (obpersonaBean.getCodigo().equals("")) {
			if(!obpersonaBean.getTipoDocumento().getIdRegistro().equals("000002") ){  
				System.out.println("SIN SERVICIO DE RENIEC" ); 
				
				this.setAuditoria(obpersonaBean, request, true); 
				this.personaService.insertar(obpersonaBean);
				System.out.println("SIN SERVICIO DE RENIEC getNroDocumento"  + obpersonaBean.getNroDocumento()); 
				setPersonaBean(obpersonaBean);
			}else{
				setPersonaBean(obpersonaBean);
				if(this.getPersonaBean().getSwReniec()){
					
					System.out.println("this.getPostulanteBean().getPersona(). " +this.getPersonaBean().getTipoDocumento().getIdRegistro());
					System.out.println("this.getPostulanteBean().getPersona() ::" + this.getPersonaBean());
					this.getPersonaBean().setTelefonoNumero(obpersonaBean.getTelefonoNumero());
					this.getPersonaBean().setCorreo(obpersonaBean.getCorreo());
					this.getPersonaBean().getNivelInstrucion().setIdRegistro(obpersonaBean.getNivelInstrucion().getIdRegistro());
					this.getPersonaBean().getOcupacion().setIdRegistro(obpersonaBean.getOcupacion().getIdRegistro());
					
					this.setAuditoria(this.getPersonaBean(), request, true); 
					this.personaService.insertar(this.getPersonaBean());
					System.out.println("persona reniec");
				}else{
					System.out.println("SIN SERVICIO DE RENIEC" ); 
					this.setAuditoria(obpersonaBean, request, true); 
					this.personaService.insertar(obpersonaBean);
					System.out.println("SIN SERVICIO DE RENIEC getNroDocumento"  + obpersonaBean.getNroDocumento()); 
					setPersonaBean(obpersonaBean);
				}
			} 
			System.out.println("persona no existe es nuevo"); 
			
		}else{ 
			System.out.println("existe persona");
			 
				this.setAuditoria(this.getPersonaBean(), request, true);  
				this.personaService.actualizar(obpersonaBean); 
			
		}     
		
		return this.getPersonaBean();
	}
	

	   @RequestMapping(value = "/refrescarListaArticulos", method = RequestMethod.GET)
		public @ResponseBody VentaItemBean refrescarListaOrden(@RequestParam("index") int index) throws Exception {
			System.out.println("index " + index);
			VentaItemBean objVentaItemBean = new VentaItemBean(); 
			objVentaItemBean.setStock(lstStocks.get(index)); 
			objVentaItemBean.setPrecio(lstStocks.get(index).getPrecioVenta());
			objVentaItemBean.setCantidad(1);
			objVentaItemBean.ejecutarImporte();
			DecimalFormat df = new DecimalFormat("0.00"); 
			objVentaItemBean.setsImporte((df.format(objVentaItemBean.getSubtotal()).replace(",", ".")));
			//lstOrdenDetalleBean.add(objOrdenDetalleBean);
			return objVentaItemBean;
		}
	     
	   @RequestMapping(value = "/consultarPersonaPorDocumento", method = RequestMethod.GET)
		public @ResponseBody PersonaBean consultarPorNroDocumento(
				@RequestParam("tipoDocumento") String tipoDocumento,
				@RequestParam("numero") String numero)throws Exception {
			this.setPersonaBean(new PersonaBean());  
			personaBean = new PersonaBean();
			PersonaBean prmPersona = new PersonaBean();
			prmPersona.setNroDocumento(numero);
			prmPersona.getTipoDocumento().setIdRegistro(tipoDocumento);
			try { 
					personaBean = personaService.buscarxTipoDocumentoNumeroDocumento(prmPersona);
					if(personaBean!=null){   
						System.out.println("perosana consultada" +personaBean.getNombreCompleto());  
						System.out.println("personaBean.getCodigo() " + personaBean.getCodigo());
						this.setPersonaBean(personaBean);
						
					}else{   
					} 
			} catch (Exception e) {  
			} 
			 
			return this.getPersonaBean();
		}   
	 
	   
	@RequestMapping(value = "/cambiarFinanciamiento", method = RequestMethod.GET)
	@ResponseBody
	public void cambiarFinanciamiento(@RequestParam("financiador") String financiador,
		HttpServletRequest request) { 
		 this.getPersonaBean().getTipoFinanciador().setIdRegistro(financiador);
   	}
		
    @RequestMapping(value = "/grabarOrden", method = RequestMethod.POST)
	@ResponseBody
	public String grabarVenta(
			@RequestBody VentaItemBean[] ventaDetalleArray,  
			HttpServletRequest request) {
    		
    	System.out.println("personaCodigo:: " + this.getPersonaBean().getCodigo());
		String codigo = "";
		boolean sw = false;
		String cadenaCodigoStock = "@";
		String cadenaCantidad = "@"; 
		VentaBean ventaBean = new VentaBean();
		ventaBean.setPersona(this.getPersonaBean());
		for (VentaItemBean prmVentaItemBeanBean : ventaDetalleArray) {
			System.out.println("getCodReg == >" + prmVentaItemBeanBean.getStock().getCodigo());
			
			cadenaCantidad = cadenaCantidad + prmVentaItemBeanBean.getCantidad() + "@";
			cadenaCodigoStock = cadenaCodigoStock + prmVentaItemBeanBean.getStock().getCodigo() + "@";
		}
		ventaBean.setCadenaCantidad(cadenaCantidad);
		ventaBean.setCadenaCodigoStock(cadenaCodigoStock);
		ventaBean.setCantidadItems(ventaDetalleArray.length);
		 
		try {

			if (ventaBean.getCodigo().equals("")) {
				this.setAuditoria(ventaBean, request, true);
				  
				sw = (this.ventaService.insertar(ventaBean));

				if (sw) {
					codigo = ventaBean.getCodigo(); 

				} 

			} else {
				// UPDATE
				this.setAuditoria(ventaBean, request, false);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("sw " + sw);
		return codigo; 
		 
	}
	   
	public VentaBean getVentaBean() {
		return ventaBean;
	}

	public void setVentaBean(VentaBean VentaBean) {
		this.ventaBean = VentaBean;
	}
	public PersonaBean getPersonaBean() {
		return personaBean;
	}

	public void setPersonaBean(PersonaBean personaBean) {
		this.personaBean = personaBean;
	}
	
	
}