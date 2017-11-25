package br.com.caelum.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.caelum.exception.DAOException;
import br.com.caelum.factory.ConnectionFactory;

@WebFilter("/*")
public class FiltroConexao implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();
			req.setAttribute("connection", connection);
			chain.doFilter(req, res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeConnection(connection);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {

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
