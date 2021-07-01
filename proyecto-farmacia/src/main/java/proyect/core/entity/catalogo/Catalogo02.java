package proyect.core.entity.catalogo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


 

@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "catalogo02.insertar", procedureName = "[usp_Catalogo02_insertar]", 
			resultClasses = Catalogo02.class, parameters = {					
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "NroRegistro", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "IdCatalogo", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "DescripcionCorta", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "DescripcionLarga", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "usuarioRegistro", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ipRegistro", type = String.class)    
			}),
	
	@NamedStoredProcedureQuery(name = "catalogo02.actualizar", procedureName = "[usp_Catalogo02_actualizar]", 
			resultClasses = Catalogo02.class, parameters = {					
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NroRegistro", 	  type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "IdCatalogo", 	  type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "DescripcionCorta", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "DescripcionLarga", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN,  name="usuarioModificacion", type = String.class ),
				@StoredProcedureParameter(mode = ParameterMode.IN,  name="ipModificacion", 	  type = String.class)  
			}),
	
	@NamedStoredProcedureQuery(name = "catalogo02.eliminar", procedureName = "[usp_Catalogo02_eliminar]", 
			resultClasses = Catalogo02.class, parameters = {					
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NroRegistro", 	  type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "IdCatalogo", 	  type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN,  name="usuarioModificacion", type = String.class ),
				@StoredProcedureParameter(mode = ParameterMode.IN,  name="ipModificacion", 	  type = String.class)   
			}),
	
	@NamedStoredProcedureQuery(name = "catalogo02.listarPorCodigoTabla", procedureName = "[usp_Catalogo02_listarxCodigoCatalogo]", 
			resultClasses = Catalogo02.class, parameters = {					
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CodigoTabla", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "tipo", type = int.class) 
			}),
	
	@NamedStoredProcedureQuery(name = "catalogo02.listarTodascatalogos", procedureName = "[usp_Catalogo02_listarTodascatalogos]", 
			resultClasses = Catalogo02.class, parameters = { 
			}),
	
	@NamedStoredProcedureQuery(name = "catalogo02.listarCatalogoRegistros", procedureName = "[usp_Catalogo02_listarCatalogoRegistros]", 
			resultClasses = Catalogo02.class, parameters = { 
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "IdCatalogo", type = String.class),
			})
	  
})

@Entity
@NamedQuery(name="Catalogo02.findAll", query="SELECT c FROM Catalogo02 c")
public class Catalogo02 implements Serializable {
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
	
	private String nombreCatalogo;
	
	public Catalogo02() {
	}

	public String getNombreCatalogo() {
		return nombreCatalogo;
	}

	public void setNombreCatalogo(String nombreCatalogo) {
		this.nombreCatalogo = nombreCatalogo;
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