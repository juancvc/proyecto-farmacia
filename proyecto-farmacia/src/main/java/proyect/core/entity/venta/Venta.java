package proyect.core.entity.venta;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList; 
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity; 
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
  


@SuppressWarnings("serial")
@NamedStoredProcedureQueries(
		{
			@NamedStoredProcedureQuery(
				name="venta.insertVenta", 
				procedureName="[dbo].[usp_Venta_insertar]",
				resultClasses= Venta.class,
				parameters={
						    @StoredProcedureParameter(mode=ParameterMode.OUT, name="valida", 		  type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.OUT, name="nombreArticulo",  type=String.class ),
							@StoredProcedureParameter(mode=ParameterMode.OUT, name="idVenta", 		  type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipPersona", 	  type=String.class),
							 
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idEvento", 		  type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idAlmacen", 	  type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="fechaAtencion",   type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioRegistro", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idTurno", 		  type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idModalidadPago", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="tipoSeguro",	  type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipRegistro", 	  type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="cantidadItems",   type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaIdStock",   type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaCantidad",  type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="tipoMoneda", 	  type=String.class)
					}
					),
		
			@NamedStoredProcedureQuery(
				name="venta.findByLikeObjectVO", 
				procedureName="[dbo].[usp_Venta_buscarxCriterios]",
				resultClasses= Venta.class,
				parameters={
				
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idVenta",  type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idEvento", type=String.class)
					}					
					),
			@NamedStoredProcedureQuery(
							name="venta.findByLikeObject", 
							procedureName="[dbo].[usp_Venta_buscarxID]",
							resultClasses= Venta.class,
							parameters={
								
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idVenta", type=String.class)
					}					
					),
					
					@NamedStoredProcedureQuery(
							name="ventaItem.findByLikeObjectDIARIOS", 
							procedureName="[dbo].[usp_Venta_listaVentaItemxIdVentaDiarios]",
							resultClasses= Venta.class,
							parameters={
						
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idVenta",      type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="fechaAtencion", type=String.class )
					}					
					),
						@NamedStoredProcedureQuery(
							name="venta.findByLikeObjectDIARIOS", 
							procedureName="[dbo].[usp_Venta_listarVentaDiaria]",
							resultClasses= Venta.class,
							parameters={
						
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idVenta",	    type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="fechaRegistro", type=String.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idTurno", 		type=String.class )
					}					
					),
					
					 
			@NamedStoredProcedureQuery(
							name="venta.anular", 
							procedureName="[dbo].[usp_Venta_anularVenta]",
							resultClasses= Venta.class,
							parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idVenta",    	  type=String.class),								
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipRegistro",      type=String.class),					
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioRegistro", type=String.class)
					}					
					),
			@NamedStoredProcedureQuery(
					name="venta.buscarxFechaClienteVO", 
					procedureName="SP_VENTA_BUSCAR_FECHA_CLIENTE",
					resultClasses= Venta.class,
					parameters={
					
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_CLIENTE", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="fechaAtencion",  type=String.class)
				}					
				),
				@NamedStoredProcedureQuery(
						name="venta.findByObjectVO", 
						procedureName="[dbo].[usp_Venta_listaVentaItemxIdVenta]",
						resultClasses= Venta.class,
						parameters={
						
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idVenta", type=String.class)
				}					
				),
				@NamedStoredProcedureQuery(
						name="venta.buscarArticulosxIdVenta", 
						procedureName="[dbo].[usp_Venta_listarArticulosVentaID]",
						resultClasses= Venta.class,
						parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idVenta", type=String.class)
				}					
				),
				@NamedStoredProcedureQuery(
						name="venta.buscarArticulosxIdEvento", 
						procedureName="[dbo].[usp_Venta_listaArticulosxIdEvento]",
						resultClasses= Venta.class,
						parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idEvento", type=String.class)
				}					
				),
				@NamedStoredProcedureQuery(
						name="venta.devolucion", 
						procedureName="[dbo].[usp_Venta_devolucionVenta]",
						resultClasses= Venta.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaIdVenta",    type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idAlmacen",        type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="fechaAtencion",    type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="cantidadItems",    type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaIdArticulo", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaIdLote", 	   type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaCantidad",   type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipRegistro", 	   type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioRegistro",  type=String.class)
				}					
				),
				@NamedStoredProcedureQuery(
						name="venta.findByIdVenta", 
						procedureName="[dbo].[usp_Venta_buscarxID]",
						resultClasses= Venta.class,
						parameters={
					    @StoredProcedureParameter(mode=ParameterMode.IN,  name="idVenta", type=String.class)
				}					
				),
				@NamedStoredProcedureQuery(
						name="venta.cierreVentaDiariaTurno", 
						procedureName="SP_VENTA_CIERRE_VENTA_DIARIA",
						resultClasses= Venta.class,
						parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idAlmacen", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="FECHA", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idTurno", type=Integer.class)
				}					
				),
				@NamedStoredProcedureQuery(
						name="venta.listarVentaDiariaTurno", 
						procedureName="SP_VENTA_LISTAR_VENTA_DIARIA",
						resultClasses= Venta.class,
						parameters={
						//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idAlmacen", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="fechaAtencion", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idVenta", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idTurno", type=Integer.class)
				}					
				),
				@NamedStoredProcedureQuery(
						name="venta.listarVentasAnuladas", 
						procedureName="[Farmacia].[dbo].[SP_VENTA_LISTAR_VENTA_ANULADAS]",
						resultClasses= Venta.class,
						parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="FECHA_INICIO", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="FECHA_FIN", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="idAlmacen", type=int.class )
				}					
				),
				@NamedStoredProcedureQuery(
						name="venta.listarVentasAnuladasIME", 
						procedureName="[Farmacia].[dbo].[SP_VENTA_LISTAR_VENTA_ANULADAS_IME]",
						resultClasses= Venta.class,
						parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="MES", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="PERIODO", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="idAlmacen", type=int.class )
				}					
				),
				@NamedStoredProcedureQuery(
						name="venta.listarVentasDiariasFindByObject", 
						procedureName="[Farmacia].[dbo].[SP_VENTA_LISTAR_VENTA_DIARIA_FINDBYOBJECT]",
						resultClasses= Venta.class,
						parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="FECHA_INICIO", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="FECHA_FIN", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="idAlmacen", type=int.class )
				}
						
				),
				@NamedStoredProcedureQuery(
						name="venta.listarVentasDiariasFindByObjectPagante", 
						procedureName="[Farmacia].[dbo].[SP_VENTA_LISTAR_VENTA_DIARIA_FINDBYOBJECT_PAGANTE]",
						resultClasses= Venta.class,
						parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="FECHA_INICIO", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="FECHA_FIN", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="idAlmacen", type=int.class )
				}
						
				)
				,@NamedStoredProcedureQuery(
						name="venta.listarArticulosxIdPersona", 
						procedureName="SP_VENTA_LISTA_ARTICULOS_X_ID_PERSONA",
						resultClasses= Venta.class,
						parameters={
							//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipPersona", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION_PERSONA", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION_PERSONA", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE_PERSONA", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO_PERSONA", type=int.class )
				}					
				),
				@NamedStoredProcedureQuery(
						name="venta.listarAtencionesIME", 
						procedureName="SP_VENTA_LISTAR_VENTA_ATENCIONES_IME",
						resultClasses= Venta.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="MES", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="PERIODO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="idAlmacen", type=int.class) 
				}					
				),
				@NamedStoredProcedureQuery(
						name="venta.listarVentasPacienteFUA", 
						procedureName="[Farmacia].[dbo].SP_VENTA_PACIENTE_FUA",
						resultClasses= Venta.class,
						parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="FECHA_INICIO", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="FECHA_FIN", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="idAlmacen", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="NROFUA", type=String.class )
				}					
				),
				@NamedStoredProcedureQuery(
						name="venta.listarItemsVentasFUA", 
						procedureName="SP_VENTA_LISTAR_ITEMS_FUA ",
						resultClasses= Venta.class,
						parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION_VENTA", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION_VENTA", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE_VENTA", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO_VENTA", type=int.class),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="idVenta", type=int.class), 
				}					
				),
		}			
	)


