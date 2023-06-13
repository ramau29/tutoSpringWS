package com.tutoSpringWS.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMPLEADO")
public class EmpleadoEntity {
    @Id
    @Column(name="CODIGO")
    private int codigo;

    @Column(name="NOMBRE")
    private String nombre;

    @Column(name="SALARIO")
    private long salario;


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getSalario() {
        return salario;
    }

    public void setSalario(long salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "EmpleadoEntity{" +
                "codigo=" + codigo +
                ", nombre=" + nombre +
                ", salario=" + salario +
                '}';
    }
}
