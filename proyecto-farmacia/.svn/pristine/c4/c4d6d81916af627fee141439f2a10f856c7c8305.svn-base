package hnch.referencia.core.bean.asistencial.referencia;

import hnch.referencia.base.bean.BaseBean;
import hnch.referencia.core.bean.general.PersonalBean;
import hnch.referencia.core.bean.general.RenaesBean;
import hnch.referencia.core.bean.general.TablaBean;
import hnch.referencia.core.bean.general.PacienteBean;
import hnch.referencia.core.bean.general.PersonaBean;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.print.DocFlavor.BYTE_ARRAY;
import javax.xml.bind.annotation.XmlRootElement;
 
public class ReferenciaBean extends BaseBean {

	private TablaBean 	 estadoPuerperal;
	private TablaBean 	 condicionPaciente;
	private Boolean 	 tipoAsegurado;

	private PacienteBean  paciente;
	private PersonalBean responsableEstablecimiento;
	private PersonalBean responsableReferencia;
	private PersonalBean personalAcompanante;
	private PersonalBean personalRecepcion;
	private RenaesBean  establecimientoOrige;
	private RenaesBean  establecimientoDestino;

	private TablaBean   tipoReferencia;
	private TablaBean   servicioUPSReferencia;
	private TablaBean	especialidad;
	
	private Date 		fechaIngresoRef;
	private String 		strfechaIngresoRef;
	private Date 		fechaReferencia;
	private String 		horaIngresoRef;
	private String 	    numeroReferencia;
	private String 		numeroHCReferido;
	private TablaBean   especialidadDestino;
	private TablaBean   planAtenSIS;
	private TablaBean	tiempoEnfermedad;
	
	private TablaBean	formaInicio;
	private TablaBean	curso;
	
	private int		cantTiempoEnfermedad;
	private String      anamnesisHC;
	private String      examenesAuxHC;
	private String      tratamientoHC;
	private String      codigoAfiliacion;
	private String      estadoAfiliacion;
	private TablaBean   tipoAfiliacion;
	private TablaBean   motivoReferencia;
	private String   	descripcionMotivoReferencia;
	private byte []     docPdfRef;

	private String 		sintomas;
	private String 		relato;
	private String 		temperatura;
	private String 		presionArterial;
	private String 		frecuenciaRespiratorio;
	private String 		frecuenciaCardiaca; 
	 
	private String 		fechaDesde; 
	private String 		fechaHasta; 
	
	private TablaBean	tipoSeguro;
	private String		categoriaSeguro;
	private TablaBean	motivoDescarte;
	private String		detalleMotivoDescarte;
	
	private List<ReferenciaApoyoDxResultadoBean> listReferenciaApoyoDxResultadoBean;
	
	private List<ReferenciaApoyoDxBean> listReferenciaApoyoDxBean;
	
	private List<ReferenciaDiagnosticoBean> listReferenciaDiagnosticoBean; 
	
	private List<TablaBean> listEspecialidades; 
	
	public ReferenciaBean() {
		super();
	}

	public String getDetalleMotivoDescarte() {
		return detalleMotivoDescarte;
	}

	public void setDetalleMotivoDescarte(String detalleMotivoDescarte) {
		this.detalleMotivoDescarte = detalleMotivoDescarte;
	}

	public TablaBean getMotivoDescarte() {
		return motivoDescarte;
	}

	public void setMotivoDescarte(TablaBean motivoDescarte) {
		this.motivoDescarte = motivoDescarte;
	}

	public String getNumeroReferencia() {
		return numeroReferencia;
	}

	public void setNumeroReferencia(String numeroReferencia) {
		this.numeroReferencia = numeroReferencia;
	}

	public TablaBean getEstadoPuerperal() {
		return estadoPuerperal;
	}

	public void setEstadoPuerperal(TablaBean estadoPuerperal) {
		this.estadoPuerperal = estadoPuerperal;
	}

	public TablaBean getCondicionPaciente() {
		if (condicionPaciente == null) {
			condicionPaciente = new TablaBean();
		}
		return condicionPaciente;
	}

