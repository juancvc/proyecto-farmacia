package proyect.core.repository.interfaces.compra;

import java.util.List;

import proyect.base.repository.DAOException;
import proyect.base.repository.interfaces.BaseDAO;
import proyect.core.bean.compra.CompraBean; 

public interface CompraDAO  extends BaseDAO<CompraBean>{
	 
	public List<CompraBean >  buscarxFechaClienteVO(CompraBean  CompraBean ) throws DAOException;
	
	public boolean anularCompra(CompraBean Compra)throws DAOException; 
	 
	public String cantidadConLetra(float monto)throws DAOException;
	
	public CompraBean  findByIdCompra(CompraBean Compra)throws DAOException;
	
	public boolean cierreCompraDiaria(CompraBean Compra)throws DAOException; 
	
	public List<CompraBean > listarComprasAnuladasFindByObject(CompraBean Compra)throws DAOException;
	
	public List<CompraBean > listarComprasAnuladasFindByObjectPagante(CompraBean Compra)throws DAOException;
 
	public List<CompraBean > listarComprasDiarias(CompraBean Compra)throws DAOException;
	
	public List<CompraBean > listarAtencionesIME(CompraBean Compra) throws DAOException;
	
	public List<CompraBean > listarPacientes(CompraBean Compra) throws DAOException;
	
	public CompraBean  buscarPorNroDocumento(CompraBean Compra)throws DAOException;
	 
}
