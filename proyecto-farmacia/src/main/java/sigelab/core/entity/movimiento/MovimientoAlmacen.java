package pe.com.galaxy.systems.apolo.core.entidad.entidad.movimiento;

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

import pe.com.galaxy.systems.apolo.core.entidad.GenericEntity;
import pe.com.galaxy.systems.apolo.core.entidad.entidad.general.Persona;
import pe.com.galaxy.systems.apolo.core.entidad.entidad.general.Situacion;
import pe.com.galaxy.systems.apolo.core.entidad.entidad.general.TipoDocumentoCompra;
import pe.com.galaxy.systems.apolo.core.entidad.entidad.inventario.Almacen;
import pe.com.galaxy.systems.apolo.core.entidad.entidad.stock.Articulo;
import pe.com.galaxy.systems.apolo.core.entidad.entidad.stock.Stock; 
import pe.com.galaxy.systems.apolo.core.entidad.entidad.seguridad.Usuario;
import pe.com.galaxy.systems.apolo.core.entidad.vo.movimiento.MovimientoAlmacenIngresoTransferenciaVO;
import pe.com.galaxy.systems.apolo.core.entidad.vo.movimiento.MovimientoAlmacenKardexVO;
import pe.com.galaxy.systems.apolo.core.entidad.vo.movimiento.MovimientoAlmacenRptICIVO;
import pe.com.galaxy.systems.apolo.core.entidad.vo.movimiento.MovimientoAlmacenVO;
import pe.com.galaxy.systems.apolo.core.entidad.vo.venta.VentaAnuladasVO;
import pe.com.galaxy.systems.apolo.core.entidad.vo.venta.VentaVO;


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
							resultClasses= MovimientoAlmacenVO.class,
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
							resultClasses= MovimientoAlmacenVO.class,
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
							resultClasses= MovimientoAlmacenIngresoTransferenciaVO.class,
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
							resultClasses= MovimientoAlmacenKardexVO.class,
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
							resultClasses= MovimientoAlmacenKardexVO.class,
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
							resultClasses= MovimientoAlmacenRptICIVO.class,
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
							resultClasses= MovimientoAlmacenVO.class,
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
public class MovimientoAlmacen extends GenericEntity implements Serializable {
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
	
	@ManyToOne
	@JoinColumn(name="ID_ARTICULO")
	private Articulo articulo;
	
	@ManyToOne
	@JoinColumn(name="ID_STOCK")
	private Stock stock;

	@ManyToOne
	@JoinColumn(name="ID_TIPO_MOVIMIENTO")
	private TipoMovimiento tipoMovimiento;
	
	@ManyToOne
	@JoinColumn(name="ID_ALMACEN_ORIGEN")
	private Almacen almacenOrigen;
	
	@ManyToOne
	@JoinColumn(name="ID_ALMACEN_DESTINO")
	private Almacen almacenDestino;
	
	@ManyToOne
	@JoinColumn(name="ID_TIPO_FINANCIADOR")
	private TipoFinanciamiento tipoFinanciamiento;
	
	@ManyToOne
	@JoinColumn(name="ID_TIPO_SELECCION")
	private TipoProcesoSeleccion tipoProcesoSeleccion;
 
	private Persona persona;
	
	@ManyToOne
	@JoinColumn(name="ID_TIPO_DOCUM_COMPRA")
	private TipoDocumentoCompra tipoDocumentoCompra;
	
	@Column(name="MES")
	private String mes;
	
	@Column(name="ANIO")
	private String anio;
	
	@Column(name="ID_ORGANIZACION_MOVIMIENTO_ALMACEN")
	private int idOrganizacionMovimientoAlmacen;
	
	@Column(name="ID_INSTITUCION_MOVIMIENTO_ALMACEN")
	private int idInstitucionMovimientoAlmacen;
	
	@Column(name="ID_SEDE_MOVIMIENTO_ALMACEN")
	private int idSedeMovimientoAlmacen;
	
	@Column(name="NRO_VERSION_MOVIMIENTO_ALMACEN")
	private int nroVersionMovimientoAlmacen;
	
	@Column(name="NRO_PERIODO_MOVIMIENTO_ALMACEN")
	private int nroPeriodoMovimientoAlmacen;
	
	@Column(name="FECHA_ORDEN")
	private Timestamp fechaOrden;
	
	
	private String id_alm_origen;
	

	private String id_alm_vir_ori;
	

	private String id_alm_destino;
	
	
	private String id_alm_vir_dest;
	
	
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
	
