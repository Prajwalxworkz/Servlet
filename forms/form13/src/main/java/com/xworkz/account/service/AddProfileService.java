package com.xworkz.account.service;

import com.xworkz.account.dto.AddProfileDto;

public interface AddProfileService {
    Boolean validateAndSave(AddProfileDto dto);
}
