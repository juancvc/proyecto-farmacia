package proyect.core.service.interfaces.compra;

import java.util.List;

import proyect.base.service.ServiceException;
import proyect.base.service.interfaces.BaseService;
import proyect.core.bean.general.EpisodioBean;
import proyect.core.bean.compra.CompraBean;
import proyect.core.bean.compra.CompraItemBean;


public interface CompraItemService extends BaseService<CompraItemBean> {
	
	public List<CompraItemBean > listarArtPorEpisodio(EpisodioBean episodio) throws ServiceException;
	
	public List<CompraItemBean > listarConsumoPaciente(CompraBean CompraBean) throws ServiceException;
	
}
