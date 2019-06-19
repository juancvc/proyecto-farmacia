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
						name="periodo.buscarxid", 
						procedureName="SP_PERIODO_BUSCAR_X_ID",
						resultClasses= Periodo.class,
						parameters={
								//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_PERIODO", type=Long.class)
							}					
					),
				
				@NamedStoredProcedureQuery(
						name="periodo.buscarTodos", 
						procedureName="SP_PERIODO_BUSCAR_TODOS",
						resultClasses= Periodo.class
					/*	parameters={
									@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class )
							}	*/				
					),
					
				@NamedStoredProcedureQuery(
						name="periodo.buscarxcriterios", 
						procedureName="SP_PERIODO_BUSCAR_X_CRITERIOS",
						resultClasses= Periodo.class,
						parameters={
								//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_CORTO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_LARGO", type=String.class)
							}	
				),
				
				@NamedStoredProcedureQuery(
						name="periodo.insert", 
						procedureName="SP_PERIODO_INSERTAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="ID_PERIODO", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_CORTO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_LARGO", type=String.class),
									
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SITUACION", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_USUARIO", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_OPERACION", type=Long.class)
							}					
				),
				
				@NamedStoredProcedureQuery(
						name="periodo.update", 
						procedureName="SP_PERIODO_ACTUALIZAR",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_PERIODO", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NOMBRE_CORTO", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NOMBRE_LARGO", type=String.class),
								
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SITUACION", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_USUARIO", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_IP", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_SESSION", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_OPERACION", type=Long.class)
						}					
										
				),
				@NamedStoredProcedureQuery(
						name="periodo.delete", 
						procedureName="SP_PERIODO_ELIMINAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_PERIODO", type=Long.class )
							}					
				)
		
		}
	)
@Entity
public class Periodo 
	extends GenericEntity{
	private static final int serialVersionUID = 1;
	@Id
	@Column(name="ID_PERIODO")
	private int idPeriodo;

	@Column(name="NOMBRE_CORTO")
	private String nombreCorto;

	@Column(name="NOMBRE_LARGO")
	private String nombreLargo;

	public Periodo() {
	}


	public int getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(int idPeriodo) {
		this.idPeriodo = idPeriodo;
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

	@Override
	public String toString() {
		return "Clase [idPeriodo=" + idPeriodo + ", nombreCorto=" + nombreCorto
				+ ", nombreLargo=" + nombreLargo + ", estado="
				+ estado + "]";
	}
	
}