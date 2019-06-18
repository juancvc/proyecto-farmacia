package hnch.referencia.core.repository.implementacion.asistencial.referencia;

import hnch.referencia.core.bean.asistencial.referencia.ReferenciaBean;
import hnch.referencia.core.bean.general.PersonaBean;
import hnch.referencia.core.bean.general.PersonalBean;
import hnch.referencia.core.entity.asistencial.referencia.ReferenciaCB;
import hnch.referencia.core.entity.asistencial.referencia.ReferenciaEspecialidad;
import hnch.referencia.core.repository.DAOException;
import hnch.referencia.core.repository.interfaces.asistencial.referencia.ReferenciaCbDAO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository("referenciaCbDAO")
public class ReferenciaCbDAOImp implements ReferenciaCbDAO {

	@PersistenceContext//(unitName = "emf")
	private EntityManager em;

	public ReferenciaBean getReferenciaBean(Object object) {
		return (ReferenciaBean) object;
	}

	@Override
	public boolean insertar(ReferenciaBean referenciaBean) throws DAOException {
		Object idReferenciaCb = null;
		Object nroperiodo = null;
		Object nroVersi = null;
		System.out.println("referenciaBean.getCodigoUsuarioCreacion() " + referenciaBean.getCodigoUsuarioCreacion());
		System.out.println("referenciaBean.getIpCreacion() " + referenciaBean.getIpCreacion());
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("referencia.insertar");

			spq.setParameter("CODORGAN", referenciaBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", referenciaBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", referenciaBean.getCodigoSede());

			spq.setParameter("FECHAREF", referenciaBean.getStrfechaIngresoRef());
			spq.setParameter("HORAREFE", referenciaBean.getHoraIngresoRef());

			spq.setParameter("CODESORI", referenciaBean.getEstablecimientoOrige().getCodRenaes());
			spq.setParameter("TG14TPUPS", referenciaBean.getServicioUPSReferencia().getCodReg()); 

			spq.setParameter("CODESPEC", referenciaBean.getEspecialidad().getCodReg());
			
			spq.setParameter("CODORGPA", referenciaBean.getPaciente().getCodigoOrganizacion());
			spq.setParameter("CODINSPA", referenciaBean.getPaciente().getCodigoInstitucion());
			spq.setParameter("CODSEDPA", referenciaBean.getPaciente().getCodigoSede());
			spq.setParameter("CODPACIE", referenciaBean.getPaciente().getCodigo());
			spq.setParameter("NROVERPA", referenciaBean.getPaciente().getNumeroVersion());
			spq.setParameter("NROPERPA", referenciaBean.getPaciente().getNumeroPeriodo());
			spq.setParameter("NROHC", referenciaBean.getPaciente().getNroHC());
			spq.setParameter("NROFILIA", referenciaBean.getPaciente().getCodigoFiliacion());
			
			spq.setParameter("TG14PLAN", referenciaBean.getPlanAtenSIS().getCodReg());
 
			spq.setParameter("TG1TIEMP", referenciaBean.getTiempoEnfermedad().getCodReg());
			spq.setParameter("TIEMPOEN", referenciaBean.getCantTiempoEnfermedad()); 
			spq.setParameter("TG1FORIN", referenciaBean.getFormaInicio().getCodReg());
			spq.setParameter("TG1CURSO", referenciaBean.getCurso().getCodReg());
			
			spq.setParameter("SINTOMAS", referenciaBean.getSintomas());
			spq.setParameter("RELATO",	 referenciaBean.getRelato());
			spq.setParameter("TEMPERAT", referenciaBean.getTemperatura());
			spq.setParameter("PRESARTE", referenciaBean.getPresionArterial());

			spq.setParameter("FRERESPI", referenciaBean.getFrecuenciaRespiratorio());
			spq.setParameter("FRECARDI", referenciaBean.getFrecuenciaCardiaca());

			spq.setParameter("EXAMAUXI", referenciaBean.getExamenesAuxHC());
			spq.setParameter("TRATAMIE", referenciaBean.getTratamientoHC());
			spq.setParameter("TG14CNPA", referenciaBean.getCondicionPaciente().getCodReg());

			spq.setParameter("CODESDES", referenciaBean.getEstablecimientoDestino().getCodRenaes());
			spq.setParameter("TG14MORE", referenciaBean.getMotivoReferencia().getCodReg());
			spq.setParameter("MOTIVORE", referenciaBean.getDescripcionMotivoReferencia()); 

			spq.setParameter("CDORGRES", referenciaBean.getResponsableReferencia().getCodigoOrganizacion());
			spq.setParameter("CDINSRES", referenciaBean.getResponsableReferencia().getCodigoInstitucion());
			spq.setParameter("CDSEDRES", referenciaBean.getResponsableReferencia().getCodigoSede());
			spq.setParameter("CODPERES", referenciaBean.getResponsableReferencia().getPersona().getCodigo());
			spq.setParameter("NRVERRES", referenciaBean.getResponsableReferencia().getNumeroVersion());
			spq.setParameter("NRPERRES", referenciaBean.getResponsableReferencia().getNumeroPeriodo());
			spq.setParameter("NCOLEGRE", referenciaBean.getResponsableReferencia().getNroColegiatura());
			spq.setParameter("TGPROFRE", referenciaBean.getResponsableReferencia().getPersona().getOcupacion().getCodReg());
			
			spq.setParameter("CDORGPES", referenciaBean.getResponsableEstablecimiento().getCodigoOrganizacion());
			spq.setParameter("CDINSPES", referenciaBean.getResponsableEstablecimiento().getCodigoInstitucion());
			spq.setParameter("CDSEDPES", referenciaBean.getResponsableEstablecimiento().getCodigoSede());
			spq.setParameter("CODPEEST", referenciaBean.getResponsableEstablecimiento().getPersona().getCodigo());
			spq.setParameter("NRVERPES", referenciaBean.getResponsableEstablecimiento().getNumeroVersion());
			spq.setParameter("NRPERPES", referenciaBean.getResponsableEstablecimiento().getNumeroPeriodo());
			spq.setParameter("NCOLEGES", referenciaBean.getResponsableEstablecimiento().getNroColegiatura());
			spq.setParameter("TGPROFES", referenciaBean.getResponsableEstablecimiento().getPersona().getOcupacion().getCodReg());
			 
			spq.setParameter("CDORGACO", referenciaBean.getPersonalAcompanante().getCodigoOrganizacion());
			spq.setParameter("CDINSACO", referenciaBean.getPersonalAcompanante().getCodigoInstitucion());
			spq.setParameter("CDSEDACO", referenciaBean.getPersonalAcompanante().getCodigoSede());
			spq.setParameter("CODPEACO", referenciaBean.getPersonalAcompanante().getPersona().getCodigo());
			spq.setParameter("NRVERACO", referenciaBean.getPersonalAcompanante().getNumeroVersion());
			spq.setParameter("NRPERACO", referenciaBean.getPersonalAcompanante().getNumeroPeriodo());
			spq.setParameter("NCOLEGAC", referenciaBean.getPersonalAcompanante().getNroColegiatura());
			spq.setParameter("TGPROFAC", referenciaBean.getPersonalAcompanante().getPersona().getOcupacion().getCodReg()); 
			
			spq.setParameter("TG14TPSE", referenciaBean.getPaciente().getTipoSeguro().getCodReg());
			spq.setParameter("CATEGORI", referenciaBean.getPaciente().getCategoriaSeguro());
			
			spq.setParameter("AUCDUSCR", referenciaBean.getCodigoUsuarioCreacion());
			spq.setParameter("AUPCIPCR", referenciaBean.getIpCreacion());

			spq.execute();

			idReferenciaCb = spq.getOutputParameterValue(1);
			nroperiodo = spq.getOutputParameterValue(2);
			nroVersi = spq.getOutputParameterValue(3);
			if (idReferenciaCb != null) {
				referenciaBean.setCodigo(idReferenciaCb.toString());
				referenciaBean.setNumeroPeriodo(nroperiodo.toString());
				referenciaBean.setNumeroVersion(nroVersi.toString());
				sw = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			sw = false;
		} finally {
			em.close();
		}
		return sw;
	}

