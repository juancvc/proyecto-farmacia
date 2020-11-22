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

import org.bridj.cpp.com.DECIMAL;
  


@SuppressWarnings("serial")
@NamedStoredProcedureQueries(
		{
			@NamedStoredProcedureQuery(
				name="venta.insertar", 
				procedureName="[dbo].[usp_Venta_insertar]",
				resultClasses= Venta.class,
				parameters={
						    @StoredProcedureParameter(mode=ParameterMode.OUT, name="valida", 		  type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.OUT, name="nombreArticulo",  type=String.class ),
							@StoredProcedureParameter(mode=ParameterMode.OUT, name="idVenta", 		  type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.OUT, name="numeroPeriodo",   type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idPersona", 	  type=String.class),
							 
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idEvento", 		  type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idAlmacen", 	  type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="fechaAtencion",   type=String.class),
						
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idTurno", 		  type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idModalidadPago", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="tipoFinanciador", type=String.class),
					
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="cantidadItems",   type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaPeriodoStock",   type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaIdStock",   type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaCantidad",  type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaCantidadFaltante",  type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="tipoMoneda", 	  type=String.class),
							
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioRegistro", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipRegistro", 	  type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="fechaEmision", 	  type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idTipoComprobanteCat02", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idTipoOperacionCat02", 	 type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="nroSerie", 	  	  type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="codctacte", 	  type=String.class),
						    @StoredProcedureParameter(mode=ParameterMode.IN,  name="perctacte", 	  type=String.class),
						    @StoredProcedureParameter(mode=ParameterMode.IN,  name="verctacte", 	  type=String.class),
						    @StoredProcedureParameter(mode=ParameterMode.IN,  name="codepicta", 	  type=String.class),
						    @StoredProcedureParameter(mode=ParameterMode.IN,  name="perepicte", 	  type=String.class),
						    @StoredProcedureParameter(mode=ParameterMode.IN,  name="verepicte", 	  type=String.class),
						    @StoredProcedureParameter(mode=ParameterMode.IN,  name="tipoPaci", 	      type=String.class)
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
					name="venta.buscarxFechaClienteVO", 
					procedureName="SP_VENTA_BUSCAR_FECHA_CLIENTE",
					resultClasses= Venta.class,
					parameters={
					
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="nombreCliente", type=String.class),
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
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="fecha", 	type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idTurno",   type=String.class)
				}					
				),
				@NamedStoredProcedureQuery(
						name="venta.listarVentaDiariaTurno", 
						procedureName="SP_VENTA_LISTAR_VENTA_DIARIA",
						resultClasses= Venta.class,
						parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idAlmacen", 	type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="fechaAtencion", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idVenta", 	    type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idTurno", 		type=Integer.class)
				}					
				),
				@NamedStoredProcedureQuery(
						name="venta.listarVentasAnuladas", 
						procedureName="[Farmacia].[dbo].[SP_VENTA_LISTAR_VENTA_ANULADAS]",
						resultClasses= Venta.class,
						parameters={
							
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="fechaInicio", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="fechaFin",    type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="idAlmacen",    type=String.class )
				}					
				),
				@NamedStoredProcedureQuery(
						name="venta.listarVentasAnuladasIME", 
						procedureName="[Farmacia].[dbo].[SP_VENTA_LISTAR_VENTA_ANULADAS_IME]",
						resultClasses= Venta.class,
						parameters={
							
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="periodo",  type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="idAlmacen", type=String.class )
				}					
				),
				@NamedStoredProcedureQuery(
						name="venta.listarVentaDiaria", 
						procedureName="[usp_Venta_listarVentaDiaria]",
						resultClasses= Venta.class,
						parameters={ 
							@StoredProcedureParameter(mode=ParameterMode.IN, name="idAlmacen", 	  type=String.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="fechaEmisionDesde", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="fechaEmisionHasta", type=String.class),
				}
						
				),
				@NamedStoredProcedureQuery(
						name="venta.listarVentasDiariasFindByObjectPagante", 
						procedureName="[Farmacia].[dbo].[SP_VENTA_LISTAR_VENTA_DIARIA_FINDBYOBJECT_PAGANTE]",
						resultClasses= Venta.class,
						parameters={
							
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="fechaInicio", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="fechaFin", 	  type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idAlmacen",   type=String.class )
				}
						
				)
				,@NamedStoredProcedureQuery(
						name="venta.listarArticulosxIdPersona", 
						procedureName="SP_VENTA_LISTA_ARTICULOS_X_ID_PERSONA",
						resultClasses= Venta.class,
						parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipPersona", 	type=String.class)
				}					
				),
				@NamedStoredProcedureQuery(
						name="venta.listarAtencionesIME", 
						procedureName="SP_VENTA_LISTAR_VENTA_ATENCIONES_IME",
						resultClasses= Venta.class,
						parameters={
								
									@StoredProcedureParameter(mode=ParameterMode.IN, name="mes", 		type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="periodo",    type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="idAlmacen",  type=String.class) 
				}					
				),
				@NamedStoredProcedureQuery(
						name="venta.listarVentasPacienteFUA", 
						procedureName="[Farmacia].[dbo].SP_VENTA_PACIENTE_FUA",
						resultClasses= Venta.class,
						parameters={

							@StoredProcedureParameter(mode=ParameterMode.IN, name="fechaInicio", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="fechaFin", 	 type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="idAlmacen",   type=String.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="nroFua", 	 type=String.class )
				}					
				),
				@NamedStoredProcedureQuery(
						name="venta.listarItemsVentasFUA", 
						procedureName="SP_VENTA_LISTAR_ITEMS_FUA ",
						resultClasses= Venta.class,
						parameters={

							@StoredProcedureParameter(mode=ParameterMode.IN, name="idVenta", 	type=String.class), 
				}					
				),
				@NamedStoredProcedureQuery(
						name="venta.cantidadConLetra", 
						procedureName="[dbo].[CantidadConLetra]",
						resultClasses= String.class,
						parameters={

							@StoredProcedureParameter(mode=ParameterMode.IN, name="Numero", 	type=float.class), 
				}					
				),
				@NamedStoredProcedureQuery(
						name="venta.listarPacientes", 
						procedureName="[dbo].[usp_Venta_listarPacientes]",
						resultClasses= Venta.class,
						parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN, name="idSituacion", 	type=String.class), 
				}					
				),
				
				@NamedStoredProcedureQuery(
						name="venta.buscarPorNroDocumento", 
						procedureName="[dbo].[usp_Venta_buscarxNroDocumento]",
						resultClasses= Venta.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="nroSerie",  type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idVenta", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="numeroPeriodo", type=String.class)
				}					
				),
				
				@NamedStoredProcedureQuery(
						name="venta.anular", 
						procedureName="[dbo].[usp_Venta_anularVenta]",
						resultClasses= Venta.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idVenta", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="numeroPeriodo", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="numeroDocu",  type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipRegistro",  type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioRegistro",  type=String.class),
									
				}					
				),				
				@NamedStoredProcedureQuery(
						name="venta.totalVenta", 
						procedureName="[dbo].[usp_Venta_buscarxDiaMes]",
						resultClasses= Venta.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="tipoReporte", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="fechaEmision", type=Timestamp.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="mes",  type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="anio",  type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idSituacion",  type=String.class) 
				}					
				),
				@NamedStoredProcedureQuery(
						name="venta.listaMensual", 
						procedureName="[dbo].[usp_Venta_porPeriodo]",
						resultClasses= Venta.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="anio",  type=String.class)
				}					
				),
				@NamedStoredProcedureQuery(
						name="venta.reporteTipoPaciente", 
						procedureName="[dbo].[usp_Venta_reporteTiposPacientes]",
						resultClasses= Venta.class,
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="tipoReporte", type=int.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="fechaEmision", type=Timestamp.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="mes",  type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="anio",  type=String.class),
				}					
				)
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
	
	private String nombreAlmacen;
	
	private Timestamp fechaEmision;
	
	private String apellidoPaterno;

	private String apellidoMaterno;
	
	private String nroDocumento;

	private String nombres;
	
	private String tipoSeguro;
	
	private String nombreBoleta;
	
	private String numero;
	
	private String montoLetra;
	
	private String idEpisodio;
	
	private String nroSerie;
	
	private String mes;
	
	private int cantidadItems;
	
	
	public Venta() { 
	}


	public String getMes() {
		return mes;
	}


	public void setMes(String mes) {
		this.mes = mes;
	}


	public String getNroSerie() {
		return nroSerie;
	}


	public void setNroSerie(String nroSerie) {
		this.nroSerie = nroSerie;
	}


	public String getIdEpisodio() {
		return idEpisodio;
	}
	
	public void setIdEpisodio(String idEpisodio) {
		this.idEpisodio = idEpisodio;
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


	public Timestamp getFechaEmision() {
		return fechaEmision;
	}


	public void setFechaEmision(Timestamp fechaEmision) {
		this.fechaEmision = fechaEmision;
	}


	public String getNombreAlmacen() {
		return nombreAlmacen;
	}


	public void setNombreAlmacen(String nombreAlmacen) {
		this.nombreAlmacen = nombreAlmacen;
	}


	public String getApellidoPaterno() {
		return apellidoPaterno;
	}


	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getTipoSeguro() {
		return tipoSeguro;
	}

	public void setTipoSeguro(String tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}

	public String getNombreBoleta() {
		return nombreBoleta;
	}

	public void setNombreBoleta(String nombreBoleta) {
		this.nombreBoleta = nombreBoleta;
	}

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}


	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getMontoLetra() {
		return montoLetra;
	}


	public void setMontoLetra(String montoLetra) {
		this.montoLetra = montoLetra;
	}


	public int getCantidadItems() {
		return cantidadItems;
	}


	public void setCantidadItems(int cantidadItems) {
		this.cantidadItems = cantidadItems;
	}
	
}