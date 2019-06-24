package proyect.core.service.implementacion.catalogo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyect.core.bean.general.CatalogoBean;
import proyect.core.repository.interfaces.catalogo.Catalogo2DAO;
import proyect.base.repository.DAOException;
import proyect.base.service.ServiceException;
import proyect.core.service.interfaces.catalogo.Catalogo2Service; 
 
@Service("maestra2Service")
@Transactional (readOnly = true)
public class Catalogo2ServiceImp implements Catalogo2Service {
	
	@Autowired
	private Catalogo2DAO maestra2DAO; 
	

	@Override
	public boolean insertar(CatalogoBean TablaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  maestra2DAO.insertar(TablaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(CatalogoBean TablaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  maestra2DAO.actualizar(TablaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(CatalogoBean TablaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  maestra2DAO.eliminar(TablaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public CatalogoBean getBuscarPorObjecto(CatalogoBean TablaBean) throws ServiceException {
		CatalogoBean oTablaBean = null;
		try {
			oTablaBean = maestra2DAO.getBuscarPorObjecto(TablaBean);
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
			lstTablaBean=(List<CatalogoBean>) maestra2DAO.getBuscarPorFiltros(lengua);
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
		return null;
	}

	@Override
	public List<CatalogoBean> listarPorValor1(CatalogoBean TablaBean) throws ServiceException {
		
		return null;
	}
	 
	
}
	
	 
