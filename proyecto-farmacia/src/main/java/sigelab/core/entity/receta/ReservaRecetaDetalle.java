package pe.com.galaxy.systems.apolo.core.entidad.entidad.receta;

import java.io.Serializable;

import javax.persistence.*;

import pe.com.galaxy.systems.apolo.core.entidad.vo.receta.ReservaRecetaDetalleVO;

import java.sql.Timestamp;
import java.math.BigDecimal;

@SuppressWarnings("serial")
@NamedStoredProcedureQueries(
		{
			
		@NamedStoredProcedureQuery(
			name="reservaRecetaDetalle.listarReservasReceta", 
			procedureName="GISEASISTENCIAL.ATEN.SP_RerservaReceta_Listar",
			resultClasses= ReservaRecetaDetalleVO.class,
			parameters={
				@StoredProcedureParameter(mode=ParameterMode.IN, name="FechaInicio", type=String.class ),
				@StoredProcedureParameter(mode=ParameterMode.IN, name="FechaFin", type=String.class ),
			
			}),
			@NamedStoredProcedureQuery(
					name="reservaRecetaDetalle.listarPorCodigo", 
					procedureName="GISEASISTENCIAL.ATEN.SP_ReservaReceta_Buscar_Codigo",
					resultClasses= ReservaRecetaDetalleVO.class,
					parameters={
						@StoredProcedureParameter(mode=ParameterMode.IN, name="CodigoRecetaMedica", type=int.class )
						
					
				})
		}
	)
