package proyect.core.entity.movimiento;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import proyect.core.entity.stock.Stock;
 


@NamedStoredProcedureQueries(
		{
			@NamedStoredProcedureQuery(
				name="movimientoAlmacen.insert", 
				procedureName="[dbo].[usp_AlmacenMovimiento_insertar]",
				parameters={
							@StoredProcedureParameter(mode=ParameterMode.OUT, name="idMovimiento", 	   		 type=String.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idTipoMovimiento",   	 type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="cantidad", 		   		 type=int.class),
							
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idAlmacenOrigen",  		 type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idAlmacenDestino", 		 type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="nroDocumento", 	   		 type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioRegistro",  		 type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipRegistro", 	   		 type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="nroGuia", 		   		 type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaIdStock",    		 type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaCantidad",   		 type=String.class),							
							@StoredProcedureParameter(mode=ParameterMode.OUT, name="valida", 		   		 type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="tipoIngresoDocumento",   type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idTipoFinanciadorCat02", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idTipoSeleccionCat02", 	 type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idTipoDocCompraCat02", 	 type=String.class)
					}
					),	
			@NamedStoredProcedureQuery(
					name="movimientoAlmacen.insertCompra", 
					procedureName="[dbo].[usp_AlmacenMovimiento_insertarCompra]",
					parameters={
								@StoredProcedureParameter(mode=ParameterMode.OUT, name="idMovimiento", 			 type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="cantidad", 				 type=int.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="idAlmacen",			 	 type=String.class),							
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="nroDocumento", 			 type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioRegistro", 		 type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipRegistro", 			 type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="nroGuia", 				 type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaIdArticulo", 		 type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaCantidad", 		 type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaLote",		     type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaPrecioCompra", 	 type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaPrecioVenta", 	 type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaFechaVencimiento", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaRegistroSanitario",type=String.class),

								@StoredProcedureParameter(mode=ParameterMode.IN,  name="idProveedor", 			 type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="idTipoFinanciadorCat02", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="idTipoSeleccionCat02",   type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="idTipoDocCompraCat02", 	 type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="idpersona", 			 type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="glosa", 				 type=String.class)
						}
						),	
					@NamedStoredProcedureQuery(
							name="movimientoAlmacen.findByLikeObject", 
							procedureName="PKG_MOVIMIENTO_ALMACEN.SP_BUSCAR_X_CRITERIOS",
							resultClasses= MovimientoAlmacen.class,
							parameters={
										@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class )
								}	
					),
					@NamedStoredProcedureQuery(
							name="movimientoAlmacen.cargarIngresoTransferencia", 
							procedureName="[dbo].[usp_AlmacenMovimiento_cargarIngresoTranf]",
							resultClasses= MovimientoAlmacen.class,
							parameters={
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="idAlmacenOrigen",  type=String.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="idAlmacenDestino", type=String.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="nroDocumento",     type=String.class)
								}	
					),
					@NamedStoredProcedureQuery(
							name="movimientoAlmacen.buscarXCriterioVO", 
							procedureName="[dbo].[usp_AlmacenMovimiento_buscarxCriterios]",
							resultClasses= MovimientoAlmacen.class,
							parameters={
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="nroDocumento", 	   type=String.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="idAlmacenOrigen",  type=String.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="idAlmacenDestino", type=String.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="idTipoMovimiento", type=String.class)
								}	
					),
					@NamedStoredProcedureQuery(
							name="movimientoAlmacen.listaIngresoTransferencia", 
							procedureName="[dbo].[usp_AlmacenMovimiento_listaIngresoTranf]",
							resultClasses= MovimientoAlmacen.class,
							parameters={
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="idAlmacenDestino", type=String.class)
								}	
					),
					@NamedStoredProcedureQuery(
							name="movimientoAlmacen.validarExisteNroDocumento", 
							procedureName="[dbo].[usp_AlmacenMovimiento_validarExisteNroDocumento]",
							resultClasses= MovimientoAlmacen.class,
							parameters={
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="nroDocumento", 	    type=String.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="idAlmacenOrigen",   type=String.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="idStock", 			type=String.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="idTipoMovimiento",  type=String.class)
								}	
					),
					@NamedStoredProcedureQuery(
							name="movimientoAlmacen.listarMovimientoKardexXidStock", 
							procedureName="[dbo].[usp_AlmacenMovimiento_buscarxIdStock]",
							resultClasses= MovimientoAlmacen.class,
							parameters={
							
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="idStock", 	 type=String.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="fechaDesde", type=Timestamp.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="fechaHasta", type=Timestamp.class)
								}	
					),		
					@NamedStoredProcedureQuery(
							name="movimientoAlmacen.listarMovimientoKardexXcodsismed", 
							procedureName="SP_MOVIMIENTO_ALMACEN_X_CODSISMED",
							resultClasses= MovimientoAlmacen.class,
							parameters={
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="codigoSismed", 		type=String.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="fechaDesde", 		type=Timestamp.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="fechaHasta", 		type=Timestamp.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="periodoStock",  	type=String.class )
								}	
					),
					@NamedStoredProcedureQuery(
							name="movimientoAlmacen.generarNroDocumento", 
							procedureName="SP_MOVIMIENTO_ALMACEN_GENERAR_NRO_DOC",
							resultClasses= MovimientoAlmacen.class
					),
					
					@NamedStoredProcedureQuery(
							name="movimientoAlmacen.reporteICI", 
							procedureName="SP_MOVIMIENTO_ALMACEN_REPORTE_ICI",
							resultClasses= MovimientoAlmacen.class,
									parameters={
												@StoredProcedureParameter(mode=ParameterMode.IN,  name="mes", 			type=String.class),
												@StoredProcedureParameter(mode=ParameterMode.IN,  name="anio", 			type=String.class),
												@StoredProcedureParameter(mode=ParameterMode.IN,  name="idAlmacen", 	type=String.class),
												@StoredProcedureParameter(mode=ParameterMode.IN,  name="idInventario",  type=String.class),
												@StoredProcedureParameter(mode=ParameterMode.IN,  name="fechaInvSig",   type=Timestamp.class)
										}
					),
					
					@NamedStoredProcedureQuery(
							name="movimientoAlmacen.listarAbastecimiento", 
							procedureName="[SP_VENTA_LISTAR_ABASTECIMIENTO_IME]",
							resultClasses= MovimientoAlmacen.class,
									parameters={
												@StoredProcedureParameter(mode=ParameterMode.IN, name="mes", 		type=String.class),
												@StoredProcedureParameter(mode=ParameterMode.IN, name="periodo", 	type=String.class), 
												@StoredProcedureParameter(mode=ParameterMode.IN, name="idAlmacen",  type=String.class)
										}
					)
		}			
	)


