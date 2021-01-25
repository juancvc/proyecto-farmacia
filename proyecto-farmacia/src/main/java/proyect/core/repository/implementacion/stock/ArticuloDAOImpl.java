package proyect.core.repository.implementacion.stock;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import proyect.base.repository.DAOException;
import proyect.core.bean.stock.ArticuloBean;
import proyect.core.entity.stock.Articulo;
import proyect.core.repository.interfaces.stock.ArticuloDAO;
import proyect.web.utilitarios.VO;


@Transactional
@Repository("ArticuloDAO")
public class ArticuloDAOImpl implements ArticuloDAO{
	
	@PersistenceContext
	private EntityManager em;

	public ArticuloDAOImpl() {
		
	}

	@Override
	public boolean insertar(ArticuloBean articuloBean) throws DAOException {
		Object idArticulo= null;
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("articulo.insert");
		 
			spq.setParameter("nombreArticulo", 		articuloBean.getNombre());
			spq.setParameter("idClase", 	   		articuloBean.getClase().getIdRegistro());
			spq.setParameter("idGenerico", 	   		articuloBean.getIdGenerico());
			spq.setParameter("idTipoPresentacionCat01", articuloBean.getTipoPresentacion().getIdRegistro());
			spq.setParameter("concentracion",  		articuloBean.getConcentracion());			
			spq.setParameter("idTipoArticuloCat01", articuloBean.getTipoArticulo().getIdRegistro());
			spq.setParameter("volumen",             articuloBean.getVolumen());
			
			spq.setParameter("idLaboratorio",       articuloBean.getLaboratorio().getCodigo());
			spq.setParameter("posologia", 	     	articuloBean.getPosologia());
			spq.setParameter("stockAlerta", 	 	articuloBean.getStockAlerta());
			spq.setParameter("stockOptimo", 	 	articuloBean.getStockOptimo());
			spq.setParameter("codigoSismed", 	 	articuloBean.getCodigoSismed());
			spq.setParameter("codigoSiga", 	     	articuloBean.getCodigoSiga());
			spq.setParameter("usuarioRegistro",  	articuloBean.getUsuarioRegistro());
			spq.setParameter("ipRegistro", 		 	articuloBean.getIpRegistro());
			spq.execute();
			
			idArticulo = spq.getOutputParameterValue(1);
			if (VO.isNotNull(idArticulo)) {
				articuloBean.setCodigo(idArticulo.toString());
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
	public boolean actualizar(ArticuloBean articuloBean) throws DAOException {
		boolean sw=true;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("articulo.update");
			
			spq.setParameter("idArticulo",    		articuloBean.getCodigo());
			spq.setParameter("nombreArticulo", 		articuloBean.getNombre());
			spq.setParameter("idClase", 	   		articuloBean.getClase().getIdRegistro());
			spq.setParameter("idGenerico", 	   		articuloBean.getIdGenerico());
			spq.setParameter("concentracion",  		articuloBean.getConcentracion());			
			spq.setParameter("idTipoArticuloCat01", articuloBean.getTipoArticulo().getIdRegistro());
			
			spq.setParameter("idLaboratorio",       articuloBean.getLaboratorio().getCodigo());
			spq.setParameter("posologia", 	     	articuloBean.getPosologia());
			spq.setParameter("stockAlerta", 	 	articuloBean.getStockAlerta());
			spq.setParameter("stockOptimo", 	 	articuloBean.getStockOptimo());
			spq.setParameter("codigoSismed", 	 	articuloBean.getCodigoSismed());
			spq.setParameter("codigoSiga", 	     	articuloBean.getCodigoSiga());
			spq.setParameter("usuarioModificacion", articuloBean.getUsuarioModificacion());
			spq.setParameter("ipModificacion", 		articuloBean.getIpModificacion());
	
			spq.execute();
			
			em.close();
			
		} catch (Exception e) {
			sw=false;
			throw new DAOException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(ArticuloBean articuloBean) throws DAOException {
		boolean sw=true;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("articulo.delete");
			spq.setParameter("idArticulo",    		articuloBean.getCodigo());
			spq.setParameter("usuarioModificacion", articuloBean.getUsuarioRegistro());
			spq.setParameter("ipModificacion",      articuloBean.getIpRegistro());
			spq.execute();

			em.close();
			
		} catch (Exception e) {
			sw=false;
			throw new DAOException(e);
		}
		return sw;
	}

	@Override
	public ArticuloBean getBuscarPorObjecto(ArticuloBean articuloBean) throws DAOException {
		List<Articulo> lstAlmacen = null;	
		   ArticuloBean lstAlmacenBean = null;
			
		   System.out.println("almacen.getCodigo() " + articuloBean.getCodigo());
				StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("articulo.findByObjectVO");  
				spq.setParameter("idAlmacen", articuloBean.getCodigo()); 
				
				 if (spq.execute()) {
					 lstAlmacen =  spq.getResultList(); 
				 }
				 
				if (lstAlmacen != null && lstAlmacen.size() > 0) {
					lstAlmacenBean = deObjetoAObjetoBean(lstAlmacen.get(0));
				 }
				
				em.close();
				
			   
			return lstAlmacenBean;
	}

	@Override
	public List<ArticuloBean> getBuscarPorFiltros(ArticuloBean articuloBean) throws DAOException {
		List<Articulo> lstArticulo = null;	
		List<ArticuloBean> lstArticuloBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("articulo.buscarPorFiltros");  
			spq.setParameter("nombreArticulo", articuloBean.getNombre()); 
			spq.setParameter("idTipoArticuloCat01", articuloBean.getTipoArticulo().getIdRegistro());
			 if (spq.execute()) {
				 lstArticulo =  spq.getResultList(); 
			 }
			 
			if (lstArticulo != null && lstArticulo.size() > 0) {
				lstArticuloBean = deListaObjetoAListaObjetoBean(lstArticulo);
			 }
			
			em.close();
			
		   
		return lstArticuloBean;
	}

	@Override
	public boolean existe(ArticuloBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	
private List<ArticuloBean> deListaObjetoAListaObjetoBean(List<Articulo> lstArticulo) {
		
		List<ArticuloBean> lstArticuloBean = null;
		
		if (lstArticulo != null && lstArticulo.size() > 0) {
			
			lstArticuloBean = new ArrayList<ArticuloBean>();
			
			for (int i = 0; i < lstArticulo.size(); i++) { 
				Articulo entity = lstArticulo.get(i);
				ArticuloBean bean = deObjetoAObjetoBean(entity);
				
				lstArticuloBean.add(bean);
			}
		}
		
		return lstArticuloBean;
	}
	
	
private ArticuloBean deObjetoAObjetoBean(Articulo entity) {
		
		ArticuloBean bean = null; 
		if (entity != null) {
			
			bean = new ArticuloBean();
			bean.setCodigo(entity.getIdArticulo());   
			bean.setNombre(entity.getNombreArticulo());
			bean.getLaboratorio().setCodigo(entity.getIdLaboratorio());
			bean.getLaboratorio().setNombre(entity.getNombreLaboratorio());
			bean.getLaboratorio().setCodigo(entity.getIdLaboratorio());
			bean.setStockAlerta(entity.getStockAlerta());
			bean.setStockOptimo(entity.getStockOptimo());
			bean.setVolumen(entity.getVolumen());
			bean.getTipoArticulo().setIdRegistro(entity.getIdTipoArticuloCat01());
			bean.getTipoArticulo().setDescripcionCorta(entity.getNombreTipoArticulo());
			bean.getTipoPresentacion().setIdRegistro(entity.getIdTipoPresentacionCat01());
			bean.getTipoPresentacion().setDescripcionCorta(entity.getDescripcionCortaPresentacion());
			bean.getTipoPresentacion().setDescripcionLarga(entity.getDescripcionLargaPresentacion());
			bean.getClase().setIdRegistro(entity.getIdClase());
			bean.getClase().setDescripcionCorta(entity.getNombreClase());
			bean.setUsuarioRegistro(entity.getUsuarioRegistro());
			bean.setIpRegistro(entity.getIpRegistro());
			bean.setPosologia(entity.getPosologia());
			bean.setIdGenerico(entity.getIdGenerico());
			bean.setConcentracion(entity.getConcentracion());
			bean.setCodigoSiga(entity.getCodigoSismed());
			bean.setCodigoSismed(entity.getCodigoSismed());
	 	}
		
		return bean;
	}

@Override
public List<ArticuloBean> reportePorStockAlerta() throws DAOException {
	List<Articulo> lstArticulo = null;	
	List<ArticuloBean> lstArticuloBean = null;
	
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("articulo.reportePorStockAlerta");  
		 if (spq.execute()) {
			 lstArticulo =  spq.getResultList(); 
		 }
		 
		if (lstArticulo != null && lstArticulo.size() > 0) {
			lstArticuloBean = deListaObjetoAListaObjetoBean(lstArticulo);
		 }
		
		em.close();
		
	   
	return lstArticuloBean;
}

}
