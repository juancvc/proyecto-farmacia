package proyect.core.service.interfaces.venta;

import java.util.List;

import proyect.base.service.ServiceException;
import proyect.base.service.interfaces.BaseService;
import proyect.core.bean.venta.VentaBean;


public interface VentaService extends BaseService<VentaBean> {
	  
	
	public boolean anularVenta(VentaBean venta)throws ServiceException; 
	 
	 
	public boolean cierreVentaDiaria(VentaBean venta)throws ServiceException; 
	
	public List<VentaBean > listarVentasAnuladas(VentaBean venta)throws ServiceException; 
 
	
	public List<VentaBean > listarAtencionesIME(VentaBean venta) throws ServiceException;
}
