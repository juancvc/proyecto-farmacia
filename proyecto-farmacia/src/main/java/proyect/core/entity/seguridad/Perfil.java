package proyect.core.entity.seguridad;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@NamedStoredProcedureQueries({

		@NamedStoredProcedureQuery(name = "perfil.buscarxid", procedureName = "SP_PERFIL_BUSCAR_X_ID", resultClasses = Perfil.class, parameters = {
				// @StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR",
				// type=void.class ),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_PERFIL", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_ORGANIZACION", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_INSTITUCION", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_SEDE", type = int.class) }),

		@NamedStoredProcedureQuery(name = "perfil.buscarTodos", procedureName = "SP_PERFIL_BUSCAR_TODOS", resultClasses = Perfil.class
		/*
		 * parameters={
		 * 
		 * @StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR",
		 * type=void.class ) }
		 */
		),

		@NamedStoredProcedureQuery(name = "perfil.buscarxcriterios", procedureName = "[dbo].[usp_Perfil_buscarxCriterios]", resultClasses = Perfil.class, parameters = {
				// @StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR",
				// type=void.class ),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "nombrePerfil", type = String.class) }),

		@NamedStoredProcedureQuery(name = "perfil.insertar", procedureName = "usp_Perfil_insertar", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "idPerfil", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "nombrePerfil", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "descripcion", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "usuarioRegistro", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ipRegistro", type = String.class) }),

		@NamedStoredProcedureQuery(name = "perfil.update", procedureName = "SP_PERFIL_ACTUALIZAR", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_PERFIL", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_ORGANIZACION", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_INSTITUCION", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_SEDE", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NOMBRE_CORTO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NOMBRE_LARGO", type = String.class),

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_SITUACION", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUD_ID_USUARIO", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUD_IP", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUD_SESSION", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUD_ID_OPERACION", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUD_MAC", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUD_OBSERVACION", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "perfil.delete", procedureName = "SP_PERFIL_ELIMINAR", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_PERFIL", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_ORGANIZACION", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_INSTITUCION", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_SEDE", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUD_ID_USUARIO", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUD_IP", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUD_SESSION", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUD_ID_OPERACION", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUD_MAC", type = String.class) })

})

@Entity
public class Perfil {
	private static final int serialVersionUID = 1;
	@Id
	@Column(name = "idPerfil")
	private String idPerfil;

	@Column(name = "nombrePerfil")
	private String nombrePerfil;

	@Column(name = "descripcion")
	private String descripcion;

	public Perfil() {
	}

	public String getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(String idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getNombrePerfil() {
		return nombrePerfil;
	}

	public void setNombrePerfil(String nombrePerfil) {
		this.nombrePerfil = nombrePerfil;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}