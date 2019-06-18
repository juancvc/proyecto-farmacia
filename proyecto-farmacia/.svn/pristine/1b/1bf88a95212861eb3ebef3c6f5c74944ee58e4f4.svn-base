package hnch.referencia.web.controller.asistencial.banco;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;  
import hnch.referencia.core.bean.asistencial.banco.PostulanteBean;
import hnch.referencia.core.bean.asistencial.banco.PreDonanteBean;
import hnch.referencia.core.bean.asistencial.banco.PreDonanteEntrevistaBean; 
import hnch.referencia.core.bean.asistencial.citas.ProgramacionMedicoCitaBean;
import hnch.referencia.core.bean.asistencial.referencia.ReferenciaBean;
import hnch.referencia.core.bean.asistencial.referencia.ReferenciaDiagnosticoBean;
import hnch.referencia.core.bean.general.PersonaBean;
import hnch.referencia.core.bean.general.TablaBean;
import hnch.referencia.core.bean.general.UbigeoBean;
import hnch.referencia.core.entity.general.PacienteReniec;
import hnch.referencia.core.service.exception.ServiceException;
import hnch.referencia.core.service.interfaces.asistencial.banco.PostulanteService;
import hnch.referencia.core.service.interfaces.asistencial.banco.PreDonanteEntrevistaService;
import hnch.referencia.core.service.interfaces.asistencial.banco.PreDonanteService;
import hnch.referencia.core.service.interfaces.asistencial.maestra.MaestraAsis14Service;
import hnch.referencia.core.service.interfaces.asistencial.maestra.MaestraBanc01Service;
import hnch.referencia.core.service.interfaces.asistencial.maestra.MaestraPreguntaBanc02Service;
import hnch.referencia.core.service.interfaces.general.Maestra1Service;
import hnch.referencia.core.service.interfaces.general.PacienteReniecService;
import hnch.referencia.web.controller.asistencial.banco.view.BancoForm;
import hnch.referencia.web.controller.base.BaseController;
import hnch.referencia.web.utilitarios.VO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@Controller
@RequestMapping(value = "entrevistaController")
public class EntrevistaController  extends BaseController {
	
	List<TablaBean> lstSituacion = new ArrayList<TablaBean>();
	List<TablaBean> lstDocumento = new ArrayList<TablaBean>();
	List<TablaBean> lstSexo = new ArrayList<TablaBean>();
	List<TablaBean> lstEstadoCivil = new ArrayList<TablaBean>();
	List<TablaBean> lstOcupacion = new ArrayList<TablaBean>();
	List<TablaBean> lstNacionalidad = new ArrayList<TablaBean>();
	List<TablaBean> lstNivelInstrucion = new ArrayList<TablaBean>();
	List<UbigeoBean> lstUbigeoBean = new ArrayList<UbigeoBean>();
	List<UbigeoBean> lstUbigeoFiltro = new ArrayList<UbigeoBean>();
	
	List<TablaBean> lstFactor = new ArrayList<TablaBean>();
	List<TablaBean> lstGrupoSangre = new ArrayList<TablaBean>();
	List<TablaBean> lstPreguntas = new ArrayList<TablaBean>();
	List<TablaBean> lstCalificacion = new ArrayList<TablaBean>();
	List<TablaBean> lstEstadoVenoso = new ArrayList<TablaBean>();
	List<TablaBean> lstEstadoEvaluacionFisica = new ArrayList<TablaBean>();
	
	PersonaBean personaBean = new PersonaBean();
	PostulanteBean PostulanteBean = new PostulanteBean();
	public UbigeoBean ubigeobean;
	
	private List<ReferenciaBean> lstReferenciaBean;
	private List<ReferenciaDiagnosticoBean> lstReferenciaDiagnosticoBean;
	private List<ProgramacionMedicoCitaBean> lstProgramacionMedicos; 
	private List<PostulanteBean> lstPostulanteBean ;
	private List<PreDonanteEntrevistaBean> lstPreDonanteEntrevistaBean;
	private List<PreDonanteBean> lstPreDonanteBean ;
	private List<PreDonanteBean> lstResultadosPreDonanteBean ;
	
	@Autowired
	private MaestraBanc01Service maestraBanc01Service; 
	 
	@Autowired
	private MaestraAsis14Service maestraAsis14Service;
	 
	@Autowired
	private MaestraPreguntaBanc02Service maestraPreguntaBanc02Service; 
	
