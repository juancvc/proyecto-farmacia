package sigelab.core.repository.implementacion.asistencial.banco;
 
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sigelab.core.bean.asistencial.banco.PreDonanteBean;
import sigelab.core.entity.asistencial.banco.InterUAL;
import sigelab.core.entity.asistencial.banco.PreDonante;
import sigelab.core.repository.DAOException; 
import sigelab.core.repository.interfaces.asistencial.banco.PreDonanteDAO; 

@Transactional
@Repository("PreDonanteDAOImp")
public class PreDonanteDAOImp implements PreDonanteDAO {

	@PersistenceContext//(unitName="emf")
	private EntityManager em; 
	
	
	public PreDonanteBean getPreDonanteBean(Object object){
		return (PreDonanteBean)object;
	}
	
	@Override
	public boolean insertar(PreDonanteBean PreDonanteBean) throws DAOException {

	//	Object id= null;   
		
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("preDonante.insertar"); 
			spq.setParameter("CODORGAN", PreDonanteBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", PreDonanteBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", PreDonanteBean.getCodigoSede()); 
			spq.setParameter("NROVERSI", PreDonanteBean.getNumeroVersion()); 
			spq.setParameter("NROPERIO", PreDonanteBean.getPostulanteBean().getNumeroPeriodo()); 
			spq.setParameter("CODENTRE", PreDonanteBean.getCodigo()); 
			spq.setParameter("FECHA", PreDonanteBean.getsFecha()); 
			spq.setParameter("HORA", PreDonanteBean.getsHora()); 
			spq.setParameter("NROPOST", PreDonanteBean.getPostulanteBean().getCodigo()); 
			
			spq.setParameter("CODPERSO", PreDonanteBean.getPostulanteBean().getPersona().getCodigo()); 
			spq.setParameter("CODRESUL", PreDonanteBean.getResultado().getCodReg()); 
			spq.setParameter("RESULTADO", PreDonanteBean.getResultado().getNombreCorto()); 
			spq.setParameter("OBSERVA", PreDonanteBean.getObservacion()); 
			spq.setParameter("PESO", PreDonanteBean.getPeso()); 
			spq.setParameter("TALLA", PreDonanteBean.getTalla()); 
			spq.setParameter("MASACP", PreDonanteBean.getMasaCorporal()); 
			spq.setParameter("VOLSANGP", PreDonanteBean.getVolumenSangreTotal()); 
			spq.setParameter("PRESION", PreDonanteBean.getPresionArterial()); 
			spq.setParameter("TEMPERAT", PreDonanteBean.getTemperatura()); 
			spq.setParameter("ESTACCVEN", PreDonanteBean.getAccesoVenoso().getCodReg()); 
			spq.setParameter("PULSO", PreDonanteBean.getPulso()); 
			spq.setParameter("REITERAT", PreDonanteBean.getReiterativo()); 
			spq.setParameter("ESTADOPRE","1");  
			
			spq.setParameter("AUCDUSCR", PreDonanteBean.getCodigoUsuarioCreacion());
			spq.setParameter("AUPCIPCR", PreDonanteBean.getNombreUsuarioCreacion().toUpperCase());
			 
			
			
			spq.execute();
			
			sw=true;
			/*** 
			
			if (id != null) {
				PreDonanteBean.setCodigo(id.toString()); 
				sw=true;
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public boolean actualizar(PreDonanteBean PreDonanteBean) throws DAOException {

		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("preDonante.modificar"); 
			spq.setParameter("CODORGAN", PreDonanteBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", PreDonanteBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", PreDonanteBean.getCodigoSede()); 
			spq.setParameter("CODCAMPA", PreDonanteBean.getCodigo());
			spq.setParameter("NROPERIO", PreDonanteBean.getNumeroPeriodo()); 
			spq.setParameter("SITUACRG", PreDonanteBean.getSituacion().getCodReg()); 
			
			spq.setParameter("AUCDUSMO", PreDonanteBean.getCodigoUsuarioModificacion());
			spq.setParameter("AUPCIPMO", PreDonanteBean.getIpModificacion()); 
			
			spq.execute();  
			sw=true;
			 
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public boolean eliminar(PreDonanteBean PreDonanteBean) throws DAOException {

		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("preDonante.eliminar"); 
			spq.setParameter("CODORGAN", PreDonanteBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", PreDonanteBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", PreDonanteBean.getCodigoSede()); 
			spq.setParameter("CODCAMPA", PreDonanteBean.getCodigo());
			spq.setParameter("NROPERIO", PreDonanteBean.getNumeroPeriodo()); 
			
			spq.setParameter("AUCDUSMO", PreDonanteBean.getCodigoUsuarioModificacion());
			spq.setParameter("AUPCIPMO", PreDonanteBean.getIpModificacion()); 
			
			spq.execute();  
			sw=true;
			 
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public PreDonanteBean getBuscarPorObjecto(PreDonanteBean PreDonanteBean) throws DAOException {

		List<PreDonante> lstPreDonante = null;	
		PreDonanteBean oPreDonanteBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("preDonante.buscarPorObjeto");   
			spq.setParameter("NROPOST", PreDonanteBean.getPostulanteBean().getCodigo()); 
			spq.setParameter("NPERIODO", PreDonanteBean.getPostulanteBean().getNumeroPeriodo()); 
			spq.setParameter("CODPERSO", PreDonanteBean.getPostulanteBean().getPersona().getCodigo()); 
			 if (spq.execute()) {
				 lstPreDonante =  spq.getResultList(); 
			 }
			 
			if (lstPreDonante != null && lstPreDonante.size() > 0) {
				System.out.println("lstPreDonante "+lstPreDonante.size());
				oPreDonanteBean = deListaObjetoAListaObjetoBean(lstPreDonante).get(0);
			 }
			
			em.close();
			
		   
		return oPreDonanteBean;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PreDonanteBean> getBuscarPorFiltros(PreDonanteBean PreDonanteBean) throws DAOException {
		List<PreDonante> lstCampania = null;	
		List<PreDonanteBean> lstPreDonanteBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("preDonante.buscarPorFiltros");   
			spq.setParameter("FECHA", PreDonanteBean.getsFecha()); 
			
			 if (spq.execute()) {
				 lstCampania =  spq.getResultList(); 
			 }
			 
			if (lstCampania != null && lstCampania.size() > 0) {
				lstPreDonanteBean = deListaObjetoAListaObjetoBean(lstCampania);
			 }
			
			em.close();
			
		   
		return lstPreDonanteBean;
	}
	
	 

private List<PreDonanteBean> deListaObjetoAListaObjetoBean(List<PreDonante> lstDonante) {
		
		List<PreDonanteBean> lstPreDonanteBean = null;
		
		if (lstDonante != null && lstDonante.size() > 0) {
			
			lstPreDonanteBean = new ArrayList<PreDonanteBean>();
			
			for (int i = 0; i < lstDonante.size(); i++) { 
				PreDonante entity = lstDonante.get(i);
				PreDonanteBean bean = deObjetoAObjetoBean(entity);
				
				lstPreDonanteBean.add(bean);
			}
		}
		
		return lstPreDonanteBean;
	}
	
	private PreDonanteBean deObjetoAObjetoBean(PreDonante entity) {
		
		PreDonanteBean bean = null;
	//	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		if (entity != null) {
			
			bean = new PreDonanteBean();
			bean.setCodigo(entity.getId().getCodEntre());  
			bean.setCodigoInstitucion(entity.getId().getCodinsti());  
			bean.setCodigoSede(entity.getId().getCodsedei());  
			bean.setCodigoOrganizacion(entity.getId().getCodorgan());
			bean.setNumeroVersion(entity.getId().getNroversi());
			bean.setNumeroPeriodo(entity.getId().getNroperio()); 
			
			bean.getPostulanteBean().setCodigo(entity.getId().getNroPost());
			bean.getPostulanteBean().setNumeroPeriodo(entity.getNROPEPOS());
			bean.getPostulanteBean().getPersona().setCodigo(entity.getId().getCodPerso());
			bean.getPostulanteBean().getPersona().setApellidoPaterno(entity.getApepater());
			bean.getPostulanteBean().getPersona().setApellidoMaterno(entity.getApemater());
			bean.getPostulanteBean().getPersona().setPrimerNombre(entity.getPrinombr());
			bean.getPostulanteBean().getPersona().setSegundoNombre(entity.getSegnombr());
			bean.getPostulanteBean().getPersona().setNroDocumento(entity.getNroDocum());
			bean.getPostulanteBean().getPersona().getTipoDocumento().setNombreCorto(entity.getTipoDocu());
			
			bean.getPostulanteBean().getPersona().getSexo().setNombreLargo(entity.getSEXO());
			bean.getPostulanteBean().getPersona().getEstadoCivil().setNombreCorto(entity.getEST_CIVIL());
			bean.getPostulanteBean().getPersona().getNacionalidad().setNombreCorto(entity.getNACIONALIDAD());
			bean.getPostulanteBean().getPersona().getNivelInstrucion().setNombreCorto(entity.getGRADOINST());
			bean.getPostulanteBean().getPersona().getOcupacion().setNombreCorto(entity.getOCUPACION());
			
			bean.getPostulanteBean().getPersona().getUbigeoDireccion().setDetalle(entity.getDETUBIDI());
			bean.getPostulanteBean().getPersona().getUbigeoNacimiento().setDetalle(entity.getNACITO());
			bean.getPostulanteBean().getPersona().setDireccion(entity.getDESCRIPC());
			bean.getPostulanteBean().getPersona().setTelefonoNumero(entity.getTELFNUMR());
			bean.getPostulanteBean().getPersona().setCorreo(entity.getCORDESCR());
			bean.getPostulanteBean().getPersona().setEdad(entity.getEdad());
			bean.getPostulanteBean().getPersona().setFechaNac(entity.getFECHANAC());
			bean.getPostulanteBean().getPersona().setFoto(entity.getFotoDeta());
			bean.getPostulanteBean().getCampania().setNombre(entity.getNomLugca());
			bean.getPostulanteBean().getCampania().getLugarCampaniaBean().setNombre(entity.getNomLugca());
			
			bean.getPostulanteBean().getEstadoFisicoBean().setHtco(entity.getHTCO());
			bean.getPostulanteBean().getEstadoFisicoBean().getGrupoSanguineo().setNombreLargo(entity.getGRUPO());
			bean.getPostulanteBean().getEstadoFisicoBean().getFactor().setNombreLargo(entity.getFACTOR());
			bean.getPostulanteBean().getEstadoFisicoBean().setObservacion(entity.getOBS());  
			bean.getPostulanteBean().getEstadoFisicoBean().getCalificacion().setNombreCorto(entity.getCALIFDONAN()); 
			
			bean.getPostulanteBean().getTipoParentescoPaciente().setNombreCorto(entity.getPARENTESCO());
			bean.getPostulanteBean().getTipoPostulate().setNombreCorto(entity.getTIP_DONACION());
			bean.getPostulanteBean().setFecha(entity.getFecha());
			
			bean.getPostulanteBean().getPaciente().getPersona().setNroDocumento(entity.getDETALLED());
			bean.getPostulanteBean().getPaciente().getPersona().setApellidoPaterno(entity.getAPEPATPAC());
			bean.getPostulanteBean().getPaciente().getPersona().setApellidoMaterno(entity.getAPEMATPAC());
			bean.getPostulanteBean().getPaciente().getPersona().setPrimerNombre(entity.getPRINOMPAC());
			
			bean.getPostulanteBean().getFlebotomiaBean().getResultado().setNombreCorto(entity.getRESFLEB());		
			bean.getPostulanteBean().getFlebotomiaBean().setVolumenSangre(entity.getVOLSANG());
			
			bean.setFechaCreacion(entity.getAufechcr());
			bean.setObservacion(entity.getObservac());  
			bean.getResultado().setNombreCorto(entity.getResultado());
			bean.setTalla(entity.getTalla());
			bean.setTemperatura(entity.getTemperat());
			bean.setPeso(entity.getPeso());
			bean.setPulso(entity.getPulso());
			bean.setPresionArterial(entity.getPresion());
			bean.getAccesoVenoso().setNombreCorto(entity.getESTACCVENOS());
	 	}
		
		return bean;
	}

	
	
	@Override
	public boolean existe(PreDonanteBean t) throws DAOException {

		return false;
	}

	@Override
	public List<PreDonanteBean> litarResultadoFisicoFlebo(PreDonanteBean PreDonanteBean) {
		List<PreDonante> lstPreDonante = null;	
		List<PreDonanteBean> lstPreDonanteBean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("preDonante.listarResultados");   
		spq.setParameter("CODPERSO", PreDonanteBean.getPostulanteBean().getPersona().getCodigo()); 
		
		 if (spq.execute()) {
			 lstPreDonante =  spq.getResultList(); 
		 }
		 
		if (lstPreDonante != null && lstPreDonante.size() > 0) {
			lstPreDonanteBean = deListaObjetoAListaObjetoBean(lstPreDonante);
		 }
		
		em.close();
		
	   
	return lstPreDonanteBean;
	}

	@Override
	public boolean insertarIterUal(InterUAL interual) {
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("interUAL.insertar"); 
			spq.setParameter("codDona", interual.getCodDona()); 
			spq.setParameter("tipoDocDona", interual.getTipoDocDona()); 
			spq.setParameter("docDona", interual.getDocDona()); 
			spq.setParameter("apepDona", interual.getApepDona()); 
			spq.setParameter("apemDona", interual.getApemDona()); 
			spq.setParameter("nomDona", interual.getNomDona()); 
			spq.setParameter("sexoDona", interual.getSexoDona()); 
			spq.setParameter("fnacDona", interual.getFnacDona()); 
			spq.setParameter("nacionDona", interual.getNacionDona()); 
			spq.setParameter("direccDona", interual.getDireccDona()); 
			spq.setParameter("ubigDistrDona", interual.getUbigDistrDona()); 
			spq.setParameter("distritoDona", interual.getDistritoDona()); 
			spq.setParameter("ubigeoDona", interual.getUbigeoDona()); 
			spq.setParameter("telefonoDona", interual.getTelefonoDona()); 
			spq.setParameter("celularDona", interual.getCelularDona()); 
			spq.setParameter("correoDona", interual.getCorreoDona()); 
			spq.setParameter("ocupCodDona", interual.getOcupCodDona()); 
			spq.setParameter("ocupDona", interual.getOcupDona()); 
			spq.setParameter("colectCodDona", interual.getColectCodDona()); 
			
			spq.setParameter("colectDona", interual.getColectDona()); 
			spq.setParameter("numMuestraDona", interual.getNumMuestraDona()); 
			spq.setParameter("tipoCodDona", interual.getTipoCodDona()); 
			spq.setParameter("tipoDona", interual.getTipoDona()); 
			spq.setParameter("codigoPac", interual.getCodigoPac()); 
			spq.setParameter("hclinicaPac", interual.getHclinicaPac()); 
			spq.setParameter("dniPac", ""); 
			spq.setParameter("nomPac", ""); 
			spq.setParameter("apepPac", ""); 
			spq.setParameter("apemPac", ""); 
			spq.setParameter("sexoPac", ""); 
			spq.setParameter("fnacPac", ""); 
			
			spq.setParameter("procPac", ""); 
			spq.setParameter("servPac", ""); 
			spq.setParameter("diagnoPac", ""); 
			spq.setParameter("motivoPac", ""); 
			spq.setParameter("seguroPac", ""); 
			spq.setParameter("parentescoPac", ""); 
			spq.setParameter("usuarioCodReg", interual.getUsuarioCodReg()); 
			spq.setParameter("usuarioReg", interual.getUsuarioReg()); 
			 
			
			spq.setParameter("fechaReg", interual.getFechaReg()); 
			spq.setParameter("horaReg", interual.getHoraReg()); 
			spq.setParameter("wbcResultHemog", interual.getWbcResultHemog()); 
			spq.setParameter("wbcUnidadHemog", interual.getWbcUnidadHemog()); 
			spq.setParameter("wbcValoresHemog", interual.getWbcValoresHemog()); 
			spq.setParameter("lymResultHemog", interual.getLymResultHemog()); 
			spq.setParameter("lymUnidadHemog", interual.getLymUnidadHemog()); 
			spq.setParameter("lymValoresHemog", interual.getLymValoresHemog()); 
			spq.setParameter("midResultHemog", interual.getMidResultHemog()); 
			spq.setParameter("midUnidadHemog", interual.getMidUnidadHemog()); 
			spq.setParameter("midValoresHemog", interual.getMidValoresHemog()); 
			spq.setParameter("graResultHemog", interual.getGraResultHemog()); 
			spq.setParameter("graUnidadHemog", interual.getGraUnidadHemog()); 
			
			spq.setParameter("graValoresHemog", interual.getGraValoresHemog()); 
			spq.setParameter("lympResultHemog", interual.getLympResultHemog()); 
			spq.setParameter("lympUnidadHemog", interual.getLympUnidadHemog()); 
			spq.setParameter("lympValoresHemog", interual.getLympValoresHemog()); 
			spq.setParameter("midpResultHemog", interual.getMidpResultHemog()); 
			spq.setParameter("midpUnidadHemog", interual.getMidpUnidadHemog()); 
			spq.setParameter("midpValoresHemog", interual.getMidpValoresHemog()); 
			spq.setParameter("grapResultHemog", interual.getGrapResultHemog()); 
			spq.setParameter("grapUnidadHemog", interual.getGrapUnidadHemog()); 
			
			spq.setParameter("grapValoresHemog", interual.getGrapValoresHemog()); 
			spq.setParameter("rbcResultHemog", interual.getRbcResultHemog()); 
			spq.setParameter("rbcUnidadHemog", interual.getRbcUnidadHemog()); 
			spq.setParameter("rbcValoresHemog", interual.getRbcValoresHemog()); 
			spq.setParameter("hgbResultHemog", interual.getHgbResultHemog()); 
			spq.setParameter("hgbUnidadHemog", interual.getHgbUnidadHemog()); 
			spq.setParameter("hgbValoresHemog", interual.getHgbValoresHemog()); 
			spq.setParameter("hctResultHemog", interual.getHctResultHemog()); 
			spq.setParameter("hctUnidadHemog", interual.getHctUnidadHemog()); 
			spq.setParameter("hctValoresHemog", interual.getHctValoresHemog()); 
			spq.setParameter("mcvResultHemog", interual.getMcvResultHemog()); 
			spq.setParameter("mcvUnidadHemog", interual.getMcvUnidadHemog()); 
			spq.setParameter("mcvValoresHemog", interual.getMcvValoresHemog()); 
			spq.setParameter("mchResultHemog", interual.getMchResultHemog()); 
			spq.setParameter("mchUnidadHemog", interual.getMchUnidadHemog()); 
			spq.setParameter("mchValoresHemog", interual.getMchValoresHemog()); 
			spq.setParameter("mchcResultHemog", interual.getMchcResultHemog()); 
			spq.setParameter("mchcUnidadHemog", interual.getMchcUnidadHemog()); 
			spq.setParameter("mchcValoresHemog", interual.getMchcValoresHemog()); 
			spq.setParameter("rdwResultHemog", interual.getRdwResultHemog()); 
			
			spq.setParameter("rdwUnidadHemog", interual.getRdwUnidadHemog()); 
			spq.setParameter("rdwValoresHemog", interual.getRdwValoresHemog()); 
			spq.setParameter("pltResultHemog", interual.getPltResultHemog()); 
			spq.setParameter("pltUnidadHemog", interual.getPltUnidadHemog()); 
			spq.setParameter("pltValoresHemog", interual.getPltValoresHemog()); 
			spq.setParameter("mpvResultHemog", interual.getMpvResultHemog()); 
			spq.setParameter("mpvUnidadHemog", interual.getMpvUnidadHemog()); 
			spq.setParameter("mpvValoresHemog", interual.getMpvValoresHemog()); 
			
			spq.setParameter("fechaRegHemog", interual.getFechaRegHemog()); 
			spq.setParameter("horaRegHemog", interual.getHoraRegHemog()); 
			spq.setParameter("usuarioCodRegHemog", interual.getUsuarioCodRegHemog()); 
			spq.setParameter("usuarioRegHemog", interual.getUsuarioRegHemog()); 
			spq.setParameter("muestraHemog", interual.getMuestraHemog()); 
			spq.setParameter("codPerso", interual.getCodPerso());  
			
			spq.execute();
			
			sw=true; 
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}

	 
 
}
