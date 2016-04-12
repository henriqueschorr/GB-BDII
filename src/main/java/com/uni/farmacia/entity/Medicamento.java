package com.uni.farmacia.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import com.uni.farmacia.types.TipoMedicamento;

@Entity
public class Medicamento implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Classificacao")
	@SequenceGenerator(name = "seq_Classificacao", sequenceName = "s_Classificacao", allocationSize = 1)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String composicao;
	
	@Column(nullable = false)
	private TipoMedicamento tipo;
	
	@Column(nullable = false)
	private String laboratorio;
	
	@Column(nullable = false)
	private int estoque;
	
	@Column(nullable = false)
	private double preco;
	
	@ManyToMany
	private Collection<Pedido> vendas;
	
	public Medicamento(){}

	public Medicamento(String nome, String composicao, TipoMedicamento tipo, String laboratorio, int estoque, double preco) {
		super();
		this.nome = nome;
		this.composicao = composicao;
		this.tipo = tipo;
		this.laboratorio = laboratorio;
		this.estoque = estoque;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getComposicao() {
		return composicao;
	}

	public void setComposicao(String composicao) {
		this.composicao = composicao;
	}

	public TipoMedicamento getTipo() {
		return tipo;
	}

	public void setTipo(TipoMedicamento tipo) {
		this.tipo = tipo;
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Collection<Pedido> getVendas() {
		return vendas;
	}

	public void setVendas(Collection<Pedido> vendas) {
		this.vendas = vendas;
	}
	
//	public void addVenda(Pedido venda){
//		this.vendas.add(venda);
//	}
	
//	public void vendido(){
//		this.estoque--;
//	}

}
