package proyect.core.entity.general;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.data.annotation.TypeAlias;


import java.sql.Timestamp;
import java.math.BigDecimal;

@NamedStoredProcedureQueries(
		{
				@NamedStoredProcedureQuery(
						name="tablaMaestra01.ListarComboGiseAsistencialTablaMaestra01", 
						procedureName="[GISEASISTENCIAL].[GENE].[SP_UtilitarioTablaMaestra1ListarCombo]",
						resultClasses= TablaMaestra01.class,
						parameters=	{
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="CodigoTabla", type=String.class)
									}		
				),
				@NamedStoredProcedureQuery(
						name="tablaMaestra01.TablaMaestra01BuscarxCriterio", 
						procedureName="[GISEASISTENCIAL].[GENE].[SP_TablaMaestra01_BuscarxCriterio]",
						resultClasses= TablaMaestra01.class,
						parameters=	{
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="CodigoTabla", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="CodigoRegistro", type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NombreCorto", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NombreLargo", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ValorGeneral01", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ValorGeneral02", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ValorGeneral03", type=String.class)
									
				})
		}
	)

@Entity(name="TablaMaestra01")
@Table(name="GENE.TablaMaestra01")
public class TablaMaestra01 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="AuditoriaCodigoUsuario")
	private BigDecimal auditoriaCodigoUsuario;

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

	@Column(name="CodigoCategoria")
	private int codigoCategoria;
	
	@Id
	@Column(name="CodigoRegistro")
	private int codigoRegistro;

	@Column(name="CodigoTabla")
	private String codigoTabla;

	@Column(name="Estado")
	private String estado;

	@Column(name="NombreCorto")
	private String nombreCorto;

	@Column(name="NombreLargo")
	private String nombreLargo;

	@Column(name="NumeroOrden")
	private short numeroOrden;

	@Column(name="SwitchCodigoMigrado")
	private short switchCodigoMigrado;

	@Column(name="ValorGeneral01")
	private String valorGeneral01;

	@Column(name="ValorGeneral02")
	private String valorGeneral02;

	@Column(name="ValorGeneral03")
	private String valorGeneral03;

	@Column(name="ValorGeneral04")
	private String valorGeneral04;

	@Column(name="ValorGeneral05")
	private String valorGeneral05;

	@Column(name="ValorGeneral06")
	private String valorGeneral06;

	@Column(name="ValorGeneral07")
	private String valorGeneral07;

	@Column(name="ValorGeneral08")
	private String valorGeneral08;

	@Column(name="ValorGeneral09")
	private String valorGeneral09;

	@Column(name="ValorGeneral10")
	private String valorGeneral10;

	@Column(name="ValorGeneral11")
	private String valorGeneral11;

	@Column(name="ValorGeneral12")
	private String valorGeneral12;

	@Column(name="ValorGeneral13")
	private String valorGeneral13;

	@Column(name="ValorGeneral14")
	private String valorGeneral14;

	@Column(name="NumeroVersionPadre")
	private String numeroVersionPadre;
	
	public TablaMaestra01() {
	}

	public BigDecimal getAuditoriaCodigoUsuario() {
		return this.auditoriaCodigoUsuario;
	}

	public void setAuditoriaCodigoUsuario(BigDecimal auditoriaCodigoUsuario) {
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

	public int getCodigoCategoria() {
		return this.codigoCategoria;
	}

	public void setCodigoCategoria(int codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public int getCodigoRegistro() {
		return this.codigoRegistro;
	}

	public void setCodigoRegistro(int codigoRegistro) {
		this.codigoRegistro = codigoRegistro;
	}

	public String getCodigoTabla() {
		return this.codigoTabla;
	}

	public void setCodigoTabla(String codigoTabla) {
		this.codigoTabla = codigoTabla;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombreCorto() {
		return this.nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	public String getNombreLargo() {
		return this.nombreLargo;
	}

	public void setNombreLargo(String nombreLargo) {
		this.nombreLargo = nombreLargo;
	}

	public short getNumeroOrden() {
		return this.numeroOrden;
	}

	public void setNumeroOrden(short numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	public short getSwitchCodigoMigrado() {
		return this.switchCodigoMigrado;
	}

	public void setSwitchCodigoMigrado(short switchCodigoMigrado) {
		this.switchCodigoMigrado = switchCodigoMigrado;
	}

	public String getValorGeneral01() {
		return this.valorGeneral01;
	}

	public void setValorGeneral01(String valorGeneral01) {
		this.valorGeneral01 = valorGeneral01;
	}

	public String getValorGeneral02() {
		return this.valorGeneral02;
	}

	public void setValorGeneral02(String valorGeneral02) {
		this.valorGeneral02 = valorGeneral02;
	}

	public String getValorGeneral03() {
		return this.valorGeneral03;
	}

	public void setValorGeneral03(String valorGeneral03) {
		this.valorGeneral03 = valorGeneral03;
	}

	public String getValorGeneral04() {
		return this.valorGeneral04;
	}

	public void setValorGeneral04(String valorGeneral04) {
		this.valorGeneral04 = valorGeneral04;
	}

	public String getValorGeneral05() {
		return this.valorGeneral05;
	}

	public void setValorGeneral05(String valorGeneral05) {
		this.valorGeneral05 = valorGeneral05;
	}

	public String getValorGeneral06() {
		return this.valorGeneral06;
	}

	public void setValorGeneral06(String valorGeneral06) {
		this.valorGeneral06 = valorGeneral06;
	}

	public String getValorGeneral07() {
		return this.valorGeneral07;
	}

	public void setValorGeneral07(String valorGeneral07) {
		this.valorGeneral07 = valorGeneral07;
	}

	public String getValorGeneral08() {
		return this.valorGeneral08;
	}

	public void setValorGeneral08(String valorGeneral08) {
		this.valorGeneral08 = valorGeneral08;
	}

	public String getValorGeneral09() {
		return this.valorGeneral09;
	}

	public void setValorGeneral09(String valorGeneral09) {
		this.valorGeneral09 = valorGeneral09;
	}

	public String getValorGeneral10() {
		return this.valorGeneral10;
	}

	public void setValorGeneral10(String valorGeneral10) {
		this.valorGeneral10 = valorGeneral10;
	}

	public String getValorGeneral11() {
		return this.valorGeneral11;
	}

	public void setValorGeneral11(String valorGeneral11) {
		this.valorGeneral11 = valorGeneral11;
	}

	public String getValorGeneral12() {
		return this.valorGeneral12;
	}

	public void setValorGeneral12(String valorGeneral12) {
		this.valorGeneral12 = valorGeneral12;
	}

	public String getValorGeneral13() {
		return this.valorGeneral13;
	}

	public void setValorGeneral13(String valorGeneral13) {
		this.valorGeneral13 = valorGeneral13;
	}

	public String getValorGeneral14() {
		return this.valorGeneral14;
	}

	public void setValorGeneral14(String valorGeneral14) {
		this.valorGeneral14 = valorGeneral14;
	}

	
	public String getNumeroVersionPadre() {
		return numeroVersionPadre;
	}

	public void setNumeroVersionPadre(String numeroVersionPadre) {
		this.numeroVersionPadre = numeroVersionPadre;
	}

	@Override
	public String toString() {
		return "TablaMaestra01 [auditoriaCodigoUsuario="
				+ auditoriaCodigoUsuario + ", auditoriaFechaOperacion="
				+ auditoriaFechaOperacion + ", auditoriaIdSesion="
				+ auditoriaIdSesion + ", auditoriaIPNumeroMac="
				+ auditoriaIPNumeroMac + ", auditoriaObservacion="
				+ auditoriaObservacion + ", auditoriaTipoOperacion="
				+ auditoriaTipoOperacion + ", codigoCategoria="
				+ codigoCategoria + ", codigoRegistro=" + codigoRegistro
				+ ", codigoTabla=" + codigoTabla + ", estado=" + estado
				+ ", nombreCorto=" + nombreCorto + ", nombreLargo="
				+ nombreLargo + ", numeroOrden=" + numeroOrden
				+ ", switchCodigoMigrado=" + switchCodigoMigrado
				+ ", valorGeneral01=" + valorGeneral01 + ", valorGeneral02="
				+ valorGeneral02 + ", valorGeneral03=" + valorGeneral03
				+ ", valorGeneral04=" + valorGeneral04 + ", valorGeneral05="
				+ valorGeneral05 + ", valorGeneral06=" + valorGeneral06
				+ ", valorGeneral07=" + valorGeneral07 + ", valorGeneral08="
				+ valorGeneral08 + ", valorGeneral09=" + valorGeneral09
				+ ", valorGeneral10=" + valorGeneral10 + ", valorGeneral11="
				+ valorGeneral11 + ", valorGeneral12=" + valorGeneral12
				+ ", valorGeneral13=" + valorGeneral13 + ", valorGeneral14="
				+ valorGeneral14 + "]";
	}

	
	
}