package com.uni.farmacia.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Pedido implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Classificacao")
	@SequenceGenerator(name = "seq_Classificacao", sequenceName = "s_Classificacao", allocationSize = 1)
	private Long id;
	
	@Column
	private Vendedor vendedor;
	
	@ManyToOne
	private Cliente cliente;
	
	@Column
	private Date data;
	
	@Column
	private Medicamento medicamentos;
	
	@Column
	private int quantidadeItens;
	
	@Column
	private double valorTotal;

	public Pedido(Cliente cliente) {
		super();
		this.cliente = cliente;
	}
	
	

}
