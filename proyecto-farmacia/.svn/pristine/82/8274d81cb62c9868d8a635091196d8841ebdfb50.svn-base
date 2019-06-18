package hnch.referencia.web.controller.inicio;
 
import hnch.referencia.core.bean.asistencial.referencia.ReferenciaBean;
import hnch.referencia.core.bean.general.TablaBean;
import hnch.referencia.core.bean.seguridad.AccesoBean;
import hnch.referencia.core.bean.seguridad.AuditoriaAccesoBean;
import hnch.referencia.core.bean.seguridad.PerfilBean;
import hnch.referencia.core.bean.seguridad.UsuarioBean;
import hnch.referencia.core.bean.seguridad.UsuarioPerfilBean;
import hnch.referencia.core.service.exception.ServiceException;
import hnch.referencia.core.service.interfaces.asistencial.maestra.MaestraAsis14Service;
import hnch.referencia.core.service.interfaces.asistencial.referencia.ReferenciaCbService; 
import hnch.referencia.core.service.interfaces.seguridad.AccesoService;
import hnch.referencia.core.service.interfaces.seguridad.UsuarioPerfilService;
import hnch.referencia.core.service.interfaces.seguridad.UsuarioService;
import hnch.referencia.web.controller.base.BaseController; 
import hnch.referencia.web.utilitarios.NetUtil;
import hnch.referencia.web.utilitarios.VO;
import hnch.referencia.web.utilitarios.acceso.AccesoMenuVo;
import hnch.referencia.web.utilitarios.acceso.LoginVo;
import hnch.referencia.web.utilitarios.acceso.PermisoVo;
import hnch.referencia.web.utilitarios.encrypt.Encrypt;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
 
 
@Controller
@RequestMapping(value = "inicioController")
@SessionAttributes("usuarioSesion")
@Scope(value="session")
public class InicioController extends BaseController{
	
	@Autowired
	AccesoService accesoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	 
	@Autowired
	private UsuarioPerfilService usuarioPerfilService;
	
	@Autowired
	private MaestraAsis14Service maestraAsis14Service;
	
	@Autowired
	private ReferenciaCbService referenciaCbService;
	
	List<TablaBean> lstMaestra =(new ArrayList<TablaBean>()); ;
	List<TablaBean> lstSituacion = new ArrayList<TablaBean>();
	List<TablaBean> lstTipoPaciente = new ArrayList<TablaBean>();
    List<ReferenciaBean> lstReferenciaBean = new ArrayList<ReferenciaBean>();
    
