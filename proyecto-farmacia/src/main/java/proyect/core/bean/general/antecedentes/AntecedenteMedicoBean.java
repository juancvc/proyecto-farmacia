package proyect.core.bean.general.antecedentes;

import proyect.base.bean.BaseBean;
import proyect.core.bean.general.PacienteBean;
import proyect.core.bean.general.TablaBean;





public
class AntecedenteMedicoBean extends BaseBean {

	private PacienteBean	paciente;
	private	TablaBean		antecedenteMedico;
	private String		observaciones;
	
	public PacienteBean getPaciente() {
		return paciente;
	}
	public void setPaciente(PacienteBean paciente) {
		this.paciente = paciente;
	}
	
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	public void setAntecedenteMedico(TablaBean antecedenteMedico) {
		this.antecedenteMedico = antecedenteMedico;
	}
	public TablaBean getAntecedenteMedico() {
		return antecedenteMedico;
	}
	
}