package sigelab.core.bean.general.antecedentes;

import java.util.ArrayList;
import java.util.List;

import sigelab.base.bean.BaseBean;
import sigelab.core.bean.general.PacienteBean;

public class AntecedentesPacienteBean extends BaseBean{
	private PacienteBean paciente;
	private String  obsAntePersonales;
	private String  obsAnteFamiliares;
	private String  obsAnteRAM;
	private String  obsAnteMedFrec;
	private String  obsAnteOcupacional;
	/*****************************************************************/
	private boolean swTransfusion;
	private String  nroTransfusiones;
	private String  hospPrevias;
	private String  descAntecedentes;
	/******************************************************************/
	private List<AntecedentesPersonalesBean> lstAntecedentesPersonales;
	private List<AntecedentesFamiliaresBean> lstAntecedentesFamiliares;
	private List<AntecedentesRAMBean>	lstRAM;
	private List<AntecedentesMedFrecuenteBean> lstMedFrecuentes;
	private List<AntecedenteDetV3Bean> lstAntecedenteDetV3s;
	private AntecedentesResidenciaBean antecedResidencia;
	private List<AntecedentesOcupacionBean> lstAntecendeOcupacion;
	private AntecedentesPrenatalesBean antecedPrenatales;
	private AntecedentesNatalesBean antecedNatales;
	private AntecedentesAlimentacionBean antecedAlimentacion;
	private AntecedentesInmunizacionesBean antecedInmunizaciones;
	private AntecedentesDesPsicomotrizBean antecedDesPsicomotriz;
	
	public AntecedentesPacienteBean(){
		lstAntecedentesPersonales = new ArrayList<AntecedentesPersonalesBean>();
		lstAntecedentesFamiliares = new ArrayList<AntecedentesFamiliaresBean>();
		lstAntecedenteDetV3s = new ArrayList<AntecedenteDetV3Bean>();
		lstRAM = new ArrayList<AntecedentesRAMBean>();
		lstMedFrecuentes = new ArrayList<AntecedentesMedFrecuenteBean>();
		lstAntecendeOcupacion = new ArrayList<AntecedentesOcupacionBean>();
	}
	public String getObsAntePersonales() {
		return obsAntePersonales;
	}
	public void setObsAntePersonales(String obsAntePersonales) {
		this.obsAntePersonales = obsAntePersonales;
	}
	public String getObsAnteFamiliares() {
		return obsAnteFamiliares;
	}
	public void setObsAnteFamiliares(String obsAnteFamiliares) {
		this.obsAnteFamiliares = obsAnteFamiliares;
	}
	public String getObsAnteRAM() {
		return obsAnteRAM;
	}
	public void setObsAnteRAM(String obsAnteRAM) {
		this.obsAnteRAM = obsAnteRAM;
	}
	public String getObsAnteMedFrec() {
		return obsAnteMedFrec;
	}
	public void setObsAnteMedFrec(String obsAnteMedFrec) {
		this.obsAnteMedFrec = obsAnteMedFrec;
	}

	public List<AntecedentesFamiliaresBean> getLstAntecedentesFamiliares() {
		return lstAntecedentesFamiliares;
	}
	public void setLstAntecedentesFamiliares(
			List<AntecedentesFamiliaresBean> lstAntecedentesFamiliares) {
		this.lstAntecedentesFamiliares = lstAntecedentesFamiliares;
	}
	public PacienteBean getPersona() {
		return paciente;
	}
	public void setPersona(PacienteBean persona) {
		this.paciente = persona;
	}
	public List<AntecedentesPersonalesBean> getLstAntecedentesPersonales() {
		return lstAntecedentesPersonales;
	}
	public void setLstAntecedentesPersonales(
			List<AntecedentesPersonalesBean> lstAntecedentesPersonales) {
		this.lstAntecedentesPersonales = lstAntecedentesPersonales;
	}
	public PacienteBean getPaciente() {
		return paciente;
	}
	public void setPaciente(PacienteBean paciente) {
		this.paciente = paciente;
	}
	
