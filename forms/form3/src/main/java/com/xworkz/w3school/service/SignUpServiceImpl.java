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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

    @Override
    public List<SignUpDto> getAllProfiles() {
        List<SignUpEntity> entityList=repo.getAllProfiles();
        List<SignUpDto> dtoList=new ArrayList<>();
        try {
            for (SignUpEntity entity : entityList) {
                SignUpDto dto = new SignUpDto();
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
        repo.deleteProfileById(id);
    }

    @Override
    public SignUpDto getProfileById(Integer id) {
        SignUpEntity entity=repo.getProfileById(id);
        try{
            SignUpDto dto=new SignUpDto();
            BeanUtils.copyProperties(dto,entity);
            return dto;
        }catch(IllegalAccessException | InvocationTargetException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateProfile(SignUpDto dto) {
        SignUpEntity entity=new SignUpEntity();
        try{
            BeanUtils.copyProperties(entity, dto);
        }catch (IllegalAccessException | InvocationTargetException e){
            System.out.println(e.getMessage());
        }
        repo.updateProfile(entity);
    }
}
