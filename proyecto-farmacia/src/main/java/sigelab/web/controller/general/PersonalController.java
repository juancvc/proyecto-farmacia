package sigelab.web.controller.general;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import sigelab.core.bean.general.TablaBean;
import sigelab.core.bean.general.PersonaBean;
import sigelab.core.bean.general.PersonalBean;
import sigelab.core.bean.general.UbigeoBean; 
import sigelab.core.bean.seguridad.PerfilBean;
import sigelab.core.service.exception.ServiceException; 
import sigelab.core.service.interfaces.general.Maestra1Service;
import sigelab.core.service.interfaces.general.Maestra2Service;
import sigelab.core.service.interfaces.general.PersonaService;
import sigelab.core.service.interfaces.general.PersonalService;
import sigelab.core.service.interfaces.general.UbigeoService;
import sigelab.core.service.interfaces.seguridad.PerfilService;
import sigelab.web.controller.base.BaseController;
import sigelab.web.utilitarios.VO;


@Controller
@RequestMapping(value = "personalController")
public class PersonalController extends BaseController {
	
	PersonalBean personalBean = new PersonalBean();

	private UbigeoBean ubigeoBean;

	private List<UbigeoBean> lstRegion;
	private List<UbigeoBean> lstProvincia;
	private List<UbigeoBean> lstDistrito;

	List<PersonalBean> lstpersonalBean= new ArrayList<PersonalBean>();
	private List<TablaBean>	lstSituacion;
	private List<TablaBean> lstTipoDocumento;
	private List<TablaBean> lstNacionalidad;
	private List<TablaBean> lstGrado;
	private List<TablaBean> lstCargo;
	private List<TablaBean> lstSexo; 
	
	private List<PerfilBean> 	lstPerfilBean;
	@Autowired
	private PerfilService perfilService;
	 
	
	@Autowired
	private UbigeoService ubigeoService;
	
	@Autowired
	private Maestra1Service maestra1Service;
	
	@Autowired 
	private PersonaService personaService;
//	
	@Autowired
	private Maestra2Service maestra2Service;
	
	@Autowired
	private PersonalService personalService;
	
	
	@PostConstruct
	public void init(){
		this.setPersonalBean(new PersonalBean());
		this.setLstpersonalBean(new ArrayList<PersonalBean>());
//		this.setLstSituacion(new ArrayList<TablaBean>());
	}
	
