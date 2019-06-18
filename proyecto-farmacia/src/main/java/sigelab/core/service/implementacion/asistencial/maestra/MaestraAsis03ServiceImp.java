package sigelab.core.service.implementacion.asistencial.maestra;

 
import sigelab.core.bean.general.TablaBean;
import sigelab.core.repository.DAOException; 
import sigelab.core.service.exception.ServiceException;
import sigelab.core.service.interfaces.asistencial.maestra.MaestraAsis03Service; 
import sigelab.core.repository.interfaces.asistencial.maestra.MaestraAsis03DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("maestraAsis03Service")
@Transactional (readOnly = true)
public class MaestraAsis03ServiceImp implements MaestraAsis03Service {

	@Autowired
	MaestraAsis03DAO MaestraAsis03DAO;
	@Override
	public boolean insertar(TablaBean t) throws ServiceException {
		
		Boolean sw = false;
		try {
			sw =  MaestraAsis03DAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(TablaBean t) throws ServiceException {
		
		Boolean sw = false;
		try {
			sw =  MaestraAsis03DAO.actualizar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(TablaBean t) throws ServiceException {
		
		Boolean sw = false;
		try {
			sw =  MaestraAsis03DAO.eliminar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public TablaBean getBuscarPorObjecto(TablaBean t)
			throws ServiceException {
		
		return null;
	}

	@Override
	public List<TablaBean> getBuscarPorFiltros(TablaBean t)
			throws ServiceException {
		
		List<TablaBean> lstBean = null;
		try {
			lstBean =  MaestraAsis03DAO.getBuscarPorFiltros(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return lstBean;
	}

	@Override
	public boolean existe(TablaBean t) throws ServiceException {
		
		return false;
	}

	@Override
	public List<TablaBean> listarPorCodigoTabla(String codTabla, int tipo) throws ServiceException {
		List<TablaBean> lstTablaBean=null;
		try { 
			lstTablaBean=(List<TablaBean>) MaestraAsis03DAO.listarPorCodigoTabla(codTabla,tipo);
		} catch (Exception e) {
			 
		}  
		return lstTablaBean;
	}
 

}