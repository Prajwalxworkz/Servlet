package com.xworkz.trainapp.repo;

import com.xworkz.trainapp.dto.AddEventDto;
import com.xworkz.trainapp.entity.AddEventEntity;

public interface AddEventRepo {
Boolean save(AddEventEntity entity);
}
