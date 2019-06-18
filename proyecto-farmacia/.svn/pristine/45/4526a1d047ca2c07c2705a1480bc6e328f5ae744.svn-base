package hnch.referencia.core.repository.implementacion.asistencial.banco;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hnch.referencia.core.bean.asistencial.banco.PostulanteBean;
import hnch.referencia.core.entity.asistencial.banco.Postulante;
import hnch.referencia.core.repository.DAOException;
import hnch.referencia.core.repository.interfaces.asistencial.banco.PostulanteDAO;

@Transactional
@Repository("PostulanteDAOImp")
public class PostulanteDAOImp implements PostulanteDAO {

	@PersistenceContext // (unitName="emf")
	private EntityManager em;

	public PostulanteBean getPostulanteBean(Object object) {
		return (PostulanteBean) object;
	}

	@Override
	public boolean insertar(PostulanteBean PostulanteBean) throws DAOException {

		Object id = null;
		Object nroPostulante = null;
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("postulante.insertar");
			spq.setParameter("CODORGAN", PostulanteBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", PostulanteBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", PostulanteBean.getCodigoSede());
			spq.setParameter("NROVERSI", PostulanteBean.getNumeroVersion());

			spq.setParameter("CODPERSO", PostulanteBean.getPersona().getCodigo());
			spq.setParameter("FECHA", PostulanteBean.getsFecha());
			spq.setParameter("HORA", PostulanteBean.getsHora());
			spq.setParameter("CODTEXPE", PostulanteBean.getPersona().getCodigoTelefono());
			spq.setParameter("CODDIXPE", PostulanteBean.getPersona().getCodigoDireccion());
			spq.setParameter("CODCORXP", PostulanteBean.getPersona().getCodigoCorreo());

			spq.setParameter("CODFISICO", PostulanteBean.getEstadoFisicoBean().getCodigo());
			spq.setParameter("CODTIPODONA", PostulanteBean.getTipoPostulate().getCodReg());
			spq.setParameter("CODPARENT", "");
			spq.setParameter("CODPROCE", "000001");
			spq.setParameter("CODPACIT", "");
			spq.setParameter("CODCONDI", "");
			spq.setParameter("CODSERVI", "");
			spq.setParameter("CAMA", "");

			spq.setParameter("ESTADOPO", "1");

			spq.setParameter("CODCAMPA", PostulanteBean.getCampania().getCodigo());
			spq.setParameter("VERCAMPD", PostulanteBean.getCampania().getNumeroVersion());
			spq.setParameter("PERCAMPD", PostulanteBean.getCampania().getNumeroPeriodo());

		//	spq.setParameter("NROPOST", PostulanteBean.getNumeroPostulante());

			spq.setParameter("AUCDUSCR", PostulanteBean.getIpCreacion());
			spq.setParameter("AUPCIPCR", PostulanteBean.getNombreUsuarioCreacion().toUpperCase());

			spq.execute();

			id = spq.getOutputParameterValue(5);
			nroPostulante = spq.getOutputParameterValue(24);
			if (id != null) {
				PostulanteBean.setCodigo(id.toString());
				PostulanteBean.setNumeroPostulante(nroPostulante.toString());
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
	public boolean actualizar(PostulanteBean PostulanteBean) throws DAOException {

		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("campania.modificar");
			spq.setParameter("CODORGAN", PostulanteBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", PostulanteBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", PostulanteBean.getCodigoSede());
			spq.setParameter("CODCAMPA", PostulanteBean.getCodigo());
			spq.setParameter("NROPERIO", PostulanteBean.getNumeroPeriodo());
			spq.setParameter("SITUACRG", PostulanteBean.getSituacion().getCodReg());

			spq.setParameter("AUCDUSMO", PostulanteBean.getCodigoUsuarioModificacion());
			spq.setParameter("AUPCIPMO", PostulanteBean.getIpModificacion());

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
	public boolean eliminar(PostulanteBean PostulanteBean) throws DAOException {

		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("postulante.eliminar");
			spq.setParameter("CODORGAN", PostulanteBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", PostulanteBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", PostulanteBean.getCodigoSede()); 
			spq.setParameter("NROVERSI", PostulanteBean.getNumeroVersion());
			spq.setParameter("NROPERIO", PostulanteBean.getNumeroPeriodo());
			spq.setParameter("NROPOST", PostulanteBean.getNumeroPostulante());
			
			spq.setParameter("AUCDUSMO", PostulanteBean.getCodigoUsuarioModificacion());
			spq.setParameter("AUPCIPMO", PostulanteBean.getIpModificacion());

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
	public PostulanteBean getBuscarPorObjecto(PostulanteBean PostulanteBean) throws DAOException {

		List<Postulante> lstCampania = null;
		PostulanteBean oPostulanteBean = null;

		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("postulante.buscarPorObjeto");
		spq.setParameter("CODORGAN", PostulanteBean.getCodigoOrganizacion());
		spq.setParameter("CODINSTI", PostulanteBean.getCodigoInstitucion());
		spq.setParameter("CODSEDEI", PostulanteBean.getCodigoSede());  
		spq.setParameter("NROPERIO", PostulanteBean.getNumeroPeriodo());
		spq.setParameter("NROPOST", PostulanteBean.getNumeroPostulante());

		if (spq.execute()) {
			lstCampania = spq.getResultList();
		}

		if (lstCampania != null && lstCampania.size() > 0) {
			oPostulanteBean = deListaObjetoAListaObjetoBean(lstCampania).get(0);
		}

		em.close();

		return oPostulanteBean;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PostulanteBean> getBuscarPorFiltros(PostulanteBean PostulanteBean) throws DAOException {
		List<Postulante> lstCampania = null;
		List<PostulanteBean> lstPostulanteBean = null;

		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("postulante.buscarPorFiltros");
		spq.setParameter("CODCAMPA", PostulanteBean.getCampania().getCodigo());

		if (spq.execute()) {
			lstCampania = spq.getResultList();
		}

		if (lstCampania != null && lstCampania.size() > 0) {
			lstPostulanteBean = deListaObjetoAListaObjetoBean(lstCampania);
		}

		em.close();

		return lstPostulanteBean;
	}

	private List<PostulanteBean> deListaObjetoAListaObjetoBean(List<Postulante> lstPostulante) {

		List<PostulanteBean> lstPostulanteBean = null;

		if (lstPostulante != null && lstPostulante.size() > 0) {

			lstPostulanteBean = new ArrayList<PostulanteBean>();

			for (int i = 0; i < lstPostulante.size(); i++) {
				Postulante entity = lstPostulante.get(i);
				PostulanteBean bean = deObjetoAObjetoBean(entity);

				lstPostulanteBean.add(bean);
			}
		}

		return lstPostulanteBean;
	}

	private PostulanteBean deObjetoAObjetoBean(Postulante entity) {

		PostulanteBean bean = null;
	//	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		if (entity != null) {

			bean = new PostulanteBean();
			bean.setCodigo(entity.getId().getNroPost());
			bean.setCodigoInstitucion(entity.getId().getCodinsti());
			bean.setCodigoSede(entity.getId().getCodsedei());
			bean.setCodigoOrganizacion(entity.getId().getCodorgan());
			bean.setNumeroVersion(entity.getId().getNroversi());
			bean.setNumeroPeriodo(entity.getId().getNroperio());
			
			bean.getCampania().setCodigo(entity.getCodCampa());
			bean.getCampania().setNombre(entity.getNOMLUGCA());
			bean.getCampania().getLugarCampaniaBean().setNombre(entity.getNOMLUGCA());
			
			bean.setNombreUsuarioCreacion(entity.getNOMUSUAR());
			bean.setFechaCreacion(entity.getAufechcr());
			bean.setNumeroPostulante(entity.getId().getNroPost());
			bean.setUltimaFechaDonacion(entity.getFecha());
			
			bean.getPersona().setApellidoPaterno(entity.getApepater());
			bean.getPersona().setApellidoMaterno(entity.getApemater());
			bean.getPersona().setPrimerNombre(entity.getPrinombr());
			bean.getPersona().setSegundoNombre(entity.getSegnombr());
			
			bean.getPersona().setCodigo(entity.getCodPerso());   
			 
			bean.getPersona().getTipoDocumento().setCodReg(entity.getTg1TpDoc());
			bean.getPersona().setNroDocumento(entity.getNroDocum()); 
			bean.getPersona().getSexo().setCodReg(entity.getTg1sexop());
			bean.getPersona().setFechaNac(entity.getFechanac());
			bean.getPersona().setFoto(entity.getFotoDeta()); 
			bean.getPersona().setDireccion(entity.getDesDirec());
			bean.getPersona().getEstadoCivil().setCodReg(entity.getTg1esciv());
			bean.getPersona().getNacionalidad().setCodReg(entity.getTg1nacio());
			bean.getPersona().getOcupacion().setCodReg(entity.getTg1ocupa());
			bean.getPersona().getNivelInstrucion().setCodReg(entity.getTg1niins());
			bean.getPersona().setFechaNacStr(entity.getSTRFECHANAC());
			bean.getPersona().getUbigeoDireccion().setCodigoUbigeo(entity.getTgUbigeo());
			bean.getPersona().getUbigeoDireccion().setNombreUbigeo(entity.getNOMLARGO());
			bean.getPersona().setEdad(entity.getEdadPers());
			bean.getPersona().getUbigeoNacimiento().setNombreUbigeo(entity.getNOMLUGNAC());
			bean.getPersona().getUbigeoNacimiento().setCodigoUbigeo(entity.getCODUBINA());
			
			bean.getPersona().setTelefonoNumero(entity.getTELFNUMR());
			bean.getPersona().setCorreo(entity.getCORDESCR());
			bean.getPersona().setCodigoCorreo(entity.getCODCORXP());
			bean.getPersona().setCodigoDireccion(entity.getCODDIXPE());
			bean.getPersona().setCodigoTelefono(entity.getCODTEXPE());
			
			bean.getEstadoFisicoBean().setCodigo(entity.getCODFISICO());
			bean.getEstadoFisicoBean().setCodigoOrganizacion(entity.getCODORGFA());
			bean.getEstadoFisicoBean().setCodigoInstitucion(entity.getCODINSFA());
			bean.getEstadoFisicoBean().setCodigoSede(entity.getCODSEDFA());
			bean.getEstadoFisicoBean().setNumeroVersion(entity.getNRVEREFA());
			bean.getEstadoFisicoBean().setNumeroPeriodo(entity.getNROPERIFA());
			bean.getEstadoFisicoBean().setFechaEvaluacion(entity.getFecEvalu());
			bean.getEstadoFisicoBean().setHora(entity.getHora());
			bean.getEstadoFisicoBean().getPersonaBean().setCodigo(entity.getCodPerso());
			bean.getEstadoFisicoBean().getSituacion().setNombreCorto(entity.getEstevalfi());
			bean.getEstadoFisicoBean().getFactor().setCodReg(entity.getCodfactor());
			bean.getEstadoFisicoBean().getFactor().setNombreCorto(entity.getFactor());
			bean.getEstadoFisicoBean().getGrupoSanguineo().setCodReg(entity.getCodgrupo());
			bean.getEstadoFisicoBean().getGrupoSanguineo().setNombreCorto(entity.getGrupo());
			bean.getEstadoFisicoBean().setObservacion(entity.getObs());
			bean.getEstadoFisicoBean().setHtco(entity.getHtco());
			bean.getEstadoFisicoBean().getCalificacion().setCodReg(entity.getCALIFDONA());
			bean.getEstadoFisicoBean().getCalificacion().setNombreCorto(entity.getNOMCALIF());
			bean.getEstadoFisicoBean().setEstado(entity.getEstadoEvf());
			bean.getEstadoFisicoBean().setResultadoSerologia(entity.getRESULTADO());
			
			bean.getTipoPostulate().setNombreCorto(entity.getTIPODONA());
			bean.getTipoParentescoPaciente().setNombreCorto(entity.getPARENTES());
		}

		return bean; 
	}

	@Override
	public boolean existe(PostulanteBean t) throws DAOException {

		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PostulanteBean buscarUltimaDonacion(PostulanteBean PostulanteBean) {
		PostulanteBean oPostulante = null;
		List<Postulante> lstPostulanteBean = null;
		System.out.println("PostulanteBean.getPostulante().getCodigo() " + PostulanteBean.getPersona().getCodigo());
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("postulante.buscarUltimaDonacion");
		spq.setParameter("CODPERSO", PostulanteBean.getPersona().getCodigo());

		if (spq.execute()) {
			lstPostulanteBean = spq.getResultList();
		}

		if (lstPostulanteBean != null && lstPostulanteBean.size() > 0) {
			oPostulante = deObjetoAObjetoBean(lstPostulanteBean.get(0));
		}

		em.close();

		return oPostulante;
	}

	@Override
	public List<PostulanteBean> listarPostulantesEstadoFisico(PostulanteBean PostulanteBean) {
		List<Postulante> lstCampania = null;
		List<PostulanteBean> lstPostulanteBean = null; 
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("postulante.estadoFisicoBuscarPorFiltros");
		spq.setParameter("FECHADES", PostulanteBean.getsFechaDesde());
		spq.setParameter("FECHAHAS", PostulanteBean.getsFechaHasta());
		spq.setParameter("ESTADOEV", PostulanteBean.getEstadoFisicoBean().getEstado());
		if (spq.execute()) {
			lstCampania = spq.getResultList();
		}

		if (lstCampania != null && lstCampania.size() > 0) {
			lstPostulanteBean = deListaObjetoAListaObjetoBean(lstCampania);
		}

		em.close();

		return lstPostulanteBean;
	}

	@Override
	public PostulanteBean obtenerPostulantesEstadoFisico(PostulanteBean PostulanteBean) {
		List<Postulante> lstCampania = null;
		PostulanteBean oPostulanteBean = null;

		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("postulante.estadoFisicoBuscarPorObjeto");
		spq.setParameter("CODORGAN", PostulanteBean.getCodigoOrganizacion());
		spq.setParameter("CODINSTI", PostulanteBean.getCodigoInstitucion());
		spq.setParameter("CODSEDEI", PostulanteBean.getCodigoSede());  
		spq.setParameter("NROPERIO", PostulanteBean.getNumeroPeriodo());
		spq.setParameter("NROPOST", PostulanteBean.getNumeroPostulante());

		if (spq.execute()) {
			lstCampania = spq.getResultList();
		}

		if (lstCampania != null && lstCampania.size() > 0) {
			oPostulanteBean = deListaObjetoAListaObjetoBean(lstCampania).get(0);
		}

		em.close();

		return oPostulanteBean;
	}

	@Override
	public List<PostulanteBean> listarPreDonantes(PostulanteBean PostulanteBean) {
		List<Postulante> lstCampania = null;
		List<PostulanteBean> lstPostulanteBean = null; 
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("postulante.preDonantesBuscarPorFiltros");
		spq.setParameter("FECHA", PostulanteBean.getEstadoFisicoBean().getsFecha()); 
		if (spq.execute()) {
			lstCampania = spq.getResultList();
		}

		if (lstCampania != null && lstCampania.size() > 0) {
			lstPostulanteBean = deListaObjetoAListaObjetoBean(lstCampania);
		}

		em.close();

		return lstPostulanteBean;
	}

	@Override
	public List<PostulanteBean> litarEstadoFisicaPorPerso(PostulanteBean PostulanteBean) {
		List<Postulante> lstCampania = null;
		List<PostulanteBean> lstPostulanteBean = null; 
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("postulante.litarEstadoFisicaPorPerso");
		spq.setParameter("CODPERSO", PostulanteBean.getPersona().getCodigo()); 
		if (spq.execute()) {
			lstCampania = spq.getResultList();
		}

		if (lstCampania != null && lstCampania.size() > 0) {
			lstPostulanteBean = deListaObjetoAListaObjetoBean(lstCampania);
		}

		em.close();

		return lstPostulanteBean;
	}

}
