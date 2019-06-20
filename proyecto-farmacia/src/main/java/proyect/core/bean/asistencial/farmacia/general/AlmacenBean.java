package proyect.core.bean.asistencial.farmacia.general;
 

import proyect.base.bean.BaseBean; 

public class AlmacenBean  extends BaseBean{
	 
	private String nombreAlmacen; 
	
	private String alias;

	public String getNombreAlmacen() {
		return nombreAlmacen;
	}

	public void setNombreAlmacen(String nombreAlmacen) {
		this.nombreAlmacen = nombreAlmacen;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	} 
	
	
}
