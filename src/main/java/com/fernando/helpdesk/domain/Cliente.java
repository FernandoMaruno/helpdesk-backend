package com.fernando.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fernando.helpdesk.domain.enums.Perfil;

@Entity
public class Cliente extends Pessoa{
	private static final long serialVersionUID = 1L;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<Chamado> chamado = new ArrayList<>();

	public Cliente() {
		super();
		addPerfil(Perfil.ADMIN);
	}

	public Cliente(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
		addPerfil(Perfil.CLIENTE);
	}

	public List<Chamado> getChamado() {
		return chamado;
	}

	public void setChamado(List<Chamado> chamado) {
		this.chamado = chamado;
	}
	
	
}
