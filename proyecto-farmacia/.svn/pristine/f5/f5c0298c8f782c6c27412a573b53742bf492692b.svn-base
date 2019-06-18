package hnch.referencia.core.entity.general;

import java.io.Serializable;
import javax.persistence.*;
 

import java.sql.Timestamp;




@NamedStoredProcedureQueries(
		{
				
		@NamedStoredProcedureQuery(name = "persona.insertar", procedureName = "[RECO].[PERSONA_INSERT]", resultClasses = Persona.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "CODPERSO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class),

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "APEPATER", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "APEMATER", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "PRINOMBR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "SEGNOMBR", type = String.class),

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TG1SEXO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TG1TPDOC", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NRODOCUM", type = String.class),

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSCR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPCR", type = String.class),

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CDPERSIG", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FECHANAC", type = Timestamp.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "NROPERIO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROCELU", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "SWRENIEC", type = String.class), }),
			
		@NamedStoredProcedureQuery(name = "persona.insertarPersonaBanco", procedureName = "SIGEHOV2GENE.[GENE].[USP_PERSONA_INSERT_BANCO_WEB]", resultClasses = Persona.class, parameters = {
	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "CODPERSO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "NROVERSI", type = String.class),
				
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "APEPATER", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "APEMATER", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "PRINOMBR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "SEGNOMBR", type = String.class),

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TG1SEXOP", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FECHANAC", type = String.class),
				
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODTIPOD", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NRODOCUM", type = String.class), 

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "LUGANACI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TG1NACIO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TG1ESCIV", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TG1OCUPA", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TG1NIINS", type = String.class),
				
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "CODCORXP", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CORREODE", type = String.class),
				
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "CODDIXPE", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "DIRECCIO", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODRGUBI", type = String.class),
				
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "CODTEXPE", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TELFNUMR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FOTO", type = byte[].class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "VARENIEC", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ORIGREGI", type = String.class),
				
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSCR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPCR", type = String.class),
			}),
		
		@NamedStoredProcedureQuery(name = "persona.actualizarPersonaBanco", procedureName = "SIGEHOV2GENE.[GENE].[USP_PERSONA_UPDATE_BANCO_WEB]", resultClasses = Persona.class, parameters = {
				
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODPERSO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "NROVERSI", type = String.class), 
				
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "LUGANACI", type = String.class), 
				
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TG1OCUPA", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TG1NIINS", type = String.class),
				
				@StoredProcedureParameter(mode = ParameterMode.INOUT, name = "CODCORXP", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CORREODE", type = String.class),
				
				@StoredProcedureParameter(mode = ParameterMode.INOUT, name = "CODDIXPE", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "DIRECCIO", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODRGUBI", type = String.class),
				
				@StoredProcedureParameter(mode = ParameterMode.INOUT, name = "CODTEXPE", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TELFNUMR", type = String.class),
				 
				
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSCR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPCR", type = String.class),
			}),		
		
		
		@NamedStoredProcedureQuery(
							name="persona.buscarPorDocumento", 
							procedureName="[RECO].[PERSONA_FIND_BY_NRODOC]",
							resultClasses= Persona.class,
							parameters={ 
										@StoredProcedureParameter(mode=ParameterMode.IN,name="TG1TPDOC", type=String.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN,name="NRODOCUM", type=String.class )
								}					
						),
				
				@NamedStoredProcedureQuery(
						name="persona.buscarPorDocumentoSigeho", 
						procedureName="[RECO].[PERSONA_SIGEHO_FIND_BY_NRODOC]",
						resultClasses= Persona.class,
						parameters={ 
									@StoredProcedureParameter(mode=ParameterMode.IN,name="TG1TPDOC", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,name="NRODOCUM", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,name="TIPO", type=String.class )
							}					
					),
			
			
			
				@NamedStoredProcedureQuery(
						name="persona.listar", 
						procedureName="[SIGEHOV2ASIS].[ATEN].[USP_REFERECB_ADMISION_BUSCA_PACIENTE_DNI_V2]",
						resultClasses= Persona.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN,name="dnipacit", type=String.class )
							}					
					) }
		
		)


