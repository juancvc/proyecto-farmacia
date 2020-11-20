package proyect.core.entity.compra;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class CompraItemPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="numeroPeriodo")
	private String numeroPeriodo;

	@Column(name="idCompraItem")
	private String idCompraItem;
 

	public String getNumeroPeriodo() {
		return numeroPeriodo;
	}

	public void setNumeroPeriodo(String numeroPeriodo) {
		this.numeroPeriodo = numeroPeriodo;
	}

	public String getIdCompraItem() {
		return this.idCompraItem;
	}
	public void setIdCompraItem(String idCompraItem) {
		this.idCompraItem = idCompraItem;
	} 

	public CompraItemPK() {
	}
	 
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CompraItemPK)) {
			return false;
		}
		CompraItemPK castOther = (CompraItemPK)other;
		return 
			 (this.numeroPeriodo == castOther.numeroPeriodo)
			&& (this.idCompraItem == castOther.idCompraItem); 
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.numeroPeriodo.hashCode();
		hash = hash * prime + this.idCompraItem.hashCode(); 
		
		return hash;
	}

	@Override
	public String toString() {
		return "CompraItemPK [numeroPeriodo=" + numeroPeriodo + ", idCompraItem=" + idCompraItem + "]";
	}
	
}