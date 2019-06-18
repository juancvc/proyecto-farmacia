package hnch.referencia.core.service.implementacion.asistencial.referencia; 

import hnch.referencia.core.bean.asistencial.referencia.ReferenciaBean; 
import hnch.referencia.core.repository.DAOException;
import hnch.referencia.core.repository.interfaces.asistencial.referencia.ReferenciaCbDAO; 
import hnch.referencia.core.service.exception.ServiceException;
import hnch.referencia.core.service.interfaces.asistencial.referencia.ReferenciaCbService; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("referenciaCBServiceService")
@Transactional (readOnly = true)
public class ReferenciaCabServiceImpl implements ReferenciaCbService {
	
	
	@Autowired
	 private ReferenciaCbDAO referenciaCbDAO;
	
	@Override
	public boolean insertar(ReferenciaBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  referenciaCbDAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(ReferenciaBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  referenciaCbDAO.actualizar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(ReferenciaBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  referenciaCbDAO.eliminar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public ReferenciaBean getBuscarPorObjecto(ReferenciaBean t) throws ServiceException {
		ReferenciaBean oReferenciaBean = null;
		try {
			oReferenciaBean = referenciaCbDAO.getBuscarPorObjecto(t);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oReferenciaBean;
	}

	@Override
	public List<ReferenciaBean> getBuscarPorFiltros(ReferenciaBean t)
			throws ServiceException {
		List<ReferenciaBean> lstReferenciaBean =  null;
		try {
			lstReferenciaBean = this.referenciaCbDAO.getBuscarPorFiltros(t);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstReferenciaBean;
	}

	@Override
	public boolean existe(ReferenciaBean t) throws ServiceException { 
		return false;
	}

	@Override
	public List<ReferenciaBean> listaEstadistico(ReferenciaBean referenciaBean) throws ServiceException {
		List<ReferenciaBean> lstReferenciaBean =  null;
		try {
			lstReferenciaBean = this.referenciaCbDAO.listaEstadistico(referenciaBean);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstReferenciaBean;
	}

	@Override
	public List<ReferenciaBean> listarPendienteCitas(ReferenciaBean referenciaBean) throws ServiceException {
		List<ReferenciaBean> lstReferenciaBean =  null;
		try {
			lstReferenciaBean = this.referenciaCbDAO.listarPendienteCitas(referenciaBean);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstReferenciaBean;
	} 
	 
}
