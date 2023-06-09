package com.tutoSpringWS.controller;

import jakarta.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tutoSpringWS.service.IEmpleadoService;

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


}
