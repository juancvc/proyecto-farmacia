package proyect.core.bean.stock;
 

import proyect.base.bean.BaseBean;
import proyect.core.bean.general.CatalogoBean;
 


public class ArticuloBean extends BaseBean{
	
	private String nombre;
	private String codigoSiga;
	private String codigoSismed;
	private String concentracion;
	private CatalogoBean clase;
	private String idGenerico;
	private LaboratorioBean laboratorio;
	private CatalogoBean tipoArticulo;
	private CatalogoBean tipoPresentacion;
	private String posologia;
	private int stockAlerta;
	private int stockOptimo;
	private String volumen;
	private Boolean swDecimal;
	private String nombreArticuloSismed;
	
	public ArticuloBean() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigoSiga() {
		return codigoSiga;
	}

	public void setCodigoSiga(String codigoSiga) {
		this.codigoSiga = codigoSiga;
	}

	public String getCodigoSismed() {
		return codigoSismed;
	}

	public void setCodigoSismed(String codigoSismed) {
		this.codigoSismed = codigoSismed;
	}

	public String getConcentracion() {
		return concentracion;
	}

	public void setConcentracion(String concentracion) {
		this.concentracion = concentracion;
	}

	public CatalogoBean getClase() {
		if (clase == null) {
			clase= new CatalogoBean();
		}
		return clase;
	}

	public void setClase(CatalogoBean clase) {
		this.clase = clase;
	}

	public String getIdGenerico() {
		return idGenerico;
	}

	public void setIdGenerico(String idGenerico) {
		this.idGenerico = idGenerico;
	}

	public LaboratorioBean getLaboratorio() {
		if (laboratorio == null) {
			laboratorio= new LaboratorioBean();
		}
		return laboratorio;
	}

	public void setLaboratorio(LaboratorioBean laboratorio) {
		this.laboratorio = laboratorio;
	}

	public CatalogoBean getTipoArticulo() {
		if (tipoArticulo == null) {
			tipoArticulo= new CatalogoBean();
		}
		return tipoArticulo;
	}

	public void setTipoArticulo(CatalogoBean tipoArticulo) {
		this.tipoArticulo = tipoArticulo;
	}

	public CatalogoBean getTipoPresentacion() {
		if (tipoPresentacion == null) {
			tipoPresentacion = new CatalogoBean();
		}
		return tipoPresentacion;
	}

	public void setTipoPresentacion(CatalogoBean tipoPresentacion) {
		this.tipoPresentacion = tipoPresentacion;
	}

	public String getPosologia() {
		return posologia;
	}

	public void setPosologia(String posologia) {
		this.posologia = posologia;
	}

	public int getStockAlerta() {
		return stockAlerta;
	}

	public void setStockAlerta(int stockAlerta) {
		this.stockAlerta = stockAlerta;
	}

	public int getStockOptimo() {
		return stockOptimo;
	}

	public void setStockOptimo(int stockOptimo) {
		this.stockOptimo = stockOptimo;
	}

	public String getVolumen() {
		return volumen;
	}

	public void setVolumen(String volumen) {
		this.volumen = volumen;
	}

	public Boolean getSwDecimal() {
		return swDecimal;
	}

	public void setSwDecimal(Boolean swDecimal) {
		this.swDecimal = swDecimal;
	}

	public String getNombreArticuloSismed() {
		
		nombreArticuloSismed = codigoSismed +" - "+ nombre;
		return nombreArticuloSismed;
	}

	public void setNombreArticuloSismed(String nombreArticuloSismed) {
		this.nombreArticuloSismed = nombreArticuloSismed;
	}

	@Override
	public String toString() {
		return "ArticuloBean [nombre=" + nombre + ", codigoSiga=" + codigoSiga + ", codigoSismed=" + codigoSismed
				+ ", concentracion=" + concentracion + ", clase=" + clase + ", idGenerico=" + idGenerico
				+ ", laboratorio=" + laboratorio + ", tipoArticulo=" + tipoArticulo + ", tipoPresentacion="
				+ tipoPresentacion + ", posologia=" + posologia + ", stockAlerta=" + stockAlerta + ", stockOptimo="
				+ stockOptimo + ", volumen=" + volumen + "]";
	}

}