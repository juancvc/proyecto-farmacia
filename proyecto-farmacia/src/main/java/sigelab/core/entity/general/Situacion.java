package pe.com.galaxy.systems.apolo.core.entidad.entidad.general;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import pe.com.galaxy.systems.apolo.core.entidad.GenericEntity;
@NamedStoredProcedureQueries(
		{
				
				@NamedStoredProcedureQuery(
						name="situacion.findByObject", 
						procedureName="PKG_CLASE.SP_BUSCAR_X_ID",
						resultClasses= Situacion.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_ID_CLASE", type=Long.class)
							}					
					),
				
				@NamedStoredProcedureQuery(
						name="situacion.buscarTodos", 
						procedureName="PKG_CLASE.SP_BUSCAR_TODOS",
						resultClasses= Situacion.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_C_CURSOR", type=void.class )
							}					
					),
					
				@NamedStoredProcedureQuery(
						name="situacion.findByLikeObject", 
						procedureName="SP_SITUACIONES_BUSCAR_X_CRITERIOS",
						resultClasses= Situacion.class,
						parameters={
									//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_TABLA", type=int.class)
							}	
				),
				
				@NamedStoredProcedureQuery(
						name="situacion.insert", 
						procedureName="PKG_CLASE.SP_INSERTAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="P_ID_CLASE", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_NOMBRE_CORTO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_NOMBRE_LARGO", type=String.class),
									
									@StoredProcedureParameter(mode=ParameterMode.IN, name="P_ID_SITUACION", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="P_AUD_ID_USUARIO", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_AUD_IP", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_AUD_SESSION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_AUD_ID_OPERACION", type=Long.class)
							}					
				),
				@NamedStoredProcedureQuery(
						name="situacion.update", 
						procedureName="PKG_CLASE.SP_ACTUALIZAR",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="P_ID_CLASE", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="P_NOMBRE_CORTO", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="P_NOMBRE_LARGO", type=String.class),
								
								@StoredProcedureParameter(mode=ParameterMode.IN, name="P_ID_SITUACION", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="P_AUD_ID_USUARIO", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="P_AUD_IP", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="P_AUD_SESSION", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="P_AUD_ID_OPERACION", type=Long.class)
						}					
										
				),
				@NamedStoredProcedureQuery(
						name="situacion.delete", 
						procedureName="PKG_CLASE.SP_ELIMINAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="P_ID_CLASE", type=Long.class )
							}					
				),
				@NamedStoredProcedureQuery(
						name="situacion.listarSituacionReceta", 
						procedureName="[Farmacia].[dbo].[SP_SITUACION_LISTAR]",
						resultClasses = Situacion.class,
						parameters={
									
							}					
				)
		
		}
	)
@Entity
public class Situacion 
	extends GenericEntity{
	private static final int serialVersionUID = 1;
	@Id
	@Column(name="ID_SITUACION")
	private int idSituacion;

	@Column(name="ID_TABLA")
	private int idTabla;
	  
	
	@Column(name="NOMBRE_CORTO")
	private String nombreCorto;

	@Column(name="NOMBRE_LARGO")
	private String nombreLargo;

	public Situacion() {
	}


	public int getIdSituacion() {
		return idSituacion;
	}

	public void setIdSituacion(int idSituacion) {
		this.idSituacion = idSituacion;
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

	public int getIdTabla() {
		return idTabla;
	}

	public void setIdTabla(int idTabla) {
		this.idTabla = idTabla;
	}

 

	@Override
	public String toString() {
		return "Situacion [idSituacion=" + idSituacion + ", nombreCorto=" + nombreCorto
				+ ", nombreLargo=" + nombreLargo + ", estado="
				+ estado + "]";
	}
	
}