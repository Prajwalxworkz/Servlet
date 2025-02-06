package com.xworkz.w3school.repository;

import com.xworkz.w3school.dto.SignUpDto;
import com.xworkz.w3school.entity.SignUpEntity;

import java.util.List;

public interface SignUpRepo {
    Boolean save(SignUpEntity entity);

    List<SignUpEntity> getAllProfiles();

    void deleteProfileById(Integer id);

    SignUpEntity getProfileById(Integer id);

    void updateProfile(SignUpEntity entity);
}
