package sigelab.core.service.interfaces.asistencial.banco;
 
 
import sigelab.core.bean.asistencial.banco.DonanteBean;
import sigelab.core.service.exception.ServiceException;
import sigelab.core.service.interfaces.BaseService;

public interface DonanteService extends BaseService<DonanteBean>{
 
	public DonanteBean buscarUltimaDonacion(DonanteBean DonanteBean);
	
	public boolean insertarVoluntario(DonanteBean t) throws  ServiceException;
}
