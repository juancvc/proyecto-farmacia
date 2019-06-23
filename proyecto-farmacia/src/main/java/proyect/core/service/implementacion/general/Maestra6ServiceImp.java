package proyect.core.service.implementacion.general;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyect.core.bean.general.CatalogoBean;
import proyect.core.repository.DAOException;
import proyect.core.repository.interfaces.general.Maestra6DAO;
import proyect.core.service.exception.ServiceException;
import proyect.core.service.interfaces.general.Maestra6Service; 
 
@Service("maestra6Service")
@Transactional (readOnly = true)
public class Maestra6ServiceImp implements Maestra6Service {
	
	@Autowired
	private Maestra6DAO maestra6DAO; 
	

	@Override
	public boolean insertar(CatalogoBean TablaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  maestra6DAO.insertar(TablaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(CatalogoBean TablaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  maestra6DAO.actualizar(TablaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(CatalogoBean TablaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  maestra6DAO.eliminar(TablaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public CatalogoBean getBuscarPorObjecto(CatalogoBean TablaBean) throws ServiceException {
		CatalogoBean oTablaBean = null;
		try {
			oTablaBean = maestra6DAO.getBuscarPorObjecto(TablaBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oTablaBean;
	}

	@Override
	public List<CatalogoBean> getBuscarPorFiltros(CatalogoBean lengua)
			throws ServiceException {
		List<CatalogoBean> lstTablaBean=null;
		try { 
			lstTablaBean=(List<CatalogoBean>) maestra6DAO.getBuscarPorFiltros(lengua);
		} catch (Exception e) {
			 
		}  
		return lstTablaBean;
	}

	@Override
	public boolean existe(CatalogoBean t) throws ServiceException {
		
		return false;
	}

	@Override
	public List<CatalogoBean> listarPorCodigoTabla(String codTabla,long tipo)
			throws  ServiceException { 
		List<CatalogoBean> lstTablaBean=null;
		try { 
			lstTablaBean=(List<CatalogoBean>) maestra6DAO.listarPorCodigoTabla(codTabla,tipo);
		} catch (Exception e) {
			 
		}  
		return lstTablaBean;
	}

	@Override
	public List<CatalogoBean> listarPorValor1(CatalogoBean TablaBean) throws ServiceException {
		List<CatalogoBean> lstTablaBean=null;
		try { 
			lstTablaBean=(List<CatalogoBean>) maestra6DAO.listarPorValor1(TablaBean);
		} catch (Exception e) {
			 
		}  
		return lstTablaBean;
	}

	@Override
	public List<CatalogoBean> listarPorValor3yNombre(CatalogoBean TablaBean)
			throws ServiceException {
		List<CatalogoBean> lstTablaBean=null;
		try { 
			lstTablaBean=(List<CatalogoBean>) maestra6DAO.listarPorValor3yNombre(TablaBean);
		} catch (Exception e) {
			 
		}  
		return lstTablaBean;
	}
	 
	
}
	
	 
