package proyect.core.bean.seguridad;
 

import java.text.SimpleDateFormat;

import proyect.base.bean.BaseBean;
import proyect.core.bean.general.CatalogoBean;





public class AuditoriaAccesoBean extends BaseBean{
			
	private CatalogoBean     tipoAccion = new CatalogoBean();
	private String			nomUsuario;
	
	private String 			nomTabla;
	private String			strFechaHoraAcc;
	private Integer			codUsuAcc;
	private String			nomPersonaUsu;
	private CatalogoBean     tipoSistema = new CatalogoBean();
	
	/** FILTROS EXTRAS - BUSQUEDA  **/
	private Long			codPerfil;
	private String			strFecInicio;
	private String			strFecFin;
	private Integer			limite;
	
	public AuditoriaAccesoBean() {
		super();
	}

	public CatalogoBean getTipoAccion() {
		return tipoAccion;
	}

	public void setTipoAccion(CatalogoBean tipoAccion) {
		this.tipoAccion = tipoAccion;
	}

	public String getNomUsuario() {
		return nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

	public String getNomTabla() {
		return nomTabla;
	}

	public void setNomTabla(String nomTabla) {
		this.nomTabla = nomTabla;
	}

	public String getStrFechaHoraAcc() {
		if (this.fechaRegistro!=null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			this.strFechaHoraAcc = sdf.format(this.fechaRegistro);
		}
		return strFechaHoraAcc;
	}

	public void setStrFechaHoraAcc(String strFechaHoraAcc) {
		this.strFechaHoraAcc = strFechaHoraAcc;
		
		try {
			if ( (this.strFechaHoraAcc != null) && (this.strFechaHoraAcc.trim().length() > 0) ) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				this.fechaRegistro = sdf.parse(this.strFechaHoraAcc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Integer getCodUsuAcc() {
		return codUsuAcc;
	}

	public void setCodUsuAcc(Integer codUsuAcc) {
		this.codUsuAcc = codUsuAcc;
	}

	public String getNomPersonaUsu() {
		return nomPersonaUsu;
	}

	public void setNomPersonaUsu(String nomPersonaUsu) {
		this.nomPersonaUsu = nomPersonaUsu;
	}

	public CatalogoBean getTipoSistema() {
		return tipoSistema;
	}

	public void setTipoSistema(CatalogoBean tipoSistema) {
		this.tipoSistema = tipoSistema;
	}

	@Override
	public String toString() {
		return "AuditoriaAccesoBean [tipoAccion=" + tipoAccion + ", nomUsuario=" + nomUsuario + ", nomTabla=" + nomTabla
				+ ", strFechaHoraAcc=" + strFechaHoraAcc + ", codUsuAcc=" + codUsuAcc + ", nomPersonaUsu="
				+ nomPersonaUsu + ", tipoSistema=" + tipoSistema + "]";
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