	public void setCondicionPaciente(TablaBean condicionPaciente) {
		this.condicionPaciente = condicionPaciente;
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

	public RenaesBean getEstablecimientoOrige() {
		if (establecimientoOrige == null) {
			establecimientoOrige = new RenaesBean();
		}
		return establecimientoOrige;
	}

	public void setEstablecimientoOrige(RenaesBean establecimientoOrige) {
		this.establecimientoOrige = establecimientoOrige;
	}

	public RenaesBean getEstablecimientoDestino() {
		if (establecimientoDestino == null) {
			establecimientoDestino = new RenaesBean();
		}
		return establecimientoDestino;
	}

	public void setEstablecimientoDestino(RenaesBean establecimientoDestino) {
		this.establecimientoDestino = establecimientoDestino;
	}

	public TablaBean getTipoReferencia() {
		return tipoReferencia;
	}

	public void setTipoReferencia(TablaBean tipoReferencia) {
		this.tipoReferencia = tipoReferencia;
	}

	public TablaBean getServicioUPSReferencia() {
		if (servicioUPSReferencia == null) {
			servicioUPSReferencia = new TablaBean();
		}
		return servicioUPSReferencia;
	}

	public void setServicioUPSReferencia(TablaBean servicioUPSReferencia) {
		this.servicioUPSReferencia = servicioUPSReferencia;
	}

	public Date getFechaIngresoRef() {
		if (fechaIngresoRef == null) {
			fechaIngresoRef = new Date();
		}
		return fechaIngresoRef;
	}

	public void setFechaIngresoRef(Date fechaIngresoRef) {
		this.fechaIngresoRef = fechaIngresoRef;
	}

	public Date getFechaReferencia() {
		return fechaReferencia;
	}

	public void setFechaReferencia(Date fechaReferencia) {
		this.fechaReferencia = fechaReferencia;
	}

	public String getHoraIngresoRef() {
		if (horaIngresoRef == null) {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			
			String strHora = sdf.format(new Date());
			horaIngresoRef = strHora;
		}
		return horaIngresoRef;
	}

	public void setHoraIngresoRef(String horaIngresoRef) {
		this.horaIngresoRef = horaIngresoRef;
	}

	public Boolean getTipoAsegurado() {
		return tipoAsegurado;
	}

	public void setTipoAsegurado(Boolean tipoAsegurado) {
		this.tipoAsegurado = tipoAsegurado;
	}

	public String getNumeroHCReferido() {
		return numeroHCReferido;
	}

	public void setNumeroHCReferido(String numeroHCReferido) {
		this.numeroHCReferido = numeroHCReferido;
	}

	public TablaBean getEspecialidadDestino() {
		return especialidadDestino;
	}

	public void setEspecialidadDestino(TablaBean especialidadDestino) {
		this.especialidadDestino = especialidadDestino;
	}

	public TablaBean getPlanAtenSIS() {
		if (planAtenSIS == null) {
			planAtenSIS = new TablaBean();
		}
		return planAtenSIS;
	}

	public void setPlanAtenSIS(TablaBean planAtenSIS) {
		this.planAtenSIS = planAtenSIS;
	}

	public String getAnamnesisHC() {
		return anamnesisHC;
	}

	public void setAnamnesisHC(String anamnesisHC) {
		this.anamnesisHC = anamnesisHC;
	}

	public String getExamenesAuxHC() {
		return examenesAuxHC;
	}

	public void setExamenesAuxHC(String examenesAuxHC) {
		this.examenesAuxHC = examenesAuxHC;
	}

	public String getTratamientoHC() {
		return tratamientoHC;
	}

	public void setTratamientoHC(String tratamientoHC) {
		this.tratamientoHC = tratamientoHC;
	}

	public String getCodigoAfiliacion() {
		return codigoAfiliacion;
	}

	public void setCodigoAfiliacion(String codigoAfiliacion) {
		this.codigoAfiliacion = codigoAfiliacion;
	}

	public String getEstadoAfiliacion() {
		return estadoAfiliacion;
	}

	public void setEstadoAfiliacion(String estadoAfiliacion) {
		this.estadoAfiliacion = estadoAfiliacion;
	}

	public TablaBean getTipoAfiliacion() {
		return tipoAfiliacion;
	}

	public void setTipoAfiliacion(TablaBean tipoAfiliacion) {
		this.tipoAfiliacion = tipoAfiliacion;
	}

	public PersonalBean getPersonalRecepcion() {
		return personalRecepcion;
	}

	public void setPersonalRecepcion(PersonalBean personalRecepcion) {
		this.personalRecepcion = personalRecepcion;
	}

	public PersonalBean getResponsableEstablecimiento() {
		if (responsableEstablecimiento == null) {
			responsableEstablecimiento = new PersonalBean();
		}
		return responsableEstablecimiento;
	}

	public void setResponsableEstablecimiento(
			PersonalBean responsableEstablecimiento) {
		this.responsableEstablecimiento = responsableEstablecimiento;
	}

	public PersonalBean getResponsableReferencia() {
		if (responsableReferencia == null) {
			responsableReferencia = new PersonalBean();
		}
		return responsableReferencia;
	}

	public void setResponsableReferencia(PersonalBean responsableReferencia) {
		this.responsableReferencia = responsableReferencia;
	}

	public PersonalBean getPersonalAcompanante() {
		if (personalAcompanante == null) {
			personalAcompanante = new PersonalBean();
		}
		return personalAcompanante;
	}

	public void setPersonalAcompanante(PersonalBean personalAcompanante) {
		this.personalAcompanante = personalAcompanante;
	}

	public byte[] getDocPdfRef() {
		return docPdfRef;
	}

	public void setDocPdfRef(byte[] docPdfRef) {
		this.docPdfRef = docPdfRef;
	}

	public TablaBean getEspecialidad() {
		if (especialidad == null) {
			especialidad = new TablaBean();
		}
		return especialidad;
	}

	public void setEspecialidad(TablaBean especialidad) {
		this.especialidad = especialidad;
	}

	public TablaBean getTiempoEnfermedad() {
		if (tiempoEnfermedad == null) {
			tiempoEnfermedad = new TablaBean();
		}
		return tiempoEnfermedad;
	}

	public void setTiempoEnfermedad(TablaBean tiempoEnfermedad) {
		this.tiempoEnfermedad = tiempoEnfermedad;
	}

	public TablaBean getFormaInicio() {
		if (formaInicio == null) {
			formaInicio = new TablaBean();
		}
		return formaInicio;
	}

	public void setFormaInicio(TablaBean formaInicio) {
		this.formaInicio = formaInicio;
	}

	public TablaBean getCurso() {
		if (curso == null) {
			curso = new TablaBean();
		}
		return curso;
	}

	public void setCurso(TablaBean curso) {
		this.curso = curso;
	}

	public int getCantTiempoEnfermedad() {
		return cantTiempoEnfermedad;
	}

	public void setCantTiempoEnfermedad(int cantTiempoEnfermedad) {
		this.cantTiempoEnfermedad = cantTiempoEnfermedad;
	}

	public String getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

	public String getRelato() {
		return relato;
	}

	public void setRelato(String relato) {
		this.relato = relato;
	}

	public String getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}

