package com.tutoSpringWS.service;

import com.tutoSpringWS.dto.EmpleadoDTO;
import com.tutoSpringWS.entity.EmpleadoEntity;
import com.tutoSpringWS.repository.IEmpleadoRepo;
import com.tutoSpringWS.util.ConvertEntityToDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpleadoService implements IEmpleadoService{

    @Autowired
    private IEmpleadoRepo repo;

    @Autowired
    ConvertEntityToDtoUtil mapper;

    @Override
    public String holaMundo(String name) {
        return "Hola " + name + " co te va!!!! bien?";
    }

    @Override
    public String guardarEmpleado(EmpleadoDTO dto) { //TODO hacer un builder o ver que tal un mapper dto-entity
        EmpleadoEntity entity = new EmpleadoEntity();
        entity.setCodigo(dto.getCodigo());
        entity.setNombre(dto.getNombre());
        entity.setSalario(dto.getSalario());
        repo.save(entity);
        return null;
    }

    @Override
    public List<EmpleadoDTO> listarEmpleados(int codigo) {
        List<EmpleadoDTO> dtos = null;
//        List<EmpleadoEntity> entities = repo.findAll();
        List<EmpleadoEntity> entities = repo.listarEmpleados(codigo);
        dtos = entities.stream().map(entity -> mapper.convertToDtoEmpleado(entity)).collect(Collectors.toList());
        return  dtos;
    }
}
