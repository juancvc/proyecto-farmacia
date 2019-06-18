//package pe.gob.procalidad.natigu.core.repository.repository.interfaces;
package sigelab.core.repository.interfaces;
import sigelab.core.repository.DAOException;

import java.util.List;



public interface BaseDAO<T> {

	public boolean insertar(T t) throws DAOException;

	public boolean actualizar(T t) throws DAOException;
	
	public boolean eliminar(T t) throws DAOException;
	
	public T getBuscarPorObjecto(T t) throws DAOException;

	public List<T> getBuscarPorFiltros(T t)throws DAOException;

	public boolean existe(T t) throws DAOException;
	
	//public boolean actualizarOrden(T t) throws DAOException;

}
