package proyect.web.controller.cuentaCorriente;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import proyect.base.service.ServiceException;
import proyect.core.bean.cuentaCorriente.CuentaCorrienteBean;
import proyect.core.bean.general.PersonaBean;

import proyect.core.service.interfaces.catalogo.Catalogo1Service;
import proyect.core.service.interfaces.cuentaCorriente.CuentaCorrienteService;
import proyect.web.controller.base.BaseController;

@Controller
@Scope(value="session")
@RequestMapping(value = "cuentaCorrienteController")
public class CuentaCorrienteController extends BaseController{
	@Autowired
	private CuentaCorrienteService cuentaCorrienteService;
	@Autowired
	private Catalogo1Service maestraGene01Services;

	List<CuentaCorrienteBean> lstCuentaCorrienteBean;
	private PersonaBean personaBean; 
	
	
	
	public PersonaBean getPersonaBean() {
		return personaBean;
	}



	public void setPersonaBean(PersonaBean personaBean) {
		this.personaBean = personaBean;
	}



	@PostConstruct
	public void init(){
		//this.setUsuarioBean(new UsuarioBean());
		//this.setPersonaBean(new PersonaBean());
	
		
	}
	
	
	
	@RequestMapping(value = "/listarPacienteCtaCtePendientes", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("cuentaCorrienteBean") CuentaCorrienteBean cuentaCorrienteBean,
			HttpServletRequest request)
			throws Exception { 
		ModelAndView mav = new ModelAndView("ventas/listado-venta", "command", cuentaCorrienteBean);  // crear el modal del listado de pacientes de cta cte
		
		try {
			lstCuentaCorrienteBean = cuentaCorrienteService.listarCtaCtePacientePendientes(cuentaCorrienteBean);  // te lista los pacientes de ctaCte
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		mav.addObject("lstCuentaCorrienteBean", lstCuentaCorrienteBean);
		mav.addObject("cuentaCorrienteBean", cuentaCorrienteBean);
		//this.cargarCombosListado(mav);
		return mav;
		
	}
	
	
}
