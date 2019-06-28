package proyect.core.repository.implementacion.Stock;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import proyect.base.repository.DAOException;
import proyect.core.bean.stock.LaboratorioBean;


import proyect.core.repository.interfaces.stock.LaboratorioDAO;


@Transactional
@Repository("LaboratorioDAO")
public class LaboratorioDAOImpl implements LaboratorioDAO{
	
	@PersistenceContext
	private EntityManager em;

	public LaboratorioDAOImpl() {
		
	}

	@Override
	public boolean insertar(LaboratorioBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(LaboratorioBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(LaboratorioBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LaboratorioBean getBuscarPorObjecto(LaboratorioBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LaboratorioBean> getBuscarPorFiltros(LaboratorioBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(LaboratorioBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
 
  
 
}
