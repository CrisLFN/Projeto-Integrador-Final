package com.AppPI.AppPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.AppPI.AppPI.models.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {
	
	// CRIADO PARA A BUSCA PEDIDO POR ID OU CHAVE PRIMÁRIA
	Pedido findById(long id);
	
	// CRIADO PARA A BUSCA PEDIDO POR NOME
	Pedido findByNome(String nome);
	
	// BUSCA PARA VÁRIOS NOMES PEDIDO
	@Query(value = "select u from Pedido u where u.nome like %?1%")
	List<Pedido> findByNomes(String nome);

}
