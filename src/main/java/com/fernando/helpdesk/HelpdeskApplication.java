package com.fernando.helpdesk;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fernando.helpdesk.domain.Chamado;
import com.fernando.helpdesk.domain.Cliente;
import com.fernando.helpdesk.domain.Tecnico;
import com.fernando.helpdesk.domain.enums.Perfil;
import com.fernando.helpdesk.domain.enums.Prioridade;
import com.fernando.helpdesk.domain.enums.Status;
import com.fernando.helpdesk.repositories.ChamadoRepository;
import com.fernando.helpdesk.repositories.ClienteRepository;
import com.fernando.helpdesk.repositories.TecnicoRepository;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner{
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Tecnico tec1 = new Tecnico(null, "Fernando", "004.903.710-27", "fernando@gmail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Bia", "889.297.610-97", "bia@gmail.com", "234");
		
		Chamado cha1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", cli1, tec1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(cha1));
		
	}

}
