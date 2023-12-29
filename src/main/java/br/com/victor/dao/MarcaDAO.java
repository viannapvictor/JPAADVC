package br.com.victor.dao;

import br.com.victor.domain.Marca;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MarcaDAO implements IMarcaDAO {
    @Override
    public Marca cadastrar(Marca marca) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(marca);
        entityManager.getTransaction().commit();

        entityManager.close();
        emf.close();

        return marca;
    }
}
