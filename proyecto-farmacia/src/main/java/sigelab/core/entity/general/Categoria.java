package pe.com.galaxy.systems.apolo.core.entidad.entidad.general;

import java.io.Serializable;
import javax.persistence.*;

@NamedStoredProcedureQueries({
	
	@NamedStoredProcedureQuery(
		name="categoria.listarCombo", 
		procedureName="SP_CATEGORIA_LISTAR",
		resultClasses= Categoria.class	
	)
})
@Entity
@Table(name="CATEGORIA")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="AUD_ID_OPERACION")
	private int audIdOperacion;

	@Column(name="AUD_ID_USUARIO")
	private int audIdUsuario;

	@Column(name="AUD_IP")
	private String audIp;

	@Column(name="AUD_SESSION")
	private String audSession;

	@Column(name="ESTADO")
	private String estado;

	@Id
	@Column(name="ID_CATEGORIA")	
	private int idCategoria;

	@Column(name="ID_SITUACION")
	private int idSituacion;

	@Column(name="NOMBRE_CORTO")
	private String nombreCorto;

	@Column(name="NOMBRE_LARGO")
	private String nombreLargo;

	public Categoria() {
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

	public int getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public int getIdSituacion() {
		return this.idSituacion;
	}

	public void setIdSituacion(int idSituacion) {
		this.idSituacion = idSituacion;
	}

	public String getNombreCorto() {
		return this.nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	public String getNombreLargo() {
		return this.nombreLargo;
	}

	public void setNombreLargo(String nombreLargo) {
		this.nombreLargo = nombreLargo;
	}

}