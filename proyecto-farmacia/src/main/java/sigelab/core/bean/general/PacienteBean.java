package sigelab.core.bean.general;



import sigelab.base.bean.BaseBean;

import sigelab.core.bean.general.antecedentes.AlergiaMedicaBean;

import sigelab.core.bean.general.antecedentes.AntecedenteMedicoBean;
import sigelab.core.bean.general.antecedentes.AntecedentesAdiccionBean;
import sigelab.core.bean.general.antecedentes.AntecedentesAlergiaBean;
import sigelab.core.bean.general.antecedentes.AntecedentesCirugiaBean;
import sigelab.core.bean.general.antecedentes.AntecedentesEnfermedadBean;
import sigelab.core.bean.general.antecedentes.AntecedentesFarmacoBean;
import sigelab.core.bean.general.antecedentes.AntecedentesOtrosBean;
import sigelab.core.bean.general.antecedentes.AntecedentesPacienteBean;

import sigelab.core.bean.general.antecedentes.MedicamentoHabitualBean;


import sigelab.core.bean.general.antecedentes.MedicamentoHabitualBean; 


import java.util.ArrayList;
import java.util.Date;

import org.codehaus.jackson.map.deser.ValueInstantiators.Base;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;



public
class PacienteBean extends BaseBean {
	
	private PersonaBean persona;
	private String	nroIEDS;
	private String	nroHC;
	private String  Ind; 
	private String	codigoPaciente;
	private	TablaBean   estadoHC;
    
	private List<AlergiaMedicaBean>			alergiasMedicas;
	private List<AntecedenteMedicoBean>		antecedententesMedicos;
	private List<MedicamentoHabitualBean>	medicamentosHabituales;
	
	/************************************************************/
	//Antecedentes Paciente V2
	private AntecedentesPacienteBean antecedentesPaciente;
	/************************************************************/
	//Antecedentes 
	private List<AntecedentesAdiccionBean> lstAntecedentesAdiccion = new ArrayList<AntecedentesAdiccionBean>();	
	private List<AntecedentesAlergiaBean> lstAntecedentesAlergia = new ArrayList<AntecedentesAlergiaBean>();
	private List<AntecedentesFarmacoBean> lstAntecedentesFarmacos = new ArrayList<AntecedentesFarmacoBean>();
	private List<AntecedentesEnfermedadBean> lstAntecedentesEnfermedad = new ArrayList<AntecedentesEnfermedadBean>();
	private List<AntecedentesCirugiaBean> lstAntecedentesCirugias = new ArrayList<AntecedentesCirugiaBean>();
	private List<AntecedentesOtrosBean> lstAntecedentesOtros = new ArrayList<AntecedentesOtrosBean>();
	
	/******************** PACIENTE NN *****************************/
	private TablaBean   tg1colpi;
	private TablaBean   tg1conco;
	private TablaBean	tg1conca;
	private TablaBean	tg1colca;
	private TablaBean	tg1lonca;
	private TablaBean	tg1forca;
	private TablaBean	tg1edadr;
	private String  detalles;
	private TablaBean	especialidad;
	
	private String antecedentesOtros;
	private String nroHCModificar;
	private String nroTicket;
	
	private boolean flagTipoPac; // para insertar o no HC 
	private String nroIEDSRN;
	private String codigoA ;//pacientes que tienen de triaje a atenci�n inmediata

	private boolean swNuevoHC = false;
	
//	private Episodio episodioPacienteTriaje;
	/**************************************************************/
	
	private TablaBean	tipoSeguro;
	private String		categoriaSeguro;
	private String		codigoFiliacion;
	private Boolean     swValidaSISwebService;
	
	private String		idErrorWSIS;
	private String	codigoPacienteSigeho;
	
