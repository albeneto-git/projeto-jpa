package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Cliente;
import br.com.alura.jpa.modelo.Conta;

public class TestaRelacionamentoClienteConta {

	public static void main(String[] args) {
	
		Conta conta = new Conta();
		conta.setId(4L);
		
		Cliente cliente = new Cliente();
		cliente.setNome("Leonardo");
		cliente.setEndereco("Rua do Ouvidor 50");
		cliente.setProfissao("Professo");
		cliente.setConta(conta);
		
//		Cliente cliente2 = new Cliente();
//		cliente2.setNome("Maria");
//		cliente2.setEndereco("Rua de Nazaré, 70");
//		cliente2.setProfissao("Professora");
//		cliente2.setConta(conta);		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		em.close();
	}
}
