package proyect.core.bean.cuentaCorriente;

import proyect.base.bean.BaseBean;
import proyect.core.bean.stock.StockBean;

public class CuentaCorrienteItemBean extends BaseBean {
	
	private CuentaCorrienteBean cuentaCorrienteBean;
	private StockBean stockBean;
	private int cantidad;
	private float precio;
	
	public CuentaCorrienteBean getCuentaCorrienteBean() {
		return cuentaCorrienteBean;
	}
	public void setCuentaCorrienteBean(CuentaCorrienteBean cuentaCorrienteBean) {
		this.cuentaCorrienteBean = cuentaCorrienteBean;
	}
	public StockBean getStockBean() {
		return stockBean;
	}
	public void setStockBean(StockBean stockBean) {
		this.stockBean = stockBean;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
}
