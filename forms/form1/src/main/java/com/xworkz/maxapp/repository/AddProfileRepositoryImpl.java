package com.xworkz.maxapp.repository;

import com.xworkz.maxapp.dto.AddProfileDto;
import com.xworkz.maxapp.entity.AddProfileEntity;
import org.apache.commons.beanutils.BeanUtils;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class AddProfileRepositoryImpl implements AddProfileRepository{

     EntityManagerFactory emf=Persistence.createEntityManagerFactory("loginPage");

    @Override
    public Boolean save(AddProfileEntity entity) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return  true;
        }catch(Exception e){
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
        finally {
            em.close();
        }

        return false;
    }

    @Override
    public List<AddProfileEntity> getAllProfiles() {
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            Query getAllProfiles = em.createNamedQuery("getAllProfiles");
            List<AddProfileEntity>  entity= getAllProfiles.getResultList();
            return entity;
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
       int numberOfRowsAffected=em.createNamedQuery("deleteProfileById").setParameter("id",id).executeUpdate();
        System.out.println("Number of rows affected "+numberOfRowsAffected);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public AddProfileEntity getProfileById(Integer id) {
        EntityManager em = emf.createEntityManager();
        return (AddProfileEntity) em.createNamedQuery("getProfileById").setParameter("id",id).getSingleResult();
    }

    @Override
    public void updateProfileById(AddProfileEntity entity) {
        EntityManager em = emf.createEntityManager();
               try{
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

