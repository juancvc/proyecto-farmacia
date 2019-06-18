package sigelab.core.entity.asistencial.banco;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "interUAL.insertar", procedureName = "[SIGEHOV2BANC].[GENE].[ADMISION_POSTULANTE_INSERT_INTER_UAL]", 
				resultClasses = InterUAL.class, parameters = {
				
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "codDona", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "tipoDocDona", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "docDona", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "apepDona", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "apemDona", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "nomDona", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "sexoDona", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "fnacDona", type = String.class),
				 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "nacionDona", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "direccDona", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ubigDistrDona", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "distritoDona", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ubigeoDona", type = String.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "telefonoDona", type = String.class),
			    
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "celularDona", type = String.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "correoDona", type = String.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "ocupCodDona", type = String.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "ocupDona", type = String.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "colectCodDona", type = String.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "colectDona", type = String.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "numMuestraDona", type = String.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "tipoCodDona", type = String.class),
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "tipoDona", type = String.class),
			    
			    @StoredProcedureParameter(mode = ParameterMode.IN, name = "codigoPac", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "hclinicaPac", type = String.class),
				
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "dniPac", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "nomPac", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "apepPac", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "apemPac", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "sexoPac", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "fnacPac", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "procPac", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "servPac", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "diagnoPac", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "motivoPac", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "seguroPac", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "parentescoPac", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "usuarioCodReg", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "usuarioReg", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "fechaReg", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "horaReg", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "wbcResultHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "wbcUnidadHemog", type = String.class),
				
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "wbcValoresHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "lymResultHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "lymUnidadHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "lymValoresHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "midResultHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "midUnidadHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "midValoresHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "graResultHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "graUnidadHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "graValoresHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "lympResultHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "lympUnidadHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "lympValoresHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "midpResultHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "midpUnidadHemog", type = String.class),
				
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "midpValoresHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "grapResultHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "grapUnidadHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "grapValoresHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "rbcResultHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "rbcUnidadHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "rbcValoresHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "hgbResultHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "hgbUnidadHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "hgbValoresHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "hctResultHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "hctUnidadHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "hctValoresHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "mcvResultHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "mcvUnidadHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "mcvValoresHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "mchResultHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "mchUnidadHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "mchValoresHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "mchcResultHemog", type = String.class),
				
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "mchcUnidadHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "mchcValoresHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "rdwResultHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "rdwUnidadHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "rdwValoresHemog", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "pltResultHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "pltUnidadHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "pltValoresHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "mpvResultHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "mpvUnidadHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "mpvValoresHemog", type = String.class),
				
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "fechaRegHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "horaRegHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "usuarioCodRegHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "usuarioRegHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "muestraHemog", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "codPerso", type = String.class),
				
 }),
		
 
})


