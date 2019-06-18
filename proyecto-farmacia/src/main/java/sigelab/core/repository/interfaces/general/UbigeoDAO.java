package sigelab.core.repository.interfaces.general;

import sigelab.core.bean.general.UbigeoBean;
import sigelab.core.repository.DAOException;
import sigelab.core.repository.interfaces.BaseDAO;

import java.util.List;



public interface UbigeoDAO extends BaseDAO<UbigeoBean>{

	public List<UbigeoBean> listarRegion() throws DAOException;
	public List<UbigeoBean> listarProvincia(UbigeoBean ubigeoBean) throws DAOException;
	public List<UbigeoBean> listarDistrito(UbigeoBean ubigeoBean)throws DAOException;
	public UbigeoBean buscarEquivalenteReniecMinsa(UbigeoBean ubigeoBean);
}
