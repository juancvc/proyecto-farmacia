package pe.com.galaxy.systems.apolo.core.entidad.entidad.farmacotecnia;

import java.io.Serializable;
import javax.persistence.*;

import pe.com.galaxy.systems.apolo.core.entidad.entidad.general.Situacion;

import java.sql.Timestamp;

@NamedStoredProcedureQueries(
		{
			@NamedStoredProcedureQuery(
					name="preparadoInsumo.insert", 
					procedureName="SP_PREPARADO_INSUMO_INSERTAR",
					parameters={
								@StoredProcedureParameter(mode=ParameterMode.OUT, name="ID_PREPARADO_INSUMO", type=Integer.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION_PREPARADO_INSUMO", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION_PREPARADO_INSUMO", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE_PREPARADO_INSUMO", type=int.class ),  
								 
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION_PREPARADO", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION_PREPARADO", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE_PREPARADO", type=int.class ), 
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_VERSION_PREPARADO", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO_PREPARADO", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_PREPARADO", type=int.class ),
								
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION_INSUMO", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION_INSUMO", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE_INSUMO", type=int.class ), 
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_VERSION_INSUMO", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO_INSUMO", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSUMO", type=int.class ),
								
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SITUACION", type=int.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_USUARIO", type=Integer.class),								
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class), 
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_MAC", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_OBSERVACION", type=String.class)
						}					
			),
			@NamedStoredProcedureQuery(
					name="preparadoInsumo.update", 
					procedureName="SP_PREPARADO_ACTUALIZAR",
					parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSUMO", type=Integer.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION_INSUMO", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION_INSUMO", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE_INSUMO", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_VERSION_INSUMO", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO_INSUMO", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_CORTO", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_LARGO", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="CODIGO_SISMED", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="CODIGO_SIGA", type=String.class),   
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="CONCENTRACION", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SITUACION", type=int.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_USUARIO", type=Integer.class),								
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class), 
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_MAC", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_OBSERVACION", type=String.class)
					}					
									
			),
			@NamedStoredProcedureQuery(
					name="preparadoInsumo.delete", 
					procedureName="[dbo].[SP_PREPARADO_INSUMO_ELIMINAR]",
					parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION_PREPARADO", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION_PREPARADO", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE_PREPARADO", type=int.class ), 
							@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_VERSION_PREPARADO", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO_PREPARADO", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_PREPARADO", type=int.class ),
							
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION_INSUMO", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION_INSUMO", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE_INSUMO", type=int.class ), 
							@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_VERSION_INSUMO", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO_INSUMO", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSUMO", type=int.class ),
							 
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_USUARIO", type=Integer.class),								
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class), 
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_MAC", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_OBSERVACION", type=String.class)
						}					
			),
	 
			    @NamedStoredProcedureQuery(
						name="preparadoInsumo.findByObjectVO", 
						procedureName="SP_PREPARADO_BUSCAR_X_ID",
						resultClasses= Insumo.class,
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSUMO", type=Integer.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION_INSUMO", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION_INSUMO", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE_INSUMO", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_VERSION_INSUMO", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO_INSUMO", type=int.class ),
							}					
					),
				@NamedStoredProcedureQuery(
						name="preparadoInsumo.findByLikeObject", 
						procedureName="SP_PREPARADO_BUSCAR_X_CRITERIOS",
						resultClasses= Preparado.class,
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION_PREPARADO", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION_PREPARADO", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE_PREPARADO", type=int.class ) 
							}	
				) ,
				@NamedStoredProcedureQuery(
						name="preparadoInsumo.listarPorIdPreparado", 
						procedureName="[dbo].[SP_PREPARADO_INSUMO_BUSCAR_X_IDPREPARADO]",
						resultClasses= PreparadoInsumo.class,
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION_PREPARADO", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION_PREPARADO", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE_PREPARADO", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO_PREPARADO", type=int.class ) ,
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_PREPARADO", type=int.class )  
							}	
				) 
		}
				
	)
@Entity
@Table(name="PREPARADO_INSUMO")
public class PreparadoInsumo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PreparadoInsumoPK id;
	
	private Preparado preparado;
	
	private Insumo insumo;

	@Column(name="AUD_FECHA_OPERACION")
	private Timestamp audFechaOperacion;

	@Column(name="AUD_ID_OPERACION")
	private int audIdOperacion;

	@Column(name="AUD_ID_USUARIO")
	private int audIdUsuario;

	@Column(name="AUD_IP")
	private String audIp;

	@Column(name="AUD_MAC")
	private String audMac;

	@Column(name="AUD_OBSERVACION")
	private String audObservacion;

	@Column(name="AUD_SESSION")
	private String audSession;

	 
	@Column(name="ESTADO")
	private String estado;

	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "ID_SITUACION", referencedColumnName = "ID_SITUACION", insertable = false, updatable = false)
	})
	private Situacion situacion;
 

	public PreparadoInsumo() {
	}
 
	public Timestamp getAudFechaOperacion() {
		return this.audFechaOperacion;
	}

	public void setAudFechaOperacion(Timestamp audFechaOperacion) {
		this.audFechaOperacion = audFechaOperacion;
	}

	public int getAudIdOperacion() {
		return this.audIdOperacion;
	}

	public void setAudIdOperacion(int audIdOperacion) {
		this.audIdOperacion = audIdOperacion;
	}

	public int getAudIdUsuario() {
		return this.audIdUsuario;
	}

	public void setAudIdUsuario(int audIdUsuario) {
		this.audIdUsuario = audIdUsuario;
	}

	public String getAudIp() {
		return this.audIp;
	}

	public void setAudIp(String audIp) {
		this.audIp = audIp;
	}

	public String getAudMac() {
		return this.audMac;
	}

	public void setAudMac(String audMac) {
		this.audMac = audMac;
	}

	public String getAudObservacion() {
		return this.audObservacion;
	}

	public void setAudObservacion(String audObservacion) {
		this.audObservacion = audObservacion;
	}

	public String getAudSession() {
		return this.audSession;
	}

	public void setAudSession(String audSession) {
		this.audSession = audSession;
	}
 
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Situacion getSituacion() {
		if (situacion == null) {
			situacion = new Situacion();
		}
		return situacion;
	}

	public void setSituacion(Situacion situacion) {
		this.situacion = situacion;
	}
 
	public Preparado getPreparado() {
		if (preparado == null) {
			preparado = new Preparado();
		}
		return preparado;
	}

	public void setPreparado(Preparado preparado) {
		this.preparado = preparado;
	}

	public void setId(PreparadoInsumoPK id) {
		this.id = id;
	}

	public Insumo getInsumo() {
		if (insumo == null) {
			insumo = new Insumo();
		}
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	public PreparadoInsumoPK getId() {
		if (id == null) {
			id = new PreparadoInsumoPK();
		}
		return id;
	}

}