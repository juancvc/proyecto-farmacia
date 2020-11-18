package proyect.core.repository.implementacion.cuentaCorriente;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional; 
import proyect.base.repository.DAOException;
import proyect.core.bean.cuentaCorriente.CuentaCorrienteBean;
import proyect.core.bean.venta.DevolucionBean;
import proyect.core.bean.venta.VentaBean;
import proyect.core.entity.cuentaCorriente.CuentaCorriente;
import proyect.core.entity.venta.Devolucion;
import proyect.core.entity.venta.Venta;
import proyect.core.repository.interfaces.cuentaCorriente.CuentaCorrienteDAO;
import proyect.core.repository.interfaces.venta.DevolucionDAO;
import proyect.web.utilitarios.VO;


@Transactional
@Repository("cuentaCorrienteDAO")
public class CuentaCorrienteDAOImpl implements CuentaCorrienteDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(CuentaCorrienteBean cuentaCorrienteBean) throws DAOException {
		Object idDevolucion= null;
		boolean sw=false;
		System.out.println("Datos :" + cuentaCorrienteBean);
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("devolucion.insertar");
		/*	spq.setParameter("ID_ORGANIZACION", devolucion.getIdOrganizacionDevolucion());
			spq.setParameter("ID_INSTITUCION", devolucion.getIdInstitucionDevolucion());
			spq.setParameter("ID_SEDE", devolucion.getIdSedeDevolucion());
			spq.setParameter("ID_SITUACION", devolucion.getSituacion().getIdSituacion());
			spq.setParameter("AUD_ID_USUARIO", devolucion.getAud_usuario().getIdUsuario());
			spq.setParameter("AUD_IP", devolucion.getAud_ip());
			spq.setParameter("AUD_SESSION", devolucion.getAud_session());
			spq.setParameter("AUD_ID_OPERACION", 1);
			spq.setParameter("AUD_MAC", devolucion.getAud_pc_mac());
			spq.setParameter("AUD_OBSERVACION", devolucion.getAud_Observacion());*/
			spq.execute();
			