	private List<VentaAnuladasVO> ventaAnuladas;
	
	private List<VentaVO> atenciones;
	
	private List<MovimientoAlmacenVO> abastecimientos;
	
	
	public MovimientoAlmacen() {
		this.setStock(new Stock());
		this.setAlmacenDestino(new Almacen());
		this.setAlmacenOrigen(new Almacen());
		this.setArticulo(new Articulo());
		this.setTipoMovimiento(new TipoMovimiento());
		this.setStockItems(new ArrayList<Stock>());
		this.setMovimientoAlmacenItems(new ArrayList<MovimientoAlmacen>());
		this.setSituacion(new Situacion());
		this.setAud_usuario(new Usuario());
		this.setTipoFinanciamiento(new TipoFinanciamiento());
		this.setTipoProcesoSeleccion(new TipoProcesoSeleccion());
		this.setTipoDocumentoCompra(new TipoDocumentoCompra());
		this.setPersona(new Persona());
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


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public Articulo getArticulo() {
		return articulo;
	}


	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}


	public TipoMovimiento getTipoMovimiento() {
		return tipoMovimiento;
	}


	public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}


	public Almacen getAlmacenOrigen() {
		return almacenOrigen;
	}


	public void setAlmacenOrigen(Almacen almacenOrigen) {
		this.almacenOrigen = almacenOrigen;
	}


	public Almacen getAlmacenDestino() {
		return almacenDestino;
	}


	public void setAlmacenDestino(Almacen almacenDestino) {
		this.almacenDestino = almacenDestino;
	}


	public String getNroGuia() {
		return nroGuia;
	}


	public void setNroGuia(String nroGuia) {
		this.nroGuia = nroGuia;
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


	public String getFechaMovimiento() {
		return fechaMovimiento;
	}


	public void setFechaMovimiento(String fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
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

	public void setMovimientoAlmacenItems(
			List<MovimientoAlmacen> movimientoAlmacenItems) {
		this.movimientoAlmacenItems = movimientoAlmacenItems;
	}
	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public String getCadenaCantdArt() {
		return cadenaCantdArt;
	}
	public void setCadenaCantdArt(String cadenaCantdArt) {
		this.cadenaCantdArt = cadenaCantdArt;
	}
	public String getCadenaIdStock() {
		return cadenaIdStock;
	}
	public void setCadenaIdStock(String cadenaIdStock) {
		this.cadenaIdStock = cadenaIdStock;
	}
	public int getTipoIngresoDocumento() {
		return tipoIngresoDocumento;
	}
	public void setTipoIngresoDocumento(int tipoIngresoDocumento) {
		this.tipoIngresoDocumento = tipoIngresoDocumento;
	}
	public TipoFinanciamiento getTipoFinanciamiento() {
		return tipoFinanciamiento;
	}
	public void setTipoFinanciamiento(TipoFinanciamiento tipoFinanciamiento) {
		this.tipoFinanciamiento = tipoFinanciamiento;
	}
	public TipoProcesoSeleccion getTipoProcesoSeleccion() {
		return tipoProcesoSeleccion;
	}
	public void setTipoProcesoSeleccion(TipoProcesoSeleccion tipoProcesoSeleccion) {
		this.tipoProcesoSeleccion = tipoProcesoSeleccion;
	}
	public TipoDocumentoCompra getTipoDocumentoCompra() {
		return tipoDocumentoCompra;
	}
	public void setTipoDocumentoCompra(TipoDocumentoCompra tipoDocumentoCompra) {
		this.tipoDocumentoCompra = tipoDocumentoCompra;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getGlosa() {
		return glosa;
	}

	public void setGlosa(String glosa) {
		this.glosa = glosa;
	}

	public void ejecutarCalculosTotal(){
		Double tmpImporte=0.0;
		for (Stock StockItem : stockItems) {
			tmpImporte+=StockItem.getPrecioVenta();
		}
		this.setTotal(tmpImporte);
	}	
	
	public void ejecutarCalculosTotalCompra(){
		Double tmpImporte=0.0;
		System.out.println("stockItems " +stockItems.size());
		System.out.println("movimientoAlmacenItems " +movimientoAlmacenItems.size());
		for (MovimientoAlmacen StockItem : movimientoAlmacenItems) {
			tmpImporte+=StockItem.getSubtotal();
		}
		this.setTotal(tmpImporte);
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

	public int getIdOrganizacionMovimientoAlmacen() {
		return idOrganizacionMovimientoAlmacen;
	}

	public void setIdOrganizacionMovimientoAlmacen(int idOrganizacionMovimientoAlmacen) {
		this.idOrganizacionMovimientoAlmacen = idOrganizacionMovimientoAlmacen;
	}

	public int getIdInstitucionMovimientoAlmacen() {
		return idInstitucionMovimientoAlmacen;
	}

	public void setIdInstitucionMovimientoAlmacen(int idInstitucionMovimientoAlmacen) {
		this.idInstitucionMovimientoAlmacen = idInstitucionMovimientoAlmacen;
	}

	public int getIdSedeMovimientoAlmacen() {
		return idSedeMovimientoAlmacen;
	}

	public void setIdSedeMovimientoAlmacen(int idSedeMovimientoAlmacen) {
		this.idSedeMovimientoAlmacen = idSedeMovimientoAlmacen;
	}

	public int getNroVersionMovimientoAlmacen() {
		return nroVersionMovimientoAlmacen;
	}

	public void setNroVersionMovimientoAlmacen(int nroVersionMovimientoAlmacen) {
		this.nroVersionMovimientoAlmacen = nroVersionMovimientoAlmacen;
	}

	public int getNroPeriodoMovimientoAlmacen() {
		return nroPeriodoMovimientoAlmacen;
	}

	public void setNroPeriodoMovimientoAlmacen(int nroPeriodoMovimientoAlmacen) {
		this.nroPeriodoMovimientoAlmacen = nroPeriodoMovimientoAlmacen;
	}

	public void ejecutarCalculos(){
		System.out.println("this.getPrecio() "  + this.getPrecio());
		this.setTotal(this.getCantidad()* this.getPrecio());
		
	}
	
	public String getCadenaNroPeriodoStock() {
		return cadenaNroPeriodoStock;
	}

	public void setCadenaNroPeriodoStock(String cadenaNroPeriodoStock) {
		this.cadenaNroPeriodoStock = cadenaNroPeriodoStock;
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

	public List<VentaAnuladasVO> getVentaAnuladas() {
		if (ventaAnuladas == null) {
			ventaAnuladas = new ArrayList<VentaAnuladasVO>();
		}
		return ventaAnuladas;
	}

	public void setVentaAnuladas(List<VentaAnuladasVO> ventaAnuladas) {
		this.ventaAnuladas = ventaAnuladas;
	}

	public List<VentaVO> getAtenciones() {
		if (atenciones == null) {
			atenciones = new ArrayList<VentaVO>();
		}
		return atenciones;
	}

	public void setAtenciones(List<VentaVO> atenciones) {
		this.atenciones = atenciones;
	}

	public List<MovimientoAlmacenVO> getAbastecimientos() {
		if (abastecimientos == null) {
			abastecimientos = new ArrayList<MovimientoAlmacenVO>();
		}
		return abastecimientos;
	}

	public void setAbastecimientos(List<MovimientoAlmacenVO> abastecimientos) {
		this.abastecimientos = abastecimientos;
	}

	public Timestamp getFechaOrden() {
		return fechaOrden;
	}

	public void setFechaOrden(Timestamp fechaOrden) {
		this.fechaOrden = fechaOrden;
	}

	public void ejecutarImporteCompra(){
		System.out.println("this.getPrecio() "  + this.getPrecio());
		System.out.println("this.getPrecio() "  + this.getCantidad());
		this.setSubtotal(this.getCantidad()* this.getPrecio());
		
	}

	public String getId_alm_origen() {
		return id_alm_origen;
	}

	public void setId_alm_origen(String id_alm_origen) {
		this.id_alm_origen = id_alm_origen;
	}

	public String getId_alm_vir_ori() {
		return id_alm_vir_ori;
	}

	public void setId_alm_vir_ori(String id_alm_vir_ori) {
		this.id_alm_vir_ori = id_alm_vir_ori;
	}

	public String getId_alm_destino() {
		return id_alm_destino;
	}

	public void setId_alm_destino(String id_alm_destino) {
		this.id_alm_destino = id_alm_destino;
	}

	public String getId_alm_vir_dest() {
		return id_alm_vir_dest;
	}

	public void setId_alm_vir_dest(String id_alm_vir_dest) {
		this.id_alm_vir_dest = id_alm_vir_dest;
	}

	public String getId_concepto() {
		return id_concepto;
	}

	public void setId_concepto(String id_concepto) {
		this.id_concepto = id_concepto;
	}

	
	
}