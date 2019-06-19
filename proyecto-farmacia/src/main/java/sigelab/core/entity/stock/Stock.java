package sigelab.core.entity.stock;

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
						procedureName="SP_STOCK_BUSCAR_X_ID",
						resultClasses= Stock.class,
						parameters={
									//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_STOCK", type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO", type=int.class )
							}					
					),
					@NamedStoredProcedureQuery(
							name="stock.findByObject", 
							procedureName="SP_STOCK_BUSCAR_X_ID",
							resultClasses= Stock.class,
							parameters={
									//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_STOCK", type=Integer.class),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class )
								}					
						),
				@NamedStoredProcedureQuery(
						name="stock.findByLikeObjectVO", 
						procedureName="SP_STOCK_BUSCAR_X_CRITERIOS",
						resultClasses= Stock.class,
						parameters={
								//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_CORTO_ARTICULO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ARTICULO", type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="TIPO_LLAMADA", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ALMACEN", type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class )
									
							}	
				),
				
				@NamedStoredProcedureQuery(
						name="stock.insert", 
						procedureName="SP_STOCK_INSERTAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="ID_STOCK", type=Integer.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ALMACEN", type=Integer.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ARTICULO", type=Integer.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="STOCK", type=Integer.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="LOTE", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SITUACION", type=Integer.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_USUARIO", type=Integer.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_OPERACION", type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="PRECIO_COMPRA", type=Float.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="PRECIO_VENTA", type=Float.class),									
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="FECHA_VENCIMIENTO", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_MODALIDAD_ADQUISICION", type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_TIPO_FINANCIADOR", type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_TIPO_SELECCION", type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NRO_REG_SANITARIO", type=String.class)
									
									
							}					
				),
				@NamedStoredProcedureQuery(
						name="stock.update", 
						procedureName="PKG_CLASE.SP_ACTUALIZAR",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_CLASE", type=Integer.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NOMBRE_CORTO", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NOMBRE_LARGO", type=String.class),
								
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SITUACION", type=Integer.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_USUARIO", type=Integer.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_IP", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_SESSION", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_OPERACION", type=Integer.class)
						}					
										
				),
				@NamedStoredProcedureQuery(
						name="stock.delete", 
						procedureName="PKG_CLASE.SP_ELIMINAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_CLASE", type=Integer.class )
							}					
				),
				@NamedStoredProcedureQuery(
						name="stock.listarProductosAVerncerse", 
						procedureName="[FARMACIA].[dbo].[SP_STOCK_LISTAR_PRODUCTOS_A_VENCER]",
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
						procedureName="SP_STOCK_INSERTAR_SISMED",
						parameters={
//									@StoredProcedureParameter(mode=ParameterMode.OUT, name="ID_STOCK", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
									
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION_ALMACEN", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION_ALMACEN", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE_ALMACEN", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_VERSION_ALMACEN", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO_ALMACEN", type=int.class ), 
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ALMACEN", type=Integer.class ),
									
									@StoredProcedureParameter(mode=ParameterMode.IN, name="CADENA_CODIGO_SISMED", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="CANT_ITEMS", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="CADENA_STOCK", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="CADENA_LOTE", type=String.class ),
									
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SITUACION", type=Integer.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_USUARIO", type=Integer.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_OPERACION", type=Integer.class),
									
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="CADENA_PRECIO_COMPRA", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="CADENA_PRECIO_VENTA", type=String.class),	
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="CADENA_PRECIO_ADQUISICION", type=String.class),
									
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="CADENA_FECHA_VENCIMIENTO", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_MODALIDAD_ADQUISICION", type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_TIPO_FINANCIADOR", type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_TIPO_SELECCION", type=Integer.class),
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
						procedureName="[FARMACIA].[dbo].[SP_STOCK_DIARIOS]",
						resultClasses = Stock.class,
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="FECHA", type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ALMACEN", type=Integer.class)
						}					
										
				),
				@NamedStoredProcedureQuery(
						name="stock.stock_insertar", 
						procedureName="[FARMACIA].[dbo].[SP_TEM_STOCK_INSERT]",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="CODIGO_SISMED", type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="CODIGO_MINSA_ALMACEN", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="LOTE", type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="STOCK", type=Integer.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="FECHA_VENCIMIENTO", type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="REGISTRO_SANITARIO", type=String.class)
						}					
										
				),
				@NamedStoredProcedureQuery(
						name="stock.actualizar", 
						procedureName="[FARMACIA].[dbo].[SP_STOCK_ACTUALIZAR]",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ALMACEN", type=int.class )
						}					
										
				)
		
		}
	)
@Entity
@Table(name="STOCK")
public class Stock 
 {
	
	@Id
	@Column(name="ID_STOCK")
	private int idStock;

	@Column(name="LOTE")
	private String lote;

	@Column(name="STOCK")
	private int Stock;
	
	@Column(name="PRECIO_VENTA")
	private double precioVenta;

	@Column(name="PRECIO_COMPRA")
	private double precioCompra;
	
	@Column(name="FECHA_VENCIMIENTO")
	private Timestamp fechaVencimiento;
	
	@Column(name="ID_ALMACEN")
	private String idAlmacen;
	
 
	@Column(name="ID_ARTICULO")
	private String idArticulo;
	
	private String tipoLlamada;
	
	@Column(name="ID_MODALIDAD_ADQUISICION")
	private int idModalidaAquisicion;
	
 
	@Column(name="ID_TIPO_FINANCIADOR")
	private String tipoFinanciamiento;
	 
	@Column(name="ID_TIPO_SELECCION")
	private String TipoProcesoSeleccion;
	
	@Column(name="NRO_REG_SANITARIO")
	private String nroRegistroSanitario;
	
	@Column(name="ID_ORGANIZACION_STOCK")
	private int idOrganizacionStock;
	
	@Column(name="ID_INSTITUCION_STOCK")
	private int idInstitucionStock;
	
	@Column(name="ID_SEDE_STOCK")
	private int idSedeStock;
	
	@Column(name="NRO_VERSION_STOCK")
	private int nroVersionStock;
	
	@Column(name="NRO_PERIODO_STOCK")
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