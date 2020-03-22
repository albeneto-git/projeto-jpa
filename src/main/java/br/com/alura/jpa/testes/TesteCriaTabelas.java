package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteCriaTabelas {

	public static void main(String[] args) {
		
		// Hibernate cria as tabelas só pelo fato de criar o entity manager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		em.close();
		emf.close();
		
	}
	
}
