package proyect.core.repository.implementacion.stock;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import proyect.base.repository.DAOException;
import proyect.core.bean.stock.LaboratorioBean;
import proyect.core.entity.stock.Laboratorio;
import proyect.core.repository.interfaces.stock.LaboratorioDAO;
import proyect.web.utilitarios.VO;


@Transactional
@Repository("LaboratorioDAO")
public class LaboratorioDAOImpl implements LaboratorioDAO{
	
	@PersistenceContext
	private EntityManager em;

	public LaboratorioDAOImpl() {
		
	}

	@Override
	public boolean insertar(LaboratorioBean laboratorioBean) throws DAOException {
		Object idLaboratorio= null;
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("laboratorio.insert");
		 
			spq.setParameter("nombreLaboratorio", laboratorioBean.getNombre());
			spq.setParameter("descripcion", 	  laboratorioBean.getDescripcion());
			spq.setParameter("ruc", 	   		  laboratorioBean.getRuc());
			spq.setParameter("usuarioRegistro",   laboratorioBean.getUsuarioRegistro());
			spq.setParameter("ipRegistro", 		  laboratorioBean.getIpRegistro());
			spq.execute();
			
			idLaboratorio = spq.getOutputParameterValue(1);
			if (VO.isNotNull(idLaboratorio)) {
				laboratorioBean.setCodigo(idLaboratorio.toString());
				sw=true;
			}
			em.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			sw=false;
			throw new DAOException(e);
		}
		return sw;
	}

	@Override
	public boolean actualizar(LaboratorioBean laboratorioBean) throws DAOException {
		boolean sw=true;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("laboratorio.update");
			
			spq.setParameter("idLaboratorio",    		laboratorioBean.getCodigo());
			spq.setParameter("nombreLaboratorio", 		laboratorioBean.getNombre());
			spq.setParameter("descripcion", 	   		laboratorioBean.getDescripcion());
			spq.setParameter("ruc", 	   				laboratorioBean.getRuc());
			spq.setParameter("usuarioModificacion",     laboratorioBean.getUsuarioModificacion());
			spq.setParameter("ipModificacion", 		    laboratorioBean.getIpModificacion());
	
			spq.execute();
			
			em.close();
			
		} catch (Exception e) {
			sw=false;
			throw new DAOException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(LaboratorioBean laboratorioBean) throws DAOException {
		boolean sw=true;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("laboratorio.delete");
			spq.setParameter("idLaboratorio",    		laboratorioBean.getCodigo());
			spq.execute();

			em.close();
			
		} catch (Exception e) {
			sw=false;
			throw new DAOException(e);
		}
		return sw;
	}

	@Override
	public LaboratorioBean getBuscarPorObjecto(LaboratorioBean laboratorioBean) throws DAOException {
		List<Laboratorio> lstLaboratorio = null;	
		LaboratorioBean   lstLaboratorioBean = null;

				StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("laboratorio.findByObject");  
				spq.setParameter("idLaboratorio", laboratorioBean.getCodigo()); 
				
				 if (spq.execute()) {
					 lstLaboratorio =  spq.getResultList(); 
				 }
				 
				if (lstLaboratorio != null && lstLaboratorio.size() > 0) {
					lstLaboratorioBean = deObjetoAObjetoBean(lstLaboratorio.get(0));
				 }
				
				em.close();
				
			   
			return lstLaboratorioBean;
	}

	@Override
	public List<LaboratorioBean> getBuscarPorFiltros(LaboratorioBean laboratorioBean) throws DAOException {
		List<Laboratorio> lstLaboratorio = null;	
		List<LaboratorioBean> lstArticuloBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("laboratorio.buscarPorFiltros");  
			spq.setParameter("nombreLaboratorio", laboratorioBean.getNombre()); 
			spq.setParameter("descripcion", laboratorioBean.getDescripcion());
			 if (spq.execute()) {
				 lstLaboratorio =  spq.getResultList(); 
			 }
			 
			if (lstLaboratorio != null && lstLaboratorio.size() > 0) {
				lstArticuloBean = deListaObjetoAListaObjetoBean(lstLaboratorio);
			 }
			
			em.close();
			
		   
		return lstArticuloBean;
	}

	@Override
	public boolean existe(LaboratorioBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	
private List<LaboratorioBean> deListaObjetoAListaObjetoBean(List<Laboratorio> lstLaboratorio) {
		
		List<LaboratorioBean> lstLaboratorioBean = null;
		
		if (lstLaboratorio != null && lstLaboratorio.size() > 0) {
			
			lstLaboratorioBean = new ArrayList<LaboratorioBean>();
			
			for (int i = 0; i < lstLaboratorio.size(); i++) { 
				Laboratorio entity = lstLaboratorio.get(i);
				LaboratorioBean bean = deObjetoAObjetoBean(entity);
				
				lstLaboratorioBean.add(bean);
			}
		}
		
		return lstLaboratorioBean;
	}
	
	
private LaboratorioBean deObjetoAObjetoBean(Laboratorio entity) {
		
		LaboratorioBean bean = null; 
		if (entity != null) {
			
			bean = new LaboratorioBean();
			bean.setCodigo(entity.getIdLaboratorio());   
			bean.setNombre(entity.getNombreLaboratorio());
			bean.setDescripcion(entity.getDescripcion());
			bean.setDireccion(entity.getDireccion());
			bean.setUsuarioRegistro(entity.getUsuarioRegistro());
			bean.setIpRegistro(entity.getIpRegistro());
			bean.setRuc(entity.getRuc());
		
	 	}
		
		return bean;
	}
	
 
  
 
}
