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
	            name="turno.buscarxid", 
	            procedureName="SP_TURNO_BUSCAR_X_ID",
	            resultClasses= Turno.class,
	            parameters={
	               //   @StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
	                  @StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_TURNO", type=Long.class)
	              }         
	          ),

	          @NamedStoredProcedureQuery(
	              name="turno.buscarTodos", 
	              procedureName="SP_TURNO_BUSCAR_TODOS",
	              resultClasses= Turno.class
	             /* parameters={
	                    @StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class )
	                } */        
	            ),
	          
	          
	          
	        @NamedStoredProcedureQuery(
	            name="turno.buscarxcriterios", 
	            procedureName="SP_TURNO_BUSCAR_X_CRITERIOS",
	            resultClasses= Turno.class,
	            parameters={
	              //    @StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
	                  @StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_CORTO", type=String.class),
	                  @StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_LARGO", type=String.class)
	              } 
	        ),
	        

	        
	        @NamedStoredProcedureQuery(
	            name="turno.insert", 
	            procedureName="SP_TURNO_INSERTAR",
	            parameters={
	                  @StoredProcedureParameter(mode=ParameterMode.OUT, name="ID_TURNO", type=Long.class ),
	                  @StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_CORTO", type=String.class),
	                  @StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_LARGO", type=String.class),
	                  
	                  @StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SITUACION", type=Long.class ),
	                  @StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_USUARIO", type=Long.class ),
	                  @StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class),
	                  @StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
	                  @StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_OPERACION", type=Long.class)
	              }         
	        ),
	        @NamedStoredProcedureQuery(
	            name="turno.update", 
	            procedureName="SP_TURNO_ACTUALIZAR",
	            parameters={
	                @StoredProcedureParameter(mode=ParameterMode.IN, name="ID_TURNO", type=Long.class ),
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
		            name="turno.validarTurnoSeguridad", 
		            procedureName="SP_TURNO_VALIDAR_TURNO_HORA",
		            resultClasses= Turno.class,
		            parameters={
		               //   @StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
		                  @StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_TURNO", type=Long.class)
		              }         
		          ),
	        @NamedStoredProcedureQuery(
	            name="turno.delete", 
	            procedureName="SP_TURNO_ELIMINAR",
	            parameters={
	                  @StoredProcedureParameter(mode=ParameterMode.IN, name="ID_TURNO", type=Long.class )
	              }         
	        )
	    
	    }
	  )
@Entity
public class Turno 
	extends GenericEntity{
	private static final int serialVersionUID = 1;
	
	@Id
	@Column(name="ID_TURNO")
	private int idTurno;

	@Column(name="NOMBRE_CORTO")
	private String nombreCorto;

	@Column(name="NOMBRE_LARGO")
	private String nombreLargo;

	@Column(name="HORA_INICIO")
	private String horaInicio;
	
	@Column(name="HORA_TERMINO")
	private String horaTermino;
	
	public Turno() {
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

	public int getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(int idTurno) {
		this.idTurno = idTurno;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraTermino() {
		return horaTermino;
	}

	public void setHoraTermino(String horaTermino) {
		this.horaTermino = horaTermino;
	}

	@Override
	public String toString() {
		return "Turno [idTurno=" + idTurno + ", nombreCorto=" + nombreCorto + ", nombreLargo=" + nombreLargo + "]";
	}


}