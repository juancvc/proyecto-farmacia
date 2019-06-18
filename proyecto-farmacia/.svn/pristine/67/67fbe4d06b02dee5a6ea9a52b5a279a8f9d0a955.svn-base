
package hnch.referencia.core.service.implementacion.general;

import hnch.referencia.core.bean.general.TablaBean;
import hnch.referencia.core.repository.DAOException;
import hnch.referencia.core.repository.interfaces.general.Maestra1DAO;
import hnch.referencia.core.service.exception.ServiceException;
import hnch.referencia.core.service.interfaces.general.Maestra1Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 

/*
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.MascotaBean;
import pe.gob.procalidad.natigu.core.bean.bean.configuracion.PremioBean;
import pe.gob.procalidad.natigu.core.bean.bean.generico.TablaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.general.Maestra1DAO; 
import pe.gob.procalidad.natigu.core.service.exception.ServiceException;
import pe.gob.procalidad.natigu.core.service.service.interfaces.general.Maestra1Service;
*/
 
@Service("maestra1Service")
@Transactional (readOnly = true)
public class Maestra1ServiceImp implements Maestra1Service {
	
	@Autowired
	private Maestra1DAO maestra1DAO; 
	

	@Override
	public boolean insertar(TablaBean TablaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  maestra1DAO.insertar(TablaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(TablaBean TablaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  maestra1DAO.actualizar(TablaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(TablaBean TablaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  maestra1DAO.eliminar(TablaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public TablaBean getBuscarPorObjecto(TablaBean TablaBean) throws ServiceException {
		TablaBean oTablaBean = null;
		try {
			oTablaBean = maestra1DAO.getBuscarPorObjecto(TablaBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oTablaBean;
	}
	
	@Override
	public TablaBean getBuscarPorTablaYRegistro(TablaBean TablaBean) throws ServiceException {
		TablaBean oTablaBean = null;
		try {
			oTablaBean = maestra1DAO.getBuscarPorTablaYRegistro(TablaBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oTablaBean;
	}
	

	@Override
	public List<TablaBean> getBuscarPorFiltros(TablaBean TablaBean)
			throws ServiceException {
		List<TablaBean> lstTablaBean=null;
		try {
			System.out.println("en listado maestra service imp");
			lstTablaBean=(List<TablaBean>) maestra1DAO.getBuscarPorFiltros(TablaBean);
		} catch (Exception e) {
			e.printStackTrace(); 	 
		} 
		 
		return lstTablaBean;
	}

	@Override
	public boolean existe(TablaBean t) throws ServiceException {
		
		return false;
	}

	@Override
	public List<TablaBean> listarPorCodigoTabla(String codTabla,int tipo)
			throws  ServiceException { 
		List<TablaBean> lstTablaBean=null;
		try { 
			lstTablaBean=(List<TablaBean>) maestra1DAO.listarPorCodigoTabla(codTabla,tipo);
		} catch (Exception e) {
			 
		}  
		return lstTablaBean;
	}
	 
	@Override
	public List<TablaBean> listarComboGeneral(String codTabla)
			throws  ServiceException { 
		List<TablaBean> lstTablaBean=null;
		try { 
			lstTablaBean=(List<TablaBean>) maestra1DAO.listarComboGeneral(codTabla);
		} catch (Exception e) {
			 
		}  
		return lstTablaBean;
	}
	
}
	
	 
