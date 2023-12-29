package br.com.victor.dao;

import br.com.victor.domain.Acessorio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AcessorioDAO implements IAcessorioDAO{
    @Override
    public Acessorio cadastrar(Acessorio acessorio) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(acessorio);
        entityManager.getTransaction().commit();

        entityManager.close();
        emf.close();

        return acessorio;
    }
}
