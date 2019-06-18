package hnch.referencia.web.controller.seguridad;

import hnch.referencia.core.bean.general.TablaBean;
import hnch.referencia.core.bean.general.PacienteBean;
import hnch.referencia.core.bean.general.PersonaBean;
import hnch.referencia.core.bean.general.RenaesBean;
import hnch.referencia.core.bean.seguridad.PerfilBean;
import hnch.referencia.core.bean.seguridad.UsuarioBean;
import hnch.referencia.core.bean.seguridad.UsuarioPerfilBean;
import hnch.referencia.core.bean.seguridad.UsuarioRenaesBean;
import hnch.referencia.core.service.exception.ServiceException;
import hnch.referencia.core.service.interfaces.asistencial.maestra.MaestraAsis14Service;
import hnch.referencia.core.service.interfaces.general.Maestra1Service;
import hnch.referencia.core.service.interfaces.general.PersonaService;
import hnch.referencia.core.service.interfaces.general.RenaesService;
import hnch.referencia.core.service.interfaces.seguridad.PerfilService;
import hnch.referencia.core.service.interfaces.seguridad.UsuarioPerfilService;
import hnch.referencia.core.service.interfaces.seguridad.UsuarioRenaesService;
import hnch.referencia.core.service.interfaces.seguridad.UsuarioService;
import hnch.referencia.web.controller.base.BaseController;
import hnch.referencia.web.utilitarios.VO;
import hnch.referencia.web.utilitarios.acceso.LoginVo;
import hnch.referencia.web.utilitarios.encrypt.Encrypt;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

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

import com.itextpdf.text.log.SysoCounter;

import gob.hnch.systems.ws.hnch.client.imp.PersonaServiceImp;
 
@Controller
@Scope(value="session")
@RequestMapping(value = "usuarioController")
public class UsuarioController extends BaseController{
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	UsuarioRenaesService usuarioRenaesService;
	
	@Autowired
	UsuarioPerfilService usuarioPerfilService;
	
	@Autowired 
	private PersonaService personaService;
	
	@Autowired
	private Maestra1Service 	maestra1Service;
	
	@Autowired
	PerfilService perfilService;
	
	@Autowired
	private MaestraAsis14Service maestraAsis14Service;

	@Autowired
	private RenaesService renaesService;
	
