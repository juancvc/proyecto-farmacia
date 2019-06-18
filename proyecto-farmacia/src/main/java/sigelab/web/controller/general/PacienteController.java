package sigelab.web.controller.general;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import gob.hnch.system.ws.sis.model.PersonaSIS;
import gob.hnch.system.ws.sis.model.PrmConsultaSIS;
import gob.hnch.system.ws.sis.srv.impl.PersonaSISServiceImp;
import gob.hnch.system.ws.sis.srv.inf.PersonaSISService; 
import gob.hnch.systems.ws.hnch.client.imp.PersonaServiceImp;
import sigelab.core.bean.general.PacienteBean;
import sigelab.core.bean.general.PersonaBean; 
import sigelab.core.bean.general.UbigeoBean;
import sigelab.core.entity.general.PacienteReniec;
import sigelab.core.service.exception.ServiceException;
import sigelab.core.service.interfaces.general.PacienteReniecService;
import sigelab.core.service.interfaces.general.PersonaService;
import sigelab.core.service.interfaces.general.UbigeoService;
import sigelab.web.utilitarios.VO; 
import org.apache.commons.codec.binary.Base64;

@Controller
@RequestMapping(value = "pacienteController")
public class PacienteController {
	
	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private UbigeoService ubigeoService;
	
	@Autowired
	private PacienteReniecService pacienteReniecService; 
	
	private PersonaBean personaBean; 
	
	private PacienteBean pacienteBean; 

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
	
	
	 
