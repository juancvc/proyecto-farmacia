package sigelab.core.service.implementacion.seguridad;

import sigelab.core.bean.seguridad.UsuarioBean;
import sigelab.core.repository.DAOException;
import sigelab.core.repository.interfaces.seguridad.UsuarioDAO;
import sigelab.core.service.exception.ServiceException;
import sigelab.core.service.interfaces.seguridad.UsuarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("usuarioService")
@Transactional (readOnly = true)
public class UsuarioServiceImp implements UsuarioService {

	@Autowired
	UsuarioDAO usuarioDAO;
	
	@Override
	public boolean insertar(UsuarioBean t) throws ServiceException {
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
	public boolean actualizar(UsuarioBean t) throws ServiceException {
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
	public boolean eliminar(UsuarioBean t) throws ServiceException {
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
	public UsuarioBean getBuscarPorObjecto(UsuarioBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsuarioBean> getBuscarPorFiltros(UsuarioBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		List<UsuarioBean> lstBean = null;
		try {
			lstBean =  usuarioDAO.getBuscarPorFiltros(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return lstBean;
	}

	@Override
	public boolean existe(UsuarioBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UsuarioBean autenticar(UsuarioBean prmUsuarioBean) throws ServiceException {
		UsuarioBean oUsuarioBean = null;
		try {
			oUsuarioBean =  usuarioDAO.autenticar(prmUsuarioBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return oUsuarioBean;
	}

	@Override
	public Integer cambiarPassword(UsuarioBean t)
			throws ServiceException {
		Integer sw = -1;
		try {
			sw =  usuarioDAO.cambiarPassword(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public UsuarioBean buscarxcodigousua(UsuarioBean prmUsuarioBean) throws ServiceException {
		UsuarioBean oUsuarioBean = null;
		System.out.println("buscarxcodigousua");
		try {
			oUsuarioBean =  usuarioDAO.buscarxcodigousua(prmUsuarioBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return oUsuarioBean;
	}
	
	@Override
	public UsuarioBean buscarxcodperso(UsuarioBean prmUsuarioBean) throws ServiceException {
		UsuarioBean oUsuarioBean = null;
		try {
			oUsuarioBean =  usuarioDAO.buscarxcodperso(prmUsuarioBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return oUsuarioBean;
	}

}