@Entity
public class MovimientoAlmacen  implements Serializable {
	@Id
	@Column(name="idMovimiento")
	private String idMovimientoAlmacen;

	@Column(name="cantidad")
	private int cantidad;

	@Column(name="nroDocumento")
	private String  nroDocumento;

	@Column(name="MONTO")
	private int monto;

	@Column(name="SALDO")
	private int saldo;

	@Column(name="ORDEN")
	private String orden;

	@Column(name="PRECIO")
	private double precio;
	
	@Column(name="nroGuia")
	private String nroGuia;

	@Column(name="glosa")
	private String glosa;
	
	@Column(name="FECHA_MOVIMIENTO")
	private String fechaMovimiento;
	
	@Column(name="tipoIngresoDocumento")
	private String tipoIngresoDocumento;
	
 
	@Column(name="ID_ARTICULO")
	private String articulo;
	

	@Column(name="idStock")
	private  String idStock;

	@Column(name="idTipoMovimiento")
	private  String idTipoMovimiento;
	
	@Column(name="idAlmacenOrigen")
	private  String almacenOrigen;
	
	@Column(name="idAlmacenDestino")
	private  String almacenDestino;
	
	@Column(name="idTipoFinanciadorCat02")
	private  String tipoFinanciamiento;
	
	@Column(name="idTipoSeleccionCat02")
	private  String tipoProcesoSeleccion;
 
