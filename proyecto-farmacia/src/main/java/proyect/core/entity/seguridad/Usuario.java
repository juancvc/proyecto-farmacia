package proyect.core.entity.seguridad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
 
@Entity
@NamedStoredProcedureQueries(
		{
				@NamedStoredProcedureQuery(
					name="usuario.validarAcceso", 
					procedureName="SP_USUARIO_VALIDAR_ACCESO",
					resultClasses= Usuario.class,
					parameters={
							//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuario", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="clave", type=String.class)
						}					
				),
				@NamedStoredProcedureQuery(
						name="usuario.findByObject", 
						procedureName="SP_USUARIO_BUSCAR_X_ID",
						resultClasses= Usuario.class,
						parameters={
								//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idUsuario",  type=Long.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class )
									
							}					
					),
				@NamedStoredProcedureQuery(
						name="usuario.findByIdPersona", 
						procedureName="[dbo].[SP_USUARIO_BUSCAR_X_ID_PERSONA]",
						resultClasses= Usuario.class,
						parameters={
								//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipPersona", type=Long.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_DOCUMENTO", type=String.class )
									
							}					
					),
				@NamedStoredProcedureQuery(
						name="usuario.findByLikeObjectVO", 
						procedureName="SP_USUARIO_BUSCAR_X_CRITERIOS",
						resultClasses= Usuario.class,
						parameters={
									//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuario", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class )
							}					
				),
				
				@NamedStoredProcedureQuery(
						name="usuario.insert", 
						procedureName="[dbo].[usp_Usuario_insertar]",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="idUsuario", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuario", 	type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="clave", 	type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipPersona", type=String.class),
									/*
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_USUARIO", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class)*/
							}					
				),
				@NamedStoredProcedureQuery(
						name="usuario.update", 
						procedureName="[dbo].[usp_Usuario_actualizar]",
						parameters={
									
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idUsuario", 		  type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioModificacion", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipModificacion", 	  type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuario", 			  type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="clave", 			  type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="descripcion", 		  type=String.class)

							}					
				),
				@NamedStoredProcedureQuery(
						name="usuario.delete", 
						procedureName="[dbo].[usp_Usuario_eliminar]",
						parameters={
									
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idUsuario", 			type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioModificacion",   type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipModificacion", 		type=String.class)
							}					
				),
				@NamedStoredProcedureQuery(
						name="usuario.validarAccesoAlmacen", 
						procedureName="[usp_login_validaAcceso]",
						resultClasses= Usuario.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="nombreUsuario", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="clave", 		type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idAlmacen", 	type=String.class)
							}					
					),
					@NamedStoredProcedureQuery(
							name="usuario.buscarPorCriterios", 
							procedureName="[dbo].[usp_Usuario_buscarxCriterios]",
							resultClasses= Usuario.class,
							parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuario", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="nombre",  type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idPerfil",type=String.class)
								}					
					 ),
					@NamedStoredProcedureQuery(
							name="usuario.actulizarClave", 
							procedureName="[Farmacia].[dbo].[SP_USUARIO_CAMBIAR_CLAVE] ",
							parameters={
									
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ORGANIZACION", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_INSTITUCION", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SEDE", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idUsuario", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="clave", type=String.class),
									
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_USUARIO", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class)
								}					
						)					 
		}
	)

public class Usuario  {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idUsuario")
	private String idUsuario;

	@Column(name="nombreUsuario")
	private String usuario;

	@Column(name="clave")
	private String clave;
	  
	@Column(name = "idPerfil")
	private String idPerfil; 
	
	@Column(name = "idPersona")
	private String idPersona; 

	@Column(name = "flgEstado")
	private Boolean fglgest; 

	@Column(name = "flgResetClave")
	private String flgResetClave;
 
	private String apellidoPaterno; 
	private String apellidoMaterno; 
	private String nombres;  
	private String idAlmacen; 
	private String nombrePerfil; 
	
	
	public Usuario() { 
	}


	public String getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getIdAlmacen() {
		return idAlmacen;
	}


	public void setIdAlmacen(String idAlmacen) {
		this.idAlmacen = idAlmacen;
	}


	public String getIdPerfil() {
		return idPerfil;
	}


	public void setIdPerfil(String idPerfil) {
		this.idPerfil = idPerfil;
	}


	public String getIdPersona() {
		return idPersona;
	}


	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}


	public Boolean getFglgest() {
		return fglgest;
	}


	public void setFglgest(Boolean fglgest) {
		this.fglgest = fglgest;
	}
 

	public String getFlgResetClave() {
		return flgResetClave;
	}


	public void setFlgResetClave(String flgResetClave) {
		this.flgResetClave = flgResetClave;
	}


	public String getApellidoPaterno() {
		return apellidoPaterno;
	}


	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}


	public String getApellidoMaterno() {
		return apellidoMaterno;
	}


	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getNombrePerfil() {
		return nombrePerfil;
	}


	public void setNombrePerfil(String nombrePerfil) {
		this.nombrePerfil = nombrePerfil;
	}

 
	
}