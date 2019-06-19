package pe.com.galaxy.systems.apolo.core.entidad.entidad.seguridad;

import java.io.Serializable;

import javax.persistence.*;

import pe.com.galaxy.systems.apolo.core.entidad.GenericEntity;
import pe.com.galaxy.systems.apolo.core.entidad.vo.seguridad.UsuarioAlmacenVO;
import pe.com.galaxy.systems.apolo.core.entidad.vo.seguridad.UsuarioVO;

import java.sql.Timestamp;

@NamedStoredProcedureQueries(
		{
				@NamedStoredProcedureQuery(
					name="usuarioAlmacen.insertar", 
					procedureName="[Farmacia].[dbo].[SP_USUARIO_ALMACEN_INSERTAR]",					
					parameters={
							
								@StoredProcedureParameter(mode=ParameterMode.OUT,  name="ID_USUARIO_ALMACEN", type=int.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ORGANIZACION", type=int.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_INSTITUCION", type=int.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SEDE", type=int.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_USUARIO", type=int.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ALMACEN", type=int.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_USUARIO", type=int.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_MAC", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_OBSERVACION", type=String.class)
						}					
				)
		}
	)
@Entity
@Table(name="USUARIO_ALMACEN")
public class UsuarioAlmacen extends GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UsuarioAlmacenPK id;

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

	@Column(name="ID_ALMACEN")
	private int idAlmacen;

	@Column(name="ID_USUARIO")
	private int idUsuario;

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

	public int getIdAlmacen() {
		return this.idAlmacen;
	}

	public void setIdAlmacen(int idAlmacen) {
		this.idAlmacen = idAlmacen;
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

}