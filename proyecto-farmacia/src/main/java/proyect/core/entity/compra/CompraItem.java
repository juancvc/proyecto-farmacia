package  proyect.core.entity.compra;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;  
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
 

@NamedStoredProcedureQueries(
		{
				@NamedStoredProcedureQuery(
						name="compraItem.buscarPorCriterios", 
						procedureName="[dbo].[usp_Venta_listaCompraItemxidCompra]",
						resultClasses= CompraItem.class,
						parameters={
								    @StoredProcedureParameter(mode=ParameterMode.IN,  name="idCompra",  type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="numeroPeriodo", type=String.class)
							}					
				),
				
				@NamedStoredProcedureQuery(
						name="compraItem.buscarPorEpisodio", 
						procedureName="[dbo].usp_Venta_listarPorIdEpisodio",
						resultClasses= CompraItem.class,
						parameters={
								    @StoredProcedureParameter(mode=ParameterMode.IN,  name="idEpisodio", type=String.class)
							}					
				),
				
				@NamedStoredProcedureQuery(
						name="compraItem.listarConsumoPaciente", 
						procedureName="[dbo].usp_Venta_listarConsumoPaciente",
						resultClasses= CompraItem.class,
						parameters={
								    @StoredProcedureParameter(mode=ParameterMode.IN,  name="idPersona", type=String.class)
							}					
				) 
		}
	)

@Entity 
public class CompraItem implements Serializable {
	private static final long serialVersionUID = 1L;
 
	@EmbeddedId
	private CompraItemPK id;

	private String idCompra;
	
	private String idPersona;
	
	private String nombreArticulo;
	
	private String descripcionCortaPresentacion;
	
	private boolean activo;

	private int cantidad;

	private int cantidadConsumida;

	private Timestamp fechaModificacion;

	private Timestamp fechaRegistro;

	private String flagEstado;

	private String idModAdquisicion;

	private String idSituacion;

	private String idStock;

	private String ipModificacion;

	private String ipRegistro;

	private String ipRegistro1;

	private String macRegistro;

	private float precio;

	private float subtotal;

	private String usuarioModificacion;

	private String usuarioRegistro;
	
	private int restoStockSolicitado;
	 
	private String idEpisodio;
	
	private Timestamp fechaEmision;
	
	private String numero;
	
	private String idTipoSeguro;
	
	private String tipoSeguro;
	
	public CompraItem() { 
	}

	
	public String getIdTipoSeguro() {
		return idTipoSeguro;
	}


	public void setIdTipoSeguro(String idTipoSeguro) {
		this.idTipoSeguro = idTipoSeguro;
	}


	public String getTipoSeguro() {
		return tipoSeguro;
	}


	public void setTipoSeguro(String tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}


	public Timestamp getFechaEmision() {
		return fechaEmision;
	}


	public void setFechaEmision(Timestamp fechaEmision) {
		this.fechaEmision = fechaEmision;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(String idCompra) {
		this.idCompra = idCompra;
	}

	public String getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombreArticulo() {
		return nombreArticulo;
	}

	public void setNombreArticulo(String nombreArticulo) {
		this.nombreArticulo = nombreArticulo;
	}

	public String getDescripcionCortaPresentacion() {
		return descripcionCortaPresentacion;
	}

	public void setDescripcionCortaPresentacion(String descripcionCortaPresentacion) {
		this.descripcionCortaPresentacion = descripcionCortaPresentacion;
	}
 
	public CompraItemPK getId() {
		return id;
	}

	public void setId(CompraItemPK id) {
		this.id = id;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getCantidadConsumida() {
		return cantidadConsumida;
	}

	public void setCantidadConsumida(int cantidadConsumida) {
		this.cantidadConsumida = cantidadConsumida;
	}

	public Timestamp getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getFlagEstado() {
		return flagEstado;
	}

	public void setFlagEstado(String flagEstado) {
		this.flagEstado = flagEstado;
	}

	public String getIdModAdquisicion() {
		return idModAdquisicion;
	}

	public void setIdModAdquisicion(String idModAdquisicion) {
		this.idModAdquisicion = idModAdquisicion;
	}

	public String getIdSituacion() {
		return idSituacion;
	}

	public void setIdSituacion(String idSituacion) {
		this.idSituacion = idSituacion;
	}

	public String getIdStock() {
		return idStock;
	}

	public void setIdStock(String idStock) {
		this.idStock = idStock;
	}

	public String getIpModificacion() {
		return ipModificacion;
	}

	public void setIpModificacion(String ipModificacion) {
		this.ipModificacion = ipModificacion;
	}

	public String getIpRegistro() {
		return ipRegistro;
	}

	public void setIpRegistro(String ipRegistro) {
		this.ipRegistro = ipRegistro;
	}

	public String getIpRegistro1() {
		return ipRegistro1;
	}

	public void setIpRegistro1(String ipRegistro1) {
		this.ipRegistro1 = ipRegistro1;
	}

	public String getMacRegistro() {
		return macRegistro;
	}

	public void setMacRegistro(String macRegistro) {
		this.macRegistro = macRegistro;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public int getRestoStockSolicitado() {
		return restoStockSolicitado;
	}

	public void setRestoStockSolicitado(int restoStockSolicitado) {
		this.restoStockSolicitado = restoStockSolicitado;
	}

	public String getIdEpisodio() {
		return idEpisodio;
	}

	public void setIdEpisodio(String idEpisodio) {
		this.idEpisodio = idEpisodio;
	}

}