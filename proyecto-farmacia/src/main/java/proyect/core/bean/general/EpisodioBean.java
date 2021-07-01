package proyect.core.bean.general;

import java.sql.Time;
import java.util.Date;

import proyect.base.bean.BaseBean;

public class EpisodioBean extends BaseBean {

	private CatalogoBean tipoPaciente;
	private CatalogoBean tipoEpisodio;
	private CatalogoBean servicio;
	private PacienteBean paciente;
	private Date fechaInicio;
	private Time horaInicio;
	private Date fechaTermino;
	private Time horaTermino;
	private String observaciones;
	private EpisodioBean episodioAnterior;
	private String numeroEpisodio;

	public CatalogoBean getTipoPaciente() {
		if (tipoPaciente == null) {
			tipoPaciente = new CatalogoBean();
		}
		return tipoPaciente;
	}

	public void setTipoPaciente(CatalogoBean tipoPaciente) {
		this.tipoPaciente = tipoPaciente;
	}

	public CatalogoBean getTipoEpisodio() {
		return tipoEpisodio;
	}

	public void setTipoEpisodio(CatalogoBean tipoEpisodio) {
		this.tipoEpisodio = tipoEpisodio;
	}

	public CatalogoBean getServicio() {
		return servicio;
	}

	public void setServicio(CatalogoBean servicio) {
		this.servicio = servicio;
	}

	public PacienteBean getPaciente() {
		if (paciente == null) {
			paciente = new PacienteBean();
		}
		return paciente;
	}

	public void setPaciente(PacienteBean paciente) {
		this.paciente = paciente;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Time getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getFechaTermino() {
		return fechaTermino;
	}

	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	public Time getHoraTermino() {
		return horaTermino;
	}

	public void setHoraTermino(Time horaTermino) {
		this.horaTermino = horaTermino;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public EpisodioBean getEpisodioAnterior() {
		return episodioAnterior;
	}

	public void setEpisodioAnterior(EpisodioBean episodioAnterior) {
		this.episodioAnterior = episodioAnterior;
	}

	public String getNumeroEpisodio() {
		return numeroEpisodio;
	}

	public void setNumeroEpisodio(String numeroEpisodio) {
		this.numeroEpisodio = numeroEpisodio;
	}

}
