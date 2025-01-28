package com.xworkz.w3school.service;

import com.oracle.net.Sdp;
import com.xworkz.w3school.dto.SignUpDto;
import com.xworkz.w3school.entity.SignUpEntity;
import com.xworkz.w3school.repository.SignUpRepo;
import com.xworkz.w3school.repository.SignUpRepoImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class SignUpServiceImpl implements  SignUpService{
    SignUpRepo repo=new SignUpRepoImpl();
    @Override
    public Boolean validateAndSave(SignUpDto dto){
    ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    Validator validator=validatorFactory.getValidator();
    Set<ConstraintViolation<SignUpDto>> validate=validator.validate(dto);
        if(!validate.isEmpty()){
        validate.forEach(error-> System.out.println(error.getMessage()));
    }else{
        try{
            SignUpEntity entity=new SignUpEntity();
            BeanUtils.copyProperties(entity,dto);
            return repo.save(entity);

        }catch(IllegalAccessException | InvocationTargetException e){
            System.out.println(e.getMessage());
        }
    }
        return null;
}
}
