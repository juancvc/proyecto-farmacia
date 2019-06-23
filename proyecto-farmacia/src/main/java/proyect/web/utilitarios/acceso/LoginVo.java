package proyect.web.utilitarios.acceso;
 
import proyect.core.bean.general.AlmacenBean;

public class LoginVo {
	
	private String	nombreUsuario;
	private String 	contrasena;
	private AlmacenBean almacen;
	
	
	
	public AlmacenBean getAlmacen() {
		return almacen;
	}
	public void setAlmacen(AlmacenBean almacen) {
		this.almacen = almacen;
	}
	public LoginVo() {
		super();
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
 
	

}