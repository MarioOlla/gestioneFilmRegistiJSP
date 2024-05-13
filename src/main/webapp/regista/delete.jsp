<!doctype html>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="it.prova.gestionefilm.model.Regista"%>
<html lang="it" class="h-100" >
	 <head>
	 
	 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="errorPage.jsp" %>
	 
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Elimina Prodotto</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class='card'>
					    <div class='card-header'>
					        <h5>Vuoi eliminare questo regista?</h5>
					    </div>
					     <% Regista registaInPagina = (Regista)request.getAttribute("visualizza_regista_attr"); %>
					    
					
					    <div class='card-body'>
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Nome</dt>
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
							  <dd class="col-sm-9"><%=registaInPagina.getDataDiNascita()!=null? registaInPagina.getDataDiNascita().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")):"N.D."  %></dd>
					    	</dl>
					    	
					    </div>
					    
					    <div class='card-footer'>
					        
					        <form action="ExecuteRemoveRegistaServlet" method="post">
					       		 <a href="ListRegistiServlet" class='btn btn-outline-secondary' style='width:80px'>
					        	    <i class='fa fa-chevron-left'></i> Back
					       		 </a>
					       		 <input type="hidden" name="idRegista" value="<%=registaInPagina.getId()%>">
					        	<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
					        	
					        </form>
					        
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