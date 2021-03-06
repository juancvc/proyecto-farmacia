package proyect.core.entity.compra;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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

import proyect.core.entity.venta.Venta;
  


@SuppressWarnings("serial")
@NamedStoredProcedureQueries(
		{
			@NamedStoredProcedureQuery(
				name="compra.buscarPorFiltros", 
				procedureName="[dbo].[usp_Compra_buscarxCriterios]",
				resultClasses= Compra.class,
				parameters={				
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idAlmacen",  type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="fechaEmision", type=String.class)
					}					
					),
			@NamedStoredProcedureQuery(
							name="compra.findByLikeObject", 
							procedureName="[dbo].[usp_Compra_buscarxID]",
							resultClasses= Compra.class,
							parameters={
								
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idCompra", type=String.class)
					}					
					),
 
				@NamedStoredProcedureQuery(
						name="compra.devolucion", 
						procedureName="[dbo].[usp_Compra_devolucionCompra]",
						resultClasses= Compra.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaIdCompra",    type=String.class),
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
						name="compra.anular", 
						procedureName="[dbo].[usp_Compra_anularCompra]",
						resultClasses= Compra.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idCompra", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="numeroPeriodo", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="numeroDocu",  type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipRegistro",  type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioRegistro",  type=String.class),
									
				}					
				),
				@NamedStoredProcedureQuery(
						name="compra.totalCompra", 
						procedureName="[dbo].[usp_Compra_buscarxDiaMes]",
						resultClasses= Compra.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="tipoReporte", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="fechaEmision", type=Timestamp.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="mes",  type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="anio",  type=String.class)
				}					
				),
				@NamedStoredProcedureQuery(
						name="compra.insertar", 
						procedureName="[dbo].[usp_Compra_insertar]",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="idCompra",	 			 type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="cantidad", 				 type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idAlmacen",			 	 type=String.class),							
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="nroDocumento", 			 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioRegistro", 		 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipRegistro", 			 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="nroGuia", 				 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaIdArticulo", 		 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaCantidad", 		 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaLote",		     type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaPrecioCompra", 	 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaPrecioVenta", 	 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaFechaVencimiento", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaRegistroSanitario",type=String.class),

									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idProveedor", 			 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idTipoFinanciadorCat02", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idTipoSeleccionCat02",   type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idTipoDocCompraCat02", 	 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idpersona", 			 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="glosa", 				 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="fechaEmision", 			 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="macRegistro", 			 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ppa", 			 		 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="pecosa", 			 	 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="swDonacion", 			 type=String.class)
							}
							),
				@NamedStoredProcedureQuery(
						name="compra.actualizar", 
						procedureName="[dbo].[usp_Compra_actualizar]",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="idCompra",	 			 type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="numeroPeriodo", 		 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="numeroDocumento", 		 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idAlmacen",			 	 type=String.class),							
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idTipoFinanciadorCat02", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idTipoProcesoSeleccionCat02",  type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idTipoDocumentoCat02", 	 type=String.class),
									
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idSituacion", 		     type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idProveedor", 			 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="glosa", 				 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ppa", 			 		 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="pecosa", 			 	 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="importe", 			 	 type=float.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="swDonacion", 			 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="fechaEmision", 			 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioModificacion", 	 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipModificacion", 	     type=String.class)
							}
							),
		}			
	)


@Entity 
public class Compra  implements Serializable {

	@EmbeddedId
	private CompraPK id;
	
	private boolean activo;

	private Timestamp fechaAtencion;

	private Timestamp fechaRegistro;

	private String hora;

	private String idAlmacen;
 
	private String idModalidadPago;

	private String idPersona;

	private String idRegistroOperacion;

	private String idSituacion;

	private String idTipoMoneda;

	private String idTurno;

	private float importe;

	private String ipRegistro;

	private String macRegistro;

	private String registroSesion;

	private String usuarioRegistro;
	
	private String nombreAlmacen;
	
	private Timestamp fechaEmision;
	 
	private String nombreBoleta;
	
	private String numeroDocumento;
	
	private String montoLetra;
	
	private String idProveedor;
	private String nombreProveedor;  
	private String idTipoDocumentoCat02; 
	private String glosa;
	private String idTipoFinanciadorCat02;
	private String idTipoProcesoSeleccionCat02; 
	private String tipoDocumento;
	private String ppa;
	private String pecosa;
	private String swDonacion;  
	
	public Compra() { 
	}


	public CompraPK getId() {
		return id;
	}


	public void setId(CompraPK id) {
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

	public String getNombreAlmacen() {
		return nombreAlmacen;
	}

	public void setNombreAlmacen(String nombreAlmacen) {
		this.nombreAlmacen = nombreAlmacen;
	}

	public Timestamp getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Timestamp fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public String getNombreBoleta() {
		return nombreBoleta;
	}

	public void setNombreBoleta(String nombreBoleta) {
		this.nombreBoleta = nombreBoleta;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getMontoLetra() {
		return montoLetra;
	}

	public void setMontoLetra(String montoLetra) {
		this.montoLetra = montoLetra;
	}

	public String getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(String idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public String getIdTipoDocumentoCat02() {
		return idTipoDocumentoCat02;
	}

	public void setIdTipoDocumentoCat02(String idTipoDocumentoCat02) {
		this.idTipoDocumentoCat02 = idTipoDocumentoCat02;
	}

	public String getGlosa() {
		return glosa;
	}

	public void setGlosa(String glosa) {
		this.glosa = glosa;
	}

	public String getIdTipoFinanciadorCat02() {
		return idTipoFinanciadorCat02;
	}

	public void setIdTipoFinanciadorCat02(String idTipoFinanciadorCat02) {
		this.idTipoFinanciadorCat02 = idTipoFinanciadorCat02;
	}

	public String getIdTipoProcesoSeleccionCat02() {
		return idTipoProcesoSeleccionCat02;
	}

	public void setIdTipoProcesoSeleccionCat02(String idTipoProcesoSeleccionCat02) {
		this.idTipoProcesoSeleccionCat02 = idTipoProcesoSeleccionCat02;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getPpa() {
		return ppa;
	}

	public void setPpa(String ppa) {
		this.ppa = ppa;
	}

	public String getPecosa() {
		return pecosa;
	}

	public void setPecosa(String pecosa) {
		this.pecosa = pecosa;
	}

	public String getSwDonacion() {
		return swDonacion;
	}

	public void setSwDonacion(String swDonacion) {
		this.swDonacion = swDonacion;
	}

 
}