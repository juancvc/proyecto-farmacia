package pe.com.galaxy.systems.apolo.core.entidad.entidad.general;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the EVENTO_PERSONA database table.
 * 
 */
@Embeddable
public class EventoPersonaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_ORGANIZACION_EVENTO_PERSONA")
	private int idOrganizacionEventoPersona;

	@Column(name="ID_INSTITUCION_EVENTO_PERSONA")
	private int idInstitucionEventoPersona;

	@Column(name="ID_SEDE_EVENTO_PERSONA")
	private int idSedeEventoPersona;

	@Column(name="NRO_VERSION_EVENTO_PERSONA")
	private int nroVersionEventoPersona;

	@Column(name="NRO_PERIODO_EVENTO_PERSONA")
	private int nroPeriodoEventoPersona;

	@Column(name="ID_EVENTO_PERSONA")
	private int idEventoPersona;

	public EventoPersonaPK() {
	}
	public int getIdOrganizacionEventoPersona() {
		return this.idOrganizacionEventoPersona;
	}
	public void setIdOrganizacionEventoPersona(int idOrganizacionEventoPersona) {
		this.idOrganizacionEventoPersona = idOrganizacionEventoPersona;
	}
	public int getIdInstitucionEventoPersona() {
		return this.idInstitucionEventoPersona;
	}
	public void setIdInstitucionEventoPersona(int idInstitucionEventoPersona) {
		this.idInstitucionEventoPersona = idInstitucionEventoPersona;
	}
	public int getIdSedeEventoPersona() {
		return this.idSedeEventoPersona;
	}
	public void setIdSedeEventoPersona(int idSedeEventoPersona) {
		this.idSedeEventoPersona = idSedeEventoPersona;
	}
	public int getNroVersionEventoPersona() {
		return this.nroVersionEventoPersona;
	}
	public void setNroVersionEventoPersona(int nroVersionEventoPersona) {
		this.nroVersionEventoPersona = nroVersionEventoPersona;
	}
	public int getNroPeriodoEventoPersona() {
		return this.nroPeriodoEventoPersona;
	}
	public void setNroPeriodoEventoPersona(int nroPeriodoEventoPersona) {
		this.nroPeriodoEventoPersona = nroPeriodoEventoPersona;
	}
	public int getIdEventoPersona() {
		return this.idEventoPersona;
	}
	public void setIdEventoPersona(int idEventoPersona) {
		this.idEventoPersona = idEventoPersona;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EventoPersonaPK)) {
			return false;
		}
		EventoPersonaPK castOther = (EventoPersonaPK)other;
		return 
			(this.idOrganizacionEventoPersona == castOther.idOrganizacionEventoPersona)
			&& (this.idInstitucionEventoPersona == castOther.idInstitucionEventoPersona)
			&& (this.idSedeEventoPersona == castOther.idSedeEventoPersona)
			&& (this.nroVersionEventoPersona == castOther.nroVersionEventoPersona)
			&& (this.nroPeriodoEventoPersona == castOther.nroPeriodoEventoPersona)
			&& (this.idEventoPersona == castOther.idEventoPersona);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idOrganizacionEventoPersona;
		hash = hash * prime + this.idInstitucionEventoPersona;
		hash = hash * prime + this.idSedeEventoPersona;
		hash = hash * prime + this.nroVersionEventoPersona;
		hash = hash * prime + this.nroPeriodoEventoPersona;
		hash = hash * prime + this.idEventoPersona;
		
		return hash;
	}
	@Override
	public String toString() {
		return "EventoPersonaPK [idOrganizacionEventoPersona=" + idOrganizacionEventoPersona
				+ ", idInstitucionEventoPersona=" + idInstitucionEventoPersona + ", idSedeEventoPersona="
				+ idSedeEventoPersona + ", nroVersionEventoPersona=" + nroVersionEventoPersona
				+ ", nroPeriodoEventoPersona=" + nroPeriodoEventoPersona + ", idEventoPersona=" + idEventoPersona + "]";
	}
	
	
}