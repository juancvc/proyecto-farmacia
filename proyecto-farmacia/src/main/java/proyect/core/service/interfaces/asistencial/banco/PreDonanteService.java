package proyect.core.service.interfaces.asistencial.banco;
 
 
import java.util.List;

import proyect.core.bean.asistencial.banco.PreDonanteBean;
import proyect.core.entity.asistencial.banco.InterUAL;
import proyect.core.service.exception.ServiceException;
import proyect.core.service.interfaces.BaseService;

public interface PreDonanteService extends BaseService<PreDonanteBean>{
	
	public List<PreDonanteBean> litarResultadoFisicoFlebo(PreDonanteBean PostulanteBean);
  
	public boolean insertarIterUal (InterUAL interual) ;
	
}
