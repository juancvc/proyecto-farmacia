package proyect.core.entity.cuentaCorriente;

import java.io.Serializable;
import java.sql.Timestamp; 
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity; 
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery; 
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter; 

@SuppressWarnings("serial")
@NamedStoredProcedureQueries({

		@NamedStoredProcedureQuery(name = "cuentaCorriente.episodiosActivos", procedureName = "[SIGEHOV2ASIS].[ATEN].[USP_EPISODIO_FIND_EPISODIOS_ACTIVOS_BY_CODPERSO]", resultClasses = CuentaCorriente.class, parameters = {

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODPERSO", type = String.class) }),
		@NamedStoredProcedureQuery(name = "cuentaCorriente.listaPacientesPendientes", procedureName = "[SIGEHOV2ASIS].[ATEN].[USP_CTA_CTE_LIST_PACIENTES_PENDIENTES_FARMACIA]", resultClasses = CuentaCorriente.class, parameters = {

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODPERSO", type = String.class), }),
		@NamedStoredProcedureQuery(name = "cuentaCorriente.cantidadConLetra", procedureName = "[dbo].[CantidadConLetra]", resultClasses = String.class, parameters = {

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "Numero", type = float.class), }),
		@NamedStoredProcedureQuery(name = "cuentaCorriente.buscaPorNumeroEpisodio", procedureName = "[dbo].[usp_Pacientes_ctaCorrienteV2]", resultClasses = CuentaCorriente.class, parameters = {

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "nroDocEpi", type = String.class), }), })

@Entity
public class CuentaCorriente implements Serializable {

	@EmbeddedId
	private CuentaCorrientePK id;

	@Column(name = "fechaLiquidacion")
	private Timestamp fechaLiquidacion;

	@Column(name = "idEpisodio")
	private String idEpisodio; // PACIENTE ESTA DENTRO DEL EPISODIO

	@Column(name = "periodoEpisodio")
	private String periodoEpisodio;

	@Column(name = "versionEpisodio")
	private String versionEpisodio;
 
	@Column(name = "idPersona")
	private String idPersona;

	@Column(name = "apellidoPaterno")
	private String apellidoPaterno;

	@Column(name = "apellidoMaterno")
	private String apellidoMaterno;

	@Column(name = "nombres")
	private String nombres;
 
	@Column(name = "idTipoCuentaCta02")
	private String idTipoCuentaCta02;
	
	/*******************/
	private String idTipoPacienteCat02;
	private String descripcionTipoCtaCte;
	private String nroDocumento;
	private String idTipoDocumentoCat02;
	private String nroHC; 
	private String nombreTipoPaciente;
	private String descripcionProcedencia;
	private String idProcedenciaCat02;
	private String numeroEpisodio; // nroH ,codigo E o nro FUA
	private int cantidadPendientes;
	private int flagHospi;
	private List<CuentaCorrienteItem> cuentaCorrienteItems;
	private String observac;
	private String codIngresado;
	private String nombreCategoria;
	private Float montoXcategoria;
	private String fchAltaDef;
	private Float importeTotalPagadoxCategoria;
	private Float importeTotalAnuladoxCategoria;
	private Float importeTotalExoneradoxCategoria;
	private Float importeTotalDevueltoxCategoria;
	private Float importeTotalBrutoxCategoria;
	private Float importeTotalExoneradoDevueltoxCategoria;
	private boolean activo;	
	private String usuarioLiquido;
	private Float importeTotal;
	private Float descuentoTotal;
	private Float importeCancelado;
	private Float sumaTotal;
	private Float deudaActualHospitalizado;
	
	private String idCuentaCorrienteV2;
	private String numeroPeriodoV2;
	private String numeroVersionV2;
	
	public CuentaCorriente() {
	}

	public CuentaCorrientePK getId() {
		return id;
	}

	public void setId(CuentaCorrientePK id) {
		this.id = id;
	}

	public Timestamp getFechaLiquidacion() {
		return fechaLiquidacion;
	}

	public void setFechaLiquidacion(Timestamp fechaLiquidacion) {
		this.fechaLiquidacion = fechaLiquidacion;
	}

	public String getIdEpisodio() {
		return idEpisodio;
	}

	public void setIdEpisodio(String idEpisodio) {
		this.idEpisodio = idEpisodio;
	}

	public String getPeriodoEpisodio() {
		return periodoEpisodio;
	}

	public void setPeriodoEpisodio(String periodoEpisodio) {
		this.periodoEpisodio = periodoEpisodio;
	}

	public String getVersionEpisodio() {
		return versionEpisodio;
	}

	public void setVersionEpisodio(String versionEpisodio) {
		this.versionEpisodio = versionEpisodio;
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

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getIdTipoDocumentoCat02() {
		return idTipoDocumentoCat02;
	}

	public void setIdTipoDocumentoCat02(String idTipoDocumentoCat02) {
		this.idTipoDocumentoCat02 = idTipoDocumentoCat02;
	}

	public String getNroHC() {
		return nroHC;
	}

	public void setNroHC(String nroHC) {
		this.nroHC = nroHC;
	}

	public String getNombreTipoPaciente() {
		return nombreTipoPaciente;
	}

	public void setNombreTipoPaciente(String nombreTipoPaciente) {
		this.nombreTipoPaciente = nombreTipoPaciente;
	}

	public String getDescripcionProcedencia() {
		return descripcionProcedencia;
	}

	public void setDescripcionProcedencia(String descripcionProcedencia) {
		this.descripcionProcedencia = descripcionProcedencia;
	}

	public String getIdProcedenciaCat02() {
		return idProcedenciaCat02;
	}

	public void setIdProcedenciaCat02(String idProcedenciaCat02) {
		this.idProcedenciaCat02 = idProcedenciaCat02;
	}

	public String getNumeroEpisodio() {
		return numeroEpisodio;
	}

	public void setNumeroEpisodio(String numeroEpisodio) {
		this.numeroEpisodio = numeroEpisodio;
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

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getUsuarioLiquido() {
		return usuarioLiquido;
	}

	public void setUsuarioLiquido(String usuarioLiquido) {
		this.usuarioLiquido = usuarioLiquido;
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

	public String getIdTipoCuentaCta02() {
		return idTipoCuentaCta02;
	}

	public void setIdTipoCuentaCta02(String idTipoCuentaCta02) {
		this.idTipoCuentaCta02 = idTipoCuentaCta02;
	}

	public String getDescripcionTipoCtaCte() {
		return descripcionTipoCtaCte;
	}

	public void setDescripcionTipoCtaCte(String descripcionTipoCtaCte) {
		this.descripcionTipoCtaCte = descripcionTipoCtaCte;
	}

	public String getIdTipoPacienteCat02() {
		return idTipoPacienteCat02;
	}

	public void setIdTipoPacienteCat02(String idTpoPacienteCat02) {
		this.idTipoPacienteCat02 = idTpoPacienteCat02;
	}

	public String getIdCuentaCorrienteV2() {
		return idCuentaCorrienteV2;
	}

	public void setIdCuentaCorrienteV2(String idCuentaCorrienteV2) {
		this.idCuentaCorrienteV2 = idCuentaCorrienteV2;
	}

	public String getNumeroPeriodoV2() {
		return numeroPeriodoV2;
	}

	public void setNumeroPeriodoV2(String numeroPeriodoV2) {
		this.numeroPeriodoV2 = numeroPeriodoV2;
	}

	public String getNumeroVersionV2() {
		return numeroVersionV2;
	}

	public void setNumeroVersionV2(String numeroVersionV2) {
		this.numeroVersionV2 = numeroVersionV2;
	}

}