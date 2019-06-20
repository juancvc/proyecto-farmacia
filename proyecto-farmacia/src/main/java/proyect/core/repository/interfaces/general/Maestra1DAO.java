
 package proyect.core.repository.interfaces.general;

import java.util.List;

import proyect.core.bean.general.TablaBean;
import proyect.core.repository.DAOException;
import proyect.core.repository.interfaces.BaseDAO;

/*
import pe.gob.procalidad.natigu.core.bean.bean.generico.TablaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;*/

public interface Maestra1DAO  extends BaseDAO<TablaBean>  {
	
	public List<TablaBean> listarPorCodigoTabla(String codTabla,int tipo) throws DAOException;
	
	public List<TablaBean> listarComboGeneral(String codTabla) throws DAOException;

	public TablaBean getBuscarPorTablaYRegistro(TablaBean TablaBean) throws DAOException;
	
 
	
}
