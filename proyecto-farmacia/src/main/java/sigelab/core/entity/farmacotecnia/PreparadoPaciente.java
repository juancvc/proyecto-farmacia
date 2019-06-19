package sigelab.core.entity.farmacotecnia;

import java.io.Serializable;
import javax.persistence.*; 


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List; 


@NamedStoredProcedureQueries(
		{
			@NamedStoredProcedureQuery(
					name="preparadoPaciente.insert", 
					procedureName="SP_PREPARADO_PACIENTE_INSERTAR",
					parameters={
								@StoredProcedureParameter(mode=ParameterMode.OUT, name="ID_PREPARADO_PACIENTE", type=Integer.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION_PREPARADO_PACIENTE", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION_PREPARADO_PACIENTE", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE_PREPARADO_PACIENTE", type=int.class ), 
								@StoredProcedureParameter(mode=ParameterMode.OUT, name="NRO_PERIODO_PREPARADO_PACIENTE", type=int.class ), 
								
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION_PERSONA", type=int.class ), 
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION_PERSONA", type=int.class ), 
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE_PERSONA", type=int.class ), 
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_VERSION_PERSONA", type=int.class ), 
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO_PERSONA", type=int.class ), 
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_PERSONA", type=int.class ), 
								
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION_EVENTO_PERSONA", type=int.class ), 
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION_EVENTO_PERSONA", type=int.class ), 
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE_EVENTO_PERSONA", type=int.class ), 
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_VERSION_EVENTO_PERSONA", type=int.class ), 
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO_EVENTO_PERSONA", type=int.class ), 
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_EVENTO_PERSONA", type=int.class ),
								
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="OBSERVACION", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="FECHA_ENTREGA", type=Timestamp.class), 
								
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SITUACION", type=int.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_USUARIO", type=Integer.class),								
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class), 
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_MAC", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_OBSERVACION", type=String.class)
						}					
			),
			@NamedStoredProcedureQuery(
					name="preparadoPaciente.update", 
					procedureName="[dbo].[SP_PREPARADO_PACIENTE_UPDATE]",
					parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_PREPARADO_PACIENTE", type=Integer.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION_PREPARADO_PACIENTE", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION_PREPARADO_PACIENTE", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE_PREPARADO_PACIENTE", type=int.class ), 
							@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO_PREPARADO_PACIENTE", type=int.class ), 
							
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="OBSERVACION", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="FECHA_ENTREGA", type=Timestamp.class), 
							
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SITUACION", type=int.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_USUARIO", type=Integer.class),								
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class), 
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_MAC", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_OBSERVACION", type=String.class)
					}					
									
			),
			@NamedStoredProcedureQuery(
					name="preparadoPaciente.delete", 
					procedureName="[SP_PREPARADO_PACIENTE_DELETE]",
					parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_PREPARADO_PACIENTE", type=Integer.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION_PREPARADO_PACIENTE", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION_PREPARADO_PACIENTE", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE_PREPARADO_PACIENTE", type=int.class ), 
							@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO_PREPARADO_PACIENTE", type=int.class ), 
							 
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_USUARIO", type=Integer.class),								
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class), 
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_MAC", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_OBSERVACION", type=String.class)
						}					
			),
	 
			    @NamedStoredProcedureQuery(
						name="preparadoPaciente.findByObjectVO", 
						procedureName="SP_PREPARADO_BUSCAR_X_ID",
						resultClasses= PreparadoPaciente.class,
						parameters={ 
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION_PREPARADO", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION_PREPARADO", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE_PREPARADO", type=int.class ), 
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO_PREPARADO", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_PREPARADO", type=Integer.class ),
							}					
					),
				@NamedStoredProcedureQuery(
						name="preparadoPaciente.findByLikeObject", 
						procedureName="SP_PREPARADO_PACIENTE_BUSCAR_X_CRITERIOS",
						resultClasses= PreparadoPaciente.class,
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION_PREPARADO_PACIENTE", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION_PREPARADO_PACIENTE", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE_PREPARADO_PACIENTE", type=int.class ) ,
								@StoredProcedureParameter(mode=ParameterMode.IN, name="FECHA_ENTREGA_DESDE", type=Timestamp.class ) ,
								@StoredProcedureParameter(mode=ParameterMode.IN, name="FECHA_ENTREGA_HASTA", type=Timestamp.class ) ,
								@StoredProcedureParameter(mode=ParameterMode.IN, name="TIPO", type=int.class ) 
							}	
				) 
		}
				
	)
