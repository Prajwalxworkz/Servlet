package com.xworkz.maxapp.service;

import com.xworkz.maxapp.dto.AddProfileDto;

public interface AddProfileService {
    Boolean validateAndSave(AddProfileDto dto);
}
