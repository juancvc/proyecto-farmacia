package sigelab.core.entity.asistencial.banco;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "estadoFisico.insertar", procedureName = "[SIGEHOV2BANC].[GENE].[ADMISION_POSTULANTES_INSERT_EVALFISICA]", resultClasses = EstadoFisico.class, parameters = {
				
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROVERSI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPERIO", type = String.class),
				
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODPERSO", type = String.class),
				
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FECHA", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "HORA", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "HTCO", type = String.class),
				
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODGRUPO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODFACTOR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CALIFDONA", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "OBS", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ESTADOEVF", type = String.class),
				
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "CODFISICO", type = String.class), 
				
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSCR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPCR", type = String.class),
 }),
@NamedStoredProcedureQuery(name = "estadoFisico.modificar", procedureName = "[SIGEHOV2BANC].[GENE].[ADMISION_UPDATE_EVALFISICA]", resultClasses = EstadoFisico.class, parameters = {
				
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODFISICO", type = String.class), 
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "NVERSION", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "NPERIODO", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODPERSO", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "HCTO", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODGRUPO", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODFACTOR", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CALIFDONA", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "OBS", type = String.class), 
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "ESTADOEVF", type = String.class)
		
 }),
@NamedStoredProcedureQuery(name = "estadoFisico.eliminar", procedureName = "[SIGEHOV2BANC].BANC.CAMPANIA_DELETE", resultClasses = EstadoFisico.class, parameters = {
		
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class),

		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODCAMPA", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPERIO", type = String.class),
	    @StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSMO", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPMO", type = String.class),
}),
@NamedStoredProcedureQuery(name = "estadoFisico.buscarPorFiltros", procedureName = "[SIGEHOV2BANC].[GENE].[ADMISION_ULTIMA_EVALUACION_FISICA]", resultClasses = EstadoFisico.class, parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODPERSO", type = String.class) })

})

@Entity
public class EstadoFisico implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	 private EstadoFisicoPK id;
 
	@Column(name = "FECHA")
	private Timestamp fecha;
	
	@Column(name = "HORA")
	private String hora;
	
	@Column(name = "CODPERSO")
	private String codPerso;
	
	@Column(name = "CODFACTOR")
	private String codFactor;
	
	@Column(name = "CALIFDONA")
	private String califDona;
	
	@Column(name = "OBS")
	private String observa;
	  
	@Column(name = "SITUACRG")
	private String situacRg;
	
	@Column(name = "HTCO")
	private String htco;
	
	@Column(name = "AUFECHCR")
	private Timestamp aufechcr;

	@Column(name = "AUFECHMO")
	private Timestamp aufechmo;
 
	private String grupo;
	private String factor;
	private String CALIFDONAN;
	private String RESULTADO;
	
	public EstadoFisico() {
	}


	public EstadoFisicoPK getId() {
		return id;
	}


	public void setId(EstadoFisicoPK id) {
		this.id = id;
	}

 

	public String getHora() {
		return hora;
	}


	public void setHora(String hora) {
		this.hora = hora;
	}


	public String getCodPerso() {
		return codPerso;
	}


	public void setCodPerso(String codPerso) {
		this.codPerso = codPerso;
	}


	public String getCodFactor() {
		return codFactor;
	}


	public void setCodFactor(String codFactor) {
		this.codFactor = codFactor;
	}


	public String getCalifDona() {
		return califDona;
	}


	public void setCalifDona(String califDona) {
		this.califDona = califDona;
	}


	public String getObserva() {
		return observa;
	}


	public void setObserva(String observa) {
		this.observa = observa;
	}


	public Timestamp getFecha() {
		return fecha;
	}


	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
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


	public String getHtco() {
		return htco;
	}


	public void setHtco(String htco) {
		this.htco = htco;
	}


	public String getGrupo() {
		return grupo;
	}


	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}


	public String getFactor() {
		return factor;
	}


	public void setFactor(String factor) {
		this.factor = factor;
	}


	public String getCALIFDONAN() {
		return CALIFDONAN;
	}


	public void setCALIFDONAN(String cALIFDONAN) {
		CALIFDONAN = cALIFDONAN;
	}


	public String getRESULTADO() {
		return RESULTADO;
	}


	public void setRESULTADO(String rESULTADO) {
		RESULTADO = rESULTADO;
	}
 
	 
}