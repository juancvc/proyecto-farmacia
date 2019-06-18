//package pe.gob.procalidad.natigu.core.bean.bean.generico;
package sigelab.core.bean.general;

import sigelab.base.bean.BaseBean;

public class UbigeoBean extends BaseBean{

 
	private String nombreUbigeo;
	private String codigoRegion;
	private String codigoProvincia;
	private String codigoDistrito;
	private String codigoUbigeo;
	private String codigoRegistro; 
	private String detalle;
	private int    codigoPais;
	
	private String categoria;
	private String variable;
	private String institucion;
	 
	public UbigeoBean() {
		super();
	}
	   
	public String getNombreUbigeo() {
		return nombreUbigeo;
	}

	public void setNombreUbigeo(String nombreUbigeo) {
		this.nombreUbigeo = nombreUbigeo;
	}

	public String getCodigoRegion() {
		return codigoRegion;
	}

	public void setCodigoRegion(String codigoRegion) {
		this.codigoRegion = codigoRegion;
	}

	public String getCodigoProvincia() {
		return codigoProvincia;
	}

	public void setCodigoProvincia(String codigoProvincia) {
		this.codigoProvincia = codigoProvincia;
	}

	public String getCodigoDistrito() {
		return codigoDistrito;
	}

	public void setCodigoDistrito(String codigoDistrito) {
		this.codigoDistrito = codigoDistrito;
	}

	public String getCodigoUbigeo() {
		if (codigoUbigeo == null) {
			codigoUbigeo = "";
		}
		return codigoUbigeo;
	}

	public void setCodigoUbigeo(String codigoUbigeo) {
		this.codigoUbigeo = codigoUbigeo;
	}

	public int getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(int codigoPais) {
		this.codigoPais = codigoPais;
	}
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getVariable() {
		return variable;
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}

	public String getInstitucion() {
		return institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public String getCodigoRegistro() {
		return codigoRegistro;
	}

	public void setCodigoRegistro(String codigoRegistro) {
		this.codigoRegistro = codigoRegistro;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	@Override
	public String toString() {
		return "UbigeoBean [nombreUbigeo=" + nombreUbigeo + ", codigoRegion=" + codigoRegion + ", codigoProvincia="
				+ codigoProvincia + ", codigoDistrito=" + codigoDistrito + ", codigoUbigeo=" + codigoUbigeo
				+ ", codigoRegistro=" + codigoRegistro + ", detalle=" + detalle + ", codigoPais=" + codigoPais
				+ ", categoria=" + categoria + ", variable=" + variable + ", institucion=" + institucion + "]";
	}
 
	
}
