package proyect.core.repository.interfaces.venta;

import java.util.List;

import proyect.base.repository.DAOException;
import proyect.base.repository.interfaces.BaseDAO;
import proyect.core.bean.venta.VentaBean; 

public interface VentaDAO  extends BaseDAO<VentaBean>{
	 
	public List<VentaBean >  buscarxFechaClienteVO(VentaBean  VentaBean ) throws DAOException;
	
	public boolean anularVenta(VentaBean venta)throws DAOException; 
	 
	public String cantidadConLetra(float monto)throws DAOException;
	
	public VentaBean  findByIdVenta(VentaBean venta)throws DAOException;
	
	public boolean cierreVentaDiaria(VentaBean venta)throws DAOException; 
	
	public List<VentaBean > listarVentasAnuladasFindByObject(VentaBean venta)throws DAOException;
	
	public List<VentaBean > listarVentasAnuladasFindByObjectPagante(VentaBean venta)throws DAOException;
 
	public List<VentaBean > listarVentasDiarias(VentaBean venta)throws DAOException;
	
	public List<VentaBean > listarAtencionesIME(VentaBean venta) throws DAOException;
	
	public List<VentaBean > listarPacientes(VentaBean venta) throws DAOException;
	
	public VentaBean  buscarPorNroDocumento(VentaBean venta)throws DAOException;
	 
}
