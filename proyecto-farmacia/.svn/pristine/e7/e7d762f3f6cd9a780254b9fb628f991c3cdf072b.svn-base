package hnch.referencia.core.entity.asistencial.referencia;

import java.io.Serializable;
import javax.persistence.*;
 
import java.sql.Timestamp;


@NamedStoredProcedureQueries(
		{
				
			@NamedStoredProcedureQuery(name = "referenciaEspecialidad.insertar",
					procedureName = "SIGEHOV2ASIS.[ATEN].[USP_REFESPEC_INSERT_WEB]", 
					resultClasses = ReferenciaEspecialidad.class, parameters = {
					@StoredProcedureParameter(mode = ParameterMode.OUT, name ="CODREGIS", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class), 
					
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODPERSO",  type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODCBREF",  type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPERCB",  type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROVERCB",  type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.OUT, name ="NUMREFER", type = String.class),
					  
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "TG01CLRE",  type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "TG01TIRE",  type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODRESPE",  type = String.class), 
					
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "SITUACRG",  type = String.class), 
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSCR", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPCR", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUOBSEMO",  type = String.class),
					}), 
		}
		)


@Entity
public class ReferenciaEspecialidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ReferenciaEspecialidadPK id;

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

	@Column(name="CODCBREF")
	private String codcbref;

	@Column(name="CODPERSO")
	private String codperso;

	@Column(name="CODRESPE")
	private String codrespe;

	@Column(name="ESTADORG")
	private String estadorg;

	@Column(name="NROPERCB")
	private String nropercb;

	@Column(name="NROVERCB")
	private String nrovercb;

	@Column(name="NUMREFER")
	private String numrefer;

	@Column(name="SITUACRG")
	private String situacrg;

	@Column(name="SWMIGRAD")
	private short swmigrad;

	@Column(name="TG01CLRE")
	private String tg01clre;

	@Column(name="TG01TIRE")
	private String tg01tire;

	public ReferenciaEspecialidad() {
	}

	public ReferenciaEspecialidadPK getId() {
		return this.id;
	}

	public void setId(ReferenciaEspecialidadPK id) {
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

	public String getCodcbref() {
		return this.codcbref;
	}

	public void setCodcbref(String codcbref) {
		this.codcbref = codcbref;
	}

	public String getCodperso() {
		return this.codperso;
	}

	public void setCodperso(String codperso) {
		this.codperso = codperso;
	}

	public String getCodrespe() {
		return this.codrespe;
	}

	public void setCodrespe(String codrespe) {
		this.codrespe = codrespe;
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

	public String getNumrefer() {
		return this.numrefer;
	}

	public void setNumrefer(String numrefer) {
		this.numrefer = numrefer;
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

	public String getTg01clre() {
		return this.tg01clre;
	}

	public void setTg01clre(String tg01clre) {
		this.tg01clre = tg01clre;
	}

	public String getTg01tire() {
		return this.tg01tire;
	}

	public void setTg01tire(String tg01tire) {
		this.tg01tire = tg01tire;
	}

}