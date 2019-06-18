package sigelab.core.service.interfaces.general;
import sigelab.core.bean.general.UbigeoBean;
import sigelab.core.service.exception.ServiceException;
import sigelab.core.service.interfaces.BaseService;

import java.util.List;




public interface UbigeoService extends BaseService<UbigeoBean>{
	public List<UbigeoBean> listarRegion() throws ServiceException;
	public List<UbigeoBean> listarProvincia(UbigeoBean ubigeoBean) throws ServiceException;
	public List<UbigeoBean> listarDistrito(UbigeoBean ubigeoBean)throws ServiceException;
	public UbigeoBean buscarEquivalenteReniecMinsa(UbigeoBean ubigeoBean);
}
