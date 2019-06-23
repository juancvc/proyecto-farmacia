package proyect.core.bean.general;
 

import proyect.base.bean.BaseBean; 

public class AlmacenBean  extends BaseBean{
	 
	private String nombreAlmacen; 
	private String descripcion; 
	private String codigoMinsa;
	private String alias;

	public String getNombreAlmacen() {
		return nombreAlmacen;
	}

	public void setNombreAlmacen(String nombreAlmacen) {
		this.nombreAlmacen = nombreAlmacen;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getCodigoMinsa() {
		return codigoMinsa;
	}

	public void setCodigoMinsa(String codigoMinsa) {
		this.codigoMinsa = codigoMinsa;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	} 
	
	
}
