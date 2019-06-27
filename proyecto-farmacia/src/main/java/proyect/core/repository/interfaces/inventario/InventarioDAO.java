package proyect.core.repository.interfaces.inventario;
 
import proyect.base.repository.DAOException;
import proyect.base.repository.interfaces.BaseDAO;
import proyect.core.bean.inventario.InventarioBean;
import java.util.List;

public interface InventarioDAO extends BaseDAO<InventarioBean> {
	 
	public List<InventarioBean> listarBuscarxNroDocumento(InventarioBean inventarioBean);
	public boolean insertarHistorico(InventarioBean inventarioBean) throws DAOException;
}
