package proyect.core.repository.interfaces.asistencial.banco;
  
 
import proyect.core.bean.asistencial.banco.DonanteBean;
import proyect.core.repository.DAOException;
import proyect.core.repository.interfaces.BaseDAO;

public interface DonanteDAO  extends BaseDAO<DonanteBean> {
	
	public DonanteBean buscarUltimaDonacion(DonanteBean DonanteBean); 
	
	public boolean insertarVoluntario(DonanteBean t) throws DAOException;
  
}
