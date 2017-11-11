package br.com.caelum.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.caelum.Bean.ContatoBean;
import br.com.caelum.JDBC.ConnectionFactory;

public class ContatoDao {

	public void insert(ContatoBean contato1) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		System.out.println("Conexao aberta");

		String sql = "INSERT INTO Contato (Nome,Email,Endereco,DataNascimento) values (?,?,?,?)";

		PreparedStatement stmt = connection.prepareStatement(sql);

		long dataNascimentoMileSegundos = contato1.getDataNascimento().getTimeInMillis();

		stmt.setString(1, contato1.getNome());
		stmt.setString(2, contato1.getEmail());
		stmt.setString(3, contato1.getEndereco());
		stmt.setDate(4, new Date(dataNascimentoMileSegundos));

		stmt.execute();

		stmt.close();
		connection.close();

	}

}
