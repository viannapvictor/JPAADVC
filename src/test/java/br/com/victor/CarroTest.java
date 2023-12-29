package br.com.victor;

import br.com.victor.dao.*;
import br.com.victor.domain.Acessorio;
import br.com.victor.domain.Carro;
import br.com.victor.domain.Marca;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author victor.vianna
 *
 */
public class CarroTest {

	private ICarro carroDAO;

	private IMarcaDAO marcaDAO;

	private IAcessorioDAO acessorioDAO;

	public CarroTest() {
		carroDAO = new CarroDAO();
		marcaDAO = new MarcaDAO();
		acessorioDAO = new AcessorioDAO();
	}

	private Marca criarMarca(String descricao) {
		Marca marca = new Marca();
		marca.setDescricao(descricao);
		return marcaDAO.cadastrar(marca);
	}

	private Acessorio criarAcessorio(String codigo, Carro carro) {
		Acessorio acessorio = new Acessorio();
		acessorio.setCodigo(codigo);
		acessorio.setNome("Som");
		acessorio.setCarro(carro);
		return acessorioDAO.cadastrar(acessorio);
	}


	@Test
	public void cadastrar() {
		Marca marca = criarMarca("Ford");
		Carro carro = new Carro();
		carro.setCodigo("A1");
		carro.setNome("Celta");
		carro.setMarca(marca);
		carro = carroDAO.cadastrar(carro);
		criarAcessorio("A1", carro);


		assertNotNull(carro);
		assertNotNull(carro.getId());
	}

}
