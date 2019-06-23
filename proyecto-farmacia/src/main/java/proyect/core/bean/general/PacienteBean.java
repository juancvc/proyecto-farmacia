package proyect.core.bean.general;

import proyect.base.bean.BaseBean;

public class PacienteBean extends BaseBean {
	
	private PersonaBean persona;
	private String	nroIEDS;
	private String	nroHC;
    private CatalogoBean tipoPaciente;
    
    
	public PersonaBean getPersona() {
		return persona;
	}
	public void setPersona(PersonaBean persona) {
		this.persona = persona;
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
	public CatalogoBean getTipoPaciente() {
		return tipoPaciente;
	}
	public void setTipoPaciente(CatalogoBean tipoPaciente) {
		this.tipoPaciente = tipoPaciente;
	}
	
	
}