package hnch.referencia.core.service.implementacion.asistencial.citas;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 
import hnch.referencia.core.bean.asistencial.citas.CitaBean;
import hnch.referencia.core.repository.DAOException;
import hnch.referencia.core.repository.interfaces.asistencial.citas.CitaDAO;
import hnch.referencia.core.service.exception.ServiceException;
import hnch.referencia.core.service.interfaces.asistencial.citas.CitaService; 

@Service("citaService")
@Transactional(readOnly = true)
public class CitaServiceImp implements CitaService {

	@Autowired
	CitaDAO CitaDAO;

	@Override
	public boolean insertar(CitaBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  CitaDAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(CitaBean t) throws ServiceException {
	
		return false;
	}

	@Override
	public boolean eliminar(CitaBean t) throws ServiceException {
	
		return false;
	}

	@Override
	public CitaBean getBuscarPorObjecto(CitaBean t) throws ServiceException {
	
		return null;
	}

	@Override
	public List<CitaBean> getBuscarPorFiltros(CitaBean t) throws ServiceException {
		List<CitaBean> lstCitaBean = null;
		try {
			lstCitaBean = CitaDAO.getBuscarPorFiltros(t);
		} catch (Exception e) {

		}
		return lstCitaBean;
	}

	@Override
	public boolean existe(CitaBean t) throws ServiceException {
	
		return false;
	}

	@Override
	public List<CitaBean> listado(CitaBean cita) {
		List<CitaBean> lstCitaBean = null;
		try {
			lstCitaBean = CitaDAO.listado(cita);
		} catch (Exception e) {

		}
		return lstCitaBean;
	}

 

}
