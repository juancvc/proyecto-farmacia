package proyect.core.bean.stock;

import java.util.Date;

import proyect.base.bean.BaseBean;
import proyect.core.bean.general.AlmacenBean;
import proyect.core.bean.general.CatalogoBean;

public class StockBean extends BaseBean {

	private AlmacenBean almacen;
	private ArticuloBean articulo;
	private int stock;
	private String lote;
	private float precioCompra;
	private float precioVenta;
	private Date fechaVencimiento;
	private CatalogoBean modalidadAdquision;
	private CatalogoBean tipoFinanciador;
	private CatalogoBean tipoSeleccion;
	private String nroRegistroSanitario;
	private ProveedorBean proveedorBean;
	private String tipoLlamada;
	private String sPrecio;
	private int diasVencimiento;

	public int getDiasVencimiento() {
		return diasVencimiento;
	}

	public void setDiasVencimiento(int diasVencimiento) {
		this.diasVencimiento = diasVencimiento;
	}

	public AlmacenBean getAlmacen() {
		if (almacen == null) {
			almacen = new AlmacenBean();
		}
		return almacen;
	}

	public void setAlmacen(AlmacenBean almacenBean) {
		this.almacen = almacenBean;
	}

	public String getsPrecio() {
		return sPrecio;
	}

	public void setsPrecio(String sPrecio) {
		this.sPrecio = sPrecio;
	}

	public ArticuloBean getArticulo() {
		if (articulo == null) {
			articulo = new ArticuloBean();
		}
		return articulo;
	}

	public void setArticulo(ArticuloBean articuloBean) {
		this.articulo = articuloBean;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public float getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(float precioCompra) {
		this.precioCompra = precioCompra;
	}

	public float getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public Date setFechaVencimiento(Date fechaVencimiento) {
		return this.fechaVencimiento = fechaVencimiento;
	}

	public CatalogoBean getModalidadAdquision() {
		if (modalidadAdquision == null) {
			modalidadAdquision = new CatalogoBean();
		}
		return modalidadAdquision;
	}

	public void setModalidadAdquision(CatalogoBean modalidadAdquision) {
		this.modalidadAdquision = modalidadAdquision;
	}

	public CatalogoBean getTipoFinanciador() {
		if (tipoFinanciador == null) {
			tipoFinanciador = new CatalogoBean();
		}
		return tipoFinanciador;
	}

	public void setTipoFinanciador(CatalogoBean tipoFinanciador) {
		this.tipoFinanciador = tipoFinanciador;
	}

	public CatalogoBean getTipoSeleccion() {
		if (tipoSeleccion == null) {
			tipoSeleccion = new CatalogoBean();
		}
		return tipoSeleccion;
	}

	public void setTipoSeleccion(CatalogoBean tipoSeleccion) {
		this.tipoSeleccion = tipoSeleccion;
	}

	public String getNroRegistroSanitario() {
		return nroRegistroSanitario;
	}

	public void setNroRegistroSanitario(String nroRegistroSanitario) {
		this.nroRegistroSanitario = nroRegistroSanitario;
	}

	public ProveedorBean getProveedorBean() {
		return proveedorBean;
	}

	public void setProveedorBean(ProveedorBean proveedorBean) {
		this.proveedorBean = proveedorBean;
	}

	public String getTipoLlamada() {
		return tipoLlamada;
	}

	public void setTipoLlamada(String tipoLlamada) {
		this.tipoLlamada = tipoLlamada;
	}

}
