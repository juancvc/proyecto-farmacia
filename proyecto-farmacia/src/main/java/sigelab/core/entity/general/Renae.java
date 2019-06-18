package sigelab.core.entity.general;

import java.io.Serializable;
import javax.persistence.*;
 

import java.sql.Timestamp;

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "Renae.listarPorFiltros", 
				procedureName = "[RECO].[RENAES_FIND_BY_LIKEOBJECT]", 
				resultClasses = Renae.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "UBIGEO", type = String.class) ,
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NOMRENEA", type = String.class) ,
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TG14CATE", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODIGO_DISA", type = String.class)  
				
		}) 
		
})

@Entity
@Table(name = "RENAES")
@NamedQuery(name = "Renae.findAll", query = "SELECT r FROM Renae r")
public class Renae implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "CATEGORIA")
	private String categoria;

	@Column(name = "CLARENEA")
	private String clarenea;

	@Column(name = "CODIGO_DISA")
	private String codigoDisa;

	@Column(name = "CODIGO_MICRORRED")
	private String codigoMicrorred;

	@Column(name = "CODIGO_RED")
	private String codigoRed;

	@Column(name = "CODIGO_UE")
	private double codigoUe;

	@Column(name = "CODINSTI")
	private String codinsti;

	@Column(name = "CODORGAN")
	private String codorgan;

	@Column(name = "CODRENEA")
	private String codrenea;

	@Id
	@Column(name = "CODRGREN")
	private String codrgren;

	@Column(name = "CODSEDEI")
	private String codsedei;

	@Column(name = "CONDICION")
	private String condicion;

	@Column(name = "COTA")
	private double cota;

	@Column(name = "DEPARTAMENTO")
	private String departamento;

	@Column(name = "DIRECCION")
	private String direccion;

	@Column(name = "DISA")
	private String disa;

	@Column(name = "DISTRITO")
	private String distrito;

	@Column(name = "ESTADO")
	private String estado;

	@Column(name = "ESTBCORR")
	private String estbcorr;

	@Column(name = "ESTE")
	private double este;

	@Column(name = "HORARIO")
	private String horario;

	@Column(name = "INICIO_ACTIVI")
	private Timestamp inicioActivi;

	@Column(name = "INSPECCION")
	private String inspeccion;

	@Column(name = "INSTITUCION")
	private String institucion;

	@Column(name = "MICRORRED")
	private String microrred;

	@Column(name = "NOMRENEA")
	private String nomrenea;

	@Column(name = "NORTE")
	private double norte;

	@Column(name = "NRO_DOC_CATEGO")
	private String nroDocCatego;

	@Column(name = "NRPERREN")
	private String nrperren;

	@Column(name = "NRVERREN")
	private String nrverren;

	@Column(name = "PROVINCIA")
	private String provincia;

	@Column(name = "RED")
	private String red;

	@Column(name = "RESPONSABLE")
	private String responsable;

	@Column(name = "SITUACION")
	private String situacion;

	@Column(name = "TELEFONO")
	private String telefono;

	@Column(name = "TIP_DOC_CATEGO")
	private String tipDocCatego;

	@Column(name = "TIPORENEA")
	private String tiporenea;

	@Column(name = "UBIGEO")
	private String ubigeo;

	@Column(name = "UNIDAD_EJECUTORA")
	private String unidadEjecutora;
	
	@Column(name = "TG14CATE")
	private String tg14Cate;
	

	public Renae() {
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getClarenea() {
		return this.clarenea;
	}

	public void setClarenea(String clarenea) {
		this.clarenea = clarenea;
	}

	public String getCodigoDisa() {
		return this.codigoDisa;
	}

	public void setCodigoDisa(String codigoDisa) {
		this.codigoDisa = codigoDisa;
	}

	public String getCodigoMicrorred() {
		return this.codigoMicrorred;
	}

	public void setCodigoMicrorred(String codigoMicrorred) {
		this.codigoMicrorred = codigoMicrorred;
	}

	public String getCodigoRed() {
		return this.codigoRed;
	}

	public void setCodigoRed(String codigoRed) {
		this.codigoRed = codigoRed;
	}

	public double getCodigoUe() {
		return this.codigoUe;
	}

	public void setCodigoUe(double codigoUe) {
		this.codigoUe = codigoUe;
	}

	public String getCodinsti() {
		return this.codinsti;
	}

	public void setCodinsti(String codinsti) {
		this.codinsti = codinsti;
	}

	public String getCodorgan() {
		return this.codorgan;
	}

	public void setCodorgan(String codorgan) {
		this.codorgan = codorgan;
	}

	public String getCodrenea() {
		return this.codrenea;
	}

	public void setCodrenea(String codrenea) {
		this.codrenea = codrenea;
	}

	public String getCodrgren() {
		return this.codrgren;
	}

	public void setCodrgren(String codrgren) {
		this.codrgren = codrgren;
	}

	public String getCodsedei() {
		return this.codsedei;
	}

	public void setCodsedei(String codsedei) {
		this.codsedei = codsedei;
	}

	public String getCondicion() {
		return this.condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	public double getCota() {
		return this.cota;
	}

	public void setCota(double cota) {
		this.cota = cota;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDisa() {
		return this.disa;
	}

	public void setDisa(String disa) {
		this.disa = disa;
	}

	public String getDistrito() {
		return this.distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstbcorr() {
		return this.estbcorr;
	}

	public void setEstbcorr(String estbcorr) {
		this.estbcorr = estbcorr;
	}

	public double getEste() {
		return this.este;
	}

	public void setEste(double este) {
		this.este = este;
	}

	public String getHorario() {
		return this.horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Timestamp getInicioActivi() {
		return this.inicioActivi;
	}

	public void setInicioActivi(Timestamp inicioActivi) {
		this.inicioActivi = inicioActivi;
	}

	public String getInspeccion() {
		return this.inspeccion;
	}

	public void setInspeccion(String inspeccion) {
		this.inspeccion = inspeccion;
	}

	public String getInstitucion() {
		return this.institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public String getMicrorred() {
		return this.microrred;
	}

	public void setMicrorred(String microrred) {
		this.microrred = microrred;
	}

	public String getNomrenea() {
		return this.nomrenea;
	}

	public void setNomrenea(String nomrenea) {
		this.nomrenea = nomrenea;
	}

	public double getNorte() {
		return this.norte;
	}

	public void setNorte(double norte) {
		this.norte = norte;
	}

	public String getNroDocCatego() {
		return this.nroDocCatego;
	}

	public void setNroDocCatego(String nroDocCatego) {
		this.nroDocCatego = nroDocCatego;
	}

	public String getNrperren() {
		return this.nrperren;
	}

	public void setNrperren(String nrperren) {
		this.nrperren = nrperren;
	}

	public String getNrverren() {
		return this.nrverren;
	}

	public void setNrverren(String nrverren) {
		this.nrverren = nrverren;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getRed() {
		return this.red;
	}

	public void setRed(String red) {
		this.red = red;
	}

	public String getResponsable() {
		return this.responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getSituacion() {
		return this.situacion;
	}

	public void setSituacion(String situacion) {
		this.situacion = situacion;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTipDocCatego() {
		return this.tipDocCatego;
	}

	public void setTipDocCatego(String tipDocCatego) {
		this.tipDocCatego = tipDocCatego;
	}

	public String getTiporenea() {
		return this.tiporenea;
	}

	public void setTiporenea(String tiporenea) {
		this.tiporenea = tiporenea;
	}

	public String getUbigeo() {
		return this.ubigeo;
	}

	public void setUbigeo(String ubigeo) {
		this.ubigeo = ubigeo;
	}

	public String getUnidadEjecutora() {
		return this.unidadEjecutora;
	}

	public void setUnidadEjecutora(String unidadEjecutora) {
		this.unidadEjecutora = unidadEjecutora;
	}

	public String getTg14Cate() {
		return tg14Cate;
	}

	public void setTg14Cate(String tg14Cate) {
		this.tg14Cate = tg14Cate;
	}

}