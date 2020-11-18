package proyect.core.service.implementacion.general;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyect.core.bean.general.SerieBean;
import proyect.core.repository.interfaces.general.SerieDAO;
import proyect.core.service.interfaces.general.SerieService;
import proyect.base.repository.DAOException;
import proyect.base.service.ServiceException;
 

@Service("serieBeanService")
@Transactional(readOnly = true)
public class SerieServiceImpl implements SerieService {
	
	
	@Autowired
	private SerieDAO SerieDAO; 

	public SerieServiceImpl() {
	}

	@Override
	public boolean insertar(SerieBean SerieBean) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getSerieDAO().insertar(SerieBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean actualizar(SerieBean SerieBean) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getSerieDAO().actualizar(SerieBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(SerieBean SerieBean) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getSerieDAO().eliminar(SerieBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public SerieBean getBuscarPorObjecto(SerieBean SerieBean) throws ServiceException {
		SerieBean oSerieBean=null;
		try {
			oSerieBean=this.getSerieDAO().getBuscarPorObjecto(SerieBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oSerieBean;
	}
 
	@Override
	public List<SerieBean> getBuscarPorFiltros(SerieBean SerieBean) throws ServiceException {
		List<SerieBean> lstSerieBean=null;
		try {
			lstSerieBean=this.getSerieDAO().getBuscarPorFiltros(SerieBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return lstSerieBean;
	}
 
	@Override
	public boolean existe(SerieBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	public SerieDAO getSerieDAO() {
		return SerieDAO;
	}

	public void setSerieDAO(SerieDAO almacenDAO) {
		SerieDAO = almacenDAO;
	}
 

}
