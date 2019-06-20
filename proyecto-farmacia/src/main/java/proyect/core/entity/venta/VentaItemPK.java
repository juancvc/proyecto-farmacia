package proyect.core.entity.venta;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the VENTA_ITEM database table.
 * 
 */
@Embeddable
public class VentaItemPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_ORGANIZACION_VENTA_ITEM")
	private int idOrganizacionVentaItem;

	@Column(name="ID_INSTITUCION_VENTA_ITEM")
	private int idInstitucionVentaItem;

	@Column(name="ID_SEDE_VENTA_ITEM")
	private int idSedeVentaItem;

	@Column(name="NRO_VERSION_VENTA_ITEM")
	private int nroVersionVentaItem;

	@Column(name="NRO_PERIODO_VENTA_ITEM")
	private int nroPeriodoVentaItem;

	@Column(name="ID_VENTAITEM")
	private int idVentaitem;
 

	public VentaItemPK() {
	}
	public int getIdOrganizacionVentaItem() {
		return this.idOrganizacionVentaItem;
	}
	public void setIdOrganizacionVentaItem(int idOrganizacionVentaItem) {
		this.idOrganizacionVentaItem = idOrganizacionVentaItem;
	}
	public int getIdInstitucionVentaItem() {
		return this.idInstitucionVentaItem;
	}
	public void setIdInstitucionVentaItem(int idInstitucionVentaItem) {
		this.idInstitucionVentaItem = idInstitucionVentaItem;
	}
	public int getIdSedeVentaItem() {
		return this.idSedeVentaItem;
	}
	public void setIdSedeVentaItem(int idSedeVentaItem) {
		this.idSedeVentaItem = idSedeVentaItem;
	}
	public int getNroVersionVentaItem() {
		return this.nroVersionVentaItem;
	}
	public void setNroVersionVentaItem(int nroVersionVentaItem) {
		this.nroVersionVentaItem = nroVersionVentaItem;
	}
	public int getNroPeriodoVentaItem() {
		return this.nroPeriodoVentaItem;
	}
	public void setNroPeriodoVentaItem(int nroPeriodoVentaItem) {
		this.nroPeriodoVentaItem = nroPeriodoVentaItem;
	}
	public int getIdVentaitem() {
		return this.idVentaitem;
	}
	public void setIdVentaitem(int idVentaitem) {
		this.idVentaitem = idVentaitem;
	} 
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof VentaItemPK)) {
			return false;
		}
		VentaItemPK castOther = (VentaItemPK)other;
		return 
			(this.idOrganizacionVentaItem == castOther.idOrganizacionVentaItem)
			&& (this.idInstitucionVentaItem == castOther.idInstitucionVentaItem)
			&& (this.idSedeVentaItem == castOther.idSedeVentaItem)
			&& (this.nroVersionVentaItem == castOther.nroVersionVentaItem)
			&& (this.nroPeriodoVentaItem == castOther.nroPeriodoVentaItem)
			&& (this.idVentaitem == castOther.idVentaitem); 
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idOrganizacionVentaItem;
		hash = hash * prime + this.idInstitucionVentaItem;
		hash = hash * prime + this.idSedeVentaItem;
		hash = hash * prime + this.nroVersionVentaItem;
		hash = hash * prime + this.nroPeriodoVentaItem;
		hash = hash * prime + this.idVentaitem; 
		
		return hash;
	}
	@Override
	public String toString() {
		return "VentaItemPK [idOrganizacionVentaItem=" + idOrganizacionVentaItem + ", idInstitucionVentaItem="
				+ idInstitucionVentaItem + ", idSedeVentaItem=" + idSedeVentaItem + ", nroVersionVentaItem="
				+ nroVersionVentaItem + ", nroPeriodoVentaItem=" + nroPeriodoVentaItem + ", idVentaitem=" + idVentaitem
				+ "]";
	}
	
}