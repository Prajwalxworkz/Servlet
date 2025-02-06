package com.xworkz.w3school.repository;

import com.xworkz.w3school.entity.SignUpEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import java.util.Collections;
import java.util.List;

public class SignUpRepoImpl implements SignUpRepo {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("save");

    @Override
    public Boolean save(SignUpEntity entity) {
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

    @Override
    public List<SignUpEntity> getAllProfiles() {
        EntityManager em = emf.createEntityManager();
        try {
            return (List<SignUpEntity>) em.createNamedQuery("getAllProfiles").getResultList();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }
        return Collections.emptyList();
    }

    @Override
    public void deleteProfileById(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("deleteProfileById").setParameter("id", id).executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public SignUpEntity getProfileById(Integer id) {
        try {
            return (SignUpEntity) emf.createEntityManager().createNamedQuery("getProfileById").setParameter("id", id).getSingleResult();
        } catch (NoResultException e) {
            System.out.println(emf.getCache());
        } finally {
            emf.createEntityManager().close();
        }
        return null;
    }

    @Override
    public void updateProfile(SignUpEntity entity) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }
}

