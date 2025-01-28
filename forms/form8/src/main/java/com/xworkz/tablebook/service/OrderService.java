package com.xworkz.tablebook.service;

import com.xworkz.tablebook.dto.OrderDto;

public interface OrderService {
    Boolean validateAndSave(OrderDto dto);
}
