package pe.com.galaxy.systems.apolo.core.entidad.entidad.movimiento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import pe.com.galaxy.systems.apolo.core.entidad.GenericEntity;
@NamedStoredProcedureQueries(
		{
				
				@NamedStoredProcedureQuery(
						name="tipomovimiento.findByObject", 
						procedureName="SP_TIPO_MOVIMIENTO_BUSCAR_X_ID",
						resultClasses= TipoMovimiento.class,
						parameters={
								//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_TIPO_MOVIMIENTO", type=Long.class)
							}					
					),

				@NamedStoredProcedureQuery(
						name="tipomovimiento.findByLikeObject", 
						procedureName="SP_TIPO_MOVIMIENTO_BUSCAR_X_CRITERIOS",
						resultClasses= TipoMovimiento.class,
						parameters={
								//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_CORTO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_LARGO", type=String.class)
							}	
				),
				

				@NamedStoredProcedureQuery(
						name="tipomovimiento.buscarTodos", 
						procedureName="SP_TIPO_MOVIMIENTO_BUSCAR_TODOS",
						resultClasses= TipoMovimiento.class
						/*parameters={
									@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class )
							}*/					
					),
				
				@NamedStoredProcedureQuery(
						name="tipomovimiento.insert", 
						procedureName="SP_TIPO_MOVIMIENTO_INSERTAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="ID_TIPO_MOVIMIENTO", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_CORTO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_LARGO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="CLASE_MOVIMIENTO", type=Long.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="VISIBLE", type=Long.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="VALOR01", type=Long.class)
							}					
				),
				@NamedStoredProcedureQuery(
						name="tipomovimiento.update", 
						procedureName="SP_TIPO_MOVIMIENTO_ACTUALIZAR",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_TIPO_MOVIMIENTO", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NOMBRE_CORTO", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NOMBRE_LARGO", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="CLASE_MOVIMIENTO", type=Long.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="VISIBLE", type=Long.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="VALOR01", type=Long.class)
						}					
										
				),
				@NamedStoredProcedureQuery(
						name="tipomovimiento.delete", 
						procedureName="SP_TIPO_MOVIMIENTO_ELIMINAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_TIPO_MOVIMIENTO", type=Long.class )
							}					
				)
		
		}
	)
@Entity
public class TipoMovimiento extends GenericEntity{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_TIPO_MOVIMIENTO")
	private long idTipoMovimiento;

	@Column(name="NOMBRE_CORTO")
	private String nombreCorto;

	@Column(name="NOMBRE_LARGO")
	private String nombreLargo;
	
	@Column(name="VALOR01")
	private String valor01;
	
	@Column(name="CLASE_MOVIMIENTO")
	private String clase;
	
	@Column(name="VISIBLE")
	private String swVisible;
	
	public TipoMovimiento() {
	}
	
	public long getIdTipoMovimiento() {
		return idTipoMovimiento;
	}

	public void setIdTipoMovimiento(long idTipoMovimiento) {
		this.idTipoMovimiento = idTipoMovimiento;
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
	
	
	public String getValor01() {
		return valor01;
	}

	public String getSwVisible() {
		return swVisible;
	}

	public void setSwVisible(String swVisible) {
		this.swVisible = swVisible;
	}

	public void setValor01(String valor01) {
		this.valor01 = valor01;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	@Override
	public String toString() {
		return "Tipo_Movimiento [idTipoMovimiento=" + idTipoMovimiento + ", nombreCorto=" + nombreCorto
				+ ", nombreLargo=" + nombreLargo + ", estado="
				+ estado + "]";
	}

}
