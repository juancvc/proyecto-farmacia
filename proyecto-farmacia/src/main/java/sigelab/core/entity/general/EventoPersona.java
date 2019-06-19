package pe.com.galaxy.systems.apolo.core.entidad.entidad.general;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity; 
import javax.persistence.JoinColumn;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table; 
import pe.com.galaxy.systems.apolo.core.entidad.GenericEntity;
import pe.com.galaxy.systems.apolo.core.entidad.entidad.venta.ModalidadPago;
import pe.com.galaxy.systems.apolo.core.entidad.entidad.venta.TipoSeguro;
import pe.com.galaxy.systems.apolo.core.entidad.vo.general.EventoPersonaConsumoVO;
import pe.com.galaxy.systems.apolo.core.entidad.vo.general.EventoPersonaVO;
@NamedStoredProcedureQueries(
		{
				
				@NamedStoredProcedureQuery(
						name="eventoPersona.findByObject", 
						procedureName="SP_EVENTO_PERSONA_BUSCAR_X_ID",
						resultClasses= EventoPersona.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ALMACEN", type=Long.class)
							}					
					),
				@NamedStoredProcedureQuery(
						name="eventoPersona.findByLikeObject", 
						procedureName="SP_EVENTO_PERSONA_BUSCAR_X_CRITERIOS",
						resultClasses= EventoPersonaVO.class,
						parameters={
									//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_DOCUMENTO", type=String.class)
							}	
				),
				
				@NamedStoredProcedureQuery(
						name="eventoPersona.insert", 
						procedureName="SP_EVENTO_PERSONA_INSERTAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="ID_ALMACEN", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_CORTO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_LARGO", type=String.class),
									
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SITUACION", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_USUARIO", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_OPERACION", type=Long.class)
							}					
				),
				@NamedStoredProcedureQuery(
						name="eventoPersona.update", 
						procedureName="SP_EVENTO_PERSONA_ACTUALIZAR",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ALMACEN", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NOMBRE_CORTO", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NOMBRE_LARGO", type=String.class),
								
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SITUACION", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_USUARIO", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_IP", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_SESSION", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_OPERACION", type=Long.class)
						}					
										
				),
				@NamedStoredProcedureQuery(
						name="eventoPersona.delete", 
						procedureName="SP_EVENTO_PERSONA_ELIMINAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ALMACEN", type=Long.class )
							}					
				),
				@NamedStoredProcedureQuery(
						name="eventoPersona.buscarXnroDocumento", 
						procedureName="SP_EVENTO_PERSONA_FIND_BY_NRO_DOCUMENTO",
						resultClasses= EventoPersonaVO.class,
						parameters={
									//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_DOCUMENTO", type=String.class)
							}					
					),
					@NamedStoredProcedureQuery(
							name="eventoPersona.findByObjectVO", 
							procedureName="SP_EVENTO_PERSONA_BUSCAR_X_ID",
							resultClasses= EventoPersonaVO.class,
							parameters={
										//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_EVENTO", type=Long.class)
								}					
						),
					@NamedStoredProcedureQuery(
							name="eventoPersona.buscarConsumoXid", 
							procedureName="SP_EVENTO_PERSONA_BUSCAR_CONSUMO_X_ID",
							resultClasses= EventoPersonaConsumoVO.class,
							parameters={
										//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ORGANIZACION", type=int.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_INSTITUCION", type=int.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SEDE", type=int.class),
										
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_EVENTO", type=int.class),
										
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ORGANIZACION_PERSONA", type=int.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_INSTITUCION_PERSONA", type=int.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SEDE_PERSONA", type=int.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="NRO_PERIODO_PERSONA", type=int.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_PERSONA", type=int.class)
								}					
						)
		
		}
	)
