package com.xworkz.gfg.repository;

import com.xworkz.gfg.entity.SaveProfileEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import java.util.Collections;
import java.util.List;

public class SaveProfileRepositoryImpl implements SaveProfileRepository {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("save");
    @Override
    public Boolean save(SaveProfileEntity entity) {
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
        }
    }

    @Override
    public List<SaveProfileEntity> getAllProfiles() {
        EntityManager em=emf.createEntityManager();
        try {
            return (List<SaveProfileEntity>) em.createNamedQuery("getAllProfiles").getResultList();
        }catch (NoResultException e){
            System.out.println(e.getMessage());
        }finally {
            em.close();
        }
        return Collections.emptyList();
    }

    @Override
    public void deleteProfileById(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNamedQuery("deleteProfileById").setParameter("id",id).executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public SaveProfileEntity getProfileById(Integer id) {
        EntityManager em=emf.createEntityManager();
        try {
            return (SaveProfileEntity) em.createNamedQuery("getProfileById").setParameter("id", id).getSingleResult();
        }catch (NoResultException e){
            System.out.println(e.getMessage());
        }finally {
            em.close();
        }
        return null;
    }

    @Override
    public void updateProfile(SaveProfileEntity entity) {
        EntityManager em=emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
        }finally {
            em.close();
        }
    }
}
