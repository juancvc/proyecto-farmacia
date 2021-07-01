package proyect.core.bean.inventario;

import java.util.Date;
import proyect.base.bean.BaseBean;
import proyect.core.bean.general.AlmacenBean;
import proyect.core.bean.general.CatalogoBean;
import proyect.core.bean.general.PersonaBean;
import proyect.core.bean.stock.StockBean;

public class InventarioBean  extends BaseBean{

	private AlmacenBean almacen;
	private PersonaBean personalResponsable;
	private Date fecha;
	private String nroDocumento;
	private CatalogoBean mes;
	private CatalogoBean periodo;
	private int cantidadItems;
	private String cadenaCantidad;
	private String cadenaIdStock;
	private CatalogoBean situacion;
	
	public AlmacenBean getAlmacen() {
		if (almacen == null) {
			almacen =  new AlmacenBean();
		}
		return almacen;
	}
	public void setAlmacen(AlmacenBean almacen) {
		this.almacen = almacen;
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
	public PersonaBean getPersonalResponsable() {
		if (personalResponsable == null) {
			personalResponsable = new PersonaBean();
		}
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
	public CatalogoBean getMes() {
		if (mes == null) {
			mes = new CatalogoBean();
		}
		return mes;
	}
	public void setMes(CatalogoBean mes) {
		this.mes = mes;
	}
	public CatalogoBean getPeriodo() {
		if (periodo == null) {
			periodo = new CatalogoBean();
		}
		return periodo;
	}
	public void setPeriodo(CatalogoBean periodo) {
		this.periodo = periodo;
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
				+", fecha=" + fecha + ", nroDocumento=" + nroDocumento + "]";
	}
	
	
}
