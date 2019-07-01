package proyect.core.entity.general;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter; 

@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "ubigeo.equivalenciaReniecMinsa", 
			procedureName = "[GENE].[USP_UBIGEO_CODREGISQ]", 
			resultClasses = Ubigeo.class, 
			parameters = {			
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODUBIGE", type = String.class),
		}), 
	
	@NamedStoredProcedureQuery(name = "ubigeo.listaUbigeo", 
			procedureName = "[dbo].[usp_Ubigeo_Minsa_Reniec_Inei]", 
			resultClasses = Ubigeo.class, 
			parameters = {			
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "institucion", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "categoria",   type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "descripcion", type = String.class),
		}), 
})

@Entity 
public class Ubigeo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idUbigeo")
	private String codUbige;
	
	@Column(name = "descripcion")
	private String descripcion;
	 
	
	@Column(name = "idProvin")
	private String codprovin;
	
	@Column(name = "idDistrito")
	private String coddistrito;
	
	@Column(name = "idRegistro")
	private String codRegis;
	
	@Column(name = "idPais")
	private int codpais;
 
	
	public Ubigeo() {
		super();
	} 

	public String getCodUbige() {
		return codUbige;
	}

	public void setCodUbige(String codUbige) {
		this.codUbige = codUbige;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCodprovin() {
		return codprovin;
	}

	public void setCodprovin(String codprovin) {
		this.codprovin = codprovin;
	}

	public String getCoddistrito() {
		return coddistrito;
	}

	public void setCoddistrito(String coddistrito) {
		this.coddistrito = coddistrito;
	}
 
	public String getCodRegis() {
		return codRegis;
	}

	public void setCodRegis(String codRegis) {
		this.codRegis = codRegis;
	}

	public int getCodpais() {
		return codpais;
	}

	public void setCodpais(int codpais) {
		this.codpais = codpais;
	}

	 
}
