package sigelab.core.service.interfaces.asistencial.banco;
 
 
import java.util.List;

import sigelab.core.bean.asistencial.banco.PreDonanteBean;
import sigelab.core.entity.asistencial.banco.InterUAL;
import sigelab.core.service.exception.ServiceException;
import sigelab.core.service.interfaces.BaseService;

public interface PreDonanteService extends BaseService<PreDonanteBean>{
	
	public List<PreDonanteBean> litarResultadoFisicoFlebo(PreDonanteBean PostulanteBean);
  
	public boolean insertarIterUal (InterUAL interual) ;
	
}
