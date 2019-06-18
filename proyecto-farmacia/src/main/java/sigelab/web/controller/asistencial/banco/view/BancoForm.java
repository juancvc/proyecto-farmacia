package sigelab.web.controller.asistencial.banco.view;

import sigelab.core.bean.asistencial.banco.EstadoFisicoBean;
import sigelab.core.bean.asistencial.banco.PostulanteBean;
import sigelab.core.bean.asistencial.banco.PreDonanteBean;

public class BancoForm {
	
	PostulanteBean postulanteBean = new PostulanteBean();
	
	EstadoFisicoBean estadoFisicoBean = new EstadoFisicoBean();
	
	PreDonanteBean preDonanteBean = new PreDonanteBean();

	public PostulanteBean getPostulanteBean() {
		return postulanteBean;
	}

	public void setPostulanteBean(PostulanteBean postulanteBean) {
		this.postulanteBean = postulanteBean;
	}

	public EstadoFisicoBean getEstadoFisicoBean() {
		return estadoFisicoBean;
	}

	public void setEstadoFisicoBean(EstadoFisicoBean estadoFisicoBean) {
		this.estadoFisicoBean = estadoFisicoBean;
	}

	public PreDonanteBean getPreDonanteBean() {
		return preDonanteBean;
	}

	public void setPreDonanteBean(PreDonanteBean preDonanteBean) {
		this.preDonanteBean = preDonanteBean;
	}
	
	

}
