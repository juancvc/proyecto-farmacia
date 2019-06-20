package proyect.core.entity.venta;

import java.io.Serializable;
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
  


@SuppressWarnings("serial")
@NamedStoredProcedureQueries(
		{
			@NamedStoredProcedureQuery(
				name="venta.insertVenta", 
				procedureName="SP_VENTA_INSERTAR_VENTA",
				resultClasses= Venta.class,
				parameters={
						    @StoredProcedureParameter(mode=ParameterMode.OUT, name="VALIDA", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.OUT, name="NOMBRE_ARTICULO", type=String.class ),
							@StoredProcedureParameter(mode=ParameterMode.OUT, name="ID_VENTA", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.OUT, name="NRO_PERIODO", type=Integer.class),
							
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
							
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ORGANIZACION_PERSONA", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_INSTITUCION_PERSONA", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SEDE_PERSONA", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="NRO_VERSION_PERSONA", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="NRO_PERIODO_PERSONA", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_PERSONA", type=Integer.class),
							 
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_EVENTO", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ALMACEN", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="FECHA_ATENCION", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_USUARIO", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_TURNO", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_MODALIDAD_PAGO", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_TIPO_SEGURO", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_MAC", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="CANT_ITEMS", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="CADENA_NRO_PERIODO_STOCK", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="CADENA_ID_STOCK", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="CADENA_CANTIDAD", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_TIPO_MONEDA", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="TIPO", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION_RECETA", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION_RECETA", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE_RECETA", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_VERSION_RECETA", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO_RECETA", type=Integer.class),
						    @StoredProcedureParameter(mode=ParameterMode.IN, name="ID_RECETA", type=Integer.class),
						    @StoredProcedureParameter(mode=ParameterMode.IN, name="TIPO_PACIENTE", type=Integer.class),
						    @StoredProcedureParameter(mode=ParameterMode.IN, name="SW_EXOGERADO", type=String.class)
						    
						    ,@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO_PREESCRIPTOR", type=Integer.class)
						    ,@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_PREESCRIPTOR", type=Integer.class)
						    ,@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_RECETA", type=String.class)
						    ,@StoredProcedureParameter(mode=ParameterMode.IN, name="COD_DIAGNOSTICO", type=String.class)
						    ,@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO_RESPONSABLE", type=Integer.class)
						    ,@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_RESPONSABLE", type=Integer.class)
						    ,@StoredProcedureParameter(mode=ParameterMode.IN, name="TIPO_VENTA", type=int.class)
						    ,@StoredProcedureParameter(mode=ParameterMode.IN, name="CADENA_FALTANTE", type=String.class)
						    ,@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_PROGRAMA", type=Integer.class)
						    ,@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SUB_PROGRAMA", type=Integer.class)
						    ,@StoredProcedureParameter(mode=ParameterMode.IN, name="TIPOPACIENTEHOSPITALIZADO", type=Integer.class)
					}
					),
		
			@NamedStoredProcedureQuery(
				name="venta.findByLikeObjectVO", 
				procedureName="SP_VENTA_BUSCAR_X_CRITERIOS",
				resultClasses= Venta.class,
				parameters={
							//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_VENTA", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_EVENTO", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO", type=int.class )
					}					
					),
			@NamedStoredProcedureQuery(
							name="venta.findByLikeObject", 
							procedureName="SP_VENTA_LISTA_VENTAITEM_X_ID_VENTA",
							resultClasses= Venta.class,
							parameters={
										//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_VENTA", type=Integer.class),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO", type=int.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="TIPO", type=int.class )
					}					
					),
					
					@NamedStoredProcedureQuery(
							name="venta.findByLikeObjectDIARIOS", 
							procedureName="SP_VENTA_LISTA_VENTAITEM_X_ID_VENTA_DIARIOS",
							resultClasses= Venta.class,
							parameters={
										//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_VENTA", type=Integer.class),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO", type=int.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="TIPO", type=int.class )
					}					
					),
					
					
					 
			@NamedStoredProcedureQuery(
							name="venta.anular", 
							procedureName="SP_VENTA_ANULAR_VENTA",
							resultClasses= Venta.class,
							parameters={
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_VENTA", type=Integer.class),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION_VENTA", type=int.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION_VENTA", type=int.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE_VENTA", type=int.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO_VENTA", type=int.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_MAC", type=String.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_USUARIO", type=Integer.class)
					}					
					),
			@NamedStoredProcedureQuery(
					name="venta.buscarxFechaClienteVO", 
					procedureName="SP_VENTA_BUSCAR_FECHA_CLIENTE",
					resultClasses= Venta.class,
					parameters={
							//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="NOMBRE_CLIENTE", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="FECHA_ATENCION", type=String.class)
				}					
				),
				@NamedStoredProcedureQuery(
						name="venta.findByObjectVO", 
						procedureName="SP_VENTA_LISTA_VENTAITEM_X_ID_VENTA",
						resultClasses= Venta.class,
						parameters={
							//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_VENTA", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO", type=int.class )
				}					
				),
				@NamedStoredProcedureQuery(
						name="venta.buscarArticulosxIdVenta", 
						procedureName="SP_VENTA_LISTAR_ARTICULOS_VENTA_X_ID",
						resultClasses= Venta.class,
						parameters={
							//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_VENTA", type=Integer.class)
				}					
				),
				@NamedStoredProcedureQuery(
						name="venta.buscarArticulosxIdEvento", 
						procedureName="SP_VENTA_LISTA_ARTICULOS_X_ID_EVENTO",
						resultClasses= Venta.class,
						parameters={
							//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_EVENTO", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class )
				}					
				),
				@NamedStoredProcedureQuery(
						name="venta.devolucion", 
						procedureName="SP_VENTA_DEVOLUCION_VENTA",
						resultClasses= Venta.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="CADENA_ID_VENTA", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION_ALMACEN", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION_ALMACEN", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE_ALMACEN", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_VERSION_ALMACEN", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO_ALMACEN", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ALMACEN", type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="FECHA_ATENCION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="CANT_ITEMS", type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="CADENA_ID_ARTICULO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="CADENA_ID_LOTE", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="CADENA_CANTIDAD", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_SESSION", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_IP", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_MAC", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="AUD_ID_USUARIO", type=Integer.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="CADENA_ID_MOTIVO", type=String.class)
				}					
				),
				@NamedStoredProcedureQuery(
						name="venta.findByIdVenta", 
						procedureName="SP_VENTA_BUSCAR_X_ID",
						resultClasses= Venta.class,
						parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_VENTA", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ORGANIZACION", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_INSTITUCION", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_SEDE", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="NRO_PERIODO", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="TIPO_V", type=Integer.class)
				}					
				),
				@NamedStoredProcedureQuery(
						name="venta.cierreVentaDiariaTurno", 
						procedureName="SP_VENTA_CIERRE_VENTA_DIARIA",
						resultClasses= Venta.class,
						parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ALMACEN", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="FECHA", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_TURNO", type=Integer.class)
				}					
				),
				@NamedStoredProcedureQuery(
						name="venta.listarVentaDiariaTurno", 
						procedureName="SP_VENTA_LISTAR_VENTA_DIARIA",
						resultClasses= Venta.class,
						parameters={
						//	@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_ALMACEN", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="FECHA_ATENCION", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_VENTA", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_TURNO", type=Integer.class)
				}					
				),
				@NamedStoredProcedureQuery(
						name="venta.listarVentasAnuladas", 
						procedureName="[Farmacia].[dbo].[SP_VENTA_LISTAR_VENTA_ANULADAS]",
						resultClasses= Venta.class,
						parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="FECHA_INICIO", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="FECHA_FIN", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ALMACEN", type=int.class )
				}					
				),
				@NamedStoredProcedureQuery(
						name="venta.listarVentasAnuladasIME", 
						procedureName="[Farmacia].[dbo].[SP_VENTA_LISTAR_VENTA_ANULADAS_IME]",
						resultClasses= Venta.class,
						parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="MES", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="PERIODO", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ALMACEN", type=int.class )
				}					
				),
				@NamedStoredProcedureQuery(
						name="venta.listarVentasDiariasFindByObject", 
						procedureName="[Farmacia].[dbo].[SP_VENTA_LISTAR_VENTA_DIARIA_FINDBYOBJECT]",
						resultClasses= Venta.class,
						parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="FECHA_INICIO", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="FECHA_FIN", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ALMACEN", type=int.class )
				}
						
				),
				@NamedStoredProcedureQuery(
						name="venta.listarVentasDiariasFindByObjectPagante", 
						procedureName="[Farmacia].[dbo].[SP_VENTA_LISTAR_VENTA_DIARIA_FINDBYOBJECT_PAGANTE]",
						resultClasses= Venta.class,
						parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="FECHA_INICIO", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="FECHA_FIN", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ALMACEN", type=int.class )
				}
						
				)
				,@NamedStoredProcedureQuery(
						name="venta.listarArticulosxIdPersona", 
						procedureName="SP_VENTA_LISTA_ARTICULOS_X_ID_PERSONA",
						resultClasses= Venta.class,
						parameters={
							//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="C_CURSOR", type=void.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN,  name="ID_PERSONA", type=Integer.class),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION_PERSONA", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION_PERSONA", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE_PERSONA", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO_PERSONA", type=int.class )
				}					
				),
				@NamedStoredProcedureQuery(
						name="venta.listarAtencionesIME", 
						procedureName="SP_VENTA_LISTAR_VENTA_ATENCIONES_IME",
						resultClasses= Venta.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="MES", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="PERIODO", type=String.class),
									@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ALMACEN", type=int.class) 
				}					
				),
				@NamedStoredProcedureQuery(
						name="venta.listarVentasPacienteFUA", 
						procedureName="[Farmacia].[dbo].SP_VENTA_PACIENTE_FUA",
						resultClasses= Venta.class,
						parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="FECHA_INICIO", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="FECHA_FIN", type=String.class),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ALMACEN", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="NROFUA", type=String.class )
				}					
				),
				@NamedStoredProcedureQuery(
						name="venta.listarItemsVentasFUA", 
						procedureName="SP_VENTA_LISTAR_ITEMS_FUA ",
						resultClasses= Venta.class,
						parameters={
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_ORGANIZACION_VENTA", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_INSTITUCION_VENTA", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_SEDE_VENTA", type=int.class ),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="NRO_PERIODO_VENTA", type=int.class),
							@StoredProcedureParameter(mode=ParameterMode.IN, name="ID_VENTA", type=int.class), 
				}					
				),
		}			
	)


