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
						name="turno.buscarPorObjeto", 
						procedureName="[usp_Turno_buscarxID]",
						resultClasses= Turno.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="idTurno", type=String.class)
							}					
					),
				@NamedStoredProcedureQuery(
						name="turno.buscarPorFiltros", 
						procedureName="[usp_Turno_buscarxCriterios]",
						resultClasses= Turno.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="nombreTurno", type=String.class) 
							}	
				),
				
				@NamedStoredProcedureQuery(
						name="turno.insert", 
						procedureName="[usp_Turno_insertar]",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="idTurno", type=String.class ), 
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="nombreTurno", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="descripcion", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="alias", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioRegistro", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipRegistro", type=String.class )
							}					
				),
				
				@NamedStoredProcedureQuery(
						name="turno.update", 
						procedureName="[dbo].[usp_Turno_actualizar]",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="idTurno", 		  type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="nombreTurno", 	  type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="descripcion",   	  type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="alias", 			  type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioModificacion", type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipModificacion", 	  type=String.class)
						}					
										
				),
				@NamedStoredProcedureQuery(
						name="turno.delete", 
						procedureName="[dbo].[usp_Turno_eliminar]",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="idTurno", 			 type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="usuarioModificacion", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ipModificacion", 	 type=String.class)
							}					
				),
				@NamedStoredProcedureQuery(
						name="turno.buscarTodos", 
						procedureName="[dbo].[usp_Turno_buscarTodos]",
						resultClasses= Turno.class,
						parameters={
							
							}				
					),
				@NamedStoredProcedureQuery(
						name="turno.listaDbf", 
						procedureName="SP_ALMACEN_EXP_DBF",
						resultClasses= Turno.class,
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="idTurno", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class )
							}				
					)
		
		}
	)
@Entity
@Table(name="TURNO")
public class Turno  {
	
	@Id
	@Column(name="idTurno")
	private String idTurno;

	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="nombreTurno")
	private String nombreTurno;
	
	@Column(name="horaInicio")
	private String horaInicio;
	
	@Column(name="horaTermino")
	private String horaTermino;
	 
	@Column(name="usuarioRegistro")
	private String usuarioRegistro;
	
	@Column(name="ipRegistro")
	private String ipRegistro;
	
	
	public Turno() { 
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(String idTurno) {
		this.idTurno = idTurno;
	}

	public String getNombreTurno() {
		return nombreTurno;
	}

	public void setNombreTurno(String nombreTurno) {
		this.nombreTurno = nombreTurno;
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
		return "Turno [idTurno=" + idTurno + ", descripcion=" + descripcion + ", nombreTurno=" + nombreTurno
				+ ", horaInicio=" + horaInicio + ", horaTermino=" + horaTermino + ", usuarioRegistro=" + usuarioRegistro
				+ ", ipRegistro=" + ipRegistro + "]";
	}
 
	
}