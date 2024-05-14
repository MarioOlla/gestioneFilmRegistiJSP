package it.prova.gestionefilm.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionefilm.model.Regista;
import it.prova.gestionefilm.service.MyServiceFactory;
import it.prova.gestionefilm.utility.UtilityRegistaForm;

@WebServlet("/ExecuteInsertRegistaServlet")
public class ExecuteInsertRegistaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String nomeInputParam = request.getParameter("nome");
			String cognomeInputParam = request.getParameter("cognome");
			String nicknameInputParam = request.getParameter("nickname");
			String dataDiNascitaInputParam = request.getParameter("dataDiNascita");
			
			Regista registaInstance = UtilityRegistaForm.createRegistaFromParams(nomeInputParam, cognomeInputParam, nicknameInputParam, dataDiNascitaInputParam);
			
			if (!UtilityRegistaForm.validateRegistaBean(registaInstance)) {
				request.setAttribute("insert_regista_attr", registaInstance);
				request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione.");
				request.getRequestDispatcher("/regista/insert.jsp").forward(request, response);
				return;
			}
			
			try {
				MyServiceFactory.getRegistaServiceInstance().create(registaInstance); 
				request.setAttribute("listaRegistaAttribute", MyServiceFactory.getRegistaServiceInstance().readAll()); 
				request.setAttribute("successMessage", "Operazione effettuata con successo");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
				request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
				return;
			}
			request.getRequestDispatcher("/regista/results.jsp").forward(request, response); 
		}
}
