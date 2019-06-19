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
						name="tipoEntidad.buscarxid", 
						procedureName="SP_TIPO_ENTIDAD_BUSCAR_X_ID",
						resultClasses= TipoEntidad.class,
						parameters={
									//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_TIPO_DOCUMENTO_COMPRA", type=Long.class)
							}					
					),
				@NamedStoredProcedureQuery(
						name="tipoEntidad.buscarxcriterios", 
						procedureName="SP_TIPO_ENTIDAD_BUSCAR_X_CRITERIOS",
						resultClasses= TipoEntidad.class,
						parameters={
								//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_CORTO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_LARGO", type=String.class)
							}	
				),
				@NamedStoredProcedureQuery(
						name="tipoEntidad.buscarTodos", 
						procedureName="SP_TIPO_ENTIDAD_BUSCAR_TODOS",
						resultClasses= TipoEntidad.class
				),
				@NamedStoredProcedureQuery(
						name="tipoEntidad.insert", 
						procedureName="SP_TIPO_ENTIDAD_INSERTAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="ID_TIPO_DOCUMENTO_COMPRA", type=Long.class ),
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
						name="tipoEntidad.update", 
						procedureName="SP_TIPO_ENTIDAD_ACTUALIZAR",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_TIPO_DOCUMENTO_COMPRA", type=Long.class ),
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
						name="tipoEntidad.delete", 
						procedureName="SP_TIPO_ENTIDAD_ELIMINAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_TIPO_DOCUMENTO_COMPRA", type=Long.class )
							}					
				)
		
		}
	)
@Entity
public class TipoEntidad extends GenericEntity{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_TIPO_ENTIDAD")
	private long idTipoEntidad;

	@Column(name="NOMBRE_CORTO")
	private String nombreCorto;

	@Column(name="NOMBRE_LARGO")
	private String nombreLargo;
	
	@Column(name="VALOR01")
	private String valor01;

	public TipoEntidad() {
	}

	
	public long getIdTipoEntidad() {
		return idTipoEntidad;
	}


	public void setIdTipoEntidad(long idTipoEntidad) {
		this.idTipoEntidad = idTipoEntidad;
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


	public String getValor01() {
		return valor01;
	}


	public void setValor01(String valor01) {
		this.valor01 = valor01;
	}
	
}
