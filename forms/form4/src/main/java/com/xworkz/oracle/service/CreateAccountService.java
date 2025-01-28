package com.xworkz.oracle.service;

import com.xworkz.oracle.dto.CreateAccountDto;

public interface CreateAccountService {
    Boolean validateAndSave(CreateAccountDto dto);

}
