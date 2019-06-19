package sigelab.core.entity.movimiento;

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

import sigelab.core.entity.stock.Stock;
 


@NamedStoredProcedureQueries(
		{
			@NamedStoredProcedureQuery(
				name="movimientoAlmacen.insert", 
				procedureName="SP_MOVIMIENTO_ALMACEN_INSERTAR",
				parameters={
							@StoredProcedureParameter(mode=ParameterMode.OUT, name="ID_MOVIMIENTO", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_TIPO_MOVIMIENTO", type=int.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="CANTIDAD", type=int.class),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION_ALMACEN", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION_ALMACEN", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE_ALMACEN", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_VERSION_ALMACEN", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO_ALMACEN", type=int.class ),
							
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ALMACEN_ORIGEN", type=int.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ALMACEN_DESTINO", type=int.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="NRO_DOCUMENTO", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SITUACION", type=int.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_USUARIO", type=int.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_MAC", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_OPERACION", type=int.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="NROGUIA", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="CADENA_NRO_PERIODO_STOCK", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="CADENA_ID_STOCK", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="CADENA_CANTIDAD", type=String.class),							
							@StoredProcedureParameter(mode=ParameterMode.OUT, name="VALIDA", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="TIPO_ING_DOCUM", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_TIPO_FINANCIADOR", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_TIPO_SELECCION", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_TIPO_DOCUM_COMPRA", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.OUT, name="NRO_PERIODO", type=int.class )
					}
					),	
			@NamedStoredProcedureQuery(
					name="movimientoAlmacen.insertCompra", 
					procedureName="[SP_MOVIMIENTO_ALMACEN_INSERTAR_COMPRA]",
					parameters={
								@StoredProcedureParameter(mode=ParameterMode.OUT, name="ID_MOVIMIENTO", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="CANTIDAD", type=int.class),
								
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION_ALMACEN", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION_ALMACEN", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE_ALMACEN", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_VERSION_ALMACEN", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO_ALMACEN", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ALMACEN", type=int.class),
								
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="NRO_DOCUMENTO", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SITUACION", type=int.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_USUARIO", type=int.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_MAC", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_OPERACION", type=int.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="NROGUIA", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="CADENA_ID_ARTICULO", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="CADENA_CANTIDAD", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="CADENA_LOTE", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="CADENA_PRECIO_COMPRA", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="CADENA_PRECIO_VENTA", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="CADENA_FECHA_VENCIMIENTO", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="CADENA_REG_SANITARIO", type=String.class),
								
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION_PROVEEDOR", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION_PROVEEDOR", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE_PROVEEDOR", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_VERSION_PROVEEDOR", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO_PROVEEDOR", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_PROVEEDOR", type=int.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_TIPO_FINANCIADOR", type=Integer.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_TIPO_SELECCION", type=Integer.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_TIPO_DOCUM_COMPRA", type=Integer.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_PERSONA", type=Integer.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="GLOSA", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="FECHA_ORDEN", type=Timestamp.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ALM_ORIGEN", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ALM_VIR_ORI", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ALM_DESTINO", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ALM_VIR_DEST", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_CONCEPTO", type=String.class)
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
							procedureName="SP_MOVIMIENTO_ALMACEN_CARGAR_INGRESO_TRANF",
							resultClasses= MovimientoAlmacen.class,
							parameters={
									//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ALMACEN_ORIGEN", type=int.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ALMACEN_DESTINO", type=int.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="NRO_DOCUMENTO", type=String.class),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class )
								}	
					),
					@NamedStoredProcedureQuery(
							name="movimientoAlmacen.buscarXCriterioVO", 
							procedureName="SP_MOVIMIENTO_ALMACEN_BUSCAR_X_CRITERIOS",
							resultClasses= MovimientoAlmacen.class,
							parameters={
									//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="NRO_DOCUMENTO", type=String.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ALMACEN_ORIGEN", type=int.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ALMACEN_DESTINO", type=int.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_TIPO_MOVIMIENTO", type=int.class),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO", type=int.class )
								}	
					),
					@NamedStoredProcedureQuery(
							name="movimientoAlmacen.listaIngresoTransferencia", 
							procedureName="SP_MOVIMIENTO_ALMACEN_LISTA_INGRESO_TRANF",
							resultClasses= MovimientoAlmacen.class,
							parameters={
									//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ALMACEN_DESTINO", type=int.class),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class )
								}	
					),
					@NamedStoredProcedureQuery(
							name="movimientoAlmacen.validarExisteNroDocumento", 
							procedureName="SP_MOVIMIENTO_ALMACEN_VALIDAR_EXITE_NRODOCUM",
							resultClasses= MovimientoAlmacen.class,
							parameters={
									//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="NRO_DOCUMENTO", type=String.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ALMACEN_ORIGEN", type=int.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_STOCK", type=Integer.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_TIPO_MOVIMIENTO", type=int.class),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class )
								}	
					),
					@NamedStoredProcedureQuery(
							name="movimientoAlmacen.listarMovimientoKardexXidStock", 
							procedureName="SP_MOVIMIENTO_ALMACEN_X_ID_STOCK",
							resultClasses= MovimientoAlmacen.class,
							parameters={
									//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_STOCK", type=int.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="FECHA_DESDE", type=Timestamp.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="FECHA_HASTA", type=Timestamp.class),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO_STOCK", type=int.class )
								}	
					),		
					@NamedStoredProcedureQuery(
							name="movimientoAlmacen.listarMovimientoKardexXcodsismed", 
							procedureName="SP_MOVIMIENTO_ALMACEN_X_CODSISMED",
							resultClasses= MovimientoAlmacen.class,
							parameters={
									//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="COD_SISMED", type=String.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="FECHA_DESDE", type=Timestamp.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="FECHA_HASTA", type=Timestamp.class),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO_STOCK", type=int.class )
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
											//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
												@StoredProcedureParameter(mode=ParameterMode.IN,  name="MES", type=String.class),
												@StoredProcedureParameter(mode=ParameterMode.IN,  name="ANIO", type=String.class),
												@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
												@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
												@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class),
												@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ALMACEN", type=int.class),
												@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INVENTARIO", type=int.class),
												@StoredProcedureParameter(mode=ParameterMode.IN, name="FECHA_INV_SIG", type=Timestamp.class)
										}
					),
					
					@NamedStoredProcedureQuery(
							name="movimientoAlmacen.listarAbastecimiento", 
							procedureName="[SP_VENTA_LISTAR_ABASTECIMIENTO_IME]",
							resultClasses= MovimientoAlmacen.class,
									parameters={
												@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
												@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
												@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class),
												@StoredProcedureParameter(mode=ParameterMode.IN, name="MES", type=String.class),
												@StoredProcedureParameter(mode=ParameterMode.IN, name="PERIODO", type=String.class), 
												@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ALMACEN", type=int.class)
										}
					)
		}			
	)


