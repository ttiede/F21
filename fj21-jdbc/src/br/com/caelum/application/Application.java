package br.com.caelum.application;

import java.sql.SQLException;
import java.util.Calendar;

import br.com.caelum.Bean.ContatoBean;
import br.com.caelum.Dao.ContatoDao;

public class Application {

	public static void main(String[] args) throws SQLException {
		ContatoBean contato1 = new ContatoBean();

		Calendar dataNascimento = Calendar.getInstance();

		contato1.setDataNascimento(dataNascimento);
		contato1.setEmail("geschopf@gmail.com");
		contato1.setEndereco("Diogo de Faria 111");
		contato1.setNome("Tiago Tiede");
		ContatoDao insertContato = new ContatoDao();
		insertContato.insert(contato1);

	}

}
