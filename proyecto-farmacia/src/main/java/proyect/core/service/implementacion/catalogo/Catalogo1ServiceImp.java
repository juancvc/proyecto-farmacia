
package proyect.core.service.implementacion.catalogo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyect.base.service.ServiceException;
import proyect.core.bean.general.CatalogoBean;
import proyect.core.repository.DAOException;
import proyect.core.repository.interfaces.catalogo.Catalogo1DAO; 
import proyect.core.service.interfaces.catalogo.Catalogo1Service; 

 
@Service("maestra1Service")
@Transactional (readOnly = true)
public class Catalogo1ServiceImp implements Catalogo1Service {
	
	@Autowired
	private Catalogo1DAO maestra1DAO; 
	

	@Override
	public boolean insertar(CatalogoBean TablaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  maestra1DAO.insertar(TablaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(CatalogoBean TablaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  maestra1DAO.actualizar(TablaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(CatalogoBean TablaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  maestra1DAO.eliminar(TablaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public CatalogoBean getBuscarPorObjecto(CatalogoBean TablaBean) throws ServiceException {
		CatalogoBean oTablaBean = null;
		try {
			oTablaBean = maestra1DAO.getBuscarPorObjecto(TablaBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oTablaBean;
	}
	
	@Override
	public CatalogoBean getBuscarPorTablaYRegistro(CatalogoBean TablaBean) throws ServiceException {
		CatalogoBean oTablaBean = null;
		try {
			oTablaBean = maestra1DAO.getBuscarPorTablaYRegistro(TablaBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oTablaBean;
	}
	

	@Override
	public List<CatalogoBean> getBuscarPorFiltros(CatalogoBean TablaBean)
			throws ServiceException {
		List<CatalogoBean> lstTablaBean=null;
		try {
			System.out.println("en listado maestra service imp");
			lstTablaBean=(List<CatalogoBean>) maestra1DAO.getBuscarPorFiltros(TablaBean);
		} catch (Exception e) {
			e.printStackTrace(); 	 
		} 
		 
		return lstTablaBean;
	}

	@Override
	public boolean existe(CatalogoBean t) throws ServiceException {
		
		return false;
	}

	@Override
	public List<CatalogoBean> listarPorCodigoTabla(String codTabla,int tipo)
			throws  ServiceException { 
		List<CatalogoBean> lstTablaBean=null;
		try { 
			lstTablaBean=(List<CatalogoBean>) maestra1DAO.listarPorCodigoTabla(codTabla,tipo);
		} catch (Exception e) {
			 
		}  
		return lstTablaBean;
	}
	 
	@Override
	public List<CatalogoBean> listarComboGeneral(String codTabla)
			throws  ServiceException { 
		List<CatalogoBean> lstTablaBean=null;
		try { 
			lstTablaBean=(List<CatalogoBean>) maestra1DAO.listarComboGeneral(codTabla);
		} catch (Exception e) {
			 
		}  
		return lstTablaBean;
	}
	
}
	
	 
