package br.com.caelum.servlet;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import br.com.caelum.dao.ContatoDAO;
import br.com.caelum.util.DateUtil;
import br.com.caelum.vo.ContatoVO;

@WebServlet("/adicionaContato")

public class AdicionaServlet extends HttpServlet {
	@Override
	public void service(final ServletRequest req, final ServletResponse res)
			throws ServletException, java.io.IOException {
		final ContatoDAO dataBaseContato = new ContatoDAO();

		final ContatoVO contatoVO = buildContatoVO(req);

		dataBaseContato.insert(contatoVO);

		final PrintWriter out = res.getWriter();

		out.println("<html>");
		out.println("<body>");
		out.println(String.format("contato:<br>nome %s<br> email: %s<br> endereçco: %s<br> data de nascimento: %s",
				contatoVO.getNome(), contatoVO.getEmail(), contatoVO.getEndereco(),
				DateUtil.dateFormatDayMonthYear(contatoVO.getDataNascimento())));
		out.println("<p> Adicionado com sucesso");

		out.println("</body>");
		out.println("</html>");

	}

	private ContatoVO buildContatoVO(final ServletRequest req) {
		final ContatoVO contatoVO = new ContatoVO();

		contatoVO.setNome(req.getParameter("nome"));
		contatoVO.setEmail(req.getParameter("email"));
		contatoVO.setEndereco(req.getParameter("endereco"));
		contatoVO.setDataNascimento(DateUtil.stringToDate(req.getParameter("dataDeNascimento")));
		return contatoVO;
	}
}
