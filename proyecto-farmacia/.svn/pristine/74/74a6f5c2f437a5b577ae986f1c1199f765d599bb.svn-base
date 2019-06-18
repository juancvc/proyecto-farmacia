package hnch.referencia.base.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import hnch.referencia.core.bean.general.TablaBean; 

public class BaseBean {

	protected String codigo;
	protected String codigoOrganizacion;
	protected String codigoInstitucion;
	protected String codigoSede;
	protected String numeroVersion;
	protected String numeroPeriodo;
	
	protected TablaBean situacion;
	protected String estado;
	protected String audTipo;
	protected String audSession;
	
	protected String audObservacionModificacion;
	protected String audHostIP;
	protected Date fechaCreacion;
	protected String codigoUsuarioCreacion;
	protected String ipCreacion;

	protected Date fechaModificacion;
	protected String codigoUsuarioModificacion;
	protected String ipModificacion;

	protected String nombreUsuarioCreacion;
	protected String strFechaCreacion;

	protected Integer item;

	protected String valPreguEncrypt;
	protected String valAlterEncrypt;
	protected String valRelEncrypt;
 
	protected String codigoUsuarioSession;
	protected String codigoPerfilUsuarioSession;
	
	protected boolean valValid;

	public TablaBean getSituacion() {
		if (situacion == null) {
			situacion = new TablaBean();
		}
		return situacion;
	}

	public void setSituacion(TablaBean situacion) {
		this.situacion = situacion;
	}

	public BaseBean() {
		super();
	}

