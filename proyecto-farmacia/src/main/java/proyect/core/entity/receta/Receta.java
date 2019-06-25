package proyect.core.entity.receta;

import java.sql.Timestamp; 
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity; 
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;  


@SuppressWarnings("serial")
@NamedStoredProcedureQueries(
		{
				
				@NamedStoredProcedureQuery(
						name="receta.buscarxid", 
						procedureName="SP_RECETA_BUSCAR_X_ID",
						resultClasses= Receta.class,
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="idReceta", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="tipo", 	   type=String.class )
							}					
					),
				
				@NamedStoredProcedureQuery(
						name="receta.buscarTodos", 
						procedureName="SP_RECETA_BUSCAR_TODOS",
						resultClasses= Receta.class
					/*	parameters={
									@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class )
							}	*/				
					),
					
				@NamedStoredProcedureQuery(
						name="receta.buscarxcriterios", 
						procedureName="SP_RECETA_BUSCAR_X_CRITERIOS",
						resultClasses= Receta.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idReceta", 		type=String.class),									
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idMedico", 		type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="fechaInicio", 	type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="fechaFin", 		type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idSituacion", 	type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idAlmacen", 	type=String.class )
							}	
				),
				
				@NamedStoredProcedureQuery(
						name="receta.insert", 
						procedureName="SP_RECETA_INSERTAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT, name="idReceta", 				type=String.class ),
								
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idEvento", 				type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idPaciente", 			type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idMedico", 				type=String.class), 
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="fechaAtencion", 		type=String.class), 
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="idCIE10", 				type=String.class ),									
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioRegistro", 		type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipRegistro", 			type=String.class),							
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="cantidadItems", 		type=int.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaIdArticulo", 		type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaCantidad", 		type=String.class)
							}					
				),
				
				@NamedStoredProcedureQuery(
						name="receta.update", 
						procedureName="SP_RECETA_ACTUALIZAR",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="idReceta", 				type=String.class ),								
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="idEvento", 				type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="idPaciente", 			type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="idMedico", 				type=String.class),  
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="idCIE10", 				type=String.class ),						
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="usuarioModificacion", 	type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="ipModificacion", 		type=String.class),								
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="cantidadItems", 		type=int.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaIdRecetaDetalle", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaIdArticulo", 		type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="cadenaCantidad", 		type=String.class)
						}					
										
				),
				@NamedStoredProcedureQuery(
						name="receta.delete", 
						procedureName="SP_RECETA_ELIMINAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="idReceta",			 type=String.class ),								
									@StoredProcedureParameter(mode=ParameterMode.IN, name="usuarioModificacion", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ipModificacion", 	 type=String.class)
							}					
				),
				@NamedStoredProcedureQuery(
						name="receta.procesarReceta", 
						procedureName="[Farmacia].[dbo].[SP_PROCESAR_RECETA]",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="idReceta", 			type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="idAlmacen", 			type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="tipo", 				type=String.class )
							}					
				),
				@NamedStoredProcedureQuery(
						name="receta.cambiarSituacion", 
						procedureName="[GISEASISTENCIAL].[ATEN].[SP_RecetaMedica_CambiarSituacion]",
						parameters={

							@StoredProcedureParameter(mode=ParameterMode.IN,  name="idReceta", 					type=String.class)
				}					
				),
				@NamedStoredProcedureQuery(
						name="receta.anularReservaPorReceta", 
						procedureName="[dbo].[SP_RESERVA_CANCELAR_X_IDRECETA]",
						parameters={ 

								@StoredProcedureParameter(mode=ParameterMode.IN, name="idReceta", 		 type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="idAlmacen", 		 type=String.class ),							
								@StoredProcedureParameter(mode=ParameterMode.IN, name="usuarioRegistro", type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN, name="ipRegistro", 	 type=String.class)
				}					
				)
		
		}
	)

@Entity
public class Receta   {

	@EmbeddedId
	private RecetaPK id; 
	
	@Column(name="idCIE10")
	private int idCIE10;
	
	@Column(name="observacion")
	private String observacion;
	
	@Column(name="fechaAtencion")
	private  String  fechaAtencion;
	
	@Column(name="AUD_FECHA_OPERACION")
	private  Timestamp 	aud_fechaOperacion;
	
	@Column(name="NUMERO_HC")
	private String numeroHC;
	
	@OneToMany(mappedBy="receta")
	private List<RecetaDetalle> recetaItems;
	
