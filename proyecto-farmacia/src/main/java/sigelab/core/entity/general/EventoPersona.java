package sigelab.core.entity.general;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity; 
import javax.persistence.JoinColumn;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;  

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
						resultClasses= EventoPersona.class,
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
						resultClasses= EventoPersona.class,
						parameters={
									//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_DOCUMENTO", type=String.class)
							}					
					),
					@NamedStoredProcedureQuery(
							name="eventoPersona.findByObjectVO", 
							procedureName="SP_EVENTO_PERSONA_BUSCAR_X_ID",
							resultClasses= EventoPersona.class,
							parameters={
										//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_EVENTO", type=Long.class)
								}					
						),
					@NamedStoredProcedureQuery(
							name="eventoPersona.buscarConsumoXid", 
							procedureName="SP_EVENTO_PERSONA_BUSCAR_CONSUMO_X_ID",
							resultClasses= EventoPersona.class,
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
public class EventoPersona {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private EventoPersonaPK id;

	@Column(name="MONTO_CREDITO_ASIGNADO")
	private Double montoCreditoAsignado;

	@Column(name="MONTO_CREDITO_ACTUAL")
	private Double montoCreditoActual;

	@Column(name="ID_MODALIDAD_PAGO")
	private String modalidadPago;
	 
	//private Persona persona;
	
	//private Paciente paciente;
	
	@Column(name="ID_PROGRAMA")
	private String idPrograma;
	
	@Column(name="ID_TIPO_SEGURO")
	private String tipoSeguro ;
	
	/**@Column(name="ID_ORGANIZACION_EVENTO_PERSONA")
	private int idOrganizacionEventoPersona;
	
	@Column(name="ID_INSTITUCION_EVENTO_PERSONA")
	private int idInstitucionEventoPersona;
	
	@Column(name="ID_SEDE_EVENTO_PERSONA")
	private int idSedeEventoPersona;
	
	@Column(name="NRO_VERSION_EVENTO_PERSONA")
	private int nroVersionEventoPersona;
	
	@Column(name="NRO_PERIODO_EVENTO_PERSONA")
	private int nroPeriodoEventoPersona;
	*/
	
	public EventoPersona() { 
	}

	public EventoPersonaPK getId() {
		return id;
	}

	public void setId(EventoPersonaPK id) {
		this.id = id;
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

	public String getModalidadPago() {
		return modalidadPago;
	}

	public void setModalidadPago(String modalidadPago) {
		this.modalidadPago = modalidadPago;
	}
 

	public String getTipoSeguro() {
		return tipoSeguro;
	}

	public void setTipoSeguro(String tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}
 
 
	 

}