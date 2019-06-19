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
	            name="tipopersona.buscarxid", 
	            procedureName="PKG_TIPO_PERSONA.SP_BUSCAR_X_ID",
	            resultClasses= TipoPersona.class,
	            parameters={
	                  @StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_C_CURSOR", type=void.class ),
	                  @StoredProcedureParameter(mode=ParameterMode.IN,  name="P_ID_TIPO_PERSONA", type=Long.class)
	              }         
	          ),

	          @NamedStoredProcedureQuery(
	              name="tipopersona.buscarTodos", 
	              procedureName="PKG_TIPO_PERSONA.SP_BUSCAR_TODOS",
	              resultClasses= TipoPersona.class,
	              parameters={
	                    @StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_C_CURSOR", type=void.class )
	                }         
	            ),
	          
	          
	          
	        @NamedStoredProcedureQuery(
	            name="tipopersona.buscarxcriterios", 
	            procedureName="PKG_TIPO_PERSONA.SP_BUSCAR_X_CRITERIOS",
	            resultClasses= TipoPersona.class,
	            parameters={
	                  @StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_C_CURSOR", type=void.class ),
	                  @StoredProcedureParameter(mode=ParameterMode.IN,  name="P_NOMBRE_CORTO", type=String.class),
	                  @StoredProcedureParameter(mode=ParameterMode.IN,  name="P_NOMBRE_LARGO", type=String.class)
	              } 
	        ),
	        

	        
	        @NamedStoredProcedureQuery(
	            name="tipopersona.insert", 
	            procedureName="PKG_TIPO_PERSONA.SP_INSERTAR",
	            parameters={
	                  @StoredProcedureParameter(mode=ParameterMode.OUT, name="P_ID_TIPO_PERSONA", type=Long.class ),
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
	            name="tipopersona.update", 
	            procedureName="PKG_TIPO_PERSONA.SP_ACTUALIZAR",
	            parameters={
	                @StoredProcedureParameter(mode=ParameterMode.IN, name="P_ID_TIPO_PERSONA", type=Long.class ),
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
	            name="tipopersona.delete", 
	            procedureName="PKG_TIPO_PERSONA.SP_ELIMINAR",
	            parameters={
	                  @StoredProcedureParameter(mode=ParameterMode.IN, name="P_ID_TIPO_PERSONA", type=Long.class )
	              }         
	        )
	    
	    }
	  )
@Entity
public class TipoPersona 
	extends GenericEntity{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ID_TIPO_PERSONA")
	private long idTipoPersona;

	@Column(name="NOMBRE_CORTO")
	private String nombreCorto;

	@Column(name="NOMBRE_LARGO")
	private String nombreLargo;

	public TipoPersona() {
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

	public long getIdTipoPersona() {
		return idTipoPersona;
	}

	public void setIdTipoPersona(long idTipoPersona) {
		this.idTipoPersona = idTipoPersona;
	}
	
	@Override
	public String toString() {
		return "Tipo_Persona [idTipoPersona=" + idTipoPersona + ", nombreCorto=" + nombreCorto
				+ ", nombreLargo=" + nombreLargo + ", estado="
				+ estado + "]";
	}

}