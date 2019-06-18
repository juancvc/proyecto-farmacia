package  sigelab.core.bean.general;


import sigelab.base.bean.BaseBean;


public class RenaesDestinoBean extends BaseBean {
	
	 private RenaesBean renaesOrigen;
	 
	 private RenaesBean renaesDestino;
	 
	public RenaesBean getRenaesOrigen() {
		if (renaesOrigen == null) {
			renaesOrigen = new RenaesBean();
		}
		return renaesOrigen;
	}
	
	public void setRenaesOrigen(RenaesBean renaesOrigen) {
		this.renaesOrigen = renaesOrigen;
	}
	
	public RenaesBean getRenaesDestino() {
		if (renaesDestino == null) {
			renaesDestino = new RenaesBean();
		}
		return renaesDestino;
	}
	
	public void setRenaesDestino(RenaesBean renaesDestino) {
		this.renaesDestino = renaesDestino;
	}
 
	 
}