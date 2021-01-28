package proyect.web.controller.mantenimiento;


import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView; 
import proyect.core.bean.general.CatalogoBean;
import proyect.core.bean.stock.LaboratorioBean;
import proyect.core.service.interfaces.stock.LaboratorioService;
import proyect.base.service.ServiceException;
import proyect.web.controller.base.BaseController; 

@Controller
@RequestMapping(value = "laboratorioController")
public class LaboratorioController extends BaseController{
	
	List<CatalogoBean> lstcatalogos = new ArrayList<CatalogoBean>();
	List<LaboratorioBean> lstLaboratorios = new ArrayList<LaboratorioBean>();
	private LaboratorioBean laboratorioBean; 
	
	@Autowired
	private LaboratorioService laboratorioService;
	
	private void cargarCombos(ModelAndView mav) {
		/*try {
			lstcatalogos = Catalogo1Service.listarTodascatalogos(new CatalogoBean());
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		*/
		mav.addObject("lstcatalogos", lstcatalogos);
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("laboratorioBean") LaboratorioBean laboratorioBean,
			HttpServletRequest request)
			throws Exception { 
		List<LaboratorioBean> lstLaboratorios = new ArrayList<LaboratorioBean>();
		
		ModelAndView mav = new ModelAndView("mantenimiento/laboratorio/listado-laboratorio", "command", laboratorioBean); 
		
		lstLaboratorios = laboratorioService.getBuscarPorFiltros(laboratorioBean);
		mav.addObject("lstLaboratorios", lstLaboratorios);
		System.out.println("lstLaboratorios " + lstLaboratorios.size());
		this.cargarCombos(mav);
		return mav;
		
	}
	
	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("LaboratorioBean") LaboratorioBean LaboratorioBean, HttpServletRequest request) {

		return listado(LaboratorioBean, request);
	}

	
	@RequestMapping(value = "/listado", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView listado(@ModelAttribute("LaboratorioBean") LaboratorioBean LaboratorioBean, HttpServletRequest request){
	 
		ModelAndView mav = new ModelAndView("mantenimiento/laboratorio/listado-laboratorio", "command", LaboratorioBean); 
		 lstLaboratorios = new ArrayList<LaboratorioBean>();
		this.setLaboratorioBean(new LaboratorioBean()); 
		try {
			lstLaboratorios = laboratorioService.getBuscarPorFiltros(laboratorioBean);
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		mav.addObject("lstLaboratorios", lstLaboratorios);
		this.cargarCombos(mav);
		return mav;
	}
 
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo(HttpServletRequest request) {
		// cargarComboLeccion();
		LaboratorioBean laboratorioBean = new LaboratorioBean(); 
		ModelAndView mav = new ModelAndView("mantenimiento/laboratorio/registro-laboratorio", "command", laboratorioBean); 
		this.cargarCombos(mav);
		return mav;
	}
	@RequestMapping(value = "/modificar", method = RequestMethod.POST)
	public ModelAndView modificar(@RequestParam("index") int index){  
		 ;
		System.out.println("modificar index " + index); 
		LaboratorioBean laboratorioBean = new LaboratorioBean();   
		laboratorioBean = lstLaboratorios.get(index);
		ModelAndView mav = new ModelAndView("mantenimiento/laboratorio/registro-laboratorio", "command", laboratorioBean); 
		this.cargarCombos(mav);
		mav.addObject("laboratorioBean", laboratorioBean);
		mav.addObject("swActivo", "1"); 
		return mav;
	}
	
	@RequestMapping(value = "/grabar", method = RequestMethod.POST) 
	public ModelAndView grabar(@ModelAttribute("laboratorioBean") LaboratorioBean laboratorioBean, HttpServletRequest request) {
		 
		System.out.println("doGrabar @laboratorioBean");
		boolean sw = true;
		try {
			if (laboratorioBean.getCodigo()!=null && !laboratorioBean.getCodigo().equals("")) { 
				this.setAuditoria(laboratorioBean, request, false); 
				sw = (laboratorioService.actualizar(laboratorioBean));
			} else { 
				this.setAuditoria(laboratorioBean, request, true); 
				sw =  (laboratorioService.insertar(laboratorioBean));
			} 
		} catch (Exception e) { 
			e.printStackTrace();
		}
		System.out.println("sw " + sw);
		if (sw) {
			laboratorioBean = new LaboratorioBean() ;
			 return this.listado(laboratorioBean, request);
			 
		}else{
			ModelAndView mav = new ModelAndView("mantenimiento/laboratorio/registro-laboratorio", "command", laboratorioBean);
			return mav ;
		} 
		 
	} 
	
	@RequestMapping(value = "/eliminar", method = RequestMethod.GET)
	@ResponseBody
	public String doEliminar(@RequestParam("index") int index ,
			 HttpServletRequest request) {
		String valida = "";
		LaboratorioBean laboratorioBean = new LaboratorioBean();  
		laboratorioBean = lstLaboratorios.get(index);
	    System.out.println("laboratorioBean.getCodigo " + laboratorioBean.getCodigo());
	    try { 
	    	this.setAuditoria(laboratorioBean, request, true); 
			 if(laboratorioService.eliminar(laboratorioBean)){
				 valida = "1";
			 }
		} catch (Exception e) { 
			e.printStackTrace();
		} 
		return valida;
	}
	
 
	public LaboratorioBean getLaboratorioBean() {
		return laboratorioBean;
	}

	public void setLaboratorioBean(LaboratorioBean laboratorioBean) {
		this.laboratorioBean = laboratorioBean;
	}

	public List<LaboratorioBean> getLstLaboratorioes() {
		return lstLaboratorios;
	}

	public void setLstLaboratorioes(List<LaboratorioBean> lstLaboratorios) {
		this.lstLaboratorios = lstLaboratorios;
	}

	
	
}