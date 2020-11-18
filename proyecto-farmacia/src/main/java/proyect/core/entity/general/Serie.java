package proyect.core.entity.general;

import java.sql.Timestamp;

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
						name="serie.buscarPorObjeto", 
						procedureName="[usp_Serie_buscarxID]",
						resultClasses= Serie.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="idAlmacen", type=String.class)
							}					
					),
				@NamedStoredProcedureQuery(
						name="serie.buscarPorFiltros", 
						procedureName="[usp_Serie_buscarxCriterios]",
						resultClasses= Serie.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="idTipoComprobanteCat01", type=String.class) 
							}	
				),
				
				@NamedStoredProcedureQuery(
						name="serie.insert", 
						procedureName="[usp_Serie_insertar]",
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
						name="serie.update", 
						procedureName="[dbo].[usp_Serie_actualizar]",
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
						name="serie.delete", 
						procedureName="[dbo].[usp_Serie_eliminar]",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="idAlmacen", 			 type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="usuarioModificacion", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ipModificacion", 	 type=String.class)
							}					
				),
				@NamedStoredProcedureQuery(
						name="serie.buscarTodos", 
						procedureName="[dbo].[usp_Serie_buscarTodos]",
						resultClasses= Serie.class,
						parameters={
							
							}				
					),
				@NamedStoredProcedureQuery(
						name="serie.listaDbf", 
						procedureName="SP_ALMACEN_EXP_DBF",
						resultClasses= Serie.class,
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
public class Serie  {
	
	@Id
	@Column(name="idSerie")
	private String idSerie;

	@Column(name="idTipoComprobanteCat01")
	private String idTipoComprobanteCat01;
	
	@Column(name="nroSerie")
	private String nroSerie;
	 
	@Column(name="fechaRegistro")
	private Timestamp fechaRegistro;
	
	@Column(name="usuarioRegistro")
	private String usuarioRegistro;
	
	@Column(name="ipRegistro")
	private String ipRegistro;
	
	
	public Serie() { 
	}


	public String getIdSerie() {
		return idSerie;
	}


	public void setIdSerie(String idSerie) {
		this.idSerie = idSerie;
	}


	public String getIdTipoComprobanteCat01() {
		return idTipoComprobanteCat01;
	}


	public void setIdTipoComprobanteCat01(String idTipoComprobanteCat01) {
		this.idTipoComprobanteCat01 = idTipoComprobanteCat01;
	}


	public String getNroSerie() {
		return nroSerie;
	}


	public void setNroSerie(String nroSerie) {
		this.nroSerie = nroSerie;
	}


	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
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

	
}