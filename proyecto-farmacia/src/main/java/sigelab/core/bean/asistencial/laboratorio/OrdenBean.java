package sigelab.core.bean.asistencial.laboratorio;
 
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import sigelab.base.bean.BaseBean;
import sigelab.core.bean.general.PacienteBean;
import sigelab.core.bean.general.TablaBean;

public class OrdenBean extends BaseBean{
	
	private PacienteBean pacienteBean;
	private Date fechaOrden;
	private String horaOrden;
	private String nroOrden;  
	private String strFechaOrden;  
	private String observacion;  
	private Float importeTotal;
	
	private String sImporteTotal;
	private String descripcionImporte;
	
	private List<OrdenDetalleBean> lstOrdenDetalleBean;
	
	private int cantidadItems;  
	private String cadenaCodigoTarifario;  
	private String cadenaCantidad;  
	
	private String fechaDesde;  
	private String fechaHasta;  
	private TablaBean motivoAnular;
	private String detalleMotivoAnular;  
	
 
	public TablaBean getMotivoAnular() {
		if (motivoAnular == null) {
			motivoAnular = new TablaBean();
		}
		return motivoAnular;
	}
	public void setMotivoAnular(TablaBean motivoAnular) {
		this.motivoAnular = motivoAnular;
	}
	public String getDetalleMotivoAnular() {
		return detalleMotivoAnular;
	}
	public void setDetalleMotivoAnular(String detalleMotivoAnular) {
		this.detalleMotivoAnular = detalleMotivoAnular;
	}
	public String getNroOrden() {
		return nroOrden;
	}
	public void setNroOrden(String nroOrden) {
		this.nroOrden = nroOrden;
	}
	public String getFechaDesde() {
		if (fechaDesde == null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			String strHora = sdf.format(new Date());
			fechaDesde = strHora;
		} 
		return fechaDesde; 
	}
	public void setFechaDesde(String fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	public String getFechaHasta() {
		if (fechaHasta == null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			String strHora = sdf.format(new Date());
			fechaHasta = strHora;
		} 
		return fechaHasta;
	}
	public void setFechaHasta(String fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
	public int getCantidadItems() {
		return cantidadItems;
	}
	public void setCantidadItems(int cantidadItems) {
		this.cantidadItems = cantidadItems;
	}
	public String getCadenaCodigoTarifario() {
		return cadenaCodigoTarifario;
	}
	public void setCadenaCodigoTarifario(String cadenaCodigoTarifario) {
		this.cadenaCodigoTarifario = cadenaCodigoTarifario;
	}
	public String getCadenaCantidad() {
		return cadenaCantidad;
	}
	public void setCadenaCantidad(String cadenaCantidad) {
		this.cadenaCantidad = cadenaCantidad;
	}
	public String getsImporteTotal() {
		return sImporteTotal;
	}
	public void setsImporteTotal(String sImporteTotal) {
		this.sImporteTotal = sImporteTotal;
	}
	public List<OrdenDetalleBean> getLstOrdenDetalleBean() {
		return lstOrdenDetalleBean;
	}
	public void setLstOrdenDetalleBean(List<OrdenDetalleBean> lstOrdenDetalleBean) {
		this.lstOrdenDetalleBean = lstOrdenDetalleBean;
	}
	public PacienteBean getPacienteBean() {
		if (pacienteBean == null ) {
			pacienteBean = new PacienteBean();
		}
		return pacienteBean;
	}
	public void setPacienteBean(PacienteBean pacienteBean) {
		this.pacienteBean = pacienteBean;
	}
	public Date getFechaOrden() {
		return fechaOrden;
	}
	public void setFechaOrden(Date fechaOrden) {
		this.fechaOrden = fechaOrden;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public Float getImporteTotal() {
		return importeTotal;
	}
	public void setImporteTotal(Float importeTotal) {
		this.importeTotal = importeTotal;
	}
	public String getDescripcionImporte() {
		return descripcionImporte;
	}
	public void setDescripcionImporte(String descripcionImporte) {
		this.descripcionImporte = descripcionImporte;
	}  
	
	public void calcularImporteTotal(){
		Float tmpImporte = (float) 0.00;
		for (OrdenDetalleBean ordenDetalleBean : lstOrdenDetalleBean) {
			tmpImporte += ordenDetalleBean.getImporte();
		}
		System.out.println("tmpImporte " + tmpImporte);
		this.setImporteTotal(tmpImporte);
	}
	public String getStrFechaOrden() {
		return strFechaOrden;
	}
	public void setStrFechaOrden(String strFechaOrden) {
		this.strFechaOrden = strFechaOrden;
	}
	public String getHoraOrden() {
		return horaOrden;
	}
	public void setHoraOrden(String horaOrden) {
		this.horaOrden = horaOrden;
	}
 
}