	public String getPresionArterial() {
		return presionArterial;
	}

	public void setPresionArterial(String presionArterial) {
		this.presionArterial = presionArterial;
	}

	public String getFrecuenciaRespiratorio() {
		return frecuenciaRespiratorio;
	}

	public void setFrecuenciaRespiratorio(String frecuenciaRespiratorio) {
		this.frecuenciaRespiratorio = frecuenciaRespiratorio;
	}

	public String getFrecuenciaCardiaca() {
		return frecuenciaCardiaca;
	}

	public void setFrecuenciaCardiaca(String frecuenciaCardiaca) {
		this.frecuenciaCardiaca = frecuenciaCardiaca;
	}

	public TablaBean getMotivoReferencia() {
		if (motivoReferencia == null) {
			motivoReferencia = new TablaBean();
		}
		return motivoReferencia;
	}

	public void setMotivoReferencia(TablaBean motivoReferencia) {
		this.motivoReferencia = motivoReferencia;
	}

	public String getDescripcionMotivoReferencia() {
		return descripcionMotivoReferencia;
	}

	public void setDescripcionMotivoReferencia(String descripcionMotivoReferencia) {
		this.descripcionMotivoReferencia = descripcionMotivoReferencia;
	}

	public String getStrfechaIngresoRef() {
		return strfechaIngresoRef;
	}

	public void setStrfechaIngresoRef(String strfechaIngresoRef) {
		this.strfechaIngresoRef = strfechaIngresoRef;
	}

	public List<ReferenciaApoyoDxResultadoBean> getListReferenciaApoyoDxResultadoBean() {
		return listReferenciaApoyoDxResultadoBean;
	}

