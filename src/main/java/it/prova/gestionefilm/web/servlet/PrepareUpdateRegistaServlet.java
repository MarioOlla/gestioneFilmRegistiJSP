package it.prova.gestionefilm.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionefilm.service.MyServiceFactory;

@WebServlet("/PrepareUpdateRegistaServlet")
public class PrepareUpdateRegistaServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String parametroIdRegistaToUpdate = request.getParameter("idRegista");
		Long idRegistaToUpdate = Long.parseLong(parametroIdRegistaToUpdate);

		if (!NumberUtils.isCreatable(parametroIdRegistaToUpdate)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
			return;
		}

		try {
			request.setAttribute("update_regista_attr",
					MyServiceFactory.getRegistaServiceInstance().read(idRegistaToUpdate));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/regista/edit.jsp").forward(request, response);
	}
}
