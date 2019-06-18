package sigelab.core.service.implementacion.general;


import sigelab.core.bean.general.UbigeoBean;
import sigelab.core.repository.interfaces.general.UbigeoDAO;
import sigelab.core.service.exception.ServiceException;
import sigelab.core.service.interfaces.general.UbigeoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ubigeoService")
@Transactional (readOnly = true)
public class UbigeoServiceImpl implements UbigeoService {
	
	
	@Autowired
	 private UbigeoDAO ubigeoDAO;
	
	@Override
	public boolean insertar(UbigeoBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(UbigeoBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(UbigeoBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UbigeoBean getBuscarPorObjecto(UbigeoBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UbigeoBean> getBuscarPorFiltros(UbigeoBean t)
			throws ServiceException {
		List<UbigeoBean> lstUbigeoBean =  null;
		try {
			lstUbigeoBean = this.getUbigeoDAO().getBuscarPorFiltros(t);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstUbigeoBean;
	}

	@Override
	public boolean existe(UbigeoBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UbigeoBean> listarRegion()
			throws ServiceException {
		List<UbigeoBean> lstUbigeoBean =  null;
		try {
			lstUbigeoBean = this.getUbigeoDAO().listarRegion();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstUbigeoBean;
	}

	@Override
	public List<UbigeoBean> listarProvincia(UbigeoBean ubigeoBean)
			throws ServiceException {
		List<UbigeoBean> lstUbigeoBean =  null;
		try {
			lstUbigeoBean = this.getUbigeoDAO().listarProvincia(ubigeoBean);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstUbigeoBean;
	}

	@Override
	public List<UbigeoBean> listarDistrito(UbigeoBean ubigeoBean)
			throws ServiceException {
		List<UbigeoBean> lstUbigeoBean =  null;
		try {
			lstUbigeoBean = this.getUbigeoDAO().listarDistrito(ubigeoBean);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstUbigeoBean;
	}

	public UbigeoDAO getUbigeoDAO() {
		return ubigeoDAO;
	}

	public void setUbigeoDAO(UbigeoDAO ubigeoDAO) {
		this.ubigeoDAO = ubigeoDAO;
	}

	@Override
	public UbigeoBean buscarEquivalenteReniecMinsa(UbigeoBean ubigeoBean) {
		UbigeoBean oUbigeoBean =  null;
		try {
			oUbigeoBean = this.getUbigeoDAO().buscarEquivalenteReniecMinsa(ubigeoBean);
			
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return oUbigeoBean;
	}

	
}