@Entity
public class MovimientoAlmacen  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_MOVIMIENTO")
	private long idMovimientoAlmacen;

	@Column(name="CANTIDAD")
	private int cantidad;

	@Column(name="NRO_DOCUMENTO")
	private String  nroDocumento;

	@Column(name="MONTO")
	private int monto;

	@Column(name="SALDO")
	private int saldo;

	@Column(name="ORDEN")
	private String orden;

	@Column(name="PRECIO")
	private double precio;
	
	@Column(name="NROGUIA")
	private String nroGuia;

	@Column(name="GLOSA")
	private String glosa;
	
	@Column(name="FECHA_MOVIMIENTO")
	private String fechaMovimiento;
	
	@Column(name="TIPO_ING_DOCUM")
	private int tipoIngresoDocumento;
	
 
	@Column(name="ID_ARTICULO")
	private String articulo;
	

	@Column(name="ID_STOCK")
	private  String idStock;

	@Column(name="ID_TIPO_MOVIMIENTO")
	private  String idTipoMovimiento;
	
	@Column(name="ID_ALMACEN_ORIGEN")
	private  String almacenOrigen;
	
	@Column(name="ID_ALMACEN_DESTINO")
	private  String almacenDestino;
	
	@Column(name="ID_TIPO_FINANCIADOR")
	private  String tipoFinanciamiento;
	
	@Column(name="ID_TIPO_SELECCION")
	private  String tipoProcesoSeleccion;
 
	@Column(name="ID_PERSONA")
	private  String idPersona;
	
	@Column(name="ID_TIPO_DOCUM_COMPRA")
	private  String idTipoDocumentoCompra;
	
	@Column(name="MES")
	private String mes;
	
	@Column(name="ANIO")
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

	public long getIdMovimientoAlmacen() {
		return idMovimientoAlmacen;
	}


	public void setIdMovimientoAlmacen(long idMovimientoAlmacen) {
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

	public int getTipoIngresoDocumento() {
		return tipoIngresoDocumento;
	}

	public void setTipoIngresoDocumento(int tipoIngresoDocumento) {
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