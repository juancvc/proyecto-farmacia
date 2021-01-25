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
import proyect.core.bean.general.AlmacenBean;
import proyect.core.bean.general.CatalogoBean;
import proyect.base.service.ServiceException; 
import proyect.core.service.interfaces.general.AlmacenService;
import proyect.web.controller.base.BaseController; 

@Controller
@RequestMapping(value = "almacenController")
public class AlmacenController extends BaseController{
	
	List<CatalogoBean> lstcatalogos = new ArrayList<CatalogoBean>();
	List<AlmacenBean> lstAlmacenes = new ArrayList<AlmacenBean>();
	private AlmacenBean almacenBean; 
	
	@Autowired
	private AlmacenService almecenService;
	
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
	public ModelAndView doBuscar(@ModelAttribute("almacenBean") AlmacenBean almacenBean,
			HttpServletRequest request)
			throws Exception { 
		List<AlmacenBean> lstAlmacenes = new ArrayList<AlmacenBean>();
		
		ModelAndView mav = new ModelAndView("mantenimiento/almacen/listado-almacen", "command", almacenBean); 
		
		lstAlmacenes = almecenService.getBuscarPorFiltros(almacenBean);
		mav.addObject("lstAlmacenes", lstAlmacenes);
		System.out.println("lstAlmacenes " + lstAlmacenes.size());
		this.cargarCombos(mav);
		return mav;
		
	}
	
	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("AlmacenBean") AlmacenBean AlmacenBean, HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView("mantenimiento/almacen/listado-almacen", "command", AlmacenBean); 
		lstAlmacenes = new ArrayList<AlmacenBean>();
		this.setAlmacenBean(new AlmacenBean());
		almacenBean.setNombreAlmacen("");
		try {
			lstAlmacenes = almecenService.getBuscarPorFiltros(almacenBean);
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		mav.addObject("lstAlmacenes", lstAlmacenes);
		this.cargarCombos(mav);
		return mav;
	}

	
	@RequestMapping(value = "/listado", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView listado(@ModelAttribute("AlmacenBean") AlmacenBean AlmacenBean, HttpServletRequest request){
	 
		ModelAndView mav = new ModelAndView("mantenimiento/almacen/listado-almacen", "command", AlmacenBean); 
		 lstAlmacenes = new ArrayList<AlmacenBean>();
		this.setAlmacenBean(new AlmacenBean());
		almacenBean.setNombreAlmacen("");
		try {
			lstAlmacenes = almecenService.getBuscarPorFiltros(almacenBean);
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		mav.addObject("lstAlmacenes", lstAlmacenes);
		this.cargarCombos(mav);
		return mav;
	}
 
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo(HttpServletRequest request) {
		// cargarComboLeccion();
		AlmacenBean almacenBean = new AlmacenBean(); 
		ModelAndView mav = new ModelAndView("mantenimiento/almacen/registro-almacen", "command", almacenBean); 
		this.cargarCombos(mav);
		return mav;
	}
	@RequestMapping(value = "/modificar", method = RequestMethod.POST)
	public ModelAndView modificar(@RequestParam("index") int index){  
		 ;
		System.out.println("modificar index " + index); 
		AlmacenBean almacenBean = new AlmacenBean();   
		almacenBean = lstAlmacenes.get(index);
		ModelAndView mav = new ModelAndView("mantenimiento/almacen/registro-almacen", "command", almacenBean); 
		this.cargarCombos(mav);
		mav.addObject("almacenBean", almacenBean);
		mav.addObject("swActivo", "1"); 
		return mav;
	}
	
	@RequestMapping(value = "/grabar", method = RequestMethod.POST) 
	public ModelAndView grabar(@ModelAttribute("almacenBean") AlmacenBean almacenBean, HttpServletRequest request) {
		 
		System.out.println("doGrabar @almacenBean");
		boolean sw = true;
		try {
			if (almacenBean.getCodigo()!=null && !almacenBean.getCodigo().equals("")) { 
				this.setAuditoria(almacenBean, request, false); 
				sw = (almecenService.actualizar(almacenBean));
			} else { 
				this.setAuditoria(almacenBean, request, true); 
				sw =  (almecenService.insertar(almacenBean));
			} 
		} catch (Exception e) { 
			e.printStackTrace();
		}
		System.out.println("sw " + sw);
		if (sw) {
			almacenBean = new AlmacenBean() ;
			 return this.listado(almacenBean, request);
			 
		}else{
			ModelAndView mav = new ModelAndView("mantenimiento/almacen/registro-almacen", "command", almacenBean);
			return mav ;
		} 
		 
	} 
	
	@RequestMapping(value = "/eliminar", method = RequestMethod.GET)
	@ResponseBody
	public String doEliminar(@RequestParam("index") int index ,
			 HttpServletRequest request) {
		String valida = "";
		AlmacenBean almacenBean = new AlmacenBean();  
		almacenBean = lstAlmacenes.get(index);
	    System.out.println("almacenBean.getCodigo " + almacenBean.getCodigo());
	    try { 
	    	this.setAuditoria(almacenBean, request, true); 
			 if(almecenService.eliminar(almacenBean)){
				 valida = "1";
			 }
		} catch (Exception e) { 
			e.printStackTrace();
		} 
		return valida;
	}
	
 
	public AlmacenBean getAlmacenBean() {
		return almacenBean;
	}

	public void setAlmacenBean(AlmacenBean almacenBean) {
		this.almacenBean = almacenBean;
	}

	public List<AlmacenBean> getLstAlmacenes() {
		return lstAlmacenes;
	}

	public void setLstAlmacenes(List<AlmacenBean> lstAlmacenes) {
		this.lstAlmacenes = lstAlmacenes;
	}

	
	
}