	public void setListReferenciaApoyoDxResultadoBean(
			List<ReferenciaApoyoDxResultadoBean> listReferenciaApoyoDxResultadoBean) {
		this.listReferenciaApoyoDxResultadoBean = listReferenciaApoyoDxResultadoBean;
	}

	public String getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(String fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public String getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(String fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public TablaBean getTipoSeguro() {
		if (tipoSeguro ==  null) {
			tipoSeguro = new TablaBean();
		}
		return tipoSeguro;
	}

	public void setTipoSeguro(TablaBean tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}

	public String getCategoriaSeguro() {
		return categoriaSeguro;
	}

	public void setCategoriaSeguro(String categoriaSeguro) {
		this.categoriaSeguro = categoriaSeguro;
	}

	public List<ReferenciaApoyoDxBean> getListReferenciaApoyoDxBean() {
		return listReferenciaApoyoDxBean;
	}

	public void setListReferenciaApoyoDxBean(List<ReferenciaApoyoDxBean> listReferenciaApoyoDxBean) {
		this.listReferenciaApoyoDxBean = listReferenciaApoyoDxBean;
	}

	public List<ReferenciaDiagnosticoBean> getListReferenciaDiagnosticoBean() {
		return listReferenciaDiagnosticoBean;
	}

	public void setListReferenciaDiagnosticoBean(List<ReferenciaDiagnosticoBean> listReferenciaDiagnosticoBean) {
		this.listReferenciaDiagnosticoBean = listReferenciaDiagnosticoBean;
	}

	public List<TablaBean> getListEspecialidades() {
		return listEspecialidades;
	}

	public void setListEspecialidades(List<TablaBean> listEspecialidades) {
		this.listEspecialidades = listEspecialidades;
	}

	@Override
	public String toString() {
		return "ReferenciaBean [estadoPuerperal=" + estadoPuerperal + ", condicionPaciente=" + condicionPaciente
				+ ", tipoAsegurado=" + tipoAsegurado + ", paciente=" + paciente + ", responsableEstablecimiento="
				+ responsableEstablecimiento + ", responsableReferencia=" + responsableReferencia
				+ ", personalAcompanante=" + personalAcompanante + ", personalRecepcion=" + personalRecepcion
				+ ", establecimientoOrige=" + establecimientoOrige + ", establecimientoDestino="
				+ establecimientoDestino + ", tipoReferencia=" + tipoReferencia + ", servicioUPSReferencia="
				+ servicioUPSReferencia + ", especialidad=" + especialidad + ", fechaIngresoRef=" + fechaIngresoRef
				+ ", strfechaIngresoRef=" + strfechaIngresoRef + ", fechaReferencia=" + fechaReferencia
				+ ", horaIngresoRef=" + horaIngresoRef + ", numeroReferencia=" + numeroReferencia
				+ ", numeroHCReferido=" + numeroHCReferido + ", especialidadDestino=" + especialidadDestino
				+ ", planAtenSIS=" + planAtenSIS + ", tiempoEnfermedad=" + tiempoEnfermedad + ", formaInicio="
				+ formaInicio + ", curso=" + curso + ", cantTiempoEnfermedad=" + cantTiempoEnfermedad + ", anamnesisHC="
				+ anamnesisHC + ", examenesAuxHC=" + examenesAuxHC + ", tratamientoHC=" + tratamientoHC
				+ ", codigoAfiliacion=" + codigoAfiliacion + ", estadoAfiliacion=" + estadoAfiliacion
				+ ", tipoAfiliacion=" + tipoAfiliacion + ", motivoReferencia=" + motivoReferencia
				+ ", descripcionMotivoReferencia=" + descripcionMotivoReferencia + ", docPdfRef="
				+ Arrays.toString(docPdfRef) + ", sintomas=" + sintomas + ", relato=" + relato + ", temperatura="
				+ temperatura + ", presionArterial=" + presionArterial + ", frecuenciaRespiratorio="
				+ frecuenciaRespiratorio + ", frecuenciaCardiaca=" + frecuenciaCardiaca
				+ ", listReferenciaApoyoDxResultadoBean=" + listReferenciaApoyoDxResultadoBean + ", fechaDesde="
				+ fechaDesde + ", fechaHasta=" + fechaHasta + ", tipoSeguro=" + tipoSeguro + ", categoriaSeguro="
				+ categoriaSeguro + "]";
	}
 

}