	private PersonaBean personaBean; 
	private UsuarioBean usuarioBean;
	private PerfilBean perfilBean;
	private List<TablaBean>	lstSituacion;
	private List<TablaBean>	lstTipoDocumento;
	private List<PerfilBean>	lstPerfiles;
	List<TablaBean> lstDocumento = new ArrayList<TablaBean>();
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
			lstDocumento = maestraAsis14Service.listarPorCodigoTabla("000003", 1);
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		setPersonaBean(new PersonaBean());
		mav.addObject("lstDocumento", lstDocumento); 
		this.cargarComboPerfiles(mav);
		return mav;
	}
	
	@RequestMapping(value = "/consultarPorDocumentoPersona", method = RequestMethod.GET)
	public @ResponseBody PersonaBean consultarPorNroDocumento(@RequestParam("tipoDocumento") String tipoDocumento,@RequestParam("numero") String numero)throws Exception {
		  
		personaBean = new PersonaBean();
		PersonaBean prmPersona = new PersonaBean();
		prmPersona.setNroDocumento(numero);
		prmPersona.getTipoDocumento().setCodReg(tipoDocumento);
		
		try {
			personaBean = this.getPersonaService().buscarxTipoDocumentoNumeroDocumento(prmPersona); 
			if(personaBean!=null){
				System.out.println("persona existe en reco.persona");
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
						personaBean.setPrimerNombre(perso.getPrenomInscrito());
						personaBean.setNroDocumento(perso.getNuDNI());
						personaBean.getTipoDocumento().setCodReg("000001");
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
							personaBean.getSexo().setCodReg("000002"); 
						}else{
							personaBean.getSexo().setCodReg("000001"); 
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
		 List<TablaBean> lstCategoria = null;
		
		try { 
			lstCategoria = maestraAsis14Service.listarPorCodigoTabla("000010", 1);
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
		 System.out.println("renaesBean categoria " + renaesBean.getCategoria().getCodReg());
		 renaesBean.setCodigoDisa("20");
		try {
			lstRenaesBean = renaesService.getBuscarPorFiltros(renaesBean);
			 
		} catch (Exception e) { 
			
		} 
	
		return lstRenaesBean;
	}
	
	@RequestMapping(value = "/listUsuarioRenaesBean", method = RequestMethod.GET)
	public @ResponseBody List<UsuarioRenaesBean> listUsuarioRenaesBean(@RequestParam("codigoUsuario") String codigoUsuario)throws Exception {
		  
		List<UsuarioRenaesBean> lstUsuarioRenaesBean = null;
		UsuarioBean prmUsuarioBean = new UsuarioBean();
		prmUsuarioBean.setCodigo(codigoUsuario);  
		
		try {
			lstUsuarioRenaesBean = usuarioRenaesService.buscarxcodigousua(prmUsuarioBean); 
			 
		} catch (Exception e) { 
			
		} 
	
		return lstUsuarioRenaesBean;
	}
	@RequestMapping(value = "/doGrabarUsuarioRenaes", method = RequestMethod.GET)
	public @ResponseBody String doGrabarUsuarioRenaes(@RequestParam("codigoUsuario") String codigoUsuario,
										@RequestParam("codigoRenaes") String codigoRenaes,
										@RequestParam("codigoPersona") String codigoPersona,
			HttpServletRequest request) {
		System.out.println("doGrabarUsuarioRenaes");
		UsuarioRenaesBean usuarioRenaesBean = new UsuarioRenaesBean();
		usuarioRenaesBean.getUsuario().setCodigo(codigoUsuario);
		usuarioRenaesBean.getUsuario().getPersona().setCodigo(codigoPersona);
		usuarioRenaesBean.getRenaes().setCodigo(codigoRenaes);
		String codigo = "";
		
		boolean sw = false;
		try {
			this.setAuditoria(usuarioRenaesBean, request, true);
			sw = this.usuarioRenaesService.insertar(usuarioRenaesBean);
			if(sw){
				codigo = usuarioRenaesBean.getCodigo();
			}
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		
		return codigo;
	}
	
	@RequestMapping(value = "/doGrabar", method = RequestMethod.POST)
	public ModelAndView doGrabar(@ModelAttribute("usuarioBean") UsuarioBean usuarioBean, HttpServletRequest request) {
		
		//System.out.println("lenguaBean Grabar"+lenguaBean);
		boolean sw = true;
		String clave ="";
		String nombreUsuario; 
		
		System.out.println("usuarioBean.getCodigoOrganizacion  " + usuarioBean.getCodigoOrganizacion());
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
				
				nombreUsuario= getPersonaBean().getPrimerNombre()+"."+getPersonaBean().getApellidoPaterno()+ getPersonaBean().getApellidoMaterno().substring(0,1);
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
				lstDocumento = maestraAsis14Service.listarPorCodigoTabla("000003", 1);
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
	public @ResponseBody UsuarioBean grabar(@ModelAttribute("usuarioBean") UsuarioBean usuarioBean, HttpServletRequest request) {
		System.out.println("grabar(@ModelAttribut" );
		UsuarioBean objUsuarioBean = new UsuarioBean() ; 
		boolean sw = true;
		String clave ="";
		String nombreUsuario;
		System.out.println("usuarioBean.getCodigoOrganizacion  " + usuarioBean.getCodigoOrganizacion());
		System.out.println("usuarioBean.codigo " + usuarioBean.getCodigo());
		System.out.println("usuarioBean.getNombreUsuario " + usuarioBean.getNombreUsuario());
		System.out.println("usuarioBean.getPersona " + this.getPersonaBean());
		try {
			if (!usuarioBean.getCodigo().trim().equals("")) {
				System.out.println("método usuarioBean actualizar " + usuarioBean);
				this.setAuditoria(usuarioBean, request, false);
				clave = usuarioBean.getPasswordUsuario();
				/**if (  VO.isEmpty(usuarioBean.getPasswordUsuario())  ) {			
					usuarioBean.setPasswordUsuario(tmpContrasena); //Manteniendo la clave del usuario
				}else{
					Encrypt.init("KEY_ENCRYPT_PASS");
					String passencrypt = Encrypt.encrypt(usuarioBean.getPasswordUsuario());
					if(!tmpContrasena.equals(passencrypt)){
						//Encriptando la clave principal
						usuarioBean.setPasswordUsuario(passencrypt);
					}
				}*/
				sw = (usuarioService.actualizar(usuarioBean));
			} else {
				
				if(this.getPersonaBean().getCodigo().trim().equals("")){
					if (personaService.insertar(getPersonaBean())) {
						System.out.println("getPersonaBean().getCodigo() nuevo " + getPersonaBean().getCodigo());
						usuarioBean.getPersona().setCodigo(getPersonaBean().getCodigo());
					}
				}
				nombreUsuario= getPersonaBean().getPrimerNombre()+"."+getPersonaBean().getApellidoPaterno()+ getPersonaBean().getApellidoMaterno().substring(0,1);
				 
				System.out.println("método usuarioBean insertar " + usuarioBean);
				usuarioBean.setNombreUsuario(stripAccents(nombreUsuario));
				System.out.println("stripAccents(nombreUsuario); " + stripAccents(nombreUsuario));
				 
				System.out.println("nombreUsuario " + nombreUsuario);
				this.setAuditoria(usuarioBean, request, true);
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
			
			try {
				objUsuarioBean = usuarioService.buscarxcodperso(usuarioBean);
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
			usuarioPerfilBean.setCodigoUsuarioCreacion(usuarioBean.getCodigoUsuarioCreacion());
			usuarioPerfilBean.setAudHostIP(usuarioBean.getAudHostIP());
			
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
	public ModelAndView doEliminar(@RequestParam("codigo") String codigo,
			 HttpServletRequest request) {
		
		System.out.println("codigo eliminarPerfil:: " + codigo);
		boolean sw = true; 
		UsuarioBean usuarioBean = new UsuarioBean();
		usuarioBean.setCodigo(codigo);
		try {
			this.setAuditoria(usuarioBean, request, false);  
			 sw = (usuarioService.eliminar(usuarioBean));
			 

		} catch (Exception e) { 
			e.printStackTrace();
		} 
		  usuarioBean = new UsuarioBean() ;
			return this.getLista(usuarioBean,request); 
	}
	
	@RequestMapping(value = "/eliminarRenaes", method = RequestMethod.GET)
	public @ResponseBody String eliminarRenaes(@RequestParam("codigo") String codigo,
			 HttpServletRequest request) {
		
		String valida ="";
		System.out.println("codigo eliminarPerfil:: " + codigo);
		boolean sw = true; 
		UsuarioRenaesBean usuarioBean = new UsuarioRenaesBean();
		usuarioBean.setCodigo(codigo);
		try {
			this.setAuditoria(usuarioBean, request, false);  
			 sw = (usuarioRenaesService.eliminar(usuarioBean));
			 

		} catch (Exception e) { 
			e.printStackTrace();
		}  
		return valida;
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
	public ModelAndView modificar(@RequestParam("codigo") String codigoUsuario){ //doObtener(@ModelAttribute("usuarioBean") UsuarioBean bean) {
		UsuarioBean ousuarioBean = new UsuarioBean();
		System.out.println("bean modificar "  + codigoUsuario);
		ousuarioBean.setCodigo(codigoUsuario); 
		ousuarioBean.setCodigoUsuario(codigoUsuario); 
		UsuarioBean usuarioBean = new UsuarioBean(); 
		List<UsuarioRenaesBean> lstUsuarioRenaesBean = null;	
			try {
				//lstUsuarioBean = usuarioService.getBuscarPorFiltros(bean);
				usuarioBean = usuarioService.buscarxcodigousua(ousuarioBean); 
				if(usuarioBean != null){ 
					System.out.println("usuarioBean nroDocumento " + usuarioBean.getPersona().getNroDocumento());
					tmpContrasena = ousuarioBean.getPasswordUsuario();//Guardando la contrasena en una variable temporal. 
					System.out.println(" usuarioBean codigo::: "  + usuarioBean.getCodigo());
					System.out.println(" usuarioBean codigoUser::: "  + usuarioBean.getCodigoUsuario());
					System.out.println(" usuarioBean obj::: "  + usuarioBean);
					this.setPersonaBean(usuarioBean.getPersona());					
					try {
						lstUsuarioRenaesBean = usuarioRenaesService.buscarxcodigousua(ousuarioBean); 
						 
					} catch (Exception e) { 
						
					}
				}else{
					System.out.println("usuario es null");
					usuarioBean = new UsuarioBean();
				}
			} catch (ServiceException e) {
				
				e.printStackTrace();
			}
		 
		
	 
		ModelAndView mav = new ModelAndView("seguridad/usuario/registro-usuario", "command",usuarioBean);
		mav.addObject("usuarioBean", usuarioBean);
		mav.addObject("swActivo", "1");
		mav.addObject("lstUsuarioRenaes", lstUsuarioRenaesBean);
		this.cargarCombos(mav);
		this.cargarComboPerfiles(mav);
		return mav;
	}
	
	@RequestMapping(value = "/modificar", method = RequestMethod.GET)
	public ModelAndView modificarGet(@RequestParam("codigo") String codigoUsuario){ //doObtener(@ModelAttribute("usuarioBean") UsuarioBean bean) {
		UsuarioBean ousuarioBean = new UsuarioBean();
		System.out.println("bean modificar "  + codigoUsuario);
		ousuarioBean.setCodigo(codigoUsuario); 
		ousuarioBean.setCodigoUsuario(codigoUsuario); 
		UsuarioBean usuarioBean = new UsuarioBean(); 
		List<UsuarioRenaesBean> lstUsuarioRenaesBean = null;	
			try {
				//lstUsuarioBean = usuarioService.getBuscarPorFiltros(bean);
				usuarioBean = usuarioService.buscarxcodigousua(ousuarioBean); 
				if(usuarioBean != null){ 
					System.out.println("usuarioBean nroDocumento " + usuarioBean.getPersona().getNroDocumento());
					tmpContrasena = ousuarioBean.getPasswordUsuario();//Guardando la contrasena en una variable temporal. 
					System.out.println(" usuarioBean codigo::: "  + usuarioBean.getCodigo());
					System.out.println(" usuarioBean codigoUser::: "  + usuarioBean.getCodigoUsuario());
					System.out.println(" usuarioBean obj::: "  + usuarioBean);
					this.setPersonaBean(usuarioBean.getPersona());					
					try {
						lstUsuarioRenaesBean = usuarioRenaesService.buscarxcodigousua(ousuarioBean); 
						 
					} catch (Exception e) { 
						
					}
				}else{
					System.out.println("usuario es null");
					usuarioBean = new UsuarioBean();
				}
			} catch (ServiceException e) {
				
				e.printStackTrace();
			}
		 
		
	 
		ModelAndView mav = new ModelAndView("seguridad/usuario/registro-usuario", "command",usuarioBean);
		mav.addObject("usuarioBean", usuarioBean);
		mav.addObject("swActivo", "1");
		mav.addObject("lstUsuarioRenaes", lstUsuarioRenaesBean);
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
						return  new ModelAndView("seguridad/login/login-admin", "command",prmLogin);
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
		
		List<UsuarioBean> lstUsuarioBean =new ArrayList<UsuarioBean>(); 
		try {
		/**	
			UsuarioBean userActual = this.getUsuarioSesion(request);
			
			if(	!VO.isNull(userActual) 
				&& !VO.isNull(userActual.getCodPerfilUsuSelec())){ 
				
			}*/
		//	usuarioBean.setAudCodigoUsuario(userActual.getCodigoUsuario());
		//	usuarioBean.setCodPerfilUsuSelec(userActual.getCodPerfilUsuSelec());
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
				lstDocumento = maestraAsis14Service.listarPorCodigoTabla("000003", 1);  
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
