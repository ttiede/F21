package br.com.caelum.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.exception.DAOException;
import br.com.caelum.vo.ContatoVO;

public class ContatoDAO {
	private final Connection connection;

	public ContatoDAO(Connection connection) {
		this.connection = connection;
	}

	public void insert(ContatoVO contato1) throws SQLException {

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

	public void update(ContatoVO contato1) throws SQLException {

		String sql = "UPDATE Contato SET Nome = ? ,Email = ? ,Endereco = ? ,DataNascimento = ? WHERE ContatoID = ?";

		PreparedStatement stmt = connection.prepareStatement(sql);

		long dataNascimentoMileSegundos = contato1.getDataNascimento().getTimeInMillis();

		stmt.setString(1, contato1.getNome());
		stmt.setString(2, contato1.getEmail());
		stmt.setString(3, contato1.getEndereco());
		stmt.setDate(4, new Date(dataNascimentoMileSegundos));
		stmt.setLong(5, contato1.getContatoID());

		stmt.execute();

		stmt.close();

	}

	public List<ContatoVO> getContatos(String where) {
		List<ContatoVO> contatos = new ArrayList<>();

		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Contato");

			if (where != null) {
				stmt = connection.prepareStatement("SELECT * FROM Contato WHERE ?");
				stmt.setString(1, String.valueOf(where));
			}

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ContatoVO contato = new ContatoVO();
				contato.setContatoID(rs.getLong("ContatoID"));
				contato.setNome(rs.getString("Nome"));
				contato.setEmail(rs.getString("Email"));
				contato.setEndereco(rs.getString("Endereco"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("DataNascimento"));
				contato.setDataNascimento(data);
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			return contatos;

		} catch (SQLException e) {
			throw new DAOException(null, e);
		}
	}

	public List<ContatoVO> getById(Integer id) {
		List<ContatoVO> contatos = new ArrayList<>();

		try {
			PreparedStatement stmt = null;
			String querySearch = "SELECT * FROM Contato WHERE ContatoID = ?";
			if (id != null) {
				stmt = connection.prepareStatement(querySearch);
				stmt.setLong(1, id);
			}

			ResultSet rs = stmt != null ? stmt.executeQuery() : null;
			while (rs != null ? rs.next() : false) {
				ContatoVO contato = new ContatoVO();
				contato.setContatoID(rs.getLong("ContatoID"));
				contato.setNome(rs.getString("Nome"));
				contato.setEmail(rs.getString("Email"));
				contato.setEndereco(rs.getString("Endereco"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("DataNascimento"));
				contato.setDataNascimento(data);
				contatos.add(contato);
			}
			assert rs != null;
			rs.close();
			stmt.close();
			return contatos;

		} catch (SQLException e) {
			throw new DAOException(null, e);
		}
	}

	public String deleteById(Long id) {
		try {
			PreparedStatement stmt = null;
			String queryDelete = "DELETE FROM Contato WHERE ContatoID = ?";
			if (id != null) {
				stmt = connection.prepareStatement(queryDelete);

				stmt.setLong(1, id);

				stmt.execute();

				stmt.close();
				return "Contato excluído:"+ id;
			}
		}catch (SQLException e) {
			throw new DAOException("falha ao excluir contato:"+ id, e);
		}
		return null;
	}
}
