package sigelab.core.service.implementacion.asistencial.banco;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sigelab.core.bean.asistencial.banco.EstadoFisicoBean;
import sigelab.core.repository.DAOException; 
import sigelab.core.service.exception.ServiceException;
import sigelab.core.service.interfaces.asistencial.banco.EstadoFisicoService; 
import sigelab.core.repository.interfaces.asistencial.banco.EstadoFisicoDAO ;

@Service("estadoFisicoService")
@Transactional(readOnly = true)
public class EstadoFisicoServiceImp implements EstadoFisicoService {

	@Autowired
    EstadoFisicoDAO EstadoFisicoDAO;

	@Override
	public boolean insertar(EstadoFisicoBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  EstadoFisicoDAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(EstadoFisicoBean t) throws ServiceException {
	
		Boolean sw = false;
		try {
			sw =  EstadoFisicoDAO.actualizar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(EstadoFisicoBean t) throws ServiceException {
	
		Boolean sw = false;
		try {
			sw =  EstadoFisicoDAO.eliminar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public EstadoFisicoBean getBuscarPorObjecto(EstadoFisicoBean t) throws ServiceException {
	
		return null;
	}

	@Override
	public List<EstadoFisicoBean> getBuscarPorFiltros(EstadoFisicoBean t) throws ServiceException {
		List<EstadoFisicoBean> lstEstadoFisicoBean = null;
		try {
			lstEstadoFisicoBean = EstadoFisicoDAO.getBuscarPorFiltros(t);
		} catch (Exception e) {

		}
		return lstEstadoFisicoBean;
	}

	@Override
	public boolean existe(EstadoFisicoBean t) throws ServiceException {
	
		return false;
	}
 

}
