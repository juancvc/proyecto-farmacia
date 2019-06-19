package sigelab.core.entity.farmacotecnia;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PREPARADO database table.
 * 
 */
@Embeddable
public class PreparadoInsumoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_ORGANIZACION_PREPARADO_INSUMO")
	private int idOrganizacionPreparado;

	@Column(name="ID_INSTITUCION_PREPARADO_INSUMO")
	private int idInstitucionPreparado;

	@Column(name="ID_SEDE_PREPARADO_INSUMO")
	private int idSedePreparado;

	@Column(name="NRO_VERSION_PREPARADO_INSUMO")
	private int nroVersionPreparado;

	@Column(name="NRO_PERIODO_PREPARADO_INSUMO")
	private int nroPeriodoPreparado;

	@Column(name="ID_PREPARADO_INSUMO")
	private long idPreparado;

	public PreparadoInsumoPK() {
	}
	public int getIdOrganizacionPreparado() {
		return this.idOrganizacionPreparado;
	}
	public void setIdOrganizacionPreparado(int idOrganizacionPreparado) {
		this.idOrganizacionPreparado = idOrganizacionPreparado;
	}
	public int getIdInstitucionPreparado() {
		return this.idInstitucionPreparado;
	}
	public void setIdInstitucionPreparado(int idInstitucionPreparado) {
		this.idInstitucionPreparado = idInstitucionPreparado;
	}
	public int getIdSedePreparado() {
		return this.idSedePreparado;
	}
	public void setIdSedePreparado(int idSedePreparado) {
		this.idSedePreparado = idSedePreparado;
	}
	public int getNroVersionPreparado() {
		return this.nroVersionPreparado;
	}
	public void setNroVersionPreparado(int nroVersionPreparado) {
		this.nroVersionPreparado = nroVersionPreparado;
	}
	public int getNroPeriodoPreparado() {
		return this.nroPeriodoPreparado;
	}
	public void setNroPeriodoPreparado(int nroPeriodoPreparado) {
		this.nroPeriodoPreparado = nroPeriodoPreparado;
	}
	public long getIdPreparado() {
		return this.idPreparado;
	}
	public void setIdPreparado(long idPreparado) {
		this.idPreparado = idPreparado;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PreparadoInsumoPK)) {
			return false;
		}
		PreparadoInsumoPK castOther = (PreparadoInsumoPK)other;
		return 
			(this.idOrganizacionPreparado == castOther.idOrganizacionPreparado)
			&& (this.idInstitucionPreparado == castOther.idInstitucionPreparado)
			&& (this.idSedePreparado == castOther.idSedePreparado)
			&& (this.nroVersionPreparado == castOther.nroVersionPreparado)
			&& (this.nroPeriodoPreparado == castOther.nroPeriodoPreparado)
			&& (this.idPreparado == castOther.idPreparado);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idOrganizacionPreparado;
		hash = hash * prime + this.idInstitucionPreparado;
		hash = hash * prime + this.idSedePreparado;
		hash = hash * prime + this.nroVersionPreparado;
		hash = hash * prime + this.nroPeriodoPreparado;
		hash = hash * prime + ((int) (this.idPreparado ^ (this.idPreparado >>> 32)));
		
		return hash;
	}
}