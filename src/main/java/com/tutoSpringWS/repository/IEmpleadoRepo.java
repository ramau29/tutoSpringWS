package com.tutoSpringWS.repository;

import com.tutoSpringWS.entity.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpleadoRepo extends JpaRepository<EmpleadoEntity, Integer> {
}
