package proyect.core.service.implementacion.compra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyect.base.repository.DAOException;
import proyect.base.service.ServiceException;
import proyect.core.bean.general.EpisodioBean;
import proyect.core.bean.compra.CompraBean;
import proyect.core.bean.compra.CompraItemBean;
import proyect.core.repository.interfaces.compra.CompraItemDAO;
import proyect.core.service.interfaces.compra.CompraItemService; 

@Service("CompraItemService")
public class CompraItemServiceImpl implements CompraItemService {
	
	
	@Autowired
	private CompraItemDAO CompraItemDAO; 

	public CompraItemServiceImpl() {
	}

	@Override
	public boolean insertar(CompraItemBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(CompraItemBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(CompraItemBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CompraItemBean getBuscarPorObjecto(CompraItemBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompraItemBean> getBuscarPorFiltros(CompraItemBean t) throws ServiceException {
		List<CompraItemBean> lstPedido=null;
		try {
			lstPedido=CompraItemDAO.getBuscarPorFiltros(t);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return lstPedido;
	}

	@Override
	public boolean existe(CompraItemBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CompraItemBean> listarArtPorEpisodio(EpisodioBean episodio) throws ServiceException {
		List<CompraItemBean> lstPedido=null;
		try {
			lstPedido=CompraItemDAO.listarArtPorEpisodio(episodio);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return lstPedido;
	}

	@Override
	public List<CompraItemBean> listarConsumoPaciente(CompraBean CompraBean) throws ServiceException {
		List<CompraItemBean> lstPedido=null;
		try {
			lstPedido=CompraItemDAO.listarConsumoPaciente(CompraBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return lstPedido;
	}

}

	
