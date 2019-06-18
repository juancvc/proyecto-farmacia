package sigelab.core.entity.asistencial.laboratorio;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PERSONAL database table.
 * 
 */
@Embeddable
public class Personal_laboratorioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CODORGAN")
	private String codorgan;

	@Column(name="CODINSTI")
	private String codinsti;

	@Column(name="CODSEDEI")
	private String codsedei;

	@Column(name="NROVERSI")
	private String nroversi;

	@Column(name="NROPERIO")
	private String nroperio;

	@Column(name="CODEMPLE")
	private String codemple;

	@Column(name="CODPERSO")
	private String codperso;

	public Personal_laboratorioPK() {
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
	public String getCodemple() {
		return this.codemple;
	}
	public void setCodemple(String codemple) {
		this.codemple = codemple;
	}
	public String getCodperso() {
		return this.codperso;
	}
	public void setCodperso(String codperso) {
		this.codperso = codperso;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Personal_laboratorioPK)) {
			return false;
		}
		Personal_laboratorioPK castOther = (Personal_laboratorioPK)other;
		return 
			this.codorgan.equals(castOther.codorgan)
			&& this.codinsti.equals(castOther.codinsti)
			&& this.codsedei.equals(castOther.codsedei)
			&& this.nroversi.equals(castOther.nroversi)
			&& this.nroperio.equals(castOther.nroperio)
			&& this.codemple.equals(castOther.codemple)
			&& this.codperso.equals(castOther.codperso);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codorgan.hashCode();
		hash = hash * prime + this.codinsti.hashCode();
		hash = hash * prime + this.codsedei.hashCode();
		hash = hash * prime + this.nroversi.hashCode();
		hash = hash * prime + this.nroperio.hashCode();
		hash = hash * prime + this.codemple.hashCode();
		hash = hash * prime + this.codperso.hashCode();
		
		return hash;
	}
}