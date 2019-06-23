package proyect.core.bean.seguridad;

import proyect.base.bean.BaseBean;
import proyect.core.bean.general.CatalogoBean;





public class PerfilBean extends BaseBean {
	

	private String codigoPerfil; 
	private CatalogoBean situacion; 
	private String nombrePerfil;

	
	
	public PerfilBean() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getCodigoPerfil() {
		return codigoPerfil;
	}



	public void setCodigoPerfil(String codigoPerfil) {
		this.codigoPerfil = codigoPerfil;
	}



	public CatalogoBean getSituacion() {
		return situacion;
	}



	public void setSituacion(CatalogoBean situacion) {
		this.situacion = situacion;
	}



	public String getNombrePerfil() {
		return nombrePerfil;
	}



	public void setNombrePerfil(String nombrePerfil) {
		this.nombrePerfil = nombrePerfil;
	}

	
	
	
}
