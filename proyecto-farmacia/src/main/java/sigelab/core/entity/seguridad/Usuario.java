package pe.com.galaxy.systems.apolo.core.entidad.entidad.seguridad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import pe.com.galaxy.systems.apolo.core.entidad.GenericEntity;
import pe.com.galaxy.systems.apolo.core.entidad.entidad.general.Persona;
import pe.com.galaxy.systems.apolo.core.entidad.entidad.general.Situacion;
import pe.com.galaxy.systems.apolo.core.entidad.vo.seguridad.UsuarioAlmacenVO;
import pe.com.galaxy.systems.apolo.core.entidad.vo.seguridad.UsuarioVO; 
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
						resultClasses= UsuarioVO.class,
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
						resultClasses= UsuarioVO.class,
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
						resultClasses= UsuarioVO.class,
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
						procedureName="SP_USUARIO_VALIDAR_ACCESO_ALMACEN",
						resultClasses= UsuarioAlmacenVO.class,
						parameters={
								//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="USUARIO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="CLAVE", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ALMACEN", type=Long.class),
									//@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_USUARIO", type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.OUT,  name="RESPUESTA", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class )
							}					
					),
					@NamedStoredProcedureQuery(
							name="usuario.buscarPorCriterios", 
							procedureName="[Farmacia].[dbo].[SP_USUARIO_ALMACEN_BUSCAR_X_CRITERIOS] ",
							resultClasses= UsuarioAlmacenVO.class,
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

public class Usuario 
	extends GenericEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_USUARIO")
	private long idUsuario;

	@Column(name="USUARIO")
	private String usuario;

	@Column(name="CLAVE")
	private String clave;
	
	@Column(name="NOMBRE")
	private String nombre;

	@Column(name="ID_ORGANIZACION_USUARIO")
	private int idOrganizacionUsuario;
	
	@Column(name="ID_INSTITUCION_USUARIO")
	private int idInstitucionUsuario;
	
	@Column(name="ID_SEDE_USUARIO")
	private int idSedeUsuario;
	
	@Column(name="NRO_VERSION_USUARIO")
	private int nroVersionUsuario;
	
	@Column(name="NRO_PERIODO_USUARIO")
	private int nroPeriodoUsuario;
	
	//@ManyToOne 
	private Persona persona;

    private int  idPerfil;
	@Column(name="AUD_ID_USUARIO")
	private int audIdUsuario;
	
	private int idAlmacen;
	
	public Usuario() {
		this.setPersona(new Persona());
		this.setSituacion(new Situacion());
		//this.setAud_usuario(new Usuario());
	}
	
	

	public long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}


	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public int getIdOrganizacionUsuario() {
		return idOrganizacionUsuario;
	}



	public void setIdOrganizacionUsuario(int idOrganizacionUsuario) {
		this.idOrganizacionUsuario = idOrganizacionUsuario;
	}



	public int getIdInstitucionUsuario() {
		return idInstitucionUsuario;
	}



	public void setIdInstitucionUsuario(int idInstitucionUsuario) {
		this.idInstitucionUsuario = idInstitucionUsuario;
	}



	public int getIdSedeUsuario() {
		return idSedeUsuario;
	}



	public void setIdSedeUsuario(int idSedeUsuario) {
		this.idSedeUsuario = idSedeUsuario;
	}



	public int getNroVersionUsuario() {
		return nroVersionUsuario;
	}



	public void setNroVersionUsuario(int nroVersionUsuario) {
		this.nroVersionUsuario = nroVersionUsuario;
	}



	public int getNroPeriodoUsuario() {
		return nroPeriodoUsuario;
	}


	

	public int getAudIdUsuario() {
		return audIdUsuario;
	}



	public void setAudIdUsuario(int audIdUsuario) {
		this.audIdUsuario = audIdUsuario;
	}



	public void setNroPeriodoUsuario(int nroPeriodoUsuario) {
		this.nroPeriodoUsuario = nroPeriodoUsuario;
	}


	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", usuario=" + usuario
				+ ", clave=" + clave + ", nombre=" + nombre + ", estado="
				+ estado + "]";
	}



	public int getIdPerfil() {
		return idPerfil;
	}



	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}



	public int getIdAlmacen() {
		return idAlmacen;
	}



	public void setIdAlmacen(int idAlmacen) {
		this.idAlmacen = idAlmacen;
	}
	
}