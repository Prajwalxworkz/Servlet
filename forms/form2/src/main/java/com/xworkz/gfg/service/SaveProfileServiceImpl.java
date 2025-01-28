package com.xworkz.gfg.service;

import com.xworkz.gfg.dto.SaveProfileDto;
import com.xworkz.gfg.entity.SaveProfileEntity;
import com.xworkz.gfg.repository.SaveProfileRepository;
import com.xworkz.gfg.repository.SaveProfileRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class SaveProfileServiceImpl implements SaveProfileService{
SaveProfileRepository repository=new SaveProfileRepositoryImpl();
    @Override
    public Boolean validateAndSave(SaveProfileDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator=validatorFactory.getValidator();
        Set<ConstraintViolation<SaveProfileDto>> validate=validator.validate(dto);
        if(!validate.isEmpty()){
            validate.forEach(error-> System.out.println(error.getMessage()));
        }else{
            try{
               SaveProfileEntity entity=new SaveProfileEntity();
                BeanUtils.copyProperties(entity,dto);
               return repository.save(entity);

            }catch(IllegalAccessException | InvocationTargetException e){
                System.out.println(e.getMessage());
            }
        }
        return null;
    }
}
