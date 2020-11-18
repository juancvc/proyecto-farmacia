package proyect.core.bean.movimiento;

import java.util.Date;
import java.util.List;
import proyect.base.bean.BaseBean;
import proyect.core.bean.general.AlmacenBean;
import proyect.core.bean.general.CatalogoBean;
import proyect.core.bean.general.PersonaBean;
import proyect.core.bean.inventario.InventarioBean;
import proyect.core.bean.stock.ArticuloBean;
import proyect.core.bean.stock.StockBean; 

public class MovimientoAlmacenBean extends BaseBean {

	
	private String idMovimientoAlmacen;
	private int cantidad;
	private String  nroDocumento;
	private int monto;
	private int saldo;
	private String orden;
	private double precio;
	private String nroGuia;
	private String glosa;
	private String sFechaMovimiento;
	private String tipoIngresoDocumento;
	private StockBean stockBean;
	private ArticuloBean articuloBean;
	private TipoMovimientoBean tipoMovimiento;
	private  String almacenOrigen;
	private  String almacenDestino;
	private CatalogoBean    tipoFinanciador;
	private CatalogoBean    tipoSeleccion;	
	private CatalogoBean    tipoDocumentoCompra;	
	private PersonaBean persona;
	private CatalogoBean mes;
	private CatalogoBean periodo;
	private Date fechaOrden;
	private String id_concepto;
	private List<StockBean> stockBeanItems;
	private List<MovimientoAlmacenBean> movimientoAlmacenBeanItems; 
	private String cadenaCantdArt;
	private String cadenaNroPeriodoStock;
	private String cadenaIdStock;
	private double subtotal;
	private double total;
	private AlmacenBean almacenBean;
	private InventarioBean inventarioBean;
	private Date fechaInventarioSig;
	private Date fechaMovimiento;
	
	private List<MovimientoAlmacenBean> abastecimientos;
	
