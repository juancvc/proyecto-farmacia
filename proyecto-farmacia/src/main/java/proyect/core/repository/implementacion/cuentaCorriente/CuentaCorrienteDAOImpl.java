package proyect.core.repository.implementacion.cuentaCorriente;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional; 
import proyect.base.repository.DAOException;
import proyect.core.bean.cuentaCorriente.CuentaCorrienteBean; 
import proyect.core.bean.venta.VentaBean;
import proyect.core.entity.cuentaCorriente.CuentaCorriente; 
import proyect.core.entity.venta.Venta;
import proyect.core.repository.interfaces.cuentaCorriente.CuentaCorrienteDAO; 
import proyect.web.utilitarios.VO;


@Transactional
@Repository("cuentaCorrienteDAO")
public class CuentaCorrienteDAOImpl implements CuentaCorrienteDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(CuentaCorrienteBean cuentaCorrienteBean) throws DAOException {
		Object idCuentaCorriente= null;
		boolean sw=false;
		System.out.println("Datos :" + cuentaCorrienteBean);
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("devolucion.insertar");
		/*	spq.setParameter("ID_ORGANIZACION", devolucion.getIdOrganizacionCuentaCorriente());
			spq.setParameter("ID_INSTITUCION", devolucion.getIdInstitucionCuentaCorriente());
			spq.setParameter("ID_SEDE", devolucion.getIdSedeCuentaCorriente());
			spq.setParameter("ID_SITUACION", devolucion.getSituacion().getIdSituacion());
			spq.setParameter("AUD_ID_USUARIO", devolucion.getAud_usuario().getIdUsuario());
			spq.setParameter("AUD_IP", devolucion.getAud_ip());
			spq.setParameter("AUD_SESSION", devolucion.getAud_session());
			spq.setParameter("AUD_ID_OPERACION", 1);
			spq.setParameter("AUD_MAC", devolucion.getAud_pc_mac());
			spq.setParameter("AUD_OBSERVACION", devolucion.getAud_Observacion());*/
			spq.execute();
			
