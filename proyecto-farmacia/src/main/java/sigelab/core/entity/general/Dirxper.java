package sigelab.core.entity.general;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the DIRXPER database table.
 * 
 */
@Entity
@Table(name="DIRXPER")
@NamedQuery(name="Dirxper.findAll", query="SELECT d FROM Dirxper d")
public class Dirxper implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DirxperPK id;
	
	@Column(name="AUCDUSCR")
	private String aucduscr;

	@Column(name="AUCDUSMO")
	private String aucdusmo;

	@Column(name="AUFECHCR")
	private Timestamp aufechcr;

	@Column(name="AUFECHMO")
	private String aufechmo;

	@Column(name="AUPCIPCR")
	private String aupcipcr;

	@Column(name="CODDIXPE")
	private String coddixpe;

	@Column(name="CODPERSO")
	private String codperso;

	@Column(name="DESCRIPC")
	private String descripc;

	@Column(name="ESTADODI")
	private String estadodi;

	@Column(name="FECHVARE")
	private String fechvare;

	@Column(name="PREDETER")
	private String predeter;

	@Column(name="REFERENC")
	private String referenc;

	@Column(name="SWMIGRAD")
	private short swmigrad;

	@Column(name="TG01CATG")
	private String tg01catg;

	@Column(name="TG01TIPO")
	private String tg01tipo;

	@Column(name="TG01TIPU")
	private String tg01tipu;

	@Column(name="TG02SITU")
	private String tg02situ;

	@Column(name="TGCODREG")
	private String tgcodreg;

	@Column(name="TGUBIGEO")
	private String tgubigeo;

	@Column(name="VARENIEC")
	private String vareniec;
	private String ubig;

	
	
	public Dirxper() {
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

	public String getAufechmo() {
		return this.aufechmo;
	}

	public void setAufechmo(String aufechmo) {
		this.aufechmo = aufechmo;
	}

	public String getAupcipcr() {
		return this.aupcipcr;
	}

	public void setAupcipcr(String aupcipcr) {
		this.aupcipcr = aupcipcr;
	}

	public String getCoddixpe() {
		return this.coddixpe;
	}

	public void setCoddixpe(String coddixpe) {
		this.coddixpe = coddixpe;
	}

	public String getCodperso() {
		return this.codperso;
	}

	public void setCodperso(String codperso) {
		this.codperso = codperso;
	}

	public String getDescripc() {
		return this.descripc;
	}

	public void setDescripc(String descripc) {
		this.descripc = descripc;
	}

	public String getEstadodi() {
		return this.estadodi;
	}

	public void setEstadodi(String estadodi) {
		this.estadodi = estadodi;
	}

	public String getFechvare() {
		return this.fechvare;
	}

	public void setFechvare(String fechvare) {
		this.fechvare = fechvare;
	}

	public String getPredeter() {
		return this.predeter;
	}

	public void setPredeter(String predeter) {
		this.predeter = predeter;
	}

	public String getReferenc() {
		return this.referenc;
	}

	public void setReferenc(String referenc) {
		this.referenc = referenc;
	}

	public short getSwmigrad() {
		return this.swmigrad;
	}

	public void setSwmigrad(short swmigrad) {
		this.swmigrad = swmigrad;
	}

	public String getTg01catg() {
		return this.tg01catg;
	}

	public void setTg01catg(String tg01catg) {
		this.tg01catg = tg01catg;
	}

	public String getTg01tipo() {
		return this.tg01tipo;
	}

	public void setTg01tipo(String tg01tipo) {
		this.tg01tipo = tg01tipo;
	}

	public String getTg01tipu() {
		return this.tg01tipu;
	}

	public void setTg01tipu(String tg01tipu) {
		this.tg01tipu = tg01tipu;
	}

	public String getTg02situ() {
		return this.tg02situ;
	}

	public void setTg02situ(String tg02situ) {
		this.tg02situ = tg02situ;
	}

	public String getTgcodreg() {
		return this.tgcodreg;
	}

	public void setTgcodreg(String tgcodreg) {
		this.tgcodreg = tgcodreg;
	}

	public String getTgubigeo() {
		return this.tgubigeo;
	}

	public void setTgubigeo(String tgubigeo) {
		this.tgubigeo = tgubigeo;
	}

	public String getVareniec() {
		return this.vareniec;
	}

	public void setVareniec(String vareniec) {
		this.vareniec = vareniec;
	}

}