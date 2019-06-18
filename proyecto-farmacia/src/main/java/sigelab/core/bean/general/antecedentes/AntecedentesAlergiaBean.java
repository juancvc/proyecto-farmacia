package sigelab.core.bean.general.antecedentes;


import sigelab.base.bean.BaseBean;
import sigelab.core.bean.general.PacienteBean;


public class AntecedentesAlergiaBean extends BaseBean {
	private String codMedicamentoAlergia;
	private String nombMedicamento;
	private PacienteBean paciente; 
//	private Producto medicamentoAlergia;
	private String medicamentoAlergiaManual;
	public AntecedentesAlergiaBean(){
		super();
	}

	public String getCodMedicamentoAlergia() {
		return codMedicamentoAlergia;
	}

	public void setCodMedicamentoAlergia(String codMedicamentoAlergia) {
		this.codMedicamentoAlergia = codMedicamentoAlergia;
	}

	public String getNombMedicamento() {
		return nombMedicamento;
	}

	public void setNombMedicamento(String nombMedicamento) {
		this.nombMedicamento = nombMedicamento;
	}

	public PacienteBean getPaciente() {
		return paciente;
	}

	public void setPaciente(PacienteBean paciente) {
		this.paciente = paciente;
	}
/*
	public Producto getMedicamentoAlergia() {
		return medicamentoAlergia;
	}

	public void setMedicamentoAlergia(Producto medicamentoAlergia) {
		this.medicamentoAlergia = medicamentoAlergia;
	}
*/
	public String getMedicamentoAlergiaManual() {
		return medicamentoAlergiaManual;
	}

	public void setMedicamentoAlergiaManual(String medicamentoAlergiaManual) {
		this.medicamentoAlergiaManual = medicamentoAlergiaManual;
	}
	
	
}
