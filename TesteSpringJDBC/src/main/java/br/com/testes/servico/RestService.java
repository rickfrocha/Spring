package br.com.testes.servico;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.testes.dao.MyDAOEJBWithSpringJDBC;
import br.com.testes.entity.Pessoa;

@Path("/rest/pessoa")
public class RestService {
	
	
	@EJB
	MyDAOEJBWithSpringJDBC dao;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	public List<Pessoa> listarPessoasO(){
		return dao.listPessoas();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listJDBC")
	public List<Pessoa> listarPessoas1() throws SQLException{
		return dao.listPessoasWithNaturalJDBC();
	}
	

}
