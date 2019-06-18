package hnch.referencia.core.repository.implementacion.general;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.StoredProcedureQuery; 
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hnch.referencia.core.entity.general.PacienteReniec; 
import hnch.referencia.core.repository.interfaces.general.PacienteReniecDAO; 
import hnch.referencia.base.repository.DAOException;


@Transactional
@Repository("pacienteReniecDAO")
public class PacienteReniecDAOImpl implements PacienteReniecDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean delete(PacienteReniec arg0) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	


	@Override
	public boolean insert(PacienteReniec arg0) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(PacienteReniec arg0) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PacienteReniec> pacienteReniecVerificacion(
			PacienteReniec pacienteReniec) throws hnch.referencia.core.repository.DAOException {
	    List<PacienteReniec> lstPaciente = null;	
		
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("pacienteReniec.verificar");
		
			
			spq.setParameter("dni", pacienteReniec.getNroDni());
			
			
			if (spq.execute()) {
				lstPaciente = (List<PacienteReniec>)spq.getResultList();
			 	
			}
			em.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			//throw new hnch.referencia.core.repository.DAOException(e);
		}
		return lstPaciente;
	}




	@Override
	public PacienteReniec getByObject(PacienteReniec t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public List<PacienteReniec> getByLikeObject(PacienteReniec t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public boolean exist(PacienteReniec t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}


	













	



}
