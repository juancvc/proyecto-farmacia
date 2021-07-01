package proyect.core.entity.general;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
  
@NamedStoredProcedureQueries(
		{
				
				@NamedStoredProcedureQuery(
						name="institucion.buscarPorObjeto", 
						procedureName="[usp_Institucion_buscarxID]",
						resultClasses= Institucion.class,
						parameters={ 
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idInstitucion", type=String.class)
							}					
					), 
				@NamedStoredProcedureQuery(
						name="institucion.buscarPorFiltros", 
						procedureName="[usp_Institucion_buscarxCriterios]",
						resultClasses= Institucion.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="nombre", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="descripcion", type=String.class) 
							}	
				),
				@NamedStoredProcedureQuery(
						name="institucion.update", 
						procedureName="[usp_Institucion_actualizar]",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="idInstitucion", type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="nombre", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="nombreComercial", type=String.class), 
								@StoredProcedureParameter(mode=ParameterMode.IN, name="descripcion", type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="direccion", type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="logo", type=byte.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="nombreLogo", type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="usuarioModificacion", type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ipModificacion", type=String.class )
						}					
										
				)  
		}
	)

@Entity
public class Institucion { 
	
	@Id
	@Column(name="idInstitucion")
	private String idInstitucion;
 
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="nombreComercial")
	private String nombreComercial;
	
	@Column(name="ruc")
	private String ruc;
	
	@Column(name="logo")
	private byte[] logo;
	
	@Column(name="nombreLogo")
	private String nombreLogo;
	
	@Column(name="descripcion")
	private String descripcion;
	 
	public Institucion() {  
	}

	public String getIdInstitucion() {
		return idInstitucion;
	}

	public void setIdInstitucion(String idInstitucion) {
		this.idInstitucion = idInstitucion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public String getNombreLogo() {
		return nombreLogo;
	}

	public void setNombreLogo(String nombreLogo) {
		this.nombreLogo = nombreLogo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
 
	
}
