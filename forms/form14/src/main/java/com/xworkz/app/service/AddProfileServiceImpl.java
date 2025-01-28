package com.xworkz.app.service;

import com.xworkz.app.dto.AddProfileDto;
import com.xworkz.app.entity.AddProfileEntity;
import com.xworkz.app.repo.AddProfileRepo;
import com.xworkz.app.repo.AddProfileRepoImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class AddProfileServiceImpl implements AddProfileService{
    AddProfileRepo repo= new AddProfileRepoImpl();

    @Override
    public Boolean validateAndSave(AddProfileDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator=validatorFactory.getValidator();
        Set<ConstraintViolation<AddProfileDto>> validate=validator.validate(dto);
        if(!validate.isEmpty()){
            validate.forEach(error-> System.out.println(error.getMessage()));
        }else{
            try{
                AddProfileEntity entity=new AddProfileEntity();
                BeanUtils.copyProperties(entity,dto);
                return repo.save(entity);

            }catch(IllegalAccessException | InvocationTargetException e){
                System.out.println(e.getMessage());
            }
        }
        return null;
    }
}

