package sigelab.core.entity.receta;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the ReservaReceta database table.
 * 
 */
@Entity
public class ReservaReceta implements Serializable {
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

	@Column(name="CodigoInstitucionalEpisodio")
	private int codigoInstitucionalEpisodio;

	@Column(name="CodigoInstitucionRecetaMedica")
	private int codigoInstitucionRecetaMedica;

	@Column(name="CodigoInstitucionReservaReceta")
	private int codigoInstitucionReservaReceta;

	@Column(name="CodigoMedico")
	private long codigoMedico;

	@Column(name="CodigoOrganizacionEpisodio")
	private int codigoOrganizacionEpisodio;

	@Column(name="CodigoOrganizacionRecetaMedica")
	private int codigoOrganizacionRecetaMedica;

	@Column(name="CodigoOrganizacionReservaReceta")
	private int codigoOrganizacionReservaReceta;

	@Column(name="CodigoRecetaMedica")
	private int codigoRecetaMedica;

	@Column(name="CodigoRegistroEpisodio")
	private int codigoRegistroEpisodio;
	
	@Id
	@Column(name="CodigoRegistroReservaReceta")
	private int codigoRegistroReservaReceta;

	@Column(name="CodigoSedeEpisodio")
	private int codigoSedeEpisodio;

	@Column(name="CodigoSedeRecetaMedica")
	private int codigoSedeRecetaMedica;

	@Column(name="CodigoSedeReservaReceta")
	private int codigoSedeReservaReceta;

	@Column(name="Estado")
	private int estado;

	@Column(name="EstadoMigracion")
	private int estadoMigracion;

	@Column(name="FechaEmision")
	private Timestamp fechaEmision;

	@Column(name="NumeroPeriodoEpisodio")
	private int numeroPeriodoEpisodio;

	@Column(name="NumeroPeriodoRecetaMedica")
	private int numeroPeriodoRecetaMedica;

	@Column(name="NumeroPeriodoReservaReceta")
	private int numeroPeriodoReservaReceta;

	@Column(name="NumeroVersionEpisodio")
	private int numeroVersionEpisodio;

	@Column(name="NumeroVersionRecetaMedica")
	private int numeroVersionRecetaMedica;

	@Column(name="NumeroVersionReservaReceta")
	private int numeroVersionReservaReceta;

