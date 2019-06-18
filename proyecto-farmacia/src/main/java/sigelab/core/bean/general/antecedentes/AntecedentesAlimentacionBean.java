package sigelab.core.bean.general.antecedentes;

import java.util.ArrayList;
import java.util.List;

import sigelab.base.bean.BaseBean;
import sigelab.core.bean.general.TablaBean;


public class AntecedentesAlimentacionBean extends BaseBean{
	/***************************************************/
	//Lactancia
	private boolean swLactancia = false;
	private int edadFinLact;
	private TablaBean umEdadFinLact;
	private boolean swNinoLact = false;
	private TablaBean tipoLactancia;
	private int duraSuccxmama;
	private int nroLactxdia;
	/*****************************************************************************/
	//Ablactancia
	private boolean swAblactancia = false;
	private int edadIniAblact;
	private TablaBean umEdadIniAblact;
	private int frecAlimenSemi;
	private List<LiquidoAblactanciaBean> lstLiquidoAblact;
	private String descAlimenSemi;
	
	/**************************************************************************************/
	//Actual
	private boolean swAnadeAceite = false;
	private String alimentMasFrec;
	
	private AntecedentesPacienteBean antecPac;
	
	public AntecedentesAlimentacionBean(){
		lstLiquidoAblact = new ArrayList<LiquidoAblactanciaBean>();
	}

	public boolean isSwLactancia() {
		return swLactancia;
	}

	public void setSwLactancia(boolean swLactancia) {
		this.swLactancia = swLactancia;
	}

		public int getEdadFinLact() {
		return edadFinLact;
	}

	public void setEdadFinLact(int edadFinLact) {
		this.edadFinLact = edadFinLact;
	}

	

	public TablaBean getUmEdadFinLact() {
		return umEdadFinLact;
	}

	public void setUmEdadFinLact(TablaBean umEdadFinLact) {
		this.umEdadFinLact = umEdadFinLact;
	}

	public boolean isSwNinoLact() {
		return swNinoLact;
	}

	public void setSwNinoLact(boolean swNinoLact) {
		this.swNinoLact = swNinoLact;
	}

	public TablaBean getTipoLactancia() {
		return tipoLactancia;
	}

	public void setTipoLactancia(TablaBean tipoLactancia) {
		this.tipoLactancia = tipoLactancia;
	}

	public int getDuraSuccxmama() {
		return duraSuccxmama;
	}

	public void setDuraSuccxmama(int duraSuccxmama) {
		this.duraSuccxmama = duraSuccxmama;
	}

	public int getNroLactxdia() {
		return nroLactxdia;
	}

	public void setNroLactxdia(int nroLactxdia) {
		this.nroLactxdia = nroLactxdia;
	}

	public boolean isSwAblactancia() {
		return swAblactancia;
	}

	public void setSwAblactancia(boolean swAblactancia) {
		this.swAblactancia = swAblactancia;
	}

	public int getEdadIniAblact() {
		return edadIniAblact;
	}

	public void setEdadIniAblact(int edadIniAblact) {
		this.edadIniAblact = edadIniAblact;
	}

	public TablaBean getUmEdadIniAblact() {
		return umEdadIniAblact;
	}

	public void setUmEdadIniAblact(TablaBean umEdadIniAblact) {
		this.umEdadIniAblact = umEdadIniAblact;
	}

	public int getFrecAlimenSemi() {
		return frecAlimenSemi;
	}

	public void setFrecAlimenSemi(int frecAlimenSemi) {
		this.frecAlimenSemi = frecAlimenSemi;
	}

	public List<LiquidoAblactanciaBean> getLstLiquidoAblact() {
		return lstLiquidoAblact;
	}

	public void setLstLiquidoAblact(List<LiquidoAblactanciaBean> lstLiquidoAblact) {
		this.lstLiquidoAblact = lstLiquidoAblact;
	}

	public String getDescAlimenSemi() {
		return descAlimenSemi;
	}

	public void setDescAlimenSemi(String descAlimenSemi) {
		this.descAlimenSemi = descAlimenSemi;
	}

	public boolean isSwAnadeAceite() {
		return swAnadeAceite;
	}

	public void setSwAnadeAceite(boolean swAnadeAceite) {
		this.swAnadeAceite = swAnadeAceite;
	}

	public String getAlimentMasFrec() {
		return alimentMasFrec;
	}

	public void setAlimentMasFrec(String alimentMasFrec) {
		this.alimentMasFrec = alimentMasFrec;
	}

	public AntecedentesPacienteBean getAntecPac() {
		return antecPac;
	}

	public void setAntecPac(AntecedentesPacienteBean antecPac) {
		this.antecPac = antecPac;
	}
	
	
}
