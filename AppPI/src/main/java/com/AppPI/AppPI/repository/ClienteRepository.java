package com.AppPI.AppPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.AppPI.AppPI.models.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	
	// CRIADO PARA A BUSCA CLIENTE POR ID OU CHAVE PRIMÁRIA
	Cliente findById(long id);
	
	// CRIADO PARA A BUSCA CLIENTE POR NOME
	Cliente findByNome(String nome);
	
	// BUSCA PARA VÁRIOS NOMES CLIENTE
	@Query(value = "select u from Cliente u where u.nome like %?1%")
	List<Cliente> findByNomes(String nome);
}
