package it.prova.gestionefilm.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionefilm.service.MyServiceFactory;

@WebServlet("/PrepareRemoveFilmServlet")
public class PrepareRemoveFilmServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String parametroIdFilmToRemove = request.getParameter("idFilm");

		if (!NumberUtils.isCreatable(parametroIdFilmToRemove)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		try {
			request.setAttribute("visualizza_film_attr",
					MyServiceFactory.getFilmServiceInstance().read(Long.parseLong(parametroIdFilmToRemove)));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/film/delete.jsp").forward(request, response);
	}

}
