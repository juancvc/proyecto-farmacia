package proyect.core.entity.compra;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the Compra database table.
 * 
 */
@Embeddable
public class CompraPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="numeroPeriodo")
	private String numeroPeriodo;

	@Column(name="idCompra")
	private String idCompra;

	public CompraPK() {
	}
	 

	public String getNumeroPeriodo() {
		return numeroPeriodo;
	}

	public void setNumeroPeriodo(String numeroPeriodo) {
		this.numeroPeriodo = numeroPeriodo;
	}

	public String getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(String idCompra) {
		this.idCompra = idCompra;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CompraPK)) {
			return false;
		}
		CompraPK castOther = (CompraPK)other;
		return 
				(this.numeroPeriodo == castOther.numeroPeriodo)
			&& (this.idCompra == castOther.idCompra);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.numeroPeriodo.hashCode();
		hash = hash * prime + this.idCompra.hashCode();
		
		return hash;
	}


	@Override
	public String toString() {
		return "CompraPK [numeroPeriodo=" + numeroPeriodo + ", idCompra=" + idCompra + "]";
	}
	
}