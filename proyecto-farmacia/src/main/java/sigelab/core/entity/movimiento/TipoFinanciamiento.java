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
						name="tipoFinanciamiento.findByObject", 
						procedureName="SP_TIPO_FINANCIAMIENTO_BUSCAR_X_ID",
						resultClasses= TipoFinanciamiento.class,
						parameters={
									//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_TIPO_FINANCIAMIENTO", type=Integer.class)
							}					
					),
				@NamedStoredProcedureQuery(
						name="tipoFinanciamiento.findByLikeObject", 
						procedureName="SP_TIPO_FINANCIAMIENTO_BUSCAR_X_CRITERIOS",
						resultClasses= TipoFinanciamiento.class,
						parameters={
									//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="NOMBRE_CORTO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="NOMBRE_LARGO", type=String.class)
							}	
				),
				
				@NamedStoredProcedureQuery(
						name="tipoFinanciamiento.insert", 
						procedureName="SP_TIPO_FINANCIAMIENTO_INSERTAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="ID_TIPO_FINANCIAMIENTO", type=Integer.class ),
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
						name="tipoFinanciamiento.update", 
						procedureName="SP_TIPO_FINANCIAMIENTO_ACTUALIZAR",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_TIPO_FINANCIAMIENTO", type=Integer.class ),
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
						name="tipoFinanciamiento.delete", 
						procedureName="SP_TIPO_FINANCIAMIENTO_ELIMINAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_TIPO_FINANCIAMIENTO", type=Integer.class )
							}					
				),
				@NamedStoredProcedureQuery(
						name="tipoFinanciamiento.buscarTodos", 
						procedureName="SP_TIPO_FINANCIAMIENTO_BUSCAR_TODOS",
						resultClasses= TipoFinanciamiento.class
						/*parameters={
									@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class )
							}	*/				
					)
		
		}
	)
@Entity
@Table(name="TIPO_FINANCIAMIENTO")
public class TipoFinanciamiento 
	extends GenericEntity{
	
	@Id
	@Column(name="ID_TIPO_FINANCIAMIENTO")
	private int idTipoFinanciamiento;

	@Column(name="NOMBRE_CORTO")
	private String nombreCorto;

	@Column(name="NOMBRE_LARGO")
	private String nombreLargo;

	@Column(name="CODIGO_PUBLICO")
	private String codigoPublico;
	
	public TipoFinanciamiento() {
	}

	public int getIdTipoFinanciamiento() {
		return idTipoFinanciamiento;
	}

	public void setIdTipoFinanciamiento(int idTipoFinanciamiento) {
		this.idTipoFinanciamiento = idTipoFinanciamiento;
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

	public String getCodigoPublico() {
		return codigoPublico;
	}

	public void setCodigoPublico(String codigoPublico) {
		this.codigoPublico = codigoPublico;
	}

	@Override
	public String toString() {
		return "TipoFinanciamiento [idTipoFinanciamiento=" + idTipoFinanciamiento + ", nombreCorto=" + nombreCorto
				+ ", nombreLargo=" + nombreLargo + ", estado="
				+ estado + "]";
	}
	
}