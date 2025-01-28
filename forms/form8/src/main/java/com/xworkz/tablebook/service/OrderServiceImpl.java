package com.xworkz.tablebook.service;

import com.xworkz.tablebook.dto.OrderDto;
import com.xworkz.tablebook.entity.OrderEntity;
import com.xworkz.tablebook.repo.OrderRepo;
import com.xworkz.tablebook.repo.OrderRepoImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class OrderServiceImpl implements OrderService{
    OrderRepo repo= new OrderRepoImpl();

    @Override
    public Boolean validateAndSave(OrderDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator=validatorFactory.getValidator();
        Set<ConstraintViolation<OrderDto>> validate=validator.validate(dto);
        if(!validate.isEmpty()){
            validate.forEach(error-> System.out.println(error.getMessage()));
        }else{
            try{
                OrderEntity entity=new OrderEntity();
                BeanUtils.copyProperties(entity,dto);
                return repo.save(entity);

            }catch(IllegalAccessException | InvocationTargetException e){
                System.out.println(e.getMessage());
            }
        }
        return null;
    }
}