	public PersonalController(){
/**		
//		List<TablaBean> situacion = new ArrayList<TablaBean>();
//		situacion = maestra1Service.listarPorCodigoTabla("situacionPersonal");
		lstSituacion= new ArrayList<TablaBean>();
		lstTipoDocumento= new ArrayList<TablaBean>();
		try {
			lstSituacion = maestra1Service.listarPorCodigoTabla("situacionPersonal");
			lstTipoDocumento = maestra1Service.listarPorCodigoTabla("tipoDocumento");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
*/
	}
	
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo() {
		
		ModelAndView mav = new ModelAndView("general/registro-administrativo", "command",new PersonalBean());
		mav.addObject("lstSituacion",lstSituacion);
//		mav.addObject("lstTipoDocumento",lstTipoDocumento);
		mav.addObject("personalBean", new PersonalBean());
		cargarUbigeo(mav, null);
		this.cargarCombos(mav);
		return mav;
	}
	
	
	@RequestMapping(value = "/modificar", method = RequestMethod.GET)
	public ModelAndView doModificar(@RequestParam("codigo") Integer codigo) {

		System.out.println("modificar codigo: " + codigo);

		PersonalBean prmPersonalBean = new PersonalBean(); 
		try {
			personalBean = this.getPersonalService().getBuscarPorObjecto(prmPersonalBean);
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
		
	/*	if(personalBean.getPersonaBean().getFechaNac()!=null){
			String fechaConFormato = sdf.format(personalBean.getPersonaBean().getFechaNac()); 
//			Date nuevaFecha=null;
			
		
//				nuevaFecha = sdf.parse(fechaConFormato);
				personalBean.getPersonaBean().setStrFechaNac(fechaConFormato);
			
			
		}*/
		System.out.println("modificar lenguaBean: " + personalBean);
		ModelAndView mav = new ModelAndView("general/registro-administrativo", "command", personalBean);
		mav.addObject("personalBean", personalBean);
	//	mav.addObject("idUsuario",usuarioBean.getCodigo());	
		this.cargarUbigeo(mav, personalBean);
		this.cargarCombos(mav);	
		return mav;
	}
	
	
	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
	public ModelAndView doGrabar(@ModelAttribute("personalBean") PersonalBean personalBean,
			 HttpServletRequest request) {
		
		System.out.println(" grabar personalBean "+personalBean);
		PersonaBean prmPersona = new PersonaBean();
	/*	personalBean.getPersonaBean().setNombrePersona(VO.convertirCaracteresEsp(personalBean.getPersonaBean().getNombrePersona()));
		personalBean.getPersonaBean().setApellidoPaterno(VO.convertirCaracteresEsp(personalBean.getPersonaBean().getApellidoPaterno()));
		personalBean.getPersonaBean().setApellidoMaterno(VO.convertirCaracteresEsp(personalBean.getPersonaBean().getApellidoMaterno()));
		personalBean.getPersonaBean().setDireccionPersona(VO.convertirCaracteresEsp(personalBean.getPersonaBean().getDireccionPersona()));
		personalBean.getPersonaBean().setCorreo(VO.convertirCaracteresEsp(personalBean.getPersonaBean().getCorreo()));*/
		boolean sw = false;
		
		System.out.println("llegó a grabar personalBean "+personalBean);
		
		try {
			
			
			if (personalBean.getCodigo().equals("")) {
				
			//	prmPersona=personalBean.getPersonaBean();
				
				prmPersona = this.getPersonaService().buscarxTipoDocumentoNumeroDocumento(prmPersona);
				if(prmPersona==null){
				//	prmPersona=personalBean.getPersonaBean();
					
				//	prmPersona.setCodigoUbigeo(prmPersona.getUbigeoBean().getCodigoRegion()+prmPersona.getUbigeoBean().getCodigoProvincia()+prmPersona.getUbigeoBean().getCodigoDistrito());
					
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
					
					/*if(personalBean.getPersonaBean().getStrFechaNac()!=null){
						Date fechaConFormato = sdf.parse(personalBean.getPersonaBean().getStrFechaNac().toString()); 
//						
						prmPersona.setFechaNac(fechaConFormato);
						
						
					} */
					this.setAuditoria(prmPersona, request, true);
					sw = (this.getPersonaService().insertar(prmPersona));
					
					
					
				}
				this.setAuditoria(personalBean, request, true);
			//	personalBean.setPersonaBean(prmPersona);
				
				
				sw =  (this.getPersonalService().insertar(personalBean)); 
				
			} else {
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
				
			/*	if(personalBean.getPersonaBean().getStrFechaNac()!=null){
					Date fechaConFormato = sdf.parse(personalBean.getPersonaBean().getStrFechaNac().toString()); 
//					
					prmPersona.setFechaNac(fechaConFormato);
				//	personalBean.getPersonaBean().setFechaNac(prmPersona.getFechaNac());
					
				}
				*/
			//	personalBean.getPersonaBean().setCodigoUbigeo(personalBean.getPersonaBean().getUbigeoBean().getCodigoRegion()+personalBean.getPersonaBean().getUbigeoBean().getCodigoProvincia()+personalBean.getPersonaBean().getUbigeoBean().getCodigoDistrito());
				this.setAuditoria(personalBean, request, false);
				sw = (this.getPersonalService().actualizar(personalBean));
			}

		} catch (Exception e) { 
			e.printStackTrace();
		}

		if (sw) {
			personalBean = new PersonalBean() ;
			return this.getLista(personalBean);
		} else {
			ModelAndView mav = new ModelAndView("general/registro-administrativo", "command",personalBean);
			return mav;
		}

	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("personalBean") PersonalBean personalBean)
			throws Exception { 
		return this.getLista(personalBean);
	}

	
	
	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("personalBean") PersonalBean personalBean)throws Exception {
	
		PersonalBean personalBean2 = new PersonalBean();
//		personalBean.getPersonaBean().setNombrePersona(personalBean.getPersonaBean().getNombrePersona().trim());
		personalBean2 = personalBean;

		ModelAndView mav = new ModelAndView("general/listado-administrativo", "command",personalBean);

		mav.addObject("lstPersonalBean", new ArrayList<PersonaBean>());
		mav.addObject("personalBean", personalBean);
		this.cargarCombos(mav);
		return mav;
	}
	
	@RequestMapping(value ="/eliminar", method = RequestMethod.GET)
	public ModelAndView eliminar(@RequestParam("codigo")Integer codigo,HttpServletRequest request){
		boolean sw=false;
		personalBean= new PersonalBean(); 
	//	this.setAuditoria(lenguaBean, request, false);
		try { 
				sw =  (this.getPersonalService().eliminar(personalBean));  

		} catch (Exception e) { 
			e.printStackTrace();
		} 		 
		this.setValoresPredeterminados(personalBean);
		ModelAndView mav = this.getLista(personalBean);
		mav.addObject("swMensaje",sw?"1":"0");
		return mav;		
	}
	
	 public void setValoresPredeterminados(PersonalBean personalBean){
//		 personalBean.setNombre(""); 
//		 personalBean.getSituacion().setCodigoRegistro(0);
	    }
	 
