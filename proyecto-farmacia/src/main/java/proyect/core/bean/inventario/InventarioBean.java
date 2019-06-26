package proyect.core.bean.inventario;

import java.util.Date;
import proyect.base.bean.BaseBean;
import proyect.core.bean.general.AlmacenBean;
import proyect.core.bean.general.PersonaBean;
import proyect.core.bean.stock.StockBean;

public class InventarioBean  extends BaseBean{

	private AlmacenBean almacen;
	private PersonaBean personalResponsable;
	private Date fecha;
	private String nroDocumento;
	private int nroMes;
	
	public AlmacenBean getAlmacen() {
		return almacen;
	}
	public void setAlmacen(AlmacenBean almacen) {
		this.almacen = almacen;
	}
	public PersonaBean getPersonalResponsable() {
		return personalResponsable;
	}
	public void setPersonalResponsable(PersonaBean personalResponsable) {
		this.personalResponsable = personalResponsable;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getNroDocumento() {
		return nroDocumento;
	}
	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}
	public int getNroMes() {
		return nroMes;
	}
	public void setNroMes(int nroMes) {
		this.nroMes = nroMes;
	}
	@Override
	public String toString() {
		return "InventarioBean [almacen=" + almacen + ", personalResponsable=" + personalResponsable 
				+", fecha=" + fecha + ", nroDocumento=" + nroDocumento + ", nroMes=" + nroMes + "]";
	}
	
	
}
