package proyect.core.entity.inventario;
 
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id; 
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import proyect.core.entity.stock.Stock;
 
@SuppressWarnings("serial")
@NamedStoredProcedureQueries(
		{
				
				@NamedStoredProcedureQuery(
						name="inventarioDetalle.insert", 
						procedureName="[dbo].[usp_Inventario_insertar]",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="idInventario", 			type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idFarmacia",   		    type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="cantidadItems", 		type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaCantidad", 		type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="nroDocumento", 			type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idPersonalResponsable", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="fecha", 				type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioRegistro", 		type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipRegistro", 			type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaIdStock", 		type=String.class)
							}					
				),
				@NamedStoredProcedureQuery(
						name="inventarioDetalle.buscarXNroDocumento", 
						procedureName="[dbo].[usp_Inventario_buscarxNroDocumento]",
						resultClasses = InventarioDetalle.class,
						parameters={
						
								@StoredProcedureParameter(mode=ParameterMode.IN, name="idAlmacen", 	  type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="nroDocumento", type=String.class)
							}					
				),
				@NamedStoredProcedureQuery(
						name="inventarioDetalle.insertHistorico", 
						procedureName="[dbo].[usp_Inventario_insertarHistorico]",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="idFarmacia", 	 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ipRegistro", 	 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="nroDocumento", 	 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="usuarioRegistro", type=String.class )
							}					
				),
				@NamedStoredProcedureQuery(
						name="inventarioDetalle.validarExisteInventario", 
						procedureName="[dbo].[SP_INVENTARIO_VALIDAR_EXISTE]",
						resultClasses = InventarioDetalle.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="idAlmacen", 		 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="nroPeriodo", 	 type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="nroMes", 		 type=String.class )
							}					
				),
				@NamedStoredProcedureQuery(
						name="inventarioDetalle.findByLikeObjectVO", 
						procedureName="[dbo].[SP_INVENTARIO_BUSCAR_X_CRITERIOS]",
						resultClasses = InventarioDetalle.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="idAlmacen", 		 type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="nroPeriodo", 	 type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="nroMes", 		 type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="idSituacion",     type=String.class )
							}					
				)
		}
	)
@Entity
public class InventarioDetalle  {
	@Id
	@Column(name="idInventarioDetalle")
	private String idInventarioDetalle;
	
	@Column(name="idInventario")
	private String idInventario;
	
	@Column(name="idStock")
	private String idStock;
	
	@Column(name="fecha")
	private String fecha;

	@Column(name="nroDocumento")
	private String nroDocumento;
	
	@Column(name="cantidad")
	private int cantidad;
	
	@Column(name="saldoAnterior")
	private int saldoAnterior;
	
	@Column(name="saldoActual")
	private int saldoActual;

	public String getIdInventarioDetalle() {
		return idInventarioDetalle;
	}

	public void setIdInventarioDetalle(String idInventarioDetalle) {
		this.idInventarioDetalle = idInventarioDetalle;
	}

	public String getIdInventario() {
		return idInventario;
	}

	public void setIdInventario(String idInventario) {
		this.idInventario = idInventario;
	}

	public String getIdStock() {
		return idStock;
	}

	public void setIdStock(String idStock) {
		this.idStock = idStock;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getSaldoAnterior() {
		return saldoAnterior;
	}

	public void setSaldoAnterior(int saldoAnterior) {
		this.saldoAnterior = saldoAnterior;
	}

	public int getSaldoActual() {
		return saldoActual;
	}

	public void setSaldoActual(int saldoActual) {
		this.saldoActual = saldoActual;
	}
	
	
	
}

