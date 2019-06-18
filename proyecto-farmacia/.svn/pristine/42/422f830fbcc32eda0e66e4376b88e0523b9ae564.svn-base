package hnch.referencia.core.entity.asistencial.referencia;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The persistent class for the REFWEBCB database table.
 * 
 */
@NamedStoredProcedureQueries({

		@NamedStoredProcedureQuery(name = "referencia.insertar", procedureName = "RECO.REFERECB_INSERT", resultClasses = ReferenciaCB.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "CODREFCB", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "NROPERIO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "NROVERSI", type = String.class),

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class),

				// @StoredProcedureParameter(mode = ParameterMode.IN, name =
				// "FECHAREF", type = Timestamp.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FECHAREF", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "HORAREFE", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODESORI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TG14TPUPS", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODESPEC", type = String.class),

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGPA", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSPA", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDPA", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODPACIE", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROVERPA", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPERPA", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROHC", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROFILIA", type = String.class),

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TG14PLAN", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TG1TIEMP", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TIEMPOEN", type = int.class),

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TG1FORIN", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TG1CURSO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "SINTOMAS", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "RELATO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TEMPERAT", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "PRESARTE", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FRERESPI", type = String.class),

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FRECARDI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "EXAMAUXI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TRATAMIE", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TG14CNPA", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODESDES", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TG14MORE", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "MOTIVORE", type = String.class),

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CDORGRES", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CDINSRES", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CDSEDRES", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODPERES", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NRVERRES", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NRPERRES", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NCOLEGRE", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TGPROFRE", type = String.class),

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CDORGPES", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CDINSPES", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CDSEDPES", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODPEEST", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NRVERPES", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NRPERPES", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NCOLEGES", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TGPROFES", type = String.class),

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CDORGACO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CDINSACO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CDSEDACO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODPEACO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NRVERACO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NRPERACO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NCOLEGAC", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TGPROFAC", type = String.class),

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TG14TPSE", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CATEGORI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSCR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPCR", type = String.class) }),

		@NamedStoredProcedureQuery(name = "referencia.findByLikeObject", procedureName = "[RECO].[REFERECB_SELECT]", resultClasses = ReferenciaCB.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FECREFDESDE", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FECREFHASTA", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NOMBESTORIG", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODUSUAR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODPERFIL", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TIPOUPS", type = String.class) }),
		
		@NamedStoredProcedureQuery(name = "referencia.listarPendienteCitas", procedureName = "[RECO].[REFERECB_LISTA_PENDIENTE_CITA]", resultClasses = ReferenciaCB.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FECREFER", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODUSUAR", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TIPOUPS", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROREFER", type = String.class) }),
		
		@NamedStoredProcedureQuery(name = "referencia.listaEstadistico", procedureName = "RECO.USP_REFERECB_ESTADISTICO", resultClasses = ReferenciaCB.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FECREFDESDE", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FECREFHASTA", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NOMBESTORIG", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "SITUACRG", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NOMPACIENTE", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TIPOPACI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODUSUAR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODPERFIL", type = String.class) }),
		
		@NamedStoredProcedureQuery(name = "referencia.findByObject", procedureName = " [RECO].[REFERECB_FINDBYOBJECT]", resultClasses = ReferenciaCB.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODREFCB", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPERIO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROVERSI", type = String.class),

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class) }),
		
		@NamedStoredProcedureQuery(name = "referencia.eliminar", procedureName = "[RECO].[REFERECB_DESCARTAR]", resultClasses = ReferenciaCB.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODREFCB", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPERIO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROVERSI", type = String.class),

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class),

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TG14MDES", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "MOTIDESC", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSMO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPMO", type = String.class)

		}), })

