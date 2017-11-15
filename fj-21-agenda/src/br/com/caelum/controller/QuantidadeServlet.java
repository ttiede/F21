package br.com.caelum.controller;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import br.com.caelum.Dao.ContatoDao;
import br.com.caelum.JDBC.ConnectionFactory;

@WebServlet("/oi")

public class QuantidadeServlet extends HttpServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, java.io.IOException {
		Connection connection = null;
		try {
			connection =  ConnectionFactory.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ContatoDao dataBaseContato = new ContatoDao(connection);

		int sizeContatos = dataBaseContato.getContatos(null).size();
		
		PrintWriter out = res.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<p>Quantidade de contatos:" + sizeContatos);

		out.println("</body>");
		out.println("</html>");

	}
}
