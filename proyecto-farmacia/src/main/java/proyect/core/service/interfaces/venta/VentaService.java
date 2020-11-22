package proyect.core.service.interfaces.venta;

import java.util.List;

import proyect.base.service.ServiceException;
import proyect.base.service.interfaces.BaseService;
import proyect.core.bean.venta.VentaBean;


public interface VentaService extends BaseService<VentaBean> {
	  
	
	public boolean anularVenta(VentaBean venta)throws ServiceException; 
	 
	public String cantidadConLetra(float monto)throws ServiceException; 
	
	public boolean cierreVentaDiaria(VentaBean venta)throws ServiceException; 
	
	public List<VentaBean > listarVentasAnuladas(VentaBean venta)throws ServiceException; 
 
	public List<VentaBean > listarVentasDiarias(VentaBean venta)throws ServiceException; 
	
	public List<VentaBean > listarAtencionesIME(VentaBean venta) throws ServiceException;
	
	public List<VentaBean > listarPacientes(VentaBean venta) throws ServiceException;
	
	public VentaBean  buscarPorNroDocumento(VentaBean venta) throws ServiceException;
	
	public VentaBean  totalVenta(int tipo, VentaBean venta) throws ServiceException;
	
	public List<VentaBean>  listaMensual(VentaBean venta) throws ServiceException;
	
	public  List<VentaBean> reporteVentaTipoPaciente(int tipo, VentaBean venta) throws ServiceException;
	
}
