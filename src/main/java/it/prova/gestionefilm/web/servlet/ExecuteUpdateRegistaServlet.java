package it.prova.gestionefilm.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionefilm.model.Regista;
import it.prova.gestionefilm.service.MyServiceFactory;
import it.prova.gestionefilm.utility.UtilityRegistaForm;

@WebServlet("/ExecuteUpdateRegistaServlet")
public class ExecuteUpdateRegistaServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nomeInputParam = request.getParameter("nome");
		String cognomeInputParam = request.getParameter("cognome");
		String nicknameInputParam = request.getParameter("nickname");
		String dataDiNascitaInputParam = request.getParameter("data_nascita");
		String updateDateTimeInputParam = request.getParameter("data_aggiornamento");

		Regista registaInstance = UtilityRegistaForm.updateRegistaFromParams(nomeInputParam, cognomeInputParam,
				nicknameInputParam, dataDiNascitaInputParam, updateDateTimeInputParam);

		if (!UtilityRegistaForm.validateRegistaBean(registaInstance)) {
			request.setAttribute("update_regista_attr", registaInstance);
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione.");
			request.getRequestDispatcher("/regista/update.jsp").forward(request, response);
			return;
		}
		try {
			MyServiceFactory.getRegistaServiceInstance().update(registaInstance);
			request.setAttribute("listaRegistaAttribute", MyServiceFactory.getRegistaServiceInstance().readAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/regista/results.jsp").forward(request, response);
	}
}
