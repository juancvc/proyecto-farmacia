package proyect.core.bean.general;

import proyect.base.bean.BaseBean;

public class InstitucionBean  extends BaseBean{
	 
	private String ruc;
	private String nombre; 
	private String nombreComercial; 
	private String descripcion; 
	private String direccion;
	private String nombreLogo;
	private byte[] logo;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombreComercial() {
		return nombreComercial;
	}
	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNombreLogo() {
		return nombreLogo;
	}
	public void setNombreLogo(String nombreLogo) {
		this.nombreLogo = nombreLogo;
	}
	public byte[] getLogo() {
		return logo;
	}
	public void setLogo(byte[] logo) {
		this.logo = logo;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	} 
}
