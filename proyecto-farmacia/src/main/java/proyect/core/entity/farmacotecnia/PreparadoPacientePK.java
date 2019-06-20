package proyect.core.entity.farmacotecnia;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PREPARADO_PACIENTE database table.
 * 
 */
@Embeddable
public class PreparadoPacientePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_ORGANIZACION_PREPARADO_PACIENTE")
	private int idOrganizacionPreparadoPaciente;

	@Column(name="ID_INSTITUCION_PREPARADO_PACIENTE")
	private int idInstitucionPreparadoPaciente;

	@Column(name="ID_SEDE_PREPARADO_PACIENTE")
	private int idSedePreparadoPaciente;

	@Column(name="NRO_VERSION_PREPARADO_PACIENTE")
	private int nroVersionPreparadoPaciente;

	@Column(name="NRO_PERIODO_PREPARADO_PACIENTE")
	private int nroPeriodoPreparadoPaciente;

	@Column(name="ID_PREPARADO_PACIENTE")
	private long idPreparadoPaciente;

	public PreparadoPacientePK() {
	}
	public int getIdOrganizacionPreparadoPaciente() {
		return this.idOrganizacionPreparadoPaciente;
	}
	public void setIdOrganizacionPreparadoPaciente(int idOrganizacionPreparadoPaciente) {
		this.idOrganizacionPreparadoPaciente = idOrganizacionPreparadoPaciente;
	}
	public int getIdInstitucionPreparadoPaciente() {
		return this.idInstitucionPreparadoPaciente;
	}
	public void setIdInstitucionPreparadoPaciente(int idInstitucionPreparadoPaciente) {
		this.idInstitucionPreparadoPaciente = idInstitucionPreparadoPaciente;
	}
	public int getIdSedePreparadoPaciente() {
		return this.idSedePreparadoPaciente;
	}
	public void setIdSedePreparadoPaciente(int idSedePreparadoPaciente) {
		this.idSedePreparadoPaciente = idSedePreparadoPaciente;
	}
	public int getNroVersionPreparadoPaciente() {
		return this.nroVersionPreparadoPaciente;
	}
	public void setNroVersionPreparadoPaciente(int nroVersionPreparadoPaciente) {
		this.nroVersionPreparadoPaciente = nroVersionPreparadoPaciente;
	}
	public int getNroPeriodoPreparadoPaciente() {
		return this.nroPeriodoPreparadoPaciente;
	}
	public void setNroPeriodoPreparadoPaciente(int nroPeriodoPreparadoPaciente) {
		this.nroPeriodoPreparadoPaciente = nroPeriodoPreparadoPaciente;
	}
	public long getIdPreparadoPaciente() {
		return this.idPreparadoPaciente;
	}
	public void setIdPreparadoPaciente(long idPreparadoPaciente) {
		this.idPreparadoPaciente = idPreparadoPaciente;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PreparadoPacientePK)) {
			return false;
		}
		PreparadoPacientePK castOther = (PreparadoPacientePK)other;
		return 
			(this.idOrganizacionPreparadoPaciente == castOther.idOrganizacionPreparadoPaciente)
			&& (this.idInstitucionPreparadoPaciente == castOther.idInstitucionPreparadoPaciente)
			&& (this.idSedePreparadoPaciente == castOther.idSedePreparadoPaciente)
			&& (this.nroVersionPreparadoPaciente == castOther.nroVersionPreparadoPaciente)
			&& (this.nroPeriodoPreparadoPaciente == castOther.nroPeriodoPreparadoPaciente)
			&& (this.idPreparadoPaciente == castOther.idPreparadoPaciente);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idOrganizacionPreparadoPaciente;
		hash = hash * prime + this.idInstitucionPreparadoPaciente;
		hash = hash * prime + this.idSedePreparadoPaciente;
		hash = hash * prime + this.nroVersionPreparadoPaciente;
		hash = hash * prime + this.nroPeriodoPreparadoPaciente;
		hash = hash * prime + ((int) (this.idPreparadoPaciente ^ (this.idPreparadoPaciente >>> 32)));
		
		return hash;
	}
}