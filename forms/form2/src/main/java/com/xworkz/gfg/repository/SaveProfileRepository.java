package com.xworkz.gfg.repository;

import com.xworkz.gfg.entity.SaveProfileEntity;

import java.util.List;

public interface SaveProfileRepository {
    Boolean save(SaveProfileEntity entity);

    List<SaveProfileEntity> getAllProfiles();

    void deleteProfileById(Integer id);

    SaveProfileEntity getProfileById(Integer id);

    void updateProfile(SaveProfileEntity entity);
}

