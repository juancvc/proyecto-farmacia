package sigelab.core.entity.asistencial.banco;

import java.io.Serializable;
import javax.persistence.*;

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "lugarCampania.insertar", procedureName = "[SIGEHOV2BANC].BANC.LUGCAMPA_INSERT", resultClasses = LugarCampania.class, parameters = {
				
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class),

				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "CODLUGCA", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NOMLUGCA", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODREGUB", type = String.class), 
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSCR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPCR", type = String.class),
 }),
@NamedStoredProcedureQuery(name = "lugarCampania.modificar", procedureName = "[SIGEHOV2BANC].BANC.LUGCAMPA_UPDATE", resultClasses = LugarCampania.class, parameters = {
				
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class),

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODLUGCA", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NOMLUGCA", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODREGUB", type = String.class),  
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSMO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPMO", type = String.class),
 }),
@NamedStoredProcedureQuery(name = "lugarCampania.eliminar", procedureName = "[SIGEHOV2BANC].BANC.LUGCAMPA_DELETE", resultClasses = LugarCampania.class, parameters = {
		
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class),

		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODLUGCA", type = String.class), 
	    @StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSMO", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPMO", type = String.class),
}),
@NamedStoredProcedureQuery(name = "lugarCampania.buscarPorFiltros", procedureName = "[SIGEHOV2BANC].[BANC].[LUGCAMPA_LISTA_X_FILTROS]", resultClasses = LugarCampania.class, parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "NOMLUGCA", type = String.class)})

})

@Entity
public class LugarCampania implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CODLUGCA")
	private String CodLugCa;
 
	@Column(name="CODORGAN")
	private String codorgan;

	@Column(name="CODINSTI")
	private String codinsti;

	@Column(name="CODSEDEI")
	private String codsedei; 

	@Column(name="NROVERSI")
	private String nroversi;

	@Column(name="NROPERIO")
	private String nroperio;
	
	@Column(name = "NOMLUGCA")
	private String nomLugCa;
	
	@Column(name = "LUGCAMPA")
	private String lugCampa;
	
	@Column(name = "CODREGUB")
	private String codRegUb;
	
	private String nombrLug;
	
	public LugarCampania() {
	}

 
	public String getCodRegUb() {
		return codRegUb;
	}


	public void setCodRegUb(String codRegUb) {
		this.codRegUb = codRegUb;
	}


	public String getNombrLug() {
		return nombrLug;
	}


	public void setNombrLug(String nombrLug) {
		this.nombrLug = nombrLug;
	}


	public String getCodLugCa() {
		return CodLugCa;
	}


	public void setCodLugCa(String codLugCa) {
		CodLugCa = codLugCa;
	} 

	public String getNomLugCa() {
		return nomLugCa;
	}


	public void setNomLugCa(String nomLugCa) {
		this.nomLugCa = nomLugCa;
	}


	public String getLugCampa() {
		return lugCampa;
	}


	public void setLugCampa(String lugCampa) {
		this.lugCampa = lugCampa;
	}


	public String getCodorgan() {
		return codorgan;
	}


	public void setCodorgan(String codorgan) {
		this.codorgan = codorgan;
	}


	public String getCodinsti() {
		return codinsti;
	}


	public void setCodinsti(String codinsti) {
		this.codinsti = codinsti;
	}


	public String getCodsedei() {
		return codsedei;
	}


	public void setCodsedei(String codsedei) {
		this.codsedei = codsedei;
	}


	public String getNroversi() {
		return nroversi;
	}


	public void setNroversi(String nroversi) {
		this.nroversi = nroversi;
	}


	public String getNroperio() {
		return nroperio;
	}


	public void setNroperio(String nroperio) {
		this.nroperio = nroperio;
	}


	 
}