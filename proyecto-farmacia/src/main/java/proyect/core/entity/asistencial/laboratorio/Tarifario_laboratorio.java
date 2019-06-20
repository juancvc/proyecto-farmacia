package proyect.core.entity.asistencial.laboratorio;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;



@NamedStoredProcedureQueries(
		{ 
			@NamedStoredProcedureQuery(
					name="tarifario.listarPorFiltros", 
					procedureName="[LABO].[TARIFARIO_LISTAR_X_FILTROS]",
					resultClasses= Tarifario_laboratorio.class,
					parameters={ 
							@StoredProcedureParameter(mode = ParameterMode.IN, name ="TG1TIPOT", type = String.class) ,
							@StoredProcedureParameter(mode = ParameterMode.IN, name ="DESCRIPC", type = String.class) 
					}),
			@NamedStoredProcedureQuery(
					name="tarifario.registro", 
					procedureName="[LABO].[TARIFARIO_ITEM_INSERT]",
					resultClasses= Tarifario_laboratorio.class,
					parameters={ 
							@StoredProcedureParameter(mode = ParameterMode.OUT, name ="CODTARIF", type = 	String.class),			
							@StoredProcedureParameter(mode = ParameterMode.IN, name = "TG1TIPOT", type = 	String.class),
					//		@StoredProcedureParameter(mode = ParameterMode.IN, name = "TIPO",  	  type =	String.class),
							@StoredProcedureParameter(mode = ParameterMode.IN, name = "SUBTIPO",  type = 	String.class),						
							@StoredProcedureParameter(mode = ParameterMode.IN, name = "NOMPRODU", type = 	String.class),
							@StoredProcedureParameter(mode = ParameterMode.IN, name = "PRECIO",   type =    Float.class),
							@StoredProcedureParameter(mode = ParameterMode.IN, name = "TIPOUNID", type = 	String.class),
							@StoredProcedureParameter(mode = ParameterMode.IN, name = "VALREFIN", type = 	String.class),
							@StoredProcedureParameter(mode = ParameterMode.IN, name = "VALREFFI", type = 	String.class),
							@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUDUSUCR", type = 	String.class)
					}),
			@NamedStoredProcedureQuery(
					name="tarifario.actualizar", 
					procedureName="[LABO].[TARIFARIO_ITEM_UPDATE]",
					resultClasses= Tarifario_laboratorio.class,
					parameters={ 
							@StoredProcedureParameter(mode = ParameterMode.IN, name ="CODTARIF", type = 	String.class),			
							@StoredProcedureParameter(mode = ParameterMode.IN, name = "TG1TIPOT", type = 	String.class),
							@StoredProcedureParameter(mode = ParameterMode.IN, name = "TIPO",  	  type =	String.class),
							@StoredProcedureParameter(mode = ParameterMode.IN, name = "SUBTIPO",  type = 	String.class),	
							@StoredProcedureParameter(mode = ParameterMode.IN, name = "NOMPRODU", type = 	String.class),
							@StoredProcedureParameter(mode = ParameterMode.IN, name = "PRECIO",   type =    Float.class),
							@StoredProcedureParameter(mode = ParameterMode.IN, name = "TIPOUNID", type = 	String.class),
							@StoredProcedureParameter(mode = ParameterMode.IN, name = "VALREFIN", type = 	String.class),
							@StoredProcedureParameter(mode = ParameterMode.IN, name = "VALREFFI", type = 	String.class),
							@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSCR", type = 	String.class) 
					}),
			
			@NamedStoredProcedureQuery(
					name="tarifario.eliminar", 
					procedureName="[LABO].[TARIFARIO_ITEM_DELETE]",
					resultClasses= Tarifario_laboratorio.class,
					parameters={ 
							@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODTARIF", type = 	String.class),			
							@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSMO", type = 	String.class), 
							@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPMO", type = 	String.class) 
					}),
		}
		)