			idCuentaCorriente = spq.getOutputParameterValue(1);
			if (VO.isNotNull(idCuentaCorriente)) {
				cuentaCorrienteBean.setCodigo((idCuentaCorriente.toString()));
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
			
	/**		spq.setParameter("ID_CLASE", devolucion.getIdCuentaCorriente());	
			spq.setParameter("ID_ORGANIZACION", devolucion.getIdOrganizacionCuentaCorriente());
			spq.setParameter("ID_INSTITUCION", devolucion.getIdInstitucionCuentaCorriente());
			spq.setParameter("ID_SEDE", devolucion.getIdSedeCuentaCorriente());
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
			spq.setParameter("ID_CLASE", devolucion.getIdCuentaCorriente());	
			spq.setParameter("ID_ORGANIZACION", devolucion.getIdOrganizacionCuentaCorriente());
			spq.setParameter("ID_INSTITUCION", devolucion.getIdInstitucionCuentaCorriente());
			spq.setParameter("ID_SEDE", devolucion.getIdSedeCuentaCorriente());
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
		
		CuentaCorrienteBean oCuentaCorrienteBean = null;	
		List<CuentaCorriente> lstCuentaCorriente = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("devolucion.getBuscarPorObjecto");
			spq.setParameter("idCuentaCorriente", devolucion.getCodigo()); 
			 
			 if (spq.execute()) {
				 lstCuentaCorriente =  spq.getResultList(); 
			 }
			 
			if (lstCuentaCorriente != null && lstCuentaCorriente.size() > 0) {
				oCuentaCorrienteBean = deObjetoAObjetoBean(lstCuentaCorriente.get(0));
			 }
			
			em.close(); 
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
		return oCuentaCorrienteBean;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CuentaCorrienteBean> getBuscarPorFiltros(CuentaCorrienteBean devolucion)
			throws DAOException {
		List<CuentaCorrienteBean> lstCuentaCorrienteBean = null;	
		List<CuentaCorriente> lstCuentaCorriente = null;	
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("devolucion.buscarxcriterios");	 
			
			 if (spq.execute()) {
				 lstCuentaCorriente =  spq.getResultList(); 
			 }
			 
			if (lstCuentaCorriente != null && lstCuentaCorriente.size() > 0) {
				lstCuentaCorrienteBean = deListaObjetoAListaObjetoBean(lstCuentaCorriente);
			 }
			
			em.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
		return lstCuentaCorrienteBean;
	}
 
	
	@Override
	public List<CuentaCorrienteBean> listarCtaCtePacientePendientes(CuentaCorrienteBean venta) throws DAOException {
		List<CuentaCorriente> lstCuentaCorriente = null;	
		List<CuentaCorrienteBean> lstVentaBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("cuentaCorriente.listaPacientesPendientes"); 
			spq.setParameter("CODPERSO", "");  	
		
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
	

private List<CuentaCorrienteBean> deListaObjetoAListaObjetoBean(List<CuentaCorriente> lstCuentaCorriente) {
		
		List<CuentaCorrienteBean> lstCuentaCorrienteBean = null;
		
		if (lstCuentaCorriente != null && lstCuentaCorriente.size() > 0) {
			
			lstCuentaCorrienteBean = new ArrayList<CuentaCorrienteBean>();
			
			for (int i = 0; i < lstCuentaCorriente.size(); i++) { 
				CuentaCorriente entity = lstCuentaCorriente.get(i);
				CuentaCorrienteBean bean = deObjetoAObjetoBean(entity);
				
				lstCuentaCorrienteBean.add(bean);
			}
		}
		
		return lstCuentaCorrienteBean;
	}
	
	private CuentaCorrienteBean deObjetoAObjetoBean(CuentaCorriente entity) {
		
		CuentaCorrienteBean bean = null; 
		if (entity != null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
			bean = new CuentaCorrienteBean();
			bean.setCodigo(entity.getId().getIdCuentaCorriente());   
			bean.setNumeroPeriodo(entity.getId().getNumeroPeriodo());    
			bean.setNumeroVersion(entity.getId().getNumeroVersion());
			bean.setNombreCategoria(entity.getNombreCategoria());
			bean.setIdCuentaCabV2(entity.getIdCuentaCorrienteV2());
			bean.setPeriodoCuentaCabV2(entity.getNumeroPeriodoV2());
			bean.setVersionCuentaCabV2(entity.getNumeroVersionV2());
			bean.getTipoProcedencia().setIdRegistro(entity.getIdProcedenciaCat02());
			bean.getTipoCuentaCorriente().setIdRegistro(entity.getIdTipoCuentaCta02());
			bean.getTipoCuentaCorriente().setDescripcionCorta(entity.getDescripcionTipoCtaCte());
			bean.setFechaLiquidacion(entity.getFechaLiquidacion());
			if (entity.getFechaLiquidacion() !=null) {
				bean.setsFechaLiquidacion(dateFormat.format(entity.getFechaLiquidacion()));
			}
			
			bean.getEpisodio().setCodigo(entity.getIdEpisodio());
			bean.getEpisodio().setNumeroPeriodo(entity.getPeriodoEpisodio());
			bean.getEpisodio().setNumeroVersion(entity.getVersionEpisodio());
			bean.getEpisodio().setNumeroEpisodio(entity.getNumeroEpisodio());
			bean.getEpisodio().getTipoPaciente().setIdRegistro(entity.getIdTipoPacienteCat02()); 
			bean.getEpisodio().getTipoPaciente().setDescripcionCorta(entity.getNombreTipoPaciente());			
			bean.getEpisodio().getPaciente().setCodigo(entity.getIdPersona());
			bean.getEpisodio().getPaciente().setApellidoPaterno(entity.getApellidoPaterno());
			bean.getEpisodio().getPaciente().setApellidoMaterno(entity.getApellidoMaterno());
			bean.getEpisodio().getPaciente().setNombres(entity.getNombres());
			bean.getEpisodio().getPaciente().setNroDocumento(entity.getNroDocumento());
			bean.getEpisodio().getPaciente().getTipoDocumento().setIdRegistro(entity.getIdTipoDocumentoCat02());
			bean.getEpisodio().getPaciente().setNroHC(entity.getNroHC());
			
	 	}
		
		return bean;
	}

	@Override
	public boolean existe(CuentaCorrienteBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CuentaCorrienteBean buscarPorNroEpisodioV2(CuentaCorrienteBean cuentaCorrienteBean) throws DAOException {
		CuentaCorrienteBean oCuentaCorrienteBean = null;	
		List<CuentaCorriente> lstCuentaCorriente = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("cuentaCorriente.buscaPorNumeroEpisodio");
			spq.setParameter("nroDocEpi", cuentaCorrienteBean.getEpisodio().getNumeroEpisodio()); 
			 
			 if (spq.execute()) {
				 lstCuentaCorriente =  spq.getResultList(); 
			 }
			 
			if (lstCuentaCorriente != null && lstCuentaCorriente.size() > 0) {
				oCuentaCorrienteBean = deObjetoAObjetoBean(lstCuentaCorriente.get(0));
			 }
			
			em.close(); 
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
		return oCuentaCorrienteBean;
	}

	

}
