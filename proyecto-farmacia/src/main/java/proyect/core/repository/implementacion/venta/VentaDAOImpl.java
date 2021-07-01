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
import proyect.core.bean.stock.ArticuloBean;
import proyect.core.bean.venta.VentaBean;
import proyect.core.bean.venta.VentaItemBean;
import proyect.core.entity.stock.Articulo;
import proyect.core.entity.venta.Venta;
import proyect.core.entity.venta.VentaItem;
import proyect.core.repository.interfaces.venta.VentaDAO;
import proyect.web.utilitarios.VO;

@Transactional
@Repository("VentaDAO")
public class VentaDAOImpl implements VentaDAO{
	
	@PersistenceContext
	private EntityManager em;

	public VentaDAOImpl() {
		
	}

	@Override
	public boolean insertar(VentaBean venta) throws DAOException {
		boolean sw=false;
		Object id = null;
		Object valida= 0;
		Object nroPeriodo = null;
		Object nombreArticulo= null;
		Object idError= 0;
		Object descError= null;
		System.out.println("venta.getSfechaEmision() insertar " + venta.getSfechaEmision());
		try { 
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("venta.insertar"); 
			spq.setParameter("idPersona", venta.getPersona().getCodigo());
			spq.setParameter("idAlmacen", venta.getAlmacen().getCodigo());
			spq.setParameter("fechaAtencion", venta.getFechaAtencion());
 
			spq.setParameter("idTurno", venta.getTurno().getCodigo());
			spq.setParameter("idModalidadPago", venta.getModalidadPago().getIdRegistro());
			spq.setParameter("tipoFinanciador", venta.getTipoFinanciador().getIdRegistro());

			spq.setParameter("cantidadItems", venta.getCantidadItems());
			spq.setParameter("cadenaPeriodoStock", venta.getCadenaNroPeriodoStock());
			spq.setParameter("cadenaIdStock", venta.getCadenaCodigoStock());
			spq.setParameter("cadenaCantidad", venta.getCadenaCantidad());
			spq.setParameter("cadenaCantidadFaltante",venta.getCadenaCantidadFaltante());
			spq.setParameter("idTipoMoneda", venta.getTipoMoneda().getIdRegistro());
			spq.setParameter("fechaEmision", venta.getSfechaEmision());
			spq.setParameter("idTipoComprobanteCat02", venta.getTipoComprobante().getIdRegistro());
			spq.setParameter("idTipoOperacionCat02", venta.getTipoOperacion().getIdRegistro());
			spq.setParameter("nroSerie", venta.getSerie().getNroSerie());
			
			spq.setParameter("idProcedenciaCat02", venta.getCuentaCorrienteBean().getTipoProcedencia().getIdRegistro());
			spq.setParameter("idTipoCuentaCta02", venta.getCuentaCorrienteBean().getTipoCuentaCorriente().getIdRegistro());
			
			spq.setParameter("numeroEpisodio", venta.getCuentaCorrienteBean().getEpisodio().getNumeroEpisodio());
			spq.setParameter("idEpisodio", venta.getCuentaCorrienteBean().getEpisodio().getCodigo());
			spq.setParameter("periodoEpisodio", venta.getCuentaCorrienteBean().getEpisodio().getNumeroPeriodo());
			spq.setParameter("versionEpisodio", venta.getCuentaCorrienteBean().getEpisodio().getNumeroVersion());
			spq.setParameter("tipoPaciente", venta.getCuentaCorrienteBean().getEpisodio().getTipoPaciente().getIdRegistro());

			spq.setParameter("codctacte", venta.getCuentaCorrienteBean().getIdCuentaCabV2());
			spq.setParameter("perctacte", venta.getCuentaCorrienteBean().getPeriodoCuentaCabV2());
			spq.setParameter("verctacte", venta.getCuentaCorrienteBean().getVersionCuentaCabV2());
			
			System.out.println("venta.getUsuarioRegistro() " + venta.getUsuarioRegistro());
			spq.setParameter("usuarioRegistro", venta.getUsuarioRegistro());
			spq.setParameter("ipRegistro", venta.getIpRegistro()); 
			spq.setParameter("macRegistro", "");
			spq.execute(); 
			
			valida = spq.getOutputParameterValue(1);
			nombreArticulo = spq.getOutputParameterValue(2);
			id = spq.getOutputParameterValue(3);
			nroPeriodo = spq.getOutputParameterValue(4);
			idError = spq.getOutputParameterValue(34);
			descError = spq.getOutputParameterValue(35);
			if (VO.isNotNull(id)) {
				sw = true;
				venta.setValida(Integer.valueOf(valida.toString()));
				venta.setNombreArticuloSinStock(nombreArticulo.toString());
				venta.setCodigo(id.toString());
				venta.setNumeroPeriodo(nroPeriodo.toString());
				venta.setError(descError.toString());
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
	public boolean actualizar(VentaBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(VentaBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public VentaBean getBuscarPorObjecto(VentaBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VentaBean> getBuscarPorFiltros(VentaBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(VentaBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<VentaBean> buscarxFechaClienteVO(VentaBean VentaBean) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean anularVenta(VentaBean venta) throws DAOException {
		boolean sw=true;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("venta.anular");
			
			spq.setParameter("idVenta",    		venta.getCodigo());
			spq.setParameter("numeroPeriodo", 	venta.getNumeroPeriodo());
			spq.setParameter("numeroDocu", 	   	venta.getNumero());
			spq.setParameter("ipRegistro", 	   	venta.getIpRegistro());
			spq.setParameter("usuarioRegistro", venta.getUsuarioRegistro());	
			spq.setParameter("motivoElimino", venta.getMotivoElimina());	
			spq.execute();
			
			em.close();
			
		} catch (Exception e) {
			sw=false;
			throw new DAOException(e);
		}
		return sw;
	}

	@Override
	public VentaBean findByIdVenta(VentaBean venta) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean cierreVentaDiaria(VentaBean venta) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<VentaBean> listarVentasAnuladasFindByObject(VentaBean venta) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VentaBean> listarVentasAnuladasFindByObjectPagante(VentaBean venta) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VentaBean> listarAtencionesIME(VentaBean venta) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VentaBean> listarVentasDiarias(VentaBean venta) throws DAOException {
		List<Venta> lstVenta = null;	
		List<VentaBean> lstVentaBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("venta.listarVentaDiaria"); 
			spq.setParameter("idAlmacen", 	      venta.getAlmacen().getCodigo());  	
			spq.setParameter("fechaEmisionDesde", venta.getFechaEmisionDesde());  			
			spq.setParameter("fechaEmisionHasta", venta.getFechaEmisionHasta());  	
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
 
	private List<VentaBean> deListaObjetoAListaObjetoBean(List<Venta> lstVenta) {
		
		List<VentaBean> lstVentaBean = null;
		
		if (lstVenta != null && lstVenta.size() > 0) {
			
		lstVentaBean = new ArrayList<VentaBean>();
			
		for (int i = 0; i < lstVenta.size(); i++) { 
			Venta entity = lstVenta.get(i);
		VentaBean bean = deObjetoAObjetoBean(entity);
				
		lstVentaBean.add(bean);
		}
		}	
		return lstVentaBean;
	}
	
	private VentaBean deObjetoAObjetoBean(Venta entity) {
		
		VentaBean bean = null; 
		if (entity != null) {
			
			bean = new VentaBean();
			bean.setCodigo(entity.getId().getIdVenta());   
			bean.setNumeroPeriodo(entity.getId().getNumeroPeriodo());
			bean.getAlmacen().setCodigo(entity.getIdAlmacen());
			bean.getAlmacen().setNombreAlmacen(entity.getNombreAlmacen());
			bean.getPersona().setCodigo(entity.getIdPersona());
			bean.getPersona().setApellidoPaterno(entity.getApellidoPaterno());
			bean.getPersona().setApellidoMaterno(entity.getApellidoMaterno());
			bean.getPersona().setNombres(entity.getNombres());
			bean.getPersona().setNroDocumento(entity.getNroDocumento());
			bean.setImporte(entity.getImporte());   
			bean.setFechaEmision(entity.getFechaEmision());
			bean.getTipoFinanciador().setIdRegistro(entity.getIdTipoSeguro());
			bean.getTipoFinanciador().setDescripcionCorta(entity.getTipoSeguro());
			bean.setNumero(entity.getNombreBoleta());
			bean.setsImporte((getTwoDecimals(entity.getImporte()).replace(",", ".")));
			bean.setHora(entity.getHora());
			bean.setUsuarioRegistro(entity.getUsuarioRegistro());
			bean.setNumero(entity.getNumero());
			bean.setMontoLetras(entity.getMontoLetra());
			bean.getEpisodio().setCodigo(entity.getIdEpisodio());
			bean.getSerie().setNroSerie(entity.getNroSerie());
			bean.setMes(entity.getMes());
			bean.setCantidadItems(entity.getCantidadItems());
			bean.setCantidadTransAnul(entity.getCantidadTransAnul());
			bean.setCantidadTransTotal(entity.getCantidadTransTotal());
			bean.setCantidadTransVenta(entity.getCantidadTransVenta());
			bean.setImporteAnulacion(entity.getImporteAnulacion());
			bean.setImporteVenta(entity.getImporteVenta());
			bean.setImporteTotal(entity.getImporteTotal());
		/*	bean.getReporteVenta().setEnero(entity.getEnero());
			bean.getReporteVenta().setFebrero(entity.getFebrero());
			bean.getReporteVenta().setMarzo(entity.getMarzo());
			bean.getReporteVenta().setAbril(entity.getAbril());
			bean.getReporteVenta().setMayo(entity.getMayo());
			bean.getReporteVenta().setJunio(entity.getJunio());
			bean.getReporteVenta().setJulio(entity.getJulio());
			bean.getReporteVenta().setAgosto(entity.getAgosto());
			bean.getReporteVenta().setSetiembre(entity.getSetiembre());
			bean.getReporteVenta().setOctubre(entity.getOctubre());
			bean.getReporteVenta().setNoviembre(entity.getNoviembre());
			bean.getReporteVenta().setDiciembre(entity.getDiciembre());  */
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
	public List<VentaBean> listarPacientes(VentaBean venta) throws DAOException {
		List<Venta> lstVenta = null;	
		List<VentaBean> lstVentaBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("venta.listarPacientes"); 
			spq.setParameter("idSituacion", venta.getSituacion().getIdRegistro()); 	
			 if (spq.execute()) {
				 lstVenta =  spq.getResultList(); 
			 }		 
			if (lstVenta != null && lstVenta.size() > 0) {
				lstVentaBean = deListaObjetoAListaObjetoBean(lstVenta);
			 }
			
			em.close();
				   
		return lstVentaBean;
	}

	@Override
	public VentaBean buscarPorNroDocumento(VentaBean venta) throws DAOException {
		List<Venta> lstVenta = null;	
		VentaBean lstVentaBean = null;
				StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("venta.buscarPorNroDocumento");  
				spq.setParameter("nroSerie", venta.getSerie().getNroSerie()); 
				spq.setParameter("idVenta", venta.getCodigo()); 
				spq.setParameter("numeroPeriodo", venta.getNumeroPeriodo()); 
				
				 if (spq.execute()) {
					 lstVenta =  spq.getResultList(); 
				 }
				 
				if (lstVenta != null && lstVenta.size() > 0) {
					lstVentaBean = deObjetoAObjetoBean(lstVenta.get(0));
				 }
				
				em.close();
				
			   
			return lstVentaBean;
	}

	@Override
	public VentaBean totalVenta(int tipo, VentaBean venta) throws DAOException {
		List<Venta> lstVenta = null;	
		VentaBean lstVentaBean = null;
				StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("venta.totalVenta");  
				spq.setParameter("tipoReporte", tipo); 
				spq.setParameter("fechaEmision", venta.getFechaEmision()); 
				spq.setParameter("mes", venta.getMes()); 
				spq.setParameter("anio", venta.getNumeroPeriodo());
				spq.setParameter("idSituacion", venta.getSituacion().getIdRegistro());
				 if (spq.execute()) {
					 lstVenta =  spq.getResultList(); 
				 }
				 
				if (lstVenta != null && lstVenta.size() > 0) {
					lstVentaBean = deObjetoAObjetoBean(lstVenta.get(0));
				 }
				
				em.close();
				
			   
			return lstVentaBean;
	}

	@Override
	public List<VentaBean> listaMensual(VentaBean venta) throws DAOException {
		List<Venta> lstVenta = null;	
		List<VentaBean> lstVentaBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("venta.listaMensual"); 
			spq.setParameter("anio", venta.getNumeroPeriodo()); 	
			 if (spq.execute()) {
				 lstVenta =  spq.getResultList(); 
				 System.out.println("lstVenta " + lstVenta.size());
			 }		 
			if (lstVenta != null && lstVenta.size() > 0) {
				lstVentaBean = deListaObjetoAListaObjetoBean(lstVenta);
			 }
			
			em.close();
				   
		return lstVentaBean;
	}

	@Override
	public List<VentaBean> reporteVentaTipoPaciente(int tipo, VentaBean venta) throws DAOException {
		List<Venta> lstVenta = null;	
		List<VentaBean> lstVentaBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("venta.reporteTipoPaciente"); 
			spq.setParameter("tipoReporte", tipo); 
			spq.setParameter("fechaEmision", venta.getFechaEmision()); 
			spq.setParameter("mes", venta.getMes()); 
			spq.setParameter("anio", venta.getNumeroPeriodo());
			 if (spq.execute()) {
				 lstVenta =  spq.getResultList(); 
				 System.out.println("lstVenta " + lstVenta.size());
			 }		 
			if (lstVenta != null && lstVenta.size() > 0) {
				lstVentaBean = deListaObjetoAListaObjetoBean(lstVenta);
			 }
			
			em.close();
				   
		return lstVentaBean;
	}

	@Override
	public boolean devolucionVenta(VentaBean venta) throws DAOException {
		boolean sw=false; 
		try { 
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("venta.devolucion");  
			spq.setParameter("cadenaIdVenta", venta.getCadenaIdVenta());
			spq.setParameter("idPersona", venta.getPersona().getCodigo());
			spq.setParameter("fechaAtencion", venta.getFechaAtencion());
			spq.setParameter("cantidadItems", venta.getCantidadItems());
			spq.setParameter("cadenaPrecio", venta.getCadenaPrecioVenta());
			spq.setParameter("cadenaIdStock", venta.getCadenaCodigoStock());
			spq.setParameter("cadenaCantidad", venta.getCadenaCantidad());
			spq.setParameter("ipRegistro", venta.getIpRegistro());  
			spq.setParameter("usuarioRegistro", venta.getUsuarioRegistro());
			
			spq.execute(); 
			 
			em.close();
			
		} catch (Exception e) {
			sw = false;
			e.printStackTrace();
			throw new DAOException(e);
		}
		return sw;
	}

	@Override
	public List<VentaBean> reporteRecaudacion(VentaBean venta) throws DAOException {
		List<Venta> lstVenta = null;	
		List<VentaBean> lstVentaBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("venta.reporteRecaudacion"); 	
			spq.setParameter("fechaEmisionDesde", venta.getFechaEmisionDesde());  			
			spq.setParameter("fechaEmisionHasta", venta.getFechaEmisionHasta());  	
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
