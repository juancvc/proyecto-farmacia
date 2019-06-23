package proyect.web.controller.general;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList; 
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import gob.hnch.systems.ws.hnch.client.imp.PersonaServiceImp;
import proyect.base.bean.BaseBean;
import proyect.core.bean.general.PersonaBean;
import proyect.core.bean.general.CatalogoBean;
import proyect.core.bean.general.UbigeoBean;
import proyect.core.bean.seguridad.UsuarioBean;
import proyect.core.entity.general.PacienteReniec;
import proyect.core.service.exception.ServiceException;
import proyect.core.service.interfaces.catalogo.Catalogo1Service;
import proyect.core.service.interfaces.general.PacienteReniecService;
import proyect.core.service.interfaces.general.PersonaService;
import proyect.core.service.interfaces.general.UbigeoService;
import proyect.web.utilitarios.NetUtil;
import proyect.web.utilitarios.VO; 

@Controller
@RequestMapping(value = "personaController")
public class PersonaController {
	
	
	
	PersonaBean  opersonaBean = new PersonaBean();
	PersonaBean personaBean = new PersonaBean(); 
	
	String nombreUser = "";
	List<CatalogoBean> lstSituacion = new ArrayList<CatalogoBean>();
	List<CatalogoBean> lstDocumento = new ArrayList<CatalogoBean>();
	List<CatalogoBean> lstSexo = new ArrayList<CatalogoBean>();
	List<CatalogoBean> lstEstadoCivil = new ArrayList<CatalogoBean>();
	List<CatalogoBean> lstOcupacion = new ArrayList<CatalogoBean>();
	List<CatalogoBean> lstNacionalidad = new ArrayList<CatalogoBean>();
	List<CatalogoBean> lstNivelInstrucion = new ArrayList<CatalogoBean>();
	List<UbigeoBean> lstUbigeoBean = new ArrayList<UbigeoBean>();
	List<CatalogoBean> lstTipoExamen = new ArrayList<CatalogoBean>();
	private List<PersonaBean> lstPersonaBean ;  
	private List<PersonaBean> lstPersonaBeanRpt ;  
	
	@Autowired
	private PacienteReniecService pacienteReniecService; 
	
	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private UbigeoService ubigeoService;
	
	
	@Autowired
	private Catalogo1Service Catalogo1Service;
	
	

