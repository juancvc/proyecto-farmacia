package proyect.web.controller.venta;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.RowSet;
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
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
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
import proyect.core.bean.cuentaCorriente.CuentaCorrienteBean;
import proyect.core.bean.general.AlmacenBean;
import proyect.core.bean.general.CatalogoBean;
import proyect.core.bean.general.EpisodioBean;
import proyect.core.bean.general.PacienteBean;
import proyect.core.bean.general.PersonaBean;
import proyect.core.bean.general.SerieBean;
import proyect.core.bean.general.UbigeoBean;
import proyect.core.bean.seguridad.UsuarioBean;
import proyect.core.bean.stock.StockBean;
import proyect.core.bean.venta.VentaBean;
import proyect.core.bean.venta.VentaItemBean; 
import proyect.base.service.ServiceException;
import proyect.core.service.interfaces.catalogo.Catalogo1Service;
import proyect.core.service.interfaces.catalogo.Catalogo2Service;
import proyect.core.service.interfaces.cuentaCorriente.CuentaCorrienteService;
import proyect.core.service.interfaces.general.AlmacenService;
import proyect.core.service.interfaces.general.PacienteService;
import proyect.core.service.interfaces.general.PersonaService;
import proyect.core.service.interfaces.general.SerieService;
import proyect.core.service.interfaces.general.UbigeoService;
import proyect.core.service.interfaces.stock.StockService;
import proyect.core.service.interfaces.venta.VentaItemService;
import proyect.core.service.interfaces.venta.VentaService;
import proyect.web.controller.base.BaseController;
import proyect.web.controller.venta.vista.VentaForm;
import proyect.web.utilitarios.VO;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import com.lowagie.text.html.simpleparser.HTMLWorker;
import com.lowagie.text.pdf.PdfReader;
import java.io.StringReader;

@Controller
@RequestMapping(value = "ventaController")
public class VentaController extends BaseController {

	List<CatalogoBean> lstTipoDocumento;
	List<CatalogoBean> lstTipoFinanciador;
	List<CatalogoBean> lstSexo;
	List<CatalogoBean> lstEstadoCivil;
	List<CatalogoBean> lstNacionalidad;
	List<CatalogoBean> lstTipoComprobante;
	List<CatalogoBean> lstTipoOperacion;
	List<CatalogoBean> lstTipoBusqueda;
	List<CatalogoBean> lstPeriodo;

	List<SerieBean> lstSerie;

	List<UbigeoBean> lstUbigeoBean;
	List<StockBean> lstStocks;
	List<PacienteBean> lstPacientes;
	List<PersonaBean> lstPersonas;
	List<VentaBean> lstPersonasVentas;
	List<VentaBean> lstVentas;
	List<AlmacenBean> lstAlmacen;
	List<VentaItemBean> lstVentasItemDevolucion;
	List<VentaItemBean> lstConsumoPaciente;
	List<CuentaCorrienteBean> lstCuentaCorrienteBean;
	private CatalogoBean tipoFinanciador;
	private VentaBean ventaBean;
	private UbigeoBean ubigeobean;
	private AlmacenBean almacenBean; 
	private PersonaBean personaBean;
	private String fechaEmision;
	private VentaBean ventaDevolucion;
	private CuentaCorrienteBean cuentaCorrienteBean;

	@Autowired
	private Catalogo1Service catalogo1Service;

	@Autowired
	private Catalogo2Service catalogo2Service;

	@Autowired
	private UbigeoService ubigeoService;

	@Autowired
	private StockService StockService;

	@Autowired
	private PersonaService personaService;

	@Autowired
	private PacienteService pacienteService;

	@Autowired
	private VentaService ventaService;

	@Autowired
	private VentaItemService ventaItemService;

	@Autowired
	private AlmacenService almacenService;

	@Autowired
	private SerieService serieService;

	@Autowired
	private CuentaCorrienteService cuentaCorrienteService;

	private void cargarCombos(ModelAndView mav) {
		SerieBean serie = new SerieBean();
		serie.getTipoComprobante().setIdRegistro("000001");
		try {
			lstTipoDocumento = catalogo2Service.listarPorCodigoTabla("000003", 1);
			lstTipoFinanciador = catalogo2Service.listarPorCodigoTabla("000008", 1);
			lstNacionalidad = catalogo1Service.listarPorCodigoTabla("000003", 1);
			lstSexo = catalogo1Service.listarPorCodigoTabla("000009", 1);
			lstEstadoCivil = catalogo1Service.listarPorCodigoTabla("000005", 1);
			lstTipoComprobante = catalogo2Service.listarPorCodigoTabla("000018", 0);
			lstTipoOperacion = catalogo2Service.listarPorCodigoTabla("000019", 1);
			lstSerie = serieService.getBuscarPorFiltros(serie);
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}

		mav.addObject("lstTipoDocumento", lstTipoDocumento);
		mav.addObject("lstTipoFinanciador", lstTipoFinanciador);
		mav.addObject("lstNacionalidad", lstNacionalidad);
		mav.addObject("lstSexo", lstSexo);
		mav.addObject("lstEstadoCivil", lstEstadoCivil);
		mav.addObject("lstTipoComprobante", lstTipoComprobante);
		mav.addObject("lstSerie", lstSerie);
		mav.addObject("lstTipoOperacion", lstTipoOperacion);
	}

	private void cargarCombosDevolucion(ModelAndView mav) {
		SerieBean serie = new SerieBean();
		serie.getTipoComprobante().setIdRegistro("000001");

		try {
			lstTipoBusqueda = catalogo2Service.listarPorCodigoTabla("000020", 1);
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}
		mav.addObject("lstTipoBusqueda", lstTipoBusqueda);
	}

