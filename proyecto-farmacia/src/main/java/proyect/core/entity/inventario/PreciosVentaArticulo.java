package proyect.core.entity.inventario;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
 
@NamedStoredProcedureQueries(
		{
				
				@NamedStoredProcedureQuery(
						name="preciosVentaArticulo.buscarxid", 
						procedureName="[dbo].[usp_PrecioVenta_buscarxID]",
						resultClasses= PreciosVentaArticulo.class,
						parameters={
						
							@StoredProcedureParameter(mode=ParameterMode.IN, name="idPrecioVenta", type=String.class )
							}					
					),
				
				@NamedStoredProcedureQuery(
						name="preciosVentaArticulo.buscarxcriterios", 
						procedureName="[dbo].[usp_PrecioVenta_buscarxCriterios]",
						resultClasses= PreciosVentaArticulo.class,
						parameters={
								
							@StoredProcedureParameter(mode=ParameterMode.IN, name="idPrecioVenta", type=String.class )
							}	
				),
				
				@NamedStoredProcedureQuery(
						name="preciosVentaArticulo.insert", 
						procedureName="[dbo].[usp_PrecioVenta_insertar]",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.OUT, name="idPrecioVenta", 	type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="porcPrecioVenta01", type=float.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="porcPrecioVenta02", type=float.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="porcPrecioVenta03", type=float.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="porcPrecioVenta04", type=float.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="porcPrecioVenta05", type=float.class),									
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="activoPrecio01", 	type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="activoPrecio02", 	type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="activoPrecio03", 	type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="activoPrecio04", 	type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="activoPrecio05", 	type=String.class),									
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="tipoCambio", 		type=float.class),									
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioRegistro", 	type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipRegistro", 		type=String.class)
							}					
				),
				
				@NamedStoredProcedureQuery(
						name="preciosVentaArticulo.update", 
						procedureName="[dbo].[usp_PrecioVenta_actualizar]",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="idPrecioVenta", 	  type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="porcPrecioVenta01",   type=float.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="porcPrecioVenta02",   type=float.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="porcPrecioVenta03",   type=float.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="porcPrecioVenta04",   type=float.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="porcPrecioVenta05",   type=float.class),							
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="activoPrecio01", 	  type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="activoPrecio02", 	  type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="activoPrecio03", 	  type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="activoPrecio04", 	  type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="activoPrecio05", 	  type=String.class),								
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="tipoCambio",		  type=float.class),								
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioModificacion", type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipModificacion", 	  type=String.class)
						}					
										
				),
				@NamedStoredProcedureQuery(
						name="preciosVentaArticulo.delete", 
						procedureName="[dbo].[usp_PrecioVenta_eliminar]",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="idPrecioVenta",		  type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioModificacion", type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipModificacion", 	  type=String.class)
							}					
				)
		
		}
	)
@Entity
@Table(name="PrecioVenta")
public class PreciosVentaArticulo  {
	private static final int serialVersionUID = 1;
	@Id
	@Column(name="idPrecioVenta")
	private String idPrecioVentaArticulo;

	@Column(name="porcPrecioVenta01")
	private float porcentajePrecioVenta1;

	@Column(name="porcPrecioVenta02")
	private float porcentajePrecioVenta2;
	

	@Column(name="porcPrecioVenta03")
	private float porcentajePrecioVenta3;
	

	@Column(name="porcPrecioVenta04")
	private float porcentajePrecioVenta4;
	

	@Column(name="porcPrecioVenta05")
	private float porcentajePrecioVenta5;
	
	@Column(name="tipoCambio")
	private float precioTipoCambio;
	
	@Column(name="activoPrecio01")
	private String swActivoPrecio1;
	
	@Column(name="activoPrecio02")
	private String swActivoPrecio2;
	
	@Column(name="activoPrecio03")
	private String swActivoPrecio3;
	
	@Column(name="activoPrecio04")
	private String swActivoPrecio4;
	
	@Column(name="activoPrecio05")
	private String swActivoPrecio5;
	
	@Column(name="ID_ORGANIZACION_PRECIO_VENTA_ART")
	private int idOrganizacionPrecioVentaArticulo;
	
	@Column(name="ID_INSTITUCION_PRECIO_VENTA_ART")
	private int idInstitucionPrecioVentaArticulo;
	
	@Column(name="ID_SEDE_PRECIO_VENTA_ART")
	private int idSedePrecioVentaArticulo;
	
	@Column(name="NRO_VERSION_PRECIO_VENTA_ART")
	private int nroVersionPrecioVentaArticulo;
	
	@Column(name="NRO_PERIODO_PRECIO_VENTA_ART")
	private int nroPeriodoPrecioVentaArticulo;
	
	@Column(name="usuarioRegistro")
	private String usuarioRegistro;
	
	@Column(name="ipRegistro")
	private String ipRegistro;
	
	@Column(name="usuarioModificacion")
	private String usuarioModificacion;
	
	@Column(name="ipModificacion")
	private String ipModificacion;
	
	
	@Column(name="AUD_FECHA_OPERACION")
	private  Timestamp 	aud_fechaOperacion;
	public String getIdPrecioVentaArticulo() {
		return idPrecioVentaArticulo;
	}


	public void setIdPrecioVentaArticulo(String idPrecioVentaArticulo) {
		this.idPrecioVentaArticulo = idPrecioVentaArticulo;
	}


	public float getPorcentajePrecioVenta1() {
		return porcentajePrecioVenta1;
	}


	public void setPorcentajePrecioVenta1(float porcentajePrecioVenta1) {
		this.porcentajePrecioVenta1 = porcentajePrecioVenta1;
	}


	public float getPorcentajePrecioVenta2() {
		return porcentajePrecioVenta2;
	}


