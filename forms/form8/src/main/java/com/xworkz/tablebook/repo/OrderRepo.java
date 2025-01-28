package com.xworkz.tablebook.repo;

import com.xworkz.tablebook.dto.OrderDto;
import com.xworkz.tablebook.entity.OrderEntity;

public interface OrderRepo {
    Boolean save(OrderEntity entity);
}
