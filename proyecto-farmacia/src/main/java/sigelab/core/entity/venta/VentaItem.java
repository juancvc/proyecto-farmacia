package pe.com.galaxy.systems.apolo.core.entidad.entidad.venta;

import java.io.Serializable; 
import javax.persistence.EmbeddedId;
import javax.persistence.Entity; 
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table; 
import pe.com.galaxy.systems.apolo.core.entidad.entidad.stock.Articulo;
import pe.com.galaxy.systems.apolo.core.entidad.vo.general.StockVO;


@NamedStoredProcedureQueries(
		{
				@NamedStoredProcedureQuery(
						name="pedidoItem.insert", 
						procedureName="PKG_PEDIDO.SP_INSERTAR_ITEM",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="P_ID_PEDIDO_ITEM", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_ID_PEDIDO", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_ID_ARTICULO", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_CANTIDAD", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_PRECIO", type=Double.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_IMPORTE", type=Double.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_ID_STOCK", type=Double.class)
							}					
				) 
		}
	)
@Entity
@Table(name="VENTA_ITEM")
public class VentaItem implements Serializable {
	private static final long serialVersionUID = 1L;
 
	@EmbeddedId
	private VentaItemPK id;
	
	private int cantidad;

	private String estado;

	private Float importe;

	private Float precio;
 
	private Venta venta;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="ID_ARTICULO")
	private Articulo articulo;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="ID_STOCK")
	private StockVO stockVO;
	
	@ManyToOne
	@JoinColumn(name="ID_MOTIVO_DEVOLUCION")
	private MotivoDevolucion motivoDevolucion;
	
	private int restoStockSolicitado;
	
	public VentaItem() {
		this.setVenta(new Venta());
		this.setArticulo(new Articulo());
		this.setStockVO(new StockVO());
		this.setMotivoDevolucion(new MotivoDevolucion());
	}
	public MotivoDevolucion getMotivoDevolucion() {
		return motivoDevolucion;
	}

	public void setMotivoDevolucion(MotivoDevolucion motivoDevolucion) {
		this.motivoDevolucion = motivoDevolucion;
	}
 
	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Float getImporte() {
		return this.importe;
	}

	public void setImporte(Float importe) {
		this.importe = importe;
	}

	public Float getPrecio() {
		return this.precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}


	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Articulo getArticulo() {
		return this.articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public StockVO getStockVO() {
		return stockVO;
	}

	public void setStockVO(StockVO stock) {
		this.stockVO = stock;
	}

	public void ejecutarCalculos(){
		//System.out.println("this.getPrecio() "  + this.getPrecio());
		this.setImporte(this.getCantidad()* this.getPrecio());
		//System.out.println("this.getImporte() " + this.getImporte());
	}
	public void ejecutarCalculos(int resto, int stock){
		if(resto > 0){
			this.setImporte(stock * this.getPrecio());
		}else{
			this.setImporte(this.getCantidad() * this.getPrecio());
		}
	}
	public int getRestoStockSolicitado() {
		return restoStockSolicitado;
	}
	public void setRestoStockSolicitado(int restoStockSolicitado) {
		this.restoStockSolicitado = restoStockSolicitado;
	}
	
	public VentaItemPK getId() {
		if (id == null) {
			id = new VentaItemPK();
		}
		return id;
	} 

	public void setId(VentaItemPK id) {
		this.id = id;
	} 
}