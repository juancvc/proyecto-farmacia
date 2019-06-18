package hnch.referencia.core.entity.asistencial.citas;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name ="programacionMedicoCita.buscarPorFiltros", 
				procedureName = "SIGEHOV2ASIS.[ATEN].[USP_PROGRXTIEMPOXESPE_SELECT_VERS2_WEB]", 
				resultClasses = ProgramacionMedicoCita.class, 
				parameters = {
			 	@StoredProcedureParameter(mode = ParameterMode.IN, name = "TG02UNOR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FEDIAMES", type = String.class)  })

})

@Entity
public class ProgramacionMedicoCita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "AUFECHCR")
	private Timestamp aufechcr;

	@Column(name = "AUFECHMO")
	private Timestamp aufechmo;

	@Column(name = "CODCATEG")
	private String codcateg;

	@Id
	@Column(name = "CODPRGDH")
	private String codPrgDh;

	@Column(name = "NROPEGDH")
	private String nroPerDH;
	
	@Column(name = "CODTIXES")
	private String CodTiXEs;

	@Column(name = "FECDIAME")
	private Timestamp fecDiaMe;

	@Column(name = "HORAINIC")
	private String horaInic;

	@Column(name = "HORATERM")
	private String horaTerm;

	@Column(name = "CODAMBIE")
	private String codAmbie;

	@Column(name = "CODPERSO")
	private String codPerso;

	@Column(name = "PRINOMBR")
	private String prinombr;

	@Column(name = "SEGNOMBR")
	private String segnombr;

	@Column(name = "APEMATER")
	private String apemater;

	@Column(name = "APEPATER")
	private String apepater;

	@Column(name = "CODACTIV")
	private String codActiv;

	@Column(name = "CODESPEC")
	private String codEspec;

	@Column(name = "NOMACTIV")
	private String nomActiv;

	@Column(name = "CANTNUEV")
	private int cantNuev;

	@Column(name = "TIEMNUEV")
	private String tiemNuev;

	@Column(name = "TIECITAPR")
	private int tiemCiTapr;

	@Column(name = "TIEMCONT")
	private String tiemCont;

	@Column(name = "CANTCONT")
	private int cantCont;

	@Column(name = "PORCENTAJE")
	private int porcentaje;

	@Column(name = "CANTCITAPROGXDIA")
	private int cantCitaProgDia;

	@Column(name = "CANTCITAS_DISPONI")
	private int cantCitaDispo;

	@Column(name = "CANTCITA")
	private int cantCita;

	@Column(name = "CODSERV")
	private String codServ;
	
	public ProgramacionMedicoCita() {
	}

	public Timestamp getAufechcr() {
		return aufechcr;
	}

	public void setAufechcr(Timestamp aufechcr) {
		this.aufechcr = aufechcr;
	}

	public Timestamp getAufechmo() {
		return aufechmo;
	}

	public void setAufechmo(Timestamp aufechmo) {
		this.aufechmo = aufechmo;
	}

	public String getCodcateg() {
		return codcateg;
	}

	public void setCodcateg(String codcateg) {
		this.codcateg = codcateg;
	}

	public String getCodPrgDh() {
		return codPrgDh;
	}

	public void setCodPrgDh(String codPrgDh) {
		this.codPrgDh = codPrgDh;
	}

	public String getCodTiXEs() {
		return CodTiXEs;
	}

	public void setCodTiXEs(String codTiXEs) {
		CodTiXEs = codTiXEs;
	}

	public Timestamp getFecDiaMe() {
		return fecDiaMe;
	}

	public void setFecDiaMe(Timestamp fecDiaMe) {
		this.fecDiaMe = fecDiaMe;
	}

	public String getHoraInic() {
		return horaInic;
	}

	public void setHoraInic(String horaInic) {
		this.horaInic = horaInic;
	}

	public String getHoraTerm() {
		return horaTerm;
	}

	public void setHoraTerm(String horaTerm) {
		this.horaTerm = horaTerm;
	}

	public String getCodAmbie() {
		return codAmbie;
	}

	public void setCodAmbie(String codAmbie) {
		this.codAmbie = codAmbie;
	}

	public String getCodPerso() {
		return codPerso;
	}

	public void setCodPerso(String codPerso) {
		this.codPerso = codPerso;
	}

	public String getPrinombr() {
		return prinombr;
	}

	public void setPrinombr(String prinombr) {
		this.prinombr = prinombr;
	}

	public String getSegnombr() {
		return segnombr;
	}

	public void setSegnombr(String segnombr) {
		this.segnombr = segnombr;
	}

	public String getApemater() {
		return apemater;
	}

	public void setApemater(String apemater) {
		this.apemater = apemater;
	}

	public String getApepater() {
		return apepater;
	}

	public void setApepater(String apepater) {
		this.apepater = apepater;
	}

	public String getCodActiv() {
		return codActiv;
	}

	public void setCodActiv(String codActiv) {
		this.codActiv = codActiv;
	}

	public String getCodEspec() {
		return codEspec;
	}

	public void setCodEspec(String codEspec) {
		this.codEspec = codEspec;
	}

	public String getNomActiv() {
		return nomActiv;
	}

	public void setNomActiv(String nomActiv) {
		this.nomActiv = nomActiv;
	}

	public int getCantNuev() {
		return cantNuev;
	}

	public void setCantNuev(int cantNuev) {
		this.cantNuev = cantNuev;
	}

	public String getTiemNuev() {
		return tiemNuev;
	}

	public void setTiemNuev(String tiemNuev) {
		this.tiemNuev = tiemNuev;
	}

	public int getTiemCiTapr() {
		return tiemCiTapr;
	}

	public void setTiemCiTapr(int tiemCiTapr) {
		this.tiemCiTapr = tiemCiTapr;
	}

	public String getTiemCont() {
		return tiemCont;
	}

	public void setTiemCont(String tiemCont) {
		this.tiemCont = tiemCont;
	}

	public int getCantCont() {
		return cantCont;
	}

	public void setCantCont(int cantCont) {
		this.cantCont = cantCont;
	}

	public int getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}

	public int getCantCitaProgDia() {
		return cantCitaProgDia;
	}

	public void setCantCitaProgDia(int cantCitaProgDia) {
		this.cantCitaProgDia = cantCitaProgDia;
	}

	public int getCantCitaDispo() {
		return cantCitaDispo;
	}

	public void setCantCitaDispo(int cantCitaDispo) {
		this.cantCitaDispo = cantCitaDispo;
	}

	public int getCantCita() {
		return cantCita;
	}

	public void setCantCita(int cantCita) {
		this.cantCita = cantCita;
	}

	public String getNroPerDH() {
		return nroPerDH;
	}

	public void setNroPerDH(String nroPerDH) {
		this.nroPerDH = nroPerDH;
	}

	public String getCodServ() {
		return codServ;
	}

	public void setCodServ(String codServ) {
		this.codServ = codServ;
	}

}