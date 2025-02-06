package com.xworkz.gfg.service;

import com.xworkz.gfg.dto.SaveProfileDto;

import java.util.List;

public interface SaveProfileService {
    Boolean validateAndSave(SaveProfileDto dto);
    List<SaveProfileDto> getAllProfiles();

    void deleteProfileById(Integer id);

    SaveProfileDto getProfileById(Integer id);

    void updateProfile(SaveProfileDto dto);
}

