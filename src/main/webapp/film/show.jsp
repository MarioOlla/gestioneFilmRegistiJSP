<!doctype html>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="it.prova.gestionefilm.model.Film"%>
<html lang="it" class="h-100">
<head>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="errorPage.jsp"%>

<jsp:include page="../header.jsp" />

<title>Visualizza Film</title>
</head>
<body class="d-flex flex-column h-100">

	<jsp:include page="../navbar.jsp"></jsp:include>

	<main class="flex-shrink-0">
		<div class="container">
			<h5>Visualizza dettaglio</h5>
		</div>
		<%
            Film filmInPagina = (Film) request.getAttribute("visualizza_film_attr");
        %>
		<div class='card-body'>
			<dl class="row">
				<dt class="col-sm-3 text-right">Titolo:</dt>
				<dd class="col-sm-9"><%= filmInPagina.getTitolo() %></dd>
			</dl>

			<dl class="row">
				<dt class="col-sm-3 text-right">Genere:</dt>
				<dd class="col-sm-9"><%= filmInPagina.getGenere() %></dd>
			</dl>

			<dl class="row">
				<dt class="col-sm-3 text-right">Data di Pubblicazione:</dt>
				<dd class="col-sm-9"><%= filmInPagina.getDataPubblicazione() != null ? filmInPagina.getDataPubblicazione().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "N.D." %></dd>
			</dl>

			<dl class="row">
				<dt class="col-sm-3 text-right">Minuti Durata:</dt>
				<dd class="col-sm-9"><%= filmInPagina.getMinutiDurata() %></dd>
			</dl>

		</div>

		<div class='card-footer'>
			<a href="ListFilmServlet" class='btn btn-outline-secondary'
				style='width: 80px'> <i class='fa fa-chevron-left'></i> Back
			</a>
		</div>
		<!-- end card -->
		</div>

		<!-- end container -->
		</div>

	</main>

	<!-- Footer -->
	<jsp:include page="../footer.jsp" />
</body>
</html>
