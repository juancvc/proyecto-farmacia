package hnch.referencia.web.controller.asistencial.contrareferencia;
  
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody; 
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import hnch.referencia.core.bean.asistencial.referencia.ReferenciaBean;
import hnch.referencia.core.bean.asistencial.referencia.ReferenciaEspecialidadBean;
import hnch.referencia.core.bean.general.PersonaBean;
import hnch.referencia.core.bean.general.PersonalBean;
import hnch.referencia.core.bean.general.TablaBean;
import hnch.referencia.core.service.exception.ServiceException;
import hnch.referencia.core.service.interfaces.asistencial.referencia.ReferenciaEspecialidadService;
import hnch.referencia.core.service.interfaces.general.Maestra1Service;
import hnch.referencia.core.service.interfaces.general.Maestra2Service;
import hnch.referencia.core.service.interfaces.seguridad.UsuarioService;
import hnch.referencia.web.controller.asistencial.referencia.view.ReferenciaForm;
import hnch.referencia.web.controller.base.BaseController;
import hnch.referencia.web.utilitarios.ResourceUtil;
import hnch.referencia.web.utilitarios.VO;
 
@Controller
@Scope(value="session")
@RequestMapping(value = "contrareferenciaController")

public class ContrareferenciaController extends BaseController {
	
	private ReferenciaForm 		referenciaForm;

	private ReferenciaBean 		referenciaBean;
	
	private ReferenciaEspecialidadBean referenciaEspecialidadBean;
	
	private List<ReferenciaEspecialidadBean> 	lstReferenciaEspecialidadBean;
	
	 

	@Autowired
	private ReferenciaEspecialidadService 		referenciaEspecialidadService;
 
	@Autowired
	private Maestra1Service maestra1Service;
	
	List<TablaBean>  lstSituacion = new ArrayList<TablaBean>();
	 
	
	@PostConstruct
	public void init(){
		this.setReferenciaBean(new ReferenciaBean());
		this.setReferenciaForm(new ReferenciaForm());
		this.setLstReferenciaEspecialidadBean(new ArrayList<ReferenciaEspecialidadBean>());  
	}
	 
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo() {
		//cargarComboLeccion();
		ModelAndView mav = new ModelAndView("asistencial/contrareferencia/registro-contrareferencia", "command",new ReferenciaForm()); 
 
		
		mav.addObject("referenciaForm", new ReferenciaForm()); 
		return mav;
	}
	
	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("referenciaBean") ReferenciaBean lenguaBean
			)throws Exception {   
		ModelAndView mav = new ModelAndView("general/lengua/listado-lengua", "command",lenguaBean);

		mav.addObject("lstReferenciaBean", new ArrayList<ReferenciaBean>());
		this.cargarCombos(mav);
		return mav;
	} 

	
	@RequestMapping(value = "/grabarReferencia", method = RequestMethod.POST)
	public ModelAndView grabarReferencia(@ModelAttribute("referenciaForm") ReferenciaForm referenciaForm, @RequestParam("especialidad") String[] especialidad,
			 HttpServletRequest request) {
		
		System.out.println(" grabar grabarReferenciaEspecialidad "+referenciaForm);
		PersonaBean prmPersona = new PersonaBean(); 
		boolean sw = false;
		
		System.out.println("llegó a grabar personalBean "+referenciaForm);
		
		try {
			
			
			if (referenciaForm.getReferenciaBean().getCodigo().equals("")) {
				
			//	prmPersona=personalBean.getPersonaBean();
				 
				if(prmPersona==null){ 
					
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");   
					this.setAuditoria(prmPersona, request, true);
					sw = (this.referenciaEspecialidadService.insertar(referenciaForm.getReferenciaEspecialidadBean()));
					
					
					
				} 
				
			} else {
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
				//this.setAuditoria(personalBean, request, false);
			//	sw = (this.getPersonalService().actualizar(personalBean));
			}

		} catch (Exception e) { 
			e.printStackTrace();
		}

		if (sw) {
			ModelAndView mav = new ModelAndView("general/registro-administrativo", "command",referenciaForm);
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("general/registro-administrativo", "command",referenciaForm);
			return mav;
		}

	}
	 
	@RequestMapping(value = "/grabarReferenciaEspecialidad", method = RequestMethod.POST)
	public ModelAndView grabarReferenciaEspecialidad(@ModelAttribute("referenciaForm") ReferenciaForm referenciaForm, @RequestParam("especialidad") String[] especialidad,
			 HttpServletRequest request) {
		
		System.out.println(" grabar grabarReferenciaEspecialidad "+referenciaForm);
		PersonaBean prmPersona = new PersonaBean(); 
		boolean sw = false;
		
		System.out.println("llegó a grabar personalBean "+referenciaForm);
		
		try {
			
			
			if (referenciaForm.getReferenciaBean().getCodigo().equals("")) {
				
			//	prmPersona=personalBean.getPersonaBean();
				 
				if(prmPersona==null){ 
					
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");   
					this.setAuditoria(prmPersona, request, true);
					sw = (this.referenciaEspecialidadService.insertar(referenciaForm.getReferenciaEspecialidadBean()));
					
					
					
				} 
				
			} else {
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
				//this.setAuditoria(personalBean, request, false);
			//	sw = (this.getPersonalService().actualizar(personalBean));
			}

		} catch (Exception e) { 
			e.printStackTrace();
		}

		if (sw) {
			ModelAndView mav = new ModelAndView("general/registro-administrativo", "command",referenciaForm);
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("general/registro-administrativo", "command",referenciaForm);
			return mav;
		}

	}
	
	private void cargarCombos(ModelAndView mav){
		 
		try {
			lstSituacion = maestra1Service.listarPorCodigoTabla("situacionLengua",0); 
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}	 

	mav.addObject("lstSituacion",lstSituacion);  

}
	  

	public void setValoresPredeterminados(ReferenciaBean referenciaBean){
		referenciaBean.setNumeroPeriodo("");		 
		referenciaBean.getSituacion().setCodReg("0");;
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

	 
	
}