package proyect.core.bean.movimiento;

import proyect.base.bean.BaseBean;
import proyect.core.bean.general.CatalogoBean;

public class TipoMovimientoBean extends BaseBean {

	private String nombreTipoMovimiento;
	private CatalogoBean categoriaTipoMovimiento;
	private CatalogoBean clase;
	
	public String getNombreTipoMovimiento() {
		return nombreTipoMovimiento;
	}
	public void setNombreTipoMovimiento(String nombreTipoMovimiento) {
		this.nombreTipoMovimiento = nombreTipoMovimiento;
	}
	public CatalogoBean getCategoriaTipoMovimiento() {
		if (categoriaTipoMovimiento == null ) {
			categoriaTipoMovimiento = new CatalogoBean();
		}
		return categoriaTipoMovimiento;
	}
	public void setCategoriaTipoMovimiento(CatalogoBean categoriaTipoMovimiento) {
		this.categoriaTipoMovimiento = categoriaTipoMovimiento;
	}
	public CatalogoBean getClase() {
		if (clase == null ) {
			clase = new CatalogoBean();
		}
		return clase;
	}
	public void setClase(CatalogoBean clase) {
		this.clase = clase;
	}
	
}
