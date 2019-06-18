<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
				<c:forEach var="postulante" items="${lstPostulanteEstadoFisicoBean}"
					varStatus="loop">
					<tr>
						<td>${postulante.codigo}</td>
						<c:choose>
							<c:when
								test="${postulante.estadoFisicoBean.resultadoSerologia == 'REACTIVO'}">
								<td class="estilo_reactivo">${postulante.estadoFisicoBean.resultadoSerologia}</td>
							</c:when> 
							<c:when
								test="${postulante.estadoFisicoBean.resultadoSerologia == 'NO REACTIVO'}">
								<td class="estilo_noReactivo">${postulante.estadoFisicoBean.resultadoSerologia}</td>
							</c:when> 
							<c:otherwise>
								<td>${postulante.estadoFisicoBean.resultadoSerologia}</td>
							</c:otherwise>
						</c:choose> 
						<td><fmt:formatDate pattern="dd/MM/yyyy"
								value="${postulante.estadoFisicoBean.fechaEvaluacion}" /></td>
						<td>${postulante.estadoFisicoBean.htco}</td>
						<td>${postulante.estadoFisicoBean.grupoSanguineo.nombreCorto}${postulante.estadoFisicoBean.factor.nombreCorto}</td>
						<td>${postulante.tipoPostulate.nombreCorto}</td>
						<td>${postulante.tipoParentescoPaciente.nombreCorto}</td>
						<td></td>
						<td>${postulante.estadoFisicoBean.observacion}</td>
						<td></td>
						<td></td>  
					</tr>
				</c:forEach> 