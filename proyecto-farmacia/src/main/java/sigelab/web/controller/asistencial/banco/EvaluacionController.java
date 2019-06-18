package sigelab.web.controller.asistencial.banco;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;  
import sigelab.core.bean.asistencial.banco.PostulanteBean;
import sigelab.core.bean.general.PersonaBean;
import sigelab.core.bean.general.TablaBean;
import sigelab.core.bean.general.UbigeoBean;
import sigelab.core.entity.general.PacienteReniec;
import sigelab.core.service.exception.ServiceException;
import sigelab.core.service.interfaces.asistencial.banco.DonanteService;
import sigelab.core.service.interfaces.asistencial.banco.EstadoFisicoService;
import sigelab.core.service.interfaces.asistencial.banco.PostulanteService;
import sigelab.core.service.interfaces.asistencial.maestra.MaestraAsis14Service;
import sigelab.core.service.interfaces.asistencial.maestra.MaestraBanc01Service;
import sigelab.core.service.interfaces.asistencial.maestra.MaestraPreguntaBanc02Service;
import sigelab.core.service.interfaces.general.Maestra1Service;
import sigelab.core.service.interfaces.general.PacienteReniecService;
import sigelab.web.controller.base.BaseController;

@Controller
@RequestMapping(value = "evaluacionController")
public class EvaluacionController  extends BaseController {
	
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
	List<TablaBean> lstEstadoEvaluacionFisica = new ArrayList<TablaBean>();
	
	PersonaBean personaBean = new PersonaBean();
	PostulanteBean PostulanteBean = new PostulanteBean();
	public UbigeoBean ubigeobean;
	 
	private List<PostulanteBean> lstPostulanteBean ;
	
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
	private EstadoFisicoService estadoFisicoService;
	 
	@PostConstruct
	public void init() { 
		
	}
	
	private void cargarCombos(ModelAndView mav) {
		try {
			lstSituacion =maestraBanc01Service.listarPorCodigoTabla("000034", 1);
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
	
	@RequestMapping(value = "/listaPostulantesEvaluacion", method = RequestMethod.GET)
	public ModelAndView listaPostulantesEvaluacion(@ModelAttribute("postulanteBean") PostulanteBean postulanteBean, HttpServletRequest request) throws Exception {
		postulanteBean.getEstadoFisicoBean().setEstado("1");
		ModelAndView mav = new ModelAndView("asistencial/bancoSangre/estadoFisico/listado-postulante-evaluacion", "command", postulanteBean); 
		lstPostulanteBean = postulanteService.listarPostulantesEstadoFisico(postulanteBean);  
		cargarCombosListado(mav);
		mav.addObject("postulanteBean", postulanteBean); 
		mav.addObject("lstPostulanteBean", lstPostulanteBean); 
		return mav;
	}
	@RequestMapping(value = "/listaPostulantesEvaluacion", method = RequestMethod.POST)
	public ModelAndView listaPostulantesEvaluacionPost(@ModelAttribute("postulanteBean") PostulanteBean postulanteBean, HttpServletRequest request) throws Exception {
		postulanteBean.getEstadoFisicoBean().setEstado("1");
		ModelAndView mav = new ModelAndView("asistencial/bancoSangre/estadoFisico/listado-postulante-evaluacion", "command", postulanteBean); 
		lstPostulanteBean = postulanteService.listarPostulantesEstadoFisico(postulanteBean);  
		cargarCombosListado(mav);
		mav.addObject("postulanteBean", postulanteBean); 
		mav.addObject("lstPostulanteBean", lstPostulanteBean); 
		return mav;
	}
	
	@RequestMapping(value = "/buscarPostulanteEvaluacion", method = RequestMethod.POST)
	public ModelAndView buscarPostulanteEvaluacion(@ModelAttribute("postulanteBean") PostulanteBean postulanteBean,
			HttpServletRequest request
			)
			throws Exception {  
		lstPostulanteBean = new ArrayList<PostulanteBean>(); 
		ModelAndView mav = new ModelAndView("asistencial/bancoSangre/estadoFisico/listado-postulante-evaluacion", "command", postulanteBean); 
		lstPostulanteBean = postulanteService.listarPostulantesEstadoFisico(postulanteBean);  
		mav.addObject("postulanteBean", postulanteBean); 
		cargarCombosListado(mav);
		mav.addObject("lstPostulanteBean", lstPostulanteBean); 
	 
		return mav;
		
	}
	
	@RequestMapping(value = "/buscarPostulanteEvaluacion", method = RequestMethod.GET)
	public ModelAndView buscarPostulanteEvaluacionGet(@ModelAttribute("postulanteBean") PostulanteBean postulanteBean,
			HttpServletRequest request
			)
			throws Exception { 
		return this.buscarPostulanteEvaluacion(postulanteBean, request) ;
	  
		
	}
	
	@RequestMapping(value = "/registroEvaluacion", method = RequestMethod.POST)
	public ModelAndView nuevoLugarCampania(@RequestParam("codigo") Integer index,
											HttpServletRequest request) {
		PostulanteBean oPostulanteBean = new PostulanteBean(); 
		oPostulanteBean = this.lstPostulanteBean.get(index);
		
		PostulanteBean objPostulanteBean = new PostulanteBean(); 
		try {
			objPostulanteBean = this.postulanteService.obtenerPostulantesEstadoFisico(oPostulanteBean);
			System.out.println("objPostulanteBean.personaBean.getfoto " + objPostulanteBean.getPersona().getFoto()); 
			this.setPostulanteBean(objPostulanteBean);
		} catch (Exception e) {
		}
		
		ModelAndView mav = new ModelAndView("asistencial/bancoSangre/estadoFisico/registro-evaluacion-postulante", "command", objPostulanteBean); 
		mav.addObject("postulanteBean", objPostulanteBean);
		cargarCombos(mav);
		return mav;
	}
	
	@RequestMapping(value = "/updateEstadoFisico", method = RequestMethod.POST)
	public @ResponseBody String updateEstadoFisico(@ModelAttribute("postulanteBean")PostulanteBean postulanteBean,
											 HttpServletRequest request) throws Exception {  
		String codigo ="";    
			this.setAuditoria(postulanteBean.getEstadoFisicoBean(), request, false); 
			System.out.println("actualiza getEstadoFisicoBean " + postulanteBean.getEstadoFisicoBean().getCodigo());
			System.out.println("actualiza getPersonaBean " + postulanteBean.getEstadoFisicoBean().getPersonaBean().getCodigo());
			System.out.println("actualiza getNumeroPeriodo " + postulanteBean.getEstadoFisicoBean().getNumeroPeriodo());
			System.out.println("actualiza getNumeroVersion " + postulanteBean.getEstadoFisicoBean().getNumeroVersion());
			
			if (estadoFisicoService.actualizar(postulanteBean.getEstadoFisicoBean())) {  
				codigo = postulanteBean.getEstadoFisicoBean().getCodigo();
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

