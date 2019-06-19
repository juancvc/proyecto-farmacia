package pe.com.galaxy.systems.apolo.core.entidad.entidad.venta;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import pe.com.galaxy.systems.apolo.core.entidad.GenericEntity;
@NamedStoredProcedureQueries(
		{
				
				@NamedStoredProcedureQuery(
						name="tipotarjeta.findByObject", 
						procedureName="PKG_TIPO_TARJETA.SP_BUSCAR_X_ID",
						resultClasses= TipoTarjeta.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_ID_TIPO_TARJETA", type=Long.class)
							}					
					),
				@NamedStoredProcedureQuery(
						name="tipotarjeta.findByLikeObject", 
						procedureName="PKG_TIPO_TARJETA.SP_BUSCAR_X_CRITERIOS",
						resultClasses= TipoTarjeta.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="P_NOMBRE_CORTO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="P_NOMBRE_LARGO", type=String.class)
							}	
				),
				
				@NamedStoredProcedureQuery(
						name="tipotarjeta.insert", 
						procedureName="PKG_TIPO_TARJETA.SP_INSERTAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="P_ID_TIPO_TARJETA", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_NOMBRE_CORTO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_NOMBRE_LARGO", type=String.class),
									
									@StoredProcedureParameter(mode=ParameterMode.IN, name="P_ID_SITUACION", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="P_AUD_ID_USUARIO", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_AUD_IP", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_AUD_SESSION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_AUD_ID_OPERACION", type=Long.class)
							}					
				),
				@NamedStoredProcedureQuery(
						name="tipotarjeta.update", 
						procedureName="PKG_TIPO_TARJETA.SP_ACTUALIZAR",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="P_ID_TIPO_TARJETA", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="P_NOMBRE_CORTO", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="P_NOMBRE_LARGO", type=String.class),
								
								@StoredProcedureParameter(mode=ParameterMode.IN, name="P_ID_SITUACION", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="P_AUD_ID_USUARIO", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="P_AUD_IP", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="P_AUD_SESSION", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="P_AUD_ID_OPERACION", type=Long.class)
						}					
										
				),
				@NamedStoredProcedureQuery(
						name="tipotarjeta.delete", 
						procedureName="PKG_TIPO_TARJETA.SP_ELIMINAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="P_ID_TIPO_TARJETA", type=Long.class )
							}					
				),
				@NamedStoredProcedureQuery(
						name="tipotarjeta.buscarTodos", 
						procedureName="PKG_TIPO_TARJETA.SP_BUSCAR_TODOS",
						resultClasses= TipoTarjeta.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_C_CURSOR", type=void.class )
							}					
					)
		
		}
	)
@Entity
@Table(name="TIPO_TARJETA")
public class TipoTarjeta 
	extends GenericEntity{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ID_TIPO_TARJETA")
	private long idTipoTarjeta;

	@Column(name="NOMBRE_CORTO")
	private String nombreCorto;

	@Column(name="NOMBRE_LARGO")
	private String nombreLargo;

	public TipoTarjeta() {
	}


	public long getIdTipoTarjeta() {
		return idTipoTarjeta;
	}


	public void setIdTipoTarjeta(long idTipoTarjeta) {
		this.idTipoTarjeta = idTipoTarjeta;
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

	
}