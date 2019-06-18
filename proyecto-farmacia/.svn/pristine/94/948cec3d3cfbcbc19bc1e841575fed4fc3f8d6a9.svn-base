//package pe.gob.procalidad.natigu.core.entity.entity.seguridad;
package hnch.referencia.core.entity.seguridad;

import java.io.Serializable;

import javax.persistence.*;


import java.util.Date;

@NamedStoredProcedureQueries({	
	@NamedStoredProcedureQuery(name = "leotbc_acceso.insertar", 
		procedureName = "segu.fun_leotbcacceso_insertar", 
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codacceso", type = Number.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_codperfil", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_codcompo", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_flgasi", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_codusureg", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_hostreg", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_flgread", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_flgwrite", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_flgdelete", type = String.class)
		}),
		
	@NamedStoredProcedureQuery(name = "leotbc_acceso.actualizar", 
	procedureName = "segu.fun_leotbcacceso_actualizar", 
	resultClasses = Acceso.class,
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codacceso", type = Number.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_flgasi", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_codusumod", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_hostmod", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_flgread", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_flgwrite", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_flgdelete", type = String.class)
	}),
	@NamedStoredProcedureQuery(name = "leotbc_acceso.eliminar", 
	procedureName = "segu.fun_leotbcacceso_eliminar", 
	resultClasses = Acceso.class,
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codacceso", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_codusumod", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_hostmod", type = String.class)
	}),
	/*@NamedStoredProcedureQuery(name = "leotbc_acceso.listar", 
	procedureName = "segu.fun_leotbcacceso_listar", 
	resultClasses = LeotbcAcceso.class,
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomperfil", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_codperfil", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_tm1sitprf", type = Integer.class)
	}),*/
	@NamedStoredProcedureQuery(name = "acceso.listar", 
		procedureName = "[SIGEHOV2SEGU].RECO.USP_ACCESO_LISTADO", 
		resultClasses = Acceso.class,
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODIPERF", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODCOMPA", type = String.class)
	}),
	@NamedStoredProcedureQuery(name = "acceso.asignar", 
		procedureName = "[SIGEHOV2SEGU].RECO.USP_ACCESO_ASIGNAR", 
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.INOUT, name = "CODACCES", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "SWASIGNA", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "SWLECTUR", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "SWESCRIT", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "SWELIMIN", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "SWEXPORT", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "CODIPERF", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "CODCOMPO", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "AUCDUSCR", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "AUPCIPCR", type = String.class)
	})
		
})

@Entity
@Table(name="acceso", schema="REC")
public class Acceso implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id  
	@Column(name="NRORDEN")
	private Integer nroOrden;
	
	@Column(name="CODACCES")
	private String codacceso;

	@Column(name="CODCOMPO")
	private String codcompo;

	@Column(name="CODIPERF")
	private String codperfil;

	@Column(name="SWASIGNA")
	private String swAsignado;

	@Column(name="SWLECTUR")
	private String swLectura;
	
	@Column(name="SWESCRIT")
	private String swEscrito;
	
	@Column(name="SWELIMIN")
	private String swEliminar;
	
	@Column(name="SWEXPORT")
	private String swExportar;
	
	@Column(name="ESTADORG")
	private String estado;
	
	@Column(name="SITUACRG")
	private String sitauciom;
	
	@Temporal(TemporalType.DATE)
	@Column(name="AUFECHCR")
	private Date auFechReg;

	@Column(name="AUPCIPCR")
	private String auPCIPcr;
	
	@Column(name="AUCDUSCR")
	private String aucdUScr;
	
	@Column(name="nomcompo")
	private String nomcompo;
	
	@Column(name="descompo")
	private String descompo;
	
	@Column(name="codcompa")
	private String codcompa;
	
	public Acceso() {
	
	}

	public String getCodacceso() {
		return codacceso;
	}

	public void setCodacceso(String codacceso) {
		this.codacceso = codacceso;
	}

	public String getCodcompo() {
		return codcompo;
	}

	public void setCodcompo(String codcompo) {
		this.codcompo = codcompo;
	}

	public String getCodperfil() {
		return codperfil;
	}

	public void setCodperfil(String codperfil) {
		this.codperfil = codperfil;
	}

	public String getSwAsignado() {
		return swAsignado;
	}

	public void setSwAsignado(String swAsignado) {
		this.swAsignado = swAsignado;
	}

	public String getSwLectura() {
		return swLectura;
	}

	public void setSwLectura(String swLectura) {
		this.swLectura = swLectura;
	}

	public String getSwEscrito() {
		return swEscrito;
	}

	public void setSwEscrito(String swEscrito) {
		this.swEscrito = swEscrito;
	}

	public String getSwEliminar() {
		return swEliminar;
	}

	public void setSwEliminar(String swEliminar) {
		this.swEliminar = swEliminar;
	}

	public String getSwExportar() {
		return swExportar;
	}

	public void setSwExportar(String swExportar) {
		this.swExportar = swExportar;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getSitauciom() {
		return sitauciom;
	}

	public void setSitauciom(String sitauciom) {
		this.sitauciom = sitauciom;
	}

	public Date getAuFechReg() {
		return auFechReg;
	}

	public void setAuFechReg(Date auFechReg) {
		this.auFechReg = auFechReg;
	}

	public String getAuPCIPcr() {
		return auPCIPcr;
	}

	public void setAuPCIPcr(String auPCIPcr) {
		this.auPCIPcr = auPCIPcr;
	}

	public String getAucdUScr() {
		return aucdUScr;
	}

	public void setAucdUScr(String aucdUScr) {
		this.aucdUScr = aucdUScr;
	}

	public String getNomcompo() {
		return nomcompo;
	}

	public void setNomcompo(String nomcompo) {
		this.nomcompo = nomcompo;
	}

	public String getDescompo() {
		return descompo;
	}

	public void setDescompo(String descompo) {
		this.descompo = descompo;
	}

	public String getCodcompa() {
		return codcompa;
	}

	public void setCodcompa(String codcompa) {
		this.codcompa = codcompa;
	}

	public Integer getNroOrden() {
		return nroOrden;
	}

	public void setNroOrden(Integer nroOrden) {
		this.nroOrden = nroOrden;
	}
 
}