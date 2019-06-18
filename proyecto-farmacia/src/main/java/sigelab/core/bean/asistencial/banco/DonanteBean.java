package sigelab.core.bean.asistencial.banco;

import sigelab.base.bean.BaseBean;
import sigelab.core.bean.general.PersonaBean;
import sigelab.core.bean.general.TablaBean;

public class DonanteBean  extends BaseBean{
	
	private CampaniaBean campania; 
	private PersonaBean persona; 
	private String ultimaFechaDonacion; 
	private String sFecha ;
	private String sHora ;
	private TablaBean tipoRegistro;

	public PersonaBean getPersona() {
		return persona;
	}

	public void setPersona(PersonaBean persona) {
		if (persona == null) {
			persona = new PersonaBean();
		}
		this.persona = persona;
	}

	public CampaniaBean getCampania() {
		return campania;
	}

	public void setCampania(CampaniaBean campania) {
		this.campania = campania;
	}

	public String getUltimaFechaDonacion() {
		return ultimaFechaDonacion;
	}

	public void setUltimaFechaDonacion(String ultimaFechaDonacion) {
		this.ultimaFechaDonacion = ultimaFechaDonacion;
	}

	public String getsFecha() {
		return sFecha;
	}

	public void setsFecha(String sFecha) {
		this.sFecha = sFecha;
	}

	public String getsHora() {
		return sHora;
	}

	public void setsHora(String sHora) {
		this.sHora = sHora;
	}

	public TablaBean getTipoRegistro() {
		if (tipoRegistro == null) {
			tipoRegistro = new TablaBean();
		}
		return tipoRegistro;
	}

	public void setTipoRegistro(TablaBean tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	@Override
	public String toString() {
		return "DonanteBean [campania=" + campania + ", persona=" + persona + ", ultimaFechaDonacion="
				+ ultimaFechaDonacion + ", sFecha=" + sFecha + ", sHora=" + sHora + ", tipoRegistro=" + tipoRegistro
				+ "]";
	}

	 
	
}