	@Column(name="tipo")
	private int tipo;
	
	@Column(name="TIPO_PACIENTE")
	private int tipoPaciente;
	
	@Column(name="swExonerado")
	private String swExonerado; 
	
	/*@JoinColumn(name="idAlmacen")
	private Almacen almacen;
	*/
	
	private String descripcionTipoSis;
	private int    idTipoSis;
	
	public RecetaDetalle removeRecetaDetalle(RecetaDetalle recetaDetalle) {
		getRecetaItems().remove(recetaDetalle);
		recetaDetalle.setReceta(null);
		return recetaDetalle;
	}
	public void removeTodoRecetaDetalle(RecetaDetalle recetaDetalle) {
		getRecetaItems().remove(recetaDetalle); 
	}
	
	private int cantidadItems;
	private String cadenaIdRecetaDetalle;
	private String cadenaIdArticulo;
	private String cadenaDosis;
	private String cadenaCantidad;
	private String fechaDesde;
	private String fechaHasta;
	
	private int   idAlmacen;
	
	public Receta() { 
	}


	public String getSwExonerado() {
		return swExonerado;
	}
	public void setSwExonerado(String swExonerado) {
		this.swExonerado = swExonerado;
	}
	public List<RecetaDetalle> getRecetaItems() {
		return recetaItems;
	}


	public void setRecetaItems(List<RecetaDetalle> recetaItems) {
		this.recetaItems = recetaItems;
	}


	 

	 
	public RecetaPK getId() {
		return id;
	}
	public void setId(RecetaPK id) {
		this.id = id;
	}
 

	public int getIdCIE10() {
		return idCIE10;
	}


	public void setIdCIE10(int idCIE10) {
		this.idCIE10 = idCIE10;
	}


	public String getFechaAtencion() {
		return fechaAtencion;
	}


	public void setFechaAtencion(String fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}


	public Timestamp getAud_fechaOperacion() {
		return aud_fechaOperacion;
	}


	public void setAud_fechaOperacion(Timestamp aud_fechaOperacion) {
		this.aud_fechaOperacion = aud_fechaOperacion;
	}


	public int getCantidadItems() {
		return cantidadItems;
	}


	public void setCantidadItems(int cantidadItems) {
		this.cantidadItems = cantidadItems;
	}


	public String getCadenaIdArticulo() {
		return cadenaIdArticulo;
	}


	public void setCadenaIdArticulo(String cadenaIdArticulo) {
		this.cadenaIdArticulo = cadenaIdArticulo;
	}


	public String getCadenaCantidad() {
		return cadenaCantidad;
	}


	public void setCadenaCantidad(String cadenaCantidad) {
		this.cadenaCantidad = cadenaCantidad;
	}


	public String getCadenaIdRecetaDetalle() {
		return cadenaIdRecetaDetalle;
	}


	public void setCadenaIdRecetaDetalle(String cadenaIdRecetaDetalle) {
		this.cadenaIdRecetaDetalle = cadenaIdRecetaDetalle;
	}


	public String getFechaDesde() {
		return fechaDesde;
	}


	public void setFechaDesde(String fechaDesde) {
		this.fechaDesde = fechaDesde;
	}


	public String getFechaHasta() {
		return fechaHasta;
	}


	public void setFechaHasta(String fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public String getCadenaDosis() {
		return cadenaDosis;
	}
	public void setCadenaDosis(String cadenaDosis) {
		this.cadenaDosis = cadenaDosis;
	}
	public int getIdAlmacen() {
		return idAlmacen;
	}
	public void setIdAlmacen(int idAlmacen) {
		this.idAlmacen = idAlmacen;
	}
	public String getNumeroHC() {
		return numeroHC;
	}
	public void setNumeroHC(String numeroHC) {
		this.numeroHC = numeroHC;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public int getTipoPaciente() {
		return tipoPaciente;
	}
	public void setTipoPaciente(int tipoPaciente) {
		this.tipoPaciente = tipoPaciente;
	}

	public String getDescripcionTipoSis() {
		return descripcionTipoSis;
	}
	public void setDescripcionTipoSis(String descripcionTipoSis) {
		this.descripcionTipoSis = descripcionTipoSis;
	}
	
	public int getIdTipoSis() {
		return idTipoSis;
	}
	public void setIdTipoSis(int idTipoSis) {
		this.idTipoSis = idTipoSis;
	} 
	
}