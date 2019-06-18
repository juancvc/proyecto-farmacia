package hnch.referencia.core.service.implementacion.general;


import hnch.referencia.core.bean.general.TablaBean;
import hnch.referencia.core.repository.DAOException;
import hnch.referencia.core.repository.interfaces.general.Maestra6DAO;
import hnch.referencia.core.service.exception.ServiceException;
import hnch.referencia.core.service.interfaces.general.Maestra6Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 
 
@Service("maestra6Service")
@Transactional (readOnly = true)
public class Maestra6ServiceImp implements Maestra6Service {
	
	@Autowired
	private Maestra6DAO maestra6DAO; 
	

	@Override
	public boolean insertar(TablaBean TablaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  maestra6DAO.insertar(TablaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(TablaBean TablaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  maestra6DAO.actualizar(TablaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(TablaBean TablaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  maestra6DAO.eliminar(TablaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public TablaBean getBuscarPorObjecto(TablaBean TablaBean) throws ServiceException {
		TablaBean oTablaBean = null;
		try {
			oTablaBean = maestra6DAO.getBuscarPorObjecto(TablaBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oTablaBean;
	}

	@Override
	public List<TablaBean> getBuscarPorFiltros(TablaBean lengua)
			throws ServiceException {
		List<TablaBean> lstTablaBean=null;
		try { 
			lstTablaBean=(List<TablaBean>) maestra6DAO.getBuscarPorFiltros(lengua);
		} catch (Exception e) {
			 
		}  
		return lstTablaBean;
	}

	@Override
	public boolean existe(TablaBean t) throws ServiceException {
		
		return false;
	}

	@Override
	public List<TablaBean> listarPorCodigoTabla(String codTabla,long tipo)
			throws  ServiceException { 
		List<TablaBean> lstTablaBean=null;
		try { 
			lstTablaBean=(List<TablaBean>) maestra6DAO.listarPorCodigoTabla(codTabla,tipo);
		} catch (Exception e) {
			 
		}  
		return lstTablaBean;
	}

	@Override
	public List<TablaBean> listarPorValor1(TablaBean TablaBean) throws ServiceException {
		List<TablaBean> lstTablaBean=null;
		try { 
			lstTablaBean=(List<TablaBean>) maestra6DAO.listarPorValor1(TablaBean);
		} catch (Exception e) {
			 
		}  
		return lstTablaBean;
	}

	@Override
	public List<TablaBean> listarPorValor3yNombre(TablaBean TablaBean)
			throws ServiceException {
		List<TablaBean> lstTablaBean=null;
		try { 
			lstTablaBean=(List<TablaBean>) maestra6DAO.listarPorValor3yNombre(TablaBean);
		} catch (Exception e) {
			 
		}  
		return lstTablaBean;
	}
	 
	
}
	
	 
