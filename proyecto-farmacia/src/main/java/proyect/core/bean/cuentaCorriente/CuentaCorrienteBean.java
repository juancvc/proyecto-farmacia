package proyect.core.bean.cuentaCorriente;

import java.util.Date;

import proyect.base.bean.BaseBean;
import proyect.core.bean.general.EpisodioBean;
import proyect.core.bean.general.PacienteBean;
import proyect.core.bean.general.PersonaBean;
import proyect.core.bean.general.PersonalBean;


public class CuentaCorrienteBean extends BaseBean {
	
	
	private EpisodioBean episodio;
	private PersonaBean  persona;
	private PacienteBean paciente;
	private String		codigoVinculacionCuenta;  
	private int 		cantidadPendientes;	
	private boolean activo;

	private Date 		fechaLiquidacion;
	
	private PersonalBean	personalLiquidacion;
	
	private Float 		importeTotal;
	
	private Float 		descuentoTotal;
	
	private Float		importeCancelado;
	
	private Float		sumaTotal;
	
	private Float		deudaActualHospitalizado;
	
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
	private int    		flagHospi;
	public EpisodioBean getEpisodio() {
		if (episodio == null) {
			episodio = new EpisodioBean();
		}
		return episodio;
	}
	public void setEpisodio(EpisodioBean episodio) {
		this.episodio = episodio;
	}
	public PersonaBean getPersona() {
		if (persona == null) {
			persona = new PersonaBean();
		}
		return persona;
	}
	public void setPersona(PersonaBean persona) {
		this.persona = persona;
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
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public Date getFechaLiquidacion() {
		return fechaLiquidacion;
	}
	public void setFechaLiquidacion(Date fechaLiquidacion) {
		this.fechaLiquidacion = fechaLiquidacion;
	}
	public PersonalBean getPersonalLiquidacion() {
		if (personalLiquidacion == null) {
			personalLiquidacion = new PersonalBean();
		}
		return personalLiquidacion;
	}
	public void setPersonalLiquidacion(PersonalBean personalLiquidacion) {
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
	public int getFlagHospi() {
		return flagHospi;
	}
	public void setFlagHospi(int flagHospi) {
		this.flagHospi = flagHospi;
	}
	public PacienteBean getPaciente() {
		if (paciente == null) {
			paciente = new PacienteBean();
		}
		return paciente;
	}
	public void setPaciente(PacienteBean paciente) {
		this.paciente = paciente;
	}
	
	
	
	
	
}
