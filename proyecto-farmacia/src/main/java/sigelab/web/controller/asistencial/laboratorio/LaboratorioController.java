package sigelab.web.controller.asistencial.laboratorio;

import java.io.File;
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
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.sarxos.webcam.Webcam;

import sigelab.core.bean.asistencial.banco.PostulanteBean;
import sigelab.core.bean.asistencial.banco.SeropositivoBean;
import sigelab.core.bean.asistencial.laboratorio.OrdenBean;
import sigelab.core.bean.asistencial.banco.CampaniaBean;
import sigelab.core.bean.asistencial.banco.DonanteBean;
import sigelab.core.bean.asistencial.banco.EstadoFisicoBean;
import sigelab.core.bean.asistencial.banco.LugarCampaniaBean;  
import sigelab.core.bean.general.PersonaBean;
import sigelab.core.bean.general.TablaBean;
import sigelab.core.bean.general.TarifarioBean;
import sigelab.core.bean.general.UbigeoBean;
import sigelab.core.bean.seguridad.UsuarioBean;
import sigelab.core.entity.asistencial.banco.InterUAL;
import sigelab.core.entity.general.PacienteReniec;
import sigelab.core.service.exception.ServiceException;
import sigelab.core.service.interfaces.asistencial.banco.CampaniaService;
import sigelab.core.service.interfaces.asistencial.banco.DonanteService;
import sigelab.core.service.interfaces.asistencial.banco.EstadoFisicoService;
import sigelab.core.service.interfaces.asistencial.banco.LugarCampaniaService;
import sigelab.core.service.interfaces.asistencial.banco.PostulanteService;
import sigelab.core.service.interfaces.asistencial.banco.PreDonanteService;
import sigelab.core.service.interfaces.asistencial.banco.SeropositivoService;
import sigelab.core.service.interfaces.asistencial.maestra.MaestraAsis01Service;
import sigelab.core.service.interfaces.asistencial.maestra.MaestraBanc01Service; 
import sigelab.core.service.interfaces.general.Maestra1Service;
import sigelab.core.service.interfaces.general.PacienteReniecService;
import sigelab.core.service.interfaces.general.PersonaService;
import sigelab.core.service.interfaces.general.TarifarioService;
import sigelab.core.service.interfaces.general.UbigeoService;
import sigelab.web.controller.base.BaseController;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader; 

@Controller
@RequestMapping(value = "laboratorioController")
public class LaboratorioController  extends BaseController {
	
	List<TablaBean> lstSituacion = new ArrayList<TablaBean>();
	List<TablaBean> lstDocumento = new ArrayList<TablaBean>();
	List<TablaBean> lstSexo = new ArrayList<TablaBean>();
	List<TablaBean> lstEstadoCivil = new ArrayList<TablaBean>();
	List<TablaBean> lstOcupacion = new ArrayList<TablaBean>();
	List<TablaBean> lstNacionalidad = new ArrayList<TablaBean>();
	List<TablaBean> lstNivelInstrucion = new ArrayList<TablaBean>();
	List<UbigeoBean> lstUbigeoBean = new ArrayList<UbigeoBean>();
	List<TablaBean> lstTipoExamen = new ArrayList<TablaBean>();
	
	PersonaBean personaBean = new PersonaBean();
	PostulanteBean PostulanteBean = new PostulanteBean();
	public UbigeoBean ubigeobean;
	  
	private List<TarifarioBean> lstTarifarioBean ;
	private List<PostulanteBean> lstPostulanteBean ;
	private List<SeropositivoBean> lstSeropositivoBean ;
	
	@Autowired
	private MaestraBanc01Service maestraBanc01Service; 
	 
	@Autowired
	private MaestraAsis01Service maestraAsis01Service;
	
	@Autowired
	private CampaniaService campaniaService;
	
	@Autowired
	private TarifarioService tarifarioService;
	
	@Autowired
	private Maestra1Service maestraGene01Services;
	
	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private UbigeoService ubigeoService;
	 
	@Autowired
	private PostulanteService postulanteService;
	
	@Autowired
	private PacienteReniecService pacienteReniecService; 
	
	@Autowired
	private EstadoFisicoService estadoFisicoService;
	
	@Autowired
	private DonanteService donanteService;
	
