package proyect.core.service.interfaces.venta;

import java.util.List;

import proyect.base.service.ServiceException;
import proyect.base.service.interfaces.BaseService;
import proyect.core.bean.general.EpisodioBean;
import proyect.core.bean.venta.VentaBean;
import proyect.core.bean.venta.VentaItemBean;


public interface VentaItemService extends BaseService<VentaItemBean> {
	
	public List<VentaItemBean > listarArtPorEpisodio(EpisodioBean episodio) throws ServiceException;
	
	public List<VentaItemBean > listarConsumoPaciente(VentaBean ventaBean) throws ServiceException;
	
}
