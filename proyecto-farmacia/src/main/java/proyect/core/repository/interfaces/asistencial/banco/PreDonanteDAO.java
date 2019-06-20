package proyect.core.repository.interfaces.asistencial.banco;
  
  
import java.util.List;

import proyect.core.bean.asistencial.banco.PostulanteBean;
import proyect.core.bean.asistencial.banco.PreDonanteBean;
import proyect.core.entity.asistencial.banco.InterUAL;
import proyect.core.repository.DAOException;
import proyect.core.repository.interfaces.BaseDAO;

public interface PreDonanteDAO  extends BaseDAO<PreDonanteBean> {
	
	public List<PreDonanteBean> litarResultadoFisicoFlebo(PreDonanteBean PostulanteBean);
	
	public boolean insertarIterUal (InterUAL interual);
  
}
