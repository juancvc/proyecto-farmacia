<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Farmacia</title>

<!-- Custom fonts for this template-->
<link
	href="${pageContext.request.contextPath}/app-assets/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link
	href="${pageContext.request.contextPath}/app-assets/css/sb-admin-2.min.css"
	rel="stylesheet">

</head>

<style>
.tipo4 {
	color: #A9E2F3
}

.tipo5 {
	color: #F3E2A9
}
</style>
<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<jsp:include
			page="${pageContext.request.contextPath}/../layout/menu-view.jsp" />

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<jsp:include
					page="${pageContext.request.contextPath}/../layout/head-nav-view.jsp" />
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-2">
						<h1 class="h4 mb-0 text-gray-800">Dashboard</h1>
						<!-- <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
            <i class="fas fa-download fa-sm text-white-50"></i> Generate Report</a> -->

					</div>

					<!-- Content Row -->
					<div class="row">

						<div class="col-xl-4 col-md-6 mb-2">
							<div class="card border-left-success shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="text-xs font-weight-bold text-success text-uppercase mb-1">VENTAS</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800">${totalVenta}</div>
										</div>
										<div class="col-auto">
											<i class="fas fa-money fa-2x text-gray-300"></i>
										</div>
									</div>
								</div>
							</div>
						</div>


						<!-- Earnings (Monthly) Card Example -->
						<div class="col-xl-4 col-md-6 mb-2">
							<div class="card border-left-danger shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="text-xs font-weight-bold text-danger text-uppercase mb-1">VENTAS
												ANULADAS</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800">${totalVentaAnulado}</div>
										</div>
										<div class="col-auto">
											<i class="fas fa-times-circle fa-2x text-gray-300"></i>
										</div>
									</div>
								</div>
							</div>
						</div>

						<!-- Earnings (Monthly) Card Example 
            <div class="col-xl-3 col-md-6 mb-4">
              <div class="card border-left-info shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-info text-uppercase mb-1">Tasks</div>
                      <div class="row no-gutters align-items-center">
                        <div class="col-auto">
                          <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">50%</div>
                        </div>
                        <div class="col">
                          <div class="progress progress-sm mr-2">
                            <div class="progress-bar bg-info" role="progressbar" style="width: 50%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>
