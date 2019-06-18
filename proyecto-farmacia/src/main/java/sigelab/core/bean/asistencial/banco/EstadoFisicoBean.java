package sigelab.core.bean.asistencial.banco;

import java.text.SimpleDateFormat;
import java.util.Date;

import sigelab.base.bean.BaseBean;
import sigelab.core.bean.general.PersonaBean;
import sigelab.core.bean.general.TablaBean;

public class EstadoFisicoBean extends BaseBean{
	
	private String hora;
	private TablaBean grupoSanguineo;
	private TablaBean factor;
	private Date fecha;  
	private TablaBean calificacion;
	private String htco;
	private String observacion;
	private PersonaBean personaBean;
	private Date fechaEvaluacion;
	private String sFecha ;
	private String sHora ;
	private String resultadoSerologia ;
	
	
	public String getResultadoSerologia() {
		return resultadoSerologia;
	}

	public void setResultadoSerologia(String resultadoSerologia) {
		this.resultadoSerologia = resultadoSerologia;
	}

	public Date getFechaEvaluacion() {
		return fechaEvaluacion;
	}
	
	public String getsFecha() {
		if (sFecha == null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			String strHora = sdf.format(new Date());
			sFecha = strHora;
		} 
		return sFecha;
	}

	public void setsFecha(String sFecha) {
		this.sFecha = sFecha;
	}

	public String getsHora() {
		return sHora;
	}

	public void setsHora(String sHora) {
		this.sHora = sHora;
	}

	public void setFechaEvaluacion(Date fechaEvaluacion) {
		this.fechaEvaluacion = fechaEvaluacion;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public TablaBean getGrupoSanguineo() {
		if (grupoSanguineo == null) {
			grupoSanguineo = new TablaBean();
		}
		return grupoSanguineo;
	}
	public void setGrupoSanguineo(TablaBean grupoSanguineo) {
		this.grupoSanguineo = grupoSanguineo;
	}
	public TablaBean getFactor() {
		if (factor == null) {
			factor = new TablaBean();
		}
		return factor;
	}
	public void setFactor(TablaBean factor) {
		this.factor = factor;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public TablaBean getCalificacion() {
		if (calificacion == null) {
			calificacion = new TablaBean();
		}
		return calificacion;
	}
	public void setCalificacion(TablaBean calificacion) {
		this.calificacion = calificacion;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	public String getHtco() {
		return htco;
	}
	public void setHtco(String htco) {
		this.htco = htco;
	}
	public PersonaBean getPersonaBean() {
		if (personaBean == null) {
			personaBean = new PersonaBean();
		}
		return personaBean;
	}
	public void setPersonaBean(PersonaBean personaBean) {
		this.personaBean = personaBean;
	}
	@Override
	public String toString() {
		return "EstadoFisicoBean [hora=" + hora + ", grupoSanguineo=" + grupoSanguineo + ", factor=" + factor
				+ ", fecha=" + fecha + ", calificacion=" + calificacion + ", observacion=" + observacion + "]";
	} 
	
	 
}
