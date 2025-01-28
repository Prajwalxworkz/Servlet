package com.xworkz.app.service;

import com.xworkz.app.dto.AccountDto;
import com.xworkz.app.entity.AccountEntity;
import com.xworkz.app.repo.AccountRepo;
import com.xworkz.app.repo.AccountRepoImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class AccountServiceImpl implements AccountService{
    AccountRepo repo= new AccountRepoImpl();

    @Override
    public Boolean validateAndSave(AccountDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator=validatorFactory.getValidator();
        Set<ConstraintViolation<AccountDto>> validate=validator.validate(dto);
        if(!validate.isEmpty()){
            validate.forEach(error-> System.out.println(error.getMessage()));
        }else{
            try{
                AccountEntity entity=new AccountEntity();
                BeanUtils.copyProperties(entity,dto);
                return repo.save(entity);

            }catch(IllegalAccessException | InvocationTargetException e){
                System.out.println(e.getMessage());
            }
        }
        return false;
    }
}
