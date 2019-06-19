package pe.com.galaxy.systems.apolo.core.entidad.entidad.farmacotecnia;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the INSUMO database table.
 * 
 */
@Embeddable
public class InsumoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_ORGANIZACION_INSUMO")
	private int idOrganizacionInsumo;

	@Column(name="ID_INSTITUCION_INSUMO")
	private int idInstitucionInsumo;

	@Column(name="ID_SEDE_INSUMO")
	private int idSedeInsumo;

	@Column(name="NRO_VERSION_INSUMO")
	private int nroVersionInsumo;

	@Column(name="NRO_PERIODO_INSUMO")
	private int nroPeriodoInsumo;

	@Column(name="ID_INSUMO")
	private Long idInsumo;

	public InsumoPK() {
	}
	public int getIdOrganizacionInsumo() {
		return this.idOrganizacionInsumo;
	}
	public void setIdOrganizacionInsumo(int idOrganizacionInsumo) {
		this.idOrganizacionInsumo = idOrganizacionInsumo;
	}
	public int getIdInstitucionInsumo() {
		return this.idInstitucionInsumo;
	}
	public void setIdInstitucionInsumo(int idInstitucionInsumo) {
		this.idInstitucionInsumo = idInstitucionInsumo;
	}
	public int getIdSedeInsumo() {
		return this.idSedeInsumo;
	}
	public void setIdSedeInsumo(int idSedeInsumo) {
		this.idSedeInsumo = idSedeInsumo;
	}
	public int getNroVersionInsumo() {
		return this.nroVersionInsumo;
	}
	public void setNroVersionInsumo(int nroVersionInsumo) {
		this.nroVersionInsumo = nroVersionInsumo;
	}
	public int getNroPeriodoInsumo() {
		return this.nroPeriodoInsumo;
	}
	public void setNroPeriodoInsumo(int nroPeriodoInsumo) {
		this.nroPeriodoInsumo = nroPeriodoInsumo;
	}
	public Long getIdInsumo() {
		if (idInsumo == null) {
			idInsumo = 0L;
		}
		return this.idInsumo;
	}
	public void setIdInsumo(Long idInsumo) {
		this.idInsumo = idInsumo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof InsumoPK)) {
			return false;
		}
		InsumoPK castOther = (InsumoPK)other;
		return 
			(this.idOrganizacionInsumo == castOther.idOrganizacionInsumo)
			&& (this.idInstitucionInsumo == castOther.idInstitucionInsumo)
			&& (this.idSedeInsumo == castOther.idSedeInsumo)
			&& (this.nroVersionInsumo == castOther.nroVersionInsumo)
			&& (this.nroPeriodoInsumo == castOther.nroPeriodoInsumo)
			&& this.idInsumo.equals(castOther.idInsumo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idOrganizacionInsumo;
		hash = hash * prime + this.idInstitucionInsumo;
		hash = hash * prime + this.idSedeInsumo;
		hash = hash * prime + this.nroVersionInsumo;
		hash = hash * prime + this.nroPeriodoInsumo;
		hash = hash * prime + this.idInsumo.hashCode();
		
		return hash;
	}
	@Override
	public String toString() {
		return "InsumoPK [idOrganizacionInsumo=" + idOrganizacionInsumo + ", idInstitucionInsumo=" + idInstitucionInsumo
				+ ", idSedeInsumo=" + idSedeInsumo + ", nroVersionInsumo=" + nroVersionInsumo + ", nroPeriodoInsumo="
				+ nroPeriodoInsumo + ", idInsumo=" + idInsumo + "]";
	}
	
	
}