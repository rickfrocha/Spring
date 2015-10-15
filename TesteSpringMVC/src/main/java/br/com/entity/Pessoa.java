package br.com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Pessoa {
	
	@Id
	@Min(value=10,message="minimo.invalido")
	@Max(value=20,message="maximo.invalido")
	private int codigo;
	
	@NotBlank
	@NotNull
	@Size(min=3, max=30)
	private String nome;
	
	@Min(value=0,message="minimo.invalido")
	@Max(value=100,message="maximo.invalido")
	private int idade;
	
	@Email
	private String email;
	
	
	public Pessoa() {
		// TODO Auto-generated constructor stub
	}
	
	


	public Pessoa(int codigo, String nome, int idade, String email) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.idade = idade;
		this.email = email;
	}




	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getIdade() {
		return idade;
	}


	public void setIdade(int idade) {
		this.idade = idade;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}




	@Override
	public String toString() {
		return "Pessoa [codigo=" + codigo + ", nome=" + nome + ", idade="
				+ idade + ", email=" + email + "]";
	}
	
	
	

}
