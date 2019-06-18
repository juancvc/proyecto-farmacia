package hnch.referencia.core.service.implementacion.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hnch.referencia.base.service.ServiceException;
import hnch.referencia.core.entity.general.PacienteReniec;
import hnch.referencia.core.repository.DAOException;
import hnch.referencia.core.repository.interfaces.general.PacienteReniecDAO;
import hnch.referencia.core.service.interfaces.general.PacienteReniecService; 

@Service("pacienteReniecService")
public class PacienteReniecServiceImpl implements PacienteReniecService {
	
	
	@Autowired
	private PacienteReniecDAO pacienteDAO; 

	public PacienteReniecServiceImpl() {
	}





	public PacienteReniecDAO getPacienteDAO() {
		return pacienteDAO;
	}





	public void setPacienteDAO(PacienteReniecDAO pacienteDAO) {
		this.pacienteDAO = pacienteDAO;
	}





	@Override
	public boolean delete(PacienteReniec arg0) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

  


	@Override
	public boolean insert(PacienteReniec arg0) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}





	@Override
	public boolean update(PacienteReniec arg0) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}





	@Override
	public List<PacienteReniec> pacienteReniecVerificacion(
			PacienteReniec pacienteReniec) 
					
					throws hnch.referencia.core.service.exception.ServiceException {
		List<PacienteReniec> lstPaciente=null;
		try {
			lstPaciente=this.getPacienteDAO().pacienteReniecVerificacion(pacienteReniec);
		} catch (DAOException e) {
			throw new hnch.referencia.core.service.exception.ServiceException(e);
		}
		return lstPaciente;
	}





	@Override
	public PacienteReniec getByObject(PacienteReniec t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public List<PacienteReniec> getByLikeObject(PacienteReniec t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public boolean exist(PacienteReniec t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}





}