	private void cargarCombos(ModelAndView mav) {
		try {
		//	lstSituacion =maestraBanc01Service.listarPorCodigoTabla("000034", 1);
			lstDocumento = Catalogo1Service.listarPorCodigoTabla("000003", 1);
			lstSexo = Catalogo1Service.listarPorCodigoTabla("000004", 1);
			lstEstadoCivil = Catalogo1Service.listarPorCodigoTabla("000005", 0);
			lstOcupacion = Catalogo1Service.listarPorCodigoTabla("000007", 0);
			lstNacionalidad = Catalogo1Service.listarPorCodigoTabla("000003", 0);
			lstNivelInstrucion = Catalogo1Service.listarPorCodigoTabla("000006", 0);
			
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
	}
	
	@RequestMapping(value = "/validapersona", method = RequestMethod.POST)
	public @ResponseBody PersonaBean validaPersona(@RequestParam("tipodocumento") Integer tipoDocumento, @RequestParam("numerodocumento") String numeroDocumento) {

		List<UbigeoBean> lstUbigeoBean;
		UbigeoBean ubigeoBean;
 		personaBean = new PersonaBean();
	//	personaBean.getTipoDocumento().setCodigoRegistro(tipoDocumento);
	//	personaBean.setNumeroDocumento(numeroDocumento);
	
		try {
			personaBean = this.getPersonaService().buscarxTipoDocumentoNumeroDocumento(personaBean);
			
			if(personaBean!=null){
				ubigeoBean=new UbigeoBean();
				//ubigeoBean.setCodigoUbigeo(personaBean.getCodigoUbigeo());
				lstUbigeoBean = (List<UbigeoBean>)ubigeoService.getBuscarPorFiltros(ubigeoBean);
				if(lstUbigeoBean!=null){
					ubigeoBean=lstUbigeoBean.get(0);
				//	personaBean.getUbigeoBean().setCodigoUbigeo(ubigeoBean.getCodigoUbigeo());
				//	personaBean.getUbigeoBean().setNombreUbigeo(ubigeoBean.getNombreUbigeo());
				}
			}
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		
		if(personaBean==null){
			personaBean=new  PersonaBean();
		}
		
		return personaBean;
	}
	
	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView listado(@ModelAttribute("personaBean") PersonaBean personaBean, HttpServletRequest request) throws Exception {
		return this.listadoPost(personaBean, request) ;
	}
	@RequestMapping(value = "/listado", method = RequestMethod.POST)
	public ModelAndView listadoPost(@ModelAttribute("personaBean") PersonaBean personaBean, HttpServletRequest request) throws Exception {
	//	personaBean.getSituacion().setIdRegistro("000001");
		lstPersonaBean = new ArrayList<PersonaBean>(); 
		ModelAndView mav = new ModelAndView("asistencial/laboratorio/persona/listado-persona", "command", personaBean); 
		lstPersonaBean = personaService.getBuscarPorFiltros(personaBean);
		setLstPersonaBeanRpt(lstPersonaBean);
		lstSituacion = Catalogo1Service.listarPorCodigoTabla("000016", 1);
		
		mav.addObject("lstSituacion", lstSituacion);
		mav.addObject("lstPersonaBean", lstPersonaBean); 
		mav.addObject("personaBean", personaBean); 
		return mav;
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView buscarPOST(@ModelAttribute("personaBean") PersonaBean personaBean,
			HttpServletRequest request
			)
			throws Exception { 
		lstPersonaBean = new ArrayList<PersonaBean>(); 
		ModelAndView mav = new ModelAndView("asistencial/laboratorio/persona/listado-persona", "command", personaBean); 
		lstPersonaBean = personaService.getBuscarPorFiltros(personaBean);
		setLstPersonaBeanRpt(lstPersonaBean);
		mav.addObject("lstPersonaBean", lstPersonaBean); 
		mav.addObject("personaBean", personaBean); 
		return mav;
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public ModelAndView buscarGet(@ModelAttribute("ordenBean") PersonaBean personaBean,
			HttpServletRequest request
			)
			throws Exception { 
		return this.buscarPOST(personaBean, request) ;
	}
	

	@RequestMapping(value = "/buscarPersonaReniec", method = RequestMethod.GET)
	public ModelAndView doBuscarListado(@RequestParam("dni") String dni )
			throws Exception {
		try {
			
			PersonaServiceImp persona = new PersonaServiceImp();
			
			gob.hnch.systems.ws.ext.model.Persona perso =persona.getPersona(dni);
		} catch (Exception e) {
			// TODO: handle exception
		}
		ModelAndView mav = new ModelAndView("general/institucion/listado-institucion", "command",personaBean);
		
	/*	System.out.println("lstInstitucionBean"+lstInstitucionBean);
		mav.addObject("lstInstitucionBean", lstInstitucionBean);*/
	//	mav.addObject("personaRefBean", personaRefBean);
	//	this.listarCombos(mav);
		return mav;
		
	//	return this.getLista(institucionBean);
		
		
	}
	
	@RequestMapping(value = "/buscarPacienteReniec2", method = RequestMethod.GET)
	public @ResponseBody List<gob.hnch.systems.ws.ext.model.Persona> doBuscarProvincia(@RequestParam("nroDocumento") String nroDocumento)throws Exception {
		System.out.println("dni.. :"+nroDocumento);
		int codError=0;
		List<UbigeoBean> lstProvincia = new ArrayList<UbigeoBean>();
		List<gob.hnch.systems.ws.ext.model.Persona> lstPersona = new ArrayList<gob.hnch.systems.ws.ext.model.Persona>();
		PersonaServiceImp persona = new PersonaServiceImp();
		
		gob.hnch.systems.ws.ext.model.Persona perso =persona.getPersona(nroDocumento);
		lstPersona.add(perso);
		
		if (perso.getCodigoDeError().trim().equals("DNE")){
			System.out.println("perso.getCodigoDeError()"+perso.getCodigoDeError());
			codError = 1;
			//ubigeobean.setCodigoRegion(codigo);
			
	//		lstProvincia = ubigeoService.listarProvincia(ubigeobean);
			
	
			
		}
		return lstPersona;
	}
	
	
	
	@RequestMapping(value = "/consultarPersonaPorDocumento", method = RequestMethod.GET)
	public @ResponseBody PersonaBean consultarPorNroDocumento(@RequestParam("tipoDocumento") String tipoDocumento,@RequestParam("numero") String numero)throws Exception {
		  
		personaBean = new PersonaBean();
		PersonaBean prmPersona = new PersonaBean();
		prmPersona.setNroDocumento(numero);
		prmPersona.getTipoDocumento().setIdRegistro(tipoDocumento);
		try {
		/*	personaBean = this.getPersonaService().buscarxTipoDocumentoNumeroDocumento(prmPersona); 
			if(personaBean!=null){ 
			
			}else{*/
				personaBean = this.getPersonaService().buscarxTipoDocumentoNumeroDocumentoSigeho(prmPersona);
				if(personaBean!=null){  
					System.out.println("persona existe en sigehov2gene");
					System.out.println(personaBean.getNombreCompleto());
					 
					
					if (tipoDocumento.equals("000002")) {
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
							System.out.println("bphoto " + bphoto);
							personaBean.setFoto(lstPersona.get(0).getFotoPaciente());
							personaBean.setFotoCadena(bphoto);
							personaBean.setSwReniec(false);
						}
					}
				
					
				}else{  
					PacienteReniec pacienteReniec = new PacienteReniec();
					pacienteReniec.setNroDni(numero); 
					List<PacienteReniec> lstPersona = null ; //new ArrayList<PacienteReniec>();
					try {
						lstPersona = pacienteReniecService.pacienteReniecVerificacion(pacienteReniec) ;		
					} catch (Exception e) {
						System.out.println("entro al catch");
						lstPersona =  null;
					}
								
					//lstPersona.add(perso); 
					if (lstPersona!= null ) {
						if (lstPersona.size() > 0) {
							if (lstPersona.get(0).getCodigoRespuesta().equals("0000")) {
								System.out.println("lstPersona size " + lstPersona.size());
								personaBean = new PersonaBean();
								System.out.println("personaBean RENIEC no es null " + lstPersona.get(0).getCodigoRespuesta());
								personaBean.setApellidoMaterno(lstPersona.get(0).getApellidoMaterno());
								personaBean.setApellidoPaterno(lstPersona.get(0).getApellidoPaterno());
								personaBean.getNacionalidad().setIdRegistro("000114");
								SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
								String strFecha = lstPersona.get(0).getFechaNacimiento();
								
								personaBean.setNombres(lstPersona.get(0).getNombres());
								if(lstPersona.get(0).getFotoPaciente() != null){
									personaBean.setFoto(lstPersona.get(0).getFotoPaciente());
								}
								/**
								personaBean.setUbiDepartamento(lstPersona.get(0).getUbiDepart());
								personaBean.setUbiProvincia(lstPersona.get(0).getUbiProv());
								personaBean.setUbiDistrito(lstPersona.get(0).getUbiDist());
								*/
								UbigeoBean oUbigeoBean = new UbigeoBean();
								oUbigeoBean.setCodigoUbigeo(lstPersona.get(0).getUbiDepart()+
															lstPersona.get(0).getUbiProv() + 
															lstPersona.get(0).getUbiDist());
								oUbigeoBean = ubigeoService.buscarEquivalenteReniecMinsa(oUbigeoBean);
								personaBean.setUbigeoDireccion(oUbigeoBean);
								
								UbigeoBean oUbigeoNacimiemtoBean = new UbigeoBean();
								oUbigeoNacimiemtoBean.setCodigoUbigeo(lstPersona.get(0).getUbiDepNac()+
															lstPersona.get(0).getUbiProvNac() + 
															lstPersona.get(0).getUbiDistNac());
								oUbigeoNacimiemtoBean = ubigeoService.buscarEquivalenteReniecMinsa(oUbigeoNacimiemtoBean);
								personaBean.setUbigeoNacimiento(oUbigeoNacimiemtoBean);
								
								Date fecha = null;
								try {

								fecha = formatoDelTexto.parse(strFecha);

								} catch (ParseException ex) {

								ex.printStackTrace();

								}
								personaBean.setDireccion(lstPersona.get(0).getDireccion());
								personaBean.setFechaNac(fecha);
								System.out.println("personaBean no es null " + personaBean.getNombreCompleto());
								System.out.println("personaBean no es null " + personaBean.getFechaNac());
								if (lstPersona.get(0).getSexo().equals("1")) {
									personaBean.getSexo().setIdRegistro("000002"); 
								}else{
									personaBean.getSexo().setIdRegistro("000001"); 
								}
								
								if (lstPersona.get(0).getEstCivil().equals("1")) {
									personaBean.getEstadoCivil().setIdRegistro("000002"); 
								}else if (lstPersona.get(0).getEstCivil().equals("2")){
									personaBean.getEstadoCivil().setIdRegistro("000002"); 
								} else if (lstPersona.get(0).getEstCivil().equals("3")) {
									personaBean.getEstadoCivil().setIdRegistro("000003"); 
								}else{
									personaBean.getEstadoCivil().setIdRegistro("000006"); 
								}
								
								System.out.println("tipoDocumento " + tipoDocumento);
							}else{
								System.out.println("no existe persona reniec");
								personaBean  = null;	
							}
							 
						}else{
							System.out.println("no existe persona reniec");
							personaBean  = null;
						} 
					}else{
						System.out.println("no existe persona ó no hay servicio de reniec");
					//	personaBean  = null;
						personaBean = new PersonaBean();
					}
					
				 
				} 
		} catch (Exception e) { 
			
		} 
		
	
		return personaBean;
	}
	
	
	
	
	/*****************************************************************/
	/************************** POSTULANTES **************************/
	
	@RequestMapping(value = "/consultarPersonaPorDocumentoLaboratorio", method = RequestMethod.GET)
	public @ResponseBody PersonaBean consultarPorNroDocumentoLaboratorio
	(@RequestParam("tipoDocumento") String tipoDocumento,
	 @RequestParam("numero") String numero)throws Exception {
		this.setPersonaBean(new PersonaBean());  
		personaBean = new PersonaBean();
		PersonaBean prmPersona = new PersonaBean();
		prmPersona.setNroDocumento(numero);
		prmPersona.getTipoDocumento().setIdRegistro(tipoDocumento);
		try {
		/*	personaBean = this.getPersonaService().buscarxTipoDocumentoNumeroDocumento(prmPersona); 
			if(personaBean!=null){ 
			
			}else{*/
			//	personaBean = personaService.buscarxTipoDocumentoNumeroDocumentoSigeho(prmPersona);
				personaBean = personaService.buscarxTipoDocumentoNumeroDocumento(prmPersona);
				if(personaBean!=null){  
					System.out.println("persona existe en sigehov2gene");
					System.out.println(personaBean.getNombreCompleto()); 
					System.out.println("personaBean.getCodigo() " + personaBean.getCodigo());
		
					
					if (tipoDocumento.equals("000002")) {
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
				
					
				}else{  
					personaBean = new PersonaBean();
					personaBean.getTipoDocumento().setIdRegistro("000002");
					personaBean.setNroDocumento(numero);
					personaBean.setOrigenDatos("");
					
					
					
					
					
					
					
					
					
					
					
					
					
					PacienteReniec pacienteReniec = new PacienteReniec();
					pacienteReniec.setNroDni(numero); 
					List<PacienteReniec> lstPersona = null ; //new ArrayList<PacienteReniec>();
					if (tipoDocumento.equals("000002")) {
						try {
							lstPersona = pacienteReniecService.pacienteReniecVerificacion(pacienteReniec) ;		
							System.out.println("lstPersona.get(0).getCodigoRespuesta() " + lstPersona.get(0).getCodigoRespuesta());
						} catch (Exception e) {
							System.out.println("entro al catch");
							lstPersona =  null;
						}	
					} 		
					//lstPersona.add(perso); 
					if (lstPersona!= null ) {
						if (lstPersona.size() > 0) {
							if (lstPersona.get(0).getCodigoRespuesta().equals("0000")) {
								System.out.println("lstPersona size " + lstPersona.size());
								personaBean = new PersonaBean();
								personaBean.getTipoDocumento().setIdRegistro("000002");
								personaBean.setNroDocumento(numero);
								personaBean.setOrigenDatos("RENIEC");
								personaBean.setSwReniec(true);
								personaBean.setCodigoErrorReniec(lstPersona.get(0).getCodigoRespuesta());
								System.out.println("personaBean RENIEC no es null " + lstPersona.get(0).getCodigoRespuesta());
								personaBean.setApellidoMaterno(lstPersona.get(0).getApellidoMaterno());
								personaBean.setApellidoPaterno(lstPersona.get(0).getApellidoPaterno());
								personaBean.getNacionalidad().setIdRegistro("000114");
								SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
								String strFecha = lstPersona.get(0).getFechaNacimiento();
							 
								personaBean.setNombres(lstPersona.get(0).getNombres());
								 
								if(lstPersona.get(0).getFotoPaciente() != null){
									personaBean.setFoto(lstPersona.get(0).getFotoPaciente());
								}
								/**
								personaBean.setUbiDepartamento(lstPersona.get(0).getUbiDepart());
								personaBean.setUbiProvincia(lstPersona.get(0).getUbiProv());
								personaBean.setUbiDistrito(lstPersona.get(0).getUbiDist());
								*/
								UbigeoBean oUbigeoBean = new UbigeoBean();
								oUbigeoBean.setCodigoUbigeo(lstPersona.get(0).getUbiDepart()+
															lstPersona.get(0).getUbiProv() + 
															lstPersona.get(0).getUbiDist());
								oUbigeoBean = ubigeoService.buscarEquivalenteReniecMinsa(oUbigeoBean);
								personaBean.setUbigeoDireccion(oUbigeoBean);
								
								UbigeoBean oUbigeoNacimiemtoBean = new UbigeoBean();
								oUbigeoNacimiemtoBean.setCodigoUbigeo(lstPersona.get(0).getUbiDepNac()+
															lstPersona.get(0).getUbiProvNac() + 
															lstPersona.get(0).getUbiDistNac());
								oUbigeoNacimiemtoBean = ubigeoService.buscarEquivalenteReniecMinsa(oUbigeoNacimiemtoBean);
								personaBean.setUbigeoNacimiento(oUbigeoNacimiemtoBean);
								
								Date fecha = null;
								try {

								fecha = formatoDelTexto.parse(strFecha);

								} catch (ParseException ex) {

								ex.printStackTrace();

								}
								personaBean.setDireccion(lstPersona.get(0).getDireccion());
								personaBean.setFechaNac(fecha);
								personaBean.setFechaNacStr(strFecha);
								System.out.println("personaBean no es null " + personaBean.getNombreCompleto());
								System.out.println("personaBean no es null " + personaBean.getFechaNac());
								if (lstPersona.get(0).getSexo().equals("1")) {
									personaBean.getSexo().setIdRegistro("000002"); 
								}else{
									personaBean.getSexo().setIdRegistro("000001"); 
								}
								
								if (lstPersona.get(0).getEstCivil().equals("1")) {
									personaBean.getEstadoCivil().setIdRegistro("000001"); 
								}else if (lstPersona.get(0).getEstCivil().equals("2")){
									personaBean.getEstadoCivil().setIdRegistro("000002"); 
								} else if (lstPersona.get(0).getEstCivil().equals("3")) {
									personaBean.getEstadoCivil().setIdRegistro("000003"); 
								}else{
									personaBean.getEstadoCivil().setIdRegistro("000006"); 
								}
								
								System.out.println("tipoDocumento " + tipoDocumento);
							}else{
								System.out.println("no existe persona reniec");
								personaBean  = null;	
							}
							 
						}else{
							System.out.println("no existe persona reniec");
							personaBean  = null;
						} 
					}else{
						System.out.println("no existe persona ó no hay servicio de reniec");
						personaBean  = null;
					//	personaBean  = new PersonaBean();
					} 
				} 
		} catch (Exception e) {  
		} 
		
	//    this.getPostulanteBean().setPersona(personaBean);
	    this.setPersonaBean(personaBean);
		return personaBean;
	}
	
	
	@RequestMapping(value = "/grabarPersonaLaboratorio", method = RequestMethod.POST)
	public @ResponseBody PersonaBean grabarPersonaLaboratorio(@ModelAttribute("personaBean")PersonaBean obpersonaBean,
											 HttpServletRequest request) throws Exception {  
	
		if (personaBean==null) {
			personaBean = new PersonaBean();
		}
		
	//	this.getPersonaBean().setOrigenDeRegistro("Sistema Labmed Web");
	// 	personaBean = new PersonaBean();
	//	this.getPostulanteBean().getTipoPostulate().setIdRegistro("000001");
		if (this.getPersonaBean().getCodigo().equals("")) {
			if(!obpersonaBean.getTipoDocumento().getIdRegistro().equals("000002") ){ // extranjero
				this.setAuditoria(obpersonaBean, request, true); 
				this.personaService.insertarPersonaLaboratorio(obpersonaBean);
				setPersonaBean(obpersonaBean);
			}else{
				setPersonaBean(new PersonaBean());
				if(this.getPersonaBean().getSwReniec()){
					
					System.out.println("this.getPostulanteBean().getPersona(). " +this.getPersonaBean().getTipoDocumento().getIdRegistro());
					System.out.println("this.getPostulanteBean().getPersona() ::" + this.getPersonaBean());
					this.getPersonaBean().setTelefonoNumero(obpersonaBean.getTelefonoNumero());
					this.getPersonaBean().setCorreo(obpersonaBean.getCorreo());
					this.getPersonaBean().getNivelInstrucion().setIdRegistro(obpersonaBean.getNivelInstrucion().getIdRegistro());
					this.getPersonaBean().getOcupacion().setIdRegistro(obpersonaBean.getOcupacion().getIdRegistro());
					
					this.setAuditoria(this.getPersonaBean(), request, true); 
					this.personaService.insertarPersonaLaboratorio(this.getPersonaBean());
					System.out.println("persona reniec");
				}else{
					this.getPersonaBean().setTelefonoNumero(obpersonaBean.getTelefonoNumero());
					this.getPersonaBean().setCorreo(obpersonaBean.getCorreo());
					this.getPersonaBean().getNivelInstrucion().setIdRegistro(obpersonaBean.getNivelInstrucion().getIdRegistro());
					this.setAuditoria(obpersonaBean, request, true); 
					this.personaService.insertarPersonaLaboratorio(obpersonaBean);
					setPersonaBean(obpersonaBean);
				}
			}
			
			System.out.println("persona no existe");
		//	this.personaService.insertarPersonaBanco(this.getPostulanteBean().getPersona());
			
		}else{  
			
		} 
		if (!personaBean.getCodigo().trim().equals("")) {
			this.setAuditoria(this.getPersonaBean(), request, false); 
			System.out.println("actualiza postulanteBean " + obpersonaBean.getCodigo());
	
		} else {
			
			/*
			EstadoFisicoBean oeEstadoFisicoBean = new EstadoFisicoBean();
			oeEstadoFisicoBean.setPersonaBean(this.getPersonaBean());
			this.setAuditoria(oeEstadoFisicoBean, request, true); */
			this.setAuditoria(this.getPersonaBean(), request, true); 
			
		//	this.setAuditoria(odDonanteBean, request, true); 
		//	System.out.println("insert postulanteBean " + postulanteBean.getCodigo());
			
		//	odDonanteBean.getTipoRegistro().setIdRegistro("000003");
		//	odDonanteBean.setPersona(this.getPostulanteBean().getPersona());

		
			
		}  
	//	nuevoPostulante(request,obpersonaBean);
	//	return this.getPostulanteBean();
		return this.getPersonaBean();
	}
	
	 
	
	
	
	/*
	private ModelAndView getLista(InstitucionBean institucionBean) {
		
		List<InstitucionBean> lstInstitucionBean = new ArrayList<InstitucionBean>();
		
		try {
			PersonaServiceImp persona = new PersonaServiceImp();
			String nroDoc;
			gob.hnch.systems.ws.ext.model.Persona perso =persona.getPersona(nroDoc);
			
			
			lstInstitucionBean = (List<InstitucionBean>) this.getInstitucionService().getBuscarPorFiltros(institucionBean);
			
			
 
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getLista " + e.getMessage());
		}

		ModelAndView mav = new ModelAndView("general/institucion/listado-institucion", "command",institucionBean);
	
		System.out.println("lstInstitucionBean"+lstInstitucionBean);
		mav.addObject("lstInstitucionBean", lstInstitucionBean);
		mav.addObject("institucionBean", institucionBean);
	//	this.listarCombos(mav);
		return mav;
	}
	
	*/
	
	/***NUEVA LINEA 19-04-2019****/
	@RequestMapping(value = "/nuevoPaciente", method = RequestMethod.GET)
	public ModelAndView nuevoPaciente(HttpServletRequest request) {
		PersonaBean personaBean = new PersonaBean(); 
	
		ModelAndView mav = new ModelAndView("asistencial/laboratorio/registro-paciente-laboratorio", "command", personaBean); 
		
		this.cargarCombos(mav);
		return mav;
	}
	
	   @RequestMapping(value = "/descargarExcel", method = RequestMethod.GET, produces = "application/vnd.ms-excel")
	    public @ResponseBody void descargarExcel(HttpServletResponse response) throws IOException {
	    	 try {
	    		 Workbook wb = generarExcel();
	    		 response.setHeader("Content-disposition", "attachment; filename=reporteExcel.xls");
	    		 wb.write( response.getOutputStream() );
	         } catch (Exception e) {
	             e.printStackTrace();
	         }
	    }
	   
	   public HSSFWorkbook generarExcel() {
	        try {
	            HSSFWorkbook workbook = new HSSFWorkbook();
	            //Hoja
	            HSSFSheet    sheet    = workbook.createSheet("SEGUIMIENTO DE PACIENTES");
	            /**** color ***/
	            HSSFColor lightGray =  setColor(workbook,(byte) 0xE0, (byte)0xE0,(byte) 0xE0);
	            /**estilos**/
	            //estilo para el titulo
	            HSSFFont headerFont = workbook.createFont();
	            CellStyle titleStyle = workbook.createCellStyle();
	            //titleStyle.setFillForegroundColor(lightGray.getIndex());
	            titleStyle.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
	            titleStyle.setAlignment(CellStyle.ALIGN_CENTER);
	            titleStyle.setFont(headerFont);
	            //estilo para el cabecera
	            HSSFCellStyle headerStyle = workbook.createCellStyle();
	            headerStyle.setFillForegroundColor(lightGray.getIndex());
	            headerStyle.setAlignment(CellStyle.ALIGN_CENTER);
	            headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	            headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	            headerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
	            headerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
	            headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	            //estilo para el cuerpo
	         	HSSFCellStyle bodyStyle = workbook.createCellStyle();
	         	//bodyStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	         	bodyStyle.setFillBackgroundColor(IndexedColors.WHITE.getIndex());
	         	bodyStyle.setAlignment(CellStyle.ALIGN_CENTER);
	         	bodyStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	         	bodyStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
	         	bodyStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
	         	bodyStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	            /*** tamaÃ¯Â¿Â½o de la columnas ***/
	            sheet.setColumnWidth(0, 2500); 
	            sheet.setColumnWidth(1, 2500);
	            sheet.setColumnWidth(2, 10000);
	            sheet.setColumnWidth(3, 10000); 
	            sheet.setColumnWidth(4, 10000);
	            sheet.setColumnWidth(5, 8000);
	            
	            sheet.setColumnWidth(6, 8000);
//	            sheet.setColumnWidth(7, 5000);
//	            sheet.setColumnWidth(8, 3000);
//	            sheet.setColumnWidth(9, 3000);
//	            sheet.setColumnWidth(7, 5000);
//	            sheet.setColumnWidth(8, 5000);
	            sheet.setColumnWidth(7, 5000);
	            /**** fuente ***/
	            //titulo
	            HSSFFont fontTitulo = workbook.createFont();
	            fontTitulo.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	            fontTitulo.setFontHeightInPoints((short) 14);
	            
	            titleStyle.setFont(fontTitulo);
	            //cabecera
	            HSSFFont fontCabecera = workbook.createFont();
	            fontCabecera.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	            fontCabecera.setFontHeightInPoints((short) 9);
	            
	            headerStyle.setFont(fontCabecera); 	
	            
	            /*** contenido del excel ***/
	            int rowIndex  = 0;
	            HSSFCell headerCell = null;
	            sheet.createRow( rowIndex++ );
	            sheet.createRow( rowIndex++ );
	            HSSFRow   headerRow    = sheet.createRow( rowIndex++ );
	            sheet.addMergedRegion(new CellRangeAddress(2, 2, 1, 7));
	            headerCell = headerRow.createCell(1);
	            headerCell.setCellValue("LISTADO DE PACIENTES");
	            headerCell.setCellStyle(titleStyle);
	            sheet.createRow( rowIndex++ );
	            //Fila
	            HSSFRow      bodyRow    = sheet.createRow( rowIndex++ );
	            
	            
	           
	            
	            /************************* cabecera *****************************/
		            
	            headerCell = bodyRow.createCell(1);
	            headerCell.setCellStyle(headerStyle);
	            headerCell.setCellValue("N°");
	            headerCell = bodyRow.createCell(2);
	            headerCell.setCellStyle(headerStyle);
	            headerCell.setCellValue("SEDE REGISTRO");
	            headerCell = bodyRow.createCell(3);
	            headerCell.setCellStyle(headerStyle);
	            headerCell.setCellValue("PACIENTE");
	            headerCell = bodyRow.createCell(4);
	            headerCell.setCellStyle(headerStyle);
	            headerCell.setCellValue("FECHA REGISTRO");
	            headerCell = bodyRow.createCell(5);
	            headerCell.setCellStyle(headerStyle);
	            headerCell.setCellValue("PROCEDENCIA");
	            headerCell = bodyRow.createCell(6);
	            headerCell.setCellStyle(headerStyle);
	            headerCell.setCellValue("USUARIO REGISTRO");
//	            headerCell = bodyRow.createCell(7);
//	            headerCell.setCellStyle(headerStyle);
//	            headerCell.setCellValue("NIVEL");
//	            headerCell = bodyRow.createCell(8);
//	            headerCell.setCellStyle(headerStyle);
//	            headerCell.setCellValue("CICLO");
//	            headerCell = bodyRow.createCell(9);
//	            headerCell.setCellStyle(headerStyle);
//	            headerCell.setCellValue("AÃ¯Â¿Â½O");
//	            headerCell = bodyRow.createCell(7);
//	            headerCell.setCellStyle(headerStyle);
//	            headerCell.setCellValue("FECHA INICIO");
//	            headerCell = bodyRow.createCell(8);
//	            headerCell.setCellStyle(headerStyle);
//	            headerCell.setCellValue("FECHA TERMINO");
	            headerCell = bodyRow.createCell(7);
	            headerCell.setCellStyle(headerStyle);
	            headerCell.setCellValue("SITUACION");
	            /******************* Contenido *************************/
	    		HSSFRow  contentRow  = null;
	    		HSSFCell contentCell = null;
	    		
	    		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
	    	
	            for (int i = 0; i < this.getLstPersonaBeanRpt().size(); i++) {
	            	
//	            	personaBean personaBean = this.lstpersonaBean.get(i);
	            	PersonaBean personaBean = this.getLstPersonaBeanRpt().get(i);
	            	contentRow = sheet.createRow( rowIndex++ );
	            	contentCell = contentRow.createCell(1);
	            	contentCell.setCellStyle(bodyStyle);
	            	contentCell.setCellValue(String.valueOf((i+1)));
	            	contentCell = contentRow.createCell(2);
	            	contentCell.setCellStyle(bodyStyle);
	            //	contentCell.setCellValue(personaBean.getCodigoSede());
	            	contentCell = contentRow.createCell(3);
	            	contentCell.setCellStyle(bodyStyle);
	            	contentCell.setCellValue(personaBean.getNombreCompleto());
	            	contentCell = contentRow.createCell(4);
	            	contentCell.setCellStyle(bodyStyle);
	            	contentCell.setCellValue(personaBean.getStrFechaCreacion());
	            	contentCell = contentRow.createCell(5);
	            	contentCell.setCellStyle(bodyStyle);
	            	contentCell.setCellValue(personaBean.getUbigeoDireccion().getNombreUbigeo());
	            	contentCell = contentRow.createCell(6);
	            	contentCell.setCellStyle(bodyStyle);
	            	contentCell.setCellValue(personaBean.getNombreUsuarioCreacion());

	            	contentCell = contentRow.createCell(7);
	            	contentCell.setCellStyle(bodyStyle); 
	            }
	            workbook.write(new FileOutputStream("reporteExcel.xls"));

	            //return workbook.getBytes();
	            return workbook;
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	   

	    public HSSFColor setColor(HSSFWorkbook workbook, byte r,byte g, byte b){
	        HSSFPalette palette = workbook.getCustomPalette();
	        HSSFColor hssfColor = null;
	        try {
	            hssfColor= palette.findColor(r, g, b); 
	            if (hssfColor == null ){
	                palette.setColorAtIndex(HSSFColor.LAVENDER.index, r, g,b);
	                hssfColor = palette.getColor(HSSFColor.LAVENDER.index);
	            }
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }

	        return hssfColor;
	    }
		
	   
	
	
	protected void setAuditoria(BaseBean baseBean,HttpServletRequest request,boolean swInsert){
		UsuarioBean usuario= (UsuarioBean) request.getSession().getAttribute("usuarioSesion");
		String idUsuario= !VO.isNull(usuario) ? usuario.getCodigo() :"0";	
		nombreUser = !VO.isNull(usuario) ? usuario.getNombreUsuario() :"0";	
		this.setAuditoriaLocal(baseBean, idUsuario, request, swInsert);		
	}
	private void setAuditoriaLocal(BaseBean baseBean,String iddUsuario,HttpServletRequest request,boolean swInsert){
		if (swInsert) {
			baseBean.setCodigoUsuarioCreacion(iddUsuario);
			baseBean.setNombreUsuarioCreacion(nombreUser);
			baseBean.setIpCreacion(NetUtil.getClientIpAddr(request));			
			
		} else {
			baseBean.setCodigoUsuarioModificacion(iddUsuario);
			baseBean.setNombreUsuarioCreacion(nombreUser);
			baseBean.setIpModificacion(NetUtil.getClientIpAddr(request));			
		}

	}
	

	public PersonaService getPersonaService() {
		return personaService;
	}

	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}

	public PersonaBean getPersonaBean() {
		return personaBean;
	}

	public void setPersonaBean(PersonaBean personaBean) {
		this.personaBean = personaBean;
	}

	public List<PersonaBean> getLstPersonaBeanRpt() {
		return lstPersonaBeanRpt;
	}

	public void setLstPersonaBeanRpt(List<PersonaBean> lstPersonaBeanRpt) {
		this.lstPersonaBeanRpt = lstPersonaBeanRpt;
	}
	
	
}
