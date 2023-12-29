/**
 * 
 */
package br.com.victor.dao;

import br.com.victor.domain.Carro;

import java.util.List;

/**
 * @author victor.vianna
 *
 */
public interface ICarro {

	public Carro cadastrar(Carro carro);

	public void excluir(Carro carro);

	public List<Carro> buscarTodos();
}
