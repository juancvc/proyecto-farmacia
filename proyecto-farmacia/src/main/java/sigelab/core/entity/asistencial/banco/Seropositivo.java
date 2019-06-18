package sigelab.core.entity.asistencial.banco;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "seropositivo.insertar", procedureName = "[SIGEHOV2BANC].BANC.CAMPANIA_INSERT", resultClasses = Seropositivo.class, parameters = {
				
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
@NamedStoredProcedureQuery(name = "seropositivo.modificar", procedureName = "[SIGEHOV2BANC].BANC.CAMPANIA_UPDATE", resultClasses = Seropositivo.class, parameters = {
				
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
@NamedStoredProcedureQuery(name = "seropositivo.eliminar", procedureName = "[SIGEHOV2BANC].BANC.CAMPANIA_DELETE", resultClasses = Seropositivo.class, parameters = {
		
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class),

		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODCAMPA", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPERIO", type = String.class),
	    @StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSMO", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPMO", type = String.class),
}),
@NamedStoredProcedureQuery(name = "seropositivo.buscarPorFiltros", procedureName = "[SIGEHOV2BANC].[GENE].[ADMISION_MUESTRA_RESULTSEROLOGIA]", resultClasses = Seropositivo.class, parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODPERSO", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "NRODOCUM", type = String.class)})

})

@Entity
public class Seropositivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	 private SeropositivoPK id;
 
	@Column(name = "PERIPOST")
	private String periPost;
	
	@Column(name = "FECHA")
	private String fecha;
	
	@Column(name = "NBOLSA")
	private String nBolsa; 
	
	@Column(name = "CODANALI")
	private String codAnali; 
	
	@Column(name = "ANALISIS")
	private String analisis; 
	
	@Column(name = "RESULTADO")
	private String resultado; 
	
	@Column(name = "VALORINI")
	private String valorIni; 
	
	@Column(name = "VALORFIN")
	private String valorFin; 
	
	@Column(name = "VALORRIS")
	private String valorRis; 
	
	@Column(name = "UNIDADES")
	private String unidades; 
	
	@Column(name = "OBSERVA")
	private String observa; 
	
	@Column(name = "FECHAFIN")
	private Timestamp fechaFin; 
	
	@Column(name = "TG02SITU")
	private String situacRg;
	
	@Column(name = "NRODOCUM")
	private String nroDocum;
	
	@Column(name = "AUFECHCR")
	private Timestamp aufechcr;

	@Column(name = "AUFECHMO")
	private Timestamp aufechmo;
  
	public Seropositivo() {
	}

	public SeropositivoPK getId() {
		return id;
	}

	public void setId(SeropositivoPK id) {
		this.id = id;
	}

	public String getPeriPost() {
		return periPost;
	}

	public void setPeriPost(String periPost) {
		this.periPost = periPost;
	} 
 
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getnBolsa() {
		return nBolsa;
	}

	public void setnBolsa(String nBolsa) {
		this.nBolsa = nBolsa;
	}

	public String getCodAnali() {
		return codAnali;
	}

	public void setCodAnali(String codAnali) {
		this.codAnali = codAnali;
	}

	public String getAnalisis() {
		return analisis;
	}

	public void setAnalisis(String analisis) {
		this.analisis = analisis;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getValorIni() {
		return valorIni;
	}

	public void setValorIni(String valorIni) {
		this.valorIni = valorIni;
	}

	public String getValorFin() {
		return valorFin;
	}

	public void setValorFin(String valorFin) {
		this.valorFin = valorFin;
	}

	public String getValorRis() {
		return valorRis;
	}

	public void setValorRis(String valorRis) {
		this.valorRis = valorRis;
	}

	public String getUnidades() {
		return unidades;
	}

	public void setUnidades(String unidades) {
		this.unidades = unidades;
	}

	public String getObserva() {
		return observa;
	}

	public void setObserva(String observa) {
		this.observa = observa;
	}

	public Timestamp getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getSituacRg() {
		return situacRg;
	}

	public void setSituacRg(String situacRg) {
		this.situacRg = situacRg;
	}

	public String getNroDocum() {
		return nroDocum;
	}

	public void setNroDocum(String nroDocum) {
		this.nroDocum = nroDocum;
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


	 
}