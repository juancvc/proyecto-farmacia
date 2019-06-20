package proyect.core.service.implementacion.general;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyect.core.bean.general.TablaBean;
import proyect.core.repository.DAOException;
import proyect.core.repository.interfaces.general.Maestra2DAO;
import proyect.core.service.exception.ServiceException;
import proyect.core.service.interfaces.general.Maestra2Service; 
 
@Service("maestra2Service")
@Transactional (readOnly = true)
public class Maestra2ServiceImp implements Maestra2Service {
	
	@Autowired
	private Maestra2DAO maestra2DAO; 
	

	@Override
	public boolean insertar(TablaBean TablaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  maestra2DAO.insertar(TablaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(TablaBean TablaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  maestra2DAO.actualizar(TablaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(TablaBean TablaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  maestra2DAO.eliminar(TablaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public TablaBean getBuscarPorObjecto(TablaBean TablaBean) throws ServiceException {
		TablaBean oTablaBean = null;
		try {
			oTablaBean = maestra2DAO.getBuscarPorObjecto(TablaBean);
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
			lstTablaBean=(List<TablaBean>) maestra2DAO.getBuscarPorFiltros(lengua);
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
			lstTablaBean=(List<TablaBean>) maestra2DAO.listarPorCodigoTabla(codTabla,tipo);
		} catch (Exception e) {
			 
		}  
		return lstTablaBean;
	}

	@Override
	public List<TablaBean> listarPorValor1(TablaBean TablaBean) throws ServiceException {
		List<TablaBean> lstTablaBean=null;
		try { 
			lstTablaBean=(List<TablaBean>) maestra2DAO.listarPorValor1(TablaBean);
		} catch (Exception e) {
			 
		}  
		return lstTablaBean;
	}
	 
	
}
	
	 
