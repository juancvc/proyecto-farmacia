package proyect.core.entity.receta;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the RECETA_DETALLE database table.
 * 
 */
@Embeddable
public class RecetaDetallePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_ORGANIZACION_RECETA_DETALLE")
	private int idOrganizacionRecetaDetalle;

	@Column(name="ID_INSTITUCION_RECETA_DETALLE")
	private int idInstitucionRecetaDetalle;

	@Column(name="ID_SEDE_RECETA_DETALLE")
	private int idSedeRecetaDetalle;

	@Column(name="NRO_VERSION_RECETA_DETALLE")
	private int nroVersionRecetaDetalle;

	@Column(name="NRO_PERIODO_RECETA_DETALLE")
	private int nroPeriodoRecetaDetalle;

	@Column(name="ID_RECETA_DETALLE")
	private int idRecetaDetalle;

	public RecetaDetallePK() {
	}
	public int getIdOrganizacionRecetaDetalle() {
		return this.idOrganizacionRecetaDetalle;
	}
	public void setIdOrganizacionRecetaDetalle(int idOrganizacionRecetaDetalle) {
		this.idOrganizacionRecetaDetalle = idOrganizacionRecetaDetalle;
	}
	public int getIdInstitucionRecetaDetalle() {
		return this.idInstitucionRecetaDetalle;
	}
	public void setIdInstitucionRecetaDetalle(int idInstitucionRecetaDetalle) {
		this.idInstitucionRecetaDetalle = idInstitucionRecetaDetalle;
	}
	public int getIdSedeRecetaDetalle() {
		return this.idSedeRecetaDetalle;
	}
	public void setIdSedeRecetaDetalle(int idSedeRecetaDetalle) {
		this.idSedeRecetaDetalle = idSedeRecetaDetalle;
	}
	public int getNroVersionRecetaDetalle() {
		return this.nroVersionRecetaDetalle;
	}
	public void setNroVersionRecetaDetalle(int nroVersionRecetaDetalle) {
		this.nroVersionRecetaDetalle = nroVersionRecetaDetalle;
	}
	public int getNroPeriodoRecetaDetalle() {
		return this.nroPeriodoRecetaDetalle;
	}
	public void setNroPeriodoRecetaDetalle(int nroPeriodoRecetaDetalle) {
		this.nroPeriodoRecetaDetalle = nroPeriodoRecetaDetalle;
	}
	public int getIdRecetaDetalle() {
		return this.idRecetaDetalle;
	}
	public void setIdRecetaDetalle(int idRecetaDetalle) {
		this.idRecetaDetalle = idRecetaDetalle;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RecetaDetallePK)) {
			return false;
		}
		RecetaDetallePK castOther = (RecetaDetallePK)other;
		return 
			(this.idOrganizacionRecetaDetalle == castOther.idOrganizacionRecetaDetalle)
			&& (this.idInstitucionRecetaDetalle == castOther.idInstitucionRecetaDetalle)
			&& (this.idSedeRecetaDetalle == castOther.idSedeRecetaDetalle)
			&& (this.nroVersionRecetaDetalle == castOther.nroVersionRecetaDetalle)
			&& (this.nroPeriodoRecetaDetalle == castOther.nroPeriodoRecetaDetalle)
			&& (this.idRecetaDetalle == castOther.idRecetaDetalle);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idOrganizacionRecetaDetalle;
		hash = hash * prime + this.idInstitucionRecetaDetalle;
		hash = hash * prime + this.idSedeRecetaDetalle;
		hash = hash * prime + this.nroVersionRecetaDetalle;
		hash = hash * prime + this.nroPeriodoRecetaDetalle;
		hash = hash * prime + this.idRecetaDetalle;
		
		return hash;
	}
}