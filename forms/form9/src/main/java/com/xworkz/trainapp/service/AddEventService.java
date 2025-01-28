package com.xworkz.trainapp.service;

import com.xworkz.trainapp.dto.AddEventDto;

public interface AddEventService {
    Boolean validateAndSave(AddEventDto dto);
}
