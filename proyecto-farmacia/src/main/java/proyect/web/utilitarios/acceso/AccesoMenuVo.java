package proyect.web.utilitarios.acceso;

public class AccesoMenuVo {

	/** GENERAL **/
	private boolean   menu_Estadisticos;
	private boolean   menu_Venta;
	private boolean   menu_Inventario;
	private boolean   menu_Movimiento;
	private boolean   menu_Mantenimiento; 
	private boolean   menu_RptVenta; 
	private boolean   menu_RptICI; 
	private boolean   menu_RptArticulo; 
	private boolean   menu_Seguridad;
	private boolean   menu_Configuracion; 
	
	// VENTA  
	private PermisoVo subMenu_venta_generar;
	private PermisoVo subMenu_venta_listar;
	private PermisoVo subMenu_venta_paciente;
	private PermisoVo subMenu_venta_anular;
	private PermisoVo subMenu_venta_devolucion;
	
	// INVENTARIO  
	private PermisoVo subMenu_inventario_articulo;
	private PermisoVo subMenu_inventario_almacen;
	private PermisoVo subMenu_inventario_consultar;
	private PermisoVo subMenu_inventario_generar; 
	
	// MOVIMIENTO  
	private PermisoVo subMenu_movimiento_compra;
	private PermisoVo subMenu_movimiento_ingresoSalida;
	private PermisoVo subMenu_movimiento_kardex; 
	
	// MANTENIMIENTO
	private PermisoVo subMenu_mantenimiento_personal;
	private PermisoVo subMenu_mantenimiento_stock;
	private PermisoVo subMenu_mantenimiento_laboratorio; 
	private PermisoVo subMenu_mantenimiento_tipoMovimiento; 
	private PermisoVo subMenu_mantenimiento_catalogos; 
	
	// REPORTE VENTAS
	private PermisoVo subMenu_ventaRpt_recaudacion; 
	private PermisoVo subMenu_ventaRpt_diario;
	private PermisoVo subMenu_ventaRpt_anulaciones;
	private PermisoVo subMenu_ventaRpt_tipoPaciente;
	private PermisoVo subMenu_ventaRpt_devoluciones;

	// REPORTE ICI
	private PermisoVo subMenu_ici_mensual; 
	private PermisoVo subMenu_ici_diario;
	
	// REPORTE ARTICULO
	private PermisoVo subMenu_articuloRpt_vencimiento;
	 	
	// SEGURIDAD 
	private PermisoVo subMenu_seguridad_usuario; 
	private PermisoVo subMenu_seguridad_acceso; 
	private PermisoVo subMenu_seguridad_perfil; 
	// CONFIGURACION 
	private PermisoVo subMenu_configuracion_institucion; 
	private PermisoVo subMenu_configuracion_inventario; 
		