	@Column(name="idpersona")
	private  String idPersona;
	
	@Column(name="idTipoDocCompraCat02")
	private  String idTipoDocumentoCompra;
	
	@Column(name="mes")
	private String mes;
	
	@Column(name="anio")
	private String anio;
	
/**	@Column(name="ID_ORGANIZACION_MOVIMIENTO_ALMACEN")
	private int idOrganizacionMovimientoAlmacen;
	
	@Column(name="ID_INSTITUCION_MOVIMIENTO_ALMACEN")
	private int idInstitucionMovimientoAlmacen;
	
	@Column(name="ID_SEDE_MOVIMIENTO_ALMACEN")
	private int idSedeMovimientoAlmacen;
	
	@Column(name="NRO_VERSION_MOVIMIENTO_ALMACEN")
	private int nroVersionMovimientoAlmacen;
	
	@Column(name="NRO_PERIODO_MOVIMIENTO_ALMACEN")
	private int nroPeriodoMovimientoAlmacen;
*/
	
	@Column(name="FECHA_ORDEN")
	private Timestamp fechaOrden;
	
	
	 
	 
	
	private String id_concepto;
	
	private List<Stock> stockItems;
	
	private List<MovimientoAlmacen> movimientoAlmacenItems; 
	
	private String cadenaCantdArt;
	
	private String cadenaNroPeriodoStock;
	
	private String cadenaIdStock;
	
	private double subtotal;

	private double total;
	
	private int idAlmacen;
	
	private int idInventario;
	
	private Timestamp fechaInventarioSig;
	
//	private List<VentaAnuladasVO> ventaAnuladas;
	
//	private List<VentaVO> atenciones;
	
	private List<MovimientoAlmacen> abastecimientos;
	
	
	public MovimientoAlmacen() { 
	}
	
	public MovimientoAlmacen removeMovimientoAlmacenItem(MovimientoAlmacen movimientoAlmacenItem) {
		getMovimientoAlmacenItems().remove(movimientoAlmacenItem);

		return movimientoAlmacenItem;
	}
	public MovimientoAlmacen addMovimientoAlmacenItem(MovimientoAlmacen movimientoAlmacen) {
		this.getMovimientoAlmacenItems().add(movimientoAlmacen);

		return movimientoAlmacen;
	}

	public String getIdMovimientoAlmacen() {
		return idMovimientoAlmacen;
	}


	public void setIdMovimientoAlmacen(String idMovimientoAlmacen) {
		this.idMovimientoAlmacen = idMovimientoAlmacen;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public String getNroDocumento() {
		return nroDocumento;
	}


	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}


	public int getMonto() {
		return monto;
	}


	public void setMonto(int monto) {
		this.monto = monto;
	}


