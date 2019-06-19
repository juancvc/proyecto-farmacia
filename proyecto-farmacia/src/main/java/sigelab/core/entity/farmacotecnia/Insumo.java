
package sigelab.core.entity.farmacotecnia;

import java.io.Serializable;
import javax.persistence.*;


import java.sql.Timestamp;

@NamedStoredProcedureQueries(
		{
			@NamedStoredProcedureQuery(
					name="insumo.insert", 
					procedureName="SP_INSUMO_INSERTAR",
					parameters={
								@StoredProcedureParameter(mode=ParameterMode.OUT, name="ID_INSUMO", type=Integer.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION_INSUMO", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION_INSUMO", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE_INSUMO", type=int.class ), 
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
					name="insumo.update", 
					procedureName="SP_INSUMO_ACTUALIZAR",
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
					name="insumo.delete", 
					procedureName="SP_INSUMO_ELIMINAR",
					parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSUMO", type=Integer.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION_INSUMO", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION_INSUMO", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE_INSUMO", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_VERSION_INSUMO", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO_INSUMO", type=int.class ),
							
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_USUARIO", type=Integer.class),								
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class), 
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_MAC", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_OBSERVACION", type=String.class)
						}					
			),
	 
			    @NamedStoredProcedureQuery(
						name="insumo.findByObjectVO", 
						procedureName="SP_INSUMO_BUSCAR_X_ID",
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
						name="insumo.findByLikeObjectVO", 
						procedureName="SP_INSUMO_BUSCAR_X_CRITERIOS",
						resultClasses= Insumo.class,
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION_INSUMO", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION_INSUMO", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE_INSUMO", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="CODIGO_SISMED", type=String.class )
							}	
				) 
		}
				
	)
@Entity
@Table(name="INSUMO")
@NamedQuery(name="Insumo.findAll", query="SELECT i FROM Insumo i")
public class Insumo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private InsumoPK id;

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

	@Column(name="CODIGO_SIGA")
	private String codigoSiga;

	@Column(name="CODIGO_SISMED")
	private String codigoSismed;

	@Column(name="CONCENTRACION")
	private String concentracion;

	@Column(name="ESTADO")
	private String estado;
 
	@Column(name="ID_SITUACION")
	private String situacion;
	
	@Column(name="NOMBRE_CORTO")
	private String nombreCorto;

	@Column(name="NOMBRE_LARGO")
	private String nombreLargo;

	public Insumo() { 
	}

	public InsumoPK getId() {
		return this.id;
	}

	public void setId(InsumoPK id) {
		this.id = id;
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

	public String getCodigoSiga() {
		return this.codigoSiga;
	}

	public void setCodigoSiga(String codigoSiga) {
		this.codigoSiga = codigoSiga;
	}

	public String getCodigoSismed() {
		return this.codigoSismed;
	}

	public void setCodigoSismed(String codigoSismed) {
		this.codigoSismed = codigoSismed;
	}

	public String getConcentracion() {
		return this.concentracion;
	}

	public void setConcentracion(String concentracion) {
		this.concentracion = concentracion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	} 

	public String getSituacion() {
		return situacion;
	}

	public void setSituacion(String situacion) {
		this.situacion = situacion;
	}

	public String getNombreCorto() {
		return this.nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	public String getNombreLargo() {
		return this.nombreLargo;
	}

	public void setNombreLargo(String nombreLargo) {
		this.nombreLargo = nombreLargo;
	}

	@Override
	public String toString() {
		return "Insumo [id=" + id + ", audFechaOperacion=" + audFechaOperacion + ", audIdOperacion=" + audIdOperacion
				+ ", audIdUsuario=" + audIdUsuario + ", audIp=" + audIp + ", audMac=" + audMac + ", audObservacion="
				+ audObservacion + ", audSession=" + audSession + ", codigoSiga=" + codigoSiga + ", codigoSismed="
				+ codigoSismed + ", concentracion=" + concentracion + ", estado=" + estado + ", situacion=" + situacion
				+ ", nombreCorto=" + nombreCorto + ", nombreLargo=" + nombreLargo + "]";
	}

}