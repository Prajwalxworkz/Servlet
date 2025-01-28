package com.xworkz.gfg.repository;

import com.xworkz.gfg.entity.SaveProfileEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SaveProfileRepositoryImpl implements SaveProfileRepository {
    @Override
    public Boolean save(SaveProfileEntity entity) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("save");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
            return false;
        } finally {
            em.close();
            emf.close();
        }
    }
}
