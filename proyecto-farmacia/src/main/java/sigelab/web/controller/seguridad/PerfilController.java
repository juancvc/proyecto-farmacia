package sigelab.web.controller.seguridad;
 
import sigelab.core.bean.general.TablaBean;
import sigelab.core.bean.seguridad.PerfilBean;
import sigelab.core.service.exception.ServiceException;
import sigelab.core.service.interfaces.general.Maestra1Service;
import sigelab.core.service.interfaces.seguridad.PerfilService;
import sigelab.web.controller.base.BaseController;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "perfilController")
public class PerfilController extends BaseController {
	@Autowired
	PerfilService perfilService;
	
	@Autowired
	private Maestra1Service 	maestra1Service;
	
	private PerfilBean perfilBean;
	private List<TablaBean>	lstSituacion;
	
	@PostConstruct
	public void init(){
		this.setPerfilBean(new PerfilBean());
	}
	
	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("perfilBean") PerfilBean bean) {
		
		return this.getLista(bean);
	}
	
	@RequestMapping(value = "/listado", method = RequestMethod.POST)
	public ModelAndView lista(@ModelAttribute("perfilBean") PerfilBean bean) {
		ModelAndView mav = new ModelAndView(); 
		List<PerfilBean> lstPerfilBean =new ArrayList<PerfilBean>(); 
		try {
			lstPerfilBean =  perfilService.getBuscarPorFiltros(bean);
			System.out.println("getLista sin errores " );
		} catch (Exception e) {
			System.out.println("getLista error " + e.getMessage());
		}

		 mav = new ModelAndView("seguridad/perfil/listado-perfil", "command",bean);
		mav.addObject("perfilBean", bean);
		mav.addObject("lstPerfilBean", lstPerfilBean);
		
		return mav;
	}
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo() {
		
		ModelAndView mav = new ModelAndView("seguridad/perfil/registro-perfil", "command",new PerfilBean());
		mav.addObject("lstSituacion",lstSituacion);
		mav.addObject("perfilBean", new PerfilBean());
		return mav;
	}
	
	@RequestMapping(value = "/modificar", method = RequestMethod.POST)
	public ModelAndView doObtener(@RequestParam("codigo") String codigo) {
		PerfilBean opPerfilBean = new PerfilBean();
		opPerfilBean.setCodigo(codigo);
		
		perfilBean = new PerfilBean();
		try {
			perfilBean = perfilService.getBuscarPorObjecto(opPerfilBean);
			if (perfilBean != null) {
				System.out.println("perfilBean nombre " + perfilBean.getNombrePerfil());
			}
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("seguridad/perfil/registro-perfil", "command",perfilBean);
		mav.addObject("perfilBean", perfilBean);
 
		return mav;
	} 
	
	
	@RequestMapping(value = "/grabarPerfil", method = RequestMethod.POST)
	//@ResponseBody
	public ModelAndView grabar(@ModelAttribute("perfilBean") PerfilBean perfilBean, HttpServletRequest request) {
		
		String codigo = "0";
		System.out.println("doGrabar @ModelAttribute");
		boolean sw = true;
		try {
		
			System.out.println("perfilBean.getCodigo() " + perfilBean.getCodigo());
			if (perfilBean.getCodigo()!=null && !perfilBean.getCodigo().equals("")) {
				this.setAuditoria(perfilBean, request, false); 
				System.out.println("actualiza perfil " + perfilBean.getCodigo());
				sw = (perfilService.actualizar(perfilBean));
			} else {
				this.setAuditoria(perfilBean, request, true); 
				System.out.println("insert perfil " + perfilBean.getCodigo());
				sw =  (perfilService.insertar(perfilBean)); 
				
			}
			codigo = "1";
		} catch (Exception e) { 
			e.printStackTrace();
		}
		System.out.println("sw " + sw);
		if (sw) {
			//ModelAndView mav = new ModelAndView("seguridad/perfil/listado-perfil", "command",new PerfilBean());
			//return mav ;
			perfilBean = new PerfilBean() ;
			return this.getLista(perfilBean);
		}else{
			ModelAndView mav = new ModelAndView("seguridad/perfil/registro-perfil", "command",perfilBean);
			return mav ;
		} 
		 
	}
	
/**	
	@RequestMapping(value = "/grabarPerfil", method = RequestMethod.POST)
	@ResponseBody
	public String doGrabar(@ModelAttribute("perfilBean") PerfilBean perfilBean, HttpServletRequest request) {
		
		String codigo = "0";
		System.out.println("doGrabar");
		boolean sw = true;
		try {
			this.setAuditoria(perfilBean, request, true);  
			System.out.println("perfilBean.getCodigo() " + perfilBean.getCodigo());
			if (perfilBean.getCodigo()!=null && !perfilBean.getCodigo().equals("")) {
				sw = (perfilService.actualizar(perfilBean));
			} else {
				sw =  (perfilService.insertar(perfilBean)); 
				
			}
			codigo = "1";
		} catch (Exception e) { 
			e.printStackTrace();
		}
 
		 return codigo ;
	}
	*/
	@RequestMapping(value = "/eliminar", method = RequestMethod.GET)
	public ModelAndView doEliminar(@RequestParam("codigo") String codigo,
			 HttpServletRequest request) {
		
		System.out.println("codigo eliminarPerfil:: " + codigo);
		boolean sw = true; 
		PerfilBean perfilBean = new PerfilBean();
		perfilBean.setCodigo(codigo);
		try {
			this.setAuditoria(perfilBean, request, false);  
			 sw = (perfilService.eliminar(perfilBean));
			 

		} catch (Exception e) { 
			e.printStackTrace();
		} 
			perfilBean = new PerfilBean() ;
			return this.getLista(perfilBean); 
	}
	
	@RequestMapping(value = "/listarPerfiles", method = RequestMethod.GET)
	public @ResponseBody List<PerfilBean> refrescarListaPerfil()throws Exception { 
		PerfilBean bean = new PerfilBean();
		List<PerfilBean> lstPerfilBean =new ArrayList<PerfilBean>(); 
		try {
			lstPerfilBean = perfilService.getBuscarPorFiltros(bean);
			if(lstPerfilBean != null && lstPerfilBean.size()>0){
				perfilBean = (PerfilBean)lstPerfilBean.get(0);
				
			}
		} catch (ServiceException e) {
			
			e.printStackTrace();
		}
		 
			return lstPerfilBean; 
	}
	
	private ModelAndView getLista(PerfilBean perfilBean) {
		
		List<PerfilBean> lstPerfilBean =new ArrayList<PerfilBean>(); 
		try {
			lstPerfilBean =  perfilService.getBuscarPorFiltros(perfilBean);
			System.out.println("getLista sin errores " );
		} catch (Exception e) {
			System.out.println("getLista error " + e.getMessage());
		}

		ModelAndView mav = new ModelAndView("seguridad/perfil/listado-perfil", "command",perfilBean);
		mav.addObject("perfilBean", perfilBean);
		mav.addObject("lstPerfilBean", lstPerfilBean);
//		this.cargarCombos(mav);
		return mav;
	}
	
	private void cargarCombos(ModelAndView mav){
		
		if (lstSituacion==null) {
			try {
				lstSituacion = maestra1Service.listarPorCodigoTabla("situacionPerfil",0);
			} catch (ServiceException e) {
				e.printStackTrace();
			}		
		}
  
		mav.addObject("lstSituacion",lstSituacion); 
	}  

	public PerfilBean getPerfilBean() {
		return perfilBean;
	}

	public void setPerfilBean(PerfilBean perfilBean) {
		this.perfilBean = perfilBean;
	}
	
	
}