@Entity
public class InterUAL implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id 
	@Column(name = "codDona")
	private String codDona;
	
	private String tipoDocDona;
	private String docDona; 
	private String codPerso; 
	private String apepDona; 
	private String apemDona; 
	private String nomDona; 
	private String sexoDona;
	private String fnacDona;
	private String nacionDona;
	private String direccDona;
	private String ubigDistrDona;
	private String distritoDona;
	private String ubigeoDona;
	private String telefonoDona;
	private String celularDona;
	private String correoDona;
	private String ocupCodDona;
	private String ocupDona; 
	private String colectCodDona;
	private String colectDona;
	private String numMuestraDona;
	private String tipoCodDona;
	private String tipoDona;
	private String codigoPac;
	private String hclinicaPac;
	private String dniPac;
	private String nomPac;
	private String apepPac;
	private String apemPac;
	private String sexoPac;
	private String fnacPac;
	private String procPac;
	private String servPac; 
	private String diagnoPac;
	private String motivoPac;
	private String seguroPac;  
	private String parentescoPac; 
	private String usuarioCodReg;
	private String usuarioReg;
	private String fechaReg; 
	private String horaReg;
	private String wbcResultHemog;
	private String wbcUnidadHemog; 
	private String wbcValoresHemog;
	private String lymResultHemog;
	private String lymUnidadHemog;
	private String lymValoresHemog;
	private String midResultHemog;
	private String midUnidadHemog;
	private String midValoresHemog; 
	private String graResultHemog;
	private String graUnidadHemog;
	private String graValoresHemog;
	private String lympResultHemog;
	private String lympUnidadHemog;
	private String lympValoresHemog;
	private String midpResultHemog;
	private String midpUnidadHemog;
	private String midpValoresHemog;
	private String grapResultHemog;
	private String grapUnidadHemog;
	private String grapValoresHemog;
	private String rbcResultHemog;
	
	private String rbcUnidadHemog;
	private String rbcValoresHemog;
	private String hgbResultHemog;
	private String hgbUnidadHemog;
	private String hgbValoresHemog;
	private String hctResultHemog;
	
	private String hctUnidadHemog;
	private String hctValoresHemog;
	private String mcvResultHemog;
	private String mcvUnidadHemog;
	private String mcvValoresHemog;
	private String mchResultHemog;
	private String mchUnidadHemog;
	private String mchValoresHemog;
	private String mchcResultHemog;
	
	private String mchcUnidadHemog;
	private String mchcValoresHemog;
	private String rdwResultHemog;
	private String rdwUnidadHemog;
	private String rdwValoresHemog;
	private String pltResultHemog;
	private String pltUnidadHemog;
	private String pltValoresHemog;
	private String mpvResultHemog;
	private String mpvUnidadHemog;
	private String mpvValoresHemog;
	
	private Timestamp fechaRegHemog; 
	private String horaRegHemog;
	private String usuarioCodRegHemog;
	private String usuarioRegHemog;
	private String muestraHemog;
	private String estadoDual;
	
	public InterUAL() {
	}

	public String getCodDona() {
		return codDona;
	}

	public void setCodDona(String codDona) {
		this.codDona = codDona;
	}

	public String getTipoDocDona() {
		return tipoDocDona;
	}

	public void setTipoDocDona(String tipoDocDona) {
		this.tipoDocDona = tipoDocDona;
	}

	public String getDocDona() {
		return docDona;
	}

	public void setDocDona(String docDona) {
		this.docDona = docDona;
	}

	public String getCodPerso() {
		return codPerso;
	}

	public void setCodPerso(String codPerso) {
		this.codPerso = codPerso;
	}

	public String getApepDona() {
		return apepDona;
	}

	public void setApepDona(String apepDona) {
		this.apepDona = apepDona;
	}

	public String getApemDona() {
		return apemDona;
	}

	public void setApemDona(String apemDona) {
		this.apemDona = apemDona;
	}

	public String getNomDona() {
		return nomDona;
	}

	public void setNomDona(String nomDona) {
		this.nomDona = nomDona;
	}

	public String getSexoDona() {
		return sexoDona;
	}

	public void setSexoDona(String sexoDona) {
		this.sexoDona = sexoDona;
	}

	public String getFnacDona() {
		return fnacDona;
	}

	public void setFnacDona(String fnacDona) {
		this.fnacDona = fnacDona;
	}

	public String getNacionDona() {
		return nacionDona;
	}

	public void setNacionDona(String nacionDona) {
		this.nacionDona = nacionDona;
	}

	public String getDireccDona() {
		return direccDona;
	}

	public void setDireccDona(String direccDona) {
		this.direccDona = direccDona;
	}

	public String getUbigDistrDona() {
		return ubigDistrDona;
	}

	public void setUbigDistrDona(String ubigDistrDona) {
		this.ubigDistrDona = ubigDistrDona;
	}

	public String getDistritoDona() {
		return distritoDona;
	}

	public void setDistritoDona(String distritoDona) {
		this.distritoDona = distritoDona;
	}

	public String getUbigeoDona() {
		return ubigeoDona;
	}

	public void setUbigeoDona(String ubigeoDona) {
		this.ubigeoDona = ubigeoDona;
	}

	public String getTelefonoDona() {
		return telefonoDona;
	}

	public void setTelefonoDona(String telefonoDona) {
		this.telefonoDona = telefonoDona;
	}

	public String getCelularDona() {
		return celularDona;
	}

	public void setCelularDona(String celularDona) {
		this.celularDona = celularDona;
	}

	public String getCorreoDona() {
		return correoDona;
	}

	public void setCorreoDona(String correoDona) {
		this.correoDona = correoDona;
	}

	public String getOcupCodDona() {
		return ocupCodDona;
	}

	public void setOcupCodDona(String ocupCodDona) {
		this.ocupCodDona = ocupCodDona;
	}

	public String getOcupDona() {
		return ocupDona;
	}

	public void setOcupDona(String ocupDona) {
		this.ocupDona = ocupDona;
	}

	public String getColectCodDona() {
		return colectCodDona;
	}

	public void setColectCodDona(String colectCodDona) {
		this.colectCodDona = colectCodDona;
	}

	public String getColectDona() {
		return colectDona;
	}

	public void setColectDona(String colectDona) {
		this.colectDona = colectDona;
	}

	public String getNumMuestraDona() {
		return numMuestraDona;
	}

	public void setNumMuestraDona(String numMuestraDona) {
		this.numMuestraDona = numMuestraDona;
	}

	public String getTipoCodDona() {
		return tipoCodDona;
	}

	public void setTipoCodDona(String tipoCodDona) {
		this.tipoCodDona = tipoCodDona;
	}

	public String getTipoDona() {
		return tipoDona;
	}

	public void setTipoDona(String tipoDona) {
		this.tipoDona = tipoDona;
	}

	public String getCodigoPac() {
		return codigoPac;
	}

	public void setCodigoPac(String codigoPac) {
		this.codigoPac = codigoPac;
	}

	public String getHclinicaPac() {
		return hclinicaPac;
	}

	public void setHclinicaPac(String hclinicaPac) {
		this.hclinicaPac = hclinicaPac;
	}

	public String getDniPac() {
		return dniPac;
	}

	public void setDniPac(String dniPac) {
		this.dniPac = dniPac;
	}

	public String getNomPac() {
		return nomPac;
	}

	public void setNomPac(String nomPac) {
		this.nomPac = nomPac;
	}

	public String getApepPac() {
		return apepPac;
	}

	public void setApepPac(String apepPac) {
		this.apepPac = apepPac;
	}

	public String getApemPac() {
		return apemPac;
	}

	public void setApemPac(String apemPac) {
		this.apemPac = apemPac;
	}

	public String getSexoPac() {
		return sexoPac;
	}

	public void setSexoPac(String sexoPac) {
		this.sexoPac = sexoPac;
	}

	public String getFnacPac() {
		return fnacPac;
	}

	public void setFnacPac(String fnacPac) {
		this.fnacPac = fnacPac;
	}

	public String getProcPac() {
		return procPac;
	}

	public void setProcPac(String procPac) {
		this.procPac = procPac;
	}

	public String getServPac() {
		return servPac;
	}

	public void setServPac(String servPac) {
		this.servPac = servPac;
	}

	public String getDiagnoPac() {
		return diagnoPac;
	}

	public void setDiagnoPac(String diagnoPac) {
		this.diagnoPac = diagnoPac;
	}

	public String getMotivoPac() {
		return motivoPac;
	}

	public void setMotivoPac(String motivoPac) {
		this.motivoPac = motivoPac;
	}

	public String getSeguroPac() {
		return seguroPac;
	}

	public void setSeguroPac(String seguroPac) {
		this.seguroPac = seguroPac;
	}

	public String getParentescoPac() {
		return parentescoPac;
	}

	public void setParentescoPac(String parentescoPac) {
		this.parentescoPac = parentescoPac;
	}

	public String getUsuarioCodReg() {
		return usuarioCodReg;
	}

	public void setUsuarioCodReg(String usuarioCodReg) {
		this.usuarioCodReg = usuarioCodReg;
	}

	public String getUsuarioReg() {
		return usuarioReg;
	}

	public void setUsuarioReg(String usuarioReg) {
		this.usuarioReg = usuarioReg;
	}

	public String getFechaReg() {
		return fechaReg;
	}

	public void setFechaReg(String fechaReg) {
		this.fechaReg = fechaReg;
	}

	public String getHoraReg() {
		return horaReg;
	}

	public void setHoraReg(String horaReg) {
		this.horaReg = horaReg;
	}

	public String getWbcResultHemog() {
		return wbcResultHemog;
	}

	public void setWbcResultHemog(String wbcResultHemog) {
		this.wbcResultHemog = wbcResultHemog;
	}

	public String getWbcUnidadHemog() {
		return wbcUnidadHemog;
	}

	public void setWbcUnidadHemog(String wbcUnidadHemog) {
		this.wbcUnidadHemog = wbcUnidadHemog;
	}

	public String getWbcValoresHemog() {
		return wbcValoresHemog;
	}

	public void setWbcValoresHemog(String wbcValoresHemog) {
		this.wbcValoresHemog = wbcValoresHemog;
	}

	public String getLymResultHemog() {
		return lymResultHemog;
	}

	public void setLymResultHemog(String lymResultHemog) {
		this.lymResultHemog = lymResultHemog;
	}

	public String getLymUnidadHemog() {
		return lymUnidadHemog;
	}

	public void setLymUnidadHemog(String lymUnidadHemog) {
		this.lymUnidadHemog = lymUnidadHemog;
	}

	public String getLymValoresHemog() {
		return lymValoresHemog;
	}

	public void setLymValoresHemog(String lymValoresHemog) {
		this.lymValoresHemog = lymValoresHemog;
	}

	public String getMidResultHemog() {
		return midResultHemog;
	}

	public void setMidResultHemog(String midResultHemog) {
		this.midResultHemog = midResultHemog;
	}

	public String getMidUnidadHemog() {
		return midUnidadHemog;
	}

	public void setMidUnidadHemog(String midUnidadHemog) {
		this.midUnidadHemog = midUnidadHemog;
	}

	public String getMidValoresHemog() {
		return midValoresHemog;
	}

	public void setMidValoresHemog(String midValoresHemog) {
		this.midValoresHemog = midValoresHemog;
	}

	public String getGraResultHemog() {
		return graResultHemog;
	}

	public void setGraResultHemog(String graResultHemog) {
		this.graResultHemog = graResultHemog;
	}

	public String getGraUnidadHemog() {
		return graUnidadHemog;
	}

	public void setGraUnidadHemog(String graUnidadHemog) {
		this.graUnidadHemog = graUnidadHemog;
	}

	public String getGraValoresHemog() {
		return graValoresHemog;
	}

	public void setGraValoresHemog(String graValoresHemog) {
		this.graValoresHemog = graValoresHemog;
	}

	public String getLympResultHemog() {
		return lympResultHemog;
	}

	public void setLympResultHemog(String lympResultHemog) {
		this.lympResultHemog = lympResultHemog;
	}

	public String getLympUnidadHemog() {
		return lympUnidadHemog;
	}

	public void setLympUnidadHemog(String lympUnidadHemog) {
		this.lympUnidadHemog = lympUnidadHemog;
	}

	public String getLympValoresHemog() {
		return lympValoresHemog;
	}

	public void setLympValoresHemog(String lympValoresHemog) {
		this.lympValoresHemog = lympValoresHemog;
	}

	public String getMidpResultHemog() {
		return midpResultHemog;
	}

	public void setMidpResultHemog(String midpResultHemog) {
		this.midpResultHemog = midpResultHemog;
	}

	public String getMidpUnidadHemog() {
		return midpUnidadHemog;
	}

	public void setMidpUnidadHemog(String midpUnidadHemog) {
		this.midpUnidadHemog = midpUnidadHemog;
	}

	public String getMidpValoresHemog() {
		return midpValoresHemog;
	}

	public void setMidpValoresHemog(String midpValoresHemog) {
		this.midpValoresHemog = midpValoresHemog;
	}

	public String getGrapResultHemog() {
		return grapResultHemog;
	}

	public void setGrapResultHemog(String grapResultHemog) {
		this.grapResultHemog = grapResultHemog;
	}

	public String getGrapUnidadHemog() {
		return grapUnidadHemog;
	}

	public void setGrapUnidadHemog(String grapUnidadHemog) {
		this.grapUnidadHemog = grapUnidadHemog;
	}

	public String getGrapValoresHemog() {
		return grapValoresHemog;
	}

	public void setGrapValoresHemog(String grapValoresHemog) {
		this.grapValoresHemog = grapValoresHemog;
	}

	public String getRbcResultHemog() {
		return rbcResultHemog;
	}

	public void setRbcResultHemog(String rbcResultHemog) {
		this.rbcResultHemog = rbcResultHemog;
	}

	public String getRbcUnidadHemog() {
		return rbcUnidadHemog;
	}

	public void setRbcUnidadHemog(String rbcUnidadHemog) {
		this.rbcUnidadHemog = rbcUnidadHemog;
	}

	public String getRbcValoresHemog() {
		return rbcValoresHemog;
	}

	public void setRbcValoresHemog(String rbcValoresHemog) {
		this.rbcValoresHemog = rbcValoresHemog;
	}

	public String getHgbResultHemog() {
		return hgbResultHemog;
	}

	public void setHgbResultHemog(String hgbResultHemog) {
		this.hgbResultHemog = hgbResultHemog;
	}

	public String getHgbUnidadHemog() {
		return hgbUnidadHemog;
	}

	public void setHgbUnidadHemog(String hgbUnidadHemog) {
		this.hgbUnidadHemog = hgbUnidadHemog;
	}

	public String getHgbValoresHemog() {
		return hgbValoresHemog;
	}

	public void setHgbValoresHemog(String hgbValoresHemog) {
		this.hgbValoresHemog = hgbValoresHemog;
	}

	public String getHctResultHemog() {
		return hctResultHemog;
	}

	public void setHctResultHemog(String hctResultHemog) {
		this.hctResultHemog = hctResultHemog;
	}

	public String getHctUnidadHemog() {
		return hctUnidadHemog;
	}

	public void setHctUnidadHemog(String hctUnidadHemog) {
		this.hctUnidadHemog = hctUnidadHemog;
	}

	public String getHctValoresHemog() {
		return hctValoresHemog;
	}

	public void setHctValoresHemog(String hctValoresHemog) {
		this.hctValoresHemog = hctValoresHemog;
	}

	public String getMcvResultHemog() {
		return mcvResultHemog;
	}

	public void setMcvResultHemog(String mcvResultHemog) {
		this.mcvResultHemog = mcvResultHemog;
	}

	public String getMcvUnidadHemog() {
		return mcvUnidadHemog;
	}

	public void setMcvUnidadHemog(String mcvUnidadHemog) {
		this.mcvUnidadHemog = mcvUnidadHemog;
	}

	public String getMcvValoresHemog() {
		return mcvValoresHemog;
	}

	public void setMcvValoresHemog(String mcvValoresHemog) {
		this.mcvValoresHemog = mcvValoresHemog;
	}

	public String getMchResultHemog() {
		return mchResultHemog;
	}

	public void setMchResultHemog(String mchResultHemog) {
		this.mchResultHemog = mchResultHemog;
	}

	public String getMchUnidadHemog() {
		return mchUnidadHemog;
	}

	public void setMchUnidadHemog(String mchUnidadHemog) {
		this.mchUnidadHemog = mchUnidadHemog;
	}

	public String getMchValoresHemog() {
		return mchValoresHemog;
	}

	public void setMchValoresHemog(String mchValoresHemog) {
		this.mchValoresHemog = mchValoresHemog;
	}

	public String getMchcResultHemog() {
		return mchcResultHemog;
	}

	public void setMchcResultHemog(String mchcResultHemog) {
		this.mchcResultHemog = mchcResultHemog;
	}

	public String getMchcUnidadHemog() {
		return mchcUnidadHemog;
	}

	public void setMchcUnidadHemog(String mchcUnidadHemog) {
		this.mchcUnidadHemog = mchcUnidadHemog;
	}

	public String getMchcValoresHemog() {
		return mchcValoresHemog;
	}

	public void setMchcValoresHemog(String mchcValoresHemog) {
		this.mchcValoresHemog = mchcValoresHemog;
	}

	public String getRdwResultHemog() {
		return rdwResultHemog;
	}

	public void setRdwResultHemog(String rdwResultHemog) {
		this.rdwResultHemog = rdwResultHemog;
	}

	public String getRdwUnidadHemog() {
		return rdwUnidadHemog;
	}

	public void setRdwUnidadHemog(String rdwUnidadHemog) {
		this.rdwUnidadHemog = rdwUnidadHemog;
	}

	public String getRdwValoresHemog() {
		return rdwValoresHemog;
	}

	public void setRdwValoresHemog(String rdwValoresHemog) {
		this.rdwValoresHemog = rdwValoresHemog;
	}

	public String getPltResultHemog() {
		return pltResultHemog;
	}

	public void setPltResultHemog(String pltResultHemog) {
		this.pltResultHemog = pltResultHemog;
	}

	public String getPltUnidadHemog() {
		return pltUnidadHemog;
	}

	public void setPltUnidadHemog(String pltUnidadHemog) {
		this.pltUnidadHemog = pltUnidadHemog;
	}

	public String getPltValoresHemog() {
		return pltValoresHemog;
	}

	public void setPltValoresHemog(String pltValoresHemog) {
		this.pltValoresHemog = pltValoresHemog;
	}

	public String getMpvResultHemog() {
		return mpvResultHemog;
	}

	public void setMpvResultHemog(String mpvResultHemog) {
		this.mpvResultHemog = mpvResultHemog;
	}

	public String getMpvUnidadHemog() {
		return mpvUnidadHemog;
	}

	public void setMpvUnidadHemog(String mpvUnidadHemog) {
		this.mpvUnidadHemog = mpvUnidadHemog;
	}

	public String getMpvValoresHemog() {
		return mpvValoresHemog;
	}

	public void setMpvValoresHemog(String mpvValoresHemog) {
		this.mpvValoresHemog = mpvValoresHemog;
	}

	public Timestamp getFechaRegHemog() {
		return fechaRegHemog;
	}

	public void setFechaRegHemog(Timestamp fechaRegHemog) {
		this.fechaRegHemog = fechaRegHemog;
	}

	public String getHoraRegHemog() {
		return horaRegHemog;
	}

	public void setHoraRegHemog(String horaRegHemog) {
		this.horaRegHemog = horaRegHemog;
	}

	public String getUsuarioCodRegHemog() {
		return usuarioCodRegHemog;
	}

	public void setUsuarioCodRegHemog(String usuarioCodRegHemog) {
		this.usuarioCodRegHemog = usuarioCodRegHemog;
	}

	public String getUsuarioRegHemog() {
		return usuarioRegHemog;
	}

	public void setUsuarioRegHemog(String usuarioRegHemog) {
		this.usuarioRegHemog = usuarioRegHemog;
	}

	public String getMuestraHemog() {
		return muestraHemog;
	}

	public void setMuestraHemog(String muestraHemog) {
		this.muestraHemog = muestraHemog;
	}

	public String getEstadoDual() {
		return estadoDual;
	}

	public void setEstadoDual(String estadoDual) {
		this.estadoDual = estadoDual;
	}



	 

	 
	 
}