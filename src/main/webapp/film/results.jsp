<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="it.prova.gestionefilm.model.Film"%>
<%@page import="java.util.List"%>
<!doctype html>
<html lang="it" class="h-100" >
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="errorPage.jsp" %>

    <!-- Common imports in pages -->
    <jsp:include page="../header.jsp" />
    <title>Lista Film</title>
</head>
<body class="d-flex flex-column h-100">
    <!-- Fixed navbar -->
    <jsp:include page="../navbar.jsp"></jsp:include>
    <!-- Begin page content -->
    <main class="flex-shrink-0">
        <div class="container">
            <div class="alert alert-success alert-dismissible fade show ${successMessage==null?'d-none':'' }" role="alert">
                ${successMessage}
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
                    <h5>Lista dei Film</h5>
                </div>
                <div class='card-body'>
                    <a class="btn btn-primary " href="PrepareInsertFilmServlet">Add New</a>
                    <div class='table-responsive'>
                        <table class='table table-striped'>
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Titolo</th>
                                    <th>Genere</th>
                                    <th>Data di Pubblicazione</th>
                                    <th>Durata (minuti)</th>
                                    <th>Azioni</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% 
                                List<Film> listaFilm = (List<Film>) request.getAttribute("listFilmAttribute");
                                if (listaFilm != null) {
                                    for (Film item : listaFilm) {
                                %>
                                <tr>
                                    <td><%=item.getId() %></td>
                                    <td><%=item.getTitolo() %></td>
                                    <td><%=item.getGenere() %></td>
                                    <td><%=item.getDataPubblicazione()!=null? item.getDataPubblicazione().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")):"N.D."%></td>
                                    <td><%=item.getMinutiDurata() %></td>
                                    <td>
                                        <a class="btn btn-sm btn-outline-secondary" href="ExecuteReadFilmServlet?idFilm=<%=item.getId() %>">Visualizza</a>
                                        <a class="btn btn-sm btn-outline-primary ml-2 mr-2" href="PrepareUpdateFilmServlet?idFilm=<%=item.getId() %>">Edit</a>
                                        <a class="btn btn-outline-danger btn-sm" href="PrepareRemoveFilmServlet?idFilm=<%=item.getId() %>">Delete</a>
                                    </td>
                                </tr>
                                <% 
                                    }
                                } else {
                                %>
                                <tr>
                                    <td colspan="8">La lista dei Film è vuota o non è stata correttamente inizializzata.</td>
                                </tr>
                                <% 
                                }
                                %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <!-- Footer -->
    <jsp:include page="../footer.jsp" />
    <!-- Modal conferma delete -->
    <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="deleteModalLabel">Conferma Operazione</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    Continuare con l'operazione?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Annulla</button>
                    <button type="button" class="btn btn-primary">Continua</button>
                </div>
            </div>
        </div>
    </div>
    <!-- End Modal conferma delete -->
</body>
</html>
