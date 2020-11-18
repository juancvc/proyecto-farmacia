package proyect.core.repository.interfaces.cuentaCorriente;

import java.util.List;

import proyect.base.repository.DAOException;
import proyect.base.repository.interfaces.BaseDAO;
import proyect.core.bean.cuentaCorriente.CuentaCorrienteBean;
import proyect.core.bean.venta.VentaBean;

 

public interface CuentaCorrienteDAO extends BaseDAO<CuentaCorrienteBean> {
	 
	public List<CuentaCorrienteBean > listarCtaCtePacientePendientes(CuentaCorrienteBean cuentaCorrienteBean) throws DAOException;
}
