package proyect.core.repository.implementacion.compra;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.icu.text.DecimalFormat;

import proyect.base.repository.DAOException;
import proyect.core.bean.stock.ArticuloBean;
import proyect.core.bean.compra.CompraBean;
import proyect.core.bean.compra.CompraItemBean;
import proyect.core.bean.movimiento.MovimientoAlmacenBean;
import proyect.core.entity.stock.Articulo;
import proyect.core.entity.compra.Compra;
import proyect.core.entity.compra.CompraItem;
import proyect.core.entity.movimiento.MovimientoAlmacen;
import proyect.core.repository.interfaces.compra.CompraDAO;
import proyect.web.utilitarios.VO;

@Transactional
@Repository("CompraDAO")
public class CompraDAOImpl implements CompraDAO{
	
	@PersistenceContext
	private EntityManager em;

	public CompraDAOImpl() {
		
	}

	@Override
	public boolean insertar(CompraBean compra) throws DAOException {
		boolean sw=false;
		Object id = null;
		Object valida= null;
		Object nroPeriodo = null;
		Object nombreArticulo= "";
		try { 
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("compra.insertar"); 
			spq.setParameter("cantidad", compra.getCantidadItems()); 
			spq.setParameter("idAlmacen", compra.getAlmacen().getCodigo());
			spq.setParameter("nroDocumento", compra.getNumeroDocumento());
			spq.setParameter("usuarioRegistro", compra.getUsuarioRegistro());
			spq.setParameter("ipRegistro", compra.getIpRegistro()); 
			
			spq.setParameter("nroGuia", "");  
			spq.setParameter("cadenaIdArticulo", compra.getCadenaIdArticulo());
			spq.setParameter("cadenaCantidad", compra.getCadenaCantidad());
			spq.setParameter("cadenaLote",compra.getCadenaLote());
			spq.setParameter("cadenaPrecioCompra", compra.getCadenaPrecioCompra());
			spq.setParameter("cadenaPrecioVenta", compra.getCadenaPrecioVenta());
			spq.setParameter("cadenaFechaVencimiento", compra.getCadenaFechaVencimiento());
			spq.setParameter("cadenaRegistroSanitario", compra.getCadenaRegistroSanitario());
			spq.setParameter("idProveedor", compra.getProveedor().getCodigo());
			
			spq.setParameter("idTipoFinanciadorCat02", compra.getTipoFinanciamiento().getIdRegistro());
			spq.setParameter("idTipoSeleccionCat02", compra.getTipoProcesoSeleccion().getIdRegistro());
 
			spq.setParameter("idTipoDocCompraCat02", compra.getTipoDocumento().getIdRegistro());
			spq.setParameter("idpersona", "");
			
			spq.setParameter("glosa", compra.getGlosa());
			spq.setParameter("fechaEmision", compra.getsFechaEmision());
			spq.setParameter("macRegistro", "");
			
			spq.execute();  
			id = spq.getOutputParameterValue(1);
			//nroPeriodo = spq.getOutputParameterValue(4);
			if (VO.isNotNull(id)) {
				sw = true;
				//compra.get.setNombreCortoArticulo(nombreArticulo.toString());
				compra.setCodigo(id.toString());
				//compra.setNumeroPeriodo(nroPeriodo.toString());
			}
			em.close();
			
		} catch (Exception e) {
			sw = false;
			e.printStackTrace();
			throw new DAOException(e);
		}
		return sw;
	}

