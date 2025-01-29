package com.xworkz.maxapp.repository;

import com.xworkz.maxapp.dto.AddProfileDto;
import com.xworkz.maxapp.entity.AddProfileEntity;

import java.util.List;

public interface AddProfileRepository {
    Boolean save(AddProfileEntity entity);

    List<AddProfileEntity> getAllProfiles();
}
