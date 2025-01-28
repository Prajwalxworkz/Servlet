package com.xworkz.app.service;

import com.xworkz.app.dto.AddProfileDto;

public interface AddProfileService {
    Boolean validateAndSave(AddProfileDto dto);
}