@Entity 
public class Venta  implements Serializable {

	@EmbeddedId
	private VentaPK id;
	
	private boolean activo;

	private Timestamp fechaAtencion;

	private Timestamp fechaRegistro;

	private String hora;

	private String idAlmacen;

	private String idEvento;

	private String idModalidadPago;

	private String idPersona;

	private String idRegistroOperacion;

	private String idSituacion;

	private String idTipoMoneda;

	private String idTipoSeguro;

	private String idTurno;

	private float importe;

	private String ipRegistro;

	private String macRegistro;

	private String registroSesion;

	private String usuarioRegistro;
	
    
	public Venta() { 
	}


	public VentaPK getId() {
		return id;
	}


	public void setId(VentaPK id) {
		this.id = id;
	}


	public boolean isActivo() {
		return activo;
	}


	public void setActivo(boolean activo) {
		this.activo = activo;
	}


	public Timestamp getFechaAtencion() {
		return fechaAtencion;
	}


	public void setFechaAtencion(Timestamp fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}


	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	public String getHora() {
		return hora;
	}


	public void setHora(String hora) {
		this.hora = hora;
	}


	public String getIdAlmacen() {
		return idAlmacen;
	}


	public void setIdAlmacen(String idAlmacen) {
		this.idAlmacen = idAlmacen;
	}


	public String getIdEvento() {
		return idEvento;
	}


	public void setIdEvento(String idEvento) {
		this.idEvento = idEvento;
	}


	public String getIdModalidadPago() {
		return idModalidadPago;
	}


	public void setIdModalidadPago(String idModalidadPago) {
		this.idModalidadPago = idModalidadPago;
	}


	public String getIdPersona() {
		return idPersona;
	}


	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}


	public String getIdRegistroOperacion() {
		return idRegistroOperacion;
	}


	public void setIdRegistroOperacion(String idRegistroOperacion) {
		this.idRegistroOperacion = idRegistroOperacion;
	}


	public String getIdSituacion() {
		return idSituacion;
	}


	public void setIdSituacion(String idSituacion) {
		this.idSituacion = idSituacion;
	}


	public String getIdTipoMoneda() {
		return idTipoMoneda;
	}


	public void setIdTipoMoneda(String idTipoMoneda) {
		this.idTipoMoneda = idTipoMoneda;
	}


	public String getIdTipoSeguro() {
		return idTipoSeguro;
	}


	public void setIdTipoSeguro(String idTipoSeguro) {
		this.idTipoSeguro = idTipoSeguro;
	}


	public String getIdTurno() {
		return idTurno;
	}


	public void setIdTurno(String idTurno) {
		this.idTurno = idTurno;
	}


	public float getImporte() {
		return importe;
	}


	public void setImporte(float importe) {
		this.importe = importe;
	}


	public String getIpRegistro() {
		return ipRegistro;
	}


	public void setIpRegistro(String ipRegistro) {
		this.ipRegistro = ipRegistro;
	}


	public String getMacRegistro() {
		return macRegistro;
	}


	public void setMacRegistro(String macRegistro) {
		this.macRegistro = macRegistro;
	}


	public String getRegistroSesion() {
		return registroSesion;
	}


	public void setRegistroSesion(String registroSesion) {
		this.registroSesion = registroSesion;
	}


	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}


	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}


 
}