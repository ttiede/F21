package br.com.caelum.vo;

import java.util.Calendar;

public class ContatoVO {
	private Long ContatoID;
	private String nome;
	private String email;
	private String endereco;
	private Calendar dataNascimento;

	public Long getContatoID() {
		return ContatoID;
	}

	public void setContatoID(Long contatoID) {
		ContatoID = contatoID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}