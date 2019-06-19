package pe.com.galaxy.systems.apolo.core.entidad.entidad.stock;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import pe.com.galaxy.systems.apolo.core.entidad.GenericEntity;
import pe.com.galaxy.systems.apolo.core.entidad.entidad.general.Situacion;
import pe.com.galaxy.systems.apolo.core.entidad.entidad.seguridad.Usuario;
import pe.com.galaxy.systems.apolo.core.entidad.vo.general.ArticuloVO;
import pe.com.galaxy.systems.apolo.core.entidad.vo.movimiento.MovimientoBalanzaPorPeridoRptVO;
import pe.com.galaxy.systems.apolo.core.entidad.vo.venta.PreviaVentaVO;
@NamedStoredProcedureQueries(
		{
			@NamedStoredProcedureQuery(
					name="articulo.insert", 
					procedureName="SP_ARTICULO_INSERTAR",
					parameters={
								@StoredProcedureParameter(mode=ParameterMode.OUT, name="ID_ARTICULO", type=Integer.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_CORTO", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_LARGO", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_CLASE", type=Integer.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="COD_GENERICO", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_PRESENTACION", type=Integer.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="CONCENTRACION", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_TIPO_ARTICULO", type=Integer.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="VOLUMEN", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_LABORATORIO", type=Integer.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="POSOLOGIA", type=String.class),								
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="STOCK_ALERTA", type=Integer.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="STOCK_OPTIMO", type=Integer.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SITUACION", type=Integer.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_USUARIO", type=Integer.class),								
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_MAC", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_OPERACION", type=Integer.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="CODIGO_SISMED", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="CODIGO_SIGA", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_CATEGORIA", type=Integer.class)
						}					
			),
			@NamedStoredProcedureQuery(
					name="articulo.update", 
					procedureName="SP_ARTICULO_ACTUALIZAR",
					parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ARTICULO", type=Integer.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_CORTO", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_LARGO", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_CLASE", type=Integer.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="COD_GENERICO", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_PRESENTACION", type=Integer.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="CONCENTRACION", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_TIPO_ARTICULO", type=Integer.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="VOLUMEN", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_LABORATORIO", type=Integer.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="POSOLOGIA", type=String.class),								
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="STOCK_ALERTA", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="STOCK_OPTIMO", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SITUACION", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_USUARIO", type=Integer.class),								
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_MAC", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_OPERACION", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="CODIGO_SISMED", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="CODIGO_SIGA", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_CATEGORIA", type=Integer.class)
					}					
									
			),
			@NamedStoredProcedureQuery(
					name="articulo.delete", 
					procedureName="SP_ARTICULO_ELIMINAR",
					parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ARTICULO", type=Integer.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SITUACION", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_USUARIO", type=Integer.class),								
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_MAC", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_OPERACION", type=Integer.class)
						}					
			),
	
				
			
			
			    @NamedStoredProcedureQuery(
						name="articulo.findByObjectVO", 
						procedureName="SP_ARTICULO_BUSCAR_X_ID",
						resultClasses= ArticuloVO.class,
						parameters={
									//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ARTICULO", type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class )
							}					
					),
				@NamedStoredProcedureQuery(
						name="articulo.findByLikeObjectVO", 
						procedureName="SP_ARTICULO_BUSCAR_X_CRITERIOS",
						resultClasses= ArticuloVO.class,
						parameters={
								//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_CORTO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_TIPO_ARTICULO", type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_PRESENTACION", type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_CLASE", type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class )
							}	
				),
				
				@NamedStoredProcedureQuery(
						name="articulo.movimientoBalanzaPorPeriodo", 
						procedureName="[FARMACIA].[DBO].[SP_VENTA_REPORTE_BALANZA]",
						resultClasses= MovimientoBalanzaPorPeridoRptVO.class,
						parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ORGANIZACION", type=int.class),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ANIO", type=int.class )

							}	
				),
				@NamedStoredProcedureQuery(
						name="articulo.listarArticulosPorRecetaPorIdReceta", 
						procedureName="SP_LISTAR_ARTICULOS_X_RECETA_X_ID_RECETA",
						resultClasses= PreviaVentaVO.class,
						parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="TIPO", type=int.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_RECETA", type=int.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="CodigoOrganizacionRecetaMedica", type=int.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="CodigoInstitucionRecetaMedica", type=int.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="CodigoSedeRecetaMedica", type=int.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="NumeroPeriodoRecetaMedica", type=int.class)
							}	
				),
				@NamedStoredProcedureQuery(
						name="articulo.actualizarCatalogo", 
						procedureName="[dbo].[SP_ARTICULO_ACTUALIZAR_CATALOGO]",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="ID_ARTICULO", type=Integer.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_CORTO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_LARGO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_CLASE", type=Integer.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="COD_GENERICO", type=String.class),
									
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_PRESENTACION", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="CONCENTRACION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_TIPO_ARTICULO", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="VOLUMEN", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_LABORATORIO", type=Integer.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="POSOLOGIA", type=String.class),								
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="STOCK_ALERTA", type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="STOCK_OPTIMO", type=Integer.class),
									
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="PETITORIO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ESTRATEGICO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ESTADO_SISMED", type=String.class),
									
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SITUACION", type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_USUARIO", type=Integer.class),								
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_MAC", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_OPERACION", type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="CODIGO_SISMED", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="CODIGO_SIGA", type=String.class)
							}					
				),
				@NamedStoredProcedureQuery(
						name="articulo.tem_insertar", 
						procedureName="[dbo].[SP_TEM_PRODUCTO_INSERT]",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="CODIGO_SISMED", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="PRECIO_COMPRA", type=float.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="PRECIO_VENTA", type=float.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="PRECIO_ADQUISICION", type=float.class )
									
							}					
				),
				@NamedStoredProcedureQuery(
						name="articulo.listarArticulosAvencerse", 
						procedureName="[dbo].[SP_ARTICULO_A_VENCERSE]",
						resultClasses = ArticuloVO.class,
						parameters={
									
							}					
				),
				@NamedStoredProcedureQuery(
						name="articulo.listaArticulosDia", 
						procedureName="[dbo].[SP_ARTICULO_DIA]",
						resultClasses = Articulo.class,
						parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN, name="TIPO", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ALMACEN", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="FECHA_DESDE", type=Timestamp.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="FECHA_HASTA", type=Timestamp.class),
							}					
				)
		}
				
	)
