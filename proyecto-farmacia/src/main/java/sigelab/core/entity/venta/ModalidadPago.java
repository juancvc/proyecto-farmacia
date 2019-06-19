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
						name="modalidadPago.findByObject", 
						procedureName="SP_MODALIDAD_PAGO_BUSCAR_X_ID",
						resultClasses= ModalidadPago.class,
						parameters={
								//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_ID_MODALIDAD_PAGO", type=Long.class)
							}					
					),

				@NamedStoredProcedureQuery(
						name="modalidadPago.findByLikeObject", 
						procedureName="SP_MODALIDAD_PAGO_BUSCAR_X_CRITERIOS",
						resultClasses= ModalidadPago.class,
						parameters={
								//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_NOMBRE_CORTO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_NOMBRE_LARGO", type=String.class)
							}	
				),
				

				@NamedStoredProcedureQuery(
						name="modalidadPago.buscarTodos", 
						procedureName="SP_MODALIDAD_PAGO_BUSCAR_TODOS",
						resultClasses= ModalidadPago.class
					/*	parameters={
									@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_C_CURSOR", type=void.class )
							}	*/				
					),
				
				@NamedStoredProcedureQuery(
						name="modalidadPago.insert", 
						procedureName="SP_MODALIDAD_PAGO_INSERTAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="P_ID_MODALIDAD_PAGO", type=Long.class ),
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
						name="modalidadPago.update", 
						procedureName="SP_MODALIDAD_PAGO_ACTUALIZAR",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="P_ID_MODALIDAD_PAGO", type=Long.class ),
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
						name="modalidadPago.delete", 
						procedureName="SP_MODALIDAD_PAGO_ELIMINAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="P_ID_MODALIDAD_PAGO", type=Long.class )
							}					
				)
		
		}
	)
@Entity
@Table(name="MODALIDAD_PAGO")
public class ModalidadPago extends GenericEntity{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_MODALIDAD_PAGO")
	private long idModalidadPago;

	@Column(name="NOMBRE_CORTO")
	private String nombreCorto;

	@Column(name="NOMBRE_LARGO")
	private String nombreLargo;

	public ModalidadPago() {
	}

	public long getIdModalidadPago() {
		return idModalidadPago;
	}

	public void setIdModalidadPago(long idModalidadPago) {
		this.idModalidadPago = idModalidadPago;
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
