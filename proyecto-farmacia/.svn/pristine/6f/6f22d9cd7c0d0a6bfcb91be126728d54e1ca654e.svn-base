package hnch.referencia.core.service.implementacion.general;

import hnch.referencia.core.bean.general.PacienteBean;
import hnch.referencia.core.repository.DAOException;
import hnch.referencia.core.repository.interfaces.general.PacienteDAO;
import hnch.referencia.core.service.exception.ServiceException;
import hnch.referencia.core.service.interfaces.general.PacienteService; 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("pacienteService")
@Transactional (readOnly = true)
public class PacienteServiceImpl implements PacienteService {

	@Autowired
	private PacienteDAO PacienteDAO; 
	
	public PacienteDAO getPacienteDAO() {
		return PacienteDAO;
	}

	public void setPacienteDAO(PacienteDAO PacienteDAO) {
		this.PacienteDAO = PacienteDAO;
	}

	@Override
	public boolean insertar(PacienteBean PacienteBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  PacienteDAO.insertar(PacienteBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(PacienteBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  PacienteDAO.actualizar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(PacienteBean t) throws ServiceException { 
		return false;
	}

	@Override
	public PacienteBean getBuscarPorObjecto(PacienteBean t)
			throws ServiceException { 
		return null;
	}

	@Override
	public List<PacienteBean> getBuscarPorFiltros(PacienteBean t)
			throws ServiceException { 
		return null;
	}

	@Override
	public boolean existe(PacienteBean t) throws ServiceException { 
		return false;
	}
  

}
