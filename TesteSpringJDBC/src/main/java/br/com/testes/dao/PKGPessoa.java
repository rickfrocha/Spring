package br.com.testes.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import br.com.testes.entity.Pessoa;

/**
 * Classe utilitaria que utiliza o Spring JDBC para mapear as procedures de uma package de banco de dados Oracle
 * 
 * @author darochri
 *
 */
public class PKGPessoa {
	
	private static final String PKG_NAME = "PKG_PESSOA";
	
	
	private DataSource dataSource;
	private ProcedureListarPessoas procedureListarPessoas;
	
	
	public PKGPessoa(DataSource ds) {
		this.dataSource = ds;
	}
	
	
	
	public ProcedureListarPessoas getProcedureListarPessoas(){
		if(procedureListarPessoas == null){
			procedureListarPessoas = new ProcedureListarPessoas();
		}
		return procedureListarPessoas;
	}
	
	
	/**
	 * Classe que mapeia o retorno
	 * @author darochri
	 *
	 */
	public class PessoaRowMapper implements RowMapper<Pessoa>{
		public Pessoa mapRow(ResultSet resultSet, int index) throws SQLException {
			Pessoa pessoa = new Pessoa();
			pessoa.setId(resultSet.getInt("id"));
			pessoa.setNome(resultSet.getString("nome"));
			return pessoa;
		}
		
	}
	
	/**
	 * Classe interna que referencia a procedure dentro da PROC
	 * @author darochri
	 *
	 */
	public class ProcedureListarPessoas extends StoredProcedure{
		private SqlParameter[] paramsProc = new SqlParameter[] {
													new SqlParameter("p_id_sistema", Types.VARCHAR),
													new SqlParameter("p_id_usuario", Types.NUMERIC)
													//new SqlOutParameter("retorno", OracleTypes.CURSOR, new PessoaRowMapper()) ;

												};
		
		public ProcedureListarPessoas() {
			super(dataSource, PKG_NAME);
			setFunction(false);
			
			for (SqlParameter param : paramsProc) {
				declareParameter(param);
			}			
			compile();
		}
		
		
		@SuppressWarnings("unchecked")
		public List<Pessoa> listarPessoas(String identificadorSistema, int idUsuario){
			Map<String, Object> inParams = new HashMap<String, Object>();
			inParams.put("p_id_sistema", identificadorSistema);
			inParams.put("p_id_usuario", idUsuario);
			return (List<Pessoa>) execute(inParams).get("retorno");
		}
		
	}

}
