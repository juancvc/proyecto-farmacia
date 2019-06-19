package pe.com.galaxy.systems.apolo.core.entidad.entidad.stock;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import pe.com.galaxy.systems.apolo.core.entidad.GenericEntity;
import pe.com.galaxy.systems.apolo.core.entidad.entidad.general.Situacion;
import pe.com.galaxy.systems.apolo.core.entidad.entidad.seguridad.Usuario;
@NamedStoredProcedureQueries(
		{
				
				@NamedStoredProcedureQuery(
						name="proveedor.findByObject", 
						procedureName="SP_PROVEEDOR_BUSCAR_X_ID",
						resultClasses= Proveedor.class,
						parameters={
									//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_PROVEEDOR", type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class )
							}					
					),

				@NamedStoredProcedureQuery(
						name="proveedor.findByLikeObject", 
						procedureName="SP_PROVEEDOR_BUSCAR_X_CRITERIOS",
						resultClasses= Proveedor.class,
						parameters={
								//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_CORTO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_LARGO", type=String.class)
							}	
				),
				
				@NamedStoredProcedureQuery(
						name="proveedor.insert", 
						procedureName="SP_PROVEEDOR_INSERTAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="ID_PROVEEDOR", type=Integer.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_CORTO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_LARGO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="RUC", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SITUACION", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_USUARIO", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_OPERACION", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_MAC", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_OBSERVACION", type=String.class)
							}					
				),
				@NamedStoredProcedureQuery(
						name="proveedor.update", 
						procedureName="SP_PROVEEDOR_ACTUALIZAR",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_PROVEEDOR", type=Integer.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_CORTO", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_LARGO", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="RUC", type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SITUACION", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_USUARIO", type=Long.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_OPERACION", type=int.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_MAC", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_OBSERVACION", type=String.class)
						}					
										
				),
				@NamedStoredProcedureQuery(
						name="proveedor.delete", 
						procedureName="SP_PROVEEDOR_ELIMINAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_PROVEEDOR", type=Integer.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_USUARIO", type=Long.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_IP", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_SESSION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_ID_OPERACION", type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="AUD_MAC", type=String.class)
							}					
				)
		
		}
	)
@Entity
public class Proveedor 
	extends GenericEntity{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ID_PROVEEDOR")
	private long idProveedor;

	@Column(name="NOMBRE_CORTO")
	private String nombreCorto;

	@Column(name="NOMBRE_LARGO")
	private String nombreLargo;
	
	@Column(name="RUC")
	private String ruc;

	@Column(name="ID_ORGANIZACION_PROVEEDOR")
	private int idOrganizacionProveedor;
	
	@Column(name="ID_INSTITUCION_PROVEEDOR")
	private int idInstitucionProveedor;
	
	@Column(name="ID_SEDE_PROVEEDOR")
	private int idSedeProveedor;
	
	@Column(name="NRO_VERSION_PROVEEDOR")
	private int nroVersionProveedor;
	
	@Column(name="NRO_PERIODO_PROVEEDOR")
	private int nroPeriodoProveedor;
	
	public Proveedor() {
		this.setSituacion(new Situacion());
		this.setAud_usuario(new Usuario());
	}


	public long getIdProveedor() {
		return idProveedor;
	}


	public void setIdProveedor(long idProveedor) {
		this.idProveedor = idProveedor;
	}


	public String getRuc() {
		return ruc;
	}


	public void setRuc(String ruc) {
		this.ruc = ruc;
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

	public int getIdOrganizacionProveedor() {
		return idOrganizacionProveedor;
	}


	public void setIdOrganizacionProveedor(int idOrganizacionProveedor) {
		this.idOrganizacionProveedor = idOrganizacionProveedor;
	}


	public int getIdInstitucionProveedor() {
		return idInstitucionProveedor;
	}


	public void setIdInstitucionProveedor(int idInstitucionProveedor) {
		this.idInstitucionProveedor = idInstitucionProveedor;
	}


	public int getIdSedeProveedor() {
		return idSedeProveedor;
	}


	public void setIdSedeProveedor(int idSedeProveedor) {
		this.idSedeProveedor = idSedeProveedor;
	}


	public int getNroVersionProveedor() {
		return nroVersionProveedor;
	}


	public void setNroVersionProveedor(int nroVersionProveedor) {
		this.nroVersionProveedor = nroVersionProveedor;
	}


	public int getNroPeriodoProveedor() {
		return nroPeriodoProveedor;
	}


	public void setNroPeriodoProveedor(int nroPeriodoProveedor) {
		this.nroPeriodoProveedor = nroPeriodoProveedor;
	}


	@Override
	public String toString() {
		return "Proveedor [idProveedor=" + idProveedor + ", nombreCorto=" + nombreCorto
				+ ", nombreLargo=" + nombreLargo + ", ruc=" + ruc + ", estado="
				+ estado + "]";
	}
	
}