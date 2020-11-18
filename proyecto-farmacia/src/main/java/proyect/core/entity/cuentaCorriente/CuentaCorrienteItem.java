package proyect.core.entity.cuentaCorriente;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import org.bridj.cpp.com.DECIMAL;
 
import proyect.core.entity.general.Personal;
import proyect.core.entity.stock.Articulo;

@SuppressWarnings("serial")
@NamedStoredProcedureQueries({

		})

@Entity
public class CuentaCorrienteItem implements Serializable {

	@EmbeddedId
	private CuentaCorrienteItemPK id;

	private boolean activo;

	private String cuentaCorriente;

	private String codCtaCteFraccionada;

	private String tipoCategoria;

	// private PrmProcess atencion; // ATENCION - TOPICO, CITA,
	// private PrmProcess item; // PROC. MEDICO(CON ATENCION)
	// private PrmProcess subItem; // EXAMEN DE LABORATORIO (CON ATENCION Y ORDEN)

	private String tipoDocVenta;
	private String nroDocVenta;

	private String tipoTarifa;
	private Boolean swConsumido;

//	private Tarifario tarifario;
	private Articulo producto;

	private Personal personalAutorFrac;
	private String codDocAutorFrac;

	private Integer nroCuota;
	private Integer nroParte;
	private String nombreParte;

	private String tipoMoneda;
	private Float montoBase;
	private Float montoParte;
	private Float cantidad;

	private Timestamp fechaVencimiento;

	private String tipoDescuento;
	// private PrmProcess objDescuento; // SERVICIO SOCIAL O BIENESTAR DE PERSONAL
	private Float importeDescuento;

	private String tipoMora;
	private Float importeMora;
	private Float precioUnitario;
	private String pUnit;
	private Float importeTotal;

	private Boolean flagCarga; // FLAG DE CARGA (0 = SISTEMA Ó 1 = MANUAL)
	private int flagListado;

	/** PARAMETRO UTILIZADO EN LA String CTACTE **/
	private boolean seleccionado = false;

	/** PARAMETROS DEL V1 ***/
	private String tipoCuenta;
	private String codigoTarifa;
	private String codigoDocumentoV1;
	private String fecha;
	private String cpt;
	private String hora;
	private String usu;
	private String fechaItem;
	private String documentoFarmacia;

	/*** FILTROS DE REPORTE */
	private Timestamp fechaIni;
	private Timestamp fechaFin;

	private String codigoCtaCteTransferido;

	public CuentaCorrienteItem() {
	}

	public CuentaCorrienteItemPK getId() {
		return id;
	}

	public void setId(CuentaCorrienteItemPK id) {
		this.id = id;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}