	public boolean isMenu_Estadisticos() {
		return menu_Estadisticos;
	}
	public void setMenu_Estadisticos(boolean menu_Estadisticos) {
		this.menu_Estadisticos = menu_Estadisticos;
	}
	public boolean isMenu_Venta() {
		return menu_Venta;
	}
	public void setMenu_Venta(boolean menu_Venta) {
		this.menu_Venta = menu_Venta;
	}
	public boolean isMenu_Inventario() {
		return menu_Inventario;
	}
	public void setMenu_Inventario(boolean menu_Inventario) {
		this.menu_Inventario = menu_Inventario;
	}
	public boolean isMenu_Movimiento() {
		return menu_Movimiento;
	}
	public void setMenu_Movimiento(boolean menu_Movimiento) {
		this.menu_Movimiento = menu_Movimiento;
	}
	public boolean isMenu_Mantenimiento() {
		return menu_Mantenimiento;
	}
	public void setMenu_Mantenimiento(boolean menu_Mantenimiento) {
		this.menu_Mantenimiento = menu_Mantenimiento;
	}
	public boolean isMenu_RptVenta() {
		return menu_RptVenta;
	}
	public void setMenu_RptVenta(boolean menu_RptVenta) {
		this.menu_RptVenta = menu_RptVenta;
	}
	public boolean isMenu_RptICI() {
		return menu_RptICI;
	}
	public void setMenu_RptICI(boolean menu_RptICI) {
		this.menu_RptICI = menu_RptICI;
	}
	public boolean isMenu_RptArticulo() {
		return menu_RptArticulo;
	}
	public void setMenu_RptArticulo(boolean menu_RptArticulo) {
		this.menu_RptArticulo = menu_RptArticulo;
	}
	public boolean isMenu_Seguridad() {
		return menu_Seguridad;
	}
	public void setMenu_Seguridad(boolean menu_Seguridad) {
		this.menu_Seguridad = menu_Seguridad;
	}
	public boolean isMenu_Configuracion() {
		return menu_Configuracion;
	}
	public void setMenu_Configuracion(boolean menu_Configuracion) {
		this.menu_Configuracion = menu_Configuracion;
	}
	public PermisoVo getSubMenu_venta_generar() {
		return subMenu_venta_generar;
	}
	public void setSubMenu_venta_generar(PermisoVo subMenu_venta_generar) {
		this.subMenu_venta_generar = subMenu_venta_generar;
	}
	public PermisoVo getSubMenu_venta_listar() {
		return subMenu_venta_listar;
	}
	public void setSubMenu_venta_listar(PermisoVo subMenu_venta_listar) {
		this.subMenu_venta_listar = subMenu_venta_listar;
	}
	public PermisoVo getSubMenu_venta_anular() {
		return subMenu_venta_anular;
	}
	public void setSubMenu_venta_anular(PermisoVo subMenu_venta_anular) {
		this.subMenu_venta_anular = subMenu_venta_anular;
	}
	public PermisoVo getSubMenu_venta_devolucion() {
		return subMenu_venta_devolucion;
	}
	public void setSubMenu_venta_devolucion(PermisoVo subMenu_venta_devolucion) {
		this.subMenu_venta_devolucion = subMenu_venta_devolucion;
	}
	public PermisoVo getSubMenu_venta_paciente() {
		return subMenu_venta_paciente;
	}
	public void setSubMenu_venta_paciente(PermisoVo subMenu_venta_paciente) {
		this.subMenu_venta_paciente = subMenu_venta_paciente;
	}
	public PermisoVo getSubMenu_inventario_articulo() {
		return subMenu_inventario_articulo;
	}
	public void setSubMenu_inventario_articulo(PermisoVo subMenu_inventario_articulo) {
		this.subMenu_inventario_articulo = subMenu_inventario_articulo;
	}
	public PermisoVo getSubMenu_inventario_almacen() {
		return subMenu_inventario_almacen;
	}
	public void setSubMenu_inventario_almacen(PermisoVo subMenu_inventario_almacen) {
		this.subMenu_inventario_almacen = subMenu_inventario_almacen;
	}
	public PermisoVo getSubMenu_inventario_consultar() {
		return subMenu_inventario_consultar;
	}
	public void setSubMenu_inventario_consultar(PermisoVo subMenu_inventario_consultar) {
		this.subMenu_inventario_consultar = subMenu_inventario_consultar;
	}
	public PermisoVo getSubMenu_inventario_generar() {
		return subMenu_inventario_generar;
	}
	public void setSubMenu_inventario_generar(PermisoVo subMenu_inventario_generar) {
		this.subMenu_inventario_generar = subMenu_inventario_generar;
	}
	public PermisoVo getSubMenu_movimiento_compra() {
		return subMenu_movimiento_compra;
	}
	public void setSubMenu_movimiento_compra(PermisoVo subMenu_movimiento_compra) {
		this.subMenu_movimiento_compra = subMenu_movimiento_compra;
	}
	public PermisoVo getSubMenu_movimiento_ingresoSalida() {
		return subMenu_movimiento_ingresoSalida;
	}
	public void setSubMenu_movimiento_ingresoSalida(PermisoVo subMenu_movimiento_ingresoSalida) {
		this.subMenu_movimiento_ingresoSalida = subMenu_movimiento_ingresoSalida;
	}
	public PermisoVo getSubMenu_movimiento_kardex() {
		return subMenu_movimiento_kardex;
	}
	public void setSubMenu_movimiento_kardex(PermisoVo subMenu_movimiento_kardex) {
		this.subMenu_movimiento_kardex = subMenu_movimiento_kardex;
	}
	public PermisoVo getSubMenu_mantenimiento_personal() {
		return subMenu_mantenimiento_personal;
	}
	public void setSubMenu_mantenimiento_personal(PermisoVo subMenu_mantenimiento_personal) {
		this.subMenu_mantenimiento_personal = subMenu_mantenimiento_personal;
	}
	public PermisoVo getSubMenu_mantenimiento_stock() {
		return subMenu_mantenimiento_stock;
	}
	public void setSubMenu_mantenimiento_stock(PermisoVo subMenu_mantenimiento_stock) {
		this.subMenu_mantenimiento_stock = subMenu_mantenimiento_stock;
	}
	public PermisoVo getSubMenu_mantenimiento_laboratorio() {
		return subMenu_mantenimiento_laboratorio;
	}
	public void setSubMenu_mantenimiento_laboratorio(PermisoVo subMenu_mantenimiento_laboratorio) {
		this.subMenu_mantenimiento_laboratorio = subMenu_mantenimiento_laboratorio;
	}
	public PermisoVo getSubMenu_mantenimiento_tipoMovimiento() {
		return subMenu_mantenimiento_tipoMovimiento;
	}
	public void setSubMenu_mantenimiento_tipoMovimiento(PermisoVo subMenu_mantenimiento_tipoMovimiento) {
		this.subMenu_mantenimiento_tipoMovimiento = subMenu_mantenimiento_tipoMovimiento;
	}
	public PermisoVo getSubMenu_mantenimiento_catalogos() {
		return subMenu_mantenimiento_catalogos;
	}
	public void setSubMenu_mantenimiento_catalogos(PermisoVo subMenu_mantenimiento_catalogos) {
		this.subMenu_mantenimiento_catalogos = subMenu_mantenimiento_catalogos;
	}
	public PermisoVo getSubMenu_ventaRpt_recaudacion() {
		return subMenu_ventaRpt_recaudacion;
	}
	public void setSubMenu_ventaRpt_recaudacion(PermisoVo subMenu_ventaRpt_recaudacion) {
		this.subMenu_ventaRpt_recaudacion = subMenu_ventaRpt_recaudacion;
	}
	public PermisoVo getSubMenu_ventaRpt_diario() {
		return subMenu_ventaRpt_diario;
	}
	public void setSubMenu_ventaRpt_diario(PermisoVo subMenu_ventaRpt_diario) {
		this.subMenu_ventaRpt_diario = subMenu_ventaRpt_diario;
	}
	public PermisoVo getSubMenu_ventaRpt_anulaciones() {
		return subMenu_ventaRpt_anulaciones;
	}
	public void setSubMenu_ventaRpt_anulaciones(PermisoVo subMenu_ventaRpt_anulaciones) {
		this.subMenu_ventaRpt_anulaciones = subMenu_ventaRpt_anulaciones;
	}
	public PermisoVo getSubMenu_ventaRpt_tipoPaciente() {
		return subMenu_ventaRpt_tipoPaciente;
	}
	public void setSubMenu_ventaRpt_tipoPaciente(PermisoVo subMenu_ventaRpt_tipoPaciente) {
		this.subMenu_ventaRpt_tipoPaciente = subMenu_ventaRpt_tipoPaciente;
	}
	public PermisoVo getSubMenu_ventaRpt_devoluciones() {
		return subMenu_ventaRpt_devoluciones;
	}
	public void setSubMenu_ventaRpt_devoluciones(PermisoVo subMenu_ventaRpt_devoluciones) {
		this.subMenu_ventaRpt_devoluciones = subMenu_ventaRpt_devoluciones;
	}
	public PermisoVo getSubMenu_ici_mensual() {
		return subMenu_ici_mensual;
	}
	public void setSubMenu_ici_mensual(PermisoVo subMenu_ici_mensual) {
		this.subMenu_ici_mensual = subMenu_ici_mensual;
	}
	public PermisoVo getSubMenu_ici_diario() {
		return subMenu_ici_diario;
	}
	public void setSubMenu_ici_diario(PermisoVo subMenu_ici_diario) {
		this.subMenu_ici_diario = subMenu_ici_diario;
	}
	public PermisoVo getSubMenu_articuloRpt_vencimiento() {
		return subMenu_articuloRpt_vencimiento;
	}
	public void setSubMenu_articuloRpt_vencimiento(PermisoVo subMenu_articuloRpt_vencimiento) {
		this.subMenu_articuloRpt_vencimiento = subMenu_articuloRpt_vencimiento;
	}
	public PermisoVo getSubMenu_seguridad_usuario() {
		return subMenu_seguridad_usuario;
	}
	public void setSubMenu_seguridad_usuario(PermisoVo subMenu_seguridad_usuario) {
		this.subMenu_seguridad_usuario = subMenu_seguridad_usuario;
	}
	public PermisoVo getSubMenu_seguridad_acceso() {
		return subMenu_seguridad_acceso;
	}
	public void setSubMenu_seguridad_acceso(PermisoVo subMenu_seguridad_acceso) {
		this.subMenu_seguridad_acceso = subMenu_seguridad_acceso;
	}
	public PermisoVo getSubMenu_configuracion_institucion() {
		return subMenu_configuracion_institucion;
	}
	public void setSubMenu_configuracion_institucion(PermisoVo subMenu_configuracion_institucion) {
		this.subMenu_configuracion_institucion = subMenu_configuracion_institucion;
	}
	public PermisoVo getSubMenu_configuracion_inventario() {
		return subMenu_configuracion_inventario;
	}
	public void setSubMenu_configuracion_inventario(PermisoVo subMenu_configuracion_inventario) {
		this.subMenu_configuracion_inventario = subMenu_configuracion_inventario;
	}
	public PermisoVo getSubMenu_seguridad_perfil() {
		return subMenu_seguridad_perfil;
	}
	public void setSubMenu_seguridad_perfil(PermisoVo subMenu_seguridad_perfil) {
		this.subMenu_seguridad_perfil = subMenu_seguridad_perfil;
	}
	 
}
