package sigelab.core.bean.general.antecedentes;


import sigelab.base.bean.BaseBean;

public class AntecedentesDesPsicomotrizBean extends BaseBean {
	private String desMotor;
	private String desLenguaje;
	private String desSocial;
	private String desCognitivo;
	
	private AntecedentesPacienteBean antecedPac;
	
	public String getDesMotor() {
		return desMotor;
	}
	public void setDesMotor(String desMotor) {
		this.desMotor = desMotor;
	}
	public String getDesLenguaje() {
		return desLenguaje;
	}
	public void setDesLenguaje(String desLenguaje) {
		this.desLenguaje = desLenguaje;
	}
	public String getDesSocial() {
		return desSocial;
	}
	public void setDesSocial(String desSocial) {
		this.desSocial = desSocial;
	}
	public String getDesCognitivo() {
		return desCognitivo;
	}
	public void setDesCognitivo(String desCognitivo) {
		this.desCognitivo = desCognitivo;
	}
	public AntecedentesPacienteBean getAntecedPac() {
		return antecedPac;
	}
	public void setAntecedPac(AntecedentesPacienteBean antecedPac) {
		this.antecedPac = antecedPac;
	}
	
	
}