@Entity
@Table(name="EVENTO_PERSONA")
public class EventoPersona 
	extends GenericEntity{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private EventoPersonaPK id;

	@Column(name="MONTO_CREDITO_ASIGNADO")
	private Double montoCreditoAsignado;

	@Column(name="MONTO_CREDITO_ACTUAL")
	private Double montoCreditoActual;

	@JoinColumn(name="ID_MODALIDAD_PAGO")
	private ModalidadPago modalidadPago;
	 
	private Persona persona;
	
	private Paciente paciente;
	
	@JoinColumn(name="ID_PROGRAMA")
	private Programas programa;
	
	@JoinColumn(name="ID_TIPO_SEGURO")
	private TipoSeguro tipoSeguro ;
	
	@Column(name="ID_ORGANIZACION_EVENTO_PERSONA")
	private int idOrganizacionEventoPersona;
	
	@Column(name="ID_INSTITUCION_EVENTO_PERSONA")
	private int idInstitucionEventoPersona;
	
	@Column(name="ID_SEDE_EVENTO_PERSONA")
	private int idSedeEventoPersona;
	
	@Column(name="NRO_VERSION_EVENTO_PERSONA")
	private int nroVersionEventoPersona;
	
	@Column(name="NRO_PERIODO_EVENTO_PERSONA")
	private int nroPeriodoEventoPersona;
	
	public EventoPersona() {
		this.setPersona(new Persona());
		this.setModalidadPago(new ModalidadPago());
		this.setTipoSeguro(new TipoSeguro());
	}
 

	public Double getMontoCreditoAsignado() {
		return montoCreditoAsignado;
	}

	public void setMontoCreditoAsignado(Double montoCreditoAsignado) {
		this.montoCreditoAsignado = montoCreditoAsignado;
	}

	public Double getMontoCreditoActual() {
		return montoCreditoActual;
	}

	public void setMontoCreditoActual(Double montoCreditoActual) {
		this.montoCreditoActual = montoCreditoActual;
	}

	public ModalidadPago getModalidadPago() {
		return modalidadPago;
	}

	public void setModalidadPago(ModalidadPago modalidadPago) {
		this.modalidadPago = modalidadPago;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Programas getPrograma() {
		return programa;
	}

	public void setPrograma(Programas programa) {
		this.programa = programa;
	}

	public TipoSeguro getTipoSeguro() {
		return tipoSeguro;
	}

	public void setTipoSeguro(TipoSeguro tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}

	public int getIdOrganizacionEventoPersona() {
		return idOrganizacionEventoPersona;
	}

	public void setIdOrganizacionEventoPersona(int idOrganizacionEventoPersona) {
		this.idOrganizacionEventoPersona = idOrganizacionEventoPersona;
	}

	public int getIdInstitucionEventoPersona() {
		return idInstitucionEventoPersona;
	}

	public void setIdInstitucionEventoPersona(int idInstitucionEventoPersona) {
		this.idInstitucionEventoPersona = idInstitucionEventoPersona;
	}

	public int getIdSedeEventoPersona() {
		return idSedeEventoPersona;
	}

	public void setIdSedeEventoPersona(int idSedeEventoPersona) {
		this.idSedeEventoPersona = idSedeEventoPersona;
	}

	public int getNroVersionEventoPersona() {
		return nroVersionEventoPersona;
	}

	public void setNroVersionEventoPersona(int nroVersionEventoPersona) {
		this.nroVersionEventoPersona = nroVersionEventoPersona;
	}

	public int getNroPeriodoEventoPersona() {
		return nroPeriodoEventoPersona;
	}

	public void setNroPeriodoEventoPersona(int nroPeriodoEventoPersona) {
		this.nroPeriodoEventoPersona = nroPeriodoEventoPersona;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}


	public EventoPersonaPK getId() {
		if (id == null) {
			id = new EventoPersonaPK();
		}
		return id;
	}


	public void setId(EventoPersonaPK id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "EventoPersona [id=" + id + ", montoCreditoAsignado=" + montoCreditoAsignado + ", montoCreditoActual="
				+ montoCreditoActual + ", modalidadPago=" + modalidadPago + ", persona=" + persona + ", paciente="
				+ paciente + ", programa=" + programa + ", tipoSeguro=" + tipoSeguro + ", idOrganizacionEventoPersona="
				+ idOrganizacionEventoPersona + ", idInstitucionEventoPersona=" + idInstitucionEventoPersona
				+ ", idSedeEventoPersona=" + idSedeEventoPersona + ", nroVersionEventoPersona="
				+ nroVersionEventoPersona + ", nroPeriodoEventoPersona=" + nroPeriodoEventoPersona + "]";
	}


}