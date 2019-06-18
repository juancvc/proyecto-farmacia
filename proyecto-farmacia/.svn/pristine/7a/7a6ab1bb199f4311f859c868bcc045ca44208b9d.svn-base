package hnch.referencia.web.controller.general;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList; 
import java.util.Date;
import java.util.List; 
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import gob.hnch.systems.ws.hnch.client.imp.PersonaServiceImp; 
import hnch.referencia.core.bean.general.PersonaBean; 
import hnch.referencia.core.bean.general.UbigeoBean;
import hnch.referencia.core.entity.general.PacienteReniec;
import hnch.referencia.core.service.exception.ServiceException;
import hnch.referencia.core.service.interfaces.general.PacienteReniecService;
import hnch.referencia.core.service.interfaces.general.PersonaService;
import hnch.referencia.core.service.interfaces.general.UbigeoService; 

@Controller
@RequestMapping(value = "personaController")
public class PersonaController {
	
	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private UbigeoService ubigeoService;
	
	private PersonaBean personaBean; 

	@Autowired
	private PacienteReniecService pacienteReniecService; 
	
	
	
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
		prmPersona.getTipoDocumento().setCodReg(tipoDocumento);
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
								personaBean.getNacionalidad().setCodReg("000114");
								SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
								String strFecha = lstPersona.get(0).getFechaNacimiento();
								int ind = lstPersona.get(0).getNombres().indexOf(" ");
								System.out.println("ind " + ind);
								String primerNombre = "";
								if (ind > 0) {
									primerNombre = lstPersona.get(0).getNombres().substring(0, ind);
									String segundoNombre = lstPersona.get(0).getNombres().substring(ind + 1, lstPersona.get(0).getNombres().length());
									
									personaBean.setPrimerNombre(primerNombre);
									personaBean.setSegundoNombre(segundoNombre);
								}else{
									personaBean.setPrimerNombre(lstPersona.get(0).getNombres());
									personaBean.setSegundoNombre("");
								}
								
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
									personaBean.getSexo().setCodReg("000002"); 
								}else{
									personaBean.getSexo().setCodReg("000001"); 
								}
								
								if (lstPersona.get(0).getEstCivil().equals("1")) {
									personaBean.getEstadoCivil().setCodReg("000002"); 
								}else if (lstPersona.get(0).getEstCivil().equals("2")){
									personaBean.getEstadoCivil().setCodReg("000002"); 
								} else if (lstPersona.get(0).getEstCivil().equals("3")) {
									personaBean.getEstadoCivil().setCodReg("000003"); 
								}else{
									personaBean.getEstadoCivil().setCodReg("000006"); 
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
					}
					
				 
				} 
		} catch (Exception e) { 
			
		} 
		
	
		return personaBean;
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

	
	
}
