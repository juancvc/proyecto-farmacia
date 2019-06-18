package sigelab.core.bean.seguridad;

import sigelab.base.bean.BaseBean;






public class ComponenteBean extends BaseBean{

	private String codigoComponentePadre;

	private String codigoComponente;

	private String descripcion;

	private String nombreComponente;
	
	
	private PerfilBean perfil;
	
	
	private boolean flgDelete;

	
	private boolean flgRead;

	
	private boolean flgWrite;


	public ComponenteBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getCodigoComponentePadre() {
		return codigoComponentePadre;
	}


	public void setCodigoComponentePadre(String codigoComponentePadre) {
		this.codigoComponentePadre = codigoComponentePadre;
	}


	public String getCodigoComponente() {
		return codigoComponente;
	}


	public void setCodigoComponente(String codigoComponente) {
		this.codigoComponente = codigoComponente;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getNombreComponente() {
		return nombreComponente;
	}


	public void setNombreComponente(String nombreComponente) {
		this.nombreComponente = nombreComponente;
	}


	public PerfilBean getPerfil() {
		return perfil;
	}


	public void setPerfil(PerfilBean perfil) {
		this.perfil = perfil;
	}


	public boolean isFlgDelete() {
		return flgDelete;
	}


	public void setFlgDelete(boolean flgDelete) {
		this.flgDelete = flgDelete;
	}


	public boolean isFlgRead() {
		return flgRead;
	}


	public void setFlgRead(boolean flgRead) {
		this.flgRead = flgRead;
	}


	public boolean isFlgWrite() {
		return flgWrite;
	}


	public void setFlgWrite(boolean flgWrite) {
		this.flgWrite = flgWrite;
	}
	
	
}