	@PostConstruct
	public void init(){
		this.setLstMaestra(new ArrayList<TablaBean>()); 
	/*	this.setLenguaForm(new LenguaForm());
		this.setLstLenguaBean(new ArrayList<LenguaBean>()); 
		this.setLstLenguaEstructuraBean(new ArrayList<LenguaEstructuraBean>());  
		this.setLstLenguaNivelBean(new ArrayList<LenguaNivelBean>());
		this.setLstUnidadLeccionBean(new ArrayList<UnidadLeccionBean>());
		this.setLstUnidadBean(new ArrayList<UnidadBean>());
		this.setLstNivel(new ArrayList<TablaBean>());
		this.setLstLecciones(new ArrayList<TablaBean>());*/
	}
	
	
	@RequestMapping(value = "/controlAcceso", method = RequestMethod.GET)
	public ModelAndView loginGet(@ModelAttribute("login") LoginVo prmLogin,
		BindingResult result, SessionStatus status,
		HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		
		session.removeAttribute("usuarioSesion");
		session.invalidate();
		
		this.setUsuarioBean(new UsuarioBean());
		
		//Inicializando el Encrypt
		Encrypt.init("KEY_ENCRYPT_PASS");
		
		if (prmLogin != null) {
			UsuarioBean prmUsuario = new UsuarioBean();
			//Encriptando la clave ingresada
			prmUsuario.setPasswordUsuario(Encrypt.encrypt(prmLogin.getContrasena()));
			//prmUsuario.setPasswordUsuario(prmLogin.getContrasena());
			prmUsuario.setNombreUsuario(prmLogin.getNombreUsuario());
			
			UsuarioBean oUsuario = usuarioService.autenticar(prmUsuario);
			System.out.println("11111");
			if (oUsuario != null) {
				System.out.println("NombreUsuario "+oUsuario.getNombreUsuario());
				System.out.println("NombreUsuario persona "+oUsuario.getPersona().getNombreCompleto());
				System.out.println("Codigo "+oUsuario.getCodigo()); 
					if (!oUsuario.getEstado().trim().equals("1")) {//Activo
						
						
			//		this.registrarAudAcceso(prmLogin.getNombreUsuario(), 5, request);
					ModelAndView mav = new ModelAndView("seguridad/login/login-admin","command", prmLogin);
					mav.addObject("msgErrorLogin","Su usuario no se encuentra activo, "
							+ "por favor coordine con el administrador del sistema");
					return mav;
				}
				
				if(oUsuario.getFlgRestPass()!=null && "0".equals(oUsuario.getFlgRestPass())){
					System.out.println("oUsuario.getFlgRestPass()"+oUsuario.getFlgRestPass());
					request.getSession().setAttribute("usuarioSesion", oUsuario);
				//	oUsuario.setPasswordUsuario("");
					oUsuario.setNewPassword("");
					oUsuario.setOldPassword(oUsuario.getPasswordUsuario());
					
					ModelAndView mav = new ModelAndView("seguridad/usuario/cambiar-contrasenia-usuario", "command",oUsuario);
					mav.addObject("usuarioBean", oUsuario);
					return mav;
				}
				
				/** BUSCAR LOS PERFILES DEL USUARIO **/
				List<UsuarioPerfilBean> lstUsuarioPerfilBean = new ArrayList<UsuarioPerfilBean>();
				UsuarioPerfilBean us = new UsuarioPerfilBean();
				us.setCodigoUsuario(oUsuario.getCodigo());
				lstUsuarioPerfilBean.add(us); 
				 
				oUsuario.setCodPerfilUsuSelec(oUsuario.getPerfil().getCodigo());
				oUsuario.setLstUsuarioPerfil(lstUsuarioPerfilBean); 
				return this.getLista(oUsuario, request);
				
				
				
			} else {
				UsuarioBean tmpUsuario = new UsuarioBean();
				tmpUsuario.setNombreUsuario("NV");
				this.setUsuarioBean(tmpUsuario);
				this.registrarAudAcceso(prmLogin.getNombreUsuario(), "1", request);
				
				ModelAndView mav = new ModelAndView("seguridad/login/login-admin", "command",prmLogin);
				mav.addObject("msgErrorLogin", "El usuario y/o contraseña no coinciden");
				mav.addObject("usuarioSesion", tmpUsuario);
				return mav;
			}
		}else{
			return  new ModelAndView("seguridad/login/login-admin", "command",prmLogin);
		}
	}
	
	@RequestMapping(value = "/controlAcceso", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("login") LoginVo prmLogin,
		BindingResult result, SessionStatus status,
		HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		
		session.removeAttribute("usuarioSesion");
		session.invalidate();
		
		this.setUsuarioBean(new UsuarioBean());
		
		//Inicializando el Encrypt
		Encrypt.init("KEY_ENCRYPT_PASS");
		
		if (prmLogin != null) {
			UsuarioBean prmUsuario = new UsuarioBean();
			//Encriptando la clave ingresada
			prmUsuario.setPasswordUsuario(Encrypt.encrypt(prmLogin.getContrasena()));
			//prmUsuario.setPasswordUsuario(prmLogin.getContrasena());
			prmUsuario.setNombreUsuario(prmLogin.getNombreUsuario());
			
			UsuarioBean oUsuario = usuarioService.autenticar(prmUsuario);
			System.out.println("11111");
			if (oUsuario != null) {
				System.out.println("NombreUsuario "+oUsuario.getNombreUsuario());
				System.out.println("NombreUsuario persona "+oUsuario.getPersona().getNombreCompleto());
				System.out.println("Codigo "+oUsuario.getCodigo()); 
					if (!oUsuario.getEstado().trim().equals("1")) {//Activo
						
						
			//		this.registrarAudAcceso(prmLogin.getNombreUsuario(), 5, request);
					ModelAndView mav = new ModelAndView("seguridad/login/login-admin","command", prmLogin);
					mav.addObject("msgErrorLogin","Su usuario no se encuentra activo, "
							+ "por favor coordine con el administrador del sistema");
					return mav;
				}
				
				if(oUsuario.getFlgRestPass()!=null && "0".equals(oUsuario.getFlgRestPass())){
					System.out.println("oUsuario.getFlgRestPass()"+oUsuario.getFlgRestPass());
					request.getSession().setAttribute("usuarioSesion", oUsuario);
				//	oUsuario.setPasswordUsuario("");
					oUsuario.setNewPassword("");
					oUsuario.setOldPassword(oUsuario.getPasswordUsuario());
					
					ModelAndView mav = new ModelAndView("seguridad/usuario/cambiar-contrasenia-usuario", "command",oUsuario);
					mav.addObject("usuarioBean", oUsuario);
					return mav;
				}
				
				/** BUSCAR LOS PERFILES DEL USUARIO **/
				List<UsuarioPerfilBean> lstUsuarioPerfilBean = new ArrayList<UsuarioPerfilBean>();
				UsuarioPerfilBean us = new UsuarioPerfilBean();
				us.setCodigoUsuario(oUsuario.getCodigo());
				lstUsuarioPerfilBean.add(us); 
				 
				oUsuario.setCodPerfilUsuSelec(oUsuario.getPerfil().getCodigo());
				oUsuario.setLstUsuarioPerfil(lstUsuarioPerfilBean); 
				return this.getLista(oUsuario, request);
				
				
				
			} else {
				UsuarioBean tmpUsuario = new UsuarioBean();
				tmpUsuario.setNombreUsuario("NV");
				this.setUsuarioBean(tmpUsuario);
				this.registrarAudAcceso(prmLogin.getNombreUsuario(), "1", request);
				
				ModelAndView mav = new ModelAndView("seguridad/login/login-admin", "command",prmLogin);
				mav.addObject("msgErrorLogin", "El usuario y/o contraseña no coinciden");
				mav.addObject("usuarioSesion", tmpUsuario);
				return mav;
			}
		}else{
			return  new ModelAndView("seguridad/login/login-admin", "command",prmLogin);
		}
	}

