package hnch.referencia.core.repository.implementacion.asistencial.citas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hnch.referencia.core.bean.asistencial.citas.ProgramacionMedicoCitaBean;
import hnch.referencia.core.bean.asistencial.referencia.ReferenciaBean;
import hnch.referencia.core.bean.general.PersonaBean;
import hnch.referencia.core.bean.general.TablaBean;
import hnch.referencia.core.entity.asistencial.citas.ProgramacionMedicoCita;
import hnch.referencia.core.entity.asistencial.maestras.TgemaeAsis01;
import hnch.referencia.core.entity.asistencial.referencia.ReferenciaCB;
import hnch.referencia.core.repository.DAOException;
import hnch.referencia.core.repository.interfaces.asistencial.citas.ProgramacionMedicoCitaDAO;

@Transactional
@Repository("programacionMedicoCitaDAO")
public class ProgramacionMedicoCitaDAOImp implements ProgramacionMedicoCitaDAO {

	@PersistenceContext//(unitName="emf")
	private EntityManager em; 
	
	
	public ProgramacionMedicoCitaBean getProgramacionMedicoCitaBean(Object object){
		return (ProgramacionMedicoCitaBean)object;
	}
	
	@Override
	public boolean insertar(ProgramacionMedicoCitaBean t) throws DAOException {

		return false;
	}

	@Override
	public boolean actualizar(ProgramacionMedicoCitaBean t) throws DAOException {

		return false;
	}

	@Override
	public boolean eliminar(ProgramacionMedicoCitaBean t) throws DAOException {

		return false;
	}

	@Override
	public ProgramacionMedicoCitaBean getBuscarPorObjecto(ProgramacionMedicoCitaBean t) throws DAOException {

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProgramacionMedicoCitaBean> getBuscarPorFiltros(ProgramacionMedicoCitaBean t) throws DAOException {
		List<ProgramacionMedicoCita> lstProgramacionMedicoCita = null;	
		List<ProgramacionMedicoCitaBean> lstProgramacionMedicoCitaBean = null;
		
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("programacionMedicoCita.buscarPorFiltros");
			spq.setParameter("TG02UNOR", t.getEspecialidad().getCodReg());
			spq.setParameter("FEDIAMES", t.getStrFechaProgramacion()); 
			
			 if (spq.execute()) {
				 lstProgramacionMedicoCita =  spq.getResultList(); 
			} 
			if (lstProgramacionMedicoCita != null && lstProgramacionMedicoCita.size() > 0) {
				
				lstProgramacionMedicoCitaBean = deListaObjetoAListaObjetoBean(lstProgramacionMedicoCita);
			}
			em.close();
			
		   
		return lstProgramacionMedicoCitaBean;
	}
	
	 

private List<ProgramacionMedicoCitaBean> deListaObjetoAListaObjetoBean(List<ProgramacionMedicoCita> lstProgramacionMedicoCita) {
		
		List<ProgramacionMedicoCitaBean> lstProgramacionMedicoCitaBean = null;
		
		if (lstProgramacionMedicoCita != null && lstProgramacionMedicoCita.size() > 0) {
			
			lstProgramacionMedicoCitaBean = new ArrayList<ProgramacionMedicoCitaBean>();
			
			for (int i = 0; i < lstProgramacionMedicoCita.size(); i++) { 
				ProgramacionMedicoCita entity = lstProgramacionMedicoCita.get(i);
				ProgramacionMedicoCitaBean bean = deObjetoAObjetoBean(entity);
				
				lstProgramacionMedicoCitaBean.add(bean);
			}
		}
		
		return lstProgramacionMedicoCitaBean;
	}
	
	private ProgramacionMedicoCitaBean deObjetoAObjetoBean(ProgramacionMedicoCita entity) {
		
		ProgramacionMedicoCitaBean bean = null;
		
		if (entity != null) {
			
			bean = new ProgramacionMedicoCitaBean();
			bean.setCodigo(entity.getCodPrgDh()); 
			bean.setCodigoProgramacionDH(entity.getCodPrgDh()); 
			bean.setNroPeriodoDH(entity.getNroPerDH()); 
			bean.setHoraInicio(entity.getHoraInic()); 
			bean.setHoraTermino(entity.getHoraTerm()); 
			bean.setHoraInicio(entity.getHoraInic()); 
			bean.setFechaProgramacion(entity.getFecDiaMe());
			bean.setMedico(new PersonaBean());
			bean.getMedico().setCodigo(entity.getCodPerso());
			bean.getMedico().setApellidoPaterno(entity.getApepater());
			bean.getMedico().setApellidoMaterno(entity.getApemater());
			bean.getMedico().setPrimerNombre(entity.getPrinombr());
			bean.getMedico().setSegundoNombre(entity.getSegnombr());
			bean.getServicio().setCodReg(entity.getCodServ());
			
	 	}
		
		return bean;
	}

	
	
	@Override
	public boolean existe(ProgramacionMedicoCitaBean t) throws DAOException {

		return false;
	}
 

}
