package proyect.core.repository.implementacion.Stock;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import proyect.base.repository.DAOException;
import proyect.core.bean.stock.StockBean;
import proyect.core.entity.stock.Stock;
import proyect.core.repository.interfaces.stock.StockDAO;
import proyect.web.utilitarios.VO;


@Transactional
@Repository("StockDAO")
public class StockDAOImpl implements StockDAO{
	
	@PersistenceContext
	private EntityManager em;

	public StockDAOImpl() {
		
	}

	@Override
	public boolean insertar(StockBean stockBean) throws DAOException {
		Object idStock= null;
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("stock.insert");
		 
			
			spq.setParameter("idAlmacen",     			stockBean.getAlmacenBean().getCodigo());
			spq.setParameter("idArticulo", 		   	 	stockBean.getArticuloBean().getCodigo());
			spq.setParameter("stock", 		    		stockBean.getStock());
			spq.setParameter("lote", 		    		stockBean.getLote());
			spq.setParameter("usuarioRegistro", 		stockBean.getUsuarioRegistro());
			spq.setParameter("ipRegistro", 	    		stockBean.getIpRegistro());
			spq.setParameter("precioCompra", 		    stockBean.getPrecioCompra());
			spq.setParameter("precioVenta", 		    stockBean.getPrecioVenta());
			spq.setParameter("fechaVencimiento", 		stockBean.getFechaVencimiento());
			spq.setParameter("idModalidadAdquisicion",  stockBean.getModalidadAdquision().getNroRegistro());
			spq.setParameter("tipoFinanciador", 		stockBean.getTipoFinanciador().getNroRegistro());
			spq.setParameter("tipoSeleccion", 		    stockBean.getTipoSeleccion().getNroRegistro());
			spq.setParameter("nroRegistroSanitario",    stockBean.getNroRegistroSanitario());
			spq.setParameter("idProveedor", 		    stockBean.getProveedorBean().getCodigo());
			spq.execute();
			
			idStock = spq.getOutputParameterValue(1);
			if (VO.isNotNull(idStock)) {
				stockBean.setCodigo(idStock.toString());
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
	public boolean actualizar(StockBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(StockBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public StockBean getBuscarPorObjecto(StockBean stockBean) throws DAOException {
		List<Stock> lstStock = null;	
		StockBean lstStockBean = null;
			
		 
				StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("almacen.findByObjectVO");  
				spq.setParameter("idStock", stockBean.getCodigo()); 
				
				 if (spq.execute()) {
					 lstStock =  spq.getResultList(); 
				 }
				 
				if (lstStock != null && lstStock.size() > 0) {
					lstStockBean = deObjetoAObjetoBean(lstStock.get(0));
				 }
				
				em.close();
				
			   
			return lstStockBean;
	}

	@Override
	public List<StockBean> getBuscarPorFiltros(StockBean stockBean) throws DAOException {
		
		List<Stock> lstStock = null;	
		List<StockBean> lstStockBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("stock.buscarPorFiltros");  
			spq.setParameter("nombreArticulo", stockBean.getArticuloBean().getNombre()); 
			spq.setParameter("idArticulo", 	   stockBean.getArticuloBean().getCodigo()); 
			spq.setParameter("tipoLlamada",	   stockBean.getTipoLlamada()); 
			spq.setParameter("idAlmacen", 	   stockBean.getAlmacenBean().getCodigo()); 			
			 if (spq.execute()) {
				 lstStock =  spq.getResultList(); 
			 }		 
			if (lstStock != null && lstStock.size() > 0) {
				lstStockBean = deListaObjetoAListaObjetoBean(lstStock);
			 }
			
			em.close();
				   
		return lstStockBean;
	}

	@Override
	public boolean existe(StockBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	private StockBean deObjetoAObjetoBean(Stock entity) {
		
		StockBean bean = null; 
		if (entity != null) {
			
			bean = new StockBean();
			bean.setCodigo(entity.getIdStock());   
			bean.getAlmacenBean().setCodigo(entity.getIdAlmacen());
			bean.getAlmacenBean().setNombreAlmacen(entity.getNombreAlmacen());
			bean.setLote(entity.getLote());
			bean.setStock(entity.getStock());
			bean.setPrecioCompra(entity.getPrecioCompra());
			bean.setPrecioVenta(entity.getPrecioVenta());
			bean.setStock(entity.getStock());
			bean.setFechaVencimiento(entity.getFechaVencimiento());
			bean.getTipoFinanciador().setDescripcionCorta(entity.getTipoFinanciamiento());
			bean.getTipoSeleccion().setDescripcionCorta(entity.getTipoProcesoSeleccion());
			bean.getModalidadAdquision().setDescripcionCorta(entity.getNombreModalidadAdquisicion());
	 	}
		
		return bean;
	}

private List<StockBean> deListaObjetoAListaObjetoBean(List<Stock> lstStock) {
		
		List<StockBean> lstStockBean = null;
		
		if (lstStock != null && lstStock.size() > 0) {
			
		lstStockBean = new ArrayList<StockBean>();
			
		for (int i = 0; i < lstStock.size(); i++) { 
		Stock entity = lstStock.get(i);
		StockBean bean = deObjetoAObjetoBean(entity);
				
		lstStockBean.add(bean);
		}
		}	
		return lstStockBean;
	}
  
}
