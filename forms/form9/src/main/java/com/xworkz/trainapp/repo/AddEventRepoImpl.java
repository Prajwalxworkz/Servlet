package com.xworkz.trainapp.repo;

import com.xworkz.trainapp.dto.AddEventDto;
import com.xworkz.trainapp.entity.AddEventEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AddEventRepoImpl implements AddEventRepo{
    @Override
    public Boolean save(AddEventEntity entity) {
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
