package hnch.referencia.core.repository.implementacion.general;
  
import hnch.referencia.core.bean.general.RenaesBean;  
import hnch.referencia.core.entity.general.Renae;
import hnch.referencia.core.repository.DAOException;
import hnch.referencia.core.repository.interfaces.general.RenaesDAO; 
import java.util.ArrayList;
import java.util.List; 
import javax.persistence.EntityManager; 
import javax.persistence.PersistenceContext; 
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



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
			 
			spq.setParameter("CODORGAN",  RenaesBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI",  RenaesBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI",  RenaesBean.getCodigoSede());
			  
			spq.setParameter("AUCDUSCR",  RenaesBean.getCodigoUsuarioCreacion());
			spq.setParameter("AUPCIPCR",  RenaesBean.getIpCreacion()); 
				
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
			 
			spq.setParameter("p_hostmod", RenaesBean.getIpCreacion());

			
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RenaesBean getBuscarPorObjecto(RenaesBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RenaesBean> getBuscarPorFiltros(RenaesBean renaesBean)
			throws DAOException {
		List<Renae> lstRenae = null;
		List<RenaesBean> lstRenaeBean = null;

		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("Renae.listarPorFiltros");
		spq.setParameter("UBIGEO", renaesBean.getUbiRenaes());
		spq.setParameter("NOMRENEA", renaesBean.getNomRenaes());
		spq.setParameter("TG14CATE", renaesBean.getCategoria().getCodReg());
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
		// TODO Auto-generated method stub
		return false;
	} 
	
	private List<RenaesBean> deListaReferenciaAListaReferenciaBean(List<Renae> lstRenae) {

		List<RenaesBean> lstReferenciaBean = null;

		if (lstRenae != null && lstRenae.size() > 0) {

			lstReferenciaBean = new ArrayList<RenaesBean>();

			for (int i = 0; i < lstRenae.size(); i++) {
				Renae entity = lstRenae.get(i);
				RenaesBean bean = deRenaeARenaesBean(entity);

				lstReferenciaBean.add(bean);
			}
		}

		return lstReferenciaBean;
	}
	
	private RenaesBean deRenaeARenaesBean(Renae entity) {
		
		RenaesBean bean = null;
		
		if (entity != null) {
			
			bean = new RenaesBean();
			 
			bean.setCodigo(entity.getCodrgren()); 
			bean.setCodRenaes(entity.getCodrgren()); 
			bean.setCodigoOrganizacion(entity.getCodorgan());
			bean.setCodigoInstitucion(entity.getCodinsti());
			bean.setCodigoSede(entity.getCodsedei()); 
			bean.setNomRenaes(entity.getNomrenea());
			bean.setUbiRenaes(entity.getUbigeo());
			bean.setCodigoRenaes(entity.getCodrenea());
			bean.getCategoria().setNombreCorto(entity.getCategoria());
			bean.getCategoria().setCodReg(entity.getTg14Cate());
			bean.setProvRenaes(entity.getProvincia());
			bean.setDeptRenaes(entity.getDepartamento());
			bean.setDistrRenaes(entity.getDistrito());
		}
		
		return bean;
	}

	@Override
	public boolean insertarDestinoRenaes(RenaesBean personaBean) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

 
}
