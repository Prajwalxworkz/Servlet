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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

    @Override
    public List<SaveProfileDto> getAllProfiles() {
        List<SaveProfileDto> dtoList=new ArrayList<>();
        List<SaveProfileEntity> entityList=repository.getAllProfiles();
        try {
            for (SaveProfileEntity entity : entityList) {
                SaveProfileDto dto = new SaveProfileDto();
                BeanUtils.copyProperties(dto, entity);
                dtoList.add(dto);
            }
            return dtoList;
        }catch (IllegalAccessException | InvocationTargetException e){
            System.out.println(e.getMessage());
        }
        return Collections.emptyList();
    }

    @Override
    public void deleteProfileById(Integer id) {
        repository.deleteProfileById(id);
    }

    @Override
    public SaveProfileDto getProfileById(Integer id) {
        if(id>0){
            try{
            SaveProfileEntity entity=repository.getProfileById(id);
            SaveProfileDto dto=new SaveProfileDto();
            BeanUtils.copyProperties(dto,entity);
            return dto;
            }catch(IllegalAccessException | InvocationTargetException e){
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    @Override
    public void updateProfile(SaveProfileDto dto) {
        try{
            SaveProfileEntity entity=new SaveProfileEntity();
            BeanUtils.copyProperties(entity,dto);
            repository.updateProfile(entity);
        }catch(IllegalAccessException | InvocationTargetException e){
            System.out.println(e.getMessage());
        }
    }
}
