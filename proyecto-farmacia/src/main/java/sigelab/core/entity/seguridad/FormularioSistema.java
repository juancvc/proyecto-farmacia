package pe.com.galaxy.systems.apolo.core.entidad.entidad.seguridad;

import java.io.Serializable;

import javax.persistence.*;

import pe.com.galaxy.systems.apolo.core.entidad.entidad.seguridad.Perfil; 

import java.sql.Timestamp;

@NamedStoredProcedureQueries(
		{
				
		@NamedStoredProcedureQuery(
				name="formularioSistema.listarFormularios", 
				procedureName="[Farmacia].[SEGU].[SP_LISTAR_FORMULARIOS_SISTEMA]",
				resultClasses= FormularioSistema.class,
				parameters={
								
					@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_FORMULARIO", type=int.class)
					}					
					)
		
		}
	)


@Entity
@Table(name="FORMULARIO_SISTEMA")
public class FormularioSistema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_FORMULARIO")
	private int idFormulario;

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

	@Column(name="DESCRIPCION_FORMULARIO")
	private String descripcionFormulario;

	@Column(name="ESTADO")
	private String estado;

	@Column(name="ID_SITUACION")
	private int idSituacion;

	@Column(name="NOMBRE_FORMULARIO")
	private String nombreFormulario;

	@Column(name="SW_VISIBLE")
	private String swVisible;
	
	private Perfil perfil;
	
	private  int   idBotonFormulario;
	
	public FormularioSistema() {
		setPerfil(new Perfil());
	}

	public int getIdFormulario() {
		return this.idFormulario;
	}

	public void setIdFormulario(int idFormulario) {
		this.idFormulario = idFormulario;
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

	public String getDescripcionFormulario() {
		return this.descripcionFormulario;
	}

	public void setDescripcionFormulario(String descripcionFormulario) {
		this.descripcionFormulario = descripcionFormulario;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getIdSituacion() {
		return this.idSituacion;
	}

	public void setIdSituacion(int idSituacion) {
		this.idSituacion = idSituacion;
	}

	public String getNombreFormulario() {
		return this.nombreFormulario;
	}

	public void setNombreFormulario(String nombreFormulario) {
		this.nombreFormulario = nombreFormulario;
	}

	public String getSwVisible() {
		return this.swVisible;
	}

	public void setSwVisible(String swVisible) {
		this.swVisible = swVisible;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public int getIdBotonFormulario() {
		return idBotonFormulario;
	}

	public void setIdBotonFormulario(int idBotonFormulario) {
		this.idBotonFormulario = idBotonFormulario;
	}

}