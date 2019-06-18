package hnch.referencia.core.repository.implementacion.general;

import hnch.referencia.core.bean.general.PersonalBean;
import hnch.referencia.core.entity.general.Personal;
import hnch.referencia.core.repository.DAOException;
import hnch.referencia.core.repository.interfaces.general.PersonalDAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



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
			spq.setParameter("p_tm1sitper", personal.getSituacion().getCodReg()); 
			spq.setParameter("p_codusureg", personal.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostreg", personal.getIpCreacion());
		
		
			
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
			spq.setParameter("p_codusumod", personal.getCodigoUsuarioCreacion());
			spq.setParameter("p_hostmod", personal.getIpCreacion());
		
		
			
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
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("Personal.buscar_por_filtros");
			spq.setParameter("p_codpersonal", personal.getCodigo());   
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
	/**	
		bean.setCodigo(entity.getnCodPersonal()); 
		bean.getSituacionPersonal().setCodigoRegistro(entity.getnTm1SitPer());
		bean.getCargoPersonal().setCodigoRegistro(entity.getnTm2Cargo());
		bean.getGradoPersonal().setCodigoRegistro(entity.getnTm2Grado());
//		bean.setNombre(entity.getVNomPersonal()); 
		
		bean.getPersonaBean().setCodigo(entity.getnCodPersona());
		bean.getPersonaBean().setNombrePersona(entity.getvNombrePer());
		bean.getPersonaBean().setApellidoPaterno(entity.getvApePatPer());
		bean.getPersonaBean().setApellidoMaterno(entity.getvApeMatPer());
		bean.getPersonaBean().getTipoDocumento().setCodigoRegistro(entity.getnTm1TpDoPe());
		bean.getPersonaBean().setNumeroDocumento(entity.getvNumDocum());
		bean.getPersonaBean().getTipoPersona().setCodigoRegistro(entity.getnTm1TipPer());
		bean.getPersonaBean().setCodigoUbigeo(entity.getvCodUbigeo());
		bean.getPersonaBean().setDireccionPersona(entity.getvDirecPers());
		bean.getPersonaBean().getSituacionPersona().setCodigoRegistro(entity.getnTm1SitPersona());
		bean.getPersonaBean().setFechaNac(entity.getdFechNacim());
		bean.getPersonaBean().getNacionalidad().setCodigoRegistro(entity.getnTm2Pais());
		bean.getPersonaBean().getEstadoCivil().setCodigoRegistro(entity.getnTm2EstCiv());
		bean.getPersonaBean().getSexo().setCodigoRegistro(entity.getnTm2Sexo());
		bean.getPersonaBean().getLenguaBean().setCodigo(entity.getvCodLengua());
		bean.getPersonaBean().setTelefono(entity.getvTelefono());
		bean.getPersonaBean().setCorreo(entity.getvCorreo());
		bean.getPersonaBean().getTipoPersona().setNombreCorto(entity.getvNomPerfil());
		bean.getSituacionPersonal().setNombreCorto(entity.getvNombreTm1SitPer());
		
		if (entity.getvCodUbigeo() != null) {
			bean.getPersonaBean().getUbigeoBean().setCodigoRegion(""+entity.getvCodUbigeo().charAt(0)+entity.getvCodUbigeo().charAt(1));
			bean.getPersonaBean().getUbigeoBean().setCodigoProvincia(""+entity.getvCodUbigeo().charAt(2)+entity.getvCodUbigeo().charAt(3));
			bean.getPersonaBean().getUbigeoBean().setCodigoDistrito(""+entity.getvCodUbigeo().charAt(4)+entity.getvCodUbigeo().charAt(5));
		}*/
	}
	
	return bean;
}



	@Override
	public boolean existe(PersonalBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

}
