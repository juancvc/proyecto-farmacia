package proyect.web.controller.seguridad;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
//import gob.hnch.systems.ws.hnch.client.imp.PersonaServiceImp;
import proyect.core.bean.general.PersonaBean;
import proyect.core.bean.general.RenaesBean;
import proyect.core.bean.compra.CompraItemBean;
import proyect.core.bean.general.AlmacenBean;
import proyect.core.bean.general.CatalogoBean;
import proyect.core.bean.seguridad.PerfilBean;
import proyect.core.bean.seguridad.UsuarioAlmacenBean;
import proyect.core.bean.seguridad.UsuarioAlmacenTurnoBean;
import proyect.core.bean.seguridad.UsuarioBean;
import proyect.core.bean.seguridad.UsuarioPerfilBean;
import proyect.core.bean.seguridad.UsuarioRenaesBean;
import proyect.core.bean.stock.ArticuloBean;
import proyect.base.service.ServiceException;
import proyect.core.service.interfaces.catalogo.Catalogo1Service;
import proyect.core.service.interfaces.catalogo.Catalogo2Service;
import proyect.core.service.interfaces.general.AlmacenService;
import proyect.core.service.interfaces.general.PersonaService;
import proyect.core.service.interfaces.general.RenaesService;
import proyect.core.service.interfaces.seguridad.PerfilService;
import proyect.core.service.interfaces.seguridad.UsuarioAlmacenService;
import proyect.core.service.interfaces.seguridad.UsuarioAlmacenTurnoService;
import proyect.core.service.interfaces.seguridad.UsuarioPerfilService;
import proyect.core.service.interfaces.seguridad.UsuarioService;
import proyect.web.controller.base.BaseController;
import proyect.web.utilitarios.VO;
import proyect.web.utilitarios.acceso.LoginVo;
import proyect.web.utilitarios.encrypt.Encrypt;
 
@Controller
@Scope(value="session")
@RequestMapping(value = "usuarioController")
public class UsuarioController extends BaseController{
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	UsuarioAlmacenService usuarioAlmacenService;
	
	@Autowired
	UsuarioPerfilService usuarioPerfilService;
	
	@Autowired
	UsuarioAlmacenTurnoService usuarioAlmacenTurnoService;
	
	@Autowired 
	private PersonaService personaService;
	
	@Autowired
	private Catalogo2Service catalogo2Service;
	
	@Autowired
	PerfilService perfilService;
	
	
	@Autowired
	AlmacenService almacenService;

	@Autowired
	private RenaesService renaesService;
	
	@Autowired
	private Catalogo1Service maestraGene01Services;
	
	private PersonaBean personaBean; 
	private UsuarioBean usuarioBean;
	private PerfilBean perfilBean;
	private List<CatalogoBean>	lstSituacion;
	private List<CatalogoBean>	lstTipoDocumento;
	private List<UsuarioBean> lstUsuarioBean;
	private List<PerfilBean>	lstPerfiles;
	List<CatalogoBean> lstDocumento = new ArrayList<CatalogoBean>();
	List<CatalogoBean> tipoPerfil = new ArrayList<CatalogoBean>();
	List<CatalogoBean> sedes = new ArrayList<CatalogoBean>();
	List<AlmacenBean> lstAlmacenBean;
	List<UsuarioAlmacenBean> lstUsuarioAlmacenBean =new ArrayList<UsuarioAlmacenBean>(); 
	private List<RenaesBean> lstRenaesBean;
	private String tmpContrasena;
	
