package proyect.core.repository.interfaces.asistencial.laboratorio;
  
 
import java.util.List;

import proyect.core.bean.asistencial.laboratorio.OrdenDetalleBean;
import proyect.core.bean.general.PersonaBean;
import proyect.core.repository.DAOException;
import proyect.core.repository.interfaces.BaseDAO;

public interface OrdenDetalleDAO  extends BaseDAO<OrdenDetalleBean> {
	public boolean resultadoModificar(OrdenDetalleBean ordenDetalleBean)throws DAOException;
	public List<OrdenDetalleBean > getBuscarPorFiltrosReporte(OrdenDetalleBean ordenDetalleBean)throws DAOException;
  
}