	@RequestMapping(value = "/inicio", method = RequestMethod.POST)
	public ModelAndView incio(@ModelAttribute("usuarioBean") UsuarioBean usuarioBean,
		BindingResult result, SessionStatus status,
		HttpServletRequest request) throws Exception {
		
		UsuarioBean usuario = this.getUsuarioSesion(request);
		UsuarioBean oUsuarioBean = new UsuarioBean();
		/*HttpSession session = request.getSession();
		session.removeAttribute("usuarioSesion");
		session.invalidate();
		*/
		//this.setUsuarioBean(new UsuarioBean());
	
		//Inicializando el Encrypt
		Encrypt.init("KEY_ENCRYPT_PASS");
		
		String passActual = "";
		String passNew = "";
		
		if (usuarioBean != null) {
			UsuarioBean prmUsuario = new UsuarioBean();
			//Encriptando la clave ingresada
			passActual = Encrypt.encrypt(usuarioBean.getPasswordUsuario());
			passNew    = Encrypt.encrypt(usuarioBean.getNewPassword());
			
			prmUsuario.setCodigoUsuario(usuarioBean.getCodigoUsuario());
			prmUsuario.setPasswordUsuario(passActual);
			prmUsuario.setNewPassword(passNew);
			prmUsuario.setFlgRestPass("0");
			this.setAuditoria(prmUsuario, request, false);
			Integer resultI = usuarioService.cambiarPassword(prmUsuario);
			
			if (resultI != null && resultI>0) {
				UsuarioBean filtro = new UsuarioBean();
				filtro.setCodigoUsuario(usuarioBean.getCodigoUsuario());
				
			  oUsuarioBean = usuarioService.buscarxcodigousua(filtro);
				if(oUsuarioBean != null){
					usuario = oUsuarioBean;
				}
				usuario.setPasswordUsuario(passActual);
				usuario.setFlgRestPass("0");
				/** BUSCAR LOS PERFILES DEL USUARIO **/
				List<UsuarioPerfilBean> lstUsuarioPerfilBean = new ArrayList<UsuarioPerfilBean>();
				UsuarioPerfilBean filtroUsuarioPerfilBean = new UsuarioPerfilBean();
				filtroUsuarioPerfilBean.setUsuario(new UsuarioBean());
				filtroUsuarioPerfilBean.getUsuario().setCodigoUsuario(usuarioBean.getCodigo());
				lstUsuarioPerfilBean = usuarioPerfilService.getBuscarPorFiltros(filtroUsuarioPerfilBean);
				
				String codPerfilSelecc = oUsuarioBean.getPerfil().getCodigo();// "1";
				
				if( !VO.isEmptyList(lstUsuarioPerfilBean) ){
					UsuarioPerfilBean prmUP = lstUsuarioPerfilBean.get(0);
					codPerfilSelecc = prmUP.getPerfil().getCodigoPerfil();
				}
				System.out.println("codPerfilSelecc  " + codPerfilSelecc);
				usuario.setCodPerfilUsuSelec(codPerfilSelecc);
				usuario.setLstUsuarioPerfil(lstUsuarioPerfilBean);
						
				return this.getLista(usuario, request);
			} else {
				UsuarioBean filtro = new UsuarioBean();
				filtro.setCodigoUsuario(usuarioBean.getCodigoUsuario());
				 oUsuarioBean = usuarioService.buscarxcodigousua(filtro);
				
				if(oUsuarioBean != null){
					usuario = oUsuarioBean;
				}
				request.getSession().setAttribute("usuarioSesion", usuario);
				ModelAndView mav = new ModelAndView("seguridad/login/cambiar-contrasenia", "command",usuarioBean);
				mav.addObject("msgErrorLogin", "La contrase&nacute;a no coincide con la actual");
				mav.addObject("usuarioBean", usuarioBean);
				return mav;
			}
		}else{
			
			return  new ModelAndView("seguridad/login/login-admin", "command",new LoginVo());
		}
	}
	
