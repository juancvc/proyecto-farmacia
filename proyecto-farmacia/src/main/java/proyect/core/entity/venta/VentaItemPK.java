package proyect.core.entity.venta;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class VentaItemPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="numeroPeriodo")
	private int numeroPeriodo;

	@Column(name="idVentaitem")
	private String idVentaitem;
 

	public int getNumeroPeriodo() {
		return numeroPeriodo;
	}

	public void setNumeroPeriodo(int numeroPeriodo) {
		this.numeroPeriodo = numeroPeriodo;
	}

	public String getIdVentaitem() {
		return this.idVentaitem;
	}
	public void setIdVentaitem(String idVentaitem) {
		this.idVentaitem = idVentaitem;
	} 

	public VentaItemPK() {
	}
	 
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof VentaItemPK)) {
			return false;
		}
		VentaItemPK castOther = (VentaItemPK)other;
		return 
			 (this.numeroPeriodo == castOther.numeroPeriodo)
			&& (this.idVentaitem == castOther.idVentaitem); 
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.numeroPeriodo;
		hash = hash * prime + this.idVentaitem.hashCode(); 
		
		return hash;
	}

	@Override
	public String toString() {
		return "VentaItemPK [numeroPeriodo=" + numeroPeriodo + ", idVentaitem=" + idVentaitem + "]";
	}
	
}