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
						name="stock.findByLikeObjectVO", 
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
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=Integer.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=Integer.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=Integer.class),							
								@StoredProcedureParameter(mode=ParameterMode.IN, name="CANTIDAD_DIAS", type=Integer.class )
						}					
										
				),
				@NamedStoredProcedureQuery(
						name="stock.insertSISMED", 
						procedureName="SP_stock_INSERTAR_SISMED",
						parameters={
//									@StoredProcedureParameter(mode=ParameterMode.OUT, name="idStock", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
									
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION_ALMACEN", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION_ALMACEN", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE_ALMACEN", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_VERSION_ALMACEN", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO_ALMACEN", type=int.class ), 
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idAlmacen", type=Integer.class ),
									
									@StoredProcedureParameter(mode=ParameterMode.IN, name="CADENA_CODIGO_SISMED", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="CANT_ITEMS", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="CADENA_stock", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="CADENA_LOTE", type=String.class ),
									
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SITUACION", type=Integer.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioRegistro", type=Integer.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipRegistro", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_OPERACION", type=Integer.class),
									
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="CADENA_PRECIO_COMPRA", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="CADENA_PRECIO_VENTA", type=String.class),	
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="CADENA_PRECIO_ADQUISICION", type=String.class),
									
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="CADENA_FECHA_VENCIMIENTO", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idModalidadAdquisicion", type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="tipoFinanciador", type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="tipoSeleccion", type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="CADENA_NRO_REG_SANITARIO", type=String.class),
									
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION_PROVEEDOR", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION_PROVEEDOR", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE_PROVEEDOR", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_VERSION_PROVEEDOR", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO_PROVEEDOR", type=int.class ), 
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_PROVEEDOR", type=Integer.class ),
									
									
							}					
				),
				@NamedStoredProcedureQuery(
						name="stock.listarStockDiarios", 
						procedureName="[FARMACIA].[dbo].[SP_stock_DIARIOS]",
						resultClasses = Stock.class,
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="FECHA", type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="idAlmacen", type=Integer.class)
						}					
										
				),
				@NamedStoredProcedureQuery(
						name="stock.stock_insertar", 
						procedureName="[FARMACIA].[dbo].[SP_TEM_stock_INSERT]",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="CODIGO_SISMED", type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="CODIGO_MINSA_ALMACEN", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="lote", type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="stock", type=Integer.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="fechaVencimiento", type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="REGISTRO_SANITARIO", type=String.class)
						}	
						
										
				),
				@NamedStoredProcedureQuery(
						name="stock.actualizar", 
						procedureName="[FARMACIA].[dbo].[SP_stock_ACTUALIZAR]",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="idAlmacen", type=int.class )
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
	private int idStock;

	@Column(name="lote")
	private String lote;

	@Column(name="stock")
	private int Stock;
	
	@Column(name="precioVenta")
	private double precioVenta;

	@Column(name="precioCompra")
	private double precioCompra;
	
	@Column(name="fechaVencimiento")
	private Timestamp fechaVencimiento;
	
	@Column(name="idAlmacen")
	private String idAlmacen;
	
 
	@Column(name="idArticulo")
	private String idArticulo;
	
	private String tipoLlamada;
	
	@Column(name="idModalidadAdquisicion")
	private int idModalidaAquisicion;
	
 
	@Column(name="tipoFinanciador")
	private String tipoFinanciamiento;
	 
	@Column(name="tipoSeleccion")
	private String TipoProcesoSeleccion;
	
	@Column(name="nroRegistroSanitario")
	private String nroRegistroSanitario;
	
	@Column(name="ID_ORGANIZACION_stock")
	private int idOrganizacionStock;
	
	@Column(name="ID_INSTITUCION_stock")
	private int idInstitucionStock;
	
	@Column(name="ID_SEDE_stock")
	private int idSedeStock;
	
	@Column(name="NRO_VERSION_stock")
	private int nroVersionStock;
	
	@Column(name="NRO_PERIODO_stock")
	private int nroPeriodoStock;
	
 
	@Column(name="ID_PROVEEDOR")
	private String proveedor;
	
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
	
	public Stock() { 
	}

    
	public String getCadenaPrecioAdquisicion() {
		return cadenaPrecioAdquisicion;
	}


	public void setCadenaPrecioAdquisicion(String cadenaPrecioAdquisicion) {
		this.cadenaPrecioAdquisicion = cadenaPrecioAdquisicion;
	}


	public int getIdStock() {
		return idStock;
	}


	public void setIdStock(int idStock) {
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


	public double getPrecioCompra() {
		return precioCompra;
	}


	public void setPrecioCompra(double precioCompra) {
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


	public double getPrecioVenta() {
		return this.precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}
	
	public String getTipoLlamada() {
		return tipoLlamada;
	}


	public void setTipoLlamada(String tipoLlamada) {
		this.tipoLlamada = tipoLlamada;
	}


	public int getIdModalidaAquisicion() {
		return idModalidaAquisicion;
	}


	public void setIdModalidaAquisicion(int idModalidaAquisicion) {
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

	public int getIdOrganizacionStock() {
		return idOrganizacionStock;
	}

	public void setIdOrganizacionStock(int idOrganizacionStock) {
		this.idOrganizacionStock = idOrganizacionStock;
	}


	public int getIdInstitucionStock() {
		return idInstitucionStock;
	}


	public void setIdInstitucionStock(int idInstitucionStock) {
		this.idInstitucionStock = idInstitucionStock;
	}


	public int getIdSedeStock() {
		return idSedeStock;
	}


	public void setIdSedeStock(int idSedeStock) {
		this.idSedeStock = idSedeStock;
	}


	public int getNroVersionStock() {
		return nroVersionStock;
	}


	public void setNroVersionStock(int nroVersionStock) {
		this.nroVersionStock = nroVersionStock;
	}


	public int getNroPeriodoStock() {
		return nroPeriodoStock;
	}


	public void setNroPeriodoStock(int nroPeriodoStock) {
		this.nroPeriodoStock = nroPeriodoStock;
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

}