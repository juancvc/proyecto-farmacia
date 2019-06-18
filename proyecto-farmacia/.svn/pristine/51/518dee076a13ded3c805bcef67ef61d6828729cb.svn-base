package hnch.referencia.web.controller.general;


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
import hnch.referencia.core.bean.general.TablaBean;
import hnch.referencia.core.bean.seguridad.PerfilBean;
import hnch.referencia.core.bean.seguridad.UsuarioBean;
import hnch.referencia.core.bean.seguridad.UsuarioRenaesBean;
import hnch.referencia.core.service.exception.ServiceException;
import hnch.referencia.core.service.interfaces.asistencial.maestra.MaestraAsis14Service;
import hnch.referencia.web.controller.base.BaseController; 

@Controller
@RequestMapping(value = "maestraController")
public class MaestraController extends BaseController{
	
	List<TablaBean> lstTablas = new ArrayList<TablaBean>();
	
	
	@Autowired
	private MaestraAsis14Service maestraAsis14Service;
	
	
	private void cargarCombos(ModelAndView mav) {
		try {
			lstTablas = maestraAsis14Service.listarTodasTablas(new TablaBean());
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		
		mav.addObject("lstTablas", lstTablas);
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("tablaBean") TablaBean tablaBean,
			HttpServletRequest request)
			throws Exception { 
		List<TablaBean> lstTablasRegistros = new ArrayList<TablaBean>();
		
		System.out.println("tablaBean.getCodigo() " + tablaBean.getCodigo());
		ModelAndView mav = new ModelAndView("general/maestras/listado-maestra", "command", tablaBean); 
		
		lstTablasRegistros = maestraAsis14Service.getBuscarPorFiltros(tablaBean);
		mav.addObject("lstTablasRegistros", lstTablasRegistros);
		System.out.println("lstTablasRegistros " + lstTablasRegistros.size());
		this.cargarCombos(mav);
		return mav;
		
	}
	
	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("renaesBean") TablaBean tablaBean, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("general/maestras/listado-maestra", "command", tablaBean); 
	
		this.cargarCombos(mav);
		return mav;
	}

	
	@RequestMapping(value = "/listado", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView listado(@ModelAttribute("tablaBean") TablaBean tablaBean, HttpServletRequest request){
	 
		ModelAndView mav = new ModelAndView("general/maestras/listado-maestra", "command", tablaBean); 
		this.cargarCombos(mav);
		return mav;
	}
 
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo(HttpServletRequest request) {
		// cargarComboLeccion();
		TablaBean tablaBean = new TablaBean(); 
		ModelAndView mav = new ModelAndView("general/maestras/registro-maestra", "command", tablaBean); 
		this.cargarCombos(mav);
		return mav;
	}
	@RequestMapping(value = "/modificar", method = RequestMethod.POST)
	public ModelAndView modificar(@RequestParam("tabla") String tabla,
								  @RequestParam("codigo") String codigoRegistro){  
		
		System.out.println("modificar tabla " + tabla);
		System.out.println("modificar codigoRegistro " + codigoRegistro);
		TablaBean oTablaBean = new TablaBean(); 
		oTablaBean.setTabla(tabla);
		oTablaBean.setCodReg(codigoRegistro);
		TablaBean tablaBean = new TablaBean();  
	
			try { 
				tablaBean = maestraAsis14Service.getBuscarPorObjecto(oTablaBean);  
			 System.out.println("tablaBean::" + tablaBean);
			} catch (ServiceException e) {
				
				e.printStackTrace();
			}
			ModelAndView mav = new ModelAndView("general/maestras/registro-maestra", "command",tablaBean); 
			this.cargarCombos(mav);
			mav.addObject("tablaBean", tablaBean);
			mav.addObject("swActivo", "1"); 
			return mav;
	}
	
	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
	//@ResponseBody
	public ModelAndView grabar(@ModelAttribute("tablaBean") TablaBean tablaBean, HttpServletRequest request) {
		 
		System.out.println("doGrabar @ModelAttribute");
		boolean sw = true;
		try {
		
			System.out.println("perfilBean.getCodigo() " + tablaBean.getCodReg());
			if (tablaBean.getCodReg()!=null && !tablaBean.getCodReg().equals("")) { 
				System.out.println("actualiza tablaBean " + tablaBean.getCodReg());
				sw = (maestraAsis14Service.actualizar(tablaBean));
			} else { 
				System.out.println("insert tablaBean " + tablaBean.getCodReg());
				sw =  (maestraAsis14Service.insertar(tablaBean)); 
				
			} 
		} catch (Exception e) { 
			e.printStackTrace();
		}
		System.out.println("sw " + sw);
		if (sw) {
			tablaBean = new TablaBean() ;
			 return this.listado(tablaBean, request);
			 
		}else{
			ModelAndView mav = new ModelAndView("general/maestras/registro-maestra", "command",tablaBean); 
			return mav ;
		} 
		 
	} 
	
	@RequestMapping(value = "/eliminar", method = RequestMethod.GET)
	@ResponseBody
	public String doEliminar(@RequestParam("tabla") String tabla,
							 @RequestParam("codReg") String codReg,
			 HttpServletRequest request) {
		String valida = "";
		System.out.println("codigo eliminar:: " + tabla); 
		TablaBean tablaBean = new TablaBean();
		tablaBean.setCodReg(codReg);
		tablaBean.setTabla(tabla);
		try { 
			 if(maestraAsis14Service.eliminar(tablaBean)){
				 valida = "1";
			 }
			 

		} catch (Exception e) { 
			e.printStackTrace();
		} 
		return valida;
	}
	
	@RequestMapping(value = "/refrescarLista", method = RequestMethod.GET)
	public @ResponseBody List<TablaBean> refrescarLista(@RequestParam("tabla") String tabla)throws Exception { 
		 TablaBean tablaBean = new TablaBean();
		 tablaBean.setTabla(tabla);
		List<TablaBean> lstTablaBean =new ArrayList<TablaBean>(); 
		try {
			lstTablaBean = maestraAsis14Service.getBuscarPorFiltros(tablaBean); 
		
		} catch (ServiceException e) {
			
			e.printStackTrace();
		}
		 
			return lstTablaBean; 
	}
}