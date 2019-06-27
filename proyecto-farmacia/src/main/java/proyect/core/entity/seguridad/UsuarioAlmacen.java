package proyect.core.entity.seguridad;

import java.io.Serializable;

import javax.persistence.*; 

import java.sql.Timestamp;

@NamedStoredProcedureQueries(
		{
				@NamedStoredProcedureQuery(
					name="usuarioAlmacen.insertar", 
					procedureName="[Farmacia].[dbo].[SP_USUARIO_ALMACEN_INSERTAR]",					
					parameters={
								@StoredProcedureParameter(mode=ParameterMode.OUT,  name="idUsuarioAlmacen", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,   name="idUsuario", 		type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,   name="idAlmacen", 		type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,   name="usuarioRegistro", 	type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,   name="ipRegistro", 		type=String.class)
						}					
				)
		}
	)
@Entity
@Table(name="USUARIO_ALMACEN")
public class UsuarioAlmacen implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UsuarioAlmacenPK id;

	@Column(name="AUD_FECHA_OPERACION")
	private Timestamp audFechaOperacion;

	@Column(name="AUD_ID_OPERACION")
	private int audIdOperacion;

	@Column(name="usuarioRegistro")
	private String audIdUsuario;

	@Column(name="ipRegistro")
	private String audIp;

	@Column(name="AUD_MAC")
	private String audMac;

	@Column(name="observacion")
	private String audObservacion;

	@Column(name="AUD_SESSION")
	private String audSession;

	@Column(name="ESTADO")
	private String estado;

	@Column(name="idAlmacen")
	private String idAlmacen;

	@Column(name="idUsuario")
	private String idUsuario;

	public UsuarioAlmacen() {
		setId(new UsuarioAlmacenPK());
	}

	public UsuarioAlmacenPK getId() {
		return this.id;
	}

	public void setId(UsuarioAlmacenPK id) {
		this.id = id;
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

	public String getAudIdUsuario() {
		return this.audIdUsuario;
	}

	public void setAudIdUsuario(String audIdUsuario) {
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

	public String getIdAlmacen() {
		return this.idAlmacen;
	}

	public void setIdAlmacen(String idAlmacen) {
		this.idAlmacen = idAlmacen;
	}

	public String getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

}