package proyect.core.service.implementacion.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyect.core.bean.general.PersonalBean;
import proyect.core.repository.interfaces.general.PersonalDAO;
import proyect.base.repository.DAOException;
import proyect.base.service.ServiceException;
import proyect.core.service.interfaces.general.PersonalService;


@Service("personalService")
@Transactional (readOnly = true)
public class PersonalServiceImpl implements PersonalService {

	@Autowired
	private PersonalDAO personalDAO;
	
	
	
	public PersonalDAO getPersonalDAO() {
		return personalDAO;
	}

	public void setPersonalDAO(PersonalDAO personalDAO) {
		this.personalDAO = personalDAO;
	}

	@Override
	public boolean insertar(PersonalBean personalBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  personalDAO.insertar(personalBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(PersonalBean personalBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  personalDAO.actualizar(personalBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(PersonalBean personalBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  personalDAO.eliminar(personalBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public PersonalBean getBuscarPorObjecto(PersonalBean personal)
			throws ServiceException {
		PersonalBean oPersonalBean = null;
		try {
			oPersonalBean = personalDAO.getBuscarPorObjecto(personal);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oPersonalBean;
	}

	@Override
	public List<PersonalBean> getBuscarPorFiltros(PersonalBean personal)
			throws ServiceException {
		List<PersonalBean> lstPersonal=null;
		try { 
			lstPersonal=(List<PersonalBean>) personalDAO.getBuscarPorFiltros(personal);
		} catch (Exception e) {
			 
		} 
		 
		return lstPersonal;
	}

	@Override
	public boolean existe(PersonalBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

}