	@RequestMapping(value = "/estadisticos", method = RequestMethod.GET)
	public ModelAndView estadisticos(@ModelAttribute("usuarioSesion") UsuarioBean usuario,
			HttpServletRequest request) throws Exception {
		return  new ModelAndView("inicio", "command", new ReferenciaBean());
	}
	
	private ModelAndView getLista(UsuarioBean usuario, HttpServletRequest request) { 
		
		ModelAndView mav = new ModelAndView("portada", "command", new ReferenciaBean());
		
	//	ModelAndView mav = new ModelAndView("asistencial/registro-referencia");
		System.out.println("inicia sistema ");
		
		try {
			
			int totalPerfiles = 0;
			
			/** TRAER ACCESOS **/
			if(!VO.isEmptyList(usuario.getLstUsuarioPerfil())){
				System.out.println("pasa mi modulo");
				System.out.println("usuario.getCodPerfilUsuSelec() " + usuario.getCodPerfilUsuSelec()); 
				totalPerfiles = usuario.getLstUsuarioPerfil().size();
				
				AccesoBean filtroAccesoBean = new AccesoBean();
				filtroAccesoBean.setPerfil(new PerfilBean());
				filtroAccesoBean.getPerfil().setCodigo(usuario.getCodPerfilUsuSelec()); 
				
				 
				List<AccesoBean> lstAccesoBean =  accesoService.getBuscarPorFiltros(filtroAccesoBean);
				
				
				AccesoMenuVo accesoMenuVo = verificarAccesos(lstAccesoBean);
				request.getSession().setAttribute("accesoMenu", accesoMenuVo);
				mav.addObject("accesoMenu", accesoMenuVo);		
				usuario.setLstAcceso(lstAccesoBean);
				
				
			}
			
			try {
				lstSituacion = maestraAsis14Service.listarPorCodigoTabla("000012", 1);
				lstTipoPaciente = maestraAsis14Service.listarPorCodigoTabla("000007", 1);
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}
			this.setUsuarioBean(usuario);	
			request.getSession().setAttribute("totalPerfiles", totalPerfiles);
			mav.addObject("totalPerfiles",totalPerfiles); 
			mav.addObject("lstSituacion",lstSituacion); 
			mav.addObject("lstTipoPaciente",lstTipoPaciente);
			request.getSession().setAttribute("usuarioSesion", usuario);
			mav.addObject("usuarioSesion", usuario);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mav;
	}
	
	
	
	@RequestMapping(value = "/listado", method = RequestMethod.POST)
	public ModelAndView doListado(@ModelAttribute("referenciaBean") ReferenciaBean referenciaBean, HttpServletRequest request
	)throws Exception {   
	ModelAndView mav = new ModelAndView("inicio", "command",referenciaBean);
	referenciaBean.setCodigoUsuarioSession(getUsuarioSesion(request).getCodigo());
	referenciaBean.setCodigoPerfilUsuarioSession(getUsuarioSesion(request).getPerfil().getCodigo());

	lstReferenciaBean = this.referenciaCbService.listaEstadistico(referenciaBean);
	this.cargarCombos(mav); 
	mav.addObject("lstReferenciaBean",lstReferenciaBean); 
	return mav;
	} 
	
	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView lista(@ModelAttribute("referenciaBean") ReferenciaBean referenciaBean, HttpServletRequest request
	)throws Exception {   
	ModelAndView mav = new ModelAndView("inicio", "command",referenciaBean);
	referenciaBean.setCodigoUsuarioSession(getUsuarioSesion(request).getCodigo());
	referenciaBean.setCodigoPerfilUsuarioSession(getUsuarioSesion(request).getPerfil().getCodigo());
	
	lstReferenciaBean = this.referenciaCbService.listaEstadistico(referenciaBean);
	this.cargarCombos(mav); 
	mav.addObject("lstReferenciaBean",lstReferenciaBean); 
	return mav;
	} 
	
	private void cargarCombos(ModelAndView mav){
		try {
			lstSituacion = maestraAsis14Service.listarPorCodigoTabla("000012", 1);
			lstTipoPaciente = maestraAsis14Service.listarPorCodigoTabla("000007", 1);
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}  
		mav.addObject("lstSituacion",lstSituacion); 
		mav.addObject("lstTipoPaciente",lstTipoPaciente);
	}
	
	
	@RequestMapping(value = "/portada", method = RequestMethod.GET)
	public ModelAndView portada(@ModelAttribute("usuarioSesion") UsuarioBean usuario,
			HttpServletRequest request) throws Exception {
		return  new ModelAndView("portada", "command", new ReferenciaBean());
	}
	
	
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ModelAndView listar(@ModelAttribute("usuarioSesion") UsuarioBean usuario,
			HttpServletRequest request) throws Exception {
		return this.getLista(usuario, request);
	}
	
	@RequestMapping(value = "/obtenerAccesos", method = RequestMethod.GET)
	@ResponseBody
	public void obtenerAccesos(@RequestParam("codperfil") String codperfil,
			HttpServletRequest request) throws Exception {
		
		UsuarioBean usuario = this.getUsuarioSesion(request);
		usuario.setCodPerfilUsuSelec(codperfil);
		request.getSession().setAttribute("usuarioSesion", usuario);
		
	}
	
	
	/*
	@RequestMapping(value = "/reporteLenguas", method = RequestMethod.GET)
	@ResponseBody
	public List<InstitucionLenguaBean> getReporteLenguas(@RequestParam("codinst") String codinst,
			HttpServletRequest request) throws Exception {
		
		List<InstitucionLenguaBean> lista = new ArrayList<InstitucionLenguaBean>();
		
		try {
			InstitucionLenguaBean filtro = new InstitucionLenguaBean();
			filtro.getInstitucionBean().setCodigo(VO.toLong(codinst));
			lista = this.fs.getInstitucionLenguaService().reporteAlumLengInst(filtro);
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		return lista;
	}
	
	*/
	
	private AccesoMenuVo verificarAccesos(List<AccesoBean> listaAcceso) {
		System.out.println("listaAcceso " + listaAcceso.size());
		AccesoMenuVo accesoMenuVo = new AccesoMenuVo();
		
		if(!VO.isEmptyList(listaAcceso)){
			for (int i = 0; i < listaAcceso.size(); i++) {
				AccesoBean bean = listaAcceso.get(i);
				
				if(		!VO.isNull(bean.getComponente()) 
					&& 	!VO.isNull(bean.getComponente().getNombreComponente())
				  ){
					
					String nombreComponente = bean.getComponente().getNombreComponente();
					
					/** INDICADOR **/
					if (nombreComponente.equals("estadisticos")) {
						
						accesoMenuVo.setMenu_Estadisticos(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1") ? true : false);
						
					}
					
					/** REFERENCIA **/
					if (nombreComponente.equals("referencia")) {
						
						accesoMenuVo.setMenu_Referencia(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1") ? true : false);
						
					}
					
					/** CONTRAREFERENCIA **/
					if (nombreComponente.equals("contrareferencia")) {
						
						accesoMenuVo.setMenu_Contrareferencia(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1") ? true : false);
						
					}
					
					/** CITA **/
					if (nombreComponente.equals("citas")) {
						
						accesoMenuVo.setMenu_Citas(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1") ? true : false);
						
					} 
					
					/** BANCO DE SANGRE **/
					if (nombreComponente.equals("bancoSangre")) {
						
						accesoMenuVo.setMenu_BancoSangre(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1") ? true : false);
						
					} if (nombreComponente.equals("postulantes")) {
						accesoMenuVo.setSubMenu_banco_postulante(new PermisoVo());
						accesoMenuVo.getSubMenu_banco_postulante().setAsignado((!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1") ? true : false));
						accesoMenuVo.getSubMenu_banco_postulante().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_banco_postulante().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_banco_postulante().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_banco_postulante().setExportacion(bean.isFlgExport() ? true : false);
						
					} if (nombreComponente.equals("estadoFisico")) {
						accesoMenuVo.setSubMenu_banco_estadoFisico(new PermisoVo());
						accesoMenuVo.getSubMenu_banco_estadoFisico().setAsignado((!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1") ? true : false));
						accesoMenuVo.getSubMenu_banco_estadoFisico().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_banco_estadoFisico().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_banco_estadoFisico().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_banco_estadoFisico().setExportacion(bean.isFlgExport() ? true : false);
					
					} if (nombreComponente.equals("entrevista")) {
						accesoMenuVo.setSubMenu_banco_entrevista(new PermisoVo());
						accesoMenuVo.getSubMenu_banco_entrevista().setAsignado((!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1") ? true : false));
						accesoMenuVo.getSubMenu_banco_entrevista().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_banco_entrevista().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_banco_entrevista().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_banco_entrevista().setExportacion(bean.isFlgExport() ? true : false); 
						
					} if (nombreComponente.equals("campania")) {
						accesoMenuVo.setSubMenu_banco_campania(new PermisoVo());
						accesoMenuVo.getSubMenu_banco_campania().setAsignado((!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1") ? true : false));
						accesoMenuVo.getSubMenu_banco_campania().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_banco_campania().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_banco_campania().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_banco_campania().setExportacion(bean.isFlgExport() ? true : false); 
						
					}if (nombreComponente.equals("lugarCampania")) {
						accesoMenuVo.setSubMenu_banco_lugarCampania(new PermisoVo());
						accesoMenuVo.getSubMenu_banco_lugarCampania().setAsignado((!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1") ? true : false));
						accesoMenuVo.getSubMenu_banco_lugarCampania().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_banco_lugarCampania().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_banco_lugarCampania().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_banco_lugarCampania().setExportacion(bean.isFlgExport() ? true : false); 
					}
					
					/** HERRAMIENTA **/
					if (nombreComponente.equals("herramientas")) {
						
						accesoMenuVo.setMenu_Herramientas(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1") ? true : false);
						
					} 
					
					/** SEGURIDAD **/
					if (nombreComponente.equals("seguridad")) {
						
						accesoMenuVo.setMenu_Seguridad(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("1") ? true : false);
						
					}else if (nombreComponente.equals("usuario")) {
						accesoMenuVo.setSubMenu_seguridad_usuario(new PermisoVo());
						accesoMenuVo.getSubMenu_seguridad_usuario().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_seguridad_usuario().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_seguridad_usuario().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_seguridad_usuario().setExportacion(bean.isFlgExport() ? true : false);
						
					}else if (nombreComponente.equals("perfil")) {
						accesoMenuVo.setSubMenu_seguridad_perfil(new PermisoVo());
						accesoMenuVo.getSubMenu_seguridad_perfil().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_seguridad_perfil().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_seguridad_perfil().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_seguridad_perfil().setExportacion(bean.isFlgExport() ? true : false);
					
					}else if (nombreComponente.equals("acceso")) {
						accesoMenuVo.setSubMenu_seguridad_acceso(new PermisoVo());
						accesoMenuVo.getSubMenu_seguridad_acceso().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_seguridad_acceso().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_seguridad_acceso().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_seguridad_acceso().setExportacion(bean.isFlgExport() ? true : false); 
					} 
				}
				
			}
		}
	
		return accesoMenuVo;
	}
	
	private void registrarAudAcceso(String nomUsuario, String tipoAccion, HttpServletRequest request){
		try {
			AuditoriaAccesoBean bean = new AuditoriaAccesoBean();
			bean.getTipoAccion().setCodReg(tipoAccion);
			bean.setNomUsuario(nomUsuario);
			bean.setIpCreacion(NetUtil.getClientIpAddr(request));
			bean.getTipoSistema().setCodReg("000001");
			
			if(!VO.isNull(bean.getIpCreacion()) && !bean.getIpCreacion().equals("0:0:0:0:0:0:0:1")){
				this.fs.getAuditoriaService().insertarAuditoriaAcceso(bean);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}




	public List<TablaBean> getLstMaestra() {
		return lstMaestra;
	}




	public void setLstMaestra(List<TablaBean> lstMaestra) {
		this.lstMaestra = lstMaestra;
	}
	
	
	
	
	
}