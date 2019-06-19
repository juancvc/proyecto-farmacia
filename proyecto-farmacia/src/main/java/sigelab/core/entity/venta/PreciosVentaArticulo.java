package sigelab.core.entity.venta;

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
						procedureName="SP_PRECIO_VENTA_ART_BUSCAR_X_ID",
						resultClasses= PreciosVentaArticulo.class,
						parameters={
								//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_PRECIO_VENTA_ART", type=Integer.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class )
							}					
					),
				
				@NamedStoredProcedureQuery(
						name="preciosVentaArticulo.buscarxcriterios", 
						procedureName="SP_PRECIO_VENTA_ART_BUSCAR_X_CRITERIOS",
						resultClasses= PreciosVentaArticulo.class,
						parameters={
								//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_PRECIO_VENTA_ART", type=Integer.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class )
							}	
				),
				
				@NamedStoredProcedureQuery(
						name="preciosVentaArticulo.insert", 
						procedureName="SP_PRECIO_VENTA_ART_INSERTAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="ID_PRECIO_VENTA_ART", type=Integer.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="PORC_PRECIO_VENTA_1", type=float.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="PORC_PRECIO_VENTA_2", type=float.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="PORC_PRECIO_VENTA_3", type=float.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="PORC_PRECIO_VENTA_4", type=float.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="PORC_PRECIO_VENTA_5", type=float.class),									
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="SWACTIVO_PRECIO1", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="SWACTIVO_PRECIO2", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="SWACTIVO_PRECIO3", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="SWACTIVO_PRECIO4", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="SWACTIVO_PRECIO5", type=String.class),									
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="PRECIO_TIPO_CAMBIO", type=float.class),									
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SITUACION", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_USUARIO", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_MAC", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_OPERACION", type=Long.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class )
							}					
				),
				
				@NamedStoredProcedureQuery(
						name="preciosVentaArticulo.update", 
						procedureName="SP_PRECIO_VENTA_ART_ACTUALIZAR",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_PRECIO_VENTA_ART", type=Integer.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="PORC_PRECIO_VENTA_1", type=float.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="PORC_PRECIO_VENTA_2", type=float.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="PORC_PRECIO_VENTA_3", type=float.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="PORC_PRECIO_VENTA_4", type=float.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="PORC_PRECIO_VENTA_5", type=float.class),							
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="SWACTIVO_PRECIO1", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="SWACTIVO_PRECIO2", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="SWACTIVO_PRECIO3", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="SWACTIVO_PRECIO4", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="SWACTIVO_PRECIO5", type=String.class),								
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="PRECIO_TIPO_CAMBIO", type=float.class),								
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SITUACION", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_USUARIO", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_MAC", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_OPERACION", type=Long.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class )
						}					
										
				),
				@NamedStoredProcedureQuery(
						name="preciosVentaArticulo.delete", 
						procedureName="SP_PRECIO_VENTA_ART_ELIMINAR",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_PRECIO_VENTA_ART", type=Integer.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SITUACION", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_USUARIO", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_MAC", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_OPERACION", type=Long.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class )
							}					
				)
		
		}
	)
@Entity
@Table(name="PRECIOS_VENTA_ART")
public class PreciosVentaArticulo  {
	private static final int serialVersionUID = 1;
	@Id
	@Column(name="ID_PRECIO_VENTA_ART")
	private int idPrecioVentaArticulo;

	@Column(name="PORC_PRECIO_VENTA_1")
	private float porcentajePrecioVenta1;

	@Column(name="PORC_PRECIO_VENTA_2")
	private float porcentajePrecioVenta2;
	

	@Column(name="PORC_PRECIO_VENTA_3")
	private float porcentajePrecioVenta3;
	

	@Column(name="PORC_PRECIO_VENTA_4")
	private float porcentajePrecioVenta4;
	

	@Column(name="PORC_PRECIO_VENTA_5")
	private float porcentajePrecioVenta5;
	
	@Column(name="PRECIO_TIPO_CAMBIO")
	private float precioTipoCambio;
	
	@Column(name="SWACTIVO_PRECIO1")
	private String swActivoPrecio1;
	
	@Column(name="SWACTIVO_PRECIO2")
	private String swActivoPrecio2;
	
	@Column(name="SWACTIVO_PRECIO3")
	private String swActivoPrecio3;
	
	@Column(name="SWACTIVO_PRECIO4")
	private String swActivoPrecio4;
	
	@Column(name="SWACTIVO_PRECIO5")
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
	
	@Column(name="AUD_FECHA_OPERACION")
	private  Timestamp 	aud_fechaOperacion;
	public int getIdPrecioVentaArticulo() {
		return idPrecioVentaArticulo;
	}


	public void setIdPrecioVentaArticulo(int idPrecioVentaArticulo) {
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