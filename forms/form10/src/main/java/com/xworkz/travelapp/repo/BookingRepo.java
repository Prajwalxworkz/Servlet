package com.xworkz.travelapp.repo;

import com.xworkz.travelapp.entity.BookingEntity;

public interface BookingRepo {
    Boolean save(BookingEntity entity);
}
