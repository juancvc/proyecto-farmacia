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
	private CatalogoBean tipoSeguro;
	private TurnoBean turno;
	private float importe;
	
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
		return modalidadPago;
	}
	public void setModalidadPago(CatalogoBean modalidadPago) {
		this.modalidadPago = modalidadPago;
	}
	public PersonaBean getPersona() {
		return persona;
	}
	public void setPersona(PersonaBean persona) {
		this.persona = persona;
	}
	public CatalogoBean getTipoMoneda() {
		return tipoMoneda;
	}
	public void setTipoMoneda(CatalogoBean tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}
	public CatalogoBean getTipoSeguro() {
		return tipoSeguro;
	}
	public void setTipoSeguro(CatalogoBean tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}
	public TurnoBean getTurno() {
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
	
	@Override
	public String toString() {
		return "VentaBean [fechaAtencion=" + fechaAtencion + ", hora=" + hora + ", almacen=" + almacen
				+ ", modalidadPago=" + modalidadPago + ", persona=" + persona + ", tipoMoneda=" + tipoMoneda
				+ ", tipoSeguro=" + tipoSeguro + ", turno=" + turno + ", importe=" + importe + "]";
	} 
	 
}
