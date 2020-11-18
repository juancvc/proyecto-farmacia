package proyect.core.entity.stock;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id; 
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table; 

@SuppressWarnings("serial")
@NamedStoredProcedureQueries(
		{
				
				@NamedStoredProcedureQuery(
						name="stock.findByObjectVO", 
						procedureName="[dbo].[usp_Stock_buscarxID]",
						resultClasses= Stock.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idStock", type=String.class)
							}					
					),
					@NamedStoredProcedureQuery(
							name="stock.findByObject", 
							procedureName="SP_stock_BUSCAR_X_ID",
							resultClasses= Stock.class,
							parameters={
								
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="idStock", type=String.class),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class )
								}					
						),
				@NamedStoredProcedureQuery(
						name="stock.buscarPorFiltros", 
						procedureName="[dbo].[usp_Stock_buscarxCriterios]",
						resultClasses= Stock.class,
						parameters={
					
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="nombreArticulo", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idArticulo", 	 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="tipoLlamada", 	 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idAlmacen", 	 type=String.class)
									
							}	
				),
				
				@NamedStoredProcedureQuery(
						name="stock.buscarPorIdArticulo", 
						procedureName="[dbo].[usp_Stock_buscarxIdArticulo]",
						resultClasses= Stock.class,
						parameters={
					 
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idArticulo", 	 type=String.class)
									
							}	
				),
				
				@NamedStoredProcedureQuery(
						name="stock.insert", 
						procedureName="[dbo].[usp_Stock_insertar]",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="idStock", 				 type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idAlmacen", 			 type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idArticulo", 			 type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="stock", 				 type=Integer.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="lote", 					 type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioRegistro", 		 type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipRegistro", 			 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="precioCompra", 			 type=Float.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="precioVenta", 			 type=Float.class),									
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="fechaVencimiento",  	 type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idModalidadAdquisicion", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="tipoFinanciador", 		 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="tipoSeleccion", 		 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="nroRegistroSanitario",   type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idProveedor", 			 type=String.class)
									
									
							}					
				),
				@NamedStoredProcedureQuery(
						name="clase.update", 
						procedureName="[dbo].[usp_ClaseArticulo_actualizar]",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="idClase", 		 type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="nombreClase", 	 type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="detalle", 		 type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="usuarioRegistro", type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ipRegistro", 	 type=String.class)
						}					
										
				),
				@NamedStoredProcedureQuery(
						name="clase.delete", 
						procedureName="[dbo].[usp_ClaseArticulo_eliminar]",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="idClase", 	 type=String.class )
							}					
				),
				@NamedStoredProcedureQuery(
						name="stock.listarProductosAVerncerse", 
						procedureName="[FARMACIA].[dbo].[SP_stock_LISTAR_PRODUCTOS_A_VENCER]",
						resultClasses = Stock.class,
						parameters={													
								@StoredProcedureParameter(mode=ParameterMode.IN, name="cantidadDias", type=Integer.class )
						}					
										
				),
				@NamedStoredProcedureQuery(
						name="stock.insertSISMED", 
						procedureName="SP_stock_INSERTAR_SISMED",
						parameters={
//									@StoredProcedureParameter(mode=ParameterMode.OUT, name="idStock", type=int.class ),


									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idAlmacen", 		 type=String.class ),
									
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaCodigoSismed",  type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="cantidadItems", 	  type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaStock", 		  type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaLote", 		  type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioRegistro", 	  type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipRegistro", 		  type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaPrecioCompra",  type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaPrecioVenta",   type=String.class),	
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaPrecioAdquisicion", type=String.class),
									
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaFechaVencimiento", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idModalidadAdquisicion", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="tipoFinanciador", 		 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="tipoSeleccion", 		 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaNroRegSanitario",  type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idProveedor", 			 type=String.class )
									
									
							}					
				),
				@NamedStoredProcedureQuery(
						name="stock.listarStockDiarios", 
						procedureName="[FARMACIA].[dbo].[SP_stock_DIARIOS]",
						resultClasses = Stock.class,
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="fecha", 	   type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="idAlmacen", type=String.class)
						}					
										
				),
				@NamedStoredProcedureQuery(
						name="stock.stock_insertar", 
						procedureName="[FARMACIA].[dbo].[SP_TEM_stock_INSERT]",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="codigoSismed", 		type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="codigoMinsaAlmacen", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="lote", 				type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="stock", 				type=Integer.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="fechaVencimiento",   type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="registroSanitario",  type=String.class)
						}	
						
										
				),
				@NamedStoredProcedureQuery(
						name="stock.actualizar", 
						procedureName="[FARMACIA].[dbo].[SP_stock_ACTUALIZAR]",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="idAlmacen", type=String.class )
						}					
										
				)
		
		}
	)
