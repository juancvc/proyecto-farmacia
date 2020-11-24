package proyect.core.repository.implementacion.compra;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.icu.text.DecimalFormat;

import proyect.base.repository.DAOException;
import proyect.core.bean.general.EpisodioBean;
import proyect.core.bean.compra.CompraBean;
import proyect.core.bean.compra.CompraItemBean;
import proyect.core.entity.compra.Compra;
import proyect.core.entity.compra.CompraItem;
import proyect.core.repository.interfaces.compra.CompraItemDAO;
import proyect.web.utilitarios.VO; 

@Transactional
@Repository("CompraItemDAO")
public class CompraItemDAOImpl implements CompraItemDAO{
	
	@PersistenceContext
	private EntityManager em;

	public CompraItemDAOImpl() {
		
	}

	@Override
	public boolean insertar(CompraItemBean t) throws DAOException {
		return false;
	}

	@Override
	public boolean actualizar(CompraItemBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(CompraItemBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CompraItemBean getBuscarPorObjecto(CompraItemBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompraItemBean> getBuscarPorFiltros(CompraItemBean CompraItem) throws DAOException {
		List<CompraItem> lstCompra = null;	
		List<CompraItemBean> lstCompraBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("CompraItem.buscarPorCriterios"); 
			spq.setParameter("idCompra", CompraItem.getCompra().getCodigo()); 	
			spq.setParameter("numeroPeriodo", CompraItem.getCompra().getNumeroPeriodo()); 
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

	@Override
	public boolean existe(CompraItemBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

private static String getTwoDecimals(double value){
      DecimalFormat df = new DecimalFormat("0.00"); 
      return df.format(value);
}
	
private List<CompraItemBean> deListaObjetoAListaObjetoBean(List<CompraItem> lstCompra) {
		
		List<CompraItemBean> lstCompraBean = null;
		
		if (lstCompra != null && lstCompra.size() > 0) {
			
		lstCompraBean = new ArrayList<CompraItemBean>();
			
		for (int i = 0; i < lstCompra.size(); i++) { 
			CompraItem entity = lstCompra.get(i);
			CompraItemBean bean = deObjetoAObjetoBean(entity);
				
		lstCompraBean.add(bean);
		}
		}	
		return lstCompraBean;
	}
	
	private CompraItemBean deObjetoAObjetoBean(CompraItem entity) {
		
		CompraItemBean bean = null; 
		if (entity != null) {
			bean = new CompraItemBean();
			bean.setCodigo(entity.getId().getIdCompraItem());  
			bean.setNumeroPeriodo(entity.getId().getNumeroPeriodo()); 
			bean.getCompra().setNumeroDocumento(entity.getNumero());
			bean.getCompra().setFechaEmision(entity.getFechaEmision());
			bean.getCompra().setCodigo(entity.getIdCompra());
			bean.setCantidad(entity.getCantidad());
			bean.getStock().getArticulo().setNombre(entity.getNombreArticulo());
			bean.getStock().getArticulo().getTipoPresentacion().setDescripcionCorta(entity.getDescripcionCortaPresentacion());
			bean.getStock().setsPrecio((getTwoDecimals(entity.getPrecio()).replace(",", ".")));
			bean.setsSubTotal((getTwoDecimals(entity.getSubtotal()).replace(",", ".")));
			bean.setUsuarioRegistro(entity.getUsuarioRegistro()); 
	 	}
		
		return bean;
	}

	@Override
	public List<CompraItemBean> listarArtPorEpisodio(EpisodioBean episodio) throws DAOException {
		List<CompraItem> lstCompra = null;	
		List<CompraItemBean> lstCompraBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("CompraItem.buscarPorEpisodio"); 
			spq.setParameter("idEpisodio", episodio.getCodigo()); 	
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

	@Override
	public List<CompraItemBean> listarConsumoPaciente(CompraBean CompraBean) throws DAOException {
		List<CompraItem> lstCompra = null;	
		List<CompraItemBean> lstCompraBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("CompraItem.listarConsumoPaciente"); 
			//spq.setParameter("idPersona", CompraBean.getPersona().getCodigo()); 	
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
}
