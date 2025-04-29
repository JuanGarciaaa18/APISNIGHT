package com.Night.ws.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Night.ws.dao.EmpleadosDao;
import com.Night.ws.vo.EmpleadosVo;

@RestController
@RequestMapping("/servicio/empleados")
public class EmpleadosService {

    @Autowired
    private EmpleadosDao empleadosDao;

    @GetMapping("/empleados")
    public ResponseEntity<EmpleadosVo> getEmpleado(@RequestParam(value = "id") String cedula) {
        EmpleadosVo empleado = empleadosDao.consultarEmpleadoPorCedula(cedula);

        if (empleado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(empleado);
    }

    @GetMapping("/empleados-list")
    public ResponseEntity<List<EmpleadosVo>> getListaEmpleados() {
        List<EmpleadosVo> empleados = empleadosDao.obtenerListaEmpleados();
        return ResponseEntity.ok(empleados);
    }

    @PostMapping("/guardar/empleados")
    public ResponseEntity<EmpleadosVo> registrarEmpleado(@RequestBody EmpleadosVo empleado) {
        EmpleadosVo nuevo = empleadosDao.registrarEmpleado(empleado);
        return nuevo != null ? ResponseEntity.ok(nuevo) : ResponseEntity.badRequest().build();
    }

    @PutMapping("/actualizar/empleados")
    public ResponseEntity<EmpleadosVo> actualizarEmpleado(@RequestBody EmpleadosVo empleado) {
        EmpleadosVo actualizado = empleadosDao.actualizarEmpleado(empleado);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable String id) {
        boolean eliminado = empleadosDao.eliminarEmpleado(id);
        return eliminado ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
