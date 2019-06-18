package sigelab.core.entity.asistencial.banco;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the REFEDIAG database table.
 * 
 */
@Embeddable
public class SeropositivoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CODORGAN")
	private String codorgan;

	@Column(name="CODINSTI")
	private String codinsti;

	@Column(name="CODSEDEI")
	private String codsedei;

	@Column(name="CODSERPT")
	private String codSerpt;

	@Column(name="NROVERSI")
	private String nroversi;

	@Column(name="NROPERIO")
	private String nroperio;
	
	@Column(name="NROPOST")
	private String nroPost;
	
	@Column(name="CODPERSO")
	private String codPerso;

	public SeropositivoPK() {
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
 
	public String getCodSerpt() {
		return codSerpt;
	}
	public void setCodSerpt(String codSerpt) {
		this.codSerpt = codSerpt;
	}
	public String getNroPost() {
		return nroPost;
	}
	public void setNroPost(String nroPost) {
		this.nroPost = nroPost;
	}
	public String getCodPerso() {
		return codPerso;
	}
	public void setCodPerso(String codPerso) {
		this.codPerso = codPerso;
	}
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SeropositivoPK)) {
			return false;
		}
		SeropositivoPK castOther = (SeropositivoPK)other;
		return 
			this.codorgan.equals(castOther.codorgan)
			&& this.codinsti.equals(castOther.codinsti)
			&& this.codsedei.equals(castOther.codsedei)
			&& this.codSerpt.equals(castOther.codSerpt)
			&& this.nroversi.equals(castOther.nroversi)
			&& this.nroPost.equals(castOther.nroPost)
			&& this.codPerso.equals(castOther.codPerso)
			&& this.nroperio.equals(castOther.nroperio);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codorgan.hashCode();
		hash = hash * prime + this.codinsti.hashCode();
		hash = hash * prime + this.codsedei.hashCode();
		hash = hash * prime + this.codSerpt.hashCode();
		hash = hash * prime + this.nroversi.hashCode();
		hash = hash * prime + this.nroperio.hashCode();
		hash = hash * prime + this.nroPost.hashCode();
		hash = hash * prime + this.codPerso.hashCode();
		
		return hash;
	}
}