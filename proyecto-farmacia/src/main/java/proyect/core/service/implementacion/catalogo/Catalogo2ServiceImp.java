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
	public boolean insertar(CatalogoBean catalogoBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  maestra2DAO.insertar(catalogoBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(CatalogoBean catalogoBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  maestra2DAO.actualizar(catalogoBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(CatalogoBean catalogoBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  maestra2DAO.eliminar(catalogoBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public CatalogoBean getBuscarPorObjecto(CatalogoBean catalogoBean) throws ServiceException {
		CatalogoBean ocatalogoBean = null;
		try {
			ocatalogoBean = maestra2DAO.getBuscarPorObjecto(catalogoBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return ocatalogoBean;
	}

	@Override
	public List<CatalogoBean> getBuscarPorFiltros(CatalogoBean lengua)
			throws ServiceException {
		List<CatalogoBean> lstcatalogoBean=null;
		try { 
			lstcatalogoBean=(List<CatalogoBean>) maestra2DAO.getBuscarPorFiltros(lengua);
		} catch (Exception e) {
			 
		}  
		return lstcatalogoBean;
	}

	@Override
	public boolean existe(CatalogoBean t) throws ServiceException {
		
		return false;
	}

	@Override
	public List<CatalogoBean> listarPorCodigoTabla(String codTabla,int tipo)
			throws  ServiceException {  
		List<CatalogoBean> lstcatalogoBean=null;
		try { 
			lstcatalogoBean =   maestra2DAO.listarPorCodigoTabla(codTabla,tipo);
		} catch (Exception e) {
			 
		}  
		return lstcatalogoBean;
	}

	@Override
	public List<CatalogoBean> listarPorValor1(CatalogoBean catalogoBean) throws ServiceException {
		
		return null;
	}

	@Override
	public List<CatalogoBean> listarTodascatalogos() throws ServiceException {
		List<CatalogoBean> lstcatalogoBean=null;
		try { 
			lstcatalogoBean =   maestra2DAO.listarTodascatalogos();
		} catch (Exception e) {
			 
		}  
		return lstcatalogoBean;
	}

	@Override
	public List<CatalogoBean> listarCatalogoRegistros(CatalogoBean catalogoBean) throws ServiceException {
		List<CatalogoBean> lstcatalogoBean=null;
		try { 
			lstcatalogoBean =   maestra2DAO.listarCatalogoRegistros(catalogoBean);
		} catch (Exception e) {
			 
		}  
		return lstcatalogoBean;
	}
	  
}
	
	 
