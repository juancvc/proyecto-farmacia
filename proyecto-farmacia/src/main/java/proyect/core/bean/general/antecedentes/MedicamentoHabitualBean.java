package proyect.core.bean.general.antecedentes;

import proyect.base.bean.BaseBean;
import proyect.core.bean.general.PacienteBean;
import proyect.core.bean.general.TablaBean;



public
class MedicamentoHabitualBean extends BaseBean {
	
	private PacienteBean	paciente;
	private	TablaBean		medicamentoHabitual;
	private String		observaciones;
	
	public PacienteBean getPaciente() {
		return paciente;
	}
	public void setPaciente(PacienteBean paciente) {
		this.paciente = paciente;
	}
	
	public TablaBean getMedicamentoHabitual() {
		return medicamentoHabitual;
	}
	public void setMedicamentoHabitual(TablaBean medicamentoHabitual) {
		this.medicamentoHabitual = medicamentoHabitual;
	}
	
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
}