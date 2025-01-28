package com.xworkz.w3school.repository;

import com.xworkz.w3school.dto.SignUpDto;
import com.xworkz.w3school.entity.SignUpEntity;

public interface SignUpRepo {
    Boolean save(SignUpEntity entity);

}
