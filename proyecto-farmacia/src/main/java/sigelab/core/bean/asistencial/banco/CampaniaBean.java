package sigelab.core.bean.asistencial.banco;

import java.util.Date;

import sigelab.base.bean.BaseBean;

public class CampaniaBean extends BaseBean{
	
	private String nombre;
	private String lugar;
	private Date fechaInicio;
	private Date fechaFin;

	private String sFechaInicio;
	private String sFechaFin;
	
	private LugarCampaniaBean lugarCampaniaBean;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getsFechaInicio() {
		return sFechaInicio;
	}

	public void setsFechaInicio(String sFechaInicio) {
		this.sFechaInicio = sFechaInicio;
	}

	public String getsFechaFin() {
		return sFechaFin;
	}

	public void setsFechaFin(String sFechaFin) {
		this.sFechaFin = sFechaFin;
	}

	public LugarCampaniaBean getLugarCampaniaBean() {
		if (lugarCampaniaBean == null) {
			lugarCampaniaBean = new LugarCampaniaBean();
		}
		return lugarCampaniaBean;
	}

	public void setLugarCampaniaBean(LugarCampaniaBean lugarCampaniaBean) {
		this.lugarCampaniaBean = lugarCampaniaBean;
	}

	@Override
	public String toString() {
		return "CampaniaBean [nombre=" + nombre + ", lugar=" + lugar + ", fechaInicio=" + fechaInicio + ", fechaFin="
				+ fechaFin + ", sFechaInicio=" + sFechaInicio + ", sFechaFin=" + sFechaFin + ", lugarCampaniaBean="
				+ lugarCampaniaBean + "]";
	}

	
}
