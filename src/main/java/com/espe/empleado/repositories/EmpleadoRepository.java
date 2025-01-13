package com.espe.empleado.repositories;
import com.espe.empleado.models.Empleado;
import org.springframework.data.repository.CrudRepository;

public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {
}