@Entity
public class ReferenciaCB implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ReferenciaCBPK id;

	@Column(name = "CODORGPA")
	private String codORGPA;

	@Column(name = "CODINSPA")
	private String codINSPA;

	@Column(name = "CODSEDPA")
	private String codSEDPA;

	@Column(name = "CODPACIE")
	private String codPacie;

	@Column(name = "NROVERPA")
	private String nroVERPA;

	@Column(name = "NROPERPA")
	private String nroPERPA;

	@Column(name = "TG14TPUPS")
	private String tg14TpUPS;

	@Column(name = "CODESORI")
	private String codesOri;

	@Column(name = "CODESPEC")
	private String codEspec;

	@Column(name = "TG14PLAN")
	private String tg14PLAN;

	@Column(name = "TG1TIEMP")
	private String tg1TIEMP;

	@Column(name = "TIEMPOEN")
	private int tiempEnf;

	@Column(name = "TG1FORIN")
	private String tg1FORIN;

	@Column(name = "TG1CURSO")
	private String tg1CURSO;

	@Column(name = "SINTOMAS")
	private String sintomas;

	@Column(name = "RELATO")
	private String relato;

	@Column(name = "TEMPERAT")
	private String TEMPERAT;

	@Column(name = "PRESARTE")
	private String preSarte;

	@Column(name = "FRERESPI")
	private String freRespi;

	@Column(name = "FRECARDI")
	private String freCardi;

	@Column(name = "EXAMAUXI")
	private String examAuxi;

	@Column(name = "TRATAMIE")
	private String tratamien;

	@Column(name = "TG14CNPA")
	private String tg14CNPA;

	@Column(name = "CODESDES")
	private String codESDES;

	@Column(name = "HORAREFE")
	private String horaRefe;

	@Column(name = "NOMESPEC")
	private String nomEspec;

	@Column(name = "TG14MORE")
	private String tg14MoRe;

	@Column(name = "MOTIVORE")
	private String motivoRe;

	@Column(name = "NROHC")
	private String nroHC;

	@Column(name = "NROFILIA")
	private String nroFilia;

	@Column(name = "TG14TPSE")
	private String tg14TpSe;

	@Column(name = "CATEGORI")
	private String categori;

	@Column(name = "AUCDUSCR")
	private String aucduscr;

	@Column(name = "AUCDUSMO")
	private String aucdusmo;

	@Column(name = "AUFECHCR")
	private Timestamp aufechcr;

	@Column(name = "AUFECHMO")
	private Timestamp aufechmo;

	@Column(name = "AUOBSEMO")
	private String auobsemo;

	@Column(name = "AUPCIPCR")
	private String aupcipcr;

	@Column(name = "AUPCIPMO")
	private String aupcipmo;

	@Column(name = "ESTADORG")
	private String estadorg;

	@Column(name = "ESTAFSIS")
	private String estafsis;

	@Column(name = "FECHAREF")
	private Timestamp fchingrf;

	@Column(name = "FCHREFER")
	private Timestamp fchrefer;

	@Column(name = "SITUACRG")
	private String situacrg;

	@Column(name = "SWMIGRAD")
	private short swmigrad;

	@Column(name = "NROREFER")
	private String nroRefer;

	@Column(name = "CDORGRES")
	private String codRegEs;

	@Column(name = "CDINSRES")
	private String codInsRes;

	@Column(name = "CDSEDRES")
	private String codSedRes;

	@Column(name = "CODPERES")
	private String codPerRes;

	@Column(name = "NRVERRES")
	private String nroVerRes;

	@Column(name = "NRPERRES")
	private String nroPerRes;

	@Column(name = "NCOLEGRE")
	private String nroColRes;

	@Column(name = "TGPROFRE")
	private String tpProRes;

	@Column(name = "CDORGPES")
	private String codRegPes;

	@Column(name = "CDINSPES")
	private String codInsPes;

	@Column(name = "CDSEDPES")
	private String codSedPes;

	@Column(name = "CODPEEST")
	private String codPeEst;

	@Column(name = "NRVERPES")
	private String nroVerPes;

	@Column(name = "NRPERPES")
	private String nroPerPes;

	@Column(name = "NCOLEGES")
	private String nroColEst;

	@Column(name = "TGPROFES")
	private String tpProEst;

	@Column(name = "CDORGACO")
	private String codRegAco;

	@Column(name = "CDINSACO")
	private String codInsAco;

	@Column(name = "CDSEDACO")
	private String codSedAco;

	@Column(name = "CODPEACO")
	private String codPeAco;

	@Column(name = "NRVERACO")
	private String nroVerAco;

	@Column(name = "NRPERACO")
	private String nroPeAco;

	@Column(name = "NCOLEGAC")
	private String nroColAco;

	@Column(name = "TGPROFAC")
	private String tpProAco;

	private String nomTipoPac;
	private String apePater;
	private String apeMater;
	private String priNombr;
	private String segNombr;
	private String nroDocum;
	private String nomEstOri;
	private String nomEstDes;
	private String nombtpUPS;
	private String nomlaTPA;

	private String nombPlan;
	private String nombTiem;
	private String nombFori;
	private String nombCurso;
	private String nombSitu;
	private String nroCelu;
	private String edadAnios;
	private String edadCompleta;
	private String nomSexo;
	private Timestamp fechaNac;
	
	/*
	 * private String NCOLEGRE; private String TGPROFRE;
	 * 
	 * private String NCOLEGES; private String TGPROFES;
	 * 
	 * private String NCOLEGAC; private String TGPROFAC;
	 */
	private String NOMBMORE;
	private String NOMBCNPA;

	private String APEPARES;
	private String APEMARES;
	private String PRINORES;
	private String SEGNORES;

	private String APEPAPES;
	private String APEMAPES;
	private String PRINOPES;
	private String SEGNOPES;

	private String APEPAACO;
	private String APEMAACO;
	private String PRINOACO;
	private String SEGNOACO;
	private String CDPACSIG;
	
	public ReferenciaCB() {
	}

	public ReferenciaCBPK getId() {
		return this.id;
	}

	public void setId(ReferenciaCBPK id) {
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

	public String getCodORGPA() {
		return codORGPA;
	}

	public void setCodORGPA(String codORGPA) {
		this.codORGPA = codORGPA;
	}

	public String getCodINSPA() {
		return codINSPA;
	}

	public void setCodINSPA(String codINSPA) {
		this.codINSPA = codINSPA;
	}

	public String getCodSEDPA() {
		return codSEDPA;
	}

	public void setCodSEDPA(String codSEDPA) {
		this.codSEDPA = codSEDPA;
	}

	public String getCodPacie() {
		return codPacie;
	}

	public void setCodPacie(String codPacie) {
		this.codPacie = codPacie;
	}

	public String getNroVERPA() {
		return nroVERPA;
	}

	public void setNroVERPA(String nroVERPA) {
		this.nroVERPA = nroVERPA;
	}

	public String getNroPERPA() {
		return nroPERPA;
	}

	public void setNroPERPA(String nroPERPA) {
		this.nroPERPA = nroPERPA;
	}

	public String getTg14TpUPS() {
		return tg14TpUPS;
	}

	public void setTg14TpUPS(String tg14TpUPS) {
		this.tg14TpUPS = tg14TpUPS;
	}

	public String getCodesOri() {
		return codesOri;
	}

	public void setCodesOri(String codesOri) {
		this.codesOri = codesOri;
	}

	public String getCodEspec() {
		return codEspec;
	}

	public void setCodEspec(String codEspec) {
		this.codEspec = codEspec;
	}

	public String getTg14PLAN() {
		return tg14PLAN;
	}

	public void setTg14PLAN(String tg14plan) {
		tg14PLAN = tg14plan;
	}

	public String getTg1TIEMP() {
		return tg1TIEMP;
	}

	public void setTg1TIEMP(String tg1tiemp) {
		tg1TIEMP = tg1tiemp;
	}

	public int getTiempEnf() {
		return tiempEnf;
	}

	public void setTiempEnf(int tiempEnf) {
		this.tiempEnf = tiempEnf;
	}

	public String getTg1FORIN() {
		return tg1FORIN;
	}

	public void setTg1FORIN(String tg1forin) {
		tg1FORIN = tg1forin;
	}

	public String getTg1CURSO() {
		return tg1CURSO;
	}

	public void setTg1CURSO(String tg1curso) {
		tg1CURSO = tg1curso;
	}

	public String getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

	public String getRelato() {
		return relato;
	}

	public void setRelato(String relato) {
		this.relato = relato;
	}

	public String getTEMPERAT() {
		return TEMPERAT;
	}

	public void setTEMPERAT(String tEMPERAT) {
		TEMPERAT = tEMPERAT;
	}

	public String getPresArte() {
		return preSarte;
	}

	public void setPreSarte(String preSarte) {
		this.preSarte = preSarte;
	}

	public String getFreRespi() {
		return freRespi;
	}

	public void setFreRespi(String freRespi) {
		this.freRespi = freRespi;
	}

	public String getFreCardi() {
		return freCardi;
	}

	public void setFreCardi(String freCardi) {
		this.freCardi = freCardi;
	}

	public String getExamAuxi() {
		return examAuxi;
	}

	public void setExamAuxi(String examAuxi) {
		this.examAuxi = examAuxi;
	}

	public String getTratamien() {
		return tratamien;
	}

	public void setTratamien(String tratamien) {
		this.tratamien = tratamien;
	}

	public String getTg14CNPA() {
		return tg14CNPA;
	}

	public void setTg14CNPA(String tg14cnpa) {
		tg14CNPA = tg14cnpa;
	}

	public String getCodESDES() {
		return codESDES;
	}

	public void setCodESDES(String codESDES) {
		this.codESDES = codESDES;
	}

	public String getEstadorg() {
		return estadorg;
	}

	public void setEstadorg(String estadorg) {
		this.estadorg = estadorg;
	}

	public String getEstafsis() {
		return estafsis;
	}

	public void setEstafsis(String estafsis) {
		this.estafsis = estafsis;
	}

	public Timestamp getFchingrf() {
		return fchingrf;
	}

	public void setFchingrf(Timestamp fchingrf) {
		this.fchingrf = fchingrf;
	}

	public Timestamp getFchrefer() {
		return fchrefer;
	}

	public void setFchrefer(Timestamp fchrefer) {
		this.fchrefer = fchrefer;
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

	public String getNomTipoPac() {
		return nomTipoPac;
	}

	public void setNomTipoPac(String nomTipoPac) {
		this.nomTipoPac = nomTipoPac;
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

	public String getNomEstOri() {
		return nomEstOri;
	}

	public void setNomEstOri(String nomEstOri) {
		this.nomEstOri = nomEstOri;
	}

	public String getNomEstDes() {
		return nomEstDes;
	}

	public void setNomEstDes(String nomEstDes) {
		this.nomEstDes = nomEstDes;
	}

	public String getHoraRefe() {
		return horaRefe;
	}

	public void setHoraRefe(String horaRefe) {
		this.horaRefe = horaRefe;
	}

	public String getNomEspec() {
		return nomEspec;
	}

	public void setNomEspec(String nomEspec) {
		this.nomEspec = nomEspec;
	}

	public String getTg14MoRe() {
		return tg14MoRe;
	}

	public void setTg14MoRe(String tg14MoRe) {
		this.tg14MoRe = tg14MoRe;
	}

	public String getMotivoRe() {
		return motivoRe;
	}

	public void setMotivoRe(String motivoRe) {
		this.motivoRe = motivoRe;
	}

	public String getNroHC() {
		return nroHC;
	}

	public void setNroHC(String nroHC) {
		this.nroHC = nroHC;
	}

	public String getNroFilia() {
		return nroFilia;
	}

	public void setNroFilia(String nroFilia) {
		this.nroFilia = nroFilia;
	}

	public String getTg14TpSe() {
		return tg14TpSe;
	}

	public void setTg14TpSe(String tg14TpSe) {
		this.tg14TpSe = tg14TpSe;
	}

	public String getCategori() {
		return categori;
	}

	public void setCategori(String categori) {
		this.categori = categori;
	}

	public String getPreSarte() {
		return preSarte;
	}

	public String getNombtpUPS() {
		return nombtpUPS;
	}

	public void setNombtpUPS(String nombtpUPS) {
		this.nombtpUPS = nombtpUPS;
	}

	public String getNomlaTPA() {
		return nomlaTPA;
	}

	public void setNomlaTPA(String nomlaTPA) {
		this.nomlaTPA = nomlaTPA;
	}

	public String getNroDocum() {
		return nroDocum;
	}

	public void setNroDocum(String nroDocum) {
		this.nroDocum = nroDocum;
	}

	public String getNroRefer() {
		return nroRefer;
	}

	public void setNroRefer(String nroRefer) {
		this.nroRefer = nroRefer;
	}

	public String getNombPlan() {
		return nombPlan;
	}

	public void setNombPlan(String nombPlan) {
		this.nombPlan = nombPlan;
	}

	public String getNombTiem() {
		return nombTiem;
	}

	public void setNombTiem(String nombTiem) {
		this.nombTiem = nombTiem;
	}

	public String getNombFori() {
		return nombFori;
	}

	public void setNombFori(String nombFori) {
		this.nombFori = nombFori;
	}

	public String getNombCurso() {
		return nombCurso;
	}

	public void setNombCurso(String nombCurso) {
		this.nombCurso = nombCurso;
	}

	public String getNOMBMORE() {
		return NOMBMORE;
	}

	public void setNOMBMORE(String nOMBMORE) {
		NOMBMORE = nOMBMORE;
	}

	public String getNOMBCNPA() {
		return NOMBCNPA;
	}

	public void setNOMBCNPA(String nOMBCNPA) {
		NOMBCNPA = nOMBCNPA;
	}

	public String getCodRegEs() {
		return codRegEs;
	}

	public void setCodRegEs(String codRegEs) {
		this.codRegEs = codRegEs;
	}

	public String getCodInsRes() {
		return codInsRes;
	}

	public void setCodInsRes(String codInsRes) {
		this.codInsRes = codInsRes;
	}

	public String getCodSedRes() {
		return codSedRes;
	}

	public void setCodSedRes(String codSedRes) {
		this.codSedRes = codSedRes;
	}

	public String getCodPerRes() {
		return codPerRes;
	}

	public void setCodPerRes(String codPerRes) {
		this.codPerRes = codPerRes;
	}

	public String getNroVerRes() {
		return nroVerRes;
	}

	public void setNroVerRes(String nroVerRes) {
		this.nroVerRes = nroVerRes;
	}

	public String getNroPerRes() {
		return nroPerRes;
	}

	public void setNroPerRes(String nroPerRes) {
		this.nroPerRes = nroPerRes;
	}

	public String getNroColRes() {
		return nroColRes;
	}

	public void setNroColRes(String nroColRes) {
		this.nroColRes = nroColRes;
	}

	public String getTpProRes() {
		return tpProRes;
	}

	public void setTpProRes(String tpProRes) {
		this.tpProRes = tpProRes;
	}

	public String getCodRegPes() {
		return codRegPes;
	}

	public void setCodRegPes(String codRegPes) {
		this.codRegPes = codRegPes;
	}

	public String getCodInsPes() {
		return codInsPes;
	}

	public void setCodInsPes(String codInsPes) {
		this.codInsPes = codInsPes;
	}

	public String getCodSedPes() {
		return codSedPes;
	}

	public void setCodSedPes(String codSedPes) {
		this.codSedPes = codSedPes;
	}

	public String getCodPeEst() {
		return codPeEst;
	}

	public void setCodPeEst(String codPeEst) {
		this.codPeEst = codPeEst;
	}

	public String getNroVerPes() {
		return nroVerPes;
	}

	public void setNroVerPes(String nroVerPes) {
		this.nroVerPes = nroVerPes;
	}

	public String getNroPerPes() {
		return nroPerPes;
	}

	public void setNroPerPes(String nroPerPes) {
		this.nroPerPes = nroPerPes;
	}

	public String getNroColEst() {
		return nroColEst;
	}

	public void setNroColEst(String nroColEst) {
		this.nroColEst = nroColEst;
	}

	public String getTpProEst() {
		return tpProEst;
	}

	public void setTpProEst(String tpProEst) {
		this.tpProEst = tpProEst;
	}

	public String getCodRegAco() {
		return codRegAco;
	}

	public void setCodRegAco(String codRegAco) {
		this.codRegAco = codRegAco;
	}

	public String getCodInsAco() {
		return codInsAco;
	}

	public void setCodInsAco(String codInsAco) {
		this.codInsAco = codInsAco;
	}

	public String getCodSedAco() {
		return codSedAco;
	}

	public void setCodSedAco(String codSedAco) {
		this.codSedAco = codSedAco;
	}

	public String getCodPeAco() {
		return codPeAco;
	}

	public void setCodPeAco(String codPeAco) {
		this.codPeAco = codPeAco;
	}

	public String getNroVerAco() {
		return nroVerAco;
	}

	public void setNroVerAco(String nroVerAco) {
		this.nroVerAco = nroVerAco;
	}

	public String getNroPeAco() {
		return nroPeAco;
	}

	public void setNroPeAco(String nroPeAco) {
		this.nroPeAco = nroPeAco;
	}

	public String getNroColAco() {
		return nroColAco;
	}

	public void setNroColAco(String nroColAco) {
		this.nroColAco = nroColAco;
	}

	public String getTpProAco() {
		return tpProAco;
	}

	public void setTpProAco(String tpProAco) {
		this.tpProAco = tpProAco;
	}

	public String getAPEPARES() {
		return APEPARES;
	}

	public void setAPEPARES(String aPEPARES) {
		APEPARES = aPEPARES;
	}

	public String getAPEMARES() {
		return APEMARES;
	}

	public void setAPEMARES(String aPEMARES) {
		APEMARES = aPEMARES;
	}

	public String getPRINORES() {
		return PRINORES;
	}

	public void setPRINORES(String pRINORES) {
		PRINORES = pRINORES;
	}

	public String getSEGNORES() {
		return SEGNORES;
	}

	public void setSEGNORES(String sEGNORES) {
		SEGNORES = sEGNORES;
	}

	public String getAPEPAPES() {
		return APEPAPES;
	}

	public void setAPEPAPES(String aPEPAPES) {
		APEPAPES = aPEPAPES;
	}

	public String getAPEMAPES() {
		return APEMAPES;
	}

	public void setAPEMAPES(String aPEMAPES) {
		APEMAPES = aPEMAPES;
	}

	public String getPRINOPES() {
		return PRINOPES;
	}

	public void setPRINOPES(String pRINOPES) {
		PRINOPES = pRINOPES;
	}

	public String getSEGNOPES() {
		return SEGNOPES;
	}

	public void setSEGNOPES(String sEGNOPES) {
		SEGNOPES = sEGNOPES;
	}

	public String getAPEPAACO() {
		return APEPAACO;
	}

	public void setAPEPAACO(String aPEPAACO) {
		APEPAACO = aPEPAACO;
	}

	public String getAPEMAACO() {
		return APEMAACO;
	}

	public void setAPEMAACO(String aPEMAACO) {
		APEMAACO = aPEMAACO;
	}

	public String getPRINOACO() {
		return PRINOACO;
	}

	public void setPRINOACO(String pRINOACO) {
		PRINOACO = pRINOACO;
	}

	public String getSEGNOACO() {
		return SEGNOACO;
	}

	public void setSEGNOACO(String sEGNOACO) {
		SEGNOACO = sEGNOACO;
	}

	public String getNombSitu() {
		return nombSitu;
	}

	public void setNombSitu(String nombSitu) {
		this.nombSitu = nombSitu;
	}

	public String getNroCelu() {
		return nroCelu;
	}

	public void setNroCelu(String nroCelu) {
		this.nroCelu = nroCelu;
	}

	public String getEdadAnios() {
		return edadAnios;
	}

	public void setEdadAnios(String edadAnios) {
		this.edadAnios = edadAnios;
	}

	public String getEdadCompleta() {
		return edadCompleta;
	}

	public void setEdadCompleta(String edadCompleta) {
		this.edadCompleta = edadCompleta;
	}

	public String getNomSexo() {
		return nomSexo;
	}

	public void setNomSexo(String nomSexo) {
		this.nomSexo = nomSexo;
	}

	public Timestamp getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Timestamp fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getCDPACSIG() {
		return CDPACSIG;
	}

	public void setCDPACSIG(String cDPACSIG) {
		CDPACSIG = cDPACSIG;
	}

}