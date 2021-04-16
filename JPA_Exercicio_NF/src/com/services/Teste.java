package com.services;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entidades.Cliente;
import com.entidades.Item;
import com.entidades.Produto;

public class Teste {

	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_NF");
		EntityManager entitymanager = emfactory.createEntityManager();
		
		entitymanager.getTransaction().begin();
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(new Cliente(1,"Pedro","pedro@gmail.com"));
		clientes.add(new Cliente(2,"Ana","ana@gmail.com"));
		clientes.add(new Cliente(3,"Maria","maria@gmail.com"));
		clientes.add(new Cliente(4,"Alex","alex@gmail.com"));
		
		for (Cliente cliente: clientes) 
			entitymanager.persist(cliente);
		
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		produtos.add(new Produto(1,"Celular Motorola",1230.79f));
		produtos.add(new Produto(2,"Geladeira Brastemp",2354.81f));
		produtos.add(new Produto(3,"Ferro Walita",202.43f));
		produtos.add(new Produto(4,"Fogão Consul - 4 bocas",765.33f));
		produtos.add(new Produto(5,"Microondas LG - 28 litros",552.25f));
		produtos.add(new Produto(6,"Smart TV LG 43'",2234.72f));
		produtos.add(new Produto(7,"IPhone",2781.74f));
		produtos.add(new Produto(8,"Notebook Asus",2951.36f));

		for (Produto produto: produtos) 
			entitymanager.persist(produto);
		
		ArrayList<Item> itens = new ArrayList<Item>();
		itens.add(new Item(1, produtos.get(0), 2));
		itens.add(new Item(2, produtos.get(1), 1));
		itens.add(new Item(3, produtos.get(2), 1));
		itens.add(new Item(4, produtos.get(3), 2));
		itens.add(new Item(5, produtos.get(4), 3));
		itens.add(new Item(6, produtos.get(5), 1));
		itens.add(new Item(7, produtos.get(6), 2));
		itens.add(new Item(8, produtos.get(7), 3));
		
		for (Item item: itens) 
			entitymanager.persist(item);
		
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
	}

}