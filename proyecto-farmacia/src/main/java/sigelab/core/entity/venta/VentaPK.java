package pe.com.galaxy.systems.apolo.core.entidad.entidad.venta;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the VENTA database table.
 * 
 */
@Embeddable
public class VentaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_ORGANIZACION_VENTA")
	private int idOrganizacionVenta;

	@Column(name="ID_INSTITUCION_VENTA")
	private int idInstitucionVenta;

	@Column(name="ID_SEDE_VENTA")
	private int idSedeVenta;

	@Column(name="NRO_VERSION_VENTA")
	private int nroVersionVenta;

	@Column(name="NRO_PERIODO_VENTA")
	private int nroPeriodoVenta;

	@Column(name="ID_VENTA")
	private int idVenta;

	public VentaPK() {
	}
	public int getIdOrganizacionVenta() {
		return this.idOrganizacionVenta;
	}
	public void setIdOrganizacionVenta(int idOrganizacionVenta) {
		this.idOrganizacionVenta = idOrganizacionVenta;
	}
	public int getIdInstitucionVenta() {
		return this.idInstitucionVenta;
	}
	public void setIdInstitucionVenta(int idInstitucionVenta) {
		this.idInstitucionVenta = idInstitucionVenta;
	}
	public int getIdSedeVenta() {
		return this.idSedeVenta;
	}
	public void setIdSedeVenta(int idSedeVenta) {
		this.idSedeVenta = idSedeVenta;
	}
	public int getNroVersionVenta() {
		return this.nroVersionVenta;
	}
	public void setNroVersionVenta(int nroVersionVenta) {
		this.nroVersionVenta = nroVersionVenta;
	}
	public int getNroPeriodoVenta() {
		return this.nroPeriodoVenta;
	}
	public void setNroPeriodoVenta(int nroPeriodoVenta) {
		this.nroPeriodoVenta = nroPeriodoVenta;
	}
	public int getIdVenta() {
		return this.idVenta;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof VentaPK)) {
			return false;
		}
		VentaPK castOther = (VentaPK)other;
		return 
			(this.idOrganizacionVenta == castOther.idOrganizacionVenta)
			&& (this.idInstitucionVenta == castOther.idInstitucionVenta)
			&& (this.idSedeVenta == castOther.idSedeVenta)
			&& (this.nroVersionVenta == castOther.nroVersionVenta)
			&& (this.nroPeriodoVenta == castOther.nroPeriodoVenta)
			&& (this.idVenta == castOther.idVenta);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idOrganizacionVenta;
		hash = hash * prime + this.idInstitucionVenta;
		hash = hash * prime + this.idSedeVenta;
		hash = hash * prime + this.nroVersionVenta;
		hash = hash * prime + this.nroPeriodoVenta;
		hash = hash * prime + this.idVenta;
		
		return hash;
	}
	@Override
	public String toString() {
		return "VentaPK [idOrganizacionVenta=" + idOrganizacionVenta + ", idInstitucionVenta=" + idInstitucionVenta
				+ ", idSedeVenta=" + idSedeVenta + ", nroVersionVenta=" + nroVersionVenta + ", nroPeriodoVenta="
				+ nroPeriodoVenta + ", idVenta=" + idVenta + "]";
	}
	
	
}