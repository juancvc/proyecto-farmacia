package hnch.referencia.core.entity.general; 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@NamedStoredProcedureQueries({

		@NamedStoredProcedureQuery(name = "pacienteReniec.verificar", procedureName = "[SIGEHOV2GENE].[dbo].[callWebServiceReniec]", resultClasses = PacienteReniec.class, parameters = {

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "dni", type = String.class)

		}) })
@Entity
public class PacienteReniec {
 

	@Column(name = "codResp")
	private String codigoRespuesta;
	@Id
	@Column(name = "nroDni")
	private String nroDni;

	@Column(name = "codVerif")
	private String codigoVerificacion;

	@Column(name = "apPater")
	private String apellidoPaterno;

	@Column(name = "apMater")
	private String apellidoMaterno;

	@Column(name = "nombres")
	private String nombres;

	@Column(name = "apCasada")
	private String condicionCasado;

	@Column(name = "fechaNac")
	private String fechaNacimiento;

	@Column(name = "nomPadre")
	private String nombrePadre;

	@Column(name = "nomMadre")
	private String nombreMadre;

	@Column(name = "sexo")
	private String sexo;
	
	@Column(name = "estCivil")
	private String estCivil;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "foto")
	private byte[] fotoPaciente;

	@Column(name = "ubiDepart")
	private String ubiDepart;
	
	@Column(name = "ubiProv")
	private String ubiProv;
	
	@Column(name = "ubiDist")
	private String ubiDist;
	
	@Column(name = "ubiDepNac")
	private String ubiDepNac;
	
	@Column(name = "ubiProvNac")
	private String ubiProvNac;
	
	@Column(name = "ubiDistNac")
	private String ubiDistNac;
	
	public PacienteReniec() {

	}

	public String getUbiDist() {
		return ubiDist;
	}

	public void setUbiDist(String ubiDist) {
		this.ubiDist = ubiDist;
	}

	public String getEstCivil() {
		return estCivil;
	}

	public void setEstCivil(String estCivil) {
		this.estCivil = estCivil;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}

	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}

	public String getNroDni() {
		return nroDni;
	}

	public void setNroDni(String nroDni) {
		this.nroDni = nroDni;
	}

	public String getCodigoVerificacion() {
		return codigoVerificacion;
	}

	public void setCodigoVerificacion(String codigoVerificacion) {
		this.codigoVerificacion = codigoVerificacion;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidopaterno(String apellidoPaterno) {
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

	public String getCondicionCasado() {
		return condicionCasado;
	}

	public void setCondicionCasado(String condicionCasado) {
		this.condicionCasado = condicionCasado;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombrePadre() {
		return nombrePadre;
	}

	public void setNombrePadre(String nombrePadre) {
		this.nombrePadre = nombrePadre;
	}

	public String getNombreMadre() {
		return nombreMadre;
	}

	public void setNombreMadre(String nombreMadre) {
		this.nombreMadre = nombreMadre;
	}

	public byte[] getFotoPaciente() {
		return fotoPaciente;
	}

	public void setFotoPaciente(byte[] fotoPaciente) {
		this.fotoPaciente = fotoPaciente;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getUbiDepart() {
		return ubiDepart;
	}

	public void setUbiDepart(String ubiDepart) {
		this.ubiDepart = ubiDepart;
	}

	public String getUbiProv() {
		return ubiProv;
	}

	public void setUbiProv(String ubiProv) {
		this.ubiProv = ubiProv;
	}

	public String getUbiDepNac() {
		return ubiDepNac;
	}

	public void setUbiDepNac(String ubiDepNac) {
		this.ubiDepNac = ubiDepNac;
	}

	public String getUbiProvNac() {
		return ubiProvNac;
	}

	public void setUbiProvNac(String ubiProvNac) {
		this.ubiProvNac = ubiProvNac;
	}

	public String getUbiDistNac() {
		return ubiDistNac;
	}

	public void setUbiDistNac(String ubiDistNac) {
		this.ubiDistNac = ubiDistNac;
	}

}