	public String getIdMovimientoAlmacen() {
		return idMovimientoAlmacen;
	}
	public void setIdMovimientoAlmacen(String idMovimientoAlmacen) {
		this.idMovimientoAlmacen = idMovimientoAlmacen;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getNroDocumento() {
		return nroDocumento;
	}
	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}
	public int getMonto() {
		return monto;
	}
	public void setMonto(int monto) {
		this.monto = monto;
	}
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	public String getOrden() {
		return orden;
	}
	public void setOrden(String orden) {
		this.orden = orden;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getNroGuia() {
		return nroGuia;
	}
	public void setNroGuia(String nroGuia) {
		this.nroGuia = nroGuia;
	}
	public String getGlosa() {
		return glosa;
	}
	public void setGlosa(String glosa) {
		this.glosa = glosa;
	}
	public String getsFechaMovimiento() {
		return sFechaMovimiento;
	}
	public void setsFechaMovimiento(String sFechaMovimiento) {
		this.sFechaMovimiento = sFechaMovimiento;
	}
	public Date getFechaMovimiento() {
		return fechaMovimiento;
	}
	public void setFechaMovimiento(Date fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}
	public String getTipoIngresoDocumento() {
		return tipoIngresoDocumento;
	}
	public void setTipoIngresoDocumento(String tipoIngresoDocumento) {
		this.tipoIngresoDocumento = tipoIngresoDocumento;
	}
	
	public String getAlmacenOrigen() {
		return almacenOrigen;
	}
	public void setAlmacenOrigen(String almacenOrigen) {
		this.almacenOrigen = almacenOrigen;
	}
	public String getAlmacenDestino() {
		return almacenDestino;
	}
	public void setAlmacenDestino(String almacenDestino) {
		this.almacenDestino = almacenDestino;
	}
	
	
	public CatalogoBean getMes() {
		if (mes == null) {
			mes = new CatalogoBean();
		}
		return mes;
	}
	public void setMes(CatalogoBean mes) {
		this.mes = mes;
	}
	public CatalogoBean getPeriodo() {
		if (periodo == null) {
			periodo = new CatalogoBean();
		}
		return periodo;
	}
	public void setPeriodo(CatalogoBean periodo) {
		this.periodo = periodo;
	}
	public Date getFechaOrden() {
		return fechaOrden;
	}
	public void setFechaOrden(Date fechaOrden) {
		this.fechaOrden = fechaOrden;
	}
	public String getId_concepto() {
		return id_concepto;
	}
	public void setId_concepto(String id_concepto) {
		this.id_concepto = id_concepto;
	}
	
	public String getCadenaCantdArt() {
		return cadenaCantdArt;
	}
	public void setCadenaCantdArt(String cadenaCantdArt) {
		this.cadenaCantdArt = cadenaCantdArt;
	}
	public String getCadenaNroPeriodoStock() {
		return cadenaNroPeriodoStock;
	}
	public void setCadenaNroPeriodoStock(String cadenaNroPeriodoStock) {
		this.cadenaNroPeriodoStock = cadenaNroPeriodoStock;
	}
	public String getCadenaIdStock() {
		return cadenaIdStock;
	}
	public void setCadenaIdStock(String cadenaIdStock) {
		this.cadenaIdStock = cadenaIdStock;
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
	
	public Date getFechaInventarioSig() {
		return fechaInventarioSig;
	}
	public void setFechaInventarioSig(Date fechaInventarioSig) {
		this.fechaInventarioSig = fechaInventarioSig;
	}
	public StockBean getStockBean() {
		if (stockBean == null) {
			stockBean = new StockBean();
		}
		return stockBean;
	}
	public void setStockBean(StockBean stockBean) {
		this.stockBean = stockBean;
	}
	public TipoMovimientoBean gettipoMovimiento() {
		if (tipoMovimiento == null) {
			tipoMovimiento = new TipoMovimientoBean();
		}
		return tipoMovimiento;
	}
	public void settipoMovimiento(TipoMovimientoBean tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	public CatalogoBean getTipoFinanciador() {
		return tipoFinanciador;
	}
	public void setTipoFinanciador(CatalogoBean tipoFinanciador) {
		this.tipoFinanciador = tipoFinanciador;
	}
	public CatalogoBean getTipoSeleccion() {
		return tipoSeleccion;
	}
	public void setTipoSeleccion(CatalogoBean tipoSeleccion) {
		this.tipoSeleccion = tipoSeleccion;
	}
	public CatalogoBean getTipoDocumentoCompra() {
		return tipoDocumentoCompra;
	}
	public void setTipoDocumentoCompra(CatalogoBean tipoDocumentoCompra) {
		this.tipoDocumentoCompra = tipoDocumentoCompra;
	}
	public PersonaBean getPersona() {
		if (persona == null) {
			persona = new PersonaBean();
		}
		return persona;
	}
	public void setPersona(PersonaBean persona) {
		this.persona = persona;
	}
	public List<StockBean> getStockBeanItems() {
		return stockBeanItems;
	}
	public void setStockBeanItems(List<StockBean> stockBeanItems) {
		this.stockBeanItems = stockBeanItems;
	}
	public List<MovimientoAlmacenBean> getMovimientoAlmacenBeanItems() {
		return movimientoAlmacenBeanItems;
	}
	public void setMovimientoAlmacenBeanItems(List<MovimientoAlmacenBean> movimientoAlmacenBeanItems) {
		this.movimientoAlmacenBeanItems = movimientoAlmacenBeanItems;
	}
	public AlmacenBean getAlmacenBean() {
		if (almacenBean == null) {
			almacenBean = new AlmacenBean();
		}
		return almacenBean;
	}
	public void setAlmacenBean(AlmacenBean almacenBean) {
		this.almacenBean = almacenBean;
	}
	public InventarioBean getInventarioBean() {
		if (inventarioBean == new InventarioBean()) {
			inventarioBean = new InventarioBean();
		}
		return inventarioBean;
	}
	public void setInventarioBean(InventarioBean inventarioBean) {
		this.inventarioBean = inventarioBean;
	}
	public List<MovimientoAlmacenBean> getAbastecimientos() {
		return abastecimientos;
	}
	public void setAbastecimientos(List<MovimientoAlmacenBean> abastecimientos) {
		this.abastecimientos = abastecimientos;
	}
	public ArticuloBean getArticuloBean() {
		if (articuloBean == null) {
			articuloBean = new ArticuloBean();
		}
		return articuloBean;
	}
	public void setArticuloBean(ArticuloBean articuloBean) {
		this.articuloBean = articuloBean;
	}
	
}
