package sigelab.core.entity.general;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PACIENTE database table.
 * 
 */
@Embeddable
public class PacientePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CODORGAN")
	private String codorgan;

	@Column(name="CODINSTI")
	private String codinsti;

	@Column(name="CODSEDEI")
	private String codsedei;

	@Column(name="CODVERSI")
	private String codversi;

	@Column(name="CODPACIE")
	private String codpacie;

	@Column(name="NROVERSI")
	private String nroversi;

	@Column(name="NROPERIO")
	private String nroPerio;

	public PacientePK() {
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
	public String getCodversi() {
		return this.codversi;
	}
	public void setCodversi(String codversi) {
		this.codversi = codversi;
	}
	public String getCodpacie() {
		return this.codpacie;
	}
	public void setCodpacie(String codpacie) {
		this.codpacie = codpacie;
	}
	public String getNroversi() {
		return this.nroversi;
	}
	public void setNroversi(String nroversi) {
		this.nroversi = nroversi;
	} 

	public String getNroPerio() {
		return nroPerio;
	}
	public void setNroPerio(String nroPerio) {
		this.nroPerio = nroPerio;
	}
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PacientePK)) {
			return false;
		}
		PacientePK castOther = (PacientePK)other;
		return 
			this.codorgan.equals(castOther.codorgan)
			&& this.codinsti.equals(castOther.codinsti)
			&& this.codsedei.equals(castOther.codsedei)
			&& this.codversi.equals(castOther.codversi)
			&& this.codpacie.equals(castOther.codpacie)
			&& this.nroversi.equals(castOther.nroversi) ;
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codorgan.hashCode();
		hash = hash * prime + this.codinsti.hashCode();
		hash = hash * prime + this.codsedei.hashCode();
		hash = hash * prime + this.codversi.hashCode();
		hash = hash * prime + this.codpacie.hashCode();
		hash = hash * prime + this.nroversi.hashCode(); 
		
		return hash;
	}
}