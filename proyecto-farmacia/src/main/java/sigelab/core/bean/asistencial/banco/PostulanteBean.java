package sigelab.core.bean.asistencial.banco;

import java.text.SimpleDateFormat;
import java.util.Date;

import sigelab.base.bean.BaseBean;
import sigelab.core.bean.general.PacienteBean;
import sigelab.core.bean.general.PersonaBean;
import sigelab.core.bean.general.TablaBean;

public class PostulanteBean  extends BaseBean{
	
	private CampaniaBean campania;
	private PersonaBean persona;
	private String ultimaFechaDonacion;
	private TablaBean tipoPostulate;
	private String sFecha ;
	private Date fecha ;
	private String sHora ;
	private String numeroPostulante ;
	private EstadoFisicoBean estadoFisicoBean;
	private FlebotomiaBean flebotomiaBean;
	private String sFechaDesde;
	private String sFechaHasta;
	private TablaBean tipoParentescoPaciente;
	private PacienteBean paciente;
	private Integer index;
	
	public FlebotomiaBean getFlebotomiaBean() {
		if (flebotomiaBean == null) {
			flebotomiaBean = new FlebotomiaBean();
		}
		return flebotomiaBean;
	}

	public void setFlebotomiaBean(FlebotomiaBean flebotomiaBean) {
		this.flebotomiaBean = flebotomiaBean;
	}

	public PacienteBean getPaciente() {
		if (paciente == null) {
			paciente = new PacienteBean();
		}
		return paciente;
	}

	public void setPaciente(PacienteBean paciente) {
		this.paciente = paciente;
	}

	public TablaBean getTipoParentescoPaciente() {
		if (tipoParentescoPaciente == null) {
			tipoParentescoPaciente = new TablaBean();
		}
		return tipoParentescoPaciente;
	}

	public void setTipoParentescoPaciente(TablaBean tipoParentescoPaciente) {
		this.tipoParentescoPaciente = tipoParentescoPaciente;
	}

	public String getNumeroPostulante() {
		return numeroPostulante;
	}

	public void setNumeroPostulante(String numeroPostulante) {
		this.numeroPostulante = numeroPostulante;
	}

	public TablaBean getTipoPostulate() {
		if (tipoPostulate == null) {
			tipoPostulate = new TablaBean();
		}
		return tipoPostulate;
	}

	public String getsFecha() {
		return sFecha;
	}

	public void setsFecha(String sFecha) {
		this.sFecha = sFecha;
	}

	public String getsHora() {
		return sHora;
	}

	public void setsHora(String sHora) {
		this.sHora = sHora;
	}

	public void setTipoPostulate(TablaBean tipoPostulate) {
		this.tipoPostulate = tipoPostulate;
	}

	public PersonaBean getPersona() {
		if (persona == null) {
			persona = new PersonaBean();
		}
		return persona;
	}

	public void setPersona(PersonaBean persona) {
		this.persona = persona;
	}

	public CampaniaBean getCampania() {
		if (campania == null) {
			campania = new CampaniaBean();
		}
		return campania;
	}

	public void setCampania(CampaniaBean campania) {
		this.campania = campania;
	}

	public String getUltimaFechaDonacion() {
		return ultimaFechaDonacion;
	}

	public void setUltimaFechaDonacion(String ultimaFechaDonacion) {
		this.ultimaFechaDonacion = ultimaFechaDonacion;
	}

	public EstadoFisicoBean getEstadoFisicoBean() {
		if (estadoFisicoBean == null) {
			estadoFisicoBean = new EstadoFisicoBean();
		}
		return estadoFisicoBean;
	}

	public void setEstadoFisicoBean(EstadoFisicoBean estadoFisicoBean) {
		this.estadoFisicoBean = estadoFisicoBean;
	}

	public String getsFechaDesde() {
		if (sFechaDesde == null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			String strHora = sdf.format(new Date());
			sFechaDesde = strHora;
		}
		return sFechaDesde; 
	}

	public void setsFechaDesde(String sFechaDesde) {
		this.sFechaDesde = sFechaDesde;
	}

	public String getsFechaHasta() {
		if (sFechaHasta == null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			String strHora = sdf.format(new Date());
			sFechaHasta = strHora;
		} 
		return sFechaHasta;
	}

	public void setsFechaHasta(String sFechaHasta) {
		this.sFechaHasta = sFechaHasta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return "PostulanteBean [campania=" + campania + ", persona=" + persona + ", ultimaFechaDonacion="
				+ ultimaFechaDonacion + ", tipoPostulate=" + tipoPostulate + ", sFecha=" + sFecha + ", sHora=" + sHora
				+ ", numeroPostulante=" + numeroPostulante + ", estadoFisicoBean=" + estadoFisicoBean + ", sFechaDesde="
				+ sFechaDesde + ", sFechaHasta=" + sFechaHasta + "]";
	}
 
}
