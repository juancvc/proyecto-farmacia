package proyect.base.bean;
 
import java.util.Date;
import proyect.core.bean.general.CatalogoBean;
 
 

public class BaseBean {

	protected String codigo;
	protected String numeroVersion;
	protected String numeroPeriodo;
	 
	protected CatalogoBean situacion; 
	protected String strFechaRegistro; 
	protected Integer item;  
	protected String usuarioModificacion;
	protected String usuarioRegistro;
	protected String idUsuarioModificacion;
	protected String idUsuarioRegistro;
	protected String ipModificacion;
	protected String ipRegistro;
	protected Date fechaModificacion; 
	protected Date fechaRegistro;
	
	protected boolean activo; 
	protected String audSession; 
	protected String audObservacionModificacion; 
	
	public BaseBean() {
		super();
	}

	public String getCodigo() {
		if (codigo == null) {
			codigo ="";
		}
		return codigo;
	}

	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNumeroVersion() {
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

	public CatalogoBean getSituacion() {
		return situacion;
	}

	public void setSituacion(CatalogoBean situacion) {
		this.situacion = situacion;
	}

	public String getStrFechaRegistro() {
		return strFechaRegistro;
	}

	public void setStrFechaRegistro(String strFechaRegistro) {
		this.strFechaRegistro = strFechaRegistro;
	}

	public Integer getItem() {
		return item;
	}

	public void setItem(Integer item) {
		this.item = item;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public String getIpModificacion() {
		return ipModificacion;
	}

	public void setIpModificacion(String ipModificacion) {
		this.ipModificacion = ipModificacion;
	}

	public String getIpRegistro() {
		return ipRegistro;
	}

	public void setIpRegistro(String ipRegistro) {
		this.ipRegistro = ipRegistro;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getAudSession() {
		return audSession;
	}

	public void setAudSession(String audSession) {
		this.audSession = audSession;
	}

	public String getAudObservacionModificacion() {
		return audObservacionModificacion;
	}

	public void setAudObservacionModificacion(String audObservacionModificacion) {
		this.audObservacionModificacion = audObservacionModificacion;
	}
	
	
}