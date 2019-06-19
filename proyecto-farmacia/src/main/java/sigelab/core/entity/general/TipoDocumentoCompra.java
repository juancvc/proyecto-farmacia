package pe.com.galaxy.systems.apolo.core.entidad.entidad.general;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import pe.com.galaxy.systems.apolo.core.entidad.GenericEntity;
@NamedStoredProcedureQueries(
		{
				
				@NamedStoredProcedureQuery(
						name="tipodocumentocompra.buscarxid", 
						procedureName="SP_TIPO_DOCUMENTO_COMPRA_BUSCAR_X_ID",
						resultClasses= TipoDocumentoCompra.class,
						parameters={
									//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_TIPO_DOCUMENTO_COMPRA", type=Long.class)
							}					
					),
				@NamedStoredProcedureQuery(
						name="tipodocumentocompra.buscarxcriterios", 
						procedureName="SP_TIPO_DOCUMENTO_COMPRA_BUSCAR_X_CRITERIOS",
						resultClasses= TipoDocumentoCompra.class,
						parameters={
								//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_CORTO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_LARGO", type=String.class)
							}	
				),
				@NamedStoredProcedureQuery(
						name="tipodocumentocompra.buscarTodos", 
						procedureName="SP_TIPO_DOCUMENTO_COMPRA_BUSCAR_TODOS",
						resultClasses= TipoDocumentoCompra.class
				),
				@NamedStoredProcedureQuery(
						name="tipodocumentocompra.insert", 
						procedureName="SP_TIPO_DOCUMENTO_COMPRA_INSERTAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="ID_TIPO_DOCUMENTO_COMPRA", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_CORTO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_LARGO", type=String.class),
									
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SITUACION", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_USUARIO", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_OPERACION", type=Long.class)
							}					
				),
				@NamedStoredProcedureQuery(
						name="tipodocumentocompra.update", 
						procedureName="SP_TIPO_DOCUMENTO_COMPRA_ACTUALIZAR",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_TIPO_DOCUMENTO_COMPRA", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NOMBRE_CORTO", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="NOMBRE_LARGO", type=String.class),
								
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SITUACION", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_USUARIO", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_IP", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_SESSION", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_OPERACION", type=Long.class)
						}					
										
				),
				@NamedStoredProcedureQuery(
						name="tipodocumentocompra.delete", 
						procedureName="SP_TIPO_DOCUMENTO_COMPRA_ELIMINAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_TIPO_DOCUMENTO_COMPRA", type=Long.class )
							}					
				)
		
		}
	)
@Entity
public class TipoDocumentoCompra extends GenericEntity{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_TIPO_DOCUM_COMPRA")
	private long idTipoDocumentoCompra;

	@Column(name="NOMBRE_CORTO")
	private String nombreCorto;

	@Column(name="NOMBRE_LARGO")
	private String nombreLargo;

	public TipoDocumentoCompra() {
	}

	
	public long getIdTipoDocumentoCompra() {
		return idTipoDocumentoCompra;
	}


	public void setIdTipoDocumentoCompra(long idTipoDocumentoCompra) {
		this.idTipoDocumentoCompra = idTipoDocumentoCompra;
	}


	public String getNombreCorto() {
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	public String getNombreLargo() {
		return nombreLargo;
	}

	public void setNombreLargo(String nombreLargo) {
		this.nombreLargo = nombreLargo;
	}
	
}
