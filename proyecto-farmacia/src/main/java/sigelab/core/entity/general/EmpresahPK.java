package sigelab.core.entity.general;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the EMPRESAH database table.
 * 
 */
@Embeddable
public class EmpresahPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CODINSTI")
	private String codinsti;

	@Column(name="CODORGAN")
	private String codorgan;

	@Column(name="NROPERIO")
	private String nroperio;

	@Column(name="CODEMPRE")
	private String codempre;

	@Column(name="NROVERSI")
	private String nroversi;

	@Column(name="NUMERRUC")
	private String numerruc;

	public EmpresahPK() {
	}
	public String getCodinsti() {
		return this.codinsti;
	}
	public void setCodinsti(String codinsti) {
		this.codinsti = codinsti;
	}
	public String getCodorgan() {
		return this.codorgan;
	}
	public void setCodorgan(String codorgan) {
		this.codorgan = codorgan;
	}
	public String getNroperio() {
		return this.nroperio;
	}
	public void setNroperio(String nroperio) {
		this.nroperio = nroperio;
	}
	public String getCodempre() {
		return this.codempre;
	}
	public void setCodempre(String codempre) {
		this.codempre = codempre;
	}
	public String getNroversi() {
		return this.nroversi;
	}
	public void setNroversi(String nroversi) {
		this.nroversi = nroversi;
	}
	public String getNumerruc() {
		return this.numerruc;
	}
	public void setNumerruc(String numerruc) {
		this.numerruc = numerruc;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EmpresahPK)) {
			return false;
		}
		EmpresahPK castOther = (EmpresahPK)other;
		return 
			this.codinsti.equals(castOther.codinsti)
			&& this.codorgan.equals(castOther.codorgan)
			&& this.nroperio.equals(castOther.nroperio)
			&& this.codempre.equals(castOther.codempre)
			&& this.nroversi.equals(castOther.nroversi)
			&& this.numerruc.equals(castOther.numerruc);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codinsti.hashCode();
		hash = hash * prime + this.codorgan.hashCode();
		hash = hash * prime + this.nroperio.hashCode();
		hash = hash * prime + this.codempre.hashCode();
		hash = hash * prime + this.nroversi.hashCode();
		hash = hash * prime + this.numerruc.hashCode();
		
		return hash;
	}
}