	private void cargarCombosListado(ModelAndView mav) {
		try {
			lstAlmacen = almacenService.getBuscarPorFiltros(new AlmacenBean());
			lstTipoComprobante = catalogo1Service.listarPorCodigoTabla("000018", 0);
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}

		mav.addObject("lstAlmacen", lstAlmacen);
		mav.addObject("lstTipoComprobante", lstTipoComprobante);
	}

	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView doBuscar(@ModelAttribute("ventaBean") VentaBean ventaBean, HttpServletRequest request)
			throws Exception {
		ModelAndView mav = new ModelAndView("ventas/listado-venta", "command", ventaBean);

		try {
			lstVentas = ventaService.listarVentasDiarias(ventaBean);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		mav.addObject("lstVentas", lstVentas);
		mav.addObject("ventaBean", ventaBean);
		this.cargarCombosListado(mav);
		return mav;

	}

	@RequestMapping(value = "/buscarConsumoPaciente", method = RequestMethod.POST)
	public ModelAndView buscarConsumoPaciente(@ModelAttribute("ventaBean") VentaBean ventaBean,
			HttpServletRequest request) throws Exception {

		PersonaBean persona = new PersonaBean();
		ModelAndView mav = new ModelAndView("ventas/consumo-paciente", "command", ventaBean);

		try {
			lstConsumoPaciente = ventaItemService.listarConsumoPaciente(ventaBean);
			lstPersonas = personaService.getBuscarPorFiltros(persona);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		mav.addObject("lstPersonas", lstPersonas);
		mav.addObject("lstConsumo", lstConsumoPaciente);
		mav.addObject("ventaBean", ventaBean);
		// this.cargarCombosListado(mav);
		return mav;

	}

	@RequestMapping(value = "/consumoPaciente", method = RequestMethod.GET)
	public ModelAndView consumoPaciente(@ModelAttribute("ventaBean") VentaBean VentaBean, HttpServletRequest request) {

		PersonaBean persona = new PersonaBean();
		ModelAndView mav = new ModelAndView("ventas/consumo-paciente", "command", VentaBean);

		try {

			lstPersonas = personaService.getBuscarPorFiltros(persona);
		} catch (Exception e) {
		}
		mav.addObject("lstPersonas", lstPersonas);
		mav.addObject("ventaBean", ventaBean);
		return mav;
	}

	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView doListado(@ModelAttribute("ventaBean") VentaBean VentaBean, HttpServletRequest request) {
		return this.listado(VentaBean, request);
	}

	@RequestMapping(value = "/listado", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView listado(@ModelAttribute("ventaBean") VentaBean VentaBean, HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("ventas/listado-venta", "command", VentaBean);

		try {
			lstVentas = ventaService.listarVentasDiarias(VentaBean);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mav.addObject("ventaBean", VentaBean);
		mav.addObject("lstVentas", lstVentas);
		this.cargarCombosListado(mav);
		return mav;
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView doNuevo(HttpServletRequest request) {
		// cargarComboLeccion();
		VentaForm ventaForm = new VentaForm();
		PersonaBean persona = new PersonaBean();
		VentaBean ventaBean = new VentaBean();
		StockBean Stock = new StockBean();
		Stock.setTipoLlamada("1");
		UsuarioBean usuario = (UsuarioBean) request.getSession().getAttribute("usuarioSesion");
		System.out.println("usuario.getAlmacen()" + usuario.getAlmacen().getCodigo());
		Stock.setAlmacen(usuario.getAlmacen());
		ventaBean.setAlmacen(usuario.getAlmacen());
		ModelAndView mav = new ModelAndView("ventas/generar-venta", "command", ventaBean);
		this.cargarCombos(mav);
		try {

			lstStocks = StockService.getBuscarPorFiltros(Stock);
			System.out.println("lstStocks " + lstStocks.size());
		} catch (Exception e) {
		}
		mav.addObject("lstStocks", lstStocks);
		try {

			lstPersonas = personaService.getBuscarPorFiltros(persona);
			System.out.println("lstStocks " + lstStocks.size());
			System.out.println("lstPersonas " + lstPersonas.size());
		} catch (Exception e) {
		}
		mav.addObject("lstPersonas", lstPersonas);
		return mav;
	}

	@RequestMapping(value = "/modificar", method = RequestMethod.POST)
	public ModelAndView modificar(@RequestParam("catalogo") String catalogo,
			@RequestParam("codigo") String codigoRegistro) {

		System.out.println("modificar catalogo " + catalogo);
		System.out.println("modificar codigoRegistro " + codigoRegistro);
		CatalogoBean ocatalogoBean = new CatalogoBean();
		ocatalogoBean.setIdCatalogo(catalogo);
		ocatalogoBean.setIdRegistro(codigoRegistro);
		CatalogoBean catalogoBean = new CatalogoBean();

		try {
			catalogoBean = catalogo2Service.getBuscarPorObjecto(ocatalogoBean);
			System.out.println("catalogoBean::" + catalogoBean);
		} catch (ServiceException e) {

			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("general/Catalogos/registro-Catalogo", "command", catalogoBean);
		this.cargarCombos(mav);
		mav.addObject("catalogoBean", catalogoBean);
		mav.addObject("swActivo", "1");
		return mav;
	}

	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
	// @ResponseBody
	public ModelAndView grabar(@ModelAttribute("catalogoBean") CatalogoBean catalogoBean, HttpServletRequest request) {

		System.out.println("doGrabar @ModelAttribute");
		boolean sw = true;
		try {
			if (catalogoBean.getIdRegistro() != null && !catalogoBean.getIdRegistro().equals("")) {
				sw = (catalogo2Service.actualizar(catalogoBean));
			} else {
				sw = (catalogo2Service.insertar(catalogoBean));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("sw " + sw);
		if (sw) {
			ventaBean = new VentaBean();
			return this.listado(ventaBean, request);

		} else {
			ModelAndView mav = new ModelAndView("general/Catalogos/registro-Catalogo", "command", catalogoBean);
			return mav;
		}

	}

	@RequestMapping(value = "/eliminar", method = RequestMethod.GET)
	@ResponseBody
	public String doEliminar(@RequestParam("catalogo") String catalogo, @RequestParam("codReg") String codReg,
			HttpServletRequest request) {
		String valida = "";
		System.out.println("codigo eliminar:: " + catalogo);
		CatalogoBean catalogoBean = new CatalogoBean();
		catalogoBean.setIdRegistro(codReg);
		catalogoBean.setIdCatalogo(catalogo);
		try {
			if (catalogo2Service.eliminar(catalogoBean)) {
				valida = "1";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return valida;
	}

	@RequestMapping(value = "/refrescarLista", method = RequestMethod.GET)
	public @ResponseBody List<CatalogoBean> refrescarLista(@RequestParam("catalogo") String catalogo) throws Exception {
		CatalogoBean catalogoBean = new CatalogoBean();
		catalogoBean.setIdCatalogo(catalogo);
		List<CatalogoBean> lstcatalogoBean = new ArrayList<CatalogoBean>();
		try {
			lstcatalogoBean = catalogo2Service.getBuscarPorFiltros(catalogoBean);

		} catch (ServiceException e) {

			e.printStackTrace();
		}

		return lstcatalogoBean;
	}

	@RequestMapping(value = "/personaModal", method = RequestMethod.POST)
	public ModelAndView personaModalPost() throws Exception {
		PersonaBean objPersona = new PersonaBean();
		objPersona.getNacionalidad().setIdRegistro("000114");
		objPersona.getEstadoCivil().setIdRegistro("000006");
		ModelAndView mav = new ModelAndView("ventas/persona-registro-modal", "command", objPersona);
		ubigeobean = new UbigeoBean();
		ubigeobean.setDescripcion("");
		ubigeobean.setInstitucion("000003");
		ubigeobean.setCategoria("000003");
		lstUbigeoBean = new ArrayList<UbigeoBean>();
		try {

			lstUbigeoBean = ubigeoService.getBuscarPorFiltros(ubigeobean);
		} catch (Exception e) {
		}
		mav.addObject("personaBean", objPersona);
		mav.addObject("ubigeoBean", new UbigeoBean());
		mav.addObject("lstUbigeoBean", lstUbigeoBean);
		this.cargarCombos(mav);
		return mav;
	}

	@RequestMapping(value = "/grabarPersona", method = RequestMethod.POST)
	public @ResponseBody PersonaBean grabarPersonaLaboratorio(@ModelAttribute("personaBean") PersonaBean obpersonaBean,
			HttpServletRequest request) throws Exception {

		if (personaBean == null) {
			personaBean = new PersonaBean();
		}

		System.out.println("obpersonaBean.getCodigo() " + obpersonaBean.getCodigo());

		if (obpersonaBean.getCodigo().equals("")) {
			if (!obpersonaBean.getTipoDocumento().getIdRegistro().equals("000002")) {
				System.out.println("SIN SERVICIO DE RENIEC");

				this.setAuditoria(obpersonaBean, request, true);
				this.personaService.insertar(obpersonaBean);
				System.out.println("SIN SERVICIO DE RENIEC getNroDocumento" + obpersonaBean.getNroDocumento());
				setPersonaBean(obpersonaBean);
			} else {
				setPersonaBean(obpersonaBean);
				if (this.getPersonaBean().getSwReniec()) {

					System.out.println("this.getPostulanteBean().getPersona(). "
							+ this.getPersonaBean().getTipoDocumento().getIdRegistro());
					System.out.println("this.getPostulanteBean().getPersona() ::" + this.getPersonaBean());
					this.getPersonaBean().setTelefonoNumero(obpersonaBean.getTelefonoNumero());
					this.getPersonaBean().setCorreo(obpersonaBean.getCorreo());
					this.getPersonaBean().getNivelInstrucion()
							.setIdRegistro(obpersonaBean.getNivelInstrucion().getIdRegistro());
					this.getPersonaBean().getOcupacion().setIdRegistro(obpersonaBean.getOcupacion().getIdRegistro());

					this.setAuditoria(this.getPersonaBean(), request, true);
					this.personaService.insertar(this.getPersonaBean());
					System.out.println("persona reniec");
				} else {
					System.out.println("SIN SERVICIO DE RENIEC");
					this.setAuditoria(obpersonaBean, request, true);
					this.personaService.insertar(obpersonaBean);
					System.out.println("SIN SERVICIO DE RENIEC getNroDocumento" + obpersonaBean.getNroDocumento());
					setPersonaBean(obpersonaBean);
				}
			}
			System.out.println("persona no existe es nuevo");

		} else {
			System.out.println("existe persona");

			this.setAuditoria(this.getPersonaBean(), request, true);
			this.personaService.actualizar(obpersonaBean);

		}

		return this.getPersonaBean();
	}

	@RequestMapping(value = "/refrescarListaArticulos", method = RequestMethod.GET)
	public @ResponseBody VentaItemBean refrescarListaOrden(@RequestParam("index") int index) throws Exception {
		System.out.println("index " + index);
		VentaItemBean objVentaItemBean = new VentaItemBean();
		objVentaItemBean.setStock(lstStocks.get(index));
		objVentaItemBean.setPrecio(lstStocks.get(index).getPrecioVenta());
		objVentaItemBean.setCantidad(1);
		objVentaItemBean.ejecutarImporte();
		DecimalFormat df = new DecimalFormat("0.00");
		objVentaItemBean.setsImporte((df.format(objVentaItemBean.getSubtotal()).replace(",", ".")));
		// lstOrdenDetalleBean.add(objOrdenDetalleBean);
		return objVentaItemBean;
	}

	@RequestMapping(value = "/consultarPersonaPorDocumento", method = RequestMethod.GET)
	public @ResponseBody PersonaBean consultarPorNroDocumento(@RequestParam("tipoDocumento") String tipoDocumento,
			@RequestParam("numero") String numero) throws Exception {
		this.setPersonaBean(new PersonaBean());
		personaBean = new PersonaBean();
		PersonaBean prmPersona = new PersonaBean();
		prmPersona.setNroDocumento(numero);
		prmPersona.getTipoDocumento().setIdRegistro(tipoDocumento);
		try {
			personaBean = personaService.buscarxTipoDocumentoNumeroDocumento(prmPersona);
			if (personaBean != null) {
				System.out.println("perosana consultada" + personaBean.getNombreCompleto());
				System.out.println("personaBean.getCodigo() " + personaBean.getCodigo());
				this.setPersonaBean(personaBean);

			} else {
			}
		} catch (Exception e) {
		}

		return this.getPersonaBean();
	}

	@RequestMapping(value = "/cambiarTipoComprobante", method = RequestMethod.GET)
	@ResponseBody
	public List<SerieBean> cambiarTipoComprobante(@RequestParam("idTipoComprobante") String idTipoComprobante,
			HttpServletRequest request) {
		SerieBean serie = new SerieBean();
		serie.getTipoComprobante().setIdRegistro(idTipoComprobante);
		try {
			lstSerie = serieService.getBuscarPorFiltros(serie);
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}

		return lstSerie;
	}

	@RequestMapping(value = "/cambiarFinanciamiento", method = RequestMethod.GET)
	@ResponseBody
	public void cambiarFinanciamiento(@RequestParam("financiador") String financiador, HttpServletRequest request) {

		this.getTipoFinanciador().setIdRegistro(financiador);
	}

	@RequestMapping(value = "/cargarPersona", method = RequestMethod.GET)
	@ResponseBody
	public void cargarPersona(@RequestParam("codigo") String codigo) {
		System.out.println("cargarPersona codigo:: " + codigo);
		this.setPersonaBean(new PersonaBean());

		this.getPersonaBean().setCodigo(codigo);
		listarPacienteCtaCtePendientes2();
	}

	@RequestMapping(value = "/llenarVenta", method = RequestMethod.GET)
	@ResponseBody
	public void llenarVenta(@ModelAttribute("ventaBean") VentaBean ventaBean, HttpServletRequest request) {
		System.out.println("ventaBean.getSfechaEmision:: " + ventaBean.getSfechaEmision());
		this.setVentaBean(ventaBean);
	}

	@RequestMapping(value = "/grabarVenta", method = RequestMethod.POST)
	@ResponseBody
	public VentaBean grabarVenta(@RequestBody VentaItemBean[] ventaDetalleArray, HttpServletRequest request) {

		UsuarioBean usuario = (UsuarioBean) request.getSession().getAttribute("usuarioSesion");
		System.out.println("usuario.getAlmacen()" + usuario.getAlmacen().getCodigo());

		System.out.println("personaCodigo:: " + this.getPersonaBean().getCodigo());
		String resultado = "";
		boolean sw = false;
		String cadenaCodigoStock = "@";
		String cadenaCantidad = "@";
		this.getVentaBean().setPersona(this.getPersonaBean());
		this.getVentaBean().setAlmacen(usuario.getAlmacen());
		System.out.println("usuario.getTurno() " + usuario.getTurno().getCodigo());
		this.getVentaBean().setTurno(usuario.getTurno());
		this.getVentaBean().getTipoMoneda().setIdRegistro("000001");
		for (VentaItemBean prmVentaItemBeanBean : ventaDetalleArray) {
			System.out.println("getCodReg == >" + prmVentaItemBeanBean.getStock().getCodigo());

			cadenaCantidad = cadenaCantidad + prmVentaItemBeanBean.getCantidad() + "@";
			cadenaCodigoStock = cadenaCodigoStock + prmVentaItemBeanBean.getStock().getCodigo() + "@";
		}
		this.getVentaBean().setCadenaCantidad(cadenaCantidad);
		this.getVentaBean().setCadenaCodigoStock(cadenaCodigoStock);
		this.getVentaBean().setCuentaCorrienteBean(this.getCuentaCorrienteBean());
		this.getVentaBean().setCantidadItems(ventaDetalleArray.length);

		try {

			if (this.getVentaBean().getCodigo().equals("")) {
				this.setAuditoria(this.getVentaBean(), request, true);

				sw = (this.ventaService.insertar(this.getVentaBean()));

				if (sw) {
					resultado = this.getVentaBean().getCodigo();
				}

			} else {
				// UPDATE
				this.setAuditoria(ventaBean, request, false);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("sw " + sw);
		System.out.println("this.getVentaBean() " + this.getVentaBean().getValida());
		System.out.println("this.getVentaBean() error " + this.getVentaBean().getError());
		System.out.println("this.getVentaBean() falta " + this.getVentaBean().getNombreArticuloSinStock());
		return this.getVentaBean();

	}

	@RequestMapping(value = "/anular", method = RequestMethod.GET)
	public ModelAndView anularVenta(@ModelAttribute("ventaBean") VentaBean ventaBean, HttpServletRequest request) {
		// cargarComboLeccion();

		java.util.Date fecha = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		String anio = dateFormat.format(fecha);
		System.out.println("anio " + anio);
		// VentaBean ventaBean = new VentaBean();
		ventaBean.setNumeroPeriodo(anio);
		StockBean Stock = new StockBean();
		Stock.setTipoLlamada("1");
		UsuarioBean usuario = (UsuarioBean) request.getSession().getAttribute("usuarioSesion");
		System.out.println("usuario.getAlmacen()" + usuario.getAlmacen().getCodigo());
		Stock.setAlmacen(usuario.getAlmacen());
		ModelAndView mav = new ModelAndView("ventas/anular-venta", "command", ventaBean);
		try {
			lstPeriodo = catalogo2Service.listarPorCodigoTabla("000011", 0);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		mav.addObject("lstPeriodo", lstPeriodo);
		mav.addObject("ventaBean", ventaBean);
		return mav;
	} 
	
	@RequestMapping(value = "/buscarPorTipoEpisodio", method = RequestMethod.GET)
	public @ResponseBody PacienteBean buscarPorTipoEpisodio(@RequestParam("tipoEpisodio") String tipoDocumento,
			@RequestParam("numero") String numero) throws Exception {

		PacienteBean paciente = new PacienteBean();

		return paciente;
	}

	@RequestMapping(value = "/cargarProductoEpisodio", method = RequestMethod.GET)
	public @ResponseBody PacienteBean cargarProductoEpisodio(@RequestParam("idEpisodio") String idEpisodio)
			throws Exception {

		PacienteBean paciente = new PacienteBean();

		return paciente;
	}

	@RequestMapping(value = "rptTicketVenta", method = RequestMethod.GET)
	@ResponseBody
	public void rptTicketVenta(@RequestParam("index") Integer index, HttpServletResponse response,
			HttpServletRequest request) throws JRException, IOException {
		InputStream jasperStream = this.getClass().getResourceAsStream("/reportes/ticketVenta.jasper");

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		this.setVentaBean(lstVentas.get(index));
		List<VentaItemBean> lstVentaItem = null;
		VentaItemBean ventaItemBean = new VentaItemBean();
		ventaItemBean.setVenta(this.getVentaBean());
		System.out.println("this.getVentaBean().getImporte() " + this.getVentaBean().getImporte());
		try {
			lstVentaItem = ventaItemService.getBuscarPorFiltros(ventaItemBean);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Map<String, Object> parametro = new HashMap<String, Object>();
		parametro.put("usuario", getUsuarioSesion(request).getNombreUsuario());
		parametro.put("nroComprobante", this.getVentaBean().getNumero());
		parametro.put("fechaEmision", dateFormat.format(this.getVentaBean().getFechaEmision()));
		parametro.put("horaEmision", this.getVentaBean().getHora());
		parametro.put("paciente", this.getVentaBean().getPersona().getNombreCompleto());
		parametro.put("docPaciente", this.getVentaBean().getPersona().getNroDocumento());
		parametro.put("almacen", this.getVentaBean().getAlmacen().getNombreAlmacen());
		parametro.put("vendedor", this.getVentaBean().getUsuarioRegistro());
		parametro.put("montoTotal", this.getVentaBean().getsImporte());
		parametro.put("montoLetra", this.getVentaBean().getMontoLetras());

		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lstVentaItem);
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametro, dataSource);

		response.setContentType("application/x-pdf");
		response.setHeader("Content-disposition", "inline; filename=" + this.getVentaBean().getNumero() + ".pdf");

		final OutputStream outStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);

	}

	public ByteArrayOutputStream generatePDFDocumentBytes(int numeroActaIngresoIni, int numeroActaIngresoFin,
			String tipoReporte, PdfWriter writer, Document document, Map mapalistadoParametro,
			ByteArrayOutputStream baosPDF, String rutaCompleta) throws Exception {

		RowSet rs = null;
		document.open();

		String parrafo1, parrafo2, parrafo3, parrafo4, parrafo5, departamental;
		String salto = "<br>", vacio = "---------------";

		String descripcionRazonSocial, identificadorTipoDocumento, identificadorEmpleador;
		String nombreDocumento, descripcionDocumentoIngreso, descripcionActaEntrega, numeroDocumentoIngreso,
				descripcionFecha;
		String identificadorSede, descripcionSede, nombreRemitenteDocumentoIngreso, documentoIdentidad,
				tipoEmpleadorCustodio, tipoCustodio;
		String descripcionTipoRemitente, representanteLegal, descripcionFechaConforme, cargoResponsable,
				cargoResponsableDetalle;
		String nombreResponsable, descripcionDocumentoResponsable, documentoResponsable, descripcionRegularizacion;
		String nombreComercial, tipoDocumento, estadoContribuyente;
		descripcionRazonSocial = identificadorTipoDocumento = identificadorEmpleador = vacio;
		nombreDocumento = descripcionDocumentoIngreso = descripcionActaEntrega = numeroDocumentoIngreso = descripcionFecha = vacio;
		identificadorSede = descripcionSede = nombreRemitenteDocumentoIngreso = documentoIdentidad = tipoEmpleadorCustodio = tipoCustodio = vacio;
		descripcionTipoRemitente = representanteLegal = descripcionFechaConforme = cargoResponsable = cargoResponsableDetalle = vacio;
		nombreResponsable = descripcionDocumentoResponsable = documentoResponsable = descripcionRegularizacion = nombreComercial = tipoDocumento = estadoContribuyente = vacio;

		HTMLWorker htmlWorker = new HTMLWorker((DocListener) document);

		String n1 = String.valueOf(numeroActaIngresoIni);
		String n2 = String.valueOf(numeroActaIngresoFin);

		while (rs.next()) {

			if (String.valueOf(rs.getObject("TIPO_CUSTODIO")) != "") {
				tipoCustodio = String.valueOf(rs.getObject("TIPO_CUSTODIO"));
			} else {
				tipoCustodio = vacio;
			}
			;
			if (String.valueOf(rs.getObject("DES_TI_REMI")) != "") {
				descripcionTipoRemitente = String.valueOf(rs.getObject("DES_TI_REMI"));
			} else {
				descripcionTipoRemitente = vacio;
			}
			;
			if (String.valueOf(rs.getObject("REPR_LEGAL")) != "") {
				representanteLegal = String.valueOf(rs.getObject("REPR_LEGAL"));
			} else {
				representanteLegal = vacio;
			}
			;
			if (String.valueOf(rs.getObject("DE_FECHA_CONFORMIDAD")) != "") {
				descripcionFechaConforme = String.valueOf(rs.getObject("DE_FECHA_CONFORMIDAD"));
			} else {
				descripcionFechaConforme = vacio;
			}
			;
			if (String.valueOf(rs.getObject("DE_FECHA")) != "") {
				if (String.valueOf(rs.getObject("FLAG_FECHA")).equals("ACTIVO")
						&& (tipoEmpleadorCustodio == "R" || tipoEmpleadorCustodio.equals("R"))) {
					descripcionFecha = String.valueOf(rs.getObject("DE_FECHA_CONF_REGU"));
				} else {
					descripcionFecha = String.valueOf(rs.getObject("DE_FECHA"));
				}
				;
			} else {
				descripcionFecha = vacio;
			}

		}
		document.close();
		writer.close();

		if (baosPDF.size() < 1) {
			throw new DocumentException("El documento tiene " + baosPDF.size() + " bytes");
		}

		return baosPDF;
	}

	@RequestMapping(value = "/cargarImpresionTicket", method = RequestMethod.GET)

	public ModelAndView cargarImpresionTicket() throws Exception {
		VentaBean objVentaBean = new VentaBean();
		ModelAndView mav = new ModelAndView("ventas/ticketVenta", "command", objVentaBean);

		return mav;
	}

	@RequestMapping(value = "/descargarPDF", method = RequestMethod.GET, produces = "application/pdf")
	public @ResponseBody void descargarPDF(HttpServletResponse response) throws IOException {

		File file = new File("reporte.pdf");

		// InputStream in = new FileInputStream(file);

		try {
			HttpHeaders responseHeaders = new HttpHeaders();
			Document documento = new Document(PageSize.A4.rotate(), 36, 36, 10, 20);

			PdfWriter pdfw = PdfWriter.getInstance(documento, new FileOutputStream("reporte.pdf"));
			MyFooter event = new MyFooter();
			pdfw.setPageEvent(event);

			documento.open();
			// Fuentes
			Font fuente = new Font(Font.getFamily("ARIAL"), 12, Font.BOLD);
			Font fuenteDatos = new Font(Font.getFamily("ARIAL"), 7, Font.NORMAL);
			Font fuenteSubrayada = new Font(Font.getFamily("ARIAL"), 8, Font.BOLD);
			fuenteSubrayada.setStyle(Font.UNDERLINE);
			Font fuenteListado = new Font(Font.getFamily("ARIAL"), 8);
			Font fuenteItalic = new Font(Font.FontFamily.COURIER, 8, Font.ITALIC);

			// Cabecera // windows

			// Image Imagen = Image.getInstance("D://Reportes/Imagenes/logo_cabecera.png");
//				Image Imagen =  Image.getInstance(ResourceUtil.getKey("ruta.natigu.archivos.academico.seguimiento")+this.getDiagonalFile()+"logo_cabecera.png");

			// linux
			// Image Imagen =
			// Image.getInstance("//opt//natigu//archivos//Reportes//Imagenes//logo_cabecera.png");
			Image Imagen = Image.getInstance(getClass().getResource("img/logo_cabecera.png"));// Image.getInstance("logo_cabecera.png");
			//
			Imagen.scaleAbsolute(820, 70);
			Imagen.setAlignment(Element.ALIGN_CENTER);
			documento.add(Imagen);

			Paragraph titulo = new Paragraph("SEGUIMIENTO DE ESTUDIANTES", fuente);
			titulo.setAlignment(Element.ALIGN_CENTER);
			documento.add(titulo);

			Paragraph saltolinea = new Paragraph();
			saltolinea.add("\n");
			documento.add(saltolinea);
			//
			PdfPTable tabla = new PdfPTable(24);
			tabla.setWidthPercentage(100);

			// tabla cabecera
			PdfPCell celda1 = new PdfPCell(
					new Paragraph("N°", FontFactory.getFont("Arial", 8, Font.BOLD, BaseColor.WHITE)));
			PdfPCell celda2 = new PdfPCell(
					new Paragraph("INSTITUCIÓN", FontFactory.getFont("Arial", 8, Font.BOLD, BaseColor.WHITE)));
			PdfPCell celda3 = new PdfPCell(
					new Paragraph("DOCENTE", FontFactory.getFont("Arial", 8, Font.BOLD, BaseColor.WHITE)));
			PdfPCell celda4 = new PdfPCell(
					new Paragraph("ESTUDIANTE", FontFactory.getFont("Arial", 8, Font.BOLD, BaseColor.WHITE)));
			PdfPCell celda12 = new PdfPCell(
					new Paragraph("USUARIO", FontFactory.getFont("Arial", 8, Font.BOLD, BaseColor.WHITE)));
			PdfPCell celda5 = new PdfPCell(new Paragraph("LENGUA - NIVEL - AÑO - SEMESTRE",
					FontFactory.getFont("Arial", 8, Font.BOLD, BaseColor.WHITE)));
//	            PdfPCell celda5 =  new PdfPCell(new Paragraph("LENGUA",FontFactory.getFont("Arial",9,Font.BOLD,BaseColor.WHITE)));
//	            PdfPCell celda6 =  new PdfPCell(new Paragraph("NIVEL",FontFactory.getFont("Arial",9,Font.BOLD,BaseColor.WHITE)));
//	            PdfPCell celda7 =  new PdfPCell(new Paragraph("SEMESTRE",FontFactory.getFont("Arial",8,Font.BOLD,BaseColor.WHITE)));
//	            PdfPCell celda8 =  new PdfPCell(new Paragraph("AÃ¯Â¿Â½O",FontFactory.getFont("Arial",9,Font.BOLD,BaseColor.WHITE)));
//	            PdfPCell celda9 =  new PdfPCell(new Paragraph("FECHA INICIO",FontFactory.getFont("Arial",8,Font.BOLD,BaseColor.WHITE)));
//	            PdfPCell celda10 =  new PdfPCell(new Paragraph("FECHA TERMINO",FontFactory.getFont("Arial",8,Font.BOLD,BaseColor.WHITE)));
			PdfPCell celda11 = new PdfPCell(
					new Paragraph("SITUACIÓN", FontFactory.getFont("Arial", 8, Font.BOLD, BaseColor.WHITE)));

			// Color Plomo de fondo
			celda1.setBackgroundColor(BaseColor.LIGHT_GRAY);
			celda2.setBackgroundColor(BaseColor.LIGHT_GRAY);
			celda3.setBackgroundColor(BaseColor.LIGHT_GRAY);
			celda4.setBackgroundColor(BaseColor.LIGHT_GRAY);
			celda5.setBackgroundColor(BaseColor.LIGHT_GRAY);
//	            celda6.setBackgroundColor(BaseColor.LIGHT_GRAY);
//	            celda7.setBackgroundColor(BaseColor.LIGHT_GRAY);
//	            celda8.setBackgroundColor(BaseColor.LIGHT_GRAY);
//	            celda9.setBackgroundColor(BaseColor.LIGHT_GRAY);
//	            celda10.setBackgroundColor(BaseColor.LIGHT_GRAY);
			celda11.setBackgroundColor(BaseColor.LIGHT_GRAY);
			celda12.setBackgroundColor(BaseColor.LIGHT_GRAY);
			// centar
			celda1.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda2.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda3.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda4.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda5.setHorizontalAlignment(Element.ALIGN_CENTER);
//	            celda6.setHorizontalAlignment(Element.ALIGN_CENTER);
//	            celda7.setHorizontalAlignment(Element.ALIGN_CENTER);
//	            celda8.setHorizontalAlignment(Element.ALIGN_CENTER);
//	            celda9.setHorizontalAlignment(Element.ALIGN_CENTER);
//	            celda10.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda11.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda12.setHorizontalAlignment(Element.ALIGN_CENTER);

			// tamaÃ¯Â¿Â½o de la celda
			celda1.setColspan(1);
			celda2.setColspan(4);
			celda3.setColspan(4);
			celda4.setColspan(4);// 13
			celda12.setColspan(4);// 13
			celda5.setColspan(5);
//	            celda6.setColspan(2);
//	            celda7.setColspan(2);
//	            celda8.setColspan(1);//19
//	            celda9.setColspan(3);
//	            celda10.setColspan(3);
			celda11.setColspan(2);

			celda1.setPaddingTop(5);
			celda2.setPaddingTop(5);
			celda3.setPaddingTop(5);
			celda4.setPaddingTop(5);
			celda12.setPaddingTop(5);
			celda5.setPaddingTop(5);
//	            celda6.setPaddingTop(5);
//	            celda7.setPaddingTop(5);
//	            celda8.setPaddingTop(5);
//	            celda9.setPaddingTop(5);
//	            celda10.setPaddingTop(5);
			celda11.setPaddingTop(5);

			celda1.setPaddingBottom(5);
			celda2.setPaddingBottom(5);
			celda3.setPaddingBottom(5);
			celda4.setPaddingBottom(5);
			celda12.setPaddingBottom(5);
			celda5.setPaddingBottom(5);
//	            celda6.setPaddingBottom(5);
//	            celda7.setPaddingBottom(5);
//	            celda8.setPaddingBottom(5);
//	            celda9.setPaddingBottom(5);
//	            celda10.setPaddingBottom(5);
			celda11.setPaddingBottom(5);

			// agregar las celda
			tabla.addCell(celda1);
			tabla.addCell(celda2);
			tabla.addCell(celda3);
			tabla.addCell(celda4);
			tabla.addCell(celda12);
			tabla.addCell(celda5);
//	            tabla.addCell(celda6);
//	            tabla.addCell(celda7);
//	            tabla.addCell(celda8);
//	            tabla.addCell(celda9);
//	            tabla.addCell(celda10);
			tabla.addCell(celda11);

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			/***
			 * for (int i = 0; i < this.lstMatriculaAlumnoBeanGeneral.size(); i++) {
			 * 
			 * // MatriculaBean matriculaBean = this.lstMatriculaBean.get(i);
			 * MatriculaAlumnoBean matriculaBean =
			 * this.lstMatriculaAlumnoBeanGeneral.get(i);
			 * 
			 * //Datos detalle PdfPCell celd1 = new PdfPCell(new
			 * Paragraph(String.valueOf((i+1)),fuenteDatos)); PdfPCell celd2 = new
			 * PdfPCell(new
			 * Paragraph(matriculaBean.getMatriculaBean().getInsti().getNombreInstitucion(),fuenteDatos));
			 * PdfPCell celd3 = new PdfPCell(new
			 * Paragraph(matriculaBean.getMatriculaBean().getDocenteBean().getPersonaBean().getNombreCompleto(),fuenteDatos));
			 * PdfPCell celd4 = new PdfPCell(new
			 * Paragraph(matriculaBean.getAlumnoBean().getPersonaBean().getNombreCompleto(),fuenteDatos));
			 * PdfPCell celd12 = new PdfPCell(new
			 * Paragraph(matriculaBean.getAlumnoBean().getUsuario(),fuenteDatos)); PdfPCell
			 * celd5 = new PdfPCell(new
			 * Paragraph(matriculaBean.getMatriculaBean().getLengua().getNombre()+" -
			 * "+matriculaBean.getMatriculaBean().getNivel().getNombreCorto()+" -
			 * "+String.valueOf(matriculaBean.getMatriculaBean().getPeriodo().getCodigoRegistro())+"
			 * -
			 * "+matriculaBean.getMatriculaBean().getCiclo().getNombreCorto(),fuenteDatos));
			 * // PdfPCell celd5 = new PdfPCell(new
			 * Paragraph(matriculaBean.getLengua().getNombre(),fuenteDatos)); // PdfPCell
			 * celd6 = new PdfPCell(new
			 * Paragraph(matriculaBean.getNivel().getNombreCorto(),fuenteDatos)); //
			 * PdfPCell celd7 = new PdfPCell(new
			 * Paragraph(matriculaBean.getCiclo().getNombreCorto(),fuenteDatos)); //
			 * PdfPCell celd8 = new PdfPCell(new
			 * Paragraph(String.valueOf(matriculaBean.getPeriodo().getCodigoRegistro()),fuenteDatos));
			 * // PdfPCell celd9 = new PdfPCell(new
			 * Paragraph(sdf.format(matriculaBean.getInscripcion().getFechaRegistro()),fuenteDatos));
			 * // PdfPCell celd10 = new PdfPCell(new
			 * Paragraph(sdf.format(matriculaBean.getInscripcion().getFechaModificacion()),fuenteDatos));
			 * PdfPCell celd11 = new PdfPCell(new
			 * Paragraph(matriculaBean.getMatriculaBean().getSituacion().getNombreLargo(),fuenteDatos));
			 * 
			 * celd1.setHorizontalAlignment(Element.ALIGN_CENTER);
			 * celd2.setHorizontalAlignment(Element.ALIGN_CENTER);
			 * celd3.setHorizontalAlignment(Element.ALIGN_CENTER);
			 * celd4.setHorizontalAlignment(Element.ALIGN_CENTER);
			 * celd12.setHorizontalAlignment(Element.ALIGN_CENTER);
			 * celd5.setHorizontalAlignment(Element.ALIGN_CENTER); //
			 * celd6.setHorizontalAlignment(Element.ALIGN_CENTER); //
			 * celd7.setHorizontalAlignment(Element.ALIGN_CENTER); //
			 * celd8.setHorizontalAlignment(Element.ALIGN_CENTER); //
			 * celd9.setHorizontalAlignment(Element.ALIGN_CENTER); //
			 * celd10.setHorizontalAlignment(Element.ALIGN_CENTER);
			 * celd11.setHorizontalAlignment(Element.ALIGN_CENTER);
			 * 
			 * 
			 * //tamaÃ¯Â¿Â½o de la celda celd1.setColspan(1); celd2.setColspan(4);
			 * celd3.setColspan(4); celd4.setColspan(4);//13 celd12.setColspan(4);//13
			 * celd5.setColspan(5); // celd6.setColspan(2); // celd7.setColspan(2); //
			 * celd8.setColspan(1);//19 // celd9.setColspan(3); // celd10.setColspan(3);
			 * celd11.setColspan(2);
			 * 
			 * 
			 * 
			 * tabla.addCell(celd1); tabla.addCell(celd2); tabla.addCell(celd3);
			 * tabla.addCell(celd4); tabla.addCell(celd12); tabla.addCell(celd5); //
			 * tabla.addCell(celd6); // tabla.addCell(celd7); // tabla.addCell(celd8); //
			 * tabla.addCell(celd9); // tabla.addCell(celd10); tabla.addCell(celd11);
			 * 
			 * }
			 * 
			 */
			documento.add(tabla);

			documento.close();

			ByteArrayOutputStream pdf = new ByteArrayOutputStream();

			if (file.exists()) {
				String nFile = "reporte.pdf";
				pdf.write(getBytesFromFile(file));
				pdf.close();
				responseHeaders.setContentType(MediaType.valueOf("application/pdf"));
				responseHeaders.setContentLength(pdf.size());
				responseHeaders.set("Content-Disposition", "inline;filename=" + nFile);

				InputStream in = new FileInputStream(file);

				response.setContentType("application/pdf");
				response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
				response.setHeader("Content-Length", String.valueOf(file.length()));
				FileCopyUtils.copy(in, response.getOutputStream());

			}

			// return new ResponseEntity<byte[]>(pdf.toByteArray(), responseHeaders,
			// HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println("ERROR: " + e);
		}

	}

	private byte[] getBytesFromFile(File file) throws IOException {
		InputStream is = new FileInputStream(file);
		// se obtiene el tamaÃ¯Â¿Â½o del archivo
		long length = file.length();
		// se vwerifica si el archivo es muy grande
		if (length > Integer.MAX_VALUE) {
			// directivas en caso el archivo sea muy pesado
		}
		// se crea la data en byte
		byte[] bytes = new byte[(int) length];
		// lectura de byte's
		int offset = 0;
		int numRead = 0;
		while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
			offset += numRead;
		}

		if (offset < bytes.length) {
			throw new IOException("Could not completely read file " + file.getName());
		}

		// se cierra el inputStream y se retorna los byte del archivo
		is.close();
		return bytes;
	}

	class MyFooter extends PdfPageEventHelper {
		Font fuente = new Font(Font.FontFamily.UNDEFINED, 7, Font.NORMAL);

		public void onEndPage(PdfWriter writer, Document document) {
			PdfContentByte cb = writer.getDirectContent();
			Phrase header = new Phrase("", fuente);
			DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
			DateFormat formatoHora = new SimpleDateFormat("HH:mm");
			Date date = new Date();
			String fecha = formatoFecha.format(date);
			String hora = formatoHora.format(date);

			Phrase footer = new Phrase("FECHA Y HORA DE IMPRESIÃ¯Â¿Â½N:  " + fecha + " " + hora
					+ "                                                     "
					+ "                                                     "
					+ "                                                     "
					+ "                                                     "
					+ "                                                     " + "                              "
					+ "PÃ¯Â¿Â½gina " + String.valueOf(document.getPageNumber()), fuente);
			ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, header,
					(document.right() - document.left()) / 2 + document.leftMargin(), document.top() + 10, 0);
			ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, footer,
					(document.right() - document.left()) / 2 + document.leftMargin(), document.bottom() - 4, 0);
		}
	}
 
	@RequestMapping(value = "/buscarVentaPorNumeroDocumento", method = RequestMethod.GET)
	@ResponseBody
	public VentaBean buscarVentaPorNumeroDocumento(@RequestParam("nroSerie") String nroSerie,
			@RequestParam("idVenta") String idVenta, @RequestParam("numeroPeriodo") String numeroPeriodo,
			HttpServletRequest request) {

		VentaBean venta = new VentaBean();
		venta.setCodigo(idVenta);
		venta.setNumeroPeriodo(numeroPeriodo);
		venta.getSerie().setNroSerie(nroSerie);

		try {
			ventaBean = ventaService.buscarPorNroDocumento(venta);
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}

		return ventaBean;
	}

	@RequestMapping(value = "/anularVenta", method = RequestMethod.GET)
	@ResponseBody
	public String anularVenta(@RequestParam("idVenta") String idVenta,
			@RequestParam("numeroPeriodo") String numeroPeriodo, @RequestParam("numeroDocu") String numeroDocu,
			@RequestParam("motivo") String motivo,

			HttpServletRequest request) {
		String anulado = "";
		Boolean sw = false;
		VentaBean venta = new VentaBean();
		venta.setCodigo(idVenta);
		venta.setNumeroPeriodo(numeroPeriodo);
		venta.setNumero(numeroDocu);
		venta.setMotivoElimina(motivo);
		try {
			this.setAuditoria(venta, request, true);
			sw = ventaService.anularVenta(venta);
			if (sw == true) {
				anulado = "1";
			}
		} catch (ServiceException e) {
			System.out.println("printStackTrace");
			e.printStackTrace();
		}

		return anulado;
	}

	@RequestMapping(value = "/descargarExcel", method = RequestMethod.GET, produces = "application/vnd.ms-excel")
	public @ResponseBody void descargarExcel(HttpServletResponse response) throws IOException {
		if (lstVentas  != null ) {
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
			HSSFWorkbook workbook = new HSSFWorkbook();
			// Hoja
			HSSFSheet sheet = workbook.createSheet("LISTADO DE VENTAS");
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
			sheet.setColumnWidth(2, 10000);
			sheet.setColumnWidth(3, 10000);
			sheet.setColumnWidth(4, 10000);
			sheet.setColumnWidth(5, 8000);

			sheet.setColumnWidth(6, 8000);

			sheet.setColumnWidth(7, 5000);
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
			sheet.addMergedRegion(new CellRangeAddress(2, 2, 1, 7));
			headerCell = headerRow.createCell(1);
			headerCell.setCellValue("LISTADO DE VENTAS");
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
			headerCell.setCellValue("PACIENTE");
			headerCell = bodyRow.createCell(3);
			headerCell.setCellStyle(headerStyle);
			headerCell.setCellValue("Nº DOCUMENTO");
			headerCell = bodyRow.createCell(4);
			headerCell.setCellStyle(headerStyle);
			headerCell.setCellValue("FECHA EMISIÓN");
			headerCell = bodyRow.createCell(5);
			headerCell.setCellStyle(headerStyle);
			headerCell.setCellValue("ALMACEN");
			headerCell = bodyRow.createCell(6);
			headerCell.setCellStyle(headerStyle);
			headerCell.setCellValue("NRO BOLETA");

			headerCell = bodyRow.createCell(7);
			headerCell.setCellStyle(headerStyle);
			headerCell.setCellValue("IMPORTE");
			/******************* Contenido *************************/
			HSSFRow contentRow = null;
			HSSFCell contentCell = null;

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			for (int i = 0; i < this.lstVentas.size(); i++) {

//	            	personaBean personaBean = this.lstpersonaBean.get(i);
				VentaBean personaBean = this.lstVentas.get(i);
				contentRow = sheet.createRow(rowIndex++);
				contentCell = contentRow.createCell(1);
				contentCell.setCellStyle(bodyStyle);
				contentCell.setCellValue(String.valueOf((i + 1)));
				contentCell = contentRow.createCell(2);
				contentCell.setCellStyle(bodyStyle);
				contentCell.setCellValue(personaBean.getPersona().getNombreCompleto());
				contentCell = contentRow.createCell(3);
				contentCell.setCellStyle(bodyStyle);
				contentCell.setCellValue(personaBean.getPersona().getNroDocumento());
				contentCell = contentRow.createCell(4);
				contentCell.setCellStyle(bodyStyle);
				contentCell.setCellValue(dateFormat.format(personaBean.getFechaEmision()));
				contentCell = contentRow.createCell(5);
				contentCell.setCellStyle(bodyStyle);
				contentCell.setCellValue(personaBean.getAlmacen().getNombreAlmacen());
				contentCell = contentRow.createCell(6);
				contentCell.setCellStyle(bodyStyle);
				contentCell.setCellValue(personaBean.getNumero());

				contentCell = contentRow.createCell(7);
				contentCell.setCellStyle(bodyStyle);
				contentCell.setCellValue(personaBean.getsImporte());
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

	private void listarPacienteCtaCtePendientes2() {
		CuentaCorrienteBean cuentaCorrienteBean = new CuentaCorrienteBean();
		PacienteBean persona = new PacienteBean();
		persona.setCodigo(this.getPersonaBean().getCodigo());
		cuentaCorrienteBean.getEpisodio().setPaciente(persona);
		// cuentaCorrienteBean.setp
		try {
			lstCuentaCorrienteBean = cuentaCorrienteService.listarCtaCtePacientePendientes(cuentaCorrienteBean);
			if (lstCuentaCorrienteBean != null) {
				if (lstCuentaCorrienteBean.size() == 1) {
					System.out.println("lstCuentaCorrienteBean" + lstCuentaCorrienteBean.size());
					for (CuentaCorrienteBean oCuentaCorrienteBean : lstCuentaCorrienteBean) {
						setCuentaCorrienteBean(oCuentaCorrienteBean);
						System.out.println("setCuentaCorrienteBean" + oCuentaCorrienteBean.getCodigo());
					}
				}
			}

		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // te lista los pacientes de ctaCte
	}

	/******** Devolucion **********/
	@RequestMapping(value = "/devolucion", method = RequestMethod.GET)
	public ModelAndView devolucion(HttpServletRequest request) {
		// cargarComboLeccion();
		PersonaBean persona = new PersonaBean();
		VentaBean ventaBean = new VentaBean();
		ventaBean.getSituacion().setIdRegistro("000001");
		StockBean Stock = new StockBean();
		Stock.setTipoLlamada("1");
		UsuarioBean usuario = (UsuarioBean) request.getSession().getAttribute("usuarioSesion");

		Stock.setAlmacen(usuario.getAlmacen());
		ModelAndView mav = new ModelAndView("ventas/devolucion-venta", "command", ventaBean);

		try {
			lstPersonasVentas = ventaService.listarPacientes(ventaBean);
		} catch (Exception e) {
		}

		mav.addObject("lstPersonas", lstPersonasVentas);
		this.cargarCombosDevolucion(mav);

		return mav;
	}
	
	@RequestMapping(value = "/listarDevolucion", method = RequestMethod.GET)
//	@ResponseBody
	public ModelAndView listarDevolucion(@RequestParam("idEpisodio") String idEpisodio,
										 @RequestParam("index") int index) 
	throws Exception {
		System.out.println("/listarDevolucion " + idEpisodio);
		this.setventaDevolucion(lstPersonasVentas.get(index-1));
		EpisodioBean episodio = new EpisodioBean();
		episodio.setCodigo(idEpisodio);

		ModelAndView mav = new ModelAndView("ventas/ajax/listado-devolucion");
		lstVentasItemDevolucion = new ArrayList<VentaItemBean>();
		try {
			lstVentasItemDevolucion = ventaItemService.listarArtPorEpisodio(episodio);
			System.out.println("lstVentasItemDevolucion " + lstVentasItemDevolucion);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		mav.addObject("lstVentasItemDevolucion", lstVentasItemDevolucion);
		return mav;
	}
	
	@RequestMapping(value = "/llenarDevolucionCabecera", method = RequestMethod.GET)
	@ResponseBody
	public void llenarDevolucionCabecera(@ModelAttribute("ventaBean") VentaBean ventaDevolucion,
			HttpServletRequest request) {
		
		//this.setventaDevolucion(ventaDevolucion);
	}

	@RequestMapping(value = "/asignarDevolucion", method = RequestMethod.POST)
	public @ResponseBody List<VentaItemBean> asignarCompra(@RequestBody VentaItemBean[] compraItemArray,
			HttpServletRequest request) {
		System.out.println("asignarDevolucion ");
		List<VentaItemBean> lstCompraBean = new ArrayList<VentaItemBean>();

		try {

			if (!VO.isNull(compraItemArray)) {

				System.out.println("guardarCambios "); 
				  if(guardarCambios(compraItemArray,request)){ }
				 

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lstCompraBean;
	}

	private boolean guardarCambios(VentaItemBean[] listaVentaItem, HttpServletRequest request){
		boolean sw = false;
		boolean swGuardado = true;
		System.out.println("cboPacienteVenta " + this.getventaDevolucion().getPersona().getCodigo());
		String cadenaCantidad = "@"; 
		String cadenaCodigoVenta = "@";
		String cadenaIdStock = "@"; 
		String cadenaLote = "@"; 
		String cadenaPrecioVenta = "@";
		int cantidad = 0;
		
			for (int i = 0; i < listaVentaItem.length; i++) {
				VentaItemBean prmCompraItem = listaVentaItem[i];
				if (prmCompraItem.getCantidad() > 0) {
					cantidad++;
					sw = true;
					cadenaCodigoVenta = cadenaCodigoVenta + prmCompraItem.getVenta().getCodigo()+ "@"; 
					cadenaCantidad = cadenaCantidad + prmCompraItem.getCantidad() + "@";
					cadenaIdStock = cadenaIdStock + prmCompraItem.getStock().getCodigo() + "@"; 
					cadenaLote = cadenaLote + prmCompraItem.getStock().getLote() + "@"; 
					cadenaPrecioVenta = cadenaPrecioVenta + prmCompraItem.getPrecio()+ "@";  
				}  
			}
			this.getventaDevolucion().setCadenaIdVenta(cadenaCodigoVenta);
			this.getventaDevolucion().setCantidadItems(cantidad);
			this.getventaDevolucion().setCadenaCantidad(cadenaCantidad);
			this.getventaDevolucion().setCadenaCodigoStock(cadenaIdStock); 
			this.getventaDevolucion().setCadenaPrecioVenta(cadenaPrecioVenta); 
			System.out.println("getCadenaIdVenta" + this.getventaDevolucion().getCadenaIdVenta());
			System.out.println("cadenaIdStock" + this.getventaDevolucion().getCadenaCodigoStock());
			try {
				if (sw) {
					System.out.println("graba devolucion");
					this.setAuditoria(this.getventaDevolucion(), request, true);
					this.ventaService.devolucionVenta(this.getventaDevolucion());
				} 
			} catch (Exception e) {
				e.printStackTrace();
			}

		return swGuardado;
	}
	
	/*** RECAUDACION***/
	
	@RequestMapping(value = "/recaudacion", method = RequestMethod.GET)
	public ModelAndView doRecaudacion(@ModelAttribute("ventaBean") VentaBean VentaBean, HttpServletRequest request) {
		this.setVentaBean(VentaBean);
		return this.recaudacion(VentaBean, request);
	}

	@RequestMapping(value = "/recaudacion", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView recaudacion(@ModelAttribute("ventaBean") VentaBean VentaBean, HttpServletRequest request) {

		this.setVentaBean(VentaBean);
		ModelAndView mav = new ModelAndView("ventas/reportes/recaudacion", "command", VentaBean);

		try {
			lstVentas = ventaService.reporteRecaudacion(VentaBean);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mav.addObject("ventaBean", VentaBean);
		mav.addObject("lstVentas", lstVentas);
		this.cargarCombosListado(mav);
		return mav;
	}
	
	@RequestMapping(value = "reporteRecaudacion", method = RequestMethod.GET)
	@ResponseBody
	public void reporteRecaudacion(HttpServletResponse response,
			HttpServletRequest request) throws JRException, IOException {
		InputStream jasperStream = this.getClass().getResourceAsStream("/reportes/rptRecaudacion.jasper");

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	 
		System.out.println("this.getVentaBean().getFechaEmisionDesde() " + this.getVentaBean().getFechaEmisionDesde());
		Map<String, Object> parametro = new HashMap<String, Object>();
		parametro.put("nombUsuario", getUsuarioSesion(request).getNombreUsuario()); 
		parametro.put("fechaDesde",  this.getVentaBean().getFechaEmisionDesde());
		parametro.put("fechaHasta",  this.getVentaBean().getFechaEmisionHasta());

		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(this.lstVentas);
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametro, dataSource);

		response.setContentType("application/x-pdf");
		response.setHeader("Content-disposition", "inline; filename= RecaudacionFarmacia"+this.getVentaBean().getFechaEmisionDesde().replaceAll("/", "")+".pdf");

		final OutputStream outStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);

	}

	/*********** CTA CORRIENTE ***************/
	@RequestMapping(value = "/consultarCtaCorriente", method = RequestMethod.GET)
	public @ResponseBody CuentaCorrienteBean consultarCtaCorriente(@RequestParam("numero") String numero) throws Exception {
		this.setCuentaCorrienteBean(new CuentaCorrienteBean());
		cuentaCorrienteBean = new CuentaCorrienteBean();
		CuentaCorrienteBean prmCuentaCorrienteBean = new CuentaCorrienteBean();
		prmCuentaCorrienteBean.getEpisodio().setNumeroEpisodio(numero);
		try {
			cuentaCorrienteBean = cuentaCorrienteService.buscarPorNroEpisodioV2(prmCuentaCorrienteBean);
			if (cuentaCorrienteBean != null) {
				this.setPersonaBean(cuentaCorrienteBean.getEpisodio().getPaciente());
				System.out.println("cuentaCorrienteBean consultada" + cuentaCorrienteBean.getEpisodio().getPaciente().getNombreCompleto());
				System.out.println("cuentaCorrienteBean.getCodigo() " + cuentaCorrienteBean.getCodigo());
				System.out.println("cuentaCorrienteBean fecha liqui " + cuentaCorrienteBean.getFechaLiquidacion());
				this.setCuentaCorrienteBean(cuentaCorrienteBean);

			} else {
			}
		} catch (Exception e) {
		}

		return this.getCuentaCorrienteBean();
	}
	
	@RequestMapping(value = "/validarGenerar", method = RequestMethod.GET)
	public @ResponseBody String validarGenerar() throws IOException {
		String validar="";
		if (lstVentas  != null ) {
			validar = "1";		}
		return validar;
	}

	/********************************************/
	public VentaBean getVentaBean() {
		return ventaBean;
	}

	public void setVentaBean(VentaBean VentaBean) {
		this.ventaBean = VentaBean;
	}

	public PersonaBean getPersonaBean() {
		return personaBean;
	}

	public void setPersonaBean(PersonaBean personaBean) {
		this.personaBean = personaBean;
	}

	public CatalogoBean getTipoFinanciador() {
		return tipoFinanciador;
	}

	public void setTipoFinanciador(CatalogoBean tipoFinanciador) {
		this.tipoFinanciador = tipoFinanciador;
	}

	public List<AlmacenBean> getLstAlmacen() {
		return lstAlmacen;
	}

	public void setLstAlmacen(List<AlmacenBean> lstAlmacen) {
		this.lstAlmacen = lstAlmacen;
	}

	public CuentaCorrienteBean getCuentaCorrienteBean() {
		return cuentaCorrienteBean;
	}

	public void setCuentaCorrienteBean(CuentaCorrienteBean cuentaCorrienteBean) {
		this.cuentaCorrienteBean = cuentaCorrienteBean;
	}

	public VentaBean getventaDevolucion() {
		return ventaDevolucion;
	}

	public void setventaDevolucion(VentaBean ventaDevolucion) {
		this.ventaDevolucion = ventaDevolucion;
	}

}