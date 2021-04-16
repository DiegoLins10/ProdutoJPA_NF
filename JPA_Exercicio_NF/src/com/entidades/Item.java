package com.entidades;
/*
 * @Author Diego Lins 16/04
 * entidade item
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Item {
	@Id
	private int id;
	
	@ManyToOne
	private Produto produto;
	
	private float precoUnitario;
	private int quantidade;
	private float totalItem;
	
	public Item() {
	}

	public Item(int id, Produto produto, int quantidade) {
		this.id = id;
		this.produto = produto;
		this.quantidade = quantidade;
		this.precoUnitario = produto.getPrecoUnitario();
		setTotalItem();
	}
	
	private void setTotalItem() {
		this.totalItem = produto.getPrecoUnitario() * this.quantidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
		setTotalItem();
	}

	public float getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(float precoUnitario) {
		this.precoUnitario = precoUnitario;
		setTotalItem();
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
		setTotalItem();
	}

	public float getTotalItem() {
		return totalItem;
	}
	
	
}