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
import br.com.caelum.factory.ConnectionFactory;
import br.com.caelum.vo.ContatoVO;

public class ContatoDAO {

	public void insert(ContatoVO contato) {
		final String sql = "INSERT INTO Contato (Nome,Email,Endereco,DataNascimento) values (?,?,?,?)";
		this.mergeData(contato, sql);
	}

	public void update(final ContatoVO contato) {
		final String sql = "UPDATE Contato SET Nome = ? ,Email = ? ,Endereco = ? ,DataNascimento = ? WHERE ContatoID = ?";
		this.mergeData(contato, sql);
	}

	public List<ContatoVO> getContatos(final String where) {
		final List<ContatoVO> contatos = new ArrayList<>();
		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();

			final PreparedStatement stmt;
			if (where == null) {
				stmt = connection.prepareStatement("SELECT * FROM Contato");
			} else {
				stmt = connection.prepareStatement("SELECT * FROM Contato WHERE ?");
				stmt.setString(1, String.valueOf(where));
			}

			final ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				contatos.add(this.buildContato(rs));
			}
			rs.close();
			stmt.close();
			return contatos;

		} catch (SQLException e) {
			throw new DAOException(null, e);
		} finally {
			this.closeConnection(connection);
		}
	}

	public List<ContatoVO> getById(final Integer id) {
		final List<ContatoVO> contatos = new ArrayList<>();
		Connection connection = null;
		try {
			String querySearch = "SELECT * FROM Contato WHERE ContatoID = ?";
			if (id != null) {
				connection = ConnectionFactory.getConnection();

				final PreparedStatement stmt = connection.prepareStatement(querySearch);
				stmt.setLong(1, id);

				final ResultSet rs = stmt.executeQuery();

				while (rs != null ? rs.next() : false) {
					contatos.add(this.buildContato(rs));
				}
				rs.close();
				stmt.close();
			}
			return contatos;
		} catch (SQLException e) {
			throw new DAOException(null, e);
		} finally {
			this.closeConnection(connection);
		}
	}

	private ContatoVO buildContato(final ResultSet rs) throws SQLException {
		ContatoVO contato = new ContatoVO();
		contato.setContatoID(rs.getLong("ContatoID"));
		contato.setNome(rs.getString("Nome"));
		contato.setEmail(rs.getString("Email"));
		contato.setEndereco(rs.getString("Endereco"));

		Calendar data = Calendar.getInstance();
		data.setTime(rs.getDate("DataNascimento"));
		contato.setDataNascimento(data);
		return contato;
	}

	public String deleteById(final Long id) {
		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();

			String queryDelete = "DELETE FROM Contato WHERE ContatoID = ?";
			if (id != null) {
				final PreparedStatement stmt = connection.prepareStatement(queryDelete);
				stmt.setLong(1, id);
				stmt.execute();
				stmt.close();
				return String.format("Contato excluído: %s", id);
			}
		} catch (SQLException e) {
			throw new DAOException(String.format("falha ao excluir contato: %s",id), e);
		} finally {
			this.closeConnection(connection);
		}
		return null;
	}

	private void mergeData(final ContatoVO contatoVO, final String qry) {
		Connection connection = null;

		try {
			connection = ConnectionFactory.getConnection();
			long dataNascimentoMileSegundos = contatoVO.getDataNascimento().getTimeInMillis();

			final PreparedStatement stmt = connection.prepareStatement(qry);
			stmt.setString(1, contatoVO.getNome());
			stmt.setString(2, contatoVO.getEmail());
			stmt.setString(3, contatoVO.getEndereco());
			stmt.setDate(4, new Date(dataNascimentoMileSegundos));

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(null, e);
		} finally {
			this.closeConnection(connection);
		}

	}

	private void closeConnection(final Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new DAOException("Error ao fechar conexao:", e);
			}
		}
	}
}