package it.prova.gestionefilm.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionefilm.service.MyServiceFactory;

@WebServlet("/PrepareRemoveRegistaServlet")
public class PrepareRemoveRegistaServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String parametroIdRegistaToRemove = request.getParameter("idRegista");

		if (!NumberUtils.isCreatable(parametroIdRegistaToRemove)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		try {
			request.setAttribute("regista_to_remove",
					MyServiceFactory.getRegistaServiceInstance().read(Long.parseLong(parametroIdRegistaToRemove)));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}