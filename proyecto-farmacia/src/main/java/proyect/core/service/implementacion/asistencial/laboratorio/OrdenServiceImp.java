package proyect.core.service.implementacion.asistencial.laboratorio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyect.core.bean.asistencial.laboratorio.OrdenBean;
import proyect.core.repository.DAOException;
import proyect.core.repository.interfaces.asistencial.laboratorio.OrdenDAO;
import proyect.core.service.exception.ServiceException;
import proyect.core.service.interfaces.asistencial.laboratorio.OrdenService; 

@Service("OrdenService")
@Transactional(readOnly = true)
public class OrdenServiceImp implements OrdenService {

	@Autowired
    OrdenDAO OrdenDAO;

	@Override
	public boolean insertar(OrdenBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  OrdenDAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(OrdenBean t) throws ServiceException {
	
		Boolean sw = false;
		try {
			sw =  OrdenDAO.actualizar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(OrdenBean t) throws ServiceException {
	
		Boolean sw = false;
		try {
			sw =  OrdenDAO.eliminar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public OrdenBean getBuscarPorObjecto(OrdenBean t) throws ServiceException {
	
		return null;
	}

	@Override
	public List<OrdenBean> getBuscarPorFiltros(OrdenBean t) throws ServiceException {
		List<OrdenBean> lstOrdenBean = null;
		try {
			lstOrdenBean = OrdenDAO.getBuscarPorFiltros(t);
		} catch (Exception e) {

		}
		return lstOrdenBean;
	}

	@Override
	public boolean existe(OrdenBean t) throws ServiceException {
	
		return false;
	}
 

}
