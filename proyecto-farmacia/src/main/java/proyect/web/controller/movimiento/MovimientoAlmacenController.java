package proyect.web.controller.movimiento;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.axis.types.Entities;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import proyect.core.bean.general.AlmacenBean;
import proyect.core.bean.general.CatalogoBean;
import proyect.core.bean.general.PersonaBean;
import proyect.core.bean.movimiento.MovimientoAlmacenBean;
import proyect.core.bean.stock.ArticuloBean;
import proyect.core.bean.stock.StockBean;
import proyect.core.bean.venta.VentaBean;
import proyect.base.service.ServiceException;
import proyect.core.service.interfaces.catalogo.Catalogo1Service;
import proyect.core.service.interfaces.catalogo.Catalogo2Service;
import proyect.core.service.interfaces.general.AlmacenService;
import proyect.core.service.interfaces.movimiento.MovimientoAlmacenService;
import proyect.core.service.interfaces.stock.ArticuloService;
import proyect.core.service.interfaces.stock.StockService;
import proyect.web.controller.base.BaseController; 

@Controller
@RequestMapping(value = "movimientoAlmacenController")
public class MovimientoAlmacenController extends BaseController{
	
	List<CatalogoBean> lstcatalogos = new ArrayList<CatalogoBean>();
	private MovimientoAlmacenBean movimientoAlmacenBean;
	
	List<CatalogoBean> lstMes;
	List<CatalogoBean> lstPeriodo;
	List<StockBean> lstStocks;
	List<ArticuloBean> lstArticulos;
	List<AlmacenBean> lstAlmacen;
	List<MovimientoAlmacenBean> lstMovimientoArticulo;
	List<MovimientoAlmacenBean> lstICImensual;
	
	@Autowired
	private ArticuloService articuloService;
	@Autowired
	private AlmacenService almacenService;
	@Autowired
	private Catalogo1Service Catalogo1Service;
	@Autowired
	private MovimientoAlmacenService movimientoAlmacenService;
	@Autowired
	private Catalogo2Service catalogo2Service;
	@Autowired
	private StockService StockService;
	
	private void cargarCombos(ModelAndView mav) {
		try {
			lstAlmacen = almacenService.getBuscarPorFiltros(new AlmacenBean());
			lstMes = catalogo2Service.listarPorCodigoTabla("000010", 2);
			lstPeriodo = catalogo2Service.listarPorCodigoTabla("000011", 0);
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		 
		mav.addObject("lstAlmacen", lstAlmacen); 
		mav.addObject("lstMes", lstMes);
		mav.addObject("lstPeriodo", lstPeriodo); 
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("catalogoBean") CatalogoBean catalogoBean,
			HttpServletRequest request)
			throws Exception { 
		List<CatalogoBean> lstcatalogosRegistros = new ArrayList<CatalogoBean>();
		
		ModelAndView mav = new ModelAndView("mantenimiento/articulo/listado-articulo", "command", catalogoBean); 
		
		lstcatalogosRegistros = Catalogo1Service.getBuscarPorFiltros(catalogoBean);
		mav.addObject("lstcatalogosRegistros", lstcatalogosRegistros);
		System.out.println("lstcatalogosRegistros " + lstcatalogosRegistros.size());
		this.cargarCombos(mav);
		return mav;
		
	}
	
	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("movimientoAlmacenBean") MovimientoAlmacenBean movimientoAlmacenBean,
			HttpServletRequest request) {
		return this.listado(movimientoAlmacenBean, request) ;
	}
	