			idDevolucion = spq.getOutputParameterValue(1);
			if (VO.isNotNull(idDevolucion)) {
				cuentaCorrienteBean.setCodigo((idDevolucion.toString()));
				sw=true;
			}
			em.close();
			System.out.println("Llego a :" + cuentaCorrienteBean);
			
		} catch (Exception e) {
			e.printStackTrace();
			sw=false;
			throw new DAOException(e);
		}
		return sw;
	}

	@Override
	public boolean actualizar(CuentaCorrienteBean devolucion) throws DAOException {
		boolean sw=true;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("devolucion.actualizar");
			
	/**		spq.setParameter("ID_CLASE", devolucion.getIdDevolucion());	
			spq.setParameter("ID_ORGANIZACION", devolucion.getIdOrganizacionDevolucion());
			spq.setParameter("ID_INSTITUCION", devolucion.getIdInstitucionDevolucion());
			spq.setParameter("ID_SEDE", devolucion.getIdSedeDevolucion());
			spq.setParameter("ID_SITUACION", devolucion.getSituacion().getIdSituacion());
			spq.setParameter("AUD_ID_USUARIO", devolucion.getAud_usuario().getIdUsuario());
			spq.setParameter("AUD_IP", devolucion.getAud_ip());
			spq.setParameter("AUD_SESSION", devolucion.getAud_session());
			spq.setParameter("AUD_ID_OPERACION", 2);
			spq.setParameter("AUD_MAC", devolucion.getAud_pc_mac());
			spq.setParameter("AUD_OBSERVACION", devolucion.getAud_Observacion());
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
	public boolean eliminar(CuentaCorrienteBean devolucion) throws DAOException {
		boolean sw=true;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("devolucion.eliminar");
		/*	
			spq.setParameter("ID_CLASE", devolucion.getIdDevolucion());	
			spq.setParameter("ID_ORGANIZACION", devolucion.getIdOrganizacionDevolucion());
			spq.setParameter("ID_INSTITUCION", devolucion.getIdInstitucionDevolucion());
			spq.setParameter("ID_SEDE", devolucion.getIdSedeDevolucion());
			spq.setParameter("AUD_ID_USUARIO", devolucion.getAud_usuario().getIdUsuario());
			spq.setParameter("AUD_IP", devolucion.getAud_ip());
			spq.setParameter("AUD_SESSION", devolucion.getAud_session());
			spq.setParameter("AUD_ID_OPERACION", 3);
			spq.setParameter("AUD_MAC", devolucion.getAud_pc_mac());
			spq.execute();
			*/
			em.close();
			
		} catch (Exception e) {
			sw=false;
			throw new DAOException(e);
		}
		return sw;
	}

	@SuppressWarnings("unchecked")
	@Override
	public CuentaCorrienteBean getBuscarPorObjecto(CuentaCorrienteBean devolucion) throws DAOException {
		
		CuentaCorrienteBean oDevolucionBean = null;	
		List<CuentaCorriente> lstDevolucion = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("devolucion.getBuscarPorObjecto");
			spq.setParameter("idDevolucion", devolucion.getCodigo()); 
			 
			 if (spq.execute()) {
				 lstDevolucion =  spq.getResultList(); 
			 }
			 
			if (lstDevolucion != null && lstDevolucion.size() > 0) {
				oDevolucionBean = deObjetoAObjetoBean(lstDevolucion.get(0));
			 }
			
			em.close(); 
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
		return oDevolucionBean;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CuentaCorrienteBean> getBuscarPorFiltros(CuentaCorrienteBean devolucion)
			throws DAOException {
		List<CuentaCorrienteBean> lstDevolucionBean = null;	
		List<CuentaCorriente> lstDevolucion = null;	
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("devolucion.buscarxcriterios");	 
			
			 if (spq.execute()) {
				 lstDevolucion =  spq.getResultList(); 
			 }
			 
			if (lstDevolucion != null && lstDevolucion.size() > 0) {
				lstDevolucionBean = deListaObjetoAListaObjetoBean(lstDevolucion);
			 }
			
			em.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
		return lstDevolucionBean;
	}
 
	
	@Override
	public List<CuentaCorrienteBean> listarCtaCtePacientePendientes(CuentaCorrienteBean venta) throws DAOException {
		List<CuentaCorriente> lstCuentaCorriente = null;	
		List<CuentaCorrienteBean> lstVentaBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("cuentaCorriente.listaPacientesPendientes"); 
			spq.setParameter("CODPERSO", 	      venta.getPersona().getCodigo());  	
		
			 if (spq.execute()) {
				 lstCuentaCorriente =  spq.getResultList(); 
			 }		 
			if (lstCuentaCorriente != null && lstCuentaCorriente.size() > 0) {
				System.out.println("lstVenta.size() " + lstCuentaCorriente.size());
				lstVentaBean = deListaObjetoAListaObjetoBean(lstCuentaCorriente);
			 }
			
			em.close();
				   
		return lstVentaBean;
	}
	

private List<CuentaCorrienteBean> deListaObjetoAListaObjetoBean(List<CuentaCorriente> lstDevolucion) {
		
		List<CuentaCorrienteBean> lstDevolucionBean = null;
		
		if (lstDevolucion != null && lstDevolucion.size() > 0) {
			
			lstDevolucionBean = new ArrayList<CuentaCorrienteBean>();
			
			for (int i = 0; i < lstDevolucion.size(); i++) { 
				CuentaCorriente entity = lstDevolucion.get(i);
				CuentaCorrienteBean bean = deObjetoAObjetoBean(entity);
				
				lstDevolucionBean.add(bean);
			}
		}
		
		return lstDevolucionBean;
	}
	
	private CuentaCorrienteBean deObjetoAObjetoBean(CuentaCorriente entity) {
		
		CuentaCorrienteBean bean = null; 
		if (entity != null) {
			
			bean = new CuentaCorrienteBean();
			bean.setCodigo(entity.getId().getIdCuentaCorriente());   
			bean.setNumeroPeriodo(entity.getId().getNumeroPeriodo());    
			bean.setNumeroVersion(entity.getId().getNumeroVersion());
			bean.getEpisodio().setCodigo(entity.getCodigoEpisodio());
			bean.getEpisodio().setNumeroPeriodo(entity.getPeriodoEpisodio());
			bean.getEpisodio().setNumeroVersion(entity.getVersionoEpisodio());
			bean.getEpisodio().getTipoPaciente().setIdRegistro(entity.getTipoPaciente());
			bean.getEpisodio().getTipoPaciente().setDescripcionCorta(entity.getNombreTipoPaciente());
			bean.setNombreCategoria(entity.getNombreCategoria());
			bean.getPersona().setCodigo(entity.getCodigoPersona());
			bean.getPersona().setApellidoPaterno(entity.getApellidoPaterno());
			bean.getPersona().setApellidoMaterno(entity.getApellidoMaterno());
			bean.getPersona().setNombres(entity.getPrimerNombre()+" "+entity.getSegundoNombre());
			bean.getPersona().setNroDocumento(entity.getNroDoc());
			bean.getPersona().getTipoDocumento().setIdRegistro(entity.getTipoDocumento());
			bean.getPaciente().setNroHC(entity.getNroHC());
	 	}
		
		return bean;
	}

	@Override
	public boolean existe(CuentaCorrienteBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	

}
