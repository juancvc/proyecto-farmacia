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
						name="sexo.buscarxid", 
						procedureName="SP_SEXO_BUSCAR_X_ID",
						resultClasses= Sexo.class,
						parameters={
									//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SEXO", type=Long.class)
							}					
					),
				@NamedStoredProcedureQuery(
						name="sexo.buscarxcriterios", 
						procedureName="SP_SEXO_BUSCAR_X_CRITERIOS",
						resultClasses= Sexo.class,
						parameters={
								//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_CORTO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_LARGO", type=String.class)
							}	
				),
				@NamedStoredProcedureQuery(
						name="sexo.buscarTodos", 
						procedureName="SP_SEXO_BUSCAR_TODOS",
						resultClasses= Sexo.class
				),
				@NamedStoredProcedureQuery(
						name="sexo.insert", 
						procedureName="SP_SEXO_INSERTAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="ID_SEXO", type=Long.class ),
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
						name="sexo.update", 
						procedureName="SP_SEXO_ACTUALIZAR",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEXO", type=Long.class ),
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
						name="sexo.delete", 
						procedureName="SP_SEXO_ELIMINAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEXO", type=Long.class )
							}					
				)
		
		}
	)
@Entity
public class Sexo extends GenericEntity{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_SEXO")
	private long idSexo;

	@Column(name="NOMBRE_CORTO")
	private String nombreCorto;

	@Column(name="NOMBRE_LARGO")
	private String nombreLargo;

	public Sexo() {
	}
	
	public long getIdSexo() {
		return idSexo;
	}

	public void setIdSexo(long idSexo) {
		this.idSexo = idSexo;
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
	
}
