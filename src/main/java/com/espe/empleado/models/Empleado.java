package com.espe.empleado.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "empleados")
@Getter
@Setter
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "El cargo no puede estar vacío")
    @Size(max = 50, message = "El cargo no puede superar los 50 caracteres")
    @Column(nullable = false)
    private String cargo;

    @Min(value = 0, message = "El sueldo debe ser igual o mayor a 0")
    @Column(nullable = false)
    private int sueldo;

    @PastOrPresent(message = "La fecha de ingreso debe ser una fecha pasada o actual")
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_ingreso", nullable = false)
    private Date fechaIngreso;

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public int getSueldo() {
        return sueldo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