@Entity
@Table(name="stock")
public class Stock 
 {
	
	@Id
	@Column(name="idStock")
	private String idStock;

	@Column(name="lote")
	private String lote;

	@Column(name="stock")
	private int Stock;
	
	@Column(name="precioVenta")
	private float precioVenta;

	@Column(name="precioCompra")
	private float precioCompra;
	
	@Column(name="fechaVencimiento")
	private Timestamp fechaVencimiento;
	
	@Column(name="idAlmacen")
	private String idAlmacen;
	
	@Column(name="nombreAlmacen")
	private String nombreAlmacen;
	
	@Column(name="idArticulo")
	private String idArticulo;
	
	private String tipoLlamada;
	
	@Column(name="idModalidadAdquisicion")
	private String idModalidaAquisicion;
	
	@Column(name="nombreModalidadAdquisicion")
	private String nombreModalidadAdquisicion;
	
 
	@Column(name="tipoFinanciador")
	private String tipoFinanciamiento;
	 
	@Column(name="tipoSeleccion")
	private String TipoProcesoSeleccion;
	
	@Column(name="nroRegistroSanitario")
	private String nroRegistroSanitario;
 
	@Column(name="idProveedor")
	private String proveedor;
	
	private String nombreArticulo;
	private String concentracion;
	private String descripcionLargaPresentacion;
	
	private String cadenaIdArticulo;
	private String cadenaLote;
	private String cadenaFechaVencimiento;
	private String cadenaRegSanitario;
	private String cadenaPrecioVenta;
	private String cadenaPrecioCompra;
	private String cadenaPrecioAdquisicion;
	private String cadenaIdProveedor;
	private int  cantidadDias;
	private String cadenaStock;
	private int cantidadItems;
	private String codigoSismed;
	
	public Stock() { 
	}
 
	public String getCadenaPrecioAdquisicion() {
		return cadenaPrecioAdquisicion;
	}


	public void setCadenaPrecioAdquisicion(String cadenaPrecioAdquisicion) {
		this.cadenaPrecioAdquisicion = cadenaPrecioAdquisicion;
	}


	public String getDescripcionLargaPresentacion() {
		return descripcionLargaPresentacion;
	}

	public void setDescripcionLargaPresentacion(String descripcionLargaPresentacion) {
		this.descripcionLargaPresentacion = descripcionLargaPresentacion;
	}

	public String getIdStock() {
		return idStock;
	}


	public void setIdStock(String idStock) {
		this.idStock = idStock;
	}


	public String getLote() {
		return lote;
	}


	public void setLote(String lote) {
		this.lote = lote;
	}


	public String getCadenaStock() {
		return cadenaStock;
	}


	public void setCadenaStock(String cadenaStock) {
		this.cadenaStock = cadenaStock;
	}


	public int getStock() {
		return Stock;
	}


	public void setStock(int stock) {
		Stock = stock;
	}


	public float getPrecioCompra() {
		return precioCompra;
	}


	public void setPrecioCompra(float precioCompra) {
		this.precioCompra = precioCompra;
	}


	public Timestamp getFechaVencimiento() {
		return fechaVencimiento;
	}


	public void setFechaVencimiento(Timestamp fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

 

	public String getIdAlmacen() {
		return idAlmacen;
	}


	public void setIdAlmacen(String idAlmacen) {
		this.idAlmacen = idAlmacen;
	}


	public String getIdArticulo() {
		return idArticulo;
	}


	public void setIdArticulo(String idArticulo) {
		this.idArticulo = idArticulo;
	}


	public String getTipoFinanciamiento() {
		return tipoFinanciamiento;
	}


	public void setTipoFinanciamiento(String tipoFinanciamiento) {
		this.tipoFinanciamiento = tipoFinanciamiento;
	}


	public String getTipoProcesoSeleccion() {
		return TipoProcesoSeleccion;
	}


	public void setTipoProcesoSeleccion(String tipoProcesoSeleccion) {
		TipoProcesoSeleccion = tipoProcesoSeleccion;
	}


	public String getProveedor() {
		return proveedor;
	}


	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}


	public float getPrecioVenta() {
		return this.precioVenta;
	}

	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}
	
	public String getTipoLlamada() {
		return tipoLlamada;
	}


	public void setTipoLlamada(String tipoLlamada) {
		this.tipoLlamada = tipoLlamada;
	}


	public String getIdModalidaAquisicion() {
		return idModalidaAquisicion;
	}


	public void setIdModalidaAquisicion(String idModalidaAquisicion) {
		this.idModalidaAquisicion = idModalidaAquisicion;
	}
 
	public String getNroRegistroSanitario() {
		return nroRegistroSanitario;
	}


	public void setNroRegistroSanitario(String nroRegistroSanitario) {
		this.nroRegistroSanitario = nroRegistroSanitario;
	}
	
	public String getCadenaIdArticulo() {
		return cadenaIdArticulo;
	}
	public void setCadenaIdArticulo(String cadenaIdArticulo) {
		this.cadenaIdArticulo = cadenaIdArticulo;
	}
	public String getCadenaFechaVencimiento() {
		return cadenaFechaVencimiento;
	}
	public void setCadenaFechaVencimiento(String cadenaFechaVencimiento) {
		this.cadenaFechaVencimiento = cadenaFechaVencimiento;
	}
	public String getCadenaRegSanitario() {
		return cadenaRegSanitario;
	}
	public void setCadenaRegSanitario(String cadenaRegSanitario) {
		this.cadenaRegSanitario = cadenaRegSanitario;
	}
	public String getCadenaPrecioVenta() {
		return cadenaPrecioVenta;
	}
	public void setCadenaPrecioVenta(String cadenaPrecioVenta) {
		this.cadenaPrecioVenta = cadenaPrecioVenta;
	}
	public String getCadenaPrecioCompra() {
		return cadenaPrecioCompra;
	}
	public void setCadenaPrecioCompra(String cadenaPrecioCompra) {
		this.cadenaPrecioCompra = cadenaPrecioCompra;
	}

	public String getCadenaLote() {
		return cadenaLote;
	}

	public void setCadenaLote(String cadenaLote) {
		this.cadenaLote = cadenaLote;
	}
 
	public String getCadenaIdProveedor() {
		return cadenaIdProveedor;
	}

	public void setCadenaIdProveedor(String cadenaIdProveedor) {
		this.cadenaIdProveedor = cadenaIdProveedor;
	}
 
	public int getCantidadDias() {
		return cantidadDias;
	}

	public void setCantidadDias(int cantidadDias) {
		this.cantidadDias = cantidadDias;
	}

	public int getCantidadItems() {
		return cantidadItems;
	}

	public void setCantidadItems(int cantidadItems) {
		this.cantidadItems = cantidadItems;
	}

	public String getNombreAlmacen() {
		return nombreAlmacen;
	}

	public void setNombreAlmacen(String nombreAlmacen) {
		this.nombreAlmacen = nombreAlmacen;
	}

	public String getNombreModalidadAdquisicion() {
		return nombreModalidadAdquisicion;
	}

	public void setNombreModalidadAdquisicion(String nombreModalidadAdquisicion) {
		this.nombreModalidadAdquisicion = nombreModalidadAdquisicion;
	}

	public String getNombreArticulo() {
		return nombreArticulo;
	}

	public void setNombreArticulo(String nombreArticulo) {
		this.nombreArticulo = nombreArticulo;
	}

	public String getConcentracion() {
		return concentracion;
	}

	public void setConcentracion(String concentracion) {
		this.concentracion = concentracion;
	}

	public String getCodigoSismed() {
		return codigoSismed;
	}

	public void setCodigoSismed(String codigoSismed) {
		this.codigoSismed = codigoSismed;
	}
	
	

}