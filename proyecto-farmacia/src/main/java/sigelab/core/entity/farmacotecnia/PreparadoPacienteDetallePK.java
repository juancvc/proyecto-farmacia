package sigelab.core.entity.farmacotecnia;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PREPARADO_PACIENTE database table.
 * 
 */
@Embeddable
public class PreparadoPacienteDetallePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_ORGANIZACION_PREPARADO_PACIENTE_DETALLE")
	private int idOrganizacionPreparadoPacienteDetalle;

	@Column(name="ID_INSTITUCION_PREPARADO_PACIENTE_DETALLE")
	private int idInstitucionPreparadoPacienteDetalle;

	@Column(name="ID_SEDE_PREPARADO_PACIENTE_DETALLE")
	private int idSedePreparadoPacienteDetalle;

	@Column(name="NRO_VERSION_PREPARADO_PACIENTE_DETALLE")
	private int nroVersionPreparadoPacienteDetalle;

	@Column(name="NRO_PERIODO_PREPARADO_PACIENTE_DETALLE")
	private int nroPeriodoPreparadoPacienteDetalle;

	@Column(name="ID_PREPARADO_PACIENTE_DETALLE")
	private long idPreparadoPacienteDetalle;

	public PreparadoPacienteDetallePK() {
	}
	public int getIdOrganizacionPreparadoPacienteDetalle() {
		return this.idOrganizacionPreparadoPacienteDetalle;
	}
	public void setIdOrganizacionPreparadoPacienteDetalle(int idOrganizacionPreparadoPacienteDetalle) {
		this.idOrganizacionPreparadoPacienteDetalle = idOrganizacionPreparadoPacienteDetalle;
	}
	public int getIdInstitucionPreparadoPacienteDetalle() {
		return this.idInstitucionPreparadoPacienteDetalle;
	}
	public void setIdInstitucionPreparadoPacienteDetalle(int idInstitucionPreparadoPacienteDetalle) {
		this.idInstitucionPreparadoPacienteDetalle = idInstitucionPreparadoPacienteDetalle;
	}
	public int getIdSedePreparadoPacienteDetalle() {
		return this.idSedePreparadoPacienteDetalle;
	}
	public void setIdSedePreparadoPacienteDetalle(int idSedePreparadoPacienteDetalle) {
		this.idSedePreparadoPacienteDetalle = idSedePreparadoPacienteDetalle;
	}
	public int getNroVersionPreparadoPacienteDetalle() {
		return this.nroVersionPreparadoPacienteDetalle;
	}
	public void setNroVersionPreparadoPacienteDetalle(int nroVersionPreparadoPacienteDetalle) {
		this.nroVersionPreparadoPacienteDetalle = nroVersionPreparadoPacienteDetalle;
	}
	public int getNroPeriodoPreparadoPacienteDetalle() {
		return this.nroPeriodoPreparadoPacienteDetalle;
	}
	public void setNroPeriodoPreparadoPacienteDetalle(int nroPeriodoPreparadoPacienteDetalle) {
		this.nroPeriodoPreparadoPacienteDetalle = nroPeriodoPreparadoPacienteDetalle;
	}
	public long getIdPreparadoPacienteDetalle() {
		return this.idPreparadoPacienteDetalle;
	}
	public void setIdPreparadoPacienteDetalle(long idPreparadoPacienteDetalle) {
		this.idPreparadoPacienteDetalle = idPreparadoPacienteDetalle;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PreparadoPacienteDetallePK)) {
			return false;
		}
		PreparadoPacienteDetallePK castOther = (PreparadoPacienteDetallePK)other;
		return 
			(this.idOrganizacionPreparadoPacienteDetalle == castOther.idOrganizacionPreparadoPacienteDetalle)
			&& (this.idInstitucionPreparadoPacienteDetalle == castOther.idInstitucionPreparadoPacienteDetalle)
			&& (this.idSedePreparadoPacienteDetalle == castOther.idSedePreparadoPacienteDetalle)
			&& (this.nroVersionPreparadoPacienteDetalle == castOther.nroVersionPreparadoPacienteDetalle)
			&& (this.nroPeriodoPreparadoPacienteDetalle == castOther.nroPeriodoPreparadoPacienteDetalle)
			&& (this.idPreparadoPacienteDetalle == castOther.idPreparadoPacienteDetalle);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idOrganizacionPreparadoPacienteDetalle;
		hash = hash * prime + this.idInstitucionPreparadoPacienteDetalle;
		hash = hash * prime + this.idSedePreparadoPacienteDetalle;
		hash = hash * prime + this.nroVersionPreparadoPacienteDetalle;
		hash = hash * prime + this.nroPeriodoPreparadoPacienteDetalle;
		hash = hash * prime + ((int) (this.idPreparadoPacienteDetalle ^ (this.idPreparadoPacienteDetalle >>> 32)));
		
		return hash;
	}
	@Override
	public String toString() {
		return "PreparadoPacienteDetallePK [idOrganizacionPreparadoPacienteDetalle="
				+ idOrganizacionPreparadoPacienteDetalle + ", idInstitucionPreparadoPacienteDetalle="
				+ idInstitucionPreparadoPacienteDetalle + ", idSedePreparadoPacienteDetalle="
				+ idSedePreparadoPacienteDetalle + ", nroVersionPreparadoPacienteDetalle="
				+ nroVersionPreparadoPacienteDetalle + ", nroPeriodoPreparadoPacienteDetalle="
				+ nroPeriodoPreparadoPacienteDetalle + ", idPreparadoPacienteDetalle=" + idPreparadoPacienteDetalle
				+ "]";
	}
	
}