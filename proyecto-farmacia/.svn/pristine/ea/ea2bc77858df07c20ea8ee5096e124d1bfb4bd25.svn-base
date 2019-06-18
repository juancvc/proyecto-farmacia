package hnch.referencia.core.service.implementacion.general;

import hnch.referencia.core.bean.general.PersonaBean;
import hnch.referencia.core.repository.DAOException;
import hnch.referencia.core.repository.interfaces.general.PersonaDAO;
import hnch.referencia.core.service.exception.ServiceException;
import hnch.referencia.core.service.interfaces.general.PersonaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("personaService")
@Transactional (readOnly = true)
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaDAO personaDAO;
	
	
	
	public PersonaDAO getPersonaDAO() {
		return personaDAO;
	}

	public void setPersonaDAO(PersonaDAO personaDAO) {
		this.personaDAO = personaDAO;
	}

	@Override
	public boolean insertar(PersonaBean personaBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  personaDAO.insertar(personaBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(PersonaBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  personaDAO.actualizar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(PersonaBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PersonaBean getBuscarPorObjecto(PersonaBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonaBean> getBuscarPorFiltros(PersonaBean t)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(PersonaBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PersonaBean buscarxTipoDocumentoNumeroDocumento(
			PersonaBean personaBean) throws ServiceException {
		PersonaBean oPersonaBean = null;
		try {
		
			oPersonaBean= personaDAO.buscarxTipoDocumentoNumeroDocumento(personaBean);
		} catch (Exception e) {
			 
		} 
		 
		return oPersonaBean;
	}

	@Override
	public boolean actualizardatosuser(PersonaBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  personaDAO.actualizardatosuser(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizardatosfotouser(PersonaBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  personaDAO.actualizardatosfotouser(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public PersonaBean buscarxTipoDocumentoNumeroDocumentoSigeho(PersonaBean personaBean) throws ServiceException {
		PersonaBean oPersonaBean = null;
		try {
		
			oPersonaBean= personaDAO.buscarxTipoDocumentoNumeroDocumentoSigeho(personaBean);
		} catch (Exception e) {
			 
		} 
		 
		return oPersonaBean;
	}

	@Override
	public boolean insertarPersonaBanco(PersonaBean persona) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  personaDAO.insertarPersonaBanco(persona);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizarPersonaBanco(PersonaBean persona) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  personaDAO.actualizarPersonaBanco(persona);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

}