	@PostConstruct
	public void init(){
		this.setUsuarioBean(new UsuarioBean());
		this.setPersonaBean(new PersonaBean());
		this.perfilBean= new PerfilBean();
		this.setLstRenaesBean(new ArrayList<RenaesBean>());
	}
 
	
	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("usuarioBean") UsuarioBean bean, HttpServletRequest request)throws Exception {
		
		return this.getLista(bean,request);
	}
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo() { 
		ModelAndView mav = new ModelAndView("seguridad/usuario/registro-usuario", "command",new UsuarioBean());
		mav.addObject("usuarioBean", new UsuarioBean());
		try {
			lstDocumento = catalogo2Service.listarPorCodigoTabla("000003", 1);
			tipoPerfil = maestraGene01Services.listarPorCodigoTabla("000064", 1);
			sedes = maestraGene01Services.listarPorCodigoTabla("000065", 1);
		    lstAlmacenBean = almacenService.getBuscarPorFiltros(new AlmacenBean());
			 
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		setPersonaBean(new PersonaBean());
		mav.addObject("lstDocumento", lstDocumento);
		mav.addObject("lstAlmacen", lstAlmacenBean);
		this.cargarComboPerfiles(mav);
		return mav;
	}
	
	@RequestMapping(value = "/consultarPorDocumentoPersona", method = RequestMethod.GET)
	public @ResponseBody PersonaBean consultarPorNroDocumento(@RequestParam("tipoDocumento") String tipoDocumento,
			@RequestParam("numero") String numero) throws Exception {
		this.setPersonaBean(new PersonaBean());
		personaBean = new PersonaBean();
		PersonaBean prmPersona = new PersonaBean();
		prmPersona.setNroDocumento(numero);
		prmPersona.getTipoDocumento().setIdRegistro(tipoDocumento);
		try {
			personaBean = personaService.buscarxTipoDocumentoNumeroDocumentoSigeho(prmPersona);
			if (personaBean != null) {
				System.out.println("perosana consultada" + personaBean.getNombreCompleto());
				System.out.println("personaBean.getCodigo() " + personaBean.getCodigo());
				this.setPersonaBean(personaBean);

			} else {
			}
		} catch (Exception e) {
		}

		return this.getPersonaBean();
	}
	/***
	@RequestMapping(value = "/consultarPorDocumentoPersona", method = RequestMethod.GET)
	public @ResponseBody PersonaBean consultarPorNroDocumento(@RequestParam("tipoDocumento") String tipoDocumento,@RequestParam("numero") String numero)throws Exception {
		  
		personaBean = new PersonaBean();
		PersonaBean prmPersona = new PersonaBean();
		prmPersona.setNroDocumento(numero);
		prmPersona.getTipoDocumento().setIdRegistro(tipoDocumento);
		
		try {
			personaBean = this.getPersonaService().buscarxTipoDocumentoNumeroDocumento(prmPersona); 
			if(personaBean!=null){
				System.out.println("persona existe en reco.persona");
				System.out.println("persona"+personaBean.getNombreCompleto());
				System.out.println("persona"+personaBean.getTelfCelu());
				System.out.println("persona"+personaBean.getCorreo());
				setPersonaBean(personaBean);
				
				 
			}else{
				personaBean = this.getPersonaService().buscarxTipoDocumentoNumeroDocumentoSigeho(prmPersona);
				if(personaBean!=null){  
					System.out.println("persona existe en sigehov2gene");
					System.out.println(personaBean.getNombreCompleto());
					System.out.println("fechNac" + personaBean.getFechaNac());
					personaBean.setCodigo("");
					setPersonaBean(personaBean); 
				
				}else{
					List<gob.hnch.systems.ws.ext.model.Persona> lstPersona = new ArrayList<gob.hnch.systems.ws.ext.model.Persona>();
					personaBean = new PersonaBean();
					PersonaServiceImp persona = new PersonaServiceImp();  
					gob.hnch.systems.ws.ext.model.Persona perso =persona.getPersona(numero);
					System.out.println("personaaaa"+perso.toString());
					lstPersona.add(perso); 
					if (perso!= null ) {
						System.out.println("personaBean reniec no es null " + perso.getApSegundo());
						personaBean.setApellidoMaterno(perso.getApSegundo());
						personaBean.setApellidoPaterno(perso.getApPrimer());
						personaBean.setNombres(perso.getPrenomInscrito());
						personaBean.setNroDocumento(perso.getNuDNI());
						personaBean.getTipoDocumento().setIdRegistro("000001");
						SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyyMMdd");
						String strFecha = perso.getFeNacimiento();
						Date fecha = null;
						try {

						fecha = formatoDelTexto.parse(strFecha);

						} catch (ParseException ex) {

						ex.printStackTrace();

						}
						
						personaBean.setFechaNac(fecha);
						System.out.println("persona reniec "+personaBean.getNombreCompleto()); 
						
						if (perso.getDeGenero().equals("1")) {
							personaBean.getSexo().setIdRegistro("000002"); 
						}else{
							personaBean.getSexo().setIdRegistro("000001"); 
						}
						System.out.println("tipoDocumento " + tipoDocumento); 
						this.setPersonaBean(personaBean);
					}
					
				} 
			}
		} catch (Exception e) { 
			
		} 
	
		return personaBean;
	}
	*/
	
	@RequestMapping(value = "/buscarPorCodigoPersona", method = RequestMethod.GET)
	public @ResponseBody UsuarioBean buscarPorCodigoPersona(@RequestParam("codigoPersona") String codigoPersona)throws Exception {
		  
		UsuarioBean usuarioBean = new UsuarioBean();
		PersonaBean prmPersona = new PersonaBean();
		prmPersona.setCodigo(codigoPersona);
		UsuarioBean prmUsuarioBean = new UsuarioBean();
		prmUsuarioBean.setPersona(prmPersona); 
		
		try {
			usuarioBean = usuarioService.buscarxcodperso(prmUsuarioBean); 
			if(usuarioBean!=null){
				tmpContrasena = usuarioBean.getPasswordUsuario();
				System.out.println("usuarioBean existe"); 
				 
			}
		} catch (Exception e) { 
			
		} 
	    
		return usuarioBean;
	}
	
	@RequestMapping(value = "/establecimientoModal", method = RequestMethod.POST)
	public ModelAndView establecimientoModal(@ModelAttribute("renaesBean") RenaesBean renaesBean) throws Exception {
	
		ModelAndView mav = new ModelAndView("seguridad/usuario/listado-establecimiento-modal", "command",
				new RenaesBean());
		renaesBean.setCodigoDisa("20");
		 List<CatalogoBean> lstCategoria = null;
		
		try { 
			lstCategoria = catalogo2Service.listarPorCodigoTabla("000010", 1);
		//	if (lstRenaesBean.size() == 0) {
				lstRenaesBean = renaesService.getBuscarPorFiltros(renaesBean);
		//	}

		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		
		mav.addObject("lstRenaesBean", lstRenaesBean);
		mav.addObject("lstCategoria", lstCategoria);
		return mav;
	}
	
	@RequestMapping(value = "/listarEstablecimiento", method = RequestMethod.GET)
	public @ResponseBody List<RenaesBean> listarEstablecimiento(@ModelAttribute("renaesBean") RenaesBean renaesBean)throws Exception {
		  
		 System.out.println("renaesBean nombre " + renaesBean.getNomRenaes());
		 System.out.println("renaesBean categoria " + renaesBean.getCategoria().getIdRegistro());
		 renaesBean.setCodigoDisa("20");
		try {
			lstRenaesBean = renaesService.getBuscarPorFiltros(renaesBean);
			 
		} catch (Exception e) { 
			
		} 
	
		return lstRenaesBean;
	}
 
	@RequestMapping(value = "/doGrabar", method = RequestMethod.POST)
	public ModelAndView doGrabar(@ModelAttribute("usuarioBean") UsuarioBean usuarioBean, HttpServletRequest request) {
		
		//System.out.println("lenguaBean Grabar"+lenguaBean);
		boolean sw = true;
		String clave ="";
		String nombreUsuario; 
		try {
			if (usuarioBean.getCodigo()!=null || !usuarioBean.getCodigo().equals("")) {
				this.setAuditoria(usuarioBean, request, true);
				clave = usuarioBean.getPasswordUsuario();
				if (  VO.isEmpty(usuarioBean.getPasswordUsuario())  ) {			
					usuarioBean.setPasswordUsuario(tmpContrasena); //Manteniendo la clave del usuario
				}else{
					Encrypt.init("KEY_ENCRYPT_PASS");
					String passencrypt = Encrypt.encrypt(usuarioBean.getPasswordUsuario());
					if(!tmpContrasena.equals(passencrypt)){
						//Encriptando la clave principal
						usuarioBean.setPasswordUsuario(passencrypt);
					}
				}
				sw = (usuarioService.actualizar(usuarioBean));
				
			} else {
				
				nombreUsuario= getPersonaBean().getNombres()+"."+getPersonaBean().getApellidoPaterno()+ getPersonaBean().getApellidoMaterno().substring(0,1);
				usuarioBean.setNombreUsuario(nombreUsuario);
				System.out.println("nombreUsuario " + nombreUsuario);
				
				this.setAuditoria(usuarioBean, request, false);
				clave = usuarioBean.getPasswordUsuario();
				//Encriptando la clave
				Encrypt.init("KEY_ENCRYPT_PASS");
				usuarioBean.setPasswordUsuario(Encrypt.encrypt(usuarioBean.getPasswordUsuario()));
				sw =  (usuarioService.insertar(usuarioBean)); 
				
			}

		} catch (Exception e) { 
			e.printStackTrace();
		}
		System.out.println("usuarioService sw " + sw);
		if (sw) {
			UsuarioBean objUsuarioBean = new UsuarioBean() ;
			try {
				objUsuarioBean = usuarioService.buscarxcodperso(usuarioBean);
				if (objUsuarioBean != null) {
					System.out.println("objUsuarioBean " + objUsuarioBean.getCodigo());
				}
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			ModelAndView mav = new ModelAndView("seguridad/usuario/registro-usuario", "command",objUsuarioBean);
			mav.addObject("usuarioBean", objUsuarioBean);
			try {
				lstDocumento = catalogo2Service.listarPorCodigoTabla("000003", 1);
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}
			setPersonaBean(new PersonaBean());
			mav.addObject("lstDocumento", lstDocumento); 
			this.cargarComboPerfiles(mav);
			return mav;
			//return this.getLista(usuarioBean,request);
		} else {
			usuarioBean.setPasswordUsuario(clave);
			ModelAndView mav = new ModelAndView("seguridad/usuario/registro-usuario", "command",usuarioBean);
			return mav;
		}

	}
	
	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
	public @ResponseBody UsuarioBean grabar(@ModelAttribute("usuarioBean") UsuarioBean ousuarioBean, HttpServletRequest request) {
		System.out.println("grabar(@ModelAttribut" );
		UsuarioBean objUsuarioBean = new UsuarioBean() ; 
		boolean sw = true;
		String clave ="";
		String nombreUsuario;
		System.out.println("ousuarioBean.codigo " + ousuarioBean.getCodigo().toString());
		System.out.println("ousuarioBean.getNombreUsuario " + ousuarioBean.getNombreUsuario());
		System.out.println("ousuarioBean.getPersona " + this.getPersonaBean());
		try {
			
			if (ousuarioBean.getCodigo()!=null && !ousuarioBean.getCodigo().equals("")) {
		
				System.out.println("ousuarioBean22.codigo " + ousuarioBean.getCodigo().toString());
				System.out.println("método usuarioBean actualizar " + ousuarioBean);
				this.setAuditoria(ousuarioBean, request, false);
				clave = ousuarioBean.getPasswordUsuario();	
				sw = (usuarioService.actualizar(ousuarioBean));
			} else {
				
				if(this.getPersonaBean().getCodigo().trim().equals("")){
					if (personaService.insertar(getPersonaBean())) {
						System.out.println("getPersonaBean().getCodigo() nuevo " + getPersonaBean().getCodigo());
						ousuarioBean.getPersona().setCodigo(getPersonaBean().getCodigo());
					}
				}
				nombreUsuario= getPersonaBean().getNombres().substring(0,1)+getPersonaBean().getApellidoPaterno()+ getPersonaBean().getApellidoMaterno().substring(0,1);
				 
				System.out.println("método usuarioBean insertar " + ousuarioBean);
				ousuarioBean.setNombreUsuario(stripAccents(nombreUsuario)); 
				ousuarioBean.setPersona(getPersonaBean());
				System.out.println("stripAccents(nombreUsuario); " + stripAccents(nombreUsuario));
				 
				System.out.println("nombreUsuario " + nombreUsuario);
				this.setAuditoria(ousuarioBean, request, true);
				clave = ousuarioBean.getPasswordUsuario();
				//Encriptando la clave
				Encrypt.init("KEY_ENCRYPT_PASS");
				ousuarioBean.setPasswordUsuario(Encrypt.encrypt(ousuarioBean.getPasswordUsuario()));
				sw =  (usuarioService.insertar(ousuarioBean)); 
				
			}

		} catch (Exception e) { 
			e.printStackTrace();
		}
		System.out.println("usuarioService sw " + sw);
		if (sw) {
			
			try {
				//objUsuarioBean = usuarioService.buscarxcodperso(ousuarioBean);
				objUsuarioBean = usuarioService.buscarxcodigousua(ousuarioBean);
				if (objUsuarioBean != null) {
					System.out.println("objUsuarioBean " + objUsuarioBean.getCodigo());
					
				}
			} catch (ServiceException e) { 
				e.printStackTrace();
			}  
			return objUsuarioBean; 
		} else { 
			return new UsuarioBean();
		}

	}
	

private static final String ORIGINAL
        = "ÁáÉéÍíÓóÚúÑñÜü";
private static final String REPLACEMENT
        = "AaEeIiOoUuNnUu";

public static String stripAccents(String str) {
    if (str == null) {
        return null;
    }
    char[] array = str.toCharArray();
    for (int index = 0; index < array.length; index++) {
        int pos = ORIGINAL.indexOf(array[index]);
        if (pos > -1) {
            array[index] = REPLACEMENT.charAt(pos);
        }
    }
    return new String(array);
}

	@RequestMapping(value = "/asignar", method = RequestMethod.POST)
	public ModelAndView dAsignar(@ModelAttribute("usuarioBean") UsuarioBean usuarioBean) {
		
		//System.out.println("lenguaBean Grabar"+lenguaBean);
		List<UsuarioBean> lstUsuario = new ArrayList<UsuarioBean>();
		boolean sw = true;
		UsuarioBean oUsuarioBean = new UsuarioBean();
		try {
			if (usuarioBean.getCodigoUsuario()!=null && !usuarioBean.getCodigoUsuario().equals("")) {
				//sw = (usuarioService.actualizar(usuarioBean));
			} else {
				usuarioBean.setNombreUsuario(usuarioBean.getPersona().getNroDocumento());
				
				//usuarioBean.setPasswordUsuario(usuarioBean.getPersona().getNumeroDocumento());
				Encrypt.init("KEY_ENCRYPT_PASS");
				usuarioBean.setPasswordUsuario(Encrypt.encrypt(usuarioBean.getPersona().getNroDocumento()));
				
				sw =  (usuarioService.insertar(usuarioBean)); 
				
				if(sw){
					oUsuarioBean = usuarioService.buscarxcodperso(usuarioBean); 
					if(oUsuarioBean!=null && !usuarioBean.getCodigoUsuario().equals("")){
					//	oUsuarioBean = lstUsuario.get(0);
						tmpContrasena = oUsuarioBean.getPasswordUsuario();//Guardando la contrasena en una variable temporal.
						if(oUsuarioBean.getPersona()!=null){
							oUsuarioBean.setPersona(personaService.buscarxTipoDocumentoNumeroDocumento(oUsuarioBean.getPersona()));
						}
					}else{
						oUsuarioBean = new UsuarioBean();
					}
				}
				
				
			}

		} catch (Exception e) { 
			e.printStackTrace();
		}

		/*if (sw) {
			usuarioBean = new UsuarioBean() ;
			return this.getLista(usuarioBean);
		} else {*/
			ModelAndView mav = new ModelAndView("seguridad/usuario/registro-usuario", "command",oUsuarioBean);
			mav.addObject("usuarioBean", oUsuarioBean);
			mav.addObject("lstUsuarioPerfil", new ArrayList<UsuarioPerfilBean>());
			this.cargarCombos(mav);
			this.cargarComboPerfiles(mav);
			return mav;
		//}

	}
	
	@RequestMapping(value = "/asignarPerfil", method = RequestMethod.POST)
	public ModelAndView dAsignarPerfil(@ModelAttribute("usuarioBean") UsuarioBean usuarioBean) {
		
		//System.out.println("lenguaBean Grabar"+lenguaBean);
		List<UsuarioPerfilBean> lstUsuarioPerfil = new ArrayList<UsuarioPerfilBean>();
		List<UsuarioBean> lstUsuario = new ArrayList<UsuarioBean>();
		boolean sw = true;
		 
		UsuarioBean OUsuarioBean = new UsuarioBean();
		try {
			
			UsuarioPerfilBean usuarioPerfilBean = new UsuarioPerfilBean();
			usuarioPerfilBean.setUsuario(new UsuarioBean());
			usuarioPerfilBean.getUsuario().setCodigoUsuario(usuarioBean.getCodigoUsuario());
			usuarioPerfilBean.setPerfil(new PerfilBean());
			usuarioPerfilBean.getPerfil().setCodigoPerfil(usuarioBean.getCodigoPerfil());
			usuarioPerfilBean.setIdUsuarioRegistro(usuarioBean.getIdUsuarioRegistro());
			usuarioPerfilBean.setIpRegistro(usuarioBean.getIpRegistro());
			
			sw = usuarioPerfilService.insertar(usuarioPerfilBean);
			UsuarioBean bean = new UsuarioBean();
			
			bean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
			
			OUsuarioBean = usuarioService.buscarxcodigousua(bean);
			if(OUsuarioBean!=null ){
				//OUsuarioBean = lstUsuario.get(0);
				tmpContrasena = OUsuarioBean.getPasswordUsuario();//Guardando la contrasena en una variable temporal.
				if(OUsuarioBean.getPersona()!=null){
					OUsuarioBean.setPersona(personaService.buscarxTipoDocumentoNumeroDocumento(OUsuarioBean.getPersona()));
				}
			}
			if (sw) {
				UsuarioPerfilBean filtroUP = new UsuarioPerfilBean();
				filtroUP.setUsuario(new UsuarioBean());
				filtroUP.getUsuario().setCodigoUsuario(OUsuarioBean.getCodigoUsuario());
				lstUsuarioPerfil =usuarioPerfilService.getBuscarPorFiltros(filtroUP);
			} else {
				
				
			}

		} catch (Exception e) { 
			e.printStackTrace();
		}

		/*if (sw) {
			usuarioBean = new UsuarioBean() ;
			return this.getLista(usuarioBean);
		} else {*/
			ModelAndView mav = new ModelAndView("seguridad/usuario/registro-usuario", "command",OUsuarioBean);
			mav.addObject("usuarioBean", OUsuarioBean);
			mav.addObject("lstUsuarioPerfil", lstUsuarioPerfil);
			this.cargarCombos(mav);
			this.cargarComboPerfiles(mav);
			return mav;
		//}

	}
	
	@RequestMapping(value = "/eliminar", method = RequestMethod.GET)
	public ModelAndView doEliminar(@RequestParam("index") int index,
			 HttpServletRequest request) {
		
		System.out.println("codigo eliminar usuario:: " + index);
		boolean sw = true; 
		
		try {
			this.setAuditoria(usuarioBean, request, false);  
			 sw = (usuarioService.eliminar(this.lstUsuarioBean.get(index-1)));
			 

		} catch (Exception e) { 
			e.printStackTrace();
		} 
		  usuarioBean = new UsuarioBean() ;
			return this.getLista(usuarioBean,request); 
	}
 
	@RequestMapping(value = "/asignarAlmacen", method = RequestMethod.GET)
	public @ResponseBody List<UsuarioAlmacenBean> asignarAlmacen(
			@RequestParam("codigoUsuario") String codigoUsuario,
			@RequestParam("idAlmacen") String idAlmacen,
			HttpServletRequest request
			)throws Exception { 
		
		
			AlmacenBean objAlmacenBean = new AlmacenBean();
			objAlmacenBean.setCodigo(idAlmacen);
			UsuarioAlmacenBean bean = new UsuarioAlmacenBean();
			bean.getUsuario().setCodigo(codigoUsuario);
			bean.setAlmacen(objAlmacenBean);
			this.setAuditoria(bean, request, true); 
			usuarioAlmacenService.insertar(bean);
			try {
				lstUsuarioAlmacenBean = usuarioAlmacenService.getBuscarPorFiltros(bean); 
			} catch (ServiceException e) { 
				e.printStackTrace();
			}
			 
			return lstUsuarioAlmacenBean; 
	}
	
	@RequestMapping(value = "/listarUsuario", method = RequestMethod.GET)
	public @ResponseBody List<UsuarioBean> refrescarListaPerfil()throws Exception { 
		UsuarioBean bean = new UsuarioBean();
		List<UsuarioBean> lstPerfilBean =new ArrayList<UsuarioBean>(); 
		try {
			lstPerfilBean = usuarioService.getBuscarPorFiltros(bean);
			 
		} catch (ServiceException e) {
			
			e.printStackTrace();
		}
		 
			return lstPerfilBean; 
	}
	
	@RequestMapping(value = "/buscarPersona", method = RequestMethod.POST)
	public ModelAndView doObtenerPersona(@ModelAttribute("usuarioBean") UsuarioBean bean) {
			
		
			PersonaBean rslPersonaBean =new PersonaBean(); 
			List<UsuarioBean> lstUsuarioBean = new ArrayList<UsuarioBean>();
			List<UsuarioPerfilBean> lstUsuarioPerfil = new ArrayList<UsuarioPerfilBean>();
			UsuarioBean oUsuarioBean =  new UsuarioBean();
			try {
 				rslPersonaBean = personaService.buscarxTipoDocumentoNumeroDocumento(bean.getPersona());
				if(rslPersonaBean != null){
					UsuarioBean filtro = new UsuarioBean();
					
					filtro.setPersona(new PersonaBean());
					filtro.getPersona().setCodigo(rslPersonaBean.getCodigo());
					
					oUsuarioBean = usuarioService.buscarxcodperso(filtro);
					if(oUsuarioBean!=null ){
						//usuarioBean = lstUsuarioBean.get(0);
						tmpContrasena = oUsuarioBean.getPasswordUsuario();//Guardando la contrasena en una variable temporal.
						oUsuarioBean.setPersona(rslPersonaBean);
						UsuarioPerfilBean filtroUP = new UsuarioPerfilBean();
						filtroUP.setUsuario(new UsuarioBean());
						filtroUP.getUsuario().setCodigoUsuario(oUsuarioBean.getCodigoUsuario());
						lstUsuarioPerfil = usuarioPerfilService.getBuscarPorFiltros(filtroUP);
					}else{
						oUsuarioBean = new UsuarioBean();
						oUsuarioBean.setPersona(rslPersonaBean);
					}
				}
			} catch (ServiceException e) {
				
				e.printStackTrace();
			}
			
		
		
		ModelAndView mav = new ModelAndView("seguridad/usuario/registro-usuario", "command",oUsuarioBean);
		mav.addObject("usuarioBean", oUsuarioBean);
		mav.addObject("lstUsuarioPerfil", lstUsuarioPerfil);
		this.cargarCombos(mav);
		this.cargarComboPerfiles(mav);
		return mav;
	}
	
 
	@RequestMapping(value = "/modificar", method = RequestMethod.POST)
	public ModelAndView modificar(@RequestParam("index") int index){   
		System.out.println("bean modificar "  + index);
		usuarioBean = lstUsuarioBean.get(index);  
		UsuarioAlmacenBean bean = new UsuarioAlmacenBean();
		bean.setUsuario(usuarioBean); 
		try {
			lstUsuarioAlmacenBean = usuarioAlmacenService.getBuscarPorFiltros(bean); 
			System.out.println("lstUsuarioAlmacenBean " + lstUsuarioAlmacenBean.size());
			lstAlmacenBean = almacenService.getBuscarPorFiltros(new AlmacenBean());
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		
		ModelAndView mav = new ModelAndView("seguridad/usuario/registro-usuario", "command",usuarioBean);
		mav.addObject("usuarioBean", usuarioBean);  
		mav.addObject("lstAlmacen", lstAlmacenBean); 
		mav.addObject("lstUsuarioAlmacen", lstUsuarioAlmacenBean); 
		this.cargarCombos(mav);
		this.cargarComboPerfiles(mav);
		return mav;
	}
 
	@RequestMapping(value = "/eliminarPerfil", method = RequestMethod.POST)
	public ModelAndView doEliminarPerfil(@ModelAttribute UsuarioPerfilBean bean) {
		List<UsuarioBean> lstUsuarioBean =new ArrayList<UsuarioBean>();
		List<UsuarioPerfilBean> lstUsuarioPerfil = new ArrayList<UsuarioPerfilBean>();
		if(bean.getCodigoUsuarioPerfil()!=null && bean.getCodigoUsuarioPerfil()>0){
			
			try {
				boolean result = usuarioPerfilService.eliminar(bean);
				if(result){
					UsuarioBean usBean = new UsuarioBean();
					usBean.setCodigoUsuario(bean.getCodigoUsuario());
					lstUsuarioBean = usuarioService.getBuscarPorFiltros(usBean);
					
					if(lstUsuarioBean != null && lstUsuarioBean.size()>0){
						usuarioBean = (UsuarioBean)lstUsuarioBean.get(0);
						tmpContrasena = usuarioBean.getPasswordUsuario();//Guardando la contrasena en una variable temporal.
						if(usuarioBean.getPersona()!=null){
							usuarioBean.setPersona(personaService.buscarxTipoDocumentoNumeroDocumento(usuarioBean.getPersona()));
						}
						UsuarioPerfilBean filtroUP = new UsuarioPerfilBean();
						filtroUP.setUsuario(new UsuarioBean());
						filtroUP.getUsuario().setCodigoUsuario(usuarioBean.getCodigoUsuario());
						lstUsuarioPerfil = usuarioPerfilService.getBuscarPorFiltros(filtroUP);
					}
				}
				
			} catch (ServiceException e) {
				
				e.printStackTrace();
			}
			
		}else{
			usuarioBean = new UsuarioBean();
		}
		
		ModelAndView mav = new ModelAndView("seguridad/usuario/registro-usuario", "command",usuarioBean);
		mav.addObject("usuarioBean", usuarioBean);
		mav.addObject("lstUsuarioPerfil", lstUsuarioPerfil);
		this.cargarCombos(mav);
		this.cargarComboPerfiles(mav);
		return mav;
	}
	
	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	public @ResponseBody String doCambiarPassword(@ModelAttribute("usuarioBean") UsuarioBean usuarioBean,
			HttpServletRequest request) {
		 
		Integer sw = -1;
		String newPass ="";
		try {
			//usuarioBean.setNewPassword(usuarioBean.getNombreUsuario());
			System.out.println("usuarioBean " + usuarioBean.getCodigo());
			System.out.println("usuarioBean.getPersona().getNroDocumento() " + usuarioBean.getPersona().getNroDocumento()) ;
			Encrypt.init("KEY_ENCRYPT_PASS");
			usuarioBean.setNewPassword(Encrypt.encrypt(usuarioBean.getPersona().getNroDocumento()));
			this.setAuditoria(usuarioBean, request, false);
			usuarioBean.setFlgRestPass("1");
			sw = usuarioService.cambiarPassword(usuarioBean);
			UsuarioBean bean = new UsuarioBean();
			bean.setCodigoUsuario(usuarioBean.getCodigoUsuario());  
			if (sw==1) {
				newPass = usuarioBean.getPasswordUsuario();
			} else{
				newPass ="";
				
			}

		} catch (Exception e) { 
			e.printStackTrace();
		}

		return newPass ;
	}
	
	
	
	@RequestMapping(value = "/cambiarPassUsuario", method = RequestMethod.GET)
	public ModelAndView doCambiarPassInicio(HttpServletRequest request) {
		UsuarioBean usuario = this.getUsuarioSesion(request);
		ModelAndView mav = new ModelAndView("seguridad/usuario/cambiar-contrasenia-usuario", "command",usuario);
		//mav.addObject("lstSituacion",lstSituacion);
		mav.addObject("usuarioBean",usuario);
		
		return mav;
	}
	
	@RequestMapping(value = "/cambiarPass", method = RequestMethod.POST)
	public ModelAndView doCambiarPass(@ModelAttribute("usuarioBean") UsuarioBean usuarioBean,
			BindingResult result, 
			SessionStatus status,
			HttpServletRequest request){
		 
		System.out.println("cambiarPass " ); 
				Integer sw = -1;
				String msg="";
				String oldPass = "";
				String newPass = "";
				try {
					UsuarioBean usuario = this.getUsuarioSesion(request); 
					if(usuario.getCodigo().equals("")){
						usuario = usuarioBean; 
						System.out.println("NO INICIA SESSION");
						//usuario.setPasswordUsuario(Encrypt.encrypt(usuarioBean.getPasswordUsuario()));
						oldPass = usuario.getOldPassword();
					}else{
						System.out.println("SESSION INICIADA");
						
						oldPass = usuario.getPasswordUsuario();
						System.out.println(" old getPasswordUsuario " + usuario.getPasswordUsuario());
					}
					
					
					System.out.println("usuario.getperiodo " + usuario.getNumeroPeriodo());
					System.out.println("usuario.getCodigoUsuario() " + usuario.getCodigoUsuario());
					usuario.setFlgRestPass("0");
					Encrypt.init("KEY_ENCRYPT_PASS");
					
					newPass = usuario.getNewPassword();
					usuario.setPasswordUsuario(Encrypt.encrypt(usuarioBean.getPasswordUsuario()));
					usuario.setNewPassword(Encrypt.encrypt(usuarioBean.getNewPassword()));
					
					System.out.println("usuarioBean.getPasswordUsuario() " + usuarioBean.getPasswordUsuario());
					System.out.println("usuario.getPasswordUsuario() " + usuario.getPasswordUsuario());
					
					System.out.println("oldPass " + oldPass);
					if(!oldPass.equals(usuario.getPasswordUsuario()) ){
						sw = 0;
					}else{
						
						sw = usuarioService.cambiarPassword(usuario);
					}
					
					
					if (sw==1) {
						HttpSession session = request.getSession();
						
						session.removeAttribute("usuarioSesion");
						session.invalidate();
						LoginVo prmLogin = new LoginVo();
						ModelAndView mav =   new ModelAndView("seguridad/login/login-admin", "command",prmLogin); 
						cargarComboAlmacen(mav);
						
						return mav;
					} else if(sw==0){
						usuarioBean.setPasswordUsuario("");
						usuarioBean.setNewPassword("");
						msg= "No se cambió la contraseña,<br> "
								+ "La contrase&ntilde;a ingresada no coincide con la actual";
					}else{
						//usuarioBean.setPasswordUsuario(oldPass);
						usuarioBean.setNewPassword("");
						msg= "No se restablecio contraseña, "
								+ "por favor coordine con el administrador del sistema";
					}

				} catch (Exception e) { 
					e.printStackTrace();
				}

				
				ModelAndView mav = new ModelAndView("seguridad/usuario/cambiar-contrasenia-usuario", "command",usuarioBean);
				mav.addObject("usuarioBean", usuarioBean);
				mav.addObject("msgError",msg);
				this.cargarCombos(mav);
				this.cargarComboPerfiles(mav);
				return mav;
				
	}
	
	private ModelAndView getLista(UsuarioBean usuarioBean, HttpServletRequest request) {
		
		 lstUsuarioBean =new ArrayList<UsuarioBean>(); 
		try {
			lstUsuarioBean =  usuarioService.getBuscarPorFiltros(usuarioBean);
			System.out.println("getLista size " + lstUsuarioBean.size());
		} catch (Exception e) {
			System.out.println("getLista " + e.getMessage());
		}

		ModelAndView mav = new ModelAndView("seguridad/usuario/listado-usuario", "command",usuarioBean);
		
		mav.addObject("lstUsuarioBean", lstUsuarioBean);
		//this.cargarCombos(mav);
		this.cargarComboPerfiles(mav);
		return mav;
	}

	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("usuarioBean") UsuarioBean usuarioBean,
			HttpServletRequest request)
			throws Exception { 
		return this.getLista(usuarioBean, request);
	}
	
	private void cargarCombos(ModelAndView mav){ 
 
			try {
				lstDocumento = catalogo2Service.listarPorCodigoTabla("000003", 1); 
				
			} catch (ServiceException e) {
				e.printStackTrace();
			}	 
	
		mav.addObject("lstDocumento",lstDocumento); 
	}  
	
	private void cargarComboPerfiles(ModelAndView mav){
		perfilBean = new PerfilBean();
		if (lstPerfiles==null) {
			try {
				lstPerfiles = perfilService.getBuscarPorFiltros(perfilBean);
			} catch (ServiceException e) {
				e.printStackTrace();
			}		
		}
  
		mav.addObject("lstPerfiles",lstPerfiles); 
	}  
	
	private void cargarComboAlmacen(ModelAndView mav){
		AlmacenBean almacenBean = new AlmacenBean();
		 
			try {
				lstAlmacenBean = almacenService.getBuscarPorFiltros(almacenBean);
			} catch (ServiceException e) {
				e.printStackTrace(); 	
		}
  
		mav.addObject("lstAlmacenBean",lstAlmacenBean); 
	}  
	
	@RequestMapping(value = "/eliminarAlmacen", method = RequestMethod.GET)
	public @ResponseBody String eliminarAlmacen(@RequestParam("codigo") String codigo,
			 HttpServletRequest request) {
		String valida= "";
		System.out.println("codigo eliminarPerfil:: " + codigo);
		boolean sw = true; 
		UsuarioAlmacenBean usuarioBean = new UsuarioAlmacenBean();
		usuarioBean.setCodigo(codigo);
		try {
			this.setAuditoria(usuarioBean, request, false);  
			 sw = (usuarioAlmacenService.eliminar(usuarioBean));
			 

		} catch (Exception e) { 
			e.printStackTrace();
		}  
		return valida;
	}

	@RequestMapping(value = "/listarUsuarioAlmacen", method = RequestMethod.GET)
	public @ResponseBody List<UsuarioAlmacenBean> listarUsuarioAlmacen(
			@RequestParam("codigoUsuario") String codigoUsuario,
			HttpServletRequest request
			)throws Exception { 
		 
			UsuarioAlmacenBean bean = new UsuarioAlmacenBean();
			bean.getUsuario().setCodigo(codigoUsuario);   
			
			try {
				lstUsuarioAlmacenBean = usuarioAlmacenService.getBuscarPorFiltros(bean); 
			} catch (ServiceException e) { 
				e.printStackTrace();
			}
			 
			return lstUsuarioAlmacenBean; 
	}
	
	@RequestMapping(value = "/turnoModal", method = RequestMethod.POST)
	public ModelAndView turnoModal(@RequestParam("index") int index,
			 HttpServletRequest request) throws Exception {
		
		List<UsuarioAlmacenTurnoBean> lstTurnoAlmacen = new ArrayList<UsuarioAlmacenTurnoBean>();
		
		UsuarioAlmacenTurnoBean objUsuarioAlmacenTurno = new  UsuarioAlmacenTurnoBean();
		objUsuarioAlmacenTurno.setUsuarioAlmacen(lstUsuarioAlmacenBean.get(index));
		
		ModelAndView mav = new ModelAndView("seguridad/usuario/turno-modal", "command",  objUsuarioAlmacenTurno); 
		
		lstTurnoAlmacen = usuarioAlmacenTurnoService.getBuscarPorFiltros(objUsuarioAlmacenTurno);
		mav.addObject("lstTurnoAlmacen", lstTurnoAlmacen); 
		mav.addObject("usuarioAlmacenTurno", objUsuarioAlmacenTurno); 
		return mav;
	} 
	
	@RequestMapping(value = "/grabarTurnoAlmacen", method = RequestMethod.GET)
	public @ResponseBody String grabarTurnoAlmacen(
			@RequestParam("dia") String dia,@RequestParam("tarde") String tarde,
			@RequestParam("noche") String noche,@RequestParam("idUsuarioAlmacen") String idUsuarioAlmacen,
			HttpServletRequest request
			)throws Exception { 
		
			String codigo = "";
			System.out.println("dia " + dia);
			System.out.println("idUsuarioAlmacen" + idUsuarioAlmacen);
			UsuarioAlmacenTurnoBean bean = new UsuarioAlmacenTurnoBean();
			bean.getUsuarioAlmacen().setCodigo(idUsuarioAlmacen);   
			
			try {
				this.setAuditoria(bean, request, true);
				bean.getTurno().setCodigo("0001");
				bean.setEstadoTurno(dia);
				usuarioAlmacenTurnoService.insertar(bean) ;
				bean.getTurno().setCodigo("0002");
				bean.setEstadoTurno(tarde);
				usuarioAlmacenTurnoService.insertar(bean) ;
				bean.getTurno().setCodigo("0003");
				bean.setEstadoTurno(noche);
				usuarioAlmacenTurnoService.insertar(bean) ;
			} catch (ServiceException e) { 
				e.printStackTrace();
			}
			 
			return codigo; 
	}
	
	
	public UsuarioBean getUsuarioBean() {
		return usuarioBean;
	}

	public void setUsuarioBean(UsuarioBean usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	public PersonaBean getPersonaBean() {
		return personaBean;
	}

	public void setPersonaBean(PersonaBean personaBean) {
		this.personaBean = personaBean;
	}

	public PersonaService getPersonaService() {
		return personaService;
	}

	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}

	public List<RenaesBean> getLstRenaesBean() {
		return lstRenaesBean;
	}

	public void setLstRenaesBean(List<RenaesBean> lstRenaesBean) {
		this.lstRenaesBean = lstRenaesBean;
	}
	
}
