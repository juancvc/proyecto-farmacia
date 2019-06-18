package hnch.referencia.core.service.implementacion.asistencial.referencia; 

import hnch.referencia.core.bean.asistencial.referencia.ReferenciaBean;
import hnch.referencia.core.bean.asistencial.referencia.ReferenciaDiagnosticoBean; 
import hnch.referencia.core.repository.DAOException;
import hnch.referencia.core.repository.interfaces.asistencial.referencia.ReferenciaDiagnosticoDAO; 
import hnch.referencia.core.service.exception.ServiceException;
import hnch.referencia.core.service.interfaces.asistencial.referencia.ReferenciaDiagnosticoService; 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("referenciaDiagnosticoService")
@Transactional (readOnly = true)
public class ReferenciaDiagnosticoServiceImpl implements ReferenciaDiagnosticoService {
	
	
	@Autowired
	 private ReferenciaDiagnosticoDAO ReferenciaDiagnosticoDAO;
	
	@Override
	public boolean insertar(ReferenciaDiagnosticoBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  ReferenciaDiagnosticoDAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(ReferenciaDiagnosticoBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  ReferenciaDiagnosticoDAO.actualizar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(ReferenciaDiagnosticoBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  ReferenciaDiagnosticoDAO.eliminar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public ReferenciaDiagnosticoBean getBuscarPorObjecto(ReferenciaDiagnosticoBean t) throws ServiceException {
		ReferenciaDiagnosticoBean oReferenciaDiagnosticoBean = null;
		try {
			oReferenciaDiagnosticoBean = ReferenciaDiagnosticoDAO.getBuscarPorObjecto(t);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oReferenciaDiagnosticoBean;
	}

	@Override
	public List<ReferenciaDiagnosticoBean> getBuscarPorFiltros(ReferenciaDiagnosticoBean t)
			throws ServiceException {
		List<ReferenciaDiagnosticoBean> lstReferenciaDiagnosticoBean =  null;
		try {
			lstReferenciaDiagnosticoBean = this.ReferenciaDiagnosticoDAO.getBuscarPorFiltros(t);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstReferenciaDiagnosticoBean;
	}

	@Override
	public boolean existe(ReferenciaDiagnosticoBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ReferenciaDiagnosticoBean> listarPorReferenciaBean(ReferenciaBean referenciaBean)
			throws ServiceException {
			List<ReferenciaDiagnosticoBean> lstReferenciaDiagnosticoBean =  null;
			try {
				lstReferenciaDiagnosticoBean = this.ReferenciaDiagnosticoDAO.listarPorReferenciaBean(referenciaBean);
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServiceException(e);
			}
			return lstReferenciaDiagnosticoBean;
	} 
	 
}
