package com.tutoSpringWS.repository;

import com.tutoSpringWS.entity.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEmpleadoRepo extends JpaRepository<EmpleadoEntity, Integer> {

    @Query("select e from EmpleadoEntity e where codigo > :codigo")
    List<EmpleadoEntity> listarEmpleados(int codigo);
}