	 private void cargarUbigeo(ModelAndView mav,PersonalBean PersonalBean){

			ubigeoBean = new UbigeoBean();
			if(PersonalBean!=null){
				 
			}
			
			try {
				lstRegion = this.getUbigeoService().listarRegion();
				lstProvincia = this.getUbigeoService().listarProvincia(ubigeoBean);
				lstDistrito = this.getUbigeoService().listarDistrito(ubigeoBean);
				
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		
		
			
			mav.addObject("lstRegion",lstRegion); 
			mav.addObject("lstProvincia",lstProvincia);
			mav.addObject("lstDistrito",lstDistrito); 
		}
	 
	 
	 
	private void cargarCombos(ModelAndView mav){
//		lstSituacion = new ArrayList<TablaBean>();
		
	 
		PerfilBean perfilBean = new PerfilBean();
		if (lstSituacion==null) {
			try { 
				lstSituacion = maestra1Service.listarPorCodigoTabla("situacionLengua",0);
				lstTipoDocumento = maestra1Service.listarPorCodigoTabla("tipoDocumento",1);
				lstNacionalidad = maestra2Service.listarPorCodigoTabla("nacionalidad",0);
						lstGrado=  maestra2Service.listarPorCodigoTabla("grado",0);
						lstCargo= maestra2Service.listarPorCodigoTabla("cargo",0);
						lstSexo= maestra2Service.listarPorCodigoTabla("sexo",0);
						lstPerfilBean=perfilService.getBuscarPorFiltros(perfilBean);
						//lstRegion = this.ubigeoService.listarRegion();
			} catch (ServiceException e) {
				System.out.println("printStackTrace");
				e.printStackTrace();
			}		
		}
  
		mav.addObject("lstSituacion",lstSituacion); 
		mav.addObject("lstTipoDocumento",lstTipoDocumento); 
		mav.addObject("lstNacionalidad",lstNacionalidad); 
		mav.addObject("lstGrado",lstGrado); 
		mav.addObject("lstCargo",lstCargo); 
		mav.addObject("lstSexo",lstSexo); 
		mav.addObject("lstPerfilBean",lstPerfilBean); 
		//mav.addObject("lstRegion",lstRegion); 
	}
	
private ModelAndView getLista(PersonalBean personalBean) {
		
		List<PersonalBean> lstPersonalBean = new ArrayList<PersonalBean>();
		
		try {
			lstPersonalBean = (List<PersonalBean>) this.getPersonalService().getBuscarPorFiltros(personalBean);
			System.out.println("lstLenguaBean "+lstPersonalBean.size());
		} catch (Exception e) {
			System.out.println("getLista " + e.getMessage());
		}
 
		
		ModelAndView mav = new ModelAndView("general/listado-administrativo", "command",personalBean);
		System.out.println("lstPersonalBean "+lstPersonalBean);
		mav.addObject("lstPersonalBean", lstPersonalBean);
		this.cargarCombos(mav);
		return mav;
	}

	@RequestMapping(value = "/validaPersonal", method = RequestMethod.POST)
	private @ResponseBody PersonalBean validaPersonal(@RequestParam("numerodocumento")String numeroDocumento){
		List<PersonalBean> lstPersonalBeans=new ArrayList<PersonalBean>();
		PersonalBean personalBean = new PersonalBean(); 
		PersonalBean prmpersonal=new PersonalBean();
		
		
		try {
			lstPersonalBeans = personalService.getBuscarPorFiltros(personalBean);
			if(lstPersonalBeans!=null){
				prmpersonal=personalService.getBuscarPorObjecto(lstPersonalBeans.get(0));
				
				
			}
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return prmpersonal;
		
	}

public PersonalBean getPersonalBean() {
	return personalBean;
}


public void setPersonalBean(PersonalBean personalBean) {
	this.personalBean = personalBean;
}


public List<PersonalBean> getLstpersonalBean() {
	return lstpersonalBean;
}


public void setLstpersonalBean(List<PersonalBean> lstpersonalBean) {
	this.lstpersonalBean = lstpersonalBean;
}


public List<TablaBean> getLstSituacion() {
	return lstSituacion;
}

public void setLstSituacion(List<TablaBean> lstSituacion) {
	this.lstSituacion = lstSituacion;
}

public List<TablaBean> getLstTipoDocumento() {
	return lstTipoDocumento;
}

public void setLstTipoDocumento(List<TablaBean> lstTipoDocumento) {
	this.lstTipoDocumento = lstTipoDocumento;
}

public PersonalService getPersonalService() {
	return personalService;
}


public void setPersonalService(PersonalService personalService) {
	this.personalService = personalService;
}

public PersonaService getPersonaService() {
	return personaService;
}

public void setPersonaService(PersonaService personaService) {
	this.personaService = personaService;
}
 
		
	public UbigeoService getUbigeoService() {
		return ubigeoService;
	}
	public void setUbigeoService(UbigeoService ubigeoService) {
		this.ubigeoService = ubigeoService;
	}
	
	
	
	
	
		
	
}
