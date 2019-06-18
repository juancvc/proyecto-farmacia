package hnch.referencia.core.bean.asistencial.referencia;

import org.springframework.web.multipart.MultipartFile;
import hnch.referencia.base.bean.BaseBean;
import hnch.referencia.core.bean.general.TablaBean;

public class ReferenciaApoyoDxResultadoBean extends BaseBean {

	private ReferenciaBean referenciaBean ;
	private TablaBean tipoApoyo;
	private TablaBean apoyoDX;
	private MultipartFile 	fileResultado;
	private String extensionDocumentoResultado; 
	private String nombreDocumentoResultado;
	
	public ReferenciaApoyoDxResultadoBean() {
		super();
	}
	
	public ReferenciaBean getReferenciaBean() {
		if (referenciaBean == null) {
			referenciaBean = new ReferenciaBean();
		}
		return referenciaBean;
	}
	public void setReferenciaBean(ReferenciaBean referenciaBean) {
		this.referenciaBean = referenciaBean;
	}
	public TablaBean getTipoApoyo() {
		if (tipoApoyo == null) {
			tipoApoyo =  new TablaBean();
		}
		return tipoApoyo;
	}
	public void setTipoApoyo(TablaBean tipoApoyo) {
		this.tipoApoyo = tipoApoyo;
	}
	public TablaBean getApoyoDX() {
		if (apoyoDX == null) {
			apoyoDX =  new TablaBean();
		}
		return apoyoDX;
	}
	public void setApoyoDX(TablaBean apoyoDX) {
		this.apoyoDX = apoyoDX;
	}
	public MultipartFile getFileResultado() {
		return fileResultado;
	}
	public void setFileResultado(MultipartFile resultado) {
		this.fileResultado = resultado;
	}
	public String getExtensionDocumentoResultado() {
		return extensionDocumentoResultado;
	}
	public void setExtensionDocumentoResultado(String extensionDocumentoResultado) {
		this.extensionDocumentoResultado = extensionDocumentoResultado;
	}
	public String getNombreDocumentoResultado() {
		return nombreDocumentoResultado;
	}
	public void setNombreDocumentoResultado(String nombreDocumentoResultado) {
		this.nombreDocumentoResultado = nombreDocumentoResultado;
	}
 
}
