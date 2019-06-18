package hnch.referencia.core.service.implementacion.asistencial.citas;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 
import hnch.referencia.core.bean.asistencial.citas.ProgramacionMedicoCitaBean; 
import hnch.referencia.core.repository.DAOException;
import hnch.referencia.core.repository.interfaces.asistencial.citas.ProgramacionMedicoCitaDAO;
import hnch.referencia.core.service.exception.ServiceException;
import hnch.referencia.core.service.interfaces.asistencial.citas.ProgramacionMedicoCitaService; 

@Service("programacionMedicoCitaService")
@Transactional(readOnly = true)
public class ProgramacionMedicoCitaServiceImp implements ProgramacionMedicoCitaService {

	@Autowired
	ProgramacionMedicoCitaDAO programacionMedicoCitaDAO;

	@Override
	public boolean insertar(ProgramacionMedicoCitaBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(ProgramacionMedicoCitaBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(ProgramacionMedicoCitaBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ProgramacionMedicoCitaBean getBuscarPorObjecto(ProgramacionMedicoCitaBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProgramacionMedicoCitaBean> getBuscarPorFiltros(ProgramacionMedicoCitaBean t) throws ServiceException {
		List<ProgramacionMedicoCitaBean> lstProgramacionMedicoCitaBean = null;
		try {
			lstProgramacionMedicoCitaBean = programacionMedicoCitaDAO.getBuscarPorFiltros(t);
		} catch (Exception e) {

		}
		return lstProgramacionMedicoCitaBean;
	}

	@Override
	public boolean existe(ProgramacionMedicoCitaBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

 

}
