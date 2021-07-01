package proyect.core.bean.seguridad;

import proyect.base.bean.BaseBean;
import proyect.core.bean.general.CatalogoBean;





public class PerfilBean extends BaseBean {
	

	private String codigoPerfil; 
	private CatalogoBean situacion; 
	private String nombrePerfil;
	private String descripcion;

	
	
	public PerfilBean() {
		super();
		// TODO Auto-generated constructor stub
	}



	public CatalogoBean getSituacion() {
		if (situacion == null) {
			situacion = new CatalogoBean();
		}
		return situacion;
	} 

	public void setSituacion(CatalogoBean situacion) {
		this.situacion = situacion;
	}



	public String getCodigoPerfil() {
		return codigoPerfil;
	}



	public void setCodigoPerfil(String codigoPerfil) {
		this.codigoPerfil = codigoPerfil;
	}
 
	public String getNombrePerfil() {
		return nombrePerfil;
	}



	public void setNombrePerfil(String nombrePerfil) {
		this.nombrePerfil = nombrePerfil;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
	
}
