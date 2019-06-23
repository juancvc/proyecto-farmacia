package proyect.core.entity.seguridad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="USUARIO", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="CLAVE", type=String.class)
						}					
				),
				@NamedStoredProcedureQuery(
						name="usuario.findByObject", 
						procedureName="SP_USUARIO_BUSCAR_X_ID",
						resultClasses= Usuario.class,
						parameters={
								//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_USUARIO", type=Long.class),
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
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_PERSONA", type=Long.class),
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
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="USUARIO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class )
							}					
				),
				
				@NamedStoredProcedureQuery(
						name="usuario.insert", 
						procedureName="SP_USUARIO_INSERTAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="ID_USUARIO", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="USUARIO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="CLAVE", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_PERSONA", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_PERFIL", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ORGANIZACION", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_INSTITUCION", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SEDE", type=int.class),
									
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_USUARIO", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_MAC", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_OBSERVACION", type=String.class)
							}					
				),
				@NamedStoredProcedureQuery(
						name="usuario.update", 
						procedureName="[Farmacia].[dbo].[SP_USUARIO_ACTUALIZAR]",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ORGANIZACION", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_INSTITUCION", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SEDE", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_USUARIO", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_PERFIL", type=int.class),
									
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_USUARIO", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class)

							}					
				),
				@NamedStoredProcedureQuery(
						name="usuario.delete", 
						procedureName="[Farmacia].[dbo].[SP_USUARIO_ELIMINAR]",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ORGANIZACION", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_INSTITUCION", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SEDE", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_USUARIO", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_USUARIO", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class)
							}					
				),
				@NamedStoredProcedureQuery(
						name="usuario.validarAccesoAlmacen", 
						procedureName="[usp_login_validaAcceso]",
						resultClasses= Usuario.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="nombreUsuario", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="clave", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idAlmacen", type=String.class)
							}					
					),
					@NamedStoredProcedureQuery(
							name="usuario.buscarPorCriterios", 
							procedureName="[Farmacia].[dbo].[SP_USUARIO_ALMACEN_BUSCAR_X_CRITERIOS] ",
							resultClasses= Usuario.class,
							parameters={
									
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ORGANIZACION", type=int.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_INSTITUCION", type=int.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SEDE", type=int.class),				
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ALMACEN", type=int.class)
								}					
					 ),
					@NamedStoredProcedureQuery(
							name="usuario.actulizarClave", 
							procedureName="[Farmacia].[dbo].[SP_USUARIO_CAMBIAR_CLAVE] ",
							parameters={
									
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ORGANIZACION", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_INSTITUCION", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SEDE", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_USUARIO", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="CLAVE", type=String.class),
									
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
	private String fglgest; 

	@Column(name = "flgResetClave")
	private String vFlgrestpas;
 
	private String apellidoPaterno; 
	private String apellidoMaterno; 
	private String nombres;  
	private String idAlmacen; 
	
	
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


	public String getFglgest() {
		return fglgest;
	}


	public void setFglgest(String fglgest) {
		this.fglgest = fglgest;
	}


	public String getvFlgrestpas() {
		return vFlgrestpas;
	}


	public void setvFlgrestpas(String vFlgrestpas) {
		this.vFlgrestpas = vFlgrestpas;
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

 
	
}