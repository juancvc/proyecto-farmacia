package sigelab.core.service.implementacion.asistencial.banco;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sigelab.core.bean.asistencial.banco.PostulanteBean;
import sigelab.core.repository.DAOException; 
import sigelab.core.service.exception.ServiceException;
import sigelab.core.service.interfaces.asistencial.banco.PostulanteService;
import sigelab.core.repository.interfaces.asistencial.banco.PostulanteDAO ;

@Service("PostulanteServiceImp")
@Transactional(readOnly = true)
public class PostulanteServiceImp implements PostulanteService {

	@Autowired
    PostulanteDAO PostulanteDAO;

	@Override
	public boolean insertar(PostulanteBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  PostulanteDAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(PostulanteBean t) throws ServiceException {
	
		Boolean sw = false;
		try {
			sw =  PostulanteDAO.actualizar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(PostulanteBean t) throws ServiceException {
	
		Boolean sw = false;
		try {
			sw =  PostulanteDAO.eliminar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public PostulanteBean getBuscarPorObjecto(PostulanteBean t) throws ServiceException {
	
		PostulanteBean oPostulanteBean = null;
		try {
			oPostulanteBean = PostulanteDAO.getBuscarPorObjecto(t);
		} catch (Exception e) {

		}
		return oPostulanteBean;
	}

	@Override
	public List<PostulanteBean> getBuscarPorFiltros(PostulanteBean t) throws ServiceException {
		List<PostulanteBean> lstPostulanteBean = null;
		try {
			lstPostulanteBean = PostulanteDAO.getBuscarPorFiltros(t);
		} catch (Exception e) {

		}
		return lstPostulanteBean;
	}

	@Override
	public boolean existe(PostulanteBean t) throws ServiceException {
	
		return false;
	}

	@Override
	public PostulanteBean buscarUltimaDonacion(PostulanteBean PostulanteBean) {
		PostulanteBean oPostulanteBean = null;
		try {
			oPostulanteBean = PostulanteDAO.buscarUltimaDonacion(PostulanteBean);
		} catch (Exception e) {

		}
		return oPostulanteBean;
	}

	@Override
	public List<PostulanteBean> listarPostulantesEstadoFisico(PostulanteBean PostulanteBean) {
		List<PostulanteBean> lstPostulanteBean = null;
		try {
			lstPostulanteBean = PostulanteDAO.listarPostulantesEstadoFisico(PostulanteBean);
		} catch (Exception e) {

		}
		return lstPostulanteBean;
	}

	@Override
	public PostulanteBean obtenerPostulantesEstadoFisico(PostulanteBean PostulanteBean) {
		PostulanteBean oPostulanteBean = null;
		try {
			oPostulanteBean = PostulanteDAO.obtenerPostulantesEstadoFisico(PostulanteBean);
		} catch (Exception e) {

		}
		return oPostulanteBean;
	}

	@Override
	public List<PostulanteBean> listarPreDonantes(PostulanteBean PostulanteBean) {
		List<PostulanteBean> lstPostulanteBean = null;
		try {
			lstPostulanteBean = PostulanteDAO.listarPreDonantes(PostulanteBean);
		} catch (Exception e) {

		}
		return lstPostulanteBean;
	}

	@Override
	public List<PostulanteBean> litarEstadoFisicaPorPerso(PostulanteBean PostulanteBean) {
		List<PostulanteBean> lstPostulanteBean = null;
		try {
			lstPostulanteBean = PostulanteDAO.litarEstadoFisicaPorPerso(PostulanteBean);
		} catch (Exception e) {

		}
		return lstPostulanteBean;
	}
 

}
