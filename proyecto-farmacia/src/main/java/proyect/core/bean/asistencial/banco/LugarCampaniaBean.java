package proyect.core.bean.asistencial.banco;

 
import proyect.base.bean.BaseBean;
import proyect.core.bean.general.UbigeoBean;

public class LugarCampaniaBean extends BaseBean{
	
	private String nombre; 

	private UbigeoBean ubigeoLugar;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public UbigeoBean getUbigeoLugar() {
		if (ubigeoLugar == null) {
			ubigeoLugar = new UbigeoBean();
		}
		return ubigeoLugar;
	}

	public void setUbigeoLugar(UbigeoBean ubigeoLugar) {
		this.ubigeoLugar = ubigeoLugar;
	}

	@Override
	public String toString() {
		return "LugarCampaniaBean [nombre=" + nombre + ", ubigeoLugar=" + ubigeoLugar + "]";
	}

	 
}
