package pe.com.galaxy.systems.apolo.core.entidad.entidad.general;

import java.io.Serializable; 
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity; 
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table; 
import pe.com.galaxy.systems.apolo.core.entidad.vo.general.PacienteVO;



@NamedStoredProcedureQueries(
		{
				@NamedStoredProcedureQuery(
					name="paciente.buscarXNroDocumento", 
					procedureName="SP_PACIENTE_BUSCAR_X_NRO_DOCUMENTO",
					resultClasses= PacienteVO.class,
					parameters={
							//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="NRO_DOCUMENTO", type=String.class)
						}					
				),
				
				@NamedStoredProcedureQuery(
						name="paciente.findByObject", 
						procedureName="SP_PACIENTE_BUSCAR_X_ID",
						resultClasses= Paciente.class,
						parameters={
								//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_PERSONA", type=Long.class)
							}					
					),
				@NamedStoredProcedureQuery(
						name="paciente.findByLikeObjectVO", 
						procedureName="SP_PACIENTE_BUSCAR_X_CRITERIOS",
						resultClasses= PacienteVO.class,
						parameters={
									//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ORGANIZACION", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_INSTITUCION", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SEDE", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="APELLIDO_PATERNO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="PRIMER_NOMBRE", type=String.class)
							}	
				),
				@NamedStoredProcedureQuery(
						name="paciente.insert", 
						procedureName="SP_PACIENTE_INSERTAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="ID_PACIENTE", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ORGANIZACION", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_INSTITUCION", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SEDE", type=int.class),
									
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NRO_DOCUMENTO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="APELLIDO_PATERNO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="APELLIDO_MATERNO", type=String.class),									
									@StoredProcedureParameter(mode=ParameterMode.IN, name="PRIMER_NOMBRE", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="SEGUNDO_NOMBRE", type=String.class ),
									
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_TIPO_PERSONA", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SEXO", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_MAC", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_IP", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_USUARIO", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_OBSERVACION", type=String.class)
							}					
				),
				
				@NamedStoredProcedureQuery(
						name="paciente.update", 
						procedureName="SP_PACIENTE_ACTUALIZAR",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_PERSONA", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="APELLIDO_PATERNO", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="APELLIDO_MATERNO", type=String.class),
								
								@StoredProcedureParameter(mode=ParameterMode.IN, name="PRIMER_NOMBRE", type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="SEGUNDO_NOMBRE", type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_TIPO_PERSONA", type=Long.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="DIRECCION", type=String.class)
						}					
										
				),

				@NamedStoredProcedureQuery(
						name="paciente.delete", 
						procedureName="SP_PACIENTE_ELIMINAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_PERSONA", type=Long.class )
							}					
				),
				@NamedStoredProcedureQuery(
						name="paciente.buscarPorNroDocumento", 
						procedureName="[dbo].[SP_PACIENTE_BUSCAR_X_NRO_DOCUMENTO]",
								resultClasses= PacienteVO.class,//resultClasses= PacienteVO.class,
						parameters={
								//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ), 
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ORGANIZACION", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_INSTITUCION", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SEDE", type=int.class),
									
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NRO_DOCUMENTO", type=String.class)
							}					
					),
		   }
		)
@Entity
@Table(name="PACIENTE")
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PacientePK id;
	 
	private Persona persona;

	@Column(name="NUMERO_HC")
	private String numeroHC;
		
	public PacientePK getId() {
		if (id == null) {
			id = new PacientePK();
		}
		return id;
	}


	public void setId(PacientePK id) {
		this.id = id;
	}


	public String getNumeroHC() {
		return numeroHC;
	}


	public void setNumeroHC(String numeroHC) {
		this.numeroHC = numeroHC;
	}


	public Paciente() {
		this.setId(new PacientePK());
		this.setPersona(new Persona());
		//this.setDocumento_Persona(new DocumentoPersona());
	}

 
	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}


	@Override
	public String toString() {
		return "Paciente [id=" + id + ", persona=" + persona + ", numeroHC=" + numeroHC + "]";
	}
   
}