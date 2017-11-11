package br.com.caelum.application;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.Bean.ContatoBean;
import br.com.caelum.Dao.ContatoDao;
import br.com.caelum.JDBC.ConnectionFactory;

public class ApplicationListaContatos {

	public static void main(String[] args) throws SQLException {
		List<ContatoBean> contatos = new ArrayList<ContatoBean>();
		;

		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();

			ContatoDao dataBaseContato = new ContatoDao(connection);

			contatos = dataBaseContato.getContatos(null);
			// contatos = dataBaseContato.getContato("nome like 'Ti%'");
			//contatos = dataBaseContato.getById(8);

			
			for (ContatoBean contato : contatos) {
				System.out.println("===================== Contato =====================");
				System.out.println("Nome: " + contato.getNome());
				System.out.println("Email: " + contato.getEmail());
				System.out.println("Endereco: " + contato.getEndereco());
				System.out.println("Data de Nascimento: " + contato.getDataNascimento().getTimeInMillis());
				System.out.println("Nome: " + contato.getNome());
				System.out.println("\n");
			}

		} finally {
			connection.close();
		}
	}

}
