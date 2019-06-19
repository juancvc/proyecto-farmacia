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
						name="clase.buscarxid", 
						procedureName="SP_CLASE_BUSCAR_X_ID",
						resultClasses= Clase.class,
						parameters={
								//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_CLASE", type=Long.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class )
							}					
					),
				
				@NamedStoredProcedureQuery(
						name="clase.buscarTodos", 
						procedureName="SP_CLASE_BUSCAR_TODOS",
						resultClasses= Clase.class
					/*	parameters={
									@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class )
							}	*/				
					),
					
				@NamedStoredProcedureQuery(
						name="clase.buscarxcriterios", 
						procedureName="SP_CLASE_BUSCAR_X_CRITERIOS",
						resultClasses= Clase.class,
						parameters={
								//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_CORTO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_LARGO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class )
							}	
				),
				
				@NamedStoredProcedureQuery(
						name="clase.insert", 
						procedureName="SP_CLASE_INSERTAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="ID_CLASE", type=Long.class ),
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
						name="clase.update", 
						procedureName="SP_CLASE_ACTUALIZAR",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_CLASE", type=Long.class ),
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
						name="clase.delete", 
						procedureName="SP_CLASE_ELIMINAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_CLASE", type=Long.class ),
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
						name="clase.validar", 
						procedureName="dbo.SP_CLASE_VALIDAR",
						resultClasses= Clase.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_CLASE", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="NOMBRE_CORTO", type=String.class )
							}					
				)				
		
		}
	)
@Entity
public class Clase 
	extends GenericEntity{
	private static final int serialVersionUID = 1;
	@Id
	@Column(name="ID_CLASE")
	private int idClase;

	@Column(name="NOMBRE_CORTO")
	private String nombreCorto;

	@Column(name="NOMBRE_LARGO")
	private String nombreLargo;

	@Column(name="ID_ORGANIZACION_CLASE")
	private int idOrganizacionClase;
	
	@Column(name="ID_INSTITUCION_CLASE")
	private int idInstitucionClase;
	
	@Column(name="ID_SEDE_CLASE")
	private int idSedeClase;
	
	@Column(name="NRO_VERSION_CLASE")
	private int nroVersionClase;
	
	@Column(name="NRO_PERIODO_CLASE")
	private int nroPeriodoClase;
	
	@Column(name="AUD_FECHA_OPERACION")
	private  Timestamp 	aud_fechaOperacion;
	
	public Clase() {
		this.setSituacion(new Situacion());
		this.setAud_usuario(new Usuario());
	}


	public int getIdClase() {
		return idClase;
	}

	public void setIdClase(int idClase) {
		this.idClase = idClase;
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

	public int getIdOrganizacionClase() {
		return idOrganizacionClase;
	}


	public void setIdOrganizacionClase(int idOrganizacionClase) {
		this.idOrganizacionClase = idOrganizacionClase;
	}


	public int getIdInstitucionClase() {
		return idInstitucionClase;
	}


	public void setIdInstitucionClase(int idInstitucionClase) {
		this.idInstitucionClase = idInstitucionClase;
	}


	public int getIdSedeClase() {
		return idSedeClase;
	}


	public void setIdSedeClase(int idSedeClase) {
		this.idSedeClase = idSedeClase;
	}


	public int getNroVersionClase() {
		return nroVersionClase;
	}


	public void setNroVersionClase(int nroVersionClase) {
		this.nroVersionClase = nroVersionClase;
	}


	public int getNroPeriodoClase() {
		return nroPeriodoClase;
	}


	public void setNroPeriodoClase(int nroPeriodoClase) {
		this.nroPeriodoClase = nroPeriodoClase;
	}


	@Override
	public String toString() {
		return "Clase [idClase=" + idClase + ", nombreCorto=" + nombreCorto
				+ ", nombreLargo=" + nombreLargo + ", estado="
				+ estado + "]";
	}


	public Timestamp getAud_fechaOperacion() {
		return aud_fechaOperacion;
	}


	public void setAud_fechaOperacion(Timestamp aud_fechaOperacion) {
		this.aud_fechaOperacion = aud_fechaOperacion;
	}
	
}