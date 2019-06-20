package proyect.core.repository.interfaces.general;

import java.util.List;

import proyect.core.bean.general.UbigeoBean;
import proyect.core.repository.DAOException;
import proyect.core.repository.interfaces.BaseDAO;



public interface UbigeoDAO extends BaseDAO<UbigeoBean>{

	public List<UbigeoBean> listarRegion() throws DAOException;
	public List<UbigeoBean> listarProvincia(UbigeoBean ubigeoBean) throws DAOException;
	public List<UbigeoBean> listarDistrito(UbigeoBean ubigeoBean)throws DAOException;
	public UbigeoBean buscarEquivalenteReniecMinsa(UbigeoBean ubigeoBean);
}
