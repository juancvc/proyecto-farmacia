package proyect.core.bean.seguridad;

import proyect.base.bean.BaseBean;
import proyect.core.bean.general.AlmacenBean; 

public class UsuarioAlmacenBean extends BaseBean {

	private UsuarioBean usuario;

	private AlmacenBean almacen;

	public UsuarioAlmacenBean() {
		super();
	}

	public UsuarioBean getUsuario() {
		if (usuario == null) {
			usuario =  new UsuarioBean();
		}
		return usuario;
	}

	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}

	public AlmacenBean getAlmacen() {
		if (almacen == null) {
			almacen = new AlmacenBean();
		}
		return almacen;
	}

	public void setAlmacen(AlmacenBean almacen) {
		this.almacen = almacen;
	}

 
 
}
