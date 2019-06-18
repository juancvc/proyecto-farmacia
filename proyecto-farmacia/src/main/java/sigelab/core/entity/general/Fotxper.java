package sigelab.core.entity.general;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the FOTXPER database table.
 * 
 */
@Entity
@Table(name="FOTXPER")
@NamedQuery(name="Fotxper.findAll", query="SELECT f FROM Fotxper f")
public class Fotxper implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FotxperPK id;

	@Column(name="ESTADOFT")
	private String estadoft;

	@Column(name="FOTODETA")
	private byte[] fotodeta;

	@Column(name="NRODNI")
	private String nrodni;

	public Fotxper() {
	}
 
	public String getEstadoft() {
		return this.estadoft;
	}

	public void setEstadoft(String estadoft) {
		this.estadoft = estadoft;
	}

	public byte[] getFotodeta() {
		return this.fotodeta;
	}

	public void setFotodeta(byte[] fotodeta) {
		this.fotodeta = fotodeta;
	}

	public String getNrodni() {
		return this.nrodni;
	}

	public void setNrodni(String nrodni) {
		this.nrodni = nrodni;
	}

}