	@Autowired
	private SeropositivoService seropositivoService;
	
	
	@Autowired
	private PreDonanteService preDonanteService;
	
	@PostConstruct
	public void init() { 
		
	}
	
	private void cargarCombos(ModelAndView mav) {
		try {
		//	lstSituacion =maestraBanc01Service.listarPorCodigoTabla("000034", 1);
			lstDocumento = maestraAsis01Service.listarPorCodigoTabla("000003", 1);
			lstSexo = maestraAsis01Service.listarPorCodigoTabla("000004", 1);
			lstEstadoCivil = maestraGene01Services.listarPorCodigoTabla("000005", 0);
			lstOcupacion = maestraGene01Services.listarPorCodigoTabla("000007", 0);
			lstNacionalidad = maestraGene01Services.listarPorCodigoTabla("000003", 0);
			lstNivelInstrucion = maestraGene01Services.listarPorCodigoTabla("000006", 0);
			
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
	
	private void cargarCombosCampania(ModelAndView mav) {
		try {
			lstSituacion =maestraBanc01Service.listarPorCodigoTabla("000034", 1); 
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		
		mav.addObject("lstSituacion", lstSituacion) ;
	}
	/*****************************************************************/
	/************************** POSTULANTES **************************/
	
	@RequestMapping(value = "/consultarPersonaPorDocumento", method = RequestMethod.GET)
	public @ResponseBody PersonaBean consultarPorNroDocumento(@RequestParam("tipoDocumento") String tipoDocumento,@RequestParam("numero") String numero)throws Exception {
		this.setPersonaBean(new PersonaBean());  
		personaBean = new PersonaBean();
		PersonaBean prmPersona = new PersonaBean();
		prmPersona.setNroDocumento(numero);
		prmPersona.getTipoDocumento().setCodReg(tipoDocumento);
		try {
		/*	personaBean = this.getPersonaService().buscarxTipoDocumentoNumeroDocumento(prmPersona); 
			if(personaBean!=null){ 
			
			}else{*/
				personaBean = personaService.buscarxTipoDocumentoNumeroDocumentoSigeho(prmPersona);
				if(personaBean!=null){  
					System.out.println("persona existe en sigehov2gene");
					System.out.println(personaBean.getNombreCompleto());
					personaBean.setOrigenDatos("SIGEHOv2");
					
					System.out.println("personaBean.getCodigo() " + personaBean.getCodigo());
					PostulanteBean postulante = new PostulanteBean();
					postulante.setPersona(personaBean);
					try {
						postulante = postulanteService.buscarUltimaDonacion(postulante);
						if (postulante != null) {
							System.out.println("postulante.getUltimaFechaDonacion() "  + postulante.getUltimaFechaDonacion());
							personaBean.setUltimaFechaDonacion(postulante.getUltimaFechaDonacion());
						}
					} catch (Exception e) {
						 
					}
				
					
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
								personaBean.getTipoDocumento().setCodReg("000002");
								personaBean.setNroDocumento(numero);
								personaBean.setOrigenDatos("RENIEC");
								personaBean.setSwReniec(true);
								personaBean.setCodigoErrorReniec(lstPersona.get(0).getCodigoRespuesta());
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
								personaBean.setFechaNacStr(strFecha);
								System.out.println("personaBean no es null " + personaBean.getNombreCompleto());
								System.out.println("personaBean no es null " + personaBean.getFechaNac());
								if (lstPersona.get(0).getSexo().equals("1")) {
									personaBean.getSexo().setCodReg("000002"); 
								}else{
									personaBean.getSexo().setCodReg("000001"); 
								}
								
								if (lstPersona.get(0).getEstCivil().equals("1")) {
									personaBean.getEstadoCivil().setCodReg("000001"); 
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
		
	    this.getPostulanteBean().setPersona(personaBean);
	    this.setPersonaBean(personaBean);
		return personaBean;
	}
	
	

	
	
	@RequestMapping(value = "/listarEstadoFisicoPersona", method = RequestMethod.GET)
	public ModelAndView listarEvaluacionFisicaPersona(@RequestParam("codigoPersona") String codigoPersona)throws Exception { 
		
		ModelAndView mav = new ModelAndView("asistencial/bancoSangre/postulante/ajax/listado-tabla-EstadoFisicoPostulantes");
		List<PostulanteBean> lstPostulanteBean = new ArrayList<PostulanteBean>();
		try {
			PostulanteBean postulanteBean = new PostulanteBean();
			postulanteBean.getPersona().setCodigo(codigoPersona);
	 		
	 		lstPostulanteBean = postulanteService.litarEstadoFisicaPorPerso(postulanteBean);  
		} catch (Exception e) { 
			e.printStackTrace();
		} 
			if (lstPostulanteBean != null) {
				mav.addObject("lstPostulanteEstadoFisicoBean", lstPostulanteBean); 
				return mav; 
			}else{
				return null;
			}
		}
		 
	 
	
	@RequestMapping(value = "/grabarPostulante", method = RequestMethod.POST)
	public @ResponseBody PostulanteBean grabarPostulante(@ModelAttribute("postulanteBean")PostulanteBean postulanteBean,
											 HttpServletRequest request) throws Exception {  
		//PersonaBean opersona = new PersonaBean();
		DonanteBean odDonanteBean = new DonanteBean();
		this.getPostulanteBean().getPersona().setOrigenDeRegistro("Sistema Banco Web");
		this.getPostulanteBean().setCampania(postulanteBean.getCampania());
		this.getPostulanteBean().getTipoPostulate().setCodReg("000001");
		if (this.getPostulanteBean().getPersona().getCodigo().equals("")) {
			if(!postulanteBean.getPersona().getTipoDocumento().getCodReg().equals("000002") ){ // extranjero
				this.setAuditoria(postulanteBean.getPersona(), request, true); 
				this.personaService.insertarPersonaLaboratorio(postulanteBean.getPersona());
				this.getPostulanteBean().setPersona(postulanteBean.getPersona());
			}else{
				if(this.getPersonaBean().getSwReniec()){
					System.out.println("this.getPostulanteBean().getPersona(). " + this.getPostulanteBean().getPersona().getTipoDocumento().getCodReg());
					System.out.println("this.getPostulanteBean().getPersona() ::" + this.getPostulanteBean().getPersona());
					this.getPostulanteBean().getPersona().setTelefonoNumero(postulanteBean.getPersona().getTelefonoNumero());
					this.getPostulanteBean().getPersona().setCorreo(postulanteBean.getPersona().getCorreo());
					this.getPostulanteBean().getPersona().getNivelInstrucion().setCodReg(postulanteBean.getPersona().getNivelInstrucion().getCodReg());
					this.getPostulanteBean().getPersona().getOcupacion().setCodReg(postulanteBean.getPersona().getOcupacion().getCodReg());
					
					this.setAuditoria(this.getPostulanteBean().getPersona(), request, true); 
					this.personaService.insertarPersonaLaboratorio(this.getPostulanteBean().getPersona());
					System.out.println("persona reniec");
				}else{
					this.setAuditoria(postulanteBean.getPersona(), request, true); 
					this.personaService.insertarPersonaLaboratorio(postulanteBean.getPersona());
					this.getPostulanteBean().setPersona(postulanteBean.getPersona());
				}
			}
			
			System.out.println("persona no existe");
		//	this.personaService.insertarPersonaBanco(this.getPostulanteBean().getPersona());
			
		}else{ 
			System.out.println("existe persona");
			 
				this.setAuditoria(postulanteBean.getPersona(), request, true); 
				System.out.println("postulanteBean.getCodigoCorreo " + postulanteBean.getPersona().getCodigoCorreo());
				System.out.println("postulanteBean.getCodigoDireccion " + postulanteBean.getPersona().getCodigoDireccion());
				System.out.println("postulanteBean.getCodigoTelefono " + postulanteBean.getPersona().getCodigoTelefono());
				this.personaService.actualizarPersonaLaboratorio(postulanteBean.getPersona());
			//	this.getPostulanteBean().setPersona(postulanteBean.getPersona());
		 
			
		} 
		System.out.println("postulanteBean.getCodigo()::" + postulanteBean.getCodigo().trim());
		if (!postulanteBean.getCodigo().trim().equals("")) {
			this.setAuditoria(this.getPostulanteBean(), request, false); 
			System.out.println("actualiza postulanteBean " + postulanteBean.getCodigo());
		/**	if (postulanteService.actualizar(this.getPostulanteBean())) { 
				System.out.println("postulanteBean " + this.getPostulanteBean().getCodigo());
				codigo = this.getPostulanteBean().getCodigo();
			}*/
		} else {
			EstadoFisicoBean oeEstadoFisicoBean = new EstadoFisicoBean();
			oeEstadoFisicoBean.setPersonaBean(this.getPostulanteBean().getPersona());
			this.setAuditoria(this.getPostulanteBean(), request, true); 
			this.setAuditoria(oeEstadoFisicoBean, request, true); 
			this.setAuditoria(odDonanteBean, request, true); 
			System.out.println("insert postulanteBean " + postulanteBean.getCodigo());
			
			odDonanteBean.getTipoRegistro().setCodReg("000003");
			odDonanteBean.setPersona(this.getPostulanteBean().getPersona());
			if (donanteService.insertarVoluntario(odDonanteBean)) {
				System.out.println("insertó donante voluntario");
			}
			
			if (estadoFisicoService.insertar(oeEstadoFisicoBean)) {  
				this.getPostulanteBean().setEstadoFisicoBean(oeEstadoFisicoBean);
				if (postulanteService.insertar(this.getPostulanteBean())) { 
					PersonaBean objPersona = new PersonaBean();
					this.getPostulanteBean().getPersona().setTipo("1");
					objPersona = personaService.buscarxTipoDocumentoNumeroDocumentoSigeho(this.getPostulanteBean().getPersona());
					if(objPersona!=null){ 
						this.getPostulanteBean().setPersona(objPersona);
					}
					InterUAL objinterual = new InterUAL();	
					
					objinterual.setCodDona(this.getPostulanteBean().getNumeroPostulante());	
					objinterual.setTipoDocDona(this.getPostulanteBean().getPersona().getTipoDocumento().getNombreCorto());
					objinterual.setDocDona(this.getPostulanteBean().getPersona().getNroDocumento());
					objinterual.setApepDona(this.getPostulanteBean().getPersona().getApellidoPaterno());
					objinterual.setApemDona(this.getPostulanteBean().getPersona().getApellidoMaterno());
					objinterual.setNomDona(this.getPostulanteBean().getPersona().getPrimerNombre());
					objinterual.setSexoDona(this.getPostulanteBean().getPersona().getSexo().getNombreCorto());
					SimpleDateFormat sdfecha = new SimpleDateFormat("yyyy-MM-dd");
					
					objinterual.setFnacDona(sdfecha.format(this.getPostulanteBean().getPersona().getFechaNac()));
									
					objinterual.setNacionDona(this.getPostulanteBean().getPersona().getNacionalidad().getNombreCorto());
					objinterual.setDireccDona(this.getPostulanteBean().getPersona().getDireccion());
					objinterual.setUbigDistrDona(this.getPostulanteBean().getPersona().getUbigeoDireccion().getCodigoUbigeo());
					objinterual.setDistritoDona(this.getPostulanteBean().getPersona().getUbigeoDireccion().getNombreUbigeo());
					objinterual.setCelularDona(this.getPostulanteBean().getPersona().getTelefonoNumero());
					objinterual.setCorreoDona(this.getPostulanteBean().getPersona().getCorreo());
					objinterual.setOcupCodDona(this.getPostulanteBean().getPersona().getOcupacion().getCodReg());
					objinterual.setOcupDona(this.getPostulanteBean().getPersona().getOcupacion().getNombreCorto());
					objinterual.setNumMuestraDona(this.getPostulanteBean().getNumeroPostulante());		
					objinterual.setTipoCodDona("000001");
					objinterual.setTipoDona("VOLUNTARIO");
					objinterual.setUsuarioCodReg(this.getPostulanteBean().getCodigoUsuarioCreacion());
					
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat sdH = new SimpleDateFormat("HH:mm");
					String fecha = sdf.format(new Date());
					String hora = sdH.format(new Date());
					System.out.println(fecha);
					
					objinterual.setFechaReg(fecha);
					objinterual.setHoraReg(hora);	
					objinterual.setCodPerso(this.getPostulanteBean().getPersona().getCodigo());
					if (preDonanteService.insertarIterUal(objinterual)) {
						
					}
					System.out.println("postulanteBean " + this.getPostulanteBean().getCodigo());
					//codigo = this.getPostulanteBean().getNumeroPostulante();
					lstPostulanteBean = postulanteService.getBuscarPorFiltros(new PostulanteBean());  
					//this.getPostulanteBean().setIndex(lstPostulanteBean.size()-1);
					this.getPostulanteBean().setIndex(0);
					
					
					
				}
			}
			
			
		}  
		return this.getPostulanteBean();
	}
	
	
	@RequestMapping(value = "/eliminarPostulante", method = RequestMethod.GET)
	public @ResponseBody String doEliminarPostulante(@RequestParam("index") Integer index,
			 HttpServletRequest request) {
		String resultado = "";
		PostulanteBean oPostulanteBean = new PostulanteBean(); 
		oPostulanteBean = this.lstPostulanteBean.get(index);
		
		System.out.println("oPostulanteBean.getCodigo " + oPostulanteBean.getCodigo());
		System.out.println("oPostulanteBean " + oPostulanteBean);
		this.setAuditoria(oPostulanteBean, request, false); 
		try {
			if (postulanteService.eliminar(oPostulanteBean)) {
				System.out.println("Se eliminó el registro ");
				resultado  ="1";
			} 
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		 return resultado;
	}
	
	@RequestMapping(value = "/modificarPostulante", method = RequestMethod.POST)
	public ModelAndView doModificarPostulante(@RequestParam("codigo") Integer index, HttpServletRequest request) {

		System.out.println("modificar codigo: " + index); 
		PostulanteBean oPostulanteBean = new PostulanteBean(); 
		oPostulanteBean = this.lstPostulanteBean.get(index);
		
		PostulanteBean objPostulanteBean = new PostulanteBean(); 
		try {
			objPostulanteBean = this.postulanteService.getBuscarPorObjecto(oPostulanteBean);
			System.out.println("objPostulanteBean.personaBean.getfoto " + objPostulanteBean.getPersona().getFoto());
			objPostulanteBean.getPersona().setOrigenDatos("SIGEHOv2");
			this.setPostulanteBean(objPostulanteBean);
		} catch (Exception e) {
		}
		
		PostulanteBean postulante = new PostulanteBean();
		postulante.setPersona(objPostulanteBean.getPersona());
		try {
			postulante = postulanteService.buscarUltimaDonacion(postulante);
			if (postulante != null) {
				System.out.println("postulante.getUltimaFechaDonacion() "  + postulante.getUltimaFechaDonacion());
				objPostulanteBean.getPersona().setUltimaFechaDonacion(postulante.getUltimaFechaDonacion());
			}
		} catch (Exception e) {
			 
		}
		
		System.out.println("modificar oReferenciaBean: " + oPostulanteBean.getCodigo());
		ModelAndView mav = new ModelAndView("asistencial/bancoSangre/postulante/registro-postulante", "command", objPostulanteBean);
		mav.addObject("postulanteBean", objPostulanteBean); 
		this.cargarCombos(mav);
		return mav;
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
	
	@RequestMapping(value = "/listarPostulantes", method = RequestMethod.GET)
	public ModelAndView listarPostulantes()
			throws Exception {
		System.out.println("/listarPostulantes");
		ModelAndView mav = new ModelAndView("asistencial/bancoSangre/postulante/ajax/listado-tabla-postulantes");
		lstPostulanteBean = new ArrayList<PostulanteBean>(); 
		try {
	 		lstPostulanteBean = postulanteService.getBuscarPorFiltros(new PostulanteBean());  
		} catch (ServiceException e) { 
			e.printStackTrace();
		} 
		mav.addObject("lstPostulanteBean", lstPostulanteBean); 
		return mav;
	}
	
/******	
	@RequestMapping(value = "/listarPostulantes", method = RequestMethod.GET)
	public @ResponseBody List<PostulanteBean> refrescarListaPostulantes()throws Exception { 
	 	try {
	 		lstPostulanteBean = postulanteService.getBuscarPorFiltros(new PostulanteBean());  
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		 
		return lstPostulanteBean; 
	}
	*/ 
	
	@RequestMapping(value = "/buscarTamizaje", method = RequestMethod.POST)
	public ModelAndView buscarTamizaje(String codigoPerso, String nroDocumento) throws Exception {

		
		System.out.println("codigoPerso "+codigoPerso);
	 	System.out.println("nroDocumento " + nroDocumento);
		SeropositivoBean oSeropositivoBean = new SeropositivoBean();
		oSeropositivoBean.getPostulanteBean().getPersona().setCodigo(codigoPerso);
		oSeropositivoBean.getPostulanteBean().getPersona().setNroDocumento(nroDocumento);
		lstSeropositivoBean = new ArrayList<SeropositivoBean>();
		try {
			lstSeropositivoBean = seropositivoService.getBuscarPorFiltros(oSeropositivoBean);  
			if (lstSeropositivoBean != null) {
				if (lstSeropositivoBean.size()> 0) {
					oSeropositivoBean = lstSeropositivoBean.get(0);
					System.out.println("oSeropositivoBean fecha " + oSeropositivoBean.getsFecha());
				}	
			} 
			
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("asistencial/bancoSangre/postulante/listado-tamizaje-modal", "command", oSeropositivoBean);
		mav.addObject("seropositivoBean", oSeropositivoBean); 
		mav.addObject("lstSeropositivoBean", lstSeropositivoBean);
		
		return mav;
	}
	
	@RequestMapping(value = "/listadoPostulante", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("postulanteBean") PostulanteBean postulanteBean, HttpServletRequest request) throws Exception {
		return this.doListadoPost(postulanteBean, request) ;
	}
	@RequestMapping(value = "/listadoPostulante", method = RequestMethod.POST)
	public ModelAndView doListadoPost(@ModelAttribute("postulanteBean") PostulanteBean postulanteBean, HttpServletRequest request) throws Exception {
		 
		ModelAndView mav = new ModelAndView("asistencial/bancoSangre/postulante/listado-postulante", "command", postulanteBean); 
		lstPostulanteBean = postulanteService.getBuscarPorFiltros(postulanteBean);  
		mav.addObject("postulanteBean", postulanteBean); 
		mav.addObject("lstPostulanteBean", lstPostulanteBean); 
		return mav;
	}
	
	@RequestMapping(value = "/buscarPostulante", method = RequestMethod.POST)
	public ModelAndView buscarPostulantePOST(@ModelAttribute("postulanteBean") PostulanteBean postulanteBean,
			HttpServletRequest request
			)
			throws Exception { 
		lstPostulanteBean = new ArrayList<PostulanteBean>(); 
		ModelAndView mav = new ModelAndView("asistencial/bancoSangre/postulante/listado-postulante", "command", postulanteBean); 
		lstPostulanteBean = postulanteService.getBuscarPorFiltros(postulanteBean);  
		mav.addObject("postulanteBean", postulanteBean); 
		mav.addObject("lstPostulanteBean", lstPostulanteBean); 
		return mav;
	}
	
	@RequestMapping(value = "/buscarPostulante", method = RequestMethod.GET)
	public ModelAndView buscarPostulanteGet(@ModelAttribute("postulanteBean") PostulanteBean postulanteBean,
			HttpServletRequest request
			)
			throws Exception { 
		return this.buscarPostulantePOST(postulanteBean, request) ;
	}
	 
 
	@RequestMapping(value ="/orden", method = RequestMethod.GET)
	public ModelAndView nuevoRegistroOrden() throws Exception {
		return nuevoRegistroOrdenPOST();
	}
	
	@RequestMapping(value ="/orden", method = RequestMethod.POST)
	public ModelAndView nuevoRegistroOrdenPOST() throws Exception {
		OrdenBean objOrdenBean = new OrdenBean();  
		ModelAndView mav = new ModelAndView("asistencial/laboratorio/orden/registro-orden", "command", objOrdenBean);  
		 
		return mav;
	}
	
	
	
	@RequestMapping(value = "/tarifarioRegModal", method = RequestMethod.POST)
	public ModelAndView nuevoTarifario()throws Exception {

		ModelAndView mav = new ModelAndView("asistencial/laboratorio/registro-tarifario", "command", new TarifarioBean());
		lstTarifarioBean = new ArrayList<TarifarioBean>();
		lstTipoExamen = new ArrayList<TablaBean>();
		try {
			lstTarifarioBean = tarifarioService.getBuscarPorFiltros(new TarifarioBean());  
			lstTipoExamen = maestraAsis01Service.listarPorCodigoTabla("000013", 1);
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		
		mav.addObject("lstTarifarioBean", lstTarifarioBean);
		mav.addObject("lstTipoExamen", lstTipoExamen);
		return mav;
	}
	
	
	@RequestMapping(value = "/mostrarCamara", method = RequestMethod.POST)
	public ModelAndView mostrarCamara()throws Exception {

		ModelAndView mav = new ModelAndView("asistencial/laboratorio/pantalla-foto-paciente", "command", new TarifarioBean());
	/*	lstTarifarioBean = new ArrayList<TarifarioBean>();
		lstTipoExamen = new ArrayList<TablaBean>();
		try {
			lstTarifarioBean = tarifarioService.getBuscarPorFiltros(new TarifarioBean());  
			lstTipoExamen = maestraAsis01Service.listarPorCodigoTabla("000013", 1);
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		Webcam webcam = Webcam.getDefault();
		webcam.open();
		ImageIO.write(webcam.getImage(), "PNG", new File("fotopaciente.png"));
		*/
		mav.addObject("lstTarifarioBean", new TarifarioBean());
		mav.addObject("lstTipoExamen", new TablaBean());
		return mav;
	}
	
	@RequestMapping(value = "/mostrarCamaraV2", method = RequestMethod.GET)
	public ModelAndView mostrarCamaraV2(HttpServletRequest request) {
		TarifarioBean tarifarioBean = new TarifarioBean(); 
		CampaniaBean campaniaBean = new CampaniaBean();
		campaniaBean.getSituacion().setCodReg("000001");
		Webcam webcam = Webcam.getDefault();
		webcam.open();
		try {
			ImageIO.write(webcam.getImage(), "PNG", new File("fotopaciente.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("asistencial/laboratorio/registro-tarifario", "command", tarifarioBean); 
		
		 
		return mav;
	}
	
	
	@RequestMapping(value = "/listadoUbigeoModal", method = RequestMethod.POST)
	public ModelAndView listadoUbigeoModal() throws Exception {

		ModelAndView mav = new ModelAndView("general/ubigeo/listado-ubigeo-modal", "command", new UbigeoBean());
		ubigeobean = new UbigeoBean();
		ubigeobean.setVariable("");
		ubigeobean.setInstitucion("000003");
		ubigeobean.setCategoria("000003");
		lstUbigeoBean = new ArrayList<UbigeoBean>();
		try {
			
			lstUbigeoBean = ubigeoService.getBuscarPorFiltros(ubigeobean);
		} catch (Exception e) { 
		}
		mav.addObject("ubigeoBean", new UbigeoBean());
		mav.addObject("lstUbigeoBean", lstUbigeoBean);
		return mav;
	}
	

	
	/***NUEVA LINEA 19-04-2019****/
	@RequestMapping(value = "/nuevoPaciente", method = RequestMethod.GET)
	public ModelAndView nuevoPaciente(HttpServletRequest request) {
		PostulanteBean PostulanteBean = new PostulanteBean(); 
		CampaniaBean campaniaBean = new CampaniaBean();
		campaniaBean.getSituacion().setCodReg("000001"); 
	/*	try {
			lstCampaniaBean = campaniaService.getBuscarPorFiltros(campaniaBean);
			if (lstCampaniaBean != null && lstCampaniaBean.size() > 0) {
				PostulanteBean.setCampania(lstCampaniaBean.get(0));
			}
		} catch (ServiceException e) { 
			e.printStackTrace();
		}  */
		ModelAndView mav = new ModelAndView("asistencial/laboratorio/registro-paciente-laboratorio", "command", PostulanteBean); 
		
		this.cargarCombos(mav);
		return mav;
	}
	
	
	@RequestMapping(value = "rptListadoPostulantes", method = RequestMethod.GET)
	@ResponseBody
	public void getRpt1(@RequestParam("nombreCampania") String nombreCampania,
						HttpServletResponse response, 
						HttpServletRequest request) throws JRException, IOException {
		InputStream jasperStream = this.getClass().getResourceAsStream("/reportes/rptListadoPostulantes.jasper");
		Map<String, Object> parametro = new HashMap<String, Object>();
		parametro.put("usuario", getUsuarioSesion(request).getNombreUsuario());
		parametro.put("nombreCampania", nombreCampania);
		System.out.println("jasperStream " + jasperStream);
	//	List<ReferenciaBean> rates = new ArrayList<ReferenciaBean>();
	
		//	rates.add(getReferenciaBean());
		// data source
		// JRDataSource dataSource = getDataSource(rates);
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lstPostulanteBean);
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametro, dataSource);

		response.setContentType("application/x-pdf");
		response.setHeader("Content-disposition",
				"inline; filename=listadoPostulantes.pdf");

		final OutputStream outStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	}
	 
	  
	@RequestMapping(value = "/grabarCampania", method = RequestMethod.POST)
	public @ResponseBody String grabarCampania(@ModelAttribute("campaniaBean")CampaniaBean campaniaBean,
											 HttpServletRequest request) throws Exception {  
		String codigo ="";   
		if (campaniaBean.getCodigo()!=null && !campaniaBean.getCodigo().equals("")) {
			this.setAuditoria(campaniaBean, request, false); 
			System.out.println("actualiza campaniaBean " + campaniaBean.getCodigo());
			if (campaniaService.actualizar(campaniaBean)) { 
				System.out.println("campaniaBean " + campaniaBean.getCodigo());
				codigo = campaniaBean.getCodigo();
			}
		} else {
			this.setAuditoria(campaniaBean, request, true); 
			System.out.println("insert campaniaBean " + campaniaBean.getCodigo());
			if (campaniaService.insertar(campaniaBean)) { 
				System.out.println("campaniaBean " + campaniaBean.getCodigo());
				codigo = campaniaBean.getCodigo();
			}
			
		}  
		return codigo;
	}
	 
	
	@RequestMapping(value = "/refrescarListTarifario", method = RequestMethod.GET)
	public @ResponseBody List<TarifarioBean> refrescarListTarifario(
							String tipo, 
							String descripcion
			)throws Exception { 
		
		System.out.println("descripcion== " + descripcion);
		System.out.println("tipo== " + tipo);
		
		TarifarioBean prmTarifarioBean = new TarifarioBean(); 
		prmTarifarioBean.setTipo(new TablaBean());
		prmTarifarioBean.getTipo().setCodReg(tipo);
		prmTarifarioBean.setDescripcion(descripcion);
		
		lstTarifarioBean = new ArrayList<TarifarioBean>(); 
		try {
			lstTarifarioBean = tarifarioService.getBuscarPorFiltros(prmTarifarioBean);   
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		 
		 
		return lstTarifarioBean; 
	} 
 
	@RequestMapping(value = "/tarifarioModal", method = RequestMethod.POST)
	public ModelAndView tarifarioModal() throws Exception {
		TarifarioBean prmTarifarioBean = new TarifarioBean(); 
		prmTarifarioBean.setTipo(new TablaBean());
		prmTarifarioBean.getTipo().setCodReg("");
		prmTarifarioBean.setDescripcion("");
		ModelAndView mav = new ModelAndView("asistencial/laboratorio/listado-tarifario-modal", "command", new TarifarioBean());
		lstTarifarioBean = new ArrayList<TarifarioBean>();
		lstTipoExamen = new ArrayList<TablaBean>();
		try {
			lstTarifarioBean = tarifarioService.getBuscarPorFiltros(prmTarifarioBean);  
			System.out.println("lstTarifarioBean.size() " + lstTarifarioBean.size());
			lstTipoExamen = maestraAsis01Service.listarPorCodigoTabla("000013", 1);
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		
		mav.addObject("lstTarifarioBean", lstTarifarioBean);
		mav.addObject("lstTipoExamen", lstTipoExamen);
		return mav;
	} 
 
	

   @RequestMapping(value = "/refrescarListaOrden", method = RequestMethod.GET)
	public @ResponseBody TarifarioBean refrescarListaCIEXREF(@RequestParam("index") int index) throws Exception {
		System.out.println("index " + index);
		TarifarioBean objTarifarioBean = new TarifarioBean(); 
		objTarifarioBean = lstTarifarioBean.get(index); 
		return objTarifarioBean;
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

	public List<TarifarioBean> getLstTarifarioBean() {
		return lstTarifarioBean;
	}

	public void setLstTarifarioBean(List<TarifarioBean> lstTarifarioBean) {
		this.lstTarifarioBean = lstTarifarioBean;
	}

}

