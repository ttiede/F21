package br.com.caelum.servlet;

import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import br.com.caelum.dao.ContatoDAO;
import br.com.caelum.vo.ContatoVO;

@WebServlet("/listContatos")

public class ListContatosServlet extends HttpServlet {
	@Override
	public void service(final ServletRequest req, final ServletResponse res)
			throws ServletException, java.io.IOException {
		final ContatoDAO dataBaseContato = new ContatoDAO((Connection) req.getAttribute("connection"));

		final List<ContatoVO> contatoVOs = dataBaseContato.getContatos(null);
		System.out.println(contatoVOs);
		req.setAttribute("contatoVOs", contatoVOs);
		
		req.getRequestDispatcher("/jsp/contato/listContato.jsp").forward(req, res);
	}
}
