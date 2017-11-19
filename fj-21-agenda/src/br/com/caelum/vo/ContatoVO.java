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

	public void setContatoID(final Long contatoID) {
		ContatoID = contatoID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(final String endereco) {
		this.endereco = endereco;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(final Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
