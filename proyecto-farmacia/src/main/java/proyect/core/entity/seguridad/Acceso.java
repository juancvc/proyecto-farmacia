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
	@Column(name="idAcceso")
	private String idAcceso;

	@Column(name="idComponente")
	private String idComponente;

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
	
	@Column(name="ipRegistro")
	private String ipRegistro;
	
	@Column(name="usuarioRegistro")
	private String usuarioRegistro;
	
	@Column(name="nombreComponente")
	private String nombreComponente;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="idComponentePadre")
	private String idComponentePadre;
	
	@Column(name="nroOrden")
	private Integer nroOrden;
	
	public Acceso() {
	
	}

	public String getIdAcceso() {
		return idAcceso;
	}

	public void setIdAcceso(String idAcceso) {
		this.idAcceso = idAcceso;
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

	public String getIpRegistro() {
		return ipRegistro;
	}

	public void setIpRegistro(String ipRegistro) {
		this.ipRegistro = ipRegistro;
	}

	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public String getNombreComponente() {
		return nombreComponente;
	}

	public void setNombreComponente(String nombreComponente) {
		this.nombreComponente = nombreComponente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIdComponentePadre() {
		return idComponentePadre;
	}

	public void setIdComponentePadre(String idComponentePadre) {
		this.idComponentePadre = idComponentePadre;
	}

	public Integer getNroOrden() {
		return nroOrden;
	}

	public void setNroOrden(Integer nroOrden) {
		this.nroOrden = nroOrden;
	}

	public String getIdComponente() {
		return idComponente;
	}

	public void setIdComponente(String idComponente) {
		this.idComponente = idComponente;
	}
 
	
}