package sigelab.core.service.implementacion.asistencial.banco;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sigelab.core.bean.asistencial.banco.PreDonanteEntrevistaBean;
import sigelab.core.repository.DAOException; 
import sigelab.core.service.exception.ServiceException;
import sigelab.core.service.interfaces.asistencial.banco.PreDonanteEntrevistaService; 
import sigelab.core.repository.interfaces.asistencial.banco.PreDonanteEntrevistaDAO ;

@Service("PreDonanteEntrevistaServiceImp")
@Transactional(readOnly = true)
public class PreDonanteEntrevistaServiceImp implements PreDonanteEntrevistaService {

	@Autowired
    PreDonanteEntrevistaDAO PreDonanteEntrevistaDAO;

	@Override
	public boolean insertar(PreDonanteEntrevistaBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  PreDonanteEntrevistaDAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(PreDonanteEntrevistaBean t) throws ServiceException {
	
		Boolean sw = false;
		try {
			sw =  PreDonanteEntrevistaDAO.actualizar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(PreDonanteEntrevistaBean t) throws ServiceException {
	
		Boolean sw = false;
		try {
			sw =  PreDonanteEntrevistaDAO.eliminar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public PreDonanteEntrevistaBean getBuscarPorObjecto(PreDonanteEntrevistaBean t) throws ServiceException {
	
		return null;
	}

	@Override
	public List<PreDonanteEntrevistaBean> getBuscarPorFiltros(PreDonanteEntrevistaBean t) throws ServiceException {
		List<PreDonanteEntrevistaBean> lstPreDonanteEntrevistaBean = null;
		try {
			lstPreDonanteEntrevistaBean = PreDonanteEntrevistaDAO.getBuscarPorFiltros(t);
		} catch (Exception e) {

		}
		return lstPreDonanteEntrevistaBean;
	}

	@Override
	public boolean existe(PreDonanteEntrevistaBean t) throws ServiceException {
	
		return false;
	}

 

}
