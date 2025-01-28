package com.xworkz.maxapp.service;

import com.xworkz.maxapp.dto.AddProfileDto;
import com.xworkz.maxapp.entity.AddProfileEntity;
import com.xworkz.maxapp.repository.AddProfileRepository;
import com.xworkz.maxapp.repository.AddProfileRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class AddProfileServiceImpl implements AddProfileService {
    AddProfileRepository repository=new AddProfileRepositoryImpl();
    @Override
    public Boolean validateAndSave(AddProfileDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<AddProfileDto>> validate = validator.validate(dto);
        if (!validate.isEmpty()) {
            validate.forEach(error -> System.out.println(error.getMessage()));
        }else{
            AddProfileEntity entity=new AddProfileEntity();
            try{
                BeanUtils.copyProperties(entity,dto);
                Boolean isAdded=repository.save(entity);
                return isAdded;
            }catch (IllegalAccessException | InvocationTargetException e){
                System.out.println(e.getMessage());
            }
        }
        return null;
    }
}
