package br.com.caelum.application;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.Bean.ContatoBean;
import br.com.caelum.Dao.ContatoDao;
import br.com.caelum.JDBC.ConnectionFactory;

public class Application {

	private static  List<ContatoBean> contatos;

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();
			
			ContatoBean contato1 = new ContatoBean();

			Calendar dataNascimento = Calendar.getInstance();
			dataNascimento.set(1983, 9, 7);
			
			contato1.setDataNascimento(dataNascimento);
			contato1.setEmail("geschopf@gmail.com");
			contato1.setEndereco("Diogo de Faria 111");
			contato1.setNome("Tiago Tiede");
			
			ContatoDao dataBaseContato = new ContatoDao(connection);
			dataBaseContato.insert(contato1);	
			
			contatos = dataBaseContato.getAll();
			
			for(ContatoBean contato : contatos){
				System.out.println("===================== Contato =====================");
				System.out.println("Nome: " +contato.getNome());
				System.out.println("Email: " +contato.getEmail());
				System.out.println("Endereco: " +contato.getEndereco());
				System.out.println("Data de Nascimento: " +contato.getDataNascimento().getTimeInMillis());
				System.out.println("Nome: " +contato.getNome());
				System.out.println("\n");
			}
			
		}finally{
			connection .close();
		}
	}

}
