package proyect.core.entity.cuentaCorriente;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity; 
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import org.bridj.cpp.com.DECIMAL;

import proyect.core.entity.catalogo.Catalogo02;
import proyect.core.entity.general.Personal;
  


@SuppressWarnings("serial")
@NamedStoredProcedureQueries(
		{
		
				@NamedStoredProcedureQuery(
						name="cuentaCorriente.episodiosActivos", 
						procedureName="[SIGEHOV2ASIS].[ATEN].[USP_EPISODIO_FIND_EPISODIOS_ACTIVOS_BY_CODPERSO]",
						resultClasses= CuentaCorriente.class,
						parameters={

							@StoredProcedureParameter(mode=ParameterMode.IN, name="CODPERSO", type=String.class)
				}					
				),
				@NamedStoredProcedureQuery(
						name="cuentaCorriente.listaPacientesPendientes", 
						procedureName="[SIGEHOV2ASIS].[ATEN].[USP_CTA_CTE_LIST_PACIENTES_PENDIENTES]",
						resultClasses= CuentaCorriente.class,
						parameters={

							@StoredProcedureParameter(mode=ParameterMode.IN, name="CODPERSO", 	type=String.class), 
				}					
				),
				@NamedStoredProcedureQuery(
						name="cuentaCorriente.cantidadConLetra", 
						procedureName="[dbo].[CantidadConLetra]",
						resultClasses= String.class,
						parameters={

							@StoredProcedureParameter(mode=ParameterMode.IN, name="Numero", 	type=float.class), 
				}					
				),
		}			
	)


@Entity 
public class CuentaCorriente  implements Serializable {

	@EmbeddedId
	private CuentaCorrientePK id;
	
	private boolean activo;

	private Timestamp 		fechaLiquidacion;
	
	private Personal	personalLiquidacion;
	
	private Float 		importeTotal;
	
	private Float 		descuentoTotal;
	
	private Float		importeCancelado;
	
	private Float		sumaTotal;
	
	private Float		deudaActualHospitalizado;
	
	@Column(name="CODRGEPI")
	private String 		codigoEpisodio; 				// PACIENTE ESTA DENTRO DEL EPISODIO
	
	@Column(name="NROVERSI")
	private String       periodoEpisodio;
	
	@Column(name="NROPERIO")
	private String        versionoEpisodio;
	
	/****relacionado al paciente****/
	@Column(name="CODPERSO")
	private String  codigoPersona;
	
	@Column(name="APEPATER")
	private String  apellidoPaterno;
	
	@Column(name="APEMATER")
	private String  apellidoMaterno;
	
	@Column(name="PRINOMBR")
	private String  primerNombre;
	
	@Column(name="SEGNOMBR")
	private String  segundoNombre;
	
	@Column(name="NOMBTIPDO")
	private String  nroDoc;
	
	@Column(name="CODTIPOD")
	private String  tipoDocumento;
	
	@Column(name="NUMEROHC")
	private String  nroHC;
	
	@Column(name="TG12TPPA")
	private String  tipoPaciente;
	
	@Column(name="NOMBTPPA")
	private String  nombreTipoPaciente;
	
	
	/********/
	
	private String  	descripcionProcedencia;
	
	private Catalogo02  tipoCuentaCte;  
	
	@Column(name="CODVINCTA")	
	private String		codigoVinculacionCuenta;           // nroH ,codigo E o nro FUA
	
	@Column(name="CANTIDAD_CONCEPTOS_PENDIENTES")	
	private int 		cantidadPendientes;		
	
	private int    		flagHospi;
	
	private List<CuentaCorrienteItem> 	cuentaCorrienteItems; 
	private String 						observac;
	private String 		  codIngresado;
	private String        nombreCategoria  ;
	private Float         montoXcategoria  ;
	private String        fchAltaDef;
	private Float 		  importeTotalPagadoxCategoria;
	private Float 		  importeTotalAnuladoxCategoria;
	private Float 		  importeTotalExoneradoxCategoria;
	private Float 		  importeTotalDevueltoxCategoria;
	private Float 		  importeTotalBrutoxCategoria;
	private Float 		  importeTotalExoneradoDevueltoxCategoria;
	
	public CuentaCorriente() { 
	}


	public CuentaCorrientePK getId() {
		return id;
	}


	public void setId(CuentaCorrientePK id) {
		this.id = id;
	}


	public boolean isActivo() {
		return activo;
	}


	public void setActivo(boolean activo) {
		this.activo = activo;
	}


	public Timestamp getFechaLiquidacion() {
		return fechaLiquidacion;
	}


