//package pe.gob.procalidad.natigu.core.service.service.interfaces;
package proyect.base.service.interfaces;

import java.util.List;

import proyect.base.service.ServiceException;



public interface BaseService<T> {

	public boolean insertar(T t) throws ServiceException;

	public boolean actualizar(T t) throws ServiceException;
	
	public boolean eliminar(T t) throws ServiceException;
	
	public T getBuscarPorObjecto(T t) throws ServiceException;

	public List<T> getBuscarPorFiltros(T t) throws ServiceException;

	public boolean existe(T t) throws ServiceException;
	

}
