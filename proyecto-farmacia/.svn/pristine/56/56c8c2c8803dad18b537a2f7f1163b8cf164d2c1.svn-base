package hnch.referencia.core.entity.asistencial.banco;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "campania.insertar", procedureName = "[SIGEHOV2BANC].BANC.CAMPANIA_INSERT", resultClasses = Campania.class, parameters = {
				
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class),

				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "CODCAMPA", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NOMCAMPA", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "LUGCAMPA", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FECHAINI", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FECHAFIN", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODLUGCA", type = String.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "SITUACRG", type = String.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSCR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPCR", type = String.class),
 }),
@NamedStoredProcedureQuery(name = "campania.modificar", procedureName = "[SIGEHOV2BANC].BANC.CAMPANIA_UPDATE", resultClasses = Campania.class, parameters = {
				
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class),

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODCAMPA", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPERIO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NOMCAMPA", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "LUGCAMPA", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FECHAINI", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FECHAFIN", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODLUGCA", type = String.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "SITUACRG", type = String.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSMO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPMO", type = String.class),
 }),
@NamedStoredProcedureQuery(name = "campania.eliminar", procedureName = "[SIGEHOV2BANC].BANC.CAMPANIA_DELETE", resultClasses = Campania.class, parameters = {
		
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class),

		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODCAMPA", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPERIO", type = String.class),
	    @StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSMO", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPMO", type = String.class),
}),
@NamedStoredProcedureQuery(name = "campania.buscarPorFiltros", procedureName = "[SIGEHOV2BANC].BANC.CAMPANIA_LISTA_X_FILTROS", resultClasses = Campania.class, parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "NOMCAMPA", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "SITUACRG", type = String.class)})

})

@Entity
public class Campania implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	 private CampaniaPK id;
 
	@Column(name = "NOMCAMPA")
	private String nomCampa;
	
	@Column(name = "LUGCAMPA")
	private String lugCampa;
	
	@Column(name = "FECHAINI")
	private Timestamp fechaIni;
	
	@Column(name = "FECHAFIN")
	private Timestamp fechaFin; 
	
	@Column(name = "SITUACRG")
	private String situacRg;
	
	@Column(name = "CODLUGCA")
	private String codLugCa;
	
	@Column(name = "AUFECHCR")
	private Timestamp aufechcr;

	@Column(name = "AUFECHMO")
	private Timestamp aufechmo;
 
	private String nombSitu;
	
	private String nomLugCa;
	
	public Campania() {
	}


	public String getCodLugCa() {
		return codLugCa;
	}


	public void setCodLugCa(String codLugCa) {
		this.codLugCa = codLugCa;
	}


	public String getNomLugCa() {
		return nomLugCa;
	}


	public void setNomLugCa(String nomLugCa) {
		this.nomLugCa = nomLugCa;
	}


	public CampaniaPK getId() {
		return id;
	}


	public void setId(CampaniaPK id) {
		this.id = id;
	}


	public String getNomCampa() {
		return nomCampa;
	}


	public void setNomCampa(String nomCampa) {
		this.nomCampa = nomCampa;
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
	 
}