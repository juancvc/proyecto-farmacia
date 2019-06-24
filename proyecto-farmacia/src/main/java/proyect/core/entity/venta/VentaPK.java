package proyect.core.entity.venta;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the VENTA database table.
 * 
 */
@Embeddable
public class VentaPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="numeroPeriodo")
	private String numeroPeriodo;

	@Column(name="idVenta")
	private String idVenta;

	public VentaPK() {
	}
	 

	public String getNumeroPeriodo() {
		return numeroPeriodo;
	}

	public void setNumeroPeriodo(String numeroPeriodo) {
		this.numeroPeriodo = numeroPeriodo;
	}

	public String getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(String idVenta) {
		this.idVenta = idVenta;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof VentaPK)) {
			return false;
		}
		VentaPK castOther = (VentaPK)other;
		return 
				(this.numeroPeriodo == castOther.numeroPeriodo)
			&& (this.idVenta == castOther.idVenta);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.numeroPeriodo.hashCode();
		hash = hash * prime + this.idVenta.hashCode();
		
		return hash;
	}


	@Override
	public String toString() {
		return "VentaPK [numeroPeriodo=" + numeroPeriodo + ", idVenta=" + idVenta + "]";
	}
	
}