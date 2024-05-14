package it.prova.gestionefilm.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionefilm.model.Film;
import it.prova.gestionefilm.service.MyServiceFactory;
import it.prova.gestionefilm.utility.UtilityFilmForm;

@WebServlet("/ExecuteUpdateFilmServlet")
public class ExecuteUpdateFilmServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String titoloInputParam = request.getParameter("titolo");
		String genereInputParam = request.getParameter("genere");
		String dataPubblicazioneInputParam = request.getParameter("dataPubblicazione");
		String minutiDurataInputParam = request.getParameter("minutiDurata");
		String idFilmParam = request.getParameter("idFilm");

		Film filmInstance = UtilityFilmForm.updateFilmFromParams(idFilmParam,titoloInputParam, genereInputParam,
				dataPubblicazioneInputParam, minutiDurataInputParam);

		if (!UtilityFilmForm.validateFilmBean(filmInstance)) {
			request.setAttribute("filmDaInviareAPaginaEdit", filmInstance);
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione.");
			request.getRequestDispatcher("/film/edit.jsp").forward(request, response);
			return;
		}
		try {
			MyServiceFactory.getFilmServiceInstance().update(filmInstance); 
			request.setAttribute("listFilmAttribute", MyServiceFactory.getFilmServiceInstance().readAll()); 
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/film/results.jsp").forward(request, response);
	}
}