	@Autowired
	private Maestra1Service maestraGene01Services;
	 
	@Autowired
	private PostulanteService postulanteService;
	
	@Autowired
	private PacienteReniecService pacienteReniecService;  
	
	@Autowired
	private PreDonanteEntrevistaService preDonanteEntrevistaService;
	
	@Autowired
	private PreDonanteService preDonanteService;
	
	@PostConstruct
	public void init() {
		this.setLstReferenciaBean(new ArrayList<ReferenciaBean>());
		
	}
	
	private void cargarCombos(ModelAndView mav) {
		try {
			lstSituacion = maestraBanc01Service.listarPorCodigoTabla("000034", 1);
			lstDocumento = maestraAsis14Service.listarPorCodigoTabla("000003", 1);
			lstSexo = maestraAsis14Service.listarPorCodigoTabla("000004", 1);
			lstEstadoCivil = maestraGene01Services.listarPorCodigoTabla("000005", 0);
			lstOcupacion = maestraGene01Services.listarPorCodigoTabla("000007", 0);
			lstNacionalidad = maestraGene01Services.listarPorCodigoTabla("000003", 0);
			lstNivelInstrucion = maestraGene01Services.listarPorCodigoTabla("000006", 0);
			lstFactor = maestraGene01Services.listarPorCodigoTabla("000004", 0);
			lstGrupoSangre = maestraGene01Services.listarPorCodigoTabla("000002", 0);
			lstCalificacion = maestraPreguntaBanc02Service.listarPorCodigoTabla("000003", 0);
			lstEstadoEvaluacionFisica = maestraBanc01Service.listarPorCodigoTabla("000035", 0);
			lstEstadoVenoso = maestraBanc01Service.listarPorCodigoTabla("000009", 1);
			
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		
		mav.addObject("lstSituacion", lstSituacion);
		mav.addObject("lstDocumento", lstDocumento); 
		mav.addObject("lstSexo", lstSexo); 
		mav.addObject("lstEstadoCivil", lstEstadoCivil); 
		mav.addObject("lstOcupacion", lstOcupacion); 
		mav.addObject("lstNacionalidad", lstNacionalidad); 
		mav.addObject("lstNivelInstrucion", lstNivelInstrucion); 
		mav.addObject("lstGrupoSangre", lstGrupoSangre); 
		mav.addObject("lstFactor", lstFactor); 
		mav.addObject("lstCalificacion", lstCalificacion); 
		mav.addObject("lstEstadoEvaluacionFisica", lstEstadoEvaluacionFisica); 
		mav.addObject("lstEstadoVenoso", lstEstadoVenoso); 
	}
	
	private void cargarCombosListado(ModelAndView mav) {
		try { 
			lstEstadoEvaluacionFisica = maestraBanc01Service.listarPorCodigoTabla("000035", 0);
			
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		 
		mav.addObject("lstEstadoEvaluacionFisica", lstEstadoEvaluacionFisica); 
	}
 
	/**************************************************************/
	/********************* EVALUACION FISICA **********************/
	
	@RequestMapping(value = "/listaPreDonantes", method = RequestMethod.GET)
	public ModelAndView listaPostulantesEvaluacion(@ModelAttribute("postulanteBean") PostulanteBean postulanteBean, HttpServletRequest request) throws Exception {
		return this.listaPostulantesEvaluacionPost(postulanteBean, request) ;
	}
	@RequestMapping(value = "/listaPreDonantes", method = RequestMethod.POST)
	public ModelAndView listaPostulantesEvaluacionPost(@ModelAttribute("postulanteBean") PostulanteBean postulanteBean, HttpServletRequest request) throws Exception {
		postulanteBean.getEstadoFisicoBean().setEstado("1");
		ModelAndView mav = new ModelAndView("asistencial/bancoSangre/entrevista/listado-predonantes", "command", postulanteBean); 
		lstPostulanteBean = postulanteService.listarPreDonantes(postulanteBean);  
		cargarCombosListado(mav);
		mav.addObject("postulanteBean", postulanteBean); 
		mav.addObject("lstPostulanteBean", lstPostulanteBean); 
		return mav;
	}
	
	@RequestMapping(value = "/buscarPreDonantes", method = RequestMethod.POST)
	public ModelAndView buscarPostulanteEvaluacion(@ModelAttribute("postulanteBean") PostulanteBean postulanteBean,
			HttpServletRequest request
			)
			throws Exception {  
		lstPostulanteBean = new ArrayList<PostulanteBean>(); 
		ModelAndView mav = new ModelAndView("asistencial/bancoSangre/entrevista/listado-predonantes", "command", postulanteBean); 
		lstPostulanteBean = postulanteService.listarPreDonantes(postulanteBean);  
		mav.addObject("postulanteBean", postulanteBean); 
		cargarCombosListado(mav);
		mav.addObject("lstPostulanteBean", lstPostulanteBean); 
	 
		return mav;
		
	}
	
	@RequestMapping(value = "/buscarPreDonantes", method = RequestMethod.GET)
	public ModelAndView buscarPostulanteEvaluacionGet(@ModelAttribute("postulanteBean") PostulanteBean postulanteBean,
			HttpServletRequest request
			)
			throws Exception { 
		return this.buscarPostulanteEvaluacion(postulanteBean, request) ;
	  
		
	}
	
	@RequestMapping(value = "/registroEntrevista", method = RequestMethod.POST)
	public ModelAndView nuevoLugarCampania(@RequestParam("codigo") Integer index,
											HttpServletRequest request) {
		BancoForm bancoForm = new BancoForm();
		PostulanteBean oPostulanteBean = new PostulanteBean(); 
		oPostulanteBean = this.lstPostulanteBean.get(index);
		lstPreguntas = new ArrayList<TablaBean>();
		PostulanteBean objPostulanteBean = new PostulanteBean(); 
		
		PreDonanteBean opPreDonanteBean = new PreDonanteBean();
		opPreDonanteBean.setPostulanteBean(oPostulanteBean); 
		
		System.out.println("opPreDonanteBeangetCodigo " + opPreDonanteBean.getPostulanteBean().getPersona().getCodigo());
			
		lstResultadosPreDonanteBean = new ArrayList<PreDonanteBean>();
		try {
			objPostulanteBean = this.postulanteService.obtenerPostulantesEstadoFisico(oPostulanteBean);
			if (objPostulanteBean != null) {
				bancoForm.setPostulanteBean(objPostulanteBean);
				lstPreguntas = maestraPreguntaBanc02Service.listarPreguntasPorSexo(objPostulanteBean.getPersona().getSexo().getValor1());
			}
			this.setPostulanteBean(objPostulanteBean);
			
			lstResultadosPreDonanteBean = this.preDonanteService.litarResultadoFisicoFlebo(opPreDonanteBean);
		} catch (Exception e) {
		}
		
		ModelAndView mav = new ModelAndView("asistencial/bancoSangre/entrevista/registro-entrevista-postulante", "command", bancoForm); 
		mav.addObject("bancoForm", bancoForm);
		mav.addObject("lstPreguntas", lstPreguntas);
		mav.addObject("lstResultadosPreDonanteBean", lstResultadosPreDonanteBean);
		cargarCombos(mav);
		return mav;
	}
	
	@RequestMapping(value = "/grabarRespuestas", method = RequestMethod.POST)
    public @ResponseBody String asignarAcceso(@RequestBody PreDonanteEntrevistaBean[] preguntasArray, HttpServletRequest request) {
        
		String codigo ="";		
        try {
        	System.out.println("preguntasArray " + preguntasArray.length);
			if (	!VO.isNull(preguntasArray)
					&& 	(	!VO.isNull(preguntasArray[0]) 
						&& 	!VO.isNull(preguntasArray[0].getPostulanteBean())
						&& 	!VO.isNull(preguntasArray[0].getPostulanteBean().getCodigo())
						)
			   ) {
				
				String perfilIdPostulante = preguntasArray[0].getPostulanteBean().getCodigo();
			//	System.out.println("perfilIdPostulante " + perfilIdPostulante);
				if(guardarCambios(preguntasArray,request)){
					codigo = perfilIdPostulante;
					/** RETORNAR MENUS PRINCIPALES **/
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        return codigo;
    }
	
	private boolean guardarCambios(PreDonanteEntrevistaBean[] listaPreguntas, HttpServletRequest request){
		
		boolean swGuardado = true;
		//System.out.println("guardarCambios " );
		try {
			
			//UsuarioBean usuarioSesion = this.getUsuarioSesion(request);
			
			for (int i = 0; i < listaPreguntas.length; i++) {
				PreDonanteEntrevistaBean prmPreguntas = listaPreguntas[i];
				//System.out.println("prmAcceso codigo " + prmPreguntas.getPregunta().getCodReg());
				this.setAuditoria(prmPreguntas, request, true); 
				preDonanteEntrevistaService.insertar(prmPreguntas);
			}
		} catch (Exception e) {
			e.printStackTrace();
			swGuardado = false;
		}
		
		return swGuardado;
	}
	
	@RequestMapping(value = "/registrarEntrevista", method = RequestMethod.POST)
	public @ResponseBody String registrarEntrevista(@ModelAttribute("bancoForm")BancoForm bancoForm,
						 @RequestParam("resultado") String resultado, @RequestParam("reiterativo") String reiterativo,
						 HttpServletRequest request) throws Exception { 
		
		System.out.println("bancoForm.getNombreCorto " + resultado);
		System.out.println("reiterativo " + reiterativo);
		bancoForm.getPreDonanteBean().setPostulanteBean(bancoForm.getPostulanteBean());
		bancoForm.getPreDonanteBean().getResultado().setNombreCorto(resultado);
		bancoForm.getPreDonanteBean().setReiterativo(reiterativo);
		String codigo ="";    
			this.setAuditoria(bancoForm.getPreDonanteBean(), request, true);  
			
			if (preDonanteService.insertar(bancoForm.getPreDonanteBean())) {   
				codigo ="1";
			} 
		return codigo;
	}
	
	@RequestMapping(value = "/obtenerFotoPostulante", method = RequestMethod.GET)
	public @ResponseBody PersonaBean obtenerFotoPostulante(@RequestParam("tipoDocumento") String tipoDocumento,@RequestParam("numero") String numero)throws Exception {
		//PersonaBean oPersona = new PersonaBean();
		PersonaBean personaBean = new PersonaBean();
		if(this.getPostulanteBean().getPersona().getFoto() != null){
			personaBean = this.getPostulanteBean().getPersona();
		}else if (tipoDocumento.equals("000002")) {
			PacienteReniec pacienteReniec = new PacienteReniec();
			pacienteReniec.setNroDni(numero);
			//System.out.println("personaaaa"+perso.toString());
			List<PacienteReniec> lstPersona =  null; 	
			try {
				lstPersona = pacienteReniecService.pacienteReniecVerificacion(pacienteReniec) ;				
			} catch (Exception e) {
			}
			//lstPersona.add(perso); 
			if (lstPersona!= null ) {
				String bphoto = Base64.encodeBase64String(lstPersona.get(0).getFotoPaciente()); 
				personaBean.setFoto(lstPersona.get(0).getFotoPaciente());
				personaBean.setFotoCadena(bphoto);
				personaBean.setSwReniec(false);
			}
		}
		
		return personaBean;
	}
	
	
	/////////////////////// FIN EVALUACION FISICA //////////////////
 
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/listadoPostulanteEntrevistados", method = RequestMethod.GET)
	public ModelAndView listadoPostulanteEntrevistados(@ModelAttribute("preDonanteBean") PreDonanteBean preDonanteBean, HttpServletRequest request) throws Exception { 
		ModelAndView mav = new ModelAndView("asistencial/bancoSangre/entrevista/listado-predonantesEntrevistados", "command", preDonanteBean); 
		lstPreDonanteBean = preDonanteService.getBuscarPorFiltros(preDonanteBean);  
		cargarCombosListado(mav);
		mav.addObject("preDonanteBean", preDonanteBean); 
		mav.addObject("lstPreDonanteBean", lstPreDonanteBean); 
		return mav;
	}
	@RequestMapping(value = "/listadoPostulanteEntrevistados", method = RequestMethod.POST)
	public ModelAndView listadoPostulanteEntrevistadosPost(@ModelAttribute("preDonanteBean") PreDonanteBean preDonanteBean, HttpServletRequest request) throws Exception { 
		ModelAndView mav = new ModelAndView("asistencial/bancoSangre/entrevista/listado-predonantesEntrevistados", "command", preDonanteBean); 
		lstPreDonanteBean = preDonanteService.getBuscarPorFiltros(preDonanteBean);  
		cargarCombosListado(mav);
		mav.addObject("preDonanteBean", preDonanteBean); 
		mav.addObject("lstPreDonanteBean", lstPreDonanteBean); 
		return mav;
	}
	
	@RequestMapping(value = "/buscarEntrevistados", method = RequestMethod.POST)
	public ModelAndView buscarEntrevistados(@ModelAttribute("preDonanteBean") PreDonanteBean preDonanteBean,
			HttpServletRequest request
			)
			throws Exception {  
		lstPreDonanteBean = new ArrayList<PreDonanteBean>(); 
		ModelAndView mav = new ModelAndView("asistencial/bancoSangre/entrevista/listado-predonantesEntrevistados", "command", preDonanteBean); 
		lstPreDonanteBean = preDonanteService.getBuscarPorFiltros(preDonanteBean);  
		mav.addObject("preDonanteBean", preDonanteBean); 
		cargarCombosListado(mav);
		mav.addObject("lstPreDonanteBean", lstPreDonanteBean);  
	
		return mav;
		
	}
	
	@RequestMapping(value = "/buscarEntrevistados", method = RequestMethod.GET)
	public ModelAndView buscarEntrevistadosGet(@ModelAttribute("preDonanteBean") PreDonanteBean preDonanteBean,
			HttpServletRequest request
			)
			throws Exception { 
		return this.buscarEntrevistados(preDonanteBean, request) ;
	}
	
	
	@RequestMapping(value = "rptFichaPostulante", method = RequestMethod.GET)
	@ResponseBody
	public void getRpt1(@RequestParam("index") Integer index,
						HttpServletResponse response, 
						HttpServletRequest request) throws JRException, IOException {
		InputStream jasperStream = this.getClass().getResourceAsStream("/reportes/rptFichaEntrevista.jasper");
		lstPreDonanteEntrevistaBean = new ArrayList<PreDonanteEntrevistaBean>();
		PreDonanteBean objPreDonanteBean = new PreDonanteBean();
		PreDonanteEntrevistaBean prmPreDonanteEntrevistaBean = new PreDonanteEntrevistaBean();
		try {
			objPreDonanteBean = preDonanteService.getBuscarPorObjecto(lstPreDonanteBean.get(index));
			if (objPreDonanteBean != null) {
				if (objPreDonanteBean.getPostulanteBean().getPersona().getTipoDocumento().getNombreCorto().equals("DNI")) {
					PacienteReniec pacienteReniec = new PacienteReniec();
					pacienteReniec.setNroDni(objPreDonanteBean.getPostulanteBean().getPersona().getNroDocumento()); 
					List<PacienteReniec> lstPersona =  null; 	
				/**	try {
						lstPersona = pacienteReniecService.pacienteReniecVerificacion(pacienteReniec) ;				
					} catch (Exception e) {
					} 
					if (lstPersona!= null ) { 
						objPreDonanteBean.getPostulanteBean().getPersona().setFoto(lstPersona.get(0).getFotoPaciente()); 
					}*/
				}else{
					objPreDonanteBean.getPostulanteBean().getPersona().setFoto(null); 
				}
				System.out.println(objPreDonanteBean.getPostulanteBean().getCodigo());
				System.out.println(objPreDonanteBean.getPostulanteBean().getNumeroPeriodo());
				System.out.println(objPreDonanteBean.getPostulanteBean().getPersona().getCodigo());
				prmPreDonanteEntrevistaBean.setPostulanteBean(objPreDonanteBean.getPostulanteBean());
				lstPreDonanteEntrevistaBean = preDonanteEntrevistaService.getBuscarPorFiltros(prmPreDonanteEntrevistaBean);
				if (lstPreDonanteEntrevistaBean != null) {
					System.out.println("lstPreDonanteEntrevistaBean " + lstPreDonanteEntrevistaBean.size());
					objPreDonanteBean.setLstPreDonanteEntrevistaBean(lstPreDonanteEntrevistaBean);
				}else{
					System.out.println("lstPreDonanteEntrevistaBean is null");
				}
			}else{
				System.out.println("objPreDonanteBeanis null");
			}
		} catch (Exception e) {
			 
		}
		Map<String, Object> parametro = new HashMap<String, Object>();
		parametro.put("usuario", getUsuarioSesion(request).getNombreUsuario()); 
		System.out.println("jasperStream " + jasperStream);
		List<PreDonanteBean> oPreDonanteBean = new ArrayList<PreDonanteBean>();
		oPreDonanteBean.add(objPreDonanteBean); 
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(oPreDonanteBean);
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametro, dataSource);

		response.setContentType("application/x-pdf");
		response.setHeader("Content-disposition",
				"inline; filename="+objPreDonanteBean.getPostulanteBean().getCodigo()+".pdf");

		final OutputStream outStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	}
	 
	@RequestMapping(value = "rptFichaPostulanteGrabar", method = RequestMethod.GET)
	@ResponseBody
	public String rptFichaPostulante(@ModelAttribute("bancoForm") BancoForm bancoForm,
						HttpServletResponse response, 
						HttpServletRequest request) throws JRException, IOException {
		
		String codigo ="";
		InputStream jasperStream = this.getClass().getResourceAsStream("/reportes/rptFichaEntrevista.jasper");
		
		System.out.println("bancoForm " + bancoForm.getPostulanteBean().getCodigo());
		System.out.println("bancoForm.getNumeroPeriodo " + bancoForm.getPostulanteBean().getNumeroPeriodo());
		System.out.println("bancoForm.getPersona " + bancoForm.getPostulanteBean().getPersona().getCodigo());
		lstPreDonanteEntrevistaBean = new ArrayList<PreDonanteEntrevistaBean>();
		PreDonanteBean objPreDonanteBean = new PreDonanteBean();
		PreDonanteEntrevistaBean prmPreDonanteEntrevistaBean = new PreDonanteEntrevistaBean();
		try {
			objPreDonanteBean = preDonanteService.getBuscarPorObjecto(bancoForm.getPreDonanteBean());
			if (objPreDonanteBean != null) {
				if (objPreDonanteBean.getPostulanteBean().getPersona().getTipoDocumento().getNombreCorto().equals("DNI")) {
					PacienteReniec pacienteReniec = new PacienteReniec();
					pacienteReniec.setNroDni(objPreDonanteBean.getPostulanteBean().getPersona().getNroDocumento()); 
					List<PacienteReniec> lstPersona =  null; 	
					try {
						lstPersona = pacienteReniecService.pacienteReniecVerificacion(pacienteReniec) ;				
					} catch (Exception e) {
					} 
					if (lstPersona!= null ) { 
						objPreDonanteBean.getPostulanteBean().getPersona().setFoto(lstPersona.get(0).getFotoPaciente()); 
					}
				}else{
					objPreDonanteBean.getPostulanteBean().getPersona().setFoto(null); 
				}
				System.out.println(objPreDonanteBean.getPostulanteBean().getCodigo());
				prmPreDonanteEntrevistaBean.setPostulanteBean(objPreDonanteBean.getPostulanteBean());
				lstPreDonanteEntrevistaBean = preDonanteEntrevistaService.getBuscarPorFiltros(prmPreDonanteEntrevistaBean);
				if (lstPreDonanteEntrevistaBean != null) {
					objPreDonanteBean.setLstPreDonanteEntrevistaBean(lstPreDonanteEntrevistaBean);
				}
			}else{
				System.out.println("objPreDonanteBeanis null");
			}
		} catch (Exception e) {
			 
		}
		Map<String, Object> parametro = new HashMap<String, Object>();
		parametro.put("usuario", getUsuarioSesion(request).getNombreUsuario()); 
		System.out.println("jasperStream " + jasperStream);
		List<PreDonanteBean> oPreDonanteBean = new ArrayList<PreDonanteBean>();
		oPreDonanteBean.add(objPreDonanteBean); 
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(oPreDonanteBean);
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametro, dataSource);

		response.setContentType("application/x-pdf");
		response.setHeader("Content-disposition",
				"inline; filename="+objPreDonanteBean.getPostulanteBean().getCodigo()+".pdf");

		final OutputStream outStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		return codigo;
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

	public List<ProgramacionMedicoCitaBean> getLstProgramacionMedicos() {
		return lstProgramacionMedicos;
	}

	public void setLstProgramacionMedicos(List<ProgramacionMedicoCitaBean> lstProgramacionMedicos) {
		this.lstProgramacionMedicos = lstProgramacionMedicos;
	}

	public PersonaBean getPersonaBean() {
		return personaBean;
	}

	public void setPersonaBean(PersonaBean personaBean) {
		this.personaBean = personaBean;
	}

	public PostulanteBean getPostulanteBean() {
		return PostulanteBean;
	}

	public void setPostulanteBean(PostulanteBean PostulanteBean) {
		this.PostulanteBean = PostulanteBean;
	}

}

