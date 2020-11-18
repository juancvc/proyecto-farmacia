package proyect.core.bean.general;
 

import proyect.base.bean.BaseBean; 

public class SerieBean  extends BaseBean{
	 
	private String nroSerie; 
	private CatalogoBean tipoComprobante;
	
	public String getNroSerie() {
		return nroSerie;
	}
	public void setNroSerie(String nroSerie) {
		this.nroSerie = nroSerie;
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
}
