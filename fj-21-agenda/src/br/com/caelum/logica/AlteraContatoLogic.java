package br.com.caelum.logica;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.mysql.jdbc.Connection;

import br.com.caelum.dao.ContatoDAO;
import br.com.caelum.mvc.Logica;
import br.com.caelum.vo.ContatoVO;

public class AlteraContatoLogic implements Logica {
	
	@Override
	public String executa(ServletRequest req, ServletResponse res) throws Exception {
		long id = Long.parseLong(req.getParameter("id"));
		final ContatoDAO dao = new ContatoDAO((Connection) req.getAttribute("connection"));
		List<ContatoVO> contatos = dao.getById((int) id);
		if( contatos.size() > 0 ){
			req.setAttribute("contatoVO", contatos.get(0));
			return "jsp/contato/alteraContato.jsp";
		}
		return null;
	}

}
