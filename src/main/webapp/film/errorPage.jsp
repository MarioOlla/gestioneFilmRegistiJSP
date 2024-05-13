<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
<head>	 
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Oops...</title>
	 </head>
<body>

<div class="container">
    <div class="jumbotron">
        <h1 class="display-4">Errore</h1>
        <p class="lead">Si è verificato un errore durante l'esecuzione della richiesta.</p>
        <hr class="my-4">
        <div class="col-12">
    <form action="index.jsp" method="post">
        <button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Ritorna alla Pagina Iniziale</button>
    </form>
</div>

		
    </div>
</div>

</body>
</html>