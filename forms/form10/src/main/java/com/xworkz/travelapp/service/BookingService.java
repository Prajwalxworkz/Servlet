package com.xworkz.travelapp.service;

import com.xworkz.travelapp.dto.BookingDto;

public interface BookingService {
    Boolean validateAndSave(BookingDto dto);
}
