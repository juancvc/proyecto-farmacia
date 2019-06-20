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
						name="inventario.insert", 
						procedureName="SP_INVENTARIO_INSERTAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="ID_INVENTARIO", type=Integer.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_MES", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_FARMACIA", type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="CANT_ITEMS", type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="CADENA_CANTIDAD", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_DOC", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="COD_PERSONAL_RESPONSABLE", type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="FECHA", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SITUACION", type=Integer.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_USUARIO", type=Integer.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_IP", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_SESSION", type=String.class),
									//@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_OPERACION", type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="CADENA_NRO_PERIODO_STOCK", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="CADENA_ID_STOCK", type=String.class),
									
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_MAC", type=String.class)
							}					
				),
				@NamedStoredProcedureQuery(
						name="inventario.buscarXNroDocumento", 
						procedureName="SP_INVENTARIO_BUSCAR_X_NRO_DOCUMENTO",
						resultClasses = Inventario.class,
						parameters={
							//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ALMACEN", type=Integer.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_DOC", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class )
							}					
				),
				@NamedStoredProcedureQuery(
						name="inventario.insertHistorico", 
						procedureName="SP_INVENTARIO_INSERTAR_HISTORICO",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_FARMACIA", type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_SESSION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_IP", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_DOC", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_USUARIO", type=Integer.class )
							}					
				),
				@NamedStoredProcedureQuery(
						name="inventario.validarExisteInventario", 
						procedureName="[dbo].[SP_INVENTARIO_VALIDAR_EXISTE]",
						resultClasses = Inventario.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ALMACEN", type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_MES", type=int.class )
							}					
				),
				@NamedStoredProcedureQuery(
						name="inventario.findByLikeObjectVO", 
						procedureName="[dbo].[SP_INVENTARIO_BUSCAR_X_CRITERIOS]",
						resultClasses = Inventario.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ALMACEN", type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_MES", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SITUACION", type=int.class )
							}					
				)
		}
	)
@Entity
public class Inventario  {
	@Id
	@Column(name="ID_INVENTARIO")
	private String idInventario;

	@Column(name="ID_ALMACEN")
	private String idAlmacen;
	 
	@Column(name="COD_PERSONAL_RESPONSABLE")
	private String idPersonalResponsable;
	 
	@Column(name="ID_STOCK")
	private String idStock;
	
	@Column(name="FECHA")
	private String fecha;

	@Column(name="NRO_DOC")
	private String nroDocumento;
	
	@Column(name="CANTIDAD")
	private int cantidad;
	
	/**@Column(name="ID_ORGANIZACION_INVENTARIO")
	private int idOrganizacionInventario;
	
	@Column(name="ID_INSTITUCION_INVENTARIO")
	private int idInstitucionInventario;
	
	@Column(name="ID_SEDE_INVENTARIO")
	private int idSedeInventario;
	
	@Column(name="NRO_PERIODO")
	private int nroPeriodo;
	*/
	@Column(name="NRO_MES")
	private int nroMes;
	
	private int cantidadItems;
	
	private String cadenaNroPeriodoStock;
	
	private String cadenaIdStock;
	
	private String cadenaCantidad;
	
	private List<Stock> stockItems;
	
	private double subtotal;

	private double total;
	
	private double precio;
	
	public Inventario() { 
	}

	public Stock removeStockItem(Stock stockItem) {
		getStockItems().remove(stockItem);

		return stockItem;
	}
	public Stock addStockItem(Stock stock) {
		this.getStockItems().add(stock);

		return stock;
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


	public int getCantidadItems() {
		return cantidadItems;
	}


	public void setCantidadItems(int cantidadItems) {
		this.cantidadItems = cantidadItems;
	}


	public String getCadenaIdStock() {
		return cadenaIdStock;
	}


	public void setCadenaIdStock(String cadenaIdStock) {
		this.cadenaIdStock = cadenaIdStock;
	}


	public String getCadenaCantidad() {
		return cadenaCantidad;
	}


	public void setCadenaCantidad(String cadenaCantidad) {
		this.cadenaCantidad = cadenaCantidad;
	}
 

	public List<Stock> getStockItems() {
		return stockItems;
	}


	public void setStockItems(List<Stock> stockItems) {
		this.stockItems = stockItems;
	}
 

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

 

	public int getNroMes() {
		return nroMes;
	}

	public void setNroMes(int nroMes) {
		this.nroMes = nroMes;
	}

	public void ejecutarCalculosSubTotal(){ 
		//this.setSubtotal(this.getStock().getStock() * this.getPrecio());
	}
	
	public void ejecutarCalculosTotal(){
		Double tmpImporte=0.0;
		for (Stock StockItem : stockItems) {
			tmpImporte+=StockItem.getPrecioVenta();
		}
		this.setTotal(tmpImporte);
	}

	public String getCadenaNroPeriodoStock() {
		return cadenaNroPeriodoStock;
	}

	public void setCadenaNroPeriodoStock(String cadenaNroPeriodoStock) {
		this.cadenaNroPeriodoStock = cadenaNroPeriodoStock;
	}

	public String getIdInventario() {
		return idInventario;
	}

	public void setIdInventario(String idInventario) {
		this.idInventario = idInventario;
	}

	public String getIdAlmacen() {
		return idAlmacen;
	}

	public void setIdAlmacen(String idAlmacen) {
		this.idAlmacen = idAlmacen;
	}

	public String getIdPersonalResponsable() {
		return idPersonalResponsable;
	}

	public void setIdPersonalResponsable(String idPersonalResponsable) {
		this.idPersonalResponsable = idPersonalResponsable;
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

	 
}