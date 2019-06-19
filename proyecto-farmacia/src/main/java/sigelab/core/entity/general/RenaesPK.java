package pe.com.galaxy.systems.apolo.core.entidad.entidad.general;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the Renaes database table.
 * 
 */
@Embeddable
public class RenaesPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CodigoOrganizacionRenaes")
	private int codigoOrganizacionRenaes;

	@Column(name="CodigoInstitucionRenaes")
	private int codigoInstitucionRenaes;

	@Column(name="CodigoSedeRenaes")
	private int codigoSedeRenaes;

	@Column(name="CodigoRegistroRenaes")
	private long codigoRegistroRenaes;

	@Column(name="NumeroVersionRenaes")
	private int numeroVersionRenaes;

	@Column(name="NumeroPeriodoRenaes")
	private int numeroPeriodoRenaes;

	@Column(name="ClasificacionRenaes")
	private String clasificacionRenaes;

	public RenaesPK() {
	}
	public int getCodigoOrganizacionRenaes() {
		return this.codigoOrganizacionRenaes;
	}
	public void setCodigoOrganizacionRenaes(int codigoOrganizacionRenaes) {
		this.codigoOrganizacionRenaes = codigoOrganizacionRenaes;
	}
	public int getCodigoInstitucionRenaes() {
		return this.codigoInstitucionRenaes;
	}
	public void setCodigoInstitucionRenaes(int codigoInstitucionRenaes) {
		this.codigoInstitucionRenaes = codigoInstitucionRenaes;
	}
	public int getCodigoSedeRenaes() {
		return this.codigoSedeRenaes;
	}
	public void setCodigoSedeRenaes(int codigoSedeRenaes) {
		this.codigoSedeRenaes = codigoSedeRenaes;
	}
	public long getCodigoRegistroRenaes() {
		return this.codigoRegistroRenaes;
	}
	public void setCodigoRegistroRenaes(long codigoRegistroRenaes) {
		this.codigoRegistroRenaes = codigoRegistroRenaes;
	}
	public int getNumeroVersionRenaes() {
		return this.numeroVersionRenaes;
	}
	public void setNumeroVersionRenaes(int numeroVersionRenaes) {
		this.numeroVersionRenaes = numeroVersionRenaes;
	}
	public int getNumeroPeriodoRenaes() {
		return this.numeroPeriodoRenaes;
	}
	public void setNumeroPeriodoRenaes(int numeroPeriodoRenaes) {
		this.numeroPeriodoRenaes = numeroPeriodoRenaes;
	}
	public String getClasificacionRenaes() {
		return this.clasificacionRenaes;
	}
	public void setClasificacionRenaes(String clasificacionRenaes) {
		this.clasificacionRenaes = clasificacionRenaes;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RenaesPK)) {
			return false;
		}
		RenaesPK castOther = (RenaesPK)other;
		return 
			(this.codigoOrganizacionRenaes == castOther.codigoOrganizacionRenaes)
			&& (this.codigoInstitucionRenaes == castOther.codigoInstitucionRenaes)
			&& (this.codigoSedeRenaes == castOther.codigoSedeRenaes)
			&& (this.codigoRegistroRenaes == castOther.codigoRegistroRenaes)
			&& (this.numeroVersionRenaes == castOther.numeroVersionRenaes)
			&& (this.numeroPeriodoRenaes == castOther.numeroPeriodoRenaes)
			&& this.clasificacionRenaes.equals(castOther.clasificacionRenaes);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codigoOrganizacionRenaes;
		hash = hash * prime + this.codigoInstitucionRenaes;
		hash = hash * prime + this.codigoSedeRenaes;
		hash = hash * prime + ((int) (this.codigoRegistroRenaes ^ (this.codigoRegistroRenaes >>> 32)));
		hash = hash * prime + this.numeroVersionRenaes;
		hash = hash * prime + this.numeroPeriodoRenaes;
		hash = hash * prime + this.clasificacionRenaes.hashCode();
		
		return hash;
	}
}