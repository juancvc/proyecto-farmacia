package sigelab.core.entity.asistencial.banco;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "preDonante.insertar", procedureName = "[SIGEHOV2BANC].[GENE].[ENTREVISTA_PREDONANTES_INSERT_UPTADE_POSTU]", resultClasses = PreDonante.class, parameters = {
				
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROVERSI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPERIO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODENTRE", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FECHA", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "HORA", type = String.class),
				 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPOST", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODPERSO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODRESUL", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "RESULTADO", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "OBSERVA", type = String.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "PESO", type = String.class),
			    
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "TALLA", type = String.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "MASACP", type = String.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "VOLSANGP", type = String.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "PRESION", type = String.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "TEMPERAT", type = String.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "ESTACCVEN", type = String.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "PULSO", type = String.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "REITERAT", type = String.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "ESTADOPRE", type = String.class),
			    
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSCR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPCR", type = String.class),
 }),
		
 	
@NamedStoredProcedureQuery(name = "preDonante.modificar", procedureName = "[SIGEHOV2BANC].BANC.CAMPANIA_UPDATE", resultClasses = PreDonante.class, parameters = {
				
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
@NamedStoredProcedureQuery(name = "preDonante.eliminar", procedureName = "[SIGEHOV2BANC].BANC.CAMPANIA_DELETE", resultClasses = PreDonante.class, parameters = {
		
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class),

		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODCAMPA", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPERIO", type = String.class),
	    @StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSMO", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPMO", type = String.class),
}),
@NamedStoredProcedureQuery(name = "preDonante.buscarPorFiltros", procedureName = "[SIGEHOV2BANC].[BANC].[PREDONANTES_ENTREVISTADOS_LISTA_X_FILTRO]", resultClasses = PreDonante.class, parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "FECHA", type = String.class) 
		
}) ,

@NamedStoredProcedureQuery(name = "preDonante.buscarPorObjeto", procedureName = "[SIGEHOV2BANC].[BANC].[PREDONANTES_REPORTE_ENTREVISTA_CABECERA]", resultClasses = PreDonante.class, parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPOST", type = String.class) ,
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "NPERIODO", type = String.class) ,
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODPERSO", type = String.class) 
		
}) ,
@NamedStoredProcedureQuery(name = "preDonante.listarResultados", procedureName = "[SIGEHOV2BANC].[BANC].[ADMISION_CONSULTA_PARENTESCO_EVALUFISC_WEB]", resultClasses = PreDonante.class, parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODPERSO", type = String.class) 
		
}) ,
})


