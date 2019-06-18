package hnch.referencia.core.entity.general;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the FAMILIAR database table.
 * 
 */
@Embeddable
public class FamiliarPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CODORGAN")
	private String codorgan;

	@Column(name="CODINSTI")
	private String codinsti;

	@Column(name="CODSEDEI")
	private String codsedei;

	@Column(name="NROPERIO")
	private String nroperio;

	@Column(name="CODFAMIL")
	private String codfamil;

	public FamiliarPK() {
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
	public String getNroperio() {
		return this.nroperio;
	}
	public void setNroperio(String nroperio) {
		this.nroperio = nroperio;
	}
	public String getCodfamil() {
		return this.codfamil;
	}
	public void setCodfamil(String codfamil) {
		this.codfamil = codfamil;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FamiliarPK)) {
			return false;
		}
		FamiliarPK castOther = (FamiliarPK)other;
		return 
			this.codorgan.equals(castOther.codorgan)
			&& this.codinsti.equals(castOther.codinsti)
			&& this.codsedei.equals(castOther.codsedei)
			&& this.nroperio.equals(castOther.nroperio)
			&& this.codfamil.equals(castOther.codfamil);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codorgan.hashCode();
		hash = hash * prime + this.codinsti.hashCode();
		hash = hash * prime + this.codsedei.hashCode();
		hash = hash * prime + this.nroperio.hashCode();
		hash = hash * prime + this.codfamil.hashCode();
		
		return hash;
	}
}