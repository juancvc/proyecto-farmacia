package sigelab.core.bean.asistencial.banco;

import sigelab.base.bean.BaseBean;
import sigelab.core.bean.general.TablaBean; 

public class FlebotomiaBean  extends BaseBean{
	
	private String sFecha;
	private TablaBean resultado;
	private String observacion;
	private String volumenSangre;
	
	
	public String getVolumenSangre() {
		return volumenSangre;
	}
	public void setVolumenSangre(String volumenSangre) {
		this.volumenSangre = volumenSangre;
	}
	
	public String getsFecha() {
		return sFecha;
	}
	public void setsFecha(String sFecha) {
		this.sFecha = sFecha;
	}
	public TablaBean getResultado() {
		if (resultado == null) {
			resultado = new TablaBean();
		}
		return resultado;
	}
	public void setResultado(TablaBean resultado) {
		this.resultado = resultado;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	 
}
