package proyect.core.service.implementacion.asistencial.banco;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyect.core.bean.asistencial.banco.LugarCampaniaBean;
import proyect.core.repository.DAOException;
import proyect.core.repository.interfaces.asistencial.banco.LugarCampaniaDAO;
import proyect.core.service.exception.ServiceException;
import proyect.core.service.interfaces.asistencial.banco.LugarCampaniaService;

@Service("LugarCampaniaService")
@Transactional(readOnly = true)
public class LugarCampaniaServiceImp implements LugarCampaniaService {

	@Autowired
    LugarCampaniaDAO LugarCampaniaDAO;

	@Override
	public boolean insertar(LugarCampaniaBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  LugarCampaniaDAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(LugarCampaniaBean t) throws ServiceException {
	
		Boolean sw = false;
		try {
			sw =  LugarCampaniaDAO.actualizar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(LugarCampaniaBean t) throws ServiceException {
	
		Boolean sw = false;
		try {
			sw =  LugarCampaniaDAO.eliminar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public LugarCampaniaBean getBuscarPorObjecto(LugarCampaniaBean t) throws ServiceException {
	
		return null;
	}

	@Override
	public List<LugarCampaniaBean> getBuscarPorFiltros(LugarCampaniaBean t) throws ServiceException {
		List<LugarCampaniaBean> lstLugarCampaniaBean = null;
		try {
			lstLugarCampaniaBean = LugarCampaniaDAO.getBuscarPorFiltros(t);
		} catch (Exception e) {

		}
		return lstLugarCampaniaBean;
	}

	@Override
	public boolean existe(LugarCampaniaBean t) throws ServiceException {
	
		return false;
	}
 

}
