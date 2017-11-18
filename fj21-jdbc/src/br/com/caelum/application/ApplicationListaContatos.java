package br.com.caelum.application;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.dao.ContatoDAO;
import br.com.caelum.factory.ConnectionFactory;
import br.com.caelum.vo.ContatoVO;

public class ApplicationListaContatos {

	public static void main(String[] args) throws SQLException {
		List<ContatoVO> contatos = new ArrayList<ContatoVO>();
		;

		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();

			ContatoDAO dataBaseContato = new ContatoDAO(connection);

			contatos = dataBaseContato.getContatos(null);
			// contatos = dataBaseContato.getContato("nome like 'Ti%'");
			//contatos = dataBaseContato.getById(8);

			
			for (ContatoVO contato : contatos) {
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
