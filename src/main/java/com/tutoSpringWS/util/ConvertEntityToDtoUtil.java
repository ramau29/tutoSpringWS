package com.tutoSpringWS.util;

import com.tutoSpringWS.dto.EmpleadoDTO;
import com.tutoSpringWS.entity.EmpleadoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ConvertEntityToDtoUtil")
public class ConvertEntityToDtoUtil {

    @Autowired
    private ModelMapper modelMapper;

    public EmpleadoDTO convertToDtoEmpleado(EmpleadoEntity entity){
        if(entity != null){
            return modelMapper.map(entity, EmpleadoDTO.class);
        }
        return null;
    }
}
