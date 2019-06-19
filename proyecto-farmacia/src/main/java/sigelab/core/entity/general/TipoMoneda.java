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
	            name="tipomoneda.buscarxid", 
	            procedureName="PKG_TIPO_MONEDA.SP_BUSCAR_X_ID",
	            resultClasses= TipoMoneda.class,
	            parameters={
	                  @StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_C_CURSOR", type=void.class ),
	                  @StoredProcedureParameter(mode=ParameterMode.IN,  name="P_ID_TIPO_MONEDA", type=Long.class)
	              }         
	          ),

	          @NamedStoredProcedureQuery(
	              name="tipomoneda.buscarTodos", 
	              procedureName="PKG_TIPO_MONEDA.SP_BUSCAR_TODOS",
	              resultClasses= TipoMoneda.class,
	              parameters={
	                    @StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_C_CURSOR", type=void.class )
	                }         
	            ),
	          
	          
	          
	        @NamedStoredProcedureQuery(
	            name="tipomoneda.buscarxcriterios", 
	            procedureName="PKG_TIPO_MONEDA.SP_BUSCAR_X_CRITERIOS",
	            resultClasses= TipoMoneda.class,
	            parameters={
	                  @StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_C_CURSOR", type=void.class ),
	                  @StoredProcedureParameter(mode=ParameterMode.IN,  name="P_NOMBRE_CORTO", type=String.class),
	                  @StoredProcedureParameter(mode=ParameterMode.IN,  name="P_NOMBRE_LARGO", type=String.class)
	              } 
	        ),
	        

	        
	        @NamedStoredProcedureQuery(
	            name="tipomoneda.insert", 
	            procedureName="PKG_TIPO_MONEDA.SP_INSERTAR",
	            parameters={
	                  @StoredProcedureParameter(mode=ParameterMode.OUT, name="P_ID_TIPO_MONEDA", type=Long.class ),
	                  @StoredProcedureParameter(mode=ParameterMode.IN,  name="P_NOMBRE_CORTO", type=String.class),
	                  @StoredProcedureParameter(mode=ParameterMode.IN,  name="P_NOMBRE_LARGO", type=String.class),
	                  
	                  @StoredProcedureParameter(mode=ParameterMode.IN, name="P_ID_SITUACION", type=Long.class ),
	                  @StoredProcedureParameter(mode=ParameterMode.IN, name="P_AUD_ID_USUARIO", type=Long.class ),
	                  @StoredProcedureParameter(mode=ParameterMode.IN,  name="P_AUD_IP", type=String.class),
	                  @StoredProcedureParameter(mode=ParameterMode.IN,  name="P_AUD_SESSION", type=String.class),
	                  @StoredProcedureParameter(mode=ParameterMode.IN,  name="P_AUD_ID_OPERACION", type=Long.class)
	              }         
	        ),
	        @NamedStoredProcedureQuery(
	            name="tipomoneda.update", 
	            procedureName="PKG_TIPO_MONEDA.SP_ACTUALIZAR",
	            parameters={
	                @StoredProcedureParameter(mode=ParameterMode.IN, name="P_ID_TIPO_MONEDA", type=Long.class ),
	                @StoredProcedureParameter(mode=ParameterMode.IN, name="P_NOMBRE_CORTO", type=String.class),
	                @StoredProcedureParameter(mode=ParameterMode.IN, name="P_NOMBRE_LARGO", type=String.class),
	                
	                @StoredProcedureParameter(mode=ParameterMode.IN, name="P_ID_SITUACION", type=Long.class ),
	                @StoredProcedureParameter(mode=ParameterMode.IN, name="P_AUD_ID_USUARIO", type=Long.class ),
	                @StoredProcedureParameter(mode=ParameterMode.IN, name="P_AUD_IP", type=String.class),
	                @StoredProcedureParameter(mode=ParameterMode.IN, name="P_AUD_SESSION", type=String.class),
	                @StoredProcedureParameter(mode=ParameterMode.IN, name="P_AUD_ID_OPERACION", type=Long.class)
	            }         
	                    
	        ),
	        @NamedStoredProcedureQuery(
	            name="tipomoneda.delete", 
	            procedureName="PKG_TIPO_MONEDA.SP_ELIMINAR",
	            parameters={
	                  @StoredProcedureParameter(mode=ParameterMode.IN, name="P_ID_TIPO_MONEDA", type=Long.class )
	              }         
	        )
	    
	    }
	  )
@Entity
public class TipoMoneda 
	extends GenericEntity{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ID_TIPO_MONEDA")
	private long idTipoMoneda;

	@Column(name="NOMBRE_CORTO")
	private String nombreCorto;

	@Column(name="NOMBRE_LARGO")
	private String nombreLargo;

	public TipoMoneda() {
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

	public long getIdTipoMoneda() {
		return idTipoMoneda;
	}

	public void setIdTipoMoneda(long idTipoMoneda) {
		this.idTipoMoneda = idTipoMoneda;
	}
	
	@Override
	public String toString() {
		return "Tipo_Moneda [idTipoMoneda=" + idTipoMoneda + ", nombreCorto=" + nombreCorto
				+ ", nombreLargo=" + nombreLargo + ", estado="
				+ estado + "]";
	}

}