	public void setFechaLiquidacion(Timestamp fechaLiquidacion) {
		this.fechaLiquidacion = fechaLiquidacion;
	}


	public Personal getPersonalLiquidacion() {
		return personalLiquidacion;
	}


	public void setPersonalLiquidacion(Personal personalLiquidacion) {
		this.personalLiquidacion = personalLiquidacion;
	}


	public Float getImporteTotal() {
		return importeTotal;
	}


	public void setImporteTotal(Float importeTotal) {
		this.importeTotal = importeTotal;
	}


	public Float getDescuentoTotal() {
		return descuentoTotal;
	}


	public void setDescuentoTotal(Float descuentoTotal) {
		this.descuentoTotal = descuentoTotal;
	}


	public Float getImporteCancelado() {
		return importeCancelado;
	}


	public void setImporteCancelado(Float importeCancelado) {
		this.importeCancelado = importeCancelado;
	}


	public Float getSumaTotal() {
		return sumaTotal;
	}


	public void setSumaTotal(Float sumaTotal) {
		this.sumaTotal = sumaTotal;
	}


	public Float getDeudaActualHospitalizado() {
		return deudaActualHospitalizado;
	}


	public void setDeudaActualHospitalizado(Float deudaActualHospitalizado) {
		this.deudaActualHospitalizado = deudaActualHospitalizado;
	}


	public String getCodigoEpisodio() {
		return codigoEpisodio;
	}


	public void setCodigoEpisodio(String codigoEpisodio) {
		this.codigoEpisodio = codigoEpisodio;
	}


	public String getPeriodoEpisodio() {
		return periodoEpisodio;
	}


	public void setPeriodoEpisodio(String periodoEpisodio) {
		this.periodoEpisodio = periodoEpisodio;
	}


	public String getVersionoEpisodio() {
		return versionoEpisodio;
	}


	public void setVersionoEpisodio(String versionoEpisodio) {
		this.versionoEpisodio = versionoEpisodio;
	}


	public String getDescripcionProcedencia() {
		return descripcionProcedencia;
	}


	public void setDescripcionProcedencia(String descripcionProcedencia) {
		this.descripcionProcedencia = descripcionProcedencia;
	}


	public Catalogo02 getTipoCuentaCte() {
		return tipoCuentaCte;
	}


	public void setTipoCuentaCte(Catalogo02 tipoCuentaCte) {
		this.tipoCuentaCte = tipoCuentaCte;
	}


	public String getCodigoVinculacionCuenta() {
		return codigoVinculacionCuenta;
	}


	public void setCodigoVinculacionCuenta(String codigoVinculacionCuenta) {
		this.codigoVinculacionCuenta = codigoVinculacionCuenta;
	}


	public int getCantidadPendientes() {
		return cantidadPendientes;
	}


	public void setCantidadPendientes(int cantidadPendientes) {
		this.cantidadPendientes = cantidadPendientes;
	}


	public int getFlagHospi() {
		return flagHospi;
	}


	public void setFlagHospi(int flagHospi) {
		this.flagHospi = flagHospi;
	}


	public List<CuentaCorrienteItem> getCuentaCorrienteItems() {
		return cuentaCorrienteItems;
	}


	public void setCuentaCorrienteItems(List<CuentaCorrienteItem> cuentaCorrienteItems) {
		this.cuentaCorrienteItems = cuentaCorrienteItems;
	}


	public String getObservac() {
		return observac;
	}


	public void setObservac(String observac) {
		this.observac = observac;
	}


	public String getCodIngresado() {
		return codIngresado;
	}


	public void setCodIngresado(String codIngresado) {
		this.codIngresado = codIngresado;
	}


