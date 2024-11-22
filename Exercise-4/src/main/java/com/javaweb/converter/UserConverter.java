package com.javaweb.converter;

import com.javaweb.model.dto.UserDTO;
import com.javaweb.entity.UserEntity;
import org.jboss.jandex.Main;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    private static final Logger log = LoggerFactory.getLogger(UserConverter.class);
    @Autowired
    private ModelMapper modelMapper;

    public UserDTO convertToDto(UserEntity entity) {
        UserDTO result = modelMapper.map(entity, UserDTO.class);
        return result;
    }


    public UserEntity convertToEntity(UserDTO dto) {
        UserEntity result = modelMapper.map(dto, UserEntity.class);
        return result;


    }


}
