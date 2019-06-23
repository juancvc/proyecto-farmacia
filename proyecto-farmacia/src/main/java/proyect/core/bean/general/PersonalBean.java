package proyect.core.bean.general;

import java.util.Date;

import proyect.base.bean.BaseBean;

public class PersonalBean extends BaseBean{
	
		private PersonaBean     persona;
		private String  		codEmple;
		private String  		observacion;
		private String  		fotochec = "";
		private String  		plaza;
		private	Date			fechaInscripcion;
		private	String			funcionDesempenia;
		private	CatalogoBean       tipoGremio;
		private	CatalogoBean		gremio;
		private	Date			fechaInscripcionGremio;
		private	String			actGremio;
		private String  		nroColegiatura;
		private CatalogoBean   	tipoColegio;
		private	CatalogoBean   	condicion = new CatalogoBean();
		private	String			ieds;
		private	CatalogoBean		nivel;
		private CatalogoBean   	unidadOrg = new CatalogoBean();
		private CatalogoBean   	cargo;
		private	CatalogoBean       tipo;   // asistencial, administradtivo , etc
	//	private	Ambiente   	ambienteAsig;
		private String      	nroSesigra;
		private	Date			fechaIniSesigra;
		private Date			fechaTerminoSesigra;
		private RenaesBean		renaes;
		private	CatalogoBean		especialidad = new CatalogoBean();
		private	CatalogoBean		grupoOcupacional;
		private String          nroHC;
	/*	
	public Ambiente getAmbienteAsig() {
		return ambienteAsig;
	}

	public void setAmbienteAsig(Ambiente ambienteAsig) {
		this.ambienteAsig = ambienteAsig;
	}
	
	
*/
		
	public PersonalBean() {
		super();
	}
	public CatalogoBean getCargo() {
		return cargo;
	}

	public void setCargo(CatalogoBean cargo) {
		this.cargo = cargo;
	}

	public String getIeds() {
		return ieds;
	}

	public void setIeds(String ieds) {
		this.ieds = ieds;
	}

	public String getNroColegiatura() {
		return nroColegiatura;
	}

	public void setNroColegiatura(String nroColegiatura) {
		this.nroColegiatura = nroColegiatura;
	}

	public CatalogoBean getCondicion() {
	/*	if (condicion==null){
			TablaBean tbl = new TablaBean();
			tbl.setCodReg("000011");
			tbl.setNombreCorto("SIN DEFINIR");
			return tbl;
		}
	*/
		return condicion;
	}
                    
	public void setCondicion(CatalogoBean condicion) {
		this.condicion = condicion;
	}

	public String getFotochec() {
		return fotochec;
	}

	public void setFotochec(String fotochec) {
		this.fotochec = fotochec;
	}

	public String getPlaza() {
		return plaza;
	}

	public void setPlaza(String plaza) {
		this.plaza = plaza;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public String getCodEmple() {
		return codEmple;
	}

	public void setCodEmple(String codEmple) {
		this.codEmple = codEmple;
	}


	public CatalogoBean getNivel() {
		return nivel;
	}

	public void setNivel(CatalogoBean nivel) {
		this.nivel = nivel;
	}
/*
	public PersonalBean(String codigo) {
		super(codigo);
	}
*/
	public CatalogoBean getUnidadOrg() {
		return unidadOrg;
	}

	public void setUnidadOrg(CatalogoBean unidadOrg) {
		this.unidadOrg = unidadOrg;
	}

	public CatalogoBean getTipoColegio() {
		return tipoColegio;
	}

	public void setTipoColegio(CatalogoBean tipoColegio) {
		this.tipoColegio = tipoColegio;
	}

	public CatalogoBean getTipo() {
		return tipo;
	}

	public void setTipo(CatalogoBean tipo) {
		this.tipo = tipo;
	}

	public Date getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	public String getFuncionDesempenia() {
		return funcionDesempenia;
	}

	public void setFuncionDesempenia(String funcionDesempenia) {
		this.funcionDesempenia = funcionDesempenia;
	}

	public CatalogoBean getTipoGremio() {
		return tipoGremio;
	}

	public void setTipoGremio(CatalogoBean tipoGremio) {
		this.tipoGremio = tipoGremio;
	}

	public CatalogoBean getGremio() {
		return gremio;
	}

	public void setGremio(CatalogoBean gremio) {
		this.gremio = gremio;
	}

	public String getActGremio() {
		return actGremio;
	}

	public void setActGremio(String actGremio) {
		this.actGremio = actGremio;
	}

	public String getNroSesigra() {
		return nroSesigra;
	}

	public void setNroSesigra(String nroSesigra) {
		this.nroSesigra = nroSesigra;
	}

	public Date getFechaIniSesigra() {
		return fechaIniSesigra;
	}

	public void setFechaIniSesigra(Date fechaIniSesigra) {
		this.fechaIniSesigra = fechaIniSesigra;
	}

	public Date getFechaTerminoSesigra() {
		return fechaTerminoSesigra;
	}

	public void setFechaTerminoSesigra(Date fechaTerminoSesigra) {
		this.fechaTerminoSesigra = fechaTerminoSesigra;
	}

	public RenaesBean getRenaes() {
		return renaes;
	}

	public void setRenaes(RenaesBean renaes) {
		this.renaes = renaes;
	}

	public Date getFechaInscripcionGremio() {
		return fechaInscripcionGremio;
	}

	public void setFechaInscripcionGremio(Date fechaInscripcionGremio) {
		this.fechaInscripcionGremio = fechaInscripcionGremio;
	}

	public String getNroHC() {
		return nroHC;
	}

	public void setNroHC(String nroHC) {
		this.nroHC = nroHC;
	}

	public CatalogoBean getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(CatalogoBean especialidad) {
		this.especialidad = especialidad;
	}

	public CatalogoBean getGrupoOcupacional() {
		return grupoOcupacional;
	}

	public void setGrupoOcupacional(CatalogoBean grupoOcupacional) {
		this.grupoOcupacional = grupoOcupacional;
	}
	public PersonaBean getPersona() {
		if (persona == null) {
			persona =  new PersonaBean();
		}
		return persona;
	}
	public void setPersona(PersonaBean persona) {
		this.persona = persona;
	}
 

}
