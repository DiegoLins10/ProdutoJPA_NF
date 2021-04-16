package com.entidades;
/*
 * @Author Diego Lins 16/04
 * entidade NOTA
 */

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Nota {
	
	@Id
	private int nr;
	
	private Date data;
	private float total;
	
	@OneToMany
	private List<Item> itens = new ArrayList<>();
	
	@ManyToOne
	private Cliente cliente;
	
	public Nota() {
	}

	public Nota(int nr, Date data,  List<Item> itens, Cliente cliente) {
		this.nr = nr;
		this.data = data;
		this.itens = itens;
		this.cliente = cliente;
		this.setTotal();
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public float getTotal() {
		return total;
	}

	private void setTotal() {
		for(Item item: itens)
			this.total += item.getTotalItem();
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
		setTotal();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}