	@Override
	public boolean actualizar(CompraBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(CompraBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CompraBean getBuscarPorObjecto(CompraBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompraBean> getBuscarPorFiltros(CompraBean t) throws DAOException {
		List<Compra> lstCompraAlmacen = null;	
		List<CompraBean> lstCompraAlmacenBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("compra.buscarPorFiltros");  
			spq.setParameter("idAlmacen", t.getAlmacen().getCodigo()); 
			spq.setParameter("fechaEmision", t.getsFechaEmision()); 
			 if (spq.execute()) {
				 lstCompraAlmacen =  spq.getResultList(); 
			 }
			 
			if (lstCompraAlmacen != null && lstCompraAlmacen.size() > 0) {
				lstCompraAlmacenBean = deListaObjetoAListaObjetoBean(lstCompraAlmacen);
			 }
			
			em.close();
			
		   
		return lstCompraAlmacenBean;
	}

	@Override
	public boolean existe(CompraBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CompraBean> buscarxFechaClienteVO(CompraBean CompraBean) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean anularCompra(CompraBean Compra) throws DAOException {
		boolean sw=true;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("compra.anular");
			
			spq.setParameter("idCompra",    	Compra.getCodigo());
			spq.setParameter("numeroPeriodo", 	Compra.getNumeroPeriodo()); 
			spq.setParameter("ipRegistro", 	   	Compra.getIpRegistro());
			spq.setParameter("usuarioRegistro", Compra.getUsuarioRegistro());	
	
			spq.execute();
			
			em.close();
			
		} catch (Exception e) {
			sw=false;
			throw new DAOException(e);
		}
		return sw;
	}

	@Override
	public CompraBean findByIdCompra(CompraBean Compra) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean cierreCompraDiaria(CompraBean Compra) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CompraBean> listarComprasAnuladasFindByObject(CompraBean Compra) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompraBean> listarComprasAnuladasFindByObjectPagante(CompraBean Compra) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompraBean> listarAtencionesIME(CompraBean Compra) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompraBean> listarComprasDiarias(CompraBean Compra) throws DAOException {
		List<Compra> lstCompra = null;	
		List<CompraBean> lstCompraBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("compra.listarCompraDiaria"); 
			spq.setParameter("idAlmacen", 	      Compra.getAlmacen().getCodigo());   	
			 if (spq.execute()) {
				 lstCompra =  spq.getResultList(); 
			 }		 
			if (lstCompra != null && lstCompra.size() > 0) {
				System.out.println("lstCompra.size() " + lstCompra.size());
				lstCompraBean = deListaObjetoAListaObjetoBean(lstCompra);
			 }
			
			em.close();
				   
		return lstCompraBean;
	}
 
	private List<CompraBean> deListaObjetoAListaObjetoBean(List<Compra> lstCompra) {
		
		List<CompraBean> lstCompraBean = null;
		
		if (lstCompra != null && lstCompra.size() > 0) {
			
		lstCompraBean = new ArrayList<CompraBean>();
			
		for (int i = 0; i < lstCompra.size(); i++) { 
			Compra entity = lstCompra.get(i);
		CompraBean bean = deObjetoAObjetoBean(entity);
				
		lstCompraBean.add(bean);
		}
		}	
		return lstCompraBean;
	}
	
 
	private CompraBean deObjetoAObjetoBean(Compra entity) {
		
		CompraBean bean = null; 
		if (entity != null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
			
			bean = new CompraBean();
			bean.setCodigo(entity.getId().getIdCompra());   
			bean.setNumeroPeriodo(entity.getId().getNumeroPeriodo());
			bean.getAlmacen().setCodigo(entity.getIdAlmacen());
			bean.getAlmacen().setNombreAlmacen(entity.getNombreAlmacen()); 
			bean.setFechaEmision(entity.getFechaEmision()); 
			if (entity.getFechaEmision() !=null) {
				bean.setsFechaEmision(dateFormat.format(entity.getFechaEmision()));
			} 
			bean.setHora(entity.getHora());
			bean.setUsuarioRegistro(entity.getUsuarioRegistro());
			bean.setImporte(entity.getImporte());
			bean.setNumeroDocumento(entity.getNumeroDocumento());
			bean.getTipoDocumento().setIdRegistro(entity.getIdTipoDocumentoCat02());
			bean.getTipoDocumento().setDescripcionCorta(entity.getTipoDocumento());
			bean.getProveedor().setCodigo(entity.getIdProveedor());
			bean.getTipoProcesoSeleccion().setIdRegistro(entity.getIdTipoProcesoSeleccionCat02());
			bean.getTipoFinanciamiento().setIdRegistro(entity.getIdTipoFinanciadorCat02());
			bean.getProveedor().setNombreProveedor(entity.getNombreProveedor());
			bean.setGlosa(entity.getGlosa());
			bean.setsImporte((getTwoDecimals(entity.getImporte()).replace(",", ".")));
			
	 	}
		
		return bean;
	}
	
	private static String getTwoDecimals(double value){
	      DecimalFormat df = new DecimalFormat("0.00"); 
	      return df.format(value);
	    }

	@Override
	public String cantidadConLetra(float monto) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompraBean> listarPacientes(CompraBean Compra) throws DAOException {
		List<Compra> lstCompra = null;	
		List<CompraBean> lstCompraBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("compra.listarPacientes"); 
			spq.setParameter("idSituacion", Compra.getSituacion().getIdRegistro()); 	
			 if (spq.execute()) {
				 lstCompra =  spq.getResultList(); 
			 }		 
			if (lstCompra != null && lstCompra.size() > 0) {
				lstCompraBean = deListaObjetoAListaObjetoBean(lstCompra);
			 }
			
			em.close();
				   
		return lstCompraBean;
	}

	@Override
	public CompraBean buscarPorNroDocumento(CompraBean Compra) throws DAOException {
		List<Compra> lstCompra = null;	
		CompraBean lstCompraBean = null;
				StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("compra.buscarPorNroDocumento");  
				spq.setParameter("idCompra", Compra.getCodigo()); 
				spq.setParameter("numeroPeriodo", Compra.getNumeroPeriodo()); 
				
				 if (spq.execute()) {
					 lstCompra =  spq.getResultList(); 
				 }
				 
				if (lstCompra != null && lstCompra.size() > 0) {
					lstCompraBean = deObjetoAObjetoBean(lstCompra.get(0));
				 }
				
				em.close();
				
			   
			return lstCompraBean;
	}

	@Override
	public CompraBean totalCompra(int tipo, CompraBean compra) throws DAOException {
		List<Compra> lstCompra = null;	
		CompraBean lstCompraBean = null;
				StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("compra.totalCompra");  
				spq.setParameter("tipoReporte", tipo); 
				spq.setParameter("fechaEmision", compra.getFechaEmision()); 
				spq.setParameter("mes", compra.getMes()); 
				spq.setParameter("anio", compra.getNumeroPeriodo());
				
				 if (spq.execute()) {
					 lstCompra =  spq.getResultList(); 
				 }
				 
				if (lstCompra != null && lstCompra.size() > 0) {
					lstCompraBean = deObjetoAObjetoBean(lstCompra.get(0));
				 }
				
				em.close();
				
			   
			return lstCompraBean;
	}
	
}
