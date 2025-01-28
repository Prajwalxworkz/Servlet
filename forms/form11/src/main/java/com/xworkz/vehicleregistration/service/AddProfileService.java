package com.xworkz.vehicleregistration.service;

import com.xworkz.vehicleregistration.dto.AddProfileDto;

public interface AddProfileService {
    Boolean validateAndSave(AddProfileDto dto);
}
