package it.prova.gestionefilm.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionefilm.service.MyServiceFactory;

@WebServlet("/ExecuteRemoveRegistaServlet")
public class ExecuteRemoveRegistaServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String parametroIdRegistaToRemove = request.getParameter("idRegista");
		Long idRegistaToRemove = Long.parseLong(parametroIdRegistaToRemove);

		if (!NumberUtils.isCreatable(parametroIdRegistaToRemove)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		try {
			MyServiceFactory.getRegistaServiceInstance().delete(idRegistaToRemove);
			request.setAttribute("listaRegistaAttribute", MyServiceFactory.getRegistaServiceInstance().readAll());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/regista/results.jsp").forward(request, response);
	}
}