	public List<AntecedentesMedFrecuenteBean> getLstMedFrecuentes() {
		return lstMedFrecuentes;
	}
	public void setLstMedFrecuentes(List<AntecedentesMedFrecuenteBean> lstMedFrecuentes) {
		this.lstMedFrecuentes = lstMedFrecuentes;
	}
	public List<AntecedentesRAMBean> getLstRAM() {
		return lstRAM;
	}
	public void setLstRAM(List<AntecedentesRAMBean> lstRAM) {
		this.lstRAM = lstRAM;
	}
	public boolean isSwTransfusion() {
		return swTransfusion;
	}
	public void setSwTransfusion(boolean swTransfusion) {
		this.swTransfusion = swTransfusion;
	}
	public String getNroTransfusiones() {
		return nroTransfusiones;
	}
	public void setNroTransfusiones(String nroTransfusiones) {
		this.nroTransfusiones = nroTransfusiones;
	}
	public String getHospPrevias() {
		return hospPrevias;
	}
	public void setHospPrevias(String hospPrevias) {
		this.hospPrevias = hospPrevias;
	}
	public String getDescAntecedentes() {
		return descAntecedentes;
	}
	public void setDescAntecedentes(String descAntecedentes) {
		this.descAntecedentes = descAntecedentes;
	}
	public List<AntecedenteDetV3Bean> getLstAntecedenteDetV3s() {
		return lstAntecedenteDetV3s;
	}
	public void setLstAntecedenteDetV3s(List<AntecedenteDetV3Bean> lstAntecedenteDetV3s) {
		this.lstAntecedenteDetV3s = lstAntecedenteDetV3s;
	}
	
	public void setAntecedResidencia(AntecedentesResidenciaBean antecedResidencia) {
		this.antecedResidencia = antecedResidencia;
	}
	
	public AntecedentesResidenciaBean getAntecedResidencia() {
		return antecedResidencia;
	}
	public List<AntecedentesOcupacionBean> getLstAntecendeOcupacion() {
		return lstAntecendeOcupacion;
	}
	public void setLstAntecendeOcupacion(
			List<AntecedentesOcupacionBean> lstAntecendeOcupacion) {
		this.lstAntecendeOcupacion = lstAntecendeOcupacion;
	}
	public String getObsAnteOcupacional() {
		return obsAnteOcupacional;
	}
	public void setObsAnteOcupacional(String obsAnteOcupacional) {
		this.obsAnteOcupacional = obsAnteOcupacional;
	}
	public AntecedentesPrenatalesBean getAntecedPrenatales() {
		return antecedPrenatales;
	}
	public void setAntecedPrenatales(AntecedentesPrenatalesBean antecedPrenatales) {
		this.antecedPrenatales = antecedPrenatales;
	}
	public AntecedentesNatalesBean  getAntecedNatales() {
		return antecedNatales;
	}
	public void setAntecedNatales(AntecedentesNatalesBean antecedNatales) {
		this.antecedNatales = antecedNatales;
	}
	public AntecedentesAlimentacionBean getAntecedAlimentacion() {
		return antecedAlimentacion;
	}
	public void setAntecedAlimentacion(AntecedentesAlimentacionBean antecedAlimentacion) {
		this.antecedAlimentacion = antecedAlimentacion;
	}
	public AntecedentesInmunizacionesBean getAntecedInmunizaciones() {
		return antecedInmunizaciones;
	}
	public void setAntecedInmunizaciones(AntecedentesInmunizacionesBean antecedInmunizaciones) {
		this.antecedInmunizaciones = antecedInmunizaciones;
	}
	public AntecedentesDesPsicomotrizBean getAntecedDesPsicomotriz() {
		return antecedDesPsicomotriz;
	}
	public void setAntecedDesPsicomotriz(AntecedentesDesPsicomotrizBean antecedDesPsicomotriz) {
		this.antecedDesPsicomotriz = antecedDesPsicomotriz;
	}
	
	
}
