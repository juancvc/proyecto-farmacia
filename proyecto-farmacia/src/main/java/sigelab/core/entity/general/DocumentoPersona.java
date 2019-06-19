package pe.com.galaxy.systems.apolo.core.entidad.entidad.general;
      
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import pe.com.galaxy.systems.apolo.core.entidad.GenericEntity;
@NamedStoredProcedureQueries(
		{
				
				@NamedStoredProcedureQuery(
						name="documento_Persona.findByObject", 
						procedureName="PKG_TIPO_ARTICULO.SP_BUSCAR_X_ID",
						resultClasses= DocumentoPersona.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_ID_TIPO_ARTICULO", type=Long.class)
							}					
					),
				@NamedStoredProcedureQuery(
						name="documento_Persona.findByLikeObject", 
						procedureName="PKG_TIPO_ARTICULO.SP_BUSCAR_X_CRITERIOS",
						resultClasses= DocumentoPersona.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_TIPO_DOCUMENTO_PER", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_NOMBRE_LARGO", type=String.class)
							}	
				),
				
				@NamedStoredProcedureQuery(
						name="documento_Persona.insert", 
						procedureName="PKG_TIPO_ARTICULO.SP_INSERTAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="P_ID_TIPO_ARTICULO", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_NOMBRE_CORTO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_NOMBRE_LARGO", type=String.class),
									
									@StoredProcedureParameter(mode=ParameterMode.IN, name="P_ID_SITUACION", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="P_AUD_ID_USUARIO", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_AUD_IP", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_AUD_SESSION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_AUD_ID_OPERACION", type=Long.class)
							}					
				),
				@NamedStoredProcedureQuery(
						name="documento_Persona.update", 
						procedureName="PKG_TIPO_ARTICULO.SP_ACTUALIZAR",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="P_ID_TIPO_ARTICULO", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="P_NOMBRE_CORTO", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="P_NOMBRE_LARGO", type=String.class),
								
								@StoredProcedureParameter(mode=ParameterMode.IN, name="P_ID_SITUACION", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="P_AUD_ID_USUARIO", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="P_AUD_IP", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="P_AUD_SESSION", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="P_AUD_ID_OPERACION", type=Long.class)
						}					
										
				),
				@NamedStoredProcedureQuery(
						name="documento_Persona.delete", 
						procedureName="PKG_TIPO_ARTICULO.SP_ELIMINAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="P_ID_TIPO_ARTICULO", type=Long.class )
							}					
				)
		
		}
	)
@Entity
@Table(name="DOCUMENTO_PERSONA")
public class DocumentoPersona extends GenericEntity{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_DOCUMENTO_PERSONA")
	private long idDocumentoPersona;

	@Column(name="NRO_DOCUMENTO")
	private String numeroDocumento;

	//bi-directional many-to-one association to tipo documento persona
	@ManyToOne
	@JoinColumn(name="ID_TIPO_DOCUMENTO_PER")
	private TipoDocumentoPersona tipoDocumentoPersona;
	
	//bi-directional many-to-one association to Persona 
	private Persona persona;
		
	public DocumentoPersona() {
		this.setTipoDocumentoPersona(new TipoDocumentoPersona());
	}
	
	//@OneToMany(mappedBy="DOCUMENTO_PERSONA")
	
	public long getIdDocumentoPersona() {
		return idDocumentoPersona;
	}


	public void setIdDocumentoPersona(long idDocumentoPersona) {
		this.idDocumentoPersona = idDocumentoPersona;
	}


	public String getNumeroDocumento() {
		return numeroDocumento;
	}


	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}


	public TipoDocumentoPersona getTipoDocumentoPersona() {
		return tipoDocumentoPersona;
	}


	public void setTipoDocumentoPersona(TipoDocumentoPersona tipoDocumentoPersona) {
		this.tipoDocumentoPersona = tipoDocumentoPersona;
	}


	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}


	@Override
	public String toString() {
		return "DOCUMENTO_PERSONA [idDocumentoPersona=" + idDocumentoPersona + 
				", numeroDocumento=" + numeroDocumento
				;
	}

}
