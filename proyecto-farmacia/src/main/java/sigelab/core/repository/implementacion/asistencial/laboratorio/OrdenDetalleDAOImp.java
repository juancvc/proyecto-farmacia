package sigelab.core.repository.implementacion.asistencial.laboratorio;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sigelab.core.bean.asistencial.laboratorio.OrdenDetalleBean;
import sigelab.core.bean.general.PersonaBean;
import sigelab.core.bean.general.TablaBean;
import sigelab.core.bean.general.TarifarioBean;
import sigelab.core.bean.general.TarifarioDetalleBean;
import sigelab.core.entity.asistencial.laboratorio.Orden_detalle_laboratorio;
import sigelab.core.repository.DAOException;
import sigelab.core.repository.interfaces.asistencial.laboratorio.OrdenDetalleDAO; 

@Transactional
@Repository("OrdenDetalleDAOImp")
public class OrdenDetalleDAOImp implements OrdenDetalleDAO {

	@PersistenceContext//(unitName="emf")
	private EntityManager em; 
	
	
	public OrdenDetalleBean getOrdenDetalleBean(Object object){
		return (OrdenDetalleBean)object;
	}
	
	@Override
	public boolean insertar(OrdenDetalleBean OrdenDetalleBean) throws DAOException {

		Object id= null;   
		
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("OrdenDetalle.insertar"); 
			spq.setParameter("CODORGAN", OrdenDetalleBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", OrdenDetalleBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", OrdenDetalleBean.getCodigoSede()); 
			 
			spq.setParameter("SITUACRG", OrdenDetalleBean.getSituacion().getCodReg());
			
			spq.setParameter("AUCDUSCR", OrdenDetalleBean.getCodigoUsuarioCreacion());
			spq.setParameter("AUPCIPCR", OrdenDetalleBean.getIpCreacion());
			 
			
			
			spq.execute();
			
			id = spq.getOutputParameterValue(4); 
			
			if (id != null) {
				OrdenDetalleBean.setCodigo(id.toString()); 
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
	public boolean actualizar(OrdenDetalleBean OrdenDetalleBean) throws DAOException {

		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("OrdenDetalle.modificar"); 
			spq.setParameter("CODORGAN", OrdenDetalleBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", OrdenDetalleBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", OrdenDetalleBean.getCodigoSede()); 
			spq.setParameter("CODCAMPA", OrdenDetalleBean.getCodigo());
			spq.setParameter("NROPERIO", OrdenDetalleBean.getNumeroPeriodo()); 
			spq.setParameter("SITUACRG", OrdenDetalleBean.getSituacion().getCodReg()); 
			
			spq.setParameter("AUCDUSMO", OrdenDetalleBean.getCodigoUsuarioModificacion());
			spq.setParameter("AUPCIPMO", OrdenDetalleBean.getIpModificacion()); 
			
			spq.execute();  
			sw=true;
			 
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public boolean eliminar(OrdenDetalleBean OrdenDetalleBean) throws DAOException {

		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("OrdenDetalle.eliminar"); 
			spq.setParameter("CODORGAN", OrdenDetalleBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", OrdenDetalleBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", OrdenDetalleBean.getCodigoSede()); 
			spq.setParameter("CODCAMPA", OrdenDetalleBean.getCodigo());
			spq.setParameter("NROPERIO", OrdenDetalleBean.getNumeroPeriodo()); 
			
			spq.setParameter("AUCDUSMO", OrdenDetalleBean.getCodigoUsuarioModificacion());
			spq.setParameter("AUPCIPMO", OrdenDetalleBean.getIpModificacion()); 
			
			spq.execute();  
			sw=true;
			 
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public OrdenDetalleBean getBuscarPorObjecto(OrdenDetalleBean t) throws DAOException {

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrdenDetalleBean> getBuscarPorFiltros(OrdenDetalleBean OrdenDetalleBean) throws DAOException {
		List<Orden_detalle_laboratorio> lstOrdenDetalle = null;	
		List<OrdenDetalleBean> lstOrdenDetalleBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("ordenDetalle.buscarPorFiltros");   
			spq.setParameter("CODORGAN", OrdenDetalleBean.getOrdenBean().getCodigoOrganizacion());
			spq.setParameter("CODINSTI", OrdenDetalleBean.getOrdenBean().getCodigoInstitucion());
			spq.setParameter("CODSEDEI", OrdenDetalleBean.getOrdenBean().getCodigoSede()); 
			spq.setParameter("CODORDEN", OrdenDetalleBean.getOrdenBean().getCodigo()); 
			spq.setParameter("NROVEORD", OrdenDetalleBean.getOrdenBean().getNumeroVersion()); 
			spq.setParameter("NROPEORD", OrdenDetalleBean.getOrdenBean().getNumeroPeriodo()); 
			
			 if (spq.execute()) {
				 lstOrdenDetalle =  spq.getResultList(); 
			 }
			 
			if (lstOrdenDetalle != null && lstOrdenDetalle.size() > 0) {
				lstOrdenDetalleBean = deListaObjetoAListaObjetoBean(lstOrdenDetalle);
			 }
			
			em.close();
			
		   
		return lstOrdenDetalleBean;
	}
	
	 

private List<OrdenDetalleBean> deListaObjetoAListaObjetoBean(List<Orden_detalle_laboratorio> lstOrdenDetalle) {
		
		List<OrdenDetalleBean> lstOrdenDetalleBean = null;
		
		if (lstOrdenDetalle != null && lstOrdenDetalle.size() > 0) {
			
			lstOrdenDetalleBean = new ArrayList<OrdenDetalleBean>();
			
			for (int i = 0; i < lstOrdenDetalle.size(); i++) { 
				Orden_detalle_laboratorio entity = lstOrdenDetalle.get(i);
				OrdenDetalleBean bean = deObjetoAObjetoBean(entity);
				
				lstOrdenDetalleBean.add(bean);
			}
		}
		
		return lstOrdenDetalleBean;
	}
	
	private OrdenDetalleBean deObjetoAObjetoBean(Orden_detalle_laboratorio entity) {
		
		OrdenDetalleBean bean = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		if (entity != null) {
			
			bean = new OrdenDetalleBean();
			bean.setCodigo(entity.getId().getCodOrdde());  
			bean.setCodigoInstitucion(entity.getId().getCodinsti());  
			bean.setCodigoSede(entity.getId().getCodsedei());  
			bean.setCodigoOrganizacion(entity.getId().getCodorgan());
			bean.setNumeroVersion(entity.getId().getNroversi());
			bean.setNumeroPeriodo(entity.getId().getNroperio());
			 
			bean.getSituacion().setCodReg(entity.getSituacRg()); 
			bean.setCantidad(entity.getCantidad());
			bean.setImporte(entity.getImporte());
			bean.setResultado(entity.getResultado());
			bean.setPrecio(entity.getPrecio());
			bean.setExamen(new TarifarioBean());
			bean.getExamen().setDescripcion(entity.getNOMPRODU());
			bean.getExamen().setCodigo(entity.getCodTarif());
			bean.getExamen().setPrecio(entity.getPrecio());
			bean.getExamen().setTipo(new TablaBean());
			bean.getExamen().getTipo().setNombreCorto(entity.getNOMTPEXA());
			bean.getExamen().setTarifarioDetalleBean(new TarifarioDetalleBean());
			bean.getExamen().getTarifarioDetalleBean().setObservacion(entity.getOBSERVAC());
			bean.getExamen().getTarifarioDetalleBean().setUnidades(entity.getUNIDADES());
			bean.getExamen().getTarifarioDetalleBean().setValoresRefIni(entity.getVALORINI());
			bean.getExamen().getTarifarioDetalleBean().setValoresRefFin(entity.getVALORFIN());
			bean.getExamen().setsPrecio((getTwoDecimals(entity.getPrecio()).replace(",", ".")));
			bean.setsImporte((getTwoDecimals(entity.getImporte()).replace(",", ".")));
			
	 	}
		
		return bean;
	}

	private static String getTwoDecimals(double value){
	      DecimalFormat df = new DecimalFormat("0.00"); 
	      return df.format(value);
	    }
	
	@Override
	public boolean existe(OrdenDetalleBean t) throws DAOException {

		return false;
	}

	@Override
	public boolean resultadoModificar(OrdenDetalleBean ordenDetalleBean) throws DAOException {
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("ordenDetalleResultado.modificar");
			spq.setParameter("CODORDDE", ordenDetalleBean.getCodigo());
			spq.setParameter("NROPERIO", ordenDetalleBean.getNumeroPeriodo()); 
			spq.setParameter("CODORGAN", ordenDetalleBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", ordenDetalleBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", ordenDetalleBean.getCodigoSede()); 
	
			spq.setParameter("RESULTADO", ordenDetalleBean.getResultado()); 
			
			spq.setParameter("AUCDUSMO", ordenDetalleBean.getCodigoUsuarioModificacion());
			spq.setParameter("AUPCIPMO", ordenDetalleBean.getIpModificacion()); 
			
			spq.execute();  
			sw=true;
			 
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public List<OrdenDetalleBean> getBuscarPorFiltrosReporte(OrdenDetalleBean ordenDetalleBean) throws DAOException {
		// TODO Auto-generated method stub
		List<Orden_detalle_laboratorio> lstOrdenDetalle = null;	
		List<OrdenDetalleBean> lstOrdenDetalleBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("ordenDetalle.buscarPorFiltrosReporte");   
			spq.setParameter("CODORGAN", ordenDetalleBean.getOrdenBean().getCodigoOrganizacion());
			spq.setParameter("CODINSTI", ordenDetalleBean.getOrdenBean().getCodigoInstitucion());
			spq.setParameter("CODSEDEI", ordenDetalleBean.getOrdenBean().getCodigoSede()); 
			spq.setParameter("CODORDEN", ordenDetalleBean.getOrdenBean().getCodigo()); 
			spq.setParameter("NROVEORD", ordenDetalleBean.getOrdenBean().getNumeroVersion()); 
			spq.setParameter("NROPEORD", ordenDetalleBean.getOrdenBean().getNumeroPeriodo()); 
			
			 if (spq.execute()) {
				 lstOrdenDetalle =  spq.getResultList(); 
			 }
			 
			if (lstOrdenDetalle != null && lstOrdenDetalle.size() > 0) {
				lstOrdenDetalleBean = deListaObjetoAListaObjetoBean(lstOrdenDetalle);
			 }
			
			em.close();
			
		   
		return lstOrdenDetalleBean;
	}

	 

}
