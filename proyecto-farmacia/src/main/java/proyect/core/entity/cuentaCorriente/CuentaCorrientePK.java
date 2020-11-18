package proyect.core.entity.cuentaCorriente;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class CuentaCorrientePK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="NRPERCTC")
	private String numeroPeriodo;

	@Column(name="CODRGCTC")
	private String idCuentaCorriente;
 
	@Column(name="NRVERCTC")
	private String numeroVersion;

	public String getNumeroPeriodo() {
		return numeroPeriodo;
	}

	public void setNumeroPeriodo(String numeroPeriodo) {
		this.numeroPeriodo = numeroPeriodo;
	}

	

	public String getIdCuentaCorriente() {
		return idCuentaCorriente;
	}

	public void setIdCuentaCorriente(String idCuentaCorriente) {
		this.idCuentaCorriente = idCuentaCorriente;
	}
	
	
	

	public String getNumeroVersion() {
		return numeroVersion;
	}

	public void setNumeroVersion(String numeroVersion) {
		this.numeroVersion = numeroVersion;
	}

	public CuentaCorrientePK() {
	}
	 
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CuentaCorrientePK)) {
			return false;
		}
		CuentaCorrientePK castOther = (CuentaCorrientePK)other;
		return 
			 (this.numeroPeriodo == castOther.numeroPeriodo)
			&& (this.idCuentaCorriente == castOther.idCuentaCorriente)&& (this.numeroVersion == castOther.numeroVersion); 
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.numeroPeriodo.hashCode();
		hash = hash * prime + this.idCuentaCorriente.hashCode(); 
		hash = hash * prime + this.numeroVersion.hashCode();
		
		return hash;
	}

	@Override
	public String toString() {
		return "VentaItemPK [numeroPeriodo=" + numeroPeriodo + ", idCuentaCorriente=" + idCuentaCorriente + "]";
	}
	
}