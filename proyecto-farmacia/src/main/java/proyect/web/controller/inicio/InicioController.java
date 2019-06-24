package proyect.web.controller.inicio;
  
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

import com.itextpdf.text.log.SysoCounter;

import proyect.core.bean.general.AlmacenBean;
import proyect.core.bean.general.CatalogoBean;
import proyect.core.bean.seguridad.AccesoBean;
import proyect.core.bean.seguridad.AuditoriaAccesoBean;
import proyect.core.bean.seguridad.PerfilBean;
import proyect.core.bean.seguridad.UsuarioBean;
import proyect.core.bean.seguridad.UsuarioPerfilBean;
import proyect.base.service.ServiceException;
import proyect.core.service.interfaces.catalogo.Catalogo2Service;
import proyect.core.service.interfaces.farmacia.general.AlmacenService;
import proyect.core.service.interfaces.seguridad.AccesoService;
import proyect.core.service.interfaces.seguridad.UsuarioPerfilService;
import proyect.core.service.interfaces.seguridad.UsuarioService;
import proyect.web.controller.base.BaseController;
import proyect.web.utilitarios.NetUtil;
import proyect.web.utilitarios.VO;
import proyect.web.utilitarios.acceso.AccesoMenuVo;
import proyect.web.utilitarios.acceso.LoginVo;
import proyect.web.utilitarios.acceso.PermisoVo;
import proyect.web.utilitarios.encrypt.Encrypt;
 
 
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
	private Catalogo2Service Catalogo2Service;
 
	@Autowired
	AlmacenService almacenService;
	
	List<CatalogoBean> lstMaestra =(new ArrayList<CatalogoBean>()); ;
	List<CatalogoBean> lstSituacion = new ArrayList<CatalogoBean>();
	List<CatalogoBean> lstTipoPaciente = new ArrayList<CatalogoBean>(); 
	List<AlmacenBean> lstAlmacenBean;
	
	@PostConstruct
	public void init(){
		this.setLstMaestra(new ArrayList<CatalogoBean>());  
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
			
			System.out.println("prmUsuario getPasswordUsuario" + prmUsuario.getPasswordUsuario());
			prmUsuario.setNombreUsuario(prmLogin.getNombreUsuario());
			System.out.println("prmLogin.getAlmacen() " + prmLogin.getAlmacen().getCodigo());
			prmUsuario.setAlmacen(prmLogin.getAlmacen());
			UsuarioBean oUsuario = usuarioService.autenticar(prmUsuario); 
			if (oUsuario != null) {
				System.out.println("NombreUsuario "+oUsuario.getNombreUsuario());
				System.out.println("NombreUsuario persona "+oUsuario.getPersona().getNombreCompleto());
				System.out.println("Codigo "+oUsuario.getCodigo()); 
					if (!oUsuario.isActivo()) {//Activo
						
						
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
				cargarComboAlmacen(mav);
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
			prmUsuario.setPasswordUsuario(Encrypt.encrypt(prmLogin.getContrasena()));  ; 
			System.out.println("prmUsuario getPasswordUsuario" + prmUsuario.getPasswordUsuario());
			prmUsuario.setNombreUsuario(prmLogin.getNombreUsuario());
			System.out.println("prmUsuario getAlmacen" + prmLogin.getAlmacen().getCodigo());
			
			prmUsuario.setAlmacen(prmLogin.getAlmacen()); 
			
			UsuarioBean oUsuario = usuarioService.autenticar(prmUsuario);
			System.out.println("11111");
			if (oUsuario != null) {
				oUsuario.setAlmacen(prmLogin.getAlmacen());
				System.out.println("NombreUsuario "+oUsuario.getNombreUsuario());
				System.out.println("NombreUsuario persona "+oUsuario.getPersona().getNombreCompleto());
				System.out.println("Codigo "+oUsuario.getCodigo()); 
					if (!oUsuario.isActivo()) {//Activo
						
						
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
				cargarComboAlmacen(mav);
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
	 
	private ModelAndView getLista(UsuarioBean usuario, HttpServletRequest request) { 
		
		ModelAndView mav = new ModelAndView("portada", "command", new CatalogoBean());
		
	//	ModelAndView mav = new ModelAndView("asistencial/registro-referencia");
		System.out.println("inicia sistema "+ usuario.getAlmacen().getNombreAlmacen());
		
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
				
				 
			//	List<AccesoBean> lstAccesoBean =  accesoService.getBuscarPorFiltros(filtroAccesoBean);
				
				
			//	AccesoMenuVo accesoMenuVo = verificarAccesos(lstAccesoBean);
			//	request.getSession().setAttribute("accesoMenu", accesoMenuVo);
			//	mav.addObject("accesoMenu", accesoMenuVo);		
			//	activar usuario.setLstAcceso(lstAccesoBean);
				
			}
			
			try {
				lstSituacion = Catalogo2Service.listarPorCodigoTabla("000012", 1);
				lstTipoPaciente = Catalogo2Service.listarPorCodigoTabla("000007", 1);
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}
			AlmacenBean objAlmacen = almacenService.getBuscarPorObjecto(usuario.getAlmacen());
			usuario.setAlmacen(objAlmacen);
			this.setUsuarioBean(usuario);	
			request.getSession().setAttribute("usuarioSesion", usuario);
			mav.addObject("usuarioSesion", usuario);
			request.getSession().setAttribute("totalPerfiles", totalPerfiles);
			mav.addObject("totalPerfiles",totalPerfiles); 
			mav.addObject("lstSituacion",lstSituacion); 
			mav.addObject("lstTipoPaciente",lstTipoPaciente);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mav;
	}
	
	
	 
	
	private void cargarCombos(ModelAndView mav){
		try {
			lstSituacion = Catalogo2Service.listarPorCodigoTabla("000012", 1);
			lstTipoPaciente = Catalogo2Service.listarPorCodigoTabla("000007", 1);
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
		return  new ModelAndView("portada", "command", new CatalogoBean());
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
			bean.getTipoAccion().setIdRegistro(tipoAccion);
			bean.setNomUsuario(nomUsuario);
			bean.setIpRegistro(NetUtil.getClientIpAddr(request));
			bean.getTipoSistema().setIdRegistro("000001");
			
			if(!VO.isNull(bean.getIpRegistro()) && !bean.getIpRegistro().equals("0:0:0:0:0:0:0:1")){
				this.fs.getAuditoriaService().insertarAuditoriaAcceso(bean);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}




	public List<CatalogoBean> getLstMaestra() {
		return lstMaestra;
	}




	public void setLstMaestra(List<CatalogoBean> lstMaestra) {
		this.lstMaestra = lstMaestra;
	}
	
	
	
	
	
}