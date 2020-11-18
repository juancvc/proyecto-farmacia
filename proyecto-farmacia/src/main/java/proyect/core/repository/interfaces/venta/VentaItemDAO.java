package proyect.core.repository.interfaces.venta;

import java.util.List;

import proyect.base.repository.DAOException;
import proyect.base.repository.interfaces.BaseDAO;
import proyect.core.bean.general.EpisodioBean;
import proyect.core.bean.venta.VentaBean;
import proyect.core.bean.venta.VentaItemBean;


public interface VentaItemDAO  extends BaseDAO<VentaItemBean>{
	
	public List<VentaItemBean > listarArtPorEpisodio(EpisodioBean episodio) throws DAOException;
	
	public List<VentaItemBean > listarConsumoPaciente(VentaBean ventaBean) throws DAOException;
	
}
