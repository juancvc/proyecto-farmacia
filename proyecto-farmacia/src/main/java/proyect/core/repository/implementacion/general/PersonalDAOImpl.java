package proyect.core.repository.implementacion.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import proyect.base.repository.DAOException;
import proyect.core.bean.general.PersonalBean;
import proyect.core.entity.general.Personal;
import proyect.core.repository.interfaces.general.PersonalDAO;



@Transactional
@Repository("personalDAO")
public class PersonalDAOImpl implements PersonalDAO {
	
	@PersistenceContext//(unitName="emf")
	private EntityManager em;

	@Override
	public boolean insertar(PersonalBean personal) throws DAOException {
		//LenguaBean lengua= this.getLenguaBean(objeto);
		System.out.println("em :: " + em);
		System.out.println("personal DAO "+personal);
		Object idpersonal= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("Personal.insertar");
			
//			spq.setParameter("p_codpersonal", personal.getCodigo());
			spq.setParameter("p_codpersona", personal.getCodigo()); 
		
		
			
			spq.execute();
			
			idpersonal = spq.getOutputParameterValue(1);
			if (idpersonal != null) { 
				sw=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public boolean actualizar(PersonalBean personal) throws DAOException {
		//LenguaBean lengua= this.getLenguaBean(objeto);
		System.out.println("em :: " + em);
		System.out.println("personal DAO "+personal);
		Object idpersonal= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("Personal.actualizar");
			
			 
		
		
			
			spq.execute();
			sw=true;
//			idpersonal = spq.getOutputParameterValue(1);
//			if (idpersonal != null) {
//				personal.setCodigo(Integer.valueOf(idpersonal.toString()));
//				sw=true;
//			}
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public boolean eliminar(PersonalBean personal) throws DAOException {
		//LenguaBean lengua= this.getLenguaBean(objeto);
		System.out.println("em :: " + em);
		System.out.println("personal DAO "+personal);
//		Object idpersonal= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("Personal.eliminar");
		
			spq.setParameter("p_codpersonal", personal.getCodigo()); 
		
		
			
			spq.execute();
			sw=true;
//			idpersonal = spq.getOutputParameterValue(1);
//			if (idpersonal != null) {
//				personal.setCodigo(Integer.valueOf(idpersonal.toString()));
//				sw=true;
//			}
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public PersonalBean getBuscarPorObjecto(PersonalBean personal) throws DAOException { 
		List<Personal> lstPersonal = null;	
		PersonalBean oPersonaBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("Personal.buscar_por_codigo");
			spq.setParameter("p_codpersonal", personal.getCodigo()); 
			
			if (spq.execute()) {
				lstPersonal =  spq.getResultList(); 
			} 
			if (lstPersonal != null && lstPersonal.size() > 0) {
				
				oPersonaBean = dePersonalAPersonalBean(lstPersonal.get(0));
			}
			//em.close();
			
		   
		return oPersonaBean;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PersonalBean> getBuscarPorFiltros(PersonalBean personal)
			throws DAOException { 
		List<Personal> lstPersonal = null;	
		List<PersonalBean> lstPersonalBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("personal.buscarxCriterios");
			spq.setParameter("apellidoPaterno", personal.getPersona().getApellidoPaterno());   
			spq.setParameter("nombres", personal.getPersona().getNombres());   
			if (spq.execute()) {
				lstPersonal =  spq.getResultList(); 
			} 
			if (lstPersonal != null && lstPersonal.size() > 0) {
				
				lstPersonalBean = deListaPersonalAListaPersonalBean(lstPersonal);
			}
			//em.close();
			
		   
		return lstPersonalBean;
	}

	
private List<PersonalBean> deListaPersonalAListaPersonalBean(List<Personal> lstHorarioExcepcion) {
		
		List<PersonalBean> lstHorarioExcepcionBean = null;
		
		if (lstHorarioExcepcion != null && lstHorarioExcepcion.size() > 0) {
			
			lstHorarioExcepcionBean = new ArrayList<PersonalBean>();
			
			for (int i = 0; i < lstHorarioExcepcion.size(); i++) { 
				Personal entity = lstHorarioExcepcion.get(i);
				PersonalBean bean = dePersonalAPersonalBean(entity);
				
				lstHorarioExcepcionBean.add(bean);
			}
		}
		
		return lstHorarioExcepcionBean;
	}
	
	
private PersonalBean dePersonalAPersonalBean(Personal entity) {
	
	PersonalBean bean = null;
	
	if (entity != null) {
		
		bean = new PersonalBean();
	 	
		bean.setCodigo(entity.getIdPersonal()); 
		bean.getPersona().setCodigo(entity.getIdPersona());
		bean.getPersona().setNombres(entity.getNombres());
		bean.getPersona().setApellidoPaterno(entity.getApellidoPaterno());
		bean.getPersona().setApellidoMaterno(entity.getApellidoMaterno()); 
	 
	}
	
	return bean;
}



	@Override
	public boolean existe(PersonalBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

}
