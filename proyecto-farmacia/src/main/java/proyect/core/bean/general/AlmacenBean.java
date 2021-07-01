package proyect.core.bean.general;
 

import proyect.base.bean.BaseBean; 

public class AlmacenBean  extends BaseBean{
	 
	private String nombreAlmacen; 
	private String descripcion; 
	private String codigoMinsa;
	private String alias;
	private CatalogoBean tipo;
	private Boolean swPrincipal; 

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

	public CatalogoBean getTipo() {
		if (tipo == null) {
			tipo = new CatalogoBean();
		}
		return tipo;
	}

	public void setTipo(CatalogoBean tipo) {
		this.tipo = tipo;
	}

	public Boolean getSwPrincipal() {
		return swPrincipal;
	}

	public void setSwPrincipal(Boolean swPrincipal) {
		this.swPrincipal = swPrincipal;
	} 
	
	
}
