package com.Night.ws.dao;

import java.util.List;
import java.util.Iterator;

import org.springframework.stereotype.Service;
import com.Night.ws.utilidades.EmpleadosUtilidades;
import com.Night.ws.vo.EmpleadosVo;

@Service
public class EmpleadosDao {

    public EmpleadosDao() {
        EmpleadosUtilidades.iniciarLista();
    }

    public EmpleadosVo consultarEmpleadoPorCedula(String cedula) {
        for (EmpleadosVo e : EmpleadosUtilidades.listaEmpleados) {
            if (e.getCedula().equals(cedula)) {
                return e;
            }
        }
        return null;
    }

    public List<EmpleadosVo> obtenerListaEmpleados() {
        return EmpleadosUtilidades.listaEmpleados;
    }

    public EmpleadosVo registrarEmpleado(EmpleadosVo empleadoVo) {
        for (EmpleadosVo e : EmpleadosUtilidades.listaEmpleados) {
            if (e.getCedula().equals(empleadoVo.getCedula())) {
                return null;
            }
        }
        EmpleadosUtilidades.listaEmpleados.add(empleadoVo);
        return empleadoVo;
    }

    public EmpleadosVo actualizarEmpleado(EmpleadosVo empleado) {
        for (EmpleadosVo e : EmpleadosUtilidades.listaEmpleados) {
            if (e.getCedula().equals(empleado.getCedula())) {
                e.setNombre(empleado.getNombre());
                e.setCorreo(empleado.getCorreo());
                e.setTelefono(empleado.getTelefono());
                return e;
            }
        }
        return null;
    }

    public boolean eliminarEmpleado(String cedula) {
        Iterator<EmpleadosVo> iterator = EmpleadosUtilidades.listaEmpleados.iterator();
        while (iterator.hasNext()) {
            EmpleadosVo e = iterator.next();
            if (e.getCedula().equals(cedula)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}

