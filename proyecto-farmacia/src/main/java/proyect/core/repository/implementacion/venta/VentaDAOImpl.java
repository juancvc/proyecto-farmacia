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
		Object valida= null;
		Object nroPeriodo = null;
		Object nombreArticulo= "";
		System.out.println("venta insertar " + venta);
		try { 
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("venta.insertar"); 
			spq.setParameter("idPersona", venta.getPersona().getCodigo());
			
			spq.setParameter("idEvento", "");
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
			spq.setParameter("tipoMoneda", venta.getTipoMoneda().getIdRegistro());
			spq.setParameter("usuarioRegistro", venta.getUsuarioRegistro());
			spq.setParameter("ipRegistro", venta.getIpRegistro()); 
			spq.setParameter("fechaEmision", venta.getSfechaEmision());
			spq.setParameter("idTipoComprobanteCat02", venta.getTipoComprobante().getIdRegistro());
			spq.setParameter("idTipoOperacionCat02", venta.getTipoOperacion().getIdRegistro());
			spq.setParameter("nroSerie", venta.getSerie().getNroSerie());
			
			spq.setParameter("codctacte", venta.getCuentaCorrienteBean().getCodigo());
			spq.setParameter("perctacte", venta.getCuentaCorrienteBean().getNumeroPeriodo());
			spq.setParameter("verctacte", venta.getCuentaCorrienteBean().getNumeroVersion());
			spq.setParameter("codepicta", venta.getCuentaCorrienteBean().getEpisodio().getCodigo());
			spq.setParameter("perepicte", venta.getCuentaCorrienteBean().getEpisodio().getNumeroPeriodo());
			spq.setParameter("verepicte", venta.getCuentaCorrienteBean().getEpisodio().getNumeroVersion());
			spq.execute(); 
			valida = spq.getOutputParameterValue(1);
			nombreArticulo = spq.getOutputParameterValue(2);
			id = spq.getOutputParameterValue(3);
			nroPeriodo = spq.getOutputParameterValue(4);
			if (VO.isNotNull(id)) {
				sw = true;
				venta.setSwValida(Boolean.valueOf(valida.toString()));
				//venta.get.setNombreCortoArticulo(nombreArticulo.toString());
				venta.setCodigo(id.toString());
				venta.setNumeroPeriodo(nroPeriodo.toString());
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
	
}
