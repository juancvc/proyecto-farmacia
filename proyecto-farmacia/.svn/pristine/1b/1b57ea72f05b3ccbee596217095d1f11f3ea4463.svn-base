package hnch.referencia.core.service.implementacion.asistencial.banco;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import hnch.referencia.core.bean.asistencial.banco.DonanteBean;
import hnch.referencia.core.repository.DAOException; 
import hnch.referencia.core.service.exception.ServiceException;
import hnch.referencia.core.service.interfaces.asistencial.banco.DonanteService;
import hnch.referencia.core.repository.interfaces.asistencial.banco.DonanteDAO ;

@Service("DonanteServiceImp")
@Transactional(readOnly = true)
public class DonanteServiceImp implements DonanteService {

	@Autowired
    DonanteDAO DonanteDAO;

	@Override
	public boolean insertar(DonanteBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  DonanteDAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(DonanteBean t) throws ServiceException {
	
		Boolean sw = false;
		try {
			sw =  DonanteDAO.actualizar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(DonanteBean t) throws ServiceException {
	
		Boolean sw = false;
		try {
			sw =  DonanteDAO.eliminar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public DonanteBean getBuscarPorObjecto(DonanteBean t) throws ServiceException {
	
		return null;
	}

	@Override
	public List<DonanteBean> getBuscarPorFiltros(DonanteBean t) throws ServiceException {
		List<DonanteBean> lstDonanteBean = null;
		try {
			lstDonanteBean = DonanteDAO.getBuscarPorFiltros(t);
		} catch (Exception e) {

		}
		return lstDonanteBean;
	}

	@Override
	public boolean existe(DonanteBean t) throws ServiceException {
	
		return false;
	}

	@Override
	public DonanteBean buscarUltimaDonacion(DonanteBean DonanteBean) {
		DonanteBean oDonanteBean = null;
		try {
			oDonanteBean = DonanteDAO.buscarUltimaDonacion(DonanteBean);
		} catch (Exception e) {

		}
		return oDonanteBean;
	}

	@Override
	public boolean insertarVoluntario(DonanteBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  DonanteDAO.insertarVoluntario(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}
 

}
