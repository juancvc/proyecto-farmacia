package sigelab.core.bean.general.antecedentes;

import java.util.Date;




import sigelab.base.bean.BaseBean;
import sigelab.core.bean.general.TablaBean;


public class AntecedentesOcupacionBean extends BaseBean{
	private TablaBean ocupacion;
	private String descripcion;
	private TablaBean tipoOcupacion;
	private Date fechaReg;
	private AntecedentesPacienteBean antPaciente;
	
	public AntecedentesOcupacionBean() {
		// PTO Auto-generated constructor stub
		super();
	}

	public TablaBean getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(TablaBean ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TablaBean getTipoOcupacion() {
		return tipoOcupacion;
	}

	public void setTipoOcupacion(TablaBean tipoOcupacion) {
		this.tipoOcupacion = tipoOcupacion;
	}

	public Date getFechaReg() {
		return fechaReg;
	}

	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}

	public AntecedentesPacienteBean getAntPaciente() {
		return antPaciente;
	}

	public void setAntPaciente(AntecedentesPacienteBean antPaciente) {
		this.antPaciente = antPaciente;
	}
	
	
}
