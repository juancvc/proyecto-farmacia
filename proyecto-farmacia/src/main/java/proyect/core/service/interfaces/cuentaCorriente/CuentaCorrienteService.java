package proyect.core.service.interfaces.cuentaCorriente;

import java.util.List;


import proyect.base.service.ServiceException;
import proyect.base.service.interfaces.BaseService;
import proyect.core.bean.cuentaCorriente.CuentaCorrienteBean;


public interface CuentaCorrienteService extends BaseService<CuentaCorrienteBean> {
	

	public List<CuentaCorrienteBean > listarCtaCtePacientePendientes(CuentaCorrienteBean cuentaCorrienteBean) throws ServiceException;
	
	
}
