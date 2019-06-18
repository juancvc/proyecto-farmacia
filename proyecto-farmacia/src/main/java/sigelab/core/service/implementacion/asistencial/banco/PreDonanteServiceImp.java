package sigelab.core.service.implementacion.asistencial.banco;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sigelab.core.bean.asistencial.banco.PreDonanteBean;
import sigelab.core.entity.asistencial.banco.InterUAL;
import sigelab.core.repository.DAOException; 
import sigelab.core.service.exception.ServiceException;
import sigelab.core.service.interfaces.asistencial.banco.PreDonanteService;
import sigelab.core.repository.interfaces.asistencial.banco.PreDonanteDAO ;

@Service("PreDonanteServiceImp")
@Transactional(readOnly = true)
public class PreDonanteServiceImp implements PreDonanteService {

	@Autowired
    PreDonanteDAO PreDonanteDAO;

	@Override
	public boolean insertar(PreDonanteBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  PreDonanteDAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(PreDonanteBean t) throws ServiceException {
	
		Boolean sw = false;
		try {
			sw =  PreDonanteDAO.actualizar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(PreDonanteBean t) throws ServiceException {
	
		Boolean sw = false;
		try {
			sw =  PreDonanteDAO.eliminar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public PreDonanteBean getBuscarPorObjecto(PreDonanteBean t) throws ServiceException {
	
		PreDonanteBean oPreDonanteBean = null;
		try {
			oPreDonanteBean = PreDonanteDAO.getBuscarPorObjecto(t);
		} catch (Exception e) {

		}
		return oPreDonanteBean;
	}

	@Override
	public List<PreDonanteBean> getBuscarPorFiltros(PreDonanteBean t) throws ServiceException {
		List<PreDonanteBean> lstPreDonanteBean = null;
		try {
			lstPreDonanteBean = PreDonanteDAO.getBuscarPorFiltros(t);
		} catch (Exception e) {

		}
		return lstPreDonanteBean;
	}

	@Override
	public boolean existe(PreDonanteBean t) throws ServiceException {
	
		return false;
	}

	@Override
	public List<PreDonanteBean> litarResultadoFisicoFlebo(PreDonanteBean PreDonanteBean) {
		List<PreDonanteBean> lstPreDonanteBean = null;
		try {
			lstPreDonanteBean = PreDonanteDAO.litarResultadoFisicoFlebo(PreDonanteBean);
		} catch (Exception e) {

		}
		return lstPreDonanteBean;
	}

	@Override
	public boolean insertarIterUal(InterUAL interual) {
		Boolean sw = false;
		try {
			sw =  PreDonanteDAO.insertarIterUal(interual);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sw;
	}

 

}
