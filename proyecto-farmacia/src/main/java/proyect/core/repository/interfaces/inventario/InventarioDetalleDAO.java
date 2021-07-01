package proyect.core.repository.interfaces.inventario;
 
import java.util.List;

import proyect.base.repository.DAOException;
import proyect.base.repository.interfaces.BaseDAO;
import proyect.core.bean.inventario.InventarioBean;
import proyect.core.bean.inventario.InventarioDetalleBean;
 

public interface InventarioDetalleDAO extends BaseDAO<InventarioDetalleBean> {
	 
	public List<InventarioDetalleBean> listarReporteProceso(InventarioBean inventarioBean) throws DAOException;;
	
}
