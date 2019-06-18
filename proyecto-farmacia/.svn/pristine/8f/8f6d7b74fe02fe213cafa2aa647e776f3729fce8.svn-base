package hnch.referencia.core.repository.interfaces.seguridad;

import hnch.referencia.core.bean.seguridad.UsuarioBean;
import hnch.referencia.core.repository.DAOException;
import hnch.referencia.core.repository.interfaces.BaseDAO;

public interface UsuarioDAO extends BaseDAO<UsuarioBean> {

	public UsuarioBean autenticar(UsuarioBean prmUsuarioBean) throws DAOException;
	
	public Integer cambiarPassword(UsuarioBean prmUsuarioBean) throws DAOException;
	
	public UsuarioBean buscarxcodigousua(UsuarioBean prmUsuarioBean) throws DAOException;
	
	public UsuarioBean buscarxcodperso(UsuarioBean prmUsuarioBean) throws DAOException;
}
