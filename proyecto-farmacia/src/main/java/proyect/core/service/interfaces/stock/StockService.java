package proyect.core.service.interfaces.stock;

import java.util.List;

import proyect.base.service.ServiceException;
import proyect.base.service.interfaces.BaseService;
import proyect.core.bean.stock.ArticuloBean;
import proyect.core.bean.stock.StockBean;



public interface StockService extends BaseService<StockBean> {
	 
	public List<StockBean > listarPorIdArticulo(ArticuloBean articuloBean) throws ServiceException;
	
	/*
	public boolean anularVenta(VentaBean venta)throws ServiceException; 
	 
	 
	public boolean cierreVentaDiaria(VentaBean venta)throws ServiceException; 
	
	public List<VentaBean > listarVentasAnuladas(VentaBean venta)throws ServiceException; 
 
	
	public List<VentaBean > listarAtencionesIME(VentaBean venta) throws ServiceException;*/
}
