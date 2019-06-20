package proyect.core.service.implementacion.farmacia.general;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyect.core.bean.asistencial.farmacia.general.AlmacenBean;
import proyect.core.repository.DAOException;
import proyect.core.repository.interfaces.farmacia.general.AlmacenDAO;
import proyect.core.service.exception.ServiceException;
import proyect.core.service.interfaces.farmacia.general.AlmacenService;
 

@Service("AlmacenBeanService")
@Transactional(readOnly = true)
public class AlmacenServiceImpl implements AlmacenService {
	
	
	@Autowired
	private AlmacenDAO AlmacenDAO; 

	public AlmacenServiceImpl() {
	}

	@Override
	public boolean insertar(AlmacenBean AlmacenBean) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getAlmacenDAO().insertar(AlmacenBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean actualizar(AlmacenBean AlmacenBean) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getAlmacenDAO().actualizar(AlmacenBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(AlmacenBean AlmacenBean) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getAlmacenDAO().eliminar(AlmacenBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public AlmacenBean getBuscarPorObjecto(AlmacenBean AlmacenBean) throws ServiceException {
		AlmacenBean oAlmacenBean=null;
		try {
			oAlmacenBean=this.getAlmacenDAO().getBuscarPorObjecto(AlmacenBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oAlmacenBean;
	}
 
	@Override
	public List<AlmacenBean> getBuscarPorFiltros(AlmacenBean AlmacenBean) throws ServiceException {
		List<AlmacenBean> lstAlmacenBean=null;
		try {
			lstAlmacenBean=this.getAlmacenDAO().getBuscarPorFiltros(AlmacenBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return lstAlmacenBean;
	}
 
	@Override
	public boolean existe(AlmacenBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	public AlmacenDAO getAlmacenDAO() {
		return AlmacenDAO;
	}

	public void setAlmacenDAO(AlmacenDAO almacenDAO) {
		AlmacenDAO = almacenDAO;
	}
 

}
