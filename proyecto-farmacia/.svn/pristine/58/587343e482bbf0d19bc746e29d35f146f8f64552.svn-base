
package hnch.referencia.core.entity.seguridad;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

@SuppressWarnings("serial")
@NamedStoredProcedureQueries({

		@NamedStoredProcedureQuery(name = "usuario.insertar", procedureName = "[SIGEHOV2SEGU].RECO.USP_USUARIO_INSERTAR", resultClasses = Usuario.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "CODUSUAR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "NROPERIO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NOMUSUAR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "PSWUSUAR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODPERSO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODIPERF", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSCR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPCR", type = String.class) }),
	
		@NamedStoredProcedureQuery(name = "usuario.actualizar", procedureName = "[SIGEHOV2SEGU].RECO.USP_USUARIO_UPDATE", resultClasses = Usuario.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODUSUAR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPERIO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NOMUSUAR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "PSWUSUAR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODPERSO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODIPERF", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSMO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPMO", type = String.class) }),
		
		@NamedStoredProcedureQuery(name = "usuario.eliminar", procedureName = "[SIGEHOV2SEGU].RECO.USP_USUARIO_DELETE", resultClasses = Usuario.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODUSUAR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPERIO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSMO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPMO", type = String.class) }),
	 
	 

		@NamedStoredProcedureQuery(name = "usuario.listar", procedureName = "SIGEHOV2SEGU.[RECO].[USP_USUARIO_FINDBYLIKEOBJECT]", resultClasses = Usuario.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NOMUSUAR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODIPERF", type = String.class)

		}),

		@NamedStoredProcedureQuery(name = "usuario.autenticar", procedureName = "SIGEHOV2SEGU.[RECO].[USP_USUARIO_AUTENTICAR]", resultClasses = Usuario.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NOMUSUAR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "PSWUSUAR", type = String.class) }),
	 
		  @NamedStoredProcedureQuery(name = "usuario.resetpass",
		  procedureName = "[SIGEHOV2SEGU].[RECO].[USP_USUARIO_RESTABLECER_CLAVE]", resultClasses =Usuario.class, parameters = {
		 
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "CODUSUAR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPERIO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.INOUT, name = "PSWUSUAR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSMO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPMO", type = String.class) }),
		  

		@NamedStoredProcedureQuery(name = "usuarioObj.buscarPorCodigoUsuario", procedureName = "[SIGEHOV2SEGU].[RECO].[USP_USUARIO_FINDBY_CODUSER]", resultClasses = Usuario.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODUSUAR", type = String.class) }),

		@NamedStoredProcedureQuery(name = "usuario.buscarxcodperso", procedureName = "SIGEHOV2SEGU.[RECO].[USP_USUARIO_FINDBY_CODPERSO]", resultClasses = Usuario.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODPERSO", type = String.class) }) })

@Entity
public class Usuario implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "CODUSUAR")
	private String nCodusuari;

/*	@Temporal(TemporalType.DATE)
	@Column(name = "d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name = "d_fecreg")
	private Date dFecreg;
*/
	@Column(name = "CODIPERF")
	private String nCodperfil;

	@Column(name = "NROPERIO")
	private String nroPerio;
	
	@Column(name = "CODORGAN")
	private String codOrgan;
	
	@Column(name = "CODINSTI")
	private String codInsti;
	
	@Column(name = "CODSEDEI")
	private String codSedei;
	
	@Column(name = "NROVERSI")
	private String nroVersi;
	
	
	@Column(name = "CODPERSO")
	private String nCodperso;

	@Column(name = "AUCDUSCR")
	private String nCodusureg;

	@Column(name = "SITUSUAR")
	private String nTm1situsu;

	@Column(name = "ESTADORG")
	private String vFlgest;

	@Column(name = "NOMUSUAR")
	private String vNomusuari;

	@Column(name = "PSWUSUAR")
	private String vPassusuar;

	@Column(name = "SWCLAVEP")
	private String vFlgrestpas;

	@Column(name = "NOMBPERF")
	private String nomPerfil;

	@Column(name = "APEPATER")
	private String apePater;

	@Column(name = "APEMATER")
	private String apeMater;

	@Column(name = "PRINOMBR")
	private String priNombr;

	@Column(name = "SEGNOMBR")
	private String segNombr;

	@Column(name = "NRODOCUM")
	private String nroDocum;
	
	@Column(name = "TG1TPDOC")
	private String tg1TpDoc;

	public Usuario() {
		return;
	}

	public String getnCodusuari() {
		return nCodusuari;
	}

	public void setnCodusuari(String nCodusuari) {
		this.nCodusuari = nCodusuari;
	}

	public String getnCodperfil() {
		return nCodperfil;
	}

	public void setnCodperfil(String nCodperfil) {
		this.nCodperfil = nCodperfil;
	}

	public String getnCodperso() {
		return nCodperso;
	}

	public void setnCodperso(String nCodperso) {
		this.nCodperso = nCodperso;
	}

	public String getnCodusureg() {
		return nCodusureg;
	}

	public void setnCodusureg(String nCodusureg) {
		this.nCodusureg = nCodusureg;
	}

	public String getnTm1situsu() {
		return nTm1situsu;
	}

	public void setnTm1situsu(String nTm1situsu) {
		this.nTm1situsu = nTm1situsu;
	}

	public String getvFlgest() {
		return vFlgest;
	}

	public void setvFlgest(String vFlgest) {
		this.vFlgest = vFlgest;
	}

	public String getvNomusuari() {
		return vNomusuari;
	}

	public void setvNomusuari(String vNomusuari) {
		this.vNomusuari = vNomusuari;
	}

	public String getvPassusuar() {
		return vPassusuar;
	}

	public void setvPassusuar(String vPassusuar) {
		this.vPassusuar = vPassusuar;
	}

	public String getvFlgrestpas() {
		return vFlgrestpas;
	}

	public void setvFlgrestpas(String vFlgrestpas) {
		this.vFlgrestpas = vFlgrestpas;
	}

	public String getNomPerfil() {
		return nomPerfil;
	}

	public void setNomPerfil(String nomPerfil) {
		this.nomPerfil = nomPerfil;
	}

	public String getApePater() {
		return apePater;
	}

	public void setApePater(String apePater) {
		this.apePater = apePater;
	}

	public String getApeMater() {
		return apeMater;
	}

	public void setApeMater(String apeMater) {
		this.apeMater = apeMater;
	}

	public String getPriNombr() {
		return priNombr;
	}

	public void setPriNombr(String priNombr) {
		this.priNombr = priNombr;
	}

	public String getSegNombr() {
		return segNombr;
	}

	public void setSegNombr(String segNombr) {
		this.segNombr = segNombr;
	}

	public String getNroDocum() {
		return nroDocum;
	}

	public void setNroDocum(String nroDocum) {
		this.nroDocum = nroDocum;
	}

	public String getTg1TpDoc() {
		return tg1TpDoc;
	}

	public void setTg1TpDoc(String tg1TpDoc) {
		this.tg1TpDoc = tg1TpDoc;
	}

	public String getNroPerio() {
		return nroPerio;
	}

	public void setNroPerio(String nroPerio) {
		this.nroPerio = nroPerio;
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

	@Override
	public String toString() {
		return "Usuario [nCodusuari=" + nCodusuari + ", nCodperfil=" + nCodperfil + ", nroPerio=" + nroPerio
				+ ", codOrgan=" + codOrgan + ", codInsti=" + codInsti + ", codSedei=" + codSedei + ", nroVersi="
				+ nroVersi + ", nCodperso=" + nCodperso + ", nCodusureg=" + nCodusureg + ", nTm1situsu=" + nTm1situsu
				+ ", vFlgest=" + vFlgest + ", vNomusuari=" + vNomusuari + ", vPassusuar=" + vPassusuar
				+ ", vFlgrestpas=" + vFlgrestpas + ", nomPerfil=" + nomPerfil + ", apePater=" + apePater + ", apeMater="
				+ apeMater + ", priNombr=" + priNombr + ", segNombr=" + segNombr + ", nroDocum=" + nroDocum
				+ ", tg1TpDoc=" + tg1TpDoc + "]";
	}
 
	 
 
}