@Entity
@Table(name="PERSONA")
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PersonaPK id;

	@Column(name="APEMATER")
	private String apemater;

	@Column(name="APEPATER")
	private String apepater;

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

	@Column(name="CORREOPE")
	private String correope;

	@Column(name="DONAORGA")
	private String donaorga;

	@Column(name="ESTADORG")
	private String estadorg;

	@Column(name="FCHFALLE")
	private Timestamp fchfalle;

	@Column(name="FECHANAC")
	private Timestamp fechanac;

	@Column(name="FECHVARE")
	private Timestamp fechvare;

	@Column(name="LUGANACI")
	private String luganaci; 

	@Column(name="OBSERVAC")
	private String observac;

	@Column(name="ORIGREGI")
	private String origregi;

	@Column(name="PRINOMBR")
	private String prinombr;

	@Column(name="SEGNOMBR")
	private String segnombr;

	@Column(name="SITUACRG")
	private String situacrg;

	@Column(name="SWCESANT")
	private String swcesant;

	@Column(name="SWEMPLEA")
	private String swemplea;

	@Column(name="SWFALLEC")
	private String swfallec;

	@Column(name="SWFAMEMP")
	private String swfamemp;

	@Column(name="SWFAMEMPHISORICO")
	private String swfamemphisorico;

	@Column(name="SWMIGRAD")
	private short swmigrad;

	@Column(name="SWNACID")
	private String swnacid;

	@Column(name="SWPACIEN")
	private String swpacien;

	@Column(name="SWVALEMP")
	private String swvalemp;

	@Column(name="SWVALPAC")
	private String swvalpac;

	@Column(name="TELFCELU")
	private String telfcelu;

	@Column(name="TELFFIJO")
	private String telffijo;

	@Column(name="TG1ESCIV")
	private String tg1esciv;

	@Column(name="TG1ETNIA")
	private String tg1etnia;

	@Column(name="TG1FACGS")
	private String tg1facgs;

	@Column(name="TG1GRSAN")
	private String tg1grsan;

	@Column(name="TG1NACIO")
	private String tg1nacio;

	@Column(name="TG1NIINS")
	private String tg1niins;

	@Column(name="TG1NROHI")
	private String tg1nrohi;

	@Column(name="TG1OCUPA")
	private String tg1ocupa;

	@Column(name="TG1RELIG")
	private String tg1relig;

	@Column(name="TG1SEXO")
	private String tg1sexop;

	@Column(name="VARENIEC")
	private String vareniec;

	@Column(name="TG1TPDOC")
	private String tg1TpDoc;
	
	@Column(name="NRODOCUM")
	private String nroDocum;
	
	@Column(name="CDPERSIG")
	private String codPersoSigeho;
	
	
	
