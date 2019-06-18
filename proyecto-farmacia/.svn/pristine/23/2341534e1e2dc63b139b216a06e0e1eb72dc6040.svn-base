package hnch.referencia.core.entity.asistencial.referencia;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the DXRESULT database table.
 * 
 */
@Embeddable
public class DxresultPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CODORGAN")
	private String codorgan;

	@Column(name="CODINSTI")
	private String codinsti;

	@Column(name="CODSEDEI")
	private String codsedei;

	@Column(name="CODDXRES")
	private String coddxres;

	@Column(name="NROVERSI")
	private String nroversi;

	@Column(name="NROPERIO")
	private String nroperio;

	public DxresultPK() {
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
	public String getCoddxres() {
		return this.coddxres;
	}
	public void setCoddxres(String coddxres) {
		this.coddxres = coddxres;
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
		if (!(other instanceof DxresultPK)) {
			return false;
		}
		DxresultPK castOther = (DxresultPK)other;
		return 
			this.codorgan.equals(castOther.codorgan)
			&& this.codinsti.equals(castOther.codinsti)
			&& this.codsedei.equals(castOther.codsedei)
			&& this.coddxres.equals(castOther.coddxres)
			&& this.nroversi.equals(castOther.nroversi)
			&& this.nroperio.equals(castOther.nroperio);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codorgan.hashCode();
		hash = hash * prime + this.codinsti.hashCode();
		hash = hash * prime + this.codsedei.hashCode();
		hash = hash * prime + this.coddxres.hashCode();
		hash = hash * prime + this.nroversi.hashCode();
		hash = hash * prime + this.nroperio.hashCode();
		
		return hash;
	}
}