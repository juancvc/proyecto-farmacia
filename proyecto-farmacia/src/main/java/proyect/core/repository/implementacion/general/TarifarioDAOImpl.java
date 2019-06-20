package proyect.core.repository.implementacion.general;
 
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import proyect.core.bean.general.TablaBean;
import proyect.core.bean.general.TarifarioBean;
import proyect.core.entity.asistencial.laboratorio.Tarifario_laboratorio;
import proyect.core.entity.general_.Tgemae02;
import proyect.core.repository.DAOException;
import proyect.core.repository.interfaces.general.TarifarioDAO;



@Transactional
@Repository("TarifarioDAO")
public class TarifarioDAOImpl implements TarifarioDAO {

	@PersistenceContext//(unitName="emf")
	private EntityManager em;
	
	@Override
	public boolean insertar(TarifarioBean Tarifario) throws DAOException {
  
		Object idTarifario= null; 
		Object nroPeriodo= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("tarifario.registro");
			spq.setParameter("TG1TIPOT", Tarifario.getTipo().getCodReg()); 
		//	spq.setParameter("TIPO", Tarifario.getTipo().getNombreCorto()); 
			spq.setParameter("SUBTIPO", Tarifario.getSubtipo());  
			spq.setParameter("NOMPRODU", Tarifario.getDescripcion()); 
			spq.setParameter("PRECIO", Tarifario.getPrecio()); 
			spq.setParameter("TIPOUNID", ""); 
			spq.setParameter("VALREFIN", ""); 
			spq.setParameter("VALREFFI", ""); 
			spq.setParameter("AUDUSUCR", Tarifario.getCodigoUsuarioCreacion());  
			
			spq.execute();
			
			idTarifario = spq.getOutputParameterValue(1);
		//	nroPeriodo = spq.getOutputParameterValue(16);
			if (idTarifario != null) {
				Tarifario.setCodigo(idTarifario.toString());
			//	Tarifario.setNumeroPeriodo(nroPeriodo.toString());
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
	public boolean actualizar(TarifarioBean Tarifario) throws DAOException {
		Object idTarifario= null; 
	//	Object nroPeriodo= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("tarifario.actualizar");
			spq.setParameter("CODTARIF", Tarifario.getCodigo()); 
			spq.setParameter("TG1TIPOT", Tarifario.getTipo().getCodReg()); 
			spq.setParameter("TIPO", ""); 
			spq.setParameter("SUBTIPO", Tarifario.getSubtipo());  
			spq.setParameter("NOMPRODU", Tarifario.getDescripcion()); 
			spq.setParameter("PRECIO", Tarifario.getPrecio()); 
			spq.setParameter("TIPOUNID", ""); 
			spq.setParameter("VALREFIN", ""); 
			spq.setParameter("VALREFFI", ""); 
			spq.setParameter("AUCDUSCR", Tarifario.getCodigoUsuarioCreacion());  
			
			spq.execute();
			
		//	idTarifario = spq.getOutputParameterValue(1);
		//	nroPeriodo = spq.getOutputParameterValue(16);
			//if (idTarifario != null) {
				//Tarifario.setCodigo(idTarifario.toString());
			//	Tarifario.setNumeroPeriodo(nroPeriodo.toString());
				sw=true;
			//}
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public boolean eliminar(TarifarioBean Tarifario) throws DAOException {
		

		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("tarifario.eliminar");
			
			spq.setParameter("CODTARIF", Tarifario.getCodigo());  
			spq.setParameter("AUCDUSMO", Tarifario.getCodigoUsuarioModificacion());
			spq.setParameter("AUPCIPMO", Tarifario.getIpModificacion());

			
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
	public TarifarioBean getBuscarPorObjecto(TarifarioBean t) throws DAOException {
		
		return null;
	}

	@Override
	public List<TarifarioBean> getBuscarPorFiltros(TarifarioBean TarifarioBean)
			throws DAOException {
		
		List<Tarifario_laboratorio> lstMaestra = null;	
		List<TarifarioBean> lstTablaBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("tarifario.listarPorFiltros");
			spq.setParameter("TG1TIPOT", TarifarioBean.getTipo().getCodReg()); 
			spq.setParameter("DESCRIPC", TarifarioBean.getDescripcion()); 
			if (spq.execute()) {
				lstMaestra =  spq.getResultList(); 
			} 
			if (lstMaestra != null && lstMaestra.size() > 0) {
				
				lstTablaBean = deListaTarifariolaboratorioAListaTarifarioBean(lstMaestra);
			}
			em.close();
			
		   
		return lstTablaBean;
	}

	@Override
	public boolean existe(TarifarioBean t) throws DAOException {
		
		return false;
	}
 
	private List<TarifarioBean> deListaTarifariolaboratorioAListaTarifarioBean(List<Tarifario_laboratorio> lstTarifario_laboratorio) {
		
		List<TarifarioBean> lstlstTarifarioBean = null;
		
		if (lstTarifario_laboratorio != null && lstTarifario_laboratorio.size() > 0) {
			
			lstlstTarifarioBean = new ArrayList<TarifarioBean>();
			
			for (int i = 0; i < lstTarifario_laboratorio.size(); i++) { 
				Tarifario_laboratorio entity = lstTarifario_laboratorio.get(i);
				TarifarioBean bean = deTarifarioATarifarioBean(entity);
				
				lstlstTarifarioBean.add(bean);
			}
		}
		
		return lstlstTarifarioBean;
	}
	private TarifarioBean deTarifarioATarifarioBean(Tarifario_laboratorio entity) {
		
		TarifarioBean bean = null;
		
		if (entity != null) {
			
			bean = new TarifarioBean(); 
			bean.setCodigo(entity.getCODTARIF());
			bean.setTipo(new TablaBean());
			bean.getTipo().setNombreCorto(entity.getTIPO());
			bean.getTipo().setCodReg(entity.getTG1TIPOT());
			bean.setDescripcion(entity.getNOMPRODU());
			bean.setSubtipo(entity.getSUBTIPO());
			bean.setPrecio(entity.getPRECIO());
			bean.setsPrecio((getTwoDecimals(entity.getPRECIO()).replace(",", ".")));
		}
		
		return bean;
	}
 
	 private static String getTwoDecimals(double value){
	      DecimalFormat df = new DecimalFormat("0.00"); 
	      return df.format(value);
	    }
}
