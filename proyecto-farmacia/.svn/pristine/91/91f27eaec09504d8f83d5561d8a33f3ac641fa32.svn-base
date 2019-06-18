package hnch.referencia.core.bean.general;
 
import java.util.Date; 
import hnch.referencia.base.bean.BaseBean; 

public class PersonaBean extends BaseBean {

	private String apellidoPaterno = ""; // Apellido Paterno
	private String apellidoMaterno = ""; // Apellido Materno
	private String primerNombre = "";
	private String segundoNombre = "";

	private String nombreCompleto = "";
	private String codigoPersonaSigeho = "";
	private String nroPeriodoPersona = "";
	
	private TablaBean sexo;
	private TablaBean nroHijos;
	private UbigeoBean ubigeoNacimiento;
	private UbigeoBean ubigeoDireccion;
	private Date fechaNac;
	private Date fechInsc;
	private TablaBean tipoDocumento;
	private String nroDocumento;
	private TablaBean nacionalidad;
	private TablaBean estadoCivil;
	private TablaBean grupoSanguineo;
	private TablaBean factorSanguineo;
	private TablaBean nivelInstrucion;
	private TablaBean ocupacion;
	private TablaBean religion;
	private byte[] foto;
	private String fotoCadena; 
	public String getFotoCadena() {
		return fotoCadena;
	}
	public void setFotoCadena(String fotoCadena) {
		this.fotoCadena = fotoCadena;
	}

	private String RutaFoto;
	private String observacion;
	private String origenDeRegistro;
	/***** VERIFICAR UTILIDADD DE VARIABLE<----- *****/
	private String validacionReniec = "1";
	private TablaBean etnia;
	private String donanteOrg;

	private Boolean swPaciente = false; // 1: Activo, 0:Inactivo;
	private Boolean swEmpleado; // 1: Activo, 0:Inactivo;
	private Boolean swFallecido; // 1: Activo, 0:Inactivo;
	private Boolean swReniec; // 1: Activo, 0:Inactivo;
	private Boolean swFamiliaEmpleado; // 1: Activo, 0:Inactivo;
	private Boolean swEmpleadoCesante; // 1: Activo, 0:Inactivo;
	private Boolean swRN;

	private String telfFijo;
	private String telfCelu;
	private String correo;
	private String edad;
	private String edadCompleta;
	private String fechaNacStr;
	private String direccion;
	private String ultimaFechaDonacion;
	
	private String telefonoNumero; 
	private String codigoErrorReniec; 
	private String origenDatos; 
	
	private String codigoDireccion; 
	private String codigoTelefono; 
	private String codigoCorreo; 
	
	private String tipo;
	
