package com.xworkz.wikipedia.service;

import com.xworkz.wikipedia.dto.CreateAccountDto;
import com.xworkz.wikipedia.entity.CreateAccountEntity;
import com.xworkz.wikipedia.repo.CreateAccountRepo;
import com.xworkz.wikipedia.repo.CreateAccountRepoImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class CreateAccountServiceImpl implements CreateAccountService{
    CreateAccountRepo repo=new CreateAccountRepoImpl();
    @Override
    public Boolean validateAndSave(CreateAccountDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator=validatorFactory.getValidator();
        Set<ConstraintViolation<CreateAccountDto>> validate=validator.validate(dto);
        if(!validate.isEmpty()){
            validate.forEach(error-> System.out.println(error.getMessage()));
        }else{
            try{
                CreateAccountEntity entity=new CreateAccountEntity();
                BeanUtils.copyProperties(entity,dto);
                return repo.save(entity);

            }catch(IllegalAccessException | InvocationTargetException e){
                System.out.println(e.getMessage());
            }
        }
        return null;
    }
}
