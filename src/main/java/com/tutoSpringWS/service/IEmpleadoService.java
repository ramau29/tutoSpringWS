package com.tutoSpringWS.service;

import com.tutoSpringWS.dto.EmpleadoDTO;

import java.util.List;

public interface IEmpleadoService {

    String holaMundo(String name);

    String guardarEmpleado(EmpleadoDTO empleado);

    List<EmpleadoDTO> listarEmpleados(int codigo);
}
