package proyect.core.repository.interfaces.asistencial.banco;
  
  

import java.util.List;

import proyect.core.bean.asistencial.banco.PostulanteBean;
import proyect.core.repository.interfaces.BaseDAO;

public interface PostulanteDAO  extends BaseDAO<PostulanteBean> {
	
	public PostulanteBean buscarUltimaDonacion(PostulanteBean PostulanteBean);
	
	public List<PostulanteBean> listarPostulantesEstadoFisico(PostulanteBean PostulanteBean);
	
	public List<PostulanteBean> listarPreDonantes(PostulanteBean PostulanteBean);
	
	public PostulanteBean obtenerPostulantesEstadoFisico(PostulanteBean PostulanteBean);
	
	public List<PostulanteBean> litarEstadoFisicaPorPerso(PostulanteBean PostulanteBean);
  
}
