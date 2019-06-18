package hnch.referencia.web.controller.asistencial.citas;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry; 
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import hnch.referencia.core.bean.asistencial.citas.CitaBean;
import hnch.referencia.core.bean.asistencial.citas.ProgramacionMedicoCitaBean;
import hnch.referencia.core.bean.asistencial.referencia.ReferenciaBean;
import hnch.referencia.core.bean.asistencial.referencia.ReferenciaDiagnosticoBean; 
import hnch.referencia.core.bean.general.TablaBean; 
import hnch.referencia.core.service.exception.ServiceException;
import hnch.referencia.core.service.interfaces.asistencial.citas.CitaService;
import hnch.referencia.core.service.interfaces.asistencial.citas.ProgramacionMedicoCitaService;
import hnch.referencia.core.service.interfaces.asistencial.maestra.MaestraAsis03Service;
import hnch.referencia.core.service.interfaces.asistencial.maestra.MaestraAsis14Service;
import hnch.referencia.core.service.interfaces.asistencial.referencia.ReferenciaCbService;
import hnch.referencia.core.service.interfaces.asistencial.referencia.ReferenciaDiagnosticoService;
import hnch.referencia.web.controller.asistencial.citas.view.CitasForm;
import hnch.referencia.web.controller.base.BaseController; 

@Controller
@RequestMapping(value = "citasController")
public class CitasController  extends BaseController {
	
	List<TablaBean> lstTablas = new ArrayList<TablaBean>();
	private List<ReferenciaBean> lstReferenciaBean;
	private List<ReferenciaDiagnosticoBean> lstReferenciaDiagnosticoBean;
	private List<ProgramacionMedicoCitaBean> lstProgramacionMedicos;
	
	private List<TablaBean> lstEspecialidad;  
	@Autowired
	private ProgramacionMedicoCitaService programacionMedicoCitaService;
	
	@Autowired
	private MaestraAsis14Service maestraAsis14Service;
	
	@Autowired
	private ReferenciaCbService referenciaCbService;
	
	@Autowired
	private ReferenciaDiagnosticoService referenciaDiagnosticoService;
	
	@Autowired
	private CitaService citaService;
	
	@Autowired
	private MaestraAsis03Service maestraAsis03Service;
	
	@PostConstruct
	public void init() {
		this.setLstReferenciaBean(new ArrayList<ReferenciaBean>());
		
	}
	
