package hnch.referencia.core.repository.implementacion.asistencial.citas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hnch.referencia.core.bean.asistencial.citas.CitaBean;
import hnch.referencia.core.bean.general.PersonaBean;
import hnch.referencia.core.entity.asistencial.citas.Citas;
import hnch.referencia.core.entity.asistencial.citas.Citas; 
import hnch.referencia.core.repository.DAOException;
import hnch.referencia.core.repository.interfaces.asistencial.citas.CitaDAO; 

@Transactional
@Repository("CitaDAO")
public class CitaDAOImp implements CitaDAO {

	@PersistenceContext//(unitName="emf")
	private EntityManager em; 
	
	
	public CitaBean getCitaBean(Object object){
		return (CitaBean)object;
	}
	
	@Override
	public boolean insertar(CitaBean citaBean) throws DAOException {

		Object idCita= null;  
		Object idEpisodio= null;  
		Object versionEpisodio= null;  
		Object periodoEpisodio= null;  
		
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("citas.insertar"); 
			spq.setParameter("CODORGAN", citaBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", citaBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", citaBean.getCodigoSede()); 
			
			spq.setParameter("CODEPICB_IN", "");
			spq.setParameter("NRVEPICB_IN", "");
			spq.setParameter("NRPEPICB_IN", ""); 
			
			spq.setParameter("NROPERDH", citaBean.getProgramacionMedicoCitaBean().getNroPeriodoDH()); 
			spq.setParameter("CODPRGDH", citaBean.getProgramacionMedicoCitaBean().getCodigoProgramacionDH());  
			spq.setParameter("GT02SERV", citaBean.getProgramacionMedicoCitaBean().getServicio().getCodReg()); 
			spq.setParameter("GT02SESP", citaBean.getProgramacionMedicoCitaBean().getEspecialidad().getCodReg()); 
			
			spq.setParameter("CODPACIE", citaBean.getPacienteBean().getCodigo());  
			spq.setParameter("NRODOCUM", citaBean.getPacienteBean().getPersona().getNroDocumento()); 
			spq.setParameter("CODEMPLE", citaBean.getProgramacionMedicoCitaBean().getMedico().getCodigo()); 
			spq.setParameter("FECHAPRG", citaBean.getProgramacionMedicoCitaBean().getStrFechaProgramacion()); 
			spq.setParameter("HORAINIC", citaBean.getProgramacionMedicoCitaBean().getHoraInicio()); 
			spq.setParameter("TIPOPACE", citaBean.getPacienteBean().getTipoSeguro().getCodReg()); 
			
			spq.setParameter("AUCDUSCR", citaBean.getCodigoUsuarioCreacion());
			spq.setParameter("AUPCIPCR", citaBean.getIpCreacion());
			
			spq.setParameter("CDORGDXR", citaBean.getReferenciaDiagnosticoBean().getCodigoOrganizacion());
			spq.setParameter("CDINSDXR", citaBean.getReferenciaDiagnosticoBean().getCodigoInstitucion());
			spq.setParameter("CDSEDDXR", citaBean.getReferenciaDiagnosticoBean().getCodigoSede());
			spq.setParameter("CODDIAGN", citaBean.getReferenciaDiagnosticoBean().getCodigo());
			spq.setParameter("NRVEDXRE", citaBean.getReferenciaDiagnosticoBean().getNumeroVersion());
			spq.setParameter("NRPEDXRE", citaBean.getReferenciaDiagnosticoBean().getNumeroPeriodo());
			
			
			spq.execute();
			
			idCita = spq.getOutputParameterValue(1);
			idEpisodio=  spq.getOutputParameterValue(5);
			versionEpisodio=  spq.getOutputParameterValue(6);
			periodoEpisodio=  spq.getOutputParameterValue(7);
			
			if (idCita != null) {
				citaBean.setCodigo(idCita.toString());
				citaBean.getEpisodioBean().setCodigo(idEpisodio.toString());
				citaBean.getEpisodioBean().setNumeroVersion(versionEpisodio.toString());
				citaBean.getEpisodioBean().setNumeroPeriodo(periodoEpisodio.toString());
				sw=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public boolean actualizar(CitaBean t) throws DAOException {

		return false;
	}

	@Override
	public boolean eliminar(CitaBean t) throws DAOException {

		return false;
	}

	@Override
	public CitaBean getBuscarPorObjecto(CitaBean t) throws DAOException {

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CitaBean> getBuscarPorFiltros(CitaBean citaBean) throws DAOException {
		List<Citas> lstCitas = null;	
		List<CitaBean> lstCitaBean = null;
		
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("citas.buscarPorFiltros"); 
			spq.setParameter("GT02SESP", citaBean.getEspecialidad().getCodReg()); 
			spq.setParameter("NROREFER", citaBean.getReferenciaDiagnosticoBean().getReferenciaBean().getNumeroReferencia()); 
			spq.setParameter("FECHPRGI", citaBean.getFechaDesde()); 
			spq.setParameter("FECHPRGF", citaBean.getFechaHasta()); 
			spq.setParameter("NOMESTOR", citaBean.getReferenciaDiagnosticoBean().getReferenciaBean().getEstablecimientoOrige().getNomRenaes()); 
			
			 if (spq.execute()) {
				 lstCitas =  spq.getResultList(); 
			 }
			 
			if (lstCitas != null && lstCitas.size() > 0) {
				lstCitaBean = deListaObjetoAListaObjetoBean(lstCitas);
			 }
			
			em.close();
			
		   
		return lstCitaBean;
	}
	
	 

private List<CitaBean> deListaObjetoAListaObjetoBean(List<Citas> lstCitas) {
		
		List<CitaBean> lstCitaBean = null;
		
		if (lstCitas != null && lstCitas.size() > 0) {
			
			lstCitaBean = new ArrayList<CitaBean>();
			
			for (int i = 0; i < lstCitas.size(); i++) { 
				Citas entity = lstCitas.get(i);
				CitaBean bean = deObjetoAObjetoBean(entity);
				
				lstCitaBean.add(bean);
			}
		}
		
		return lstCitaBean;
	}
	
	private CitaBean deObjetoAObjetoBean(Citas entity) {
		
		CitaBean bean = null;
		
		if (entity != null) {
			
			bean = new CitaBean();
			bean.setCodigo(entity.getId().getCodprgci());  
			bean.setNumeroVersion(entity.getId().getNroversi());  
			bean.setCodigoInstitucion(entity.getId().getCodinsti());  
			bean.setCodigoSede(entity.getId().getCodsedei());  
			bean.setCodigoOrganizacion(entity.getId().getCodorgan());
			bean.setNumeroVersion(entity.getId().getNroversi());
			bean.setNumeroPeriodo(entity.getId().getNroperio());
			bean.setFechaCita(entity.getFECHAPRG());
			bean.setHoraCita(entity.getHORAINIC());
			bean.setNombreUsuarioCreacion(entity.getNOMUSUAR());
			bean.getEspecialidad().setNombreCorto(entity.getESPECIALIDAD()); 
			
			bean.getReferenciaDiagnosticoBean().getReferenciaBean().setNumeroReferencia(entity.getNROREFER());
			bean.getReferenciaDiagnosticoBean().getReferenciaBean().getEstablecimientoOrige().setNomRenaes(entity.getNOMRENEA());
			bean.getPacienteBean().getPersona().setApellidoMaterno(entity.getAPEMATER());
			bean.getPacienteBean().getPersona().setApellidoPaterno(entity.getAPEPATER());
			bean.getPacienteBean().getPersona().setPrimerNombre(entity.getPRINOMBR());
			bean.getPacienteBean().getPersona().setSegundoNombre(entity.getSEGNOMBR());
			bean.getProgramacionMedicoCitaBean().getMedico().setApellidoPaterno(entity.getMEDICO());
			
			
	 	}
		
		return bean;
	}

	
	
	@Override
	public boolean existe(CitaBean t) throws DAOException {

		return false;
	}

	@Override
	public List<CitaBean> listado(CitaBean citaBean) {
		List<Citas> lstCitas = null;	
		List<CitaBean> lstCitaBean = null;
		
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("citas.buscarPorFiltros"); 
			spq.setParameter("GT02SESP", citaBean.getEspecialidad().getCodReg()); 
			spq.setParameter("NROREFER", citaBean.getReferenciaDiagnosticoBean().getReferenciaBean().getNumeroReferencia()); 
			spq.setParameter("FECHPRGI", citaBean.getFechaDesde()); 
			spq.setParameter("FECHPRGF", citaBean.getFechaHasta()); 
			spq.setParameter("NOMESTOR", citaBean.getReferenciaDiagnosticoBean().getReferenciaBean().getEstablecimientoOrige().getNomRenaes()); 
			
			 if (spq.execute()) {
				 lstCitas =  spq.getResultList(); 
			 }
			 
			if (lstCitas != null && lstCitas.size() > 0) {
				lstCitaBean = deListaObjetoAListaObjetoBean(lstCitas);
			 }
			
			em.close();
			
		   
		return lstCitaBean;
	}
 

}
