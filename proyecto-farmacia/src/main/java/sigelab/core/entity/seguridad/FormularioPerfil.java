package pe.com.galaxy.systems.apolo.core.entidad.entidad.seguridad;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;


@NamedStoredProcedureQueries(
		{
				
		@NamedStoredProcedureQuery(
				name="formularioPerfil.insertar", 
				procedureName="[Farmacia].[SEGU].[SP_FORMULARIO_PERFIL_INSERTAR]",
				parameters={
								
					@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_PERFIL", type=int.class),
					@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_FORMULARIO", type=int.class),
					@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_BOTON_FORMULARIO", type=int.class),
					@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SITUACION", type=int.class),
					@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_MAC", type=String.class),
					@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class),
					@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_USUARIO", type=int.class),
					@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
					@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_OPERACION", type=int.class),
					@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_OBSERVACION", type=String.class)
					}					
					),
		@NamedStoredProcedureQuery(
				name="formularioPerfil.buscarPorCriterios", 
				procedureName="[Farmacia].[SEGU].[SP_FORMULARIO_PERFIL_BUSCAR_X_CRITERIOS]",
				resultClasses = FormularioPerfil.class,
				parameters={
											
						@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_PERFIL", type=int.class)
					}					
					),
		@NamedStoredProcedureQuery(
				name="formularioPerfil.eliminar", 
				procedureName="[Farmacia].[SEGU].[SP_FORMULARIO_PERFIL_ELIMINAR]",
				parameters={
											
						@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_PERFIL", type=int.class),
						@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_FORMULARIO", type=int.class),

						@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_MAC", type=String.class),
						@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class),
						@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_USUARIO", type=int.class),
						@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
						@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_OPERACION", type=int.class),
						@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_OBSERVACION", type=String.class)
								}					
								)
		
		}
	)
@Entity
@Table(name="FORMULARIO_PERFIL")
public class FormularioPerfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_FORMULARIO_PERFIL")
	private int idFormularioPerfil;

	@Column(name="AUD_FECHA_OPERACION")
	private Timestamp audFechaOperacion;

	@Column(name="AUD_ID_OPERACION")
	private int audIdOperacion;

	@Column(name="AUD_ID_USUARIO")
	private int audIdUsuario;

	@Column(name="AUD_IP")
	private String audIp;

	@Column(name="AUD_MAC")
	private String audMac;

	@Column(name="AUD_OBSERVACION")
	private String audObservacion;

	@Column(name="AUD_SESSION")
	private String audSession;

	@Column(name="ESTADO")
	private String estado;

	@Column(name="ID_BOTON_FORMULARIO")
	private int idBotonFormulario;

	@Column(name="ID_FORMULARIO")
	private int idFormulario;

	@Column(name="ID_PERFIL")
	private int idPerfil;

	@Column(name="ID_SITUACION")
	private int idSituacion;
	
	@Column(name="NOMBRE_FORMULARIO")
	private String nombreFormulario;
	
	@Column(name="DESCRIPCION_FORMULARIO")
	private String descripcionFormulario;

	public FormularioPerfil() {
	}

	public int getIdFormularioPerfil() {
		return this.idFormularioPerfil;
	}

	public void setIdFormularioPerfil(int idFormularioPerfil) {
		this.idFormularioPerfil = idFormularioPerfil;
	}

	public Timestamp getAudFechaOperacion() {
		return this.audFechaOperacion;
	}

	public void setAudFechaOperacion(Timestamp audFechaOperacion) {
		this.audFechaOperacion = audFechaOperacion;
	}

	public int getAudIdOperacion() {
		return this.audIdOperacion;
	}

	public void setAudIdOperacion(int audIdOperacion) {
		this.audIdOperacion = audIdOperacion;
	}

	public int getAudIdUsuario() {
		return this.audIdUsuario;
	}

	public void setAudIdUsuario(int audIdUsuario) {
		this.audIdUsuario = audIdUsuario;
	}

	public String getAudIp() {
		return this.audIp;
	}

	public void setAudIp(String audIp) {
		this.audIp = audIp;
	}

	public String getAudMac() {
		return this.audMac;
	}

	public void setAudMac(String audMac) {
		this.audMac = audMac;
	}

	public String getAudObservacion() {
		return this.audObservacion;
	}

	public void setAudObservacion(String audObservacion) {
		this.audObservacion = audObservacion;
	}

	public String getAudSession() {
		return this.audSession;
	}

	public void setAudSession(String audSession) {
		this.audSession = audSession;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getIdBotonFormulario() {
		return this.idBotonFormulario;
	}

	public void setIdBotonFormulario(int idBotonFormulario) {
		this.idBotonFormulario = idBotonFormulario;
	}

	public int getIdFormulario() {
		return this.idFormulario;
	}

	public void setIdFormulario(int idFormulario) {
		this.idFormulario = idFormulario;
	}

	public int getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public int getIdSituacion() {
		return this.idSituacion;
	}

	public void setIdSituacion(int idSituacion) {
		this.idSituacion = idSituacion;
	}

	public String getNombreFormulario() {
		return nombreFormulario;
	}

	public void setNombreFormulario(String nombreFormulario) {
		this.nombreFormulario = nombreFormulario;
	}

	public String getDescripcionFormulario() {
		return descripcionFormulario;
	}

	public void setDescripcionFormulario(String descripcionFormulario) {
		this.descripcionFormulario = descripcionFormulario;
	}

	
}