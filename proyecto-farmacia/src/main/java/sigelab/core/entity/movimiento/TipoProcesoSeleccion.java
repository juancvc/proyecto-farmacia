package pe.com.galaxy.systems.apolo.core.entidad.entidad.movimiento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import pe.com.galaxy.systems.apolo.core.entidad.GenericEntity;
@SuppressWarnings("serial")
@NamedStoredProcedureQueries(
		{
				
				@NamedStoredProcedureQuery(
						name="tipoProcesoSeleccion.findByObject", 
						procedureName="SP_TIPO_PROCESO_SELECCION_BUSCAR_X_ID",
						resultClasses= TipoProcesoSeleccion.class,
						parameters={
									//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_TIPO_SELECCION", type=Integer.class)
							}					
					),
				@NamedStoredProcedureQuery(
						name="tipoProcesoSeleccion.findByLikeObject", 
						procedureName="SP_TIPO_PROCESO_SELECCION_BUSCAR_X_CRITERIOS",
						resultClasses= TipoProcesoSeleccion.class,
						parameters={
									//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="NOMBRE_CORTO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="NOMBRE_LARGO", type=String.class)
							}	
				),
				
				@NamedStoredProcedureQuery(
						name="tipoProcesoSeleccion.insert", 
						procedureName="SP_TIPO_PROCESO_SELECCION_INSERTAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="ID_TIPO_SELECCION", type=Integer.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_CORTO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_LARGO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="CODIGO_PUBLICO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SITUACION", type=Integer.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_USUARIO", type=Integer.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_OPERACION", type=Integer.class)
							}					
				),
				@NamedStoredProcedureQuery(
						name="tipoProcesoSeleccion.update", 
						procedureName="SP_TIPO_PROCESO_SELECCION_ACTUALIZAR",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_TIPO_SELECCION", type=Integer.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NOMBRE_CORTO", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NOMBRE_LARGO", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="CODIGO_PUBLICO", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SITUACION", type=Integer.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_USUARIO", type=Integer.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_IP", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_SESSION", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_OPERACION", type=Integer.class)
						}					
										
				),
				@NamedStoredProcedureQuery(
						name="tipoProcesoSeleccion.delete", 
						procedureName="SP_TIPO_PROCESO_SELECCION_ELIMINAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_TIPO_SELECCION", type=Integer.class )
							}					
				),
				@NamedStoredProcedureQuery(
						name="tipoProcesoSeleccion.buscarTodos", 
						procedureName="SP_TIPO_PROCESO_SELECCION_BUSCAR_TODOS",
						resultClasses= TipoProcesoSeleccion.class
						/*parameters={
									@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class )
							}	*/				
					)
		
		}
	)
@Entity
@Table(name="TIPO_PROCESO_SELECCION")
public class TipoProcesoSeleccion 
	extends GenericEntity{
	
	@Id
	@Column(name="ID_TIPO_SELECCION")
	private long idTipoSeleccion;

	@Column(name="NOMBRE_CORTO")
	private String nombreCorto;

	@Column(name="NOMBRE_LARGO")
	private String nombreLargo;

	@Column(name="CODIGO_PUBLICO")
	private String codigoPublico;
	
	public TipoProcesoSeleccion() {
	}


	
	public long getIdTipoSeleccion() {
		return idTipoSeleccion;
	}



	public void setIdTipoSeleccion(long idTipoSeleccion) {
		this.idTipoSeleccion = idTipoSeleccion;
	}



	public String getCodigoPublico() {
		return codigoPublico;
	}



	public void setCodigoPublico(String codigoPublico) {
		this.codigoPublico = codigoPublico;
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