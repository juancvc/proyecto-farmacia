package sigelab.core.repository.interfaces.asistencial.laboratorio;
  
 
import java.util.List;

import sigelab.core.bean.asistencial.laboratorio.OrdenDetalleBean;
import sigelab.core.bean.general.PersonaBean;
import sigelab.core.repository.DAOException;
import sigelab.core.repository.interfaces.BaseDAO;

public interface OrdenDetalleDAO  extends BaseDAO<OrdenDetalleBean> {
	public boolean resultadoModificar(OrdenDetalleBean ordenDetalleBean)throws DAOException;
	public List<OrdenDetalleBean > getBuscarPorFiltrosReporte(OrdenDetalleBean ordenDetalleBean)throws DAOException;
  
}
