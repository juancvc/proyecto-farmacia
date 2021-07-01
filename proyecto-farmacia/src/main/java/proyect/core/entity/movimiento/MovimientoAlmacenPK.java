package proyect.core.entity.movimiento;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class MovimientoAlmacenPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="numeroPeriodo")
	private String numeroPeriodo;

	@Column(name="idMovimiento")
	private String idMovimientoAlmacen;;
 

	public String getNumeroPeriodo() {
		return numeroPeriodo;
	}

	public void setNumeroPeriodo(String numeroPeriodo) {
		this.numeroPeriodo = numeroPeriodo;
	}
 
	public String getIdMovimientoAlmacen() {
		return idMovimientoAlmacen;
	}

	public void setIdMovimientoAlmacen(String idMovimientoAlmacen) {
		this.idMovimientoAlmacen = idMovimientoAlmacen;
	}

	public MovimientoAlmacenPK() {
	}
	 
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MovimientoAlmacenPK)) {
			return false;
		}
		MovimientoAlmacenPK castOther = (MovimientoAlmacenPK)other;
		return 
			 (this.numeroPeriodo == castOther.numeroPeriodo)
			&& (this.idMovimientoAlmacen == castOther.idMovimientoAlmacen); 
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.numeroPeriodo.hashCode();
		hash = hash * prime + this.idMovimientoAlmacen.hashCode(); 
		
		return hash;
	}

	@Override
	public String toString() {
		return "VentaItemPK [numeroPeriodo=" + numeroPeriodo + ", idMovimientoAlmacen=" + idMovimientoAlmacen + "]";
	}
	
}