package hnch.referencia.core.entity.asistencial.referencia;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;



@NamedStoredProcedureQueries(
		{
				
			@NamedStoredProcedureQuery(name = "referenciaApoyoDX.insertar",
					procedureName = "[RECO].REFAPOYO_INSERT", 
					resultClasses = Refapoyo.class, parameters = {
					@StoredProcedureParameter(mode = ParameterMode.OUT, name ="CODAPOYO", type = String.class),
					
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODREFCB",  type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPERCB",  type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROVERCB",  type = String.class),
					
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class), 
					
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "TG14TPAP",  type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODTARCB",  type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSCR", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPCR", type = String.class)
					}), 
			@NamedStoredProcedureQuery(
					name="referenciaApoyoDX.findByRefCb", 
					procedureName="[RECO].[REFAPOYO_FIND_BY_CODREFCB]",
					resultClasses= Refapoyo.class,
					parameters={ 
							@StoredProcedureParameter(mode = ParameterMode.IN, name ="CODREFCB", type = String.class),
						    @StoredProcedureParameter(mode = ParameterMode.IN, name ="NROPERIO", type = String.class),
						    @StoredProcedureParameter(mode = ParameterMode.IN, name ="NROVERSI", type = String.class),
						    
						    @StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
							@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
							@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class)
					}),
		}
		)
@Entity
@Table(name="REFAPOYO")
@NamedQuery(name="Refapoyo.findAll", query="SELECT r FROM Refapoyo r")
public class Refapoyo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RefapoyoPK id;

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

	@Column(name="CODINSTCB")
	private String codinstcb;

	@Column(name="CODORGCB")
	private String codorgcb;

	@Column(name="CODREFCB")
	private String codrefcb;

	@Column(name="CODSEDCB")
	private String codsedcb;

	@Column(name="CODTARCB")
	private String codtarcb;

	@Column(name="ESTADORG")
	private String estadorg;

	@Column(name="NROPERCB")
	private String nropercb;

	@Column(name="NROVERCB")
	private String nrovercb;

	@Column(name="SITUACRG")
	private String situacrg;

	@Column(name="SWMIGRAD")
	private short swmigrad;

	@Column(name="TG14TPAP")
	private String tg14tpap;
	
	
	private String nomTPApo; 
	private String nomApoyo;
	

	public Refapoyo() {
	}

	public RefapoyoPK getId() {
		return this.id;
	}

	public void setId(RefapoyoPK id) {
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

	public String getCodinstcb() {
		return this.codinstcb;
	}

	public void setCodinstcb(String codinstcb) {
		this.codinstcb = codinstcb;
	}

	public String getCodorgcb() {
		return this.codorgcb;
	}

	public void setCodorgcb(String codorgcb) {
		this.codorgcb = codorgcb;
	}

	public String getCodrefcb() {
		return this.codrefcb;
	}

	public void setCodrefcb(String codrefcb) {
		this.codrefcb = codrefcb;
	}

	public String getCodsedcb() {
		return this.codsedcb;
	}

	public void setCodsedcb(String codsedcb) {
		this.codsedcb = codsedcb;
	}

	public String getCodtarcb() {
		return this.codtarcb;
	}

	public void setCodtarcb(String codtarcb) {
		this.codtarcb = codtarcb;
	}

	public String getEstadorg() {
		return this.estadorg;
	}

	public void setEstadorg(String estadorg) {
		this.estadorg = estadorg;
	}

	public String getNropercb() {
		return this.nropercb;
	}

	public void setNropercb(String nropercb) {
		this.nropercb = nropercb;
	}

	public String getNrovercb() {
		return this.nrovercb;
	}

	public void setNrovercb(String nrovercb) {
		this.nrovercb = nrovercb;
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

	public String getTg14tpap() {
		return this.tg14tpap;
	}

	public void setTg14tpap(String tg14tpap) {
		this.tg14tpap = tg14tpap;
	}

	public String getNomTPApo() {
		return nomTPApo;
	}

	public void setNomTPApo(String nomTPApo) {
		this.nomTPApo = nomTPApo;
	}

	public String getNomApoyo() {
		return nomApoyo;
	}

	public void setNomApoyo(String nomApoyo) {
		this.nomApoyo = nomApoyo;
	}

}