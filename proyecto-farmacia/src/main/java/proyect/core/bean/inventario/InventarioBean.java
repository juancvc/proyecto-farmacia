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
	private int cantidadItems;
	private String cadenaCantidad;
	private String cadenaIdStock;
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
	
	
	
	public int getCantidadItems() {
		return cantidadItems;
	}
	public void setCantidadItems(int cantidadItems) {
		this.cantidadItems = cantidadItems;
	}
	public String getCadenaCantidad() {
		return cadenaCantidad;
	}
	public void setCadenaCantidad(String cadenaCantidad) {
		this.cadenaCantidad = cadenaCantidad;
	}
	public String getCadenaIdStock() {
		return cadenaIdStock;
	}
	public void setCadenaIdStock(String cadenaIdStock) {
		this.cadenaIdStock = cadenaIdStock;
	}
	@Override
	public String toString() {
		return "InventarioBean [almacen=" + almacen + ", personalResponsable=" + personalResponsable 
				+", fecha=" + fecha + ", nroDocumento=" + nroDocumento + ", nroMes=" + nroMes + "]";
	}
	
	
}
