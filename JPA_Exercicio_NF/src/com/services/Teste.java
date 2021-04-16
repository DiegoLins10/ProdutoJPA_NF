package com.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entidades.Cliente;
import com.entidades.Item;
import com.entidades.Nota;
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
		
		// Lista de itens 1
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

		// Lista de itens 2
		ArrayList<Item> itens2 = new ArrayList<Item>();
		itens2.add(new Item(9, produtos.get(0), 1));
		itens2.add(new Item(10, produtos.get(1), 2));
		itens2.add(new Item(11, produtos.get(2), 2));
		itens2.add(new Item(12, produtos.get(6), 3));
		itens2.add(new Item(13, produtos.get(7), 1));
		
		for (Item item: itens2) 
			entitymanager.persist(item);

		// Lista de itens 3
		ArrayList<Item> itens3 = new ArrayList<Item>();
		itens3.add(new Item(14, produtos.get(3), 4));
		itens3.add(new Item(15, produtos.get(4), 2));
		itens3.add(new Item(16, produtos.get(5), 3));
		itens3.add(new Item(17, produtos.get(6), 5));
		itens3.add(new Item(18, produtos.get(7), 2));
		
		for (Item item: itens3) 
			entitymanager.persist(item);	
		
		// Lista de itens 4
		ArrayList<Item> itens4 = new ArrayList<Item>();
		itens4.add(new Item(19, produtos.get(0), 2));
		itens4.add(new Item(20, produtos.get(1), 3));
		itens4.add(new Item(21, produtos.get(3), 4));
		itens4.add(new Item(22, produtos.get(6), 5));
		itens4.add(new Item(23, produtos.get(7), 6));
		
		for (Item item: itens4) 
			entitymanager.persist(item);		
			
		// Lista de NFs
		ArrayList<Nota> notas = new ArrayList<Nota>();
		notas.add(new Nota(1, Date.valueOf(LocalDate.of(2021, 4, 16)), itens, clientes.get(0)));
		notas.add(new Nota(2, Date.valueOf(LocalDate.of(2021, 4, 15)), itens2, clientes.get(1)));
		notas.add(new Nota(3, Date.valueOf(LocalDate.of(2021, 4, 10)), itens3, clientes.get(2)));
		notas.add(new Nota(4, Date.valueOf(LocalDate.of(2021, 4, 12)), itens4, clientes.get(3)));

		for (Nota nota: notas) 
			entitymanager.persist(nota);		
		
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
	}

}