	public int getSaldo() {
		return saldo;
	}


	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}


	public String getOrden() {
		return orden;
	}


	public void setOrden(String orden) {
		this.orden = orden;
	}


	public double getPrecio() {
		return precio;
	}

	public String getNroGuia() {
		return nroGuia;
	}

	public void setNroGuia(String nroGuia) {
		this.nroGuia = nroGuia;
	}

	public String getGlosa() {
		return glosa;
	}

	public void setGlosa(String glosa) {
		this.glosa = glosa;
	}

	public String getFechaMovimiento() {
		return fechaMovimiento;
	}

	public void setFechaMovimiento(String fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}

	public String getTipoIngresoDocumento() {
		return tipoIngresoDocumento;
	}

	public void setTipoIngresoDocumento(String tipoIngresoDocumento) {
		this.tipoIngresoDocumento = tipoIngresoDocumento;
	}

	public String getArticulo() {
		return articulo;
	}

	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}

	public String getIdStock() {
		return idStock;
	}

	public void setIdStock(String idStock) {
		this.idStock = idStock;
	}

	public String getIdTipoMovimiento() {
		return idTipoMovimiento;
	}

	public void setIdTipoMovimiento(String idTipoMovimiento) {
		this.idTipoMovimiento = idTipoMovimiento;
	}

	public String getAlmacenOrigen() {
		return almacenOrigen;
	}

	public void setAlmacenOrigen(String almacenOrigen) {
		this.almacenOrigen = almacenOrigen;
	}

	public String getAlmacenDestino() {
		return almacenDestino;
	}

	public void setAlmacenDestino(String almacenDestino) {
		this.almacenDestino = almacenDestino;
	}

	public String getTipoFinanciamiento() {
		return tipoFinanciamiento;
	}

	public void setTipoFinanciamiento(String tipoFinanciamiento) {
		this.tipoFinanciamiento = tipoFinanciamiento;
	}

	public String getTipoProcesoSeleccion() {
		return tipoProcesoSeleccion;
	}

	public void setTipoProcesoSeleccion(String tipoProcesoSeleccion) {
		this.tipoProcesoSeleccion = tipoProcesoSeleccion;
	}

	public String getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}

	public String getIdTipoDocumentoCompra() {
		return idTipoDocumentoCompra;
	}

	public void setIdTipoDocumentoCompra(String idTipoDocumentoCompra) {
		this.idTipoDocumentoCompra = idTipoDocumentoCompra;
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

	public Timestamp getFechaOrden() {
		return fechaOrden;
	}

	public void setFechaOrden(Timestamp fechaOrden) {
		this.fechaOrden = fechaOrden;
	}

	public String getId_concepto() {
		return id_concepto;
	}

	public void setId_concepto(String id_concepto) {
		this.id_concepto = id_concepto;
	}

	public List<Stock> getStockItems() {
		return stockItems;
	}

	public void setStockItems(List<Stock> stockItems) {
		this.stockItems = stockItems;
	}

	public List<MovimientoAlmacen> getMovimientoAlmacenItems() {
		return movimientoAlmacenItems;
	}

	public void setMovimientoAlmacenItems(List<MovimientoAlmacen> movimientoAlmacenItems) {
		this.movimientoAlmacenItems = movimientoAlmacenItems;
	}

	public String getCadenaCantdArt() {
		return cadenaCantdArt;
	}

	public void setCadenaCantdArt(String cadenaCantdArt) {
		this.cadenaCantdArt = cadenaCantdArt;
	}

	public String getCadenaNroPeriodoStock() {
		return cadenaNroPeriodoStock;
	}

	public void setCadenaNroPeriodoStock(String cadenaNroPeriodoStock) {
		this.cadenaNroPeriodoStock = cadenaNroPeriodoStock;
	}

	public String getCadenaIdStock() {
		return cadenaIdStock;
	}

	public void setCadenaIdStock(String cadenaIdStock) {
		this.cadenaIdStock = cadenaIdStock;
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

	public int getIdAlmacen() {
		return idAlmacen;
	}

	public void setIdAlmacen(int idAlmacen) {
		this.idAlmacen = idAlmacen;
	}

	public int getIdInventario() {
		return idInventario;
	}

	public void setIdInventario(int idInventario) {
		this.idInventario = idInventario;
	}

	public Timestamp getFechaInventarioSig() {
		return fechaInventarioSig;
	}

	public void setFechaInventarioSig(Timestamp fechaInventarioSig) {
		this.fechaInventarioSig = fechaInventarioSig;
	}

	public List<MovimientoAlmacen> getAbastecimientos() {
		return abastecimientos;
	}

	public void setAbastecimientos(List<MovimientoAlmacen> abastecimientos) {
		this.abastecimientos = abastecimientos;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
 

	 
	
}