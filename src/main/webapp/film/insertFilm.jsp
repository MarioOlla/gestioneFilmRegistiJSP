<!doctype html>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="it.prova.gestionefilm.model.Film"%>
<%@page import="it.prova.gestionefilm.model.Regista"%>

<html lang="it" class="h-100" >
	 <head>
	 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="errorPage.jsp" %>
	 
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Inserisci Nuovo Film</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none':'' }" role="alert">
					  ${errorMessage}
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
					<div class="alert alert-danger alert-dismissible fade show d-none" role="alert">
					  Esempio di operazione fallita!
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
					<div class="alert alert-info alert-dismissible fade show d-none" role="alert">
					  Aggiungere d-none nelle class per non far apparire
					   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
			  
			  <div class='card'>
				    <div class='card-header'>
				        <h5>Inserisci nuovo Film</h5> 
				    </div>
				    <div class='card-body'>
		
							<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>
		
		
							<form method="post" action="ExecuteInsertProdottoServlet" class="row g-3" novalidate="novalidate">
							
								<% Film filmInPagina = (Film)request.getAttribute("insert_film_attr"); %>
							
								<div class="col-md-6">
									<label for="titolo" class="form-label">Titolo <span class="text-danger">*</span></label>
									<input type="text" name="titolo" id="titolo" class="form-control" placeholder="Inserire il titolo"  
										value="<%=filmInPagina.getTitolo()!=null?filmInPagina.getTitolo():""  %>" required>
								</div>
								
								<div class="col-md-6">
									<label for="genere" class="form-label">Genere <span class="text-danger">*</span></label>
									<input type="text" name="genere" id="genere" class="form-control" placeholder="Inserire il genere"  
										value="<%=filmInPagina.getGenere()!=null?filmInPagina.getGenere():""  %>" required>
								</div>
								
								<div class="col-md-3">
									<label for="dataPubblicazioneFilm" class="form-label">Data Pubblicazione Film<span class="text-danger">*</span></label>
									<input class="form-control"  name="dataPubblicazioneFilm" id="dataPubblicazioneFilm" type="date" placeholder="dd/MM/yy" title="formato : gg/mm/aaaa" 
										value="<%=filmInPagina.getDataPubblicazione()!=null? filmInPagina.getDataPubblicazione().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")):""  %>" required>
								</div>
							
								<div class="col-md-6">
									<label for="minutiDurata" class="form-label">Minuti Durata <span class="text-danger">*</span></label>
									<input type="number" class="form-control" name="minutiDurata" id="minutiDurata" placeholder="Inserire i minuti di durata" 
									value="<%=filmInPagina.getMinutiDurata()!=null?filmInPagina.getMinutiDurata():""  %>" required/>
								</div>
								
							<div class="col-12">
								<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
							</div>
		
						</form>
  
				    
				    
					<!-- end card-body -->			   
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