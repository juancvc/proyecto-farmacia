package sigelab.core.bean.general.antecedentes;

import sigelab.base.bean.BaseBean;
import sigelab.core.bean.general.TablaBean;



public class LiquidoAblactanciaBean extends BaseBean{
	private AntecedentesAlimentacionBean antecedAlimentacion;
	private TablaBean liquidAblactancia;
	private String descripcion;
	private boolean swMarcar;
	private int frecuencia;
	private int cantidad;
	
	public LiquidoAblactanciaBean(){
		
	}
	public LiquidoAblactanciaBean(TablaBean tbliquidAbla){
		this.liquidAblactancia = tbliquidAbla;
	}
	public AntecedentesAlimentacionBean getAntecedAlimentacion() {
		return antecedAlimentacion;
	}
	public void setAntecedAlimentacion(AntecedentesAlimentacionBean antecedAlimentacion) {
		this.antecedAlimentacion = antecedAlimentacion;
	}
	public TablaBean getLiquidAblactancia() {
		return liquidAblactancia;
	}
	public void setLiquidAblactancia(TablaBean liquidAblactancia) {
		this.liquidAblactancia = liquidAblactancia;
	}
	public boolean isSwMarcar() {
		return swMarcar;
	}
	public void setSwMarcar(boolean swMarcar) {
		this.swMarcar = swMarcar;
	}
	public int getFrecuencia() {
		return frecuencia;
	}
	public void setFrecuencia(int frecuencia) {
		this.frecuencia = frecuencia;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
