package com.xworkz.passport.service;

import com.xworkz.passport.dto.AddProfileDto;

public interface AddProfileService {
    Boolean validateAndSave(AddProfileDto dto);
}
