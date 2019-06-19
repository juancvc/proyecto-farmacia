package pe.com.galaxy.systems.apolo.core.entidad.entidad.general;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import pe.com.galaxy.systems.apolo.core.entidad.vo.general.PersonalGiseVO;
import pe.com.galaxy.systems.apolo.core.entidad.vo.general.PersonalVO;



@NamedStoredProcedureQueries(
		{
				@NamedStoredProcedureQuery(
					name="personal.buscarXNroDocumento", 
					procedureName="SP_PERSONAL_BUSCAR_X_NRO_DOCUMENTO",
					resultClasses= PersonalVO.class,
					parameters={
							//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="NRO_DOCUMENTO", type=String.class)
						}					
				),
				
				@NamedStoredProcedureQuery(
						name="personal.findByObject", 
						procedureName="SP_PERSONAL_BUSCAR_X_ID",
						resultClasses= Personal.class,
						parameters={
								//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_PERSONA", type=Long.class)
							}					
					),
				@NamedStoredProcedureQuery(
						name="personal.findByLikeObjectVO", 
						procedureName="SP_PERSONAL_BUSCAR_X_CRITERIOS",
						resultClasses= PersonalVO.class,
						parameters={
									//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="APELLIDO_PATERNO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="PRIMER_NOMBRE", type=String.class)
							}	
				),
				@NamedStoredProcedureQuery(
						name="personal.insert", 
						procedureName="SP_PERSONAL_INSERTAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="ID_PERSONA", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="APELLIDO_PATERNO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="APELLIDO_MATERNO", type=String.class),
									
									@StoredProcedureParameter(mode=ParameterMode.IN, name="PRIMER_NOMBRE", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="SEGUNDO_NOMBRE", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_TIPO_PERSONA", type=Long.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="DIRECCION", type=String.class)
							}					
				),
				
				@NamedStoredProcedureQuery(
						name="personal.update", 
						procedureName="SP_PERSONAL_ACTUALIZAR",
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
						name="personal.eliminar", 
						procedureName="[Farmacia].[dbo].[SP_PERSONAL_ELIMINAR]",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_PERSONAL", type=int.class )
							}					
				),
				@NamedStoredProcedureQuery(
						name="personal.listarPersonalGise", 
						procedureName="[Farmacia].[dbo].[SP_PERSONAL_BUSCAR_X_CRITERIOS_GISE]",
						resultClasses= PersonalGiseVO.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="APEPATER", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="APEMATER", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="PRINOMBR", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="NRODOCUM", type=String.class )
							}					
				)				
		   }
		)
@Entity
@Table(name="PERSONAL")
public class Personal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PERSONAL")
	private long idPersonal;
	 
	private Persona persona;

	
	//Bib-directional many-to-one association to document
/*	@ManyToOne
	@JoinColumn(name="ID_DOCUMENTO_PERSONA")
	private DocumentoPersona documentoPersona;
	*/	

	//private 
		
	public Personal() {
		this.setPersona(new Persona());
		//this.setDocumento_Persona(new DocumentoPersona());
	}


	public long getIdPersonal() {
		return idPersonal;
	}


	public void setIdPersonal(long idPersonal) {
		this.idPersonal = idPersonal;
	}


	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}
   
}