	private void cargarCombos(ModelAndView mav) {
		try {
			lstEspecialidad = maestraAsis03Service.listarPorCodigoTabla("000001", 3);
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		
		mav.addObject("lstEspecialidad", lstEspecialidad);
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("citaBean") CitaBean citaBean,
			HttpServletRequest request
			)
			throws Exception { 
		List<CitaBean> lstCitaBean = new ArrayList<CitaBean>(); 
		ModelAndView mav = new ModelAndView("asistencial/citas/listado-cita", "command", citaBean); 
		lstCitaBean = citaService.getBuscarPorFiltros(citaBean);  
		mav.addObject("lstCitasBean", lstCitaBean); 
		this.cargarCombos(mav);
		return mav;
		
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public ModelAndView doBuscarGet(@ModelAttribute("citaBean") CitaBean citaBean,
			HttpServletRequest request
			)
			throws Exception { 
		List<CitaBean> lstCitaBean = new ArrayList<CitaBean>(); 
		ModelAndView mav = new ModelAndView("asistencial/citas/listado-cita", "command", citaBean); 
		lstCitaBean = citaService.getBuscarPorFiltros(citaBean);  
		mav.addObject("lstCitasBean", lstCitaBean); 
		this.cargarCombos(mav);
		return mav;
		
	}
	
	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("citaBean") CitaBean citaBean, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView("asistencial/citas/listado-cita", "command", citaBean); 
	
		this.cargarCombos(mav);
		return mav;
	}

	
	@RequestMapping(value = "/listado", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView listado(@ModelAttribute("citaBean") CitaBean citaBean, HttpServletRequest request) throws Exception {
	 
		ModelAndView mav = new ModelAndView("asistencial/citas/listado-cita", "command", citaBean); 
		return mav;
	}
 
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo(HttpServletRequest request) {
		CitasForm citasForm = new CitasForm(); 
		ModelAndView mav = new ModelAndView("asistencial/citas/registro-citas", "command", citasForm); 
	//	this.cargarCombos(mav);
		return mav;
	}
	
	@RequestMapping(value = "/referenciasModal", method = RequestMethod.POST) 
	//@ResponseBody
	public ModelAndView establecimientoModal(@ModelAttribute("referenciaBean")ReferenciaBean referenciaBean,
			HttpServletRequest request) throws Exception {
		
			ModelAndView mav = new ModelAndView("asistencial/citas/listado-referencias-modal", "command", referenciaBean);
			referenciaBean.getServicioUPSReferencia().setCodReg("000001");
			referenciaBean.setCodigoUsuarioSession(getUsuarioSesion(request).getCodigo());
			referenciaBean.setCodigoPerfilUsuarioSession(getUsuarioSesion(request).getPerfil().getCodigo());
			lstReferenciaBean = referenciaCbService.listarPendienteCitas(referenciaBean);
			mav.addObject("lstReferenciaBean", lstReferenciaBean);
			

		return mav;
	}
	
	@RequestMapping(value = "/listarReferencias", method = RequestMethod.GET)
	public @ResponseBody List<ReferenciaBean> listarReferencias(@ModelAttribute("referenciaBean")ReferenciaBean referenciaBean,
															    HttpServletRequest request) throws Exception {
	 
		System.out.println("listarReferencias referenciaBean " + referenciaBean);
		List<ReferenciaBean> lstReferenciaBean = new ArrayList<ReferenciaBean>();  
		referenciaBean.getServicioUPSReferencia().setCodReg("000001");
		referenciaBean.setCodigoUsuarioSession(getUsuarioSesion(request).getCodigo());
		referenciaBean.setCodigoPerfilUsuarioSession(getUsuarioSesion(request).getPerfil().getCodigo());
		lstReferenciaBean = referenciaCbService.listarPendienteCitas(referenciaBean);
		
		return lstReferenciaBean;
	}
	
	
	@RequestMapping(value = "/pacienteCitaModal", method = RequestMethod.POST) 
	//@ResponseBody
	public ModelAndView pacienteCitaModal(@RequestParam("codigoDH") String codigoDH) throws Exception {
			System.out.println("pacienteCitaModal");
			System.out.println("lstProgramacionMedicos.size(); "  + lstProgramacionMedicos.size());
			CitaBean citaBean = new CitaBean();
			for (int i = 0; i < lstProgramacionMedicos.size(); i++) {
				if (lstProgramacionMedicos.get(i).getCodigoProgramacionDH().equals(codigoDH)) {
					citaBean.setProgramacionMedicoCitaBean(lstProgramacionMedicos.get(i));
					break;
				}
			}
			
			ModelAndView mav = new ModelAndView("asistencial/citas/paciente-cita-modal", "command", citaBean);
	
			/**	referenciaBean.getServicioUPSReferencia().setCodReg("000001");
			referenciaBean.setCodigoUsuarioSession(getUsuarioSesion(request).getCodigo());
			referenciaBean.setCodigoPerfilUsuarioSession(getUsuarioSesion(request).getPerfil().getCodigo());
			lstReferenciaBean = referenciaCbService.getBuscarPorFiltros(referenciaBean);
			mav.addObject("lstReferenciaBean", lstReferenciaBean);
		*/	

		return mav;
	}
	
	@RequestMapping(value = "/obtenerReferencia", method = RequestMethod.GET)
	public @ResponseBody ReferenciaBean obtenerReferencia(@RequestParam("index") int index) throws Exception {
		System.out.println("index " + index);
		ReferenciaBean objetoReferencia = new ReferenciaBean(); 
		List<TablaBean> lstEspecialidad = new ArrayList<TablaBean>();  
		List<TablaBean> lstReferenciaEspecialidad = new ArrayList<TablaBean>();  
		objetoReferencia = lstReferenciaBean.get(index);  
		lstReferenciaDiagnosticoBean = referenciaDiagnosticoService.listarPorReferenciaBean(objetoReferencia);
		for (ReferenciaDiagnosticoBean lst : lstReferenciaDiagnosticoBean) {
			if((!lst.getEspecialidad().getCodReg().equals("")) && lst.getSituacion().getCodReg().equals("000001") ){ 
				lstEspecialidad.add(lst.getEspecialidad());
			}
		}
		Map<String, TablaBean> mapPersonas = new HashMap<String, TablaBean>(lstEspecialidad.size());
	
		 for(TablaBean p : lstEspecialidad) {
		 mapPersonas.put(p.getCodReg(), p);
		 }
		 
		 for(Entry<String, TablaBean> p : mapPersonas.entrySet()) {
			 lstReferenciaEspecialidad.add(p.getValue());
			 System.out.println(p.getValue());
			 }
		     
		objetoReferencia.setListEspecialidades(lstReferenciaEspecialidad);
		return objetoReferencia;
	}
	
	@RequestMapping(value = "/obtenerListaMedicos", method = RequestMethod.GET)
	public @ResponseBody List<ProgramacionMedicoCitaBean> obtenerListaMedicos(
			@RequestParam("codigoEspecialidad") String codigoEspecialidad,
			@RequestParam("fecha") String fecha) throws Exception {
		
		lstProgramacionMedicos = new ArrayList<ProgramacionMedicoCitaBean>();
		/***SimpleDateFormat dateFormat = new SimpleDateFormat(
	            "dd/MM/yyyy");

	    Date parsedTimeStamp = dateFormat.parse(fecha);

	    Timestamp tFechaProg = new Timestamp(parsedTimeStamp.getTime()); */
	    System.out.println("codigoEspecialidad " + codigoEspecialidad);
	    System.out.println("fecha  " + fecha);
		ProgramacionMedicoCitaBean programacionMedicoCitaBean = new ProgramacionMedicoCitaBean();
		programacionMedicoCitaBean.getEspecialidad().setCodReg(codigoEspecialidad);
		programacionMedicoCitaBean.setStrFechaProgramacion(fecha);
		programacionMedicoCitaBean.getActividad().setCodReg("000001");
	  try {
		  lstProgramacionMedicos = programacionMedicoCitaService.getBuscarPorFiltros(programacionMedicoCitaBean);
	} catch (Exception e) {
		 
	}
		
		 
		return lstProgramacionMedicos;	
	}
	
	@RequestMapping(value = "/grabarCita", method = RequestMethod.POST)
	public @ResponseBody CitaBean grabarCita(@ModelAttribute("citaBean")CitaBean citaBean,
											 HttpServletRequest request) throws Exception { 
		CitaBean objCita = new CitaBean();
		
		System.out.println("citaBean fecha " + citaBean.getProgramacionMedicoCitaBean().getFechaProgramacion());
	//	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		//citaBean.getProgramacionMedicoCitaBean().setFechaModificacion(sdf.format(citaBean.getProgramacionMedicoCitaBean().getFechaProgramacion()));
		
		ReferenciaDiagnosticoBean oReferenciaDiagnosticoBean = new ReferenciaDiagnosticoBean();
		
		for (ReferenciaDiagnosticoBean objeto : lstReferenciaDiagnosticoBean) {
			 if (objeto.getEspecialidad().getCodReg().equals(citaBean.getProgramacionMedicoCitaBean().getEspecialidad().getCodReg())) {
				 oReferenciaDiagnosticoBean = objeto;
				 break;
			}
			
		}
		this.setAuditoria(citaBean, request, true);
		citaBean.setReferenciaDiagnosticoBean(oReferenciaDiagnosticoBean);
		if (citaService.insertar(citaBean)) {
			objCita = citaBean;
			System.out.println("citaBean " + citaBean.getCodigo());
		}
		return objCita;
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

}

