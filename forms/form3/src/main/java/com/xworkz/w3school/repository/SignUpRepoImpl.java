package com.xworkz.w3school.repository;

import com.xworkz.w3school.entity.SignUpEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SignUpRepoImpl implements SignUpRepo{

    @Override
    public Boolean save(SignUpEntity entity) {
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

