//package pe.gob.procalidad.natigu.core.bean.bean.generico;
package proyect.core.bean.general;

import proyect.base.bean.BaseBean;

public class TarifarioDetalleBean extends BaseBean{

 
	private TarifarioBean tarifarioBean; 
	private String unidades; 
	private String valoresRefIni;
	private String valoresRefFin; 
	private String observacion; 
	
	public TarifarioDetalleBean() {
		super();
	}
 
	public TarifarioBean getTarifarioBean() {
		if (tarifarioBean == null) {
			tarifarioBean = new TarifarioBean();
		}
		return tarifarioBean;
	}

	public void setTarifarioBean(TarifarioBean tarifarioBean) {
		this.tarifarioBean = tarifarioBean;
	}

	public String getUnidades() {
		return unidades;
	}

	public void setUnidades(String unidades) {
		this.unidades = unidades;
	}

	public String getValoresRefIni() {
		return valoresRefIni;
	}

	public void setValoresRefIni(String valoresRefIni) {
		this.valoresRefIni = valoresRefIni;
	}

	public String getValoresRefFin() {
		return valoresRefFin;
	}

	public void setValoresRefFin(String valoresRefFin) {
		this.valoresRefFin = valoresRefFin;
	}

	public String getObservacion() {
		return observacion;
	}


	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	@Override
	public String toString() {
		return "TarifarioDetalleBean [tarifarioBean=" + tarifarioBean + ", unidades=" + unidades + ", valoresRefIni="
				+ valoresRefIni + ", valoresRefFin=" + valoresRefFin + ", observacion=" + observacion + "]";
	}

	
	
	
}
