package com.Night.ws.utilidades;

import java.util.ArrayList;
import java.util.List;
import com.Night.ws.vo.ClientesVo;

public class ClientesUtilidades {

    public static List<ClientesVo> listaClientes = new ArrayList<>();

    public static void iniciarLista() {
        if (listaClientes.isEmpty()) {
            listaClientes.add(new ClientesVo("111", "Juan Pérez", "juan.perez@example.com", "3001234567"));
            listaClientes.add(new ClientesVo("222", "María Gómez", "maria.gomez@example.com", "3007654321"));
        }
    }
}