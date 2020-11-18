package proyect.core.entity.cuentaCorriente;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class CuentaCorrienteItemPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="NRPERCTC")
	private int numeroPeriodo;

	@Column(name="CODRGCTC")
	private String idCuentaCorrienteitem;
 

	public int getNumeroPeriodo() {
		return numeroPeriodo;
	}

	public void setNumeroPeriodo(int numeroPeriodo) {
		this.numeroPeriodo = numeroPeriodo;
	}

	

	public String getIdCuentaCorrienteitem() {
		return idCuentaCorrienteitem;
	}

	public void setIdCuentaCorrienteitem(String idCuentaCorrienteitem) {
		this.idCuentaCorrienteitem = idCuentaCorrienteitem;
	}

	public CuentaCorrienteItemPK() {
	}
	 
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CuentaCorrienteItemPK)) {
			return false;
		}
		CuentaCorrienteItemPK castOther = (CuentaCorrienteItemPK)other;
		return 
			 (this.numeroPeriodo == castOther.numeroPeriodo)
			&& (this.idCuentaCorrienteitem == castOther.idCuentaCorrienteitem); 
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.numeroPeriodo;
		hash = hash * prime + this.idCuentaCorrienteitem.hashCode(); 
		
		return hash;
	}

	@Override
	public String toString() {
		return "VentaItemPK [numeroPeriodo=" + numeroPeriodo + ", idCuentaCorrienteitem=" + idCuentaCorrienteitem + "]";
	}
	
}