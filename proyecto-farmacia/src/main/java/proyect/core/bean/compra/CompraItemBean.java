package proyect.core.bean.compra;

import proyect.base.bean.BaseBean;
import proyect.core.bean.general.CatalogoBean;
import proyect.core.bean.stock.ArticuloBean;
import proyect.core.bean.stock.StockBean;

public class CompraItemBean extends BaseBean {

	private CompraBean Compra;
	private float cantidad;
	private float cantidadConsumida;
	private CatalogoBean modalidadAdquicision;
	private StockBean stock;
	private float precio;
	private float subtotal;
	private String sImporte; 
	private String sSubTotal; 
	private int cantidadFaltante;
	
	
	public int getCantidadFaltante() {
		return cantidadFaltante;
	}
	public void setCantidadFaltante(int cantidadFaltante) {
		this.cantidadFaltante = cantidadFaltante;
	}
	public void ejecutarImporte(){   
		this.setSubtotal(this.getCantidad() * this.getStock().getPrecioCompra()); 
	}
	public String getsImporte() {
		return sImporte;
	}
	public void setsImporte(String sImporte) {
		this.sImporte = sImporte;
	}
	public CompraBean getCompra() {
		if (Compra == null) {
			Compra = new CompraBean();
		}
		return Compra;
	}
	public void setCompra(CompraBean Compra) {
		this.Compra = Compra;
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	public float getCantidadConsumida() {
		return cantidadConsumida;
	}
	public void setCantidadConsumida(float cantidadConsumida) {
		this.cantidadConsumida = cantidadConsumida;
	}
	public CatalogoBean getModalidadAdquicision() {
		return modalidadAdquicision;
	}
	public void setModalidadAdquicision(CatalogoBean modalidadAdquicision) {
		this.modalidadAdquicision = modalidadAdquicision;
	}
	public StockBean getStock() {
		if (stock == null) {
			stock = new StockBean();
		}
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
	
	public String getsSubTotal() {
		return sSubTotal;
	}
	public void setsSubTotal(String sSubTotal) {
		this.sSubTotal = sSubTotal;
	}
	@Override
	public String toString() {
		return "CompraItemBean [Compra=" + Compra + ", cantidad=" + cantidad + ", cantidadConsumida=" + cantidadConsumida
				+ ", modalidadAdquicision=" + modalidadAdquicision + ", stock=" + stock + ", precio=" + precio
				+ ", subtotal=" + subtotal + "]";
	}
	
	
}
