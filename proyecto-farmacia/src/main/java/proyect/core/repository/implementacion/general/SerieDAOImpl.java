package proyect.core.repository.implementacion.general;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import proyect.base.repository.DAOException;
import proyect.core.bean.general.SerieBean;
import proyect.core.entity.general.Serie;
import proyect.core.repository.interfaces.general.SerieDAO;
import proyect.web.utilitarios.VO; 

@Transactional
@Repository("serieDAO")
public class SerieDAOImpl implements SerieDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(SerieBean serie) throws DAOException {
		Object idSerie= null;
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("serie.insert");
		 
			spq.setParameter("nroSerie", serie.getNroSerie());
			spq.setParameter("idTipoComprobanteCat01", serie.getTipoComprobante().getIdRegistro()); 
			spq.setParameter("usuarioRegistro", serie.getUsuarioRegistro());
			spq.setParameter("ipRegistro", serie.getIpRegistro());
			spq.execute();
			
			idSerie = spq.getOutputParameterValue(1);
			if (VO.isNotNull(idSerie)) {
				serie.setCodigo(idSerie.toString());
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
	public boolean actualizar(SerieBean serie) throws DAOException {
		boolean sw=true;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("serie.update");
			
			spq.setParameter("idSerie",    		serie.getCodigo()); 
			spq.setParameter("usuarioModificacion", serie.getUsuarioRegistro());
			spq.setParameter("ipModificacion",      serie.getIpRegistro());
	
			spq.execute();
			
			em.close();
			
		} catch (Exception e) {
			sw=false;
			throw new DAOException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(SerieBean serie) throws DAOException {
		boolean sw=true;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("serie.delete");
			spq.setParameter("idSerie",    		serie.getCodigo());
			spq.setParameter("usuarioModificacion", serie.getUsuarioRegistro());
			spq.setParameter("ipModificacion",      serie.getIpRegistro());
			spq.execute();

			em.close();
			
		} catch (Exception e) {
			sw=false;
			throw new DAOException(e);
		}
		return sw;
	}

	@Override
	public SerieBean getBuscarPorObjecto(SerieBean serie) throws DAOException {
		List<Serie> lstSerie = null;	
	   SerieBean lstSerieBean = null;
		
	   System.out.println("serie.getCodigo() " + serie.getCodigo());
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("serie.buscarPorObjeto");  
			spq.setParameter("idSerie", serie.getCodigo()); 
			
			 if (spq.execute()) {
				 lstSerie =  spq.getResultList(); 
			 }
			 
			if (lstSerie != null && lstSerie.size() > 0) {
				lstSerieBean = deObjetoAObjetoBean(lstSerie.get(0));
			 }
			
			em.close();
			
		   
		return lstSerieBean;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SerieBean> getBuscarPorFiltros(SerieBean serie)
			throws DAOException {
		
		List<Serie> lstSerie = null;	
		List<SerieBean> lstSerieBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("serie.buscarPorFiltros");  
			spq.setParameter("idTipoComprobanteCat01", serie.getTipoComprobante().getIdRegistro()); 
			
			 if (spq.execute()) {
				 lstSerie =  spq.getResultList(); 
			 }
			 
			if (lstSerie != null && lstSerie.size() > 0) {
				lstSerieBean = deListaObjetoAListaObjetoBean(lstSerie);
			 }
			
			em.close();
			
		   
		return lstSerieBean;
	}
 

private List<SerieBean> deListaObjetoAListaObjetoBean(List<Serie> lstSerie) {
		
		List<SerieBean> lstSerieBean = null;
		
		if (lstSerie != null && lstSerie.size() > 0) {
			
			lstSerieBean = new ArrayList<SerieBean>();
			
			for (int i = 0; i < lstSerie.size(); i++) { 
				Serie entity = lstSerie.get(i);
				SerieBean bean = deObjetoAObjetoBean(entity);
				
				lstSerieBean.add(bean);
			}
		}
		
		return lstSerieBean;
	}
	
	private SerieBean deObjetoAObjetoBean(Serie entity) {
		
		SerieBean bean = null; 
		if (entity != null) {
			
			bean = new SerieBean();
			bean.setCodigo(entity.getIdSerie());   
			bean.setNroSerie(entity.getNroSerie());
			bean.getTipoComprobante().setIdRegistro(entity.getIdTipoComprobanteCat01());
	 	}
		
		return bean;
	}

	@Override
	public boolean existe(SerieBean t) throws DAOException {
		return false;
	}


}
