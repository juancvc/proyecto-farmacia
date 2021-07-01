package proyect.web.controller.inventario;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import proyect.core.bean.general.AlmacenBean;
import proyect.core.bean.general.CatalogoBean;
import proyect.core.bean.general.PersonalBean;
import proyect.core.bean.inventario.InventarioBean;
import proyect.core.bean.inventario.InventarioDetalleBean;
import proyect.core.bean.seguridad.UsuarioBean;
import proyect.core.bean.stock.StockBean; 
import proyect.base.service.ServiceException; 
import proyect.core.service.interfaces.catalogo.Catalogo2Service;
import proyect.core.service.interfaces.general.AlmacenService;
import proyect.core.service.interfaces.general.PersonalService;
import proyect.core.service.interfaces.inventario.InventarioDetalleService;
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
	List<InventarioDetalleBean> lstInventarioDetalle;
	
	AlmacenBean objAlmacenBean = new AlmacenBean();
	private InventarioBean inventarioBean;
	
	@Autowired
	private InventarioService inventarioService;
	
	@Autowired
	private InventarioDetalleService inventarioDetalleService;
	
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
		this.setObjAlmacenBean(inventarioBean.getAlmacen());
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
		System.out.println("usuario.getAlmacen()" + usuario.getAlmacen().getCodigo() + "mes::" + ""+Integer.valueOf(mes));
		InventarioBean inventarioBean = new InventarioBean(); 
		inventarioBean.getPeriodo().setIdRegistro(anio);
		inventarioBean.getMes().setIdRegistro(""+Integer.valueOf(mes));
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
	public ModelAndView modificar(@RequestParam("index") int index){  
		inventarioBean = lstInventarios.get(index);
		StockBean stock = new StockBean();
		stock.setTipoLlamada("4");
		stock.setAlmacen(inventarioBean.getAlmacen());
		System.out.println("inventarioBean getPersonalResponsable:: " + inventarioBean.getPersonalResponsable().getCodigo());
		ModelAndView mav = new ModelAndView("inventario/registro-inventario", "command", inventarioBean); 
		InventarioDetalleBean inventarioDetalleBean = new InventarioDetalleBean();
		inventarioDetalleBean.setInventario(inventarioBean);
		try {
			lstStocks = StockService.getBuscarPorFiltros(stock);
			lstAlmacen = almacenService.getBuscarPorFiltros(new AlmacenBean());
			lstInventarioDetalle = inventarioDetalleService.getBuscarPorFiltros(inventarioDetalleBean);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		this.cargarCombos(mav);
		mav.addObject("lstInventarioDetalle", lstInventarioDetalle);
		mav.addObject("lstStocks", lstStocks);
		mav.addObject("inventarioBean", inventarioBean);
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
		return objInventarioDetalleBean;
	}


    @RequestMapping(value = "/procesarInventario", method = RequestMethod.GET)
  	@ResponseBody
  	public String procesarInventario( HttpServletResponse response,@RequestParam("index") int index,
			HttpServletRequest request) {
	    String valida ="0";
    	inventarioBean = lstInventarios.get(index);
    	try {
    		this.setAuditoria(inventarioBean, request, true);
			inventarioService.procesar(inventarioBean);
			valida ="1"; 
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
    	return valida;
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
    
    @RequestMapping(value = "rptInventarioAlmacen", method = RequestMethod.GET)
	@ResponseBody
	public void rptInventarioAlmacen( HttpServletResponse response,
			HttpServletRequest request) throws JRException, IOException {
		InputStream jasperStream = this.getClass().getResourceAsStream("/reportes/rptInventarioAlmacen.jasper");
       
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		String fecha ="";
		fecha = dateFormat.format(new Date());
		Map<String, Object> parametro = new HashMap<String, Object>();
		parametro.put("usuario", getUsuarioSesion(request).getNombreUsuario()); 
		 if (this.lstStocks !=null) {
			 parametro.put("almacen", this.lstStocks.get(0).getAlmacen().getNombreAlmacen());  
		}
		 
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lstStocks);
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametro, dataSource);

		response.setContentType("application/x-pdf");
		response.setHeader("Content-disposition", "inline; filename=Reporte_Inventario" + fecha + ".pdf");

		final OutputStream outStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);

	}
 
    @RequestMapping(value = "/descargarExcel", method = RequestMethod.GET, produces = "application/vnd.ms-excel")
	public @ResponseBody void descargarExcel(HttpServletResponse response) throws IOException {
    	if (this.lstStocks != null) {
    		try {
    			Workbook wb = generarExcel();
    			response.setHeader("Content-disposition", "attachment; filename=reporteExcel.xls");
    			wb.write(response.getOutputStream());
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
		}
	
	}

	public HSSFWorkbook generarExcel() {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String fecha = dateFormat.format(new Date());
			HSSFWorkbook workbook = new HSSFWorkbook();
			// Hoja
			HSSFSheet sheet = workbook.createSheet("INVENTARIO");
			/**** color ***/
			HSSFColor lightGray = setColor(workbook, (byte) 0xE0, (byte) 0xE0, (byte) 0xE0);
			/** estilos **/
			// estilo para el titulo
			HSSFFont headerFont = workbook.createFont();
			CellStyle titleStyle = workbook.createCellStyle();
			// titleStyle.setFillForegroundColor(lightGray.getIndex());
			titleStyle.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			titleStyle.setAlignment(CellStyle.ALIGN_CENTER);
			titleStyle.setFont(headerFont);
			// estilo para el cabecera
			HSSFCellStyle headerStyle = workbook.createCellStyle();
			headerStyle.setFillForegroundColor(lightGray.getIndex());
			headerStyle.setAlignment(CellStyle.ALIGN_CENTER);
			headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			headerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
			headerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
			headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			// estilo para el cuerpo
			HSSFCellStyle bodyStyle = workbook.createCellStyle();
			// bodyStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			bodyStyle.setFillBackgroundColor(IndexedColors.WHITE.getIndex());
			bodyStyle.setAlignment(CellStyle.ALIGN_CENTER);
			bodyStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			bodyStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
			bodyStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
			bodyStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			/*** tamaÃ¯Â¿Â½o de la columnas ***/
			sheet.setColumnWidth(0, 2500);
			sheet.setColumnWidth(1, 2500);
			sheet.setColumnWidth(2, 12000);
			sheet.setColumnWidth(3, 5000);
			sheet.setColumnWidth(4, 7000);
			sheet.setColumnWidth(5, 8000);
			sheet.setColumnWidth(6, 5000);
 
			/**** fuente ***/
			// titulo
			HSSFFont fontTitulo = workbook.createFont();
			fontTitulo.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			fontTitulo.setFontHeightInPoints((short) 14);

			titleStyle.setFont(fontTitulo);
			// cabecera
			HSSFFont fontCabecera = workbook.createFont();
			fontCabecera.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			fontCabecera.setFontHeightInPoints((short) 9);

			headerStyle.setFont(fontCabecera);

			/*** contenido del excel ***/

			int rowIndex = 0;
			HSSFCell headerCell = null;
			sheet.createRow(rowIndex++); 
			sheet.createRow(rowIndex++); 
			HSSFRow headerRow = sheet.createRow(rowIndex++);
			sheet.addMergedRegion(new CellRangeAddress(2, 2, 1, 6));
			headerCell = headerRow.createCell(1);
			headerCell.setCellValue("REPORTE INVENTARIO - "+ this.lstStocks.get(0).getAlmacen().getNombreAlmacen() +
					" "+ fecha);
			headerCell.setCellStyle(titleStyle);
			sheet.createRow(rowIndex++);
			// Fila
			HSSFRow bodyRow = sheet.createRow(rowIndex++);

			/************************* cabecera *****************************/

			headerCell = bodyRow.createCell(1);
			headerCell.setCellStyle(headerStyle);
			headerCell.setCellValue("N°");
			headerCell = bodyRow.createCell(2);
			headerCell.setCellStyle(headerStyle);
			headerCell.setCellValue("DESCRIPCION");
			headerCell = bodyRow.createCell(3);
			headerCell.setCellStyle(headerStyle);
			headerCell.setCellValue("LOTE");
			headerCell = bodyRow.createCell(4);
			headerCell.setCellStyle(headerStyle);
			headerCell.setCellValue("FECHA VENCIMIENTO");
			headerCell = bodyRow.createCell(5);
			headerCell.setCellStyle(headerStyle);
			headerCell.setCellValue("PRESENTACION");
			headerCell = bodyRow.createCell(6);
			headerCell.setCellStyle(headerStyle);
			headerCell.setCellValue("CANTIDAD"); 
			/******************* Contenido *************************/
			HSSFRow contentRow = null;
			HSSFCell contentCell = null;

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			for (int i = 0; i < this.lstStocks.size(); i++) {

//	            	personaBean personaBean = this.lstpersonaBean.get(i);
				StockBean stockBean = this.lstStocks.get(i);
				contentRow = sheet.createRow(rowIndex++);
				contentCell = contentRow.createCell(1);
				contentCell.setCellStyle(bodyStyle);
				contentCell.setCellValue(String.valueOf((i + 1)));
				contentCell = contentRow.createCell(2);
				contentCell.setCellStyle(bodyStyle);
				contentCell.setCellValue(stockBean.getArticulo().getNombre());
				contentCell = contentRow.createCell(3);
				contentCell.setCellStyle(bodyStyle);
				contentCell.setCellValue(stockBean.getLote());
				contentCell = contentRow.createCell(4);
				contentCell.setCellStyle(bodyStyle);
				contentCell.setCellValue(dateFormat.format(stockBean.getFechaVencimiento()));
				contentCell = contentRow.createCell(5);
				contentCell.setCellStyle(bodyStyle);
				contentCell.setCellValue(stockBean.getArticulo().getTipoPresentacion().getDescripcionLarga());
				contentCell = contentRow.createCell(6);
				contentCell.setCellStyle(bodyStyle);
				contentCell.setCellValue(stockBean.getStock());
 
			}
			workbook.write(new FileOutputStream("reporteExcel.xls"));

			// return workbook.getBytes();
			return workbook;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

    @RequestMapping(value = "rptInventarioProceso", method = RequestMethod.GET)
	@ResponseBody
	public void rptInventarioProceso( 
			@RequestParam("index") int index,
			HttpServletResponse response,
			HttpServletRequest request)  
		throws JRException, IOException {
		InputStream jasperStream = this.getClass().getResourceAsStream("/reportes/rptInventarioProceso.jasper");
		inventarioBean = lstInventarios.get(index);
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		String fecha ="";
		fecha = dateFormat.format(new Date());
		Map<String, Object> parametro = new HashMap<String, Object>();
		parametro.put("almacen", inventarioBean.getAlmacen().getNombreAlmacen()); 
		parametro.put("encargado", inventarioBean.getPersonalResponsable().getNombreCompleto()); 
		parametro.put("periodo", inventarioBean.getMes().getDescripcionCorta() + " - " +
								 inventarioBean.getPeriodo().getIdRegistro()); 
		parametro.put("nroDocumento", inventarioBean.getNroDocumento()); 
		parametro.put("usuario", getUsuarioSesion(request).getNombreUsuario()); 
	 	
		 
		try {
			lstInventarioDetalle = inventarioDetalleService.listarReporteProceso(inventarioBean);
		} catch (ServiceException e) { 
			e.printStackTrace();
		}
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lstInventarioDetalle);
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametro, dataSource);

		response.setContentType("application/x-pdf");
		response.setHeader("Content-disposition", "inline; filename=Reporte_Inventario"+inventarioBean.getNroDocumento()+".pdf");

		final OutputStream outStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);

	}
    
	public HSSFColor setColor(HSSFWorkbook workbook, byte r, byte g, byte b) {
		HSSFPalette palette = workbook.getCustomPalette();
		HSSFColor hssfColor = null;
		try {
			hssfColor = palette.findColor(r, g, b);
			if (hssfColor == null) {
				palette.setColorAtIndex(HSSFColor.LAVENDER.index, r, g, b);
				hssfColor = palette.getColor(HSSFColor.LAVENDER.index);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return hssfColor;
	}
	
	@RequestMapping(value = "/buscarInventario", method = RequestMethod.POST)
	public ModelAndView buscarInventario(@ModelAttribute("inventarioBean") InventarioBean inventarioBean, HttpServletRequest request){	 
		ModelAndView mav = new ModelAndView("inventario/listado-inventario", "command", inventarioBean);  
		try {
			lstInventarios = inventarioService.getBuscarPorFiltros(inventarioBean);
			lstAlmacen = almacenService.getBuscarPorFiltros(new AlmacenBean());
		} catch (ServiceException e) {
			e.printStackTrace();
		}		
		mav.addObject("lstInventarios", lstInventarios);
		mav.addObject("lstAlmacen", lstAlmacen);
		mav.addObject("inventarioBean", inventarioBean);
		this.cargarCombos(mav);
		return mav;
	}
	
public AlmacenBean getObjAlmacenBean() {
		return objAlmacenBean;
	}


	public void setObjAlmacenBean(AlmacenBean objAlmacenBean) {
		this.objAlmacenBean = objAlmacenBean;
	}


public InventarioBean getInventarioBean() {
	return inventarioBean;
}


public void setInventarioBean(InventarioBean inventarioBean) {
	this.inventarioBean = inventarioBean;
}
   
   
}