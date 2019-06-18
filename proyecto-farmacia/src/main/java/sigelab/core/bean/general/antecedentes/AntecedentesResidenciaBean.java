package sigelab.core.bean.general.antecedentes;

import java.util.List;



import sigelab.base.bean.BaseBean;
import sigelab.core.bean.general.TablaBean;

public class AntecedentesResidenciaBean extends BaseBean{
	private int nroHabitaciones;
	private int nroPersonas;
	private TablaBean tipoVivienda;
	private TablaBean materialVivienda;
	private boolean swMovilidad;
	private boolean swCrianzaAnimales;
	private AntecedentesPacienteBean antecenPaciente;
	
	private List<ServicioBasicoBean> lstServicioBasico;
	
	public AntecedentesResidenciaBean(){
		super();
	}

	public int getNroHabitaciones() {
		return nroHabitaciones;
	}

	public void setNroHabitaciones(int nroHabitaciones) {
		this.nroHabitaciones = nroHabitaciones;
	}

	public int getNroPersonas() {
		return nroPersonas;
	}

	public void setNroPersonas(int nroPersonas) {
		this.nroPersonas = nroPersonas;
	}

	public TablaBean getTipoVivienda() {
		return tipoVivienda;
	}

	public void setTipoVivienda(TablaBean tipoVivienda) {
		this.tipoVivienda = tipoVivienda;
	}

	public TablaBean getMaterialVivienda() {
		return materialVivienda;
	}

	public void setMaterialVivienda(TablaBean materialVivienda) {
		this.materialVivienda = materialVivienda;
	}

	public boolean isSwMovilidad() {
		return swMovilidad;
	}

	public void setSwMovilidad(boolean swMovilidad) {
		this.swMovilidad = swMovilidad;
	}

	public boolean isSwCrianzaAnimales() {
		return swCrianzaAnimales;
	}
	
	public void setSwCrianzaAnimales(boolean swCrianzaAnimales) {
		this.swCrianzaAnimales = swCrianzaAnimales;
	}
	
	public List<ServicioBasicoBean> getLstServicioBasico() {
		return lstServicioBasico;
	}

	public void setLstServicioBasico(List<ServicioBasicoBean> lstServicioBasico) {
		this.lstServicioBasico = lstServicioBasico;
	}

	public AntecedentesPacienteBean getAntecenPaciente() {
		return antecenPaciente;
	}

	public void setAntecenPaciente(AntecedentesPacienteBean antecenPaciente) {
		this.antecenPaciente = antecenPaciente;
	}
	
	
}