	public PacienteBean() {
		super();
	}
	public String getNroIEDS() {
		return nroIEDS;
	}
	public void setNroIEDS(String nroIEDS) {
		this.nroIEDS = nroIEDS;
	}
	public String getNroHC() {
		return nroHC;
	}
	public void setNroHC(String nroHC) {
		this.nroHC = nroHC;
	}
	public void setCodigoPaciente(String codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}
	public String getCodigoPaciente() {
		return codigoPaciente;
	}
	public List<AlergiaMedicaBean> getAlergiasMedicas() {
		return alergiasMedicas;
	}
	public void setAlergiasMedicas(List<AlergiaMedicaBean> alergiasMedicas) {
		this.alergiasMedicas = alergiasMedicas;
	}
	public List<AntecedenteMedicoBean> getAntecedententesMedicos() {
		return antecedententesMedicos;
	}
	public void setAntecedententesMedicos(
			List<AntecedenteMedicoBean> antecedententesMedicos) {
		this.antecedententesMedicos = antecedententesMedicos;
	}
	public List<MedicamentoHabitualBean> getMedicamentosHabituales() {
		return medicamentosHabituales;
	}
	public void setMedicamentosHabituales(
			List<MedicamentoHabitualBean> medicamentosHabituales) {
		this.medicamentosHabituales = medicamentosHabituales;
	}
	public List<AntecedentesAdiccionBean> getLstAntecedentesAdiccion() {
		return lstAntecedentesAdiccion;
	}
	public void setLstAntecedentesAdiccion(
			List<AntecedentesAdiccionBean> lstAntecedentesAdiccion) {
		this.lstAntecedentesAdiccion = lstAntecedentesAdiccion;
	}
	public List<AntecedentesAlergiaBean> getLstAntecedentesAlergia() {
		return lstAntecedentesAlergia;
	}
	public void setLstAntecedentesAlergia(
			List<AntecedentesAlergiaBean> lstAntecedentesAlergia) {
		this.lstAntecedentesAlergia = lstAntecedentesAlergia;
	}
	public List<AntecedentesFarmacoBean> getLstAntecedentesFarmacos() {
		return lstAntecedentesFarmacos;
	}
	public void setLstAntecedentesFarmacos(
			List<AntecedentesFarmacoBean> lstAntecedentesFarmacos) {
		this.lstAntecedentesFarmacos = lstAntecedentesFarmacos;
	}
	public List<AntecedentesEnfermedadBean> getLstAntecedentesEnfermedad() {
		return lstAntecedentesEnfermedad;
	}
	public void setLstAntecedentesEnfermedad(
			List<AntecedentesEnfermedadBean> lstAntecedentesEnfermedad) {
		this.lstAntecedentesEnfermedad = lstAntecedentesEnfermedad;
	}
	
	public List<AntecedentesCirugiaBean> getLstAntecedentesCirugias() {
		return lstAntecedentesCirugias;
	}
	public void setLstAntecedentesCirugias(
			List<AntecedentesCirugiaBean> lstAntecedentesCirugias) {
		this.lstAntecedentesCirugias = lstAntecedentesCirugias;
	}
	
