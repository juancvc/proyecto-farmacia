package proyect.core.service.implementacion.general;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyect.core.bean.general.TurnoBean;
import proyect.core.repository.interfaces.general.TurnoDAO;
import proyect.core.service.interfaces.general.TurnoService;
import proyect.base.repository.DAOException;
import proyect.base.service.ServiceException;
 

@Service("TurnoBeanService")
@Transactional(readOnly = true)
public class TurnoServiceImpl implements TurnoService {
	
	
	@Autowired
	private TurnoDAO TurnoDAO; 

	public TurnoServiceImpl() {
	}

	@Override
	public boolean insertar(TurnoBean TurnoBean) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getTurnoDAO().insertar(TurnoBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean actualizar(TurnoBean TurnoBean) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getTurnoDAO().actualizar(TurnoBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(TurnoBean TurnoBean) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getTurnoDAO().eliminar(TurnoBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public TurnoBean getBuscarPorObjecto(TurnoBean TurnoBean) throws ServiceException {
		TurnoBean oTurnoBean=null;
		try {
			oTurnoBean=this.getTurnoDAO().getBuscarPorObjecto(TurnoBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oTurnoBean;
	}
 
	@Override
	public List<TurnoBean> getBuscarPorFiltros(TurnoBean TurnoBean) throws ServiceException {
		List<TurnoBean> lstTurnoBean=null;
		try {
			lstTurnoBean=this.getTurnoDAO().getBuscarPorFiltros(TurnoBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return lstTurnoBean;
	}
 
	@Override
	public boolean existe(TurnoBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	public TurnoDAO getTurnoDAO() {
		return TurnoDAO;
	}

	public void setTurnoDAO(TurnoDAO turnoDAO) {
		TurnoDAO = turnoDAO;
	}
 

}
