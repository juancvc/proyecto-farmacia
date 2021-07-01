package proyect.core.repository.implementacion.general;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import proyect.base.repository.DAOException;
import proyect.core.bean.general.TurnoBean;
import proyect.core.entity.general.Turno;
import proyect.core.repository.interfaces.general.TurnoDAO;
import proyect.web.utilitarios.VO; 

@Transactional
@Repository("turnoDAO")
public class TurnoDAOImpl implements TurnoDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(TurnoBean turno) throws DAOException {
		Object idTurno= null;
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("turno.insert");
		 
			spq.setParameter("nombreTurno", turno.getNombreTurno());
			spq.setParameter("horaInicio", turno.getHoraInicio());
			spq.setParameter("horaTermino", turno.getHoraTermino());
			spq.setParameter("usuarioRegistro", turno.getUsuarioRegistro());
			spq.setParameter("ipRegistro", turno.getIpRegistro());
			spq.execute();
			
			idTurno = spq.getOutputParameterValue(1);
			if (VO.isNotNull(idTurno)) {
				turno.setCodigo(idTurno.toString());
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
	public boolean actualizar(TurnoBean turno) throws DAOException {
		boolean sw=true;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("turno.update");
			
			spq.setParameter("idTurno",    			turno.getCodigo());
			spq.setParameter("nombreTurno", 		turno.getNombreTurno());
			spq.setParameter("horaInicio", 			turno.getHoraInicio());
			spq.setParameter("horaTermino", 		turno.getHoraTermino());
			spq.setParameter("usuarioModificacion", turno.getUsuarioRegistro());
			spq.setParameter("ipModificacion",      turno.getIpRegistro());
	
			spq.execute();
			
			em.close();
			
		} catch (Exception e) {
			sw=false;
			throw new DAOException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(TurnoBean turno) throws DAOException {
		boolean sw=true;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("turno.delete");
			spq.setParameter("idTurno",    		turno.getCodigo());
			spq.setParameter("usuarioModificacion", turno.getUsuarioRegistro());
			spq.setParameter("ipModificacion",      turno.getIpRegistro());
			spq.execute();

			em.close();
			
		} catch (Exception e) {
			sw=false;
			throw new DAOException(e);
		}
		return sw;
	}

	@Override
	public TurnoBean getBuscarPorObjecto(TurnoBean turno) throws DAOException {
		List<Turno> lstTurno = null;	
	   TurnoBean lstTurnoBean = null;
		
	   System.out.println("turno.getCodigo() " + turno.getCodigo());
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("turno.buscarPorObjeto");  
			spq.setParameter("idTurno", turno.getCodigo()); 
			
			 if (spq.execute()) {
				 lstTurno =  spq.getResultList(); 
			 }
			 
			if (lstTurno != null && lstTurno.size() > 0) {
				lstTurnoBean = deObjetoAObjetoBean(lstTurno.get(0));
			 }
			
			em.close();
			
		   
		return lstTurnoBean;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TurnoBean> getBuscarPorFiltros(TurnoBean turno)
			throws DAOException {
		
		List<Turno> lstTurno = null;	
		List<TurnoBean> lstTurnoBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("turno.buscarPorFiltros");  
			spq.setParameter("nombreTurno", turno.getNombreTurno()); 
			
			 if (spq.execute()) {
				 lstTurno =  spq.getResultList(); 
			 }
			 
			if (lstTurno != null && lstTurno.size() > 0) {
				lstTurnoBean = deListaObjetoAListaObjetoBean(lstTurno);
			 }
			
			em.close();
			
		   
		return lstTurnoBean;
	}
 

private List<TurnoBean> deListaObjetoAListaObjetoBean(List<Turno> lstTurno) {
		
		List<TurnoBean> lstTurnoBean = null;
		
		if (lstTurno != null && lstTurno.size() > 0) {
			
			lstTurnoBean = new ArrayList<TurnoBean>();
			
			for (int i = 0; i < lstTurno.size(); i++) { 
				Turno entity = lstTurno.get(i);
				TurnoBean bean = deObjetoAObjetoBean(entity);
				
				lstTurnoBean.add(bean);
			}
		}
		
		return lstTurnoBean;
	}
	
	private TurnoBean deObjetoAObjetoBean(Turno entity) {
		
		TurnoBean bean = null; 
		if (entity != null) {
			
			bean = new TurnoBean();
			bean.setCodigo(entity.getIdTurno());   
			bean.setNombreTurno(entity.getNombreTurno());
			bean.setHoraInicio(entity.getHoraInicio());
			bean.setHoraTermino(entity.getHoraTermino());
	 	}
		
		return bean;
	}

	@Override
	public boolean existe(TurnoBean t) throws DAOException {
		return false;
	}


}
