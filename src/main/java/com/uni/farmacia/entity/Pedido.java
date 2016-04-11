package com.uni.farmacia.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;


@Entity
public class Pedido implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Classificacao")
	@SequenceGenerator(name = "seq_Classificacao", sequenceName = "s_Classificacao", allocationSize = 1)
	private Long id;
	
	@Column
	private Date data;
	
	@Column
	private int quantidadeItens;
	
	@Column
	private double valorTotal;
	
	@ManyToOne
	@JoinColumn(name="cliente_id", nullable=false)
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="vendedor_id", nullable=false)
	private Vendedor vendedor;
	
	@ManyToMany
	private Collection<Medicamento> medicamentos;
	
	public Pedido(){}

	public Pedido(Vendedor vendedor) {
		super();
		this.vendedor = vendedor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getQuantidadeItens() {
		return quantidadeItens;
	}

	public void setQuantidadeItens(int quantidadeItens) {
		this.quantidadeItens = quantidadeItens;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Collection<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(Collection<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}
	

//	public boolean addMedicamento(Medicamento medicamento){
//		if(medicamento.getEstoque() > 0){
//			this.medicamentos.add(medicamento);
//			medicamento.vendido();
//			this.valorTotal = this.valorTotal + medicamento.getPreco();
//			return true;
//		} else {
//			return false;
//		}
//		
//	}

}
