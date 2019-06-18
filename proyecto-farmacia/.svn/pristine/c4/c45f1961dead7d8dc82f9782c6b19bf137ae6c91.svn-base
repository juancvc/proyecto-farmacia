package hnch.referencia.core.bean.asistencial.citas;

import java.util.Date;

import hnch.referencia.base.bean.BaseBean;
import hnch.referencia.core.bean.asistencial.general.EpisodioBean;
import hnch.referencia.core.bean.asistencial.referencia.ReferenciaDiagnosticoBean;
import hnch.referencia.core.bean.general.PacienteBean;
import hnch.referencia.core.bean.general.TablaBean;

public class CitaBean extends BaseBean  {

	private ProgramacionMedicoCitaBean programacionMedicoCitaBean;
	private EpisodioBean episodioBean;
	private ReferenciaDiagnosticoBean referenciaDiagnosticoBean;
	private TablaBean tipoCita;
	private PacienteBean pacienteBean;
	private Date fechaCita;
	private String horaCita;
	private TablaBean tipoPaciente;
	private TablaBean especialidad;
	private String 		fechaDesde; 
	private String 		fechaHasta; 
	
	
	public ProgramacionMedicoCitaBean getProgramacionMedicoCitaBean() {
		if (programacionMedicoCitaBean == null) {
			programacionMedicoCitaBean = new ProgramacionMedicoCitaBean();
		}
		return programacionMedicoCitaBean;
	}

	public void setProgramacionMedicoCitaBean(ProgramacionMedicoCitaBean programacionMedicoCitaBean) {
		this.programacionMedicoCitaBean = programacionMedicoCitaBean;
	}

	public EpisodioBean getEpisodioBean() {
		if (episodioBean == null) {
			episodioBean = new EpisodioBean();
		}
		return episodioBean;
	}

	public void setEpisodioBean(EpisodioBean episodioBean) {
		this.episodioBean = episodioBean;
	}

	public ReferenciaDiagnosticoBean getReferenciaDiagnosticoBean() {
		if (referenciaDiagnosticoBean == null) {
			referenciaDiagnosticoBean = new ReferenciaDiagnosticoBean();
		}
		return referenciaDiagnosticoBean;
	}

	public void setReferenciaDiagnosticoBean(ReferenciaDiagnosticoBean referenciaDiagnosticoBean) {
		this.referenciaDiagnosticoBean = referenciaDiagnosticoBean;
	}

	public TablaBean getTipoCita() {
		return tipoCita;
	}

	public void setTipoCita(TablaBean tipoCita) {
		this.tipoCita = tipoCita;
	}

	public PacienteBean getPacienteBean() {
		if (pacienteBean == null) {
			pacienteBean = new PacienteBean();
		}
		return pacienteBean;
	}

	public void setPacienteBean(PacienteBean pacienteBean) {
		this.pacienteBean = pacienteBean;
	}

	public Date getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}

	public String getHoraCita() {
		return horaCita;
	}

	public void setHoraCita(String horaCita) {
		this.horaCita = horaCita;
	}

	public TablaBean getTipoPaciente() {
		if (tipoPaciente == null) {
			tipoPaciente = new TablaBean();
		}
		return tipoPaciente;
	}

	public void setTipoPaciente(TablaBean tipoPaciente) {
		this.tipoPaciente = tipoPaciente;
	}

	public String getFechaDesde() {
		if (fechaDesde == null) {
			fechaDesde = "";
		}
		return fechaDesde;
	}

	public void setFechaDesde(String fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public String getFechaHasta() {
		if (fechaHasta == null) {
			fechaHasta = "";
		}
		return fechaHasta;
	}

	public void setFechaHasta(String fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public TablaBean getEspecialidad() {
		if (especialidad == null) {
			especialidad = new TablaBean();
		}
		return especialidad;
	}

	public void setEspecialidad(TablaBean especialidad) {
		this.especialidad = especialidad;
	}

	@Override
	public String toString() {
		return "CitaBean [programacionMedicoCitaBean=" + programacionMedicoCitaBean + ", episodioBean=" + episodioBean
				+ ", referenciaDiagnosticoBean=" + referenciaDiagnosticoBean + ", tipoCita=" + tipoCita
				+ ", pacienteBean=" + pacienteBean + ", fechaCita=" + fechaCita + ", horaCita=" + horaCita
				+ ", tipoPaciente=" + tipoPaciente + ", especialidad=" + especialidad + ", fechaDesde=" + fechaDesde
				+ ", fechaHasta=" + fechaHasta + "]";
	}

}