@Entity
public class ReservaRecetaDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="AuditoriaCodigoUsuario")
	private long auditoriaCodigoUsuario;

	@Column(name="AuditoriaFechaOperacion")
	private Timestamp auditoriaFechaOperacion;

	@Column(name="AuditoriaIdSesion")
	private String auditoriaIdSesion;

	@Column(name="AuditoriaIPNumeroMac")
	private String auditoriaIPNumeroMac;

	@Column(name="AuditoriaObservacion")
	private String auditoriaObservacion;

	@Column(name="AuditoriaTipoOperacion")
	private int auditoriaTipoOperacion;

	@Column(name="CantidadMedicamento")
	private int cantidadMedicamento;

	@Column(name="CodigoArticulo")
	private int codigoArticulo;

	@Column(name="CodigoInstitucionArticulo")
	private int codigoInstitucionArticulo;

	@Column(name="CodigoInstitucionReservaReceta")
	private int codigoInstitucionReservaReceta;

	@Column(name="CodigoInstitucionReservaRecetaDetalle")
	private int codigoInstitucionReservaRecetaDetalle;

	@Column(name="CodigoOrganizacionArticulo")
	private int codigoOrganizacionArticulo;

	@Column(name="CodigoOrganizacionReservaReceta")
	private int codigoOrganizacionReservaReceta;

	@Column(name="CodigoOrganizacionReservaRecetaDetalle")
	private int codigoOrganizacionReservaRecetaDetalle;

	@Column(name="CodigoRegistroReservaReceta")
	private int codigoRegistroReservaReceta;

	@Id
	@Column(name="CodigoRegistroReservaRecetaDetalle")
	private int codigoRegistroReservaRecetaDetalle;

	@Column(name="CodigoSedeArticulo")
	private int codigoSedeArticulo;

	@Column(name="CodigoSedeReservaReceta")
	private int codigoSedeReservaReceta;

	@Column(name="CodigoSedeReservaRecetaDetalle")
	private int codigoSedeReservaRecetaDetalle;

	@Column(name="Estado")
	private int estado;

	@Column(name="EstadoMigracion")
	private int estadoMigracion;

	@Column(name="NumeroPeriodoArticulo")
	private int numeroPeriodoArticulo;

	@Column(name="NumeroPeriodoReservaReceta")
	private int numeroPeriodoReservaReceta;

	@Column(name="NumeroPeriodoReservaRecetaDetalle")
	private int numeroPeriodoReservaRecetaDetalle;

	@Column(name="NumeroVersionArticulo")
	private int numeroVersionArticulo;

	@Column(name="NumeroVersionReservaReceta")
	private int numeroVersionReservaReceta;

	@Column(name="NumeroVersionReservaRecetaDetalle")
	private int numeroVersionReservaRecetaDetalle;
	
	private String fechaInicio;
	private String fechaFin;
	private int codigoReceta;

	public ReservaRecetaDetalle() {
	}

	public long getAuditoriaCodigoUsuario() {
		return this.auditoriaCodigoUsuario;
	}

	public void setAuditoriaCodigoUsuario(long auditoriaCodigoUsuario) {
		this.auditoriaCodigoUsuario = auditoriaCodigoUsuario;
	}

	public Timestamp getAuditoriaFechaOperacion() {
		return this.auditoriaFechaOperacion;
	}

	public void setAuditoriaFechaOperacion(Timestamp auditoriaFechaOperacion) {
		this.auditoriaFechaOperacion = auditoriaFechaOperacion;
	}

	public String getAuditoriaIdSesion() {
		return this.auditoriaIdSesion;
	}

	public void setAuditoriaIdSesion(String auditoriaIdSesion) {
		this.auditoriaIdSesion = auditoriaIdSesion;
	}

	public String getAuditoriaIPNumeroMac() {
		return this.auditoriaIPNumeroMac;
	}

	public void setAuditoriaIPNumeroMac(String auditoriaIPNumeroMac) {
		this.auditoriaIPNumeroMac = auditoriaIPNumeroMac;
	}

	public String getAuditoriaObservacion() {
		return this.auditoriaObservacion;
	}

	public void setAuditoriaObservacion(String auditoriaObservacion) {
		this.auditoriaObservacion = auditoriaObservacion;
	}

	public int getAuditoriaTipoOperacion() {
		return this.auditoriaTipoOperacion;
	}

	public void setAuditoriaTipoOperacion(int auditoriaTipoOperacion) {
		this.auditoriaTipoOperacion = auditoriaTipoOperacion;
	}

	public int getCantidadMedicamento() {
		return this.cantidadMedicamento;
	}

	public void setCantidadMedicamento(int cantidadMedicamento) {
		this.cantidadMedicamento = cantidadMedicamento;
	}

	public int getCodigoArticulo() {
		return this.codigoArticulo;
	}

	public void setCodigoArticulo(int codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public int getCodigoInstitucionArticulo() {
		return this.codigoInstitucionArticulo;
	}

	public void setCodigoInstitucionArticulo(int codigoInstitucionArticulo) {
		this.codigoInstitucionArticulo = codigoInstitucionArticulo;
	}

	public int getCodigoInstitucionReservaReceta() {
		return this.codigoInstitucionReservaReceta;
	}

	public void setCodigoInstitucionReservaReceta(int codigoInstitucionReservaReceta) {
		this.codigoInstitucionReservaReceta = codigoInstitucionReservaReceta;
	}

	public int getCodigoInstitucionReservaRecetaDetalle() {
		return this.codigoInstitucionReservaRecetaDetalle;
	}

	public void setCodigoInstitucionReservaRecetaDetalle(int codigoInstitucionReservaRecetaDetalle) {
		this.codigoInstitucionReservaRecetaDetalle = codigoInstitucionReservaRecetaDetalle;
	}

	public int getCodigoOrganizacionArticulo() {
		return this.codigoOrganizacionArticulo;
	}

	public void setCodigoOrganizacionArticulo(int codigoOrganizacionArticulo) {
		this.codigoOrganizacionArticulo = codigoOrganizacionArticulo;
	}

	public int getCodigoOrganizacionReservaReceta() {
		return this.codigoOrganizacionReservaReceta;
	}

	public void setCodigoOrganizacionReservaReceta(int codigoOrganizacionReservaReceta) {
		this.codigoOrganizacionReservaReceta = codigoOrganizacionReservaReceta;
	}

	public int getCodigoOrganizacionReservaRecetaDetalle() {
		return this.codigoOrganizacionReservaRecetaDetalle;
	}

	public void setCodigoOrganizacionReservaRecetaDetalle(int codigoOrganizacionReservaRecetaDetalle) {
		this.codigoOrganizacionReservaRecetaDetalle = codigoOrganizacionReservaRecetaDetalle;
	}

	public int getCodigoRegistroReservaReceta() {
		return this.codigoRegistroReservaReceta;
	}

	public void setCodigoRegistroReservaReceta(int codigoRegistroReservaReceta) {
		this.codigoRegistroReservaReceta = codigoRegistroReservaReceta;
	}

	public int getCodigoRegistroReservaRecetaDetalle() {
		return this.codigoRegistroReservaRecetaDetalle;
	}

	public void setCodigoRegistroReservaRecetaDetalle(int codigoRegistroReservaRecetaDetalle) {
		this.codigoRegistroReservaRecetaDetalle = codigoRegistroReservaRecetaDetalle;
	}

	public int getCodigoSedeArticulo() {
		return this.codigoSedeArticulo;
	}

	public void setCodigoSedeArticulo(int codigoSedeArticulo) {
		this.codigoSedeArticulo = codigoSedeArticulo;
	}

	public int getCodigoSedeReservaReceta() {
		return this.codigoSedeReservaReceta;
	}

	public void setCodigoSedeReservaReceta(int codigoSedeReservaReceta) {
		this.codigoSedeReservaReceta = codigoSedeReservaReceta;
	}

	public int getCodigoSedeReservaRecetaDetalle() {
		return this.codigoSedeReservaRecetaDetalle;
	}

	public void setCodigoSedeReservaRecetaDetalle(int codigoSedeReservaRecetaDetalle) {
		this.codigoSedeReservaRecetaDetalle = codigoSedeReservaRecetaDetalle;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getEstadoMigracion() {
		return this.estadoMigracion;
	}

	public void setEstadoMigracion(int estadoMigracion) {
		this.estadoMigracion = estadoMigracion;
	}

	public int getNumeroPeriodoArticulo() {
		return this.numeroPeriodoArticulo;
	}

	public void setNumeroPeriodoArticulo(int numeroPeriodoArticulo) {
		this.numeroPeriodoArticulo = numeroPeriodoArticulo;
	}

	public int getNumeroPeriodoReservaReceta() {
		return this.numeroPeriodoReservaReceta;
	}

	public void setNumeroPeriodoReservaReceta(int numeroPeriodoReservaReceta) {
		this.numeroPeriodoReservaReceta = numeroPeriodoReservaReceta;
	}

	public int getNumeroPeriodoReservaRecetaDetalle() {
		return this.numeroPeriodoReservaRecetaDetalle;
	}

	public void setNumeroPeriodoReservaRecetaDetalle(int numeroPeriodoReservaRecetaDetalle) {
		this.numeroPeriodoReservaRecetaDetalle = numeroPeriodoReservaRecetaDetalle;
	}

	public int getNumeroVersionArticulo() {
		return this.numeroVersionArticulo;
	}

	public void setNumeroVersionArticulo(int numeroVersionArticulo) {
		this.numeroVersionArticulo = numeroVersionArticulo;
	}

	public int getNumeroVersionReservaReceta() {
		return this.numeroVersionReservaReceta;
	}

	public void setNumeroVersionReservaReceta(int numeroVersionReservaReceta) {
		this.numeroVersionReservaReceta = numeroVersionReservaReceta;
	}

	public int getNumeroVersionReservaRecetaDetalle() {
		return this.numeroVersionReservaRecetaDetalle;
	}

	public void setNumeroVersionReservaRecetaDetalle(int numeroVersionReservaRecetaDetalle) {
		this.numeroVersionReservaRecetaDetalle = numeroVersionReservaRecetaDetalle;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getCodigoReceta() {
		return codigoReceta;
	}

	public void setCodigoReceta(int codigoReceta) {
		this.codigoReceta = codigoReceta;
	}

}