package proyect.core.repository.implementacion.venta;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import proyect.base.repository.DAOException;
import proyect.core.bean.venta.VentaBean;
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
			
		//	spq.setParameter("ID_TIPO_MONEDA", venta.getIdTipoMoneda());
			
		/*	spq.setParameter("TIPO", venta.getTipo());
			spq.setParameter("ID_ORGANIZACION_RECETA", venta.getReceta().getId().getIdOrganizacionReceta());
			spq.setParameter("ID_INSTITUCION_RECETA", venta.getReceta().getId().getIdInstitucionReceta());
			spq.setParameter("ID_SEDE_RECETA", venta.getReceta().getId().getIdSedeReceta());
			spq.setParameter("NRO_VERSION_RECETA", venta.getReceta().getId().getNroVersionReceta());
			spq.setParameter("NRO_PERIODO_RECETA", venta.getReceta().getId().getNroPeriodoReceta());
			spq.setParameter("ID_RECETA", venta.getReceta().getId().getIdReceta());
			spq.setParameter("TIPO_PACIENTE", venta.getTipoPaciente());
			spq.setParameter("SW_EXOGERADO",venta.getReceta().getSwExonerado());
			//spq.setParameter("NRO_PERIODO", venta.getNroPerido());
			
			spq.setParameter("NRO_PERIODO_PREESCRIPTOR",venta.getNroPeriodoPreescriptor());
			spq.setParameter("ID_PREESCRIPTOR",venta.getIdPreescriptor());
			spq.setParameter("NRO_RECETA",venta.getNroRecetaVenta());
			spq.setParameter("COD_DIAGNOSTICO",venta.getCodDiagnostico());
			spq.setParameter("NRO_PERIODO_RESPONSABLE",venta.getNroPeriodoResponsable());
			spq.setParameter("ID_RESPONSABLE",venta.getIdResponsable());
			spq.setParameter("TIPO_VENTA",venta.getTipoVenta());
			spq.setParameter("CADENA_FALTANTE",venta.getCadenaStockFaltante());
			
			spq.setParameter("ID_PROGRAMA",venta.getIdPrograma());
			spq.setParameter("ID_SUB_PROGRAMA",venta.getIdSubPrograma());
			spq.setParameter("TIPOPACIENTEHOSPITALIZADO",venta.getTipoPacienteHospitalizado());
			*/
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
		// TODO Auto-generated method stub
		return false;
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
 
  
 
}
