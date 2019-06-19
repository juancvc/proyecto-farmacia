package sigelab.core.entity.venta;

import java.sql.Timestamp;
import javax.persistence.Column;
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
	private static final int serialVersionUID = 1;
	@Id
	@Column(name="ID_DEVOLUCION")
	private String idDevolucion;

	@Column(name="ID_ORGANIZACION_DEVOLUCION")
	private String idOrganizacionDevolucion;
	
	@Column(name="ID_INSTITUCION_DEVOLUCION")
	private String idInstitucionDevolucion;
	
	@Column(name="ID_SEDE_DEVOLUCION")
	private String idSedeDevolucion;
	
	@Column(name="NRO_VERSION_DEVOLUCION")
	private String nroVersionDevolucion;
	
	@Column(name="NRO_PERIODO_DEVOLUCION")
	private String nroPeriodoDevolucion;
	
	
	@Column(name="AUD_FECHA_OPERACION")
	private  Timestamp 	aud_fechaOperacion;
	 
	private VentaItem ventaItem;

	@Column(name="ID_MOTIVO_DEVOLUCION")
	private String idMotivoDevolucion;
	
	@Column(name="CANTIDAD_DEVUELTA")
	private int cantidadDevuelta;
	
	
	private String fechaInicio;
	private String fechaFin;
	
	
	
	public Devolucion() { 
	}



	public String getIdDevolucion() {
		return idDevolucion;
	}



	public void setIdDevolucion(String idDevolucion) {
		this.idDevolucion = idDevolucion;
	}



	public String getIdOrganizacionDevolucion() {
		return idOrganizacionDevolucion;
	}



	public void setIdOrganizacionDevolucion(String idOrganizacionDevolucion) {
		this.idOrganizacionDevolucion = idOrganizacionDevolucion;
	}



	public String getIdInstitucionDevolucion() {
		return idInstitucionDevolucion;
	}



	public void setIdInstitucionDevolucion(String idInstitucionDevolucion) {
		this.idInstitucionDevolucion = idInstitucionDevolucion;
	}



	public String getIdSedeDevolucion() {
		return idSedeDevolucion;
	}



	public void setIdSedeDevolucion(String idSedeDevolucion) {
		this.idSedeDevolucion = idSedeDevolucion;
	}



	public String getNroVersionDevolucion() {
		return nroVersionDevolucion;
	}



	public void setNroVersionDevolucion(String nroVersionDevolucion) {
		this.nroVersionDevolucion = nroVersionDevolucion;
	}



	public String getNroPeriodoDevolucion() {
		return nroPeriodoDevolucion;
	}



	public void setNroPeriodoDevolucion(String nroPeriodoDevolucion) {
		this.nroPeriodoDevolucion = nroPeriodoDevolucion;
	}



	public Timestamp getAud_fechaOperacion() {
		return aud_fechaOperacion;
	}



	public void setAud_fechaOperacion(Timestamp aud_fechaOperacion) {
		this.aud_fechaOperacion = aud_fechaOperacion;
	}



	public VentaItem getVentaItem() {
		return ventaItem;
	}



	public void setVentaItem(VentaItem ventaItem) {
		this.ventaItem = ventaItem;
	}



	public String getIdMotivoDevolucion() {
		return idMotivoDevolucion;
	}



	public void setIdMotivoDevolucion(String idMotivoDevolucion) {
		this.idMotivoDevolucion = idMotivoDevolucion;
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