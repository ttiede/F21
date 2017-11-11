package br.com.caelum.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.Bean.ContatoBean;
import br.com.caelum.JDBC.ConnectionFactory;

public class ContatoDao {
	protected Connection connection;

	public ContatoDao(Connection connection) {
		this.connection = connection;
	}

	public void insert(ContatoBean contato1) throws SQLException {

		String sql = "INSERT INTO Contato (Nome,Email,Endereco,DataNascimento) values (?,?,?,?)";

		PreparedStatement stmt = connection.prepareStatement(sql);

		long dataNascimentoMileSegundos = contato1.getDataNascimento().getTimeInMillis();

		stmt.setString(1, contato1.getNome());
		stmt.setString(2, contato1.getEmail());
		stmt.setString(3, contato1.getEndereco());
		stmt.setDate(4, new Date(dataNascimentoMileSegundos));

		stmt.execute();

		stmt.close();

	}

	public List<ContatoBean> getAll() {
		List<ContatoBean> contatos = new ArrayList<>();

		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Contato");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ContatoBean contato = new ContatoBean();
				contato.setContatoID(rs.getLong("ContatoID"));
				contato.setNome(rs.getString("Nome"));
				contato.setEmail(rs.getString("Email"));
				contato.setEndereco(rs.getString("Endereco"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("DataNascimento"));
				contato.setDataNascimento(data);
				contatos.add(contato);
				contato = null;
			}
			rs.close();
			stmt.close();
			return contatos;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
