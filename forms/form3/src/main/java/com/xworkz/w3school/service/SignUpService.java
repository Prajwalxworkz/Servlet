package com.xworkz.w3school.service;

import com.xworkz.w3school.dto.SignUpDto;

public interface SignUpService {
    Boolean validateAndSave(SignUpDto dto);
}
