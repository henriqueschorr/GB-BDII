package com.uni.farmacia.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.uni.farmacia.types.TipoMedicamento;

@Entity
public class Medicamento implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Classificacao")
	@SequenceGenerator(name = "seq_Classificacao", sequenceName = "s_Classificacao", allocationSize = 1)
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String composicao;
	
	@Column
	private TipoMedicamento tipo;
	
	@Column
	private int estoque;
	
	@Column
	private double preço;

}
