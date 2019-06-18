package hnch.referencia.core.entity.asistencial.banco;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "bancoSangre.insertar", procedureName = "[SIGEHOV2BANC].BANC.CAMPANIA_INSERT", resultClasses = Donante.class, parameters = {
				
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class),

				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "CODCAMPA", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NOMCAMPA", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "LUGCAMPA", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FECHAINI", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FECHAFIN", type = String.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "SITUACRG", type = String.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSCR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPCR", type = String.class),
 }),
		
@NamedStoredProcedureQuery(name = "donante.insertarVoluntario", procedureName = "[SIGEHOV2BANC].[GENE].[DONANTE_VOLUNTARIO_INSERT]", resultClasses = Donante.class, parameters = {
				
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class),
				
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROVERSI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPERIO", type = String.class),
 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODPERSO", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TIPOREGT", type = String.class),
			    
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSCR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPCR", type = String.class),
 }),		
@NamedStoredProcedureQuery(name = "bancoSangre.modificar", procedureName = "[SIGEHOV2BANC].BANC.CAMPANIA_UPDATE", resultClasses = Donante.class, parameters = {
				
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
@NamedStoredProcedureQuery(name = "bancoSangre.eliminar", procedureName = "[SIGEHOV2BANC].BANC.CAMPANIA_DELETE", resultClasses = Donante.class, parameters = {
		
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class),

		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODCAMPA", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPERIO", type = String.class),
	    @StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSMO", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPMO", type = String.class),
}),
@NamedStoredProcedureQuery(name = "bancoSangre.buscarPorFiltros", procedureName = "[SIGEHOV2BANC].BANC.CAMPANIA_LISTA_X_FILTROS", resultClasses = Donante.class, parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "NOMCAMPA", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "SITUACRG", type = String.class)})
		,
@NamedStoredProcedureQuery(name = "donante.buscarUltimaDonacion", procedureName = "[SIGEHOV2BANC].[GENE].[ADMISION_FECHA_ULTIMA_DONACION]", resultClasses = Donante.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODPERSO", type = String.class) 
			})
})


@Entity
public class Donante implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	 private DonantePK id;
 
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
	
	@Column(name = "AUFECHCR")
	private Timestamp aufechcr;

	@Column(name = "AUFECHMO")
	private Timestamp aufechmo;
 
	private String nombSitu;
	
	private String fecha;
	
	public Donante() {
	}

 
	public DonantePK getId() {
		return id;
	}


	public void setId(DonantePK id) {
		this.id = id;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
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