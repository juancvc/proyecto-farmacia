package hnch.referencia.core.bean.seguridad;

import hnch.referencia.base.bean.BaseBean;
import hnch.referencia.core.bean.general.TablaBean;

import java.text.SimpleDateFormat;





public class AuditoriaAccesoBean extends BaseBean{
			
	private TablaBean     tipoAccion = new TablaBean();
	private String			nomUsuario;
	
	private String 			nomTabla;
	private String			strFechaHoraAcc;
	private Integer			codUsuAcc;
	private String			nomPersonaUsu;
	private TablaBean     tipoSistema = new TablaBean();
	
	/** FILTROS EXTRAS - BUSQUEDA  **/
	private Long			codPerfil;
	private String			strFecInicio;
	private String			strFecFin;
	private Integer			limite;
	
	public AuditoriaAccesoBean() {
		super();
	}

	public TablaBean getTipoAccion() {
		return tipoAccion;
	}

	public void setTipoAccion(TablaBean tipoAccion) {
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
		if (this.fechaCreacion!=null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			this.strFechaHoraAcc = sdf.format(this.fechaCreacion);
		}
		return strFechaHoraAcc;
	}

	public void setStrFechaHoraAcc(String strFechaHoraAcc) {
		this.strFechaHoraAcc = strFechaHoraAcc;
		
		try {
			if ( (this.strFechaHoraAcc != null) && (this.strFechaHoraAcc.trim().length() > 0) ) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				this.fechaCreacion = sdf.parse(this.strFechaHoraAcc);
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

	public TablaBean getTipoSistema() {
		return tipoSistema;
	}

	public void setTipoSistema(TablaBean tipoSistema) {
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