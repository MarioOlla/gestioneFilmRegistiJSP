package it.prova.gestionefilm.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionefilm.model.Film;
import it.prova.gestionefilm.model.Regista;
import it.prova.gestionefilm.service.MyServiceFactory;

@WebServlet("/PrepareInsertFilmServlet")
public class PrepareInsertFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            List<Regista> listaRegisti = MyServiceFactory.getRegistaServiceInstance().readAll();
            request.setAttribute("listaRegisti", listaRegisti);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Attenzione: errore nel caricamento dei registi.");
        }
		request.setAttribute("insert_film_attr", new Film());
		request.getRequestDispatcher("/film/insert.jsp").forward(request, response); 
	}
}
