package proyect.core.repository.implementacion.venta;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import proyect.base.repository.DAOException;
import proyect.core.bean.general.AlmacenBean;
import proyect.core.bean.venta.PreciosVentaArticuloBean;
import proyect.core.entity.general.Almacen;
import proyect.core.entity.venta.PreciosVentaArticulo;
import proyect.core.repository.interfaces.venta.PreciosVentaArticuloDAO;
import proyect.web.utilitarios.VO;



@Transactional
@Repository("PreciosVentaArticuloDAO")
public class PreciosVentaArticuloDAOImpl implements PreciosVentaArticuloDAO{
	
	@PersistenceContext
	private EntityManager em;

	public PreciosVentaArticuloDAOImpl() {
		
	}

	@Override
	public boolean insertar(PreciosVentaArticuloBean preciosVentaArticuloBean) throws DAOException {
		Object idPrecioVenta= null;
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("preciosVentaArticulo.insert");
		 
			spq.setParameter("porcPrecioVenta01", preciosVentaArticuloBean.getPorcPrecioVenta01());
			spq.setParameter("porcPrecioVenta02", preciosVentaArticuloBean.getPorcPrecioVenta02());
			spq.setParameter("porcPrecioVenta03", preciosVentaArticuloBean.getPorcPrecioVenta03());
			spq.setParameter("porcPrecioVenta04", preciosVentaArticuloBean.getPorcPrecioVenta04());
			spq.setParameter("porcPrecioVenta05", preciosVentaArticuloBean.getPorcPrecioVenta05());
			spq.setParameter("activoPrecio01", 	  preciosVentaArticuloBean.getActivoPrecio01());
			spq.setParameter("activoPrecio02", 	  preciosVentaArticuloBean.getActivoPrecio02());
			spq.setParameter("activoPrecio03", 	  preciosVentaArticuloBean.getActivoPrecio03());
			spq.setParameter("activoPrecio04", 	  preciosVentaArticuloBean.getActivoPrecio04());
			spq.setParameter("activoPrecio05", 	  preciosVentaArticuloBean.getActivoPrecio05());
			spq.setParameter("tipoCambio", 		  preciosVentaArticuloBean.getTipoCambio());
			spq.setParameter("usuarioRegistro",   preciosVentaArticuloBean.getUsuarioRegistro());
			spq.setParameter("ipRegistro", 		  preciosVentaArticuloBean.getIpRegistro());
			spq.execute();
			
			idPrecioVenta = spq.getOutputParameterValue(1);
			if (VO.isNotNull(idPrecioVenta)) {
				preciosVentaArticuloBean.setCodigo(idPrecioVenta.toString());
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
	public boolean actualizar(PreciosVentaArticuloBean preciosVentaArticuloBean) throws DAOException {
		boolean sw=true;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("preciosVentaArticulo.update");
			
			spq.setParameter("idPrecioVenta", 	  	  preciosVentaArticuloBean.getCodigo());
			spq.setParameter("porcPrecioVenta01", 	  preciosVentaArticuloBean.getPorcPrecioVenta01());
			spq.setParameter("porcPrecioVenta02", 	  preciosVentaArticuloBean.getPorcPrecioVenta02());
			spq.setParameter("porcPrecioVenta03", 	  preciosVentaArticuloBean.getPorcPrecioVenta03());
			spq.setParameter("porcPrecioVenta04", 	  preciosVentaArticuloBean.getPorcPrecioVenta04());
			spq.setParameter("porcPrecioVenta05", 	  preciosVentaArticuloBean.getPorcPrecioVenta05());
			spq.setParameter("activoPrecio01", 	  	  preciosVentaArticuloBean.getActivoPrecio01());
			spq.setParameter("activoPrecio02", 	  	  preciosVentaArticuloBean.getActivoPrecio02());
			spq.setParameter("activoPrecio03", 	  	  preciosVentaArticuloBean.getActivoPrecio03());
			spq.setParameter("activoPrecio04", 	  	  preciosVentaArticuloBean.getActivoPrecio04());
			spq.setParameter("activoPrecio05", 	  	  preciosVentaArticuloBean.getActivoPrecio05());
			spq.setParameter("tipoCambio", 		  	  preciosVentaArticuloBean.getTipoCambio());
			spq.setParameter("usuarioModificacion",   preciosVentaArticuloBean.getIdUsuarioModificacion());
			spq.setParameter("ipModificacion", 		  preciosVentaArticuloBean.getIpModificacion());
	
			spq.execute();
			
			em.close();
			
		} catch (Exception e) {
			sw=false;
			throw new DAOException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(PreciosVentaArticuloBean preciosVentaArticuloBean) throws DAOException {
		boolean sw=true;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("preciosVentaArticulo.delete");
			spq.setParameter("idPrecioVenta",    	preciosVentaArticuloBean.getCodigo());
			spq.setParameter("usuarioModificacion", preciosVentaArticuloBean.getUsuarioRegistro());
			spq.setParameter("ipModificacion",      preciosVentaArticuloBean.getIpRegistro());
			spq.execute();

			em.close();
			
		} catch (Exception e) {
			sw=false;
			throw new DAOException(e);
		}
		return sw;
	}

	@Override
	public PreciosVentaArticuloBean getBuscarPorObjecto(PreciosVentaArticuloBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PreciosVentaArticuloBean> getBuscarPorFiltros(PreciosVentaArticuloBean preciosVentaArticuloBean) throws DAOException {
		List<PreciosVentaArticulo> lstPreciosVentaArticulo = null;	
		List<PreciosVentaArticuloBean> lstAlmacenBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("preciosVentaArticulo.buscarxcriterios");  
			spq.setParameter("idPrecioVenta", preciosVentaArticuloBean.getCodigo()); 
			
			 if (spq.execute()) {
				 lstPreciosVentaArticulo =  spq.getResultList(); 
			 }
			 
			if (lstPreciosVentaArticulo != null && lstPreciosVentaArticulo.size() > 0) {
				lstAlmacenBean = deListaObjetoAListaObjetoBean(lstPreciosVentaArticulo);
			 }
			
			em.close();
			
		   
		return lstAlmacenBean;
	}
	
	
private List<PreciosVentaArticuloBean> deListaObjetoAListaObjetoBean(List<PreciosVentaArticulo> lstPreciosVentaArticulo) {
		
		List<PreciosVentaArticuloBean> lstlstlstPreciosVentaArticuloBean = null;
		
		if (lstPreciosVentaArticulo != null && lstPreciosVentaArticulo.size() > 0) {
			
			lstlstlstPreciosVentaArticuloBean = new ArrayList<PreciosVentaArticuloBean>();
			
			for (int i = 0; i < lstPreciosVentaArticulo.size(); i++) { 
				PreciosVentaArticulo entity = lstPreciosVentaArticulo.get(i);
				PreciosVentaArticuloBean bean = deObjetoAObjetoBean(entity);
				
				lstlstlstPreciosVentaArticuloBean.add(bean);
			}
		}
		
		return lstlstlstPreciosVentaArticuloBean;
	}

private PreciosVentaArticuloBean deObjetoAObjetoBean(PreciosVentaArticulo entity) {
	
	PreciosVentaArticuloBean bean = null; 
	if (entity != null) {
		
		bean = new PreciosVentaArticuloBean();
		bean.setCodigo(entity.getIdPrecioVentaArticulo());   
		bean.setPorcPrecioVenta01(entity.getPorcentajePrecioVenta1());
		bean.setPorcPrecioVenta02(entity.getPorcentajePrecioVenta2());
		bean.setPorcPrecioVenta03(entity.getPorcentajePrecioVenta3());
		bean.setPorcPrecioVenta04(entity.getPorcentajePrecioVenta4());
		bean.setPorcPrecioVenta05(entity.getPorcentajePrecioVenta5());
		bean.setActivoPrecio01(entity.getSwActivoPrecio1());
		bean.setActivoPrecio02(entity.getSwActivoPrecio2());
		bean.setActivoPrecio03(entity.getSwActivoPrecio3());
		bean.setActivoPrecio04(entity.getSwActivoPrecio4());
		bean.setActivoPrecio05(entity.getSwActivoPrecio5());
		bean.setTipoCambio(entity.getPrecioTipoCambio());
		bean.setUsuarioRegistro(entity.getUsuarioRegistro());
		bean.setIpRegistro(entity.getIpRegistro());
		bean.setUsuarioModificacion(entity.getUsuarioModificacion());
		bean.setIpModificacion(entity.getIpModificacion());
 	}
	
	return bean;
}
	

	@Override
	public boolean existe(PreciosVentaArticuloBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
 
  
 
}
