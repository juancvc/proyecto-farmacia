package proyect.web.controller.inicio;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import proyect.core.bean.general.AlmacenBean;
import proyect.core.bean.general.TurnoBean;
import proyect.core.service.interfaces.general.AlmacenService;
import proyect.core.service.interfaces.general.TurnoService;
import proyect.base.service.ServiceException;
import proyect.web.utilitarios.acceso.LoginVo;


@Controller
@RequestMapping(value="")
public class MainController {
	List<AlmacenBean> lstAlmacenBean;
	List<TurnoBean> lstTurno;
	
	@Autowired
	AlmacenService almacenService;
	
	@Autowired
	private  TurnoService turnoService;
	
/*	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getdata() {
		System.out.println("controller");
		List<String> list = getList();

		//return back to index.jsp
		ModelAndView model = new ModelAndView("index");
		model.addObject("lists", list);
		System.out.println("list " + list.size());
		return model;

	}*/
	
	private void cargarComboAlmacen(ModelAndView mav){
		AlmacenBean almacenBean = new AlmacenBean();
		 
			try {
				lstAlmacenBean = almacenService.getBuscarPorFiltros(almacenBean);
				lstTurno = turnoService.getBuscarPorFiltros(new TurnoBean());
			} catch (ServiceException e) {
				e.printStackTrace(); 	
		}
  
		mav.addObject("lstAlmacenBean",lstAlmacenBean); 
		mav.addObject("lstTurno",lstTurno); 
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView goLogin() {
		LoginVo prmLogin = new LoginVo();
	//	return  new ModelAndView("seguridad/login/login", "command",prmLogin);
		
		ModelAndView mav =   new ModelAndView("seguridad/login/login", "command",prmLogin); 
		cargarComboAlmacen(mav);
		
		return mav;
		
	}
	
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public ModelAndView getdataLista() {
		System.out.println("controller");
		List<String> list = getList();

		//return back to index.jsp
		ModelAndView model = new ModelAndView("index");
		model.addObject("lists", list);
		System.out.println("list x" + list.size());
		return model;

	}

	private List<String> getList() {

		List<String> list = new ArrayList<String>();
		list.add("List A");
		list.add("List B");
		list.add("List C");
		list.add("List D");
		list.add("List 1");
		list.add("List 2");
		list.add("List 3");

		return list;

	}
}
