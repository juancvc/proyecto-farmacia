package hnch.referencia.core.service.implementacion.asistencial.referencia; 

import hnch.referencia.core.bean.asistencial.referencia.ReferenciaEspecialidadBean; 
import hnch.referencia.core.repository.DAOException;
import hnch.referencia.core.repository.interfaces.asistencial.referencia.ReferenciaEspecialidadDAO; 
import hnch.referencia.core.service.exception.ServiceException;
import hnch.referencia.core.service.interfaces.asistencial.referencia.ReferenciaEspecialidadService; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("referenciaEspecialidadServiceService")
@Transactional (readOnly = true)
public class ReferenciaEspecialidadServiceImpl implements ReferenciaEspecialidadService {
	
	
	@Autowired
	 private ReferenciaEspecialidadDAO referenciaEspecialidadDAO;
	
	@Override
	public boolean insertar(ReferenciaEspecialidadBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  referenciaEspecialidadDAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(ReferenciaEspecialidadBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  referenciaEspecialidadDAO.actualizar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(ReferenciaEspecialidadBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  referenciaEspecialidadDAO.eliminar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public ReferenciaEspecialidadBean getBuscarPorObjecto(ReferenciaEspecialidadBean t) throws ServiceException {
		ReferenciaEspecialidadBean oReferenciaEspecialidadBean = null;
		try {
			oReferenciaEspecialidadBean = referenciaEspecialidadDAO.getBuscarPorObjecto(t);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oReferenciaEspecialidadBean;
	}

	@Override
	public List<ReferenciaEspecialidadBean> getBuscarPorFiltros(ReferenciaEspecialidadBean t)
			throws ServiceException {
		List<ReferenciaEspecialidadBean> lstReferenciaEspecialidadBean =  null;
		try {
			lstReferenciaEspecialidadBean = this.referenciaEspecialidadDAO.getBuscarPorFiltros(t);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstReferenciaEspecialidadBean;
	}

	@Override
	public boolean existe(ReferenciaEspecialidadBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	} 
	 
}
