package com.xworkz.vehicleregistration.repo;

import com.xworkz.vehicleregistration.entity.AddProfileEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AddProfileRepoImpl implements AddProfileRepo {
    @Override
    public Boolean save(AddProfileEntity entity) {

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

