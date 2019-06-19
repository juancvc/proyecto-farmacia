package pe.com.galaxy.systems.apolo.core.entidad.entidad.general;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import pe.com.galaxy.systems.apolo.core.entidad.GenericEntity;
@NamedStoredProcedureQueries(
		{
				
				@NamedStoredProcedureQuery(
						name="programas.findByObject", 
						procedureName="PKG_PROGRAMAS.SP_BUSCAR_X_ID",
						resultClasses= Programas.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_ID_PROGRAMAS", type=Long.class)
							}					
					),
				@NamedStoredProcedureQuery(
						name="programas.findByLikeObject", 
						procedureName="PKG_PROGRAMAS.SP_BUSCAR_X_CRITERIOS",
						resultClasses= Programas.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="P_NOMBRE_CORTO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="P_NOMBRE_LARGO", type=String.class)
							}	
				),
				
				@NamedStoredProcedureQuery(
						name="programas.insert", 
						procedureName="PKG_PROGRAMAS.SP_INSERTAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="P_ID_PROGRAMAS", type=Long.class ),
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
						name="programas.update", 
						procedureName="PKG_PROGRAMAS.SP_ACTUALIZAR",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="P_ID_PROGRAMAS", type=Long.class ),
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
						name="programas.delete", 
						procedureName="PKG_PROGRAMAS.SP_ELIMINAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="P_ID_PROGRAMAS", type=Long.class )
							}					
				),
				@NamedStoredProcedureQuery(
						name="programas.buscarTodos", 
						procedureName="PKG_PROGRAMAS.SP_BUSCAR_TODOS",
						resultClasses= Programas.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_C_CURSOR", type=void.class )
							}					
					),
				
				/** COMBO PARA VENTAS - ESTRATEGICO **/
				@NamedStoredProcedureQuery(
						name="programas.cbobuscarxcriterios", 
						procedureName="SP_PROGRAMA_BUSCAR_CRITERIOS",
						resultClasses= Programas.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="TIPO", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_PADRE", type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_CORTO", type=String.class)
							}	
				)
		
		}
	)
@Entity
@Table(name="PROGRAMAS")
public class Programas 
	extends GenericEntity{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ID_PROGRAMA")
	private long idPrograma;

	@Column(name="NOMBRE_CORTO")
	private String nombreCorto;

	@Column(name="NOMBRE_LARGO")
	private String nombreLargo;
	
	@Column(name="AUD_ID_USUARIO")
	private int idPadre;
	
	private int tipoBusqueda;

	public Programas() {
		
	}
	
	public long getIdPrograma() {
		return idPrograma;
	}

	public void setIdPrograma(long idPrograma) {
		this.idPrograma = idPrograma;
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

	public int getIdPadre() {
		return idPadre;
	}

	public void setIdPadre(int idPadre) {
		this.idPadre = idPadre;
	}

	public int getTipoBusqueda() {
		return tipoBusqueda;
	}

	public void setTipoBusqueda(int tipoBusqueda) {
		this.tipoBusqueda = tipoBusqueda;
	}

	@Override
	public String toString() {
		return "Programas [idPrograma=" + idPrograma + ", nombreCorto=" + nombreCorto + ", nombreLargo=" + nombreLargo
				+ ", idPadre=" + idPadre + ", tipoBusqueda=" + tipoBusqueda + "]";
	}
	
	

}