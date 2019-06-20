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
						procedureName="SP_USUARIO_VALIDAR_ACCESO_ALMACEN",
						resultClasses= Usuario.class,
						parameters={
								//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="USUARIO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="CLAVE", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ALMACEN", type=String.class),
									//@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_USUARIO", type=Integer.class),
									/*	@StoredProcedureParameter(mode=ParameterMode.OUT,  name="RESPUESTA", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class )*/
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
	@Column(name="ID_USUARIO")
	private String idUsuario;

	@Column(name="USUARIO")
	private String usuario;

	@Column(name="CLAVE")
	private String clave;
	
	@Column(name="NOMBRE")
	private String nombre;

/**	@Column(name="ID_ORGANIZACION_USUARIO")
	private String idOrganizacionUsuario;
	
	@Column(name="ID_INSTITUCION_USUARIO")
	private String idInstitucionUsuario;
	
	@Column(name="ID_SEDE_USUARIO")
	private int idSedeUsuario;
	
	@Column(name="NRO_VERSION_USUARIO")
	private int nroVersionUsuario;
	
	@Column(name="NRO_PERIODO_USUARIO")
	private int nroPeriodoUsuario;
	
	*/
	 

	@Column(name = "ID_PERFIL")
	private String codperfil;

	@Column(name = "EMAIL")
	private String correo;
	
	@Column(name = "NUMECELU")
	private String nroCelular;
	
	@Column(name="AUD_ID_USUARIO")
	private int audIdUsuario;
	 
	
	@Column(name = "CODPERSO")
	private String nCodperso;

	@Column(name = "AUCDUSCR")
	private String nCodusureg;

	@Column(name = "SITUSUAR")
	private String nTm1situsu;

	@Column(name = "ESTADO")
	private String vFlgest;

	@Column(name = "NOMUSUAR")
	private String vNomusuari;

	@Column(name = "PSWUSUAR")
	private String vPassusuar;

	@Column(name = "SWCLAVEP")
	private String vFlgrestpas;

	@Column(name = "NOMBPERF")
	private String nomPerfil;

	@Column(name = "APEPATER")
	private String apePater;

	@Column(name = "APEMATER")
	private String apeMater;

	@Column(name = "PRINOMBR")
	private String priNombr;

	@Column(name = "SEGNOMBR")
	private String segNombr;

	@Column(name = "NRODOCUM")
	private String nroDocum;
	
	@Column(name = "TG1TPDOC")
	private String tg1TpDoc;
	
	
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


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	 

	public String getCodperfil() {
		return codperfil;
	}


	public void setCodperfil(String codperfil) {
		this.codperfil = codperfil;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getNroCelular() {
		return nroCelular;
	}


	public void setNroCelular(String nroCelular) {
		this.nroCelular = nroCelular;
	}


	public int getAudIdUsuario() {
		return audIdUsuario;
	}


	public void setAudIdUsuario(int audIdUsuario) {
		this.audIdUsuario = audIdUsuario;
	}


	public String getnCodperso() {
		return nCodperso;
	}


	public void setnCodperso(String nCodperso) {
		this.nCodperso = nCodperso;
	}


	public String getnCodusureg() {
		return nCodusureg;
	}


	public void setnCodusureg(String nCodusureg) {
		this.nCodusureg = nCodusureg;
	}


	public String getnTm1situsu() {
		return nTm1situsu;
	}


	public void setnTm1situsu(String nTm1situsu) {
		this.nTm1situsu = nTm1situsu;
	}


	public String getvFlgest() {
		return vFlgest;
	}


	public void setvFlgest(String vFlgest) {
		this.vFlgest = vFlgest;
	}


	public String getvNomusuari() {
		return vNomusuari;
	}


	public void setvNomusuari(String vNomusuari) {
		this.vNomusuari = vNomusuari;
	}


	public String getvPassusuar() {
		return vPassusuar;
	}


	public void setvPassusuar(String vPassusuar) {
		this.vPassusuar = vPassusuar;
	}


	public String getvFlgrestpas() {
		return vFlgrestpas;
	}


	public void setvFlgrestpas(String vFlgrestpas) {
		this.vFlgrestpas = vFlgrestpas;
	}


	public String getNomPerfil() {
		return nomPerfil;
	}


	public void setNomPerfil(String nomPerfil) {
		this.nomPerfil = nomPerfil;
	}


	public String getApePater() {
		return apePater;
	}


	public void setApePater(String apePater) {
		this.apePater = apePater;
	}


	public String getApeMater() {
		return apeMater;
	}


	public void setApeMater(String apeMater) {
		this.apeMater = apeMater;
	}


	public String getPriNombr() {
		return priNombr;
	}


	public void setPriNombr(String priNombr) {
		this.priNombr = priNombr;
	}


	public String getSegNombr() {
		return segNombr;
	}


	public void setSegNombr(String segNombr) {
		this.segNombr = segNombr;
	}


	public String getNroDocum() {
		return nroDocum;
	}


	public void setNroDocum(String nroDocum) {
		this.nroDocum = nroDocum;
	}


	public String getTg1TpDoc() {
		return tg1TpDoc;
	}


	public void setTg1TpDoc(String tg1TpDoc) {
		this.tg1TpDoc = tg1TpDoc;
	}
	
	

	 
	
}