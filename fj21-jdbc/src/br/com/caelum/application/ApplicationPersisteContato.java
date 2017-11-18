package br.com.caelum.application;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;

import br.com.caelum.dao.ContatoDAO;
import br.com.caelum.factory.ConnectionFactory;
import br.com.caelum.vo.ContatoVO;

public class ApplicationPersisteContato {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;

			connection = ConnectionFactory.getConnection();

			ContatoVO contato1 = new ContatoVO();

			Calendar dataNascimento = Calendar.getInstance();
			dataNascimento.set(1983, 9, 7);

			contato1.setDataNascimento(dataNascimento);
			contato1.setEmail("geschopf@gmail.com");
			contato1.setEndereco("Diogo de Faria 111");
			contato1.setNome("Tiago Tiede");

			ContatoDAO dataBaseContato = new ContatoDAO();
			dataBaseContato.insert(contato1);

			ContatoVO contato2 = new ContatoVO();
			Calendar dataNascimento2 = Calendar.getInstance();
			
			dataNascimento2.set(1983, 11, 22);
			contato2.setDataNascimento(dataNascimento2);
			contato2.setEmail("Tamyracarvalho@gmail.com");
			contato2.setEndereco("Mst Zeferino Santana");
			contato2.setNome("Tamyra Carvalho");
			
			dataBaseContato.insert(contato1);

		
	}
}
