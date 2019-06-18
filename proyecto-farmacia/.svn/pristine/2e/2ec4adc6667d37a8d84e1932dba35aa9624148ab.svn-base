
package hnch.referencia.core.repository.implementacion.seguridad;

import hnch.referencia.core.bean.seguridad.AccesoBean;
import hnch.referencia.core.entity.seguridad.Acceso;
import hnch.referencia.core.repository.DAOException;
import hnch.referencia.core.repository.interfaces.seguridad.AccesoDAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository("accesoDAO")
public class AccesoDAOImp implements AccesoDAO {

	@PersistenceContext//(unitName="emfSeguridad")
	private EntityManager em; 
	
	@Override
	public boolean insertar(AccesoBean t) throws DAOException {
		
		/*Object id= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_acceso.insertar");
	       // spq.setParameter("p_codacceso", t.getp_codacceso());
            spq.setParameter("p_codperfil", t.getPerfil()!=null? t.getPerfil().getCodigoPerfil():null);
            spq.setParameter("p_codcompo", t.getComponente()!=null? t.getComponente().getCodigoComponente():null);
            spq.setParameter("p_flgasi", t.getFlgAsignado());
            spq.setParameter("p_codusureg", t.getAudCodigoUsuario());
            spq.setParameter("p_hostreg", t.getAudHostIP());
            spq.setParameter("p_flgread", t.isFlgRead()? "1":"0");
            spq.setParameter("p_flgwrite", t.isFlgWrite()? "1":"0");
            spq.setParameter("p_flgdelete", t.isFlgDelete()? "1":"0");
	        
	        spq.execute();
			
			id = spq.getOutputParameterValue(1);
			if (id != null) {
				t.setCodigo(Integer.valueOf(id.toString()));
				sw=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}*/
		return false;//sw;
	}

	@Override
	public boolean actualizar(AccesoBean t) throws DAOException {
		
		/*boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_acceso.actualizar");
			spq.setParameter("p_codacceso", t.getCodigoAcceso());
            spq.setParameter("p_flgasi", t.getFlgAsignado());
            spq.setParameter("p_codusumod", t.getAudCodigoUsuario());
            spq.setParameter("p_hostmod", t.getAudHostIP());
            spq.setParameter("p_flgread", t.isFlgRead()? "1":"0");
            spq.setParameter("p_flgwrite", t.isFlgWrite()? "1":"0");
            spq.setParameter("p_flgdelete", t.isFlgDelete()? "1":"0");
	        
	        spq.execute();
			sw=true;
				
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}*/
		return false;//sw;
	}

	@Override
	public boolean eliminar(AccesoBean t) throws DAOException {
		
		/*boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_acceso.eliminar");
			spq.setParameter("p_codacceso", t.getCodigoAcceso());
            spq.setParameter("p_codusumod", t.getAudCodigoUsuario());
            spq.setParameter("p_hostmod", t.getAudHostIP());
	        
	        spq.execute();
			sw=true;
				
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}*/
		return false;//sw;
	}

	@Override
	public AccesoBean getBuscarPorObjecto(AccesoBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccesoBean> getBuscarPorFiltros(AccesoBean accesoBean)
			throws DAOException {
		List<AccesoBean> lstAccesoBean = new ArrayList<AccesoBean>();
		List<Acceso> lstEntity = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("acceso.listar");
			spq.setParameter("CODIPERF", accesoBean.getPerfil().getCodigo());
	        spq.setParameter("CODCOMPA", accesoBean.getComponente().getCodigoComponentePadre()); 
		
			if (spq.execute()) {
				lstEntity = spq.getResultList();			
			}
			
			if (	lstEntity != null
				&&	lstEntity.size() > 0) {
				for (Acceso Acceso : lstEntity) {
					lstAccesoBean.add(deAccesoToAccesoBean(Acceso));
				}
				
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return lstAccesoBean;
	}

	@Override
	public boolean existe(AccesoBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean asignar(AccesoBean bean) throws DAOException {
		Object id  = null; 
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("acceso.asignar");
	        spq.setParameter("CODACCES", bean.getCodigo());
            spq.setParameter("SWASIGNA", bean.getFlgAsignado());
            spq.setParameter("SWLECTUR", bean.isFlgRead()? "1":"0");
            spq.setParameter("SWESCRIT", bean.isFlgWrite()? "1":"0");
            spq.setParameter("SWELIMIN", bean.isFlgDelete()? "1":"0");
            spq.setParameter("SWEXPORT", bean.isFlgExport()? "1":"0");
            spq.setParameter("CODIPERF", bean.getPerfil().getCodigo());
            spq.setParameter("CODCOMPO", bean.getComponente().getCodigo());
            spq.setParameter("AUCDUSCR", bean.getCodigoUsuarioCreacion());
         	spq.setParameter("AUPCIPCR", bean.getIpCreacion());
	        
	        spq.execute();
			
			id = spq.getOutputParameterValue(1);
			if (id != null) {
				bean.setCodigo(id.toString());
				sw = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			sw = false; 
		}finally{
			em.close();
		}
		return sw;
	}
	
	private AccesoBean deAccesoToAccesoBean(Acceso entity){
		AccesoBean bean = null;
		
		if(entity!=null){
			bean = new AccesoBean();
			bean.setItem(entity.getNroOrden()); 
			bean.setCodigo(entity.getCodacceso()); 
			bean.getComponente().setNombreComponente(entity.getNomcompo());
			bean.getComponente().setDescripcion(entity.getDescompo());
			bean.getComponente().setCodigo(entity.getCodcompo());
			bean.getComponente().setCodigoComponentePadre(entity.getCodcompa());
			bean.setFlgAsignado(entity.getSwAsignado());
			bean.setFlgRead(entity.getSwLectura()!= null && entity.getSwLectura().equals("1") ? true : false);
			bean.setFlgWrite(entity.getSwEscrito()!= null && entity.getSwEscrito().equals("1") ? true : false);
			bean.setFlgDelete(entity.getSwEliminar()!= null && entity.getSwEliminar().equals("1") ? true : false);
			bean.setFlgExport(entity.getSwExportar()!= null && entity.getSwExportar().equals("1") ? true : false);
		}
		
		return bean;
	}

}