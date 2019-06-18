package sigelab.core.entity.general;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the PERSONAL database table.
 * 
 */
@Entity
@Table(name="PERSONAL")
@NamedQuery(name="Personal.findAll", query="SELECT p FROM Personal p")
public class Personal implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PersonalPK id;

	@Column(name="ACTGREMI")
	private String actgremi;

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

	@Column(name="CODESPEC")
	private String codespec;

	@Column(name="CODRGREN")
	private String codrgren;

	@Column(name="CODVERSI")
	private String codversi;

	@Column(name="ESTADORG")
	private String estadorg;

	@Column(name="FECHINSC")
	private Timestamp fechinsc;

	@Column(name="FECINISE")
	private Timestamp fecinise;

	@Column(name="FECINSGR")
	private Timestamp fecinsgr;

	@Column(name="FECTERSE")
	private Timestamp fecterse;

	@Column(name="FOTOCHEC")
	private String fotochec;

	@Column(name="FUNCDESE")
	private String funcdese;

	@Column(name="IEDS")
	private String ieds;

	@Column(name="NROCOLEG")
	private String nrocoleg;

	@Column(name="NROCOLEGIO")
	private String nrocolegio;

	@Column(name="NROSESIG")
	private String nrosesig;

	@Column(name="OBSERVAC")
	private String observac;

	@Column(name="PLAZA")
	private String plaza;

	@Column(name="SITUACRG")
	private String situacrg;

	@Column(name="SWMIGRAD")
	private short swmigrad;

	@Column(name="TG03COND")
	private String tg03cond;

	@Column(name="TG03NIVE")
	private String tg03nive;

	@Column(name="TG1COLEP")
	private String tg1colep;

	@Column(name="TG1TPPER")
	private String tg1tpper;

	@Column(name="TG3GPOCU")
	private String tg3gpocu;

	@Column(name="TGNOMGRE")
	private String tgnomgre;

	@Column(name="TGTPGREM")
	private String tgtpgrem;

	public Personal() {
	}

	public PersonalPK getId() {
		return this.id;
	}

	public void setId(PersonalPK id) {
		this.id = id;
	}

	public String getActgremi() {
		return this.actgremi;
	}

	public void setActgremi(String actgremi) {
		this.actgremi = actgremi;
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

	public String getCodespec() {
		return this.codespec;
	}

	public void setCodespec(String codespec) {
		this.codespec = codespec;
	}

	public String getCodrgren() {
		return this.codrgren;
	}

	public void setCodrgren(String codrgren) {
		this.codrgren = codrgren;
	}

	public String getCodversi() {
		return this.codversi;
	}

	public void setCodversi(String codversi) {
		this.codversi = codversi;
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

	public Timestamp getFecinise() {
		return this.fecinise;
	}

	public void setFecinise(Timestamp fecinise) {
		this.fecinise = fecinise;
	}

	public Timestamp getFecinsgr() {
		return this.fecinsgr;
	}

	public void setFecinsgr(Timestamp fecinsgr) {
		this.fecinsgr = fecinsgr;
	}

	public Timestamp getFecterse() {
		return this.fecterse;
	}

	public void setFecterse(Timestamp fecterse) {
		this.fecterse = fecterse;
	}

	public String getFotochec() {
		return this.fotochec;
	}

	public void setFotochec(String fotochec) {
		this.fotochec = fotochec;
	}

	public String getFuncdese() {
		return this.funcdese;
	}

	public void setFuncdese(String funcdese) {
		this.funcdese = funcdese;
	}

	public String getIeds() {
		return this.ieds;
	}

	public void setIeds(String ieds) {
		this.ieds = ieds;
	}

	public String getNrocoleg() {
		return this.nrocoleg;
	}

	public void setNrocoleg(String nrocoleg) {
		this.nrocoleg = nrocoleg;
	}

	public String getNrocolegio() {
		return this.nrocolegio;
	}

	public void setNrocolegio(String nrocolegio) {
		this.nrocolegio = nrocolegio;
	}

	public String getNrosesig() {
		return this.nrosesig;
	}

	public void setNrosesig(String nrosesig) {
		this.nrosesig = nrosesig;
	}

	public String getObservac() {
		return this.observac;
	}

	public void setObservac(String observac) {
		this.observac = observac;
	}

	public String getPlaza() {
		return this.plaza;
	}

	public void setPlaza(String plaza) {
		this.plaza = plaza;
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

	public String getTg03cond() {
		return this.tg03cond;
	}

	public void setTg03cond(String tg03cond) {
		this.tg03cond = tg03cond;
	}

	public String getTg03nive() {
		return this.tg03nive;
	}

	public void setTg03nive(String tg03nive) {
		this.tg03nive = tg03nive;
	}

	public String getTg1colep() {
		return this.tg1colep;
	}

	public void setTg1colep(String tg1colep) {
		this.tg1colep = tg1colep;
	}

	public String getTg1tpper() {
		return this.tg1tpper;
	}

	public void setTg1tpper(String tg1tpper) {
		this.tg1tpper = tg1tpper;
	}

	public String getTg3gpocu() {
		return this.tg3gpocu;
	}

	public void setTg3gpocu(String tg3gpocu) {
		this.tg3gpocu = tg3gpocu;
	}

	public String getTgnomgre() {
		return this.tgnomgre;
	}

	public void setTgnomgre(String tgnomgre) {
		this.tgnomgre = tgnomgre;
	}

	public String getTgtpgrem() {
		return this.tgtpgrem;
	}

	public void setTgtpgrem(String tgtpgrem) {
		this.tgtpgrem = tgtpgrem;
	}

}