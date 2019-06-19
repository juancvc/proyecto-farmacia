package pe.com.galaxy.systems.apolo.core.entidad.entidad.venta;

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
						name="motivoDevolucion.buscarxid", 
						procedureName="SP_MOTIVO_DEVOLUCION_BUSCAR_X_ID",
						resultClasses= MotivoDevolucion.class,
						parameters={
									//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_MOTIVO_DEVOLUCION", type=Long.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class )
							}					
					),
				@NamedStoredProcedureQuery(
						name="motivoDevolucion.buscarxcriterios", 
						procedureName="SP_MOTIVO_DEVOLUCION_BUSCAR_X_CRITERIOS",
						resultClasses= MotivoDevolucion.class,
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
						name="motivoDevolucion.buscarTodos", 
						procedureName="SP_MOTIVO_DEVOLUCION_BUSCAR_TODOS",
						resultClasses= MotivoDevolucion.class
				),
				@NamedStoredProcedureQuery(
						name="motivoDevolucion.insert", 
						procedureName="SP_MOTIVO_DEVOLUCION_INSERTAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="ID_MOTIVO_DEVOLUCION", type=Long.class ),
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
						name="motivoDevolucion.update", 
						procedureName="SP_MOTIVO_DEVOLUCION_ACTUALIZAR",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_MOTIVO_DEVOLUCION", type=Long.class ),
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
						name="motivoDevolucion.delete", 
						procedureName="SP_MOTIVO_DEVOLUCION_ELIMINAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_MOTIVO_DEVOLUCION", type=Long.class ),
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
						name="motivoDevolucion.validar", 
						procedureName="SP_MOTIVO_DEVOLUCION_VALIDAR",
						resultClasses= MotivoDevolucion.class,
						parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_MOTIVO_DEVOLUCION", type=Long.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="NOMBRE_CORTO", type=int.class )
					}						
				)
		
		}
	)
@Entity
public class MotivoDevolucion extends GenericEntity{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_MOTIVO_DEVOLUCION")
	private long idMotivoDevolucion;

	@Column(name="NOMBRE_CORTO")
	private String nombreCorto;

	@Column(name="NOMBRE_LARGO")
	private String nombreLargo;

	@Column(name="ID_ORGANIZACION_DEVOLUCION")
	private int idOrganizacionMotivoDevolucion;
	
	@Column(name="ID_INSTITUCION_DEVOLUCION")
	private int idInstitucionMotivoDevolucion;
	
	@Column(name="ID_SEDE_DEVOLUCION")
	private int idSedeMotivoDevolucion;
	
	@Column(name="NRO_VERSION_DEVOLUCION")
	private int nroVersionMotivoDevolucion;
	
	@Column(name="AUD_FECHA_OPERACION")
	private  Timestamp 	aud_fechaOperacion;
	
	public MotivoDevolucion() {
		this.setSituacion(new Situacion());
		this.setAud_usuario(new Usuario());
	}
	
	public long getIdMotivoDevolucion() {
		return idMotivoDevolucion;
	}

	public void setIdMotivoDevolucion(long idMotivoDevolucion) {
		this.idMotivoDevolucion = idMotivoDevolucion;
	}

	public int getIdOrganizacionMotivoDevolucion() {
		return idOrganizacionMotivoDevolucion;
	}

	public void setIdOrganizacionMotivoDevolucion(int idOrganizacionMotivoDevolucion) {
		this.idOrganizacionMotivoDevolucion = idOrganizacionMotivoDevolucion;
	}

	public int getIdInstitucionMotivoDevolucion() {
		return idInstitucionMotivoDevolucion;
	}

	public void setIdInstitucionMotivoDevolucion(int idInstitucionMotivoDevolucion) {
		this.idInstitucionMotivoDevolucion = idInstitucionMotivoDevolucion;
	}

	public int getIdSedeMotivoDevolucion() {
		return idSedeMotivoDevolucion;
	}

	public void setIdSedeMotivoDevolucion(int idSedeMotivoDevolucion) {
		this.idSedeMotivoDevolucion = idSedeMotivoDevolucion;
	}

	public int getNroVersionMotivoDevolucion() {
		return nroVersionMotivoDevolucion;
	}

	public void setNroVersionMotivoDevolucion(int nroVersionMotivoDevolucion) {
		this.nroVersionMotivoDevolucion = nroVersionMotivoDevolucion;
	}

	public Timestamp getAud_fechaOperacion() {
		return aud_fechaOperacion;
	}

	public void setAud_fechaOperacion(Timestamp aud_fechaOperacion) {
		this.aud_fechaOperacion = aud_fechaOperacion;
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
