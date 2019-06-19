package pe.com.galaxy.systems.apolo.core.entidad.entidad.receta;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the RECETA database table.
 * 
 */
@Embeddable
public class RecetaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_ORGANIZACION_RECETA")
	private int idOrganizacionReceta;

	@Column(name="ID_INSTITUCION_RECETA")
	private int idInstitucionReceta;

	@Column(name="ID_SEDE_RECETA")
	private int idSedeReceta;

	@Column(name="NRO_VERSION_RECETA")
	private int nroVersionReceta;

	@Column(name="NRO_PERIODO_RECETA")
	private int nroPeriodoReceta;

	@Column(name="ID_RECETA")
	private int idReceta;

	public RecetaPK() {
	}
	public int getIdOrganizacionReceta() {
		return this.idOrganizacionReceta;
	}
	public void setIdOrganizacionReceta(int idOrganizacionReceta) {
		this.idOrganizacionReceta = idOrganizacionReceta;
	}
	public int getIdInstitucionReceta() {
		return this.idInstitucionReceta;
	}
	public void setIdInstitucionReceta(int idInstitucionReceta) {
		this.idInstitucionReceta = idInstitucionReceta;
	}
	public int getIdSedeReceta() {
		return this.idSedeReceta;
	}
	public void setIdSedeReceta(int idSedeReceta) {
		this.idSedeReceta = idSedeReceta;
	}
	public int getNroVersionReceta() {
		return this.nroVersionReceta;
	}
	public void setNroVersionReceta(int nroVersionReceta) {
		this.nroVersionReceta = nroVersionReceta;
	}
	public int getNroPeriodoReceta() {
		return this.nroPeriodoReceta;
	}
	public void setNroPeriodoReceta(int nroPeriodoReceta) {
		this.nroPeriodoReceta = nroPeriodoReceta;
	}
	public int getIdReceta() {
		return this.idReceta;
	}
	public void setIdReceta(int idReceta) {
		this.idReceta = idReceta;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RecetaPK)) {
			return false;
		}
		RecetaPK castOther = (RecetaPK)other;
		return 
			(this.idOrganizacionReceta == castOther.idOrganizacionReceta)
			&& (this.idInstitucionReceta == castOther.idInstitucionReceta)
			&& (this.idSedeReceta == castOther.idSedeReceta)
			&& (this.nroVersionReceta == castOther.nroVersionReceta)
			&& (this.nroPeriodoReceta == castOther.nroPeriodoReceta)
			&& (this.idReceta == castOther.idReceta);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idOrganizacionReceta;
		hash = hash * prime + this.idInstitucionReceta;
		hash = hash * prime + this.idSedeReceta;
		hash = hash * prime + this.nroVersionReceta;
		hash = hash * prime + this.nroPeriodoReceta;
		hash = hash * prime + this.idReceta;
		
		return hash;
	}
	@Override
	public String toString() {
		return "RecetaPK [idOrganizacionReceta=" + idOrganizacionReceta + ", idInstitucionReceta=" + idInstitucionReceta
				+ ", idSedeReceta=" + idSedeReceta + ", nroVersionReceta=" + nroVersionReceta + ", nroPeriodoReceta="
				+ nroPeriodoReceta + ", idReceta=" + idReceta + "]";
	}
	
}