@Entity 
public class Venta  implements Serializable {

	@EmbeddedId
	private VentaPK id;

	private Float descimp;

	private Float descporc;

	private String estado;

	@Column(name="FECHA_ATENCION")
	private String fechaAtencion;

	@Column(name="FECHA_REGISTRO")
	private String fechaRegistro;

	private String observacion;

	private Float subtotal;

	private Float total;
 
	@Column(name="ID_PERSONA")
	private String idPersona;
	
	@Column(name="ID_TIPO_MONEDA")
	private String tipoMoneda;
 
	@Column(name="ID_TURNO")
	private String turno;
	
	@OneToMany(mappedBy="venta")
	private List<VentaItem> ventaItems;
	 
	@Column(name="ID_ALMACEN")
	private String almacen;
	
	private String fechaInicio;
	
	private String fechaTermino;
	
//	private EventoPersona eventoPersona;
	
	private String mes;
	private String anio;
	
    private 	List<Venta> lstVentasVO ;
  //  private 	List<Almacen> lstAlmacen ;
    
    private 	String		  nroFUA;
	 
    private String preescriptor;
    private String responsable;
    
    @Column(name="NRO_RECETA")
    private String numeroReceta;
    
    @Column(name="COD_DIAGNOSTICO")
    private String  codDiagnostico;
    
