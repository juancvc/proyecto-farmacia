package proyect.core.entity.seguridad;

import java.io.Serializable;

import javax.persistence.*; 

import java.sql.Timestamp;

@NamedStoredProcedureQueries(
		{
				@NamedStoredProcedureQuery(
					name="usuarioAlmacen.buscarPorCriterios", 
					resultClasses= UsuarioAlmacen.class,
					procedureName="usp_UsuarioAlmacen_buscarxCriterios",					
					parameters={ 
								@StoredProcedureParameter(mode=ParameterMode.IN,   name="idUsuario", type=String.class)
						}					
				),
				@NamedStoredProcedureQuery(
						name="usuarioAlmacen.insert", 
						procedureName="[dbo].[usp_UsuarioAlmacen_insertar]",					
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT,  name="idUsuarioAlmacen", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,   name="idUsuario", 		type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,   name="idAlmacen", 		type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,   name="usuarioRegistro", 	type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,   name="ipRegistro", 		type=String.class)
							}					
					),
				@NamedStoredProcedureQuery(
						name="usuarioAlmacen.delete", 
						procedureName="[dbo].[usp_UsuarioAlmacen_eliminar]",
						parameters={
									
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idUsuarioAlmacen",		type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioModificacion",   type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipModificacion", 		type=String.class)
							}					
				),
		}
	)
@Entity
@Table(name="UsuarioAlmacen")
public class UsuarioAlmacen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idUsuarioAlmacen;

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
 
	private String nombreAlmacen;
	
	
	public String getNombreAlmacen() {
		return nombreAlmacen;
	}

	public void setNombreAlmacen(String nombreAlmacen) {
		this.nombreAlmacen = nombreAlmacen;
	}

	public String getIdUsuarioAlmacen() {
		return idUsuarioAlmacen;
	}

	public void setIdUsuarioAlmacen(String idUsuarioAlmacen) {
		this.idUsuarioAlmacen = idUsuarioAlmacen;
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