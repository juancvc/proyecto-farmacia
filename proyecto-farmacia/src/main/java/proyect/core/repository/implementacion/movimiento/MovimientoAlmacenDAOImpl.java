package proyect.core.repository.implementacion.movimiento;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import proyect.base.repository.DAOException;
import proyect.core.bean.movimiento.MovimientoAlmacenBean;
import proyect.core.repository.interfaces.movimiento.MovimientoAlmacenDAO;
import proyect.web.utilitarios.VO; 
import proyect.core.entity.movimiento.MovimientoAlmacen;

@Transactional
@Repository("MovimientoAlmacenDAO")
public class MovimientoAlmacenDAOImpl implements MovimientoAlmacenDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(MovimientoAlmacenBean MovimientoAlmacen) throws DAOException {
		Object idMovimientoAlmacen= null;
		Object valida= null;
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("movimientoAlmacen.insertar");
			spq.setParameter("idTipoMovimiento", MovimientoAlmacen.getTipoMovimiento().getCodigo());
			spq.setParameter("cantidad", MovimientoAlmacen.getCantidad());
			spq.setParameter("idAlmacenOrigen", MovimientoAlmacen.getAlmacenOrigen().getCodigo());
			spq.setParameter("idAlmacenDestino", MovimientoAlmacen.getAlmacenDestino().getCodigo());
			spq.setParameter("nroDocumento", MovimientoAlmacen.getNroDocumento());
			spq.setParameter("usuarioRegistro", MovimientoAlmacen.getUsuarioRegistro());
			spq.setParameter("ipRegistro", MovimientoAlmacen.getIpRegistro());
			spq.setParameter("nroGuia", "");
			spq.setParameter("cadenaIdStock", MovimientoAlmacen.getCadenaIdStock());
			spq.setParameter("cadenaCantidad", MovimientoAlmacen.getCadenaCantdArt());
			spq.setParameter("tipoIngresoDocumento", MovimientoAlmacen.getTipoIngresoDocumento());
			spq.setParameter("idTipoFinanciadorCat02", MovimientoAlmacen.getTipoFinanciador().getIdRegistro());
			spq.setParameter("idTipoSeleccionCat02", MovimientoAlmacen.getTipoSeleccion().getIdRegistro());
			spq.setParameter("idTipoDocCompraCat02", MovimientoAlmacen.getTipoDocumentoCompra().getIdRegistro());
			
			spq.execute();
			
