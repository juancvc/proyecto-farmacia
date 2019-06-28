//package pe.gob.procalidad.natigu.core.entity.entity.seguridad;
package proyect.core.entity.seguridad;

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
	

	@NamedStoredProcedureQuery(name = "acceso.listar", 
		procedureName = "[dbo].[usp_Accesos_lista]", 
		resultClasses = Acceso.class,
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "idPerfil", 			type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "idComponentePadre",  type = String.class)
	}),
	@NamedStoredProcedureQuery(name = "acceso.asignar", 
		procedureName = "[dbo].[usp_Accesos_asignar]", 
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "idAcceso", 		  type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "flagAsignar", 	  type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "flagLectura", 	  type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "flagEscritura",   type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "flagEliminar", 	  type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "flagExportar", 	  type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "idPerfil", 		  type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "idComponente", 	  type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "usuarioRegistro", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,  name = "ipRegistro", 	  type = String.class)
	})
		
})

@Entity
@Table(name="acceso", schema="dbo")
public class Acceso implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id  
	@Column(name="NRORDEN")
	private Integer nroOrden;
	
	@Column(name="idAcceso")
	private String idAcceso;

	@Column(name="idComponente")
	private String codcompo;

	@Column(name="idPerfil")
	private String codperfil;

	@Column(name="flagAsignar")
	private String swAsignado;

	@Column(name="flagLectura")
	private String swLectura;
	
	@Column(name="flagEscritura")
	private String swEscrito;
	
	@Column(name="flagEliminar")
	private String swEliminar;
	
	@Column(name="flagExportar")
	private String swExportar;
	
	@Column(name="ESTADORG")
	private String estado;
	
	@Column(name="SITUACRG")
	private String sitauciom;
	
	@Temporal(TemporalType.DATE)
	@Column(name="AUFECHCR")
	private Date auFechReg;

	@Column(name="ipRegistro")
	private String auPCIPcr;
	
	@Column(name="usuarioRegistro")
	private String aucdUScr;
	
	@Column(name="nomcompo")
	private String nomcompo;
	
	@Column(name="descompo")
	private String descompo;
	
	@Column(name="codcompa")
	private String codcompa;
	
	public Acceso() {
	
	}

	public String getIdAcceso() {
		return idAcceso;
	}

	public void setIdAcceso(String idAcceso) {
		this.idAcceso = idAcceso;
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