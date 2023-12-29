/**
 * 
 */
package br.com.victor.dao;

import br.com.victor.domain.Carro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


/**
 * @author victor.vianna
 *
 */
public class CarroDAO implements ICarro {


	@Override
	public Carro cadastrar(Carro carro) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = emf.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(carro);
		entityManager.getTransaction().commit();

		entityManager.close();
		emf.close();

		return carro;
	}

	@Override
	public void excluir(Carro carro) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = emf.createEntityManager();

		entityManager.getTransaction().begin();
		carro = entityManager.merge(carro);
		entityManager.remove(carro);
		entityManager.getTransaction().commit();

		entityManager.close();
		emf.close();
	}

	@Override
	public List<Carro> buscarTodos() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = emf.createEntityManager();


		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Carro> query = builder.createQuery(Carro.class);
		Root<Carro> root = query.from(Carro.class);
		query.select(root);

		TypedQuery<Carro> tpQuery =
				entityManager.createQuery(query);
		List<Carro> list = tpQuery.getResultList();

		entityManager.close();
		emf.close();
		return list;
	}
}