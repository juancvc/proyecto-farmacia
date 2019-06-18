package hnch.referencia.core.entity.asistencial.banco;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "postulante.insertar", procedureName = "[SIGEHOV2BANC].[GENE].[ADMISION_POSTULANTE_INSERT]", resultClasses = Postulante.class, parameters = {
				
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROVERSI", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "NROPERIO", type = String.class),
			
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODPERSO", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "FECHA", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "HORA", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODTEXPE", type = String.class), 
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODDIXPE", type = String.class),
		    @StoredProcedureParameter(mode = ParameterMode.IN, name = "CODCORXP", type = String.class),
		    @StoredProcedureParameter(mode = ParameterMode.IN, name = "CODFISICO", type = String.class),
		    @StoredProcedureParameter(mode = ParameterMode.IN, name = "CODTIPODONA", type = String.class),
		    @StoredProcedureParameter(mode = ParameterMode.IN, name = "CODPARENT", type = String.class),
		    @StoredProcedureParameter(mode = ParameterMode.IN, name = "CODPROCE", type = String.class),
		    @StoredProcedureParameter(mode = ParameterMode.IN, name = "CODPACIT", type = String.class),
		    @StoredProcedureParameter(mode = ParameterMode.IN, name = "CODCONDI", type = String.class),
		    @StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSERVI", type = String.class),
		    @StoredProcedureParameter(mode = ParameterMode.IN, name = "CAMA", type = String.class),
		    @StoredProcedureParameter(mode = ParameterMode.IN, name = "ESTADOPO", type = String.class),
		    @StoredProcedureParameter(mode = ParameterMode.IN, name = "CODCAMPA", type = String.class),
		    @StoredProcedureParameter(mode = ParameterMode.IN, name = "VERCAMPD", type = String.class),
		    @StoredProcedureParameter(mode = ParameterMode.IN, name = "PERCAMPD", type = String.class),
		    
		    @StoredProcedureParameter(mode = ParameterMode.OUT, name = "NROPOST", type = String.class),
		    
		    @StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSCR", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPCR", type = String.class),
 }),
@NamedStoredProcedureQuery(name = "postulante.modificar", procedureName = "[SIGEHOV2BANC].BANC.CAMPANIA_UPDATE", resultClasses = Postulante.class, parameters = {
				
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class),

			@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODCAMPA", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPERIO", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "NOMCAMPA", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "LUGCAMPA", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "FECHAINI", type = String.class), 
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "FECHAFIN", type = String.class),
		    @StoredProcedureParameter(mode = ParameterMode.IN, name = "SITUACRG", type = String.class),
		    @StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSMO", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPMO", type = String.class),
 }),
@NamedStoredProcedureQuery(name = "postulante.eliminar", procedureName = "[SIGEHOV2BANC].[BANC].[POSTULANTE_DELETE]", resultClasses = Postulante.class, parameters = {
			
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class), 
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROVERSI", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPERIO", type = String.class),
			
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPOST", type = String.class),
			
		    @StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSMO", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPMO", type = String.class),
 }),
@NamedStoredProcedureQuery(name = "postulante.buscarPorFiltros", procedureName = "[SIGEHOV2BANC].[BANC].[POSTULANTE_CAMPANIA_LISTA_X_FILTRO]", resultClasses = Postulante.class, parameters = {
		
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODCAMPA", type = String.class) 
 }),
@NamedStoredProcedureQuery(name = "postulante.buscarPorObjeto", procedureName = "[SIGEHOV2BANC].[BANC].[POSTULANTE_CAMPANIA_LISTA_X_OBJETO]", resultClasses = Postulante.class, parameters = {
		
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class) ,
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class) ,
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class) ,
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPERIO", type = String.class) ,
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPOST", type = String.class) 
		
}),
@NamedStoredProcedureQuery(name = "postulante.buscarUltimaDonacion", procedureName = "[SIGEHOV2BANC].[GENE].[ADMISION_FECHA_ULTIMA_DONACION]", resultClasses = Postulante.class, parameters = {
		
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODPERSO", type = String.class) 
 }),

@NamedStoredProcedureQuery(name = "postulante.estadoFisicoBuscarPorFiltros", procedureName = "[SIGEHOV2BANC].[BANC].[POSTULANTE_ESTADOFISICO_CAMPANIA_LISTA_X_FILTRO]", resultClasses = Postulante.class, parameters = {
		
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "FECHADES", type = String.class) ,
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "FECHAHAS", type = String.class) ,
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "ESTADOEV", type = String.class)  
}),

@NamedStoredProcedureQuery(name = "postulante.estadoFisicoBuscarPorObjeto", procedureName = "[SIGEHOV2BANC]. [BANC].[POSTULANTE_ESTADOFISICO_CAMPANIA_LISTA_X_OBJETO]", resultClasses = Postulante.class, parameters = {
	
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class) ,
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class) ,
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class) ,
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPERIO", type = String.class) ,
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPOST", type = String.class) 
	
}),


