package com.xworkz.maxapp.repository;

import com.xworkz.maxapp.dto.AddProfileDto;
import com.xworkz.maxapp.entity.AddProfileEntity;

public interface AddProfileRepository {
    Boolean save(AddProfileEntity entity);
}
