package proyect.core.entity.inventario;

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
									@StoredProcedureParameter(mode=ParameterMode.IN, name="idAlmacen", type=Integer.class)
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
						procedureName="SP_ALMACEN_ACTUALIZAR",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ALMACEN", type=Integer.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ORGANIZACION", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_INSTITUCION", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SEDE", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_CORTO", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_LARGO", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ALIAS", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SITUACION", type=Integer.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_USUARIO", type=Integer.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_OPERACION", type=Integer.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_MAC", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_OBSERVACION", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="CODIGO_MINSA", type=String.class)
						}					
										
				),
				@NamedStoredProcedureQuery(
						name="almacen.delete", 
						procedureName="SP_ALMACEN_ELIMINAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ALMACEN", type=Integer.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_USUARIO", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_IP", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_SESSION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_OPERACION", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_MAC", type=String.class)
							}					
				),
				@NamedStoredProcedureQuery(
						name="almacen.buscarTodos", 
						procedureName="SP_ALMACEN_BUSCAR_TODOS",
						resultClasses= Almacen.class,
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class )
							}				
					),
				@NamedStoredProcedureQuery(
						name="almacen.listaDbf", 
						procedureName="SP_ALMACEN_EXP_DBF",
						resultClasses= Almacen.class,
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ALMACEN", type=int.class ),
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

	@Override
	public String toString() {
		return "Almacen [idAlmacen=" + idAlmacen + ", nombreAlmacen=" + nombreAlmacen + ", alias=" + alias
				+ ", codigoMinsa=" + codigoMinsa + "]";
	}
 
	
}