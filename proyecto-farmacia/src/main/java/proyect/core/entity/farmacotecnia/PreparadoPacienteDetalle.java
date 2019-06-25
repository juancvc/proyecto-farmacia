package proyect.core.entity.farmacotecnia;

import java.io.Serializable;
import javax.persistence.*;



import java.sql.Timestamp;

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "preparadoPacienteDetalle.insert",
				procedureName = "SP_PREPARADO_PACIENTE_DETALLE_INSERTAR",
				parameters = {
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "idPreparadoPacienteDetalle", 	type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name =  "idPreparadoPaciente", 			type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name =  "idPreparado", 					type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name =  "cantidadPreparado", 			type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name =  "idSituacion", 					type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name =  "usuarioRegistro", 				type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name =  "ipRegistro", 					type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name =  "observacion", 					type = String.class) }),
		
		@NamedStoredProcedureQuery(name = "preparadoPacienteDetalle.update",
				procedureName = "SP_PREPARADO_ACTUALIZAR",
				parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "idInsumo", 				type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "nombreInsumo", 			type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "descripcion", 			type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "codigoSismed", 			type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "codigoSIGA", 			type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "concentracion", 			type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "idSituacion", 			type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "usuarioModificacion", 	type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ipModificacion", 		type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "observacion", 			type = String.class) }

		), @NamedStoredProcedureQuery(name = "preparadoPacienteDetalle.delete",
				procedureName = "[dbo].[SP_PREPARADO_PACIENTE_DETALLE_ELIMINAR] ",
				parameters = {  
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "idPreparadoPaciente", 	type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "idPreparado", 			type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "usuarioModificacion", 	type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ipModificacion", 		type = String.class)}),
		
		

		@NamedStoredProcedureQuery(name = "preparadoPacienteDetalle.findByObjectVO",
		procedureName = "SP_PREPARADO_BUSCAR_X_ID",
		resultClasses = PreparadoPaciente.class,
		parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "idPreparado", 			type = String.class) }),
		
		
		@NamedStoredProcedureQuery(name = "preparadoPacienteDetalle.findByLikeObject",
		procedureName = "SP_PREPARADO_PACIENTE_DETALLE_BUSCAR_X_IDPREPARADOPACIENTE",
		resultClasses = PreparadoPacienteDetalle.class,
		parameters = {

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "idPreparadoPaciente", type = int.class) }) }

)

@Entity
@Table(name = "PREPARADO_PACIENTE")
@NamedQuery(name = "preparadoPacienteDetalle.findAll", query = "SELECT p FROM PreparadoPaciente p")
public class PreparadoPacienteDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PreparadoPacienteDetallePK id;

	@Column(name = "AUD_FECHA_OPERACION")
	private Timestamp audFechaOperacion;

	@Column(name = "AUD_ID_OPERACION")
	private int audIdOperacion;

	@Column(name = "usuarioRegistro")
	private int audIdUsuario;

	@Column(name = "ipRegistro")
	private String audIp;

	@Column(name = "AUD_MAC")
	private String audMac;

	@Column(name = "observacion")
	private String audObservacion;

	@Column(name = "AUD_SESSION")
	private String audSession;

	@Column(name = "cantidadPreparado")
	private int cantPreparado;

	@Column(name = "ESTADO")
	private String estado;

	@Column(name="idSituacion") 
	private String situacion;

	private PreparadoPaciente preparadoPaciente;

	private Preparado preparado;

	public PreparadoPacienteDetalle() {
	}

	public PreparadoPacienteDetallePK getId() {
		if (id == null) {
			id = new PreparadoPacienteDetallePK();
		}
		return this.id;
	}

	public void setId(PreparadoPacienteDetallePK id) {
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

	public int getCantPreparado() {
		return this.cantPreparado;
	}

	public void setCantPreparado(int cantPreparado) {
		this.cantPreparado = cantPreparado;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Preparado getPreparado() {
		return preparado;
	}

	public void setPreparado(Preparado preparado) {
		this.preparado = preparado;
	}

	public PreparadoPaciente getPreparadoPaciente() {
		return preparadoPaciente;
	}

	public void setPreparadoPaciente(PreparadoPaciente preparadoPaciente) {
		this.preparadoPaciente = preparadoPaciente;
	}

	public String getSituacion() {
		if (situacion == null) {
			situacion = new String();
		}
		return situacion;
	}

	public void setSituacion(String situacion) {
		this.situacion = situacion;
	}

}