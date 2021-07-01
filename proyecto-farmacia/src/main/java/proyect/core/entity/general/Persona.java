package proyect.core.entity.general;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType; 
import org.eclipse.persistence.jpa.jpql.parser.DateTime;
  

@NamedStoredProcedureQueries(
		{
				@NamedStoredProcedureQuery(
					name="persona.buscarPorDocumento", 
					procedureName="[usp_Persona_buscarxNroDocumento]",
					resultClasses= Persona.class,
					parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="nroDocumento", type=String.class)
						}					
				),
				@NamedStoredProcedureQuery(
						name="persona.buscarPorDocumentoV2", 
						procedureName="[usp_Persona_buscarxNroDocumentoV2]",
						resultClasses= Persona.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="nroDocumento", type=String.class)
							}					
					), 
				@NamedStoredProcedureQuery(
						name="persona.buscarPorFiltros", 
						procedureName="usp_Persona_buscarxCriterios",
						resultClasses= Persona.class,
						parameters={ 
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="nroDocumento", type=String.class)
							}	
				),
				@NamedStoredProcedureQuery(
						name="persona.insertar", 
						procedureName="usp_Persona_insertar",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="idPersona", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="apellidoPaterno", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="apellidoMaterno", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="nombres", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="direccion", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="fechaNacimiento", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idTipoDocumentoCat02", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="nroDocumento", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ruc", type=String.class ), 
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idRegUbigeoDireccion", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="telefono", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="correo", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="idSexoCat02", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idNacionalidadCat01", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idEstadoCivilCat01", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioRegistro", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipRegistro", type=String.class)
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
public class Persona   implements Serializable {
	private static final long serialVersionUID = 1L;

	//@EmbeddedId
	//private PersonaPK id;
	@Id
	@Column(name="idPersona")
	private String idPersona;
	
	@Column(name="apellidoPaterno")
	private String apellidoPaterno;

	@Column(name="apellidoMaterno")
	private String apellidoMaterno;

	@Column(name="nombres")
	private String nombres;
	
	@Column(name="idTipoDocumentoCat02")
	private String idTipoDocumento;
	
	@Column(name="nroDocumento")
	private String nroDocumento;
	
	@Column(name="idSexoCat02")
	private String idSexo;
	 
	@Column(name="fechaNacimiento")
	private Timestamp fechaNacimiento;
	
	@Column(name="idNacionalidadCat01")
	private String idNacionalidad;
	
	@Column(name="idEstadoCivilCat01")
	private String idEstadoCivil;
	
	@Column(name="ruc")
	private String ruc;
	
	@Column(name="idRegUbigeoDireccion")
	private String idRegUbigeoDireccion;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="correo")
	private String correo;
	
	@Column(name="usuarioRegistro")
	private String usuarioRegistro;
	
	@Column(name="codPersoSigeho")
	private String codPersoSigeho;
	
	public String getIdEstadoCivil() {
		return idEstadoCivil;
	}

	public void setIdEstadoCivil(String idEstadoCivil) {
		this.idEstadoCivil = idEstadoCivil;
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

	public String getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(String idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getIdSexo() {
		return idSexo;
	}

	public void setIdSexo(String idSexo) {
		this.idSexo = idSexo;
	}

	public Timestamp getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Timestamp fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getIdNacionalidad() {
		return idNacionalidad;
	}

	public void setIdNacionalidad(String idNacionalidad) {
		this.idNacionalidad = idNacionalidad;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getIdRegUbigeoDireccion() {
		return idRegUbigeoDireccion;
	}

	public void setIdRegUbigeoDireccion(String idRegUbigeoDireccion) {
		this.idRegUbigeoDireccion = idRegUbigeoDireccion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public String getCodPersoSigeho() {
		return codPersoSigeho;
	}

	public void setCodPersoSigeho(String codPersoSigeho) {
		this.codPersoSigeho = codPersoSigeho;
	}
}