package sigelab.core.bean.general.antecedentes;

import sigelab.base.bean.BaseBean;
import sigelab.core.bean.general.TablaBean;

public class ServicioBasicoBean extends BaseBean{
	private TablaBean servBasico;
	private boolean swMarcar = false;
	private AntecedentesResidenciaBean antecedentesResidencia;
	
	public ServicioBasicoBean(){
		super();
	}

	public TablaBean getServBasico() {
		return servBasico;
	}

	public void setServBasico(TablaBean servBasico) {
		this.servBasico = servBasico;
	}

	public boolean isSwMarcar() {
		return swMarcar;
	}

	public void setSwMarcar(boolean swMarcar) {
		this.swMarcar = swMarcar;
	}

	public AntecedentesResidenciaBean getAntecedentesResidencia() {
		return antecedentesResidencia;
	}

	public void setAntecedentesResidencia(
			AntecedentesResidenciaBean antecedentesResidencia) {
		this.antecedentesResidencia = antecedentesResidencia;
	}
	
	
}
