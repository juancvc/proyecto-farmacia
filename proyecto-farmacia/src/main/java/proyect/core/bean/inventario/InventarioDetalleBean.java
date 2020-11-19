package proyect.core.bean.inventario;

import proyect.base.bean.BaseBean;
import proyect.core.bean.general.AlmacenBean;
import proyect.core.bean.stock.StockBean;

public class InventarioDetalleBean  extends BaseBean{
	
	private InventarioBean inventario;
	private StockBean stock;
	private int faltantes;
	private int sobrantes;
	private int cantidad;
	private AlmacenBean almacen;
	
	public InventarioBean getInventario() {
		return inventario;
	}
	public void setInventario(InventarioBean inventario) {
		this.inventario = inventario;
	}
	public StockBean getStock() {
		return stock;
	}
	public void setStock(StockBean stock) {
		this.stock = stock;
	}
	public int getFaltantes() {
		return faltantes;
	}
	public void setFaltantes(int faltantes) {
		this.faltantes = faltantes;
	}
	public int getSobrantes() {
		return sobrantes;
	}
	public void setSobrantes(int sobrantes) {
		this.sobrantes = sobrantes;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public AlmacenBean getAlmacen() {
		return almacen;
	}
	public void setAlmacen(AlmacenBean almacen) {
		this.almacen = almacen;
	}
	
	

}
