package com.xworkz.maxapp.service;

import com.xworkz.maxapp.dto.AddProfileDto;
import com.xworkz.maxapp.entity.AddProfileEntity;

import java.util.List;

public interface AddProfileService {
    Boolean validateAndSave(AddProfileDto dto);

    List<AddProfileDto> getAllProfiles();

    void deleteProfileById(Integer id);

    AddProfileDto getProfileById(Integer id);

    void updateProfileById(AddProfileDto dto);
}
