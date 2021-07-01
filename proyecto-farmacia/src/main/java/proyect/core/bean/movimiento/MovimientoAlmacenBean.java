package proyect.core.bean.movimiento;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import proyect.base.bean.BaseBean;
import proyect.core.bean.compra.CompraItemBean;
import proyect.core.bean.general.AlmacenBean;
import proyect.core.bean.general.CatalogoBean;
import proyect.core.bean.general.InstitucionBean;
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
	private StockBean stock;
	private ArticuloBean articuloBean;
	private TipoMovimientoBean tipoMovimiento; 
	private CatalogoBean    tipoFinanciador;
	private CatalogoBean    tipoSeleccion;	
	private CatalogoBean    tipoDocumentoCompra;	
	private PersonaBean persona;
	private CatalogoBean mes;
	private CatalogoBean periodo;
	private Date fechaOrden;
	private String id_concepto;
	private List<StockBean> stockBeanItems;
//	private List<MovimientoAlmacenBean> movimientoAlmacenBeanItems; 
	private String cadenaCantdArt;
	private String cadenaNroPeriodoStock;
	private String cadenaIdStock;
	private double subtotal;
	private double total;
	private String sTotal;
	private AlmacenBean almacenOrigen;
	private AlmacenBean almacenDestino;
	private InventarioBean inventarioBean;
	private Date fechaInventarioSig;
	private Date fechaMovimiento;
	private String descripcion;
	private String sFechaTransferenciaDesde;
	private String sFechaTransferenciaHasta;
//	private List<MovimientoAlmacenBean> abastecimientos;
	private CatalogoBean tipo;
	private ReporteICI reporteICI;
	private InstitucionBean institucionBean;
	private CompraItemBean compraItemBean;

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
		java.util.Date fecha = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String fechaActual = dateFormat.format(fecha);
		if (sFechaMovimiento== null) {
			sFechaMovimiento = fechaActual;	
		}
		return sFechaMovimiento;
	}

	public void setsFechaMovimiento(String sFechaMovimiento) {
		this.sFechaMovimiento = sFechaMovimiento;
	}

	public String getTipoIngresoDocumento() {
		return tipoIngresoDocumento;
	}

	public void setTipoIngresoDocumento(String tipoIngresoDocumento) {
		this.tipoIngresoDocumento = tipoIngresoDocumento;
	}

	public StockBean getStock() {
		if (stock == null) {
			stock = new StockBean();
		}
		return stock;
	}

	public void setStock(StockBean stock) {
		this.stock = stock;
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

	public TipoMovimientoBean getTipoMovimiento() {
		if (tipoMovimiento == null) {
			tipoMovimiento = new TipoMovimientoBean();
		}
		return tipoMovimiento;
	}

	public void setTipoMovimiento(TipoMovimientoBean tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
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

	public CatalogoBean getTipoDocumentoCompra() {
		if (tipoDocumentoCompra == null) {
			tipoDocumentoCompra = new CatalogoBean();
		}
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

	public List<StockBean> getStockBeanItems() {
		return stockBeanItems;
	}

	public void setStockBeanItems(List<StockBean> stockBeanItems) {
		this.stockBeanItems = stockBeanItems;
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

	public String getsTotal() {
		return sTotal;
	}

	public void setsTotal(String sTotal) {
		this.sTotal = sTotal;
	}

	public AlmacenBean getAlmacenOrigen() {
		if (almacenOrigen == null) {
			almacenOrigen = new AlmacenBean();
		}
		return almacenOrigen;
	}

	public void setAlmacenOrigen(AlmacenBean almacenOrigen) {
		this.almacenOrigen = almacenOrigen;
	}

	public AlmacenBean getAlmacenDestino() {
		if (almacenDestino == null) {
			almacenDestino = new AlmacenBean();
		}
		return almacenDestino;
	}

	public void setAlmacenDestino(AlmacenBean almacenDestino) {
		this.almacenDestino = almacenDestino;
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

	public Date getFechaInventarioSig() {
		return fechaInventarioSig;
	}

	public void setFechaInventarioSig(Date fechaInventarioSig) {
		this.fechaInventarioSig = fechaInventarioSig;
	}

	public Date getFechaMovimiento() {
		return fechaMovimiento;
	}

	public void setFechaMovimiento(Date fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public ReporteICI getReporteICI() {
		if (reporteICI == null) {
			reporteICI = new ReporteICI();
		}
		return reporteICI;
	}

	public void setReporteICI(ReporteICI reporteICI) {
		this.reporteICI = reporteICI;
	}

	public String getsFechaTransferenciaDesde() {
		return sFechaTransferenciaDesde;
	}

	public void setsFechaTransferenciaDesde(String sFechaTransferenciaDesde) {
		this.sFechaTransferenciaDesde = sFechaTransferenciaDesde;
	}

	public String getsFechaTransferenciaHasta() {
		return sFechaTransferenciaHasta;
	}

	public void setsFechaTransferenciaHasta(String sFechaTransferenciaHasta) {
		this.sFechaTransferenciaHasta = sFechaTransferenciaHasta;
	}

	public CatalogoBean getTipo() {
		return tipo;
	}

	public void setTipo(CatalogoBean tipo) {
		this.tipo = tipo;
	}

	public InstitucionBean getInstitucionBean() {
		if (institucionBean == null) {
			institucionBean = new InstitucionBean();
		}
		return institucionBean;
	}

	public void setInstitucionBean(InstitucionBean institucionBean) {
		this.institucionBean = institucionBean;
	}

	public CompraItemBean getCompraItemBean() {
		return compraItemBean;
	}

	public void setCompraItemBean(CompraItemBean compraItemBean) {
		this.compraItemBean = compraItemBean;
	} 
	
}
