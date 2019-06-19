package pe.com.galaxy.systems.apolo.core.entidad.entidad.stock;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import pe.com.galaxy.systems.apolo.core.entidad.GenericEntity;
import pe.com.galaxy.systems.apolo.core.entidad.entidad.general.Situacion;
import pe.com.galaxy.systems.apolo.core.entidad.entidad.seguridad.Usuario;
@NamedStoredProcedureQueries(
		{
				
				@NamedStoredProcedureQuery(
						name="presentacion.findByObject", 
						procedureName="SP_PRESENTACION_BUSCAR_X_ID",
						resultClasses= Presentacion.class,
						parameters={
									//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_PRESENTACION", type=Long.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class )
							}					
					),
				@NamedStoredProcedureQuery(
						name="presentacion.findByLikeObject", 
						procedureName="SP_PRESENTACION_BUSCAR_X_CRITERIOS",
						resultClasses= Presentacion.class,
						parameters={
									//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_CORTO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_LARGO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class )
							}	
				),
				
				@NamedStoredProcedureQuery(
						name="presentacion.insert", 
						procedureName="SP_PRESENTACION_INSERTAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="ID_PRESENTACION", type=Long.class ),
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
						name="presentacion.update", 
						procedureName="SP_PRESENTACION_ACTUALIZAR",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_PRESENTACION", type=Long.class ),
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
						name="presentacion.delete", 
						procedureName="SP_PRESENTACION_ELIMINAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_PRESENTACION", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_USUARIO", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_IP", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_SESSION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_OPERACION", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_MAC", type=String.class)
							}					
				),
				@NamedStoredProcedureQuery(
						name="presentacion.validar", 
						procedureName="dbo.SP_PRESENTACION_VALIDAR",
						resultClasses= Presentacion.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_PRESENTACION", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_CORTO", type=String.class)
							}	
				)				
		
		}
	)
@Entity
public class Presentacion 
	extends GenericEntity{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ID_PRESENTACION")
	private long idPresentacion;

	@Column(name="NOMBRE_CORTO")
	private String nombreCorto;

	@Column(name="NOMBRE_LARGO")
	private String nombreLargo;

	@Column(name="ID_ORGANIZACION_PRESENTACION")
	private int idOrganizacionPresentacion;
	
	@Column(name="ID_INSTITUCION_PRESENTACION")
	private int idInstitucionPresentacion;
	
	@Column(name="ID_SEDE_PRESENTACION")
	private int idSedePresentacion;
	
	@Column(name="NRO_VERSION_PRESENTACION")
	private int nroVersionPresentacion;
	
	@Column(name="NRO_PERIODO_PRESENTACION")
	private int nroPeriodoPresentacion;
	
	@Column(name="AUD_FECHA_OPERACION")
	private  Timestamp 	aud_fechaOperacion;
	
	public Presentacion() {
		this.setSituacion(new Situacion());
		this.setAud_usuario(new Usuario());
	}


	public long getIdPresentacion() {
		return idPresentacion;
	}

	public void setIdPresentacion(long idPresentacion) {
		this.idPresentacion = idPresentacion;
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

	public Timestamp getAud_fechaOperacion() {
		return aud_fechaOperacion;
	}


	public void setAud_fechaOperacion(Timestamp aud_fechaOperacion) {
		this.aud_fechaOperacion = aud_fechaOperacion;
	}


	public int getIdOrganizacionPresentacion() {
		return idOrganizacionPresentacion;
	}


	public void setIdOrganizacionPresentacion(int idOrganizacionPresentacion) {
		this.idOrganizacionPresentacion = idOrganizacionPresentacion;
	}


	public int getIdInstitucionPresentacion() {
		return idInstitucionPresentacion;
	}


	public void setIdInstitucionPresentacion(int idInstitucionPresentacion) {
		this.idInstitucionPresentacion = idInstitucionPresentacion;
	}


	public int getIdSedePresentacion() {
		return idSedePresentacion;
	}


	public void setIdSedePresentacion(int idSedePresentacion) {
		this.idSedePresentacion = idSedePresentacion;
	}


	public int getNroVersionPresentacion() {
		return nroVersionPresentacion;
	}


	public void setNroVersionPresentacion(int nroVersionPresentacion) {
		this.nroVersionPresentacion = nroVersionPresentacion;
	}


	public int getNroPeriodoPresentacion() {
		return nroPeriodoPresentacion;
	}


	public void setNroPeriodoPresentacion(int nroPeriodoPresentacion) {
		this.nroPeriodoPresentacion = nroPeriodoPresentacion;
	}


	@Override
	public String toString() {
		return "Presentacion [idPresentacion=" + idPresentacion + ", nombreCorto=" + nombreCorto
				+ ", nombreLargo=" + nombreLargo + ", estado="
				+ estado + "]";
	}
	
}