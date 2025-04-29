package com.Night.ws.utilidades;

import java.util.ArrayList;
import java.util.List;
import com.Night.ws.vo.EmpleadosVo;

public class EmpleadosUtilidades {

    public static List<EmpleadosVo> listaEmpleados = new ArrayList<>();

    public static void iniciarLista() {
        if (listaEmpleados.isEmpty()) {
            listaEmpleados.add(new EmpleadosVo("001", "Carlos Martínez", "carlos.martinez@example.com", "3001234567"));
            listaEmpleados.add(new EmpleadosVo("002", "Ana López", "ana.lopez@example.com", "3007654321"));
        }
    }
}
