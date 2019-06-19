package pe.com.galaxy.systems.apolo.core.entidad.entidad.seguridad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@Entity
@NamedStoredProcedureQueries(
		{
				
				@NamedStoredProcedureQuery(
						name="systemDate.obetenerFechaHoraSistema", 
						procedureName="SP_SYSTEM_FECHA_HORA_ACTUAL",
						resultClasses= SystemDate.class/*,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_C_CURSOR", type=void.class )
							}	*/				
					)
		}
	)

public class SystemDate {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FECHA_SISTEMA")
	private String fechaSistema;

	@Column(name="HORA_SISTEMA")
	private String horaSistema;
	
	@Column(name="NRO_MES")
	private String mesSistema;

	@Column(name="NOMBRE_DIA_SEMANA")
	private String nombreDiaSemana;
	
	@Column(name="NOMBRE_MES")
	private String nombreMes;
	
	
	@Column(name="ANIO_SISTEMA")
	private String anioSistema;

	@Column(name="DIA")
	private String dia;
	
	public SystemDate() {
		
	}

	public String getFechaSistema() {
		return fechaSistema;
	}

	public void setFechaSistema(String fechaSistema) {
		this.fechaSistema = fechaSistema;
	}

	public String getHoraSistema() {
		return horaSistema;
	}

	public void setHoraSistema(String horaSistema) {
		this.horaSistema = horaSistema;
	}

	public String getMesSistema() {
		return mesSistema;
	}

	public void setMesSistema(String mesSistema) {
		this.mesSistema = mesSistema;
	}

	public String getAnioSistema() {
		return anioSistema;
	}

	public void setAnioSistema(String anioSistema) {
		this.anioSistema = anioSistema;
	}

	public String getNombreDiaSemana() {
		return nombreDiaSemana;
	}

	public void setNombreDiaSemana(String nombreDiaSemana) {
		this.nombreDiaSemana = nombreDiaSemana;
	}

	public String getNombreMes() {
		return nombreMes;
	}

	public void setNombreMes(String nombreMes) {
		this.nombreMes = nombreMes;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}
	
	
}