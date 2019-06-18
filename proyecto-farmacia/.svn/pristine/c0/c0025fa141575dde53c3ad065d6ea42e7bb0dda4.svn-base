package hnch.referencia.core.entity.general;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the EMPRESAH database table.
 * 
 */
@Embeddable
public class DirxperPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;



	@Column(name="CODDIXPE")
	private String coddixpe;

	@Column(name="CODPERSO")
	private String codperso;


	public DirxperPK() {
	}

	public String getCoddixpe() {
		return this.coddixpe;
	}
	public void setCoddixpe(String coddixpe) {
		this.coddixpe = coddixpe;
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
		if (!(other instanceof DirxperPK)) {
			return false;
		}
		DirxperPK castOther = (DirxperPK)other;
		return 
		
			 this.coddixpe.equals(castOther.coddixpe)
			&& this.codperso.equals(castOther.codperso);
			
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;

		hash = hash * prime + this.coddixpe.hashCode();
		hash = hash * prime + this.codperso.hashCode();
	
		
		return hash;
	}
}