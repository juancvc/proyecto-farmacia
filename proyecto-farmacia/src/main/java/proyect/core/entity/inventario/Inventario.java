package proyect.core.entity.inventario;
 
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id; 
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import proyect.core.entity.stock.Stock;
 
@SuppressWarnings("serial")
@NamedStoredProcedureQueries(
		{
				
				@NamedStoredProcedureQuery(
						name="inventario.insert", 
						procedureName="[dbo].[usp_Inventario_insertar]",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="idInventario", 			type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idAlmacen",   		    type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="mes", 					type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="anio", 					type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="cantidadItems", 		type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaCantidad", 		type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="nroDocumento", 			type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idPersonalResponsable", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="fecha", 				type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioRegistro", 		type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipRegistro", 			type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaIdStock", 		type=String.class)
							}					
				),
				@NamedStoredProcedureQuery(
						name="inventario.buscarXNroDocumento", 
						procedureName="[dbo].[usp_Inventario_buscarxNroDocumento]",
						resultClasses = Inventario.class,
						parameters={
						
								@StoredProcedureParameter(mode=ParameterMode.IN, name="idAlmacen", 	  type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="nroDocumento", type=String.class)
							}					
				), 
				@NamedStoredProcedureQuery(
						name="inventario.validarExisteInventario", 
						procedureName="[dbo].[usp_Inventario_validarExiste]",
						resultClasses = Inventario.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="idAlmacen", 		 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="nroPeriodo", 	 type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="nroMes", 		 type=String.class )
							}					
				),
				@NamedStoredProcedureQuery(
						name="inventario.findByLikeObjectVO", 
						procedureName="[dbo].[SP_INVENTARIO_BUSCAR_X_CRITERIOS]",
						resultClasses = Inventario.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="idAlmacen", 		 type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="nroPeriodo", 	 type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="nroMes", 		 type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="idSituacion",     type=String.class )
							}					
				),
				@NamedStoredProcedureQuery(
						name="inventario.buscarPorFiltros", 
						procedureName="[dbo].[usp_Inventario_buscarxCriterios]",
						resultClasses = Inventario.class,
						parameters={
						
								@StoredProcedureParameter(mode=ParameterMode.IN, name="idAlmacen", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="mes", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="anio", type=String.class)
							}					
				),
				@NamedStoredProcedureQuery(
						name="inventario.procesar", 
						procedureName="[dbo].[usp_Inventario_procesar]",
						resultClasses = Inventario.class,
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="idInventario", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="idAlmacen", type=String.class), 
								@StoredProcedureParameter(mode=ParameterMode.IN, name="nroDocumento", 	 type=String.class), 
								@StoredProcedureParameter(mode=ParameterMode.IN, name="periodo", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="nroMes", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="usuarioRegistro", type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ipRegistro", 	 type=String.class)
							}					
				),
		}
	)
@Entity
public class Inventario  {
	@Id
	@Column(name="idInventario")
	private String idInventario;

	@Column(name="idAlmacen")
	private String idAlmacen;
	 
	@Column(name="idPersonaResponsable")
	private String idPersonalResponsable;
	 
	@Column(name="ID_STOCK")
	private String idStock;
	
	@Column(name="fecha")
	private String fecha;

	@Column(name="nroDocumento")
	private String nroDocumento;
	
	@Column(name="CANTIDAD")
	private int cantidad;
	 
	@Column(name="nroMes")
	private int nroMes;
	
	@Column(name="ipRegistro")
	private String ipRegistro;

	@Column(name="usuarioRegistro")
	private String usuarioRegistro;
	
	private int cantidadItems;
	
	private String cadenaNroPeriodoStock;
	
	private String cadenaIdStock;
	
	private String cadenaCantidad;
	
	private List<Stock> stockItems;
	
	private double subtotal;

	private double total;
	
	private double precio;
	
	private String mes;
	private String nombreMes;
	private String anio; 
	private Timestamp fechaInvetario;
	private String nombreAlmacen;
	private String estado;
	private String idSituacion;
	private String situacion;
	private String nombresEncargado;
	private String apellidoPaternoEncargado;
	private String apellidoMaternoEncargado;
	
	public Inventario() { 
	}

	public String getNombreMes() {
		return nombreMes;
	}

