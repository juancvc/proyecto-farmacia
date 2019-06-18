package hnch.referencia.core.entity.general;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the FAMILIAR database table.
 * 
 */
@Entity
@Table(name="FAMILIAR")
@NamedQuery(name="Familiar.findAll", query="SELECT f FROM Familiar f")
public class Familiar implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FamiliarPK id;

	@Column(name="AUCDUSCR")
	private String aucduscr;

	@Column(name="AUCDUSMO")
	private String aucdusmo;

	@Column(name="AUFECHMO")
	private Timestamp aufechmo;

	@Column(name="AUOBSEMO")
	private String auobsemo;

	@Column(name="AUPCIPCR")
	private String aupcipcr;

	@Column(name="AUPCIPMO")
	private String aupcipmo;

	@Column(name="CODPACIE")
	private String codpacie;

	@Column(name="CODPERFA")
	private String codperfa;

	@Column(name="CODPERSO")
	private String codperso;

	@Column(name="ESTADOFA")
	private String estadofa;

	@Column(name="FECHAMOD")
	private Timestamp fechamod;

	@Column(name="FECHCREA")
	private Timestamp fechcrea;

	@Column(name="FECHINSC")
	private Timestamp fechinsc;

	@Column(name="OBSERVAC")
	private String observac;

	@Column(name="SWMIGRAD")
	private short swmigrad;

	@Column(name="TG02SITU")
	private String tg02situ;

	@Column(name="TIPOFAMI")
	private String tipofami;

	public Familiar() {
	}

	public FamiliarPK getId() {
		return this.id;
	}

	public void setId(FamiliarPK id) {
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

	public String getCodpacie() {
		return this.codpacie;
	}

	public void setCodpacie(String codpacie) {
		this.codpacie = codpacie;
	}

	public String getCodperfa() {
		return this.codperfa;
	}

	public void setCodperfa(String codperfa) {
		this.codperfa = codperfa;
	}

	public String getCodperso() {
		return this.codperso;
	}

	public void setCodperso(String codperso) {
		this.codperso = codperso;
	}

	public String getEstadofa() {
		return this.estadofa;
	}

	public void setEstadofa(String estadofa) {
		this.estadofa = estadofa;
	}

	public Timestamp getFechamod() {
		return this.fechamod;
	}

	public void setFechamod(Timestamp fechamod) {
		this.fechamod = fechamod;
	}

	public Timestamp getFechcrea() {
		return this.fechcrea;
	}

	public void setFechcrea(Timestamp fechcrea) {
		this.fechcrea = fechcrea;
	}

	public Timestamp getFechinsc() {
		return this.fechinsc;
	}

	public void setFechinsc(Timestamp fechinsc) {
		this.fechinsc = fechinsc;
	}

	public String getObservac() {
		return this.observac;
	}

	public void setObservac(String observac) {
		this.observac = observac;
	}

	public short getSwmigrad() {
		return this.swmigrad;
	}

	public void setSwmigrad(short swmigrad) {
		this.swmigrad = swmigrad;
	}

	public String getTg02situ() {
		return this.tg02situ;
	}

	public void setTg02situ(String tg02situ) {
		this.tg02situ = tg02situ;
	}

	public String getTipofami() {
		return this.tipofami;
	}

	public void setTipofami(String tipofami) {
		this.tipofami = tipofami;
	}

}