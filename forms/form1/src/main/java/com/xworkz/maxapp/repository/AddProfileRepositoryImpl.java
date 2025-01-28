package com.xworkz.maxapp.repository;

import com.xworkz.maxapp.dto.AddProfileDto;
import com.xworkz.maxapp.entity.AddProfileEntity;

import javax.persistence.*;

public class AddProfileRepositoryImpl implements AddProfileRepository{

    @Override
    public Boolean save(AddProfileEntity entity) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("loginPage");
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
            emf.close();
        }

        return false;
    }
}
