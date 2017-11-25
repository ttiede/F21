package br.com.caelum.servlet;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import br.com.caelum.dao.ContatoDAO;
import br.com.caelum.util.DateUtil;
import br.com.caelum.vo.ContatoVO;

@WebServlet("/adicionaContato2")

public class AdicionaContatoServlet extends HttpServlet {
	@Override
	public void service(final ServletRequest req, final ServletResponse res)
			throws ServletException, java.io.IOException {
		final ContatoDAO dataBaseContato = new ContatoDAO((Connection) req.getAttribute("connection"));

		final ContatoVO contatoVO = buildContatoVO(req);

		dataBaseContato.insert(contatoVO);
		RequestDispatcher rd = req.getRequestDispatcher("/jsp/contato/contato-adicionado.jsp");
		rd.forward(req, res);
	}

	private ContatoVO buildContatoVO(final ServletRequest req) {
		final ContatoVO contatoVO = new ContatoVO();

		contatoVO.setNome(req.getParameter("nome"));
		contatoVO.setEmail(req.getParameter("email"));
		contatoVO.setEndereco(req.getParameter("endereco"));
		contatoVO.setDataNascimento(DateUtil.stringToDate(req.getParameter("dataNascimento")));
		return contatoVO;
	}
}
