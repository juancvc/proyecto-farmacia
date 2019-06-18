
 package sigelab.core.repository.interfaces.general;

import sigelab.core.bean.general.TablaBean;
import sigelab.core.repository.DAOException;
import sigelab.core.repository.interfaces.BaseDAO;

import java.util.List;

/*
import pe.gob.procalidad.natigu.core.bean.bean.generico.TablaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;*/

public interface Maestra1DAO  extends BaseDAO<TablaBean>  {
	
	public List<TablaBean> listarPorCodigoTabla(String codTabla,int tipo) throws DAOException;
	
	public List<TablaBean> listarComboGeneral(String codTabla) throws DAOException;

	public TablaBean getBuscarPorTablaYRegistro(TablaBean TablaBean) throws DAOException;
	
 
	
}
