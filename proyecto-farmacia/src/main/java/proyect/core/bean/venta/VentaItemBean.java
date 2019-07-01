package proyect.core.bean.venta;

import proyect.base.bean.BaseBean;
import proyect.core.bean.general.CatalogoBean;
import proyect.core.bean.stock.StockBean;

public class VentaItemBean extends BaseBean {

	private VentaBean venta;
	private int cantidad;
	private int cantidadConsumida;
	private CatalogoBean modalidadAdquicision;
	private StockBean stock;
	private float precio;
	private float subtotal;
	private String sImporte; 
	private int cantidadFaltante;
	
	
	public int getCantidadFaltante() {
		return cantidadFaltante;
	}
	public void setCantidadFaltante(int cantidadFaltante) {
		this.cantidadFaltante = cantidadFaltante;
	}
	public void ejecutarImporte(){   
		this.setSubtotal(this.getCantidad() * this.getStock().getPrecioVenta()); 
	}
	public String getsImporte() {
		return sImporte;
	}
	public void setsImporte(String sImporte) {
		this.sImporte = sImporte;
	}
	public VentaBean getVenta() {
		return venta;
	}
	public void setVenta(VentaBean venta) {
		this.venta = venta;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getCantidadConsumida() {
		return cantidadConsumida;
	}
	public void setCantidadConsumida(int cantidadConsumida) {
		this.cantidadConsumida = cantidadConsumida;
	}
	public CatalogoBean getModalidadAdquicision() {
		return modalidadAdquicision;
	}
	public void setModalidadAdquicision(CatalogoBean modalidadAdquicision) {
		this.modalidadAdquicision = modalidadAdquicision;
	}
	public StockBean getStock() {
		return stock;
	}
	public void setStock(StockBean stock) {
		this.stock = stock;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public float getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
	@Override
	public String toString() {
		return "VentaItemBean [venta=" + venta + ", cantidad=" + cantidad + ", cantidadConsumida=" + cantidadConsumida
				+ ", modalidadAdquicision=" + modalidadAdquicision + ", stock=" + stock + ", precio=" + precio
				+ ", subtotal=" + subtotal + "]";
	}
	
	
}
