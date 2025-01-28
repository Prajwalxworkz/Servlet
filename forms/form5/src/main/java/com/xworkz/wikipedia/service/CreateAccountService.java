package com.xworkz.wikipedia.service;

import com.xworkz.wikipedia.dto.CreateAccountDto;

public interface CreateAccountService {
    Boolean validateAndSave(CreateAccountDto dto);

}