-->
						<!-- Pending Requests Card Example -->
						<div class="col-xl-4 col-md-6 mb-2">
							<div class="card border-left-warning shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="text-xs font-weight-bold text-warning text-uppercase mb-1">COMPRAS</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800">${totalCompra}</div>
										</div>
										<div class="col-auto">
											<i class="fas fa-shopping-cart fa-2x text-gray-300"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<!-- Content Row -->

					<div class="row">

						<!-- Area Chart -->
						<div class="col-xl-8 col-lg-7">
							<div class="card shadow mb-2">
								<!-- Card Header - Dropdown -->
								<div
									class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
									<h6 class="m-0 font-weight-bold text-primary">Resumen de
										ventas</h6>
									<div class="dropdown no-arrow">
										<a class="dropdown-toggle" href="#" role="button"
											id="dropdownMenuLink" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="false"> <i
											class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
										</a>
										<!--<div class="dropdown-menu dropdown-menu-right shadow animated--fade-in" aria-labelledby="dropdownMenuLink">
                      <div class="dropdown-header">Dropdown Header:</div>
                      <a class="dropdown-item" href="#">Action</a>
                      <a class="dropdown-item" href="#">Another action</a>
                      <div class="dropdown-divider"></div>
                      <a class="dropdown-item" href="#">Something else here</a>
                    </div>-->
									</div>
								</div>
								<!-- Card Body -->
								<div class="card-body">
									<div class="chart-area">
										<canvas id="myAreaChart"></canvas>
									</div>
								</div>
							</div>
						</div>

						<!-- Pie Chart -->
						<div class="col-xl-4 col-lg-5">
							<div class="card shadow mb-2">
								<!-- Card Header - Dropdown -->
								<div
									class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
									<h6 class="m-0 font-weight-bold text-primary">Por tipo
										paciente</h6>
									<div class="dropdown no-arrow">
										<a class="dropdown-toggle" href="#" role="button"
											id="dropdownMenuLink" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="false"> <i
											class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
										</a>
										<!-- Pie Chart <div class="dropdown-menu dropdown-menu-right shadow animated--fade-in" aria-labelledby="dropdownMenuLink">
                      <div class="dropdown-header">Dropdown Header:</div>
                      <a class="dropdown-item" href="#">Action</a>
                      <a class="dropdown-item" href="#">Another action</a>
                      <div class="dropdown-divider"></div>
                      <a class="dropdown-item" href="#">Something else here</a>
                    </div>-->
									</div>
								</div>
								<!-- Card Body -->
								<div class="card-body">
									<div class="chart-pie pt-4 pb-2">
										<canvas id="myPieChart"></canvas>
									</div>
									<div class="mt-4 text-center small">
										<c:forEach var="venta" items="${lstVentasTipoPacienteMes}"
											varStatus="loop">
											<c:choose>
												<c:when test="${loop.index==0}">
													<span class="mr-2"> <i
														class="fas fa-circle text-primary"></i>${venta.tipoFinanciador.descripcionCorta}
													</span>
												</c:when>
												<c:when test="${loop.index==1}">
													<span class="mr-2"> <i
														class="fas fa-circle text-success"></i>${venta.tipoFinanciador.descripcionCorta}
													</span>
												</c:when>
												<c:when test="${loop.index==2}">
													<span class="mr-2"> <i
														class="fas fa-circle text-info"></i>${venta.tipoFinanciador.descripcionCorta}
													</span>
												</c:when>
												<c:when test="${loop.index==3}">
													<span class="mr-2"> <i class="fas fa-circle tipo4"></i>${venta.tipoFinanciador.descripcionCorta}
													</span>
												</c:when>
												<c:when test="${loop.index==4}">
													<span class="mr-2"> <i class="fas fa-circle tipo5"></i>${venta.tipoFinanciador.descripcionCorta}
													</span>
												</c:when>
											</c:choose>
										</c:forEach>
									</div>
								</div>
							</div>
						</div>
					</div>

					<!-- Content Row -->
					<div class="row">

						<!-- Content Column -->
						<div class="col-lg-6 mb-4">

							<!-- Project Card Example -->
							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h6 class="m-0 font-weight-bold text-primary">Productos
										con menos Stock</h6>
								</div>
								<div class="card-body">

									<c:forEach var="articulo" items="${lstArticulosStockAlerta}"
										varStatus="loop">
										<c:choose>
											<c:when test="${articulo.stockAlerta < 21}">
												<h4 class="small font-weight-bold">${articulo.nombre}
													<span class="float-right">${articulo.stockAlerta}%</span>
												</h4>
												<div class="progress mb-4">
													<div class="progress-bar bg-danger" role="progressbar"
														style="width: ${articulo.stockAlerta}%" aria-valuenow="20"
														aria-valuemin="0" aria-valuemax="100"></div>
												</div>
											</c:when>
											<c:when
												test="${articulo.stockAlerta > 21 and articulo.stockAlerta < 61}">
												<h4 class="small font-weight-bold">${articulo.nombre}
													<span class="float-right">${articulo.stockAlerta}%</span>
												</h4>
												<div class="progress mb-4">
													<div class="progress-bar bg-warning" role="progressbar"
														style="width: ${articulo.stockAlerta}%" aria-valuenow="40"
														aria-valuemin="0" aria-valuemax="100"></div>
												</div>
											</c:when>
											<c:when
												test="${articulo.stockAlerta > 61 and articulo.stockAlerta < 81}">
												<h4 class="small font-weight-bold">${articulo.nombre}
													<span class="float-right">${articulo.stockAlerta}%</span>
												</h4>
												<div class="progress mb-4">
													<div class="progress-bar" role="progressbar"
														style="width: ${articulo.stockAlerta}%" aria-valuenow="60"
														aria-valuemin="0" aria-valuemax="100"></div>
												</div>
											</c:when>
											<c:when
												test="${articulo.stockAlerta > 81 and articulo.stockAlerta < 99}">
												<h4 class="small font-weight-bold">${articulo.nombre}
													<span class="float-right">${articulo.stockAlerta}%</span>
												</h4>
												<div class="progress mb-4">
													<div class="progress-bar bg-info" role="progressbar"
														style="width: ${articulo.stockAlerta}%" aria-valuenow="80"
														aria-valuemin="0" aria-valuemax="100"></div>
												</div>
											</c:when>
											<c:when test="${articulo.stockAlerta == 100}">
												<h4 class="small font-weight-bold">${articulo.nombre}
													<span class="float-right">${articulo.stockAlerta}%</span>
												</h4>
												<div class="progress mb-4">
													<div class="progress-bar bg-success" role="progressbar"
														style="width: ${articulo.stockAlerta}%"
														aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"></div>
												</div>
											</c:when>
										</c:choose>
									</c:forEach>
								</div>
							</div>

							<!-- Color System
              <div class="row">
                <div class="col-lg-6 mb-4">
                  <div class="card bg-primary text-white shadow">
                    <div class="card-body">
                      Primary
                      <div class="text-white-50 small">#4e73df</div>
                    </div>
                  </div>
                </div>
                <div class="col-lg-6 mb-4">
                  <div class="card bg-success text-white shadow">
                    <div class="card-body">
                      Success
                      <div class="text-white-50 small">#1cc88a</div>
                    </div>
                  </div>
                </div>
                <div class="col-lg-6 mb-4">
                  <div class="card bg-info text-white shadow">
                    <div class="card-body">
                      Info
                      <div class="text-white-50 small">#36b9cc</div>
                    </div>
                  </div>
                </div>
                <div class="col-lg-6 mb-4">
                  <div class="card bg-warning text-white shadow">
                    <div class="card-body">
                      Warning
                      <div class="text-white-50 small">#f6c23e</div>
                    </div>
                  </div>
                </div>
                <div class="col-lg-6 mb-4">
                  <div class="card bg-danger text-white shadow">
                    <div class="card-body">
                      Danger
                      <div class="text-white-50 small">#e74a3b</div>
                    </div>
                  </div>
                </div>
                <div class="col-lg-6 mb-4">
                  <div class="card bg-secondary text-white shadow">
                    <div class="card-body">
                      Secondary
                      <div class="text-white-50 small">#858796</div>
                    </div>
                  </div>
                </div>
              </div>

            </div>
 -->
						</div>
						<div class="col-lg-6 mb-4">
							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h6 class="m-0 font-weight-bold text-primary">Productos
										próximos a vencer</h6>
								</div>
								<div class="card-body">
									<div class="table-responsive">
										<table class="table table-bordered table-hover table-striped">
											<thead>
												<tr> 
													<th>Artículo</th>
													<th>Lote</th>
													<th>Fecha Vencimiento</th>
													<th>Días a vencer</th>
												</tr>
											</thead>
											<tbody>
											<c:forEach var="stock" items="${lstStockVencimiento}"
											varStatus="loop">
												<tr>
													<td>${stock.articulo.nombre}</td>
													<td>${stock.lote}</td>
													<td><fmt:formatDate pattern="dd/MM/yyyy"
														value="${stock.fechaVencimiento}" /></td>
													<td>${stock.diasVencimiento}</td>
												</tr> 
											</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
							<!-- Illustrations 
              <div class="card shadow mb-4">
                <div class="card-header py-3">
                  <h6 class="m-0 font-weight-bold text-primary">Illustrations</h6>
                </div>
                <div class="card-body">
                  <div class="text-center">
                    <img class="img-fluid px-3 px-sm-4 mt-3 mb-4" style="width: 25rem;" src="img/undraw_posting_photo.svg" alt="">
                  </div>
                  <p>Add some quality, svg illustrations to your project courtesy of <a target="_blank" rel="nofollow" href="https://undraw.co/">unDraw</a>, a constantly updated collection of beautiful svg images that you can use completely free and without attribution!</p>
                  <a target="_blank" rel="nofollow" href="https://undraw.co/">Browse Illustrations on unDraw &rarr;</a>
                </div>
              </div>