@NamedStoredProcedureQuery(name = "postulante.preDonantesBuscarPorFiltros", procedureName = "[SIGEHOV2BANC].BANC.[PREDONANTES_ENTREVISTA_LISTA_X_FILTRO]", resultClasses = Postulante.class, parameters = {
		
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "FECHA", type = String.class)  
}),
	
@NamedStoredProcedureQuery(name = "postulante.litarEstadoFisicaPorPerso", procedureName = "[SIGEHOV2BANC].[GENE].[ADMISION_ULTIMA_EVALUACION_FISICA_V_WEB]", resultClasses = Postulante.class, parameters = {
		
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODPERSO", type = String.class) })

 

})


@Entity
public class Postulante implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	 private PostulantePK id;
 
	@Column(name = "CODCAMPA")
	private String codCampa;
	
	@Column(name = "LUGCAMPA")
	private String lugCampa; 
	
	@Column(name = "SITUACRG")
	private String situacRg;
	
	@Column(name = "AUFECHCR")
	private Timestamp aufechcr;

	@Column(name = "CODPERSO")
	private String codPerso;
	
	@Column(name="AUCDUSCR")
	private String aucduscr;
	
	@Column(name = "AUFECHMO")
	private Timestamp aufechmo;
	
	private String apemater;
	private String apepater;
	private String prinombr;
	private String segnombr;
	private Timestamp fechanac;
	private Timestamp fechaIni; 
	private Timestamp fechaFin; 
	private String nombSitu;
	
	private String NOMLUGCA; 
	private String fecha;
	private String NOMUSUAR;
	
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
	private String tg1esciv;
	private String tg1nacio;
	private String tg1niins;
	private String tg1nrohi;
	private String tg1ocupa;
	private String tg1sexop;
	private String edadPers;
	private String tg1TpDoc; 
	private String nroDocum;
	private String STRFECHANAC;
	
	private String estevalfi;
	private Timestamp fecEvalu; 
	private String hora;
	private String estadoEvf;
	private String codfactor;
	private String factor;
	private String codgrupo;
	private String grupo;
	private String obs;
	private String htco ;
	private String CODORGFA;
	private String CODINSFA;
	private String CODSEDFA;
	private String NROPERIFA;
	private String CODFISICO;
	private String NRVEREFA;
	private String CALIFDONA;
	private String NOMCALIF;
	private String TIPODONA;
	private String PARENTES;
	private String RESULTADO;
	
	
	
	public String getRESULTADO() {
		return RESULTADO;
	}

	public void setRESULTADO(String rESULTADO) {
		RESULTADO = rESULTADO;
	}

	public String getTIPODONA() {
		return TIPODONA;
	}

	public void setTIPODONA(String tIPODONA) {
		TIPODONA = tIPODONA;
	}

	public String getPARENTES() {
		return PARENTES;
	}

	public void setPARENTES(String pARENTES) {
		PARENTES = pARENTES;
	}

	public String getFactor() {
		return factor;
	}

	public void setFactor(String factor) {
		this.factor = factor;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public Postulante() {
	}
 
	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getCALIFDONA() {
		return CALIFDONA;
	}

	public void setCALIFDONA(String cALIFDONA) {
		CALIFDONA = cALIFDONA;
	}

	public String getNOMCALIF() {
		return NOMCALIF;
	}

	public void setNOMCALIF(String nOMCALIF) {
		NOMCALIF = nOMCALIF;
	}

	public String getNRVEREFA() {
		return NRVEREFA;
	}

	public void setNRVEREFA(String nRVEREFA) {
		NRVEREFA = nRVEREFA;
	}

	public String getCodfactor() {
		return codfactor;
	}

	public void setCodfactor(String codfactor) {
		this.codfactor = codfactor;
	}

	public String getCodgrupo() {
		return codgrupo;
	}

	public void setCodgrupo(String codgrupo) {
		this.codgrupo = codgrupo;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getHtco() {
		return htco;
	}

	public void setHtco(String htco) {
		this.htco = htco;
	}

	public String getCODORGFA() {
		return CODORGFA;
	}

	public void setCODORGFA(String cODORGFA) {
		CODORGFA = cODORGFA;
	}

	public String getCODINSFA() {
		return CODINSFA;
	}

	public void setCODINSFA(String cODINSFA) {
		CODINSFA = cODINSFA;
	}

	public String getCODSEDFA() {
		return CODSEDFA;
	}

	public void setCODSEDFA(String cODSEDFA) {
		CODSEDFA = cODSEDFA;
	}

	public String getNROPERIFA() {
		return NROPERIFA;
	}

	public void setNROPERIFA(String nROPERIFA) {
		NROPERIFA = nROPERIFA;
	}

	public String getCODFISICO() {
		return CODFISICO;
	}

	public void setCODFISICO(String cODFISICO) {
		CODFISICO = cODFISICO;
	}

	public String getEstadoEvf() {
		return estadoEvf;
	}

	public void setEstadoEvf(String estadoEvf) {
		this.estadoEvf = estadoEvf;
	}

	public PostulantePK getId() {
		return id;
	}
 
	public void setId(PostulantePK id) {
		this.id = id;
	} 

	public String getFecha() {
		return fecha;
	}
 
	public void setFecha(String fecha) {
		this.fecha = fecha;
	} 
 
	public String getLugCampa() {
		return lugCampa;
	}


	public void setLugCampa(String lugCampa) {
		this.lugCampa = lugCampa;
	}


	public Timestamp getFechaIni() {
		return fechaIni;
	}


	public void setFechaIni(Timestamp fechaIni) {
		this.fechaIni = fechaIni;
	}


	public Timestamp getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFin = fechaFin;
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


	public String getNombSitu() {
		return nombSitu;
	}


	public void setNombSitu(String nombSitu) {
		this.nombSitu = nombSitu;
	}


	public String getSituacRg() {
		return situacRg;
	}


	public void setSituacRg(String situacRg) {
		this.situacRg = situacRg;
	}

	public String getCodCampa() {
		return codCampa;
	}

	public void setCodCampa(String codCampa) {
		this.codCampa = codCampa;
	}

	public String getCodPerso() {
		return codPerso;
	}

	public void setCodPerso(String codPerso) {
		this.codPerso = codPerso;
	}

	public String getAucduscr() {
		return aucduscr;
	}

	public void setAucduscr(String aucduscr) {
		this.aucduscr = aucduscr;
	}

	public String getApemater() {
		return apemater;
	}

	public void setApemater(String apemater) {
		this.apemater = apemater;
	}

	public String getApepater() {
		return apepater;
	}

	public void setApepater(String apepater) {
		this.apepater = apepater;
	}

	public String getPrinombr() {
		return prinombr;
	}

	public void setPrinombr(String prinombr) {
		this.prinombr = prinombr;
	}

	public String getSegnombr() {
		return segnombr;
	}

	public void setSegnombr(String segnombr) {
		this.segnombr = segnombr;
	}

	public Timestamp getFechanac() {
		return fechanac;
	}

	public void setFechanac(Timestamp fechanac) {
		this.fechanac = fechanac;
	}

	public String getNOMLUGCA() {
		return NOMLUGCA;
	}

	public void setNOMLUGCA(String nOMLUGCA) {
		NOMLUGCA = nOMLUGCA;
	}

	public String getNOMUSUAR() {
		return NOMUSUAR;
	}

	public void setNOMUSUAR(String nOMUSUAR) {
		NOMUSUAR = nOMUSUAR;
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

	public String getNOMLARGO() {
		return NOMLARGO;
	}

	public void setNOMLARGO(String nOMLARGO) {
		NOMLARGO = nOMLARGO;
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

	public String getTg1esciv() {
		return tg1esciv;
	}

	public void setTg1esciv(String tg1esciv) {
		this.tg1esciv = tg1esciv;
	}

	public String getTg1nacio() {
		return tg1nacio;
	}

	public void setTg1nacio(String tg1nacio) {
		this.tg1nacio = tg1nacio;
	}

	public String getTg1niins() {
		return tg1niins;
	}

	public void setTg1niins(String tg1niins) {
		this.tg1niins = tg1niins;
	}

	public String getTg1nrohi() {
		return tg1nrohi;
	}

	public void setTg1nrohi(String tg1nrohi) {
		this.tg1nrohi = tg1nrohi;
	}

	public String getTg1ocupa() {
		return tg1ocupa;
	}

	public void setTg1ocupa(String tg1ocupa) {
		this.tg1ocupa = tg1ocupa;
	}

	public String getTg1sexop() {
		return tg1sexop;
	}

	public void setTg1sexop(String tg1sexop) {
		this.tg1sexop = tg1sexop;
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

	public String getSTRFECHANAC() {
		return STRFECHANAC;
	}

	public void setSTRFECHANAC(String sTRFECHANAC) {
		STRFECHANAC = sTRFECHANAC;
	}

	public String getEdadPers() {
		return edadPers;
	}

	public void setEdadPers(String edadPers) {
		this.edadPers = edadPers;
	}

	public String getEstevalfi() {
		return estevalfi;
	}

	public void setEstevalfi(String estevalfi) {
		this.estevalfi = estevalfi;
	}

	public Timestamp getFecEvalu() {
		return fecEvalu;
	}

	public void setFecEvalu(Timestamp fecEvalu) {
		this.fecEvalu = fecEvalu;
	} 
	 
}