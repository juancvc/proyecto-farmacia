package proyect.core.service.interfaces.compra;

import java.util.List;

import proyect.base.service.ServiceException;
import proyect.base.service.interfaces.BaseService;
import proyect.core.bean.compra.CompraBean; 

public interface CompraService extends BaseService<CompraBean> {
	  
	
	public boolean anularCompra(CompraBean Compra)throws ServiceException; 
	 
	public String cantidadConLetra(float monto)throws ServiceException; 
	
	public boolean cierreCompraDiaria(CompraBean Compra)throws ServiceException; 
	
	public List<CompraBean > listarComprasAnuladas(CompraBean Compra)throws ServiceException; 
 
	public List<CompraBean > listarComprasDiarias(CompraBean Compra)throws ServiceException; 
	
	public List<CompraBean > listarAtencionesIME(CompraBean Compra) throws ServiceException;
	
	public List<CompraBean > listarPacientes(CompraBean Compra) throws ServiceException;
	
	public CompraBean  buscarPorNroDocumento(CompraBean Compra) throws ServiceException;
	
	public CompraBean  totalCompra(int tipo, CompraBean venta) throws ServiceException;
}
