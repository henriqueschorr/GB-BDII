package org.persist.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.uni.farmacia.entity.Cliente;

public class TesteDatabase {
	public static void main(String[] args) {
		// Inicializacao da fabrica de objetos
		// persistenceUnitName = "BD2", ou seja, relaciona com a conexao na
		// persistence.xml (podera ter "n" unidades de persistencia)
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BD2");
		EntityManager em = emf.createEntityManager();

		// Os comandos a seguir devem ser executados "um por vez"
		// Inserindo...
		em.getTransaction().begin();
		em.persist(new Cliente("Henrique", "03099238082"));
		em.persist(new Cliente("Cassia", "03099238082"));
		em.getTransaction().commit();
		
		// Atualizando...
		// Buscara a fruteira com id = 1. Observe o numero do id pelo pgAdmin3!
		Cliente cliente = em.find(Cliente.class, 1L); 
		if (cliente != null) {
			em.getTransaction().begin();
			cliente.setNome("Billy");
			em.merge(cliente);
			em.getTransaction().commit();
		}
//		// Recuperando "n" objetos...
//		TypedQuery<Fruteira> q = em.createQuery("SELECT f " +
//												"FROM Fruteira f", Fruteira.class);
//		for (Fruteira each : q.getResultList()) {
//			System.out.println(each.toString());
//		}		
//		
//		// Excluindo...
//		// Buscara a fruteira com id = 1. Observe o numero do id pelo pgAdmin3!
//		fruteira = em.find(Fruteira.class, 1L); 
//		if (fruteira != null) {
//			em.getTransaction().begin();
//			em.remove(fruteira);
//			em.getTransaction().commit();
//		}
//
//		// Recuperando "n" objetos...
//		q = em.createQuery("FROM Fruteira f", Fruteira.class);
//		for (Fruteira each : q.getResultList()) {
//			System.out.println(each.toString());
//		}
		
		System.exit(0);
	}
}