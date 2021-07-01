package proyect.core.service.implementacion.seguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyect.core.bean.seguridad.UsuarioAlmacenBean;
import proyect.core.repository.interfaces.seguridad.UsuarioAlmacenDAO; 
import proyect.base.repository.DAOException;
import proyect.base.service.ServiceException;
import proyect.core.service.interfaces.seguridad.UsuarioAlmacenService; 


@Service("usuarioAlmacenService")
@Transactional (readOnly = true)
public class UsuarioAlmacenServiceImp implements UsuarioAlmacenService {

	@Autowired
	UsuarioAlmacenDAO usuarioDAO;
	
	@Override
	public boolean insertar(UsuarioAlmacenBean t) throws ServiceException {
		// TODO Auto-generated method stub
		Boolean sw = false;
		try {
			sw =  usuarioDAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(UsuarioAlmacenBean t) throws ServiceException {
		// TODO Auto-generated method stub
		Boolean sw = false;
		try {
			sw =  usuarioDAO.actualizar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(UsuarioAlmacenBean t) throws ServiceException {
		// TODO Auto-generated method stub
		Boolean sw = false;
		try {
			sw =  usuarioDAO.eliminar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public UsuarioAlmacenBean getBuscarPorObjecto(UsuarioAlmacenBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsuarioAlmacenBean> getBuscarPorFiltros(UsuarioAlmacenBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		List<UsuarioAlmacenBean> lstBean = null;
		try {
			lstBean =  usuarioDAO.getBuscarPorFiltros(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return lstBean;
	}

	@Override
	public boolean existe(UsuarioAlmacenBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	} 
 

}