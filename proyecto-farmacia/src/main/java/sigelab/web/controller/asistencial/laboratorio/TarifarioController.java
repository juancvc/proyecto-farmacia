package sigelab.web.controller.asistencial.laboratorio;
 
import java.util.ArrayList; 
import java.util.List; 

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;  
import sigelab.core.bean.general.PersonaBean;
import sigelab.core.bean.general.TablaBean;
import sigelab.core.bean.general.TarifarioBean;
import sigelab.core.bean.general.TarifarioDetalleBean;
import sigelab.core.bean.general.UbigeoBean; 
import sigelab.core.service.exception.ServiceException; 
import sigelab.core.service.interfaces.asistencial.maestra.MaestraAsis01Service; 
import sigelab.core.service.interfaces.general.Maestra1Service; 
import sigelab.core.service.interfaces.general.TarifarioDetalleService;
import sigelab.core.service.interfaces.general.TarifarioService; 
import sigelab.web.controller.base.BaseController; 

@Controller
@RequestMapping(value = "tarifarioController")
public class TarifarioController extends BaseController {

	List<TablaBean> lstSituacion = new ArrayList<TablaBean>();
	List<TablaBean> lstDocumento = new ArrayList<TablaBean>();
	List<TablaBean> lstSexo = new ArrayList<TablaBean>();
	List<TablaBean> lstEstadoCivil = new ArrayList<TablaBean>();
	List<TablaBean> lstOcupacion = new ArrayList<TablaBean>();
	List<TablaBean> lstNacionalidad = new ArrayList<TablaBean>();
	List<TablaBean> lstNivelInstrucion = new ArrayList<TablaBean>();
	List<UbigeoBean> lstUbigeoBean = new ArrayList<UbigeoBean>();
	List<TablaBean> lstTipoExamen = new ArrayList<TablaBean>();

	List<TablaBean> lstAreasLab = new ArrayList<TablaBean>();

	PersonaBean personaBean = new PersonaBean(); 
	public UbigeoBean ubigeobean;
	TarifarioBean tarifarioBean = new TarifarioBean();
 
	private List<TarifarioBean> lstTarifarioBean;
	private List<TarifarioDetalleBean> lstTarifarioDetalleBean;

	@Autowired
	private MaestraAsis01Service maestraAsis01Service;

	@Autowired
	private TarifarioService tarifarioService;

	@Autowired
	private TarifarioDetalleService tarifarioDetalleService;

	@Autowired
	private Maestra1Service maestraGene01Services;

	@PostConstruct
	public void init() {

	}