@Entity
@Table(name="PREPARADO_PACIENTE")
@NamedQuery(name="PreparadoPaciente.findAll", query="SELECT p FROM PreparadoPaciente p")
public class PreparadoPaciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PreparadoPacientePK id;

//	private Persona persona;
	
//	private EventoPersona EventoPersona;
	
	@OneToMany(mappedBy="preparadoPaciente")
	private List<PreparadoPacienteDetalle> itemPreparadoPacienteDetalle;
	
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

	@Column(name="OBSERVACION")
	private String observacion;

	@Column(name="ESTADO")
	private String estado;

	@Column(name="FECHA_ENTREGA")
	private Timestamp fechaEntrega;
     
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "ID_SITUACION", referencedColumnName = "ID_SITUACION", insertable = false, updatable = false)
	})
	private String situacion;

	private Timestamp fechaEntregaDesde;
	private Timestamp fechaEntregaHasta;
	private int tipo;

	public PreparadoPaciente() {
	}

	public PreparadoPacientePK getId() {
		if (id == null) {
			id = new PreparadoPacientePK();
		}
		return this.id;
	}

	public void setId(PreparadoPacientePK id) {
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
/*
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public EventoPersona getEventoPersona() {
		if (EventoPersona == null) {
			EventoPersona = new EventoPersona();
		}
		return EventoPersona;
	}

	public void setEventoPersona(EventoPersona eventoPersona) {
		EventoPersona = eventoPersona;
	}*/

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Timestamp getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Timestamp fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
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

	public List<PreparadoPacienteDetalle> getItemPreparadoPacienteDetalle() {
		if (itemPreparadoPacienteDetalle == null) {
			itemPreparadoPacienteDetalle = new ArrayList<PreparadoPacienteDetalle>();
		} 
		return itemPreparadoPacienteDetalle;
	}

	public void setItemPreparadoPacienteDetalle(List<PreparadoPacienteDetalle> itemPreparadoPacienteDetalle) {
		this.itemPreparadoPacienteDetalle = itemPreparadoPacienteDetalle;
	}
	public PreparadoPacienteDetalle addVentaItem(PreparadoPacienteDetalle preparadoInsumo) {
		getItemPreparadoPacienteDetalle().add(preparadoInsumo);
		preparadoInsumo.setPreparadoPaciente(this);

		return preparadoInsumo;
	}

	public PreparadoPacienteDetalle removePreparadoPacienteDetalle(PreparadoPacienteDetalle preparadoInsumo) {
		getItemPreparadoPacienteDetalle().remove(preparadoInsumo);
		preparadoInsumo.setPreparado(null);

		return preparadoInsumo;
	}

	public Timestamp getFechaEntregaDesde() {
		return fechaEntregaDesde;
	}

	public void setFechaEntregaDesde(Timestamp fechaEntregaDesde) {
		this.fechaEntregaDesde = fechaEntregaDesde;
	}

	public Timestamp getFechaEntregaHasta() {
		return fechaEntregaHasta;
	}

	public void setFechaEntregaHasta(Timestamp fechaEntregaHasta) {
		this.fechaEntregaHasta = fechaEntregaHasta;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "PreparadoPaciente [id=" + id + ", itemPreparadoPacienteDetalle=" + itemPreparadoPacienteDetalle
				+ ", audFechaOperacion=" + audFechaOperacion + ", audIdOperacion=" + audIdOperacion + ", audIdUsuario="
				+ audIdUsuario + ", audIp=" + audIp + ", audMac=" + audMac + ", audObservacion=" + audObservacion
				+ ", audSession=" + audSession + ", observacion=" + observacion + ", estado=" + estado
				+ ", fechaEntrega=" + fechaEntrega + ", situacion=" + situacion + ", fechaEntregaDesde="
				+ fechaEntregaDesde + ", fechaEntregaHasta=" + fechaEntregaHasta + ", tipo=" + tipo + "]";
	}



	 
}