package sigelab.core.entity.general;

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
						name="intitucion.buscarxid", 
						procedureName="SP_INSTITUCIONES_BUSCAR_X_ID",
						resultClasses= Institucion.class,
						parameters={
									//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_INSTITUCION", type=Long.class)
							}					
					),
				@NamedStoredProcedureQuery(
						name="intitucion.buscarxcriterios", 
						procedureName="SP_INSTITUCIONES_BUSCAR_X_CRITERIOS",
						resultClasses= Institucion.class,
						parameters={
								//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_CORTO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_LARGO", type=String.class)
							}	
				),
				@NamedStoredProcedureQuery(
						name="intitucion.buscarTodos", 
						procedureName="SP_INSTITUCIONES_BUSCAR_TODOS",
						resultClasses= Institucion.class
				),
				@NamedStoredProcedureQuery(
						name="intitucion.insert", 
						procedureName="SP_INSTITUCIONES_INSERTAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_CORTO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_LARGO", type=String.class),
									
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SITUACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_USUARIO", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_OPERACION", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="RUC", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_OBSERVACION", type=String.class)
							}					
				),
				@NamedStoredProcedureQuery(
						name="intitucion.update", 
						procedureName="SP_INSTITUCIONES_ACTUALIZAR",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NOMBRE_CORTO", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NOMBRE_LARGO", type=String.class),
								
								@StoredProcedureParameter(mode=ParameterMode.IN, name="RUC", type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_OBSERVACION", type=String.class )
						}					
										
				),
				@NamedStoredProcedureQuery(
						name="intitucion.delete", 
						procedureName="SP_INSTITUCIONES_ELIMINAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class )
							}					
				),
				@NamedStoredProcedureQuery(
						name="intitucion.validar", 
						procedureName="SP_INSTITUCIONES_VALIDAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="NOMBRE_CORTO", type=String.class )
							}					
				)
		
		}
	)
@Entity
public class Institucion { 
	
	@Id
	@Column(name="ID_INSTITUCION")
	private String idInstitucion;

	@Column(name="NOMBRE_CORTO")
	private String nombreCorto;

	@Column(name="NOMBRE_LARGO")
	private String nombreLargo;

	@Column(name="ID_ORGANIZACION")
	private int idOrganizacion;
	
	/**@Column(name="ID_SEDE")
	private int idSede;
	
	@Column(name="NRO_VERSION")
	private int nroVersion;
	
	@Column(name="NRO_PERIODO")
	private int nroPeriodo;
	*/
	private String ruc;
	
	@Column(name="AUD_FECHA_OPERACION")
	private  Timestamp 	aud_fechaOperacion;
	
	private String observacion;
	
	public Institucion() {  
	}

	public String getIdInstitucion() {
		return idInstitucion;
	}

	public void setIdInstitucion(String idInstitucion) {
		this.idInstitucion = idInstitucion;
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

	public int getIdOrganizacion() {
		return idOrganizacion;
	}

	public void setIdOrganizacion(int idOrganizacion) {
		this.idOrganizacion = idOrganizacion;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public Timestamp getAud_fechaOperacion() {
		return aud_fechaOperacion;
	}

	public void setAud_fechaOperacion(Timestamp aud_fechaOperacion) {
		this.aud_fechaOperacion = aud_fechaOperacion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	 

 
	
}
