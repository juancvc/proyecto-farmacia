package hnch.referencia.core.service.implementacion.asistencial.maestra;

 
import hnch.referencia.core.bean.general.TablaBean;
import hnch.referencia.core.repository.DAOException; 
import hnch.referencia.core.service.exception.ServiceException;
import hnch.referencia.core.service.interfaces.asistencial.maestra.MaestraAsis01Service; 
import hnch.referencia.core.repository.interfaces.asistencial.maestra.MaestraAsis01DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("maestraAsis01Service")
@Transactional (readOnly = true)
public class MaestraAsis01ServiceImp implements MaestraAsis01Service {

	@Autowired
	MaestraAsis01DAO MaestraAsis01DAO;
	@Override
	public boolean insertar(TablaBean t) throws ServiceException {
		
		Boolean sw = false;
		try {
			sw =  MaestraAsis01DAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(TablaBean t) throws ServiceException {
		
		Boolean sw = false;
		try {
			sw =  MaestraAsis01DAO.actualizar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(TablaBean t) throws ServiceException {
		
		Boolean sw = false;
		try {
			sw =  MaestraAsis01DAO.eliminar(t);
			
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
			lstBean =  MaestraAsis01DAO.getBuscarPorFiltros(t);
			
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
			lstTablaBean=(List<TablaBean>) MaestraAsis01DAO.listarPorCodigoTabla(codTabla,tipo);
		} catch (Exception e) {
			 
		}  
		return lstTablaBean;
	}
 

}