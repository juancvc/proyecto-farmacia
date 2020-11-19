package proyect.web.controller.inventario;


import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

import proyect.core.bean.general.AlmacenBean;
import proyect.core.bean.general.CatalogoBean;
import proyect.core.bean.general.PersonalBean;
import proyect.core.bean.inventario.InventarioBean;
import proyect.core.bean.inventario.InventarioDetalleBean;
import proyect.core.bean.seguridad.UsuarioBean;
import proyect.core.bean.stock.StockBean; 
import proyect.core.bean.venta.VentaItemBean;
import proyect.base.service.ServiceException;
import proyect.core.service.interfaces.catalogo.Catalogo1Service;
import proyect.core.service.interfaces.catalogo.Catalogo2Service;
import proyect.core.service.interfaces.general.AlmacenService;
import proyect.core.service.interfaces.general.PersonalService;
import proyect.core.service.interfaces.inventario.InventarioService;
import proyect.core.service.interfaces.stock.StockService;
import proyect.web.controller.base.BaseController; 

@Controller
@RequestMapping(value = "inventarioController")
public class InventarioController extends BaseController{
	
	List<CatalogoBean> lstMes;
	List<CatalogoBean> lstPeriodo;
	List<PersonalBean> lstPersonal;
	List<StockBean> lstStocks;
	List<AlmacenBean> lstAlmacen;
	List<InventarioBean> lstInventarios;
	
	private InventarioBean inventarioBean;
	
	@Autowired
	private InventarioService inventarioService;
	
	@Autowired
	private Catalogo2Service catalogo2Service;
	
	@Autowired
	private PersonalService personalService;
	
	@Autowired
	private StockService StockService;
	
	@Autowired
	private AlmacenService almacenService;
	
