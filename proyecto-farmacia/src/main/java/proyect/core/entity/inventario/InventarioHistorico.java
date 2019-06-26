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
						name="inventario.buscarXNroDocumento", 
						procedureName="[dbo].[usp_Inventario_buscarxNroDocumento]",
						resultClasses = InventarioHistorico.class,
						parameters={
						
								@StoredProcedureParameter(mode=ParameterMode.IN, name="idAlmacen", 	  type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="nroDocumento", type=String.class)
							}					
				),
				@NamedStoredProcedureQuery(
						name="inventario.insertHistorico", 
						procedureName="[dbo].[usp_Inventario_insertarHistorico]",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="idFarmacia", 	 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ipRegistro", 	 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="nroDocumento", 	 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="usuarioRegistro", type=String.class )
							}					
				),
				@NamedStoredProcedureQuery(
						name="inventario.validarExisteInventario", 
						procedureName="[dbo].[SP_INVENTARIO_VALIDAR_EXISTE]",
						resultClasses = InventarioHistorico.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="idAlmacen", 		 type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="nroPeriodo", 	 type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="nroMes", 		 type=String.class )
							}					
				),
				@NamedStoredProcedureQuery(
						name="inventario.findByLikeObjectVO", 
						procedureName="[dbo].[SP_INVENTARIO_BUSCAR_X_CRITERIOS]",
						resultClasses = InventarioHistorico.class,
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
public class InventarioHistorico  {
	@Id
	@Column(name="idInventario")
	private String idInventario;

	@Column(name="idAlmacen")
	private String idAlmacen;
	 
	@Column(name="idPersonalResponsable")
	private String idPersonalResponsable;
	 
	@Column(name="ID_STOCK")
	private String idStock;
	
	@Column(name="fecha")
	private String fecha;

	@Column(name="nroDocumento")
	private String nroDocumento;
	
	@Column(name="CANTIDAD")
	private int cantidad;
	
	/**@Column(name="ID_ORGANIZACION_INVENTARIO")
	private int idOrganizacionInventario;
	
	@Column(name="ID_INSTITUCION_INVENTARIO")
	private int idInstitucionInventario;
	
	@Column(name="ID_SEDE_INVENTARIO")
	private int idSedeInventario;
	
	@Column(name="nroPeriodo")
	private int nroPeriodo;
	*/
	@Column(name="nroMes")
	private int nroMes;
	
	private int cantidadItems;
	
	private String cadenaNroPeriodoStock;
	
	private String cadenaIdStock;
	
	private String cadenaCantidad;
	
	private List<Stock> stockItems;
	
	private double subtotal;

	private double total;
	
	private double precio;
	
	public InventarioHistorico() { 
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