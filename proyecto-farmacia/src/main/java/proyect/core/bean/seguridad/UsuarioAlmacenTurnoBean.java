package proyect.core.bean.seguridad;

import proyect.base.bean.BaseBean;
import proyect.core.bean.general.TurnoBean; 

public class UsuarioAlmacenTurnoBean extends BaseBean {

	private UsuarioAlmacenBean usuarioAlmacen;
	private String estadoTurno;
	private TurnoBean turno;

	public UsuarioAlmacenTurnoBean() {
		super();
	}

	public UsuarioAlmacenBean getUsuarioAlmacen() {
		if (usuarioAlmacen == null) {
			usuarioAlmacen = new UsuarioAlmacenBean();
		}
		return usuarioAlmacen;
	}

	public void setUsuarioAlmacen(UsuarioAlmacenBean usuarioAlmacen) {
		this.usuarioAlmacen = usuarioAlmacen;
	}

	public TurnoBean getTurno() {
		if (turno == null) {
			turno = new TurnoBean();
		}
		return turno;
	}
 
	public void setTurno(TurnoBean turno) {
		this.turno = turno;
	}

	public String getEstadoTurno() {
		return estadoTurno;
	}

	public void setEstadoTurno(String estadoTurno) {
		this.estadoTurno = estadoTurno;
	}
	
	
}
