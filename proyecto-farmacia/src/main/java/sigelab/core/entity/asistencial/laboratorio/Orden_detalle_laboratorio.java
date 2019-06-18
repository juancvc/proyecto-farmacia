package sigelab.core.entity.asistencial.laboratorio;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "postulante.insertar", procedureName = "[SIGEHOV2BANC].[GENE].[ADMISION_POSTULANTE_INSERT]", resultClasses = Orden_detalle_laboratorio.class, parameters = {
				
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
@NamedStoredProcedureQuery(name = "ordenDetalleResultado.modificar", procedureName = "[LABO].[USP_ORDEN_DET_RESULTADOS_UPDATE]", resultClasses = Orden_detalle_laboratorio.class, parameters = {
			
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORDDE", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPERIO", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class),
	
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "RESULTADO", type = String.class),
			
	
		    @StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSMO", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPMO", type = String.class),
 }),
@NamedStoredProcedureQuery(name = "postulante.eliminar", procedureName = "[SIGEHOV2BANC].[BANC].[POSTULANTE_DELETE]", resultClasses = Orden_detalle_laboratorio.class, parameters = {
			
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class), 
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROVERSI", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPERIO", type = String.class),
			
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPOST", type = String.class),
			
		    @StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSMO", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPMO", type = String.class),
 }),
@NamedStoredProcedureQuery(name = "ordenDetalle.buscarPorFiltros", procedureName = "LABO.USP_ORDEN_DETALLE_LISTAR_X_FILTROS", resultClasses = Orden_detalle_laboratorio.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class), 
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORDEN", type = String.class) ,
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROVEORD", type = String.class) ,
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPEORD", type = String.class) 
 }),
@NamedStoredProcedureQuery(name = "ordenDetalle.buscarPorFiltrosReporte", procedureName = "LABO.USP_ORDEN_DETALLE_LISTAR_X_FILTROS_REPORTE", resultClasses = Orden_detalle_laboratorio.class, parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class), 
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORDEN", type = String.class) ,
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROVEORD", type = String.class) ,
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPEORD", type = String.class) 
}),
@NamedStoredProcedureQuery(name = "postulante.buscarPorObjeto", procedureName = "[SIGEHOV2BANC].[BANC].[POSTULANTE_CAMPANIA_LISTA_X_OBJETO]", resultClasses = Orden_detalle_laboratorio.class, parameters = {
		
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class) ,
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class) ,
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class) ,
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPERIO", type = String.class) ,
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPOST", type = String.class) 
		
}),
@NamedStoredProcedureQuery(name = "postulante.buscarUltimaDonacion", procedureName = "[SIGEHOV2BANC].[GENE].[ADMISION_FECHA_ULTIMA_DONACION]", resultClasses = Orden_detalle_laboratorio.class, parameters = {
		
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODPERSO", type = String.class) 
 }),

@NamedStoredProcedureQuery(name = "postulante.estadoFisicoBuscarPorFiltros", procedureName = "[SIGEHOV2BANC].[BANC].[POSTULANTE_ESTADOFISICO_CAMPANIA_LISTA_X_FILTRO]", resultClasses = Orden_detalle_laboratorio.class, parameters = {
		
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "FECHADES", type = String.class) ,
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "FECHAHAS", type = String.class) ,
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "ESTADOEV", type = String.class)  
}),

@NamedStoredProcedureQuery(name = "postulante.estadoFisicoBuscarPorObjeto", procedureName = "[SIGEHOV2BANC]. [BANC].[POSTULANTE_ESTADOFISICO_CAMPANIA_LISTA_X_OBJETO]", resultClasses = Orden_detalle_laboratorio.class, parameters = {
	
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class) ,
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class) ,
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class) ,
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPERIO", type = String.class) ,
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPOST", type = String.class) 
	
}),


@NamedStoredProcedureQuery(name = "postulante.preDonantesBuscarPorFiltros", procedureName = "[SIGEHOV2BANC].BANC.[PREDONANTES_ENTREVISTA_LISTA_X_FILTRO]", resultClasses = Orden_detalle_laboratorio.class, parameters = {
		
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "FECHA", type = String.class)  
}),
	
@NamedStoredProcedureQuery(name = "postulante.litarEstadoFisicaPorPerso", procedureName = "[SIGEHOV2BANC].[GENE].[ADMISION_ULTIMA_EVALUACION_FISICA_V_WEB]", resultClasses = Orden_detalle_laboratorio.class, parameters = {
		
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODPERSO", type = String.class) })

 

})


@Entity
public class Orden_detalle_laboratorio implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	 private Orden_detalle_laboratorioPK id; 
	
	@Column(name = "SITUACRG")
	private String situacRg;
	
	@Column(name = "AUFECHCR")
	private Timestamp aufechcr;

	@Column(name = "CODORDEN")
	private String codOrden;
	
	@Column(name="AUCDUSCR")
	private String aucduscr;
	
	@Column(name = "AUFECHMO")
	private Timestamp aufechmo;

	@Column(name = "CANTIDAD")
	private int cantidad;
	
	@Column(name = "IMPORTE")
	private Float importe; 
	
	@Column(name = "PRECIO")
	private Float precio;

	@Column(name="CODTARIF")
	private String codTarif;
	
	@Column(name="RESULTADO")
	private String resultado;
	
	private String NOMPRODU;
	private String NOMTPEXA;
	private String OBSERVAC;
	private String UNIDADES;
	private String VALORINI;
	private String VALORFIN;

	
	public String getNOMTPEXA() {
		return NOMTPEXA;
	}

	public void setNOMTPEXA(String nOMTPEXA) {
		NOMTPEXA = nOMTPEXA;
	}

	public Orden_detalle_laboratorioPK getId() {
		return id;
	}

	public void setId(Orden_detalle_laboratorioPK id) {
		this.id = id;
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

	public String getCodOrden() {
		return codOrden;
	}

	public void setCodOrden(String codOrden) {
		this.codOrden = codOrden;
	}

	public String getAucduscr() {
		return aucduscr;
	}

	public void setAucduscr(String aucduscr) {
		this.aucduscr = aucduscr;
	}

	public Timestamp getAufechmo() {
		return aufechmo;
	}

	public void setAufechmo(Timestamp aufechmo) {
		this.aufechmo = aufechmo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Float getImporte() {
		return importe;
	}

	public void setImporte(Float importe) {
		this.importe = importe;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public String getCodTarif() {
		return codTarif;
	}

	public void setCodTarif(String codTarif) {
		this.codTarif = codTarif;
	}

	public String getNOMPRODU() {
		return NOMPRODU;
	}

	public void setNOMPRODU(String nOMPRODU) {
		NOMPRODU = nOMPRODU;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getOBSERVAC() {
		return OBSERVAC;
	}

	public void setOBSERVAC(String oBSERVAC) {
		OBSERVAC = oBSERVAC;
	}

	public String getUNIDADES() {
		return UNIDADES;
	}

	public void setUNIDADES(String uNIDADES) {
		UNIDADES = uNIDADES;
	}

	public String getVALORINI() {
		return VALORINI;
	}

	public void setVALORINI(String vALORINI) {
		VALORINI = vALORINI;
	}

	public String getVALORFIN() {
		return VALORFIN;
	}

	public void setVALORFIN(String vALORFIN) {
		VALORFIN = vALORFIN;
	}
	
	
	
	
}