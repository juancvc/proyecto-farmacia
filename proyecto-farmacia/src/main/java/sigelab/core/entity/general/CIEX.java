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
						name="ciex.listarPorCriterios", 
						procedureName="[GISEASISTENCIAL].[GENE].[SP_TablaMaestra06_BuscarxCriterio]",
						resultClasses = CIEX.class,
						parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN, name="CodigoTabla", type=String.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="CodigoRegistro", type=int.class),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="NombreCorto", type=String.class),
							
							@StoredProcedureParameter(mode=ParameterMode.IN, name="NombreLargo", type=String.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ValorGeneral01", type=String.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ValorGeneral02", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ValorGeneral03", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ValorGeneral04", type=String.class)
					}							
				)
		
		}
	)
@Entity
public class CIEX 
	extends GenericEntity{
	private static final int serialVersionUID = 1;
	@Id
	@Column(name="CodigoRegistro")
	private int codigoRegistro;

	@Column(name="CodigoTabla")
	private String idTabla;
	  
	
	@Column(name="NombreCorto")
	private String nombreCorto;

	@Column(name="NombreLargo")
	private String nombreLargo;
	
	@Column(name="ValorGeneral01")
	private String valorGeneral01;
	
	@Column(name="ValorGeneral02")
	private String valorGeneral02;
	
	@Column(name="ValorGeneral03")
	private String valorGeneral03;
	
	@Column(name="ValorGeneral04")
	private String valorGeneral04;

	public CIEX() {
	}


	public String getNombreCorto() {
		if (nombreCorto == null) {
			nombreCorto = "";
		}
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	public String getNombreLargo() {
		if (nombreLargo == null) {
			nombreLargo = "";
		}
		return nombreLargo;
	}

	public void setNombreLargo(String nombreLargo) {
		this.nombreLargo = nombreLargo;
	}

	public String getIdTabla() {
		if (idTabla == null) {
			idTabla = "";
		}
		return idTabla;
	}

	public void setIdTabla(String idTabla) {
		this.idTabla = idTabla;
	}


	public int getCodigoRegistro() {
		 
		return codigoRegistro;
	}


	public void setCodigoRegistro(int codigoRegistro) {
		this.codigoRegistro = codigoRegistro;
	}


	public String getValorGeneral01() {
		if (valorGeneral01 == null) {
			valorGeneral01 = "";
		}
		return valorGeneral01;
	}


	public void setValorGeneral01(String valorGeneral01) {
		this.valorGeneral01 = valorGeneral01;
	}


	public String getValorGeneral02() {
		if (valorGeneral02 == null) {
			valorGeneral02 = "";
		}
		return valorGeneral02;
	}


	public void setValorGeneral02(String valorGeneral02) {
		this.valorGeneral02 = valorGeneral02;
	}


	public String getValorGeneral03() {
		if (valorGeneral03 == null) {
			valorGeneral03 = "";
		}
		return valorGeneral03;
	}


	public void setValorGeneral03(String valorGeneral03) {
		this.valorGeneral03 = valorGeneral03;
	}


	public String getValorGeneral04() {
		if (valorGeneral04 == null) {
			valorGeneral04 = "";
		}
		return valorGeneral04;
	}


	public void setValorGeneral04(String valorGeneral04) {
		this.valorGeneral04 = valorGeneral04;
	}

 
	
}