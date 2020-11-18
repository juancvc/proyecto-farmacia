package proyect.core.service.interfaces.movimiento;

import java.util.List;


import proyect.base.service.ServiceException;
import proyect.base.service.interfaces.BaseService;
import proyect.core.bean.movimiento.MovimientoAlmacenBean;




public interface MovimientoAlmacenService extends BaseService<MovimientoAlmacenBean> {
	
	public List<MovimientoAlmacenBean > listarReporteICI(MovimientoAlmacenBean movimientoAlmacenBean)throws ServiceException;   
	
	public List<MovimientoAlmacenBean > buscarxArticuloAlmacen(MovimientoAlmacenBean movimientoAlmacenBean)throws ServiceException; 
	
	/*
	public boolean anularVenta(VentaBean venta)throws ServiceException; 

	 
	public boolean cierreVentaDiaria(VentaBean venta)throws ServiceException; 
	
	public List<VentaBean > listarVentasAnuladas(VentaBean venta)throws ServiceException; 
 
	
	public List<VentaBean > listarAtencionesIME(VentaBean venta) throws ServiceException;*/
}
