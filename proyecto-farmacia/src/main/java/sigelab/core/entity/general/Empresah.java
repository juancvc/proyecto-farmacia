package sigelab.core.entity.general;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the EMPRESAH database table.
 * 
 */
@Entity
@Table(name="EMPRESAH")
@NamedQuery(name="Empresah.findAll", query="SELECT e FROM Empresah e")
public class Empresah implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EmpresahPK id;

	@Column(name="AUCDUSCR")
	private String aucduscr;

	@Column(name="AUCDUSMO")
	private String aucdusmo;

	@Column(name="AUFECHCR")
	private Timestamp aufechcr;

	@Column(name="AUFECHMO")
	private Timestamp aufechmo;

	@Column(name="AUOBSEMO")
	private String auobsemo;

	@Column(name="AUPCIPCR")
	private String aupcipcr;

	@Column(name="AUPCIPMO")
	private String aupcipmo;

	@Column(name="CONTACTO")
	private String contacto;

	@Column(name="DIRECCIO")
	private String direccio;

	@Column(name="EMAILCON")
	private String emailcon;

	@Column(name="EMAILEMP")
	private String emailemp;

	@Column(name="ESTADORG")
	private String estadorg;

	@Column(name="NOMBCOME")
	private String nombcome;

	@Column(name="RZSOCIAL")
	private String rzsocial;

	@Column(name="SITUACRG")
	private String situacrg;

	@Column(name="SWMIGRAD")
	private short swmigrad;

	@Column(name="TELEFONO")
	private String telefono;

	public Empresah() {
	}

	public EmpresahPK getId() {
		return this.id;
	}

	public void setId(EmpresahPK id) {
		this.id = id;
	}

	public String getAucduscr() {
		return this.aucduscr;
	}

	public void setAucduscr(String aucduscr) {
		this.aucduscr = aucduscr;
	}

	public String getAucdusmo() {
		return this.aucdusmo;
	}

	public void setAucdusmo(String aucdusmo) {
		this.aucdusmo = aucdusmo;
	}

	public Timestamp getAufechcr() {
		return this.aufechcr;
	}

	public void setAufechcr(Timestamp aufechcr) {
		this.aufechcr = aufechcr;
	}

	public Timestamp getAufechmo() {
		return this.aufechmo;
	}

	public void setAufechmo(Timestamp aufechmo) {
		this.aufechmo = aufechmo;
	}

	public String getAuobsemo() {
		return this.auobsemo;
	}

	public void setAuobsemo(String auobsemo) {
		this.auobsemo = auobsemo;
	}

	public String getAupcipcr() {
		return this.aupcipcr;
	}

	public void setAupcipcr(String aupcipcr) {
		this.aupcipcr = aupcipcr;
	}

	public String getAupcipmo() {
		return this.aupcipmo;
	}

	public void setAupcipmo(String aupcipmo) {
		this.aupcipmo = aupcipmo;
	}

	public String getContacto() {
		return this.contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getDireccio() {
		return this.direccio;
	}

	public void setDireccio(String direccio) {
		this.direccio = direccio;
	}

	public String getEmailcon() {
		return this.emailcon;
	}

	public void setEmailcon(String emailcon) {
		this.emailcon = emailcon;
	}

	public String getEmailemp() {
		return this.emailemp;
	}

	public void setEmailemp(String emailemp) {
		this.emailemp = emailemp;
	}

	public String getEstadorg() {
		return this.estadorg;
	}

	public void setEstadorg(String estadorg) {
		this.estadorg = estadorg;
	}

	public String getNombcome() {
		return this.nombcome;
	}

	public void setNombcome(String nombcome) {
		this.nombcome = nombcome;
	}

	public String getRzsocial() {
		return this.rzsocial;
	}

	public void setRzsocial(String rzsocial) {
		this.rzsocial = rzsocial;
	}

	public String getSituacrg() {
		return this.situacrg;
	}

	public void setSituacrg(String situacrg) {
		this.situacrg = situacrg;
	}

	public short getSwmigrad() {
		return this.swmigrad;
	}

	public void setSwmigrad(short swmigrad) {
		this.swmigrad = swmigrad;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}