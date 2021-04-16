package com.entidades;
/*
 * @Author Diego Lins 16/04
 * entidade Cliente
 */
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // crtl + shift + o pegar classe
public class Cliente {
	@Id
	private int id;
	private String nome;
	private String email;

	public Cliente() {

	}

	public Cliente(int id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", email=" + email + "]";
	}

}
