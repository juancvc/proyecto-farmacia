package proyect.core.bean.seguridad;


import java.text.SimpleDateFormat;

import proyect.base.bean.BaseBean;
import proyect.core.bean.general.CatalogoBean;


public class AuditoriaBean extends BaseBean{
			
	private String 			nomTabla;
	private CatalogoBean     tipoAccion = new CatalogoBean();
	private Long			codRegistroAud;
	private String			nomUsuario;
	private String			nomPersonaUsu;
	private String			strFechaHoraAud; 
	
	/** FILTROS EXTRAS - BUSQUEDA  **/
	private Long			codPerfil;
	private String			strFecInicio;
	private String			strFecFin;
	private Integer			limite;
	
	public AuditoriaBean() {
		super();
	}

	public String getNomTabla() {
		return nomTabla;
	}

	public void setNomTabla(String nomTabla) {
		this.nomTabla = nomTabla;
	}

	public CatalogoBean getTipoAccion() {
		return tipoAccion;
	}

	public void setTipoAccion(CatalogoBean tipoAccion) {
		this.tipoAccion = tipoAccion;
	}

	public Long getCodRegistroAud() {
		return codRegistroAud;
	}

	public void setCodRegistroAud(Long codRegistroAud) {
		this.codRegistroAud = codRegistroAud;
	}
	
	public String getNomUsuario() {
		return nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

	public String getNomPersonaUsu() {
		return nomPersonaUsu;
	}

	public void setNomPersonaUsu(String nomPersonaUsu) {
		this.nomPersonaUsu = nomPersonaUsu;
	}

	public String getStrFechaHoraAud() {
		if (this.fechaRegistro!=null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			this.strFechaHoraAud = sdf.format(this.fechaRegistro);
		}
		return strFechaHoraAud;
	}
	
	public void setStrFechaHoraAud(String strFechaHoraAud) {
		this.strFechaHoraAud = strFechaHoraAud;
		
		try {
			if ( (this.strFechaHoraAud != null) && (this.strFechaHoraAud.trim().length() > 0) ) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				this.fechaRegistro = sdf.parse(this.strFechaHoraAud);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "AuditoriaBean [nomTabla=" + nomTabla + ", tipoAccion=" + tipoAccion + ", codRegistroAud="
				+ codRegistroAud + ", nomUsuario=" + nomUsuario + ", nomPersonaUsu=" + nomPersonaUsu
				+ ", strFechaHoraAud=" + strFechaHoraAud + "]";
	}

	public Long getCodPerfil() {
		return codPerfil;
	}

	public void setCodPerfil(Long codPerfil) {
		this.codPerfil = codPerfil;
	}

	public String getStrFecInicio() {
		return strFecInicio;
	}

	public void setStrFecInicio(String strFecInicio) {
		this.strFecInicio = strFecInicio;
	}

	public String getStrFecFin() {
		return strFecFin;
	}

	public void setStrFecFin(String strFecFin) {
		this.strFecFin = strFecFin;
	}

	public Integer getLimite() {
		return limite;
	}

	public void setLimite(Integer limite) {
		this.limite = limite;
	}
	
}