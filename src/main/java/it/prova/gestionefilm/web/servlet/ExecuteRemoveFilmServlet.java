package it.prova.gestionefilm.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionefilm.service.MyServiceFactory;

@WebServlet("/ExecuteRemoveFilmServlet")
public class ExecuteRemoveFilmServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String parametroIdFilmToRemove = request.getParameter("idFilm");
		Long idFilmToRemove = Long.parseLong(parametroIdFilmToRemove);

		if (!NumberUtils.isCreatable(parametroIdFilmToRemove)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		try {
			MyServiceFactory.getFilmServiceInstance().delete(idFilmToRemove);
			request.setAttribute("listaFilmAttribute", MyServiceFactory.getFilmServiceInstance().readAll());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/film/results.jsp").forward(request, response);
	}
}
