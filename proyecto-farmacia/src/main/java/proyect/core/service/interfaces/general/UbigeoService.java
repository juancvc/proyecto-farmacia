package proyect.core.service.interfaces.general;
import java.util.List;

import proyect.core.bean.general.UbigeoBean;
import proyect.base.service.ServiceException;
import proyect.base.service.interfaces.BaseService;




public interface UbigeoService extends BaseService<UbigeoBean>{
	public List<UbigeoBean> listarRegion() throws ServiceException;
	public List<UbigeoBean> listarProvincia(UbigeoBean ubigeoBean) throws ServiceException;
	public List<UbigeoBean> listarDistrito(UbigeoBean ubigeoBean)throws ServiceException;
	public UbigeoBean buscarEquivalenteReniecMinsa(UbigeoBean ubigeoBean);
}