	@RequestMapping(value = "/consultarPorDocumentoPersona", method = RequestMethod.GET)
	public @ResponseBody PacienteBean consultarPorNroDocumento(@RequestParam("tipoDocumento") String tipoDocumento,@RequestParam("numero") String numero)throws Exception {
		 
		PacienteBean paciente  = new PacienteBean();
		personaBean = new PersonaBean();
		PersonaBean prmPersona = new PersonaBean();
		prmPersona.setNroDocumento(numero);
		prmPersona.getTipoDocumento().setCodReg(tipoDocumento);
		try {
			personaBean = this.getPersonaService().buscarxTipoDocumentoNumeroDocumento(prmPersona); 
			if(personaBean!=null){
				System.out.println("persona existe en reco.persona");
				PacienteReniec pacienteReniec = new PacienteReniec();
				pacienteReniec.setNroDni(numero);
				List<PacienteReniec> lstPersona = null; //new ArrayList<PacienteReniec>();
				try {
					lstPersona = pacienteReniecService.pacienteReniecVerificacion(pacienteReniec) ;				
				} catch (Exception e) {
				}
				
				if (lstPersona!= null ) {
					String bphoto = Base64.encodeBase64String(lstPersona.get(0).getFotoPaciente());
					System.out.println("bphoto " + bphoto);
					personaBean.setFoto(lstPersona.get(0).getFotoPaciente());
					personaBean.setFotoCadena(bphoto);
				}else{
					personaBean.setSwReniec(false);
				}
				
				
				paciente.setPersona(personaBean);
			}else{
				personaBean = this.getPersonaService().buscarxTipoDocumentoNumeroDocumentoSigeho(prmPersona);
				if(personaBean!=null){  
					System.out.println("persona existe en sigehov2gene");
					System.out.println(personaBean.getNombreCompleto());
					System.out.println("fechNac" + personaBean.getFechaNac());
					System.out.println("personaBeangetFoto " + personaBean.getFoto());
					personaBean.setCodigo("");
					
					System.out.println("paciente nombrecompleto "+ paciente.getPersona().getNombreCompleto());
					
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
					paciente.setPersona(personaBean);
				/*	if(personaBean.getFoto()!= null ){
						
					}
				*/	
				}else{ 
					//List<gob.hnch.systems.ws.ext.model.Persona> lstPersona = new ArrayList<gob.hnch.systems.ws.ext.model.Persona>();
					//PersonaServiceImp persona = new PersonaServiceImp();  
					//gob.hnch.systems.ws.ext.model.Persona perso =persona.getPersona(numero);
					
					PacienteReniec pacienteReniec = new PacienteReniec();
					pacienteReniec.setNroDni(numero);
					//System.out.println("personaaaa"+perso.toString());
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
								System.out.println("personaBean RENIEC no es null " + lstPersona.get(0).getCodigoRespuesta());
								paciente.getPersona().setApellidoMaterno(lstPersona.get(0).getApellidoMaterno());
								paciente.getPersona().setApellidoPaterno(lstPersona.get(0).getApellidoPaterno());
								
								SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
								String strFecha = lstPersona.get(0).getFechaNacimiento();
								int ind = lstPersona.get(0).getNombres().indexOf(" ");
								System.out.println("ind " + ind);
								String primerNombre = "";
								if (ind > 0) {
									primerNombre = lstPersona.get(0).getNombres().substring(0, ind);
									String segundoNombre = lstPersona.get(0).getNombres().substring(ind + 1, lstPersona.get(0).getNombres().length());
									
									paciente.getPersona().setPrimerNombre(primerNombre);
									paciente.getPersona().setSegundoNombre(segundoNombre);
								}else{
									paciente.getPersona().setPrimerNombre(lstPersona.get(0).getNombres());
									paciente.getPersona().setSegundoNombre("");
								}
								
								if(lstPersona.get(0).getFotoPaciente() != null){
									paciente.getPersona().setFoto(lstPersona.get(0).getFotoPaciente());
								}
								Date fecha = null;
								try {

								fecha = formatoDelTexto.parse(strFecha);

								} catch (ParseException ex) {

								ex.printStackTrace();

								}
								
								paciente.getPersona().setFechaNac(fecha);
								System.out.println("personaBean no es null " + paciente.getPersona().getNombreCompleto());
								System.out.println("personaBean no es null " + paciente.getPersona().getFechaNac());
								if (lstPersona.get(0).getSexo().equals("1")) {
									paciente.getPersona().getSexo().setCodReg("000002"); 
								}else{
									paciente.getPersona().getSexo().setCodReg("000001"); 
								}
								System.out.println("tipoDocumento " + tipoDocumento);
							}else{
								System.out.println("no existe persona reniec");
								paciente  = null;	
							}
							 
						}else{
							System.out.println("no existe persona reniec");
							paciente  = null;
						}
						
					/**	PersonaSIS personasis = new PersonaSIS();
						personasis.setNrodocumento(numero);
						*/
					}else{
						System.out.println("no existe persona ó no hay servicio de reniec");
						paciente  = null;
					}
					
					/**
					List<gob.hnch.systems.ws.ext.model.Persona> lstPersona = new ArrayList<gob.hnch.systems.ws.ext.model.Persona>();
					PersonaServiceImp persona = new PersonaServiceImp();  
					gob.hnch.systems.ws.ext.model.Persona perso =persona.getPersona(numero);
					System.out.println("personaaaa"+perso.toString());
					lstPersona.add(perso); 
					if (perso!= null ) {
						System.out.println("personaBean no es null " + perso.getApSegundo());
						paciente.getPersona().setApellidoMaterno(perso.getApSegundo());
						paciente.getPersona().setApellidoPaterno(perso.getApPrimer());
						paciente.getPersona().setPrimerNombre(perso.getPrenomInscrito());
						SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyyMMdd");
						String strFecha = perso.getFeNacimiento();
						Date fecha = null;
						try {

						fecha = formatoDelTexto.parse(strFecha);

						} catch (ParseException ex) {

						ex.printStackTrace();

						}
						
						paciente.getPersona().setFechaNac(fecha);
						System.out.println("personaBean no es null " + paciente.getPersona().getNombreCompleto());
						
						if (perso.getDeGenero().equals("1")) {
							paciente.getPersona().getSexo().setCodReg("000002"); 
						}else{
							paciente.getPersona().getSexo().setCodReg("000001"); 
						}
						System.out.println("tipoDocumento " + tipoDocumento);
						
						PersonaSIS personasis = new PersonaSIS();
						personasis.setNrodocumento(numero);
					}
					*/
				} 
			}
		} catch (Exception e) { 
			
		}
		
		if (paciente != null) {
			/*** consulta sis websercive ****/
		 	 final	PrmConsultaSIS prmConsultaSIS = new PrmConsultaSIS();
				prmConsultaSIS.setIntOpcion(1); 
				prmConsultaSIS.setStrDNI("10201932");
				if(tipoDocumento.equals("000001")){
				prmConsultaSIS.setStrTipoDocumento("1");
				}else if(tipoDocumento.equals("000002"))
				{
				prmConsultaSIS.setStrTipoDocumento("3");	
				}
				prmConsultaSIS.setStrNroDocumento(numero);
				PersonaSIS resp = null;
				ExecutorService executor = Executors.newSingleThreadExecutor();
				 
				try {
					final PersonaSISServiceImp personaSISService = new PersonaSISServiceImp();
					 List<Future<gob.hnch.system.ws.sis.model.PersonaSIS>> lstPaciente = executor.invokeAll(Arrays.asList(new 	Callable<gob.hnch.system.ws.sis.model.PersonaSIS>(){
						 @Override
							public gob.hnch.system.ws.sis.model.PersonaSIS call()
									throws Exception { 
								return personaSISService.getPersonaSIS(prmConsultaSIS); 
								
							}
							 
						 }),10,TimeUnit.SECONDS);
					 		executor.shutdown();
					 System.out.println("lstPaciente 0 " + lstPaciente.size());		
					if(lstPaciente.get(0).get() != null){
						resp = lstPaciente.get(0).get(); 
					}
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if (resp!=null){
					System.out.println("pasa paciente es sis");
					System.out.println(resp.toString());
					if (resp.getIderror().trim().equals("0")) {
						if (resp.getEstado().trim().equals("ACTIVO")) {
							paciente.getTipoSeguro().setCodReg("000003");
							paciente.setCategoriaSeguro(resp.getDesctiposeguro());
							paciente.setCodigoFiliacion(resp.getContrato()); 
							System.out.println("paciente SIS" + paciente.toString());
							
							
							} else {
							paciente.setIdErrorWSIS("I");
							paciente.setEstado("Paciente con estado de SIS Inactivo");	 
			
							}
							
						
					}else if(resp.getIderror().trim().equals("6")) {
						paciente.setEstado("Usuario fuera del límite de consultas SIS por día."); 
						paciente.setIdErrorWSIS("6");
						}
					else if(resp.getIderror().trim().equals("10")) {
						paciente.setEstado("USUARIO INVÁLIDO PARA HACER ESTE TIPO DE CONSULTA,REGISTRARÁ MANUALMENTE"); 
							
							
						}
					else if(resp.getIderror().trim().equals("12")) {
						paciente.setIdErrorWSIS("12");
						paciente.setEstado("DNI CADUCADO DEL USUARIO,SE REGISTRARÁ MANUALMENTE ");  
						}	 
					else if(resp.getIderror().trim().equals("14")) {
						paciente.setIdErrorWSIS("14");
						paciente.setEstado("Paciente no se encuentra afiliado al SIS ");  
						}
					else {
						paciente.setEstado("Paciente con estado de SIS Inactivo o no tiene SIS");	 
						
					} 
					
				}else{
					paciente.setIdErrorWSIS("50");
					paciente.setEstado("Hubo un error en la consulta del SIS Inténtelo mas tarde o consulte a la Página del SIS");	 	
					
				} 
			
				System.out.println("paciente getFoto " + paciente.getPersona().getFoto());
		}else{
			System.out.println("el paciente en consulta es null");
		}
		
	
		return paciente;
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

	public PacienteBean getPacienteBean() {
		return pacienteBean;
	}

	public void setPacienteBean(PacienteBean pacienteBean) {
		this.pacienteBean = pacienteBean;
	}

	
	
}
