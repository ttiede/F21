package br.com.caelum.logica;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.mysql.jdbc.Connection;

import br.com.caelum.dao.ContatoDAO;
import br.com.caelum.mvc.Logica;

public class RemoveContatoLogic implements Logica {
	
	@Override
	public String executa(ServletRequest req, ServletResponse res) throws Exception {
		long id = Long.parseLong(req.getParameter("id"));
		final ContatoDAO dao = new ContatoDAO((Connection) req.getAttribute("connection"));
		if( dao.getById((int) id) != null ){
			dao.deleteById(id);
			return "mvc?logica=ListContatoLogic";
		}
		return null;
	}

}
