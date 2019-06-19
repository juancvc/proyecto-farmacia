package pe.com.galaxy.systems.apolo.core.entidad.entidad.receta;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
 
import pe.com.galaxy.systems.apolo.core.entidad.GenericEntity;
import pe.com.galaxy.systems.apolo.core.entidad.entidad.general.Situacion;
import pe.com.galaxy.systems.apolo.core.entidad.entidad.stock.Articulo;
import pe.com.galaxy.systems.apolo.core.entidad.entidad.seguridad.Usuario;
import pe.com.galaxy.systems.apolo.core.entidad.vo.receta.RecetaDetalleVO;
import pe.com.galaxy.systems.apolo.core.entidad.vo.receta.ReservaRecetaDetalleVO; 

@SuppressWarnings("serial")
@NamedStoredProcedureQueries(
		{
				
				@NamedStoredProcedureQuery(
						name="recetaDetalle.buscarxid", 
						procedureName="SP_RECETA_DETALLE_BUSCAR_X_ID",
						resultClasses= RecetaDetalle.class,
						parameters={
								//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_RECETA_DETALLE", type=Long.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class )
							}					
					),
				
				@NamedStoredProcedureQuery(
						name="recetaDetalle.buscarTodos", 
						procedureName="SP_RECETA_DETALLE_BUSCAR_TODOS",
						resultClasses= RecetaDetalle.class
					/*	parameters={
									@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class )
							}	*/				
					),
					
				@NamedStoredProcedureQuery(
						name="recetaDetalle.buscarxIdReceta", 
						procedureName="SP_RECETA_DETALLE_BUSCAR_X_ID_RECETA",
						resultClasses= RecetaDetalleVO.class,
						parameters={
								//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_RECETA", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO_RECETA", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION_RECETA", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION_RECETA", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE_RECETA", type=int.class ),
							}	
				),
				
				@NamedStoredProcedureQuery(
						name="recetaDetalle.insert", 
						procedureName="SP_RECETA_DETALLE_INSERTAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="ID_RECETA_DETALLE", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_CORTO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_LARGO", type=String.class),
									
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SITUACION", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_USUARIO", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_OPERACION", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_MAC", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_OBSERVACION", type=String.class)
							}					
				),
				
				@NamedStoredProcedureQuery(
						name="recetaDetalle.update", 
						procedureName="SP_RECETA_DETALLE_ACTUALIZAR",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_RECETA_DETALLE", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NOMBRE_CORTO", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NOMBRE_LARGO", type=String.class),
								
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SITUACION", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_USUARIO", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_OPERACION", type=int.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_MAC", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_OBSERVACION", type=String.class)
						}					
										
				),
				@NamedStoredProcedureQuery(
						name="recetaDetalle.delete", 
						procedureName="SP_RECETA_DETALLE_ELIMINAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_RECETA_DETALLE", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO_RECETA_DETALLE", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION_RECETA_DETALLE", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION_RECETA_DETALLE", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE_RECETA_DETALLE", type=int.class ),
									
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_USUARIO", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_IP", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_SESSION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_MAC", type=String.class)
							}					
				),@NamedStoredProcedureQuery(
						name="recetaDetalle.listarArticulosPorReceta", 
						procedureName="[SP_RECETA_DETALLE_LISTAR_ARTICULOS_X_ID_RECETA]",
						resultClasses= ReservaRecetaDetalleVO.class,
						parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="TIPO", type=int.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_RECETA", type=int.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="CodigoOrganizacionRecetaMedica", type=int.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="CodigoInstitucionRecetaMedica", type=int.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="CodigoSedeRecetaMedica", type=int.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="NumeroPeriodoRecetaMedica", type=int.class)
							}	
				)
		
		}
	)
@Entity
public class RecetaDetalle 
	extends GenericEntity{

	@EmbeddedId
	private RecetaDetallePK id;

//	@JoinColumn(name="ID_RECETA")
	private Receta receta;
	
	@JoinColumn(name="ID_ARTICULO")
	private Articulo articulo;
	
	@Column(name="CANTIDAD")
	private int cantidad;
	
	@Column(name="AUD_FECHA_OPERACION")
	private  Timestamp 	aud_fechaOperacion;
	
	@Column(name="DOSIS")
	private  String dosis;
	
	public RecetaDetalle() {
		this.setSituacion(new Situacion());
		this.setAud_usuario(new Usuario());
		this.setArticulo(new Articulo());
		this.setReceta(new Receta());
	}

 
	public RecetaDetallePK getId() {
		return id;
	}


	public void setId(RecetaDetallePK id) {
		this.id = id;
	}


	public Receta getReceta() {
		return receta;
	}


	public void setReceta(Receta receta) {
		this.receta = receta;
	}


	public Articulo getArticulo() {
		return articulo;
	}


	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public Timestamp getAud_fechaOperacion() {
		return aud_fechaOperacion;
	}


	public void setAud_fechaOperacion(Timestamp aud_fechaOperacion) {
		this.aud_fechaOperacion = aud_fechaOperacion;
	}


	public String getDosis() {
		return dosis;
	}


	public void setDosis(String dosis) {
		this.dosis = dosis;
	}


	@Override
	public String toString() {
		return "RecetaDetalle [id=" + id + ", receta=" + receta + ", articulo=" + articulo + ", cantidad=" + cantidad
				+ ", aud_fechaOperacion=" + aud_fechaOperacion + ", dosis=" + dosis + "]";
	}
	
}