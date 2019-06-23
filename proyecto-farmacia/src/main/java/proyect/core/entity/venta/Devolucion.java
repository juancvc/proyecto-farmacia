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
						procedureName="SP_DEVOLUCION_BUSCAR_X_ID",
						resultClasses= Devolucion.class,
						parameters={
								//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_DEVOLUCION", type=Long.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class )
							}					
					),
				
				@NamedStoredProcedureQuery(
						name="devolucion.buscarTodos", 
						procedureName="SP_DEVOLUCION_BUSCAR_TODOS",
						resultClasses= Devolucion.class
					/*	parameters={
									@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class )
							}	*/				
					),
					
				@NamedStoredProcedureQuery(
						name="devolucion.listar", 
						procedureName="SP_DEVOLUCION_BUSCAR_X_CRITERIOS",
						resultClasses= Devolucion.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="FECHA_INICIO", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="FECHA_FIN", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_MOTIVO", type=int.class )

							}	
				),
				
				@NamedStoredProcedureQuery(
						name="devolucion.insert", 
						procedureName="SP_DEVOLUCION_INSERTAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="ID_DEVOLUCION", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_CORTO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_LARGO", type=String.class),
									
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SITUACION", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_USUARIO", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_OPERACION", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_MAC", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_OBSERVACION", type=String.class)
							}					
				),
				
				@NamedStoredProcedureQuery(
						name="devolucion.update", 
						procedureName="SP_DEVOLUCION_ACTUALIZAR",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_DEVOLUCION", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NOMBRE_CORTO", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NOMBRE_LARGO", type=String.class),
								
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SITUACION", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_USUARIO", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_OPERACION", type=int.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_MAC", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_OBSERVACION", type=String.class)
						}					
										
				),
				@NamedStoredProcedureQuery(
						name="devolucion.delete", 
						procedureName="SP_DEVOLUCION_ELIMINAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_DEVOLUCION", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_USUARIO", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_IP", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_SESSION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_OPERACION", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_MAC", type=String.class)
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