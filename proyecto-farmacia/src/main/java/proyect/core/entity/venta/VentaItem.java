package  proyect.core.entity.venta;

import java.io.Serializable;

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
 
	@Column(name="ID_ARTICULO")
	private String idArticulo;
 
	@Column(name="ID_STOCK")
	private String idStock;
	
	@Column(name="ID_MOTIVO_DEVOLUCION")
	private String idMotivoDevolucion;
	
	private int restoStockSolicitado;
	
	public VentaItem() { 
	}

	public VentaItemPK getId() {
		return id;
	}

	public void setId(VentaItemPK id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Float getImporte() {
		return importe;
	}

	public void setImporte(Float importe) {
		this.importe = importe;
	}

	public Float getPrecio() {
		return precio;
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

	 
	public String getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(String idArticulo) {
		this.idArticulo = idArticulo;
	}

	public String getIdStock() {
		return idStock;
	}

	public void setIdStock(String idStock) {
		this.idStock = idStock;
	}

	public String getIdMotivoDevolucion() {
		return idMotivoDevolucion;
	}

	public void setIdMotivoDevolucion(String idMotivoDevolucion) {
		this.idMotivoDevolucion = idMotivoDevolucion;
	}

	public int getRestoStockSolicitado() {
		return restoStockSolicitado;
	}

	public void setRestoStockSolicitado(int restoStockSolicitado) {
		this.restoStockSolicitado = restoStockSolicitado;
	}
	
	 
}