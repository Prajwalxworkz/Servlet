package com.xworkz.travelapp.repo;

import com.xworkz.travelapp.entity.BookingEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BookingRepoImpl implements BookingRepo{
    @Override
    public Boolean save(BookingEntity entity) {
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
