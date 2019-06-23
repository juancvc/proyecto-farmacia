package proyect.core.entity.stock;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id; 
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter; 

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
						resultClasses= Articulo.class,
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
						resultClasses= Articulo.class,
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
						resultClasses= Articulo.class,
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
						resultClasses= Articulo.class,
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
						resultClasses = Articulo.class,
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
public class Articulo  { 
	@Id
	private String idArticulo;

	private boolean activo;

	private String codigoSiga;

	private String codigoSismed;

	private String concentracion;

	private Timestamp fechaModificacion;

	private Timestamp fechaRegistro;

	private String idClase;

	private String idGenerico;

	private String idLaboratorio;

	private String idTipoArticuloCat01;

	private String idTipoPresentacionCat01;

	private String ipModificacion;

	private String ipRegistro;

	private String nombreArticulo;

	private String posologia;

	private int stockAlerta;

	private int stockOptimo;

	private String usuarioModificacion;

	private String usuarioRegistro;

	private String volumen;
	
	/***
	private  int  anio;
	private  int  tipo;
	private  int  idReceta;
	private String cadenaCodigoSISMED;
	
	/** Variables para el reporte **/
/*	private  int PAGANTE;
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
	*/
	 
	
	public Articulo() { 
	}
	public String getIdArticulo() {
		return idArticulo;
	}
	public void setIdArticulo(String idArticulo) {
		this.idArticulo = idArticulo;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
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
	public Timestamp getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getIdClase() {
		return idClase;
	}
	public void setIdClase(String idClase) {
		this.idClase = idClase;
	}
	public String getIdGenerico() {
		return idGenerico;
	}
	public void setIdGenerico(String idGenerico) {
		this.idGenerico = idGenerico;
	}
	public String getIdLaboratorio() {
		return idLaboratorio;
	}
	public void setIdLaboratorio(String idLaboratorio) {
		this.idLaboratorio = idLaboratorio;
	}
	public String getIdTipoArticuloCat01() {
		return idTipoArticuloCat01;
	}
	public void setIdTipoArticuloCat01(String idTipoArticuloCat01) {
		this.idTipoArticuloCat01 = idTipoArticuloCat01;
	}
	public String getIdTipoPresentacionCat01() {
		return idTipoPresentacionCat01;
	}
	public void setIdTipoPresentacionCat01(String idTipoPresentacionCat01) {
		this.idTipoPresentacionCat01 = idTipoPresentacionCat01;
	}
	public String getIpModificacion() {
		return ipModificacion;
	}
	public void setIpModificacion(String ipModificacion) {
		this.ipModificacion = ipModificacion;
	}
	public String getIpRegistro() {
		return ipRegistro;
	}
	public void setIpRegistro(String ipRegistro) {
		this.ipRegistro = ipRegistro;
	}
	public String getNombreArticulo() {
		return nombreArticulo;
	}
	public void setNombreArticulo(String nombreArticulo) {
		this.nombreArticulo = nombreArticulo;
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
	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}
	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}
	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}
	public String getVolumen() {
		return volumen;
	}
	public void setVolumen(String volumen) {
		this.volumen = volumen;
	}


	
}