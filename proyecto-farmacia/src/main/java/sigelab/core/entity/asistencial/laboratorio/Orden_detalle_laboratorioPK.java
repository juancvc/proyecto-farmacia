package sigelab.core.entity.asistencial.laboratorio;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the REFEDIAG database table.
 * 
 */
@Embeddable
public class Orden_detalle_laboratorioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CODORGAN")
	private String codorgan;

	@Column(name="CODINSTI")
	private String codinsti;

	@Column(name="CODSEDEI")
	private String codsedei;

	@Column(name="CODORDDE")
	private String codOrdde;

	@Column(name="NROVERSI")
	private String nroversi;

	@Column(name="NROPERIO")
	private String nroperio;

	public Orden_detalle_laboratorioPK() {
	}
	public String getCodorgan() {
		return this.codorgan;
	}
	public void setCodorgan(String codorgan) {
		this.codorgan = codorgan;
	}
	public String getCodinsti() {
		return this.codinsti;
	}
	public void setCodinsti(String codinsti) {
		this.codinsti = codinsti;
	}
	public String getCodsedei() {
		return this.codsedei;
	}
	public void setCodsedei(String codsedei) {
		this.codsedei = codsedei;
	}  
 
	public String getCodOrdde() {
		return codOrdde;
	}
	public void setCodOrdde(String codOrdde) {
		this.codOrdde = codOrdde;
	}
	public String getNroversi() {
		return this.nroversi;
	}
	public void setNroversi(String nroversi) {
		this.nroversi = nroversi;
	}
	public String getNroperio() {
		return this.nroperio;
	}
	public void setNroperio(String nroperio) {
		this.nroperio = nroperio;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Orden_detalle_laboratorioPK)) {
			return false;
		}
		Orden_detalle_laboratorioPK castOther = (Orden_detalle_laboratorioPK)other;
		return 
			this.codorgan.equals(castOther.codorgan)
			&& this.codinsti.equals(castOther.codinsti)
			&& this.codsedei.equals(castOther.codsedei)
			&& this.codOrdde.equals(castOther.codOrdde)
			&& this.nroversi.equals(castOther.nroversi)
			&& this.nroperio.equals(castOther.nroperio);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codorgan.hashCode();
		hash = hash * prime + this.codinsti.hashCode();
		hash = hash * prime + this.codsedei.hashCode();
		hash = hash * prime + this.codOrdde.hashCode();
		hash = hash * prime + this.nroversi.hashCode();
		hash = hash * prime + this.nroperio.hashCode();
		
		return hash;
	}
}