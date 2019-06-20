package proyect.core.service.interfaces.asistencial.banco;
 
 
import proyect.core.bean.asistencial.banco.DonanteBean;
import proyect.core.service.exception.ServiceException;
import proyect.core.service.interfaces.BaseService;

public interface DonanteService extends BaseService<DonanteBean>{
 
	public DonanteBean buscarUltimaDonacion(DonanteBean DonanteBean);
	
	public boolean insertarVoluntario(DonanteBean t) throws  ServiceException;
}
