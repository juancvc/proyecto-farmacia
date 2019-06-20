package proyect.core.entity.general;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PERSONA database table.
 * 
 */
@Embeddable
public class PersonaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_ORGANIZACION_PERSONA")
	private int idOrganizacionPersona;

	@Column(name="ID_INSTITUCION_PERSONA")
	private int idInstitucionPersona;

	@Column(name="ID_SEDE_PERSONA")
	private int idSedePersona;

	@Column(name="NRO_VERSION_PERSONA")
	private int nroVersionPersona;

	@Column(name="NRO_PERIODO_PERSONA")
	private int nroPeriodoPersona;

	@Column(name="ID_PERSONA")
	private int idPersona;

	public PersonaPK() {
	}
	public int getIdOrganizacionPersona() {
		return this.idOrganizacionPersona;
	}
	public void setIdOrganizacionPersona(int idOrganizacionPersona) {
		this.idOrganizacionPersona = idOrganizacionPersona;
	}
	public int getIdInstitucionPersona() {
		return this.idInstitucionPersona;
	}
	public void setIdInstitucionPersona(int idInstitucionPersona) {
		this.idInstitucionPersona = idInstitucionPersona;
	}
	public int getIdSedePersona() {
		return this.idSedePersona;
	}
	public void setIdSedePersona(int idSedePersona) {
		this.idSedePersona = idSedePersona;
	}
	public int getNroVersionPersona() {
		return this.nroVersionPersona;
	}
	public void setNroVersionPersona(int nroVersionPersona) {
		this.nroVersionPersona = nroVersionPersona;
	}
	public int getNroPeriodoPersona() {
		return this.nroPeriodoPersona;
	}
	public void setNroPeriodoPersona(int nroPeriodoPersona) {
		this.nroPeriodoPersona = nroPeriodoPersona;
	}
	public int getIdPersona() {
		return this.idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PersonaPK)) {
			return false;
		}
		PersonaPK castOther = (PersonaPK)other;
		return 
			(this.idOrganizacionPersona == castOther.idOrganizacionPersona)
			&& (this.idInstitucionPersona == castOther.idInstitucionPersona)
			&& (this.idSedePersona == castOther.idSedePersona)
			&& (this.nroVersionPersona == castOther.nroVersionPersona)
			&& (this.nroPeriodoPersona == castOther.nroPeriodoPersona)
			&& (this.idPersona == castOther.idPersona);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idOrganizacionPersona;
		hash = hash * prime + this.idInstitucionPersona;
		hash = hash * prime + this.idSedePersona;
		hash = hash * prime + this.nroVersionPersona;
		hash = hash * prime + this.nroPeriodoPersona;
		hash = hash * prime + this.idPersona;
		
		return hash;
	}
	@Override
	public String toString() {
		return "PersonaPK [idOrganizacionPersona=" + idOrganizacionPersona + ", idInstitucionPersona="
				+ idInstitucionPersona + ", idSedePersona=" + idSedePersona + ", nroVersionPersona=" + nroVersionPersona
				+ ", nroPeriodoPersona=" + nroPeriodoPersona + ", idPersona=" + idPersona + "]";
	}
	
	
}