package proyect.core.entity.general;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
 
@SuppressWarnings("serial")
@NamedStoredProcedureQueries(
		{
				
				@NamedStoredProcedureQuery(
						name="empresa.buscarPorObjeto", 
						procedureName="[usp_Almacen_buscarxID]",
						resultClasses= Empresa.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="idEmpresa", type=String.class)
							}					
					),
				@NamedStoredProcedureQuery(
						name="empresa.buscarPorFiltros", 
						procedureName="[usp_Almacen_buscarxCriterios]",
						resultClasses= Empresa.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="nombreAlmacen", type=String.class) 
							}	
				),
				
				@NamedStoredProcedureQuery(
						name="empresa.insert", 
						procedureName="[usp_Empresa_insertar]",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="idEmpresa", 	  type=String.class), 
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idUsuario", 	  type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="nombreEmpresa",   type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ruc", 			  type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="apellidos", 	  type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="nombres", 		  type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="tipoDocumento",   type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="nroDocumento",    type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idUbigeo", 		  type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="direccion", 	  type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="contrasenia", 	  type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="fotoLogoEmpresa", type=byte[].class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioRegistro", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipRegistro", 	  type=String.class )
							}					
				),
				
				@NamedStoredProcedureQuery(
						name="empresa.update", 
						procedureName="[dbo].[usp_Empresa_actualizar]",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.OUT, name="idEmpresa", 	  	  type=String.class), 
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="idUsuario", 	  	  type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="nombreEmpresa",   	  type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ruc", 			  	  type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="apellidos", 	  	  type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="nombres", 		  	  type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="tipoDocumento",   	  type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="nroDocumento",    	  type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="idUbigeo", 		  	  type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="direccion", 	  	  type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="contrasenia", 	  	  type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="fotoLogoEmpresa", 	  type=byte[].class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioModificacion", type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipModificacion", 	  type=String.class)
						}					
										
				),
				@NamedStoredProcedureQuery(
						name="empresa.delete", 
						procedureName="[dbo].[usp_Empresa_eliminar]",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="idAlmacen", 			 type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="usuarioModificacion", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ipModificacion", 	 type=String.class)
							}					
				),
				@NamedStoredProcedureQuery(
						name="empresa.buscarTodos", 
						procedureName="[dbo].[usp_Empresa_buscarTodos]",
						resultClasses= Empresa.class,
						parameters={
							
							}				
					)
		
		}
	)
@Entity
@Table(name="Empresa")
public class Empresa  {
	
	@Id
	@Column(name="idEmpresa")
	private String idEmpresa;

	@Column(name="idUsuario")
	private String idUsuario;
	
	@Column(name="nombreEmpresa")
	private String nombreEmpresa;
	
	@Column(name="ruc")
	private String ruc;
	
	@Column(name="apellidos")
	private String apellidos;
	
	@Column(name="nombres")
	private String nombres;
	
	@Column(name="tipoDocumento")
	private String tipoDocumento;
	
	@Column(name="nroDocumento")
	private String nroDocumento;
	
	@Column(name="idUbigeo")
	private String idUbigeo;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="contrasenia")
	private String contrasenia;
	
	@Column(name="fotoLogoEmpresa")
	private byte[] fotoLogoEmpresa;
	
	
	@Column(name="usuarioRegistro")
	private String usuarioRegistro;
	
	@Column(name="ipRegistro")
	private String ipRegistro;
	
	@Column(name="usuarioModificacion")
	private String usuarioModificacion;
	
	@Column(name="ipModificacion")
	private String ipModificacion;
	
	
	public Empresa() { 
	}


	public String getIdEmpresa() {
		return idEmpresa;
	}


	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}


	public String getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getNombreEmpresa() {
		return nombreEmpresa;
	}


	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}


	public String getRuc() {
		return ruc;
	}


	public void setRuc(String ruc) {
		this.ruc = ruc;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getTipoDocumento() {
		return tipoDocumento;
	}


	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}


	public String getNroDocumento() {
		return nroDocumento;
	}


	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}


	public String getIdUbigeo() {
		return idUbigeo;
	}


	public void setIdUbigeo(String idUbigeo) {
		this.idUbigeo = idUbigeo;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getContrasenia() {
		return contrasenia;
	}


	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}


	public byte[] getFotoLogoEmpresa() {
		return fotoLogoEmpresa;
	}


	public void setFotoLogoEmpresa(byte[] fotoLogoEmpresa) {
		this.fotoLogoEmpresa = fotoLogoEmpresa;
	}


	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}


	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}


	public String getIpRegistro() {
		return ipRegistro;
	}


	public void setIpRegistro(String ipRegistro) {
		this.ipRegistro = ipRegistro;
	}


	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}


	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}


	public String getIpModificacion() {
		return ipModificacion;
	}


	public void setIpModificacion(String ipModificacion) {
		this.ipModificacion = ipModificacion;
	}
	
	
	

	
	
}