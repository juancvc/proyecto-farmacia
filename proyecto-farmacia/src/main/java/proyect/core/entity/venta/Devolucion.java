package proyect.core.entity.venta;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
 
@NamedStoredProcedureQueries(
		{
				
				@NamedStoredProcedureQuery(
						name="devolucion.buscarxid", 
						procedureName="[dbo].[usp_Devolucion_buscarxID]",
						resultClasses= Devolucion.class,
						parameters={
								
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idDevolucion", type=Long.class)
							}					
					),
				
				@NamedStoredProcedureQuery(
						name="devolucion.buscarTodos", 
						procedureName="[dbo].[usp_Devolucion_buscarTodos]",
						resultClasses= Devolucion.class
					/*	parameters={
								
							}	*/				
					),
					
				@NamedStoredProcedureQuery(
						name="devolucion.listar", 
						procedureName="[dbo].[usp_Devolucion_buscarxCriterios]",
						resultClasses= Devolucion.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="idMotivoDevolucionCat02", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="fechaInicio", 			 type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="fechaFin", 				 type=String.class )

							}	
				),
				
				@NamedStoredProcedureQuery(
						name="devolucion.insert", 
						procedureName="[dbo].[usp_Devolucion_insertar]",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="idDevolucion", 			  type=String.class ),
									
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idVentaItem", 			  type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="nroPeriodoVentaItem", 	  type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="fechaDevolucion", 		  type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idMotivoDevolucionCat02", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="cantidadDevuelta", 		  type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioRegistro", 		  type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipRegistro", 			  type=String.class)
									
									
							}					
				),
				
				@NamedStoredProcedureQuery(
						name="devolucion.update", 
						procedureName="[dbo].[usp_Devolucion_actualizar]",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="idDevolucion", 				type=String.class ),				
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="idVentaItem", 				type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="nroPeriodoVentaItem", 		type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="fechaDevolucion", 			type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="idMotivoDevolucionCat02",   type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="cantidadDevuelta", 			type=int.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioModificacion", 		type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipModificacion", 			type=String.class)
								
						}					
										
				),
				@NamedStoredProcedureQuery(
						name="devolucion.delete", 
						procedureName="[dbo].[usp_Devolucion_eliminar]",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="idDevolucion", 		 type=String.class ),						
									@StoredProcedureParameter(mode=ParameterMode.IN, name="usuarioModificacion", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ipModificacion",      type=String.class)
							}					
				)
		
		}
	)
@Entity
public class Devolucion  {
	
	@EmbeddedId
	private DevolucionPK id;

	@Column(name="idVentaItem")
	private String idVentaItem;
	
	@Column(name="nroPeriodoVentaItem")
	private String nroPeriodoVentaItem;
	
	@Column(name="idMotivoDevolucionCat02")
	private String idMotivoDevolucionCat02;
	
	@Column(name="fechaDevolucion")
	private  Timestamp 	fechaDevolucion;
	
	@Column(name="usuarioRegistro")
	private String usuarioRegistro;
	
	@Column(name="fechaRegistro")
	private  Timestamp 	fechaRegistro;
	
	@Column(name="cantidadDevuelta")
	private int cantidadDevuelta;
	
	
	private String fechaInicio;
	private String fechaFin;
	
	
	
	public Devolucion() { 
	}



	public DevolucionPK getId() {
		return id;
	}



	public void setId(DevolucionPK id) {
		this.id = id;
	}



	public String getIdVentaItem() {
		return idVentaItem;
	}



	public void setIdVentaItem(String idVentaItem) {
		this.idVentaItem = idVentaItem;
	}



	public String getNroPeriodoVentaItem() {
		return nroPeriodoVentaItem;
	}



	public void setNroPeriodoVentaItem(String nroPeriodoVentaItem) {
		this.nroPeriodoVentaItem = nroPeriodoVentaItem;
	}



	public String getIdMotivoDevolucionCat02() {
		return idMotivoDevolucionCat02;
	}



	public void setIdMotivoDevolucionCat02(String idMotivoDevolucionCat02) {
		this.idMotivoDevolucionCat02 = idMotivoDevolucionCat02;
	}



	public Timestamp getFechaDevolucion() {
		return fechaDevolucion;
	}



	public void setFechaDevolucion(Timestamp fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}



	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}



	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}



	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}



	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}



	public int getCantidadDevuelta() {
		return cantidadDevuelta;
	}



	public void setCantidadDevuelta(int cantidadDevuelta) {
		this.cantidadDevuelta = cantidadDevuelta;
	}



	public String getFechaInicio() {
		return fechaInicio;
	}



	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}



	public String getFechaFin() {
		return fechaFin;
	}



	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	
}