@Entity 
public class Tarifario_laboratorio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CODTARIF")
	private String CODTARIF;

	@Column(name="AUCDUSCR")
	private String aucduscr;
	
	@Column(name="TIPO")
	private String TIPO;
	
	@Column(name="SUBTIPO")
	private String SUBTIPO;
	
	@Column(name="NOMPRODU")
	private String NOMPRODU;
	
	@Column(name="PRECIO")
	private Float PRECIO;

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

	@Column(name="CODINSTCB")
	private String codinstcb;

	@Column(name="CODORGCB")
	private String codorgcb;

	@Column(name="CODREFCB")
	private String codrefcb;

	@Column(name="CODSEDCB")
	private String codsedcb;

	@Column(name="CODTARCB")
	private String codtarcb;

	@Column(name="ESTADORG")
	private String estadorg;

	@Column(name="NROPERCB")
	private String nropercb;

	@Column(name="NROVERCB")
	private String nrovercb;

	@Column(name="SITUACRG")
	private String situacrg;

	@Column(name="SWMIGRAD")
	private short swmigrad;

	@Column(name="TG1TIPOT")
	private String TG1TIPOT;
	
	@Column(name="TIPOUNID")
	private String unidades;
	
	@Column(name="VALREFIN")
	private String valoresRefIni;
	
	@Column(name="VALREFFI")
	private String valoresRefFin; 

	public Tarifario_laboratorio() {
	}



	public String getCODTARIF() {
		return CODTARIF;
	}



	public void setCODTARIF(String cODTARIF) {
		CODTARIF = cODTARIF;
	}



	public String getAucduscr() {
		return aucduscr;
	}



	public void setAucduscr(String aucduscr) {
		this.aucduscr = aucduscr;
	}



	public String getTIPO() {
		return TIPO;
	}



	public void setTIPO(String tIPO) {
		TIPO = tIPO;
	}



	public String getSUBTIPO() {
		return SUBTIPO;
	}



	public void setSUBTIPO(String sUBTIPO) {
		SUBTIPO = sUBTIPO;
	}



	public String getNOMPRODU() {
		return NOMPRODU;
	}



	public void setNOMPRODU(String nOMPRODU) {
		NOMPRODU = nOMPRODU;
	}



	public Float getPRECIO() {
		return PRECIO;
	}



	public void setPRECIO(Float pRECIO) {
		PRECIO = pRECIO;
	}



	public String getAucdusmo() {
		return aucdusmo;
	}



	public void setAucdusmo(String aucdusmo) {
		this.aucdusmo = aucdusmo;
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



	public String getAuobsemo() {
		return auobsemo;
	}



	public void setAuobsemo(String auobsemo) {
		this.auobsemo = auobsemo;
	}



	public String getAupcipcr() {
		return aupcipcr;
	}



	public void setAupcipcr(String aupcipcr) {
		this.aupcipcr = aupcipcr;
	}



	public String getAupcipmo() {
		return aupcipmo;
	}



	public void setAupcipmo(String aupcipmo) {
		this.aupcipmo = aupcipmo;
	}



	public String getCodinstcb() {
		return codinstcb;
	}



	public void setCodinstcb(String codinstcb) {
		this.codinstcb = codinstcb;
	}



	public String getCodorgcb() {
		return codorgcb;
	}



	public void setCodorgcb(String codorgcb) {
		this.codorgcb = codorgcb;
	}



	public String getCodrefcb() {
		return codrefcb;
	}



	public void setCodrefcb(String codrefcb) {
		this.codrefcb = codrefcb;
	}



	public String getCodsedcb() {
		return codsedcb;
	}



	public void setCodsedcb(String codsedcb) {
		this.codsedcb = codsedcb;
	}



	public String getCodtarcb() {
		return codtarcb;
	}



	public void setCodtarcb(String codtarcb) {
		this.codtarcb = codtarcb;
	}



	public String getEstadorg() {
		return estadorg;
	}



	public void setEstadorg(String estadorg) {
		this.estadorg = estadorg;
	}



	public String getNropercb() {
		return nropercb;
	}



	public void setNropercb(String nropercb) {
		this.nropercb = nropercb;
	}



	public String getNrovercb() {
		return nrovercb;
	}



	public void setNrovercb(String nrovercb) {
		this.nrovercb = nrovercb;
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



	public String getTG1TIPOT() {
		return TG1TIPOT;
	}



	public void setTG1TIPOT(String tG1TIPOT) {
		TG1TIPOT = tG1TIPOT;
	}



	public String getUnidades() {
		return unidades;
	}



	public void setUnidades(String unidades) {
		this.unidades = unidades;
	}



	public String getValoresRefIni() {
		return valoresRefIni;
	}



	public void setValoresRefIni(String valoresRefIni) {
		this.valoresRefIni = valoresRefIni;
	}



	public String getValoresRefFin() {
		return valoresRefFin;
	}



	public void setValoresRefFin(String valoresRefFin) {
		this.valoresRefFin = valoresRefFin;
	}
	
	
 

}