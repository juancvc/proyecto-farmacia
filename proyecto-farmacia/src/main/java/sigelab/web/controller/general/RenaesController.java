package sigelab.web.controller.general;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
 
import sigelab.core.bean.general.PersonalBean;
import sigelab.core.bean.general.RenaesBean; 

@Controller
@RequestMapping(value = "renaesController")
public class RenaesController {
	
	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("renaesBean") RenaesBean referenciaBean, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView("general/renaes/listado-renaes", "command", referenciaBean); 
		//mav.addObject("lstReferenciaBean", lstReferenciaBean);
		// this.cargarCombos(mav);
		return mav;
	}

	
	@RequestMapping(value = "/listado", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView listado(@ModelAttribute("referenciaBean") RenaesBean referenciaBean, HttpServletRequest request) throws Exception {
	 
		ModelAndView mav = new ModelAndView("general/renaes/listado-renaes", "command", referenciaBean); 
		return mav;
	}
 
	@RequestMapping(value = "/programaDestino", method = RequestMethod.GET)
	public ModelAndView doNuevo(HttpServletRequest request) {
		// cargarComboLeccion();
		RenaesBean referenciaForm = new RenaesBean(); 
		ModelAndView mav = new ModelAndView("general/renaes/registroDestino-renaes", "command", referenciaForm); 
		return mav;
	}

}
