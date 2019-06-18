package hnch.referencia.core.entity.asistencial.citas;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "citas.insertar", procedureName = "[RECO].[USP_PRGCITAS_INSERT_WEB]", resultClasses = Citas.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "CODPRGCI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class),

				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "CODEPICB", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "NRVEPICB", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "NRPEPICB", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODEPICB_IN", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NRVEPICB_IN", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NRPEPICB_IN", type = String.class),

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPERDH", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODPRGDH", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "GT02SERV", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "GT02SESP", type = String.class),

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODPACIE", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NRODOCUM", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODEMPLE", type = String.class),

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FECHAPRG", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "HORAINIC", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TIPOPACE", type = String.class),

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSCR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPCR", type = String.class),

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CDORGDXR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CDINSDXR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CDSEDDXR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODDIAGN", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NRVEDXRE", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NRPEDXRE", type = String.class) }),
		@NamedStoredProcedureQuery(name = "citas.buscarPorFiltros", procedureName = "[RECO].[USP_CITAS_PROGRAMADAS_WEB]", resultClasses = Citas.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "GT02SESP", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROREFER", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FECHPRGI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FECHPRGF", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NOMESTOR", type = String.class) })

})

@Entity
public class Citas implements Serializable {
	private static final long serialVersionUID = 1L;

 @EmbeddedId
	 private CitasPK id;

	/*@Id
	@Column(name = "CODPRGCI")
	private String codprgci;
*/
	@Column(name = "AUFECHCR")
	private Timestamp aufechcr;

	@Column(name = "AUFECHMO")
	private Timestamp aufechmo;

	private String APEPATER;
	private String APEMATER;

	private String PRINOMBR;
	private String SEGNOMBR;
	private String NROREFER;
	private String ESPECIALIDAD;
	private String MEDICO;
	private Timestamp FECHAPRG;
	private String NOMUSUAR;
	private String HORAINIC;
	private String NOMRENEA;
	
	public Citas() {
	}

	public Timestamp getAufechcr() {
		return aufechcr;
	}

	public Timestamp getFECHAPRG() {
		return FECHAPRG;
	}

	public void setFECHAPRG(Timestamp fECHAPRG) {
		FECHAPRG = fECHAPRG;
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
 
	public String getAPEPATER() {
		return APEPATER;
	}

	public void setAPEPATER(String aPEPATER) {
		APEPATER = aPEPATER;
	}

	public String getAPEMATER() {
		return APEMATER;
	}

	public void setAPEMATER(String aPEMATER) {
		APEMATER = aPEMATER;
	}

	public String getPRINOMBR() {
		return PRINOMBR;
	}

	public void setPRINOMBR(String pRINOMBR) {
		PRINOMBR = pRINOMBR;
	}

	public String getSEGNOMBR() {
		return SEGNOMBR;
	}

	public void setSEGNOMBR(String sEGNOMBR) {
		SEGNOMBR = sEGNOMBR;
	}

	public String getNROREFER() {
		return NROREFER;
	}

	public void setNROREFER(String nROREFER) {
		NROREFER = nROREFER;
	}

	public String getESPECIALIDAD() {
		return ESPECIALIDAD;
	}

	public void setESPECIALIDAD(String eSPECIALIDAD) {
		ESPECIALIDAD = eSPECIALIDAD;
	}

	public String getMEDICO() {
		return MEDICO;
	}

	public void setMEDICO(String mEDICO) {
		MEDICO = mEDICO;
	}

	public String getNOMUSUAR() {
		return NOMUSUAR;
	}

	public void setNOMUSUAR(String nOMUSUAR) {
		NOMUSUAR = nOMUSUAR;
	}

	public String getHORAINIC() {
		return HORAINIC;
	}

	public void setHORAINIC(String hORAINIC) {
		HORAINIC = hORAINIC;
	}

	public CitasPK getId() {
		return id;
	}

	public void setId(CitasPK id) {
		this.id = id;
	}

	public String getNOMRENEA() {
		return NOMRENEA;
	}

	public void setNOMRENEA(String nOMRENEA) {
		NOMRENEA = nOMRENEA;
	}

	 
}