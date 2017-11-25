package br.com.caelum.logica;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import br.com.caelum.dao.ContatoDAO;
import br.com.caelum.mvc.Logica;
import br.com.caelum.vo.ContatoVO;

public class ListContatoLogic implements Logica {
	
	@Override
	public String executa(ServletRequest req, ServletResponse res) throws Exception {
		final ContatoDAO dataBaseContato = new ContatoDAO();

		final List<ContatoVO> contatoVOs = dataBaseContato.getContatos(null);
		System.out.println(contatoVOs);
		req.setAttribute("contatoVOs", contatoVOs);
		
		return "jsp/contato/listContato.jsp";
	}

}