    @Column(name="TIPO_VENTA")
    private int tipoVenta;
    
    private String idPrograma;
    private String idSubPrograma;
    private String tipoPacienteHospitalizado;
    
	public Venta() { 
	}

	public VentaPK getId() {
		return id;
	}

	public void setId(VentaPK id) {
		this.id = id;
	}

	public Float getDescimp() {
		return descimp;
	}

	public void setDescimp(Float descimp) {
		this.descimp = descimp;
	}

	public Float getDescporc() {
		return descporc;
	}

	public void setDescporc(Float descporc) {
		this.descporc = descporc;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFechaAtencion() {
		return fechaAtencion;
	}

	public void setFechaAtencion(String fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Float subtotal) {
		this.subtotal = subtotal;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public String getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}

	public String getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public List<VentaItem> getVentaItems() {
		return ventaItems;
	}

	public void setVentaItems(List<VentaItem> ventaItems) {
		this.ventaItems = ventaItems;
	}

	public String getAlmacen() {
		return almacen;
	}

	public void setAlmacen(String almacen) {
		this.almacen = almacen;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaTermino() {
		return fechaTermino;
	}

	public void setFechaTermino(String fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public List<Venta> getLstVentasVO() {
		return lstVentasVO;
	}

	public void setLstVentasVO(List<Venta> lstVentasVO) {
		this.lstVentasVO = lstVentasVO;
	}

	public String getNroFUA() {
		return nroFUA;
	}

	public void setNroFUA(String nroFUA) {
		this.nroFUA = nroFUA;
	}

	public String getPreescriptor() {
		return preescriptor;
	}

	public void setPreescriptor(String preescriptor) {
		this.preescriptor = preescriptor;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getNumeroReceta() {
		return numeroReceta;
	}

	public void setNumeroReceta(String numeroReceta) {
		this.numeroReceta = numeroReceta;
	}

	public String getCodDiagnostico() {
		return codDiagnostico;
	}

	public void setCodDiagnostico(String codDiagnostico) {
		this.codDiagnostico = codDiagnostico;
	}

	public int getTipoVenta() {
		return tipoVenta;
	}

	public void setTipoVenta(int tipoVenta) {
		this.tipoVenta = tipoVenta;
	}

	public String getIdPrograma() {
		return idPrograma;
	}

	public void setIdPrograma(String idPrograma) {
		this.idPrograma = idPrograma;
	}

	public String getIdSubPrograma() {
		return idSubPrograma;
	}

	public void setIdSubPrograma(String idSubPrograma) {
		this.idSubPrograma = idSubPrograma;
	}

	public String getTipoPacienteHospitalizado() {
		return tipoPacienteHospitalizado;
	}

	public void setTipoPacienteHospitalizado(String tipoPacienteHospitalizado) {
		this.tipoPacienteHospitalizado = tipoPacienteHospitalizado;
	}

 

 
 
}