	public String getCodigo() {
		if (codigo == null) {
			codigo = "";
		}
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getAudTipo() {
		return audTipo;
	}

	public void setAudTipo(String audTipo) {
		this.audTipo = audTipo;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getIpCreacion() {
		return ipCreacion;
	}

	public void setIpCreacion(String ipCreacion) {
		this.ipCreacion = ipCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getIpModificacion() {
		return ipModificacion;
	}

	public void setIpModificacion(String ipModificacion) {
		this.ipModificacion = ipModificacion;
	}

	public String getAudSession() {
		return audSession;
	}

	public void setAudSession(String audSession) {
		this.audSession = audSession;
	}

	public String getCodigoUsuarioCreacion() {
		return codigoUsuarioCreacion;
	}

	public void setCodigoUsuarioCreacion(String codigoUsuarioCreacion) {
		this.codigoUsuarioCreacion = codigoUsuarioCreacion;
	}

	public String getCodigoUsuarioModificacion() {
		return codigoUsuarioModificacion;
	}

	public void setCodigoUsuarioModificacion(String codigoUsuarioModificacion) {
		this.codigoUsuarioModificacion = codigoUsuarioModificacion;
	}
 

	public String getAudObservacionModificacion() {
		return audObservacionModificacion;
	}

	public void setAudObservacionModificacion(String audObservacionModificacion) {
		this.audObservacionModificacion = audObservacionModificacion;
	}

	/*
	 * public String getAudFechaHora() { return audFechaHora; } public void
	 * setAudFechaHora(String audFechaHora) { this.audFechaHora = audFechaHora;
	 * }
	 */
	public String getAudHostIP() {
		return audHostIP;
	}

	public void setAudHostIP(String audHostIP) {
		this.audHostIP = audHostIP;
	}

	public String getStrFechaCreacion() {
		if (this.fechaCreacion != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			this.strFechaCreacion = sdf.format(this.fechaCreacion);
		}
		return strFechaCreacion;
	}

	public void setStrFechaCreacion(String strFechaCreacion) {
		this.strFechaCreacion = strFechaCreacion;

		try {
			if ((this.strFechaCreacion != null) && (this.strFechaCreacion.trim().length() > 0)) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				this.fechaCreacion = sdf.parse(this.strFechaCreacion);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Integer getItem() {
		return item;
	}

	public void setItem(Integer item) {
		this.item = item;
	}

	public String getValPreguEncrypt() {
		return valPreguEncrypt;
	}

	public void setValPreguEncrypt(String valPreguEncrypt) {
		this.valPreguEncrypt = valPreguEncrypt;
	}

	public String getValAlterEncrypt() {
		return valAlterEncrypt;
	}

	public void setValAlterEncrypt(String valAlterEncrypt) {
		this.valAlterEncrypt = valAlterEncrypt;
	}

	public String getValRelEncrypt() {
		return valRelEncrypt;
	}

	public void setValRelEncrypt(String valRelEncrypt) {
		this.valRelEncrypt = valRelEncrypt;
	}

	public boolean isValValid() {
		return valValid;
	}

	public void setValValid(boolean valValid) {
		this.valValid = valValid;
	}

	public String getCodigoOrganizacion() {
		if (codigoOrganizacion == null) {
			codigoOrganizacion = "01";
		}
		return codigoOrganizacion;
	}

	public void setCodigoOrganizacion(String codigoOrganizacion) {
		this.codigoOrganizacion = codigoOrganizacion;
	}

	public String getCodigoInstitucion() {
		if (codigoInstitucion == null) {
			codigoInstitucion = "01";
		}
		return codigoInstitucion;
	}

	public void setCodigoInstitucion(String codigoInstitucion) {
		this.codigoInstitucion = codigoInstitucion;
	}

	public String getCodigoSede() {
		if (codigoSede == null) {
			codigoSede = "01";
		}
		return codigoSede;
	}

	public void setCodigoSede(String codigoSede) {
		this.codigoSede = codigoSede;
	}

	public String getNumeroVersion() {
		if (numeroVersion == null) {
			numeroVersion = "000";
		}
		return numeroVersion;
	}

	public void setNumeroVersion(String numeroVersion) {
		this.numeroVersion = numeroVersion;
	}

	public String getNumeroPeriodo() {
		return numeroPeriodo;
	}

	public void setNumeroPeriodo(String numeroPeriodo) {
		this.numeroPeriodo = numeroPeriodo;
	}

	public String getCodigoUsuarioSession() {
		return codigoUsuarioSession;
	}

	public void setCodigoUsuarioSession(String codigoUsuarioSession) {
		this.codigoUsuarioSession = codigoUsuarioSession;
	}

	public String getCodigoPerfilUsuarioSession() {
		return codigoPerfilUsuarioSession;
	}

	public void setCodigoPerfilUsuarioSession(String codigoPerfilUsuarioSession) {
		this.codigoPerfilUsuarioSession = codigoPerfilUsuarioSession;
	}

	public String getNombreUsuarioCreacion() {
		return nombreUsuarioCreacion;
	}

	public void setNombreUsuarioCreacion(String nombreUsuarioCreacion) {
		this.nombreUsuarioCreacion = nombreUsuarioCreacion;
	}

	@Override
	public String toString() {
		return "BaseBean [codigo=" + codigo + ", codigoOrganizacion=" + codigoOrganizacion + ", codigoInstitucion="
				+ codigoInstitucion + ", codigoSede=" + codigoSede + ", numeroVersion=" + numeroVersion
				+ ", numeroPeriodo=" + numeroPeriodo + ", situacion=" + situacion + ", estado=" + estado + ", audTipo="
				+ audTipo + ", audSession=" + audSession + ", audObservacionModificacion=" + audObservacionModificacion
				+ ", audHostIP=" + audHostIP + ", fechaCreacion=" + fechaCreacion + ", codigoUsuarioCreacion="
				+ codigoUsuarioCreacion + ", ipCreacion=" + ipCreacion + ", fechaModificacion=" + fechaModificacion
				+ ", codigoUsuarioModificacion=" + codigoUsuarioModificacion + ", ipModificacion=" + ipModificacion
				+ ", nombreUsuarioCreacion=" + nombreUsuarioCreacion + ", strFechaCreacion=" + strFechaCreacion
				+ ", item=" + item + ", valPreguEncrypt=" + valPreguEncrypt + ", valAlterEncrypt=" + valAlterEncrypt
				+ ", valRelEncrypt=" + valRelEncrypt + ", codigoUsuarioSession=" + codigoUsuarioSession
				+ ", codigoPerfilUsuarioSession=" + codigoPerfilUsuarioSession + ", valValid=" + valValid + "]";
	}

	 
}