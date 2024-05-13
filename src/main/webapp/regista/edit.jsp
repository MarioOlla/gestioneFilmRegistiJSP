<!doctype html>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="it.prova.gestionefilm.model.Regista"%>
<html lang="it" class="h-100" >
	 <head>
	 
	 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="errorPage.jsp" %>
	 
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Modifica Regista</title>
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
				        <h5>Vuoi modificare questo Regista?</h5> 
				    </div>
				    <div class='card-body'>
		
							<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>
		
		
							<form method="post" action="ExecuteUpdateRegistaServlet" class="row g-3" novalidate="novalidate">
							
								<% Regista registaInPagina = (Regista)request.getAttribute("regista_da_modificare"); %>
							
								<div class="col-md-6">
									<label for="nome" class="form-label">Nome <span class="text-danger">*</span></label>
									<input type="text" name="nome" id="nome" class="form-control" placeholder="Inserire il nome"  
										value="<%=registaInPagina.getNome()!=null?registaInPagina.getNome():"" %>" required>
								</div>
								
								<div class="col-md-6">
									<label for="cognome" class="form-label">Cognome <span class="text-danger">*</span></label>
									<input type="text" name="cognome" id="cognome" class="form-control" placeholder="Inserire il cognome"  
										value="<%=registaInPagina.getCognome()!=null?registaInPagina.getCognome():"" %>" required>
								</div>
								
								<div class="col-md-6">
									<label for="nickname" class="form-label">Nickname <span class="text-danger">*</span></label>
									<input type="text" name="nickname" id="nickname" class="form-control" placeholder="Inserire il nickname"  
										value="<%=registaInPagina.getNickname()!=null?registaInPagina.getNickname():"" %>" required>
								</div>
							
								<div class="col-md-3">
									<label for="dataDiNascita" class="form-label">Data Di Nascita<span class="text-danger">*</span></label>
									<input class="form-control"  name="dataDiNascita" id="dataDiNascita" type="date" placeholder="dd/MM/yy" title="formato : gg/mm/aaaa" 
										value="<%=registaInPagina.getDataDiNascita()!=null? registaInPagina.getDataDiNascita().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")):""  %>" required/>
								</div>
								
																
							<div class="col-12">
								<a href="ListRegistiServlet" class='btn btn-outline-secondary' style='width:80px'>
					        	    <i class='fa fa-chevron-left'></i> Back
					       		 </a>
								<input type="hidden" name="idRegista" value="<%=registaInPagina.getId()%>">
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