package pe.com.galaxy.systems.apolo.core.entidad.entidad.venta;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import pe.com.galaxy.systems.apolo.core.entidad.GenericEntity;
import pe.com.galaxy.systems.apolo.core.entidad.entidad.general.Situacion;
import pe.com.galaxy.systems.apolo.core.entidad.entidad.seguridad.Usuario;
import pe.com.galaxy.systems.apolo.core.entidad.entidad.venta.VentaItem;
import pe.com.galaxy.systems.apolo.core.entidad.vo.venta.DevolucionVO;
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
						resultClasses= DevolucionVO.class,
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
public class Devolucion 
	extends GenericEntity{
	private static final int serialVersionUID = 1;
	@Id
	@Column(name="ID_DEVOLUCION")
	private int idDevolucion;

	@Column(name="ID_ORGANIZACION_DEVOLUCION")
	private int idOrganizacionDevolucion;
	
	@Column(name="ID_INSTITUCION_DEVOLUCION")
	private int idInstitucionDevolucion;
	
	@Column(name="ID_SEDE_DEVOLUCION")
	private int idSedeDevolucion;
	
	@Column(name="NRO_VERSION_DEVOLUCION")
	private int nroVersionDevolucion;
	
	@Column(name="NRO_PERIODO_DEVOLUCION")
	private int nroPeriodoDevolucion;
	
	@Column(name="AUD_FECHA_OPERACION")
	private  Timestamp 	aud_fechaOperacion;
	 
	private VentaItem ventaItem;

	@JoinColumn(name="ID_MOTIVO_DEVOLUCION")
	private MotivoDevolucion motivoDevolucion;
	
	@Column(name="CANTIDAD_DEVUELTA")
	private int cantidadDevuelta;
	
	
	private String fechaInicio;
	private String fechaFin;
	
	
	
	public Devolucion() {
		this.setSituacion(new Situacion());
		this.setAud_usuario(new Usuario());
		this.setVentaItem(new VentaItem());
		this.setMotivoDevolucion(new MotivoDevolucion());
	}


	public int getIdDevolucion() {
		return idDevolucion;
	}

	public void setIdDevolucion(int idDevolucion) {
		this.idDevolucion = idDevolucion;
	}

	public int getIdOrganizacionDevolucion() {
		return idOrganizacionDevolucion;
	}


	public void setIdOrganizacionDevolucion(int idOrganizacionDevolucion) {
		this.idOrganizacionDevolucion = idOrganizacionDevolucion;
	}


	public int getIdInstitucionDevolucion() {
		return idInstitucionDevolucion;
	}


	public void setIdInstitucionDevolucion(int idInstitucionDevolucion) {
		this.idInstitucionDevolucion = idInstitucionDevolucion;
	}


	public int getIdSedeDevolucion() {
		return idSedeDevolucion;
	}


	public void setIdSedeDevolucion(int idSedeDevolucion) {
		this.idSedeDevolucion = idSedeDevolucion;
	}


	public int getNroVersionDevolucion() {
		return nroVersionDevolucion;
	}


	public void setNroVersionDevolucion(int nroVersionDevolucion) {
		this.nroVersionDevolucion = nroVersionDevolucion;
	}


	public int getNroPeriodoDevolucion() {
		return nroPeriodoDevolucion;
	}


	public void setNroPeriodoDevolucion(int nroPeriodoDevolucion) {
		this.nroPeriodoDevolucion = nroPeriodoDevolucion;
	}


	public VentaItem getVentaItem() {
		return ventaItem;
	}


	public void setVentaItem(VentaItem ventaItem) {
		this.ventaItem = ventaItem;
	}


	public MotivoDevolucion getMotivoDevolucion() {
		return motivoDevolucion;
	}


	public void setMotivoDevolucion(MotivoDevolucion motivoDevolucion) {
		this.motivoDevolucion = motivoDevolucion;
	}


	public int getCantidadDevuelta() {
		return cantidadDevuelta;
	}


	public void setCantidadDevuelta(int cantidadDevuelta) {
		this.cantidadDevuelta = cantidadDevuelta;
	}


	public Timestamp getAud_fechaOperacion() {
		return aud_fechaOperacion;
	}


	public void setAud_fechaOperacion(Timestamp aud_fechaOperacion) {
		this.aud_fechaOperacion = aud_fechaOperacion;
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