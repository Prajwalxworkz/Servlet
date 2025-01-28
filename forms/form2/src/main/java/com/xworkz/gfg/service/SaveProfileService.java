package com.xworkz.gfg.service;

import com.xworkz.gfg.dto.SaveProfileDto;

public interface SaveProfileService {
    Boolean validateAndSave(SaveProfileDto dto);
}
