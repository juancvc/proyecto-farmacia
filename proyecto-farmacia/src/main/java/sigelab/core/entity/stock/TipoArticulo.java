package pe.com.galaxy.systems.apolo.core.entidad.entidad.stock;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import pe.com.galaxy.systems.apolo.core.entidad.GenericEntity;
import pe.com.galaxy.systems.apolo.core.entidad.entidad.general.Situacion;
import pe.com.galaxy.systems.apolo.core.entidad.entidad.seguridad.Usuario;
@NamedStoredProcedureQueries(
		{
				
				@NamedStoredProcedureQuery(
						name="tipoarticulo.buscarxid", 
						procedureName="SP_TIPO_ARTICULO_BUSCAR_X_ID",
						resultClasses= TipoArticulo.class,
						parameters={
									//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_TIPO_ARTICULO", type=Long.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class )
							}					
					),

					@NamedStoredProcedureQuery(
							name="tipoarticulo.buscarTodos", 
							procedureName="SP_TIPO_ARTICULO_BUSCAR_TODOS",
							resultClasses= TipoArticulo.class
						/*	parameters={
										@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class )
								}	*/				
						),
					
					
					
				@NamedStoredProcedureQuery(
						name="tipoarticulo.buscarxcriterios", 
						procedureName="SP_TIPO_ARTICULO_BUSCAR_X_CRITERIOS",
						resultClasses= TipoArticulo.class,
						parameters={
									//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_CORTO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_LARGO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class )
							}	
				),
				

				
				@NamedStoredProcedureQuery(
						name="tipoarticulo.insert", 
						procedureName="SP_TIPO_ARTICULO_INSERTAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="ID_TIPO_ARTICULO", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_CORTO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_LARGO", type=String.class),
									
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SITUACION", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_USUARIO", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_OPERACION", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_MAC", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_OBSERVACION", type=String.class)
							}					
				),
				@NamedStoredProcedureQuery(
						name="tipoarticulo.update", 
						procedureName="SP_TIPO_ARTICULO_ACTUALIZAR",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_TIPO_ARTICULO", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NOMBRE_CORTO", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NOMBRE_LARGO", type=String.class),
								
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SITUACION", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_USUARIO", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_IP", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_SESSION", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_OPERACION", type=int.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_MAC", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_OBSERVACION", type=String.class)
						}					
										
				),
				@NamedStoredProcedureQuery(
						name="tipoarticulo.delete", 
						procedureName="SP_TIPO_ARTICULO_ELIMINAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_TIPO_ARTICULO", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_USUARIO", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_IP", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_SESSION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_OPERACION", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_MAC", type=String.class)
							}					
				),
				@NamedStoredProcedureQuery(
						name="tipoarticulo.validar", 
						procedureName="dbo.SP_TIPO_ARTICULO_VALIDAR",
						resultClasses= TipoArticulo.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_TIPO_ARTICULO", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="NOMBRE_CORTO", type=String.class )
							}					
				)				
		
		}
	)
@Entity
public class TipoArticulo extends GenericEntity{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_TIPO_ARTICULO")
	private long idTipoArticulo;

	@Column(name="NOMBRE_CORTO")
	private String nombreCorto;

	@Column(name="NOMBRE_LARGO")
	private String nombreLargo;

	
	@Column(name="AUD_OBSERVACION")
	private String aud_Observacion;
	
	@Column(name="AUD_FECHA_OPERACION")
	private  Timestamp 	aud_fechaOperacion;
	
	@Column(name="ID_ORGANIZACION_TIPO_ARTICULO")
	private int idOrganizacionTipoArticulo;
	
	@Column(name="ID_INSTITUCION_TIPO_ARTICULO")
	private int idInstitucionTipoArticulo;
	
	@Column(name="ID_SEDE_TIPO_ARTICULO")
	private int idSedeTipoArticulo;
	
	@Column(name="NRO_VERSION_TIPO_ARTICULO")
	private int nroVersionTipoArticulo;
	
	@Column(name="NRO_PERIODO_TIPO_ARTICULO")
	private int nroPeriodoTipoArticulo;
	
	
	
	public TipoArticulo() {
		this.setSituacion(new Situacion());
		this.setAud_usuario(new Usuario());
	}
	
	public long getIdTipoArticulo() {
		return idTipoArticulo;
	}

	public void setIdTipoArticulo(long idTipoArticulo) {
		this.idTipoArticulo = idTipoArticulo;
	}

	public String getNombreCorto() {
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	public String getNombreLargo() {
		return nombreLargo;
	}

	public void setNombreLargo(String nombreLargo) {
		this.nombreLargo = nombreLargo;
	}

	public Timestamp getAud_fechaOperacion() {
		return aud_fechaOperacion;
	}

	public void setAud_fechaOperacion(Timestamp aud_fechaOperacion) {
		this.aud_fechaOperacion = aud_fechaOperacion;
	}

	public String getAud_Observacion() {
		return aud_Observacion;
	}

	public void setAud_Observacion(String aud_Observacion) {
		this.aud_Observacion = aud_Observacion;
	}

	public int getIdOrganizacionTipoArticulo() {
		return idOrganizacionTipoArticulo;
	}

	public void setIdOrganizacionTipoArticulo(int idOrganizacionTipoArticulo) {
		this.idOrganizacionTipoArticulo = idOrganizacionTipoArticulo;
	}

	public int getIdInstitucionTipoArticulo() {
		return idInstitucionTipoArticulo;
	}

	public void setIdInstitucionTipoArticulo(int idInstitucionTipoArticulo) {
		this.idInstitucionTipoArticulo = idInstitucionTipoArticulo;
	}

	public int getIdSedeTipoArticulo() {
		return idSedeTipoArticulo;
	}

	public void setIdSedeTipoArticulo(int idSedeTipoArticulo) {
		this.idSedeTipoArticulo = idSedeTipoArticulo;
	}

	public int getNroVersionTipoArticulo() {
		return nroVersionTipoArticulo;
	}

	public void setNroVersionTipoArticulo(int nroVersionTipoArticulo) {
		this.nroVersionTipoArticulo = nroVersionTipoArticulo;
	}

	public int getNroPeriodoTipoArticulo() {
		return nroPeriodoTipoArticulo;
	}

	public void setNroPeriodoTipoArticulo(int nroPeriodoTipoArticulo) {
		this.nroPeriodoTipoArticulo = nroPeriodoTipoArticulo;
	}

	@Override
	public String toString() {
		return "TipoArticulo [idTipoArticulo=" + idTipoArticulo + ", nombreCorto=" + nombreCorto + ", nombreLargo="
				+ nombreLargo + ", estado="
						+ estado + "]";
	}

}
