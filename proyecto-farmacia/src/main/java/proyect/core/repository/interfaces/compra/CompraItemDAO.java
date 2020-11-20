package proyect.core.repository.interfaces.compra;

import java.util.List;

import proyect.base.repository.DAOException;
import proyect.base.repository.interfaces.BaseDAO;
import proyect.core.bean.general.EpisodioBean;
import proyect.core.bean.compra.CompraBean;
import proyect.core.bean.compra.CompraItemBean;


public interface CompraItemDAO  extends BaseDAO<CompraItemBean>{
	
	public List<CompraItemBean > listarArtPorEpisodio(EpisodioBean episodio) throws DAOException;
	
	public List<CompraItemBean > listarConsumoPaciente(CompraBean CompraBean) throws DAOException;
	
}
