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

@Transactional
@Repository("VentaDAO")
public class VentaDAOImpl implements VentaDAO{
	
	@PersistenceContext
	private EntityManager em;

	public VentaDAOImpl() {
		
	}

	@Override
	public boolean insertar(VentaBean venta) throws DAOException {
		Object id= null;   
		Object nroPeriodo= null;   
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("orden.insertar"); 
		/*	spq.setParameter("CODORGAN", venta.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", venta.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", venta.getCodigoSede()); 
			spq.setParameter("CODPERSO", venta.getPacienteBean().getPersona().getCodigo());
			spq.setParameter("CANT_ITEMS", venta.getCantidadItems());
			spq.setParameter("CADENA_CODTARIF", venta.getCadenaCodigoTarifario());
			spq.setParameter("CADENA_CANTIDAD", venta.getCadenaCantidad());
			
			spq.setParameter("AUCDUSCR", venta.getCodigoUsuarioCreacion());
			spq.setParameter("AUPCIPCR", venta.getIpCreacion());
			*/ 
			
			
			spq.execute();
			
			id = spq.getOutputParameterValue(4); 
			nroPeriodo = spq.getOutputParameterValue(9); 
			if (id != null) {
				venta.setCodigo(id.toString());
				venta.setNumeroPeriodo(nroPeriodo.toString()); 
				sw=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
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
