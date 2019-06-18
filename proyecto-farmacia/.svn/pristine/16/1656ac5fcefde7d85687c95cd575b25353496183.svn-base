package hnch.referencia.core.entity.asistencial.referencia;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the [ATEN.REFESPEC_] database table.
 * 
 */
@Embeddable
public class ReferenciaEspecialidadPK implements Serializable {
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

	@Column(name="NROVERSI")
	private String nroversi;

	@Column(name="CODREGIS")
	private String codregis;

	public ReferenciaEspecialidadPK() {
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
	public String getNroversi() {
		return this.nroversi;
	}
	public void setNroversi(String nroversi) {
		this.nroversi = nroversi;
	}
	public String getCodregis() {
		return this.codregis;
	}
	public void setCodregis(String codregis) {
		this.codregis = codregis;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ReferenciaEspecialidadPK)) {
			return false;
		}
		ReferenciaEspecialidadPK castOther = (ReferenciaEspecialidadPK)other;
		return 
			this.codorgan.equals(castOther.codorgan)
			&& this.codinsti.equals(castOther.codinsti)
			&& this.codsedei.equals(castOther.codsedei)
			&& this.nroperio.equals(castOther.nroperio)
			&& this.nroversi.equals(castOther.nroversi)
			&& this.codregis.equals(castOther.codregis);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codorgan.hashCode();
		hash = hash * prime + this.codinsti.hashCode();
		hash = hash * prime + this.codsedei.hashCode();
		hash = hash * prime + this.nroperio.hashCode();
		hash = hash * prime + this.nroversi.hashCode();
		hash = hash * prime + this.codregis.hashCode();
		
		return hash;
	}
}