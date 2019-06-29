package proyect.core.service.implementacion.stock;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyect.base.repository.DAOException;
import proyect.base.service.ServiceException;
import proyect.core.bean.stock.LaboratorioBean;
import proyect.core.repository.interfaces.stock.LaboratorioDAO;
import proyect.core.service.interfaces.stock.LaboratorioService;

@Service("laboratorioService")
public class LaboratorioServiceImpl implements LaboratorioService {
	
	
	@Autowired
	private LaboratorioDAO laboratorioDAO; 

	public LaboratorioServiceImpl() {
	}

	@Override
	public boolean insertar(LaboratorioBean stockBean) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getLaboratorioDAO().insertar(stockBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}
   
	@Override
	public boolean actualizar(LaboratorioBean stockBean) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getLaboratorioDAO().actualizar(stockBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(LaboratorioBean stockBean) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getLaboratorioDAO().eliminar(stockBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public LaboratorioBean getBuscarPorObjecto(LaboratorioBean stockBean) throws ServiceException {
		LaboratorioBean oPedido=null;
		try {
			oPedido=this.getLaboratorioDAO().getBuscarPorObjecto(stockBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oPedido;
	}

	@Override
	public List<LaboratorioBean> getBuscarPorFiltros(LaboratorioBean stockBean)
			throws ServiceException {
		List<LaboratorioBean> lstPedido=null;
		try {
			lstPedido=this.getLaboratorioDAO().getBuscarPorFiltros(stockBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return lstPedido;
	}
 
 


	public LaboratorioDAO getLaboratorioDAO() {
		return laboratorioDAO;
	}

	public void setLaboratorioDAO(LaboratorioDAO laboratorioDAO) {
		this.laboratorioDAO = laboratorioDAO;
	}

	@Override
	public boolean existe(LaboratorioBean t) throws ServiceException { 
		return false;
	}
  

}

	
