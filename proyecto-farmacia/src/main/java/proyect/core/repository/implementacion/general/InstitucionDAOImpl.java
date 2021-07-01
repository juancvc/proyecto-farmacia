package proyect.core.repository.implementacion.general;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import proyect.base.repository.DAOException;
import proyect.core.bean.general.InstitucionBean;
import proyect.core.entity.general.Institucion;
import proyect.core.repository.interfaces.general.InstitucionDAO;
import proyect.web.utilitarios.VO; 

@Transactional
@Repository("institucionDAO")
public class InstitucionDAOImpl implements InstitucionDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(InstitucionBean Institucion) throws DAOException {
		Object idInstitucion= null;
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("institucion.insert");
		 
			spq.setParameter("nombreInstitucion", Institucion.getNombre());
			spq.setParameter("descripcion", Institucion.getDescripcion()); 
			spq.setParameter("usuarioRegistro", Institucion.getUsuarioRegistro());
			spq.setParameter("ipRegistro", Institucion.getIpRegistro());
			spq.execute();
			
			idInstitucion = spq.getOutputParameterValue(1);
			if (VO.isNotNull(idInstitucion)) {
				Institucion.setCodigo(idInstitucion.toString());
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
	public boolean actualizar(InstitucionBean Institucion) throws DAOException {
		boolean sw=true;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("institucion.update");
			
			spq.setParameter("idInstitucion",    	Institucion.getCodigo());
			spq.setParameter("nombre", 		     	Institucion.getNombre());
			spq.setParameter("nombreComercial",  	Institucion.getNombreComercial());
			spq.setParameter("descripcion",      	Institucion.getDescripcion());
			spq.setParameter("direccion", 			Institucion.getDireccion());
			spq.setParameter("logo",      			Institucion.getLogo()); 
			spq.setParameter("nombreLogo",      	Institucion.getNombreLogo());
			spq.setParameter("usuarioModificacion", Institucion.getUsuarioRegistro());
			spq.setParameter("ipModificacion",      Institucion.getIpRegistro());
			spq.execute();
			
			em.close();
			
		} catch (Exception e) {
			sw=false;
			throw new DAOException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(InstitucionBean Institucion) throws DAOException {
		boolean sw=true;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("Institucion.delete");
			spq.setParameter("idInstitucion",    		Institucion.getCodigo());
			spq.setParameter("usuarioModificacion", Institucion.getUsuarioRegistro());
			spq.setParameter("ipModificacion",      Institucion.getIpRegistro());
			spq.execute();

			em.close();
			
		} catch (Exception e) {
			sw=false;
			throw new DAOException(e);
		}
		return sw;
	}

	@Override
	public InstitucionBean getBuscarPorObjecto(InstitucionBean Institucion) throws DAOException {
		List<Institucion> lstInstitucion = null;	
	   InstitucionBean lstInstitucionBean = null;
		
	   System.out.println("Institucion.getCodigo() " + Institucion.getCodigo());
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("institucion.buscarPorObjeto");  
			spq.setParameter("idInstitucion", Institucion.getCodigo()); 
			
			 if (spq.execute()) {
				 lstInstitucion =  spq.getResultList(); 
			 }
			 
			if (lstInstitucion != null && lstInstitucion.size() > 0) {
				lstInstitucionBean = deObjetoAObjetoBean(lstInstitucion.get(0));
			 }
			
			em.close();
			
		   
		return lstInstitucionBean;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InstitucionBean> getBuscarPorFiltros(InstitucionBean Institucion)
			throws DAOException {
		
		List<Institucion> lstInstitucion = null;	
		List<InstitucionBean> lstInstitucionBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("institucion.buscarPorFiltros");   
			spq.setParameter("nombre", Institucion.getNombre()); 
			spq.setParameter("descripcion", Institucion.getDescripcion()); 
			 if (spq.execute()) {
				 lstInstitucion =  spq.getResultList(); 
			 }
			 
			if (lstInstitucion != null && lstInstitucion.size() > 0) {
				lstInstitucionBean = deListaObjetoAListaObjetoBean(lstInstitucion);
			 }
			
			em.close();
			
		   
		return lstInstitucionBean;
	}
 

private List<InstitucionBean> deListaObjetoAListaObjetoBean(List<Institucion> lstInstitucion) {
		
		List<InstitucionBean> lstInstitucionBean = null;
		
		if (lstInstitucion != null && lstInstitucion.size() > 0) {
			
			lstInstitucionBean = new ArrayList<InstitucionBean>();
			
			for (int i = 0; i < lstInstitucion.size(); i++) { 
				Institucion entity = lstInstitucion.get(i);
				InstitucionBean bean = deObjetoAObjetoBean(entity);
				
				lstInstitucionBean.add(bean);
			}
		}
		
		return lstInstitucionBean;
	}
	
	private InstitucionBean deObjetoAObjetoBean(Institucion entity) {
		
		InstitucionBean bean = null; 
		if (entity != null) {
			
			bean = new InstitucionBean();
			bean.setCodigo(entity.getIdInstitucion());    
			bean.setNombre(entity.getNombre());
			bean.setNombreComercial(entity.getNombreComercial());
			bean.setNombreLogo(entity.getNombreLogo());
			bean.setLogo(entity.getLogo());
			bean.setDescripcion(entity.getDescripcion());
			bean.setDireccion(entity.getDireccion());
			bean.setRuc(entity.getRuc());
			
	 	}
		
		return bean;
	}

	@Override
	public boolean existe(InstitucionBean t) throws DAOException {
		return false;
	}


}
