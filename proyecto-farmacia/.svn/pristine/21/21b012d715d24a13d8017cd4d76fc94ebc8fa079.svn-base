package hnch.referencia.core.entity.general;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "renaesDestino.insertar", procedureName = "RECO.RENADEST_INSERT", resultClasses = RenaesDestino.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "CODREDES", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NROPERIO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODORGAN", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODINSTI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODSEDEI", type = String.class),
				
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODESORI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CODESDES", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUCDUSCR", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AUPCIPCR", type = String.class)

		})

})

@Entity
public class RenaesDestino implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CODREDES")
	private String codredes;

	@Column(name = "NROPERIO ")
	private String nroPerio;

	@Column(name = "CODINSTI")
	private String codinsti;

	@Column(name = "CODORGAN")
	private String codorgan;

	@Column(name = "CODSEDEI")
	private String codsedei;

	@Column(name = "CODESORI")
	private String codEsOri;

	@Column(name = "CODESDES")
	private String codEsDes;

	@Column(name = "ESTADO")
	private String estado;

	@Column(name = "AUCDUSCR")
	private String aucduscr;

	@Column(name = "AUCDUSMO")
	private String aucdusmo;

	@Column(name = "AUFECHCR")
	private Timestamp aufechcr;

	@Column(name = "AUFECHMO")
	private Timestamp aufechmo;

	@Column(name = "AUOBSEMO")
	private String auobsemo;

	@Column(name = "AUPCIPCR")
	private String aupcipcr;

	@Column(name = "AUPCIPMO")
	private String aupcipmo;

	public RenaesDestino() {
	}

}