package sigelab.core.repository.interfaces.asistencial.banco;
  
  
import java.util.List;

import sigelab.core.bean.asistencial.banco.PostulanteBean;
import sigelab.core.bean.asistencial.banco.PreDonanteBean;
import sigelab.core.entity.asistencial.banco.InterUAL;
import sigelab.core.repository.DAOException;
import sigelab.core.repository.interfaces.BaseDAO;

public interface PreDonanteDAO  extends BaseDAO<PreDonanteBean> {
	
	public List<PreDonanteBean> litarResultadoFisicoFlebo(PreDonanteBean PostulanteBean);
	
	public boolean insertarIterUal (InterUAL interual);
  
}
