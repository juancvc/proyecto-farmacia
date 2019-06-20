package proyect.core.service.interfaces.asistencial.banco;
 
 
import java.util.List;

import proyect.core.bean.asistencial.banco.PostulanteBean;
import proyect.core.service.interfaces.BaseService;

public interface PostulanteService extends BaseService<PostulanteBean>{
 
	public PostulanteBean buscarUltimaDonacion(PostulanteBean PostulanteBean);
	
	public List<PostulanteBean> listarPostulantesEstadoFisico(PostulanteBean PostulanteBean);
	
	public List<PostulanteBean> listarPreDonantes(PostulanteBean PostulanteBean);
	
	public PostulanteBean obtenerPostulantesEstadoFisico(PostulanteBean PostulanteBean); 
	
	public List<PostulanteBean> litarEstadoFisicaPorPerso(PostulanteBean PostulanteBean);
}