			idMovimientoAlmacen = spq.getOutputParameterValue(1);
			valida = spq.getOutputParameterValue(12);
			if (VO.isNotNull(idMovimientoAlmacen)) {
				MovimientoAlmacen.setCodigo(idMovimientoAlmacen.toString());
				MovimientoAlmacen.setValida(Integer.valueOf(valida.toString()));
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
	public boolean actualizar(MovimientoAlmacenBean MovimientoAlmacen) throws DAOException {
		boolean sw=true;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("MovimientoAlmacen.update");
			
		/*	spq.setParameter("ID_MovimientoAlmacen", MovimientoAlmacen.getIdMovimientoAlmacen());	
			spq.setParameter("ID_ORGANIZACION", MovimientoAlmacen.getIdOrganizacionMovimientoAlmacen());
			spq.setParameter("ID_INSTITUCION", MovimientoAlmacen.getIdInstitucionMovimientoAlmacen());
			spq.setParameter("ID_SEDE", MovimientoAlmacen.getIdSedeMovimientoAlmacen());
			spq.setParameter("NOMBRE_CORTO", MovimientoAlmacen.getNombreCorto());
			spq.setParameter("NOMBRE_LARGO", MovimientoAlmacen.getNombreLargo());
			spq.setParameter("ALIAS", MovimientoAlmacen.getAlias());
			spq.setParameter("ID_SITUACION", MovimientoAlmacen.getSituacion().getIdSituacion());
			spq.setParameter("AUD_ID_USUARIO", MovimientoAlmacen.getAud_usuario().getIdUsuario());
			spq.setParameter("AUD_IP", MovimientoAlmacen.getAud_ip());
			spq.setParameter("AUD_SESSION", MovimientoAlmacen.getAud_session());
			spq.setParameter("AUD_ID_OPERACION", 2);
			spq.setParameter("AUD_MAC", MovimientoAlmacen.getAud_pc_mac());
			spq.setParameter("AUD_OBSERVACION", MovimientoAlmacen.getAud_Observacion());
			spq.setParameter("CODIGO_MINSA", MovimientoAlmacen.getCodigoMinsa());
			*/
			spq.execute();
			
			em.close();
			
		} catch (Exception e) {
			sw=false;
			throw new DAOException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(MovimientoAlmacenBean MovimientoAlmacen) throws DAOException {
		boolean sw=true;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("MovimientoAlmacen.delete");
			
	/*		spq.setParameter("ID_MovimientoAlmacen", MovimientoAlmacen.getIdMovimientoAlmacen());	
			spq.setParameter("ID_ORGANIZACION", MovimientoAlmacen.getIdOrganizacionMovimientoAlmacen());
			spq.setParameter("ID_INSTITUCION", MovimientoAlmacen.getIdInstitucionMovimientoAlmacen());
			spq.setParameter("ID_SEDE", MovimientoAlmacen.getIdSedeMovimientoAlmacen());
			spq.setParameter("AUD_ID_USUARIO", MovimientoAlmacen.getAud_usuario().getIdUsuario());
			spq.setParameter("AUD_IP", MovimientoAlmacen.getAud_ip());
			spq.setParameter("AUD_SESSION", MovimientoAlmacen.getAud_session());
			spq.setParameter("AUD_ID_OPERACION", 3);
			spq.setParameter("AUD_MAC", MovimientoAlmacen.getAud_pc_mac());
			spq.execute();
			*/
			em.close();
			
		} catch (Exception e) {
			sw=false;
			throw new DAOException(e);
		}
		return sw;
	}

	@Override
	public MovimientoAlmacenBean getBuscarPorObjecto(MovimientoAlmacenBean MovimientoAlmacen) throws DAOException {
		List<MovimientoAlmacen> lstMovimientoAlmacen = null;	
	   MovimientoAlmacenBean lstMovimientoAlmacenBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("MovimientoAlmacen.buscarPorObjeto");  
			//spq.setParameter("idMovimientoAlmacen", MovimientoAlmacen.getCodigo()); 
			
			 if (spq.execute()) {
				 lstMovimientoAlmacen =  spq.getResultList(); 
			 }
			 
			if (lstMovimientoAlmacen != null && lstMovimientoAlmacen.size() > 0) {
				lstMovimientoAlmacenBean = deObjetoAObjetoBean(lstMovimientoAlmacen.get(0));
			 }
			
			em.close();
			
		   
		return lstMovimientoAlmacenBean;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MovimientoAlmacenBean> getBuscarPorFiltros(MovimientoAlmacenBean MovimientoAlmacen)
			throws DAOException {
		
		List<MovimientoAlmacen> lstMovimientoAlmacen = null;	
		List<MovimientoAlmacenBean> lstMovimientoAlmacenBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("MovimientoAlmacen.buscarPorFiltros");  
		//	spq.setParameter("nombreMovimientoAlmacen", MovimientoAlmacen.getNombreMovimientoAlmacen()); 
			
			 if (spq.execute()) {
				 lstMovimientoAlmacen =  spq.getResultList(); 
			 }
			 
			if (lstMovimientoAlmacen != null && lstMovimientoAlmacen.size() > 0) {
				lstMovimientoAlmacenBean = deListaObjetoAListaObjetoBean(lstMovimientoAlmacen);
			 }
			
			em.close();
			
		   
		return lstMovimientoAlmacenBean;
	}
 

private List<MovimientoAlmacenBean> deListaObjetoAListaObjetoBean(List<MovimientoAlmacen> lstMovimientoAlmacen) {
		
		List<MovimientoAlmacenBean> lstMovimientoAlmacenBean = null;
		
		if (lstMovimientoAlmacen != null && lstMovimientoAlmacen.size() > 0) {
			
			lstMovimientoAlmacenBean = new ArrayList<MovimientoAlmacenBean>();
			
			for (int i = 0; i < lstMovimientoAlmacen.size(); i++) { 
				MovimientoAlmacen entity = lstMovimientoAlmacen.get(i);
				MovimientoAlmacenBean bean = deObjetoAObjetoBean(entity);
				
				lstMovimientoAlmacenBean.add(bean);
			}
		}
		
		return lstMovimientoAlmacenBean;
	}
	
	private MovimientoAlmacenBean deObjetoAObjetoBean(MovimientoAlmacen entity) {
		
		MovimientoAlmacenBean bean = null; 
		if (entity != null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
			bean = new MovimientoAlmacenBean();
			bean.setCodigo(entity.getId().getIdMovimientoAlmacen());   
			bean.setNumeroPeriodo(entity.getId().getNumeroPeriodo());
		//	bean.getInventarioBean().setCodigo(entity.getIdInventario());
			bean.setCantidad(entity.getCantidad());
			bean.setNroDocumento(entity.getNroDocumento());
			bean.setMonto(entity.getMonto());
			bean.setSaldo(entity.getSaldo());
			bean.setOrden(entity.getOrden());
			bean.setPrecio(entity.getPrecio());
			bean.setNroGuia(entity.getNroGuia());
			bean.setGlosa(entity.getGlosa());
			bean.setFechaMovimiento(entity.getFechaMovimiento());
			bean.setTipoIngresoDocumento(entity.getTipoIngresoDocumento());
			bean.getArticuloBean().setCodigo(entity.getArticulo());
			bean.getStock().setCodigo(entity.getIdStock());
			bean.getStock().getArticulo().setNombre(entity.getNombreArticulo());
			bean.getStock().setLote(entity.getLote());
			bean.getStock().getArticulo().setCodigoSismed(entity.getCodigoSismed());
			bean.getStock().setStock(entity.getStock());
			bean.getStock().setFechaVencimiento(entity.getFechaVencimiento());
			if (entity.getFechaVencimiento() !=null) {
				bean.getStock().setsFechaVencimiento(dateFormat.format(entity.getFechaVencimiento()));
			}
			bean.getTipoMovimiento().setCodigo(entity.getIdTipoMovimiento());
			bean.getTipoMovimiento().setNombreTipoMovimiento(entity.getTipoMovimiento());
			bean.getTipoMovimiento().getCategoriaTipoMovimiento().setIdRegistro(entity.getIdCategoriaTipoMovimiento());
			bean.getAlmacenOrigen().setCodigo(entity.getIdAlmacen());
			bean.getAlmacenOrigen().setNombreAlmacen(entity.getAlmacenOrigen());
			bean.getAlmacenDestino().setNombreAlmacen(entity.getAlmacenDestino());
			bean.getPersona().setCodigo(entity.getIdPersona());
			bean.getMes().setIdRegistro(entity.getMes());
			bean.getPeriodo().setIdRegistro(entity.getAnio());
			bean.setFechaOrden(entity.getFechaOrden());
			bean.setId_concepto(entity.getId_concepto());
			bean.setCadenaCantdArt(entity.getCadenaCantdArt());
			bean.setCadenaNroPeriodoStock(entity.getCadenaNroPeriodoStock());
			bean.setCadenaIdStock(entity.getCadenaIdStock());
			bean.setSubtotal(entity.getSubtotal());
			bean.setTotal(entity.getTotal());
			bean.setFechaInventarioSig(entity.getFechaInventarioSig()); 
			
			bean.getReporteICI().setINGRESO_POR_ANULACION(entity.getINGRESO_POR_ANULACION());
			bean.getReporteICI().setSALIDA_POR_VENTA(entity.getSALIDA_POR_VENTA());
	 	}
		 
		return bean;
	}

	@Override
	public boolean existe(MovimientoAlmacenBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<MovimientoAlmacenBean> listarReporteICI(MovimientoAlmacenBean venta) throws DAOException {
		List<MovimientoAlmacen> lstMovimientoAlmacen = null;	
		List<MovimientoAlmacenBean> lstMovimientoAlmacenBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("movimientoAlmacen.reporteICIv2");  
			spq.setParameter("mes", venta.getMes().getIdRegistro()); 
			spq.setParameter("anio", venta.getPeriodo().getIdRegistro());  
			spq.setParameter("idAlmacen", venta.getAlmacenOrigen().getCodigo()); 
			
			 if (spq.execute()) {
				 lstMovimientoAlmacen =  spq.getResultList(); 
			 }
			 
			if (lstMovimientoAlmacen != null && lstMovimientoAlmacen.size() > 0) {
				lstMovimientoAlmacenBean = deListaObjetoAListaObjetoBean(lstMovimientoAlmacen);
			 }
			
			em.close();
			
		   
		return lstMovimientoAlmacenBean;
	}

	@Override
	public List<MovimientoAlmacenBean> buscarxArticuloAlmacen(MovimientoAlmacenBean movimientoAlmacenBean)
			throws DAOException {
		List<MovimientoAlmacen> lstMovimientoAlmacen = null;	
		List<MovimientoAlmacenBean> lstMovimientoAlmacenBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("movimientoAlmacen.buscarxArticuloAlmacen");  
			spq.setParameter("idArticulo", movimientoAlmacenBean.getStock().getArticulo().getCodigo()); 
			spq.setParameter("idAlmacen", movimientoAlmacenBean.getAlmacenOrigen().getCodigo()); 
			 if (spq.execute()) {
				 lstMovimientoAlmacen =  spq.getResultList(); 
			 }
			 
			if (lstMovimientoAlmacen != null && lstMovimientoAlmacen.size() > 0) {
				lstMovimientoAlmacenBean = deListaObjetoAListaObjetoBean(lstMovimientoAlmacen);
			 }
			
			em.close();
			
		   
		return lstMovimientoAlmacenBean;
	}


}
