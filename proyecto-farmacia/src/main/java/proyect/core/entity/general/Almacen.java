package proyect.core.entity.general;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
 
@SuppressWarnings("serial")
@NamedStoredProcedureQueries(
		{
				
				@NamedStoredProcedureQuery(
						name="almacen.buscarPorObjeto", 
						procedureName="[usp_Almacen_buscarxID]",
						resultClasses= Almacen.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="idAlmacen", type=String.class)
							}					
					),
				@NamedStoredProcedureQuery(
						name="almacen.buscarPorFiltros", 
						procedureName="[usp_Almacen_buscarxCriterios]",
						resultClasses= Almacen.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="nombreAlmacen", type=String.class) 
							}	
				),
				
				@NamedStoredProcedureQuery(
						name="almacen.insert", 
						procedureName="[usp_Almacen_insertar]",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="idAlmacen", type=String.class ), 
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="nombreAlmacen", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="descripcion", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="alias", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioRegistro", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipRegistro", type=String.class )
							}					
				),
				
				@NamedStoredProcedureQuery(
						name="almacen.update", 
						procedureName="[dbo].[usp_Almacen_actualizar]",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="idAlmacen", 		  type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="nombreAlmacen", 	  type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="descripcion",   	  type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="alias", 			  type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioModificacion", type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipModificacion", 	  type=String.class)
						}					
										
				),
				@NamedStoredProcedureQuery(
						name="almacen.delete", 
						procedureName="[dbo].[usp_Almacen_eliminar]",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="idAlmacen", 			 type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="usuarioModificacion", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ipModificacion", 	 type=String.class)
							}					
				),
				@NamedStoredProcedureQuery(
						name="almacen.buscarTodos", 
						procedureName="[dbo].[usp_Almacen_buscarTodos]",
						resultClasses= Almacen.class,
						parameters={
							
							}				
					),
				@NamedStoredProcedureQuery(
						name="almacen.listaDbf", 
						procedureName="SP_ALMACEN_EXP_DBF",
						resultClasses= Almacen.class,
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="idAlmacen", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class )
							}				
					)
		
		}
	)
@Entity
@Table(name="ALMACEN")
public class Almacen  {
	
	@Id
	@Column(name="idAlmacen")
	private String idAlmacen;

	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="nombreAlmacen")
	private String nombreAlmacen;
	
	@Column(name="alias")
	private String alias;
	
	@Column(name="codigoMinsa")
	private String codigoMinsa;
	
	@Column(name="usuarioRegistro")
	private String usuarioRegistro;
	
	@Column(name="ipRegistro")
	private String ipRegistro;
	
	
	public Almacen() { 
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIdAlmacen() {
		return idAlmacen;
	}

	public void setIdAlmacen(String idAlmacen) {
		this.idAlmacen = idAlmacen;
	}

	public String getNombreAlmacen() {
		return nombreAlmacen;
	}

	public void setNombreAlmacen(String nombreAlmacen) {
		this.nombreAlmacen = nombreAlmacen;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getCodigoMinsa() {
		return codigoMinsa;
	}

	public void setCodigoMinsa(String codigoMinsa) {
		this.codigoMinsa = codigoMinsa;
	}
	
	

	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public String getIpRegistro() {
		return ipRegistro;
	}

	public void setIpRegistro(String ipRegistro) {
		this.ipRegistro = ipRegistro;
	}

	@Override
	public String toString() {
		return "Almacen [idAlmacen=" + idAlmacen + ", nombreAlmacen=" + nombreAlmacen + ", alias=" + alias
				+ ", codigoMinsa=" + codigoMinsa + "]";
	}
 
	
}