	public String getCodigoDireccion() {
		return codigoDireccion;
	}
	public void setCodigoDireccion(String codigoDireccion) {
		this.codigoDireccion = codigoDireccion;
	}
	public String getCodigoTelefono() {
		return codigoTelefono;
	}
	public void setCodigoTelefono(String codigoTelefono) {
		this.codigoTelefono = codigoTelefono;
	}
	public String getCodigoCorreo() {
		return codigoCorreo;
	}
	public void setCodigoCorreo(String codigoCorreo) {
		this.codigoCorreo = codigoCorreo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getApellidoPaterno() {
		if(apellidoPaterno == null){
			apellidoPaterno = "";
		} 
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		if(apellidoMaterno == null){
			apellidoMaterno = "";
		}
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public String getPrimerNombre() {
		if(primerNombre == null){
			primerNombre = "";
		} 
		return primerNombre;
	}
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	public String getSegundoNombre() {
		if (segundoNombre == null) {
			segundoNombre = "";
		}
		return segundoNombre;
	}
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}
	public String getNombreCompleto() { 
			if(!this.getApellidoPaterno().equals("")){
				this.nombreCompleto = 	this.getApellidoPaterno().trim()
						+" "+ this.getApellidoMaterno().trim()
						+" "+ this.getPrimerNombre().trim()
						+" "+ this.getSegundoNombre().trim(); 
			}else{
				nombreCompleto = "";
			} 
		return this.nombreCompleto;
	}
	
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public TablaBean getSexo() {
		if (sexo == null) {
			sexo = new TablaBean();
		}
		return sexo;
	}
	public void setSexo(TablaBean sexo) {
		this.sexo = sexo;
	}
	public TablaBean getNroHijos() {
		return nroHijos;
	}
	public void setNroHijos(TablaBean nroHijos) {
		this.nroHijos = nroHijos;
	}
	 
	public String getCodigoErrorReniec() {
		return codigoErrorReniec;
	}
	public void setCodigoErrorReniec(String codigoErrorReniec) {
		this.codigoErrorReniec = codigoErrorReniec;
	}
	public UbigeoBean getUbigeoNacimiento() {
		if (ubigeoNacimiento == null) {
			ubigeoNacimiento =  new UbigeoBean();
		}
		return ubigeoNacimiento;
	}
	public void setUbigeoNacimiento(UbigeoBean ubigeoNacimiento) {
		this.ubigeoNacimiento = ubigeoNacimiento;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	public Date getFechInsc() {
		return fechInsc;
	}
	public void setFechInsc(Date fechInsc) {
		this.fechInsc = fechInsc;
	}
	public TablaBean getTipoDocumento() {
		if (tipoDocumento == null) {
			tipoDocumento = new TablaBean();
		}
		return tipoDocumento;
	}
	public void setTipoDocumento(TablaBean tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNroDocumento() {
		return nroDocumento;
	}
	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}
	public TablaBean getNacionalidad() {
		if (nacionalidad == null) {
			nacionalidad = new TablaBean();
		}
		return nacionalidad;
	}
	public void setNacionalidad(TablaBean nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public TablaBean getEstadoCivil() {
		if (estadoCivil == null) {
			estadoCivil = new TablaBean();
		}
		return estadoCivil;
	}
	public void setEstadoCivil(TablaBean estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public TablaBean getGrupoSanguineo() {
		return grupoSanguineo;
	}
	public void setGrupoSanguineo(TablaBean grupoSanguineo) {
		this.grupoSanguineo = grupoSanguineo;
	}
	public TablaBean getFactorSanguineo() {
		return factorSanguineo;
	}
	public void setFactorSanguineo(TablaBean factorSanguineo) {
		this.factorSanguineo = factorSanguineo;
	}
	public TablaBean getNivelInstrucion() {
		if (nivelInstrucion == null) {
			nivelInstrucion = new TablaBean();
		}
		return nivelInstrucion;
	}
	public void setNivelInstrucion(TablaBean nivelInstrucion) {
		this.nivelInstrucion = nivelInstrucion;
	}
	public TablaBean getOcupacion() {
		if (ocupacion == null) {
			ocupacion = new TablaBean();
		}
		return ocupacion;
	}
	public void setOcupacion(TablaBean ocupacion) {
		this.ocupacion = ocupacion;
	}
	public TablaBean getReligion() {
		return religion;
	}
	public void setReligion(TablaBean religion) {
		this.religion = religion;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public String getRutaFoto() {
		return RutaFoto;
	}
	public void setRutaFoto(String rutaFoto) {
		RutaFoto = rutaFoto;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public String getOrigenDeRegistro() {
		return origenDeRegistro;
	}
	public void setOrigenDeRegistro(String origenDeRegistro) {
		this.origenDeRegistro = origenDeRegistro;
	}
	public String getValidacionReniec() {
		return validacionReniec;
	}
	public void setValidacionReniec(String validacionReniec) {
		this.validacionReniec = validacionReniec;
	}
	public TablaBean getEtnia() {
		return etnia;
	}
	public void setEtnia(TablaBean etnia) {
		this.etnia = etnia;
	}
	public String getDonanteOrg() {
		return donanteOrg;
	}
	public void setDonanteOrg(String donanteOrg) {
		this.donanteOrg = donanteOrg;
	}
	public Boolean getSwPaciente() {
		return swPaciente;
	}
	public void setSwPaciente(Boolean swPaciente) {
		this.swPaciente = swPaciente;
	}
	public Boolean getSwEmpleado() {
		return swEmpleado;
	}
	public void setSwEmpleado(Boolean swEmpleado) {
		this.swEmpleado = swEmpleado;
	}
	public Boolean getSwFallecido() {
		return swFallecido;
	}
	public void setSwFallecido(Boolean swFallecido) {
		this.swFallecido = swFallecido;
	}
	public Boolean getSwReniec() {
		if (swReniec == null) {
			swReniec = false;
		}
		return swReniec;
	}
	public void setSwReniec(Boolean swReniec) {
		this.swReniec = swReniec;
	}
	public Boolean getSwFamiliaEmpleado() {
		return swFamiliaEmpleado;
	}
	public void setSwFamiliaEmpleado(Boolean swFamiliaEmpleado) {
		this.swFamiliaEmpleado = swFamiliaEmpleado;
	}
	public Boolean getSwEmpleadoCesante() {
		return swEmpleadoCesante;
	}
	public void setSwEmpleadoCesante(Boolean swEmpleadoCesante) {
		this.swEmpleadoCesante = swEmpleadoCesante;
	}
	public Boolean getSwRN() {
		return swRN;
	}
	public void setSwRN(Boolean swRN) {
		this.swRN = swRN;
	}
	public String getTelfFijo() {
		return telfFijo;
	}
	public void setTelfFijo(String telfFijo) {
		this.telfFijo = telfFijo;
	}
	public String getTelfCelu() {
		return telfCelu;
	}
	public void setTelfCelu(String telfCelu) {
		this.telfCelu = telfCelu;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
 
	public String getCodigoPersonaSigeho() {
		return codigoPersonaSigeho;
	}
	public void setCodigoPersonaSigeho(String codigoPersonaSigeho) {
		this.codigoPersonaSigeho = codigoPersonaSigeho;
	}
	public String getNroPeriodoPersona() {
		return nroPeriodoPersona;
	}
	public void setNroPeriodoPersona(String nroPeriodoPersona) {
		this.nroPeriodoPersona = nroPeriodoPersona;
	}
	public String getFechaNacStr() {
		return fechaNacStr;
	}
	public void setFechaNacStr(String fechaNacStr) {
		this.fechaNacStr = fechaNacStr;
	}
	
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public String getEdadCompleta() {
		return edadCompleta;
	}
	public void setEdadCompleta(String edadCompleta) {
		this.edadCompleta = edadCompleta;
	}
	public UbigeoBean getUbigeoDireccion() {
		if (ubigeoDireccion == null) {
			ubigeoDireccion = new UbigeoBean();
		}
		return ubigeoDireccion;
	}
	public void setUbigeoDireccion(UbigeoBean ubigeoDireccion) {
		this.ubigeoDireccion = ubigeoDireccion;
	}
	public String getUltimaFechaDonacion() {
		return ultimaFechaDonacion;
	}
	public void setUltimaFechaDonacion(String ultimaFechaDonacion) {
		this.ultimaFechaDonacion = ultimaFechaDonacion;
	}
	public String getTelefonoNumero() {
		return telefonoNumero;
	}
	public void setTelefonoNumero(String telefonoNumero) {
		this.telefonoNumero = telefonoNumero;
	}
	public String getOrigenDatos() {
		return origenDatos;
	}
	public void setOrigenDatos(String origenDatos) {
		this.origenDatos = origenDatos;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
 
}
