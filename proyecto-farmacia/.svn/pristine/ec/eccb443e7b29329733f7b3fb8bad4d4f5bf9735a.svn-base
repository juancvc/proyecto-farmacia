package hnch.referencia.core.service.implementacion.asistencial.referencia; 

import hnch.referencia.core.bean.asistencial.referencia.ReferenciaApoyoDxBean;
import hnch.referencia.core.bean.asistencial.referencia.ReferenciaBean;
import hnch.referencia.core.repository.DAOException;
import hnch.referencia.core.repository.interfaces.asistencial.referencia.ReferenciaApoyoDXDAO; 
import hnch.referencia.core.service.exception.ServiceException;
import hnch.referencia.core.service.interfaces.asistencial.referencia.ReferenciaApoyoDxService; 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("referenciaApoyoDXService")
@Transactional (readOnly = true)
public class ReferenciaApoyoDxServiceImpl implements ReferenciaApoyoDxService {
	
	
	@Autowired
	 private ReferenciaApoyoDXDAO ReferenciaApoyoDXDAO;
	
	@Override
	public boolean insertar(ReferenciaApoyoDxBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  ReferenciaApoyoDXDAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(ReferenciaApoyoDxBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  ReferenciaApoyoDXDAO.actualizar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(ReferenciaApoyoDxBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  ReferenciaApoyoDXDAO.eliminar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public ReferenciaApoyoDxBean getBuscarPorObjecto(ReferenciaApoyoDxBean t) throws ServiceException {
		ReferenciaApoyoDxBean oReferenciaApoyoDxBean = null;
		try {
			oReferenciaApoyoDxBean = ReferenciaApoyoDXDAO.getBuscarPorObjecto(t);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oReferenciaApoyoDxBean;
	}

	@Override
	public List<ReferenciaApoyoDxBean> getBuscarPorFiltros(ReferenciaApoyoDxBean t)
			throws ServiceException {
		List<ReferenciaApoyoDxBean> lstReferenciaApoyoDxBean =  null;
		try {
			lstReferenciaApoyoDxBean = this.ReferenciaApoyoDXDAO.getBuscarPorFiltros(t);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstReferenciaApoyoDxBean;
	}

	@Override
	public boolean existe(ReferenciaApoyoDxBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ReferenciaApoyoDxBean> listarPorReferenciaBean(ReferenciaBean referenciaBean) throws ServiceException {
		List<ReferenciaApoyoDxBean> lstReferenciaApoyoDxBean =  null;
		try {
			lstReferenciaApoyoDxBean = this.ReferenciaApoyoDXDAO.listarPorReferenciaBean(referenciaBean);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstReferenciaApoyoDxBean;
	} 
	 
}