	private void cargarCombos(ModelAndView mav) {
		try {
			/*
			 * lstSituacion =maestraBanc01Service.listarPorCodigoTabla("000034", 1);
			 * lstDocumento = maestraAsis01Service.listarPorCodigoTabla("000003", 1);
			 * lstSexo = maestraAsis01Service.listarPorCodigoTabla("000004", 1);
			 * lstEstadoCivil = maestraGene01Services.listarPorCodigoTabla("000005", 0);
			 * lstOcupacion = maestraGene01Services.listarPorCodigoTabla("000007", 0);
			 * lstNacionalidad = maestraGene01Services.listarPorCodigoTabla("000003", 0);
			 * lstNivelInstrucion = maestraGene01Services.listarPorCodigoTabla("000006", 0);
			 */
			lstAreasLab = maestraGene01Services.listarPorCodigoTabla("000063", 0);

		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		/*
		 * mav.addObject("lstSituacion", lstSituacion); mav.addObject("lstDocumento",
		 * lstDocumento); mav.addObject("lstSexo", lstSexo);
		 * mav.addObject("lstEstadoCivil", lstEstadoCivil); mav.addObject("lstAreasLab",
		 * lstAreasLab); mav.addObject("lstOcupacion", lstOcupacion);
		 * mav.addObject("lstNacionalidad", lstNacionalidad);
		 */
		mav.addObject("lstAreasLab", lstAreasLab);
	}

	@RequestMapping(value = "/nuevoTarifario", method = RequestMethod.GET)
	public ModelAndView nuevoRegistroTarifario(HttpServletRequest request) {
		tarifarioBean = new TarifarioBean();
		lstTarifarioDetalleBean = new ArrayList<TarifarioDetalleBean>();
		// tarifarioBean.setLstTarifarioDetalleBean(lstTarifarioDetalleBean);
		ModelAndView mav = new ModelAndView("general/tarifario/registro-tarifario", "command", tarifarioBean);
		mav.addObject("tarifarioBean", tarifarioBean);
		this.cargarCombos(mav);
		return mav;
	}

	@RequestMapping(value = "/tarifarioRegModal", method = RequestMethod.POST)
	public ModelAndView nuevoTarifario() throws Exception {

		ModelAndView mav = new ModelAndView("general/tarifario/registro-tarifario", "command", new TarifarioBean());
		lstTarifarioBean = new ArrayList<TarifarioBean>();
		lstTipoExamen = new ArrayList<TablaBean>();
		try {
			lstTarifarioBean = tarifarioService.getBuscarPorFiltros(new TarifarioBean());
			lstTipoExamen = maestraAsis01Service.listarPorCodigoTabla("000013", 1);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		mav.addObject("lstTarifarioBean", lstTarifarioBean);
		mav.addObject("lstTipoExamen", lstTipoExamen);
		return mav;
	}

	@RequestMapping(value = "/modificar", method = RequestMethod.POST)
	public ModelAndView doModificar(@RequestParam("index") Integer index, HttpServletRequest request) {
		lstTarifarioDetalleBean = new ArrayList<TarifarioDetalleBean>();
		System.out.println("modificar codigo: " + index);
		// TarifarioBean otarifarioBean = new TarifarioBean();
		tarifarioBean = this.lstTarifarioBean.get(index);
		System.out.println("modificar otarifarioBean: " + tarifarioBean.getCodigo());
		ModelAndView mav = new ModelAndView("general/tarifario/registro-tarifario", "command", tarifarioBean);
		TarifarioDetalleBean objTarifarioDetalleBean = new TarifarioDetalleBean();
		objTarifarioDetalleBean.setTarifarioBean(tarifarioBean);
		try {
			lstTarifarioDetalleBean = tarifarioDetalleService.getBuscarPorFiltros(objTarifarioDetalleBean);
			tarifarioBean.setLstTarifarioDetalleBean(lstTarifarioDetalleBean); 
		} catch (Exception e) { 
		}
		mav.addObject("tarifarioBean", tarifarioBean);
		mav.addObject("lstTarifarioDetalleBean", lstTarifarioDetalleBean);
		this.cargarCombos(mav);
		return mav;
	}

	@RequestMapping(value = "/grabarTarifario", method = RequestMethod.POST)
	public @ResponseBody String grabarTarifario( 
			@ModelAttribute("tarifarioBean") TarifarioBean tarifarioBean, HttpServletRequest request) throws Exception {
		String codigo = "";
		System.out.println("tarifarioBean lista " + tarifarioBean.getLstTarifarioDetalleBean().size());
		Boolean sw = false;
		if (tarifarioBean.getCodigo() != null && !tarifarioBean.getCodigo().equals("")) {
			this.setAuditoria(tarifarioBean, request, false);
			System.out.println("actualiza tarifarioBean " + tarifarioBean.getCodigo());
			if (tarifarioService.actualizar(tarifarioBean)) {
				System.out.println("tarifarioBean " + tarifarioBean.getCodigo());
				codigo = tarifarioBean.getCodigo();
				for (TarifarioDetalleBean objTarifarioDetalleBean : tarifarioBean.getLstTarifarioDetalleBean()) {
					objTarifarioDetalleBean.setTarifarioBean(tarifarioBean);
					this.setAuditoria(objTarifarioDetalleBean, request, false);
					System.out.println("tarifarioBean " + objTarifarioDetalleBean.getCodigo());
					System.out.println("objTarifarioDetalleBean " + objTarifarioDetalleBean.getTarifarioBean().getCodigo());
					sw = tarifarioDetalleService.actualizar(objTarifarioDetalleBean);
				} 
			}
		} else { 
			this.setAuditoria(tarifarioBean, request, true);
			System.out.println("insert tarifarioBean " + tarifarioBean.getTipo().getCodReg());
			if (tarifarioService.insertar(tarifarioBean)) {
				System.out.println("tarifarioBean " + tarifarioBean.getCodigo());
				codigo = tarifarioBean.getCodigo();  
			} 
		}
		this.setTarifarioBean(tarifarioBean);
		return codigo;
	}

	@RequestMapping(value = "/grabarTarifarioDetalle", method = RequestMethod.POST)
	public @ResponseBody String grabarTarifarioDetalle( 
			@RequestBody TarifarioDetalleBean[] detetalleArray, HttpServletRequest request) throws Exception {
		String codigo = "1"; 
 
				for (TarifarioDetalleBean tarifarioDetalleBean : detetalleArray) {
					tarifarioDetalleBean.setTarifarioBean(getTarifarioBean());
					System.out.println(
							"tarifarioDetalleBean.getValoresRefFtarifarioDetalleBeanin " + tarifarioDetalleBean.getValoresRefFin());
					this.setAuditoria(tarifarioDetalleBean, request, true);
					tarifarioDetalleService.insertar(tarifarioDetalleBean);
				}
  
		return codigo;
	}
	
	@RequestMapping(value = "/eliminar", method = RequestMethod.GET)
	public @ResponseBody String doEliminar(@RequestParam("index") Integer index, HttpServletRequest request) {
		String resultado = "";
		TarifarioBean oTarifarioBean = new TarifarioBean();
		oTarifarioBean = this.lstTarifarioBean.get(index);

		System.out.println("oCampaniaBean.getCodigo " + oTarifarioBean.getCodigo());
		System.out.println("oCampaniaBean " + oTarifarioBean);
		try {
			this.setAuditoria(oTarifarioBean, request, false);
			if (tarifarioService.eliminar(oTarifarioBean)) {
				System.out.println("Se eliminó el registro ");
				resultado = "1";
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return resultado;
	}

	@RequestMapping(value = "/eliminarDetalle", method = RequestMethod.GET)
	public @ResponseBody String eliminarDetalle(@RequestParam("index") Integer index, HttpServletRequest request) {
		String resultado = "";
		TarifarioDetalleBean oTarifarioBean = new TarifarioDetalleBean();
		oTarifarioBean = this.lstTarifarioDetalleBean.get(index);
		System.out.println("eliminarDetalle Se eliminó getCodigo " + oTarifarioBean.getCodigo());
		System.out.println("eliminarDetalle Se eliminó getTarifarioBean " + oTarifarioBean.getTarifarioBean().getCodigo());
		try {
			this.setAuditoria(oTarifarioBean, request, false);
			if (tarifarioDetalleService.eliminar(oTarifarioBean)) {
				System.out.println("Se eliminó el registro ");
				resultado = "1";
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	@RequestMapping(value = "/listarTarifario", method = RequestMethod.GET)
	public ModelAndView listarPostulantes() throws Exception {
		System.out.println("/listarTarifario");
		ModelAndView mav = new ModelAndView("general/tarifario/ajax/listado-tarifario");
		lstTarifarioBean = new ArrayList<TarifarioBean>();
		try {
			lstTarifarioBean = tarifarioService.getBuscarPorFiltros(new TarifarioBean());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		mav.addObject("lstTarifarioBean", lstTarifarioBean);
		return mav;
	}

	@RequestMapping(value = "/refrescarLista", method = RequestMethod.GET)
	public @ResponseBody List<TarifarioBean> refrescarLista() throws Exception {
		try {
			lstTarifarioBean = tarifarioService.getBuscarPorFiltros(new TarifarioBean());

		} catch (ServiceException e) {

			e.printStackTrace();
		}

		return lstTarifarioBean;
	}

	@RequestMapping(value = "/tarifarioModal", method = RequestMethod.POST)
	public ModelAndView tarifarioModal() throws Exception {

		ModelAndView mav = new ModelAndView("asistencial/laboratorio/listado-tarifario-modal", "command",
				new TarifarioBean());
		lstTarifarioBean = new ArrayList<TarifarioBean>();
		lstTipoExamen = new ArrayList<TablaBean>();
		try {
			lstTarifarioBean = tarifarioService.getBuscarPorFiltros(new TarifarioBean());
			lstTipoExamen = maestraAsis01Service.listarPorCodigoTabla("000013", 1);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		mav.addObject("lstTarifarioBean", lstTarifarioBean);
		mav.addObject("lstTipoExamen", lstTipoExamen);
		return mav;
	}

	@RequestMapping(value = "/listadoTarifario", method = RequestMethod.GET)
	public ModelAndView listadoTarifario() throws Exception {
		return listadoTarifarioPOST();
	}

	@RequestMapping(value = "/listadoTarifario", method = RequestMethod.POST)
	public ModelAndView listadoTarifarioPOST() throws Exception {

		ModelAndView mav = new ModelAndView("general/tarifario/listado-tarifario-general", "command",
				new TarifarioBean());
		lstTarifarioBean = new ArrayList<TarifarioBean>();
		lstTipoExamen = new ArrayList<TablaBean>();
		try {
			lstTarifarioBean = tarifarioService.getBuscarPorFiltros(new TarifarioBean());
			lstTipoExamen = maestraAsis01Service.listarPorCodigoTabla("000013", 1);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		mav.addObject("lstTarifarioBean", lstTarifarioBean);
		mav.addObject("lstTipoExamen", lstTipoExamen);
		cargarCombos(mav);
		return mav;
	}

	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView buscarPOST(@ModelAttribute("tarifarioBean") TarifarioBean tarifarioBean,
			HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView("general/tarifario/listado-tarifario-general", "command", tarifarioBean);
		lstTarifarioBean = new ArrayList<TarifarioBean>();
		try {
			lstTarifarioBean = tarifarioService.getBuscarPorFiltros(new TarifarioBean());
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		mav.addObject("lstTarifarioBean", lstTarifarioBean);
		mav.addObject("lstTipoExamen", lstTipoExamen);
		cargarCombos(mav);
		return mav;
	}

	@RequestMapping(value = "/agregarDetalle", method = RequestMethod.GET)
	public ModelAndView agregarDetalle(@ModelAttribute("tarifarioBean") TarifarioBean tarifarioBean,
			HttpServletRequest request) throws Exception {
		for (TarifarioDetalleBean tablaBean : tarifarioBean.getLstTarifarioDetalleBean()) {
			System.out.println("TarifarioDetalleBean " + tablaBean.getValoresRefFin());
		}

		System.out.println("getCodigo:::" + tarifarioBean.getCodigo());
		System.out.println(
				"tarifarioBean.getLstTarifarioDetalleBean():::" + tarifarioBean.getLstTarifarioDetalleBean().size());
		TarifarioDetalleBean objTarifarioDetalleBean = new TarifarioDetalleBean();
		objTarifarioDetalleBean.setCodigo("");
		objTarifarioDetalleBean.setValoresRefFin("");
		objTarifarioDetalleBean.setValoresRefIni("");
		objTarifarioDetalleBean.setUnidades("");
		// lstTarifarioDetalleBean.add(objTarifarioDetalleBean);
		try {
			// tarifarioBean.getLstTarifarioDetalleBean().add(objTarifarioDetalleBean);
			tarifarioBean.getLstTarifarioDetalleBean().add(objTarifarioDetalleBean);
		} catch (Exception e) {
			// TODO: handle exception
		}
		for (TarifarioDetalleBean tablaBean : tarifarioBean.getLstTarifarioDetalleBean()) {
			System.out.println("TarifarioDetalleBean " + tablaBean.getValoresRefFin());
		}
		ModelAndView mav = new ModelAndView("general/tarifario/ajax/listado-tarifario-detalle", "command",
				tarifarioBean);

		mav.addObject("lstTarifarioDetalleBean", tarifarioBean.getLstTarifarioDetalleBean());
		mav.addObject("tarifarioBean", tarifarioBean);
		return mav;
	}

	public PersonaBean getPersonaBean() {
		return personaBean;
	}

	public void setPersonaBean(PersonaBean personaBean) {
		this.personaBean = personaBean;
	}

 

	public TarifarioBean getTarifarioBean() {
		return tarifarioBean;
	}

	public void setTarifarioBean(TarifarioBean tarifarioBean) {
		this.tarifarioBean = tarifarioBean;
	}

	public List<TarifarioDetalleBean> getLstTarifarioDetalleBean() {
		return lstTarifarioDetalleBean;
	}

	public void setLstTarifarioDetalleBean(List<TarifarioDetalleBean> lstTarifarioDetalleBean) {
		this.lstTarifarioDetalleBean = lstTarifarioDetalleBean;
	}

}
