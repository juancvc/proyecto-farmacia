package hnch.referencia.core.bean.seguridad;

import hnch.referencia.base.bean.BaseBean;
import hnch.referencia.core.bean.general.TablaBean;
import hnch.referencia.core.bean.general.PersonaBean;

import java.util.List;

public class UsuarioBean extends BaseBean {

	private String codigoUsuario;

	private String codigoPerfil;

	private TablaBean situacion;

	private String nombreUsuario;

	private String passwordUsuario;

	private PersonaBean persona;

	private String nombrePerfiles;

	private List<UsuarioPerfilBean> lstUsuarioPerfil;

	private List<AccesoBean> lstAcceso;

	private String codPerfilUsuSelec;

	private String newPassword;

	private String flgRestPass;

	private String audCodigoUsuario;

	private String ultfechaAcceso;

	private PerfilBean perfil;

	private String oldPassword;
	
	public UsuarioBean() {
		super();
	}

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getCodigoPerfil() {
		return codigoPerfil;
	}

	public void setCodigoPerfil(String codigoPerfil) {
		this.codigoPerfil = codigoPerfil;
	}

	public TablaBean getSituacion() {
		return situacion;
	}

	public void setSituacion(TablaBean situacion) {
		this.situacion = situacion;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPasswordUsuario() {
		return passwordUsuario;
	}

	public void setPasswordUsuario(String passwordUsuario) {
		this.passwordUsuario = passwordUsuario;
	}

	public PersonaBean getPersona() {
		if (persona == null) {
			persona = new PersonaBean();
		}
		return persona;
	}

	public void setPersona(PersonaBean persona) {
		this.persona = persona;
	}

	public String getNombrePerfiles() {
		return nombrePerfiles;
	}

	public void setNombrePerfiles(String nombrePerfiles) {
		this.nombrePerfiles = nombrePerfiles;
	}

	public List<UsuarioPerfilBean> getLstUsuarioPerfil() {
		return lstUsuarioPerfil;
	}

	public void setLstUsuarioPerfil(List<UsuarioPerfilBean> lstUsuarioPerfil) {
		this.lstUsuarioPerfil = lstUsuarioPerfil;
	}

	public List<AccesoBean> getLstAcceso() {
		return lstAcceso;
	}

	public void setLstAcceso(List<AccesoBean> lstAcceso) {
		this.lstAcceso = lstAcceso;
	}

	public boolean verificarAcceso(String opc) {

		if (lstAcceso != null) {
			for (AccesoBean acceso : lstAcceso) {
				if (acceso.getComponente() != null) {
					if (acceso.getComponente().getNombreComponente().equals(opc)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public String getCodPerfilUsuSelec() {
		return codPerfilUsuSelec;
	}

	public void setCodPerfilUsuSelec(String codPerfilUsuSelec) {
		this.codPerfilUsuSelec = codPerfilUsuSelec;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getFlgRestPass() {
		return flgRestPass;
	}

	public void setFlgRestPass(String flgRestPass) {
		this.flgRestPass = flgRestPass;
	}

	public String getUltfechaAcceso() {
		return ultfechaAcceso;
	}

	public void setUltfechaAcceso(String ultfechaAcceso) {
		this.ultfechaAcceso = ultfechaAcceso;
	}

	public String getAudCodigoUsuario() {
		return audCodigoUsuario;
	}

	public void setAudCodigoUsuario(String audCodigoUsuario) {
		this.audCodigoUsuario = audCodigoUsuario;
	}

	public PerfilBean getPerfil() {
		if (perfil == null) {
			perfil = new PerfilBean();
		}
		return perfil;
	}

	public void setPerfil(PerfilBean perfil) {
		this.perfil = perfil;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	@Override
	public String toString() {
		return "UsuarioBean [codigoUsuario=" + codigoUsuario + ", codigoPerfil=" + codigoPerfil + ", situacion="
				+ situacion + ", nombreUsuario=" + nombreUsuario + ", passwordUsuario=" + passwordUsuario + ", persona="
				+ persona + ", nombrePerfiles=" + nombrePerfiles + ", lstUsuarioPerfil=" + lstUsuarioPerfil
				+ ", lstAcceso=" + lstAcceso + ", codPerfilUsuSelec=" + codPerfilUsuSelec + ", newPassword="
				+ newPassword + ", flgRestPass=" + flgRestPass + ", audCodigoUsuario=" + audCodigoUsuario
				+ ", ultfechaAcceso=" + ultfechaAcceso + ", perfil=" + perfil + "]";
	}

}
