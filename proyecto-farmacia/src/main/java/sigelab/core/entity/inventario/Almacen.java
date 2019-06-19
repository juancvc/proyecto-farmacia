package sigelab.core.entity.inventario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
 
@SuppressWarnings("serial")
@NamedStoredProcedureQueries(
		{
				
				@NamedStoredProcedureQuery(
						name="almacen.buscarPorObjeto", 
						procedureName="SP_ALMACEN_BUSCAR_X_ID",
						resultClasses= Almacen.class,
						parameters={
									//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ALMACEN", type=Integer.class)
							}					
					),
				@NamedStoredProcedureQuery(
						name="almacen.buscarPorFiltros", 
						procedureName="SP_ALMACEN_BUSCAR_X_CRITERIOS",
						resultClasses= Almacen.class,
						parameters={
									//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="NOMBRE_CORTO", type=String.class) 
							}	
				),
				
				@NamedStoredProcedureQuery(
						name="almacen.insert", 
						procedureName="SP_ALMACEN_INSERTAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="ID_ALMACEN", type=Integer.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SEDE", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_CORTO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_LARGO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ALIAS", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SITUACION", type=Integer.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_USUARIO", type=Integer.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_OPERACION", type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_MAC", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_OBSERVACION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="CODIGO_MINSA", type=String.class)
							}					
				),
				
				@NamedStoredProcedureQuery(
						name="almacen.update", 
						procedureName="SP_ALMACEN_ACTUALIZAR",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ALMACEN", type=Integer.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ORGANIZACION", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_INSTITUCION", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SEDE", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_CORTO", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_LARGO", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ALIAS", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SITUACION", type=Integer.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_USUARIO", type=Integer.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_OPERACION", type=Integer.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_MAC", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_OBSERVACION", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="CODIGO_MINSA", type=String.class)
						}					
										
				),
				@NamedStoredProcedureQuery(
						name="almacen.delete", 
						procedureName="SP_ALMACEN_ELIMINAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ALMACEN", type=Integer.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_USUARIO", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_IP", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_SESSION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_OPERACION", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_MAC", type=String.class)
							}					
				),
				@NamedStoredProcedureQuery(
						name="almacen.buscarTodos", 
						procedureName="SP_ALMACEN_BUSCAR_TODOS",
						resultClasses= Almacen.class,
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class )
							}				
					),
				@NamedStoredProcedureQuery(
						name="almacen.listaDbf", 
						procedureName="SP_ALMACEN_EXP_DBF",
						resultClasses= Almacen.class,
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ALMACEN", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class )
							}				
					)
		
		}
	)
@Entity
@Table(name="ALMACEN")
public class Almacen  {
	
	@Id
	@Column(name="ID_ALMACEN")
	private String idAlmacen;

	@Column(name="NOMBRE_CORTO")
	private String nombreCorto;

	@Column(name="NOMBRE_LARGO")
	private String nombreLargo;
	
	@Column(name="ALIAS")
	private String alias;

	@Column(name="ID_ORGANIZACION_ALMACEN")
	private int idOrganizacionAlmacen;
	
	@Column(name="ID_INSTITUCION_ALMACEN")
	private int idInstitucionAlmacen;
	
	@Column(name="ID_SEDE_ALMACEN")
	private int idSedeAlmacen;
	
	@Column(name="NRO_VERSION_ALMACEN")
	private int nroVersionAlmacen;
	
	@Column(name="NRO_PERIODO_ALMACEN")
	private int nroPeriodoAlmacen;
	
	@Column(name="AUD_OBSERVACION")
	private String aud_Observacion;
	
	@Column(name="CODIGO_MINSA")
	private String codigoMinsa;
	
	public Almacen() { 
	}
 
	public String getNombreCorto() {
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	public String getNombreLargo() {
		return nombreLargo;
	}

	public void setNombreLargo(String nombreLargo) {
		this.nombreLargo = nombreLargo;
	}

	public int getIdOrganizacionAlmacen() {
		return idOrganizacionAlmacen;
	}


	public void setIdOrganizacionAlmacen(int idOrganizacionAlmacen) {
		this.idOrganizacionAlmacen = idOrganizacionAlmacen;
	}


	public int getIdInstitucionAlmacen() {
		return idInstitucionAlmacen;
	}


	public void setIdInstitucionAlmacen(int idInstitucionAlmacen) {
		this.idInstitucionAlmacen = idInstitucionAlmacen;
	}


	public int getIdSedeAlmacen() {
		return idSedeAlmacen;
	}


	public void setIdSedeAlmacen(int idSedeAlmacen) {
		this.idSedeAlmacen = idSedeAlmacen;
	}


	public int getNroVersionAlmacen() {
		return nroVersionAlmacen;
	}

	public void setNroVersionAlmacen(int nroVersionAlmacen) {
		this.nroVersionAlmacen = nroVersionAlmacen;
	}

	public int getNroPeriodoAlmacen() {
		return nroPeriodoAlmacen;
	}

	public void setNroPeriodoAlmacen(int nroPeriodoAlmacen) {
		this.nroPeriodoAlmacen = nroPeriodoAlmacen;
	}

	public String getAlias() {
		return alias;
	}


	public void setAlias(String alias) {
		this.alias = alias;
	}


	public String getAud_Observacion() {
		return aud_Observacion;
	}


	public void setAud_Observacion(String aud_Observacion) {
		this.aud_Observacion = aud_Observacion;
	}

	public String getCodigoMinsa() {
		return codigoMinsa;
	}


	public void setCodigoMinsa(String codigoMinsa) {
		this.codigoMinsa = codigoMinsa;
	}


	public String getIdAlmacen() {
		return idAlmacen;
	}

	public void setIdAlmacen(String idAlmacen) {
		this.idAlmacen = idAlmacen;
	}

	@Override
	public String toString() {
		return "Almacen [idAlmacen=" + idAlmacen + ", nombreCorto=" + nombreCorto + ", nombreLargo=" + nombreLargo
				+ ", alias=" + alias + ", idOrganizacionAlmacen=" + idOrganizacionAlmacen + ", idInstitucionAlmacen="
				+ idInstitucionAlmacen + ", idSedeAlmacen=" + idSedeAlmacen + ", nroVersionAlmacen=" + nroVersionAlmacen
				+ ", nroPeriodoAlmacen=" + nroPeriodoAlmacen + ", aud_Observacion=" + aud_Observacion + "]";
	}


	
}