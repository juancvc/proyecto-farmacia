package proyect.core.entity.general;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;

@NamedStoredProcedureQueries(
		{
					
				@NamedStoredProcedureQuery(
						name="renaes.buscarPorCriteriosRenaes", 
						procedureName="[GISEASISTENCIAL].[ADMI].[SP_Renaes_BuscarPorCriterios]",
						resultClasses= Renaes.class,
						parameters=	{
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="CodigoRenaes", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NombreRenaes", type=String.class)
									}					
				)
		}
	)


@Entity
@Table(name="ADMI.Renaes")
public class Renaes implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RenaesPK id;

	@Column(name="Categoria")
	private String categoria;

	@Column(name="CodigoDisa")
	private String codigoDisa;

	@Column(name="CodigoMicroRed")
	private String codigoMicroRed;

	@Column(name="CodigoRed")
	private String codigoRed;

	@Column(name="CodigoRenaes")
	private String codigoRenaes;

	@Column(name="CodigoUnidadEjecutora")
	private double codigoUnidadEjecutora;

	@Column(name="Condicion")
	private String condicion;

	@Column(name="Cota")
	private double cota;

	@Column(name="Departamento")
	private String departamento;

	@Column(name="DescripcionMicroRed")
	private String descripcionMicroRed;

	@Column(name="Direccion")
	private String direccion;

	@Column(name="Disa")
	private String disa;

	@Column(name="Distrito")
	private String distrito;

	@Column(name="Estado")
	private String estado;

	@Column(name="Este")
	private double este;

	@Column(name="Horario")
	private String horario;

	@Column(name="InicioActividades")
	private Timestamp inicioActividades;

	@Column(name="Inspeccion")
	private String inspeccion;

	@Column(name="Institucion")
	private String institucion;

	@Column(name="NombreRenaes")
	private String nombreRenaes;

	@Column(name="Norte")
	private double norte;

	@Column(name="NumeroDocumentoCategoria")
	private String numeroDocumentoCategoria;

	@Column(name="Provincia")
	private String provincia;

	@Column(name="Red")
	private String red;

	@Column(name="Responsable")
	private String responsable;

	@Column(name="Situacion")
	private String situacion;

	@Column(name="SwitchEstablecimiento")
	private String switchEstablecimiento;

	@Column(name="Telefono")
	private String telefono;

	@Column(name="TipoDocumentoCategoria")
	private String tipoDocumentoCategoria;

	@Column(name="TipoRenaes")
	private String tipoRenaes;

	@Column(name="Ubigeo")
	private String ubigeo;

	@Column(name="UnidadEjecutora")
	private String unidadEjecutora;

	public Renaes() {
	}

	public RenaesPK getId() {
		return this.id;
	}

	public void setId(RenaesPK id) {
		this.id = id;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCodigoDisa() {
		return this.codigoDisa;
	}

	public void setCodigoDisa(String codigoDisa) {
		this.codigoDisa = codigoDisa;
	}

	public String getCodigoMicroRed() {
		return this.codigoMicroRed;
	}

	public void setCodigoMicroRed(String codigoMicroRed) {
		this.codigoMicroRed = codigoMicroRed;
	}

	public String getCodigoRed() {
		return this.codigoRed;
	}

	public void setCodigoRed(String codigoRed) {
		this.codigoRed = codigoRed;
	}

	public String getCodigoRenaes() {
		return this.codigoRenaes;
	}

	public void setCodigoRenaes(String codigoRenaes) {
		this.codigoRenaes = codigoRenaes;
	}

	public double getCodigoUnidadEjecutora() {
		return this.codigoUnidadEjecutora;
	}

	public void setCodigoUnidadEjecutora(double codigoUnidadEjecutora) {
		this.codigoUnidadEjecutora = codigoUnidadEjecutora;
	}

	public String getCondicion() {
		return this.condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	public double getCota() {
		return this.cota;
	}

	public void setCota(double cota) {
		this.cota = cota;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDescripcionMicroRed() {
		return this.descripcionMicroRed;
	}

	public void setDescripcionMicroRed(String descripcionMicroRed) {
		this.descripcionMicroRed = descripcionMicroRed;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDisa() {
		return this.disa;
	}

	public void setDisa(String disa) {
		this.disa = disa;
	}

	public String getDistrito() {
		return this.distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public double getEste() {
		return this.este;
	}

	public void setEste(double este) {
		this.este = este;
	}

	public String getHorario() {
		return this.horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Timestamp getInicioActividades() {
		return this.inicioActividades;
	}

	public void setInicioActividades(Timestamp inicioActividades) {
		this.inicioActividades = inicioActividades;
	}

	public String getInspeccion() {
		return this.inspeccion;
	}

	public void setInspeccion(String inspeccion) {
		this.inspeccion = inspeccion;
	}

	public String getInstitucion() {
		return this.institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public String getNombreRenaes() {
		return this.nombreRenaes;
	}

	public void setNombreRenaes(String nombreRenaes) {
		this.nombreRenaes = nombreRenaes;
	}

	public double getNorte() {
		return this.norte;
	}

	public void setNorte(double norte) {
		this.norte = norte;
	}

	public String getNumeroDocumentoCategoria() {
		return this.numeroDocumentoCategoria;
	}

	public void setNumeroDocumentoCategoria(String numeroDocumentoCategoria) {
		this.numeroDocumentoCategoria = numeroDocumentoCategoria;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getRed() {
		return this.red;
	}

	public void setRed(String red) {
		this.red = red;
	}

	public String getResponsable() {
		return this.responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getSituacion() {
		return this.situacion;
	}

	public void setSituacion(String situacion) {
		this.situacion = situacion;
	}

	public String getSwitchEstablecimiento() {
		return this.switchEstablecimiento;
	}

	public void setSwitchEstablecimiento(String switchEstablecimiento) {
		this.switchEstablecimiento = switchEstablecimiento;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTipoDocumentoCategoria() {
		return this.tipoDocumentoCategoria;
	}

	public void setTipoDocumentoCategoria(String tipoDocumentoCategoria) {
		this.tipoDocumentoCategoria = tipoDocumentoCategoria;
	}

	public String getTipoRenaes() {
		return this.tipoRenaes;
	}

	public void setTipoRenaes(String tipoRenaes) {
		this.tipoRenaes = tipoRenaes;
	}

	public String getUbigeo() {
		return this.ubigeo;
	}

	public void setUbigeo(String ubigeo) {
		this.ubigeo = ubigeo;
	}

	public String getUnidadEjecutora() {
		return this.unidadEjecutora;
	}

	public void setUnidadEjecutora(String unidadEjecutora) {
		this.unidadEjecutora = unidadEjecutora;
	}

}