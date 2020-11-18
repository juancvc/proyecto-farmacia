package proyect.core.entity.general;

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
 



@NamedStoredProcedureQueries(
		{
				@NamedStoredProcedureQuery(
					name="personal.buscarXNroDocumento", 
					procedureName="SP_PERSONAL_BUSCAR_X_NRO_DOCUMENTO",
					resultClasses= Personal.class,
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
						name="personal.buscarxCriterios", 
						procedureName="usp_Personal_buscarxCriterios",
						resultClasses= Personal.class,
						parameters={ 
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="apellidoPaterno", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="nombres", type=String.class)
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
						resultClasses= Personal.class,
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
	@Column(name="idPersonal")
	private String idPersonal;
	 
	@Column(name="idPersona")
	private String idPersona;

	private String apellidoPaterno;

	private String apellidoMaterno;

	private String nombres;
	
		
	public Personal() { 
	}

	public String getIdPersonal() {
		return idPersonal;
	}

	public void setIdPersonal(String idPersonal) {
		this.idPersonal = idPersonal;
	}

	public String getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

  
   
}