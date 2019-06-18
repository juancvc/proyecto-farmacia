package sigelab.core.entity.asistencial.laboratorio;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the FOTXPER database table.
 * 
 */
@Entity
@Table(name="FOTXPER")
@NamedQuery(name="Fotxper.findAll", query="SELECT f FROM Fotxper f")
public class Fotxper_laboratorio implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Fotxper_laboratorioPK id;

	@Column(name="ESTADOFT")
	private String estadoft;

	@Column(name="FOTODETA")
	private byte[] fotodeta;

	@Column(name="NRODNI")
	private String nrodni;

	public Fotxper_laboratorio() {
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