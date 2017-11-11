package br.com.caelum.controller;

import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class QuantidadeServlet extends HttpServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, java.io.IOException {
		Connection connection = null;
		//connection = new ConnectionFactory().getConnection();
		
		//ContatoDao dataBaseContato = new ContatoDao(connection);

		int sizeContatos = 0 ;//dataBaseContato.getContatos(null).size();
		
		PrintWriter out = res.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<p>Quantidade de contatos:" + sizeContatos);

		out.println("</body>");
		out.println("</html>");

	}
}
