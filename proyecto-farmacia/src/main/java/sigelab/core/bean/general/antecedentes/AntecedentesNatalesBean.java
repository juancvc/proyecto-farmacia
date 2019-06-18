package sigelab.core.bean.general.antecedentes;

import sigelab.base.bean.BaseBean;
import sigelab.core.bean.general.TablaBean;



public class AntecedentesNatalesBean extends BaseBean{
	private boolean swTPSeleccionado = false;
	private boolean swLugarInstitucional = false;
	private String centroSalud;
	private String otroLugar;
	
	private TablaBean tipoParto;
	private int pesoNacimiento;
	private int paramAPGAR;
	private int pesoAlta;
	private int perimCefalico;
	private int talla;
	
	private String compliRecNacido;
	private String compliMadre;
	
	private AntecedentesPacienteBean antecedPaciente;
	
	public AntecedentesNatalesBean(){
		super();
	}

	public TablaBean getTipoParto() {
		return tipoParto;
	}

	public void setTipoParto(TablaBean tipoParto) {
		this.tipoParto = tipoParto;
	}

	public int getPesoNacimiento() {
		return pesoNacimiento;
	}

	public void setPesoNacimiento(int pesoNacimiento) {
		this.pesoNacimiento = pesoNacimiento;
	}

	public int getParamAPGAR() {
		return paramAPGAR;
	}

	public void setParamAPGAR(int paramAPGAR) {
		this.paramAPGAR = paramAPGAR;
	}

	public int getPesoAlta() {
		return pesoAlta;
	}

	public void setPesoAlta(int pesoAlta) {
		this.pesoAlta = pesoAlta;
	}

	public int getPerimCefalico() {
		return perimCefalico;
	}

	public void setPerimCefalico(int perimCefalico) {
		this.perimCefalico = perimCefalico;
	}

	public int getTalla() {
		return talla;
	}

	public void setTalla(int talla) {
		this.talla = talla;
	}

	public String getCompliRecNacido() {
		return compliRecNacido;
	}

	public void setCompliRecNacido(String compliRecNacido) {
		this.compliRecNacido = compliRecNacido;
	}

	public String getCompliMadre() {
		return compliMadre;
	}

	public void setCompliMadre(String compliMadre) {
		this.compliMadre = compliMadre;
	}

	public AntecedentesPacienteBean getAntecedPaciente() {
		return antecedPaciente;
	}

	public void setAntecedPaciente(AntecedentesPacienteBean antecedPaciente) {
		this.antecedPaciente = antecedPaciente;
	}

	public boolean isSwLugarInstitucional() {
		return swLugarInstitucional;
	}

	public void setSwLugarInstitucional(boolean swLugarInstitucional) {
		this.swLugarInstitucional = swLugarInstitucional;
	}

	public String getCentroSalud() {
		return centroSalud;
	}

	public void setCentroSalud(String centroSalud) {
		this.centroSalud = centroSalud;
	}

	public String getOtroLugar() {
		return otroLugar;
	}

	public void setOtroLugar(String otroLugar) {
		this.otroLugar = otroLugar;
	}

	public boolean isSwTPSeleccionado() {
		return swTPSeleccionado;
	}

	public void setSwTPSeleccionado(boolean swTPSeleccionado) {
		this.swTPSeleccionado = swTPSeleccionado;
	}
	
	
}
