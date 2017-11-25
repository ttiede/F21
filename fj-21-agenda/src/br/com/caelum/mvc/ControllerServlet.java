package br.com.caelum.mvc;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/mvc")

public class ControllerServlet extends HttpServlet {
	@Override
	public void service(final ServletRequest req, final ServletResponse res)
			throws ServletException, java.io.IOException {
		final String opcode = req.getParameter("logica");
		final String nomeClasse = "br.com.caelum.logica." + opcode;

		final Class coringa;
		try {
			coringa = Class.forName(nomeClasse);
			final Logica objeto = (Logica) coringa.newInstance();
			final String at = objeto.executa(req, res);
			req.getRequestDispatcher(at).forward(req, res);
		} catch (Exception e) {
			throw new ServletException("Error:", e);
		}
	}
}