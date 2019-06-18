package sigelab.core.service.implementacion.asistencial.maestra;

 
import sigelab.core.bean.general.TablaBean;
import sigelab.core.repository.DAOException; 
import sigelab.core.service.exception.ServiceException; 
import sigelab.core.service.interfaces.asistencial.maestra.MaestraPreguntaBanc02Service; 
import sigelab.core.repository.interfaces.asistencial.maestra.MaestraPreguntaBanc02DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("MaestraPreguntaBanc01Service")
@Transactional (readOnly = true)
public class MaestraPreguntaBanc01ServiceImp implements MaestraPreguntaBanc02Service{

	@Autowired
	MaestraPreguntaBanc02DAO MaestraBanc02DAO;
	
	@Override
	public boolean insertar(TablaBean t) throws ServiceException {
		
		Boolean sw = false;
		try {
			sw =  MaestraBanc02DAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(TablaBean t) throws ServiceException {
		
		Boolean sw = false;
		try {
			sw =  MaestraBanc02DAO.actualizar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(TablaBean t) throws ServiceException {
		
		Boolean sw = false;
		try {
			sw =  MaestraBanc02DAO.eliminar(t);
			
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
			lstBean =  MaestraBanc02DAO.getBuscarPorFiltros(t);
			
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
			lstTablaBean=(List<TablaBean>) MaestraBanc02DAO.listarPorCodigoTabla(codTabla,tipo);
		} catch (Exception e) {
			 
		}  
		return lstTablaBean;
	}

	@Override
	public List<TablaBean> listarPreguntasPorSexo(String valgen01) throws ServiceException {
		List<TablaBean> lstTablaBean=null;
		try { 
			lstTablaBean=(List<TablaBean>) MaestraBanc02DAO.listarPreguntasPorSexo(valgen01);
		} catch (Exception e) {
			 
		}  
		return lstTablaBean;
	}
 

}