@Entity
public class Articulo 
	extends GenericEntity{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ID_ARTICULO")
	private Long idArticulo;

	@Column(name="NOMBRE_CORTO")
	private String nombreCorto;

	@Column(name="NOMBRE_LARGO")
	private String nombreLargo;
	
	@Column(name="COD_GENERICO")
	private String codGenerico;

	@Column(name="CONCENTRACION")
	private String concentracion;
	
	@Column(name="VOLUMEN")
	private String volumen;
	
	@Column(name="POSOLOGIA")
	private String posologia;
	
	@Column(name="STOCK_ALERTA")
	private double stockAlerta;
	
	@Column(name="STOCK_OPTIMO")
	private double stockOptimo;
	
	@Column (name="CODIGO_SISMED")
	private String codigoSismed;
	
	@Column (name="CODIGO_SIGA")
	private String codigoSiga;
	
	@Column(name="ID_ORGANIZACION_ARTICULO")
	private int idOrganizacionArticulo;
	
	@Column(name="ID_INSTITUCION_ARTICULO")
	private int idInstitucionArticulo;
	
	@Column(name="ID_SEDE_ARTICULO")
	private int idSedeArticulo;
	
	@Column(name="NRO_VERSION_ARTICULO")
	private int nroVersionArticulo;
	
	@Column(name="NRO_PERIODO_ARTICULO")
	private int nroPeriodoArticulo;
	
	@Column (name="PETITORIO")
	private String petitorio;
	
	@Column (name="ESTRATEGICO")
	private String estrategico;
	
	@Column (name="ESTADO_SISMED")
	private String estadoSismed;
	
	@Column (name="ID_CATEGORIA")
	private int idCategoria;
	
	private  int  anio;
	private  int  tipo;
	private  int  idReceta;
	private String cadenaCodigoSISMED;
	
	/** Variables para el reporte **/
	private  int PAGANTE;
	private  int TRABAJADOR;
	private  int SIS;
	private  int SOAT;
	private  int EXONERACION;
	private  int PRIVADO;
	private  int  TOTAL_VENDIDO;
	private  String INPORTE_TOTAL;
//	private  String CONCENTRACION;
	private  String NOMBRE_LARGO_PRESENTACION;
	private  String NOMBRE_CORTO_TIPO_ARTICULO;
	private  String PRECIO_VENTA;
	

	private  int Stock;
	
	private	int ENERO;
	private	int FEBRERO;
	private	int MARZO;
	private	int ABRIL;
	private	int MAYO;
	private	int JUNIO;
	private	int JULIO;
	private	int AGOSTO;
	private	int SETIEMBRE;
	private	int OCTUBRE;
	private	int NOVIEMBRE;
	private	int DICIEMBRE;
	
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "ID_TIPO_ARTICULO", referencedColumnName = "ID_TIPO_ARTICULO", insertable = false, updatable = false)
	})
	private TipoArticulo tipoArticulo;
	
	@Column(name="ID_TIPO_ARTICULO")
	private Long idTipoArticulo;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "ID_CLASE", referencedColumnName = "ID_CLASE", insertable = false, updatable = false)
	})
	private Clase clase;

	@Column(name="ID_CLASE")
	private Long idClase;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "ID_PRESENTACION", referencedColumnName = "ID_PRESENTACION", insertable = false, updatable = false)
	})
	private Presentacion presentacion;
	
	@Column(name="ID_PRESENTACION")
	private Long idPresentacion;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "ID_LABORATORIO", referencedColumnName = "ID_LABORATORIO", insertable = false, updatable = false)
	})
	private Laboratorio laboratorio;
	
	@Column(name="ID_LABORATORIO")
	private Long idLaboratorio;

	
	public Articulo() {
		this.setClase(new Clase());
	    this.setTipoArticulo(new TipoArticulo());
		this.setLaboratorio(new Laboratorio());
		this.setPresentacion(new Presentacion());
		this.setSituacion(new Situacion());
		this.setAud_usuario(new Usuario());
	}

	public String getCodigoSismed() {
		return codigoSismed;
	}

	public void setCodigoSismed(String codigoSismed) {
		this.codigoSismed = codigoSismed;
	}

	public String getCodigoSiga() {
		return codigoSiga;
	}

	public void setCodigoSiga(String codigoSiga) {
		this.codigoSiga = codigoSiga;
	}

	public Long getIdArticulo() {
		if (idArticulo == null) {
			idArticulo = 0L;
		}
		return idArticulo;
	}

	public void setIdArticulo(Long idArticulo) {
		this.idArticulo = idArticulo;
	}

	public String getNombreCorto() {
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	public String getNombreLargo() {
		return nombreLargo;
	}

	public void setNombreLargo(String nombreLargo) {
		this.nombreLargo = nombreLargo;
	}

	public String getCodGenerico() {
		return codGenerico;
	}

	public void setCodGenerico(String codGenerico) {
		this.codGenerico = codGenerico;
	}


	public String getConcentracion() {
		return concentracion;
	}

	public void setConcentracion(String concentracion) {
		this.concentracion = concentracion;
	}


	public String getVolumen() {
		return volumen;
	}

	public void setVolumen(String volumen) {
		this.volumen = volumen;
	}

	public String getPosologia() {
		return posologia;
	}

	public void setPosologia(String posologia) {
		this.posologia = posologia;
	}

	public double getStockAlerta() {
		return stockAlerta;
	}

	public void setStockAlerta(double stockAlerta) {
		this.stockAlerta = stockAlerta;
	}

	public double getStockOptimo() {
		return stockOptimo;
	}

	public void setStockOptimo(double stockOptimo) {
		this.stockOptimo = stockOptimo;
	}

	public TipoArticulo getTipoArticulo() {
		return this.tipoArticulo;
	}

	public void setTipoArticulo(TipoArticulo tipoArticulo) {
		this.tipoArticulo = tipoArticulo;
	}

	public Clase getClase() {
		return this.clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}

	public Presentacion getPresentacion() {
		return this.presentacion;
	}

	public void setPresentacion(Presentacion presentacion) {
		this.presentacion = presentacion;
	}

	public Laboratorio getLaboratorio() {
		return this.laboratorio;
	}

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}

	public Long getIdTipoArticulo() {
		return idTipoArticulo;
	}

	public void setIdTipoArticulo(Long idTipoArticulo) {
		this.idTipoArticulo = idTipoArticulo;
	}

	public Long getIdClase() {
		return idClase;
	}

	public void setIdClase(Long idClase) {
		this.idClase = idClase;
	}

	public Long getIdPresentacion() {
		return idPresentacion;
	}

	public void setIdPresentacion(Long idPresentacion) {
		this.idPresentacion = idPresentacion;
	}

	public Long getIdLaboratorio() {
		return idLaboratorio;
	}

	public void setIdLaboratorio(Long idLaboratorio) {
		this.idLaboratorio = idLaboratorio;
	}

	public int getIdOrganizacionArticulo() {
		return idOrganizacionArticulo;
	}

	public void setIdOrganizacionArticulo(int idOrganizacionArticulo) {
		this.idOrganizacionArticulo = idOrganizacionArticulo;
	}

	public int getIdInstitucionArticulo() {
		return idInstitucionArticulo;
	}

	public void setIdInstitucionArticulo(int idInstitucionArticulo) {
		this.idInstitucionArticulo = idInstitucionArticulo;
	}

	public int getIdSedeArticulo() {
		return idSedeArticulo;
	}

	public void setIdSedeArticulo(int idSedeArticulo) {
		this.idSedeArticulo = idSedeArticulo;
	}

	public int getNroVersionArticulo() {
		return nroVersionArticulo;
	}

	public void setNroVersionArticulo(int nroVersionArticulo) {
		this.nroVersionArticulo = nroVersionArticulo;
	}

	public int getNroPeriodoArticulo() {
		return nroPeriodoArticulo;
	}

	public void setNroPeriodoArticulo(int nroPeriodoArticulo) {
		this.nroPeriodoArticulo = nroPeriodoArticulo;
	}

	@Override
	public String toString() {
		return "Articulo [idArticulo=" + idArticulo + ", nombreCorto="
				+ nombreCorto + ", nombreLargo=" + nombreLargo
				+ ", codGenerico=" + codGenerico + ", concentracion="
				+ concentracion + ", volumen=" + volumen + ", posologia="
				+ posologia + ", stockAlerta=" + stockAlerta + ", stockOptimo="
				+ stockOptimo + ", tipoArticulo=" + tipoArticulo
				+ ", idTipoArticulo=" + idTipoArticulo + ", clase=" + clase
				+ ", idClase=" + idClase + ", presentacion=" + presentacion
				+ ", idPresentacion=" + idPresentacion + ", laboratorio="
				+ laboratorio + ", idLaboratorio=" + idLaboratorio + "]";
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getIdReceta() {
		return idReceta;
	}

	public void setIdReceta(int idReceta) {
		this.idReceta = idReceta;
	}

	public String getPetitorio() {
		return petitorio;
	}

	public void setPetitorio(String petitorio) {
		this.petitorio = petitorio;
	}

	public String getEstrategico() {
		return estrategico;
	}

	public void setEstrategico(String estrategico) {
		this.estrategico = estrategico;
	}

	public String getEstadoSismed() {
		return estadoSismed;
	}

	public void setEstadoSismed(String estadoSismed) {
		this.estadoSismed = estadoSismed;
	}

	public String getCadenaCodigoSISMED() {
		return cadenaCodigoSISMED;
	}

	public void setCadenaCodigoSISMED(String cadenaCodigoSISMED) {
		this.cadenaCodigoSISMED = cadenaCodigoSISMED;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public int getPAGANTE() {
		return PAGANTE;
	}

	public void setPAGANTE(int pAGANTE) {
		PAGANTE = pAGANTE;
	}

	public int getTRABAJADOR() {
		return TRABAJADOR;
	}

	public void setTRABAJADOR(int tRABAJADOR) {
		TRABAJADOR = tRABAJADOR;
	}

	public int getSIS() {
		return SIS;
	}

	public void setSIS(int sIS) {
		SIS = sIS;
	}

	public int getSOAT() {
		return SOAT;
	}

	public void setSOAT(int sOAT) {
		SOAT = sOAT;
	}

	public int getPRIVADO() {
		return PRIVADO;
	}

	public void setPRIVADO(int pRIVADO) {
		PRIVADO = pRIVADO;
	}

	public int getTOTAL_VENDIDO() {
		return TOTAL_VENDIDO;
	}

	public void setTOTAL_VENDIDO(int tOTAL_VENDIDO) {
		TOTAL_VENDIDO = tOTAL_VENDIDO;
	}

	public String getNOMBRE_LARGO_PRESENTACION() {
		return NOMBRE_LARGO_PRESENTACION;
	}

	public void setNOMBRE_LARGO_PRESENTACION(String nOMBRE_LARGO_PRESENTACION) {
		NOMBRE_LARGO_PRESENTACION = nOMBRE_LARGO_PRESENTACION;
	}

	public String getNOMBRE_CORTO_TIPO_ARTICULO() {
		return NOMBRE_CORTO_TIPO_ARTICULO;
	}

	public void setNOMBRE_CORTO_TIPO_ARTICULO(String nOMBRE_CORTO_TIPO_ARTICULO) {
		NOMBRE_CORTO_TIPO_ARTICULO = nOMBRE_CORTO_TIPO_ARTICULO;
	}

	public String getPRECIO_VENTA() {
		return PRECIO_VENTA;
	}

	public void setPRECIO_VENTA(String pRECIO_VENTA) {
		PRECIO_VENTA = pRECIO_VENTA;
	}

	public String getINPORTE_TOTAL() {
		return INPORTE_TOTAL;
	}

	public void setINPORTE_TOTAL(String iNPORTE_TOTAL) {
		INPORTE_TOTAL = iNPORTE_TOTAL;
	}

	public int getEXONERACION() {
		return EXONERACION;
	}

	public void setEXONERACION(int eXONERACION) {
		EXONERACION = eXONERACION;
	}

	public int getStock() {
		return Stock;
	}

	public void setStock(int stock) {
		Stock = stock;
	}

	public int getENERO() {
		return ENERO;
	}

	public void setENERO(int eNERO) {
		ENERO = eNERO;
	}

	public int getFEBRERO() {
		return FEBRERO;
	}

	public void setFEBRERO(int fEBRERO) {
		FEBRERO = fEBRERO;
	}

	public int getMARZO() {
		return MARZO;
	}

	public void setMARZO(int mARZO) {
		MARZO = mARZO;
	}

	public int getABRIL() {
		return ABRIL;
	}

	public void setABRIL(int aBRIL) {
		ABRIL = aBRIL;
	}

	public int getMAYO() {
		return MAYO;
	}

	public void setMAYO(int mAYO) {
		MAYO = mAYO;
	}

	public int getJUNIO() {
		return JUNIO;
	}

	public void setJUNIO(int jUNIO) {
		JUNIO = jUNIO;
	}

	public int getJULIO() {
		return JULIO;
	}

	public void setJULIO(int jULIO) {
		JULIO = jULIO;
	}

	public int getAGOSTO() {
		return AGOSTO;
	}

	public void setAGOSTO(int aGOSTO) {
		AGOSTO = aGOSTO;
	}

	public int getSETIEMBRE() {
		return SETIEMBRE;
	}

	public void setSETIEMBRE(int sETIEMBRE) {
		SETIEMBRE = sETIEMBRE;
	}

	public int getOCTUBRE() {
		return OCTUBRE;
	}

	public void setOCTUBRE(int oCTUBRE) {
		OCTUBRE = oCTUBRE;
	}

	public int getNOVIEMBRE() {
		return NOVIEMBRE;
	}

	public void setNOVIEMBRE(int nOVIEMBRE) {
		NOVIEMBRE = nOVIEMBRE;
	}

	public int getDICIEMBRE() {
		return DICIEMBRE;
	}

	public void setDICIEMBRE(int dICIEMBRE) {
		DICIEMBRE = dICIEMBRE;
	}


	
	
}