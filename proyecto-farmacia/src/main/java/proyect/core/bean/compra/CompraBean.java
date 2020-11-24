package proyect.core.bean.compra;

import java.text.SimpleDateFormat;
import java.util.Date;
import proyect.base.bean.BaseBean;
import proyect.core.bean.cuentaCorriente.CuentaCorrienteBean;
import proyect.core.bean.general.AlmacenBean;
import proyect.core.bean.general.CatalogoBean;
import proyect.core.bean.general.EpisodioBean;
import proyect.core.bean.general.PersonaBean;
import proyect.core.bean.general.SerieBean;
import proyect.core.bean.general.TurnoBean;
import proyect.core.bean.stock.ProveedorBean;

public class CompraBean extends BaseBean {

	private CatalogoBean tipoDocumento;
	private String numeroDocumento;
	private Date fechaAtencion;
	private Date fechaEmision;
	private String hora;
	private AlmacenBean almacen; 
	private CatalogoBean modalidadPago;
	private ProveedorBean proveedor;
	private CatalogoBean tipoMoneda;
	private CatalogoBean tipoProcesoSeleccion;
	private CatalogoBean tipoFinanciamiento;
	private String glosa;
	private String sFechaEmision;
	private float importe;
	private String sImporte;
	private String mes;
	private int cantidadItems; 
	private String cadenaIdArticulo;
	private String cadenaCantidad;
	private String cadenaLote;
	private String cadenaPrecioCompra;
	private String cadenaPrecioVenta; 
	private String cadenaFechaVencimiento;
	private String cadenaRegistroSanitario;
	
	
	public String getCadenaRegistroSanitario() {
		return cadenaRegistroSanitario;
	}
	public void setCadenaRegistroSanitario(String cadenaRegistroSanitario) {
		this.cadenaRegistroSanitario = cadenaRegistroSanitario;
	}
	public String getCadenaFechaVencimiento() {
		return cadenaFechaVencimiento;
	}
	public void setCadenaFechaVencimiento(String cadenaFechaVencimiento) {
		this.cadenaFechaVencimiento = cadenaFechaVencimiento;
	}
	public String getCadenaIdArticulo() {
		return cadenaIdArticulo;
	}
	public void setCadenaIdArticulo(String cadenaIdArticulo) {
		this.cadenaIdArticulo = cadenaIdArticulo;
	}
	public String getCadenaCantidad() {
		return cadenaCantidad;
	}
	public void setCadenaCantidad(String cadenaCantidad) {
		this.cadenaCantidad = cadenaCantidad;
	}
	public String getCadenaLote() {
		return cadenaLote;
	}
	public void setCadenaLote(String cadenaLote) {
		this.cadenaLote = cadenaLote;
	}
	public String getCadenaPrecioCompra() {
		return cadenaPrecioCompra;
	}
	public void setCadenaPrecioCompra(String cadenaPrecioCompra) {
		this.cadenaPrecioCompra = cadenaPrecioCompra;
	}
	public String getCadenaPrecioVenta() {
		return cadenaPrecioVenta;
	}
	public void setCadenaPrecioVenta(String cadenaPrecioVenta) {
		this.cadenaPrecioVenta = cadenaPrecioVenta;
	}
	public int getCantidadItems() {
		return cantidadItems;
	}
	public void setCantidadItems(int cantidadItems) {
		this.cantidadItems = cantidadItems;
	}
	public CatalogoBean getTipoDocumento() {
		if (tipoDocumento == null) {
			tipoDocumento = new CatalogoBean();
		}
		return tipoDocumento;
	}
	public void setTipoDocumento(CatalogoBean tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public Date getFechaAtencion() {
		return fechaAtencion;
	}
	public void setFechaAtencion(Date fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}
	public Date getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public AlmacenBean getAlmacen() {
		if (almacen == null) {
			almacen = new AlmacenBean();
		}
		return almacen;
	}
	public void setAlmacen(AlmacenBean almacen) {
		this.almacen = almacen;
	}
	public CatalogoBean getModalidadPago() {
		if (modalidadPago == null) {
			modalidadPago = new CatalogoBean();
		}
		return modalidadPago;
	}
	public void setModalidadPago(CatalogoBean modalidadPago) {
		this.modalidadPago = modalidadPago;
	}
	public ProveedorBean getProveedor() {
		if (proveedor == null) {
			proveedor = new ProveedorBean();
		}
		return proveedor;
	}
	public void setProveedor(ProveedorBean proveedor) {
		this.proveedor = proveedor;
	}
	public CatalogoBean getTipoMoneda() {
		return tipoMoneda;
	}
	public void setTipoMoneda(CatalogoBean tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}
	public CatalogoBean getTipoProcesoSeleccion() {
		return tipoProcesoSeleccion;
	}
	public void setTipoProcesoSeleccion(CatalogoBean tipoProcesoSeleccion) {
		this.tipoProcesoSeleccion = tipoProcesoSeleccion;
	}
	public CatalogoBean getTipoFinanciamiento() {
		return tipoFinanciamiento;
	}
	public void setTipoFinanciamiento(CatalogoBean tipoFinanciamiento) {
		this.tipoFinanciamiento = tipoFinanciamiento;
	}
	public String getGlosa() {
		return glosa;
	}
	public void setGlosa(String glosa) {
		this.glosa = glosa;
	}
	public String getsFechaEmision() {
		/*java.util.Date fecha = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String fechaActual = dateFormat.format(fecha);
		if (sFechaEmision == null) {
			sFechaEmision = fechaActual;
		}   */
		return sFechaEmision;
	}
	public void setsFechaEmision(String sFechaEmision) {
		this.sFechaEmision = sFechaEmision;
	}
	public float getImporte() {
		return importe;
	}
	public void setImporte(float importe) {
		this.importe = importe;
	}
	public String getsImporte() {
		return sImporte;
	}
	public void setsImporte(String sImporte) {
		this.sImporte = sImporte;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	
}
