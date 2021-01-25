package proyect.core.repository.implementacion.venta;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.icu.text.DecimalFormat;

import proyect.base.repository.DAOException;
import proyect.core.bean.general.EpisodioBean;
import proyect.core.bean.venta.VentaBean;
import proyect.core.bean.venta.VentaItemBean;
import proyect.core.entity.venta.Venta;
import proyect.core.entity.venta.VentaItem;
import proyect.core.repository.interfaces.venta.VentaItemDAO; 

@Transactional
@Repository("ventaItemDAO")
public class VentaItemDAOImpl implements VentaItemDAO{
	
	@PersistenceContext
	private EntityManager em;

	public VentaItemDAOImpl() {
		
	}

	@Override
	public boolean insertar(VentaItemBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(VentaItemBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(VentaItemBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public VentaItemBean getBuscarPorObjecto(VentaItemBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VentaItemBean> getBuscarPorFiltros(VentaItemBean ventaItem) throws DAOException {
		List<VentaItem> lstVenta = null;	
		List<VentaItemBean> lstVentaBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("ventaItem.buscarPorCriterios"); 
			spq.setParameter("idVenta", ventaItem.getVenta().getCodigo()); 	
			spq.setParameter("numeroPeriodo", ventaItem.getVenta().getNumeroPeriodo()); 
			 if (spq.execute()) {
				 lstVenta =  spq.getResultList(); 
			 }		 
			if (lstVenta != null && lstVenta.size() > 0) {
				System.out.println("lstVenta.size() " + lstVenta.size());
				lstVentaBean = deListaObjetoAListaObjetoBean(lstVenta);
			 }
			
			em.close();
				   
		return lstVentaBean;
	}

	@Override
	public boolean existe(VentaItemBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

private static String getTwoDecimals(double value){
      DecimalFormat df = new DecimalFormat("0.00"); 
      return df.format(value);
}
	
private List<VentaItemBean> deListaObjetoAListaObjetoBean(List<VentaItem> lstVenta) {
		
		List<VentaItemBean> lstVentaBean = null;
		
		if (lstVenta != null && lstVenta.size() > 0) {
			
		lstVentaBean = new ArrayList<VentaItemBean>();
			
		for (int i = 0; i < lstVenta.size(); i++) { 
			VentaItem entity = lstVenta.get(i);
			VentaItemBean bean = deObjetoAObjetoBean(entity);
				
		lstVentaBean.add(bean);
		}
		}	
		return lstVentaBean;
	}
	
	private VentaItemBean deObjetoAObjetoBean(VentaItem entity) {
		
		VentaItemBean bean = null; 
		if (entity != null) {
			bean = new VentaItemBean();
			bean.setCodigo(entity.getId().getIdVentaitem());  
			bean.setNumeroPeriodo(entity.getId().getNumeroPeriodo()); 
			bean.getVenta().setNumero(entity.getNumero());
			bean.getVenta().setFechaEmision(entity.getFechaEmision());
			bean.getVenta().setCodigo(entity.getIdVenta());
			bean.setCantidad(entity.getCantidad());
			bean.setCantidadConsumida(entity.getCantidadConsumida());
			bean.getStock().setCodigo(entity.getIdStock());
			bean.getStock().getArticulo().setCodigo(entity.getIdArticulo());
			bean.getStock().setLote(entity.getLote());
			bean.getStock().getArticulo().setNombre(entity.getNombreArticulo());
			bean.getStock().getArticulo().getTipoPresentacion().setDescripcionCorta(entity.getDescripcionCortaPresentacion());
			bean.getStock().setsPrecio((getTwoDecimals(entity.getPrecio()).replace(",", ".")));
			bean.setsSubTotal((getTwoDecimals(entity.getSubtotal()).replace(",", ".")));
			bean.setUsuarioRegistro(entity.getUsuarioRegistro());
			bean.getVenta().getTipoFinanciador().setIdRegistro(entity.getIdTipoSeguro());
			bean.getVenta().getTipoFinanciador().setDescripcionCorta(entity.getTipoSeguro());
			bean.getVenta().getEpisodio().setCodigo(entity.getIdEpisodio());
			bean.getVenta().getPersona().setCodigo(entity.getIdPersona());
	 	}
		
		return bean;
	}

	@Override
	public List<VentaItemBean> listarArtPorEpisodio(EpisodioBean episodio) throws DAOException {
		List<VentaItem> lstVenta = null;	
		List<VentaItemBean> lstVentaBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("ventaItem.buscarPorEpisodio"); 
			spq.setParameter("idEpisodio", episodio.getCodigo()); 	
			 if (spq.execute()) {
				 lstVenta =  spq.getResultList(); 
			 }		 
			if (lstVenta != null && lstVenta.size() > 0) {
				System.out.println("lstVenta.size() " + lstVenta.size());
				lstVentaBean = deListaObjetoAListaObjetoBean(lstVenta);
			 }
			
			em.close();
				   
		return lstVentaBean;
	}

	@Override
	public List<VentaItemBean> listarConsumoPaciente(VentaBean ventaBean) throws DAOException {
		List<VentaItem> lstVenta = null;	
		List<VentaItemBean> lstVentaBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("ventaItem.listarConsumoPaciente"); 
			spq.setParameter("idPersona", ventaBean.getPersona().getCodigo()); 	
			 if (spq.execute()) {
				 lstVenta =  spq.getResultList(); 
			 }		 
			if (lstVenta != null && lstVenta.size() > 0) {
				System.out.println("lstVenta.size() " + lstVenta.size());
				lstVentaBean = deListaObjetoAListaObjetoBean(lstVenta);
			 }
			
			em.close();
				   
		return lstVentaBean;
	}
}