//	@Column(name = "FOTODETA")
	private byte[] fotoDeta;
	 
	private String desDirec;
	
	private String tgUbigeo;
	private String NOMLARGO;
	private String NOMLUGNAC;
	private String CODUBINA;
	private String TELFNUMR;
	private String CORDESCR;
	private String CODCORXP;
	private String CODDIXPE;
	private String CODTEXPE;
	private String UBIDIREG;
	private String UBINAREG;
	private String NOMBTPNA;
	private String NOMBTPOC;
	private String NOMBTPSX;
	private String NOMBTPDO;
	
	
	public Persona() {
	}

	
	public String getNOMBTPNA() {
		return NOMBTPNA;
	}


	public void setNOMBTPNA(String nOMBTPNA) {
		NOMBTPNA = nOMBTPNA;
	}


	public String getNOMBTPOC() {
		return NOMBTPOC;
	}


	public void setNOMBTPOC(String nOMBTPOC) {
		NOMBTPOC = nOMBTPOC;
	}


	public String getNOMBTPSX() {
		return NOMBTPSX;
	}


	public void setNOMBTPSX(String nOMBTPSX) {
		NOMBTPSX = nOMBTPSX;
	}


	public String getNOMBTPDO() {
		return NOMBTPDO;
	}


	public void setNOMBTPDO(String nOMBTPDO) {
		NOMBTPDO = nOMBTPDO;
	}


	public String getNOMLARGO() {
		return NOMLARGO;
	}

	public void setNOMLARGO(String nOMLARGO) {
		NOMLARGO = nOMLARGO;
	}

	public PersonaPK getId() {
		return this.id;
	}

	public void setId(PersonaPK id) {
		this.id = id;
	}

	public String getApemater() {
		return this.apemater;
	}

	public void setApemater(String apemater) {
		this.apemater = apemater;
	}

	public String getApepater() {
		return this.apepater;
	}

	public void setApepater(String apepater) {
		this.apepater = apepater;
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

	public String getCorreope() {
		return this.correope;
	}

	public void setCorreope(String correope) {
		this.correope = correope;
	}

	public String getDonaorga() {
		return this.donaorga;
	}

	public void setDonaorga(String donaorga) {
		this.donaorga = donaorga;
	}

	public String getEstadorg() {
		return this.estadorg;
	}

	public void setEstadorg(String estadorg) {
		this.estadorg = estadorg;
	}

	public Timestamp getFchfalle() {
		return this.fchfalle;
	}

	public void setFchfalle(Timestamp fchfalle) {
		this.fchfalle = fchfalle;
	}

	public Timestamp getFechanac() {
		return this.fechanac;
	}

	public void setFechanac(Timestamp fechanac) {
		this.fechanac = fechanac;
	}

	public Timestamp getFechvare() {
		return this.fechvare;
	}

	public void setFechvare(Timestamp fechvare) {
		this.fechvare = fechvare;
	}

	public String getLuganaci() {
		return this.luganaci;
	}

	public void setLuganaci(String luganaci) {
		this.luganaci = luganaci;
	}
 
	public String getObservac() {
		return this.observac;
	}

	public void setObservac(String observac) {
		this.observac = observac;
	}

	public String getOrigregi() {
		return this.origregi;
	}

	public void setOrigregi(String origregi) {
		this.origregi = origregi;
	}

	public String getPrinombr() {
		return this.prinombr;
	}

	public void setPrinombr(String prinombr) {
		this.prinombr = prinombr;
	}

	public String getSegnombr() {
		return this.segnombr;
	}

	public void setSegnombr(String segnombr) {
		this.segnombr = segnombr;
	}

	public String getSituacrg() {
		return this.situacrg;
	}

	public void setSituacrg(String situacrg) {
		this.situacrg = situacrg;
	}

	public String getSwcesant() {
		return this.swcesant;
	}

	public void setSwcesant(String swcesant) {
		this.swcesant = swcesant;
	}

	public String getSwemplea() {
		return this.swemplea;
	}

	public void setSwemplea(String swemplea) {
		this.swemplea = swemplea;
	}

	public String getSwfallec() {
		return this.swfallec;
	}

	public void setSwfallec(String swfallec) {
		this.swfallec = swfallec;
	}

	public String getSwfamemp() {
		return this.swfamemp;
	}

	public void setSwfamemp(String swfamemp) {
		this.swfamemp = swfamemp;
	}

	public String getSwfamemphisorico() {
		return this.swfamemphisorico;
	}

	public void setSwfamemphisorico(String swfamemphisorico) {
		this.swfamemphisorico = swfamemphisorico;
	}

	public short getSwmigrad() {
		return this.swmigrad;
	}

	public void setSwmigrad(short swmigrad) {
		this.swmigrad = swmigrad;
	}

	public String getSwnacid() {
		return this.swnacid;
	}

	public void setSwnacid(String swnacid) {
		this.swnacid = swnacid;
	}

	public String getSwpacien() {
		return this.swpacien;
	}

	public void setSwpacien(String swpacien) {
		this.swpacien = swpacien;
	}

	public String getSwvalemp() {
		return this.swvalemp;
	}

	public void setSwvalemp(String swvalemp) {
		this.swvalemp = swvalemp;
	}

	public String getSwvalpac() {
		return this.swvalpac;
	}

	public void setSwvalpac(String swvalpac) {
		this.swvalpac = swvalpac;
	}

	public String getTelfcelu() {
		return this.telfcelu;
	}

	public void setTelfcelu(String telfcelu) {
		this.telfcelu = telfcelu;
	}

	public String getTelffijo() {
		return this.telffijo;
	}

	public void setTelffijo(String telffijo) {
		this.telffijo = telffijo;
	}

	public String getTg1esciv() {
		return this.tg1esciv;
	}

	public void setTg1esciv(String tg1esciv) {
		this.tg1esciv = tg1esciv;
	}

	public String getTg1etnia() {
		return this.tg1etnia;
	}

	public void setTg1etnia(String tg1etnia) {
		this.tg1etnia = tg1etnia;
	}

	public String getTg1facgs() {
		return this.tg1facgs;
	}

	public void setTg1facgs(String tg1facgs) {
		this.tg1facgs = tg1facgs;
	}

	public String getTg1grsan() {
		return this.tg1grsan;
	}

	public void setTg1grsan(String tg1grsan) {
		this.tg1grsan = tg1grsan;
	}

	public String getTg1nacio() {
		return this.tg1nacio;
	}

	public void setTg1nacio(String tg1nacio) {
		this.tg1nacio = tg1nacio;
	}

	public String getTg1niins() {
		return this.tg1niins;
	}

	public void setTg1niins(String tg1niins) {
		this.tg1niins = tg1niins;
	}

	public String getTg1nrohi() {
		return this.tg1nrohi;
	}

	public void setTg1nrohi(String tg1nrohi) {
		this.tg1nrohi = tg1nrohi;
	}

	public String getTg1ocupa() {
		return this.tg1ocupa;
	}

	public void setTg1ocupa(String tg1ocupa) {
		this.tg1ocupa = tg1ocupa;
	}

	public String getTg1relig() {
		return this.tg1relig;
	}

	public void setTg1relig(String tg1relig) {
		this.tg1relig = tg1relig;
	}

	public String getTg1sexop() {
		return this.tg1sexop;
	}

	public void setTg1sexop(String tg1sexop) {
		this.tg1sexop = tg1sexop;
	}

	public String getVareniec() {
		return this.vareniec;
	}

	public void setVareniec(String vareniec) {
		this.vareniec = vareniec;
	}

	public String getTg1TpDoc() {
		return tg1TpDoc;
	}

	public void setTg1TpDoc(String tg1TpDoc) {
		this.tg1TpDoc = tg1TpDoc;
	}

	public String getNroDocum() {
		return nroDocum;
	}

	public void setNroDocum(String nroDocum) {
		this.nroDocum = nroDocum;
	}

	public String getCodPersoSigeho() {
		return codPersoSigeho;
	}

	public void setCodPersoSigeho(String codPersoSigeho) {
		this.codPersoSigeho = codPersoSigeho;
	}

	public byte[] getFotoDeta() {
		return fotoDeta;
	}

	public void setFotoDeta(byte[] fotoDeta) {
		this.fotoDeta = fotoDeta;
	}

	public String getDesDirec() {
		return desDirec;
	}

	public void setDesDirec(String desDirec) {
		this.desDirec = desDirec;
	}

	public String getTgUbigeo() {
		return tgUbigeo;
	}

	public void setTgUbigeo(String tgUbigeo) {
		this.tgUbigeo = tgUbigeo;
	}

	public String getNOMLUGNAC() {
		return NOMLUGNAC;
	}

	public void setNOMLUGNAC(String nOMLUGNAC) {
		NOMLUGNAC = nOMLUGNAC;
	}

	public String getCODUBINA() {
		return CODUBINA;
	}

	public void setCODUBINA(String cODUBINA) {
		CODUBINA = cODUBINA;
	}

	public String getTELFNUMR() {
		return TELFNUMR;
	}

	public void setTELFNUMR(String tELFNUMR) {
		TELFNUMR = tELFNUMR;
	}

	public String getCORDESCR() {
		return CORDESCR;
	}

	public void setCORDESCR(String cORDESCR) {
		CORDESCR = cORDESCR;
	}

	public String getCODCORXP() {
		return CODCORXP;
	}

	public void setCODCORXP(String cODCORXP) {
		CODCORXP = cODCORXP;
	}

	public String getCODDIXPE() {
		return CODDIXPE;
	}

	public void setCODDIXPE(String cODDIXPE) {
		CODDIXPE = cODDIXPE;
	}

	public String getCODTEXPE() {
		return CODTEXPE;
	}

	public void setCODTEXPE(String cODTEXPE) {
		CODTEXPE = cODTEXPE;
	}

	public String getUBIDIREG() {
		return UBIDIREG;
	}

	public void setUBIDIREG(String uBIDIREG) {
		UBIDIREG = uBIDIREG;
	}

	public String getUBINAREG() {
		return UBINAREG;
	}

	public void setUBINAREG(String uBINAREG) {
		UBINAREG = uBINAREG;
	}

 
}