package com.xworkz.w3school.service;

import com.xworkz.w3school.dto.SignUpDto;

import java.util.List;

public interface SignUpService {
    Boolean validateAndSave(SignUpDto dto);

    List<SignUpDto> getAllProfiles();

    void deleteProfileById(Integer id);

    SignUpDto getProfileById(Integer id);

    void updateProfile(SignUpDto dto);
}
