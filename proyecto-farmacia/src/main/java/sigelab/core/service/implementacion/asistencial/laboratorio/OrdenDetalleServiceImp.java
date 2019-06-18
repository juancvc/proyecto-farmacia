package sigelab.core.service.implementacion.asistencial.laboratorio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sigelab.core.bean.asistencial.laboratorio.OrdenDetalleBean;
import sigelab.core.repository.DAOException;
import sigelab.core.repository.interfaces.asistencial.laboratorio.OrdenDetalleDAO;
import sigelab.core.service.exception.ServiceException;
import sigelab.core.service.interfaces.asistencial.laboratorio.OrdenDetalleService; 

@Service("OrdenDetalleService")
@Transactional(readOnly = true)
public class OrdenDetalleServiceImp implements OrdenDetalleService {

	@Autowired
    OrdenDetalleDAO OrdenDetalleDAO;

	@Override
	public boolean insertar(OrdenDetalleBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  OrdenDetalleDAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(OrdenDetalleBean t) throws ServiceException {
	
		Boolean sw = false;
		try {
			sw =  OrdenDetalleDAO.actualizar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(OrdenDetalleBean t) throws ServiceException {
	
		Boolean sw = false;
		try {
			sw =  OrdenDetalleDAO.eliminar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public OrdenDetalleBean getBuscarPorObjecto(OrdenDetalleBean t) throws ServiceException {
	
		return null;
	}

	@Override
	public List<OrdenDetalleBean> getBuscarPorFiltros(OrdenDetalleBean t) throws ServiceException {
		List<OrdenDetalleBean> lstOrdenDetalleBean = null;
		try {
			lstOrdenDetalleBean = OrdenDetalleDAO.getBuscarPorFiltros(t);
		} catch (Exception e) {

		}
		return lstOrdenDetalleBean;
	}

	@Override
	public boolean existe(OrdenDetalleBean t) throws ServiceException {
	
		return false;
	}

	@Override
	public boolean resultadoModificar(OrdenDetalleBean ordenDetalleBean) throws ServiceException {
		// TODO Auto-generated method stub
		Boolean sw = false;
		try {
			sw =  OrdenDetalleDAO.resultadoModificar(ordenDetalleBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public List<OrdenDetalleBean> getBuscarPorFiltrosReporte(OrdenDetalleBean ordenDetalleBean)
			throws ServiceException {
		List<OrdenDetalleBean> lstOrdenDetalleBean = null;
		try {
			lstOrdenDetalleBean = OrdenDetalleDAO.getBuscarPorFiltrosReporte(ordenDetalleBean);
		} catch (Exception e) {

		}
		return lstOrdenDetalleBean;
	}
 

}
