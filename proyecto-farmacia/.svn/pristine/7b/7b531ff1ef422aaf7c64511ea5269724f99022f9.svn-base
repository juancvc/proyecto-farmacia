package hnch.referencia.core.service.implementacion.seguridad;

import hnch.referencia.core.bean.seguridad.UsuarioPerfilBean;
import hnch.referencia.core.repository.DAOException;
import hnch.referencia.core.repository.interfaces.seguridad.UsuarioPerfilDAO;
import hnch.referencia.core.service.exception.ServiceException;
import hnch.referencia.core.service.interfaces.seguridad.UsuarioPerfilService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("usuarioPerfilService")
@Transactional (readOnly = true)
public class UsuarioPerfilServiceImp implements UsuarioPerfilService{

	@Autowired
	UsuarioPerfilDAO usuarioPerfilDAO;
	
	@Override
	public boolean insertar(UsuarioPerfilBean t) throws ServiceException {
		// TODO Auto-generated method stub
		Boolean sw = false;
		try {
			sw =  usuarioPerfilDAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(UsuarioPerfilBean t) throws ServiceException {
		// TODO Auto-generated method stub
		Boolean sw = false;
		try {
			sw =  usuarioPerfilDAO.actualizar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(UsuarioPerfilBean t) throws ServiceException {
		// TODO Auto-generated method stub
		Boolean sw = false;
		try {
			sw =  usuarioPerfilDAO.eliminar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public UsuarioPerfilBean getBuscarPorObjecto(UsuarioPerfilBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsuarioPerfilBean> getBuscarPorFiltros(UsuarioPerfilBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		List<UsuarioPerfilBean> lstBean = null;
		try {
			lstBean =  usuarioPerfilDAO.getBuscarPorFiltros(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return lstBean;
	}

	@Override
	public boolean existe(UsuarioPerfilBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UsuarioPerfilBean buscarXcodigoUsu(UsuarioPerfilBean usuarioPerfilBean) throws ServiceException {
		UsuarioPerfilBean oUsuarioBean = null;
		try {
			oUsuarioBean =  usuarioPerfilDAO.buscarXcodigoUsu(usuarioPerfilBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return oUsuarioBean;
	}

	
}
