package proyect.core.service.implementacion.seguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyect.core.bean.seguridad.UsuarioAlmacenTurnoBean;
import proyect.core.repository.interfaces.seguridad.UsuarioAlmacenTurnoDAO; 
import proyect.base.repository.DAOException;
import proyect.base.service.ServiceException;
import proyect.core.service.interfaces.seguridad.UsuarioAlmacenTurnoService; 


@Service("usuarioAlmacenTurnoService")
@Transactional (readOnly = true)
public class UsuarioAlmacenTurnoServiceImp implements UsuarioAlmacenTurnoService {

	@Autowired
	UsuarioAlmacenTurnoDAO usuarioDAO;
	
	@Override
	public boolean insertar(UsuarioAlmacenTurnoBean t) throws ServiceException {
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
	public boolean actualizar(UsuarioAlmacenTurnoBean t) throws ServiceException {
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
	public boolean eliminar(UsuarioAlmacenTurnoBean t) throws ServiceException {
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
	public UsuarioAlmacenTurnoBean getBuscarPorObjecto(UsuarioAlmacenTurnoBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsuarioAlmacenTurnoBean> getBuscarPorFiltros(UsuarioAlmacenTurnoBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		List<UsuarioAlmacenTurnoBean> lstBean = null;
		try {
			lstBean =  usuarioDAO.getBuscarPorFiltros(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return lstBean;
	}

	@Override
	public boolean existe(UsuarioAlmacenTurnoBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	} 
 

}