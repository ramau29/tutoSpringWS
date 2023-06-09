package com.tutoSpringWS.service;

import org.springframework.stereotype.Service;

@Service
public class EmpleadoService implements IEmpleadoService{
    @Override
    public String holaMundo(String name) {
        return "Hola " + name + " co te va!!!! bien?";
    }
}
