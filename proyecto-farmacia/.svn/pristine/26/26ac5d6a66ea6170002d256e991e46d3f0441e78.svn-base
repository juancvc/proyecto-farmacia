package hnch.referencia.core.entity.asistencial.referencia;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


@NamedStoredProcedureQueries(
		{
				
			@NamedStoredProcedureQuery(name = "referenciaDiagnostico.insertar",
					procedureName = "[RECO].[REFEDIAG_INSERT]", 
					resultClasses = Refediag.class, parameters = {
					@StoredProcedureParameter(mode = ParameterMode.OUT, name ="CODDIAGN", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODREFCB",  type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPERCB",  type = String.class),
					
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class), 
					
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "TG6CIEX",  type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSCR", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPCR", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODESPEC", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "TG1TPDX", type = String.class),
					
					}), 
			@NamedStoredProcedureQuery(
					name="referenciaDiagnostico.findByRefCb", 
					procedureName="[RECO].[REFEDIAG_FIND_BY_CODREFCB]",
					resultClasses= Refediag.class,
					parameters={ 
							@StoredProcedureParameter(mode = ParameterMode.IN, name ="CODREFCB", type = String.class),
						    @StoredProcedureParameter(mode = ParameterMode.IN, name ="NROPERIO", type = String.class),
						    @StoredProcedureParameter(mode = ParameterMode.IN, name ="NROVERSI", type = String.class),
						    
						    @StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
							@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
							@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class)
					}),
		} )

 
@Entity
@Table(name="REFEDIAG")
@NamedQuery(name="Refediag.findAll", query="SELECT r FROM Refediag r")
public class Refediag implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RefediagPK id;

	@Column(name="CODREFCB")
	private String codRefCb;
	
	@Column(name="NROPERCB")
	private String nroPerCB; 
	
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

	@Column(name="ESTADORG")
	private String estadorg;

	@Column(name="SITUACRG")
	private String situacrg;

	@Column(name="SWMIGRAD")
	private short swmigrad;

	@Column(name="TG6CIEX")
	private String tg6ciex;
	 
	@Column(name="TG1TPDX")
	private String tg1TPDXx;
	
	@Column(name="CODESPEC")
	private String codEspec;
	
	private String nombDiag;
	private String nomEspec;
	private String valgen04;
	private String nomTpDx;
	
	public Refediag() {
	}

	public RefediagPK getId() {
		return this.id;
	}

	public void setId(RefediagPK id) {
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

	public String getEstadorg() {
		return this.estadorg;
	}

	public void setEstadorg(String estadorg) {
		this.estadorg = estadorg;
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

	public String getTg6ciex() {
		return this.tg6ciex;
	}

	public void setTg6ciex(String tg6ciex) {
		this.tg6ciex = tg6ciex;
	}

	public String getCodRefCb() {
		return codRefCb;
	}

	public void setCodRefCb(String codRefCb) {
		this.codRefCb = codRefCb;
	}

	public String getNroPerCB() {
		return nroPerCB;
	}

	public void setNroPerCB(String nroPerCB) {
		this.nroPerCB = nroPerCB;
	}

	public String getNombDiag() {
		return nombDiag;
	}

	public void setNombDiag(String nombDiag) {
		this.nombDiag = nombDiag;
	}

	public String getValgen04() {
		return valgen04;
	}

	public void setValgen04(String valgen04) {
		this.valgen04 = valgen04;
	}

	public String getCodEspec() {
		return codEspec;
	}

	public void setCodEspec(String codEspec) {
		this.codEspec = codEspec;
	}

	public String getNomEspec() {
		return nomEspec;
	}

	public void setNomEspec(String nomEspec) {
		this.nomEspec = nomEspec;
	}

	public String getTg1TPDXx() {
		return tg1TPDXx;
	}

	public void setTg1TPDXx(String tg1tpdXx) {
		tg1TPDXx = tg1tpdXx;
	}

	public String getNomTpDx() {
		return nomTpDx;
	}

	public void setNomTpDx(String nomTpDx) {
		this.nomTpDx = nomTpDx;
	}
 
}