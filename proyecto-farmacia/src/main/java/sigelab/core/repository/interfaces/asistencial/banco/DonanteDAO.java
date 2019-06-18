package sigelab.core.repository.interfaces.asistencial.banco;
  
 
import sigelab.core.bean.asistencial.banco.DonanteBean;
import sigelab.core.repository.DAOException;
import sigelab.core.repository.interfaces.BaseDAO;

public interface DonanteDAO  extends BaseDAO<DonanteBean> {
	
	public DonanteBean buscarUltimaDonacion(DonanteBean DonanteBean); 
	
	public boolean insertarVoluntario(DonanteBean t) throws DAOException;
  
}