	public TablaBean getTg1colpi() {
		return tg1colpi;
	}
	public void setTg1colpi(TablaBean tg1colpi) {
		this.tg1colpi = tg1colpi;
	}
	public TablaBean getTg1conco() {
		return tg1conco;
	}
	public void setTg1conco(TablaBean tg1conco) {
		this.tg1conco = tg1conco;
	}
	public TablaBean getTg1conca() {
		return tg1conca;
	}
	public void setTg1conca(TablaBean tg1conca) {
		this.tg1conca = tg1conca;
	}
	public TablaBean getTg1colca() {
		return tg1colca;
	}
	public void setTg1colca(TablaBean tg1colca) {
		this.tg1colca = tg1colca;
	}
	public TablaBean getTg1lonca() {
		return tg1lonca;
	}
	public void setTg1lonca(TablaBean tg1lonca) {
		this.tg1lonca = tg1lonca;
	}
	public TablaBean getTg1forca() {
		return tg1forca;
	}
	public void setTg1forca(TablaBean tg1forca) {
		this.tg1forca = tg1forca;
	}
	public TablaBean getTg1edadr() {
		return tg1edadr;
	}
	public void setTg1edadr(TablaBean tg1edadr) {
		this.tg1edadr = tg1edadr;
	}
	public String getDetalles() {
		return detalles;
	}
	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
	public String getAntecedentesOtros() {
		return antecedentesOtros;
	}
	public void setAntecedentesOtros(String antecedentesOtros) {
		this.antecedentesOtros = antecedentesOtros;
	}
	public List<AntecedentesOtrosBean> getLstAntecedentesOtros() {
		return lstAntecedentesOtros;
	}
	public void setLstAntecedentesOtros(List<AntecedentesOtrosBean> lstAntecedentesOtros) {
		this.lstAntecedentesOtros = lstAntecedentesOtros;
	}
	public void setInd(String ind) {
		Ind = ind;
	}
	public String getInd() {
		return Ind;
	}
	public TablaBean getEstadoHC() {
		return estadoHC;
	}
	public void setEstadoHC(TablaBean estadoHC) {
		this.estadoHC = estadoHC;
	}
	public String getNroHCModificar() {
		return nroHCModificar;
	}
	public void setNroHCModificar(String nroHCModificar) {
		this.nroHCModificar = nroHCModificar;
	}
	public AntecedentesPacienteBean getAntecedentesPaciente() {
		return antecedentesPaciente;
	}
	public void setAntecedentesPaciente(AntecedentesPacienteBean antecedentesPaciente) {
		this.antecedentesPaciente = antecedentesPaciente;
	}
	public TablaBean getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(TablaBean especialidad) {
		this.especialidad = especialidad;
	}
	public String getNroTicket() {
		return nroTicket;
	}
	public void setNroTicket(String nroTicket) {
		this.nroTicket = nroTicket;
	}
	
	public boolean getFlagTipoPac() {
		return flagTipoPac;
	}
	public void setFlagTipoPac(boolean flagTipoPac) {
		this.flagTipoPac = flagTipoPac;
	}
 
	public String getNroIEDSRN() {
		return nroIEDSRN;
	}
	public void setNroIEDSRN(String nroIEDSRN) {
		this.nroIEDSRN = nroIEDSRN;
	}
	
	public boolean isSwNuevoHC() {
		return swNuevoHC;
	} 
	public void setSwNuevoHC(boolean swNuevoHC) {
		this.swNuevoHC = swNuevoHC;
	}  
	public String getCodigoA() {
		return codigoA;
	}
	public void setCodigoA(String codigoA) {
		this.codigoA = codigoA;
	}
	public TablaBean getTipoSeguro() {
		if (tipoSeguro == null) {
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
	public PersonaBean getPersona() {
		if (persona == null) {
			persona = new PersonaBean();
		}
		return persona;
	}
	public void setPersona(PersonaBean persona) {
		this.persona = persona;
	}
	public String getCodigoFiliacion() {
		return codigoFiliacion;
	}
	public void setCodigoFiliacion(String codigoFiliacion) {
		this.codigoFiliacion = codigoFiliacion;
	}
	public Boolean getSwValidaSISwebService() {
		if (swValidaSISwebService == null) {
			swValidaSISwebService = false;
		}
		return swValidaSISwebService;
	}
	public void setSwValidaSISwebService(Boolean swValidaSISwebService) {
		this.swValidaSISwebService = swValidaSISwebService;
	}
	public String getIdErrorWSIS() {
		return idErrorWSIS;
	}
	public void setIdErrorWSIS(String idErrorWSIS) {
		this.idErrorWSIS = idErrorWSIS;
	}
	public String getCodigoPacienteSigeho() {
		return codigoPacienteSigeho;
	}
	public void setCodigoPacienteSigeho(String codigoPacienteSigeho) {
		this.codigoPacienteSigeho = codigoPacienteSigeho;
	}
 
}