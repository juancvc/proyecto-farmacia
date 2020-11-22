package proyect.core.bean.venta;

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

public class VentaBean extends BaseBean {

	private String numero;
	private Date fechaAtencion;
	private Date fechaEmision;
	private String hora;
	private AlmacenBean almacen;
	private EpisodioBean episodio;
	private CatalogoBean modalidadPago;
	private PersonaBean persona;
	private CatalogoBean tipoMoneda;
	private CatalogoBean tipoFinanciador;
	private TurnoBean turno;
	private float importe;
	private String sImporte;
	private Boolean swValida;

	private String cadenaCantidad;
	private String cadenaCodigoStock;
	private String cadenaNroPeriodoStock;
	private String cadenaCantidadFaltante;
	private String sfechaEmision;
	private String fechaEmisionDesde;
	private String fechaEmisionHasta;
	private CatalogoBean tipoComprobante;
	private CatalogoBean tipoOperacion;
	private SerieBean serie;
	private String montoLetras;
	private CuentaCorrienteBean cuentaCorrienteBean;
	
	private int cantidadItems;
	
	private String pacienteEpisodio;
	private String mes;
	private ReporteVenta reporteVenta;
	
	public String getPacienteEpisodio() {
		
		pacienteEpisodio = this.getEpisodio().getCodigo()+ " - " + this.getPersona().getNombreCompleto();
		
		return pacienteEpisodio;
	}

	public EpisodioBean getEpisodio() {
		if (episodio == null) {
			episodio = new EpisodioBean();
		}
		return episodio;
	}

	public void setEpisodio(EpisodioBean episodio) {
		this.episodio = episodio;
	}

	public void setPacienteEpisodio(String pacienteEpisodio) {
		this.pacienteEpisodio = pacienteEpisodio;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

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

	public PersonaBean getPersona() {
		if (persona == null) {
			persona = new PersonaBean();
		}
		return persona;
	}

	public void setPersona(PersonaBean persona) {
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

	public String getSfechaEmision() {
		java.util.Date fecha = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String fechaActual = dateFormat.format(fecha);
		System.out.println(fechaActual);
		sfechaEmision = fechaActual;
		return sfechaEmision;
	}

	public void setSfechaEmision(String sfechaEmision) {
		this.sfechaEmision = sfechaEmision;
	}

	public String getFechaEmisionDesde() {
		java.util.Date fecha = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String fechaActual = dateFormat.format(fecha);
		if (fechaEmisionDesde == null) {
			fechaEmisionDesde = fechaActual;
		}  
		return fechaEmisionDesde;
	}

	public void setFechaEmisionDesde(String fechaEmisionDesde) {
		this.fechaEmisionDesde = fechaEmisionDesde;
	}

	public String getFechaEmisionHasta() {
		java.util.Date fecha = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String fechaActual = dateFormat.format(fecha);
		if (fechaEmisionHasta == null) {
			fechaEmisionHasta = fechaActual;
		} 
		return fechaEmisionHasta;
	}

	public void setFechaEmisionHasta(String fechaEmisionHasta) {
		this.fechaEmisionHasta = fechaEmisionHasta;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public CatalogoBean getTipoComprobante() {
		if (tipoComprobante == null) {
			tipoComprobante = new CatalogoBean();
		}
		return tipoComprobante;
	}

	public void setTipoComprobante(CatalogoBean tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}

	public SerieBean getSerie() {
		if (serie == null) {
			serie = new SerieBean();
		}
		return serie;
	}

	public void setSerie(SerieBean serie) {
		this.serie = serie;
	}

	public CatalogoBean getTipoOperacion() {
		if (tipoOperacion == null) {
			tipoOperacion = new CatalogoBean();
		}
		return tipoOperacion;
	}

	public void setTipoOperacion(CatalogoBean tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	public String getMontoLetras() {
		return montoLetras;
	}

	public void setMontoLetras(String montoLetras) {
		this.montoLetras = montoLetras;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public CuentaCorrienteBean getCuentaCorrienteBean() {
		if (cuentaCorrienteBean == null) {
			cuentaCorrienteBean = new CuentaCorrienteBean();
		}
		return cuentaCorrienteBean;
	}

	public void setCuentaCorrienteBean(CuentaCorrienteBean cuentaCorrienteBean) {
		this.cuentaCorrienteBean = cuentaCorrienteBean;
	}

	public ReporteVenta getReporteVenta() {
		if (reporteVenta == null) {
			reporteVenta = new ReporteVenta();
		}
		return reporteVenta;
	}

	public void setReporteVenta(ReporteVenta reporteVenta) {
		this.reporteVenta = reporteVenta;
	}

	@Override
	public String toString() {
		return "VentaBean [fechaAtencion=" + fechaAtencion + ", hora=" + hora + ", almacen=" + almacen
				+ ", modalidadPago=" + modalidadPago + ", persona=" + persona + ", tipoMoneda=" + tipoMoneda
				+ ", tipoFinanciador=" + tipoFinanciador + ", turno=" + turno + ", importe=" + importe + "]";
	}

}
