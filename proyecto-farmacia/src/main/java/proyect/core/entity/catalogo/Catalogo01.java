package proyect.core.entity.catalogo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "catalogo01.listarPorCodigoTabla", procedureName = "[usp_Catalogo01_listarxCodigoCatalogo]", 
		resultClasses = Catalogo01.class, parameters = {					
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "CodigoTabla", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "tipo", type = int.class) 
	})
	  
})

@Entity
@NamedQuery(name="Catalogo01.findAll", query="SELECT c FROM Catalogo01 c")
public class Catalogo01 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="DescripcionCorta")
	private String descripcionCorta;

	@Column(name="DescripcionLarga")
	private String descripcionLarga;

	private Timestamp fechaModificacion;

	private Timestamp fechaRegistro;

	private String flag;

	@Column(name="IdCatalogo")
	private String idCatalogo;

	private String ipModificacion;

	private String ipRegistro;

	private int nroOrden;

	@Id
	@Column(name="NroRegistro")
	private String nroRegistro;

	private String regAsociado;

	private String usuarioModificacion;

	private String usuarioRegistro;

	public Catalogo01() {
	}

	public String getDescripcionCorta() {
		return this.descripcionCorta;
	}

	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}

	public String getDescripcionLarga() {
		return this.descripcionLarga;
	}

	public void setDescripcionLarga(String descripcionLarga) {
		this.descripcionLarga = descripcionLarga;
	}

	public Timestamp getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Timestamp getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getIdCatalogo() {
		return this.idCatalogo;
	}

	public void setIdCatalogo(String idCatalogo) {
		this.idCatalogo = idCatalogo;
	}

	public String getIpModificacion() {
		return this.ipModificacion;
	}

	public void setIpModificacion(String ipModificacion) {
		this.ipModificacion = ipModificacion;
	}

	public String getIpRegistro() {
		return this.ipRegistro;
	}

	public void setIpRegistro(String ipRegistro) {
		this.ipRegistro = ipRegistro;
	}

	public int getNroOrden() {
		return this.nroOrden;
	}

	public void setNroOrden(int nroOrden) {
		this.nroOrden = nroOrden;
	}

	public String getNroRegistro() {
		return this.nroRegistro;
	}

	public void setNroRegistro(String nroRegistro) {
		this.nroRegistro = nroRegistro;
	}

	public String getRegAsociado() {
		return this.regAsociado;
	}

	public void setRegAsociado(String regAsociado) {
		this.regAsociado = regAsociado;
	}

	public String getUsuarioModificacion() {
		return this.usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public String getUsuarioRegistro() {
		return this.usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

}