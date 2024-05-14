<!doctype html>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="it.prova.gestionefilm.model.Film"%>
<%@page import="it.prova.gestionefilm.model.Regista"%>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Elimina Elemento</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class='card'>
					    <div class='card-header'>
					        <h5>Vuoi eliminare questo film?</h5>
					    </div>
					     <% Film filmInPagina = (Film)request.getAttribute("visualizza_film_attr"); %>
					    
					
					    <div class='card-body'>
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Titolo:</dt>
							  <dd class="col-sm-9"><%=filmInPagina.getTitolo() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Genere:</dt>
							  <dd class="col-sm-9"><%=filmInPagina.getGenere() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Minuti Durata:</dt>
							  <dd class="col-sm-9"><%=filmInPagina.getMinutiDurata() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Data Pubblicazione Film:</dt>
							  <dd class="col-sm-9"><%=filmInPagina.getDataPubblicazione()!=null? filmInPagina.getDataPubblicazione().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")):"N.D."  %></dd>
					    	</dl>
					    	
					    </div>
					    
					    <div class='card-footer'>
					        
					        <form action="ExecuteDeleteFilmServlet" method="post">
					       		 <a href="ListFilmServlet" class='btn btn-outline-secondary' style='width:80px'>
					        	    <i class='fa fa-chevron-left'></i> Back
					       		 </a>
					       		 <input type="hidden" name="idFilmToRemove" value="<%=filmInPagina.getId()%>">
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