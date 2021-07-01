package proyect.web.controller.venta.vista;

import proyect.core.bean.cuentaCorriente.CuentaCorrienteBean;
import proyect.core.bean.venta.VentaBean;

public class VentaForm {

	private VentaBean venta;
	private CuentaCorrienteBean cuentaCorriente;
	
	public VentaBean getVenta() {
		if (venta == null) {
			venta = new VentaBean();
		}
		return venta;
	}
	
	public void setVenta(VentaBean ventaBean) {
		this.venta = ventaBean;
	}
	
	public CuentaCorrienteBean getCuentaCorriente() {
		if (cuentaCorriente == null) {
			cuentaCorriente = new CuentaCorrienteBean();
		}
		return cuentaCorriente;
	}
	
	public void setCuentaCorriente(CuentaCorrienteBean cuentaCorrienteBean) {
		this.cuentaCorriente = cuentaCorrienteBean;
	}
	
	
}
