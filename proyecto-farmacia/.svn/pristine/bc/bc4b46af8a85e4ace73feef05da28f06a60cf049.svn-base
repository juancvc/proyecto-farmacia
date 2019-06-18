package hnch.referencia.core.entity.asistencial.banco;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "preDonanteEntrevista.insertar", procedureName = "[SIGEHOV2BANC].[GENE].[ENTREVISTA_RESPUESTA_INSERT]", resultClasses = PreDonanteEntrevista.class, parameters = {
				
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROVERSI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "NROPERIO", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPOST", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FECHA", type = String.class), 
				 
				
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODPERSO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODREG", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "RESPTA", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "OBSERVAC", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODRESPU", type = String.class),
				
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSCR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPCR", type = String.class),
 }),
		
@NamedStoredProcedureQuery(name = "donante.insertarVoluntario", procedureName = "[SIGEHOV2BANC].[GENE].[DONANTE_VOLUNTARIO_INSERT]", resultClasses = PreDonanteEntrevista.class, parameters = {
				
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
@NamedStoredProcedureQuery(name = "preDonanteEntrevista.modificar", procedureName = "[SIGEHOV2BANC].BANC.CAMPANIA_UPDATE", resultClasses = PreDonanteEntrevista.class, parameters = {
				
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
@NamedStoredProcedureQuery(name = "preDonanteEntrevista.eliminar", procedureName = "[SIGEHOV2BANC].BANC.CAMPANIA_DELETE", resultClasses = PreDonanteEntrevista.class, parameters = {
		
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class),

		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODCAMPA", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPERIO", type = String.class),
	    @StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSMO", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPMO", type = String.class),
}),
@NamedStoredProcedureQuery(name = "preDonanteEntrevista.buscarPorFiltros", procedureName = "[SIGEHOV2BANC]. [BANC].[PREDONANTES_REPORTE_ENTREVISTA_DETALLE]", resultClasses = PreDonanteEntrevista.class, parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPOST", type = String.class) ,
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "NPERIODO", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODPERSO", type = String.class) 
		
})
		 
})


@Entity
public class PreDonanteEntrevista implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PreDonanteEntrevistaPK id;
  
	@Column(name = "FECHA")
	private Timestamp fecha;
	
	@Column(name = "CODREG")
	private String codReg; 
   
	@Column(name = "RESULTADO")
	private String resultado;
	
	@Column(name = "RESPTA")
	private String respta;
	
	@Column(name = "OBSERVAC")
	private String observac;
	
	@Column(name = "CODPACIT")
	private String codPacit;

	@Column(name = "HORA")
	private String hora;
	
	@Column(name = "ESTADOFL")
	private String estadoFl;
	
	@Column(name = "AUFECHCR")
	private Timestamp aufechcr;
	 
	private String PREGUNTA;
	
	private String apemater;
	private String apepater;
	private String prinombr;
	private String segnombr;
	private String nroDocum;
	private String nomLugca;
	
	
	public String getPREGUNTA() {
		return PREGUNTA;
	}


	public void setPREGUNTA(String pREGUNTA) {
		PREGUNTA = pREGUNTA;
	}


	public Timestamp getAufechcr() {
		return aufechcr;
	}


	public void setAufechcr(Timestamp aufechcr) {
		this.aufechcr = aufechcr;
	}


	public String getResultado() {
		return resultado;
	}


	public void setResultado(String resultado) {
		this.resultado = resultado;
	}


	public String getCodPacit() {
		return codPacit;
	}


	public void setCodPacit(String codPacit) {
		this.codPacit = codPacit;
	}


	public String getHora() {
		return hora;
	}


	public void setHora(String hora) {
		this.hora = hora;
	}


	public String getEstadoFl() {
		return estadoFl;
	}


	public void setEstadoFl(String estadoFl) {
		this.estadoFl = estadoFl;
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


	public PreDonanteEntrevistaPK getId() {
		return id;
	}


	public void setId(PreDonanteEntrevistaPK id) {
		this.id = id;
	}


	public Timestamp getFecha() {
		return fecha;
	}


	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}


	public String getCodReg() {
		return codReg;
	}


	public void setCodReg(String codReg) {
		this.codReg = codReg;
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


	@Override
	public String toString() {
		return "PreDonanteEntrevista [id=" + id + ", fecha=" + fecha + ", codReg=" + codReg + ", respta=" + respta
				+ ", observac=" + observac + "]";
	}
	
 
	 
	 
}