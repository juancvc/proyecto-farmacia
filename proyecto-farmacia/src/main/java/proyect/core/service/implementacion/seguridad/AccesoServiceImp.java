//package pe.gob.procalidad.natigu.core.service.service.implementacion.seguridad;
package proyect.core.service.implementacion.seguridad;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proyect.core.bean.seguridad.AccesoBean;
import proyect.core.repository.interfaces.seguridad.AccesoDAO;
import proyect.base.repository.DAOException;
import proyect.base.service.ServiceException;
import proyect.core.service.interfaces.seguridad.AccesoService;

@Service("accesoService")
@Transactional (readOnly = true)
public class AccesoServiceImp implements AccesoService {

	@Autowired
	AccesoDAO accesoDAO;
	
	@Override
	public boolean insertar(AccesoBean t) throws ServiceException {
		// TODO Auto-generated method stub
		Boolean sw = false;
		try {
			sw =  accesoDAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(AccesoBean t) throws ServiceException {
		// TODO Auto-generated method stub
		Boolean sw = false;
		try {
			sw =  accesoDAO.actualizar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(AccesoBean t) throws ServiceException {
		// TODO Auto-generated method stub
		Boolean sw = false;
		try {
			sw =  accesoDAO.eliminar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public AccesoBean getBuscarPorObjecto(AccesoBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccesoBean> getBuscarPorFiltros(AccesoBean t)
			throws ServiceException {
		List<AccesoBean> lstBean = null;
		try {
			lstBean =  accesoDAO.getBuscarPorFiltros(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return lstBean;
	}

	@Override
	public boolean existe(AccesoBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean asignar(AccesoBean bean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  accesoDAO.asignar(bean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}
	
}