
package sigelab.base.service.interfaces;
 

import java.util.List;

import sigelab.base.service.ServiceException;



public interface GenericService<T> {

	public boolean insert(T t) throws ServiceException;

	public boolean update(T t) throws ServiceException;
	
	public boolean delete(T t) throws ServiceException;
	
	public T getByObject(T t) throws ServiceException;

	public List<T> getByLikeObject(T t) throws ServiceException;

	public boolean exist(T t) throws ServiceException;

}
