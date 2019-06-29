package proyect.core.bean.stock;

import java.util.Date;

import proyect.base.bean.BaseBean;
import proyect.core.bean.general.AlmacenBean;
import proyect.core.entity.catalogo.Catalogo02;

public class StockBean extends BaseBean {
	
private AlmacenBean   almacenBean;
private ArticuloBean  articuloBean;
private int 		  stock;
private String 		  lote;
private float   	  precioCompra;
private float  		  precioVenta;
private Date 		  fechaVencimiento;
private Catalogo02    modalidadAdquision;
private Catalogo02    tipoFinanciador;
private Catalogo02    tipoSeleccion;	
private String 		  nroRegistroSanitario;
private ProveedorBean proveedorBean;
private String 		  tipoLlamada;



public AlmacenBean getAlmacenBean() {
	return almacenBean;
}
public void setAlmacenBean(AlmacenBean almacenBean) {
	this.almacenBean = almacenBean;
}
public ArticuloBean getArticuloBean() {
	return articuloBean;
}
public void setArticuloBean(ArticuloBean articuloBean) {
	this.articuloBean = articuloBean;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
public String getLote() {
	return lote;
}
public void setLote(String lote) {
	this.lote = lote;
}
public float getPrecioCompra() {
	return precioCompra;
}
public void setPrecioCompra(float precioCompra) {
	this.precioCompra = precioCompra;
}
public float getPrecioVenta() {
	return precioVenta;
}
public void setPrecioVenta(float precioVenta) {
	this.precioVenta = precioVenta;
}
public Date getFechaVencimiento() {
	return fechaVencimiento;
}
public Date setFechaVencimiento(Date fechaVencimiento) {
	return this.fechaVencimiento = fechaVencimiento;
}
public Catalogo02 getModalidadAdquision() {
	return modalidadAdquision;
}
public void setModalidadAdquision(Catalogo02 modalidadAdquision) {
	this.modalidadAdquision = modalidadAdquision;
}
public Catalogo02 getTipoFinanciador() {
	return tipoFinanciador;
}
public void setTipoFinanciador(Catalogo02 tipoFinanciador) {
	this.tipoFinanciador = tipoFinanciador;
}
public Catalogo02 getTipoSeleccion() {
	return tipoSeleccion;
}
public void setTipoSeleccion(Catalogo02 tipoSeleccion) {
	this.tipoSeleccion = tipoSeleccion;
}
public String getNroRegistroSanitario() {
	return nroRegistroSanitario;
}
public void setNroRegistroSanitario(String nroRegistroSanitario) {
	this.nroRegistroSanitario = nroRegistroSanitario;
}
public ProveedorBean getProveedorBean() {
	return proveedorBean;
}
public void setProveedorBean(ProveedorBean proveedorBean) {
	this.proveedorBean = proveedorBean;
}
public String getTipoLlamada() {
	return tipoLlamada;
}
public void setTipoLlamada(String tipoLlamada) {
	this.tipoLlamada = tipoLlamada;
}





}
