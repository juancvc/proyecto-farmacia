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
					procedureName="[dbo].[usp_Articulo_insertar]",
					parameters={
								@StoredProcedureParameter(mode=ParameterMode.OUT, name="idArticulo", 			  type=String.class ),
							
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="nombreArticulo", 		  type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="idClase", 				  type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="idGenerico",		 	  type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="idTipoPresentacionCat01", type=Integer.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="concentracion", 		  type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="idTipoArticuloCat01", 	  type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="volumen", 				  type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="idLaboratorio", 		  type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="posologia", 		      type=String.class),								
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="stockAlerta", 			  type=Integer.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="stockOptimo", 			  type=Integer.class),			
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="codigoSismed", 			  type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="codigoSiga", 			  type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioRegistro", 		  type=String.class),								
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipRegistro", 			  type=String.class)
						}					
			),
			@NamedStoredProcedureQuery(
					name="articulo.update", 
					procedureName="[dbo].[usp_Articulo_actualizar]",
					parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idArticulo", 				type=String.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="nombreArticulo", 			type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idClase", 					type=String.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idGenerico", 				type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idTipoPresentacionCat01",   type=Integer.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="concentracion", 			type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idTipoArticuloCat01", 		type=String.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="volumen", 				    type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idLaboratorio", 		    type=String.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="posologia", 				type=String.class),								
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="stockAlerta", 				type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="stockOptimo", 				type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="codigoSismed", 				type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="codigoSiga", 				type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioModificacion", 		type=String.class),								
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipModificacion", 		    type=String.class)
					}					
									
			),
			@NamedStoredProcedureQuery(
					name="articulo.delete", 
					procedureName="[dbo].[usp_Articulo_eliminar]",
					parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idArticulo",		  type=String.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioModificacion", type=String.class),								
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipModificacion",	  type=String.class)
						}					
			),
	
				
			
			
			    @NamedStoredProcedureQuery(
						name="articulo.findByObjectVO", 
						procedureName="[dbo].[usp_Articulo_buscarxID]",
						resultClasses= Articulo.class,
						parameters={
								
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idArticulo", type=String.class)
							}					
					),
				@NamedStoredProcedureQuery(
						name="articulo.findByLikeObjectVO", 
						procedureName="[dbo].[usp_Articulo_buscarxCriterios]",
						resultClasses= Articulo.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="nombreArticulo",	 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="idTipoArticuloCat01", type=String.class)
									
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
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="TIPO", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_RECETA", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="CodigoOrganizacionRecetaMedica", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="CodigoInstitucionRecetaMedica", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="CodigoSedeRecetaMedica", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="NumeroPeriodoRecetaMedica", type=int.class)
							}	
				),
				@NamedStoredProcedureQuery(
						name="articulo.actualizarCatalogo", 
						procedureName="[dbo].[SP_ARTICULO_ACTUALIZAR_CATALOGO]",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="idArticulo", type=Integer.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="nombreArticulo", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_LARGO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idClase", type=Integer.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idGenerico", type=String.class),
									
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_PRESENTACION", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="concentracion", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_TIPO_ARTICULO", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="volumen", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idLaboratorio", type=Integer.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="posologia", type=String.class),								
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="stockAlerta", type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="stockOptimo", type=Integer.class),
									
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="PETITORIO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ESTRATEGICO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ESTADO_SISMED", type=String.class),
									
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SITUACION", type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioRegistro", type=Integer.class),								
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipRegistro", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_MAC", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_OPERACION", type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="codigoSismed", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="codigoSiga", type=String.class)
							}					
				),
				@NamedStoredProcedureQuery(
						name="articulo.tem_insertar", 
						procedureName="[dbo].[SP_TEM_PRODUCTO_INSERT]",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="codigoSismed", type=String.class ),
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
//	private  String concentracion;
	private  String NOMBRE_LARGO_PRESENTACION;
	private  String nombreArticulo_TIPO_ARTICULO;
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