	@Override
	public boolean actualizar(ReferenciaBean referenciaBean) throws DAOException {
		boolean sw = false;
		System.out.println("ReferenciaEspecialidadBean actualizar " + referenciaBean);
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("referencia.actualizar"); 
			spq.execute();
			sw = true;

		} catch (Exception e) {
			e.printStackTrace();
			sw = false;
		} finally {
			em.close();
		}
		return sw;
	}

	@Override
	public boolean eliminar(ReferenciaBean referenciaBean) throws DAOException {
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("referencia.eliminar");
			spq.setParameter("CODREFCB", referenciaBean.getCodigo());
			spq.setParameter("NROPERIO", referenciaBean.getNumeroPeriodo());
			spq.setParameter("NROVERSI", referenciaBean.getNumeroVersion());
			spq.setParameter("CODORGAN", referenciaBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", referenciaBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", referenciaBean.getCodigoSede());
			
			spq.setParameter("TG14MDES", referenciaBean.getMotivoDescarte().getCodReg());
			spq.setParameter("MOTIDESC", referenciaBean.getDetalleMotivoDescarte());
			
			spq.setParameter("AUCDUSMO", referenciaBean.getCodigoUsuarioModificacion());
			spq.setParameter("AUPCIPMO", referenciaBean.getIpModificacion());
			spq.execute();
			sw = true;

		} catch (Exception e) {
			e.printStackTrace();
			sw = false;
		} finally {
			em.close();
		}
		return sw;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ReferenciaBean getBuscarPorObjecto(ReferenciaBean referenciaBean) throws DAOException {
		ReferenciaBean oReferenciaBean = null;
		List<ReferenciaCB> lstReferencia = null;
		System.out.println("ReferenciaBean getBuscarPorObjecto " + referenciaBean.getCodigo());
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("referencia.findByObject");
			spq.setParameter("CODREFCB", referenciaBean.getCodigo());
			spq.setParameter("NROPERIO", referenciaBean.getNumeroPeriodo());
			spq.setParameter("NROVERSI", referenciaBean.getNumeroVersion());
			
			spq.setParameter("CODORGAN", referenciaBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", referenciaBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", referenciaBean.getCodigoSede());

			if (spq.execute()) {
				lstReferencia = spq.getResultList();
			}

			if (lstReferencia != null && lstReferencia.size() > 0) {

				oReferenciaBean = deReferenciaAReferenciaBean(lstReferencia.get(0));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		} finally {
			em.close();
		}
		return oReferenciaBean;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<ReferenciaBean> getBuscarPorFiltros(ReferenciaBean referenciaBean) throws DAOException {
		List<ReferenciaCB> lstReferencia = null;
		List<ReferenciaBean> lstReferenciaBean = null;

		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("referencia.findByLikeObject");
		spq.setParameter("FECREFDESDE", referenciaBean.getFechaDesde());
		spq.setParameter("FECREFHASTA", referenciaBean.getFechaHasta());
		spq.setParameter("NOMBESTORIG", referenciaBean.getEstablecimientoOrige().getNomRenaes());
		spq.setParameter("CODUSUAR", referenciaBean.getCodigoUsuarioSession());
		spq.setParameter("CODPERFIL", referenciaBean.getCodigoPerfilUsuarioSession());
		spq.setParameter("TIPOUPS", referenciaBean.getServicioUPSReferencia().getCodReg());
		if (spq.execute()) {
			lstReferencia = spq.getResultList();
		}
		if (lstReferencia != null && lstReferencia.size() > 0) {

			lstReferenciaBean = deListaReferenciaAListaReferenciaBean(lstReferencia);
		}
		 em.close();

		return lstReferenciaBean;
	}

	@Override
	public boolean existe(ReferenciaBean referenciaBean) throws DAOException {
		Boolean sw = true;
		List<ReferenciaEspecialidad> lstReferencia = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("referencia.existe");

			if (spq.execute()) {
				lstReferencia = spq.getResultList();
			}

			if (lstReferencia != null && lstReferencia.size() > 0) {

				sw = true;
			} else {
				sw = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		} finally {
			em.close();
		}

		return sw;
	}

	private List<ReferenciaBean> deListaReferenciaAListaReferenciaBean(List<ReferenciaCB> lstHorarioExcepcion) {

		List<ReferenciaBean> lstReferenciaBean = null;

		if (lstHorarioExcepcion != null && lstHorarioExcepcion.size() > 0) {

			lstReferenciaBean = new ArrayList<ReferenciaBean>();

			for (int i = 0; i < lstHorarioExcepcion.size(); i++) {
				ReferenciaCB entity = lstHorarioExcepcion.get(i);
				ReferenciaBean bean = deReferenciaAReferenciaBean(entity);

				lstReferenciaBean.add(bean);
			}
		}

		return lstReferenciaBean;
	}

	private ReferenciaBean deReferenciaAReferenciaBean(ReferenciaCB entity) {

		ReferenciaBean bean = null;

		if (entity != null) {

			bean = new ReferenciaBean();
			bean.setCodigo(entity.getId().getCodrefcb());
			bean.setCodigoOrganizacion(entity.getId().getCodorgan());
			bean.setCodigoInstitucion(entity.getId().getCodinsti());
			bean.setCodigoSede(entity.getId().getCodsedei());
			bean.setNumeroPeriodo(entity.getId().getNroperio());
			bean.setNumeroVersion(entity.getId().getNroversi());
			
			bean.getPaciente().getPersona().setPrimerNombre(entity.getPriNombr());
			bean.getPaciente().getPersona().setSegundoNombre(entity.getSegNombr());
			bean.getPaciente().getPersona().setApellidoPaterno(entity.getApePater());
			bean.getPaciente().getPersona().setApellidoMaterno(entity.getApeMater());
			bean.getPaciente().getPersona().setNroDocumento(entity.getNroDocum());
			bean.getPaciente().getPersona().setTelfCelu(entity.getNroCelu());
			bean.getPaciente().getPersona().setEdad(entity.getEdadAnios());
			bean.getPaciente().getPersona().setEdadCompleta(entity.getEdadCompleta());
			bean.getPaciente().getPersona().getSexo().setNombreCorto(entity.getNomSexo());
			bean.getPaciente().getPersona().setFechaNac(entity.getFechaNac());
			bean.getPaciente().setNroHC(entity.getNroHC());
			bean.getPaciente().setCodigoFiliacion(entity.getNroFilia());
			bean.getPaciente().getTipoSeguro().setCodReg(entity.getTg14TpSe());
			bean.getPaciente().getTipoSeguro().setNombreCorto(entity.getNomTipoPac());
			bean.getPaciente().setCategoriaSeguro(entity.getCategori());
			bean.getPaciente().setCodigoPacienteSigeho(entity.getCDPACSIG());
			
			bean.getPlanAtenSIS().setCodReg(entity.getTg14PLAN());
			bean.getPlanAtenSIS().setNombreCorto(entity.getNombPlan());
			bean.setFechaIngresoRef(entity.getFchingrf());
			bean.setFechaReferencia(entity.getFchrefer());
			bean.setHoraIngresoRef(entity.getHoraRefe());
			bean.setCodigoAfiliacion(entity.getNroFilia());
			bean.getEspecialidad().setNombreCorto(entity.getNomEspec());
			bean.getEspecialidad().setCodReg(entity.getCodEspec());
			bean.getEspecialidad().setNombreLargo(entity.getNomlaTPA());
			bean.getTiempoEnfermedad().setCodReg(entity.getTg1TIEMP());
			bean.getTiempoEnfermedad().setNombreCorto(entity.getNombTiem());
			bean.setCantTiempoEnfermedad(entity.getTiempEnf());
			bean.getFormaInicio().setCodReg(entity.getTg1FORIN());
			bean.getFormaInicio().setNombreCorto(entity.getNombFori());
			bean.getCurso().setCodReg(entity.getTg1CURSO());
			bean.getCurso().setNombreCorto(entity.getNombCurso());
			bean.setSintomas(entity.getSintomas());
			bean.setRelato(entity.getRelato());
			bean.setTemperatura(entity.getTEMPERAT());
			bean.setPresionArterial(entity.getPresArte());
			bean.setFrecuenciaRespiratorio(entity.getFreRespi());
			bean.setFrecuenciaCardiaca(entity.getFreCardi());
			bean.setExamenesAuxHC(entity.getExamAuxi());
			bean.setTratamientoHC(entity.getTratamien());
			bean.getCondicionPaciente().setCodReg(entity.getTg14CNPA());
			bean.getCondicionPaciente().setNombreCorto(entity.getNOMBCNPA());
			bean.getMotivoReferencia().setCodReg(entity.getTg14MoRe());
			bean.getMotivoReferencia().setNombreCorto(entity.getNOMBMORE());
			bean.setDescripcionMotivoReferencia(entity.getMotivoRe());
			
			bean.getServicioUPSReferencia().setCodReg(entity.getTg14TpUPS());
			bean.getServicioUPSReferencia().setNombreCorto(entity.getNombtpUPS());
			
			bean.getTipoSeguro().setNombreCorto(entity.getNomTipoPac());
			bean.getEstablecimientoOrige().setCodRenaes(entity.getCodesOri());
			bean.getEstablecimientoOrige().setNomRenaes(entity.getNomEstOri());
			bean.getEstablecimientoDestino().setNomRenaes(entity.getNomEstDes());
			bean.getEstablecimientoDestino().setCodRenaes(entity.getCodESDES()); 
			
			bean.setNumeroReferencia(entity.getNroRefer());
			bean.getSituacion().setCodReg(entity.getSituacrg());
			bean.getSituacion().setNombreCorto(entity.getNombSitu());
			
			bean.getResponsableReferencia().getPersona().setCodigo(entity.getCodPerRes());
			bean.getResponsableReferencia().getPersona().setApellidoPaterno(entity.getAPEPARES());
			bean.getResponsableReferencia().getPersona().setApellidoMaterno(entity.getAPEMARES());
			bean.getResponsableReferencia().getPersona().setPrimerNombre(entity.getPRINORES());
			bean.getResponsableReferencia().getPersona().setSegundoNombre(entity.getSEGNORES());
			bean.getResponsableReferencia().getPersona().getOcupacion().setCodReg(entity.getTpProRes());
			bean.getResponsableReferencia().setNroColegiatura(entity.getNroColRes());
			
			bean.setResponsableEstablecimiento(new PersonalBean());
			bean.getResponsableEstablecimiento().setPersona(new PersonaBean());
			bean.getResponsableEstablecimiento().getPersona().setCodigo(entity.getCodPeEst());
			bean.getResponsableEstablecimiento().getPersona().setApellidoPaterno(entity.getAPEPAPES());
			bean.getResponsableEstablecimiento().getPersona().setApellidoMaterno(entity.getAPEMAPES());
			bean.getResponsableEstablecimiento().getPersona().setPrimerNombre(entity.getPRINOPES());
			bean.getResponsableEstablecimiento().getPersona().setSegundoNombre(entity.getSEGNOPES());
			bean.getResponsableEstablecimiento().getPersona().getOcupacion().setCodReg(entity.getTpProEst());
			bean.getResponsableEstablecimiento().setNroColegiatura(entity.getNroColEst());
			
			bean.setPersonalAcompanante(new PersonalBean());
			bean.getPersonalAcompanante().setPersona(new PersonaBean());
			bean.getPersonalAcompanante().getPersona().setCodigo(entity.getCodPeAco());
			bean.getPersonalAcompanante().getPersona().setApellidoPaterno(entity.getAPEPAACO());
			bean.getPersonalAcompanante().getPersona().setApellidoMaterno(entity.getAPEMAACO());
			bean.getPersonalAcompanante().getPersona().setPrimerNombre(entity.getPRINOACO());
			bean.getPersonalAcompanante().getPersona().setSegundoNombre(entity.getSEGNOACO());
			bean.getPersonalAcompanante().getPersona().getOcupacion().setCodReg(entity.getTpProAco());
			bean.getPersonalAcompanante().setNroColegiatura(entity.getNroColAco());
		}

		return bean;
	}

	@Override
	public List<ReferenciaBean> listaEstadistico(ReferenciaBean referenciaBean)
			throws hnch.referencia.base.repository.DAOException {
		List<ReferenciaCB> lstReferencia = null;
		List<ReferenciaBean> lstReferenciaBean = null;

		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("referencia.listaEstadistico");
		spq.setParameter("FECREFDESDE", referenciaBean.getFechaDesde());
		spq.setParameter("FECREFHASTA", referenciaBean.getFechaHasta());
		spq.setParameter("NOMBESTORIG", referenciaBean.getEstablecimientoOrige().getNomRenaes());
		spq.setParameter("SITUACRG", referenciaBean.getSituacion().getCodReg());
		spq.setParameter("NOMPACIENTE", referenciaBean.getPaciente().getPersona().getNombreCompleto().trim());
		spq.setParameter("TIPOPACI", referenciaBean.getPaciente().getTipoSeguro().getCodReg());
		spq.setParameter("CODUSUAR", referenciaBean.getCodigoUsuarioSession());
		spq.setParameter("CODPERFIL", referenciaBean.getCodigoPerfilUsuarioSession());
		 
		if (spq.execute()) {
			lstReferencia = spq.getResultList();
		}
		if (lstReferencia != null && lstReferencia.size() > 0) {

			lstReferenciaBean = deListaReferenciaAListaReferenciaBean(lstReferencia);
		}
		 em.close();

		return lstReferenciaBean;
	}

	@Override
	public List<ReferenciaBean> listarPendienteCitas(ReferenciaBean referenciaBean)
			throws hnch.referencia.base.repository.DAOException {
		List<ReferenciaCB> lstReferencia = null;
		List<ReferenciaBean> lstReferenciaBean = null;
System.out.println("referenciaBean.getStrfechaIngresoRef() " + referenciaBean.getStrfechaIngresoRef());
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("referencia.listarPendienteCitas");
		spq.setParameter("FECREFER", referenciaBean.getStrfechaIngresoRef()); 
		spq.setParameter("CODUSUAR", referenciaBean.getCodigoUsuarioSession()); 
		spq.setParameter("TIPOUPS", referenciaBean.getServicioUPSReferencia().getCodReg());
		spq.setParameter("NROREFER", referenciaBean.getNumeroReferencia());
		if (spq.execute()) {
			lstReferencia = spq.getResultList();
		}
		if (lstReferencia != null && lstReferencia.size() > 0) {

			lstReferenciaBean = deListaReferenciaAListaReferenciaBean(lstReferencia);
		}
		 em.close();

		return lstReferenciaBean;
	}

}
