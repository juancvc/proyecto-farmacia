package proyect.core.entity.farmacotecnia;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@NamedStoredProcedureQueries(
		{
			@NamedStoredProcedureQuery(
					name="preparado.insert", 
					procedureName="SP_PREPARADO_INSERTAR",
					parameters={
								@StoredProcedureParameter(mode=ParameterMode.OUT, name="idPreparado", 		type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="nombrePreparado", 	type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="descripcion", 		type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="concentracion", 	type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="idSituacion", 		type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioRegistro", 	type=String.class),								
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipRegistro", 		type=String.class), 
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="observacion", 		type=String.class)
						}					
			),

			@NamedStoredProcedureQuery(
					name="preparado.update", 
					procedureName="SP_PREPARADO_UPDATE",
					parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN, name="idPreparado", 			type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="nombrePreparado", 		type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="descripcion", 			type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="concentracion", 		type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idSituacion", 			type=String.class),   
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioModificacion", 	type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipModificacion", 		type=String.class)
					}					
									
			),			
			@NamedStoredProcedureQuery(
					name="preparado.delete", 
					procedureName="SP_PREPARADO_ELIMINAR",
					parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN, name="idPreparado", 			type=String.class ),						
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioModificacion",   type=String.class),								
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipModificacion", 		type=String.class), 
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="observacion", 			type=String.class)
						}					
			),
	 
			    @NamedStoredProcedureQuery(
						name="preparado.findByObjectVO", 
						procedureName="SP_PREPARADO_BUSCAR_X_ID",
						resultClasses= Preparado.class,
						parameters={ 
								@StoredProcedureParameter(mode=ParameterMode.IN, name="idPreparado", type=String.class )
							}					
					),
				@NamedStoredProcedureQuery(
						name="preparado.findByLikeObject", 
						procedureName="SP_PREPARADO_BUSCAR_X_CRITERIOS",
						resultClasses= Preparado.class
					/*	parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION_PREPARADO", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION_PREPARADO", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE_PREPARADO", type=int.class ) 
							}	*/
				) 
		}
				
	)
@Entity
@Table(name="PREPARADO")
@NamedQuery(name="Preparado.findAll", query="SELECT p FROM Preparado p")
public class Preparado implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PreparadoPK id;

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

	@Column(name="concentracion")
	private String concentracion;

	@Column(name="descripcion")
	private String descripcion;

	@Column(name="ESTADO")
	private String estado;

	@Column(name="idSituacion")
	private String situacion;
	
	@Column(name="nombrePreparado")
	private String nombreCorto;
 
	@OneToMany(mappedBy="preparado")
	private List<PreparadoInsumo> itemsInsumos;
	
	public Preparado() {
	}

	
	public PreparadoPK getId() {
		if (id == null) {
			id = new PreparadoPK();
		}
		return this.id;
	}

	public void setId(PreparadoPK id) {
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

	public String getConcentracion() {
		return this.concentracion;
	}

	public void setConcentracion(String concentracion) {
		this.concentracion = concentracion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
 

	public String getNombreCorto() {
		return this.nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}


	public List<PreparadoInsumo> getInsumos() {
		if (itemsInsumos == null) {
			itemsInsumos = new ArrayList<PreparadoInsumo>();
		}
		return itemsInsumos;
	}


	public void setInsumos(List<PreparadoInsumo> insumos) {
		this.itemsInsumos = insumos;
	}
	public PreparadoInsumo addVentaItem(PreparadoInsumo preparadoInsumo) {
		getInsumos().add(preparadoInsumo);
		preparadoInsumo.setPreparado(this);

		return preparadoInsumo;
	}

	public PreparadoInsumo removePreparadoInsumo(PreparadoInsumo preparadoInsumo) {
		getInsumos().remove(preparadoInsumo);
		preparadoInsumo.setPreparado(null);

		return preparadoInsumo;
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
 
}