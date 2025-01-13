package com.espe.empleado.controllers;

import com.espe.empleado.models.Empleado;
import com.espe.empleado.services.EmpleadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Empleado empleado) {
        return ResponseEntity.status(HttpStatus.CREATED).body(empleadoService.save(empleado));
    }

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(empleadoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<Empleado> empleadoOptional = empleadoService.findById(id);
        if (empleadoOptional.isPresent()) {
            return ResponseEntity.ok(empleadoOptional.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empleado no encontrado");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody Empleado empleado, @PathVariable Long id) {
        Optional<Empleado> empleadoOptional = empleadoService.findById(id);
        if (empleadoOptional.isPresent()) {
            Empleado empleadoDB = empleadoOptional.get();
            empleadoDB.setNombre(empleado.getNombre());
            empleadoDB.setCargo(empleado.getCargo());
            empleadoDB.setSueldo(empleado.getSueldo());
            empleadoDB.setFechaIngreso(empleado.getFechaIngreso());
            return ResponseEntity.status(HttpStatus.CREATED).body(empleadoService.save(empleadoDB));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empleado no encontrado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Empleado> empleadoOptional = empleadoService.findById(id);
        if (empleadoOptional.isPresent()) {
            empleadoService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empleado no encontrado");
    }
}