-->
							<!-- Approach 
              <div class="card shadow mb-4">
                <div class="card-header py-3">
                  <h6 class="m-0 font-weight-bold text-primary">Development Approach</h6>
                </div>
                <div class="card-body">
                  <p>SB Admin 2 makes extensive use of Bootstrap 4 utility classes in order to reduce CSS bloat and poor page performance. Custom CSS classes are used to create custom components and custom utility classes.</p>
                  <p class="mb-0">Before working with this theme, you should become familiar with the Bootstrap framework, especially the utility classes.</p>
                </div>
              </div>
-->
						</div>


					</div>
					<!-- /.container-fluid -->

				</div>
				<!-- End of Main Content -->

				<!-- Footer -->

				<jsp:include
					page="${pageContext.request.contextPath}/../layout/footer-view.jsp" />



				<!-- End of Footer -->

			</div>
			<!-- End of Content Wrapper -->

		</div>
		<!-- End of Page Wrapper -->

		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top"> <i
			class="fas fa-angle-up"></i>
		</a>

		<!-- Logout Modal-->
		<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Ready to
							Leave?</h5>
						<button class="close" type="button" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">Ã</span>
						</button>
					</div>
					<div class="modal-body">Select "Logout" below if you are
						ready to end your current session.</div>
					<div class="modal-footer">
						<button class="btn btn-secondary" type="button"
							data-dismiss="modal">Cancel</button>
						<a class="btn btn-primary" href="login.html">Logout</a>
					</div>
				</div>
			</div>
		</div>

		<!-- Bootstrap core JavaScript-->
		<script
			src="${pageContext.request.contextPath}/app-assets/vendor/jquery/jquery.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/app-assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

		<!-- Core plugin JavaScript-->
		<script
			src="${pageContext.request.contextPath}/app-assets/vendor/jquery-easing/jquery.easing.min.js"></script>

		<!-- Custom scripts for all pages-->
		<script
			src="${pageContext.request.contextPath}/app-assets/js/sb-admin-2.min.js"></script>

		<!-- Page level plugins -->
		<script
			src="${pageContext.request.contextPath}/app-assets/vendor/chart.js/Chart.min.js"></script>

		<!-- Page level custom scripts -->
		<script
			src="${pageContext.request.contextPath}/app-assets/js/demo/chart-area-demo.js"></script>
		<script
			src="${pageContext.request.contextPath}/app-assets/js/demo/chart-pie-demo.js"></script>
</body>
<script type="text/javascript">
	var arrayVenta = [];
	var arrayVentaTipoPacinente = [];
	$(document)
			.ready(
					function() {

						<c:forEach var="venta" items="${lstVentasMes}"
			varStatus="loop">
						console.log('${venta.mes}');

						var objVenta = {
							mes : 0,
							importe : 0
						};
						objVenta.mes = '${venta.mes}';
						objVenta.importe = '${venta.importe}';
						arrayVenta.push(objVenta);
						</c:forEach>

						area(arrayVenta);

						<c:forEach var="venta" items="${lstVentasTipoPacienteMes}"
			varStatus="loop">
						console.log('${venta.mes}');

						var objVentaTipoPaciente = {
							mes : 0,
							importe : 0
						};
						objVentaTipoPaciente.tipoPaciente = '${venta.tipoFinanciador.descripcionCorta}';
						objVentaTipoPaciente.cantidadItems = '${venta.cantidadItems}';
						arrayVentaTipoPacinente.push(objVentaTipoPaciente);
						</c:forEach>

						pie(arrayVentaTipoPacinente);

						//init();
					});
</script>
</html>