	public String getNombreCategoria() {
		return nombreCategoria;
	}


	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}


	public Float getMontoXcategoria() {
		return montoXcategoria;
	}


	public void setMontoXcategoria(Float montoXcategoria) {
		this.montoXcategoria = montoXcategoria;
	}


	public String getFchAltaDef() {
		return fchAltaDef;
	}


	public void setFchAltaDef(String fchAltaDef) {
		this.fchAltaDef = fchAltaDef;
	}


	public Float getImporteTotalPagadoxCategoria() {
		return importeTotalPagadoxCategoria;
	}


	public void setImporteTotalPagadoxCategoria(Float importeTotalPagadoxCategoria) {
		this.importeTotalPagadoxCategoria = importeTotalPagadoxCategoria;
	}


	public Float getImporteTotalAnuladoxCategoria() {
		return importeTotalAnuladoxCategoria;
	}


	public void setImporteTotalAnuladoxCategoria(Float importeTotalAnuladoxCategoria) {
		this.importeTotalAnuladoxCategoria = importeTotalAnuladoxCategoria;
	}


	public Float getImporteTotalExoneradoxCategoria() {
		return importeTotalExoneradoxCategoria;
	}


	public void setImporteTotalExoneradoxCategoria(Float importeTotalExoneradoxCategoria) {
		this.importeTotalExoneradoxCategoria = importeTotalExoneradoxCategoria;
	}


	public Float getImporteTotalDevueltoxCategoria() {
		return importeTotalDevueltoxCategoria;
	}


	public void setImporteTotalDevueltoxCategoria(Float importeTotalDevueltoxCategoria) {
		this.importeTotalDevueltoxCategoria = importeTotalDevueltoxCategoria;
	}


	public Float getImporteTotalBrutoxCategoria() {
		return importeTotalBrutoxCategoria;
	}


	public void setImporteTotalBrutoxCategoria(Float importeTotalBrutoxCategoria) {
		this.importeTotalBrutoxCategoria = importeTotalBrutoxCategoria;
	}


	public Float getImporteTotalExoneradoDevueltoxCategoria() {
		return importeTotalExoneradoDevueltoxCategoria;
	}


	public void setImporteTotalExoneradoDevueltoxCategoria(Float importeTotalExoneradoDevueltoxCategoria) {
		this.importeTotalExoneradoDevueltoxCategoria = importeTotalExoneradoDevueltoxCategoria;
	}
	
	
	


	public String getCodigoPersona() {
		return codigoPersona;
	}


	public void setCodigoPersona(String codigoPersona) {
		this.codigoPersona = codigoPersona;
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


	public String getPrimerNombre() {
		return primerNombre;
	}


	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}


	public String getSegundoNombre() {
		return segundoNombre;
	}


	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}


	public String getNroDoc() {
		return nroDoc;
	}


	public void setNroDoc(String nroDoc) {
		this.nroDoc = nroDoc;
	}


	public String getTipoDocumento() {
		return tipoDocumento;
	}


	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}


	public String getNroHC() {
		return nroHC;
	}


	public void setNroHC(String nroHC) {
		this.nroHC = nroHC;
	}


	public String getTipoPaciente() {
		return tipoPaciente;
	}


	public void setTipoPaciente(String tipoPaciente) {
		this.tipoPaciente = tipoPaciente;
	}


	public String getNombreTipoPaciente() {
		return nombreTipoPaciente;
	}


	public void setNombreTipoPaciente(String nombreTipoPaciente) {
		this.nombreTipoPaciente = nombreTipoPaciente;
	}


	@Override
	public String toString() {
		return "CuentaCorriente [id=" + id + ", activo=" + activo + ", fechaLiquidacion=" + fechaLiquidacion
				+ ", personalLiquidacion=" + personalLiquidacion + ", importeTotal=" + importeTotal
				+ ", descuentoTotal=" + descuentoTotal + ", importeCancelado=" + importeCancelado + ", sumaTotal="
				+ sumaTotal + ", deudaActualHospitalizado=" + deudaActualHospitalizado + ", codigoEpisodio="
				+ codigoEpisodio + ", periodoEpisodio=" + periodoEpisodio + ", versionoEpisodio=" + versionoEpisodio
				+ ", descripcionProcedencia=" + descripcionProcedencia + ", tipoCuentaCte=" + tipoCuentaCte
				+ ", codigoVinculacionCuenta=" + codigoVinculacionCuenta + ", cantidadPendientes=" + cantidadPendientes
				+ ", flagHospi=" + flagHospi + ", cuentaCorrienteItems=" + cuentaCorrienteItems + ", observac="
				+ observac + ", codIngresado=" + codIngresado + ", nombreCategoria=" + nombreCategoria
				+ ", montoXcategoria=" + montoXcategoria + ", fchAltaDef=" + fchAltaDef
				+ ", importeTotalPagadoxCategoria=" + importeTotalPagadoxCategoria + ", importeTotalAnuladoxCategoria="
				+ importeTotalAnuladoxCategoria + ", importeTotalExoneradoxCategoria=" + importeTotalExoneradoxCategoria
				+ ", importeTotalDevueltoxCategoria=" + importeTotalDevueltoxCategoria
				+ ", importeTotalBrutoxCategoria=" + importeTotalBrutoxCategoria
				+ ", importeTotalExoneradoDevueltoxCategoria=" + importeTotalExoneradoDevueltoxCategoria + "]";
	}



	
}