package sigelab.core.entity.general;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PACIENTE database table.
 * 
 */
@Embeddable
public class PacientePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_PACIENTE")
	private long idPaciente;

	@Column(name="ID_ORGANIZACION_PACIENTE")
	private int idOrganizacionPaciente;

	@Column(name="ID_INSTITUCION_PACIENTE")
	private int idInstitucionPaciente;

	@Column(name="ID_SEDE_PACIENTE")
	private int idSedePaciente;

	@Column(name="NRO_VERSION_PACIENTE")
	private int nroVersionPaciente;

	@Column(name="NRO_PERIODO_PACIENTE")
	private int nroPeriodoPaciente;

	public PacientePK() {
	}
	public long getIdPaciente() {
		return this.idPaciente;
	}
	public void setIdPaciente(long idPaciente) {
		this.idPaciente = idPaciente;
	}
	public int getIdOrganizacionPaciente() {
		return this.idOrganizacionPaciente;
	}
	public void setIdOrganizacionPaciente(int idOrganizacionPaciente) {
		this.idOrganizacionPaciente = idOrganizacionPaciente;
	}
	public int getIdInstitucionPaciente() {
		return this.idInstitucionPaciente;
	}
	public void setIdInstitucionPaciente(int idInstitucionPaciente) {
		this.idInstitucionPaciente = idInstitucionPaciente;
	}
	public int getIdSedePaciente() {
		return this.idSedePaciente;
	}
	public void setIdSedePaciente(int idSedePaciente) {
		this.idSedePaciente = idSedePaciente;
	}
	public int getNroVersionPaciente() {
		return this.nroVersionPaciente;
	}
	public void setNroVersionPaciente(int nroVersionPaciente) {
		this.nroVersionPaciente = nroVersionPaciente;
	}
	public int getNroPeriodoPaciente() {
		return this.nroPeriodoPaciente;
	}
	public void setNroPeriodoPaciente(int nroPeriodoPaciente) {
		this.nroPeriodoPaciente = nroPeriodoPaciente;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PacientePK)) {
			return false;
		}
		PacientePK castOther = (PacientePK)other;
		return 
			(this.idPaciente == castOther.idPaciente)
			&& (this.idOrganizacionPaciente == castOther.idOrganizacionPaciente)
			&& (this.idInstitucionPaciente == castOther.idInstitucionPaciente)
			&& (this.idSedePaciente == castOther.idSedePaciente)
			&& (this.nroVersionPaciente == castOther.nroVersionPaciente)
			&& (this.nroPeriodoPaciente == castOther.nroPeriodoPaciente);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idPaciente ^ (this.idPaciente >>> 32)));
		hash = hash * prime + this.idOrganizacionPaciente;
		hash = hash * prime + this.idInstitucionPaciente;
		hash = hash * prime + this.idSedePaciente;
		hash = hash * prime + this.nroVersionPaciente;
		hash = hash * prime + this.nroPeriodoPaciente;
		
		return hash;
	}
	@Override
	public String toString() {
		return "PacientePK [idPaciente=" + idPaciente + ", idOrganizacionPaciente=" + idOrganizacionPaciente
				+ ", idInstitucionPaciente=" + idInstitucionPaciente + ", idSedePaciente=" + idSedePaciente
				+ ", nroVersionPaciente=" + nroVersionPaciente + ", nroPeriodoPaciente=" + nroPeriodoPaciente + "]";
	}
	
	
}