	public void setNombreMes(String nombreMes) {
		this.nombreMes = nombreMes;
	}

	public String getIdSituacion() {
		return idSituacion;
	}

	public void setIdSituacion(String idSituacion) {
		this.idSituacion = idSituacion;
	}

	public String getSituacion() {
		return situacion;
	}

	public void setSituacion(String situacion) {
		this.situacion = situacion;
	}

	public Stock removeStockItem(Stock stockItem) {
		getStockItems().remove(stockItem);

		return stockItem;
	}
	public Stock addStockItem(Stock stock) {
		this.getStockItems().add(stock);

		return stock;
	}
 

	 


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getNroDocumento() {
		return nroDocumento;
	}


	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}


	public int getCantidadItems() {
		return cantidadItems;
	}


	public void setCantidadItems(int cantidadItems) {
		this.cantidadItems = cantidadItems;
	}


	public String getCadenaIdStock() {
		return cadenaIdStock;
	}


	public void setCadenaIdStock(String cadenaIdStock) {
		this.cadenaIdStock = cadenaIdStock;
	}


	public String getCadenaCantidad() {
		return cadenaCantidad;
	}


	public void setCadenaCantidad(String cadenaCantidad) {
		this.cadenaCantidad = cadenaCantidad;
	}
 

	public List<Stock> getStockItems() {
		return stockItems;
	}


	public void setStockItems(List<Stock> stockItems) {
		this.stockItems = stockItems;
	}
 

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getNroMes() {
		return nroMes;
	}

	public void setNroMes(int nroMes) {
		this.nroMes = nroMes;
	}

	public void ejecutarCalculosSubTotal(){ 
		//this.setSubtotal(this.getStock().getStock() * this.getPrecio());
	}
	
	public void ejecutarCalculosTotal(){
		Double tmpImporte=0.0;
		for (Stock StockItem : stockItems) {
			tmpImporte+=StockItem.getPrecioVenta();
		}
		this.setTotal(tmpImporte);
	}

	public String getCadenaNroPeriodoStock() {
		return cadenaNroPeriodoStock;
	}

	public void setCadenaNroPeriodoStock(String cadenaNroPeriodoStock) {
		this.cadenaNroPeriodoStock = cadenaNroPeriodoStock;
	}

	public String getIdInventario() {
		return idInventario;
	}

	public void setIdInventario(String idInventario) {
		this.idInventario = idInventario;
	}

	public String getIdAlmacen() {
		return idAlmacen;
	}

	public void setIdAlmacen(String idAlmacen) {
		this.idAlmacen = idAlmacen;
	}

	public String getIdPersonalResponsable() {
		return idPersonalResponsable;
	}

	public void setIdPersonalResponsable(String idPersonalResponsable) {
		this.idPersonalResponsable = idPersonalResponsable;
	}

	public String getIdStock() {
		return idStock;
	}

	public void setIdStock(String idStock) {
		this.idStock = idStock;
	}

	public String getFecha() {
		return fecha;
	}

	public String getIpRegistro() {
		return ipRegistro;
	}

	public void setIpRegistro(String ipRegistro) {
		this.ipRegistro = ipRegistro;
	}

	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public Timestamp getFechaInvetario() {
		return fechaInvetario;
	}

	public void setFechaInvetario(Timestamp fechaInvetario) {
		this.fechaInvetario = fechaInvetario;
	}

	public String getNombreAlmacen() {
		return nombreAlmacen;
	}

	public void setNombreAlmacen(String nombreAlmacen) {
		this.nombreAlmacen = nombreAlmacen;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombresEncargado() {
		return nombresEncargado;
	}

	public void setNombresEncargado(String nombresEncargado) {
		this.nombresEncargado = nombresEncargado;
	}

	public String getApellidoPaternoEncargado() {
		return apellidoPaternoEncargado;
	}

	public void setApellidoPaternoEncargado(String apellidoPaternoEncargado) {
		this.apellidoPaternoEncargado = apellidoPaternoEncargado;
	}

	public String getApellidoMaternoEncargado() {
		return apellidoMaternoEncargado;
	}

	public void setApellidoMaternoEncargado(String apellidoMaternoEncargado) {
		this.apellidoMaternoEncargado = apellidoMaternoEncargado;
	}

}