package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TestandoEstados {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		// Transient (não esta managed, não esta sincronizada com o bando de dados )
		Conta conta = new Conta();
		conta.setTitular("Almiro");
		conta.setAgencia(121212);
		conta.setNumero(131313);
		
		em.getTransaction().begin();
		
		// Transient -> Managed (a caracteristica é a sincronização automática)
		em.persist(conta);
		
		// Managed -> Removed
		em.remove(conta);
		
		em.getTransaction().commit();			
	}
}
