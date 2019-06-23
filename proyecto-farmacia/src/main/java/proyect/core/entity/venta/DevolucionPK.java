package proyect.core.entity.venta;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the VENTA database table.
 * 
 */
@Embeddable
public class DevolucionPK implements Serializable {
	private static final long serialVersionUID = 1L; 
	
	@Column(name="numeroPeriodo")
	private String numeroPeriodo;

	@Column(name="idDevolucion")
	private String idDevolucion;

	public DevolucionPK() {
	}
	 
	public String getNumeroPeriodo() {
		return numeroPeriodo;
	}

	public void setNumeroPeriodo(String numeroPeriodo) {
		this.numeroPeriodo = numeroPeriodo;
	}

	public String getIdDevolucion() {
		return idDevolucion;
	}

	public void setIdDevolucion(String idDevolucion) {
		this.idDevolucion = idDevolucion;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DevolucionPK)) {
			return false;
		}
		DevolucionPK castOther = (DevolucionPK)other;
		return 
			 (this.numeroPeriodo == castOther.numeroPeriodo)
			&& (this.idDevolucion == castOther.idDevolucion);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.numeroPeriodo.hashCode();
		hash = hash * prime + this.idDevolucion.hashCode();
		
		return hash;
	}

	@Override
	public String toString() {
		return "DevolucionPK [numeroPeriodo=" + numeroPeriodo + ", idDevolucion=" + idDevolucion + "]";
	}
	 
	
	
}