	@RequestMapping(value = "/listadoICIMensual", method = RequestMethod.GET)
	public ModelAndView doListadoICIMensual(@ModelAttribute("movimientoAlmacenBean") MovimientoAlmacenBean movimientoAlmacenBean, HttpServletRequest request) {
		
		 String nombreMes = new SimpleDateFormat("MMMM").format(new Date());
		 
		java.util.Date fecha = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		String anio = dateFormat.format(fecha);
		java.util.Date fechaMes = new Date();
		SimpleDateFormat dateFormatMes = new SimpleDateFormat("MM");
		String mes = dateFormatMes.format(fechaMes);
		movimientoAlmacenBean.getPeriodo().setIdRegistro(anio);
		movimientoAlmacenBean.getMes().setIdRegistro(mes);
		movimientoAlmacenBean.getMes().setDescripcionCorta(nombreMes);
		ModelAndView mav = new ModelAndView("movimiento/ICI-mensual", "command", movimientoAlmacenBean); 
	
		this.cargarCombos(mav);
		
		mav.addObject("movimientoAlmacenBean", movimientoAlmacenBean);
		return mav;
	}

	
	@RequestMapping(value = "/listado", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView listado(@ModelAttribute("movimientoAlmacenBean") MovimientoAlmacenBean movimientoAlmacenBean, 
			HttpServletRequest request){
	 
		ModelAndView mav = new ModelAndView("mantenimiento/articulo/listado-articulo", "command", movimientoAlmacenBean); 
		this.cargarCombos(mav);
		return mav;
	}
	
	@RequestMapping(value = "/reporteKardex", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView reporteKardex(@ModelAttribute("movimientoAlmacenBean") MovimientoAlmacenBean movimientoAlmacenBean, 
			HttpServletRequest request){ 
		ArticuloBean articulo = new ArticuloBean(); 
		ModelAndView mav = new ModelAndView("movimiento/kardex-articulo", "command", movimientoAlmacenBean); 
		try {
			lstAlmacen = almacenService.getBuscarPorFiltros(new AlmacenBean());
			lstArticulos = articuloService.getBuscarPorFiltros(articulo); 
		} catch (Exception e) { 
		}
		mav.addObject("lstAlmacen", lstAlmacen);
		mav.addObject("lstArticulos", lstArticulos);
		this.cargarCombos(mav);
		return mav;
	}
	
	@RequestMapping(value = "/buscarArticuloKardex", method = RequestMethod.POST)
	public ModelAndView buscarArticuloKardex(@ModelAttribute("movimientoAlmacenBean") MovimientoAlmacenBean movimientoAlmacenBean,
			HttpServletRequest request)
			throws Exception { 
		ArticuloBean articulo = new ArticuloBean(); 
		System.out.println(movimientoAlmacenBean.getStockBean().getArticulo().getCodigo());
		ModelAndView mav = new ModelAndView("movimiento/kardex-articulo", "command", movimientoAlmacenBean); 
		
		try {
			lstAlmacen = almacenService.getBuscarPorFiltros(new AlmacenBean());
			lstArticulos = articuloService.getBuscarPorFiltros(articulo); 
			lstMovimientoArticulo = movimientoAlmacenService.buscarxArticuloAlmacen(movimientoAlmacenBean); 
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		mav.addObject("lstAlmacen", lstAlmacen);
		mav.addObject("lstArticulos", lstArticulos);
		mav.addObject("lstMovimientoArticulo", lstMovimientoArticulo);  
		mav.addObject("movimientoAlmacenBean", movimientoAlmacenBean); 
		//this.cargarCombosListado(mav);
		return mav;
		
	}
	
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo(HttpServletRequest request) {
		// cargarComboLeccion();
		CatalogoBean catalogoBean = new CatalogoBean(); 
		ModelAndView mav = new ModelAndView("general/Catalogos/registro-Catalogo", "command", catalogoBean); 
		this.cargarCombos(mav);
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
	
			try { 
				catalogoBean = Catalogo1Service.getBuscarPorObjecto(ocatalogoBean);  
			 System.out.println("catalogoBean::" + catalogoBean);
			} catch (ServiceException e) {
				
				e.printStackTrace();
			}
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
		try {
			if (catalogoBean.getIdRegistro()!=null && !catalogoBean.getIdRegistro().equals("")) { 
				sw = (Catalogo1Service.actualizar(catalogoBean));
			} else { 
				sw =  (Catalogo1Service.insertar(catalogoBean)); 
				
			} 
		} catch (Exception e) { 
			e.printStackTrace();
		}
		System.out.println("sw " + sw);
		if (sw) {
			movimientoAlmacenBean = new MovimientoAlmacenBean() ;
			 return this.listado(movimientoAlmacenBean, request);
			 
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
		try { 
			 if(Catalogo1Service.eliminar(catalogoBean)){
				 valida = "1";
			 }
			 

		} catch (Exception e) { 
			e.printStackTrace();
		} 
		return valida;
	}
	
	@RequestMapping(value = "/refrescarLista", method = RequestMethod.GET)
	public @ResponseBody List<CatalogoBean> refrescarLista(@RequestParam("catalogo") String catalogo)throws Exception { 
		 CatalogoBean catalogoBean = new CatalogoBean();
		 catalogoBean.setIdCatalogo(catalogo);
		List<CatalogoBean> lstcatalogoBean =new ArrayList<CatalogoBean>(); 
		try {
			lstcatalogoBean = Catalogo1Service.getBuscarPorFiltros(catalogoBean); 
		
		} catch (ServiceException e) {
			
			e.printStackTrace();
		}
		 
			return lstcatalogoBean; 
	}
 
	@RequestMapping(value = "/listarReporteICIMensual", method = RequestMethod.GET)
	public @ResponseBody List<CatalogoBean> listarReporteICIMensual(@RequestParam("catalogo") String catalogo)throws Exception { 
		 CatalogoBean catalogoBean = new CatalogoBean();
		 catalogoBean.setIdCatalogo(catalogo);
		List<CatalogoBean> lstcatalogoBean =new ArrayList<CatalogoBean>(); 
		try {
			lstcatalogoBean = Catalogo1Service.getBuscarPorFiltros(catalogoBean); 
		
		} catch (ServiceException e) {
			
			e.printStackTrace();
		}
		 
			return lstcatalogoBean; 
	}
	
	@RequestMapping(value = "/llenarDatosICI", method = RequestMethod.GET)
	public @ResponseBody String llenarDatosICI(
    		@ModelAttribute("movimientoAlmacenBean") MovimientoAlmacenBean movimientoAlmacenBean,
    		HttpServletResponse response)throws Exception { 
		 String valida = "";
		 this.setMovimientoAlmacenBean(movimientoAlmacenBean);
		 try { 
				lstICImensual = movimientoAlmacenService.listarReporteICI(movimientoAlmacenBean); 
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		return valida; 
	}
	
	 @RequestMapping(value = "/descargarExcel", method = RequestMethod.GET, produces = "application/vnd.ms-excel")
	    public @ResponseBody void descargarExcel(
	    		HttpServletResponse response) throws IOException { 
	    	 try {
	    		 Workbook wb = generarExcel();
	    		 response.setHeader("Content-disposition", "attachment; filename=reporteExcel.xls");
	    		 wb.write( response.getOutputStream() );
	         } catch (Exception e) {
	             e.printStackTrace();
	         }
	    }
	 
	   public HSSFWorkbook generarExcel() {
	        try {
	        	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
	            HSSFWorkbook workbook = new HSSFWorkbook();
	            //Hoja
	            HSSFSheet    sheet    = workbook.createSheet("ICI"+this.getMovimientoAlmacenBean().getMes().getIdRegistro()
	            		+this.getMovimientoAlmacenBean().getPeriodo().getIdRegistro());
	            /**** color ***/
	            HSSFColor lightGray =  setColor(workbook,(byte) 0xE0, (byte)0xE0,(byte) 0xE0);
	            /**estilos**/
	            //estilo para el titulo
	            HSSFFont headerFont = workbook.createFont();
	            CellStyle titleStyle = workbook.createCellStyle();
	            //titleStyle.setFillForegroundColor(lightGray.getIndex());
	            titleStyle.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
	            titleStyle.setAlignment(CellStyle.ALIGN_CENTER);
	            titleStyle.setFont(headerFont);
	            //estilo para el cabecera
	            HSSFCellStyle headerStyle = workbook.createCellStyle();
	            headerStyle.setFillForegroundColor(lightGray.getIndex());
	            headerStyle.setAlignment(CellStyle.ALIGN_CENTER);
	            headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	            headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	            headerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
	            headerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
	            headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	            //estilo para el cuerpo
	         	HSSFCellStyle bodyStyle = workbook.createCellStyle();
	         	//bodyStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	         	bodyStyle.setFillBackgroundColor(IndexedColors.WHITE.getIndex());
	         	bodyStyle.setAlignment(CellStyle.ALIGN_CENTER);
	         	bodyStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	         	bodyStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
	         	bodyStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
	         	bodyStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	            /*** tamaÃ¯Â¿Â½o de la columnas ***/
	            sheet.setColumnWidth(0, 2500); 
	            sheet.setColumnWidth(1, 2500);
	            sheet.setColumnWidth(2, 10000);
	            sheet.setColumnWidth(3, 10000); 
	            sheet.setColumnWidth(4, 10000);
	            sheet.setColumnWidth(5, 8000);
	            
	            sheet.setColumnWidth(6, 8000);

	            sheet.setColumnWidth(7, 5000);
	            /**** fuente ***/
	            //titulo
	            HSSFFont fontTitulo = workbook.createFont();
	            fontTitulo.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	            fontTitulo.setFontHeightInPoints((short) 14);
	            
	            titleStyle.setFont(fontTitulo);
	            //cabecera
	            HSSFFont fontCabecera = workbook.createFont();
	            fontCabecera.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	            fontCabecera.setFontHeightInPoints((short) 9);
	            
	            headerStyle.setFont(fontCabecera); 	
	            
	            /*** contenido del excel ***/
	            
	            
	            int rowIndex  = 0;
	            HSSFCell headerCell = null;
	            sheet.createRow( rowIndex++ );
	            sheet.createRow( rowIndex++ );
	            HSSFRow   headerRow    = sheet.createRow( rowIndex++ );
	            sheet.addMergedRegion(new CellRangeAddress(2, 2, 1, 7));
	            headerCell = headerRow.createCell(1);
	            headerCell.setCellValue("REPORTE DE INFORME DE CONSUMO INTEGRADO " + this.getMovimientoAlmacenBean().getMes().getDescripcionCorta().toUpperCase() 
	            		+ " "+ this.getMovimientoAlmacenBean().getPeriodo().getIdRegistro());
	            headerCell.setCellStyle(titleStyle);
	            sheet.createRow( rowIndex++ );
	            //Fila
	            HSSFRow      bodyRow    = sheet.createRow( rowIndex++ );
	            
	            /************************* cabecera *****************************/
		            
	            headerCell = bodyRow.createCell(1);
	            headerCell.setCellStyle(headerStyle);
	            headerCell.setCellValue("N°");
	            headerCell = bodyRow.createCell(2);
	            headerCell.setCellStyle(headerStyle);
	            headerCell.setCellValue("NOMBRE ARTICULO");
	            headerCell = bodyRow.createCell(3);
	            headerCell.setCellStyle(headerStyle);
	            headerCell.setCellValue("LOTE");
	            headerCell = bodyRow.createCell(4);
	            headerCell.setCellStyle(headerStyle);
	            headerCell.setCellValue("FECHA VENCIMIENTO");
	            headerCell = bodyRow.createCell(5);
	            headerCell.setCellStyle(headerStyle);
	            headerCell.setCellValue("CODIGO SISMED");
	            headerCell = bodyRow.createCell(6);
	            headerCell.setCellStyle(headerStyle);
	            headerCell.setCellValue("SALDO"); 
	            headerCell = bodyRow.createCell(7);
	            headerCell.setCellStyle(headerStyle);
	            headerCell.setCellValue("PRECIO");
	            
	            headerCell = bodyRow.createCell(8);
	            headerCell.setCellStyle(headerStyle);
	            headerCell.setCellValue("SALIDA POR VENTA");
	            headerCell = bodyRow.createCell(9);
	            headerCell.setCellStyle(headerStyle);
	            headerCell.setCellValue("SALIDA POR VENCIMIENTO");
	            headerCell = bodyRow.createCell(10);
	            headerCell.setCellStyle(headerStyle);
	            headerCell.setCellValue("SALIDA POR FALTANTE INVENTA");
	            headerCell = bodyRow.createCell(11);
	            headerCell.setCellStyle(headerStyle);
	            headerCell.setCellValue("SALIDA POR FALLA O ROTURA");
	            headerCell = bodyRow.createCell(12);
	            headerCell.setCellStyle(headerStyle);
	            headerCell.setCellValue("SALIDA POR ANULACION");
	            headerCell = bodyRow.createCell(13);
	            headerCell.setCellStyle(headerStyle);
	            headerCell.setCellValue("SALIDA POR TRANSFERENCIA");
	            headerCell = bodyRow.createCell(14);
	            headerCell.setCellStyle(headerStyle);
	            headerCell.setCellValue("INGRESO POR SOBRANTE INVENT");
	            headerCell = bodyRow.createCell(15);
	            headerCell.setCellStyle(headerStyle);
	            headerCell.setCellValue("INGRESO POR TRANSFERENCIA");
	            headerCell = bodyRow.createCell(16);
	            headerCell.setCellStyle(headerStyle);
	            headerCell.setCellValue("INGRESO POR DEVOLUCION");
	            headerCell = bodyRow.createCell(17);
	            headerCell.setCellStyle(headerStyle);
	            headerCell.setCellValue("INGRESO POR REQUISICION");
	            headerCell = bodyRow.createCell(18);
	            headerCell.setCellStyle(headerStyle);
	            headerCell.setCellValue("IMPORTE TOTAL");
	            /******************* Contenido *************************/
	    		HSSFRow  contentRow  = null;
	    		HSSFCell contentCell = null;
	    		
	    		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
	    	
	            for (int i = 0; i < this.lstICImensual.size(); i++) {
	            	
//	            	movimiento movimiento = this.lstmovimiento.get(i);
	            	MovimientoAlmacenBean movimiento = this.lstICImensual.get(i);
	            	contentRow = sheet.createRow( rowIndex++ );
	            	contentCell = contentRow.createCell(1);
	            	contentCell.setCellStyle(bodyStyle);
	            	contentCell.setCellValue(String.valueOf((i+1)));
	            	contentCell = contentRow.createCell(2);
	            	contentCell.setCellStyle(bodyStyle);
	            	contentCell.setCellValue(movimiento.getStockBean().getArticulo().getNombre());
	            	contentCell = contentRow.createCell(3);
	            	contentCell.setCellStyle(bodyStyle);
	            	contentCell.setCellValue(movimiento.getStockBean().getLote());
	            	contentCell = contentRow.createCell(4);
	            	contentCell.setCellStyle(bodyStyle);
	            	contentCell.setCellValue(dateFormat.format(movimiento.getStockBean().getFechaVencimiento()));
	            	contentCell = contentRow.createCell(5);
	            	contentCell.setCellStyle(bodyStyle);
	            	contentCell.setCellValue(movimiento.getStockBean().getArticulo().getCodigoSismed());
	            	contentCell = contentRow.createCell(6);
	            	contentCell.setCellStyle(bodyStyle);
	            	contentCell.setCellValue(movimiento.getStockBean().getStock());

	            	contentCell = contentRow.createCell(7);
	            	contentCell.setCellStyle(bodyStyle);
	            	contentCell.setCellValue(movimiento.getPrecio());
	            	contentCell = contentRow.createCell(8);
	            	contentCell.setCellStyle(bodyStyle);
	            	contentCell.setCellValue(movimiento.getReporteICI().getSALIDA_POR_VENTA());
	            	contentCell = contentRow.createCell(9);
	            	contentCell.setCellStyle(bodyStyle);
	            	contentCell.setCellValue("0");
	            	contentCell = contentRow.createCell(10);
	            	contentCell.setCellStyle(bodyStyle);
	            	contentCell.setCellValue("0");
	            	contentCell = contentRow.createCell(11);
	            	contentCell.setCellStyle(bodyStyle);
	            	contentCell.setCellValue("0");
	            	contentCell = contentRow.createCell(12);
	            	contentCell.setCellStyle(bodyStyle);
	            	contentCell.setCellValue(movimiento.getReporteICI().getSALIDA_POR_VENTA());
	            	contentCell = contentRow.createCell(13);
	            	contentCell.setCellStyle(bodyStyle);
	            	contentCell.setCellValue("0");
	            	contentCell = contentRow.createCell(14);
	            	contentCell.setCellStyle(bodyStyle);
	            	contentCell.setCellValue("0");
	            	contentCell = contentRow.createCell(15);
	            	contentCell.setCellStyle(bodyStyle);
	            	contentCell.setCellValue("0");
	            	contentCell = contentRow.createCell(16);
	            	contentCell.setCellStyle(bodyStyle);
	            	contentCell.setCellValue("0");
	            	contentCell = contentRow.createCell(17);
	            	contentCell.setCellStyle(bodyStyle);
	            	contentCell.setCellValue("0");
	            	contentCell = contentRow.createCell(18);
	            	contentCell.setCellStyle(bodyStyle);
	            	contentCell.setCellValue(movimiento.getStockBean().getStock() * movimiento.getPrecio());
	            }
	            workbook.write(new FileOutputStream("reporteExcel-ICI"+ this.getMovimientoAlmacenBean().getMes().getDescripcionCorta() 
	            		+ ""+ this.getMovimientoAlmacenBean().getPeriodo().getIdRegistro()+".xls"));

	            //return workbook.getBytes();
	            return workbook;
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	   public HSSFColor setColor(HSSFWorkbook workbook, byte r,byte g, byte b){
	        HSSFPalette palette = workbook.getCustomPalette();
	        HSSFColor hssfColor = null;
	        try {
	            hssfColor= palette.findColor(r, g, b); 
	            if (hssfColor == null ){
	                palette.setColorAtIndex(HSSFColor.LAVENDER.index, r, g,b);
	                hssfColor = palette.getColor(HSSFColor.LAVENDER.index);
	            }
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }

	        return hssfColor;
	    }

	public MovimientoAlmacenBean getMovimientoAlmacenBean() {
		return movimientoAlmacenBean;
	}

	public void setMovimientoAlmacenBean(MovimientoAlmacenBean movimientoAlmacenBean) {
		this.movimientoAlmacenBean = movimientoAlmacenBean;
	}
	   
	   
	   
}


