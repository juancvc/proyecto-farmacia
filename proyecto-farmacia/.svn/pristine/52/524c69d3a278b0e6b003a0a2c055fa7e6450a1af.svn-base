
package hnch.referencia.base.repository.interfaces;
import hnch.referencia.base.repository.DAOException;

import java.util.List;



public interface GenericDAO<T> {

	public boolean insert(T t) throws DAOException;

	public boolean update(T t) throws DAOException;
	
	public boolean delete(T t) throws DAOException;
	
	public T getByObject(T t) throws DAOException;

	public List<T> getByLikeObject(T t) throws DAOException;

	public boolean exist(T t) throws DAOException;

}
