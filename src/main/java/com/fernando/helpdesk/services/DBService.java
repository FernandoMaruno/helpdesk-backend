package com.fernando.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.helpdesk.domain.Chamado;
import com.fernando.helpdesk.domain.Cliente;
import com.fernando.helpdesk.domain.Tecnico;
import com.fernando.helpdesk.domain.enums.Perfil;
import com.fernando.helpdesk.domain.enums.Prioridade;
import com.fernando.helpdesk.domain.enums.Status;
import com.fernando.helpdesk.repositories.ChamadoRepository;
import com.fernando.helpdesk.repositories.ClienteRepository;
import com.fernando.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	public void instanciaDB() {
		
		Tecnico tec1 = new Tecnico(null, "Fernando", "004.903.710-27", "fernando@gmail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		Tecnico tec2 = new Tecnico(null, "Richard Stallman", "903.347.070-56", "stallman@mail.com", "123");
		Tecnico tec3 = new Tecnico(null, "Claude Elwood Shannon", "271.068.470-54", "shannon@mail.com", "123");
		Tecnico tec4 = new Tecnico(null, "Tim Berners-Lee", "162.720.120-39", "lee@mail.com", "123");
		Tecnico tec5 = new Tecnico(null, "Linus Torvalds", "778.556.170-27", "linus@mail.com", "123");
		
		Cliente cli1 = new Cliente(null, "Bia", "889.297.610-97", "bia@gmail.com", "234");
		Cliente cli2 = new Cliente(null, "Albert Einstein", "111.661.890-74", "einstein@mail.com", "123");
		Cliente cli3 = new Cliente(null, "Marie Curie", "322.429.140-06", "curie@mail.com", "123");
		Cliente cli4 = new Cliente(null, "Charles Darwin", "792.043.830-62", "darwin@mail.com", "123");
		Cliente cli5 = new Cliente(null, "Stephen Hawking", "177.409.680-30", "hawking@mail.com", "123");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 1", "Teste chamado 1", tec1, cli1);
		Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 2", "Teste chamado 2", tec1, cli2);
		Chamado c3 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 3", "Teste chamado 3", tec2, cli3);
		Chamado c4 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 4", "Teste chamado 4", tec3, cli3);
		Chamado c5 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 5", "Teste chamado 5", tec2, cli1);
		Chamado c6 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 7", "Teste chamado 6", tec1, cli5);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5));
		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4, cli5));
		chamadoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));
		
	}

}
