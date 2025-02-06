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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AddProfileServiceImpl implements AddProfileService {
    AddProfileRepository repository = new AddProfileRepositoryImpl();

    @Override
    public Boolean validateAndSave(AddProfileDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<AddProfileDto>> validate = validator.validate(dto);
        if (!validate.isEmpty()) {
            validate.forEach(error -> System.out.println(error.getMessage()));
        } else {
            AddProfileEntity entity = new AddProfileEntity();
            try {
                BeanUtils.copyProperties(entity, dto);
                Boolean isAdded = repository.save(entity);
                return isAdded;
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    @Override
    public List<AddProfileDto> getAllProfiles() {
        List<AddProfileEntity> entity = repository.getAllProfiles();
        List<AddProfileDto> dtoList = new ArrayList<>();
        for (AddProfileEntity entity1 : entity) {
            try {
                AddProfileDto dto = new AddProfileDto();
                BeanUtils.copyProperties(dto, entity1);
                dtoList.add(dto);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
        }
        return dtoList;


//        List<AddProfileDto> dtoList= new ArrayList<>();
//        try {
//            AddProfileDto dto=new AddProfileDto();
//            BeanUtils.copyProperties(dtoList, entity);
//            return dtoList;
//        } catch (IllegalAccessException | InvocationTargetException e) {
//            System.out.println(e.getMessage());
//        }
//        return null;
//        AddProfileDto dto=new AddProfileDto();
//        for(AddProfileEntity entity1:entity){
//            dto.setFullName(entity1.getFullName());
//            dto.setEmail(entity1.getEmail());
//            dto.setAddress(entity1.getAddress());
//            dto.setMobile(entity1.getMobile());
//            dtoList.add(dto);
//        }
//        return dtoList;
//        return entity;

    }

    @Override
    public void deleteProfileById(Integer id) {
        repository.deleteProfileById(id);
    }

    @Override
    public AddProfileDto getProfileById(Integer id) {
        if (id > 0) {
            AddProfileDto dto = new AddProfileDto();
            AddProfileEntity entity = repository.getProfileById(id);
            try {
                BeanUtils.copyProperties(dto, entity);
                return dto;
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    @Override
    public void updateProfileById(AddProfileDto dto) {
        AddProfileEntity entity = new AddProfileEntity();
        try {
            BeanUtils.copyProperties(entity, dto);
            repository.updateProfileById(entity);

        } catch (IllegalAccessException | InvocationTargetException e) {
            System.out.println(e.getMessage());
        }

//    return null;
    }
}
