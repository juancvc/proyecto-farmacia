package sigelab.core.bean.asistencial.laboratorio;
  
import java.text.DecimalFormat;

import sigelab.base.bean.BaseBean; 
import sigelab.core.bean.general.TarifarioBean;

public class OrdenDetalleBean extends BaseBean{
	
	private OrdenBean ordenBean;
	private int cantidad; 
	private String estado; 
	private Float importe; 
	private Float precio;
	private TarifarioBean examen;
	private String sImporte; 
	private String resultado;
	
	public String getsImporte() {
		return sImporte;
	}
	public void setsImporte(String sImporte) {
		this.sImporte = sImporte;
	}
	public OrdenBean getOrdenBean() {
		return ordenBean;
	}
	public void setOrdenBean(OrdenBean ordenBean) {
		this.ordenBean = ordenBean;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Float getImporte() {
		return importe;
	}
	public void setImporte(Float importe) {
		this.importe = importe;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
 
	public TarifarioBean getExamen() {
		return examen;
	}
	public void setExamen(TarifarioBean examen) {
		this.examen = examen;
	}
	public void ejecutarImporte(){   
		this.setImporte(this.getCantidad() * this.getPrecio()); 
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	
}
