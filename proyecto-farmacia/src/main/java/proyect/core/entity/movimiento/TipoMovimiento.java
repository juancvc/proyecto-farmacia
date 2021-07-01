package proyect.core.entity.movimiento;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import proyect.core.entity.stock.Stock;
 


@NamedStoredProcedureQueries(
		{
			@NamedStoredProcedureQuery(
				name="tipoMovimiento.insert", 
				procedureName="[dbo].[usp_AlmacenMovimiento_insertar]",
				parameters={
							@StoredProcedureParameter(mode=ParameterMode.OUT, name="idMovimiento", 	   		 type=String.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idTipoMovimiento",   	 type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="cantidad", 		   		 type=int.class),
							
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idAlmacenOrigen",  		 type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idAlmacenDestino", 		 type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="nroDocumento", 	   		 type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioRegistro",  		 type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipRegistro", 	   		 type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="nroGuia", 		   		 type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaIdStock",    		 type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaCantidad",   		 type=String.class),							
							@StoredProcedureParameter(mode=ParameterMode.OUT, name="valida", 		   		 type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="tipoIngresoDocumento",   type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idTipoFinanciadorCat02", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idTipoSeleccionCat02", 	 type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idTipoDocCompraCat02", 	 type=String.class)
					}
					),	 	
					@NamedStoredProcedureQuery(
							name="tipoMovimiento.findByLikeObject", 
							procedureName="PKG_MOVIMIENTO_ALMACEN.SP_BUSCAR_X_CRITERIOS",
							resultClasses= TipoMovimiento.class,
							parameters={
										@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class )
								}	
					), 
					@NamedStoredProcedureQuery(
							name="tipoMovimiento.buscarPorFiltros", 
							procedureName="[dbo].[usp_TipoMovimiento_buscarxCriterios]",
							resultClasses= TipoMovimiento.class,
							parameters={
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="nombreTipoMovimiento", 	   type=String.class) 
								}	
					), 
		}			
	)


@Entity
public class TipoMovimiento  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idTipoMovimiento")
	private String idTipoMovimiento;
 
	@Column(name="nombreTipoMovimiento")
	private String nombreTipoMovimiento;
	 
	@Column(name="idClaseMovimientoCat02")
	private String idClaseMovimientoCat02;
	
	@Column(name="idCategoriaTipoMovimientoCat02")
	private String idCategoriaTipoMovimientoCat02;

	public String getIdTipoMovimiento() {
		return idTipoMovimiento;
	}

	public void setIdTipoMovimiento(String idTipoMovimiento) {
		this.idTipoMovimiento = idTipoMovimiento;
	}

	public String getNombreTipoMovimiento() {
		return nombreTipoMovimiento;
	}

	public void setNombreTipoMovimiento(String nombreTipoMovimiento) {
		this.nombreTipoMovimiento = nombreTipoMovimiento;
	}

	public String getIdClaseMovimientoCat02() {
		return idClaseMovimientoCat02;
	}

	public void setIdClaseMovimientoCat02(String idClaseMovimientoCat02) {
		this.idClaseMovimientoCat02 = idClaseMovimientoCat02;
	}

	public String getIdCategoriaTipoMovimientoCat02() {
		return idCategoriaTipoMovimientoCat02;
	}

	public void setIdCategoriaTipoMovimientoCat02(String idCategoriaTipoMovimientoCat02) {
		this.idCategoriaTipoMovimientoCat02 = idCategoriaTipoMovimientoCat02;
	}
	
	
}