package proyect.core.repository.interfaces.movimiento;
 
import java.util.List;

import proyect.base.repository.DAOException;
import proyect.base.repository.interfaces.BaseDAO;
import proyect.core.bean.movimiento.MovimientoAlmacenBean;

 

public interface MovimientoAlmacenDAO extends BaseDAO<MovimientoAlmacenBean> {
	 
	public List<MovimientoAlmacenBean > listarReporteICI(MovimientoAlmacenBean venta)throws DAOException;
	
	public List<MovimientoAlmacenBean > buscarxArticuloAlmacen(MovimientoAlmacenBean movimientoAlmacenBean)throws DAOException;
	
}
