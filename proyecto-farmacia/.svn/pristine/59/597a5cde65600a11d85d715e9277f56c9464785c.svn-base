
package hnch.referencia.core.entity.seguridad;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

import java.util.Date;

@NamedStoredProcedureQueries({	
	@NamedStoredProcedureQuery(name = "perfil.insertar", 
		procedureName = "[SIGEHOV2SEGU].[RECO].[USP_PERFIL_INSERT] ", 
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "CODIPERF", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "NOMBPERF", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "AUCDUSCR", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "AUPCIPCR", type = String.class) 
		}),
		
	@NamedStoredProcedureQuery(name = "perfil.actualizar", 
	procedureName = "[SIGEHOV2SEGU].[RECO].[USP_PERFIL_UPDATE]", 
	resultClasses = Perfil.class,
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "CODIPERF", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "NOMBPERF", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "AUCDUSMO", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "AUPCIPMO", type = String.class)
	}),
	@NamedStoredProcedureQuery(name = "perfil.eliminar", 
	procedureName = " [SIGEHOV2SEGU].[RECO].[USP_PERFIL_DELETE]", 
	resultClasses = Perfil.class,
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODIPERF", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSMO", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPMO", type = String.class)
	}),
	@NamedStoredProcedureQuery(name = "perfil.listar", 
	procedureName = "[SIGEHOV2SEGU].RECO.USP_PERFIL_FINDBYLIKEOBJECT", 
	resultClasses = Perfil.class,
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "NOMBPERF", type = String.class) 
	}),

	@NamedStoredProcedureQuery(name = "perfil.buscarObjeto", 
	procedureName = "[SIGEHOV2SEGU].[RECO].[USP_PERFIL_FINDBYOBJECT] ", 
	resultClasses = Perfil.class,
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODIPERF", type = String.class) 
	}),
	@NamedStoredProcedureQuery(name = "perfil.listado", 
	procedureName = "[SIGEHOV2SEGU].[RECO].[USP_PERFIL_LISTADO]", 
	resultClasses = Perfil.class,
	parameters = {
		//@StoredProcedureParameter(mode = ParameterMode.IN, name = "NOMBPERF", type = String.class) 
	})
})

@Entity 
public class Perfil implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;
	 */
	
	@Id
	@Column(name="CODIPERF")
	private String codiPerf;

	@Column(name="NOMBPERF")
	private String nombPerf;
	
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

	public  Perfil(){
		return;
	}
	public String getCodiPerf() {
		return codiPerf;
	}

	public void setCodiPerf(String codiPerf) {
		this.codiPerf = codiPerf;
	}

	public String getNombPerf() {
		return nombPerf;
	}

	public void setNombPerf(String nombPerf) {
		this.nombPerf = nombPerf;
	}

	public String getAucduscr() {
		return aucduscr;
	}

	public void setAucduscr(String aucduscr) {
		this.aucduscr = aucduscr;
	}

	public String getAucdusmo() {
		return aucdusmo;
	}

	public void setAucdusmo(String aucdusmo) {
		this.aucdusmo = aucdusmo;
	}

	public Timestamp getAufechcr() {
		return aufechcr;
	}

	public void setAufechcr(Timestamp aufechcr) {
		this.aufechcr = aufechcr;
	}

	public Timestamp getAufechmo() {
		return aufechmo;
	}

	public void setAufechmo(Timestamp aufechmo) {
		this.aufechmo = aufechmo;
	}

	public String getAuobsemo() {
		return auobsemo;
	}

	public void setAuobsemo(String auobsemo) {
		this.auobsemo = auobsemo;
	}

	public String getAupcipcr() {
		return aupcipcr;
	}

	public void setAupcipcr(String aupcipcr) {
		this.aupcipcr = aupcipcr;
	}

	public String getAupcipmo() {
		return aupcipmo;
	}

	public void setAupcipmo(String aupcipmo) {
		this.aupcipmo = aupcipmo;
	}

	public String getEstadorg() {
		return estadorg;
	}

	public void setEstadorg(String estadorg) {
		this.estadorg = estadorg;
	}

	public String getSituacrg() {
		return situacrg;
	}

	public void setSituacrg(String situacrg) {
		this.situacrg = situacrg;
	}

	public short getSwmigrad() {
		return swmigrad;
	}

	public void setSwmigrad(short swmigrad) {
		this.swmigrad = swmigrad;
	}

	
}