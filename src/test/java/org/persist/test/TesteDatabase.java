package org.persist.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.uni.farmacia.entity.Cliente;
import com.uni.farmacia.entity.Medicamento;
import com.uni.farmacia.entity.Pedido;
import com.uni.farmacia.entity.Vendedor;
import com.uni.farmacia.types.TipoMedicamento;

public class TesteDatabase {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FARMACIA");
		EntityManager em = emf.createEntityManager();

		Cliente cliente1 = new Cliente("Henrique", "12345678901");
		Cliente cliente2 = new Cliente("Cassia", "10987654321");

		Vendedor vendedor1 = new Vendedor("Douglas", "12312312300");
		Vendedor vendedor2 = new Vendedor("Bruna", "00321321321");

		Medicamento medicamento1 = new Medicamento("Amoxil 500mg", "Amoxicilina 500mg", TipoMedicamento.ETICO,
				"Glaxosmithkline", 5, 35.00);
		Medicamento medicamento2 = new Medicamento("Diclofenaco sódico 50mg", "Diclofenaco sódico 50mg",
				TipoMedicamento.GENERICO, "Medley", 30, 12.00);
		Medicamento medicamento3 = new Medicamento("Cimegripe",
				"Paracetamol 400mg, maleato de clorfeniramina 4mg, cloridrato de filefrina 4mg",
				TipoMedicamento.SIMILAR, "Cimed", 50, 15.00);

		ArrayList<Medicamento> medicamentos1 = new ArrayList<Medicamento>();
		ArrayList<Medicamento> medicamentos2 = new ArrayList<Medicamento>();
		ArrayList<Pedido> pedidos1 = new ArrayList<Pedido>();
		ArrayList<Pedido> pedidos2 = new ArrayList<Pedido>();

		int estoque;
		double valor;
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy h:mm:ss a");
		String formattedDate = sdf.format(date);

		// Primeira venda
		Pedido pedido1 = new Pedido(vendedor1);
		pedidos1.add(pedido1);
		vendedor1.setVendas(pedidos1);

		pedido1.setCliente(cliente1);
		cliente1.setPedidos(pedidos1);

		medicamentos1.add(medicamento1);
		medicamento1.setVendas(pedidos1);
		estoque = medicamento1.getEstoque();
		estoque--;
		medicamento1.setEstoque(estoque);

		medicamentos1.add(medicamento2);
		medicamento2.setVendas(pedidos1);
		estoque = medicamento2.getEstoque();
		estoque--;
		medicamento2.setEstoque(estoque);

		valor = medicamento1.getPreco() + medicamento2.getPreco();
		pedido1.setValorTotal(valor);

		pedido1.setData(formattedDate);

		pedido1.setQuantidadeItens(pedidos1.size() + 1);

		pedido1.setMedicamentos(medicamentos1);

		// Segunda venda
		Pedido pedido2 = new Pedido(vendedor2);
		pedidos1.add(pedido2);
		vendedor2.setVendas(pedidos1);

		pedido2.setCliente(cliente2);
		cliente2.setPedidos(pedidos1);

		medicamentos2.add(medicamento3);
		medicamento3.setVendas(pedidos1);
		estoque = medicamento3.getEstoque();
		estoque--;
		medicamento3.setEstoque(estoque);

		valor = medicamento3.getPreco();
		pedido2.setValorTotal(valor);

		pedido2.setQuantidadeItens(pedidos2.size() + 1);

		pedido2.setData(formattedDate);

		pedido2.setMedicamentos(medicamentos2);

		em.getTransaction().begin();
		em.persist(cliente1);
		em.persist(cliente2);
		em.persist(vendedor1);
		em.persist(vendedor2);
		em.persist(medicamento1);
		em.persist(medicamento2);
		em.persist(medicamento3);
		em.persist(pedido1);
		em.persist(pedido2);
		em.getTransaction().commit();

		TypedQuery<Cliente> clienteQuery = em.createQuery("SELECT c FROM Cliente c", Cliente.class);
		for (Cliente each : clienteQuery.getResultList()) {
			System.out.println("Nome Cliente: " + each.getNome());
		}
		
		TypedQuery<Vendedor> vendedorQuery = em.createQuery("SELECT v FROM Vendedor v", Vendedor.class);
		for (Vendedor each : vendedorQuery.getResultList()) {
			System.out.println("Nome Vendedor: " + each.getNome());
		}
		
		TypedQuery<Medicamento> medicamentoQuery = em.createQuery("SELECT m FROM Medicamento m", Medicamento.class);
		for (Medicamento each : medicamentoQuery.getResultList()) {
			System.out.println("Nome Medicamento: " + each.getNome());
		}
		
		TypedQuery<Pedido> pedidoQuery = em.createQuery("SELECT p FROM Pedido p", Pedido.class);
		Integer pedidoNumber = 1;
		for (Pedido each : pedidoQuery.getResultList()) {
			System.out.println("\nPedido número " + pedidoNumber);
			System.out.println("----------------------------------------------");
			System.out.println("Data e Horário: " + each.getData());
			System.out.println("Cliente: " + each.getCliente().getNome());
			System.out.println("Vendedor: " + each.getVendedor().getNome());
			System.out.println("Quantidade de itens: " + each.getQuantidadeItens());
			System.out.print("\nMedicamentos:");
			for(Medicamento eachMed : each.getMedicamentos()){
				System.out.println("\nNome Medicamento: " + eachMed.getNome());
				System.out.println("Composição: " + eachMed.getComposicao());
				System.out.println("Tipo: " + eachMed.getTipo());
				System.out.println("Laboratório: " + eachMed.getLaboratorio());
				System.out.println("Valor: " + eachMed.getPreco());
			}
			
			System.out.println("\nValor Total: " + each.getValorTotal());
			
			System.out.println("----------------------------------------------");
			pedidoNumber++;
		}


		System.exit(0);
	}
}