@Entity
public class PreDonante implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PreDonantePK id;
 
	@Column(name = "HORA")
	private String hora;
	
	@Column(name = "FECHA")
	private Timestamp fecha;
	
	@Column(name = "PRESION")
	private String presion; 
	
	@Column(name = "PULSO")
	private String pulso; 
	
	@Column(name = "PESO")
	private String peso; 
	
	@Column(name = "TALLA")
	private String talla; 
	
	@Column(name = "MASACP")
	private String masaCp; 
	
	@Column(name = "VOLSANGP")
	private String volsangp;
	
	@Column(name = "TEMPERAT")
	private String temperat;
	
	@Column(name = "ESTACCVEN")
	private String estaccven;
	
	@Column(name = "CODRESUL")
	private String codResul;
	
	@Column(name = "RESULTADO")
	private String resultado;
	
	@Column(name = "REITERAT")
	private String reiterat;
	
	@Column(name = "ESTADOPRE")
	private String estadoPre;
	
	@Column(name = "SITUACRG")
	private String situacRg;
	   
	@Column(name = "RESPTA")
	private String respta;
	
	@Column(name = "OBSERVA")
	private String observac;
	
	@Column(name = "CODPACIT")
	private String codPacit;
 
	@Column(name = "ESTADOFL")
	private String estadoFl;
	
	@Column(name = "AUFECHCR")
	private Timestamp aufechcr;
	
	@Column(name = "AUFECHMO")
	private Timestamp aufechmo;
	
	@Column(name = "AUCDUSCR")
	private String auCdUscr; 
	
	@Column(name = "LUGCAMPA")
	private String lugCampa;
	 
	private String apemater;
	private String apepater;
	private String prinombr;
	private String segnombr;
	private String nroDocum;
	private String nomLugca;
	private String edad;
	private String tipoDocu;
	private byte[] fotoDeta;
	 
	private String SEXO;
	private String NACIONALIDAD;
	private String EST_CIVIL;
	private String GRADOINST;
	private String OCUPACION;
	private String NACITO;
	private Timestamp FECHANAC;
	private String TELFNUMR;
	private String CORDESCR;
	private String TIP_DONACION;  
	private String HTCO; 
	private String GRUPO;
	private String FACTOR;
	private String ESTACCVENOS; 
	private String OBS;
	private String DESCRIPC;
	private String DETUBIDI; 
	private String NROPEPOS;
	private String PARENTESCO;
	private String DETALLED;
	private String APEPATPAC;
	private String APEMATPAC;
	private String PRINOMPAC;
	private String CALIFDONAN; 
	private String RESFLEB;
	private String VOLSANG;
	 
	public String getRESFLEB() {
		return RESFLEB;
	}

	public void setRESFLEB(String rESFLEB) {
		RESFLEB = rESFLEB;
	}

	public String getVOLSANG() {
		return VOLSANG;
	}

	public void setVOLSANG(String vOLSANG) {
		VOLSANG = vOLSANG;
	}

	public String getCALIFDONAN() {
		return CALIFDONAN;
	}

	public void setCALIFDONAN(String cALIFDONAN) {
		CALIFDONAN = cALIFDONAN;
	}

	public String getDETALLED() {
		return DETALLED;
	}

	public void setDETALLED(String dETALLED) {
		DETALLED = dETALLED;
	}

	public String getAPEPATPAC() {
		return APEPATPAC;
	}

	public void setAPEPATPAC(String aPEPATPAC) {
		APEPATPAC = aPEPATPAC;
	}

	public String getAPEMATPAC() {
		return APEMATPAC;
	}

	public void setAPEMATPAC(String aPEMATPAC) {
		APEMATPAC = aPEMATPAC;
	}

	public String getPRINOMPAC() {
		return PRINOMPAC;
	}

	public void setPRINOMPAC(String pRINOMPAC) {
		PRINOMPAC = pRINOMPAC;
	}

	public String getPARENTESCO() {
		return PARENTESCO;
	}

	public void setPARENTESCO(String pARENTESCO) {
		PARENTESCO = pARENTESCO;
	}

	public String getNROPEPOS() {
		return NROPEPOS;
	}

	public void setNROPEPOS(String nROPEPOS) {
		NROPEPOS = nROPEPOS;
	}

	public String getApemater() {
		return apemater;
	}
 
	public String getRespta() {
		return respta;
	}
 
	public void setRespta(String respta) {
		this.respta = respta;
	}
 
	public String getObservac() {
		return observac;
	} 
	
	public void setObservac(String observac) {
		this.observac = observac;
	}
 
	public String getCodPacit() {
		return codPacit;
	}

	public void setCodPacit(String codPacit) {
		this.codPacit = codPacit;
	}

	public String getEstadoFl() {
		return estadoFl;
	}

	public void setEstadoFl(String estadoFl) {
		this.estadoFl = estadoFl;
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



	public String getNroDocum() {
		return nroDocum;
	}



	public void setNroDocum(String nroDocum) {
		this.nroDocum = nroDocum;
	}



	public String getNomLugca() {
		return nomLugca;
	}



	public void setNomLugca(String nomLugca) {
		this.nomLugca = nomLugca;
	}



	public PreDonante() {
	}



	public PreDonantePK getId() {
		return id;
	}



	public void setId(PreDonantePK id) {
		this.id = id;
	}



	public String getHora() {
		return hora;
	}



	public void setHora(String hora) {
		this.hora = hora;
	}



	public Timestamp getFecha() {
		return fecha;
	}



	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}



	public String getPresion() {
		return presion;
	}



	public void setPresion(String presion) {
		this.presion = presion;
	}



	public String getPulso() {
		return pulso;
	}



	public void setPulso(String pulso) {
		this.pulso = pulso;
	}



	public String getPeso() {
		return peso;
	}



	public void setPeso(String peso) {
		this.peso = peso;
	}



	public String getTalla() {
		return talla;
	}



	public void setTalla(String talla) {
		this.talla = talla;
	}



	public String getMasaCp() {
		return masaCp;
	}



	public void setMasaCp(String masaCp) {
		this.masaCp = masaCp;
	}



	public String getVolsangp() {
		return volsangp;
	}



	public void setVolsangp(String volsangp) {
		this.volsangp = volsangp;
	}



	public String getTemperat() {
		return temperat;
	}



	public void setTemperat(String temperat) {
		this.temperat = temperat;
	}



	public String getEstaccven() {
		return estaccven;
	}



	public void setEstaccven(String estaccven) {
		this.estaccven = estaccven;
	}



	public String getCodResul() {
		return codResul;
	}



	public void setCodResul(String codResul) {
		this.codResul = codResul;
	}



	public String getResultado() {
		return resultado;
	}



	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

 
	public String getReiterat() {
		return reiterat;
	}



	public void setReiterat(String reiterat) {
		this.reiterat = reiterat;
	}



	public String getEstadoPre() {
		return estadoPre;
	}



	public void setEstadoPre(String estadoPre) {
		this.estadoPre = estadoPre;
	}



	public String getSituacRg() {
		return situacRg;
	}



	public void setSituacRg(String situacRg) {
		this.situacRg = situacRg;
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



	public String getAuCdUscr() {
		return auCdUscr;
	}



	public void setAuCdUscr(String auCdUscr) {
		this.auCdUscr = auCdUscr;
	}



	public String getLugCampa() {
		return lugCampa;
	}



	public void setLugCampa(String lugCampa) {
		this.lugCampa = lugCampa;
	}

	public String getTipoDocu() {
		return tipoDocu;
	}

	public void setTipoDocu(String tipoDocu) {
		this.tipoDocu = tipoDocu;
	}

	public byte[] getFotoDeta() {
		return fotoDeta;
	}

	public void setFotoDeta(byte[] fotoDeta) {
		this.fotoDeta = fotoDeta;
	}
 
	public String getSEXO() {
		return SEXO;
	}

	public void setSEXO(String sEXO) {
		SEXO = sEXO;
	}

	public String getNACIONALIDAD() {
		return NACIONALIDAD;
	}

	public void setNACIONALIDAD(String nACIONALIDAD) {
		NACIONALIDAD = nACIONALIDAD;
	}

	public String getEST_CIVIL() {
		return EST_CIVIL;
	}

	public void setEST_CIVIL(String eST_CIVIL) {
		EST_CIVIL = eST_CIVIL;
	}

	public String getGRADOINST() {
		return GRADOINST;
	}

	public void setGRADOINST(String gRADOINST) {
		GRADOINST = gRADOINST;
	}

	public String getOCUPACION() {
		return OCUPACION;
	}

	public void setOCUPACION(String oCUPACION) {
		OCUPACION = oCUPACION;
	}

	public String getNACITO() {
		return NACITO;
	}

	public void setNACITO(String nACITO) {
		NACITO = nACITO;
	}

	public Timestamp getFECHANAC() {
		return FECHANAC;
	}

	public void setFECHANAC(Timestamp fECHANAC) {
		FECHANAC = fECHANAC;
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

	public String getTIP_DONACION() {
		return TIP_DONACION;
	}

	public void setTIP_DONACION(String tIP_DONACION) {
		TIP_DONACION = tIP_DONACION;
	} 

	public String getHTCO() {
		return HTCO;
	}

	public void setHTCO(String hTCO) {
		HTCO = hTCO;
	}

 
 
	public String getGRUPO() {
		return GRUPO;
	}

	public void setGRUPO(String gRUPO) {
		GRUPO = gRUPO;
	}

	public String getFACTOR() {
		return FACTOR;
	}

	public void setFACTOR(String fACTOR) {
		FACTOR = fACTOR;
	}

	public String getESTACCVENOS() {
		return ESTACCVENOS;
	}

	public void setESTACCVENOS(String eSTACCVENOS) {
		ESTACCVENOS = eSTACCVENOS;
	}
 
	public String getOBS() {
		return OBS;
	}

	public void setOBS(String oBS) {
		OBS = oBS;
	}

	public String getDESCRIPC() {
		return DESCRIPC;
	}

	public void setDESCRIPC(String dESCRIPC) {
		DESCRIPC = dESCRIPC;
	}

	public String getDETUBIDI() {
		return DETUBIDI;
	}

	public void setDETUBIDI(String dETUBIDI) {
		DETUBIDI = dETUBIDI;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}
 
 
	 
}