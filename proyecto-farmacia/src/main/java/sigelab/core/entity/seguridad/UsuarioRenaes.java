
package sigelab.core.entity.seguridad;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

@NamedStoredProcedureQueries({

		@NamedStoredProcedureQuery(name = "usuarioRenaes.insertar", procedureName = "SIGEHOV2SEGU.[RECO].[USP_USURENAE_INSERTAR]", resultClasses = UsuarioRenaes.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "CODUSREN", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "NROPERIO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODUSUAR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODPERSO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODRGREN", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSCR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPCR", type = String.class) }),
		
		@NamedStoredProcedureQuery(name = "usuarioRenaes.eliminar", procedureName = "SIGEHOV2SEGU.[RECO].[USP_USURENAE_ELIMINAR]", resultClasses = UsuarioRenaes.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODUSREN", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODUSUAR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class),  
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSMO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPMO", type = String.class) }),
		
		@NamedStoredProcedureQuery(name = "sigehov2_usuario.autenticar", procedureName = "SIGEHOV2SEGU.[RECO].[USP_USUARIO_AUTENTICAR]", resultClasses = Usuario.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NOMUSUAR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "PSWUSUAR", type = String.class) }),

		@NamedStoredProcedureQuery(name = "usuarioRenaes.buscarxcodigousua", procedureName = "SIGEHOV2SEGU.[RECO].[USP_USURENAE_FINDBY_CODUSER]", resultClasses = UsuarioRenaes.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODUSUAR", type = String.class) }) })

@Entity
public class UsuarioRenaes implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@Column(name = "CODUSREN")
	private String codUsRen;

	@Column(name = "CODORGAN")
	private String codOrgan;

	@Column(name = "CODINSTI")
	private String codInsti;

	@Column(name = "CODSEDEI")
	private String codSedei;

	@Column(name = "NROVERSI")
	private String nroVersi;

	@Column(name = "NROPERIO")
	private String nroPerio;

	@Column(name = "CODUSUAR")
	private String codUsuar;

	@Column(name = "CODPERSO")
	private String codPeso;

	@Column(name = "CODRGREN")
	private String codRgRen;

	@Column(name = "ESTADORG")
	private String estadoRg;

	@Column(name = "SITUACRG")
	private String situaRG;

	@Column(name = "AUCDUSCR")
	private String aucduscr;

	@Temporal(TemporalType.DATE)
	@Column(name = "AUFECHCR")
	private Date aufechr;

	@Column(name = "AUPCIPCR")
	private String aupcipcr;

	@Temporal(TemporalType.DATE)
	@Column(name = "AUFECHMO")
	private Date aufechmo;

	@Column(name = "AUCDUSMO")
	private String aucdusmo;

	@Column(name = "SWMIGRAD")
	private String swmigrad;

	private String nomRenea;
	private String categoria;
	private String red;
	private String codRenea;

	public UsuarioRenaes() {
	}

	public String getCodUsRen() {
		return codUsRen;
	}

	public void setCodUsRen(String codUsRen) {
		this.codUsRen = codUsRen;
	}

	public String getCodOrgan() {
		return codOrgan;
	}

	public void setCodOrgan(String codOrgan) {
		this.codOrgan = codOrgan;
	}

	public String getCodInsti() {
		return codInsti;
	}

	public void setCodInsti(String codInsti) {
		this.codInsti = codInsti;
	}

	public String getCodSedei() {
		return codSedei;
	}

	public void setCodSedei(String codSedei) {
		this.codSedei = codSedei;
	}

	public String getNroVersi() {
		return nroVersi;
	}

	public void setNroVersi(String nroVersi) {
		this.nroVersi = nroVersi;
	}

	public String getNroPerio() {
		return nroPerio;
	}

	public void setNroPerio(String nroPerio) {
		this.nroPerio = nroPerio;
	}

	public String getCodUsuar() {
		return codUsuar;
	}

	public void setCodUsuar(String codUsuar) {
		this.codUsuar = codUsuar;
	}

	public String getCodPeso() {
		return codPeso;
	}

	public void setCodPeso(String codPeso) {
		this.codPeso = codPeso;
	}

	public String getCodRgRen() {
		return codRgRen;
	}

	public void setCodRgRen(String codRgRen) {
		this.codRgRen = codRgRen;
	}

	public String getEstadoRg() {
		return estadoRg;
	}

	public void setEstadoRg(String estadoRg) {
		this.estadoRg = estadoRg;
	}

	public String getSituaRG() {
		return situaRG;
	}

	public void setSituaRG(String situaRG) {
		this.situaRG = situaRG;
	}

	public String getAucduscr() {
		return aucduscr;
	}

	public void setAucduscr(String aucduscr) {
		this.aucduscr = aucduscr;
	}

	public Date getAufechr() {
		return aufechr;
	}

	public void setAufechr(Date aufechr) {
		this.aufechr = aufechr;
	}

	public String getAupcipcr() {
		return aupcipcr;
	}

	public void setAupcipcr(String aupcipcr) {
		this.aupcipcr = aupcipcr;
	}

	public Date getAufechmo() {
		return aufechmo;
	}

	public void setAufechmo(Date aufechmo) {
		this.aufechmo = aufechmo;
	}

	public String getAucdusmo() {
		return aucdusmo;
	}

	public void setAucdusmo(String aucdusmo) {
		this.aucdusmo = aucdusmo;
	}

	public String getSwmigrad() {
		return swmigrad;
	}

	public void setSwmigrad(String swmigrad) {
		this.swmigrad = swmigrad;
	}

	public String getNomRenea() {
		return nomRenea;
	}

	public void setNomRenea(String nomRenea) {
		this.nomRenea = nomRenea;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getRed() {
		return red;
	}

	public void setRed(String red) {
		this.red = red;
	}

	public String getCodRenea() {
		return codRenea;
	}

	public void setCodRenea(String codRenea) {
		this.codRenea = codRenea;
	}

}