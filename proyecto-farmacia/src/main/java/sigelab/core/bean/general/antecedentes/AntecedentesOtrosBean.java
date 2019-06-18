package sigelab.core.bean.general.antecedentes;

import java.util.Date;


import sigelab.base.bean.BaseBean;
import sigelab.core.bean.general.PacienteBean;
import sigelab.core.bean.general.PersonalBean;


public class AntecedentesOtrosBean extends BaseBean {
	private String otrosAntecedentes;
	private PersonalBean medico;
	private PacienteBean paciente;
	private Date fechaHoy;
	
	public AntecedentesOtrosBean(){
		super();
	}
	public String getOtrosAntecedentes() {
		return otrosAntecedentes;
	}
	public void setOtrosAntecedentes(String otrosAntecedentes) {
		this.otrosAntecedentes = otrosAntecedentes;
	}
	public PersonalBean getMedico() {
		return medico;
	}
	public void setMedico(PersonalBean medico) {
		this.medico = medico;
	}
	public PacienteBean getPaciente() {
		return paciente;
	}
	public void setPaciente(PacienteBean paciente) {
		this.paciente = paciente;
	}
	public Date getFechaHoy() {
		return fechaHoy;
	}
	public void setFechaHoy(Date fechaHoy) {
		this.fechaHoy = fechaHoy;
	}
	
	
}
