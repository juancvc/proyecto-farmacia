package sigelab.core.service.implementacion.asistencial.banco;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sigelab.core.bean.asistencial.banco.SeropositivoBean;
import sigelab.core.repository.DAOException; 
import sigelab.core.service.exception.ServiceException;
import sigelab.core.service.interfaces.asistencial.banco.SeropositivoService;
import sigelab.core.repository.interfaces.asistencial.banco.SeropositivoDAO ;

@Service("SeropositivoServiceImp")
@Transactional(readOnly = true)
public class SeropositivoServiceImp implements SeropositivoService {

	@Autowired
    SeropositivoDAO SeropositivoDAO;

	@Override
	public boolean insertar(SeropositivoBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  SeropositivoDAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(SeropositivoBean t) throws ServiceException {
	
		Boolean sw = false;
		try {
			sw =  SeropositivoDAO.actualizar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(SeropositivoBean t) throws ServiceException {
	
		Boolean sw = false;
		try {
			sw =  SeropositivoDAO.eliminar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public SeropositivoBean getBuscarPorObjecto(SeropositivoBean t) throws ServiceException {
	
		SeropositivoBean oSeropositivoBean = null;
		try {
			oSeropositivoBean = SeropositivoDAO.getBuscarPorObjecto(t);
		} catch (Exception e) {

		}
		return oSeropositivoBean;
	}

	@Override
	public List<SeropositivoBean> getBuscarPorFiltros(SeropositivoBean t) throws ServiceException {
		List<SeropositivoBean> lstSeropositivoBean = null;
		try {
			lstSeropositivoBean = SeropositivoDAO.getBuscarPorFiltros(t);
		} catch (Exception e) {

		}
		return lstSeropositivoBean;
	}

	@Override
	public boolean existe(SeropositivoBean t) throws ServiceException {
	
		return false;
	}

 

}