	public void setPorcentajePrecioVenta2(float porcentajePrecioVenta2) {
		this.porcentajePrecioVenta2 = porcentajePrecioVenta2;
	}


	public float getPorcentajePrecioVenta3() {
		return porcentajePrecioVenta3;
	}


	public void setPorcentajePrecioVenta3(float porcentajePrecioVenta3) {
		this.porcentajePrecioVenta3 = porcentajePrecioVenta3;
	}


	public float getPorcentajePrecioVenta4() {
		return porcentajePrecioVenta4;
	}


	public void setPorcentajePrecioVenta4(float porcentajePrecioVenta4) {
		this.porcentajePrecioVenta4 = porcentajePrecioVenta4;
	}


	public float getPorcentajePrecioVenta5() {
		return porcentajePrecioVenta5;
	}


	public void setPorcentajePrecioVenta5(float porcentajePrecioVenta5) {
		this.porcentajePrecioVenta5 = porcentajePrecioVenta5;
	}

	public String getSwActivoPrecio1() {
		return swActivoPrecio1;
	}


	public void setSwActivoPrecio1(String swActivoPrecio1) {
		this.swActivoPrecio1 = swActivoPrecio1;
	}


	public String getSwActivoPrecio2() {
		return swActivoPrecio2;
	}


	public void setSwActivoPrecio2(String swActivoPrecio2) {
		this.swActivoPrecio2 = swActivoPrecio2;
	}


	public String getSwActivoPrecio3() {
		return swActivoPrecio3;
	}


	public void setSwActivoPrecio3(String swActivoPrecio3) {
		this.swActivoPrecio3 = swActivoPrecio3;
	}


	public String getSwActivoPrecio4() {
		return swActivoPrecio4;
	}


	public void setSwActivoPrecio4(String swActivoPrecio4) {
		this.swActivoPrecio4 = swActivoPrecio4;
	}


	public String getSwActivoPrecio5() {
		return swActivoPrecio5;
	}


	public void setSwActivoPrecio5(String swActivoPrecio5) {
		this.swActivoPrecio5 = swActivoPrecio5;
	}


	public static int getSerialversionuid() {
		return serialVersionUID;
	}


	public PreciosVentaArticulo() { 
	}


	public float getPrecioTipoCambio() {
		return precioTipoCambio;
	}


	public void setPrecioTipoCambio(float precioTipoCambio) {
		this.precioTipoCambio = precioTipoCambio;
	}


	public int getIdOrganizacionPrecioVentaArticulo() {
		return idOrganizacionPrecioVentaArticulo;
	}


	public void setIdOrganizacionPrecioVentaArticulo(int idOrganizacionPrecioVentaArticulo) {
		this.idOrganizacionPrecioVentaArticulo = idOrganizacionPrecioVentaArticulo;
	}


	public int getIdInstitucionPrecioVentaArticulo() {
		return idInstitucionPrecioVentaArticulo;
	}


	public void setIdInstitucionPrecioVentaArticulo(int idInstitucionPrecioVentaArticulo) {
		this.idInstitucionPrecioVentaArticulo = idInstitucionPrecioVentaArticulo;
	}


	public int getIdSedePrecioVentaArticulo() {
		return idSedePrecioVentaArticulo;
	}


	public void setIdSedePrecioVentaArticulo(int idSedePrecioVentaArticulo) {
		this.idSedePrecioVentaArticulo = idSedePrecioVentaArticulo;
	}


	public int getNroVersionPrecioVentaArticulo() {
		return nroVersionPrecioVentaArticulo;
	}


	public void setNroVersionPrecioVentaArticulo(int nroVersionPrecioVentaArticulo) {
		this.nroVersionPrecioVentaArticulo = nroVersionPrecioVentaArticulo;
	}


	public int getNroPeriodoPrecioVentaArticulo() {
		return nroPeriodoPrecioVentaArticulo;
	}


	public void setNroPeriodoPrecioVentaArticulo(int nroPeriodoPrecioVentaArticulo) {
		this.nroPeriodoPrecioVentaArticulo = nroPeriodoPrecioVentaArticulo;
	}


	public Timestamp getAud_fechaOperacion() {
		return aud_fechaOperacion;
	}


	public void setAud_fechaOperacion(Timestamp aud_fechaOperacion) {
		this.aud_fechaOperacion = aud_fechaOperacion;
	}
	
	
	
	


	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}


	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}


	public String getIpRegistro() {
		return ipRegistro;
	}


	public void setIpRegistro(String ipRegistro) {
		this.ipRegistro = ipRegistro;
	}


	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}


	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}


	public String getIpModificacion() {
		return ipModificacion;
	}


	public void setIpModificacion(String ipModificacion) {
		this.ipModificacion = ipModificacion;
	}


	@Override
	public String toString() {
		return "PreciosVentaArticulo [idPrecioVentaArticulo=" + idPrecioVentaArticulo + ", porcentajePrecioVenta1="
				+ porcentajePrecioVenta1 + ", porcentajePrecioVenta2=" + porcentajePrecioVenta2
				+ ", porcentajePrecioVenta3=" + porcentajePrecioVenta3 + ", porcentajePrecioVenta4="
				+ porcentajePrecioVenta4 + ", porcentajePrecioVenta5=" + porcentajePrecioVenta5 + ", precioTipoCambio="
				+ precioTipoCambio + ", swActivoPrecio1=" + swActivoPrecio1 + ", swActivoPrecio2=" + swActivoPrecio2
				+ ", swActivoPrecio3=" + swActivoPrecio3 + ", swActivoPrecio4=" + swActivoPrecio4 + ", swActivoPrecio5="
				+ swActivoPrecio5 + "]";
	}


	
}