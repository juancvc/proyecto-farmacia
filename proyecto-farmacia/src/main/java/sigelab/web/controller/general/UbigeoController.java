package sigelab.web.controller.general;

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

import sigelab.core.bean.general.TablaBean;
import sigelab.core.bean.general.UbigeoBean;
import sigelab.core.service.interfaces.general.UbigeoService;
import sigelab.web.controller.base.BaseController;



@Controller
@RequestMapping(value = "ubigeoController")
public class UbigeoController extends BaseController {

	@Autowired
	public UbigeoService ubigeoService;
	public UbigeoBean ubigeobean;
	List<UbigeoBean> lstUbigeoBean = new ArrayList<UbigeoBean>();
	List<UbigeoBean> lstUbigeoFiltro = new ArrayList<UbigeoBean>();
	
//	@RequestMapping(value = "/listardepartamento", method = RequestMethod.GET)
//	public List<UbigeoBean> doListaDepartamento(@ModelAttribute("docenteBean") DocenteBean docenteBean)throws Exception {
//		List<UbigeoBean> lstProvincia = new ArrayList<UbigeoBean>();
//		DocenteBean prmDocenteBean = new DocenteBean();
//		prmDocenteBean= docenteBean;
//		//prmDocenteBean.setNombre("");
////		return this.getLista(prmDocenteBean);
//		
//		
//		return lstProvincia;
//	}
//	
	
	
	@RequestMapping(value = "/buscarProvincia", method = RequestMethod.GET)
	public @ResponseBody List<UbigeoBean> doBuscarProvincia(@RequestParam("codigodepartamento") String codigo)throws Exception {
		System.out.println("gua gua.. :"+codigo);
		List<UbigeoBean> lstProvincia = new ArrayList<UbigeoBean>();
		if (!codigo.equals("00")){
			ubigeobean = new UbigeoBean();
			ubigeobean.setCodigoRegion(codigo);
			lstProvincia = ubigeoService.listarProvincia(ubigeobean);
		}
		return lstProvincia;
	}
	
	

	
	
	@RequestMapping(value = "/buscarDistrito", method = RequestMethod.GET)
	public @ResponseBody  List<UbigeoBean> doBuscarDistrito(@RequestParam("codigodepartamento") String codigo,@RequestParam("codigoprovincia") String codigoprovincia)throws Exception {
		List<UbigeoBean> lstProvincia = new ArrayList<UbigeoBean>();
		if (!codigoprovincia.equals("00")){
		ubigeobean = new UbigeoBean();
		ubigeobean.setCodigoRegion(codigo);
		ubigeobean.setCodigoProvincia(codigoprovincia);
		lstProvincia = ubigeoService.listarDistrito(ubigeobean);
		}
		return lstProvincia;
	}
	
	@RequestMapping(value = "/listadoUbigeoModal", method = RequestMethod.POST)
	public ModelAndView listadoUbigeoModal() throws Exception {

		ModelAndView mav = new ModelAndView("general/ubigeo/listado-ubigeo-modal", "command", new UbigeoBean());
		ubigeobean = new UbigeoBean();
		ubigeobean.setVariable("");
		ubigeobean.setInstitucion("000003");
		ubigeobean.setCategoria("000003");
		lstUbigeoBean = new ArrayList<UbigeoBean>();
		try {
			
			lstUbigeoBean = ubigeoService.getBuscarPorFiltros(ubigeobean);
		} catch (Exception e) {
			// TODO: handle exception
		}
		mav.addObject("ubigeoBean", new UbigeoBean());
		mav.addObject("lstUbigeoBean", lstUbigeoBean);
		return mav;
	}
	
	@RequestMapping(value = "/buscarubigeo", method = RequestMethod.GET)
	public @ResponseBody  List<UbigeoBean> 
	doBuscarUbigeo(@ModelAttribute("ubigeoBean") UbigeoBean oUbigeoBean)throws Exception {
	//	List<UbigeoBean> lstUbigeo = new ArrayList<UbigeoBean>();
		lstUbigeoFiltro =  new ArrayList<UbigeoBean>();
		//oUbigeoBean = new UbigeoBean();
		//lstUbigeoBean = new ArrayList<UbigeoBean>();
		System.out.println("oUbigeoBean.getCodigoUbigeo() " + oUbigeoBean.getCodigoUbigeo()); 
		System.out.println("oUbigeoBean.getDetalle() " + oUbigeoBean.getDetalle()); 
		try {
			int idx = 0;
			//lstUbigeoBean = ubigeoService.getBuscarPorFiltros(oUbigeoBean);
			if (oUbigeoBean.getCodigoUbigeo().trim().length() > 0 && oUbigeoBean.getDetalle().trim().length() == 0) {
				System.out.println("if 1");
				if (lstUbigeoBean != null ) {
					for (UbigeoBean objUbigeoBean : lstUbigeoBean) {
						if (objUbigeoBean.getCodigoUbigeo().contains(oUbigeoBean.getCodigoUbigeo())) { 
							lstUbigeoFiltro.add(objUbigeoBean);
						}
					}
					
					lstUbigeoBean = lstUbigeoFiltro;
				}
			}else if (oUbigeoBean.getDetalle().trim().length() > 0 && oUbigeoBean.getCodigoUbigeo().trim().length() == 0){
				System.out.println("if 2");
					for (UbigeoBean objUbigeoBean : lstUbigeoBean) {
						if (objUbigeoBean.getDetalle().contains(oUbigeoBean.getDetalle().toUpperCase())) {
							lstUbigeoFiltro.add(objUbigeoBean);
						}
					}
					lstUbigeoBean = lstUbigeoFiltro;
					
			}else if (oUbigeoBean.getDetalle().trim().length() > 0 && oUbigeoBean.getCodigoUbigeo().trim().length() > 0){
				System.out.println("if 3");
					for (UbigeoBean objUbigeoBean : lstUbigeoBean) {
						if (objUbigeoBean.getDetalle().contains(oUbigeoBean.getDetalle())) {
							lstUbigeoFiltro.add(objUbigeoBean);
						}
					}
					for (UbigeoBean objUbigeoBean : lstUbigeoBean) {
						if (objUbigeoBean.getDetalle().contains(oUbigeoBean.getDetalle())) {
							lstUbigeoFiltro.add(objUbigeoBean);
						}
					}
					
					lstUbigeoBean = lstUbigeoFiltro;
					
			}else{
				System.out.println("if 4");
				ubigeobean = new UbigeoBean();
				ubigeobean.setVariable("");
				ubigeobean.setInstitucion("000003");
				ubigeobean.setCategoria("000003");
				lstUbigeoFiltro = ubigeoService.getBuscarPorFiltros(ubigeobean); //lstUbigeoFiltro = lstUbigeoBean;
			}
		} catch (Exception e) {
		} 
		return lstUbigeoFiltro;
	}

	@RequestMapping(value = "/enviarUbigeo", method = RequestMethod.GET)
	public @ResponseBody UbigeoBean enviarUbigeo(
			@RequestParam("index") Integer index, 
			@RequestParam("tipo") Integer tipo, HttpServletRequest request) throws Exception {  
    
		UbigeoBean oUbigeoBean = new UbigeoBean(); 
		try {
			oUbigeoBean = this.lstUbigeoBean.get(index);
			if (oUbigeoBean == null) {
				//this.getPostulanteBean().setCampania(oCampaniaBean);
			}
		} catch (Exception e) { 
		}
		
		
		return oUbigeoBean;
	}
		
}
