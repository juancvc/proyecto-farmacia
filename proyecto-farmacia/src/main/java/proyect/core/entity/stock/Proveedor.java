package proyect.core.entity.stock;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
 
@NamedStoredProcedureQueries(
		{
				
				@NamedStoredProcedureQuery(
						name="proveedor.findByObject", 
						procedureName="[dbo].[usp_Proveedor_buscarxId]",
						resultClasses= Proveedor.class,
						parameters={
					
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idProveedor", type=String.class)
							}					
					),

				@NamedStoredProcedureQuery(
						name="proveedor.findByLikeObject", 
						procedureName="[dbo].[usp_Proveedor_buscarxCriterios]",
						resultClasses= Proveedor.class,
						parameters={
					
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="nombreProveedor", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="descripcion", 	  type=String.class)
							}	
				),
				
				@NamedStoredProcedureQuery(
						name="proveedor.insert", 
						procedureName="SP_PROVEEDOR_INSERTAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT,  name="idProveedor", 	    type=String.class ),								
									@StoredProcedureParameter(mode=ParameterMode.IN,   name="nombreProveedor",  type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,   name="descripcion", 		type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,   name="ruc", 				type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,   name="usuarioRegistro",  type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,   name="ipRegistro", 		type=String.class)
							}					
				),
				@NamedStoredProcedureQuery(
						name="proveedor.update", 
						procedureName="SP_PROVEEDOR_ACTUALIZAR",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="idProveedor", 	  	  type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="nombreProveedor", 	  type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="descripcion", 	  	  type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="RUC", 			      type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioModificacion", type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipModificacion", 	  type=String.class)
						}					
										
				),
				@NamedStoredProcedureQuery(
						name="proveedor.delete", 
						procedureName="SP_PROVEEDOR_ELIMINAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="idProveedor", 		 type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="usuarioModificacion", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ipModificacion", 	 type=String.class)
							}					
				)
		
				
		}
	)
@Entity
public class Proveedor  {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="idProveedor")
	private long idProveedor;

	@Column(name="nombreProveedor")
	private String nombreCorto;

	@Column(name="descripcion")
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
 
	
}