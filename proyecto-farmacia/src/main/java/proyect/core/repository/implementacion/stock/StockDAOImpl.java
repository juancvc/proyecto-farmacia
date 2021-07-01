package proyect.core.repository.implementacion.stock;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import proyect.base.repository.DAOException;
import proyect.core.bean.stock.ArticuloBean;
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
		 
			
			spq.setParameter("idAlmacen",     			stockBean.getAlmacen().getCodigo());
			spq.setParameter("idArticulo", 		   	 	stockBean.getArticulo().getCodigo());
			spq.setParameter("stock", 		    		stockBean.getStock());
			spq.setParameter("lote", 		    		stockBean.getLote());
			spq.setParameter("usuarioRegistro", 		stockBean.getUsuarioRegistro());
			spq.setParameter("ipRegistro", 	    		stockBean.getIpRegistro());
			spq.setParameter("precioCompra", 		    stockBean.getPrecioCompra());
			spq.setParameter("precioVenta", 		    stockBean.getPrecioVenta());
			spq.setParameter("fechaVencimiento", 		stockBean.getFechaVencimiento());
			spq.setParameter("idModalidadAdquisicion",  stockBean.getModalidadAdquision().getIdRegistro());
			spq.setParameter("tipoFinanciador", 		stockBean.getTipoFinanciador().getIdRegistro());
			spq.setParameter("tipoSeleccion", 		    stockBean.getTipoSeleccion().getIdRegistro());
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
			spq.setParameter("nombreArticulo", stockBean.getArticulo().getNombre()); 
			spq.setParameter("idArticulo", 	   stockBean.getArticulo().getCodigo()); 
			spq.setParameter("tipoLlamada",	   stockBean.getTipoLlamada()); 
			spq.setParameter("idAlmacen", 	   stockBean.getAlmacen().getCodigo()); 			
			 if (spq.execute()) {
				 lstStock =  spq.getResultList(); 
			 }		 
			if (lstStock != null && lstStock.size() > 0) {
				System.out.println("lstStock.size() " + lstStock.size());
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
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
			bean = new StockBean();
			bean.setCodigo(entity.getIdStock());   
			bean.getAlmacen().setCodigo(entity.getIdAlmacen());
			bean.getAlmacen().setNombreAlmacen(entity.getNombreAlmacen());
			bean.setLote(entity.getLote());
			bean.setStock(entity.getStock());
			bean.getArticulo().setCodigo(entity.getIdArticulo());
			bean.getArticulo().setConcentracion(entity.getConcentracion());
			bean.getArticulo().setCodigoSismed(entity.getCodigoSismed());;
			bean.getArticulo().getTipoPresentacion().setDescripcionLarga(entity.getDescripcionLargaPresentacion());
			bean.getArticulo().setNombre(entity.getNombreArticulo());
			bean.setPrecioCompra(entity.getPrecioCompra());
			bean.setPrecioVenta(entity.getPrecioVenta());
			bean.setFechaVencimiento(entity.getFechaVencimiento());
			if (entity.getFechaVencimiento() !=null) {
				bean.setsFechaVencimiento(dateFormat.format(entity.getFechaVencimiento()));
			}
			bean.getTipoFinanciador().setDescripcionCorta(entity.getTipoFinanciamiento());
			bean.getTipoSeleccion().setDescripcionCorta(entity.getTipoProcesoSeleccion());
			bean.getModalidadAdquision().setDescripcionCorta(entity.getNombreModalidadAdquisicion());
			bean.setsPrecio((getTwoDecimals(entity.getPrecioVenta()).replace(",", "."))); 
			bean.setDiasVencimiento(entity.getDiasVencimiento());
	 	}
		
		return bean;
	}
	private static String getTwoDecimals(double value){
	      DecimalFormat df = new DecimalFormat("0.00"); 
	      return df.format(value);
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

@Override
public List<StockBean> listarPorIdArticulo(ArticuloBean articuloBean) throws DAOException {
	List<Stock> lstStock = null;	
	List<StockBean> lstStockBean = null;
	
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("stock.buscarPorIdArticulo");   
		spq.setParameter("idArticulo", 	   articuloBean.getCodigo());  			
		 if (spq.execute()) {
			 lstStock =  spq.getResultList(); 
		 }		 
		if (lstStock != null && lstStock.size() > 0) {
			System.out.println("lstStock.size() " + lstStock.size());
			lstStockBean = deListaObjetoAListaObjetoBean(lstStock);
		 }
		
		em.close();
			   
	return lstStockBean;
}

@Override
public List<StockBean> reporteArticuloPorVencer() throws DAOException {
	List<Stock> lstStock = null;	
	List<StockBean> lstStockBean = null;
	
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("stock.reporteArticuloPorVencer");
		 if (spq.execute()) {
			 lstStock =  spq.getResultList(); 
		 }		 
		if (lstStock != null && lstStock.size() > 0) {
			System.out.println("lstStock.size() " + lstStock.size());
			lstStockBean = deListaObjetoAListaObjetoBean(lstStock);
		 }
		
		em.close();
			   
	return lstStockBean;
	}
  
}
