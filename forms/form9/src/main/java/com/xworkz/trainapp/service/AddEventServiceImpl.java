package com.xworkz.trainapp.service;

import com.xworkz.trainapp.dto.AddEventDto;
import com.xworkz.trainapp.entity.AddEventEntity;
import com.xworkz.trainapp.repo.AddEventRepo;
import com.xworkz.trainapp.repo.AddEventRepoImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class AddEventServiceImpl implements AddEventService{
    AddEventRepo repo= new AddEventRepoImpl();

    @Override
    public Boolean validateAndSave(AddEventDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator=validatorFactory.getValidator();
        Set<ConstraintViolation<AddEventDto>> validate=validator.validate(dto);
        if(!validate.isEmpty()){
            validate.forEach(error-> System.out.println(error.getMessage()));
        }else{
            try{
                AddEventEntity entity=new AddEventEntity();
                BeanUtils.copyProperties(entity,dto);
                return repo.save(entity);

            }catch(IllegalAccessException | InvocationTargetException e){
                System.out.println(e.getMessage());
            }
        }
        return null;
    }
}
