package org.persist.test;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.uni.farmacia.entity.Cliente;
import com.uni.farmacia.entity.Pedido;

public class TesteDatabase {
	public static void main(String[] args) {
		// Inicializacao da fabrica de objetos
		// persistenceUnitName = "BD2", ou seja, relaciona com a conexao na
		// persistence.xml (podera ter "n" unidades de persistencia)
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BD2");
		EntityManager em = emf.createEntityManager();

		
		ArrayList<Pedido> d = new ArrayList<Pedido>();
		Cliente p = new Cliente("Henrique", "03099238082");
		Pedido d1 = new Pedido(p);
		Pedido d2 = new Pedido(p);
//		d1.setPessoa(p);
//		d2.setPessoa(p);
		d.add(d1);
		d.add(d2);
		p.setPedidos(d);

		em.getTransaction().begin();
		em.persist(d1);
		em.persist(d2);
		em.persist(p);
		em.getTransaction().commit();

		System.exit(0);
	}
}