package com.tutoSpringWS.controller;

import com.tutoSpringWS.dto.EmpleadoDTO;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tutoSpringWS.service.IEmpleadoService;

import java.util.List;

@Produces("application/json")
@RestController
@RequestMapping("/proyecto")
public class EmpleadoController {

    @Autowired
    IEmpleadoService service;

    @GetMapping(path = "/saludo/{name}")
    public String holaMundo(@PathVariable("name") String name) {
        return service.holaMundo(name);
    }

    @PostMapping(path="/guardar/empleado", consumes = MediaType.APPLICATION_JSON)
    public String guardarEmpleado(@RequestBody EmpleadoDTO empleadoDTO){ // TODO unificar nombres rest, quitar el /guardar
        String resp = null;
        try {
            resp = service.guardarEmpleado(empleadoDTO);
        }
        catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
        return  resp;
    }

    @GetMapping(path="/listar")
    public List<EmpleadoDTO> listarEmpleados(){
        List<EmpleadoDTO> resp = null;
        try {
            resp = service.listarEmpleados();
        }
        catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
        return  resp;
    }


}
