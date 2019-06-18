package hnch.referencia.web.controller.asistencial.referencia;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import gob.hnch.system.ws.sis.model.PersonaSIS;
import gob.hnch.systems.ws.hnch.client.imp.PersonaServiceImp;
import hnch.referencia.core.bean.asistencial.referencia.ReferenciaApoyoDxBean;
import hnch.referencia.core.bean.asistencial.referencia.ReferenciaApoyoDxResultadoBean;
import hnch.referencia.core.bean.asistencial.referencia.ReferenciaBean;
import hnch.referencia.core.bean.asistencial.referencia.ReferenciaDiagnosticoBean;
import hnch.referencia.core.bean.asistencial.referencia.ReferenciaEspecialidadBean;
import hnch.referencia.core.bean.general.PacienteBean;
import hnch.referencia.core.bean.general.PersonaBean;
import hnch.referencia.core.bean.general.PersonalBean;
import hnch.referencia.core.bean.general.RenaesBean;
import hnch.referencia.core.bean.general.TablaBean;
import hnch.referencia.core.bean.seguridad.UsuarioRenaesBean;
import hnch.referencia.core.service.exception.ServiceException;
import hnch.referencia.core.service.interfaces.asistencial.maestra.MaestraAsis01Service;
import hnch.referencia.core.service.interfaces.asistencial.maestra.MaestraAsis03Service;
import hnch.referencia.core.service.interfaces.asistencial.maestra.MaestraAsis05Service;
import hnch.referencia.core.service.interfaces.asistencial.maestra.MaestraAsis06Service;
import hnch.referencia.core.service.interfaces.asistencial.maestra.MaestraAsis14Service;
import hnch.referencia.core.service.interfaces.asistencial.referencia.ReferenciaApoyoDxResultadoService;
import hnch.referencia.core.service.interfaces.asistencial.referencia.ReferenciaApoyoDxService;
import hnch.referencia.core.service.interfaces.asistencial.referencia.ReferenciaCbService;
import hnch.referencia.core.service.interfaces.asistencial.referencia.ReferenciaDiagnosticoService;
import hnch.referencia.core.service.interfaces.asistencial.referencia.ReferenciaEspecialidadService; 
import hnch.referencia.core.service.interfaces.general.PacienteService;
import hnch.referencia.core.service.interfaces.general.PersonaService; 
import hnch.referencia.core.service.interfaces.general.RenaesService;
import hnch.referencia.core.service.interfaces.seguridad.UsuarioRenaesService;
import hnch.referencia.web.controller.asistencial.referencia.view.ReferenciaForm;
import hnch.referencia.web.controller.base.BaseController;
import hnch.referencia.web.utilitarios.FileUtil;
import hnch.referencia.web.utilitarios.ResourceUtil;
import hnch.referencia.web.utilitarios.VO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.web.multipart.MultipartFile;

@Controller
@Scope(value = "session")
@RequestMapping(value = "referenciaController")

public class ReferenciaController extends BaseController {

	private ReferenciaForm referenciaForm;

	private ReferenciaBean referenciaBean;

	private ReferenciaEspecialidadBean referenciaEspecialidadBean;

	private List<ReferenciaEspecialidadBean> lstReferenciaEspecialidadBean;

	private List<ReferenciaApoyoDxBean> lstReferenciaApoyoDxBean;

	private List<ReferenciaApoyoDxResultadoBean> lstReferenciaApoyoResultadoTempBean;

	private List<ReferenciaApoyoDxResultadoBean> lstReferenciaApoyoResultadoBean;

	private List<ReferenciaDiagnosticoBean> lstReferenciaDiagnosticoBean;

	private List<ReferenciaBean> lstReferenciaBean;

	private List<RenaesBean> lstRenaesBean;

	@Autowired
	private ReferenciaCbService referenciaCbService;

	@Autowired
	private ReferenciaEspecialidadService referenciaEspecialidadService;

	@Autowired
	private ReferenciaDiagnosticoService referenciaDiagnosticoService;

	@Autowired
	private ReferenciaApoyoDxResultadoService referenciaApoyoDxResultadoService;

	@Autowired
	private ReferenciaApoyoDxService referenciaApoyoDxService;

	@Autowired
	private PacienteService pacienteService;

	@Autowired
	private MaestraAsis14Service maestraAsis14Service;

	@Autowired
	private MaestraAsis01Service maestraAsis01Service;

	@Autowired
	private MaestraAsis03Service maestraAsis03Service;

	@Autowired
	private MaestraAsis05Service maestraAsis05Service;
	
	@Autowired
	private MaestraAsis06Service maestraAsis06Service;
	 
	@Autowired
	private RenaesService renaesService;

	@Autowired
	private PersonaService personaService;
 

	@Autowired
	UsuarioRenaesService usuarioRenaesService;

	List<TablaBean> lstSituacion = new ArrayList<TablaBean>();
	List<TablaBean> lstUpsDestino = new ArrayList<TablaBean>();
	List<TablaBean> lstCondicionPaciente = new ArrayList<TablaBean>();
	List<TablaBean> lstTipoSeguro = new ArrayList<TablaBean>();
	List<TablaBean> lstPlanAtencion = new ArrayList<TablaBean>();
	List<TablaBean> lstTiempoEnfermedad = new ArrayList<TablaBean>();
	List<TablaBean> lstFormaInicio = new ArrayList<TablaBean>();
	List<TablaBean> lstMotivoReferencia = new ArrayList<TablaBean>();
	List<TablaBean> lstCurso = new ArrayList<TablaBean>();
	List<TablaBean> lstTipoApoyoDX = new ArrayList<TablaBean>();

	List<TablaBean> lstDocumento = new ArrayList<TablaBean>();
	List<TablaBean> lstSexo = new ArrayList<TablaBean>();
	List<TablaBean> lstProfesion = new ArrayList<TablaBean>();
	List<TablaBean> lstEspecialidad = new ArrayList<TablaBean>();
	List<TablaBean> lstCIEX = new ArrayList<TablaBean>();
	List<TablaBean> lstApoyoDX = new ArrayList<TablaBean>();
	List<TablaBean> lstTipoDX = new ArrayList<TablaBean>();
	PersonalBean personalAcompana = new PersonalBean();
	PersonalBean responsableEstablecimiento = new PersonalBean();

