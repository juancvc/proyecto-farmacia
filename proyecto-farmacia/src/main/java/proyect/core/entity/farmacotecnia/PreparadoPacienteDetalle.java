package proyect.core.entity.farmacotecnia;

import java.io.Serializable;
import javax.persistence.*;



import java.sql.Timestamp;

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "preparadoPacienteDetalle.insert", procedureName = "SP_PREPARADO_PACIENTE_DETALLE_INSERTAR", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "ID_PREPARADO_PACIENTE_DETALLE", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_ORGANIZACION_PREPARADO_PACIENTE_DETALLE", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_INSTITUCION_PREPARADO_PACIENTE_DETALLE", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_SEDE_PREPARADO_PACIENTE_DETALLE", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "NRO_PERIODO_PREPARADO_PACIENTE_DETALLE", type = int.class),

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_PREPARADO_PACIENTE", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_ORGANIZACION_PREPARADO_PACIENTE", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_INSTITUCION_PREPARADO_PACIENTE", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_SEDE_PREPARADO_PACIENTE", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NRO_PERIODO_PREPARADO_PACIENTE", type = int.class),

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_ORGANIZACION_PREPARADO", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_INSTITUCION_PREPARADO", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_SEDE_PREPARADO", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NRO_VERSION_PREPARADO", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NRO_PERIODO_PREPARADO", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_PREPARADO", type = int.class),

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CANT_PREPARADO", type = int.class),

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_SITUACION", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUD_ID_USUARIO", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUD_IP", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUD_SESSION", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUD_MAC", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUD_OBSERVACION", type = String.class) }),
		
		@NamedStoredProcedureQuery(name = "preparadoPacienteDetalle.update", procedureName = "SP_PREPARADO_ACTUALIZAR", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_INSUMO", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_ORGANIZACION_INSUMO", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_INSTITUCION_INSUMO", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_SEDE_INSUMO", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NRO_VERSION_INSUMO", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NRO_PERIODO_INSUMO", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NOMBRE_CORTO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NOMBRE_LARGO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODIGO_SISMED", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODIGO_SIGA", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CONCENTRACION", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_SITUACION", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUD_ID_USUARIO", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUD_IP", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUD_SESSION", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUD_MAC", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUD_OBSERVACION", type = String.class) }

		), @NamedStoredProcedureQuery(name = "preparadoPacienteDetalle.delete", procedureName = "[dbo].[SP_PREPARADO_PACIENTE_DETALLE_ELIMINAR] ",
				parameters = {  
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_PREPARADO_PACIENTE", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_ORGANIZACION_PREPARADO_PACIENTE", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_INSTITUCION_PREPARADO_PACIENTE", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_SEDE_PREPARADO_PACIENTE", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NRO_PERIODO_PREPARADO_PACIENTE", type = int.class),

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_ORGANIZACION_PREPARADO", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_INSTITUCION_PREPARADO", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_SEDE_PREPARADO", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NRO_PERIODO_PREPARADO", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_PREPARADO", type = Integer.class), }),
		
		

		@NamedStoredProcedureQuery(name = "preparadoPacienteDetalle.findByObjectVO", procedureName = "SP_PREPARADO_BUSCAR_X_ID", resultClasses = PreparadoPaciente.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_ORGANIZACION_PREPARADO", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_INSTITUCION_PREPARADO", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_SEDE_PREPARADO", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NRO_PERIODO_PREPARADO", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_PREPARADO", type = Integer.class), }),
		
		@NamedStoredProcedureQuery(name = "preparadoPacienteDetalle.findByLikeObject", procedureName = "SP_PREPARADO_PACIENTE_DETALLE_BUSCAR_X_IDPREPARADOPACIENTE", resultClasses = PreparadoPacienteDetalle.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_ORGANIZACION_PREPARADO_PACIENTE", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_INSTITUCION_PREPARADO_PACIENTE", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_SEDE_PREPARADO_PACIENTE", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NRO_PERIODO_PREPARADO_PACIENTE", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_PREPARADO_PACIENTE", type = int.class) }) }

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

	@Column(name = "AUD_ID_USUARIO")
	private int audIdUsuario;

	@Column(name = "AUD_IP")
	private String audIp;

	@Column(name = "AUD_MAC")
	private String audMac;

	@Column(name = "AUD_OBSERVACION")
	private String audObservacion;

	@Column(name = "AUD_SESSION")
	private String audSession;

	@Column(name = "CANT_PREPARADO")
	private int cantPreparado;

	@Column(name = "ESTADO")
	private String estado;

	@Column(name="ID_SITUACION") 
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