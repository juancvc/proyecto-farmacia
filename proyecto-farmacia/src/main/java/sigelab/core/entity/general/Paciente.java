package sigelab.core.entity.general;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the PACIENTE database table.
 * 
 */
@NamedStoredProcedureQueries(
		{
				
			@NamedStoredProcedureQuery(name = "paciente.insertar",
					procedureName = "[RECO].[PACIENTE_INSERT]", 
					resultClasses = Paciente.class, parameters = {
					@StoredProcedureParameter(mode = ParameterMode.OUT, name ="CODPACIE", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.OUT, name ="NROPERIO", type = String.class),
					
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.OUT, name = "NROVERSI", type = String.class),
					
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODPERSO", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPERPE",  type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "APEPATER",  type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "APEMATER",  type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "PRINOMBR",  type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "SEGNOMBR",  type = String.class),
					
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "TG1SEXO",  type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "TG1TPDOC",  type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "NRODOCUM",  type = String.class),
					
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "TG14TPSE",  type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "CATEGORI",  type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROHC",  type = String.class),
					
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "CDPERSIG",  type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "FECHANAC",  type = Timestamp.class),   

					@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSCR", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPCR", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROCELU", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "SWRENIEC", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "SWVALSIS", type = String.class)
				
					
					}),

			@NamedStoredProcedureQuery(
						name="paciente.buscarPorPersona", 
						procedureName="[RECO].[PACIENTE_FIND_BY_CODPERSO]",
						resultClasses= Paciente.class,
						parameters={ 
									@StoredProcedureParameter(mode=ParameterMode.IN,name="CODPERSO", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,name="NROPERPE", type=String.class )
							}					
					),
			
		})
@Entity
@Table(name="PACIENTE")
@NamedQuery(name="Paciente.findAll", query="SELECT p FROM Paciente p")
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PacientePK id;

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

	@Column(name="CODPERMA")
	private String codperma;

	@Column(name="ESTADORG")
	private String estadorg;

	@Column(name="FECHINSC")
	private Timestamp fechinsc;

	@Column(name="NRIDESRN")
	private String nridesrn;

	@Column(name="NROTICKE")
	private String nroticke;

	@Column(name="NUMEIEDS")
	private String numeieds;

	@Column(name="NROHC")
	private String numerohc;

	@Column(name="SITUACRG")
	private String situacrg;

	@Column(name="SWMIGRAD")
	private short swmigrad;

	@Column(name="SWNUEVO")
	private short swnuevo;

	@Column(name="TG03ESPE")
	private String tg03espe;

	@Column(name="TGSITUPA")
	private String tgsitupa;

	@Column(name="CODPERSO")
	private String codPerso;
	
	@Column(name="NROVERPE")
	private String nroVerPe;
	
	@Column(name="NROPERPE")
	private String nroPerPe;
	
	@Column(name="TG14TPSE")
	private String tg14tpse;
	
	@Column(name="CATEGORI")
	private String categoria;
	 
	
	public Paciente() {
	}

	public PacientePK getId() {
		return this.id;
	}

	public void setId(PacientePK id) {
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

	public String getCodperma() {
		return this.codperma;
	}

	public void setCodperma(String codperma) {
		this.codperma = codperma;
	}

	public String getEstadorg() {
		return this.estadorg;
	}

	public void setEstadorg(String estadorg) {
		this.estadorg = estadorg;
	}

	public Timestamp getFechinsc() {
		return this.fechinsc;
	}

	public void setFechinsc(Timestamp fechinsc) {
		this.fechinsc = fechinsc;
	}

	public String getNridesrn() {
		return this.nridesrn;
	}

	public void setNridesrn(String nridesrn) {
		this.nridesrn = nridesrn;
	}

	public String getNroticke() {
		return this.nroticke;
	}

	public void setNroticke(String nroticke) {
		this.nroticke = nroticke;
	}

	public String getNumeieds() {
		return this.numeieds;
	}

	public void setNumeieds(String numeieds) {
		this.numeieds = numeieds;
	}

	public String getNumerohc() {
		return this.numerohc;
	}

	public void setNumerohc(String numerohc) {
		this.numerohc = numerohc;
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

	public short getSwnuevo() {
		return this.swnuevo;
	}

	public void setSwnuevo(short swnuevo) {
		this.swnuevo = swnuevo;
	}

	public String getTg03espe() {
		return this.tg03espe;
	}

	public void setTg03espe(String tg03espe) {
		this.tg03espe = tg03espe;
	}

	public String getTgsitupa() {
		return this.tgsitupa;
	}

	public void setTgsitupa(String tgsitupa) {
		this.tgsitupa = tgsitupa;
	}

	public String getCodPerso() {
		return codPerso;
	}

	public void setCodPerso(String codPerso) {
		this.codPerso = codPerso;
	}

	public String getNroVerPe() {
		return nroVerPe;
	}

	public void setNroVerPe(String nroVerPe) {
		this.nroVerPe = nroVerPe;
	}

	public String getNroPerPe() {
		return nroPerPe;
	}

	public void setNroPerPe(String nroPerPe) {
		this.nroPerPe = nroPerPe;
	}

	public String getTg14tpse() {
		return tg14tpse;
	}

	public void setTg14tpse(String tg14tpse) {
		this.tg14tpse = tg14tpse;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}