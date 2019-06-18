package sigelab.core.bean.general.antecedentes;

import java.util.ArrayList;
import java.util.List;

import sigelab.base.bean.BaseBean;

public class AntecedentesInmunizacionesBean extends BaseBean {
	private List<VacunaAntecedInmuBean> lstVacunas; 
	private String otrasVacunas;
	private String reaccionAdvVacunas;
	private AntecedentesPacienteBean antecedPac;
	
	public AntecedentesInmunizacionesBean(){
		lstVacunas = new ArrayList<VacunaAntecedInmuBean>();
	}

	public List<VacunaAntecedInmuBean> getLstVacunas() {
		return lstVacunas;
	}

	public void setLstVacunas(List<VacunaAntecedInmuBean> lstVacunas) {
		this.lstVacunas = lstVacunas;
	}

	public String getOtrasVacunas() {
		return otrasVacunas;
	}

	public void setOtrasVacunas(String otrasVacunas) {
		this.otrasVacunas = otrasVacunas;
	}

	public String getReaccionAdvVacunas() {
		return reaccionAdvVacunas;
	}

	public void setReaccionAdvVacunas(String reaccionAdvVacunas) {
		this.reaccionAdvVacunas = reaccionAdvVacunas;
	}

	public AntecedentesPacienteBean getAntecedPac() {
		return antecedPac;
	}

	public void setAntecedPac(AntecedentesPacienteBean antecedPac) {
		this.antecedPac = antecedPac;
	}
	
	
}
