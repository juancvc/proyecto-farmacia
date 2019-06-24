package proyect.core.repository.implementacion.general;
  
import java.util.ArrayList;
import java.util.List; 
import javax.persistence.EntityManager; 
import javax.persistence.PersistenceContext; 
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import proyect.core.bean.general.RenaesBean;
import proyect.core.entity.general.Renaes;
import proyect.core.repository.DAOException;
import proyect.core.repository.interfaces.general.RenaesDAO;



@Transactional
@Repository("RenaesBeanDAO")
public class RenaesDAOImpl implements RenaesDAO {

	@PersistenceContext//(unitName="emf")
	private EntityManager em;
	
	@Override
	public boolean insertar(RenaesBean RenaesBean) throws DAOException { 

		//System.out.println("RenaesBean DAO "+RenaesBean);
		Object idPersona= null; 
		Object nroPeriodo= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("renaes.insertar");
			  
			spq.setParameter("AUCDUSCR",  RenaesBean.getUsuarioRegistro());
			spq.setParameter("AUPCIPCR",  RenaesBean.getIpRegistro()); 
				
			spq.execute();
			
			idPersona = spq.getOutputParameterValue(1);
			nroPeriodo = spq.getOutputParameterValue(2);
			if (idPersona != null) {
				RenaesBean.setCodigo(idPersona.toString());
				RenaesBean.setNumeroPeriodo(nroPeriodo.toString());
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
	public boolean actualizar(RenaesBean RenaesBean) throws DAOException {
		//LenguaBean lengua= this.getLenguaBean(objeto);
		System.out.println("em :: " + em);
		System.out.println("RenaesBean DAO "+RenaesBean);
 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("RenaesBean.actualizar");
			 
			spq.setParameter("p_hostmod", RenaesBean.getIpRegistro());

			
			spq.execute();
			
			sw=true;
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public boolean eliminar(RenaesBean t) throws DAOException {
		return false;
	}

	@Override
	public RenaesBean getBuscarPorObjecto(RenaesBean t) throws DAOException {
		return null;
	}

	@Override
	public List<RenaesBean> getBuscarPorFiltros(RenaesBean renaesBean)
			throws DAOException {
		List<Renaes> lstRenae = null;
		List<RenaesBean> lstRenaeBean = null;

		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("Renae.listarPorFiltros");
		spq.setParameter("UBIGEO", renaesBean.getUbiRenaes());
		spq.setParameter("NOMRENEA", renaesBean.getNomRenaes());
		spq.setParameter("CODIGO_DISA", renaesBean.getCodigoDisa());
		
		if (spq.execute()) {
			lstRenae = spq.getResultList();
		}
		if (lstRenae != null && lstRenae.size() > 0) {

			lstRenaeBean = deListaReferenciaAListaReferenciaBean(lstRenae);
		}
		 em.close();

		return lstRenaeBean;
	}

	@Override
	public boolean existe(RenaesBean t) throws DAOException {
		return false;
	} 
	
	private List<RenaesBean> deListaReferenciaAListaReferenciaBean(List<Renaes> lstRenae) {

		List<RenaesBean> lstReferenciaBean = null;

		if (lstRenae != null && lstRenae.size() > 0) {

			lstReferenciaBean = new ArrayList<RenaesBean>();

			for (int i = 0; i < lstRenae.size(); i++) {
				Renaes entity = lstRenae.get(i);
				RenaesBean bean = deRenaeARenaesBean(entity);

				lstReferenciaBean.add(bean);
			}
		}

		return lstReferenciaBean;
	}
	
	private RenaesBean deRenaeARenaesBean(Renaes entity) {
		
		RenaesBean bean = null;
		
		if (entity != null) {
			
			bean = new RenaesBean();
			bean.setProvRenaes(entity.getProvincia());
			bean.setDeptRenaes(entity.getDepartamento());
			bean.setDistrRenaes(entity.getDistrito());
		}
		
		return bean;
	}

	@Override
	public boolean insertarDestinoRenaes(RenaesBean personaBean) throws DAOException {
		return false;
	}

 
}
