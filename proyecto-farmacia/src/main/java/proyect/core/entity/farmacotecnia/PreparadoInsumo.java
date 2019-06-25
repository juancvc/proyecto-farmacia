package proyect.core.entity.farmacotecnia;

import java.io.Serializable;
import javax.persistence.*;


import java.sql.Timestamp;

@NamedStoredProcedureQueries(
		{
			@NamedStoredProcedureQuery(
					name="preparadoInsumo.insert", 
					procedureName="SP_PREPARADO_INSUMO_INSERTAR",
					parameters={
								@StoredProcedureParameter(mode=ParameterMode.OUT, name="idPreparadoInsumo", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="idPreparado", 		type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="idInsumo", 			type=String.class),							
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="idSituacion", 		type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioRegistro", 	type=String.class),								
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipRegistro", 		type=String.class), 
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="observacion", 		type=String.class)
						}					
			),
			@NamedStoredProcedureQuery(
					name="preparadoInsumo.update", 
					procedureName="SP_PREPARADO_ACTUALIZAR",
					parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idInsumo", 				type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="nombreInsumo", 			type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="descripcion", 			type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="codigoSismed", 			type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="codigoSIGA", 			type=String.class),   
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="concentracion", 		type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idSituacion", 			type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioModificacion", 	type=String.class),								
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipModificacion", 		type=String.class), 
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="observacion",			type=String.class)
					}					
									
			),
			@NamedStoredProcedureQuery(
					name="preparadoInsumo.delete", 
					procedureName="[dbo].[SP_PREPARADO_INSUMO_ELIMINAR]",
					parameters={
	
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idPreparado", 			type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idInsumo", 				type=String.class),						 
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioModificacion", 	type=String.class),								
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipModificacion", 		type=String.class), 
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="observacion", 			type=String.class)
						}					
			),
	 
			    @NamedStoredProcedureQuery(
						name="preparadoInsumo.findByObjectVO", 
						procedureName="SP_PREPARADO_BUSCAR_X_ID",
						resultClasses= Insumo.class,
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="idInsumo", 			type=String.class),
							
							}					
					),
				@NamedStoredProcedureQuery(
						name="preparadoInsumo.findByLikeObject", 
						procedureName="SP_PREPARADO_BUSCAR_X_CRITERIOS",
						resultClasses= Preparado.class
					/*	parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION_PREPARADO",  type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION_PREPARADO",   type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE_PREPARADO", 			type=String.class ) 
							}	*/
				) ,
				@NamedStoredProcedureQuery(
						name="preparadoInsumo.listarPorIdPreparado", 
						procedureName="[dbo].[SP_PREPARADO_INSUMO_BUSCAR_X_IDPREPARADO]",
						resultClasses= PreparadoInsumo.class,
						parameters={

								@StoredProcedureParameter(mode=ParameterMode.IN, name="idPreparado", 		type=String.class )  
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

	@Column(name="usuarioRegistro")
	private int audIdUsuario;

	@Column(name="ipRegistro")
	private String audIp;

	@Column(name="AUD_MAC")
	private String audMac;

	@Column(name="observacion")
	private String audObservacion;

	@Column(name="AUD_SESSION")
	private String audSession;

	 
	@Column(name="ESTADO")
	private String estado;

	@Column(name="idSituacion")
	private String situacion;
 

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

	public String getSituacion() {
		if (situacion == null) {
			situacion = new String();
		}
		return situacion;
	}

	public void setSituacion(String situacion) {
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