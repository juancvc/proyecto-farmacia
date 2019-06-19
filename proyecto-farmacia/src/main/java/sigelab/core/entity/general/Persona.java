package pe.com.galaxy.systems.apolo.core.entidad.entidad.general;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import pe.com.galaxy.systems.apolo.core.entidad.GenericEntity;
import pe.com.galaxy.systems.apolo.core.entidad.vo.general.PacienteVO;
import pe.com.galaxy.systems.apolo.core.entidad.vo.general.PersonalGiseVO;


@NamedStoredProcedureQueries(
		{
				@NamedStoredProcedureQuery(
					name="persona.buscarXTipoYNroDocumento", 
					procedureName="PKG_PERSONA.SP_BUSCAR_X_TIPO_NRO_DOCUMENTO",
					resultClasses= Persona.class,
					parameters={
							//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_C_CURSOR", type=void.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_ID_TIPO_DOCUMENTO_PER", type=Long.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_NRO_DOCUMENTO", type=String.class)
						}					
				),
				
				@NamedStoredProcedureQuery(
						name="persona.findByObject", 
						procedureName="PKG_PERSONA.SP_BUSCAR_X_ID",
						resultClasses= Persona.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_ID_PERSONA", type=Long.class)
							}					
					),
				@NamedStoredProcedureQuery(
						name="persona.findByLikeObject", 
						procedureName="PKG_PERSONA.SP_BUSCAR_X_CRITERIOS",
						resultClasses= Persona.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_APELLIDO_PATERNO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_PRIMER_NOMBRE", type=String.class)
							}	
				),
				@NamedStoredProcedureQuery(
						name="persona.insertar", 
						procedureName="[Farmacia].[dbo].[SP_PERSONAL_INSERTAR]",
						parameters={
//									@StoredProcedureParameter(mode=ParameterMode.OUT, name="ID_PERSONA", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ORGANIZACION", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_INSTITUCION", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SEDE", type=int.class),

									
									@StoredProcedureParameter(mode=ParameterMode.IN, name="APELLIDO_PATERNO", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="APELLIDO_MATERNO", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="PRIMER_NOMBRE", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="SEGUNDO_NOMBRE", type=String.class),
									

									@StoredProcedureParameter(mode=ParameterMode.IN, name="FECHA_NACIMIENTO", type=Date.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SEXO", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="DIRECCION", type=String.class),
									
									@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_DOCUMENTO", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="RUC", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SITUACION", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_MAC", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_IP", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_USUARIO", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_OBSERVACION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NRO_COLEGIATURA", type=String.class)
							}					
				),
				
				@NamedStoredProcedureQuery(
						name="persona.modificar", 
						procedureName="[Farmacia].[dbo].[SP_PERSONAL_MODIFICAR]",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_PERSONA", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ORGANIZACION", type=int.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_INSTITUCION", type=int.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SEDE", type=int.class),
								
								@StoredProcedureParameter(mode=ParameterMode.IN, name="APELLIDO_PATERNO", type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="APELLIDO_MATERNO", type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="PRIMER_NOMBRE", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="SEGUNDO_NOMBRE", type=String.class),								
								@StoredProcedureParameter(mode=ParameterMode.IN, name="FECHA_NACIMIENTO", type=Date.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SEXO", type=int.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="DIRECCION", type=String.class),
								
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_DOCUMENTO", type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="RUC", type=String.class ),
								
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SITUACION", type=int.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_MAC", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_IP", type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_USUARIO", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_OBSERVACION", type=String.class)
						}					
										
				),

				@NamedStoredProcedureQuery(
						name="persona.delete", 
						procedureName="PKG_PERSONA.SP_ELIMINAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="P_ID_PERSONA", type=Long.class )
							}					
				),
				@NamedStoredProcedureQuery(
						name="persona.buscarXNroDocumento", 
						procedureName="[dbo].[SP_PERSONA_BUSCAR_X_NRO_DOCUMENTO]",
						resultClasses= Persona.class,
						parameters={
								//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_C_CURSOR", type=void.class ), 
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ORGANIZACION", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_INSTITUCION", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SEDE", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NRO_DOCUMENTO", type=String.class)
							}					
					),
				@NamedStoredProcedureQuery(
						name="persona.insertPersonaGise", 
						procedureName="[dbo].[SP_PERSONA_INSERTAR]",
						parameters={
								
									@StoredProcedureParameter(mode=ParameterMode.OUT,  name="CodigoPersona", type=Long.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="CodigoOrganizacion", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="CodigoInstitucion", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="CodigoSede", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ApellidoPaterno", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ApellidoMaterno", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="SegundoNombre", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="PrimerNombre", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="CodigoTipoDocumento", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="DetalleDocumento", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="CodigoSexo", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="FechaNacimiento", type=Date.class)
							}					
					)					
					
		   }
		)
