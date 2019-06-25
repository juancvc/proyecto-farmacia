package proyect.core.entity.receta;

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
  

@SuppressWarnings("serial")
@NamedStoredProcedureQueries(
		{
				
				@NamedStoredProcedureQuery(
						name="recetaDetalle.buscarxid", 
						procedureName="SP_RECETA_DETALLE_BUSCAR_X_ID",
						resultClasses= RecetaDetalle.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idRecetaDetalle", type=String.class)
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
						resultClasses= RecetaDetalle.class,
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="idReceta", type=String.class )
							}	
				),
				
				@NamedStoredProcedureQuery(
						name="recetaDetalle.insert", 
						procedureName="SP_RECETA_DETALLE_INSERTAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="idRecetaDetalle", 		type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="nombreRecetaDetalle", 	type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="descripcion", 			type=String.class),								
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idSituacion", 			type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioRegistro", 		type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipRegistro", 			type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="observacion", 			type=String.class)
							}					
				),
				
				@NamedStoredProcedureQuery(
						name="recetaDetalle.update", 
						procedureName="SP_RECETA_DETALLE_ACTUALIZAR",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="idRecetaDetalle", 		type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="nombreRecetaDetalle", 	type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="descripcion", 			type=String.class),					
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="idSituacion", 			type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioModificacion", 	type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipModificacion", 		type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="observacion", 			type=String.class)
						}					
										
				),
				@NamedStoredProcedureQuery(
						name="recetaDetalle.delete", 
						procedureName="SP_RECETA_DETALLE_ELIMINAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="idRecetaDetalle", 	 type=String.class ),									
									@StoredProcedureParameter(mode=ParameterMode.IN, name="usuarioModificacion", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ipModificacion", 	 type=String.class)
							}					
				),@NamedStoredProcedureQuery(
						name="recetaDetalle.listarArticulosPorReceta", 
						procedureName="[SP_RECETA_DETALLE_LISTAR_ARTICULOS_X_ID_RECETA]",
						resultClasses= RecetaDetalle.class,
						parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="tipo", 				type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idReceta", 			type=String.class)
							}	
				)
		
		}
	)
@Entity
public class RecetaDetalle  {

	@EmbeddedId
	private RecetaDetallePK id;

//	@JoinColumn(name="idReceta")
	private Receta receta;
	
	@JoinColumn(name="ID_ARTICULO")
	private String idArticulo;
	
	@Column(name="CANTIDAD")
	private int cantidad;
	
	@Column(name="AUD_FECHA_OPERACION")
	private  Timestamp 	aud_fechaOperacion;
	
	@Column(name="DOSIS")
	private  String dosis;
	
	public RecetaDetalle() { 
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

 
	
}