package proyect.web.controller.inicio;
  
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.log.SysoCounter;

import proyect.core.bean.compra.CompraBean;
import proyect.core.bean.general.AlmacenBean;
import proyect.core.bean.general.CatalogoBean;
import proyect.core.bean.general.TurnoBean;
import proyect.core.bean.seguridad.AccesoBean;
import proyect.core.bean.seguridad.AuditoriaAccesoBean;
import proyect.core.bean.seguridad.PerfilBean;
import proyect.core.bean.seguridad.UsuarioBean;
import proyect.core.bean.seguridad.UsuarioPerfilBean;
import proyect.core.bean.stock.ArticuloBean;
import proyect.core.bean.stock.StockBean;
import proyect.core.bean.venta.VentaBean;
import proyect.base.service.ServiceException;
import proyect.core.service.interfaces.catalogo.Catalogo2Service;
import proyect.core.service.interfaces.compra.CompraService;
import proyect.core.service.interfaces.general.AlmacenService;
import proyect.core.service.interfaces.general.TurnoService;
import proyect.core.service.interfaces.seguridad.AccesoService;
import proyect.core.service.interfaces.seguridad.UsuarioPerfilService;
import proyect.core.service.interfaces.seguridad.UsuarioService;
import proyect.core.service.interfaces.stock.ArticuloService;
import proyect.core.service.interfaces.stock.StockService;
import proyect.core.service.interfaces.venta.VentaService;
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
	private ArticuloService articuloService;
	
	@Autowired
	private StockService stockService;
	
	@Autowired
	private VentaService ventaService;
	 
	@Autowired
	private CompraService compraService;
	
	@Autowired
	private UsuarioPerfilService usuarioPerfilService;
	
	@Autowired
	private Catalogo2Service Catalogo2Service;
 
	@Autowired
	private AlmacenService almacenService;
	
	@Autowired
	private  TurnoService turnoService;
	
	List<TurnoBean> lstTurno =(new ArrayList<TurnoBean>());
	List<CatalogoBean> lstSituacion = new ArrayList<CatalogoBean>();
	List<CatalogoBean> lstTipoPaciente = new ArrayList<CatalogoBean>(); 
	List<VentaBean> lstVentasMes = new ArrayList<VentaBean>(); 
	List<VentaBean> lstVentasTipoPacienteMes = new ArrayList<VentaBean>(); 
	List<ArticuloBean> lstArticulosStockAlerta = new ArrayList<ArticuloBean>(); 
	List<StockBean> lstStockVencimiento = new ArrayList<StockBean>(); 
	List<AlmacenBean> lstAlmacenBean;
	
	private VentaBean ventaBean;
	private CompraBean compraBean;
	
	java.util.Date fecha = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
	String anio = dateFormat.format(fecha);
	
	@PostConstruct
	public void init(){
		 
	}
	
	private void cargarComboAlmacen(ModelAndView mav){
		AlmacenBean almacenBean = new AlmacenBean();
		 
			try {
				lstAlmacenBean = almacenService.getBuscarPorFiltros(almacenBean);
				lstTurno = turnoService.getBuscarPorFiltros(new TurnoBean()); 
			} catch (ServiceException e) {
				e.printStackTrace(); 	
		}
  
		mav.addObject("lstAlmacenBean",lstAlmacenBean); 
		mav.addObject("lstTurno",lstTurno); 
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
			
			UsuarioBean oUsuarioAlmacen = usuarioService.validarAccesoAlmacen(prmUsuario); 
			if (oUsuario != null) {
				System.out.println("NombreUsuario "+oUsuario.getNombreUsuario());
				System.out.println("NombreUsuario persona "+oUsuario.getPersona().getNombreCompleto());
				System.out.println("Codigo "+oUsuario.getCodigo()); 
					if (!oUsuario.isActivo()) {//Activo
						
						
			//		this.registrarAudAcceso(prmLogin.getNombreUsuario(), 5, request);
					ModelAndView mav = new ModelAndView("seguridad/login/login","command", prmLogin);
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
				
				if (oUsuarioAlmacen != null) {
					/** BUSCAR LOS PERFILES DEL USUARIO **/
					List<UsuarioPerfilBean> lstUsuarioPerfilBean = new ArrayList<UsuarioPerfilBean>();
					UsuarioPerfilBean us = new UsuarioPerfilBean();
					us.setCodigoUsuario(oUsuarioAlmacen.getCodigo());
					lstUsuarioPerfilBean.add(us); 
					 
					oUsuario.setCodPerfilUsuSelec(oUsuarioAlmacen.getPerfil().getCodigo());
					oUsuario.setLstUsuarioPerfil(lstUsuarioPerfilBean); 
					return this.getLista(oUsuarioAlmacen, request);
					
				
				}else {
					UsuarioBean tmpUsuario = new UsuarioBean();
					tmpUsuario.setNombreUsuario("NV");
					this.setUsuarioBean(tmpUsuario);
					
					ModelAndView mav = new ModelAndView("seguridad/login/login", "command",prmLogin);
					mav.addObject("msgErrorLogin", "No tiene acceso al almacén seleccionado.");
					mav.addObject("usuarioSesion", tmpUsuario);
					cargarComboAlmacen(mav);
					return mav;
				} 
				
			} else {
				UsuarioBean tmpUsuario = new UsuarioBean();
				tmpUsuario.setNombreUsuario("NV");
				this.setUsuarioBean(tmpUsuario);
				this.registrarAudAcceso(prmLogin.getNombreUsuario(), "1", request);
				
				ModelAndView mav = new ModelAndView("seguridad/login/login", "command",prmLogin);
				mav.addObject("msgErrorLogin", "El usuario y/o contraseña no coinciden");
				mav.addObject("usuarioSesion", tmpUsuario);
				cargarComboAlmacen(mav);
				return mav;
			}
		}else{
			return  new ModelAndView("seguridad/login/login", "command",prmLogin);
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
			prmUsuario.setTurno(prmLogin.getTurno());
			UsuarioBean oUsuario = usuarioService.autenticar(prmUsuario);
			
			UsuarioBean oUsuarioAlmacen = usuarioService.validarAccesoAlmacen(prmUsuario); 
			System.out.println("11111");
			if (oUsuario != null) {
				oUsuario.setAlmacen(prmLogin.getAlmacen());
				System.out.println("NombreUsuario "+oUsuario.getNombreUsuario());
				System.out.println("NombreUsuario persona "+oUsuario.getPersona().getNombreCompleto());
				System.out.println("Codigo "+oUsuario.getCodigo()); 
					if (!oUsuario.isActivo()) {//Activo
						
						
			//		this.registrarAudAcceso(prmLogin.getNombreUsuario(), 5, request);
					ModelAndView mav = new ModelAndView("seguridad/login/login","command", prmLogin);
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
				
				if (oUsuarioAlmacen != null) {
					System.out.println("oUsuarioAlmacen error" + oUsuarioAlmacen.getError());
					/** BUSCAR LOS PERFILES DEL USUARIO **/
					if (oUsuarioAlmacen.getError() == null) {
						List<UsuarioPerfilBean> lstUsuarioPerfilBean = new ArrayList<UsuarioPerfilBean>();
						UsuarioPerfilBean us = new UsuarioPerfilBean();
						us.setCodigoUsuario(oUsuarioAlmacen.getCodigo());
						us.getPerfil().setCodigo(oUsuarioAlmacen.getPerfil().getCodigo());
						lstUsuarioPerfilBean.add(us); 
						 
						oUsuarioAlmacen.setCodPerfilUsuSelec(oUsuarioAlmacen.getPerfil().getCodigo());
						oUsuarioAlmacen.setLstUsuarioPerfil(lstUsuarioPerfilBean); 
						return this.getLista(oUsuarioAlmacen, request);
					}else {
						ModelAndView mav = new ModelAndView("seguridad/login/login", "command",prmLogin);
						mav.addObject("msgErrorLogin", oUsuarioAlmacen.getError());
					//	mav.addObject("usuarioSesion", tmpUsuario);
						cargarComboAlmacen(mav);
						return mav;
					}
					
				
				}else {
					UsuarioBean tmpUsuario = new UsuarioBean();
					tmpUsuario.setNombreUsuario("NV");
					this.setUsuarioBean(tmpUsuario);
					
					ModelAndView mav = new ModelAndView("seguridad/login/login", "command",prmLogin);
					mav.addObject("msgErrorLogin", "No tiene acceso al almacén seleccionado.");
					mav.addObject("usuarioSesion", tmpUsuario);
					cargarComboAlmacen(mav);
					return mav;
				} 
				
			} else {
				UsuarioBean tmpUsuario = new UsuarioBean();
				tmpUsuario.setNombreUsuario("NV");
				this.setUsuarioBean(tmpUsuario);
				this.registrarAudAcceso(prmLogin.getNombreUsuario(), "1", request);
				
				ModelAndView mav = new ModelAndView("seguridad/login/login", "command",prmLogin);
				mav.addObject("msgErrorLogin", "El usuario y/o contraseña no coinciden");
				mav.addObject("usuarioSesion", tmpUsuario);
				cargarComboAlmacen(mav);
				return mav;
			}
		}else{
			return  new ModelAndView("seguridad/login/login", "command",prmLogin);
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
			
			return  new ModelAndView("seguridad/login/login", "command",new LoginVo());
		}
	}
	 
	private ModelAndView getLista(UsuarioBean usuario, HttpServletRequest request) { 
		
		ModelAndView mav = new ModelAndView("portada", "command", new CatalogoBean());
		
	//	ModelAndView mav = new ModelAndView("asistencial/registro-referencia");
		System.out.println("inicia sistema "+ usuario.getAlmacen().getNombreAlmacen());
		System.out.println("inicia turno "+ usuario.getTurno().getCodigo());
		System.out.println("perfil acceso "+ usuario.getPerfil().getCodigo());
		try {
			
			int totalPerfiles = 0;
			
			/** TRAER ACCESOS **/
			if(!VO.isEmptyList(usuario.getLstUsuarioPerfil())){
				System.out.println("pasa mi modulo");
				System.out.println("usuario.getCodPerfilUsuSelec() " + usuario.getCodPerfilUsuSelec()); 
				totalPerfiles = usuario.getLstUsuarioPerfil().size();
				
				AccesoBean filtroAccesoBean = new AccesoBean();
				filtroAccesoBean.setPerfil(new PerfilBean());
				filtroAccesoBean.getPerfil().setCodigo(usuario.getPerfil().getCodigo()); 
 
				List<AccesoBean> lstAccesoBean =  accesoService.getBuscarPorFiltros(filtroAccesoBean);				
				
				AccesoMenuVo accesoMenuVo = verificarAccesos(lstAccesoBean);
				request.getSession().setAttribute("accesoMenu", accesoMenuVo);
				mav.addObject("accesoMenu", accesoMenuVo);		
				usuario.setLstAcceso(lstAccesoBean);
			}
	 
			String totalVenta = "0.00";
			String totalVentaAnulado = "0.00";
			String totalCompra = "0.00";
			VentaBean prmVentaBean =  new VentaBean();
			prmVentaBean.setFechaEmision(new Date());
			prmVentaBean.getSituacion().setIdRegistro("000001");
			prmVentaBean.setNumeroPeriodo(anio);
			
			CompraBean prmCompraBean =  new CompraBean();
			prmCompraBean.setFechaEmision(new Date()); 
			
			try {
				ventaBean = ventaService.totalVenta(1, prmVentaBean); 
				totalVenta = ventaBean.getsImporte(); 
				
				prmVentaBean.getSituacion().setIdRegistro("000002");
				ventaBean = ventaService.totalVenta(1, prmVentaBean); 
				totalVentaAnulado= ventaBean.getsImporte(); 
				
				compraBean = compraService.totalCompra(1, prmCompraBean);
				totalCompra = compraBean.getsImporte();
				
				lstVentasMes = ventaService.listaMensual(prmVentaBean);
				lstVentasTipoPacienteMes = ventaService.reporteVentaTipoPaciente(1, prmVentaBean);
				
				lstArticulosStockAlerta = articuloService.reportePorStockAlerta();
				lstStockVencimiento = stockService.reporteArticuloPorVencer();
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}   
			mav.addObject("totalVenta",totalVenta);  
			mav.addObject("totalVentaAnulado",totalVentaAnulado);  
			mav.addObject("totalCompra",totalCompra); 
			mav.addObject("lstVentasMes",lstVentasMes); 
			mav.addObject("lstVentasTipoPacienteMes",lstVentasTipoPacienteMes); 
			mav.addObject("lstArticulosStockAlerta",lstArticulosStockAlerta); 
			mav.addObject("lstStockVencimiento",lstStockVencimiento); 
			
			AlmacenBean objAlmacen = almacenService.getBuscarPorObjecto(usuario.getAlmacen());
			usuario.setAlmacen(objAlmacen);
			this.setUsuarioBean(usuario);	
			request.getSession().setAttribute("usuarioSesion", usuario);
			mav.addObject("usuarioSesion", usuario);
			request.getSession().setAttribute("totalPerfiles", totalPerfiles);
			mav.addObject("totalPerfiles",totalPerfiles); 

			
			
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
		
		ModelAndView mav = new ModelAndView("portada", "command", new CatalogoBean());
		String totalVenta = "0.00";
		String totalVentaAnulado = "0.00";
		String totalCompra = "0.00";
		VentaBean prmVentaBean =  new VentaBean();
		prmVentaBean.setFechaEmision(new Date());
		prmVentaBean.getSituacion().setIdRegistro("000001");
		prmVentaBean.setNumeroPeriodo(anio);
		
		CompraBean prmCompraBean =  new CompraBean();
		prmCompraBean.setFechaEmision(new Date()); 
		
		try {
			ventaBean = ventaService.totalVenta(1, prmVentaBean); 
			totalVenta = ventaBean.getsImporte(); 
			
			prmVentaBean.getSituacion().setIdRegistro("000002");
			ventaBean = ventaService.totalVenta(1, prmVentaBean); 
			totalVentaAnulado= ventaBean.getsImporte(); 
			
			compraBean = compraService.totalCompra(1, prmCompraBean);
			totalCompra = compraBean.getsImporte();
			
			lstVentasMes = ventaService.listaMensual(prmVentaBean);
			lstVentasTipoPacienteMes = ventaService.reporteVentaTipoPaciente(1, prmVentaBean);
			lstArticulosStockAlerta = articuloService.reportePorStockAlerta();
			lstStockVencimiento = stockService.reporteArticuloPorVencer();
			System.out.println();
			
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}  
		mav.addObject("lstVentasTipoPacienteMes",lstVentasTipoPacienteMes); 
		mav.addObject("totalVenta",totalVenta);  
		mav.addObject("totalVentaAnulado",totalVentaAnulado);  
		mav.addObject("totalCompra",totalCompra); 
		mav.addObject("lstVentasMes",lstVentasMes); 
		mav.addObject("lstArticulosStockAlerta",lstArticulosStockAlerta);
		mav.addObject("lstStockVencimiento",lstStockVencimiento);
		return mav;
		
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
					System.out.println( "nombreComponente " + nombreComponente);
					/** INDICADOR **/
					if (nombreComponente.equals("Estadisticos")) {
						
						accesoMenuVo.setMenu_Estadisticos(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("true") ? true : false);
						
					}
					
					/** REFERENCIA **/
					if (nombreComponente.equals("Ventas")) { 
						accesoMenuVo.setMenu_Venta(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("true") ? true : false);

					}if (nombreComponente.equals("Generar")) {
						System.out.println("bean.getFlgAsignado() " + bean.getFlgAsignado());
						accesoMenuVo.setSubMenu_venta_generar(new PermisoVo());
						accesoMenuVo.getSubMenu_venta_generar().setAsignado((!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("true") ? true : false));
						accesoMenuVo.getSubMenu_venta_generar().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_venta_generar().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_venta_generar().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_venta_generar().setExportacion(bean.isFlgExport() ? true : false);
						
					}if (nombreComponente.equals("ListarVenta")) {
						accesoMenuVo.setSubMenu_venta_listar(new PermisoVo());
						accesoMenuVo.getSubMenu_venta_listar().setAsignado((!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("true") ? true : false));
						accesoMenuVo.getSubMenu_venta_listar().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_venta_listar().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_venta_listar().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_venta_listar().setExportacion(bean.isFlgExport() ? true : false);
						
					}if (nombreComponente.equals("PacienteVenta")) {
						accesoMenuVo.setSubMenu_venta_paciente(new PermisoVo());
						accesoMenuVo.getSubMenu_venta_paciente().setAsignado((!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("true") ? true : false));
						accesoMenuVo.getSubMenu_venta_paciente().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_venta_paciente().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_venta_paciente().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_venta_paciente().setExportacion(bean.isFlgExport() ? true : false);
						
					}if (nombreComponente.equals("AnularVenta")) {
						accesoMenuVo.setSubMenu_venta_anular(new PermisoVo());
						accesoMenuVo.getSubMenu_venta_anular().setAsignado((!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("true") ? true : false));
						accesoMenuVo.getSubMenu_venta_anular().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_venta_anular().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_venta_anular().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_venta_anular().setExportacion(bean.isFlgExport() ? true : false);
						
					}if (nombreComponente.equals("Devolución")) {
						accesoMenuVo.setSubMenu_venta_devolucion(new PermisoVo());
						accesoMenuVo.getSubMenu_venta_devolucion().setAsignado((!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("true") ? true : false));
						accesoMenuVo.getSubMenu_venta_devolucion().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_venta_devolucion().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_venta_devolucion().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_venta_devolucion().setExportacion(bean.isFlgExport() ? true : false);
						
					}
					
					/** INVENTARIO **/
					if (nombreComponente.equals("Inventario")) { 
						accesoMenuVo.setMenu_Inventario(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("true") ? true : false);
						
					}if (nombreComponente.equals("Articulo")) {
						accesoMenuVo.setSubMenu_inventario_articulo(new PermisoVo());
						accesoMenuVo.getSubMenu_inventario_articulo().setAsignado((!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("true") ? true : false));
						accesoMenuVo.getSubMenu_inventario_articulo().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_inventario_articulo().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_inventario_articulo().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_inventario_articulo().setExportacion(bean.isFlgExport() ? true : false);
						
					}if (nombreComponente.equals("Almacen")) {
						accesoMenuVo.setSubMenu_inventario_almacen(new PermisoVo());
						accesoMenuVo.getSubMenu_inventario_almacen().setAsignado((!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("true") ? true : false));
						accesoMenuVo.getSubMenu_inventario_almacen().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_inventario_almacen().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_inventario_almacen().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_inventario_almacen().setExportacion(bean.isFlgExport() ? true : false);
						
					}if (nombreComponente.equals("ConsultarInventario")) {
						accesoMenuVo.setSubMenu_inventario_consultar(new PermisoVo());
						accesoMenuVo.getSubMenu_inventario_consultar().setAsignado((!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("true") ? true : false));
						accesoMenuVo.getSubMenu_inventario_consultar().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_inventario_consultar().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_inventario_consultar().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_inventario_consultar().setExportacion(bean.isFlgExport() ? true : false);
						
					}if (nombreComponente.equals("InventarioGenerar")) {
						accesoMenuVo.setSubMenu_inventario_generar(new PermisoVo());
						accesoMenuVo.getSubMenu_inventario_generar().setAsignado((!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("true") ? true : false));
						accesoMenuVo.getSubMenu_inventario_generar().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_inventario_generar().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_inventario_generar().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_inventario_generar().setExportacion(bean.isFlgExport() ? true : false);
						
					}
					
					/** MOVIMIENTO **/
					if (nombreComponente.equals("Movimiento")) {
						accesoMenuVo.setMenu_Movimiento(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("true") ? true : false);
						
					}if (nombreComponente.equals("Compras")) {
						accesoMenuVo.setSubMenu_movimiento_compra(new PermisoVo());
						accesoMenuVo.getSubMenu_movimiento_compra().setAsignado((!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("true") ? true : false));
						accesoMenuVo.getSubMenu_movimiento_compra().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_movimiento_compra().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_movimiento_compra().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_movimiento_compra().setExportacion(bean.isFlgExport() ? true : false);
						
					}if (nombreComponente.equals("Ingeso/Salida")) {
						accesoMenuVo.setSubMenu_movimiento_ingresoSalida(new PermisoVo());
						accesoMenuVo.getSubMenu_movimiento_ingresoSalida().setAsignado((!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("true") ? true : false));
						accesoMenuVo.getSubMenu_movimiento_ingresoSalida().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_movimiento_ingresoSalida().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_movimiento_ingresoSalida().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_movimiento_ingresoSalida().setExportacion(bean.isFlgExport() ? true : false);
						
					}if (nombreComponente.equals("ReporteKardex")) {
						accesoMenuVo.setSubMenu_movimiento_kardex(new PermisoVo());
						accesoMenuVo.getSubMenu_movimiento_kardex().setAsignado((!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("true") ? true : false));
						accesoMenuVo.getSubMenu_movimiento_kardex().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_movimiento_kardex().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_movimiento_kardex().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_movimiento_kardex().setExportacion(bean.isFlgExport() ? true : false);
						
					} 
					
					/** MANTENIMIENTO **/
					if (nombreComponente.equals("Mantenimiento")) { 
						accesoMenuVo.setMenu_Mantenimiento(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("true") ? true : false);
	 
					}if (nombreComponente.equals("Personal")) {
						accesoMenuVo.setSubMenu_mantenimiento_personal(new PermisoVo());
						accesoMenuVo.getSubMenu_mantenimiento_personal().setAsignado((!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("true") ? true : false));
						accesoMenuVo.getSubMenu_mantenimiento_personal().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_mantenimiento_personal().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_mantenimiento_personal().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_mantenimiento_personal().setExportacion(bean.isFlgExport() ? true : false);
						
					}if (nombreComponente.equals("Stock")) {
						accesoMenuVo.setSubMenu_mantenimiento_stock(new PermisoVo());
						accesoMenuVo.getSubMenu_mantenimiento_stock().setAsignado((!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("true") ? true : false));
						accesoMenuVo.getSubMenu_mantenimiento_stock().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_mantenimiento_stock().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_mantenimiento_stock().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_mantenimiento_stock().setExportacion(bean.isFlgExport() ? true : false);
						
					}if (nombreComponente.equals("TipoMovimiento")) {
						accesoMenuVo.setSubMenu_mantenimiento_tipoMovimiento(new PermisoVo());
						accesoMenuVo.getSubMenu_mantenimiento_tipoMovimiento().setAsignado((!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("true") ? true : false));
						accesoMenuVo.getSubMenu_mantenimiento_tipoMovimiento().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_mantenimiento_tipoMovimiento().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_mantenimiento_tipoMovimiento().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_mantenimiento_tipoMovimiento().setExportacion(bean.isFlgExport() ? true : false);
						
					}if (nombreComponente.equals("Catalogos")) {
						accesoMenuVo.setSubMenu_mantenimiento_catalogos(new PermisoVo());
						accesoMenuVo.getSubMenu_mantenimiento_catalogos().setAsignado((!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("true") ? true : false));
						accesoMenuVo.getSubMenu_mantenimiento_catalogos().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_mantenimiento_catalogos().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_mantenimiento_catalogos().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_mantenimiento_catalogos().setExportacion(bean.isFlgExport() ? true : false);
						
					}if (nombreComponente.equals("Laboratorio")) {
						accesoMenuVo.setSubMenu_mantenimiento_laboratorio(new PermisoVo());
						accesoMenuVo.getSubMenu_mantenimiento_laboratorio().setAsignado((!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("true") ? true : false));
						accesoMenuVo.getSubMenu_mantenimiento_laboratorio().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_mantenimiento_laboratorio().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_mantenimiento_laboratorio().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_mantenimiento_laboratorio().setExportacion(bean.isFlgExport() ? true : false);
						
					}    
					
					/** REPORTE VENTA **/
					if (nombreComponente.equals("ReporteVentas")) { 
						accesoMenuVo.setMenu_RptVenta(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("true") ? true : false);
						
					}if (nombreComponente.equals("Recaudacion")) {
						accesoMenuVo.setSubMenu_ventaRpt_recaudacion(new PermisoVo());
						accesoMenuVo.getSubMenu_ventaRpt_recaudacion().setAsignado((!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("true") ? true : false));
						accesoMenuVo.getSubMenu_ventaRpt_recaudacion().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_ventaRpt_recaudacion().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_ventaRpt_recaudacion().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_ventaRpt_recaudacion().setExportacion(bean.isFlgExport() ? true : false);
						
					}if (nombreComponente.equals("VentasDiarias")) {
						accesoMenuVo.setSubMenu_ventaRpt_diario(new PermisoVo());
						accesoMenuVo.getSubMenu_ventaRpt_diario().setAsignado((!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("true") ? true : false));
						accesoMenuVo.getSubMenu_ventaRpt_diario().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_ventaRpt_diario().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_ventaRpt_diario().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_ventaRpt_diario().setExportacion(bean.isFlgExport() ? true : false);
						
					}if (nombreComponente.equals("Anulaciones")) {
						accesoMenuVo.setSubMenu_ventaRpt_anulaciones(new PermisoVo());
						accesoMenuVo.getSubMenu_ventaRpt_anulaciones().setAsignado((!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("true") ? true : false));
						accesoMenuVo.getSubMenu_ventaRpt_anulaciones().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_ventaRpt_anulaciones().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_ventaRpt_anulaciones().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_ventaRpt_anulaciones().setExportacion(bean.isFlgExport() ? true : false);
						
					}if (nombreComponente.equals("TipoPaciente")) {
						accesoMenuVo.setSubMenu_ventaRpt_tipoPaciente(new PermisoVo());
						accesoMenuVo.getSubMenu_ventaRpt_tipoPaciente().setAsignado((!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("true") ? true : false));
						accesoMenuVo.getSubMenu_ventaRpt_tipoPaciente().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_ventaRpt_tipoPaciente().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_ventaRpt_tipoPaciente().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_ventaRpt_tipoPaciente().setExportacion(bean.isFlgExport() ? true : false);
						
					}if (nombreComponente.equals("Devoluciones")) {
						accesoMenuVo.setSubMenu_ventaRpt_devoluciones(new PermisoVo());
						accesoMenuVo.getSubMenu_ventaRpt_devoluciones().setAsignado((!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("true") ? true : false));
						accesoMenuVo.getSubMenu_ventaRpt_devoluciones().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_ventaRpt_devoluciones().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_ventaRpt_devoluciones().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_ventaRpt_devoluciones().setExportacion(bean.isFlgExport() ? true : false);
						
					} 
					
					/** ICI **/
					if (nombreComponente.equals("ReporteICI")) { 
						accesoMenuVo.setMenu_RptICI(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("true") ? true : false);
						
					}if (nombreComponente.equals("Diario")) {
						accesoMenuVo.setSubMenu_ici_diario(new PermisoVo());
						accesoMenuVo.getSubMenu_ici_diario().setAsignado((!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("true") ? true : false));
						accesoMenuVo.getSubMenu_ici_diario().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_ici_diario().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_ici_diario().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_ici_diario().setExportacion(bean.isFlgExport() ? true : false);
						
					}if (nombreComponente.equals("Mensual")) {
						accesoMenuVo.setSubMenu_ici_mensual(new PermisoVo());
						accesoMenuVo.getSubMenu_ici_mensual().setAsignado((!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("true") ? true : false));
						accesoMenuVo.getSubMenu_ici_mensual().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_ici_mensual().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_ici_mensual().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_ici_mensual().setExportacion(bean.isFlgExport() ? true : false);
						
					} 
					
					/** REPORTE ARTICULO **/
					if (nombreComponente.equals("ReporteArticulo")) { 
						accesoMenuVo.setMenu_RptArticulo(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("true") ? true : false);
						
					}if (nombreComponente.equals("Vencimiento")) {
						accesoMenuVo.setSubMenu_articuloRpt_vencimiento(new PermisoVo());
						accesoMenuVo.getSubMenu_articuloRpt_vencimiento().setAsignado((!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("true") ? true : false));
						accesoMenuVo.getSubMenu_articuloRpt_vencimiento().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_articuloRpt_vencimiento().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_articuloRpt_vencimiento().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_articuloRpt_vencimiento().setExportacion(bean.isFlgExport() ? true : false);
						
					} 
					
					/** SEGURIDAD **/
				 	if (nombreComponente.equals("Seguridad")) {
						
						accesoMenuVo.setMenu_Seguridad(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("true") ? true : false);
						
					}if (nombreComponente.equals("usuario")) {
						accesoMenuVo.setSubMenu_seguridad_usuario(new PermisoVo());
						accesoMenuVo.getSubMenu_seguridad_usuario().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_seguridad_usuario().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_seguridad_usuario().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_seguridad_usuario().setExportacion(bean.isFlgExport() ? true : false);
						
					}if (nombreComponente.equals("perfil")) {
						accesoMenuVo.setSubMenu_seguridad_perfil(new PermisoVo());
						accesoMenuVo.getSubMenu_seguridad_perfil().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_seguridad_perfil().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_seguridad_perfil().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_seguridad_perfil().setExportacion(bean.isFlgExport() ? true : false);
					
					}if (nombreComponente.equals("acceso")) {
						accesoMenuVo.setSubMenu_seguridad_acceso(new PermisoVo());
						accesoMenuVo.getSubMenu_seguridad_acceso().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_seguridad_acceso().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_seguridad_acceso().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_seguridad_acceso().setExportacion(bean.isFlgExport() ? true : false); 
					} 
					 
				 	/** HERRAMIENTA **/
					if (nombreComponente.equals("Configuracion")) { 
						accesoMenuVo.setMenu_Configuracion(!VO.isNull(bean.getFlgAsignado()) && bean.getFlgAsignado().equals("true") ? true : false);
						
					}if (nombreComponente.equals("Institucion")) {
						accesoMenuVo.setSubMenu_configuracion_institucion(new PermisoVo());
						accesoMenuVo.getSubMenu_configuracion_institucion().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_configuracion_institucion().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_configuracion_institucion().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_configuracion_institucion().setExportacion(bean.isFlgExport() ? true : false); 
					
					}if (nombreComponente.equals("InventarioConfiguracion")) {
						accesoMenuVo.setSubMenu_configuracion_inventario(new PermisoVo());
						accesoMenuVo.getSubMenu_configuracion_inventario().setLectura(bean.isFlgRead() ? true : false);
						accesoMenuVo.getSubMenu_configuracion_inventario().setEscritura(bean.isFlgWrite() ? true : false);
						accesoMenuVo.getSubMenu_configuracion_inventario().setEliminacion(bean.isFlgDelete() ? true : false);
						accesoMenuVo.getSubMenu_configuracion_inventario().setExportacion(bean.isFlgExport() ? true : false); 
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
	
}