	public ReservaReceta() {
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

	public int getCodigoInstitucionalEpisodio() {
		return this.codigoInstitucionalEpisodio;
	}

	public void setCodigoInstitucionalEpisodio(int codigoInstitucionalEpisodio) {
		this.codigoInstitucionalEpisodio = codigoInstitucionalEpisodio;
	}

	public int getCodigoInstitucionRecetaMedica() {
		return this.codigoInstitucionRecetaMedica;
	}

	public void setCodigoInstitucionRecetaMedica(int codigoInstitucionRecetaMedica) {
		this.codigoInstitucionRecetaMedica = codigoInstitucionRecetaMedica;
	}

	public int getCodigoInstitucionReservaReceta() {
		return this.codigoInstitucionReservaReceta;
	}

	public void setCodigoInstitucionReservaReceta(int codigoInstitucionReservaReceta) {
		this.codigoInstitucionReservaReceta = codigoInstitucionReservaReceta;
	}

	public long getCodigoMedico() {
		return this.codigoMedico;
	}

	public void setCodigoMedico(long codigoMedico) {
		this.codigoMedico = codigoMedico;
	}

	public int getCodigoOrganizacionEpisodio() {
		return this.codigoOrganizacionEpisodio;
	}

	public void setCodigoOrganizacionEpisodio(int codigoOrganizacionEpisodio) {
		this.codigoOrganizacionEpisodio = codigoOrganizacionEpisodio;
	}

	public int getCodigoOrganizacionRecetaMedica() {
		return this.codigoOrganizacionRecetaMedica;
	}

	public void setCodigoOrganizacionRecetaMedica(int codigoOrganizacionRecetaMedica) {
		this.codigoOrganizacionRecetaMedica = codigoOrganizacionRecetaMedica;
	}

	public int getCodigoOrganizacionReservaReceta() {
		return this.codigoOrganizacionReservaReceta;
	}

	public void setCodigoOrganizacionReservaReceta(int codigoOrganizacionReservaReceta) {
		this.codigoOrganizacionReservaReceta = codigoOrganizacionReservaReceta;
	}

	public int getCodigoRecetaMedica() {
		return this.codigoRecetaMedica;
	}

	public void setCodigoRecetaMedica(int codigoRecetaMedica) {
		this.codigoRecetaMedica = codigoRecetaMedica;
	}

	public int getCodigoRegistroEpisodio() {
		return this.codigoRegistroEpisodio;
	}

	public void setCodigoRegistroEpisodio(int codigoRegistroEpisodio) {
		this.codigoRegistroEpisodio = codigoRegistroEpisodio;
	}

	public int getCodigoRegistroReservaReceta() {
		return this.codigoRegistroReservaReceta;
	}

	public void setCodigoRegistroReservaReceta(int codigoRegistroReservaReceta) {
		this.codigoRegistroReservaReceta = codigoRegistroReservaReceta;
	}

	public int getCodigoSedeEpisodio() {
		return this.codigoSedeEpisodio;
	}

	public void setCodigoSedeEpisodio(int codigoSedeEpisodio) {
		this.codigoSedeEpisodio = codigoSedeEpisodio;
	}

	public int getCodigoSedeRecetaMedica() {
		return this.codigoSedeRecetaMedica;
	}

	public void setCodigoSedeRecetaMedica(int codigoSedeRecetaMedica) {
		this.codigoSedeRecetaMedica = codigoSedeRecetaMedica;
	}

	public int getCodigoSedeReservaReceta() {
		return this.codigoSedeReservaReceta;
	}

	public void setCodigoSedeReservaReceta(int codigoSedeReservaReceta) {
		this.codigoSedeReservaReceta = codigoSedeReservaReceta;
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

	public Timestamp getFechaEmision() {
		return this.fechaEmision;
	}

	public void setFechaEmision(Timestamp fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public int getNumeroPeriodoEpisodio() {
		return this.numeroPeriodoEpisodio;
	}

	public void setNumeroPeriodoEpisodio(int numeroPeriodoEpisodio) {
		this.numeroPeriodoEpisodio = numeroPeriodoEpisodio;
	}

	public int getNumeroPeriodoRecetaMedica() {
		return this.numeroPeriodoRecetaMedica;
	}

	public void setNumeroPeriodoRecetaMedica(int numeroPeriodoRecetaMedica) {
		this.numeroPeriodoRecetaMedica = numeroPeriodoRecetaMedica;
	}

	public int getNumeroPeriodoReservaReceta() {
		return this.numeroPeriodoReservaReceta;
	}

	public void setNumeroPeriodoReservaReceta(int numeroPeriodoReservaReceta) {
		this.numeroPeriodoReservaReceta = numeroPeriodoReservaReceta;
	}

	public int getNumeroVersionEpisodio() {
		return this.numeroVersionEpisodio;
	}

	public void setNumeroVersionEpisodio(int numeroVersionEpisodio) {
		this.numeroVersionEpisodio = numeroVersionEpisodio;
	}

	public int getNumeroVersionRecetaMedica() {
		return this.numeroVersionRecetaMedica;
	}

	public void setNumeroVersionRecetaMedica(int numeroVersionRecetaMedica) {
		this.numeroVersionRecetaMedica = numeroVersionRecetaMedica;
	}

	public int getNumeroVersionReservaReceta() {
		return this.numeroVersionReservaReceta;
	}

	public void setNumeroVersionReservaReceta(int numeroVersionReservaReceta) {
		this.numeroVersionReservaReceta = numeroVersionReservaReceta;
	}

}