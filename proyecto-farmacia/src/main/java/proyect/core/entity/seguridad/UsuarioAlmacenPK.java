package proyect.core.entity.seguridad;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the USUARIO_ALMACEN database table.
 * 
 */
@Embeddable
public class UsuarioAlmacenPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_ORGANIZACION_USUARIO_ALMACEN")
	private int idOrganizacionUsuarioAlmacen;

	@Column(name="ID_INSTITUCION_USUARIO_ALMACEN")
	private int idInstitucionUsuarioAlmacen;

	@Column(name="ID_SEDE_USUARIO_ALMACEN")
	private int idSedeUsuarioAlmacen;

	@Column(name="NRO_VERSION_USUARIO_ALMACEN")
	private int nroVersionUsuarioAlmacen;

	@Column(name="NRO_PERIODO_USUARIO_ALMACEN")
	private int nroPeriodoUsuarioAlmacen;

	@Column(name="ID_USUARIO_ALMACEN")
	private int idUsuarioAlmacen;

	public UsuarioAlmacenPK() {
	}
	public int getIdOrganizacionUsuarioAlmacen() {
		return this.idOrganizacionUsuarioAlmacen;
	}
	public void setIdOrganizacionUsuarioAlmacen(int idOrganizacionUsuarioAlmacen) {
		this.idOrganizacionUsuarioAlmacen = idOrganizacionUsuarioAlmacen;
	}
	public int getIdInstitucionUsuarioAlmacen() {
		return this.idInstitucionUsuarioAlmacen;
	}
	public void setIdInstitucionUsuarioAlmacen(int idInstitucionUsuarioAlmacen) {
		this.idInstitucionUsuarioAlmacen = idInstitucionUsuarioAlmacen;
	}
	public int getIdSedeUsuarioAlmacen() {
		return this.idSedeUsuarioAlmacen;
	}
	public void setIdSedeUsuarioAlmacen(int idSedeUsuarioAlmacen) {
		this.idSedeUsuarioAlmacen = idSedeUsuarioAlmacen;
	}
	public int getNroVersionUsuarioAlmacen() {
		return this.nroVersionUsuarioAlmacen;
	}
	public void setNroVersionUsuarioAlmacen(int nroVersionUsuarioAlmacen) {
		this.nroVersionUsuarioAlmacen = nroVersionUsuarioAlmacen;
	}
	public int getNroPeriodoUsuarioAlmacen() {
		return this.nroPeriodoUsuarioAlmacen;
	}
	public void setNroPeriodoUsuarioAlmacen(int nroPeriodoUsuarioAlmacen) {
		this.nroPeriodoUsuarioAlmacen = nroPeriodoUsuarioAlmacen;
	}
	public int getIdUsuarioAlmacen() {
		return this.idUsuarioAlmacen;
	}
	public void setIdUsuarioAlmacen(int idUsuarioAlmacen) {
		this.idUsuarioAlmacen = idUsuarioAlmacen;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UsuarioAlmacenPK)) {
			return false;
		}
		UsuarioAlmacenPK castOther = (UsuarioAlmacenPK)other;
		return 
			(this.idOrganizacionUsuarioAlmacen == castOther.idOrganizacionUsuarioAlmacen)
			&& (this.idInstitucionUsuarioAlmacen == castOther.idInstitucionUsuarioAlmacen)
			&& (this.idSedeUsuarioAlmacen == castOther.idSedeUsuarioAlmacen)
			&& (this.nroVersionUsuarioAlmacen == castOther.nroVersionUsuarioAlmacen)
			&& (this.nroPeriodoUsuarioAlmacen == castOther.nroPeriodoUsuarioAlmacen)
			&& (this.idUsuarioAlmacen == castOther.idUsuarioAlmacen);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idOrganizacionUsuarioAlmacen;
		hash = hash * prime + this.idInstitucionUsuarioAlmacen;
		hash = hash * prime + this.idSedeUsuarioAlmacen;
		hash = hash * prime + this.nroVersionUsuarioAlmacen;
		hash = hash * prime + this.nroPeriodoUsuarioAlmacen;
		hash = hash * prime + this.idUsuarioAlmacen;
		
		return hash;
	}
}