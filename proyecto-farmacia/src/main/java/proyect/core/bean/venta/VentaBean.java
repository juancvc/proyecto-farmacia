package proyect.core.bean.venta;
 
import java.util.Date; 
import proyect.base.bean.BaseBean;
import proyect.core.bean.general.AlmacenBean;
import proyect.core.bean.general.CatalogoBean;
import proyect.core.bean.general.PersonaBean;
import proyect.core.bean.general.TurnoBean;

public class VentaBean  extends BaseBean {
 
	private Date fechaAtencion; 
	private String hora;
	private AlmacenBean almacen;
//	private Event idEvento;
	private CatalogoBean modalidadPago;
	private PersonaBean persona; 
	private CatalogoBean tipoMoneda;
	private CatalogoBean tipoFinanciador;
	private TurnoBean turno;
	private float importe;
	private String sImporte;
	private Boolean   swValida;
	
	private String cadenaCantidad;
	private String cadenaCodigoStock;
	private String cadenaNroPeriodoStock;
	private String cadenaCantidadFaltante;
	private int cantidadItems;
	
	
	
	public String getCadenaCantidadFaltante() {
		return cadenaCantidadFaltante;
	}
	public void setCadenaCantidadFaltante(String cadenaCantidadFaltante) {
		this.cadenaCantidadFaltante = cadenaCantidadFaltante;
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
	public String getCadenaNroPeriodoStock() {
		return cadenaNroPeriodoStock;
	}
	public void setCadenaNroPeriodoStock(String cadenaNroPeriodoStock) {
		this.cadenaNroPeriodoStock = cadenaNroPeriodoStock;
	}
	public Boolean getSwValida() {
		return swValida;
	}
	public void setSwValida(Boolean swValida) {
		this.swValida = swValida;
	}
	public String getsImporte() {
		return sImporte;
	}
	public void setsImporte(String sImporte) {
		this.sImporte = sImporte;
	}
	public Date getFechaAtencion() {
		return fechaAtencion;
	}
	public void setFechaAtencion(Date fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public AlmacenBean getAlmacen() {
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
	public PersonaBean getPersona() {
		return persona;
	}
	public void  setPersona(PersonaBean persona) {
		this.persona = persona;
	}
	public CatalogoBean getTipoMoneda() {
		if (tipoMoneda == null) {
			tipoMoneda = new CatalogoBean();
		}
		return tipoMoneda;
	}
	public void setTipoMoneda(CatalogoBean tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	} 
	public TurnoBean getTurno() {
		if (turno == null) {
			turno = new TurnoBean();
		}
		return turno;
	}
	public void setTurno(TurnoBean turno) {
		this.turno = turno;
	}
	public float getImporte() {
		return importe;
	}
	public void setImporte(float importe) {
		this.importe = importe;
	}
	
	public String getCadenaCantidad() {
		return cadenaCantidad;
	}
	public void setCadenaCantidad(String cadenaCantidad) {
		this.cadenaCantidad = cadenaCantidad;
	}
	public String getCadenaCodigoStock() {
		return cadenaCodigoStock;
	}
	public void setCadenaCodigoStock(String cadenaCodigoStock) {
		this.cadenaCodigoStock = cadenaCodigoStock;
	}
	public int getCantidadItems() {
		return cantidadItems;
	}
	public void setCantidadItems(int cantidadItems) {
		this.cantidadItems = cantidadItems;
	}
	@Override
	public String toString() {
		return "VentaBean [fechaAtencion=" + fechaAtencion + ", hora=" + hora + ", almacen=" + almacen
				+ ", modalidadPago=" + modalidadPago + ", persona=" + persona + ", tipoMoneda=" + tipoMoneda
				+ ", tipoFinanciador=" + tipoFinanciador + ", turno=" + turno + ", importe=" + importe + "]";
	} 
	 
}
