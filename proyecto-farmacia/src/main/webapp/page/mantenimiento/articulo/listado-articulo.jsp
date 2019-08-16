<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Farmacia - Articulo</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/app-assets/bower_components/bootstrap/dist/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/app-assets/bower_components/font-awesome/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/app-assets/bower_components/Ionicons/css/ionicons.min.css">
<!-- jvectormap -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/app-assets/bower_components/jvectormap/jquery-jvectormap.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/app-assets/dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/app-assets/dist/css/skins/_all-skins.min.css">

<!-- DataTables -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/app-assets/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">

<!-- Google Font -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">

</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<jsp:include
			page="${pageContext.request.contextPath}/../layout/head-nav-view.jsp" />


		<jsp:include
			page="${pageContext.request.contextPath}/../layout/menu-view.jsp" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">LISTADO DE ARTICULOS</section>

			<!-- Main content -->
			<section class="content">
				<div class="box box-primary">
					<!-- /.box-header -->
					<!-- form start -->
					<f:form id="frmListadoArticulo" role="form"
						action="${pageContext.request.contextPath}/articuloController/buscar">
						<!-- Begin Page Content -->
						<div class="container-fluid">
							<div class="card shadow mb-2">
								<div class="collapse show" id="collapseCardExample">
									<div class="card-body">
										<div class="row">
											</br>
											<div class="col-md-6 mb-2">
												<label for="nombreCompleto" class="label_control">NOMBRE
													ARTICULO </label>
												<div class="controls">
													<f:input type="text" class="form-control"
														required="required" id="txtnombre" path="nombre" />

												</div>
											</div>
											<div class="col-md-3 mb-1">
												<label for="lbltipoSeguroPaciente" class="label_control">TIPO</label>
												<div class="controls">
													<f:select id="cboTipoArticulo"
														path="tipoArticulo.idRegistro" class="form-control"
														required="required">
														<f:option value="" label="Seleccionar" selected="true"
															disabled="disabled" />
														<f:options items="${lstTipoArticulo}"
															itemValue="idRegistro" itemLabel="descripcionCorta" />
													</f:select>
												</div>
											</div>
											<div class="col-md-3 mb-1">
												<label for="lbltipoSeguroPaciente" class="label_control">CODIGO
													SISMED</label>
												<div class="controls">
													<f:input type="text" class="form-control"
														required="required" id="txtnombre" path="nombre" />
												</div>
											</div>
										</div> 
										<div class="row">
											<div class="form-group col-md-12 text-right"
												style="margin-top: 15px;">
												<button id="btnBuscar" class="btn btn-success" type="submit">
													<i class="fa fa-search"> </i> BUSCAR
												</button>
												<button
													onclick="limpiarForm();$('#dataTable').dataTable().fnClearTable();"
													type="button" class="btn btn-default">
													<i class="fa fa-eraser"></i> LIMPIAR
												</button>
												<a
													href="${pageContext.request.contextPath}/aticuloController/nuevo"
													class="btn btn-primary"> <i class="fa fa-file"></i> <span
													class="text"> NUEVO</span>
												</a>
											</div>
										</div>
</br>
									</div>
								</div>
							</div>

						 
								<!-- /.box-header -->
								<div class="box-body">
									<table id="example1" class="table table-bordered table-hover dataTable">
										<thead>
											<tr>
												<th>ITEM</th>
												<th>DESCRIPCION</th>
												<th>CONCENTRACION</th>
												<th>PRESENTACION</th>
												<th>COD SISMED</th>
												<th>ACCIONES</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="articulo" items="${lstArticulos}"
												varStatus="loop">
												<tr>
													<td>${loop.count}</td>
													<td>${articulo.nombre}</td>
													<td>${articulo.concentracion}</td>
													<td>${articulo.tipoPresentacion.descripcionLarga}</td>
													<td>${articulo.codigoSismed}</td>
													<td><a title="Modificar" data-placement="top"
														data-toggle="tooltip"
														class="btn bg-purple btn-sm"
														onclick="javascript:modificarElementoGenerico('/articuloController/modificar','${loop.index}')"
														href="#"><i class="fa fa-pencil"></i></a>

														<button type='button'
															class='btn btn-danger btn-sm'
															data-toggle='tooltip' data-placement='top'
															title='Eliminar'
															onclick="confirmar_eliminar(${loop.count});"
															data-original-title='Eliminar' id='agregarEspecialidad'>
															<i class='fa fa-trash'></i>
														</button></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<!-- /.box-body -->
							</div>

					</f:form>
				</div>
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

		<jsp:include
			page="${pageContext.request.contextPath}/../layout/footer-view.jsp" />
		<!-- Control Sidebar -->

		<!-- /.control-sidebar -->
		<!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
		<div class="control-sidebar-bg"></div>

	</div>
	<!-- ./wrapper -->

	<!-- jQuery 3 -->
	<script
		src="${pageContext.request.contextPath}/app-assets/bower_components/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap 3.3.7 -->
	<script
		src="${pageContext.request.contextPath}/app-assets/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- FastClick -->
	<script
		src="${pageContext.request.contextPath}/app-assets/bower_components/fastclick/lib/fastclick.js"></script>
	<!-- AdminLTE App -->
	<script
		src="${pageContext.request.contextPath}/app-assets/dist/js/adminlte.min.js"></script>
	<!-- Sparkline -->
	<script
		src="${pageContext.request.contextPath}/app-assets/bower_components/jquery-sparkline/dist/jquery.sparkline.min.js"></script>
	<!-- jvectormap  -->
	<script
		src="${pageContext.request.contextPath}/app-assets/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
	<!-- SlimScroll -->
	<script
		src="${pageContext.request.contextPath}/app-assets/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<!-- ChartJS -->
	<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
	<!-- AdminLTE for demo purposes -->
	<script
		src="${pageContext.request.contextPath}/app-assets/dist/js/demo.js"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<!-- FastClick -->
	<script
		src="${pageContext.request.contextPath}/app-assets/bower_components/fastclick/lib/fastclick.js"></script>

	<script>
  $(function () {
    $('#example1').DataTable()
    $('#example2').DataTable({
      'paging'      : true,
      'lengthChange': false,
      'searching'   : false,
      'ordering'    : true,
      'info'        : true,
      'autoWidth'   : false
    })
  })
</script>
</body>
</html>