	@PostConstruct
	public void init() {
		this.setReferenciaBean(new ReferenciaBean());
		this.setReferenciaForm(new ReferenciaForm());
		this.setLstReferenciaEspecialidadBean(new ArrayList<ReferenciaEspecialidadBean>());
		this.setlstReferenciaApoyoResultadoTempBean(new ArrayList<ReferenciaApoyoDxResultadoBean>());
		this.setLstReferenciaBean(new ArrayList<ReferenciaBean>());
		this.setLstReferenciaDiagnosticoBean(new ArrayList<ReferenciaDiagnosticoBean>());
		this.setLstReferenciaApoyoDxBean(new ArrayList<ReferenciaApoyoDxBean>());
		this.setLstReferenciaApoyoResultadoBean(new ArrayList<ReferenciaApoyoDxResultadoBean>());
		this.setLstRenaesBean(new ArrayList<RenaesBean>());
		this.setPersonalAcompana(new PersonalBean());
		this.setResponsableEstablecimiento(new PersonalBean());
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo(HttpServletRequest request) {
		ReferenciaForm referenciaForm = new ReferenciaForm();
		System.out.println(getUsuarioSesion(request).getPersona().getNombreCompleto());
		PersonalBean responsableEstablecimiento = new PersonalBean();
		referenciaBean = new ReferenciaBean();
		responsableEstablecimiento.setPersona(getUsuarioSesion(request).getPersona());
		// referenciaBean.setResponsableEstablecimiento(responsableEstablecimiento);
		referenciaBean.setResponsableReferencia(responsableEstablecimiento);
		referenciaForm.setReferenciaBean(referenciaBean);
		ModelAndView mav = new ModelAndView("asistencial/referencia/registro-referencia", "command", referenciaForm);

		mav.addObject("referenciaForm", referenciaForm);
		mav.addObject("fechaActual", new Date());
		this.setlstReferenciaApoyoResultadoTempBean(new ArrayList<ReferenciaApoyoDxResultadoBean>());
		this.cargarCombos(mav, request);
		return mav;
	}

	@RequestMapping(value = "/modificar", method = RequestMethod.POST)
	public ModelAndView doModificar(@RequestParam("codigo") Integer index, HttpServletRequest request) {

		System.out.println("modificar codigo: " + index);

		ReferenciaBean oReferenciaBean = new ReferenciaBean();
		oReferenciaBean = this.lstReferenciaBean.get(index);
		System.out.println("modificar oReferenciaBean: " + oReferenciaBean.getCodigo());
		ModelAndView mav = new ModelAndView("asistencial/referencia/registro-referencia", "command", referenciaForm);
		try {
			referenciaBean = referenciaCbService.getBuscarPorObjecto(oReferenciaBean);
			System.out.println("referenciaBean no es null" + referenciaBean.getCodigo());

			referenciaForm.setReferenciaBean(referenciaBean);
			lstReferenciaDiagnosticoBean = referenciaDiagnosticoService.listarPorReferenciaBean(referenciaBean);
			lstReferenciaApoyoDxBean = referenciaApoyoDxService.listarPorReferenciaBean(referenciaBean);
			lstReferenciaApoyoResultadoBean = referenciaApoyoDxResultadoService.listarPorReferenciaBean(referenciaBean);
			referenciaBean.setListReferenciaApoyoDxBean(lstReferenciaApoyoDxBean);
			referenciaBean.setListReferenciaApoyoDxResultadoBean(lstReferenciaApoyoResultadoBean);
			referenciaBean.setListReferenciaDiagnosticoBean(lstReferenciaDiagnosticoBean);

			this.setReferenciaBean(referenciaBean);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		mav.addObject("referenciaForm", referenciaForm);
		mav.addObject("lstReferenciaDiagnosticoBean", lstReferenciaDiagnosticoBean);
		mav.addObject("lstReferenciaApoyoDxBean", lstReferenciaApoyoDxBean);
		mav.addObject("lstReferenciaApoyoResultadoBean", lstReferenciaApoyoResultadoBean);
		this.cargarCombos(mav, request);
		return mav;
	}

	@RequestMapping(value = "/descartar", method = RequestMethod.GET)
	@ResponseBody
	public String descartar(
			// ModelAndView descartar(
			@ModelAttribute("referenciaBean") ReferenciaBean referenciaBean) throws Exception {

		System.out.println("referenciaBean descartar::" + referenciaBean.getCodigo());
		 
		String valida = "";
		try {
			  this.referenciaCbService.eliminar(referenciaBean);
			valida = "1";

		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * lstReferenciaBean = new ArrayList<ReferenciaBean>(); try {
		 * lstReferenciaBean = referenciaCbService.getBuscarPorFiltros(new
		 * ReferenciaBean()); } catch (Exception e) { }
		 */
		System.out.println("lstReferenciaBean size " + lstReferenciaBean.size());
		return valida;
		// return doListado(referenciaBean);

	}

	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("referenciaBean") ReferenciaBean referenciaBean,
			HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView("asistencial/referencia/listado-referencia", "command", referenciaBean);
		referenciaBean.setCodigoUsuarioSession(getUsuarioSesion(request).getCodigo());
		referenciaBean.setCodigoPerfilUsuarioSession(getUsuarioSesion(request).getPerfil().getCodigo());
		lstReferenciaBean = referenciaCbService.getBuscarPorFiltros(referenciaBean);
		mav.addObject("lstReferenciaBean", lstReferenciaBean);
		// this.cargarCombos(mav);
		return mav;
	}

	@RequestMapping(value = "/lista", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView listado(@ModelAttribute("referenciaBean") ReferenciaBean referenciaBean,
			HttpServletRequest request) throws Exception {
		lstReferenciaBean = new ArrayList<ReferenciaBean>();
		ModelAndView mav = new ModelAndView("asistencial/referencia/listado-referencia", "command", referenciaBean);
		referenciaBean.setCodigoUsuarioSession(getUsuarioSesion(request).getCodigo());
		referenciaBean.setCodigoPerfilUsuarioSession(getUsuarioSesion(request).getPerfil().getCodigo());
		lstReferenciaBean = referenciaCbService.getBuscarPorFiltros(referenciaBean);
		mav.addObject("lstReferenciaBean", lstReferenciaBean);
		return mav;
	}
	
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView listadoGet(@ModelAttribute("referenciaBean") ReferenciaBean referenciaBean,
			HttpServletRequest request) throws Exception {
		lstReferenciaBean = new ArrayList<ReferenciaBean>();
		ModelAndView mav = new ModelAndView("asistencial/referencia/listado-referencia", "command", referenciaBean);
		referenciaBean.setCodigoUsuarioSession(getUsuarioSesion(request).getCodigo());
		referenciaBean.setCodigoPerfilUsuarioSession(getUsuarioSesion(request).getPerfil().getCodigo());
		lstReferenciaBean = referenciaCbService.getBuscarPorFiltros(referenciaBean);
		mav.addObject("lstReferenciaBean", lstReferenciaBean);
		return mav;
	}

	protected void cargarArchivo(String rootPath, String urlArchivo, MultipartFile multipartFile) {

		try {
			byte[] bytes = multipartFile.getBytes();
			File dir = FileUtil.fileExists(rootPath);
			File serverFile = new File(dir.getAbsolutePath() + File.separator + urlArchivo);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getRootPathApoyoResultado() {
		return ResourceUtil.getKey("ruta.webhnch.archivos.resultados");
	}

	@SuppressWarnings("unused")
	private String renombrarImagen(MultipartFile files[], String codUnidad) {
		boolean swNuevaUrlImagen = false;
		String nombreImagen = null;
		if (files != null) {
			if (files.length > 0) {
				for (int i = 0; i < files.length; i++) {
					swNuevaUrlImagen = (files[i] != null) && (files[i].getOriginalFilename() != null)
							&& (files[i].getOriginalFilename().trim().length() > 0);

					MultipartFile fileImagen = null;
					if (swNuevaUrlImagen) {
						fileImagen = files[i];
						if (files[i].getOriginalFilename() != null) {
							nombreImagen = files[i].getOriginalFilename();
						}
					}
					System.out.println("busca ::" + nombreImagen.indexOf("_"));

					if (nombreImagen.indexOf("_") == -1) {

						nombreImagen = String.valueOf(codUnidad) + "_" + VO.convertirCaracteresEsp(nombreImagen);

					} else {
						//
						nombreImagen = String.valueOf(codUnidad) + "_"
								+ nombreImagen.substring(nombreImagen.indexOf("_") + 1, nombreImagen.length());
						//
					}

					System.out.println("nombreImagen" + nombreImagen);
				}
			} else {
				System.out.println("files menor a 0");
			}
		}

		return nombreImagen;
	}

	@RequestMapping(value = "/eliminarApoyoDxResultadoBean", method = RequestMethod.POST)
	@ResponseBody
	public List<ReferenciaApoyoDxResultadoBean> eliminarReferenciaApoyoDxResultadoBean(
			@RequestParam("codRegApoyo") String codRegApoyo) throws Exception {

		System.out.println("listarReferenciaApoyoDxResultadoBean " + codRegApoyo);

		try {
			for (ReferenciaApoyoDxResultadoBean lst : lstReferenciaApoyoResultadoTempBean) {
				if (lst.getApoyoDX().getCodReg().equals(codRegApoyo)) {
					lstReferenciaApoyoResultadoTempBean.remove(lst);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lstReferenciaApoyoResultadoTempBean;

	}

	@RequestMapping(value = "/listarReferenciaApoyoDxResultadoBean", method = RequestMethod.POST)
	@ResponseBody
	public List<ReferenciaApoyoDxResultadoBean> listarReferenciaApoyoDxResultadoBean(
			@RequestParam("codRegApoyo") String codRegApoyo, @RequestParam("nombreApoyo") String nombreApoyo,
			@RequestParam("codRegTipoApoyo") String codRegTipoApoyo,
			@RequestParam("nombreTipoApoyo") String nombreTipoApoyo) throws Exception {
		System.out.println("listarReferenciaApoyoDxResultadoBean " + nombreApoyo);
		int val = 0;
		ReferenciaApoyoDxResultadoBean oReferenciaApoyoDxResultadoBean = new ReferenciaApoyoDxResultadoBean();
		oReferenciaApoyoDxResultadoBean.getTipoApoyo().setCodReg(codRegTipoApoyo);
		oReferenciaApoyoDxResultadoBean.getTipoApoyo().setNombreCorto(nombreTipoApoyo);
		oReferenciaApoyoDxResultadoBean.getApoyoDX().setCodReg(codRegApoyo);
		oReferenciaApoyoDxResultadoBean.getApoyoDX().setNombreCorto(nombreApoyo);
		oReferenciaApoyoDxResultadoBean.setNombreDocumentoResultado("");
		try {
			for (ReferenciaApoyoDxResultadoBean lst : lstReferenciaApoyoResultadoTempBean) {
				if (lst.getApoyoDX().getCodReg().equals(codRegApoyo)
						&& lst.getTipoApoyo().getCodReg().equals(codRegTipoApoyo)) {
					val = 1;
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (val == 0) {
			lstReferenciaApoyoResultadoTempBean.add(oReferenciaApoyoDxResultadoBean);
			return lstReferenciaApoyoResultadoTempBean;
		} else {
			return null;
		}

	}

	@RequestMapping(value = "/listarReferenciaApoyoDxResultadoBeanImage", method = RequestMethod.POST)
	@ResponseBody
	public List<ReferenciaApoyoDxResultadoBean> listarReferenciaApoyoDxResultadoBeanImage(
			@RequestParam("codRegApoyo") String codRegApoyo, @RequestParam("nombreApoyo") String nombreApoyo,
			@RequestParam("codRegTipoApoyo") String codRegTipoApoyo,
			@RequestParam("nombreTipoApoyo") String nombreTipoApoyo, @RequestParam("files") MultipartFile[] files)
			throws Exception {
		System.out.println("listarReferenciaApoyoDxResultadoBean " + nombreApoyo);
		int val = 0;
		ReferenciaApoyoDxResultadoBean oReferenciaApoyoDxResultadoBean = new ReferenciaApoyoDxResultadoBean();
		oReferenciaApoyoDxResultadoBean.getTipoApoyo().setCodReg(codRegTipoApoyo);
		oReferenciaApoyoDxResultadoBean.getTipoApoyo().setNombreCorto(nombreTipoApoyo);
		oReferenciaApoyoDxResultadoBean.getApoyoDX().setCodReg(codRegApoyo);
		oReferenciaApoyoDxResultadoBean.getApoyoDX().setNombreCorto(nombreApoyo);

		boolean swNuevaUrlImagen = false;
		if (files.length > 0 && files != null) {

			swNuevaUrlImagen = (files[0] != null)
					&& (files[0].getOriginalFilename() != null && files[0].getOriginalFilename() != "")
					&& (files[0].getOriginalFilename().trim().length() > 0);

			System.out.println("swNuevaUrlImagen " + swNuevaUrlImagen);
			System.out.println("nombre Archivo:: " + files[0].getOriginalFilename());
			oReferenciaApoyoDxResultadoBean
					.setNombreDocumentoResultado(VO.convertirCaracteresEsp(files[0].getOriginalFilename()));
			if (swNuevaUrlImagen) {
				// oReferenciaApoyoDxResultadoBean.setFileResultado(files[0]);
				super.cargarArchivo(this.getRootPathApoyoResultado(), renombrarImagen(files, codRegApoyo), files[0]);
			}
		}
		try {
			for (ReferenciaApoyoDxResultadoBean lst : lstReferenciaApoyoResultadoTempBean) {
				if (lst.getApoyoDX().getCodReg().equals(codRegApoyo)
						&& lst.getTipoApoyo().getCodReg().equals(codRegTipoApoyo)) {
					val = 1;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (val == 0) {
			lstReferenciaApoyoResultadoTempBean.add(oReferenciaApoyoDxResultadoBean);
			return lstReferenciaApoyoResultadoTempBean;
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/grabarReferencia", method = RequestMethod.POST)
	@ResponseBody
	public String grabarReferencia(@ModelAttribute("referenciaForm") ReferenciaForm referenciaForm,
			@RequestParam("cie10") String[] listadoCIEX, @RequestParam("apoyoDx") String[] listadoApoyoDx,
			HttpServletRequest request) {

		String codigoReferencia = "";
		boolean sw = false;

		/*
		 * System.out.println(" grabar getHoraIngresoRef :: " +
		 * referenciaForm.getReferenciaBean().getHoraIngresoRef());
		 * System.out.println(" grabar grabarReferenciaEspecialidad " +
		 * referenciaForm);
		 * System.out.println(" grabar grabarReferenciaEspecialidad " +
		 * referenciaForm.getReferenciaBean().getEstablecimientoOrige().
		 * getCodRenaes());
		 * System.out.println(" grabar grabarReferenciaEspecialidad " +
		 * listadoCIEX.hashCode());
		 * 
		 */

		for (String prmAcceso : listadoCIEX) {
			System.out.println("getCodReg == >" + prmAcceso);
		}

		ReferenciaDiagnosticoBean referenciaDiagnosticoBean = new ReferenciaDiagnosticoBean();
		ReferenciaApoyoDxBean referenciaApoyoDxBean = new ReferenciaApoyoDxBean();

		System.out.println(
				"inscripcionForm.getStrfechaIngresoRef " + referenciaForm.getReferenciaBean().getStrfechaIngresoRef());
		System.out.println(
				"inscripcionForm.getFechaIngresoRef " + referenciaForm.getReferenciaBean().getFechaIngresoRef());
		System.out.println("llegó a grabar personalBean " + referenciaForm);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String fechaComoCadena = sdf.format(referenciaForm.getReferenciaBean().getFechaIngresoRef());
		System.out.println(fechaComoCadena);
		referenciaForm.getReferenciaBean().setStrfechaIngresoRef(fechaComoCadena);
		if (!referenciaForm.getReferenciaBean().getServicioUPSReferencia().getCodReg().equals("000001")) {
			referenciaForm.getReferenciaBean().getEspecialidad().setCodReg("");
			lstReferenciaApoyoResultadoTempBean = new ArrayList<ReferenciaApoyoDxResultadoBean>();
		}
		try {

			if (referenciaForm.getReferenciaBean().getCodigo().equals("")) {
				System.out.println("referenciaForm.getReferenciaBean().getPaciente().getTipoSeguro().getCodReg() "
						+ referenciaForm.getReferenciaBean().getPaciente().getTipoSeguro().getCodReg());
				this.setAuditoria(referenciaForm.getReferenciaBean().getPaciente(), request, true);
				System.out.println("referenciaForm.getReferenciaBean().getPaciente().getPersona.getCodigo "
						+ referenciaForm.getReferenciaBean().getPaciente().getPersona().getCodigo());
				System.out.println("referenciaForm.getReferenciaBean().getPaciente().getPersona.getCodigo "
						+ referenciaForm.getReferenciaBean().getPaciente().getPersona().getNumeroPeriodo());
				if (pacienteService.insertar(referenciaForm.getReferenciaBean().getPaciente())) {
					System.out.println("getPaciente() " + referenciaForm.getReferenciaBean().getPaciente());
				}
				if (personaService.insertar(this.getResponsableEstablecimiento().getPersona())) {
					System.out.println("getResponsableEstablecimiento() "
							+ this.getResponsableEstablecimiento().getPersona().getCodigo());
					referenciaForm.getReferenciaBean().getResponsableEstablecimiento().getPersona()
							.setCodigo(this.getResponsableEstablecimiento().getPersona().getCodigo());
					referenciaForm.getReferenciaBean().getResponsableEstablecimiento().getPersona()
							.setNumeroPeriodo(this.getResponsableEstablecimiento().getPersona().getNumeroPeriodo());
				}
				if (personaService.insertar(this.getPersonalAcompana().getPersona())) {
					System.out.println("getPersonalAcompana() " + this.getPersonalAcompana().getPersona().getCodigo());
					referenciaForm.getReferenciaBean().getPersonalAcompanante().getPersona()
							.setCodigo(this.getPersonalAcompana().getPersona().getCodigo());
					referenciaForm.getReferenciaBean().getPersonalAcompanante().getPersona()
							.setNumeroPeriodo(this.getPersonalAcompana().getPersona().getNumeroPeriodo());
				}
				// INSERT
				this.setAuditoria(referenciaForm.getReferenciaBean(), request, true);
				sw = (this.referenciaCbService.insertar(referenciaForm.getReferenciaBean()));

				if (sw) {
					referenciaDiagnosticoBean.setReferenciaBean(referenciaForm.getReferenciaBean());
					if (referenciaForm.getReferenciaBean().getServicioUPSReferencia().getCodReg().equals("000002")) { // Apoyo
																														// al
																														// DX
						this.setAuditoria(referenciaApoyoDxBean, request, true);
						for (String data : listadoApoyoDx) {
							System.out.println("data == >" + data.toString());
							int ind = data.indexOf("/");
							System.out.println("ind " + ind);
							String codigoReg = data.substring(0, ind);
							String codigoRegTipo = data.substring(ind + 1, data.length());
							System.out.println("codigoReg " + codigoReg);
							referenciaApoyoDxBean.setReferenciaBean(referenciaForm.getReferenciaBean());
							referenciaApoyoDxBean.getApoyoDX().setCodReg(codigoReg);
							referenciaApoyoDxBean.getTipoApoyo().setCodReg(codigoRegTipo);
							sw = (this.referenciaApoyoDxService.insertar(referenciaApoyoDxBean));
						}
					}
					this.setAuditoria(referenciaDiagnosticoBean, request, true);
					/**
					 * for (int i = 0; i < listadoCIEX.length; i++) { TablaBean
					 * prmAcceso = listadoCIEX[i];
					 * referenciaDiagnosticoBean.getDiagnostico().setCodReg(prmAcceso.getCodReg());
					 * referenciaDiagnosticoBean.getEspecialidad().setCodReg(prmAcceso.getValor6());
					 * sw =
					 * (this.referenciaDiagnosticoService.insertar(referenciaDiagnosticoBean));
					 * }
					 */

					for (String data : listadoCIEX) {
						System.out.println("subNiveles == >" + data.toString());
						System.out.println("data == >" + data.toString());
						int ind = data.indexOf("/");
						int indTipo = data.indexOf("-");
						System.out.println("ind " + ind);
						String codigoDiagnostico = data.substring(0, ind);
						String codigoEspecialidad = data.substring(ind + 1, indTipo);
						String codigoTipoDX = data.substring(indTipo + 1, data.length());
						System.out.println("codigoReg " + codigoDiagnostico);
						System.out.println("codigoTipoDX " + codigoTipoDX);
						referenciaDiagnosticoBean.getDiagnostico().setCodReg(codigoDiagnostico);
						referenciaDiagnosticoBean.getEspecialidad().setCodReg(codigoEspecialidad);
						referenciaDiagnosticoBean.getTipo().setCodReg(codigoTipoDX);
						sw = (this.referenciaDiagnosticoService.insertar(referenciaDiagnosticoBean));
					}

					for (ReferenciaApoyoDxResultadoBean oReferenciaApoyoDxResultadoBean : lstReferenciaApoyoResultadoTempBean) {
						this.setAuditoria(oReferenciaApoyoDxResultadoBean, request, true);
						oReferenciaApoyoDxResultadoBean.setReferenciaBean(referenciaForm.getReferenciaBean());
						sw = (this.referenciaApoyoDxResultadoService.insertar(oReferenciaApoyoDxResultadoBean));
					}

				}

				codigoReferencia = referenciaForm.getReferenciaBean().getCodigo();

			} else {
				// UPDATE
				this.setAuditoria(referenciaForm.getReferenciaBean(), request, false);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("sw " + sw);
		return codigoReferencia;
		/**
		 * if (sw) {
		 * 
		 * ModelAndView mav = new
		 * ModelAndView("asistencial/referencia/listado-referencia",
		 * "command",new ReferenciaBean()); return codigoReferencia; } else {
		 * ModelAndView mav = new
		 * ModelAndView("asistencial/referencia/registro-referencia",
		 * "command",new ReferenciaForm()); return codigoReferencia; }
		 */
	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "/grabarReferenciaEspecialidad", method = RequestMethod.POST)
	public ModelAndView grabarReferenciaEspecialidad(@ModelAttribute("referenciaForm") ReferenciaForm referenciaForm,
			@RequestParam("especialidad") String[] especialidad, HttpServletRequest request) {

		System.out.println(" grabar grabarReferenciaEspecialidad " + referenciaForm);
		PersonaBean prmPersona = new PersonaBean();
		boolean sw = false;

		System.out.println("llegó a grabar personalBean " + referenciaForm);

		try {

			if (referenciaForm.getReferenciaBean().getCodigo().equals("")) {

				// prmPersona=personalBean.getPersonaBean();

				if (prmPersona == null) {

					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					this.setAuditoria(prmPersona, request, true);
					sw = (this.referenciaEspecialidadService.insertar(referenciaForm.getReferenciaEspecialidadBean()));

				}

			} else {

				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				// this.setAuditoria(personalBean, request, false);
				// sw = (this.getPersonalService().actualizar(personalBean));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (sw) {
			ModelAndView mav = new ModelAndView("general/registro-administrativo", "command", referenciaForm);
			mav.addObject("fechaActual", new Date());
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("general/registro-administrativo", "command", referenciaForm);
			mav.addObject("fechaActual", new Date());
			return mav;
		}

	}

	private void cargarCombos(ModelAndView mav, HttpServletRequest request) {
		try {
			lstUpsDestino = maestraAsis14Service.listarPorCodigoTabla("000001", 1);
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		try {
			lstCondicionPaciente = maestraAsis14Service.listarPorCodigoTabla("000006", 0);
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		try {
			lstTipoSeguro = maestraAsis14Service.listarPorCodigoTabla("000007", 1);
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		try {
			lstPlanAtencion = maestraAsis14Service.listarPorCodigoTabla("000002", 0);
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		try {
			lstProfesion = maestraAsis14Service.listarPorCodigoTabla("000005", 0);
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}

		try {
			lstTiempoEnfermedad = maestraAsis01Service.listarPorCodigoTabla("000047", 2);
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		try {
			lstFormaInicio = maestraAsis01Service.listarPorCodigoTabla("000048", 2);
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		try {
			lstCurso = maestraAsis01Service.listarPorCodigoTabla("000049", 2);
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		try {
			lstMotivoReferencia = maestraAsis14Service.listarPorCodigoTabla("000008", 1);
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		try {
			lstTipoApoyoDX = maestraAsis14Service.listarPorCodigoTabla("000009", 2);
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		try {
			lstTipoDX = maestraAsis01Service.listarPorCodigoTabla("000021", 0);
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		List<UsuarioRenaesBean> lstUsuarioRenaesBean = null;
		List<UsuarioRenaesBean> listaUsuarioRenaesBean = new ArrayList<UsuarioRenaesBean>();
		UsuarioRenaesBean objUsuarioRenaesBean = new UsuarioRenaesBean();
		objUsuarioRenaesBean.getRenaes().setNomRenaes("Seleccionar");
		objUsuarioRenaesBean.getRenaes().setCodigo("");
		try {
			lstUsuarioRenaesBean = usuarioRenaesService.buscarxcodigousua(this.getUsuarioSesion(request));
			if (lstUsuarioRenaesBean != null) {
				if (lstUsuarioRenaesBean.size() > 1) {
					listaUsuarioRenaesBean.add(objUsuarioRenaesBean);
					for (UsuarioRenaesBean lst : lstUsuarioRenaesBean) {
						listaUsuarioRenaesBean.add(lst);
					}
					lstUsuarioRenaesBean = listaUsuarioRenaesBean;
				}
			} else {
				lstUsuarioRenaesBean = new ArrayList<UsuarioRenaesBean>();
				lstUsuarioRenaesBean.add(objUsuarioRenaesBean);
			}
		} catch (Exception e) {

		}

		/*
		 * if (lstCIEX.size() == 0) { try { lstCIEX =
		 * maestraAsis06Service.listarPorCodigoTabla("000004",0); } catch
		 * (ServiceException e) { System.out.println("printStackTrace");
		 * e.printStackTrace(); } }
		 */

		// mav.addObject("lstCIEX",lstCIEX);
		mav.addObject("lstUpsDestino", lstUpsDestino);
		mav.addObject("lstCondicionPaciente", lstCondicionPaciente);
		mav.addObject("lstTipoSeguro", lstTipoSeguro);
		mav.addObject("lstPlanAtencion", lstPlanAtencion);
		mav.addObject("lstProfesion", lstProfesion);
		mav.addObject("lstTiempoEnfermedad", lstTiempoEnfermedad);
		mav.addObject("lstFormaInicio", lstFormaInicio);
		mav.addObject("lstCurso", lstCurso);
		mav.addObject("lstMotivoReferencia", lstMotivoReferencia);
		mav.addObject("lstTipoApoyoDX", lstTipoApoyoDX);
		mav.addObject("lstTipoDX", lstTipoDX);
		mav.addObject("lstUsuarioRenaesBean", lstUsuarioRenaesBean);

	}

	@RequestMapping(value = "/refrescarListaCIE10", method = RequestMethod.GET)
	public @ResponseBody String refrescarListaCIE10() throws Exception {
		System.out.println("lstCIEX.size() " + lstCIEX.size());

		if (lstCIEX.size() == 0) {
			try {
				lstCIEX = maestraAsis06Service.listarPorCodigoTabla("000004", 0);
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}
		}

		return "lstCiex";
	}

	@RequestMapping(value = "/personaModal", method = RequestMethod.POST)
	public ModelAndView personaModal() throws Exception {

		ModelAndView mav = new ModelAndView("asistencial/referencia/persona-registro-modal", "command",
				new PacienteBean());
		mav.addObject("pacienteBean", new PersonaBean());
		this.listarCombosPaciente(mav);
		return mav;
	}

	@RequestMapping(value = "/personalModal", method = RequestMethod.POST)
	public ModelAndView personalModal() throws Exception {
		System.out.println("personalModal");
		ModelAndView mav = new ModelAndView("asistencial/referencia/personal-registro-modal", "command",
				new PersonalBean());
		mav.addObject("personalBean", new PersonalBean());
		this.listarCombosPaciente(mav);
		return mav;
	}

	@RequestMapping(value = "/consultarPorDocumentoPersona", method = RequestMethod.GET)
	public @ResponseBody PersonalBean consultarPorNroDocumento(@RequestParam("tipoDocumento") String tipoDocumento,
			@RequestParam("numero") String numero) throws Exception {

		PersonalBean personal = new PersonalBean();
		PersonaBean personaBean = new PersonaBean();
		PersonaBean prmPersona = new PersonaBean();
		prmPersona.setNroDocumento(numero);
		prmPersona.getTipoDocumento().setCodReg(tipoDocumento);
		try {
			personaBean = personaService.buscarxTipoDocumentoNumeroDocumento(prmPersona);
			if (personaBean != null) {
				System.out.println("persona existe en reco.persona");
				personal.setPersona(personaBean);

			} else {
				personaBean = personaService.buscarxTipoDocumentoNumeroDocumentoSigeho(prmPersona);
				if (personaBean != null) {
					System.out.println("persona existe en sigehov2gene");
					System.out.println(personaBean.getNombreCompleto());
					System.out.println("fechNac" + personaBean.getFechaNac());
					personaBean.setCodigo("");
					personal.setPersona(personaBean);
					System.out.println("personal nombrecompleto " + personal.getPersona().getNombreCompleto());

				} else {
					List<gob.hnch.systems.ws.ext.model.Persona> lstPersona = new ArrayList<gob.hnch.systems.ws.ext.model.Persona>();
					PersonaServiceImp persona = new PersonaServiceImp();
					gob.hnch.systems.ws.ext.model.Persona perso = persona.getPersona(numero);
					System.out.println("personaaaa" + perso.toString());
					lstPersona.add(perso);
					if (perso != null) {
						System.out.println("personaBean no es null " + perso.getApSegundo());
						personal.getPersona().setApellidoMaterno(perso.getApSegundo());
						personal.getPersona().setApellidoPaterno(perso.getApPrimer());
						personal.getPersona().setPrimerNombre(perso.getPrenomInscrito());
						SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyyMMdd");
						String strFecha = perso.getFeNacimiento();
						Date fecha = null;
						try {

							fecha = formatoDelTexto.parse(strFecha);

						} catch (ParseException ex) {

							ex.printStackTrace();

						}

						personal.getPersona().setFechaNac(fecha);
						System.out.println("personaBean no es null " + personal.getPersona().getNombreCompleto());

						if (perso.getDeGenero().equals("1")) {
							personal.getPersona().getSexo().setCodReg("000002");
						} else {
							personal.getPersona().getSexo().setCodReg("000001");
						}
						System.out.println("tipoDocumento " + tipoDocumento);

						PersonaSIS personasis = new PersonaSIS();
						personasis.setNrodocumento(numero);
					}

				}
			}
		} catch (Exception e) {

		}

		return personal;
	}

	@RequestMapping(value = "/modaldescartarReferencia", method = RequestMethod.POST)
	public ModelAndView modaldescartarReferencia(@RequestParam("index") Integer index) throws Exception {

		List<TablaBean> lstMotivos = maestraAsis14Service.listarPorCodigoTabla("000011", 1);

		ReferenciaBean oReferenciaBean = new ReferenciaBean();
		oReferenciaBean = this.lstReferenciaBean.get(index);
		ModelAndView mav = new ModelAndView("asistencial/referencia/descartar-referencia", "command", oReferenciaBean);

		mav.addObject("lstMotivos", lstMotivos);
		mav.addObject("referenciaBean", oReferenciaBean);

		return mav;
	}

	@RequestMapping(value = "/establecimientoModal", method = RequestMethod.POST)
	public ModelAndView establecimientoModal(@ModelAttribute("renaesBean") RenaesBean renaesBean) throws Exception {

		ModelAndView mav = new ModelAndView("asistencial/referencia/listado-establecimiento-modal", "command",
				new RenaesBean());
		renaesBean.setCodigoDisa("20");
		try {
			if (lstRenaesBean.size() == 0) {
				lstRenaesBean = renaesService.getBuscarPorFiltros(renaesBean);
			}

		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		mav.addObject("lstRenaesBean", lstRenaesBean);

		return mav;
	}

	@RequestMapping(value = "/listadoCIEXModal", method = RequestMethod.POST)
	public ModelAndView listadoCIEXModal() throws Exception {

		ModelAndView mav = new ModelAndView("asistencial/referencia/listado-ciex-modal", "command", new TablaBean());
		/*
		 * try { if (lstCIEX.size() == 0) { lstCIEX =
		 * maestraAsis06Service.listarPorCodigoTabla("000004",0); } } catch
		 * (ServiceException e) { System.out.println("printStackTrace");
		 * e.printStackTrace(); }
		 */
		lstCIEX = new ArrayList<TablaBean>();
		mav.addObject("lstCIEX", lstCIEX);
		return mav;
	}

	@RequestMapping(value = "/refrescarListCIEX", method = RequestMethod.GET)
	public @ResponseBody List<TablaBean> refrescarListCIEX(@ModelAttribute("TablaBean") TablaBean tablaBean)
			throws Exception {

		// List<TablaBean> lstCIEX = new ArrayList<TablaBean>();

		try {
			lstCIEX = maestraAsis06Service.buscar(tablaBean);
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}

		return lstCIEX;
	}

	@RequestMapping(value = "/especialidadesModal", method = RequestMethod.POST)
	public ModelAndView especialidadesModal() throws Exception {

		ModelAndView mav = new ModelAndView("asistencial/referencia/listado-especialidades-modal", "command",
				new TablaBean());
		mav.addObject("tablaBean", new TablaBean());
		try {
			lstEspecialidad = maestraAsis03Service.listarPorCodigoTabla("000001", 3);
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		mav.addObject("lstEspecialidad", lstEspecialidad);
		return mav;
	}

	@RequestMapping(value = "/establecimientosModal", method = RequestMethod.POST)
	public ModelAndView establecimientosModal() throws Exception {

		ModelAndView mav = new ModelAndView("asistencial/referencia/listado-establecimiento-modal", "command",
				new TablaBean());
		mav.addObject("tablaBean", new TablaBean());
		try {
			lstEspecialidad = maestraAsis03Service.listarPorCodigoTabla("000001", 3);
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		mav.addObject("lstEspecialidad", lstEspecialidad);
		return mav;
	}

	private void listarCombosPaciente(ModelAndView mav) {
		try {
			lstTipoSeguro = maestraAsis14Service.listarPorCodigoTabla("000007", 1);
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		try {
			lstDocumento = maestraAsis14Service.listarPorCodigoTabla("000003", 1);
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		try {
			lstSexo = maestraAsis14Service.listarPorCodigoTabla("000004", 1);
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}

		mav.addObject("lstTipoSeguro", lstTipoSeguro);
		mav.addObject("lstSexo", lstSexo);
		mav.addObject("lstDocumento", lstDocumento);

	}

	@RequestMapping(value = "/listadoDXModal", method = RequestMethod.POST)
	public ModelAndView listadoDXModal(@RequestParam("tipoApoyo") String tipoApoyo) throws Exception {
		
		ModelAndView mav = new ModelAndView("asistencial/referencia/listado-apoyoDX-modal", "command", new TablaBean());
		System.out.println("tipoApoyo ::: " + tipoApoyo);
		TablaBean tabla = new TablaBean();
		tabla.setTabla("000001");
		tabla.setValor10(tipoApoyo);
	/**	try { 
				lstApoyoDX = maestraAsis05Service.listarPorFiltros(tabla, 0);
			 

		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}*/
		lstApoyoDX = new ArrayList<TablaBean>();
		mav.addObject("tipoApoyo", tipoApoyo);
		mav.addObject("lstApoyoDX", lstApoyoDX);
		return mav;
	}

	@RequestMapping(value = "/refrescarListaEspecialidades", method = RequestMethod.GET)
	public @ResponseBody List<TablaBean> refrescarListaInstSede(@RequestParam("nombreCorto") String nombreCorto)
			throws Exception {
		List<TablaBean> lstEspecialidades = new ArrayList<TablaBean>();
		if (nombreCorto.trim().equals("")) {
			try {
				lstEspecialidad = maestraAsis03Service.listarPorCodigoTabla("000001", 3);

			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}
		} else {
			for (TablaBean especialidades : lstEspecialidad) {
				if (especialidades.getNombreCorto().toUpperCase().contains(nombreCorto.toUpperCase())) {
					lstEspecialidades.add(especialidades);
				}
			}
		}
		if (nombreCorto.trim().equals("")) {
			return lstEspecialidad;
		} else {
			return lstEspecialidades;
		}

	}

	@RequestMapping(value = "/refrescarListaDX", method = RequestMethod.GET)
	public @ResponseBody List<TablaBean> refrescarListaDX(@RequestParam("nombreCorto") String nombreCorto,
			@RequestParam("tipoApoyo") String tipoApoyo) throws Exception {
		List<TablaBean> lstApoyos = new ArrayList<TablaBean>();
		TablaBean tabla = new TablaBean();
		tabla.setTabla("000001");
		tabla.setValor10(tipoApoyo);
		System.out.println("tipoApoyo " + tipoApoyo);
		try { 
			lstApoyoDX = maestraAsis05Service.listarPorFiltros(tabla, 0);
		 

		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		if(lstApoyoDX != null){
			for (TablaBean especialidades : lstApoyoDX) {
				if (especialidades.getNombreCorto().toUpperCase().contains(nombreCorto.toUpperCase())) {
					lstApoyos.add(especialidades);
				}
			}
		}
			
		 
		if (nombreCorto.trim().equals("")) {
			return lstApoyoDX;
		} else {
			return lstApoyos;
		}

	}
	@RequestMapping(value = "/listadoGrabado", method = RequestMethod.POST)
	public ModelAndView listadoGrabado(@ModelAttribute("referenciaBean") ReferenciaBean referenciaBean)
			throws Exception {
		ModelAndView mav = new ModelAndView("asistencial/referencia/listado-referencia", "command", referenciaBean);

		mav.addObject("lstReferenciaBean", new ArrayList<ReferenciaBean>());
		// this.cargarCombos(mav);
		return mav;
	}

	@RequestMapping(value = "/refrescarListaCIEXREF", method = RequestMethod.GET)
	public @ResponseBody TablaBean refrescarListaCIEXREF(@RequestParam("index") int index) throws Exception {
		System.out.println("index " + index);
		TablaBean objCIEX = new TablaBean(); 
		objCIEX = lstCIEX.get(index); 
		return objCIEX;
	}

	@RequestMapping(value = "/refrescarListaApoyoDX", method = RequestMethod.GET)
	public @ResponseBody TablaBean refrescarListaApoyoDX(@RequestParam("codReg") String codReg// ,
																								// @RequestParam("tipoApoyo")
																								// String
																								// tipoApoyo
	) throws Exception {
		System.out.println("codReg " + codReg);
		TablaBean objApoyoDX = new TablaBean();
		 
		for (TablaBean apoyo : lstApoyoDX) {
			if (apoyo.getCodReg().equals(codReg)) {
				objApoyoDX = apoyo;
				break;
			}

		}

		System.out.println("objCIEX " + objApoyoDX);
		return objApoyoDX;
	}

	@RequestMapping(value = "/refrescarListaApoyoResultados", method = RequestMethod.GET)
	public @ResponseBody TablaBean refrescarListaApoyoResultados(@RequestParam("index") int index) throws Exception {
		System.out.println("index " + index);
		TablaBean objCIEX = new TablaBean();

		if (lstCIEX.size() == 0) {
			try {
				lstCIEX = maestraAsis06Service.listarPorCodigoTabla("000004", 0);
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}
		}

		objCIEX = lstCIEX.get(index);

		System.out.println("objCIEX " + objCIEX);
		return objCIEX;
	}

	/***
	 * public JasperReportsPdfView getHelloWorldReport() { JasperReportsPdfView
	 * v = new JasperReportsPdfView();
	 * v.setUrl("asistencial/referencia/reporte/rptReferencia.jasper");
	 * v.setReportDataKey("datasource"); return v; }
	 * 
	 * @Autowired @Qualifier("helloWorldReport2") private JasperReportsPdfView
	 *            helloReport;
	 * 
	 * @RequestMapping(value = "rptReferencia", method = RequestMethod.GET)
	 *                       public ModelAndView getRpt2(ModelAndView
	 *                       modelAndView) { Map parametro = new HashMap();
	 *                       parametro.put("paciente", "Alicia Villon Coveñas");
	 *                       modelAndView = new ModelAndView(helloReport,
	 *                       parametro); return modelAndView; }
	 */

	@RequestMapping(value = "rptReferencia", method = RequestMethod.GET)
	@ResponseBody
	public void getRpt1(HttpServletResponse response, HttpServletRequest request) throws JRException, IOException {
		InputStream jasperStream = this.getClass().getResourceAsStream("/reportes/rptReferencia.jasper");
		Map<String, Object> parametro = new HashMap<String, Object>();
		parametro.put("usuario", getUsuarioSesion(request).getNombreUsuario());
		System.out.println("jasperStream " + jasperStream);
		List<ReferenciaBean> rates = new ArrayList<ReferenciaBean>();
		rates.add(getReferenciaBean());
		// data source
		// JRDataSource dataSource = getDataSource(rates);
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(rates);
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametro, dataSource);

		response.setContentType("application/x-pdf");
		response.setHeader("Content-disposition",
				"inline; filename=referencia" + getReferenciaBean().getCodigo() + ".pdf");

		final OutputStream outStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	}

	@RequestMapping(value = "/llenarPersonal", method = RequestMethod.GET)
	public @ResponseBody PersonalBean listarEstablecimiento(@ModelAttribute("personalBean") PersonalBean personalBean,
			@RequestParam("tipo") String tipo) throws Exception {
		PersonalBean objPersonal = new PersonalBean();
		objPersonal = personalBean;
		if (tipo.equals("1")) { // responsableEstablecimiento
			this.setResponsableEstablecimiento(personalBean);
		} else {
			this.setPersonalAcompana(personalBean);
		}
		return objPersonal;
	}

	 
	public void setValoresPredeterminados(ReferenciaBean referenciaBean) {
		referenciaBean.setNumeroPeriodo("");
		referenciaBean.getSituacion().setCodReg("0");
		;
	}

	public ReferenciaForm getReferenciaForm() {
		return referenciaForm;
	}

	public void setReferenciaForm(ReferenciaForm referenciaForm) {
		this.referenciaForm = referenciaForm;
	}

	public ReferenciaBean getReferenciaBean() {
		return referenciaBean;
	}

	public void setReferenciaBean(ReferenciaBean referenciaBean) {
		this.referenciaBean = referenciaBean;
	}

	public ReferenciaEspecialidadBean getReferenciaEspecialidadBean() {
		return referenciaEspecialidadBean;
	}

	public void setReferenciaEspecialidadBean(ReferenciaEspecialidadBean referenciaEspecialidadBean) {
		this.referenciaEspecialidadBean = referenciaEspecialidadBean;
	}

	public List<ReferenciaEspecialidadBean> getLstReferenciaEspecialidadBean() {
		return lstReferenciaEspecialidadBean;
	}

	public void setLstReferenciaEspecialidadBean(List<ReferenciaEspecialidadBean> lstReferenciaEspecialidadBean) {
		this.lstReferenciaEspecialidadBean = lstReferenciaEspecialidadBean;
	}

	public ReferenciaEspecialidadService getReferenciaEspecialidadService() {
		return referenciaEspecialidadService;
	}

	public void setReferenciaEspecialidadService(ReferenciaEspecialidadService referenciaEspecialidadService) {
		this.referenciaEspecialidadService = referenciaEspecialidadService;
	}

	public List<ReferenciaApoyoDxResultadoBean> getlstReferenciaApoyoResultadoTempBean() {
		return lstReferenciaApoyoResultadoTempBean;
	}

	public void setlstReferenciaApoyoResultadoTempBean(
			List<ReferenciaApoyoDxResultadoBean> lstReferenciaApoyoResultadoTempBean) {
		this.lstReferenciaApoyoResultadoTempBean = lstReferenciaApoyoResultadoTempBean;
	}

	public List<ReferenciaBean> getLstReferenciaBean() {
		return lstReferenciaBean;
	}

	public void setLstReferenciaBean(List<ReferenciaBean> lstReferenciaBean) {
		this.lstReferenciaBean = lstReferenciaBean;
	}

	public List<ReferenciaDiagnosticoBean> getLstReferenciaDiagnosticoBean() {
		return lstReferenciaDiagnosticoBean;
	}

	public void setLstReferenciaDiagnosticoBean(List<ReferenciaDiagnosticoBean> lstReferenciaDiagnosticoBean) {
		this.lstReferenciaDiagnosticoBean = lstReferenciaDiagnosticoBean;
	}

	public List<ReferenciaApoyoDxBean> getLstReferenciaApoyoDxBean() {
		return lstReferenciaApoyoDxBean;
	}

	public void setLstReferenciaApoyoDxBean(List<ReferenciaApoyoDxBean> lstReferenciaApoyoDxBean) {
		this.lstReferenciaApoyoDxBean = lstReferenciaApoyoDxBean;
	}

	public List<ReferenciaApoyoDxResultadoBean> getLstReferenciaApoyoResultadoBean() {
		return lstReferenciaApoyoResultadoBean;
	}

	public void setLstReferenciaApoyoResultadoBean(
			List<ReferenciaApoyoDxResultadoBean> lstReferenciaApoyoResultadoBean) {
		this.lstReferenciaApoyoResultadoBean = lstReferenciaApoyoResultadoBean;
	}

	public List<RenaesBean> getLstRenaesBean() {
		return lstRenaesBean;
	}

	public void setLstRenaesBean(List<RenaesBean> lstRenaesBean) {
		this.lstRenaesBean = lstRenaesBean;
	}

	public PersonalBean getPersonalAcompana() {
		return personalAcompana;
	}

	public void setPersonalAcompana(PersonalBean personalAcompana) {
		this.personalAcompana = personalAcompana;
	}

	public PersonalBean getResponsableEstablecimiento() {
		return responsableEstablecimiento;
	}

	public void setResponsableEstablecimiento(PersonalBean responsableEstablecimiento) {
		this.responsableEstablecimiento = responsableEstablecimiento;
	}

}
