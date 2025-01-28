package com.xworkz.travelapp.service;

import com.xworkz.travelapp.dto.BookingDto;
import com.xworkz.travelapp.entity.BookingEntity;
import com.xworkz.travelapp.repo.BookingRepo;
import com.xworkz.travelapp.repo.BookingRepoImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class BookingServiceImpl implements BookingService{
    BookingRepo repo=new BookingRepoImpl();

    @Override
    public Boolean validateAndSave(BookingDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator=validatorFactory.getValidator();
        Set<ConstraintViolation<BookingDto>> validate=validator.validate(dto);
        if(!validate.isEmpty()){
            validate.forEach(error-> System.out.println(error.getMessage()));
        }else{
            try{
                BookingEntity entity=new BookingEntity();
                BeanUtils.copyProperties(entity,dto);
                return repo.save(entity);

            }catch(IllegalAccessException | InvocationTargetException e){
                System.out.println(e.getMessage());
            }
        }
        return null;
    }
}
