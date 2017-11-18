package br.com.caelum.servlet;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import br.com.caelum.dao.ContatoDAO;

@WebServlet("/oi")

public class QuantidadeServlet extends HttpServlet {
	@Override
	public void service(final ServletRequest req, final ServletResponse res)
			throws ServletException, java.io.IOException {
		final Integer sizeContatos;
		final ContatoDAO dataBaseContato = new ContatoDAO();
		sizeContatos = dataBaseContato.getContatos(null).size();

		final PrintWriter out = res.getWriter();

		out.println("<html>");
		out.println("<body>");
		out.println("<p>Quantidade de contatos:" + sizeContatos);

		out.println("</body>");
		out.println("</html>");

	}
}
