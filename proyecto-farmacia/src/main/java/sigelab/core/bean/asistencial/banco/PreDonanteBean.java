package sigelab.core.bean.asistencial.banco;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import sigelab.base.bean.BaseBean;
import sigelab.core.bean.general.TablaBean;

public class PreDonanteBean  extends BaseBean{
	
	private PostulanteBean postulanteBean;  
	private String ultimaFechaDonacion; 
	private String sFecha;
	private String sHora;
	private String peso;
	private String talla;
	private String pulso;
	private String reiterativo;
	private String temperatura;
	private String masaCorporal;
	private String presionArterial;
	private String volumenSangreTotal;
	private TablaBean accesoVenoso;
	private TablaBean resultado;
	private String observacion ;
	
	private List<PreDonanteEntrevistaBean> lstPreDonanteEntrevistaBean;
	
	
	
	public List<PreDonanteEntrevistaBean> getLstPreDonanteEntrevistaBean() {
		return lstPreDonanteEntrevistaBean;
	}
	public void setLstPreDonanteEntrevistaBean(List<PreDonanteEntrevistaBean> lstPreDonanteEntrevistaBean) {
		this.lstPreDonanteEntrevistaBean = lstPreDonanteEntrevistaBean;
	}
	public String getPulso() {
		return pulso;
	}
	public void setPulso(String pulso) {
		this.pulso = pulso;
	}
	public String getReiterativo() {
		return reiterativo;
	}
	public void setReiterativo(String reiterativo) {
		this.reiterativo = reiterativo;
	}
	public PostulanteBean getPostulanteBean() {
		if (postulanteBean == null) {
			postulanteBean = new PostulanteBean();
		}
		return postulanteBean;
	}
	public void setPostulanteBean(PostulanteBean postulanteBean) {
		this.postulanteBean = postulanteBean;
	}
	public String getUltimaFechaDonacion() {
		return ultimaFechaDonacion;
	}
	public void setUltimaFechaDonacion(String ultimaFechaDonacion) {
		this.ultimaFechaDonacion = ultimaFechaDonacion;
	}
	public String getsFecha() {
		if (sFecha == null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			String strHora = sdf.format(new Date());
			sFecha = strHora;
		} 
		return sFecha;
	}
	public void setsFecha(String sFecha) {
		this.sFecha = sFecha;
	}
	public String getsHora() {
		return sHora;
	}
	public void setsHora(String sHora) {
		this.sHora = sHora;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public String getTalla() {
		return talla;
	}
	public void setTalla(String talla) {
		this.talla = talla;
	}
	public String getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}
	public String getMasaCorporal() {
		return masaCorporal;
	}
	public void setMasaCorporal(String masaCorporal) {
		this.masaCorporal = masaCorporal;
	}
	public String getPresionArterial() {
		return presionArterial;
	}
	public void setPresionArterial(String presionArterial) {
		this.presionArterial = presionArterial;
	}
	public String getVolumenSangreTotal() {
		return volumenSangreTotal;
	}
	public void setVolumenSangreTotal(String volumenSangreTotal) {
		this.volumenSangreTotal = volumenSangreTotal;
	}
	public TablaBean getAccesoVenoso() {
		if (accesoVenoso == null) {
			accesoVenoso = new TablaBean();
		}
		return accesoVenoso;
	}
	public void setAccesoVenoso(TablaBean accesoVenoso) {
		this.accesoVenoso = accesoVenoso;
	}
	public TablaBean getResultado() {
		if (resultado == null) {
			resultado = new TablaBean();
		}
		return resultado;
	}
	public void setResultado(TablaBean resultado) {
		this.resultado = resultado;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	@Override
	public String toString() {
		return "PreDonanteBean [postulanteBean=" + postulanteBean + ", ultimaFechaDonacion=" + ultimaFechaDonacion
				+ ", sFecha=" + sFecha + ", sHora=" + sHora + ", peso=" + peso + ", talla=" + talla + ", temperatura="
				+ temperatura + ", masaCorporal=" + masaCorporal + ", presionArterial=" + presionArterial
				+ ", volumenSangreTotal=" + volumenSangreTotal + ", accesoVenoso=" + accesoVenoso + ", resultado="
				+ resultado + ", observacion=" + observacion + "]";
	}

	
	 
}
