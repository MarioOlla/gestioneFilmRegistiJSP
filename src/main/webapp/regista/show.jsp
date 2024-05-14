<!doctype html>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="it.prova.gestionefilm.model.Regista"%>
<html lang="it" class="h-100">
	<head>
	
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="errorPage.jsp" %>
	
		
		<jsp:include page="../header.jsp" />
		
		<title>Visualizza Regista</title>
	</head>
	<body class="d-flex flex-column h-100">
	
		<jsp:include page="../navbar.jsp"></jsp:include>
		
		<main class="flex-shrink-0">
			  <div class="container">
			  	<h5>Visualizza dettaglio</h5>
			  	</div>
			  	<% Regista registaInPagina = (Regista)request.getAttribute("listaRegistaAttribute"); %>
			  <div class='card-body'>
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Nome:</dt>
							  <dd class="col-sm-9"><%=registaInPagina.getNome() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Cognome:</dt>
							  <dd class="col-sm-9"><%=registaInPagina.getCognome() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Nickname:</dt>
							  <dd class="col-sm-9"><%=registaInPagina.getNickname() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Data Di Nascita:</dt>
							  <dd class="col-sm-9"><%= registaInPagina.getDataDiNascita() != null ? registaInPagina.getDataDiNascita().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "N.D." %></dd>

					    	</dl>
					    	
					    </div>
					    
					    <div class='card-footer'>
					        <a href="ListRegistiServlet" class='btn btn-outline-secondary' style='width:80px'>
					            <i class='fa fa-chevron-left'></i> Back
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