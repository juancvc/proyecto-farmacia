package hnch.referencia.core.service.implementacion.asistencial.referencia; 

import hnch.referencia.core.bean.asistencial.referencia.ReferenciaApoyoDxResultadoBean;
import hnch.referencia.core.bean.asistencial.referencia.ReferenciaBean;
import hnch.referencia.core.repository.DAOException;
import hnch.referencia.core.repository.interfaces.asistencial.referencia.ReferenciaApoyoDxResultadoDAO; 
import hnch.referencia.core.service.exception.ServiceException;
import hnch.referencia.core.service.interfaces.asistencial.referencia.ReferenciaApoyoDxResultadoService;
import hnch.referencia.core.service.interfaces.asistencial.referencia.ReferenciaApoyoDxService; 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("referenciaApoyoResultadoDXService")
@Transactional (readOnly = true)
public class ReferenciaApoyoDxResultadoServiceImpl implements ReferenciaApoyoDxResultadoService{
	
	
	@Autowired
	 private ReferenciaApoyoDxResultadoDAO ReferenciaApoyoDxResultadoDAO;
	
	@Override
	public boolean insertar(ReferenciaApoyoDxResultadoBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  ReferenciaApoyoDxResultadoDAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(ReferenciaApoyoDxResultadoBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  ReferenciaApoyoDxResultadoDAO.actualizar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(ReferenciaApoyoDxResultadoBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  ReferenciaApoyoDxResultadoDAO.eliminar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public ReferenciaApoyoDxResultadoBean getBuscarPorObjecto(ReferenciaApoyoDxResultadoBean t) throws ServiceException {
		ReferenciaApoyoDxResultadoBean oReferenciaApoyoDxResultadoBean = null;
		try {
			oReferenciaApoyoDxResultadoBean = ReferenciaApoyoDxResultadoDAO.getBuscarPorObjecto(t);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oReferenciaApoyoDxResultadoBean;
	}

	@Override
	public List<ReferenciaApoyoDxResultadoBean> getBuscarPorFiltros(ReferenciaApoyoDxResultadoBean t)
			throws ServiceException {
		List<ReferenciaApoyoDxResultadoBean> lstReferenciaApoyoDxResultadoBean =  null;
		try {
			lstReferenciaApoyoDxResultadoBean = this.ReferenciaApoyoDxResultadoDAO.getBuscarPorFiltros(t);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstReferenciaApoyoDxResultadoBean;
	}

	@Override
	public boolean existe(ReferenciaApoyoDxResultadoBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ReferenciaApoyoDxResultadoBean> listarPorReferenciaBean(ReferenciaBean referenciaBean)
			throws ServiceException {
		List<ReferenciaApoyoDxResultadoBean> lstReferenciaApoyoDxResultadoBean =  null;
		try {
			lstReferenciaApoyoDxResultadoBean = this.ReferenciaApoyoDxResultadoDAO.listarPorReferenciaBean(referenciaBean);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstReferenciaApoyoDxResultadoBean;
	} 
	 
}
