package sigelab.core.bean.general.antecedentes;

import sigelab.base.bean.BaseBean;
import sigelab.core.bean.general.TablaBean;




public class AntecedentesMedFrecuenteBean extends BaseBean{
//	private Producto producto;
	private String dosis;
	private TablaBean umDosis;
	private String tiempo;
	private TablaBean umTiempo;
	private TablaBean frecuencia;
	private AntecedentesPacienteBean antecedentesPaciente;
	/*
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	*/
	public String getDosis() {
		return dosis;
	}
	public void setDosis(String dosis) {
		this.dosis = dosis;
	}
	public TablaBean getUmDosis() {
		return umDosis;
	}
	public void setUmDosis(TablaBean umDosis) {
		this.umDosis = umDosis;
	}
	public String getTiempo() {
		return tiempo;
	}
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	public TablaBean getUmTiempo() {
		return umTiempo;
	}
	public void setUmTiempo(TablaBean umTiempo) {
		this.umTiempo = umTiempo;
	}
	public AntecedentesPacienteBean getAntecedentesPaciente() {
		return antecedentesPaciente;
	}
	public void setAntecedentesPaciente(AntecedentesPacienteBean antecedentesPaciente) {
		this.antecedentesPaciente = antecedentesPaciente;
	}
	public TablaBean getFrecuencia() {
		return frecuencia;
	}
	public void setFrecuencia(TablaBean frecuencia) {
		this.frecuencia = frecuencia;
	}
	
	
}
