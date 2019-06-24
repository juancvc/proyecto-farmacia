package proyect.core.entity.stock;

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
						name="laboratorio.findByObject", 
						procedureName="[dbo].[usp_Laboratorio_buscarxID]",
						resultClasses= Laboratorio.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idLaboratorio", type=Long.class)
							}					
					),
				@NamedStoredProcedureQuery(
						name="laboratorio.findByLikeObject", 
						procedureName="[dbo].[usp_Laboratorio_buscarxCriterios]",
						resultClasses= Laboratorio.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="nombreLaboratorio", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="descripcion", type=String.class)
							}	
				),
				
				@NamedStoredProcedureQuery(
						name="laboratorio.buscarTodos", 
						procedureName="[dbo].[usp_Laboratorio_buscarTodos]",
						resultClasses= Laboratorio.class
						/*parameters={
									@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class )
									
							}	*/				
					),
					
				@NamedStoredProcedureQuery(
						name="laboratorio.insert", 
						procedureName="[dbo].[usp_Laboratorio_insertar]",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="idLaboratorio", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="nombreLaboratorio", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="descripcion", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="usuarioRegistro", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipRegistro", type=String.class)
							}					
				),
				@NamedStoredProcedureQuery(
						name="laboratorio.update", 
						procedureName="[dbo].[usp_Laboratorio_actualizar]",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="idLaboratorio", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="nombreLaboratorio", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="descripcion", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="usuarioModificacion", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipModificacion", type=String.class)
						}					
										
				),
				@NamedStoredProcedureQuery(
						name="laboratorio.delete", 
						procedureName="[dbo].[usp_Laboratorio_eliminar]",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="idLaboratorio", type=Long.class )
							}					
				),
				@NamedStoredProcedureQuery(
						name="laboratorio.validar", 
						procedureName="dbo.SP_PRESENTACION_VALIDAR",
						resultClasses= Laboratorio.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN,name="idLaboratorio", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,name="nombreLaboratorio", type=String.class )
							}				
					)				
		
		}
	)
@Entity
public class Laboratorio  {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="idLaboratorio")
	private long idLaboratorio;

	@Column(name="nombreLaboratorio")
	private String nombreCorto;

	@Column(name="descripcion")
	private String nombreLargo;
	
	@Column(name="ID_ORGANIZACION_LABORATORIO")
	private int idOrganizacionLaboratorio;
	
	@Column(name="ID_INSTITUCION_LABORATORIO")
	private int idInstitucionLaboratorio;
	
	@Column(name="ID_SEDE_LABORATORIO")
	private int idSedeLaboratorio;
	
	@Column(name="NRO_VERSION_LABORATORIO")
	private int nroVersionLaboratorio;
	
	@Column(name="NRO_PERIODO_LABORATORIO")
	private int nroPeriodoLaboratorio;
	
	@Column(name="AUD_FECHA_OPERACION")
	private  Timestamp 	aud_fechaOperacion;
	
	public Laboratorio() { 
	}


	public int getIdOrganizacionLaboratorio() {
		return idOrganizacionLaboratorio;
	}


	public void setIdOrganizacionLaboratorio(int idOrganizacionLaboratorio) {
		this.idOrganizacionLaboratorio = idOrganizacionLaboratorio;
	}


	public int getIdInstitucionLaboratorio() {
		return idInstitucionLaboratorio;
	}


	public void setIdInstitucionLaboratorio(int idInstitucionLaboratorio) {
		this.idInstitucionLaboratorio = idInstitucionLaboratorio;
	}


	public int getIdSedeLaboratorio() {
		return idSedeLaboratorio;
	}


	public void setIdSedeLaboratorio(int idSedeLaboratorio) {
		this.idSedeLaboratorio = idSedeLaboratorio;
	}


	public int getNroVersionLaboratorio() {
		return nroVersionLaboratorio;
	}


	public void setNroVersionLaboratorio(int nroVersionLaboratorio) {
		this.nroVersionLaboratorio = nroVersionLaboratorio;
	}


	public int getNroPeriodoLaboratorio() {
		return nroPeriodoLaboratorio;
	}


	public void setNroPeriodoLaboratorio(int nroPeriodoLaboratorio) {
		this.nroPeriodoLaboratorio = nroPeriodoLaboratorio;
	}


	public long getIdLaboratorio() {
		return idLaboratorio;
	}

	public void setIdLaboratorio(long idLaboratorio) {
		this.idLaboratorio = idLaboratorio;
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

	
	public Timestamp getAud_fechaOperacion() {
		return aud_fechaOperacion;
	}


	public void setAud_fechaOperacion(Timestamp aud_fechaOperacion) {
		this.aud_fechaOperacion = aud_fechaOperacion;
	}

 
	
}