@Entity
@Table(name="PERSONA")
public class Persona extends GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PersonaPK id;

	@Column(name="DIRECCION")
	private String direccion;

	@Column(name="APELLIDO_PATERNO")
	private String apellido_paterno;

	@Column(name="APELLIDO_MATERNO")
	private String apellido_materno;
	
	@Column(name="PRIMER_NOMBRE")
	private String primer_nombre;
	
	@Column(name="SEGUNDO_NOMBRE")
	private String segundo_nombre;
	
	@Column(name="NRO_DOCUMENTO")
	private String numeroDocumento;
	 
	@Column(name="FECHA_NACIMIENTO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaNacimiento;
	
	@Column(name="RUC")
	private String ruc;
	
	@Column(name="ID_TIPO_PERSONA")
	private int tipoPersona;
	
	//Bib-directional many-to-one association to document
/*	@ManyToOne
	@JoinColumn(name="ID_DOCUMENTO_PERSONA")
	private DocumentoPersona documentoPersona;
	*/	

	//private 

	@Column(name="ID_SEXO")
	private int idSexo;
	
	@Column(name="ID_SITUACION")
	private int idSituacion;

	
	@Column(name="AUD_ID_USUARIO")
	private int audIdUsuario;
	
	
	private int idTipoDocumento;
	
	/*@Column(name="NRO_COLEGIATURA")
	private String nroColegiatura;
	*/	
	public Persona() {
		//this.setDocumento_Persona(new DocumentoPersona());
	}
   public String getNombreCompleto(){
	   String nombreCompleto = null;	
		if (nombreCompleto == null) {
			nombreCompleto = 	this.getApellido_paterno()+ "  "+
					   this.getApellido_materno()+ ",  "+
					   this.getPrimer_nombre()+ "  "+
					   this.getSegundo_nombre(); 
		}
		return nombreCompleto;
	}

 
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getApellido_paterno() {
		return apellido_paterno;
	}

	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}

	public String getApellido_materno() {
		return apellido_materno;
	}

	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}

	public String getPrimer_nombre() {
		return primer_nombre;
	}

	public void setPrimer_nombre(String primer_nombre) {
		this.primer_nombre = primer_nombre;
	}

	public String getSegundo_nombre() {
		return segundo_nombre;
	}

	public void setSegundo_nombre(String segundo_nombre) {
		this.segundo_nombre = segundo_nombre;
	}
	
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	} 
	 
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	
	public Situacion getSituacion() {
		return situacion;
	}
	public void setSituacion(Situacion situacion) {
		this.situacion = situacion;
	}
	public int getAudIdUsuario() {
		return audIdUsuario;
	}
	public void setAudIdUsuario(int audIdUsuario) {
		this.audIdUsuario = audIdUsuario;
	}
		
	/*public String getNroColegiatura() {
		return nroColegiatura;
	}
	public void setNroColegiatura(String nroColegiatura) {
		this.nroColegiatura = nroColegiatura;
	}
	*/	
	public int getIdSexo() {
		return idSexo;
	}
	public void setIdSexo(int idSexo) {
		this.idSexo = idSexo;
	}

	public int getIdSituacion() {
		return idSituacion;
	}
	public void setIdSituacion(int idSituacion) {
		this.idSituacion = idSituacion;
	}
	
	public int getTipoPersona() {
		return tipoPersona;
	}
	public void setTipoPersona(int tipoPersona) {
		this.tipoPersona = tipoPersona;
	}
	public PersonaPK getId() {
		if (id == null) {
			id = new PersonaPK();
		}
		return id;
	}
	public void setId(PersonaPK id) {
		this.id = id;
	}
	
	public int getIdTipoDocumento() {
		return idTipoDocumento;
	}
	public void setIdTipoDocumento(int idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}
	@Override
	public String toString() {
		return "Persona [id=" + id + ", direccion=" + direccion + ", apellido_paterno=" + apellido_paterno
				+ ", apellido_materno=" + apellido_materno + ", primer_nombre=" + primer_nombre + ", segundo_nombre="
				+ segundo_nombre + ", numeroDocumento=" + numeroDocumento + ", fechaNacimiento=" + fechaNacimiento
				+ ", ruc=" + ruc + ", tipoPersona=" + tipoPersona + ", idSexo=" + idSexo + ", idSituacion="
				+ idSituacion + ", audIdUsuario=" + audIdUsuario  + "]";
	}
	 
}