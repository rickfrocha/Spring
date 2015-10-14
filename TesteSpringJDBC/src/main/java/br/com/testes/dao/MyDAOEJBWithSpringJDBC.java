package br.com.testes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import br.com.testes.entity.Pessoa;

/**
 * Integrando EJB + Spring
 * 
 * O Spring JDBC pode conviver sem problemas com o EJB visto que ele depende apenas de um DataSource
 * 
 * @author darochri
 *
 */

@LocalBean
@Stateless(name="MyDAOEJBWithSpringJDBC")
public class MyDAOEJBWithSpringJDBC {

	@Resource(name = "jdbc/myDS", type = javax.sql.DataSource.class)
	private DataSource datasource;

	private JdbcTemplate JdbcTemplate;
	
	private static final String DEFAULT_SQL_BUSCAS = "SELECT * FROM 'APP'.'PESSOA'";
	

	@PostConstruct
	public void init() {
		JdbcTemplate = new JdbcTemplate(datasource);
	}

	
	/**
	 * Efetua busca da maneira tradicional com jdbc
	 * @return
	 * @throws SQLException
	 */
	public List<Pessoa> listPessoasWithNaturalJDBC() throws SQLException{
		List<Pessoa> retorno = new ArrayList<Pessoa>();
		
	    Connection conection = datasource.getConnection();	
	    PreparedStatement p = conection.prepareStatement(DEFAULT_SQL_BUSCAS);
	    ResultSet resultSet = p.executeQuery();
	    
	    while(resultSet.next()){
			Pessoa pessoa = new Pessoa();
			pessoa.setId(resultSet.getInt("id"));
			pessoa.setNome(resultSet.getString("nome"));
			retorno.add( pessoa );
	    }
	    
	    return retorno;
	}
	
	/**
	 * Retorna a lista de pessoas
	 * @return
	 */
	public List<Pessoa> listPessoas() {
		StringBuilder sql = new StringBuilder(DEFAULT_SQL_BUSCAS);

		return JdbcTemplate.query(sql.toString(), new RowMapper<Pessoa>() {
			public Pessoa mapRow(ResultSet resultSet, int index)
			throws SQLException 
			{
				Pessoa pessoa = new Pessoa();
				pessoa.setId(resultSet.getInt("id"));
				pessoa.setNome(resultSet.getString("nome"));
				return pessoa;
			}

		});
	}

	/**
	 * Efetua busca para um ID especifico
	 * @param id
	 * @return
	 */
	public Pessoa getPessoaById(int id) {
		StringBuilder sql = new StringBuilder(
				"select * from  APP.Pessoa where id = ?");

		return JdbcTemplate.queryForObject(sql.toString(),
				new Object[] { id }, new RowMapper<Pessoa>() {
					public Pessoa mapRow(ResultSet resultSet, int index)
							throws SQLException {
						Pessoa pessoa = new Pessoa();
						pessoa.setId(resultSet.getInt("id"));
						pessoa.setNome(resultSet.getString("nome"));
						return pessoa;
					}

				});
	}

	/**
	 * Efetua uma atualizacao de registro
	 * @param pessoa
	 */
	public void updatePessoa(Pessoa pessoa) {
		StringBuilder sql = new StringBuilder(
				"Update  APP.Pessoa Set nome = ? where id = ?");

		JdbcTemplate.update(sql.toString(), new Object[] { pessoa.getNome(),
				pessoa.getId() });

	}

}