	private void cargarCombos(ModelAndView mav) {
		try {
			lstMes = catalogo2Service.listarPorCodigoTabla("000010", 2);
			lstPeriodo = catalogo2Service.listarPorCodigoTabla("000011", 0);
			
			PersonalBean personal = new PersonalBean();
			personal.getPersona().setNombres("");
			personal.getPersona().setApellidoPaterno("");
			lstPersonal = personalService.getBuscarPorFiltros(personal);
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		mav.addObject("lstMes", lstMes);
		mav.addObject("lstPeriodo", lstPeriodo);
		mav.addObject("lstPersonal", lstPersonal);
	}
	

	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("inventarioBean") InventarioBean InventarioBean, HttpServletRequest request) {
		
		return listado(InventarioBean, request);
	}

	
	@RequestMapping(value = "/listado", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView listado(@ModelAttribute("inventarioBean") InventarioBean inventarioBean, HttpServletRequest request){	 
		
		ModelAndView mav = new ModelAndView("inventario/listado-inventario", "command", inventarioBean); 
		StockBean stock = new StockBean();
		
		try {
			lstInventarios = inventarioService.getBuscarPorFiltros(inventarioBean);
			lstAlmacen = almacenService.getBuscarPorFiltros(new AlmacenBean());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		mav.addObject("lstInventarios", lstInventarios);
		mav.addObject("lstAlmacen", lstAlmacen);
		this.cargarCombos(mav);
		return mav;
	}
 

	@RequestMapping(value = "/consultarInventario", method = RequestMethod.GET)
	public ModelAndView doConsultarInventario(@ModelAttribute("inventarioBean") InventarioBean InventarioBean, HttpServletRequest request) {
		
		return consultarInventario(InventarioBean, request);
	}

	
	@RequestMapping(value = "/consultarInventario", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView consultarInventario(@ModelAttribute("inventarioBean") InventarioBean inventarioBean, HttpServletRequest request){	 
		ModelAndView mav = new ModelAndView("inventario/consultar-inventario", "command", inventarioBean); 
		StockBean stock = new StockBean();
		
		try {
			lstStocks = StockService.getBuscarPorFiltros(stock);
			lstAlmacen = almacenService.getBuscarPorFiltros(new AlmacenBean());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		mav.addObject("lstStocks", lstStocks);
		mav.addObject("lstAlmacen", lstAlmacen);
		this.cargarCombos(mav);
		return mav;
	}
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView buscar(@ModelAttribute("inventarioBean") InventarioBean inventarioBean, HttpServletRequest request){	 
		ModelAndView mav = new ModelAndView("inventario/consultar-inventario", "command", inventarioBean); 
		StockBean stock = new StockBean();
		stock.setTipoLlamada("4");
		stock.setAlmacen(inventarioBean.getAlmacen());
		try {
			lstStocks = StockService.getBuscarPorFiltros(stock);
			lstAlmacen = almacenService.getBuscarPorFiltros(new AlmacenBean());
		} catch (ServiceException e) {
			e.printStackTrace();
		}		
		mav.addObject("lstStocks", lstStocks);
		mav.addObject("lstAlmacen", lstAlmacen);
		mav.addObject("inventarioBean", inventarioBean);
		this.cargarCombos(mav);
		return mav;
	}
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo(HttpServletRequest request) {
		// cargarComboLeccion();
		java.util.Date fecha = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		String anio = dateFormat.format(fecha);
		String nroMesDoc ="";
		java.util.Date fechaMes = new Date();
		SimpleDateFormat dateFormatMes = new SimpleDateFormat("MM");
		String mes = dateFormatMes.format(fechaMes);
		
		UsuarioBean usuario= (UsuarioBean) request.getSession().getAttribute("usuarioSesion");
		System.out.println("usuario.getAlmacen()" + usuario.getAlmacen().getCodigo());
		InventarioBean inventarioBean = new InventarioBean(); 
		inventarioBean.getPeriodo().setIdRegistro(anio);
		inventarioBean.getMes().setIdRegistro(mes);
		inventarioBean.setAlmacen(usuario.getAlmacen());
		nroMesDoc = mes;
		if (mes.length() == 1) {
			nroMesDoc = "0" + mes;
		}
		inventarioBean.setNroDocumento(inventarioBean.getAlmacen().getAlias() + "-"+ nroMesDoc+anio);
		StockBean stock = new StockBean();
		stock.setTipoLlamada("4");
		stock.setAlmacen(usuario.getAlmacen());
		ModelAndView mav = new ModelAndView("inventario/registro-inventario", "command", inventarioBean); 
		
		try {
			lstStocks = StockService.getBuscarPorFiltros(stock);
			lstAlmacen = almacenService.getBuscarPorFiltros(new AlmacenBean());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		this.cargarCombos(mav);
		mav.addObject("lstStocks", lstStocks);		
		mav.addObject("inventarioBean", inventarioBean);
		return mav;
	}
	
	@RequestMapping(value = "/modificar", method = RequestMethod.POST)
	public ModelAndView modificar(@RequestParam("catalogo") String catalogo,
								  @RequestParam("codigo") String codigoRegistro){  
		
		System.out.println("modificar catalogo " + catalogo);
		System.out.println("modificar codigoRegistro " + codigoRegistro);
		CatalogoBean ocatalogoBean = new CatalogoBean(); 
		ocatalogoBean.setIdCatalogo(catalogo);
		ocatalogoBean.setIdRegistro(codigoRegistro);
		CatalogoBean catalogoBean = new CatalogoBean();  
	
			 
			ModelAndView mav = new ModelAndView("general/Catalogos/registro-Catalogo", "command",catalogoBean); 
			this.cargarCombos(mav);
			mav.addObject("catalogoBean", catalogoBean);
			mav.addObject("swActivo", "1"); 
			return mav;
	}
	
	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
	//@ResponseBody
	public ModelAndView grabar(@ModelAttribute("catalogoBean") CatalogoBean catalogoBean, HttpServletRequest request) {
		 
		System.out.println("doGrabar @ModelAttribute");
		boolean sw = true;
		 
		System.out.println("sw " + sw);
		if (sw) {
			inventarioBean = new InventarioBean() ;
			 return this.listado(inventarioBean, request);
			 
		}else{
			ModelAndView mav = new ModelAndView("general/Catalogos/registro-Catalogo", "command",catalogoBean); 
			return mav ;
		} 
		 
	} 
	
	@RequestMapping(value = "/eliminar", method = RequestMethod.GET)
	@ResponseBody
	public String doEliminar(@RequestParam("catalogo") String catalogo,
							 @RequestParam("codReg") String codReg,
			 HttpServletRequest request) {
		String valida = "";
		System.out.println("codigo eliminar:: " + catalogo); 
		CatalogoBean catalogoBean = new CatalogoBean();
		catalogoBean.setIdRegistro(codReg);
		catalogoBean.setIdCatalogo(catalogo);
		 
		return valida;
	}
	
	@RequestMapping(value = "/refrescarLista", method = RequestMethod.GET)
	public @ResponseBody List<CatalogoBean> refrescarLista(@RequestParam("catalogo") String catalogo)throws Exception { 
		 CatalogoBean catalogoBean = new CatalogoBean();
		 catalogoBean.setIdCatalogo(catalogo);
		List<CatalogoBean> lstcatalogoBean =new ArrayList<CatalogoBean>(); 
		 
		 
			return lstcatalogoBean; 
	}
 
	@RequestMapping(value = "/configuracion", method = RequestMethod.GET)
	public ModelAndView configuracion(HttpServletRequest request) {
		// cargarComboLeccion();
		UsuarioBean usuario= (UsuarioBean) request.getSession().getAttribute("usuarioSesion");
		System.out.println("usuario.getAlmacen()" + usuario.getAlmacen().getCodigo());
		CatalogoBean catalogoBean = new CatalogoBean(); 
		ModelAndView mav = new ModelAndView("seguridad/configuracion/configuracion-inventario", "command", catalogoBean); 
	//	this.cargarCombos(mav);
		return mav;
	}
	
	@RequestMapping(value = "/llenarInventario", method = RequestMethod.GET)
	@ResponseBody
	public void llenarInventario(@ModelAttribute("inventarioBean") InventarioBean inventarioBean, HttpServletRequest request) {
		String nroMesDoc = "";
		nroMesDoc = inventarioBean.getMes().getIdRegistro();
		if (inventarioBean.getMes().getIdRegistro().length() == 1) {
			nroMesDoc = "0" + inventarioBean.getMes().getIdRegistro();
		}
		inventarioBean.setNroDocumento(inventarioBean.getAlmacen().getAlias() + "-"+ nroMesDoc
				+inventarioBean.getPeriodo().getIdRegistro());
		this.setInventarioBean(inventarioBean);
	}
	
   @RequestMapping(value = "/refrescarListaArticulos", method = RequestMethod.GET)
	public @ResponseBody InventarioDetalleBean refrescarListaOrden(@RequestParam("index") int index) throws Exception {
		System.out.println("index " + index);
		InventarioDetalleBean objInventarioDetalleBean = new InventarioDetalleBean(); 
		objInventarioDetalleBean.setStock(lstStocks.get(index));
		objInventarioDetalleBean.setCantidad(1);
		return objInventarioDetalleBean;
	}


    @RequestMapping(value = "/grabarInventario", method = RequestMethod.POST)
	@ResponseBody
	public String grabarInventario(
			@RequestBody InventarioDetalleBean[] inventarioDetalleArray,  
			HttpServletRequest request) {
   	
    	UsuarioBean usuario= (UsuarioBean) request.getSession().getAttribute("usuarioSesion");
		System.out.println("usuario.getAlmacen()" + usuario.getAlmacen().getCodigo());
		 
		String codigo = "";
		boolean sw = false;
		String cadenaCodigoStock = "@";
		String cadenaCantidad = "@";   
		this.getInventarioBean().setAlmacen(usuario.getAlmacen()); 
		for (InventarioDetalleBean prmInventarioDetalleBean : inventarioDetalleArray) {
			System.out.println("getCodReg == >" + prmInventarioDetalleBean.getStock().getCodigo());
			
			cadenaCantidad = cadenaCantidad + prmInventarioDetalleBean.getCantidad() + "@";
			cadenaCodigoStock = cadenaCodigoStock + prmInventarioDetalleBean.getStock().getCodigo() + "@";
		}
		this.getInventarioBean().setCadenaCantidad(cadenaCantidad);
		this.getInventarioBean().setCadenaIdStock(cadenaCodigoStock);
		this.getInventarioBean().setCantidadItems(inventarioDetalleArray.length);
		 
		try {

			if (this.getInventarioBean().getCodigo().equals("")) {
				this.setAuditoria(this.getInventarioBean(), request, true);
				  
				sw = (inventarioService.insertar(this.getInventarioBean()));

				if (sw) {
					codigo = this.getInventarioBean().getCodigo(); 
				} 

			} else {
				this.setAuditoria(this.getInventarioBean(), request, false);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("sw " + sw);
		return codigo; 
		 
	}
public InventarioBean getInventarioBean() {
	return inventarioBean;
}


public void setInventarioBean(InventarioBean inventarioBean) {
	this.inventarioBean = inventarioBean;
}
   
   
}